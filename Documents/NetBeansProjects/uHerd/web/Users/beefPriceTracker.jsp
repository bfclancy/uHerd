<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<jsp:useBean id="prices" scope="request" type="List<String>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Beef Factory Prices per kilo</h1>
      <table border="2">
          <tr>
              <th>Cattle Type</th>
              <th>Cattle Grade</th>
              <th>Price This Week Last Year</th>
              <th>Price this week</th>
              <th>% Change</th>
              <th>Average Beef Price Last Year</th>
              <th>Average To Date This Year</th>
              <th>% Change on Last Year</th>
          </tr>
          <c:forEach items="${prices}" var="price">
              <tr>
                <td><c:out value="${price.cattleType}"/></td>
                <td><c:out value="${price.cattleGrade}"/></td>
                <td><c:out value="${price.pricePerKiloLastYear}"/></td>
                <td><c:out value="${price.pricePerKilo}"/></td>
                <td><c:out value="${price.percentageChangeOnPreviousYear}"/></td>
                <td><c:out value="${price.averagePriceLastYear}"/></td>
                <td><c:out value="${price.averagePriceThisYear}"/></td>
                <td><c:out value="${price.percentageChangeOnAverageOnPreviousYear}"/></td>
              </tr>
              </c:forEach>
      </table>
      
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>