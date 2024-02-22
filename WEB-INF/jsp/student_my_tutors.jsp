<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
 <style type="text/css">
 .achievements-wrapper { 
 	height: 75vh; 
 	overflow: auto;
 }
 </style>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
      <h1>My Tutors</h1>
  	<nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">My Tutors</li>
        </ol>
      </nav>
 	</div>
  	<!-- Requested Tutors Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Requested Tutors List</h4>
              
              <div class="span3 achievements-wrapper">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                     <th scope="col">Tutor</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Class Info:</th>
                    <th scope="col">Request Date</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${MyTutorsFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${MyTutorsFormBean.begin}"
						end="${MyTutorsFormBean.end}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/tut_${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.tutor.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">Tr. ${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.tutor.tutorName}</font><br>
                       				<small class="p-2">${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.tutor.tutorType}</small><br>
                        			 <a class="p-2" href="myTutorsPath.do?frmControlMyTutors=1&frmFindTutorDetailsId=${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.tutor.id}">Tutor Details <i class="bi  bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
                        	<td>
                        	
                        		<b>${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.subject.subjectName}</b><br>
                        		   ${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.fee} $ </td>
                        	<td>${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.teachingType}<br>
							    ${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.periodPerWeek} periods <br>
							    <a href="myTutorsPath.do?frmControlMyTutors=2&frmDetailTeachId=${MyTutorsFormBean.frmRequestedTutorsList[i-1].teach.id}"> More Info: <i class="bi bi-arrow-up-right-square"></i></a>
							</td>
							<td>
								${MyTutorsFormBean.frmRequestedTutorsList[i-1].requestDate}
							</td>
                        	<td><a href="myTutorsPath.do?frmControlMyTutors=3&frmRequestTeachId=${MyTutorsFormBean.frmRequestedTutorsList[i-1].id}" onclick="return confirm('Are you sure to Cancel Request?')"><font color="red"> Request Cancel <i class="bi bi-x-circle"></i></font></a></td>
						</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${MyTutorsFormBean.begin==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">There is no Requested Tutors.</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table Requested Tutors -->
			</div>
            </div>
          </div>

        </div>
      </div>
    </section>
  	
  	<!-- Connected Tutors Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Connected Tutors List</h4>
              
              <!-- Table with stripped rows -->
              <table class="table table-striped connectedTutors">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Tutor</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Class Info:</th>
                    <th scope="col">Connected Date</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${MyTutorsFormBean.beginConnected!=0}">
   					  <c:forEach var="i" begin="${MyTutorsFormBean.beginConnected}"
						end="${MyTutorsFormBean.endConnected}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/tut_${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.tutor.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">Tr. ${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.tutor.tutorName}</font><br>
                       				<small class="p-2">${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.tutor.tutorType} </small><br>
                        			 <a class="p-2" href="myTutorsPath.do?frmControlMyTutors=1&frmFindTutorDetailsId=${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.tutor.id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
                        	<td>
                        		<b>${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.subject.subjectName}</b><br>
                        		   ${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.fee} $ </td>
                        	<td>${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.teachingType}<br>
							    ${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.periodPerWeek} periods <br>
							    <a href="myTutorsPath.do?frmControlMyTutors=2&frmDetailTeachId=${MyTutorsFormBean.frmConnectedTutorsList[i-1].teach.id}"> More Info:  <i class="bi bi-arrow-up-right-square"></i></a>
							</td>
							<td>
								${MyTutorsFormBean.frmConnectedTutorsList[i-1].connectedDate}
							</td>
               			</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${MyTutorsFormBean.beginConnected==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">There is no Connected Tutors.</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table Connected Tutors -->

            </div>
          </div>

        </div>
      </div>
    </section>
    
    <!-- Completed Tutors Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Completed Tutors List</h4>
              
          <div class="span3 achievements-wrapper">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Tutor</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Class Info:</th>
                    <th scope="col">Connected Date</th>
                    <th scope="col">Completed Date</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${MyTutorsFormBean.beginCompleted!=0}">
   					  <c:forEach var="i" begin="${MyTutorsFormBean.beginCompleted}"
						end="${MyTutorsFormBean.endCompleted}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/tut_${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.tutor.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">Tr. ${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.tutor.tutorName}</font><br>
                       				<small class="p-2"> ${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.tutor.tutorType}</small><br>
                        			   <a class="p-2" href="myTutorsPath.do?frmControlMyTutors=1&frmFindTutorDetailsId=${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.tutor.id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
                        	<td>
                        		<b>${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.subject.subjectName}</b><br>
                        		   ${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.fee} $ </td>
                        	<td>${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.teachingType}<br>
							    ${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.periodPerWeek} periods <br>
							    <a href="myTutorsPath.do?frmControlMyTutors=2&frmDetailTeachId=${MyTutorsFormBean.frmCompletedTutorsList[i-1].teach.id}"> More Info: <i class="bi bi-arrow-up-right-square"></i> </a>
							</td>
							<td>
								${MyTutorsFormBean.frmCompletedTutorsList[i-1].connectedDate}
							</td>
							<td>
								${MyTutorsFormBean.frmCompletedTutorsList[i-1].completedDate}
							</td>
               			</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${MyTutorsFormBean.beginCompleted==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">There is no Completed Tutors.</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table Completed Tutors -->
		</div>
            </div>
          </div>

        </div>
      </div>
    </section>
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>