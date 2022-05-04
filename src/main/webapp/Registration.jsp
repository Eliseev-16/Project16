<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/Main.css">
<title>Регистрация</title>
</head>
<body>
	<section>
		<div class="container wrapper">
			<h1 class="h1">Регистрация</h1>
			<form class="calc login" action="${pageContext.request.contextPath}/Registration" method="post">
				<label for="log">Логин</label>
				<input class="input" type="text" name="log" id="log" value="${log}" required>
	
				<label for="password">Пароль</label>
				<input class="input" type="password" name="password" id="password" value="${password}" required>
				
				<div class="error">
					<p class="err-msg">
						${errorMsg}
					</p>
				</div>
				
				<div class="log-btn">
					<input class="btn" type="submit" name="sign" value="Зарегистрироваться">
				</div>
			
			</form>
		</div>
	</section>

</body>
</html>