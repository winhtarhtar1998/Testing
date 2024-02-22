<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
 
 <style type="text/css">
 .achievements-wrapper { 
 	height: 80vh; 
 	overflow: auto;
 }
 </style>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
      <h1>Send Feedback</h1>
  	<nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Send Feedback</li>
        </ol>
      </nav>
 </div>
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
                    <th scope="col">Completed Date</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${SendFeedbackFormBean.beginCompleted!=0}">
   					  <c:forEach var="i" begin="${SendFeedbackFormBean.beginCompleted}"
						end="${SendFeedbackFormBean.endCompleted}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/tut_${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.tutor.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">Tr. ${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.tutor.tutorName}</font><br>
                       				<small class="p-2">${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.tutor.tutorType} </small><br>
                        			  <a href="sendFeedbackPath.do?frmControlMyTutors=1&frmFindTutorDetailsId=${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.tutor.id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
                        	<td>
                        		<b>${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.subject.subjectName}</b><br>
                        		   ${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.fee} $ </td>
                        	<td>${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.teachingType}<br>
							    ${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.periodPerWeek} periods <br>
							    <a href="sendFeedbackPath.do?frmControlMyTutors=2&frmDetailTeachId=${SendFeedbackFormBean.frmCompletedTutorsList[i-1].teach.id}"> More Info: <i class="bi bi-arrow-up-right-square"></i></a>
							</td>
							<td>
								${SendFeedbackFormBean.frmCompletedTutorsList[i-1].completedDate}
							</td>
							<td>
								<a href="sendFeedbackFillPathFirst.do?frmRequestTeachId=${SendFeedbackFormBean.frmCompletedTutorsList[i-1].id}"> Send Feedback <i class="bi bi-send"></i> </a>
							</td>
               			</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${SendFeedbackFormBean.beginCompleted==0}">
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