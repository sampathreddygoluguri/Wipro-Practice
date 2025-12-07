<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Manager – Home</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">

    <header>
        <h1>Contact Manager</h1>
        <p class="muted">Manage your contacts easily and efficiently</p>
    </header>

    <div class="card" style="text-align:center;">
        <a class="btn" href="ContactServlet?action=list">View Contacts</a>
        <a class="btn outline" href="ContactServlet?action=add">Add New Contact</a>
    </div>

</div>
</body>
</html>
