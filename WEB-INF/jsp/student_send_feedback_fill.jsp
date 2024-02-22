<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Send Feedback - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
   <div class="pagetitle">
      <h1>Fill & Send</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Send Feedback</li>
          <li class="breadcrumb-item">Fill & Send</li>
        </ol>
      </nav><!-- End Page Title -->
     </div>
  	<section class="section profile">
  		<div class="card m-4">
  			<div class="card-header text-center">Send Feedback to Your Tutor!</div>
  			<div class="card-body">
  			<html:form action="/sendFeedbackFillPath">
  			 <logic:empty property="frmRegFormControl" name="SendFeedbackFormBean">
  				<div class="row">
  					<div class="col-lg-4 profile mt-4">
  						<div class="card">
           				 <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
			
              			<img src="images/tut_${SendFeedbackFormBean.frmRequest.teach.tutor.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
             			<h2>Tr. ${SendFeedbackFormBean.frmRequest.teach.tutor.tutorName}</h2>
            			  <h3 class="pt-2">${SendFeedbackFormBean.frmRequest.teach.tutor.tutorType}</h3>
              			 <h4 class="small font-bold">${SendFeedbackFormBean.frmRequest.teach.tutor.gender}</h4>
             			 <h5 class="card-title pb-0">About</h5>
             				 <p class="small fst-italic">- ${SendFeedbackFormBean.frmRequest.teach.tutor.about}</p>
           			 	</div>
          			 </div>
  					</div>
  				<div class="col-lg-8">
  				 <div class="card-body pt-3 fade show active profile-overview">
                 <h5 class="card-title">Class Information</h5> 
                 
                  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Subject</div>
                    <div class="col-lg-8 col-md-8  fw-bold">${SendFeedbackFormBean.frmRequest.teach.subject.subjectName}</div>
                  </div>
                  
                  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Teaching Type</div>
                    <div class="col-lg-8 col-md-8">${SendFeedbackFormBean.frmRequest.teach.teachingType}</div>
                  </div>
                 
               		<div class="row">
                    <div class="col-lg-4 col-md-4 label">Your Feedback</div>
                    <div class="col-lg-8 col-md-8">
                    	<html:textarea property="frmFeedbackArea" rows="3" cols="30"></html:textarea>
                    </div>
                    <div class="col-lg-12"><font class="text-danger"><html:errors property="frmFeedbackArea" /></font></div>
               	  </div>
               	  <div class="row">
                    <div class="col-lg-4 col-md-4 label">Set Rating Point<br>
                    <small class="text-secondary">(This help your tutor can reach top position of tutor list)</small></div>
                    <div class="col-lg-8 col-md-8">
                   		<span class="p-1"><html:radio property="frmRatingPoint" value="0"><span class="p-1 fw-bold"> 0 </span></html:radio> </span>
                    	<span class="p-1"><html:radio property="frmRatingPoint" value="1"><span class="p-1 fw-bold"> 1 </span></html:radio> </span>
						<span class="p-1"><html:radio property="frmRatingPoint" value="2"><span class="p-1 fw-bold"> 2 </span></html:radio> </span>
						<span class="p-1"><html:radio property="frmRatingPoint" value="3"><span class="p-1 fw-bold"> 3 </span></html:radio> </span>
						<span class="p-1"><html:radio property="frmRatingPoint" value="4"><span class="p-1 fw-bold"> 4 </span></html:radio> </span>
						<span class="p-1"><html:radio property="frmRatingPoint" value="5"><span class="p-1 fw-bold"> 5 </span></html:radio> </span>
						
					</div>
                  </div>
               	  <div class="row">
                     <div class="col-lg-12 ">
                    	<html:submit property="btnSendFeedback" value="Send Feedback"></html:submit>
                    </div>
              		 </div>
			</div>
  			</div>
  		   </div>
  		   </logic:empty>
  		   <!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="SendFeedbackFormBean">
				<h5 class="text-center pt-4 pb-0 fs-4"><b>Your Feedback is Sent!</b></h5>
			</logic:notEmpty>
  		   </html:form>
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