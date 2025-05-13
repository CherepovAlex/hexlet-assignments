@params String content, String footer

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        footer {
            margin-top: 2rem;
            padding: 1rem;
            background-color: #f8f9fa;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/">Home</a>
            <div class="navbar-nav">
                <a class="nav-link" href="/users">Users</a>
            </div>
        </div>
    </nav>

    <main class="container mt-4">
        ${content}
    </main>

    <footer class="mt-5">
        ${footer}
    </footer>
</body>

</html>