<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
    <c:choose>
        <c:when test="${not empty contact}">Edit Contact</c:when>
        <c:otherwise>Add Contact</c:otherwise>
    </c:choose>
</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">

    <header>
        <h1>
            <c:choose>
                <c:when test="${not empty contact}">Edit Contact</c:when>
                <c:otherwise>Add Contact</c:otherwise>
            </c:choose>
        </h1>
    </header>

    <!-- Messages -->
    <c:if test="${not empty sessionScope.message}">
        <div class="card">
            <p class="${sessionScope.messageType == 'success' ? 'success' : 'error'}">
                ${sessionScope.message}
            </p>
            <% session.removeAttribute("message"); session.removeAttribute("messageType"); %>
        </div>
    </c:if>

    <div class="card">

        <form action="ContactServlet" method="post" class="form">

            <c:choose>
                <c:when test="${not empty contact}">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="id" value="${contact.id}" />
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="create" />
                </c:otherwise>
            </c:choose>

            <label for="name">Name *</label>
            <input id="name" name="name" value="${contact.name}" required />

            <label for="email">Email</label>
            <input id="email" name="email" type="email" value="${contact.email}" />

            <label for="phone">Phone</label>
            <input id="phone" name="phone" type="tel" value="${contact.phone}" />

            <label for="notes">Notes</label>
            <textarea id="notes" name="notes" rows="3">${contact.notes}</textarea>

            <div class="form-actions">
                <button type="submit" class="btn">Save</button>
                <a class="btn outline" href="ContactServlet?action=list">Cancel</a>
                <a class="btn outline" href="index.jsp">Home</a>
            </div>

        </form>

    </div>

</div>
</body>
</html>
