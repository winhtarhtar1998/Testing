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
      <h1>Class Details</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Send Feedback</li>
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
                    <div class="col-lg-9 col-md-8">${SendFeedbackFormBean.frmDetailTeach.subject.subjectName}</div>
                  </div>
                  
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Teaching Type</div>
                    <div class="col-lg-9 col-md-8">${SendFeedbackFormBean.frmDetailTeach.teachingType}</div>
                  </div>
                                    
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Periods per Week</div>
                    <div class="col-lg-9 col-md-8">${SendFeedbackFormBean.frmDetailTeach.periodPerWeek} periods</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Preferable Time & Days</div>
                    <div class="col-lg-9 col-md-8">${SendFeedbackFormBean.frmDetailTeach.preferableTime} <br>
                    <div class="col-lg-9 col-md-8">${SendFeedbackFormBean.frmDetailTeach.preferableDays}
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
          <p class="small mb-0">Back to <a href="sendFeedbackPath.do?frmControlMyTutors=0">Send Feedback</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>