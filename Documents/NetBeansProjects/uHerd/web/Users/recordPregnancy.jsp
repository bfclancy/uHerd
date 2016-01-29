<%@page import="java.util.List"%>
<%@page import="BusinessEntities.Cattle"%>
<%@page import="BusinessEntities.Aibulls"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="cows" scope="request" type="List<BusinessEntities.Cattle>"/>
<jsp:useBean id="bulls" scope="request" type="List<BusinessEntities.Cattle>"/>
<jsp:useBean id="aibulls" scope="request" type="List<BusinessEntities.Aibulls>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Record Pregnancy</h1>
      <form action="/uHerd/RecordPregnancy" method="post">
          <label>Date:</label><input type="date" name="date" required/><br><br>
          <label>Dam Tag Number:</label>
          <select name="damTagNumber" id="dtn">
          <c:forEach items="${cows}" var="cow">
              <option value ="${cow.tagNumber}"><c:out value="${cow.tagNumber}"/></option>
          </c:forEach>
          </select><br><br>
          <label>Sire Tag Number:(if own bull)</label>
          <select name="sireTagNumber" id="stn" onchange="disablestn2();">
              <option value="null">Select One</option>
          <c:forEach items="${bulls}" var="bull">
              <option value ="${bull.tagNumber}"><c:out value="${bull.tagNumber}"/></option>
          </c:forEach>
          </select><br><br>
          <label>AI Bull Code:</label>
          <select name="sireTagNumber" id="stn2" onchange="disablestn();">
              <option>Select One</option>
          <c:forEach items="${aibulls}" var="aibull">
              <option value ="${aibull.code}"><c:out value="${aibull.code}"/></option>
          </c:forEach>
          </select><br><br>
          <label>Sire Breed</label><input type="text" name="sireBreed"/><br><br>
          <label>&nbsp;</label><input type="submit" value="Record Income"/>
      </form>
    <div id="content">
  </div>
</div>
</div>
<script type="text/javascript">
    function disablestn2(){
        if (document.getElementById("stn").value == "null") {
        document.getElementById("stn2").disable='true';
    }
    else
        document.getElementById("stn2").disable='';
    }
    
    function disablestn(){
        document.getElementById("stn").disable='true';
    }
</script>
<jsp:include page="userFooter.jsp"/>
