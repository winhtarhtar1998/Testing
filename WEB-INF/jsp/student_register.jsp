<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Register - Student</title>
 <%@ include file="inc/head.jsp"%>
 <style>
 	.profile-overview div{
 		padding:3px; 
 		padding-left:10px;
 		padding-right:15px;
 	}
 	.label{
 	color:#580F6C;
 	}
 </style>
</head>
<body>
	
  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="Welcome.do" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo-tfs-no-text.png" alt="">
                  <span class="d-none d-lg-block">TutorFinder</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-3 fs-4"><b>Student</b> Registration</h5>
                  </div>

			
			<html:form action="/StuRegisterPath" method="post"  enctype="multipart/form-data">
			<logic:empty property="frmRegFormControl" name="StuRegFormBean">
			<div class="profile-overview">
			<h5 class="card-title pt-0">Fill All Required Data</h5>
					<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Name <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:text property="frmRegName"></html:text></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegName" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Email <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:text property="frmRegEmail"></html:text></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegEmail" />
					<html:errors property="accountError" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Grade <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:select property="frmRegGrade">
					<html:option value="0">SELECT</html:option>
					<html:option value="Grade 7">Grade 7</html:option>
					<html:option value="Grade 8">Grade 8</html:option>
					<html:option value="Grade 9">Grade 9</html:option>
					<html:option value="Grade 10">Grade 10</html:option>
					<html:option value="Grade 11">Grade 11</html:option>
					<html:option value="Grade 12">Grade 12</html:option>
				</html:select> 
				</div>
                    	<div class="col-lg-12 text-danger"><html:errors property="gradeError" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Gender <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:radio property="frmRegGender" value="Male">Male</html:radio>
					<html:radio property="frmRegGender" value="Female">Female</html:radio>
					</div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegGender" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Phone No <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:text property="frmRegPhoneNo"></html:text>
				</div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegPhoneNo" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Address</div>
                    	<div class="col-lg-8 col-md-8"><html:textarea property="frmRegAddress">
				</html:textarea></div>
                    	<div class="col-lg-12 text-danger"></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Upload Profile Photo</div>
                    	<div class="col-lg-8 col-md-8"><html:file property="frmRegPhotoFormFile"></html:file></div>
                    	<div class="col-lg-12 text-danger"></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Password <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:password property="frmRegPassword"></html:password> </div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegPassword" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Confirm Password <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:password property="frmRegConfPassword">
				</html:password></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegConfPassword" /> <html:errors
					property="passwordError" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit
					property="btnRegister" value="Register">
				</html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
                    	</div>
                    </div>	
                  </div>
		</logic:empty>
		<!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="StuRegFormBean">
			<div class="profile-overview">
			<h5 class="card-title">Confirm Your Data</h5>
			<div class="row">
                   <div class="col-lg-3 col-md-4 label">Name</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegName" disabled="true"></html:text></div>
                </div>
                
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Email</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegEmail" disabled="true"></html:text></div>
                </div>
                
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Grade</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegGrade" disabled="true"></html:text></div>
                </div>
                
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Gender</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegGender" disabled="true"></html:text></div>
                </div>
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Phone No</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegPhoneNo" disabled="true"></html:text></div>
                </div>
                
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Address</div>
                   <div class="col-lg-9 col-md-8"><html:textarea property="frmRegAddress" disabled="true"></html:textarea></div>
                </div>
                
                <div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnSave"	value="Save"></html:submit></span>
                    	<span class="m-2"><html:submit property="btnSaveCancel" value="Cancel"></html:submit></span>
                    	</div>
                    </div>
                  </div>
	</logic:notEmpty>
</html:form>
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