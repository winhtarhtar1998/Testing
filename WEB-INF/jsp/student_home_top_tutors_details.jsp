<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Top Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  	  <div class="pagetitle">
      <h1>Tutors' Details</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Student Home</li>
          <li class="breadcrumb-item">Tutors' Details</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	 <section class="section profile">
      <div class="row m-4 mb-0">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
			
              <img src="images/tut_${StudentFormBean.frmTopTutorsDetails.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
              <h2>Tr. ${StudentFormBean.frmTopTutorsDetails.tutorName}</h2>
              <h3 class="pt-2">${StudentFormBean.frmTopTutorsDetails.tutorType}</h3>
              <h4 class="small font-bold">${StudentFormBean.frmTopTutorsDetails.gender}</h4>
              <h5 class="card-title pb-0">About</h5>
              <p class="small fst-italic">${StudentFormBean.frmTopTutorsDetails.about}</p>
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
                    	${StudentFormBean.frmTopTutorsDetails.highestDegree} in
 						(${StudentFormBean.frmTopTutorsDetails.specialization})
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Other Degree(s)</div>
                    <div class="col-lg-9 col-md-8">${StudentFormBean.frmTopTutorsDetails.moreDegrees}</div>
                  </div>
                  
                 <h5 class="card-title">Contact Information</h5> 
				  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${StudentFormBean.frmTopTutorsDetails.tutorEmail}</div>
                  </div>
                 
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${StudentFormBean.frmTopTutorsDetails.tutorAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone No.</div>
                    <div class="col-lg-9 col-md-8">${StudentFormBean.frmTopTutorsDetails.tutorPhoneNo}</div>
                  </div>
				
			</div>
			</div>
		</div>
      </div>
      <div class="row m-4">
      	<div class="col-xl-12">
          <div class="card p-4">
            <div class="card-body">
              <h5 class="card-title">List of Subject(s) taught by Tr. ${StudentFormBean.frmTopTutorsDetails.tutorName}</h5>
              <!-- Small tables ~ Subject list-->
              <table class="table table-sm">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Subject</th>
                    <th scope="col">Fee</th>
                    <th scope="col"> Teaching Type</th>
                    <th scope="col">Periods/ Week</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${StudentFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${StudentFormBean.begin}"
						end="${StudentFormBean.end}" step="1">
                  <tr>
                  	<td>${i}</td>
                    <th scope="row"><b>${StudentFormBean.frmMyTeachList[i-1].subject.subjectName}</b></th>
                    <td>${StudentFormBean.frmMyTeachList[i-1].fee} $</td>
					<td>${StudentFormBean.frmMyTeachList[i-1].teachingType}</td>
                    <td>${StudentFormBean.frmMyTeachList[i-1].periodPerWeek} periods</td>
                    <td>
                    	<c:if test="${StudentFormBean.frmRequestStatus[i-1] eq 'Requested'}">
                    		<span class="badge bg-secondary"><font class="fw-bold m-1">${StudentFormBean.frmRequestStatus[i-1]}</font></span>
                    	</c:if>
                    	<c:if test="${StudentFormBean.frmRequestStatus[i-1] eq 'Connected'}">
                    		<span class="badge bg-secondary"><font class="fw-bold m-1">${StudentFormBean.frmRequestStatus[i-1]}</font></span>
                    	</c:if>
                    	<c:if test="${StudentFormBean.frmRequestStatus[i-1] eq 'Request Now'}">
                    		<a href="stuHomePath.do?frmControl=2&frmRequestTeachId=${StudentFormBean.frmMyTeachList[i-1].id}">${StudentFormBean.frmRequestStatus[i-1]} <i class="bi bi-arrow-up-right-square"></i></a></a>
                    	</c:if>
                    	</td>
                  </tr>
                  </c:forEach>
				</c:if>
				<c:if test="${StudentFormBean.begin==0}">
    			   <tr>
    				<th colspan="6"><h4 align="center">There is no Subjects List he/she teach!!</h4></th>
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
          <p class="small mb-0">Back to <a href="stuHomePath.do?frmControl=0">Home</a></p>
        </div>
  	</section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>