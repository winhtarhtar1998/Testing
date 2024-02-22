<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Delete Account - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>Delete Account</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Profile Overview</li>
          <li class="breadcrumb-item active">Delete Account</li>
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
                  <a class="nav-link" href="StuUpdatePathFirst.do">Edit Profile</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="StuChangePasswordPathFirst.do">Change Password</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link profile-tab active" href="StuDeleteProfilePathFirst.do"><font color="red">Delete Account</font></a>
                </li>
              </ul>
            </div>
            <div class="card-body">
            	<div class="row">
       			 <div class="col-xl-4">
       			 	 <div class="card m-4">
            		 <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

             		 <img src="images/stu_${StuDeleteFormBean.frmStudentDetails.id}?time=<%=System.currentTimeMillis()%>" alt="No Photo" class="rounded-circle">
             		 <h2>${StuDeleteFormBean.frmStudentDetails.studentName}</h2>
             		 <h3 class="pt-2">${StuDeleteFormBean.frmStudentDetails.grade}</h3>
             		 <h4 class="small font-bold">${StuDeleteFormBean.frmStudentDetails.gender}</h4>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				<html:form action="/StuDeleteProfilePath">
				<logic:empty property="frmRegFormControl" name="StuDeleteFormBean">
				
				<h5 class="card-title">Delete Student Account</h5>	
					
					<div class="row">
                    	<div class="col-lg-5 col-md-4 label">Confirm Your Password <font color="red">*</font></div>
                    	<div class="col-lg-7 col-md-8"><html:password property="frmCurrentPassword"></html:password></div>
                    	<div class="col-lg-12">
                    		<html:errors property="frmCurrentPassword" />
							<html:errors property="currentPasswordError" /></div>                 	
                  	</div>
                  	<div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnConfirmPassword" value="Confirm"></html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
                    	</div>
                    </div>
                  	
		</logic:empty>	
			  
		<!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="StuDeleteFormBean">
			<h5 class="card-title">Confirmation</h5>
                
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <h4 class="alert-heading">Will you Delete Your Account?</h4>
                <p><i class="bi bi-exclamation-triangle me-1"></i>
                Please notice that all of your connected information will be permanently deleted.</p>
               <p><i class="bi bi-exclamation-triangle me-1"></i> 
               And it won't be recovered after you had deleted your Student Account!</p>
              </div>
                
                <div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnDeleteAccount" value="Delete Account"></html:submit></span>
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