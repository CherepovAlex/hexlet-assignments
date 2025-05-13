@param exercise.dto.users.UsersPage page
@template.exercise.layout.page(
    content = @`
        <h1 class="mb-4">Users List</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                @for (User user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>
                        <a href="/users/${user.getId()}">
                            ${user.getFirstName()} ${user.getLastName()}
                        </a>
                    </td>
                    <td>${user.getEmail()}</td>
                </tr>
                @endfor
            </tbody>
        </table>
    `
    footer = @`
        <div class="container text-center">
            <p class="text-muted mb-0">© 2023 User Manager | Users Page</p>
        </div>
    `
)