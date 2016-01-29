<%@page import="java.util.List"%>
<%@page import="BusinessEntities.Cattle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="cattle" scope="request" type="List<BusinessEntities.Cattle>"/>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Add Animal To Herd</h1>
      <form action="RecordAnimalPurchase" method="post">
          <label>Tag Number:</label><input type="text" name="tagNumber"/><br><br>
          <label>Date of Birth:</label><input type="date" name="dateOfBirth"/><br><br>
          <label>Gender:</label><input type="checkbox" name="gender" value="M"/>Male<input type="checkbox" name="gender" value="F"/>Female<br><br>
          <label>Dam Number:</label><input type="text" name="damTagNumber"/><br><br>
          <label>Sire Breed:</label><input type="text" name="sireBreed"/><br><br>
          <label>Sire AI Code:</label><input type="text" name="sireAICode"/><br><br>
          <label>(If Own Bull)Sire Tag Number:</label><input type="text" name="sireTagNumber"/><br><br>
            <label>Purchase Date:</label><input type="date" name="purchaseDate" required/><br><br>
           <label>Purchase Price:</label><input type="number" name="purchasePrice" required/><br><br>       
           <label>&nbsp;</label><input type="submit" value="Add To Herd"/>
        </form>
    <div id="content">
        
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
