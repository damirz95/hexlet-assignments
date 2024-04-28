@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <div>
                @for(var post: page.getPostsPage())
                        <div>
                            <h4><a href="/posts/${post.getId()}">${post.getName()}</a></h4>
                            <p> ${post.getBody()}</p>
                        </div>
                @endfor
                @if(page.getPageNumber() == 1)
                    <a href="${"/posts?page=" + (page.getPageNumber() + 1)}">страница ${page.getPageNumber() + 1}</a>
                @endif
                @if(page.getPageNumber() != 1)
                    <a href="${"/posts?page=" + (page.getPageNumber() - 1)}">страница ${page.getPageNumber() - 1}</a>
                    <a href="${"/posts?page=" + (page.getPageNumber() + 1)}">страница ${page.getPageNumber() + 1}</a>
                @endif
            </div>
        </main>
    </div>
`
)
