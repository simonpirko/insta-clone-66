<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Создание поста</title>
</head>
<body>
<h1>Создание нового поста</h1>
<form action="createPost" method="post" enctype="multipart/form-data">
    <label for="image">Изображение:</label>
    <input type="file" name="image" id="image" accept="image/*"><br><br>

    <label for="text">Текст:</label>
    <textarea name="text" id="text" rows="5" cols="50"></textarea><br><br>

    <input type="submit" value="Создать пост">
</form>
</body>
</html>