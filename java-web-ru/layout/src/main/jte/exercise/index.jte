@template.exercise.layout.page(
    content = @`
        <div class="jumbotron">
            <h1 class="display-4">Welcome to User Manager!</h1>
            <p class="lead">Manage your users with our simple and intuitive interface.</p>
            <hr class="my-4">
            <p>Get started by viewing the list of users.</p>
            <a class="btn btn-primary btn-lg" href="/users" role="button">View Users</a>
        </div>
    `
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2023 User Manager | Users Page</p>
        </div>
    `
)