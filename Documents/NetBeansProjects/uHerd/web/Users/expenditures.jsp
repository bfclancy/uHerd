<%@page import="java.util.List"%>
<%@page import="BusinessEntities.Expenditure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="expenditures" scope="request" type="List<BusinessEntities.Expenditure>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Expenditures</h1>
      <table border="2">
          <tr>
              <th>Date</th>
              <th>Description</th>
              <th>Amount</th>
              <th>Total Expenditure</th>
          </tr>
          <c:forEach items="${expenditures}" var="expenditure">
            <tr>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${expenditure.expenditureDate}"/></td>
            <td><c:out value="${expenditure.expenditureDescription}"/></td>
            <td><c:out value="${expenditure.expenditureAmount}"/></td>
            <td></td>
        </c:forEach>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>${totalExpenditure}</td>
            </tr>
      </table>
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>
