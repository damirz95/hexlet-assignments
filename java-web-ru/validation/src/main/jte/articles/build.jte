@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    <div>
        @if(page.getErrors() != null)
            <ul>
                @for(var validator: page.getErrors().values())
                    @for(var error: validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
    </div>
    <h2>Create articles</h2>
    <div>
        <form action="/articles" method="post" >
            <div>
                <label>
                    title
                    <input type="text" name="title" value="${page.getTitle()}">
                </label>
            </div>
            <div>
                <label>
                    content
                    <textarea  rows="15" cols="40" name="content" placeholder="${page.getContent()}"></textarea>
                </label>
            </div>
            <input type="submit" value="Отправить">
        </form>
    </div>
`
)