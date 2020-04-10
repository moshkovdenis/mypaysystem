<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<table width="100%">
    <tr>
        <td  align="left"><img src="${pageContext.servletContext.contextPath}/views/headers/logo.png " width="100" height="100" alt="ПС"></td>
        <td width="40%" align="center"><h1>Платежная система 1.0</h1></td>
        <td width="30%" align="right">
            <form id="profileHeaderSystemForm" action="profile.jsp" method="post">
                <input id="profileHeaderSystemButton" type="submit" name="profileButton" value="Профиль" style="width: 200px; height: 50px; font-size: medium"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>