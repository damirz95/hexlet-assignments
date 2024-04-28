@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h3>${page.getPost().getName()}</h3>
            <div>
                ${page.getPost().getBody()}
            </div>
            <div>
                <a href="${NamedRoutes.postsPath()}">Все посты</a>
            </div>
        </main>
    </div>
`
)
