<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Find Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  <div class="pagetitle">
  <h1>Response Students</h1>
  	  <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item">Response Students</li>
          <li class="breadcrumb-item">Connect Student Success</li>
        </ol>
      </nav><!-- End Page Title -->
  	</div>
  	 <section>
  	 	 <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4"><b>You connected with Student Successfully!</b></h5>
                  </div>
				<table>
					<tr><td>Now, check your <a href="myStudentsPath.do?frmFormControlMyStudents=0">Students List</a>.</td></tr>
					<tr><td>or, Continue to <a href="responseStudentsPath.do?frmFormControlResponse=4">Response Students</a>.</td></tr>
				</table>
                </div>
              </div>
    </section>
  	
  </main>
  <%@ include file="inc/footer.jsp"%>
  
 <%@ include file="inc/connect-js.jsp"%>
</body>
</html>