

<%@ include file="../includes/header.jsp" %>

    <h1>List Employes</h1>
    <form class="form" method="GET" action="${pageContext.request.contextPath}/employe">
        <input class="text" type="text" name="action" value="search" hidden>
        <input type="text" name="query" placeholder="Search by Email" class="input-search">
        <button type="submit">Search</button>
    </form>

    <table class="show-table">
        <thead>
        <tr>
            <th>Employe MAtricule</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Email:</th>
            <th>Date of Birth</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Date Recruitment:</th>

            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employes}" var="employe">
            <tr>
                <td>${employe.matricule}</td>
                <td>${employe.nom}</td>
                <td>${employe.prenom}</td>
                <td>${employe.emailAdresse}</td>
                <td>${employe.dateN}</td>
                <td>${employe.tel}</td>
                <td>${employe.adress}</td>
                <td>${employe.dateRecrutement}</td>
                <td>
                    <!-- Update Button -->
                    <button class="button" onclick="showUpdateAlert('${employe.matricule}')">Update</button>
                    <!-- Delete Button -->
                    <button class="button" onclick="showDeleteAlert('${employe.matricule}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

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

<%@ include file="../includes/footer.jsp" %>

</body>
</html>
