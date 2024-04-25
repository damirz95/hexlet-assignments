@import exercise.dto.users.UserPage
@param UserPage userP
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>${userP.getHeader()}</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <h1>${userP.getHeader()}</h1>
        <table>
            <caption>Пользователь</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${userP.getUser().getId()}</td>
                    <td>${userP.getUser().getFirstName()}</td>
                    <td>${userP.getUser().getLastName()}</td>
                    <td>${userP.getUser().getEmail()}</td>
                </tr>
            </tbody>
        </table>
    </main>
</div>
</body>
</html>
