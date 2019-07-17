<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>
<c:url value="/css/stylesheet.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">

<link href="https://fonts.googleapis.com/css?family=Caveat&display=swap" rel="stylesheet">
</head>

<body>
	<header>
		<c:url value="img/logo.png" var="headerImgURL" />
		<img src="${headerImgURL}" />
	</header>
	<nav>
		<ul>
			<li><a href="<c:url value="/"/>">Home</a></li>
			<li><a href="<c:url value="/survey"/>">Survey</a></li>

		</ul>
	</nav>