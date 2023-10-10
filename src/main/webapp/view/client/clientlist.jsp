<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Clients</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
</head>
<body>
<div class="container">
    <h1>List Clients</h1>
    <form method="GET" action="${pageContext.request.contextPath}/client">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" placeholder="Search by Last Name">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
        <tr>
            <th>Client Code</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Date of Birth</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Action</th>
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
                <td>
                    <!-- Update Button -->
                    <button onclick="showUpdateAlert('${client.code}')">Update</button>
                    <!-- Delete Button -->
                    <button onclick="showDeleteAlert('${client.code}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function showUpdateAlert(clientCode) {
        swal({
            title: "Update Client?",
            text: "Do you want to update this client?",
            icon: "info",
            buttons: true,
            dangerMode: false,
        })
            .then((willUpdate) => {
                if (willUpdate) {
                    window.location.href = "${pageContext.request.contextPath}/client?action=edit&code=" + clientCode;
                }
            });
    }
</script>

<script>
    function showDeleteAlert(clientCode) {
        swal({
            title: "Delete Client?",
            text: "This client will be permanently deleted!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    window.location.href = "${pageContext.request.contextPath}/client?action=delete&code=" + clientCode;
                }
            });
    }
</script>
</body>
</html>
