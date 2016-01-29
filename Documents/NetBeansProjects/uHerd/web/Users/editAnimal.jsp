<jsp:include page="userHeader.jsp"/>
<div class="wrapper col3">
  <div id="container">
      <h1>Edit Animal Details</h1>
      <form action="AddNewAnimal" method="post">
            Tag Number:<input type ="text" name="tagNumber" readonly="readonly"/><br/><br/>
            Breed:<input type ="text" name="breed" readonly="readonly"/><br/><br/>
            Gender:<input type ="text" name="gender"/><br/><br/>
            Date of Birth:<input type ="text" name="dob" readonly="readonly"/><br/><br/>
            Date last TB test:<input type ="text" name="dtb"/><br/><br/>
            Date last BR test:<input type ="text" name="dbr"/><br/><br/>
            Date moved in:<input type ="text" name="dmi" readonly="readonly"/><br/><br/>
            Purchase price:<input type="number" name ="purchasePrice" readonly/><br/><br/>
            Sale price:<input type="number" name="salePrice"/><br/><br/>
            Weight:<input type="number" name="weight"/><br/><br/>
            <input type="submit" value="Submit"/>
        </form>
    <div id="content">
  </div>
</div>
<jsp:include page="userFooter.jsp"/>
