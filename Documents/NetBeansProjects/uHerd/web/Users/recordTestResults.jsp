<%@page import="java.util.ArrayList"%>
<%@page import="BusinessEntities.Cattle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="cattle" scope="request" type="ArrayList<BusinessEntities.Cattle>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Record Test Results</h1>
        <form action="StoreTestResults" method="post">
            <label>Date</label><input type="date" name="testDate"/><br><br>
            <label>Test type:</label>
            <select name="testType">
                <option value="TB">Tuberculosis</option>
                <option value="BR">Brucellosis</option>
            </select><br><br>
            <c:forEach items="${cattle}" var="animal">
                <label>${animal.tagNumber}</label>
                <input type="radio" name="${animal.tagNumber}" id="testResult" value="pass" checked="true"/>Pass
                <input type="radio" name="${animal.tagNumber}" id="testResult" value="fail"/>Fail<br><br>
            </c:forEach>
                <label>&nbsp;</label><input type="submit" value="Submit Test results"/>
        </form>
      <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
