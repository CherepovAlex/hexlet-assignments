@param exercise.dto.users.UserPage page
@template.exerecise.layout.page(
    content = @`
        <div class="card">
            <div class="card-body">
                <h2 class="card-title mb-4">User Details</h2>
                <dl class="row">
                    <dt class="col-sm-3">ID</dt>
                    <dd class="col-sm-9">${page.getUser().getId()}</dd>

                    <dt class="col-sm-3">First Name</dt>
                    <dd class="col-sm-9">${page.getUser().getFirstName()}</dd>

                    <dt class="col-sm-3">Last Name</dt>
                    <dd class="col-sm-9">${page.getUser().getLastName()}</dd>

                    <dt class="col-sm-3">Email</dt>
                    <dd class="col-sm-9">${page.getUser().getEmail()}</dd>
                </dl>
                <a href="/users" class="btn btn-primary">Back to Users</a>
            </div>
        </div>
    `
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2023 User Manager | Users Page</p>
        </div>
    `
)