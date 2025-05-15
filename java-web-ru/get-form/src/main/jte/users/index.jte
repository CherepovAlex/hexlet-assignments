@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Пользователи</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
    <div class="col-lg-8 mx-auto p-4 py-md-5">
        <main>
            <h1>Пользователи</h1>

            <div class="search-box">
                <form action="/users" method="get">
                    <input type="text" name="term" value="${page.getTerm()}"
                           placeholder="Search by first name..." class="form-control" />
                    <button type="submit" class="btn btn-primary mt-2">Search</button>
                    @if(page.getTerm() != null && !page.getTerm().isEmpty())
                        <a href="/users" class="btn btn-link mt-2">Show all</a>
                    @endif
                </form>
            </div>

            @if(page.getUsers().isEmpty())
                <div class="alert alert-warning mt-3">
                    @if(page.getTerm() != null && !page.getTerm().isEmpty())
                        <p>No users found matching "${page.getTerm()}"</p>
                        <p><a href="/users" class="btn btn-sm btn-outline-primary">Show all users</a></p>
                    @else
                        <p>No users available</p>
                    @endif
                </div>
            @else
                @if(page.getTerm() != null && !page.getTerm().isEmpty())
                    <p>Found ${page.getUsers().size()} users matching "${page.getTerm()}"</p>
                @endif

                <div class="list-group mt-3">
                    @for(var user : page.getUsers())
                        <div class="list-group-item">
                            <h5 class="mb-1">${user.getFirstName()} ${user.getLastName()}</h5>
                            <small class="text-muted">${user.getEmail()}</small>
                        </div>
                    @endfor
                </div>
            @endif

            <p class="mt-3"><a href="/" class="btn btn-outline-secondary">Back to home</a></p>
        </main>
    </div>
</body>
</html>