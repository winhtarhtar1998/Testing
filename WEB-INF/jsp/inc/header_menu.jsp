<style>

/*--------------------------------------------------------------
# Header
--------------------------------------------------------------*/
a {
  color: #8779E2;
  text-decoration: none;
  font-size:11pt;
}
.profile-tab{
 	 background-color:#C3A9C7 !important;
 	}
.logo {
  line-height: 1;
}
@media (min-width: 1200px) {
  .logo {
    width: 280px;
  }
}
.logo img {
  max-height: 26px;
  margin-right: 6px;
}
.logo span {
  font-size: 26px;
  font-weight: 700;
  color: #5E445F;
  font-family: "Nunito", sans-serif;
}

.header {
  transition: all 0.5s;
  z-index: 997;
  height: 60px;
  box-shadow: 0px 2px 20px rgba(1, 41, 112, 0.1);
  background-color: #fff;
  padding-left: 5px;
  padding-right: 5px;
  /* Toggle Sidebar Button */
  /* Search Bar */
}
#header-logo{
  padding-bottom: 25px;
}
#header-nav-logo{
  position: absolute;
  left: 50%;
  margin-left: -60px !important;  /* 50% of your logo width */
  display: block;
}
.header .toggle-sidebar-btn {
  font-size: 32px;
  padding-left: 10px;
  cursor: pointer;
  color: #5E445F;
}
.header .search-bar {
  min-width: 360px;
  padding: 0 20px;
}
@media (max-width: 1199px) {
  .header .search-bar {
    position: fixed;
    top: 50px;
    left: 0;
    right: 0;
    padding: 20px;
    box-shadow: 0px 0px 15px 0px rgba(1, 41, 112, 0.1);
    background: white;
    z-index: 9999;
    transition: 0.3s;
    visibility: hidden;
    opacity: 0;
  }
  .header .search-bar-show {
    top: 60px;
    visibility: visible;
    opacity: 1;
  }
}
.header .search-form {
  width: 100%;
}
.header .search-form input {
  border: 0;
  font-size: 14px;
  color: #5E445F;
  border: 1px solid rgba(1, 41, 112, 0.2);
  padding: 7px 38px 7px 8px;
  border-radius: 3px;
  transition: 0.3s;
  width: 100%;
}
.header .search-form input:focus, .header .search-form input:hover {
  outline: none;
  box-shadow: 0 0 10px 0 rgba(1, 41, 112, 0.15);
  border: 1px solid rgba(1, 41, 112, 0.3);
}
.header .search-form button {
  border: 0;
  padding: 0;
  margin-left: -30px;
  background: none;
}
.header .search-form button i {
  color: #5E445F;
}

/*--------------------------------------------------------------
# Header Nav
--------------------------------------------------------------*/
.header-nav ul {
  list-style: none;
}
.header-nav > ul {
  margin: 0;
  padding: 0;
}
.header-nav .nav-icon {
  font-size: 20px;
  color: #5E445F;
}
.header-nav .nav-profile {
  color: #5E445F;
}
.header-nav .nav-profile img {
  max-height: 36px;
}
.header-nav .nav-profile span {
  font-size: 14px;
  font-weight: 600;
}
.header-nav .badge-number {
  position: absolute;
  inset: 4px 6px auto auto;
  font-weight: normal;
  font-size: 11px;
  padding: 3px 6px;
}
.header-nav .notifications .notification-item {
  display: flex;
  align-items: center;
  padding: 15px 10px;
  transition: 0.3s;
}
.header-nav .notifications .notification-item i {
  margin: 0 20px 0 10px;
  font-size: 24px;
}
.header-nav .notifications .notification-item h4 {
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 5px;
}
.header-nav .notifications .notification-item p {
  font-size: 13px;
  margin-bottom: 3px;
  color: #F1E3F3;
}
.header-nav .notifications .notification-item:hover {
  background-color: #f3f0e9;
}
.header-nav .messages .message-item {
  padding: 15px 10px;
  transition: 0.3s;
}
.header-nav .messages .message-item a {
  display: flex;
}
.header-nav .messages .message-item img {
  margin: 0 20px 0 10px;
  max-height: 40px;
}
.header-nav .messages .message-item h4 {
  font-size: 16px;
  font-weight: 600;
  margin-bottom: 5px;
  color: #444444;
}
.header-nav .messages .message-item p {
  font-size: 13px;
  margin-bottom: 3px;
  color: #F1E3F3;
}
.header-nav .messages .message-item:hover {
  background-color: #f3f0e9;
}
.header-nav .profile {
  min-width: 240px;
  padding-bottom: 0;
}
.header-nav .profile .dropdown-header h6 {
  font-size: 18px;
  margin-bottom: 0;
  font-weight: 600;
  color: #444444;
}
.header-nav .profile .dropdown-header span {
  font-size: 14px;
}
.header-nav .profile .dropdown-item {
  font-size: 14px;
  padding: 10px 15px;
  transition: 0.3s;
}
.header-nav .profile .dropdown-item i {
  margin-right: 10px;
  font-size: 18px;
  line-height: 0;
}
.header-nav .profile .dropdown-item:hover {
  background-color: #f3f0e9;
}

