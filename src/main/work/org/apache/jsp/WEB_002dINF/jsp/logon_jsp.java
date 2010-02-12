package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_hasBindErrors_name;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_spring_hasBindErrors_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
    _jspx_tagPool_core_out_value_nobody.release();
    _jspx_tagPool_spring_hasBindErrors_name.release();
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
      out.write("<head><title>MediApp</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\r\n");
      out.write("\t<h1>Welcome to MediApp</h1>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t\r\n");
      out.write("\t<form method=\"post\">\r\n");
      out.write("\t\t<table width=\"25%\" border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" bgcolor=\"lightblue\">Log on</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<table border=\"0\" width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"33%\" align=\"right\">Username: </td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"66%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("person.username");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"text\" \r\n");
            out.write("\t\t\t\t\t\t\t\t       name=\"username\" \r\n");
            out.write("\t\t\t\t\t\t\t\t       value=\"");
            if (_jspx_meth_core_out_0(_jspx_th_spring_bind_0, _jspx_page_context, _jspx_push_body_count_spring_bind_0))
              return;
            out.write("\"/>\t\t\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_bind_0.doAfterBody();
            status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_0.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_0);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  spring:hasBindErrors
      org.springframework.web.servlet.tags.BindErrorsTag _jspx_th_spring_hasBindErrors_0 = (org.springframework.web.servlet.tags.BindErrorsTag) _jspx_tagPool_spring_hasBindErrors_name.get(org.springframework.web.servlet.tags.BindErrorsTag.class);
      _jspx_th_spring_hasBindErrors_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_hasBindErrors_0.setParent(null);
      _jspx_th_spring_hasBindErrors_0.setName("person");
      int[] _jspx_push_body_count_spring_hasBindErrors_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_hasBindErrors_0 = _jspx_th_spring_hasBindErrors_0.doStartTag();
        if (_jspx_eval_spring_hasBindErrors_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.validation.Errors errors = null;
          errors = (org.springframework.validation.Errors) _jspx_page_context.findAttribute("errors");
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t<font color=\"red\">");
            if (_jspx_meth_core_out_1(_jspx_th_spring_hasBindErrors_0, _jspx_page_context, _jspx_push_body_count_spring_hasBindErrors_0))
              return;
            out.write("</font>\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_hasBindErrors_0.doAfterBody();
            errors = (org.springframework.validation.Errors) _jspx_page_context.findAttribute("errors");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_hasBindErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_hasBindErrors_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_hasBindErrors_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_hasBindErrors_0.doFinally();
        _jspx_tagPool_spring_hasBindErrors_name.reuse(_jspx_th_spring_hasBindErrors_0);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"33%\" align=\"right\">Password: </td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"66%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("person.password");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" />\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_bind_1.doAfterBody();
            status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_1.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_1);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  spring:hasBindErrors
      org.springframework.web.servlet.tags.BindErrorsTag _jspx_th_spring_hasBindErrors_1 = (org.springframework.web.servlet.tags.BindErrorsTag) _jspx_tagPool_spring_hasBindErrors_name.get(org.springframework.web.servlet.tags.BindErrorsTag.class);
      _jspx_th_spring_hasBindErrors_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_hasBindErrors_1.setParent(null);
      _jspx_th_spring_hasBindErrors_1.setName("person");
      int[] _jspx_push_body_count_spring_hasBindErrors_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_hasBindErrors_1 = _jspx_th_spring_hasBindErrors_1.doStartTag();
        if (_jspx_eval_spring_hasBindErrors_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.validation.Errors errors = null;
          errors = (org.springframework.validation.Errors) _jspx_page_context.findAttribute("errors");
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t<font color=\"red\">");
            if (_jspx_meth_core_out_2(_jspx_th_spring_hasBindErrors_1, _jspx_page_context, _jspx_push_body_count_spring_hasBindErrors_1))
              return;
            out.write("</font>\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_hasBindErrors_1.doAfterBody();
            errors = (org.springframework.validation.Errors) _jspx_page_context.findAttribute("errors");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_hasBindErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_hasBindErrors_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_hasBindErrors_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_hasBindErrors_1.doFinally();
        _jspx_tagPool_spring_hasBindErrors_name.reuse(_jspx_th_spring_hasBindErrors_1);
      }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"center\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" alignment=\"center\" value=\"Logon\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_core_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_0.setPageContext(_jspx_page_context);
    _jspx_th_core_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_0);
    _jspx_th_core_out_0.setValue("${status.value}");
    int _jspx_eval_core_out_0 = _jspx_th_core_out_0.doStartTag();
    if (_jspx_th_core_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
    return false;
  }

  private boolean _jspx_meth_core_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_hasBindErrors_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_hasBindErrors_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_1 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_1.setPageContext(_jspx_page_context);
    _jspx_th_core_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_hasBindErrors_0);
    _jspx_th_core_out_1.setValue("${status.errorMessage}");
    int _jspx_eval_core_out_1 = _jspx_th_core_out_1.doStartTag();
    if (_jspx_th_core_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
    return false;
  }

  private boolean _jspx_meth_core_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_hasBindErrors_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_hasBindErrors_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_2 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_2.setPageContext(_jspx_page_context);
    _jspx_th_core_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_hasBindErrors_1);
    _jspx_th_core_out_2.setValue("${status.errorMessage}");
    int _jspx_eval_core_out_2 = _jspx_th_core_out_2.doStartTag();
    if (_jspx_th_core_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_2);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_2);
    return false;
  }
}
