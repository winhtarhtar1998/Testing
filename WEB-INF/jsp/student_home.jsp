<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Home - Student</title>
 <%@ include file="inc/head.jsp"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 
 <style type="text/css">
 .achievements-wrapper { 
 	height: 80vh; 
 	overflow: auto;
 }
 
 .dashboard{
 margin-left:30px;
 margin-right:30px;
 }
 body{
 background-color: #F7F2F7;
 }
 </style>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
      <h1>Home</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Student Home</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	<section class="section dashboard mb-3">
  	<div class="row p-3 d-flex justify-content-center align-items-center">
  	<h3 class="text-center fw-bold pb-3">Connections With Your Tutors</h3>  	
  		<div class="col-lg-3 col-sm-12 m-2">
  		<!-- Requested Students Card -->
  		 <div class="card">
            <div class="card-header text-center fw-bold">Requested Tutors</div>
            <div class="card-body d-block justify-content-center">
                  <div class="d-flex justify-content-center align-items-center pt-3">
                    <div class="card-icon rounded-circle d-flex  align-items-center justify-content-center">
                      <i class="fa-solid fa-user-group text-danger"></i>
                    </div>
                  </div>
                  <div class="text-center">
                      <h1 class="text-primary fw-bold text-danger">${StudentFormBean.frmNumRequestTutors}</h1>
                      <span class="small pt-1 fw-bold">Tutors</span>
                    </div>
                </div>
            <div class="card-footer text-center">
              <a href="myTutorsPath.do?frmControlMyTutors=0" class="card-link">Go to Details <i class="bi bi-arrow-up-right-square"></i></a>
            </div>
          </div><!-- End Requested Tutors Card -->
  		</div>
  		<div class="col-lg-3 col-md-4 col-sm-12 m-2">
  		<!-- Connected Tutors Card -->
  		 <div class="card">
            <div class="card-header text-center fw-bold">Connected Tutors</div>
            <div class="card-body d-block justify-content-center">
                  <div class="d-flex justify-content-center align-items-center pt-3">
                    <div class="card-icon rounded-circle d-flex  align-items-center justify-content-center">
                      <i class="fa-solid fa-user-check text-success"></i>
                    </div>
                  </div>
                  <div class="text-center">
                      <h1 class="text-primary fw-bold text-success">${StudentFormBean.frmNumConnectedTutors}</h1>
                      <span class="small pt-1 fw-bold">Tutors</span>
                    </div>
                </div>
            <div class="card-footer text-center">
              <a href="myTutorsPath.do?frmControlMyTutors=0" class="card-link">Go to Details <i class="bi bi-arrow-up-right-square"></i></a>
            </div>
          </div><!-- End Connected Tutors Card -->
  		</div>
  		<div class="col-lg-3 col-md-4 col-sm-12 m-2">
  		 <!-- Completed Tutors Card -->
  		 <div class="card">
            <div class="card-header text-center fw-bold ">Completed Tutors</div>
            <div class="card-body d-block justify-content-center">
                  <div class="d-flex justify-content-center align-items-center pt-3">
                    <div class="card-icon rounded-circle d-flex  align-items-center justify-content-center">
                      
                      <i class="fa-solid fa-user-clock text-warning"></i>
                    </div>
                  </div>
                  <div class="text-center">
                      <h1 class="text-primary fw-bold text-warning">${StudentFormBean.frmNumCompletedTutors}</h1>
                      <span class="small pt-1 fw-bold">Tutors</span>
                    </div>
                </div>
            <div class="card-footer text-center">
              <a href="myTutorsPath.do?frmControlMyTutors=0" class="card-link">Go to Details <i class="bi bi-arrow-up-right-square"></i></a>
            </div>
          </div><!-- End Completed Tutors Card -->
  		</div>
  	</div>
  	</section>
  	
  	<section class="section dashboard mb-3">
  	<div class="row d-flex justify-content-center align-items-center">
  		<h3 class="text-center fw-bold pb-3">Top Tutors List</h3>  
  		 <!-- Recent Sales -->
            <div class="col-12">
              <div class="card recent-sales overflow-auto">

                <div class="card-body">
                  <h5 class="card-title"><span class="badge bg-info text-dark">
                  <i class="bi bi-info-circle"></i> Info</span>
                  <span class="text-secondary"> The following is the list of tutors according to the number of points given by the students in ascending order.
                  </span></h5>

                 
                      <!--  table with scrollable -->
		<div class="span3 achievements-wrapper">
    		<table class="table">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th scope="col">Tutor</th>
                        <th scope="col">Specialization</th>
                        <th scope="col">Total Points</th>
                        <th scope="col">Position</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr  class="table-success">
                        <th scope="row" class="text-success">#1</th>
                        <td>
                       		<table>
                       			 <tr>
                       				<td><img class= "img-thumbnail" src="images/tut_${StudentFormBean.frmCalculatedTutorList[0].id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       				<td><font class="h6 fw-bold p-2">Tr. ${StudentFormBean.frmCalculatedTutorList[0].tutorName}</font><br>
                       					<small class="p-2">${StudentFormBean.frmCalculatedTutorList[0].tutorType}</small><br>
                        			<a class="p-2" href="stuHomePath.do?frmControl=1&frmTopTutorDetailsId=${StudentFormBean.frmCalculatedTutorList[0].id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a></td>
                 					</tr>
                 			</table>
                 		</td>
                        <td>${StudentFormBean.frmCalculatedTutorList[0].specialization}</td>
                        			<td>${StudentFormBean.totalPointsList[0][0]}</td>
                        <td>
                        <span class="badge bg-warning"><i class="bi bi-trophy"></i><font class="fw-bold m-1">First</font></span></td>
                        
                      </tr>
                      <tr class="table-success">
                        <th scope="row" class="text-success">#2</th>
                        <td>
                       		<table>
                       			 <tr>
                       				<td><img class= "img-thumbnail" src="images/tut_${StudentFormBean.frmCalculatedTutorList[1].id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       				<td><font class="h6 fw-bold p-2">Tr. ${StudentFormBean.frmCalculatedTutorList[1].tutorName}</font><br>
                       					<small class="p-2">${StudentFormBean.frmCalculatedTutorList[1].tutorType}</small><br>
                        			<a class="p-2" href="stuHomePath.do?frmControl=1&frmTopTutorDetailsId=${StudentFormBean.frmCalculatedTutorList[1].id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a></td>
                 					 </tr>
                 					</table>
                 					</td>
                        <td>${StudentFormBean.frmCalculatedTutorList[1].specialization}</td>
                        			<td>${StudentFormBean.totalPointsList[1][0]}</td>
                        <td><span class="badge bg-warning"><i class="bi bi-award"></i><font class="fw-bold m-1">Second</font></span></td>
                      </tr>
                      <tr class="table-success">
                        <th scope="row" class="text-success">#3</th>
                        <td>
                       		<table>
                       			 <tr>
                       				<td><img class= "img-thumbnail" src="images/tut_${StudentFormBean.frmCalculatedTutorList[2].id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       				<td><font class="h6 fw-bold p-2">Tr. ${StudentFormBean.frmCalculatedTutorList[2].tutorName}</font><br>
                       					<small class="p-2">${StudentFormBean.frmCalculatedTutorList[2].tutorType}</small><br>
                        			<a class="p-2" href="stuHomePath.do?frmControl=1&frmTopTutorDetailsId=${StudentFormBean.frmCalculatedTutorList[2].id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a></td>
                 					 </tr>
                 					</table>
                 					</td>
                        <td>${StudentFormBean.frmCalculatedTutorList[2].specialization}</td>
                        			<td>${StudentFormBean.totalPointsList[2][0]}</td>
                        <td><span class="badge bg-warning"><i class="bi bi-award"></i><font class="fw-bold m-1">Third</font></span></td>
                      </tr>
                      <!--  loop starts -->
					<c:forEach var="i" begin="${4}"
						end="${StudentFormBean.end}" step="1">
							<tr class="table-light">
                       			<th scope="row">#${i}</th>
                       				<td>
                       				<table>
                       				 <tr>
                       				<td><img class= "img-thumbnail" src="images/tut_${StudentFormBean.frmCalculatedTutorList[i-1].id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       				<td><font class="h6 fw-bold p-2">Tr. ${StudentFormBean.frmCalculatedTutorList[i-1].tutorName}</font><br>
                       					<small class="p-2">${StudentFormBean.frmCalculatedTutorList[i-1].tutorType}</small><br>
                        			<a class="p-2" href="stuHomePath.do?frmControl=1&frmTopTutorDetailsId=${StudentFormBean.frmCalculatedTutorList[i-1].id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a></a></td>
                 					 </tr>
                 					</table>
                 					</td>
                        			<td>${StudentFormBean.frmCalculatedTutorList[i-1].specialization}</td>
                        			<td>${StudentFormBean.totalPointsList[i-1][0]}</td>
                        			<td></td>
                      </tr>
						
						</c:forEach>
                    </tbody>
                  </table>
                  </div>
                </div>
              
              </div>
            </div><!-- End Top Tutors List -->
  	</div><!-- End Row -->
  	</section><!--  End Top Teachers Sections -->
  </main>
  <%@ include file="inc/footer.jsp"%>
  
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>