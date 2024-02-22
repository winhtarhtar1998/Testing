<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Response Students - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
  <h1>Response Students</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Response Students</li>
          <li class="breadcrumb-item">Student Details</li>
        </ol>
      </nav><!-- End Page Title -->
  	</div>
  	 <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="images/stu_${ResponseStudentFormBean.frmStudentDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
              <h2>${ResponseStudentFormBean.frmStudentDetails.studentName}</h2>
              <h3 class="pt-2">${ResponseStudentFormBean.frmStudentDetails.grade}</h3>
              <h4 class="small font-bold">${ResponseStudentFormBean.frmStudentDetails.gender}</h4>
            </div>
          </div>

        </div>
		<div class="col-xl-8">
		<div class="card">
			<div class="card-body pt-3 fade show active profile-overview">
                 <h5 class="card-title">Contact Information</h5> 
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${ResponseStudentFormBean.frmStudentDetails.studentEmail}</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${ResponseStudentFormBean.frmStudentDetails.studentAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone No.</div>
                    <div class="col-lg-9 col-md-8">${ResponseStudentFormBean.frmStudentDetails.studentPhoneNo}</div>
                  </div>
				
			</div>
			</div>
		</div>
      </div>
    </section>
  	<section>
  		<div class="col-12">
          <p class="small mb-0">Back to <a href="responseStudentsPath.do?frmFormControlResponse=4">Response Students</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>