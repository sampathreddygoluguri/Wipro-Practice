<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wipro.Contact"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Contacts</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">

    <header><h1>Your Contacts</h1></header>

    <!-- Flash Messages -->
    <c:if test="${not empty sessionScope.message}">
        <div class="card">
            <p class="${sessionScope.messageType == 'success' ? 'success' : 'error'}">
                ${sessionScope.message}
            </p>
            <% session.removeAttribute("message"); session.removeAttribute("messageType"); %>
        </div>
    </c:if>

    <div class="card">

        <div style="margin-bottom:15px;">
            <a class="btn" href="ContactServlet?action=add">Add New Contact</a>
            <a class="btn outline" href="index.jsp">Home</a>
        </div>

        <table class="responsive-table">
            <thead>
                <tr>
                    <th>Name</th><th>Email</th><th>Phone</th><th>Notes</th><th>Actions</th>
                </tr>
            </thead>
            <tbody>

                <c:choose>
                    <c:when test="${empty contacts}">
                        <tr><td colspan="5" class="muted">No contacts added yet.</td></tr>
                    </c:when>

                    <c:otherwise>
                        <c:forEach var="c" items="${contacts}">
                            <tr>
                                <td data-label="Name">${c.name}</td>
                                <td data-label="Email">${c.email}</td>
                                <td data-label="Phone">${c.phone}</td>
                                <td data-label="Notes">${c.notes}</td>

                                <td data-label="Actions">
                                    <a class="btn small" href="ContactServlet?action=edit&id=${c.id}">Edit</a>
                                    <a class="btn small outline"
                                       href="ContactServlet?action=delete&id=${c.id}"
                                       onclick="return confirm('Delete this contact?');">
                                       Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

            </tbody>
        </table>

    </div>

</div>

</body>
</html>
