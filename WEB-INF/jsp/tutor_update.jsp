<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Update Profile - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
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
              <ul class="nav nav-pills card-header-pills  align-items-center justify-content-center">
                <li class="nav-item">
                  <a class="nav-link " href="tutorProfilePath.do">Overview</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link profile-tab active" href="updatePathFirst.do">Edit Profile</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="changePasswordPathFirst.do">Change Password</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="deleteProfilePathFirst.do"><font color="red">Delete Account</font></a>
                </li>
              </ul>
            </div>
            <div class="card-body">
            	<div class="row">
       			 <div class="col-xl-4">
       			 	<div class="card m-1 mt-4">
            		 <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

             		 <img src="images/tut_${UpdateFormBean.frmTutorDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
             		 <h2>Tr. ${UpdateFormBean.frmTutorDetails.tutorName}</h2>
              		 <h3 class="pt-2">${UpdateFormBean.frmTutorDetails.tutorType}</h3>
              		 <h4 class="small font-bold">${UpdateFormBean.frmTutorDetails.gender}</h4>
                     <h5 class="card-title pb-0">About</h5>
                     <p class="small fst-italic">- ${UpdateFormBean.frmTutorDetails.about}</p>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				<html:form action="/updatePath" method="post"  enctype="multipart/form-data">
				<logic:empty property="frmRegFormControl" name="UpdateFormBean">
				
				<h5 class="card-title">Change Profile Photo</h5> 
					<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Upload Photo</div>
                    	<div class="col-lg-9 col-md-8">
                    		<div class="label pb-2"><img class= "img-thumbnail" src="images/tut_${UpdateFormBean.frmTutorDetails.id}?time=<%=System.currentTimeMillis()%>" width="100" height="100" alt="no Photo"/></div>
                    		<div><html:file property="frmRegPhotoFormFile"></html:file></div>
                    	</div>
                  	</div>	
					
					<h5 class="card-title">Personal Information</h5> 
					<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Name <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegName"></html:text></div>
                    	<div class="col-lg-12"><html:errors property="frmRegName" /></div>
                    	
                  	</div>
                 
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Email</div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegEmail" disabled="true"></html:text></div>
                 	</div>
                 	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Tutor Type <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8">
                    		<html:select property="frmRegTutorType">
								<html:option value="0">SELECT</html:option>
								<html:option value="Guide">Guide</html:option>
								<html:option value="Teacher">Teacher</html:option>
								<html:option value="Teacher, Guide">Teacher, Guide</html:option>
							</html:select> 
                    	</div>
                    	<div class="col-lg-12"><html:errors property="tutorTypeError" /></div>
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">About</div>
                    	<div class="col-lg-9 col-md-8"><html:textarea property="frmRegAbout"></html:textarea></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Gender <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8">
                    	  	 <html:radio property="frmRegGender" value="Male"><font class="m-2">Male</font></html:radio>
                    	  	 <html:radio property="frmRegGender" value="Female"><font class="m-2">Female</font></html:radio>
						</div>
                    	<div class="col-lg-12"><html:errors property="frmRegGender" /></div>
                  	</div>
                  	
                  	
                  	<h5 class="card-title">Education</h5>
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Highest Degree <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8">
                    		<html:select property="frmRegHighestDegree">
								<html:option value="0">SELECT</html:option>
								<html:option value="Bachelor">Bachelor</html:option>
								<html:option value="Master">Master</html:option>
								<html:option value="Ph.D">Ph.D</html:option>
							</html:select> 
                    	</div>
                    	<div class="col-lg-12"><html:errors property="educationError" /></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Specialization<font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegSpecialization"></html:text></div>
                    	<div class="col-lg-12"><html:errors property="frmRegSpecialization" /></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">More Degree(s)</div>
                    	<div class="col-lg-9 col-md-8"><html:textarea property="frmRegMoreDegrees"></html:textarea></div>
                  	</div>
                  	
                  	
                  	<h5 class="card-title">Contact Information</h5>
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Phone No. <font color="red">*</font></div>
                    	<div class="col-lg-9 col-md-8"><html:text property="frmRegPhoneNo"></html:text></div>
                    	<div class="col-lg-12"><html:errors property="frmRegPhoneNo" /></div>
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
		<logic:notEmpty property="frmRegFormControl" name="UpdateFormBean">
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
                   <div class="col-lg-3 col-md-4 label">Tutor Type</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegTutorType" disabled="true"></html:text></div>
                </div>
                
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Gender</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegGender" disabled="true"></html:text></div>
                </div>
                
                <h5 class="card-title">Education</h5>
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Highest Degree</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegHighestDegree" disabled="true"></html:text></div>
                </div>
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">Specialization</div>
                   <div class="col-lg-9 col-md-8"><html:text property="frmRegSpecialization" disabled="true"></html:text></div>
                </div>
                <div class="row">
                   <div class="col-lg-3 col-md-4 label">More Degree(s)</div>
                   <div class="col-lg-9 col-md-8"><html:textarea property="frmRegMoreDegrees" disabled="true"></html:textarea></div>
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