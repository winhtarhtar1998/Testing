<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Change Password - Tutor</title>
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
          <li class="breadcrumb-item  active">Change Password</li>
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
                  <a class="nav-link" href="updatePathFirst.do">Edit Profile</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link profile-tab  active" href="changePasswordPathFirst.do">Change Password</a>
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

             		 <img src="images/tut_${ChangePasswordFormBean.frmTutorDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
             		 <h2>Tr. ${ChangePasswordFormBean.frmTutorDetails.tutorName}</h2>
              		 <h3 class="pt-2">${ChangePasswordFormBean.frmTutorDetails.tutorType}</h3>
              		 <h4 class="small font-bold">${ChangePasswordFormBean.frmTutorDetails.gender}</h4>
                     <h5 class="card-title pb-0">About</h5>
                     <p class="small fst-italic">- ${ChangePasswordFormBean.frmTutorDetails.about}</p>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				<html:form action="/changePasswordPath">
				<logic:empty property="frmRegFormControl" name="ChangePasswordFormBean">
				
				<h5 class="card-title">Change Password</h5>	
					
					<div class="row">
                    	<div class="col-lg-5 col-md-4 label">Current Password <font color="red">*</font></div>
                    	<div class="col-lg-7 col-md-8"><html:password property="frmCurrentPassword"></html:password></div>
                    	<div class="col-lg-12 text-danger">
                    		<html:errors property="frmCurrentPassword" />
							<html:errors property="currentPasswordError" /></div>
                  	</div> 
                  		<div class="row">
                    	<div class="col-lg-5 col-md-4 label">New Password <font color="red">*</font></div>
                    	<div class="col-lg-7 col-md-8"><html:password property="frmRegPassword"></html:password></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegPassword" /></div>
                  	</div>
                  	
                  	<div class="row">
                    	<div class="col-lg-5 col-md-4 label">Confirm New Password <font color="red">*</font></div>
                    	<div class="col-lg-7 col-md-8"><html:password property="frmRegConfPassword"></html:password></div>
                    	<div class="col-lg-12 text-danger"><html:errors property="frmRegConfPassword" />
                    	<html:errors property="passwordError" /></div>
                  	</div>
                  	
                  	
                  	<div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnChangePassword" value="Change Password"></html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
                    	</div>
                    </div>
                  	
		</logic:empty>	
			  
		<!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="ChangePasswordFormBean">
			<h5 class="card-title">Confirmation</h5>
                
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <h4 class="alert-heading">Will you Change Your Password?</h4>
                <p>Please remember your password & you need to login with this new password for next time.</p>
              </div>
                
                <div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnSavePassword" value="Save New Password"></html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
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