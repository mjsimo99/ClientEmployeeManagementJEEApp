
<%@ include file="../includes/header.jsp" %>



<h1>List Clients</h1>
<form method="GET" action="${pageContext.request.contextPath}/client">
    <input type="text" name="action" value="search" hidden>
    <input type="text" name="query" placeholder="Search by Last Name" class="input-search">
    <button type="submit">Search</button>
</form>

<table class="show-table">
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
                <button class="update-button" onclick="showUpdateAlert('${client.code}')">Update</button>
                <button class="delete-button" onclick="showDeleteAlert('${client.code}')">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

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

<%@ include file="../includes/footer.jsp" %>


</body>
</html>
