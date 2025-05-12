@param exercise.dto.users.UserPage page

<h1>User Details</h1>

<p>ID: ${page.getUser().getId()}</p>
<p>First Name: ${page.getUser().getFirstName()}</p>
<p>Last Name: ${page.getUser().getLastName()}</p>
<p>Email: ${page.getUser().getEmail()}</p>

<a href="/users">Back to all users</a>