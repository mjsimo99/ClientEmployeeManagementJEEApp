
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
</head>
<body>
<div class="container">
    <h1>List Employes</h1>
    <form method="GET" action="${pageContext.request.contextPath}/employe">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" placeholder="Search by Email">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Employe MAtricule</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Date of Birth</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${employes}" var="employe">
            <tr>
                <td>${employe.matricule}</td>
                <td>${employe.nom}</td>
                <td>${employe.prenom}</td>
                <td>${employe.dateN}</td>
                <td>${employe.tel}</td>
                <td>${employe.adress}</td>
                <td>
                    <!-- Update Button -->
                    <button onclick="showUpdateAlert('${employe.matricule}')">Update</button>
                    <!-- Delete Button -->
                    <button onclick="showDeleteAlert('${employe.matricule}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function showUpdateAlert(employeMatricule) {
        swal({
            title: "Update Employe?",
            text: "Do you want to update this employe?",
            icon: "info",
            buttons: true,
            dangerMode: false,
        })
            .then((willUpdate) => {
                if (willUpdate) {
                    window.location.href = "${pageContext.request.contextPath}/employe?action=edit&matricule=" + employeMatricule;
                }
            });
    }
</script>

<script>
    function showDeleteAlert(employeMatricule) {
        swal({
            title: "Delete Employe?",
            text: "This employe will be permanently deleted!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    window.location.href = "${pageContext.request.contextPath}/employe?action=delete&matricule=" + employeMatricule;
                }
            });
    }
</script>
</body>
</html>
