<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>Learn To Seek Truth | Note</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
<header>
		<div class="container">
			<div id="branding">
				<h1>
					<span class="highlight">Learn</span> ToSeekTruth
				</h1>
			</div>
		</div>
	</header>
	
	<td>Username: </td>
<td><input type="text" value="<%= session.getAttribute("userID") %>" /></td>

</body>
</html>