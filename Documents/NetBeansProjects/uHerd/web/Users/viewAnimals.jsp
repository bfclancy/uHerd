<%@page import="java.util.ArrayList"%>
<%@page import="BusinessEntities.Cattle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="cattle" scope="request" type="ArrayList<BusinessEntities.Cattle>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Animal Details</h1>
      <table border="2">
            <h2>List of all animals</h2>
            <tr>
                <th>Tag Number</th>
                <th>Breed</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Date Last TB Test</th>
                <th>Date Last BR Test</th>
                <th>Date Moved In</th>
            </tr>
        <c:forEach items="${cattle}" var="animal">
            <tr>
            <td><c:out value="${animal.tagNumber}"/></td>
            <td><c:out value="${animal.sireBreed}"/></td>
            <td><c:out value="${animal.gender}"/></td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${animal.dateOfBirth}"/></td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${animal.dateLastTBTest}"/></td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${animal.dateLastBRTest}"/></td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${animal.dateMovedIn}"/></td>
        </tr>
        </c:forEach>
        </table>
    <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
