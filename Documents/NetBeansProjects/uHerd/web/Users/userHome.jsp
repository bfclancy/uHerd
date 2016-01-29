<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
        <h1>Welcome ${sessionScope.currentUser.firstName} ${sessionScope.currentUser.surname}</h1><br>
        <h2>Initial Setup Steps</h2>
        <ul>
            <li>Due to the fact that access has not been granted by the Department of Agriculture to the API there are a few minor tasks to be performed in order to set up the application to work for you.</li>
            <li>Log into the Department site for animal movements <a href="http://www.agfood.ie" target="_blank">here.</a></li><hr>
            <li>Download your herd profile in CSV format.</li>
            <img src="/uHerd/images/demo/DownloadHerdProfile.PNG" width="600px" height="450px" /><hr>
            <li>Under the Tasks navigation tab, go the the Import Herd Details page.</li>
            <li>Click on the Choose File button</li>
            <img src="/uHerd/images/demo/ChooseFile.PNG" width="400px" height="250px" /><hr>
            <li>Navigate to the Downloads folder of your PC.</li>
            <li>Select the CSV you downloaded from the Department site.</li>
            <img src="/uHerd/images/demo/Downloads.PNG" width="600px" height="250px" /><hr>
            <li>Click the Import button.</li>
            <img src="/uHerd/images/demo/Import.PNG" width="350px" height="200px" /><hr>
            <li>Under the Livestock navigation tab, go to the View Animals page.</li>
            <li>Your herd details should now be displayed.</li>
        </ul>
    <div id="content">
  </div>
</div>
</div>
<jsp:include page="userFooter.jsp"/>