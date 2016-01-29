<%@page import="java.util.List"%>
<jsp:include page="header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="counties" scope="request" type="List<BusinessEntities.Counties>"/>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="intro">
    <div class="fl_left">
      <h1>Welcome to the Livestock Manager Web Application</h1>
      <ul>
        <li>
          <h2>What we do!</h2>
          <p>Make the administrative duties of beef farm management easier.</p>
          <p>Cut down time spent on paperwork</p>
          <p>Give you the information you need to gain the best return you can from your animals</p>
        </li>
        <li class="last">
          <h2>Download the App</h2>
          <p>Download the Android App on the Google Playstore</p>
          <p>Free to download, easy to setup, easy to use, works in conjunction with web site.</p>
          <p>Easy report generation, view beef prices nationwide, set reminders and alarms, track animal movements, monitor pregnancies and communicate with other users.</p>
          <p class="readmore"><a href="#">Download the App</a></p>
        </li>
      </ul>
    </div>
    <div class="fl_right">
      <ul id="rotation">
        <li><a href="#"><img src="/uHerd/images/demo/herdTracker.jpg" alt="" /></a></li>
        <li><a href="#"><img src="images/demo/slide_2.gif" alt="" /></a></li>
        <li><a href="#"><img src="images/demo/slide_3.gif" alt="" /></a></li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
  <div id="container">
      <h1>Register</h1>
      <form action="RegisterNewUser" method="post">
          <table class="table1">
              <tr>
                  <td><label>First Name:</label><input type="text" name="firstName" required/></td>
                  <td><label>Surname:</label><input type="text" name="surname" required/></td>
              </tr>
              <tr>
                  <td><label>Address:</label><input type="text" name ="address" required/></td>
                  <td><label>County:</label>
                      <select name="county">
                        <c:forEach items="${counties}" var="county">
                            <option value="${county.county}"><c:out value="${county.county}"/></option>
                        </c:forEach>
                </select></td>
              </tr>
              <tr>
                  <td><label>Herd Number</label><input type="text" name="herdNumber" required/></td>
                  <td><label>PAC:</label><input type="text" name="pac" required/></td>
              </tr>
              <tr>
                  <td><label>Username:</label><input type="text" name="username" required/></td>
                  <td><label>Password:</label><input type="password" name="password" required/></td>
              </tr>
              <tr>
                  <td><label>Email</label><input type="text" name="email"</td>
                  <td><label>&nbsp;</label><input type="submit" value="Register"/></td>
              </tr>
          </table>
      </form>
    <div id="content">
  </div>
</div>
</div>
<!-- ####################################################################################################### -->
<jsp:include page="footer.jsp"/>