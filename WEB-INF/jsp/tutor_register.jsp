<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Register - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
	
  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="index.html" class="logo d-flex align-items-center w-auto">
                  <img src="assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">TutorFinder</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4"><b>Tutor</b> Registration</h5>
                  </div>
		
		<div class="px-4">
   		<html:form action="/registerPath" method="post"  enctype="multipart/form-data">
		<logic:empty property="frmRegFormControl" name="RegFormBean">
		<table align="center"  class="table table-borderless">
			<tr>
				<td>Name:<font color="red">*</font></td>
				<td><html:text property="frmRegName"></html:text>  
				<html:errors property="frmRegName" /></td>
			</tr>
			<tr>
				<td>Email:<font color="red">*</font> </td>
				<td><html:text property="frmRegEmail"></html:text> 
					<html:errors property="frmRegEmail" />
					<html:errors property="accountError" />
				</td>
			</tr>
			<tr>
				<td>Tutor Type:<font color="red">*</font> </td>
				<td><html:select property="frmRegTutorType">
					<html:option value="0">SELECT</html:option>
					<html:option value="Guide">Guide</html:option>
					<html:option value="Teacher">Teacher</html:option>
					<html:option value="Teacher, Guide">Teacher, Guide</html:option>
				</html:select> 
				<html:errors property="tutorTypeError" /></td>
			</tr>
			<tr>
				<td>Highest Degree:<font color="red">*</font> </td>
				<td><html:select property="frmRegHighestDegree">
					<html:option value="0">SELECT</html:option>
					<html:option value="Bachelor">Bachelor</html:option>
					<html:option value="Master">Master</html:option>
					<html:option value="Ph.D">Ph.D</html:option>
				</html:select> 
				<html:errors property="educationError" /></td>
			</tr>
			<tr>
				<td>Specialization:<font color="red">*</font></td>
				<td><html:text property="frmRegSpecialization"></html:text>  
				<html:errors property="frmRegSpecialization" /></td>
			</tr>
			<tr>
				<td>More Degree(s):</td>
				<td><html:textarea property="frmRegMoreDegrees"></html:textarea></td>
			</tr>
			<tr>
				<td>Gender:<font color="red">*</font></td>
				<td><html:radio property="frmRegGender" value="Male">Male</html:radio>
					<html:radio property="frmRegGender" value="Female">Female</html:radio>
					<html:errors property="frmRegGender" />
					</td>
			</tr>
			<tr>
				<td>Phone No:<font color="red">*</font></td>
				<td><html:text property="frmRegPhoneNo"></html:text>
					<html:errors property="frmRegPhoneNo" />
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:textarea property="frmRegAddress">
				</html:textarea></td>
			</tr>
			<tr>
				<td>About:</td>
				<td><html:textarea property="frmRegAbout">
				</html:textarea></td>
			</tr>
			<tr>
				<td>Upload Profile Photo:</td>
				<td><html:file property="frmRegPhotoFormFile"></html:file></td>
			</tr>
			<tr>
				<td>Password:<font	color="red">*</font></td>
				<td><html:password property="frmRegPassword"></html:password>
				 <html:errors property="frmRegPassword" /></td>
			</tr>
			<tr>
				<td>Confirm Password:<font color="red">*</font></td>
				<td><html:password property="frmRegConfPassword">
				</html:password>  <html:errors
					property="frmRegConfPassword" /> <html:errors
					property="passwordError" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><html:submit
					property="btnRegister" value="Register">
				</html:submit> <html:cancel value="Cancel" /></td>
			</tr>

		</table>
	</logic:empty>
	<!-- Confirmation portion here -->
	<logic:notEmpty property="frmRegFormControl" name="RegFormBean">
		<table align="center" class="table table-borderless">
			<tr>
				<td>Name:</td>
				<td><html:text property="frmRegName" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><html:text property="frmRegEmail" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Tutor Type:</td>
				<td><html:text property="frmRegTutorType" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Highest Degree:</td>
				<td><html:text property="frmRegHighestDegree" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Specialization:</td>
				<td><html:text property="frmRegSpecialization" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>More Degree(s):</td>
				<td><html:textarea property="frmRegMoreDegrees" disabled="true">
				</html:textarea></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><html:text property="frmRegGender" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><html:text property="frmRegPhoneNo" disabled="true">
				</html:text></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><html:textarea property="frmRegAddress" disabled="true">
				</html:textarea></td>
			</tr>
			<tr>
				<td>About:</td>
				<td><html:textarea property="frmRegAbout" disabled="true">
				</html:textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit property="btnSave"
					value="Save">
				</html:submit> <html:submit property="btnSaveCancel" value="Cancel">
				</html:submit></td>
			</tr>
		</table>
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