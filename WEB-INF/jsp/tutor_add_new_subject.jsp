<%@ include file="inc/common.jsp"%>
<html>
<head>
 <title>My Subjects - Tutor</title>
 <%@ include file="inc/head.jsp"%>
 <style type="text/css">
 	.add-subject-form{
 	margin-top:15px;
 	padding-top:25px;
 	align-items:center;
 	justify-content:center;
 	}
 </style>
</head>
<body>
 <%@ include file="inc/header_menu.jsp"%>
 
  <main id="main" class="main">
  	<div class="pagetitle">
  <h1>Add New Subject</h1>
  	<nav>
  		 <ol class="breadcrumb">
          <li class="breadcrumb-item">My Subjects</li>
          <li class="breadcrumb-item">Add New Subject</li>
        </ol>
      </nav>
 </div>
 
 <section class="section profile">
  	  
  	  <div class="row d-flex  align-items-center justify-content-center">
        <div class="col-xl-9">
        <div class="card add-subject-form">
        <div class="card-body pt-3 fade show active profile-overview">
  		<html:form action="/addSubjectPath">
  		<logic:empty property="frmRegFormControl" name="AddSubjectFormBean">
  			<h5 class="card-title">Add New Subject</h5> 
  			<div class="row">
                   <div class="col-lg-4 col-md-4 label">Select Subject <font color="red">*</font></div>
                   <div class="col-lg-8 col-md-8"><html:select property="frmAddSubjectId">
					<html:option value="0">SELECT</html:option>
					<html:optionsCollection property="frmAddSubjectList" value="id"
						label="subjectName" />
					</html:select></div>
                   <div class="col-lg-12"><html:errors property="subjectError" /></div>
         	</div>
         	<div class="row">
                    	<div class="col-lg-4 col-md-4 label">Teaching Type <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:select property="frmAddTeachingType">
					<html:option value="0">SELECT</html:option>
					<html:option value="Online">Online</html:option>
					<html:option value="In-Class">In-Class</html:option>
					<html:option value="Online, In-Class">Online, In-Class</html:option>
				</html:select> </div>
                    	<div class="col-lg-12"><html:errors property="teachingTypeError" /></div>
                    	
            </div>
            <div class="row">
                    	<div class="col-lg-4 col-md-4 label">Fee per Month <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:text property="frmAddFee"></html:text> $</div>
                    	<div class="col-lg-12"><html:errors property="frmAddFee" />
					<html:errors property="feeError" /></div>
                    	
            </div>
            <div class="row">
                    	<div class="col-lg-4 col-md-4 label">No. of Period(s) per Week <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:text property="frmAddPeriodPerWeek"></html:text></div>
                    	<div class="col-lg-12"><html:errors property="frmAddPeriodPerWeek" />
					<html:errors property="periodError" /></div>
                    	
            </div>
            <div class="row">
                    	<div class="col-lg-4 col-md-4 label">Preferable Time <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8"><html:textarea property="frmAddPreferableTime"></html:textarea></div>
                    	<div class="col-lg-12"><html:errors property="frmAddPreferableTime" /></div>
                    	
            </div>
            <div class="row">
                    	<div class="col-lg-4 col-md-4 label">Preferable Days <font color="red">*</font></div>
                    	<div class="col-lg-8 col-md-8">
                    <span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" SUN " /> SUN </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" MON " /> MON </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" TUE " /> TUE </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" WED " /> WED </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" THU " /> THU </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" FRI " /> FRI </span>
					<span class="p-1"><html:multibox  property="frmAddPreferableDays" value=" SAT " /> SAT </span>
					</div>
                    	<div class="col-lg-12"><html:errors property="preferableDaysError" /></div>
                    	
            </div>
            <div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnAddNewSubject" value="Add"></html:submit></span>
                    	<span class="m-2"><html:cancel value="Cancel" /></span>
                    	</div>
                    </div>
	</logic:empty>	
			  
		<!-- Confirmation portion here -->
		<logic:notEmpty property="frmRegFormControl" name="AddSubjectFormBean">
		<h5 class="card-title">Confirm Your Data</h5> 
			<div class="row">
                   <div class="col-lg-4 col-md-4 label">Selected Subject</div>
                   <div class="col-lg-8 col-md-8"><html:text property="frmAddSubjectName" disabled="true"></html:text></div>
                </div>
             <div class="row">
                   <div class="col-lg-4 col-md-4 label">Teaching Type</div>
                   <div class="col-lg-8 col-md-8"><html:text property="frmAddTeachingType" disabled="true"></html:text></div>
                </div>
            <div class="row">
                   <div class="col-lg-4 col-md-4 label">Fee per Month</div>
                   <div class="col-lg-8 col-md-8"><html:text property="frmAddFee" disabled="true"></html:text></div>
                </div>
            <div class="row">
                   <div class="col-lg-4 col-md-4 label">No. of Period(s) per Week</div>
                   <div class="col-lg-8 col-md-8"><html:text property="frmAddPeriodPerWeek" disabled="true"></html:text></div>
                </div>
            <div class="row">
                   <div class="col-lg-4 col-md-4 label">Preferable Time</div>
                   <div class="col-lg-8 col-md-8"><html:textarea property="frmAddPreferableTime" disabled="true"></html:textarea></div>
                </div>
            <div class="row">
                   <div class="col-lg-4 col-md-4 label">Preferable Days</div>
                   <div class="col-lg-8 col-md-8"><html:text property="frmAddPreferableDaysString" disabled="true"></html:text></div>
                </div>
			 <div class="row">
                    	<div class="col-lg-12 col-md-12" >
                    	<span class=""><html:submit property="btnSaveNewSubject" value="Save"></html:submit></span>
                    	<span class="m-2"><html:submit property="btnSaveCancel" value="Cancel"></html:submit></span>
                    	</div>
              </div>
	</logic:notEmpty>
  	</html:form>
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