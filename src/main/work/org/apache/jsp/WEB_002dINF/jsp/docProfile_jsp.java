package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class docProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_url_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_core_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_core_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>MediApp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Hello Doctor :)</h1>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<form method=\"post\" action=\"/welcomeDoc.htm\" >\r\n");
      out.write("<table width=\"25%\" border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" bgcolor=\"lightblue\">Name :</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" bgcolor=\"lightblue\">Age :</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<a href=\"");
      if (_jspx_meth_core_url_0(_jspx_page_context))
        return;
      out.write("\">Log out</a>\r\n");
      out.write("<br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_core_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_core_url_0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _jspx_tagPool_core_url_value_nobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_core_url_0.setPageContext(_jspx_page_context);
    _jspx_th_core_url_0.setParent(null);
    _jspx_th_core_url_0.setValue("logon.htm");
    int _jspx_eval_core_url_0 = _jspx_th_core_url_0.doStartTag();
    if (_jspx_th_core_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_0);
      return true;
    }
    _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_0);
    return false;
  }
}
