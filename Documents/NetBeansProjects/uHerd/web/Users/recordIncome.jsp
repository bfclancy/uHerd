<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Record New Income</h1>
      <form action="/uHerd/NewIncome" method="post">
          <label>Date:</label><input type="date" name="date" required/><br><br>
          <label>Amount:</label><input type="number" step="0.01" name="amount" required/><br><br>
          <label>Description:</label><input type="text" name="description" required/><br><br>
          <label>&nbsp;</label><input type="submit" value="Record Income"/>
      </form>
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>