<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/Main.css">
	<title>Вычисления</title>
</head>
<body>
	<header class="header">
		<div class="container">
				<ul class="menu">
					<li><a href="Index.jsp" class="menu-href">Назад</a></li>
					<li><a href="Login.jsp" class="menu-href">Выход</a></li>
				</ul>
		</div>
	</header>
	<section>
		<div class="container wrapper results">
			<h1 class="h1">Результаты вычисления</h1>
			<form class="calc" action="Calculations.jsp">
				<h2>Исходные данные:</h2>
				<div class="out">
					<label class="results">Фамилия:</label>
					<input class="output" type="text" name="surname" id="surname" value="${surname}" >
				</div>
				
				<div class="out">
					<label class="results">Имя:</label>
					<input class="output" type="text" name="name" id="name" value="${name}" >
				</div>
				
				<div class="out">
					<label class="results">Отчество: </label>
					<input class="output" type="text" name="patronumic" id="patronumic" value="${patronumic}" >
				</div>
				
				<div class="out">
					<label class="results">Тип периода оплаты:</label>
					<input class="output" type="text" name="period" id="period" value="${isDay}" >
				</div>

				<div class="out">
					<label class="results">Тарифная ставка (руб): </label>
					<input class="output" type="text" name="tariff-rate" id="tariff-rate" value="${tariff_rate}">
				</div>
				
				<div class="out">
					<label class="results">Количество отработанного времени: </label>
					<input class="output" type="text" name="work-time" id="work-time" value="${work_time}">
				</div>
				
				<div class="out">
					<label class="results">Принадлежность к государству:</label>
					<input class="output" type="text" name="resident" id="resident" value="${isResident}">
				</div>
				

				<h2>Итог:</h2>
				<label class="results"><span>Заработная плата (руб): ${salary}</span></label>
				
				<h3 class="h3">Отчисления:</h3>
				<div class="out ndfl">
					<label class="results">НДФЛ (руб):</label>
					<input class="output" type="text" name="incomeTax" id="incomeTax" value="${incomeTax}">
				</div>

				<p class="results">Пенсионное (руб): ${pensionTax}</p>


				<p class="results">Медицинское (руб): ${medicalTax}</p>

				<p class="results">Социальное (руб): ${socialTax}</p>

				<p class="results">Травматизм (руб): ${injuryTax}</p>

				<div class="log-btn">
					<input class="btn " type="submit" name="sign" value="Рассчетный лист">
				</div>
				
			</form>
			

			
		</div>
	</section>
	
</body>
</html>