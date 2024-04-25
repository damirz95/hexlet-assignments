@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>First Name & Last Name</th>
                <th>email</th>
            </tr>
        </thead>
        <tbody>
        @for(var user: page.getUsers())
            <tr>
                <div>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </div>
            </tr>
        @endfor
        </tbody>
    </table>
`
)