@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <table>
        <caption>Пользователь</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name Last Name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${page.getUser().getId()}</td>
            <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
        </tbody>
    </table>
`
)
