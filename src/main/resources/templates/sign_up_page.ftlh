<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
</head>
<body>
<#if error?has_content>
    <div class="reg-container">
        <p>Error: ${error}</p>
    </div>
<#else>
</#if>
<form action="/signUp" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="email" type="email" placeholder="EMAIL"/>
    <input name="password" type="password" placeholder="PASSWORD"/>
    <input name="username" type="text" placeholder="USERNAME"/>
    <input type="submit" value="SIGN UP"/>
</form>
</body>
</html>
<#if info?has_content>
    <div class="reg-container">
        <p>info: ${info}</p>
    </div>
<#else>
</#if>