/*--------------------------------------------------------------
# Sidebar
--------------------------------------------------------------*/
.sidebar {
  position: fixed;
  top: 60px;
  left: 0;
  bottom: 0;
  width: 245px;
  z-index: 996;
  transition: all 0.3s;
  padding: 12px;
  overflow-y: auto;
  scrollbar-width: thin;
  scrollbar-color: #aab7cf transparent;
  box-shadow: 0px 0px 20px rgba(1, 41, 112, 0.1);
  background-color: #fff;
}
@media (max-width: 1199px) {
  .sidebar {
    left: -245px;
  }
}
.sidebar::-webkit-scrollbar {
  width: 5px;
  height: 8px;
  background-color: #fff;
}
.sidebar::-webkit-scrollbar-thumb {
  background-color: #aab7cf;
}

@media (min-width: 1200px) {
  #main, #footer {
    margin-left: 245px;
  }
}
@media (max-width: 1199px) {
  .toggle-sidebar .sidebar {
    left: 0;
  }
}
@media (min-width: 1200px) {
  .toggle-sidebar #main, .toggle-sidebar #footer {
    margin-left: 0;
  }
  .toggle-sidebar .sidebar {
    left: -245px;
  }
}

.sidebar-nav {
  padding: 0;
  margin: 0;
  list-style: none;
}
.sidebar-nav li {
  padding: 0;
  margin: 0;
  list-style: none;
}
.sidebar-nav .nav-item {
  margin-bottom: 5px;
}
.sidebar-nav .nav-heading {
  font-size: 11px;
  text-transform: uppercase;
  color: #899bbd;
  font-weight: 600;
  margin: 10px 0 5px 15px;
}
.sidebar-nav .nav-link {
  display: flex;
  align-items: center;
  font-size: 15px;
  font-weight: 600;
  color: #5E445F;
  transition: 0.3;
  background: #f3f0e9;
  padding: 10px 15px;
  border-radius: 4px;
}
.sidebar-nav .nav-link i {
  font-size: 16px;
  margin-right: 10px;
  color: #5E445F;
}
.sidebar-nav .nav-link.collapsed {
  color: #5E445F;
  background: #fff;
}
.sidebar-nav .nav-link.collapsed i {
  color: #899bbd;
}
.sidebar-nav .nav-link:hover {
  color: #5E445F;
  background: #f3f0e9;
}
.sidebar-nav .nav-link:hover i {
  color: #5E445F;
}
.sidebar-nav .nav-link .bi-chevron-down {
  margin-right: 0;
  transition: transform 0.2s ease-in-out;
}
.sidebar-nav .nav-link:not(.collapsed) .bi-chevron-down {
  transform: rotate(180deg);
}
.sidebar-nav .nav-content {
  padding: 5px 0 0 0;
  margin: 0;
  list-style: none;
}
.sidebar-nav .nav-content a {
  display: flex;
  align-items: center;
  font-size: 14px;
  font-weight: 600;
  color: #5E445F;
  transition: 0.3;
  padding: 10px 0 10px 40px;
  transition: 0.3s;
}
.sidebar-nav .nav-content a i {
  font-size: 6px;
  margin-right: 8px;
  line-height: 0;
  border-radius: 50%;
}
.sidebar-nav .nav-content a:hover, .sidebar-nav .nav-content a.active {
  color: #5E445F;
}
.sidebar-nav .nav-content a.active i {
  background-color: #5E445F;
}

