<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container mt-5">

    <!-- Welcome Card -->
    <div class="card shadow-lg border-0 rounded-3">
        <div class="card-body text-center p-5">
            <h1 class="display-4 fw-bold text-primary mb-3">
                Welcome, ${name}! 👋
            </h1>
            <p class="lead text-muted mb-4">
                Stay productive and manage your tasks with ease.
            </p>
            
            <!-- Manage Todos Button -->
            <a href="list-todos" class="btn btn-lg btn-success px-4 py-2">
                <i class="bi bi-check2-square"></i> Manage Your Todos
            </a>
        </div>
    </div>

</div>

<%@ include file="common/footer.jspf" %>
