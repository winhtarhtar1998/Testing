<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Students - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
  <h1>Class Details</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">My Students</li>
          <li class="breadcrumb-item">Class Details</li>
        </ol>
      </nav><!-- End Page Title -->
  	</div>
  	 <section class="section profile">
      <div class="row">
      <div class="col-xl-8">
		<div class="card">
			<div class="card-body pt-3 fade show active profile-overview">
                 <h5 class="card-title">Class Information</h5> 
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Subject</div>
                    <div class="col-lg-9 col-md-8">${MyStudentsFormBean.frmRequestTeach.subject.subjectName}</div>
                  </div>
                  
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Teaching Type</div>
                    <div class="col-lg-9 col-md-8">${MyStudentsFormBean.frmRequestTeach.teachingType}</div>
                  </div>
                  
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Periods per Week</div>
                    <div class="col-lg-9 col-md-8">${MyStudentsFormBean.frmRequestTeach.periodPerWeek} periods</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Preferable Time & Days</div>
                    <div class="col-lg-9 col-md-8">${MyStudentsFormBean.frmRequestTeach.preferableTime} <br>
                    <div class="col-lg-9 col-md-8">${MyStudentsFormBean.frmRequestTeach.preferableDays}
                    </div>
  				</div>			
			</div>
			</div>
		</div>
      </div>
      </div>
    </section>
  	<section>
  		<div class="col-12">
          <p class="small mb-0">Back to <a href="myStudentsPath.do?frmFormControlMyStudents=0">My Students</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>