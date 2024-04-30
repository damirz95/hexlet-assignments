@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page
@template.layout.page(
    content=@`
        <main>
            @if(page.getError() != null)
                <div>
                    ${page.getError()}
                </div>
            @endif
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div>
                <label>
                    Имя
                    <input type="text" name="name"  placeholder="name">
                </label>
            </div>
            <div>
                <label>
                    Пароль
                    <input type="password" name="password" placeholder="password">
                </label>
            </div>
            <input type="submit"  value="Войти" />
        </form>
        </main>
    `
)