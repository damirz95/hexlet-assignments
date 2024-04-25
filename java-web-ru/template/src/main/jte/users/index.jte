@import exercise.dto.users.UsersPage
@param UsersPage usersP
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>${usersP.getHeader()}</title>
</head>
<body>
<h1>${usersP.getHeader()}</h1>
<div class="mx-auto p-4 py-md-5">
    <main>
        <p>Проверка</p>
            <div>
                <table>
                    <caption>Пользователи</caption>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                        <tbody>
                        @for(var user: usersP.getUsers())
                        <tr>
                            <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                            <td>${user.getFirstName()}</td>
                            <td>${user.getLastName()}</td>
                            <td>${user.getEmail()}</td>
                        </tr>
                        @endfor
                        </tbody>
                </table>
            </div>

    </main>
</div>
</body>
</html>
