<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Import Herd Information</h1>
      <form action="../ImportHerd" enctype="multipart/form-data" method="POST">
          <label>Select File</label>
          <input type="file" id="herdData" name="herdData" required/><br>
          <input type="submit" value="Import"/>
      </form>
    <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
