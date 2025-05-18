@import exercise.dto.articles.BuildArticlePage;
@param BuildArticlePage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hello Hexlet!</title>
</head>
<body>
@if(page.getErrors() != null && !page.getErrors().isEmpty())
    <div class="alert alert-danger">
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    </div>
@endif
<form action="/articles" method="post">
  <div>
    <label>
      Название статьи
      <input type="text" name="title" value="${page.getTitle()}" />
    </label>
  </div>
  <div>
    <label>
      Содержание статьи
      <textarea name="content">${page.getContent()}</textarea>
    </label>
  </div>
  <input type="submit" value="Опубликовать" />
</form>
</body>
</html>