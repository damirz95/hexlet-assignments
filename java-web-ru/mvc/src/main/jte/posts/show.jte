@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <div class="mx-auto p-4 py-md-5">
                <h1>${page.getPost().getName()}</h1>
            </div>

            <div class="mx-auto p-4 py-md-5">
                ${page.getPost().getBody()}
            </div>
            <!-- BEGIN -->
            <div class="mx-auto p-4 py-md-5">
                <a href="/posts/${page.getPost().getId()}/edit"><h5>Редактировать</h5></a>
            </div>
            <!-- END -->
        </main>
    `
)
