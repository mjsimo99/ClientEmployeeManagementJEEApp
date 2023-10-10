<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<c:if test="${not empty requestScope.error}">
    <div class="error-message">
        Error: ${requestScope.error}
    </div>
</c:if>
<div class="container">
    <h1>Edit Client</h1>
    <form action="${request.contextPath}/client?action=edit" method="post">
        <input type="hidden" name="action" value="edit">
        <label for="code">Client Code:</label>
        <input type="text" id="code" name="code" value="${client.code}" readonly><br>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" value="${client.nom}" required><br>
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" value="${client.prenom}" required><br>
        <label for="dateN">Date de Naissance (YYYY-MM-DD):</label>
        <input type="date" id="dateN" name="dateN" value="${client.dateN}" required><br>
        <label for="tel">Tel:</label>
        <input type="text" id="tel" name="tel" value="${client.tel}" required><br>
        <label for="adress">Adresse:</label>
        <input type="text" id="adress" name="adress" value="${client.adress}" required><br>
        <input type="submit" value="Update Client">
    </form>
</div>
</body>
</html>
