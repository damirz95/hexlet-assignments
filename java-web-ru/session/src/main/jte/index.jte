@import exercise.dto.LoginPage
@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page
@template.layout.page(
content=@`
    <main>
        @if(page.getName() == null)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
        @if(page.getName() != null)
            <div>
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <label>${String.valueOf(page.getName())}</label>
                    <input type="submit" value="Выйти">
                </form>
            </div>
        @endif
    </main>
`
)