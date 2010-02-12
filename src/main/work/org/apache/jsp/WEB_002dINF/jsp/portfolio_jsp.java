package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class portfolio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include.jsp");
    _jspx_dependants.add("/WEB-INF/spring.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_str_upperCase;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_core_url_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatNumber_value_type_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_str_upperCase = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_core_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.release();
    _jspx_tagPool_core_forEach_var_items.release();
    _jspx_tagPool_str_upperCase.release();
    _jspx_tagPool_core_out_value_nobody.release();
    _jspx_tagPool_core_choose.release();
    _jspx_tagPool_core_when_test.release();
    _jspx_tagPool_core_otherwise.release();
    _jspx_tagPool_fmt_formatNumber_value_nobody.release();
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
      out.write("<head><title>Portfolio</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Portfolio</h1>\r\n");
      out.write("<b>Cash:</b> ");
      if (_jspx_meth_fmt_formatNumber_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><b>Symbol</b></td>\r\n");
      out.write("\t\t<td><b>Company</b></td>\r\n");
      out.write("\t\t<td><b>Price</b></td>\r\n");
      out.write("\t\t<td><b>Change</b></td>\r\n");
      out.write("\t\t<td><b>% Change</b></td>\r\n");
      out.write("\t\t<td><b>Shares</b></td>\r\n");
      out.write("\t\t<td><b>Open</b></td>\r\n");
      out.write("\t\t<td><b>Volume</b></td>\r\n");
      out.write("\t\t<td><b>Current Value</b></td>\r\n");
      out.write("\t\t<td><b>Gain/Loss</b></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
      if (_jspx_meth_core_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("<a href=\"");
      if (_jspx_meth_core_url_0(_jspx_page_context))
        return;
      out.write("\">Make a trade</a><br/>\r\n");
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

  private boolean _jspx_meth_fmt_formatNumber_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent(null);
    _jspx_th_fmt_formatNumber_0.setValue("${model.cash}");
    _jspx_th_fmt_formatNumber_0.setType("currency");
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }

  private boolean _jspx_meth_core_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:forEach
    org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_core_forEach_0 = (org.apache.taglibs.standard.tag.el.core.ForEachTag) _jspx_tagPool_core_forEach_var_items.get(org.apache.taglibs.standard.tag.el.core.ForEachTag.class);
    _jspx_th_core_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_core_forEach_0.setParent(null);
    _jspx_th_core_forEach_0.setItems("${model.portfolioItems}");
    _jspx_th_core_forEach_0.setVar("stock");
    int[] _jspx_push_body_count_core_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_core_forEach_0 = _jspx_th_core_forEach_0.doStartTag();
      if (_jspx_eval_core_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t<tr>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_str_upperCase_0(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_core_out_1(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_fmt_formatNumber_1(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_core_choose_0(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("\t\r\n");
          out.write("\t\t</td>\r\n");
          out.write("\t\t<td>\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_core_choose_1(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("\t\r\n");
          out.write("\t\t</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_fmt_formatNumber_6(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_fmt_formatNumber_7(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_fmt_formatNumber_8(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>");
          if (_jspx_meth_fmt_formatNumber_9(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t<td>\r\n");
          out.write("\t\t\t");
          if (_jspx_meth_core_choose_2(_jspx_th_core_forEach_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
            return true;
          out.write("\t\r\n");
          out.write("\t\t</td>\r\n");
          out.write("\t</tr>\r\n");
          out.write("\t");
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

  private boolean _jspx_meth_str_upperCase_0(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  str:upperCase
    org.apache.taglibs.string.UpperCaseTag _jspx_th_str_upperCase_0 = (org.apache.taglibs.string.UpperCaseTag) _jspx_tagPool_str_upperCase.get(org.apache.taglibs.string.UpperCaseTag.class);
    _jspx_th_str_upperCase_0.setPageContext(_jspx_page_context);
    _jspx_th_str_upperCase_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    int _jspx_eval_str_upperCase_0 = _jspx_th_str_upperCase_0.doStartTag();
    if (_jspx_eval_str_upperCase_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_str_upperCase_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_core_forEach_0[0]++;
        _jspx_th_str_upperCase_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_str_upperCase_0.doInitBody();
      }
      do {
        if (_jspx_meth_core_out_0(_jspx_th_str_upperCase_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        int evalDoAfterBody = _jspx_th_str_upperCase_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_str_upperCase_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_core_forEach_0[0]--;
      }
    }
    if (_jspx_th_str_upperCase_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_str_upperCase.reuse(_jspx_th_str_upperCase_0);
      return true;
    }
    _jspx_tagPool_str_upperCase.reuse(_jspx_th_str_upperCase_0);
    return false;
  }

  private boolean _jspx_meth_core_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_str_upperCase_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_0.setPageContext(_jspx_page_context);
    _jspx_th_core_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_str_upperCase_0);
    _jspx_th_core_out_0.setValue("${stock.symbol}");
    int _jspx_eval_core_out_0 = _jspx_th_core_out_0.doStartTag();
    if (_jspx_th_core_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_0);
    return false;
  }

  private boolean _jspx_meth_core_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_core_out_1 = (org.apache.taglibs.standard.tag.el.core.OutTag) _jspx_tagPool_core_out_value_nobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_core_out_1.setPageContext(_jspx_page_context);
    _jspx_th_core_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_core_out_1.setValue("${stock.quote.company}");
    int _jspx_eval_core_out_1 = _jspx_th_core_out_1.doStartTag();
    if (_jspx_th_core_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
      return true;
    }
    _jspx_tagPool_core_out_value_nobody.reuse(_jspx_th_core_out_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_1(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_1 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_fmt_formatNumber_1.setValue("${stock.quote.value}");
    _jspx_th_fmt_formatNumber_1.setType("currency");
    int _jspx_eval_fmt_formatNumber_1 = _jspx_th_fmt_formatNumber_1.doStartTag();
    if (_jspx_th_fmt_formatNumber_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_1);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_1);
    return false;
  }

  private boolean _jspx_meth_core_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_core_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_core_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_core_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_core_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    int _jspx_eval_core_choose_0 = _jspx_th_core_choose_0.doStartTag();
    if (_jspx_eval_core_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_when_0(_jspx_th_core_choose_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_otherwise_0(_jspx_th_core_choose_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_core_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_0);
      return true;
    }
    _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_0);
    return false;
  }

  private boolean _jspx_meth_core_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_core_when_0 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _jspx_tagPool_core_when_test.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_core_when_0.setPageContext(_jspx_page_context);
    _jspx_th_core_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_0);
    _jspx_th_core_when_0.setTest("${stock.quote.change >= 0}");
    int _jspx_eval_core_when_0 = _jspx_th_core_when_0.doStartTag();
    if (_jspx_eval_core_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_2(_jspx_th_core_when_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_0);
      return true;
    }
    _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_2(javax.servlet.jsp.tagext.JspTag _jspx_th_core_when_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_2 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_when_0);
    _jspx_th_fmt_formatNumber_2.setValue("${stock.quote.change}");
    _jspx_th_fmt_formatNumber_2.setType("currency");
    int _jspx_eval_fmt_formatNumber_2 = _jspx_th_fmt_formatNumber_2.doStartTag();
    if (_jspx_th_fmt_formatNumber_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_2);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_2);
    return false;
  }

  private boolean _jspx_meth_core_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_core_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_core_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_core_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_core_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_0);
    int _jspx_eval_core_otherwise_0 = _jspx_th_core_otherwise_0.doStartTag();
    if (_jspx_eval_core_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<font color=\"red\">\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_3(_jspx_th_core_otherwise_0, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t</font>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_0);
      return true;
    }
    _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_3(javax.servlet.jsp.tagext.JspTag _jspx_th_core_otherwise_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_3 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_otherwise_0);
    _jspx_th_fmt_formatNumber_3.setValue("${stock.quote.change}");
    _jspx_th_fmt_formatNumber_3.setType("currency");
    int _jspx_eval_fmt_formatNumber_3 = _jspx_th_fmt_formatNumber_3.doStartTag();
    if (_jspx_th_fmt_formatNumber_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_3);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_3);
    return false;
  }

  private boolean _jspx_meth_core_choose_1(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_core_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_core_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_core_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_core_choose_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    int _jspx_eval_core_choose_1 = _jspx_th_core_choose_1.doStartTag();
    if (_jspx_eval_core_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_when_1(_jspx_th_core_choose_1, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_otherwise_1(_jspx_th_core_choose_1, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_core_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_1);
      return true;
    }
    _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_1);
    return false;
  }

  private boolean _jspx_meth_core_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_core_when_1 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _jspx_tagPool_core_when_test.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_core_when_1.setPageContext(_jspx_page_context);
    _jspx_th_core_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_1);
    _jspx_th_core_when_1.setTest("${stock.quote.pctChange >= 0}");
    int _jspx_eval_core_when_1 = _jspx_th_core_when_1.doStartTag();
    if (_jspx_eval_core_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_4(_jspx_th_core_when_1, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_1);
      return true;
    }
    _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_4(javax.servlet.jsp.tagext.JspTag _jspx_th_core_when_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_4 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_when_1);
    _jspx_th_fmt_formatNumber_4.setValue("${stock.quote.pctChange}");
    _jspx_th_fmt_formatNumber_4.setType("percent");
    int _jspx_eval_fmt_formatNumber_4 = _jspx_th_fmt_formatNumber_4.doStartTag();
    if (_jspx_th_fmt_formatNumber_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_4);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_4);
    return false;
  }

  private boolean _jspx_meth_core_otherwise_1(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_core_otherwise_1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_core_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_core_otherwise_1.setPageContext(_jspx_page_context);
    _jspx_th_core_otherwise_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_1);
    int _jspx_eval_core_otherwise_1 = _jspx_th_core_otherwise_1.doStartTag();
    if (_jspx_eval_core_otherwise_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<font color=\"red\">\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_5(_jspx_th_core_otherwise_1, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t</font>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_otherwise_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_otherwise_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_1);
      return true;
    }
    _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_5(javax.servlet.jsp.tagext.JspTag _jspx_th_core_otherwise_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_5 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_5.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_otherwise_1);
    _jspx_th_fmt_formatNumber_5.setValue("${stock.quote.pctChange}");
    _jspx_th_fmt_formatNumber_5.setType("percent");
    int _jspx_eval_fmt_formatNumber_5 = _jspx_th_fmt_formatNumber_5.doStartTag();
    if (_jspx_th_fmt_formatNumber_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_5);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_5);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_6(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_6 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_6.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_fmt_formatNumber_6.setValue("${stock.shares}");
    int _jspx_eval_fmt_formatNumber_6 = _jspx_th_fmt_formatNumber_6.doStartTag();
    if (_jspx_th_fmt_formatNumber_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_nobody.reuse(_jspx_th_fmt_formatNumber_6);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_nobody.reuse(_jspx_th_fmt_formatNumber_6);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_7(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_7 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_7.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_fmt_formatNumber_7.setValue("${stock.quote.openPrice}");
    _jspx_th_fmt_formatNumber_7.setType("currency");
    int _jspx_eval_fmt_formatNumber_7 = _jspx_th_fmt_formatNumber_7.doStartTag();
    if (_jspx_th_fmt_formatNumber_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_7);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_7);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_8(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_8 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_8.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_fmt_formatNumber_8.setValue("${stock.quote.volume}");
    int _jspx_eval_fmt_formatNumber_8 = _jspx_th_fmt_formatNumber_8.doStartTag();
    if (_jspx_th_fmt_formatNumber_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_nobody.reuse(_jspx_th_fmt_formatNumber_8);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_nobody.reuse(_jspx_th_fmt_formatNumber_8);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_9(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_9 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_9.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    _jspx_th_fmt_formatNumber_9.setValue("${stock.currentValue}");
    _jspx_th_fmt_formatNumber_9.setType("currency");
    int _jspx_eval_fmt_formatNumber_9 = _jspx_th_fmt_formatNumber_9.doStartTag();
    if (_jspx_th_fmt_formatNumber_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_9);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_9);
    return false;
  }

  private boolean _jspx_meth_core_choose_2(javax.servlet.jsp.tagext.JspTag _jspx_th_core_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_core_choose_2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_core_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_core_choose_2.setPageContext(_jspx_page_context);
    _jspx_th_core_choose_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_forEach_0);
    int _jspx_eval_core_choose_2 = _jspx_th_core_choose_2.doStartTag();
    if (_jspx_eval_core_choose_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_when_2(_jspx_th_core_choose_2, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_core_otherwise_2(_jspx_th_core_choose_2, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_core_choose_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_choose_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_2);
      return true;
    }
    _jspx_tagPool_core_choose.reuse(_jspx_th_core_choose_2);
    return false;
  }

  private boolean _jspx_meth_core_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_core_when_2 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _jspx_tagPool_core_when_test.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_core_when_2.setPageContext(_jspx_page_context);
    _jspx_th_core_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_2);
    _jspx_th_core_when_2.setTest("${stock.gainLoss >= 0}");
    int _jspx_eval_core_when_2 = _jspx_th_core_when_2.doStartTag();
    if (_jspx_eval_core_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_10(_jspx_th_core_when_2, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_2);
      return true;
    }
    _jspx_tagPool_core_when_test.reuse(_jspx_th_core_when_2);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_10(javax.servlet.jsp.tagext.JspTag _jspx_th_core_when_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_10 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_10.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_when_2);
    _jspx_th_fmt_formatNumber_10.setValue("${stock.gainLoss}");
    _jspx_th_fmt_formatNumber_10.setType("currency");
    int _jspx_eval_fmt_formatNumber_10 = _jspx_th_fmt_formatNumber_10.doStartTag();
    if (_jspx_th_fmt_formatNumber_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_10);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_10);
    return false;
  }

  private boolean _jspx_meth_core_otherwise_2(javax.servlet.jsp.tagext.JspTag _jspx_th_core_choose_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  core:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_core_otherwise_2 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_core_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_core_otherwise_2.setPageContext(_jspx_page_context);
    _jspx_th_core_otherwise_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_choose_2);
    int _jspx_eval_core_otherwise_2 = _jspx_th_core_otherwise_2.doStartTag();
    if (_jspx_eval_core_otherwise_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<font color=\"red\">\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_fmt_formatNumber_11(_jspx_th_core_otherwise_2, _jspx_page_context, _jspx_push_body_count_core_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t</font>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_core_otherwise_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_core_otherwise_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_2);
      return true;
    }
    _jspx_tagPool_core_otherwise.reuse(_jspx_th_core_otherwise_2);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_11(javax.servlet.jsp.tagext.JspTag _jspx_th_core_otherwise_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_core_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_11 = (org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_nobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_11.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_core_otherwise_2);
    _jspx_th_fmt_formatNumber_11.setValue("${stock.gainLoss}");
    _jspx_th_fmt_formatNumber_11.setType("currency");
    int _jspx_eval_fmt_formatNumber_11 = _jspx_th_fmt_formatNumber_11.doStartTag();
    if (_jspx_th_fmt_formatNumber_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_11);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_nobody.reuse(_jspx_th_fmt_formatNumber_11);
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
    _jspx_th_core_url_0.setValue("trade.htm");
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
