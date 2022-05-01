<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/Main.css">
	<title>Зарплатный калькулятор</title>
</head>
<body>
	<header class="header">
		<div class="container">
				<ul class="menu">
					<li><a href="GroupInfo.jsp" class="menu-href">О команде</a></li>
					<li><a href="Login.jsp" class="menu-href">Выход</a></li>
				</ul>
		</div>
	</header>
	<section>
		<div class="container wrapper">
			<h1 class="h1">Зарплатный калькулятор</h1>
			<form class="calc" action="${pageContext.request.contextPath}/MainServlet" method="post">
				<label for="surname">Фамилия</label>
				<input class="input" type="text" name="surname" id="surname" value="${surname}" required>

				<label for="name">Имя</label>
				<input class="input" type="text" name="name" id="name" value="${name}" required>

				<label for="patronumic">Отчество</label>
				<input class="input" type="text" name="patronumic" id="patronumic" value="${patronumic}" required>

				<label for="period">Тип периода оплаты</label>
				<!--<input class="input" type="text" name="period" id="period" value="${period}">-->
				<select name="period" size="1" required>
					<option selected value="">Выберите период
					<option>Подневная
					<option>Почасовая
				</select>


				<label for="tariff-rate">Тарифная ставка (руб)</label>
				<input class="input" type="text" name="tariffRate" id="tariffRate" value="${tariffRate}" required>

				<label for="work-time">Количество отработанного времени</label>
				<input class="input" type="text" name="workTime" id="workTime" value="${workTime}" required>

				<label for="resident">Принадлежность к государству</label>
				<!--<input class="input" type="text" name="resident" id="resident" value="${resident}" required>-->
				<select name="resident" size="1" required>
					<option selected value="">Выберите принадлежность
					<option>Резидент
					<option>Не резидент
				</select>
				
				<div class="error">
					<p class="errMsg">
						${error_msg}
					</p>
				</div>

				<div class="log-btn">
					<input class="btn" type="submit" name="sign" value="Рассчитать">
				</div>

			</form>
		</div>
	</section>
	
</body>
</html>