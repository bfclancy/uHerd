<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Login</h1>
      <p>Username or password were incorrect</p>
      <form action="j_security_check" method="get">
                <label>Username:</label><input type="text" name="j_username"/><br>
                <label>Password:</label><input type="password" name="j_password"/><br>
                <input type="submit" value="Login"/>
      </form>
    <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
