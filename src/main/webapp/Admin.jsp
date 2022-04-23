<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="Main.css">
	<title>Зарплатный калькулятор</title>
</head>
<body>
	<header class="header">
		<div class="container">
				<ul class="menu">
					<!--<li><a href="#" class="menu-href">О команде</a></li>-->
					<li><a href="Login.jsp" class="menu-href">Выход</a></li>
				</ul>
		</div>
	</header>
	<section>
		<div class="container wrapper">
			<h1 class="h1">Панель администратора</h1>
			<form class="calc" action="">
				<label for="pensionTax">Пенсионное страхование (%)</label>
				<input class="input" type="text" name="pensionTax" id="pensionTax" value="${pensionTax}" required>

				<label for="medicalTax">Медицинское страхование (%)</label>
				<input class="input" type="text" name="medicalTax" id="medicalTax" value="${medicalTax}" required>

				<label for="socialTax">Социальное страхование (%)</label>
				<input class="input" type="text" name="socialTax" id="socialTax" value="${socialTax}" required>

				<label for="incomeTax">НДФЛ для резидента РФ (%)</label>
				<input class="input" type="text" name="incomeTax" id="incomeTax" value="${incomeTax}">

				<label for="incomeTax">НДФЛ для нерезидента РФ (%)</label>
				<input class="input" type="text" name="incomeTax" id="incomeTax" value="${incomeTax}">


				<label for="injuryTax">Травматизм (%)</label>
				<input class="input" type="text" name="injuryTax" id="injuryTax" value="${injuryTax}" required>

				<div class="log-btn">
					<input class="btn" type="submit" name="sign" value="Сохранить">
				</div>

			</form>
		</div>
	</section>
	
</body>
</html>