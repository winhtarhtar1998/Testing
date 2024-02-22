<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Review Feedback - Tutor</title>
 <%@ include file="inc/head.jsp"%>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <style>
 .feedback-box{
 	height: 75vh; 
 	overflow: auto;
 }
 .blockquote{
 font-size: 13pt;
 color:#2F2130;
 }
 
 .quote-mark{
 	font-size:12pt;
 }
 </style>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  	<div class="pagetitle">
      <h1>Review Feedback</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Review Feedback</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
 	
 	<section class="section dashboard">
      <div class="row d-flex align-items-center justify-content-center">
      <div class="col-8">
  	<!-- Review Feedback Session -->
  	 <div class="card top-selling feedback-box">
            <div class="filter">
              <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                <li class="dropdown-header text-start">
                  <h6>Filter By Subject</h6>
                </li>
                <li><a class="dropdown-item" href="reviewFeedbackPath.do?frmFormControlMyStudents=0">All Subjects</a></li>
				<c:if test="${ReviewFeedbackFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${ReviewFeedbackFormBean.begin}"
						end="${ReviewFeedbackFormBean.end}" step="1">
							<li><a class="dropdown-item" href="reviewFeedbackPath.do?frmFormControlMyStudents=1&frmSubjectName=${ReviewFeedbackFormBean.myTeachList[i-1].subject.subjectName}">${ReviewFeedbackFormBean.myTeachList[i-1].subject.subjectName}</a></li>
					 </c:forEach>
				</c:if>
				<c:if test="${ReviewFeedbackFormBean.begin==0}">
    					<li><a class="dropdown-item" href="#">There is no Subject You Teach</a></li>
				</c:if>
              </ul>
            </div>

            <div class="card-body pb-0">
              <h5 class="card-title">Student Feedback <span>| ${ReviewFeedbackFormBean.frmSubjectName}</span></h5>

             <table class="table">
                    <tbody>
                    <c:if test="${ReviewFeedbackFormBean.beginCompleted!=0}">
   					  <c:forEach var="i" begin="${ReviewFeedbackFormBean.beginCompleted}"
						end="${ReviewFeedbackFormBean.endCompleted}" step="1">
                      	<tr>
                      		<td scope="row">${i}</td>
                        	<td><blockquote class="blockquote text-small"><i class="fa-solid fa-quote-left quote-mark px-2"></i>
                        	<cite>${ReviewFeedbackFormBean.frmCompletedList[i-1].feedback}</cite><i class="fa-solid fa-quote-right quote-mark px-2"></i>
                        	</blockquote></td>
                        	<td><b>${ReviewFeedbackFormBean.frmCompletedList[i-1].teach.subject.subjectName}</b><br>
                        		${ReviewFeedbackFormBean.frmCompletedList[i-1].teach.teachingType}
                        	</td>
                         	<td align="center"><img class= "rounded-circle" src="images/stu_${ReviewFeedbackFormBean.frmCompletedList[i-1].student.id}?time=<%=System.currentTimeMillis()%>" alt=""><br>
                         		<b>${ReviewFeedbackFormBean.frmCompletedList[i-1].student.studentName}</b><br>
                         	 	<small>${ReviewFeedbackFormBean.frmCompletedList[i-1].student.grade}</small>
                         	</td>
                     	 </tr>
                      </c:forEach>
					</c:if>
					<c:if test="${ReviewFeedbackFormBean.beginCompleted==0}">
    					<tr>
    						<td colspan="4">There is no <b>Feedback</b> for this <b>Subject</b></td>
						</tr>
				</c:if>
                   </tbody>
                  </table>
              </div><!-- End sidebar recent posts-->

            </div>
          </div><!-- End Rewiew Feedback Session -->
  	</div>
  	</div>
  	</section>
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>