@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
    <header>
        <h2><a href="/">На главную</a> <a href="/users">Пользователи</a></h2>
    </header>
    <main>
        ${content}
    </main>
    <footer>
        <h3><a href="/">PASS</a></h3>
    </footer>
</body>
</html>