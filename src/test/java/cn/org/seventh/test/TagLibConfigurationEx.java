package cn.org.seventh.test;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.mortbay.jetty.servlet.TagLibConfiguration;
import org.mortbay.jetty.servlet.WebApplicationContext;
import org.mortbay.log.LogFactory;
import org.mortbay.util.Resource;
import org.mortbay.xml.XmlParser;

public class TagLibConfigurationEx extends TagLibConfiguration {
	private static Log log = LogFactory.getLog(TagLibConfiguration.class);
	public static String TAGLIB_DIR = "CUSTOM_TAGLIB_DIR";
	WebApplicationContext _context;

	/* ------------------------------------------------------------ */
	/**
	 */
	public TagLibConfigurationEx() {
		super();
	}

	/* ------------------------------------------------------------ */
	/*
	 * @see org.mortbay.jetty.servlet.WebApplicationContext.Configuration#setWebApplicationContext(org.mortbay.jetty.servlet.WebApplicationContext)
	 */
	public void setWebApplicationContext(WebApplicationContext context) {
		this._context = context;
	}

	/* ------------------------------------------------------------ */
	/*
	 * @see org.mortbay.jetty.servlet.WebApplicationContext.Configuration#getWebApplicationContext()
	 */
	public WebApplicationContext getWebApplicationContext() {
		return _context;
	}

	/* ------------------------------------------------------------ */
	/*
	 * @see org.mortbay.jetty.servlet.WebApplicationContext.Configuration#configureClassPath()
	 */
	public void configureClassPath() throws Exception {
	}

	/* ------------------------------------------------------------ */
	/*
	 * @see org.mortbay.jetty.servlet.WebApplicationContext.Configuration#configureDefaults()
	 */
	public void configureDefaults() throws Exception {
	}

	/* ------------------------------------------------------------ */
	/*
	 * @see org.mortbay.jetty.servlet.WebApplicationContext.Configuration#configureWebApp()
	 */
	public void configureWebApp() throws Exception {
		Set tlds = new HashSet();

		// Find tld's from web.xml
		// When the XMLConfigurator (or other configurator) parsed the web.xml,
		// It should have created aliases for all TLDs. So search resources
		// aliases
		// for aliases ending in tld
		if (_context.getResourceAliases() != null) {
			Iterator iter = _context.getResourceAliases().values().iterator();
			while (iter.hasNext()) {
				String location = (String) iter.next();
				if (location != null && location.toLowerCase().endsWith(".tld")) {
					if (!location.startsWith("/"))
						location = "/WEB-INF/" + location;
					Resource l = _context.getBaseResource().addPath(location);
					tlds.add(l);
				}
				File dir = new File(location);
				if (dir.exists() && dir.isDirectory()) {
					File[] files = dir.listFiles(new FilenameFilter() {

						public boolean accept(File dir, String name) {
							// TODO Auto-generated method stub
							File tldfile = new File(dir, name);
							return tldfile.isFile()
									&& name.toLowerCase().endsWith(".tld");
						}

					});
					if (files.length > 0) {
						for (File f : files) {
							Resource resource = Resource.newResource(f
									.toString());
							tlds.add(resource);
						}
					}
				}
			}
		}

		// Look for any tlds in WEB-INF directly.
		if (_context.getWebInf() != null) {
			String[] contents = _context.getWebInf().list();
			for (int i = 0; i < contents.length; i++) {
				if (contents[i] != null
						&& contents[i].toLowerCase().endsWith(".tld")) {
					Resource l = _context.getWebInf().addPath(contents[i]);
					tlds.add(l);
				}

			}

			// Look for any tlds in the META-INF of included jars
			Resource lib = _context.getWebInf().addPath("lib/");
			if (lib.exists() && lib.isDirectory()) {
				contents = lib.list();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i] != null
							&& contents[i].toLowerCase().endsWith(".jar")) {
						Resource l = lib.addPath(contents[i]);
						Resource meta = Resource.newResource("jar:" + l
								+ "!/META-INF/");
						if (meta.exists()) {
							String[] meta_contents = meta.list();

							for (int j = 0; j < meta_contents.length; j++) {
								if (meta_contents[j] != null
										&& meta_contents[j].toLowerCase()
												.endsWith(".tld")) {
									Resource t = meta.addPath(meta_contents[j]);
									tlds.add(t);
								}
							}
						}
					}
				}
			}
		}
		// get parent classloader
		URLClassLoader classLoader = (URLClassLoader) getClass()
				.getClassLoader();
		URL[] contents = classLoader.getURLs();
		if (contents != null) {
			// Look for any tlds in the META-INF of included jars
			for (int i = 0; i < contents.length; i++) {
				if (contents[i] != null
						&& contents[i].toString().toLowerCase()
								.endsWith(".jar")) {
					Resource jar = Resource.newResource(contents[i]);
					Resource l = Resource.newResource("jar:" + jar + "!/");

					if (l.exists()) {
						String[] l_contents = l.list();

						for (int j = 0; j < l_contents.length; j++) {
							if (l_contents[j] != null
									&& l_contents[j].toLowerCase().endsWith(
											".tld")) {
								Resource t = l.addPath(l_contents[j]);
								tlds.add(t);
							}
						}
					}
					Resource meta = Resource.newResource("jar:" + jar
							+ "!/META-INF/");
					if (meta.exists()) {
						String[] meta_contents = meta.list();

						for (int j = 0; j < meta_contents.length; j++) {
							if (meta_contents[j] != null
									&& meta_contents[j].toLowerCase().endsWith(
											".tld")) {
								Resource t = meta.addPath(meta_contents[j]);
								tlds.add(t);
							}
						}
					}
				}
			}

		}

		// Create a TLD parser
		XmlParser parser = new XmlParser(false);

		parser
				.redirectEntity(
						"web-jsptaglibrary_1_1.dtd",
						WebApplicationContext.class
								.getResource("/javax/servlet/jsp/resources/web-jsptaglibrary_1_1.dtd"));
		parser
				.redirectEntity(
						"web-jsptaglibrary_1_2.dtd",
						WebApplicationContext.class
								.getResource("/javax/servlet/jsp/resources/web-jsptaglibrary_1_2.dtd"));
		parser
				.redirectEntity(
						"web-jsptaglibrary_2_0.xsd",
						WebApplicationContext.class
								.getResource("/javax/servlet/jsp/resources/web-jsptaglibrary_2_0.xsd"));
		parser.setXpath("/taglib/listener/listener-class");
		// Parse all the discovered TLDs
		Iterator iter = tlds.iterator();
		while (iter.hasNext()) {
			try {
				Resource tld = (Resource) iter.next();
				if (log.isDebugEnabled())
					log.debug("TLD=" + tld);

				XmlParser.Node root = parser.parse(tld.getURL());

				for (int i = 0; i < root.size(); i++) {
					Object o = root.get(i);
					if (o instanceof XmlParser.Node) {
						XmlParser.Node node = (XmlParser.Node) o;
						if ("listener".equals(node.getTag())) {
							String className = node.getString("listener-class",
									false, true);
							if (log.isDebugEnabled())
								log.debug("listener=" + className);

							try {
								Class listenerClass = getWebApplicationContext()
										.loadClass(className);
								EventListener l = (EventListener) listenerClass
										.newInstance();
								_context.addEventListener(l);
							} catch (Exception e) {
								log.warn("Could not instantiate listener "
										+ className, e);
							}
						}
					}
				}
			} catch (Exception e) {
				log.warn(e);
			}
		}
	}
}
