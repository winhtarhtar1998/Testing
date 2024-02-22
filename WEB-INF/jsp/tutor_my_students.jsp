<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Students - Tutor</title>
 <%@ include file="inc/head.jsp"%>
 <style type="text/css">
 .achievements-wrapper { 
 	height: 75vh; 
 	overflow: auto;
 }
 </style>
 
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
  <h1>My Students</h1>
  	<nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">My Students</li>
        </ol>
      </nav>
 </div>
  	<!-- Connected Students Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Connected Students List</h4>
              
             <div class="span3 achievements-wrapper">
              <table class="table table-striped ">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Student</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Class Info:</th>
                    <th scope="col">Connected Date</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${MyStudentsFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${MyStudentsFormBean.begin}"
						end="${MyStudentsFormBean.end}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/stu_${MyStudentsFormBean.frmConnectedList[i-1].student.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">${MyStudentsFormBean.frmConnectedList[i-1].student.studentName}</font><br>
                       				<small class="p-2">${MyStudentsFormBean.frmConnectedList[i-1].student.grade}</small><br>
                        			 <a class="p-2" class="p-2" href="myStudentsPath.do?frmFormControlMyStudents=1&frmStudentDetailsId=${MyStudentsFormBean.frmConnectedList[i-1].student.id}">Student Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
							
                        	<td>
                        		<b>${MyStudentsFormBean.frmConnectedList[i-1].teach.subject.subjectName}</b><br>
                        		   ${MyStudentsFormBean.frmConnectedList[i-1].teach.fee} $ </td>
                        	<td>${MyStudentsFormBean.frmConnectedList[i-1].teach.teachingType}<br>
							    ${MyStudentsFormBean.frmConnectedList[i-1].teach.periodPerWeek} periods <br>
							    <a href="myStudentsPath.do?frmFormControlMyStudents=2&frmRequestTeachId=${MyStudentsFormBean.frmConnectedList[i-1].teach.id}"> More Info: <i class="bi bi-arrow-up-right-square"></i></a>
							</td>
							<td>
								${MyStudentsFormBean.frmConnectedList[i-1].connectedDate}
							</td>
                        	<td><a href="myStudentsPath.do?frmFormControlMyStudents=3&frmRequestId=${MyStudentsFormBean.frmConnectedList[i-1].id}" onclick="return confirm('Are you sure to set as Completed Sutdent?')"><font color="green"> Change Completed <i class="bi bi-check-circle"></i></font></a></td>
						</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${MyStudentsFormBean.begin==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">There is no Connected Students.</h4></th>
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
  	    
    <!-- Completed Student Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Completed Students List</h4>
              
              <table class="table datatable table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Student</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Class Info:</th>
                    <th scope="col">Connected Date</th>
                    <th scope="col">Completed Date</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${MyStudentsFormBean.beginCompleted!=0}">
   					  <c:forEach var="i" begin="${MyStudentsFormBean.beginCompleted}"
						end="${MyStudentsFormBean.endCompleted}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/stu_${MyStudentsFormBean.frmCompletedList[i-1].student.id}" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">${MyStudentsFormBean.frmCompletedList[i-1].student.studentName}</font><br>
                       				<small class="p-2">${MyStudentsFormBean.frmCompletedList[i-1].student.grade}</small><br>
                        			 <a class="p-2" href="myStudentsPath.do?frmFormControlMyStudents=1&frmStudentDetailsId=${MyStudentsFormBean.frmCompletedList[i-1].student.id}">Student Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
							
                        	<td>
                        		<b>${MyStudentsFormBean.frmCompletedList[i-1].teach.subject.subjectName}</b><br>
                        		   ${MyStudentsFormBean.frmCompletedList[i-1].teach.fee} $ </td>
                        	<td>${MyStudentsFormBean.frmCompletedList[i-1].teach.teachingType}<br>
							    ${MyStudentsFormBean.frmCompletedList[i-1].teach.periodPerWeek} periods <br>
							    <a href="myStudentsPath.do?frmFormControlMyStudents=2&frmRequestTeachId=${MyStudentsFormBean.frmCompletedList[i-1].teach.id}"> More Info: <i class="bi bi-arrow-up-right-square"></i></a>
							</td>
							<td>
								${MyStudentsFormBean.frmCompletedList[i-1].connectedDate}
							</td>
							<td>
								${MyStudentsFormBean.frmCompletedList[i-1].completedDate}
							</td>
               			</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${MyStudentsFormBean.beginCompleted==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">There is no Completed Students.</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table Completed Tutors -->
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