<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Top 10 Tutors - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>Tutors' Details</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Tutor Home</li>
          <li class="breadcrumb-item">Tutors' Details</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	 <section class="section profile">
      <div class="row m-4 mb-0">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
			
              <img src="images/tut_${TutorFormBean.frmTopTutorsDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
              <h2>Tr. ${TutorFormBean.frmTopTutorsDetails.tutorName}</h2>
              <h3 class="pt-2">${TutorFormBean.frmTopTutorsDetails.tutorType}</h3>
              <h4 class="small font-bold">${TutorFormBean.frmTopTutorsDetails.gender}</h4>
              <h5 class="card-title pb-0">About</h5>
              <p class="small fst-italic">${TutorFormBean.frmTopTutorsDetails.about}</p>
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
                    	${TutorFormBean.frmTopTutorsDetails.highestDegree} in
 						(${TutorFormBean.frmTopTutorsDetails.specialization})
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Other Degree(s)</div>
                    <div class="col-lg-9 col-md-8">${TutorFormBean.frmTopTutorsDetails.moreDegrees}</div>
                  </div>
                  
                 <h5 class="card-title">Contact Information</h5> 
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${TutorFormBean.frmTopTutorsDetails.tutorEmail}</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${TutorFormBean.frmTopTutorsDetails.tutorAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone No.</div>
                    <div class="col-lg-9 col-md-8">${TutorFormBean.frmTopTutorsDetails.tutorPhoneNo}</div>
                  </div>
				
			</div>
			</div>
		</div>
      </div>
      <div class="row m-4">
      	<div class="col-xl-12">
          <div class="card p-4">
            <div class="card-body">
              <h5 class="card-title">List of Subject(s) taught by Tr. ${TutorFormBean.frmTopTutorsDetails.tutorName}</h5>
              <!-- Small tables ~ Subject list-->
              <table class="table table-sm">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Subject</th>
                    <th scope="col">Fee</th>
                    <th scope="col"> Teaching Type</th>
                    <th scope="col">Periods/ Week</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${TutorFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${TutorFormBean.begin}"
						end="${TutorFormBean.end}" step="1">
                  <tr>
                  	<td>${i}</td>
                    <th scope="row"><b>${TutorFormBean.myTeachList[i-1].subject.subjectName}</b></th>
                    <td>${TutorFormBean.myTeachList[i-1].fee} $</td>
					<td>${TutorFormBean.myTeachList[i-1].teachingType}</td>
                    <td>${TutorFormBean.myTeachList[i-1].periodPerWeek} periods</td>
                  </tr>
                  </c:forEach>
				</c:if>
				<c:if test="${TutorFormBean.begin==0}">
    			   <tr>
    				<th colspan="5"><h4 align="center">There is no Subjects List he/she teach!!</h4></th>
    			   </tr>
				</c:if>
                </tbody>
              </table>
              <!-- End small tables ~ Subject list-->

            </div>
          </div>

        </div>
      </div>
    </section>
  	<section>
  		<div class="col-12">
          <p class="small mb-0">Back to <a href="tutorHomePath.do?frmControl=0">Home</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>