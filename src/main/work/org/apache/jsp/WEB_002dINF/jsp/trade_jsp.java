package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class trade_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_bind_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_url_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_bind_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_bind_path.release();
    _jspx_tagPool_core_forEach_var_items.release();
    _jspx_tagPool_core_out_value_nobody.release();
    _jspx_tagPool_core_if_test.release();
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
      out.write("<head><title>Trade</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Trade</h1>\r\n");
      out.write("<form method=\"post\">\r\n");
      out.write("\r\n");
      out.write("<!-- first bind on the object itself to display global errors - if available -->\r\n");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_0 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_0.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_0.setParent(null);
      _jspx_th_spring_bind_0.setPath("trade.*");
      int[] _jspx_push_body_count_spring_bind_0 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_0 = _jspx_th_spring_bind_0.doStartTag();
        if (_jspx_eval_spring_bind_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t<font color=\"red\">\r\n");
            out.write("\t    ");
            if (_jspx_meth_core_forEach_0(_jspx_th_spring_bind_0, _jspx_page_context, _jspx_push_body_count_spring_bind_0))
              return;
            out.write("\r\n");
            out.write("    </font>\r\n");
            out.write("    <br/>\r\n");
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
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td></td>\r\n");
      out.write("\t\t<td><b>Symbol</b></td>\r\n");
      out.write("\t\t<td><b>Shares</b></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_1 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_1.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_1.setParent(null);
      _jspx_th_spring_bind_1.setPath("trade.buySell");
      int[] _jspx_push_body_count_spring_bind_1 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_1 = _jspx_th_spring_bind_1.doStartTag();
        if (_jspx_eval_spring_bind_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t\t<input type=\"radio\" \r\n");
            out.write("\t\t\t       name=\"buySell\" \r\n");
            out.write("\t\t\t       value=\"true\" \r\n");
            out.write("\t\t\t       ");
            if (_jspx_meth_core_if_0(_jspx_th_spring_bind_1, _jspx_page_context, _jspx_push_body_count_spring_bind_1))
              return;
            out.write(" >\r\n");
            out.write("\t\t\t\tBuy\r\n");
            out.write("\t\t\t</input>\r\n");
            out.write("\t\t\t<input type=\"radio\" \r\n");
            out.write("\t\t\t       name=\"buySell\" \r\n");
            out.write("\t\t\t       value=\"false\" \r\n");
            out.write("\t\t\t       ");
            if (_jspx_meth_core_if_1(_jspx_th_spring_bind_1, _jspx_page_context, _jspx_push_body_count_spring_bind_1))
              return;
            out.write(" >\r\n");
            out.write("\t\t\t\tSell\r\n");
            out.write("\t\t\t</input>\r\n");
            out.write("\t\t\t");
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
      out.write("\t\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_2 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_2.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_2.setParent(null);
      _jspx_th_spring_bind_2.setPath("trade.symbol");
      int[] _jspx_push_body_count_spring_bind_2 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_2 = _jspx_th_spring_bind_2.doStartTag();
        if (_jspx_eval_spring_bind_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t\t<input type=\"text\" name=\"symbol\" value=\"");
            if (_jspx_meth_core_out_1(_jspx_th_spring_bind_2, _jspx_page_context, _jspx_push_body_count_spring_bind_2))
              return;
            out.write("\"/>\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_bind_2.doAfterBody();
            status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_2.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_2);
      }
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t");
      //  spring:bind
      org.springframework.web.servlet.tags.BindTag _jspx_th_spring_bind_3 = (org.springframework.web.servlet.tags.BindTag) _jspx_tagPool_spring_bind_path.get(org.springframework.web.servlet.tags.BindTag.class);
      _jspx_th_spring_bind_3.setPageContext(_jspx_page_context);
      _jspx_th_spring_bind_3.setParent(null);
      _jspx_th_spring_bind_3.setPath("trade.shares");
      int[] _jspx_push_body_count_spring_bind_3 = new int[] { 0 };
      try {
        int _jspx_eval_spring_bind_3 = _jspx_th_spring_bind_3.doStartTag();
        if (_jspx_eval_spring_bind_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          org.springframework.web.servlet.tags.BindStatus status = null;
          status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
          do {
            out.write("\r\n");
            out.write("\t\t\t<input type=\"text\" name=\"shares\" value=\"");
            if (_jspx_meth_core_out_2(_jspx_th_spring_bind_3, _jspx_page_context, _jspx_push_body_count_spring_bind_3))
              return;
            out.write("\"/>\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_spring_bind_3.doAfterBody();
            status = (org.springframework.web.servlet.tags.BindStatus) _jspx_page_context.findAttribute("status");
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_spring_bind_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_spring_bind_3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_spring_bind_3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_spring_bind_3.doFinally();
        _jspx_tagPool_spring_bind_path.reuse(_jspx_th_spring_bind_3);
      }
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"3\" align=\"center\"><input type=\"submit\" alignment=\"center\" name=\"_target1\" value=\"Execute Order\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</form>\r\n");
      out.write("<br>\r\n");
      out.write("<a href=\"");
      if (_jspx_meth_core_url_0(_jspx_page_context))
        return;
      out.write("\">View Portfolio</a><br/>\r\n");
      out.write("<a href=\"");
      if (_jspx_meth_core_url_1(_jspx_page_context))
        return;
      out.write("\">Log out</a>\r\n");
      out.write("<br>\r\n");
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

  private boolean _jspx_meth_core_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:forEach
    org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_core_forEach_0 = (org.apache.taglibs.standard.tag.el.core.ForEachTag) _jspx_tagPool_core_forEach_var_items.get(org.apache.taglibs.standard.tag.el.core.ForEachTag.class);
    _jspx_th_core_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_core_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_0);
    _jspx_th_core_forEach_0.setItems("${status.errorMessages}");
    _jspx_th_core_forEach_0.setVar("error");
    int[] _jspx_push_body_count_core_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_core_forEach_0 = _jspx_th_core_forEach_0.doStartTag();
      if (_jspx_eval_core_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t    Error: ");
          if (_jspx_meth_core_out_0(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("<br/>\r\n");
          out.write("\t    ");
          int evalDoAfterBody = _jspx_th_core_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_core_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_core_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_core_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_core_forEach_0.doFinally();
      _jspx_tagPool_core_forEach_var_items.reuse(_jspx_th_core_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_core_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_0.setPageContext(_jspx_page_context);
    _jspx_th_core_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_core_out_0.setValue("${error}");
    int _jspx_eval_core_out_0 = _jspx_th_core_out_0.doStartTag();
    if (_jspx_th_core_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
    return false;
  }

  private boolean _jspx_meth_core_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_core_if_0 = (org.apache.taglibs.standard.tag.el.core.IfTag) _jspx_tagPool_core_if_test.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_core_if_0.setPageContext(_jspx_page_context);
    _jspx_th_core_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_1);
    _jspx_th_core_if_0.setTest("${status.value}");
    int _jspx_eval_core_if_0 = _jspx_th_core_if_0.doStartTag();
    if (_jspx_eval_core_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_core_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_if_test.reuse(_jspx_th_core_if_0);
      return true;
    }
    _jspx_tagPool_core_if_test.reuse(_jspx_th_core_if_0);
    return false;
  }

  private boolean _jspx_meth_core_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_core_if_1 = (org.apache.taglibs.standard.tag.el.core.IfTag) _jspx_tagPool_core_if_test.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_core_if_1.setPageContext(_jspx_page_context);
    _jspx_th_core_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_1);
    _jspx_th_core_if_1.setTest("${! status.value}");
    int _jspx_eval_core_if_1 = _jspx_th_core_if_1.doStartTag();
    if (_jspx_eval_core_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_core_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_if_test.reuse(_jspx_th_core_if_1);
      return true;
    }
    _jspx_tagPool_core_if_test.reuse(_jspx_th_core_if_1);
    return false;
  }

  private boolean _jspx_meth_core_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_1 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_1.setPageContext(_jspx_page_context);
    _jspx_th_core_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_2);
    _jspx_th_core_out_1.setValue("${status.value}");
    int _jspx_eval_core_out_1 = _jspx_th_core_out_1.doStartTag();
    if (_jspx_th_core_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
    return false;
  }

  private boolean _jspx_meth_core_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_spring_bind_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_spring_bind_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_2 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_2.setPageContext(_jspx_page_context);
    _jspx_th_core_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_spring_bind_3);
    _jspx_th_core_out_2.setValue("${status.value}");
    int _jspx_eval_core_out_2 = _jspx_th_core_out_2.doStartTag();
    if (_jspx_th_core_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_2);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_2);
    return false;
  }

  private boolean _jspx_meth_core_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_core_url_0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _jspx_tagPool_core_url_value_nobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_core_url_0.setPageContext(_jspx_page_context);
    _jspx_th_core_url_0.setParent(null);
    _jspx_th_core_url_0.setValue("portfolio.htm");
    int _jspx_eval_core_url_0 = _jspx_th_core_url_0.doStartTag();
    if (_jspx_th_core_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_0);
      return true;
    }
    _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_0);
    return false;
  }

  private boolean _jspx_meth_core_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_core_url_1 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _jspx_tagPool_core_url_value_nobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_core_url_1.setPageContext(_jspx_page_context);
    _jspx_th_core_url_1.setParent(null);
    _jspx_th_core_url_1.setValue("logon.htm");
    int _jspx_eval_core_url_1 = _jspx_th_core_url_1.doStartTag();
    if (_jspx_th_core_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_1);
      return true;
    }
    _jspx_tagPool_core_url_value_nobody.reuse(_jspx_th_core_url_1);
    return false;
  }
}
