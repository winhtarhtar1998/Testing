/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2022-08-11 03:04:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_005fregister_005fsuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(11);
    _jspx_dependants.put("/WEB-INF/jsp/inc/common.jsp", Long.valueOf(1658217370806L));
    _jspx_dependants.put("/WEB-INF/lib/struts-taglib-1.3.8.jar", Long.valueOf(1656877560000L));
    _jspx_dependants.put("jar:file:/C:/ACA%20Data/test/WorkspaceForHibernate/AyeChanAung_TutorFinderSystem/WEB-INF/lib/struts-taglib-1.3.8.jar!/META-INF/tld/struts-logic.tld", Long.valueOf(1172892492000L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1656877560000L));
    _jspx_dependants.put("jar:file:/C:/ACA%20Data/test/WorkspaceForHibernate/AyeChanAung_TutorFinderSystem/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098687690000L));
    _jspx_dependants.put("/WEB-INF/lib/displaytag-1.2.jar", Long.valueOf(1658332280172L));
    _jspx_dependants.put("/WEB-INF/jsp/inc/connect-js.jsp", Long.valueOf(1657713285575L));
    _jspx_dependants.put("jar:file:/C:/ACA%20Data/test/WorkspaceForHibernate/AyeChanAung_TutorFinderSystem/WEB-INF/lib/struts-taglib-1.3.8.jar!/META-INF/tld/struts-html.tld", Long.valueOf(1172892492000L));
    _jspx_dependants.put("jar:file:/C:/ACA%20Data/test/WorkspaceForHibernate/AyeChanAung_TutorFinderSystem/WEB-INF/lib/struts-taglib-1.3.8.jar!/META-INF/tld/struts-bean.tld", Long.valueOf(1172892492000L));
    _jspx_dependants.put("jar:file:/C:/ACA%20Data/test/WorkspaceForHibernate/AyeChanAung_TutorFinderSystem/WEB-INF/lib/displaytag-1.2.jar!/META-INF/displaytag.tld", Long.valueOf(1230365746000L));
    _jspx_dependants.put("/WEB-INF/jsp/inc/head.jsp", Long.valueOf(1659971662311L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" <title>Register - Student</title>\r\n");
      out.write(" ");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"assets/img/logo-tfs-no-text.png\" rel=\"icon\">\r\n");
      out.write("  <link href=\"assets/img/logo-tfs-no-text.png\" rel=\"apple-touch-icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.gstatic.com\" rel=\"preconnect\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor CSS Files -->\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/quill/quill.snow.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/quill/quill.bubble.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/simple-datatables/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main CSS File -->\r\n");
      out.write("  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- =======================================================\r\n");
      out.write("  * Template Name: NiceAdmin - v2.2.2\r\n");
      out.write("  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/\r\n");
      out.write("  * Author: BootstrapMade.com\r\n");
      out.write("  * License: https://bootstrapmade.com/license/\r\n");
      out.write("  ======================================================== -->");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("  <main>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("      <section class=\"section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <div class=\"row justify-content-center\">\r\n");
      out.write("            <div class=\"col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center\">\r\n");
      out.write("\r\n");
      out.write("              <div class=\"d-flex justify-content-center py-4\">\r\n");
      out.write("                <a href=\"index.html\" class=\"logo d-flex align-items-center w-auto\">\r\n");
      out.write("                  <img src=\"assets/img/logo.png\" alt=\"\">\r\n");
      out.write("                  <span class=\"d-none d-lg-block\">TutorFinder</span>\r\n");
      out.write("                </a>\r\n");
      out.write("              </div><!-- End Logo -->\r\n");
      out.write("\r\n");
      out.write("              <div class=\"card mb-3\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"py-4 px-4\">\r\n");
      out.write("                    <h5 class=\"card-title text-center pb-0 fs-4\"><b>Student</b> Registration</h5>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"px-4\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-borderless\">\r\n");
      out.write("   \t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th align=\"left\">Registration is Successful.</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr><td>Go to <a href=\"StuRegisterPathSuccess.do\">Login</a> page.</td></tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"credits\">\r\n");
      out.write("               <!--  Developed by <b>XxxxxxXxxx</b> -->\r\n");
      out.write("              </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </section>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </main><!-- End #main -->\r\n");
      out.write("\t\r\n");
      out.write("  ");
      out.write("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor JS Files -->\r\n");
      out.write("  <script src=\"assets/vendor/apexcharts/apexcharts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/chart.js/chart.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/echarts/echarts.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/quill/quill.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/simple-datatables/simple-datatables.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/tinymce/tinymce.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/php-email-form/validate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main JS File -->\r\n");
      out.write("  <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
