<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Clients</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
    <h1>List Clients</h1>
    <table>
        <thead>
        <tr>
            <th>Client Code</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Date de Naissance</th>
            <th>Tel</th>
            <th>Adresse</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.code}</td>
                <td>${client.nom}</td>
                <td>${client.prenom}</td>
                <td>${client.dateN}</td>
                <td>${client.tel}</td>
                <td>${client.adress}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