#header{
	background-color:#C3A9C7;
}
body{
 background-color: #F7F2F7;
 }
</style>
<!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End menu -->

<nav id="header-logo" class="header-nav ms-auto">
      <ul id="header-nav-logo" class="d-flex align-items-center">
        <li class="nav-item">
          <a href="#" class="logo d-flex align-items-center">
            <img src="assets/img/logo-tfs-no-text.png" alt="">
            <span class="d-none d-lg-inline text-nowrap">TutorFinder</span>
          </a>
        </li><!-- End Logo -->
    </ul>
    </nav>
    <nav class="header-nav">
      <ul class="d-flex align-items-center">
        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="images/tut_${TutorFormBean.loginPjTutor.id}?time=<%=System.currentTimeMillis()%>" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2">${TutorFormBean.loginPjTutor.tutorName }</span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>${TutorFormBean.loginPjTutor.tutorEmail }</h6>
              <span>${TutorFormBean.loginPjTutor.tutorType}</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="tutorProfilePath.do">
                <i class="bi bi-person"></i>
                <span>Profile Overview</span>
              </a>
            </li>
            <li>
              <a class="dropdown-item d-flex align-items-center" href="updatePathFirst.do">
                <i class="bi bi-pencil-square"></i>
                <span>Edit Profile</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="changePasswordPathFirst.do">
                <i class="bi bi-gear"></i>
                <span>Change Password</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            
            <li>
              <a class="dropdown-item d-flex align-items-center" href="logoutPath.do">
                <i class="bi bi-box-arrow-right"></i>
                <span>Logout</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="tutorHomePath.do?frmControl=0">
          <i class="bi bi-house-door"></i>
          <span>Home</span>
        </a>
       </li><!-- End Home Nav -->
      
      <li class="dropdown-divider"></li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="addSubjectPathFirst.do?frmControl=0">
          <i class="bi bi-book"></i>
          <span>My Subjects</span>
        </a>
      </li><!-- End Profile Page Nav -->
	  <li class="nav-item">
        <a class="nav-link collapsed" href="responseStudentsPath.do?frmFormControlResponse=0">
         <i class="bi bi-person-plus"></i>
          <span>Response Students</span>
        </a>
      </li><!-- End Response Students Page Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="myStudentsPath.do?frmFormControlMyStudents=0">
          <i class="bi bi-person-check"></i>
          <span>My Students</span>
        </a>
      </li><!-- End My Students Page Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="reviewFeedbackPath.do?frmFormControlMyStudents=0">
          <i class="bi bi-envelope-check"></i>
          <span>Review Feedback</span>
        </a>
      </li><!-- End My Students Page Nav -->
      <li class="dropdown-divider"></li>
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
           <i class="bi bi-gear"></i><span>Account Setting</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="tutorProfilePath.do">
              <i class="bi bi-circle"></i><span>Profile Overview</span>
            </a>
          </li>
          <li>
            <a href="updatePathFirst.do">
              <i class="bi bi-circle"></i><span>Edit Profile</span>
            </a>
          </li>
          <li>
            <a href="changePasswordPathFirst.do">
              <i class="bi bi-circle"></i><span>Change Password</span>
            </a>
          </li>
          <li>
            <a href="deleteProfilePathFirst.do">
              <i class="bi bi-circle"></i><span><font color="red">Delete Account</font></span>
            </a>
          </li>
        </ul>
      </li><!-- End Components Nav -->
      <li class="dropdown-divider"></li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="logoutPath.do">
          <i class="bi bi-box-arrow-right"></i>
          <span>Logout</span>
        </a>
      </li><!-- End My Students Page Nav -->
    </ul>

  </aside><!-- End Sidebar-->