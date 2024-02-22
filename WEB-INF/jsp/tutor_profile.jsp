<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Profile - Student</title>
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
                  <a class="nav-link profile-tab active" href="tutorProfilePath.do">Overview</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="updatePathFirst.do">Edit Profile</a>
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

             		 <img src="images/tut_${MyProfileBean.frmTutorDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
             		 <h2>Tr. ${MyProfileBean.frmTutorDetails.tutorName}</h2>
              		 <h3 class="pt-2">${MyProfileBean.frmTutorDetails.tutorType}</h3>
              		 <h4 class="small font-bold">${MyProfileBean.frmTutorDetails.gender}</h4>
                     <h5 class="card-title pb-0">About</h5>
                     <p class="small fst-italic">- ${MyProfileBean.frmTutorDetails.about}</p>
            		</div>
         			</div>
       			 	
       		    </div>
       		   <div class="col-xl-8">
       			 	<div class="card-body pt-3 fade show active profile-overview">
				                  
                	<h5 class="card-title">Education</h5>
				 <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Highest Degree</div>
                    <div class="col-lg-9 col-md-8">
                    	${MyProfileBean.frmTutorDetails.highestDegree} in
 						(${MyProfileBean.frmTutorDetails.specialization})
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Other Degree(s)</div>
                    <div class="col-lg-9 col-md-8">${MyProfileBean.frmTutorDetails.moreDegrees}</div>
                  </div>
                  
                 <h5 class="card-title">Contact Information</h5> 
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${MyProfileBean.frmTutorDetails.tutorEmail}</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${MyProfileBean.frmTutorDetails.tutorAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone No.</div>
                    <div class="col-lg-9 col-md-8">${MyProfileBean.frmTutorDetails.tutorPhoneNo}</div>
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