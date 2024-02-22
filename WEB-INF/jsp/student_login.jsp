<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Login - Student</title>
 <%@ include file="inc/head.jsp"%>
  <style>
  	.login{
  background-color: #dd84f54d;
}
.logo-text{
color:#583f5c;
}
.card-title {
  padding: 20px 0 15px 0;
  font-size: 18px;
  font-weight: 500;
  color: #583f5c;
  font-family: "Poppins", sans-serif;
}
  </style>
</head>

<body class="login">

  <main>
    <div class="container ">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4 ">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="Welcome.do" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo-tfs-no-text.png" alt="">
                  <span class="logo-text d-none d-lg-block">TutorFinder</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body p-3">

                  <div class="pt-4">
                    <h5 class="card-title text-center pb-0 fs-4">Login to <b>Student</b> Account</h5>
                  </div>
		
		<div class="px-4">
       <html:form action="/StuLoginPath">
		<table align="center" class="table table-borderless">
		<tr>
			<td colspan="2" align="right" class="text-danger"><html:errors property="loginerror" /></td>
		</tr>
		<tr>
			<td><span class="card-title">Email:</span></td>
			<td><html:text property="frmStudentEmail"></html:text> </td>
		</tr>
		<tr>
			<td colspan="2" align="right" class="text-danger"><html:errors property="frmStudentEmail"/></td>
			
		</tr>
		<tr>
			<td><span class="card-title">Password:</span></td>
			<td><html:password property="frmPassword">
			</html:password></td>
		</tr>
		<tr>
			<td colspan="2" align="right" class="text-danger"><html:errors property="frmPassword"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><html:submit property="btnLogin"
				value="Login">
			</html:submit></td>
		</tr>
	</table>
</html:form>
</div>
		<div class="row px-4 ">
			<div class="p-1">New user? Please <a href="StuRegisterPathFirst.do">Register</a>.</div>
			<div class="p-1">Select <a href="Welcome.do"> Role </a> again.</div>
		</div>
                </div>
              </div>

              <div class="credits">
               <!--  Developed by <b>XxxxxxXxxx</b> -->
              </div>

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <%@ include file="inc/connect-js.jsp"%>
</body>

</html>