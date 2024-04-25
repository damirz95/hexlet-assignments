@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <table>
        <caption>Пользователи</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name Last Name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        @for(var user: page.getUsers())
            <tr>
                <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        @endfor
        </tbody>
    </table>
        `
)
