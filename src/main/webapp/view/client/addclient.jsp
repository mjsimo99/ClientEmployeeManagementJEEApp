<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>







<%@ include file="../includes/header.jsp" %>




<c:if test="${not empty requestScope.error}">
    <div class="error-message">
        Error: ${requestScope.error}
    </div>
</c:if>
<div class="container">
    <h1>Add Client</h1>
    <form action="${request.contextPath}/client?action=add" method="post">
        <input type="hidden" name="action" value="add">
        <label for="code">Client Code:</label>
        <input class="form-inputs" type="text" id="code" name="code" required><br>
        <label for="nom">Last Name:</label>
        <input class="form-inputs" type="text" id="nom" name="nom" required><br>
        <label for="prenom">First Name:</label>
        <input class="form-inputs" type="text" id="prenom" name="prenom" required><br>
        <label for="dateN">Date of Birth (YYYY-MM-DD):</label>
        <input class="form-inputs" type="date" id="dateN" name="dateN" required><br>
        <label for="tel">Phone:</label>
        <input class="form-inputs" type="text" id="tel" name="tel" required><br>
        <label for="adress">Address:</label>
        <input class="form-inputs" type="text" id="adress" name="adress" required><br>
        <%--  <input class="submit" type="submit" value="Add Client">--%>
        <button type="submit" class="submit-button">Add Client</button>

    </form>
</div>
<%@ include file="../includes/footer.jsp" %>

</body>
</html>
