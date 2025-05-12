@param exercise.dto.users.UsersPage page

<h1>${page.getHeader()}</h1>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        @for (exercise.model.User user : page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td><a href="/users/${user.getId()}">View</a></td>
            </tr>
        @endfor
    </tbody>
</table>