<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Delete Account - Tutor</title>
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
                  <a class="nav-link profile-tab  active" href="StuDeleteProfilePathFirst.do"><font color="red">Delete Account</font></a>
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
				<h5 class="card-title text-danger">Cannot Delete Your Student Account</h5>	
                
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <h4 class="alert-heading">You can't delete your account at this time!</h4>
                <p><i class="bi bi-exclamation-triangle me-1"></i>Your Student Account still had connected <span class="fw-bold">( ${StuDeleteFormBean.frmNumConnectedTutors} )</span> 
                	tutors at this time, and tutors still need your contact information.</p>
                <p><i class="bi bi-exclamation-triangle me-1"></i>You can delete your account only when you haven't connected with any tutors.</p>
              </div>
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