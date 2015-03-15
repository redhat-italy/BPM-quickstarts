<!DOCTYPE html>
<html>
<head>

    <title>Quickstart Lab- Login</title>
    <!-- proper charset -->
    <link rel="stylesheet" type="text/css" href="eap.css" />
    <link rel="shortcut icon" href="favicon.ico" />

</head>

<body>

<div id="container" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px;">
  
  <!-- header -->
  <div class="header-panel">
    <div class="header-line">&nbsp;</div>
    <div class="header-top">
      <img class="prod-title" src="images/product_title.png"/><span class="prod-version">6</span>                	
    </div>
    <div class="header-bottom">&nbsp;</div>
  </div>
  
  
  <!-- main content -->
  <div id="content">

    <div class="section">

        <h1>Red Hat SKO FY16 - Quickstart Lab</h1>

        <h3>Log into the system</h3>

        <form action="j_security_check" method="POST">
            <%
                String msg = request.getParameter("message");
                if (msg != null && msg.length() > 0){
                %><p><%= msg %></p><%
                }
            %>
            <p>Username: <input value="" name="j_username" class="text-input" type="text" autofocus/></p>
            <p>Password: <input name="j_password" class="text-input" type="password"/></p>
            <input class="button login" type="submit" value='login'/>

        </form>

      <sub>This page is been copied by the index.html page of the ROOT application of JBoss EAP 6.3.</sub>

    </div>

  </div>

  <div id="footer">Red Hat SKO FY16 - Spain 17th of March 2015</div>

</div>

</body >
</html>
