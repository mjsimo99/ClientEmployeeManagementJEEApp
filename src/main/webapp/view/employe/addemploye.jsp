<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employe</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>

<%@ include file="../includes/header.jsp" %>


<c:if test="${not empty requestScope.error}">
    <div class="error-message">
        Error: ${requestScope.error}
    </div>
</c:if>
<div class="container1">
    <h1>Add Employe</h1>

    <form action="${request.contextPath}/employe?action=add" method="post">
        <input class="form-inputs" type="hidden" name="action" value="add">
        <label for="matricule">Employe Matricule:</label>
        <input class="form-inputs" type="text" id="matricule" name="matricule" required><br>
        <label for="dateRecrutement">Date Recruitment:</label>
        <input class="form-inputs" type="date" id="dateRecrutement" name="dateRecrutement" required><br>
        <label for="emailAdresse">Email:</label>
        <input class="form-inputs" type="email" id="emailAdresse" name="emailAdresse" required><br>
        <label for="nom">Last Name:</label>
        <input class="form-inputs" type="text" id="nom" name="nom" required><br>
        <label for="prenom">First Name:</label>
        <input class="form-inputs" type="text" id="prenom" name="prenom" required><br>
        <label for="dateN">Date of Birth :</label>
        <input class="form-inputs" type="date" id="dateN" name="dateN" required><br>
        <label for="tel">Phone:</label>
        <input class="form-inputs" type="text" id="tel" name="tel" required><br>
        <label for="adress">Address:</label>
        <input class="form-inputs" type="text" id="adress" name="adress" required><br>
        <button type="submit" class="submit-button">Add Employe</button>

    </form>
</div>
<%@ include file="../includes/footer.jsp" %>

</body>
</html>
