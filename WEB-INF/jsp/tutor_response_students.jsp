<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Response Students - Tutor</title>
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
  <h1>Response Students</h1>
  	<nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Response Students</li>
        </ol>
      </nav>
  	</div>
  	<!-- Requested Students Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Requested Students List</h5>
              
              <div class="span3 achievements-wrapper">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Student</th>
                    <th scope="col">Subject & Class Info:</th>
                    <th scope="col">Extra Message</th>
                    <th scope="col">Request Date</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${ResponseStudentFormBean.beginRequested!=0}">
   					  <c:forEach var="i" begin="${ResponseStudentFormBean.beginRequested}"
						end="${ResponseStudentFormBean.endRequested}" step="1">
						<tr>
							<th scope="row">${i}</th>
							<td>
							<table><tr>
							<td align="right"><img class= "img-thumbnail" src="images/stu_${ResponseStudentFormBean.frmRequestList[i-1].student.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold p-2">${ResponseStudentFormBean.frmRequestList[i-1].student.studentName}</font><br>
                       				<small class="p-2">${ResponseStudentFormBean.frmRequestList[i-1].student.grade}</small><br>
                        			 <a  class="p-2" href="responseStudentsPath.do?frmFormControlResponse=1&frmStudentDetailsId=${ResponseStudentFormBean.frmRequestList[i-1].student.id}">Student Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	</tr>
                        	</table>
                        	</td>
							
                        	<td>
                        		<b>${ResponseStudentFormBean.frmRequestList[i-1].teach.subject.subjectName}</b><br>
                        		   ${ResponseStudentFormBean.frmRequestList[i-1].teach.fee} $ <br>
                        		   ${ResponseStudentFormBean.frmRequestList[i-1].teach.teachingType}<br>
                        		   <a href="responseStudentsPath.do?frmFormControlResponse=2&frmRequestTeachId=${ResponseStudentFormBean.frmRequestList[i-1].teach.id}">More Info: <i class="bi bi-arrow-up-right-square"></i></a>
                            </td>
                        	<td>
                        	<cite>
                        		${ResponseStudentFormBean.frmRequestList[i-1].extraRequestMessage}
                        	</cite>
                        	</td>
                        	<td>${ResponseStudentFormBean.frmRequestList[i-1].requestDate}</td>
                        	<td><a href="responseStudentsPath.do?frmFormControlResponse=3&frmRequestId=${ResponseStudentFormBean.frmRequestList[i-1].id}" onclick="return confirm('Are you sure to Connect?')"> Connect Now <i class="bi bi-check-circle"></i></a> <br><br>
                        		<a href="responseStudentsPath.do?frmFormControlResponse=31&frmRequestId=${ResponseStudentFormBean.frmRequestList[i-1].id}" onclick="return confirm('Are you sure to Cancel Request?')"><font color="red">Cancel Request <i class="bi bi-x-circle"></i></font> </a></td>
						</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${ResponseStudentFormBean.beginRequested==0}">
    					<tr>
    						<th colspan="9"><h4 align="center">No Requested Students.</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table with stripped rows -->
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