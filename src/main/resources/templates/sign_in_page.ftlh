<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
<#if error?has_content>
    <div class="reg-container">
        <p>Error: ${error}</p>
    </div>
<#else>
</#if>
<#if info?has_content>
    <div class="reg-container">
        <p>info: ${info}</p>
    </div>
<#else>
</#if>
<form action="/signIn" method="post">
    <input name="email" type="email" placeholder="EMAIL"/>
    <input name="password" type="password" placeholder="PASSWORD"/>
    <input type="submit" value="SIGN IN"/>
</form>
</body>
</html>