<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>认证</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>

<body class="sign_body">
<div class="container form-margin-top">
    <form class="form-signin" action="/oauth/form" method="post">
        <h2 class="form-signin-heading" align="center">统一认证系统</h2>
        <input type="text" name="username" class="form-control form-margin-top" placeholder="账号" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="密码" required style="margin-top: 10px">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        <a href="https://github.com/login/oauth/authorize?client_id=yourclientid&redirect_uri=yourredirect_uri">github登录</a>
        <#if error??>
            <span style="color: red; ">${error}</span>
        </#if>
    </form>
</div>
<footer>
    <p>support by: YORKEHAN</p>

</footer>
</body>
</html>
