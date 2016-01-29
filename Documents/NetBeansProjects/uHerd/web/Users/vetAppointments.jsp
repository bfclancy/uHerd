<%@page import="java.util.List"%>
<%@page import="BusinessEntities.Appointment"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="appointments" scope="request" type="List<BusinessEntities.Appointment>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Upcoming Appointments</h1>
      <table border="2">
          <tr>
          <th>Appointment Type</th>
          <th>Time</th>
          <th>Date</th>
          <tr>
          <c:forEach items="${appointments}" var="appointments">
            <tr>
            <td><c:out value="${appointments.type}"/></td>
            <td><fmt:formatDate type="time" value="${appointments.time}"/></td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${appointments.date}"/></td>
        </c:forEach>
      </table>
      <hr>
      <h1>Add New Appointment</h1>
      <form action="/uHerd/NewAppointment" method="post">
          <label>Appointment Type:</label><input type="text" name="type" required/><br><br>
          <label>Time:</label><input type="time" name="time" required/><br><br>
          <label>Date:</label><input type="date" name="date" required/><br><br>
          <label>&nbsp;</label><input type="submit" value="Add Appointment"/>
      </form>
    <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
