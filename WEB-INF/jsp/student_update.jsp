<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Update Profile - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>My Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Profile Overview</li>
          <li class="breadcrumb-item active">Edit Profile</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	
  	  <section class="section profile">
  	  
  	  <div class="row">
        <div class="col-xl-12">
        	<!-- Special title treatmen -->
          <div class="card ">
            <div class="card-header">
              <ul class="nav nav-pills card-header-pills align-items-center justify-content-center">
                <li class="nav-item">
                  <a class="nav-link" href="myProfilePath.do?frmControl=0">Overview</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link profile-tab active" href="StuUpdatePathFirst.do">Edit Profile</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="StuChangePasswordPathFirst.do">Change Password</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="StuDeleteProfilePathFirst.do"><font color="red">Delete Account</font></a>
                </li>
              </ul>
            </div>
            <div class="card-body">
            	<div class="row">
       			 <div class="col-xl-4">
       			 	 <div class="card m-4">
            		 <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

             		 <img src="images/stu_${StuUpdateFormBean.frmStudentDetails.id}?time=<%=System.currentTimeMillis()%>" alt="No Photo" class="rounded-circle">
             		 <h2>${StuUpdateFormBean.frmStudentDetails.studentName}</h2>
             		 <h3 class="pt-2">${StuUpdateFormBean.frmStudentDetails.grade}</h3>
             		 <h4 class="small font-bold">${StuUpdateFormBean.frmStudentDetails.gender}</h4>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				<html:form action="/StuUpdatePath" method="post"  enctype="multipart/form-data">
				<logic:empty property="frmRegFormControl" name="StuUpdateFormBean">
				
				<h5 class="card-title">Change Profile Photo</h5> 
					<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Upload Photo</div>
                    	<div class="col-lg-9 col-md-8">
                    		<div class="label pb-2"><img class= "img-thumbnail" src="images/stu_${StuUpdateFormBean.frmStudentDetails.id}?time=<%=System.currentTimeMillis()%>" width="100" height="100" alt="no Photo"/></div>
                    		<div><html:file property="frmRegPhotoFormFile"></html:file></div>
                    	</div>
                  	</div>	
			
					<h5 class="card-title">Personal Information</h5> 
					<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Name <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegName"></html:text></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegName" /></div>
                    	
                  	</div>
                 
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Email</div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegEmail" disabled="true"></html:text></div>
                 	</div>

                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Grade <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8">
                    		<html:select property="frmRegGrade">
								<html:option value="0">SELECT</html:option>
								<html:option value="Grade 7">Grade 7</html:option>
								<html:option value="Grade 8">Grade 8</html:option>
								<html:option value="Grade 9">Grade 9</html:option>
								<html:option value="Grade 10">Grade 10</html:option>
								<html:option value="Grade 11">Grade 11</html:option>
								<html:option value="Grade 12">Grade 12</html:option>
							</html:select> </div>
                    	<div class="col-lg-12 text-danger"><html:errors property="gradeError" /></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Gender <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8">
                    	  	 <html:radio property="frmRegGender" value="Male"><font class="m-2">Male</font></html:radio>
                    	  	 <html:radio property="frmRegGender" value="Female"><font class="m-2">Female</font></html:radio>
						</div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegGender" /></div>
                  	</div>
                  	
                  	<h5 class="card-title">Contact Information</h5>
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Phone No. <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegPhoneNo"></html:text></div>
                    	<div class="col-lg-12 text-danger">
                    	<html:errors property="frmRegPhoneNo" /></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Address</div>
                    	<div class="col-lg-9 col-md-8"><html:textarea property="frmRegAddress"></html:textarea></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnUpdate" value="Update"></html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
                    	</div>
                    </div>
                  	
		</logic:empty>	
			  
		<!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="StuUpdateFormBean">
			<h5 class="card-title">Personal Information</h5>
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
               <h5 class="card-title">Contact Information</h5> 
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
                    	<span class=""><html:submit property="btnSave" value="Save"></html:submit></span>
                    	<span class="m-2"><html:submit property="btnSaveCancel" value="Cancel"></html:submit></span>
                    	</div>
                    </div>
		</logic:notEmpty>
	</html:form>
         </div>				
	 </div>
       		 </div>
       	    </div> 
           </div>
          </div><!-- End Special title treatmen -->
        </div>
       
    </section>
  	
  </main>
  
  <%@ include file="inc/footer.jsp"%>
  
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>