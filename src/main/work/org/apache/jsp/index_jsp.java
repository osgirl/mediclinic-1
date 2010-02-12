package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_redirect_url_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_core_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_core_redirect_url_nobody.release();
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
      if (_jspx_meth_core_redirect_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_core_redirect_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:redirect
    org.apache.taglibs.standard.tag.el.core.RedirectTag _jspx_th_core_redirect_0 = (org.apache.taglibs.standard.tag.el.core.RedirectTag) _jspx_tagPool_core_redirect_url_nobody.get(org.apache.taglibs.standard.tag.el.core.RedirectTag.class);
    _jspx_th_core_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_core_redirect_0.setParent(null);
    _jspx_th_core_redirect_0.setUrl("/logon.htm");
    int _jspx_eval_core_redirect_0 = _jspx_th_core_redirect_0.doStartTag();
    if (_jspx_th_core_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_redirect_url_nobody.reuse(_jspx_th_core_redirect_0);
      return true;
    }
    _jspx_tagPool_core_redirect_url_nobody.reuse(_jspx_th_core_redirect_0);
    return false;
  }
}
