<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Find Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>Request Tutor</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Student Home</li>
          <li class="breadcrumb-item">Tutors' Details</li>
          <li class="breadcrumb-item">Request Tutor</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	<section class="section profile">
  		<div class="card m-4">
  			<div class="card-header text-center">Confirm Your Tutor Request!</div>
  			<div class="card-body">
  				<div class="row">
  					<div class="col-lg-4 profile mt-4">
  						<div class="card">
           				 <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
			
              			<img src="images/tut_${StudentFormBean.frmRequestTeach.tutor.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
             			<h2>Tr. ${StudentFormBean.frmRequestTeach.tutor.tutorName}</h2>
            			  <h3 class="pt-2">${StudentFormBean.frmRequestTeach.tutor.tutorType}</h3>
              			
              			<h5 class="card-title pb-0">Preferable Time & Days</h5>
              				<div class="text-center">
                    			${StudentFormBean.frmRequestTeach.preferableTime} <br>
                    	 		${StudentFormBean.frmRequestTeach.preferableDays}
                   			 </div>
           			 	</div>
          			 </div>
  					</div>
  				<div class="col-lg-8">
  				 <div class="card-body pt-3 fade show active profile-overview">
                 <h5 class="card-title">Class Information</h5> 
                 
                  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Subject</div>
                    <div class="col-lg-8 col-md-8  fw-bold">${StudentFormBean.frmRequestTeach.subject.subjectName}</div>
                  </div>
                  
                  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Teaching Type</div>
                    <div class="col-lg-8 col-md-8">${StudentFormBean.frmRequestTeach.teachingType}</div>
                  </div>
                   <div class="row">
                    <div class="col-lg-4 col-md-4 label">Fee</div>
                    <div class="col-lg-8 col-md-8">${StudentFormBean.frmRequestTeach.fee} $</div>
               		</div>                
				  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Periods per Week</div>
                    <div class="col-lg-8 col-md-8">${FindTutorFormBean.frmRequestTeach.periodPerWeek} periods</div>
                  </div>
                  <html:form	action="/stuHomePath">
               		<div class="row">
                    <div class="col-lg-4 col-md-4 label">Extra Message for Request</div>
                    <div class="col-lg-8 col-md-8">
                    	<html:textarea property="frmExtraRequestMessage"></html:textarea>
                    </div>
               	  </div>
               	  <div class="row">
                    <div class="col-12">
                    	<html:submit property="btnRequestTutor" value="Request"></html:submit>
                    	<html:submit property="btnRequestCancel" value="Cancel"></html:submit>
                    </div>
              		 </div>
               	  </html:form>
			</div>
  			</div>
  		   </div>
  		</div>
  		</div>
  	
  	</section>
  	<section>
  		<div class="col-12">
          <p class="small mb-0">Back to <a class="p-2" href="stuHomePath.do?frmControl=1&frmTopTutorDetailsId=${StudentFormBean.frmRequestTeach.tutor.id}">Tutor Details</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>