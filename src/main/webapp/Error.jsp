<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/Main.css">
	<title>Ошибка</title>
</head>
<body>
	<header class="header">
		<div class="container">
				<ul class="menu">
					<li><a href=history.back(); class="menu-href" onclick="javascript:history.go(-1)">Назад</a></li>
				</ul>
		</div>
	</header>
	<section id="info" class="info">
			
		<div class="container">
			<h2 class="section-title">
				Ошибка
			</h2>
			<div>
				<p class="error-text">
						${errorText}
				</p>
			</div>

			<div class="about-err">
				<img src="pictures/error.jpg" alt="Error" class="error-img">
			</div>
				
		</div>	

	</section>
</body>
</html>