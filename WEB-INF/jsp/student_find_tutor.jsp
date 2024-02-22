<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Find Tutors - Student</title>
 <%@ include file="inc/head.jsp"%>
 <style type="text/css">
 .achievements-wrapper { 
 	height: 85vh; 
 	overflow: auto;
 }
 </style>
</head>
</head>
<body>
 <%@ include file="inc/header_menu_student.jsp"%>
 <main id="main" class="main">
 	<div class="pagetitle">
      <h1>Find Tutors</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Find Tutors</a></li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  	
  	<section class="section justify-content-center">
      <div class="row m-2">
        <div class="col-lg-12">

  	<html:form	action="/findTutorsPath">
  		<div class="row d-flex">
			<div class="col-4 d-flex p-2">
					<label class="p-2">Subject:</label><span class="p-2">
					<html:select property="frmFindSubjectId">
					<html:option value="0">ALL SUBJECTS</html:option>
					<html:optionsCollection property="frmFindSubjectList" value="id"
						label="subjectName" />
					</html:select></span>
			</div>
			<div class="col-4 d-flex p-2">
				    <label class="p-2">Teaching Type:</label><span class="p-2">
					<html:select property="frmFindTeachingType">
					<html:option value="0">NOT SPECIFIED</html:option>
					<html:option value="Online">Online</html:option>
					<html:option value="In-Class">In-Class</html:option>
					<html:option value="Online, In-Class">Online, In-Class</html:option>
				</html:select></span>
			</div>
			<div class="col-4 pt-3">
				<html:submit property="btnFindTutor" value="Find Tuotors"></html:submit>
			</div>
		</div>
	   </html:form>	
	   </div>
	   </div>
	   </section>
  
  	<!-- Find Result Session -->
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Tutors List</h5>
              
              <div class="span3 achievements-wrapper">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col" colspan="2">Tutor</th>
                    <th scope="col">Subject & Fee</th>
                    <th scope="col">Teaching Type</th>
                    <th scope="col">Periods/Week</th>
                    <th scope="col">Preferable Time & Days</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${FindTutorFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${FindTutorFormBean.begin}"
						end="${FindTutorFormBean.end}" step="1">
						<tr>
							<th scope="row">${i}</th>
                       		<td align="right"><img class= "img-thumbnail" src="images/tut_${FindTutorFormBean.frmFindTeachList[i-1].tutor.id}?time=<%=System.currentTimeMillis()%>" width="80" height="80" alt="no Photo"/></td>
                       		<td align="left"><font class="h6 fw-bold">Tr. ${FindTutorFormBean.frmFindTeachList[i-1].tutor.tutorName}</font><br>
                       				<small> ${FindTutorFormBean.frmFindTeachList[i-1].tutor.tutorType} </small><br>
                        			<a href="findTutorsDetailPath.do?frmControl=2&frmFindTutorDetailsId=${FindTutorFormBean.frmFindTeachList[i-1].tutor.id}">Tutor Details <i class="bi bi-arrow-up-right-square"></i></a>
                        	</td>
                        	<td>
                        		<b>${FindTutorFormBean.frmFindTeachList[i-1].subject.subjectName}</b><br>
                        		   ${FindTutorFormBean.frmFindTeachList[i-1].fee} $ </td>
                        	<td>${FindTutorFormBean.frmFindTeachList[i-1].teachingType}</td>
							<td>${FindTutorFormBean.frmFindTeachList[i-1].periodPerWeek} periods</td>
							<td>${FindTutorFormBean.frmFindTeachList[i-1].preferableTime}<br>
   								${FindTutorFormBean.frmFindTeachList[i-1].preferableDays}
							</td>
							<td>
                    	<c:if test="${FindTutorFormBean.frmRequestStatus[i-1] eq 'Requested'}">
                    		<span class="badge bg-secondary"><font class="fw-bold m-1">${FindTutorFormBean.frmRequestStatus[i-1]}</font></span>
                    	</c:if>
                    	<c:if test="${FindTutorFormBean.frmRequestStatus[i-1] eq 'Connected'}">
                    		<span class="badge bg-secondary"><font class="fw-bold m-1">${FindTutorFormBean.frmRequestStatus[i-1]}</font></span>
                    	</c:if>
                    	<c:if test="${FindTutorFormBean.frmRequestStatus[i-1] eq 'Request Now'}">
                    	<small>	<a href="requestTutorPath.do?frmControl=3&frmRequestTeachId=${FindTutorFormBean.frmFindTeachList[i-1].id}">${FindTutorFormBean.frmRequestStatus[i-1]} <i class="bi bi-arrow-up-right-square"></i></a></small>
                    	</c:if>
                    </td>
                    </tr>
					 </c:forEach>
					</c:if>
					<c:if test="${FindTutorFormBean.begin==0}">
    					<tr>
    						<th colspan="8"><h4 align="center">Sorry! There is no Tutors.</h4></th>
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