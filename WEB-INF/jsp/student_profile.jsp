<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Profile - Student</title>
 <%@ include file="inc/head.jsp"%>
 
 <style>
 	.profile-tab{
 	 background-color:#C3A9C7 !important;
 	}
 </style>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>My Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Profile Overview</li>
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
                  <a class="nav-link profile-tab active" href="myProfilePath.do">Overview</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="StuUpdatePathFirst.do">Edit Profile</a>
                </li>
                 <li class="nav-item ">
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

             		 <img src="images/stu_${StuMyProfileBean.frmStudentDetails.id}?time=<%=System.currentTimeMillis()%>" alt="No Photo" class="rounded-circle">
             		 <h2>${StuMyProfileBean.frmStudentDetails.studentName}</h2>
             		 <h3 class="pt-2">${StuMyProfileBean.frmStudentDetails.grade}</h3>
             		 <h4 class="small font-bold">${StuMyProfileBean.frmStudentDetails.gender}</h4>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				                  
                	<h5 class="card-title">Contact Information</h5> 
				  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Email</div>
                    	<div class="col-lg-9 col-md-8">${StuMyProfileBean.frmStudentDetails.studentEmail}</div>
                  	</div>
                 
                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Address</div>
                    	<div class="col-lg-9 col-md-8">${StuMyProfileBean.frmStudentDetails.studentAddress}</div>
                 	</div>

                  	<div class="row">
                    	<div class="col-lg-3 col-md-4 label">Phone No.</div>
                    	<div class="col-lg-9 col-md-8">${StuMyProfileBean.frmStudentDetails.studentPhoneNo}</div>
                  	</div>
				
			     </div>
       		 </div>
       	    </div> 
           </div>
          </div><!-- End Special title treatmen -->
        </div>
       </div>
       
    </section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>