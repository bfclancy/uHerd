<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Presentable
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Herd Management</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $.active = false;
        $('body').bind('click keypress', function() { $.active = true; });
        checkActivity(300000, 30000, 0); // timeout = 30 minutes, interval = 1 minute.
    });

    function checkActivity(timeout, interval, elapsed) {
        if ($.active) {
            elapsed = 0;
            $.active = false;
            $.get('heartbeat');
        }
        if (elapsed < timeout) {
            elapsed += interval;
            setTimeout(function() {
                checkActivity(timeout, interval, elapsed);
            }, interval);
        } else {
            window.location = '/uHerd/Logout'; // Redirect to "session expired" page.
        }
    }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="/uHerd/layout/styles/layout.css" type="text/css" />
</head>
<body id="top">
    <div class="wrapper col1">
      <div id="header">
        <div id="logo">
          <h1><a href="/uHerd/Users/index.jsp">Livestock Manager</a></h1>
          <p>Beef Herd Management Software</p>
        </div>
        <div id="search">
          <form action="#" method="post">
            <fieldset>
              <legend>Site Search</legend>
              <input type="text" value="Search the site&hellip;"  onfocus="this.value=(this.value=='Search the site&hellip;')? '' : this.value ;" />
              <input type="submit" name="go" id="go" value="GO" />
            </fieldset>
          </form><br>
              Current User:${sessionScope.currentUser.firstName} ${sessionScope.currentUser.surname}
          </br>
        </div>
        <div id="topnav">
          <ul>
            <li class="last"><a href="/uHerd/Logout">Logout</a>
            <li><a href="">Reports</a>
            <ul>
                <li><a href="/uHerd/BeefPriceData">Beef Price Tracker</a></li>
                <li><a href="/uHerd/Users/costPerHeadDV.jsp">View Users Reports</a></li>
              </ul>
            </li>
            <li><a href="">Financial</a>
              <ul>
                <li><a href="/uHerd/Users/recordExpenditure.jsp">Record Expenditure</a></li>
                <li><a href="/uHerd/ExpenditureData">Expenditure</a></li>
                <li><a href="/uHerd/Users/recordIncome.jsp">Record Income</a></li>
                <li><a href="/uHerd/IncomeData">Income</a></li>
                <li><a href="/uHerd/BalanceSheetData">Balance Sheet</a></li>
              </ul>
            </li>
            <li><a href="">Tasks</a>
            <ul>
                <li><a href="/uHerd/Users/importHerd.jsp">Import Herd Details</a></li>
                <li><a href="/uHerd/AppointmentPageData">Appointments</a></li>
                <li><a href="/uHerd/Users/reminders.jsp">Reminders</a></li>
                <li><a href="/uHerd/Users/medications.jsp">Medications</a></li>
                <li><a href="/uHerd/RecordTestResults">Record Test Results</a></li>
              </ul>
            </li>
            <li><a href="">Livestock</a>
                <ul>
                <li><a href="/uHerd/Users/animalBirth.jsp">Register Animal Birth</a></li>
                <li><a href="/uHerd/ViewAnimals">View Animals</a></li>
                <li><a href="/uHerd/Users/searchAnimal.jsp">Search for an Animal</a></li>
                <li><a href="/uHerd/AnimalPurchaseData">Record Animal Purchase</a></li>
                <li><a href="/uHerd/Users/animalSale.jsp">Record Animal Sale</a></li>
                <li><a href="/uHerd/Users/animalDeath.jsp">Record Animal Death</a></li>
                <li><a href="/uHerd/Users/editAnimal.jsp">Edit Animal Details</a></li>
                <li><a href="/uHerd/RecordPregnancyData"/>Record Pregnancy</li>
              </ul>
            </li>
            <li class="active"><a href="/uHerd/index.jsp">Home</a></li>
          </ul>
        </div>
        <br class="clear" />
      </div>
    </div>
</body>
</html>