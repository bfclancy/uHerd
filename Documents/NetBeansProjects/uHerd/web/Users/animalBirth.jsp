<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Register Animal Birth</h1>
      <form action="/uHerd/RegisterNewAnimal" method="post">
          <label>Tag Number:</label><input type="text" name="tagNumber"/><br><br>
          <label>Date of Birth:</label><input type="date" name="dateOfBirth"/><br><br>
          <label>Gender:</label><input type="checkbox" name="gender" value="M"/>Male<input type="checkbox" name="gender" value="F"/>Female<br><br>
          <label>Dam Number:</label><input type="text" name="damTagNumber"/><br><br>
          <label>Sire Breed:</label><input type="text" name="sireBreed"/><br><br>
          <label>Sire AI Code:</label><input type="text" name="sireAICode"/><br><br>
          <label>(If Own Bull)Sire Tag Number:</label><input type="text" name="sireTagNumber"/><br><br>
          <label>&nbsp;</label><input type="submit" value="Register"/>
        </form>
    <div id="content">
        
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
