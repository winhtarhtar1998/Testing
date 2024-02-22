<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>Home - Tutor</title>
 <%@ include file="inc/head.jsp"%>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  	<div class="pagetitle">
  <h1>My Subjects</h1>
  	<nav>
  	 <ol class="breadcrumb">
          <li class="breadcrumb-item">My Subjects</li>
        </ol>
      </nav>
 </div>
  	<div class="button">
  	<html:form action="/addSubjectPathFirst">
  		<div class="py-1 pt-2 px-2"><html:submit property="btnAddNewSubjectFirst" value="Add New Subject">
		</html:submit> </div>
  	</html:form>
  	</div>
  	<section class="section">
      <div class="row">
        <div class="col-lg-12">
			<c:if test="${EditSubjectFormBean.frmDeleteMessage!=''}">
              		<div class="alert alert-danger alert-dismissible fade show m-2" role="alert">
                		<i class="bi bi-exclamation-octagon me-1"></i>
                		${EditSubjectFormBean.frmDeleteMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
              	</c:if>
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">List of Subject(s) You Teach</h5>
              <!-- Table with stripped rows -->
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Subject</th>
                    <th scope="col">Teaching Type</th>
                    <th scope="col">Fee</th>
                    <th scope="col">Periods/Week</th>
                    <th scope="col">Preferable Time & Days</th>
                    <th scope="col" colspan="2">Action</th>
                  </tr>
                </thead>
                <tbody>
   					<c:if test="${EditSubjectFormBean.begin!=0}">
   					  <c:forEach var="i" begin="${EditSubjectFormBean.begin}"
						end="${EditSubjectFormBean.end}" step="1">
						<tr>
							<th scope="row">${i}</th>
                        	<td><b>${EditSubjectFormBean.myTeachList[i-1].subject.subjectName}</b></td>
							<td>${EditSubjectFormBean.myTeachList[i-1].teachingType}</td>
							<td>${EditSubjectFormBean.myTeachList[i-1].fee} $ </td>
							<td>${EditSubjectFormBean.myTeachList[i-1].periodPerWeek}</td>
							<td>${EditSubjectFormBean.myTeachList[i-1].preferableTime}<br>
   								${EditSubjectFormBean.myTeachList[i-1].preferableDays}
							</td>
                        	<td><a class="px-1" href="editSubjectPathFirst.do?frmRequestId=${EditSubjectFormBean.myTeachList[i-1].id}&frmAddSubjectId=${EditSubjectFormBean.myTeachList[i-1].subject.id}"> Edit <i class="bi bi-pencil-square"></i></a>
                        	<a class="px-1" href="addSubjectPathFirst.do?frmControl=1&frmRequestId=${EditSubjectFormBean.myTeachList[i-1].id}" onclick="return confirm('Are you sure to delete?')"><font class="text-danger"> Remove <i class="bi bi-x-circle"></i></font></a></td>
						</tr>
					 </c:forEach>
					</c:if>
					<c:if test="${EditSubjectFormBean.begin==0}">
    					<tr>
    						<th colspan="8"><h4 align="center">There is no Subjects List you teach!!</h4></th>
    					</tr>
					</c:if>
   		              	
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

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