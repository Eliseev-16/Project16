<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="Main.css">
	<title>Вход</title>
</head>
<body>
	<section>
		<div class="container wrapper">
			<h1 class="h1">Вход</h1>
			<form class="calc login" action="Index.jsp">
				<label for="log">Логин</label>
				<input class="input" type="text" name="log" id="log" value="${log}" required>

				<label for="password">Пароль</label>
				<input class="input" type="password" name="password" id="password" value="${password}" required>

				<div class="log-btn">
					<input class="btn" type="submit" name="sign" value="Войти">
				</div>
					
			</form>
		</div>
	</section>
	
</body>
</html>