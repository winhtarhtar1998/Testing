<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
      <h1>Tutor Details</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">My Tutors</li>
          <li class="breadcrumb-item">Tutor Details</li>
        </ol>
      </nav><!-- End Page Title -->
  	</div>
  	 <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
			
              <img src="images/tut_${MyTutorsFormBean.frmFindTutorDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
              <h2>Tr. ${MyTutorsFormBean.frmFindTutorDetails.tutorName}</h2>
              <h3 class="pt-2">${MyTutorsFormBean.frmFindTutorDetails.tutorType}</h3>
              <h4 class="small font-bold">${MyTutorsFormBean.frmFindTutorDetails.gender}</h4>
              <h5 class="card-title pb-0">About</h5>
              <p class="small fst-italic">${MyTutorsFormBean.frmFindTutorDetails.about}</p>
            </div>
          </div>

        </div>
		<div class="col-xl-8">
		<div class="card">
			<div class="card-body pt-3 fade show active profile-overview">
				<h5 class="card-title">Education</h5>
				 <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Highest Degree</div>
                    <div class="col-lg-9 col-md-8">
                    	${MyTutorsFormBean.frmFindTutorDetails.highestDegree} in
 						(${MyTutorsFormBean.frmFindTutorDetails.specialization})
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Other Degree(s)</div>
                    <div class="col-lg-9 col-md-8">${MyTutorsFormBean.frmFindTutorDetails.moreDegrees}</div>
                  </div>
                  
                 <h5 class="card-title">Contact Information</h5> 
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${MyTutorsFormBean.frmFindTutorDetails.tutorEmail}</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${MyTutorsFormBean.frmFindTutorDetails.tutorAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone No.</div>
                    <div class="col-lg-9 col-md-8">${MyTutorsFormBean.frmFindTutorDetails.tutorPhoneNo}</div>
                  </div>
				
			</div>
			</div>
		</div>
      </div>
    </section>
  	<section>
  		<div class="col-12">
          <p class="small mb-0">Back to <a href="myTutorsPath.do?frmControlMyTutors=0">My Tutors</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>