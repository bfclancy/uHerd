<%@page import="java.util.List"%>
<%@page import="BusinessEntities.Income"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="incomes" scope="request" type="List<BusinessEntities.Income>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Incomes</h1>
      <table border="2">
            <tr>
              <th>Date</th>
              <th>Description</th>
              <th>Amount</th>
              <th>Total Income</th>
            </tr>
            <c:forEach items="${incomes}" var="income">
            <tr>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${income.incomeDate}"/></td>
            <td><c:out value="${income.incomeDescription}"/></td>
            <td><c:out value="${income.incomeAmount}"/></td>
            <td></td>
            </c:forEach>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>${totalIncome}</td>
            </tr>
      </table>
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>
