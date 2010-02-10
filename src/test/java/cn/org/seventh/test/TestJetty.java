package cn.org.seventh.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.WebApplicationContext;

public class TestJetty extends TestCase {

	private static Log log = LogFactory.getLog(TestJetty.class);

	public void testJetty() {
		TestJetty jetty = new TestJetty();
		jetty.start();
	}

	public static void main(String[] args) {
		TestJetty jetty = new TestJetty();
		jetty.start();
		jetty.exit();

	}

	public void exit() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out
						.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
				System.out
						.print("=                  type [exit] or [quit] to end          =\n");
				System.out
						.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
				System.out.flush();
				String line = in.readLine().toLowerCase();
				if (line.startsWith("quit") || line.startsWith("exit")) {
					break;
				}
			} catch (Exception e) {
			}
		}
		System.exit(0);
	}

	public void start() {
		URL reader = getClass().getResource("/");
		String taglibPath = reader.getPath()
				+ "../../target/generated/resources";
		String path = reader.getPath() + "../../src/main/webapp/";
		String temp = reader.getPath() + "../../target/generated/java/";
		Server jettyServer = null;
		try {
			URL jettyConfig = TestJetty.class.getResource("/jetty-config.xml");
			if (jettyConfig == null) {
				log.fatal("Unable to locate jetty-config.xml on the classpath");
			}
			final Server jetty = new Server(jettyConfig);
			jettyServer = jetty;
			jettyServer.setWebApplicationConfigurationClassNames(new String[] {
					"org.mortbay.jetty.servlet.XMLConfiguration",
					"org.mortbay.jetty.servlet.JettyWebConfiguration",
					"cn.org.seventh.test.TagLibConfigurationEx" });
			WebApplicationContext webApplicationContext = jettyServer
					.addWebApplication("/", path);
			webApplicationContext.setResourceAlias(
					TagLibConfigurationEx.TAGLIB_DIR, taglibPath);
			jettyServer.getContext("/").setTempDirectory(new File(temp));
			new Thread(new Runnable() {

				public void run() {
					try {
						jetty.start();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}).start();
		} catch (Exception e) {
			log.fatal("Could not start the Jetty server: " + e);
			if (jettyServer != null) {
				try {
					jettyServer.stop();
				} catch (Exception e1) {
					log.fatal("Unable to stop the jetty server: " + e1);
				}
			}
		}
	}
}