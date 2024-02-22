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
           <li class="breadcrumb-item">Request Success</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	 <section>
  	 	 <div class="card mb-3">
				<div class="card-header text-center">Request Tutor</div>
                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4"><b>Your Request is Sent!</b></h5>
                  </div>
				<table>
					<tr><td>Now, check your <a href="myTutorsPath.do?frmControlMyTutors=0">Tutor List</a>.</td></tr>
					<tr><td>or, Go back to <a href="stuHomePath.do?frmControl=0">Home</a>.</td></tr>
				</table>
                </div>
              </div>
    </section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>