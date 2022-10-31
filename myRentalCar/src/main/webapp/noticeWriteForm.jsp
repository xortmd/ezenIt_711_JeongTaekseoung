<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/form.css">
    <title>글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <div class="form-container">
        <form method="post" action="NoticeWrite">
            <input type="text" name="title" placeholder="제목" required>
            <textarea name="content" rows="20" placeholder="글내용" required></textarea>
            <input type="submit" value="글등록">
        </form>
    </div>
</body>
</html>