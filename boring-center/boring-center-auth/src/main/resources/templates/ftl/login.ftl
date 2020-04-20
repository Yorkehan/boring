<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="yoursite.com">

    <title>登陆</title>

    <link rel="shortcut icon" type="image/icon" href="http://koder.top/demo/authfy/demo/images/favicon-16x16.png">

    <link rel="stylesheet" href="/css/login-style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if IE]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div data-v-42127c5e="" id="dm-extension-sniffer"><!----></div>
<!-- Start Preloader -->

<!-- Preloader End -->
<div class="container-fluid">
    <div class="row">
        <div class="authfy-container col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
            <div class="col-sm-5 authfy-panel-left">
                <div class="brand-col">
                    <div class="headline">
                        <!-- brand-logo start -->
                        <div class="brand-logo">
                            <img src="" width="150" alt="brand-logo">
                        </div><!-- ./brand-logo -->
                        <p>快速登陆</p>
                        <!-- social login buttons start -->
                        <div class="row social-buttons">
                            <div class="col-xs-4 col-sm-4 col-md-12">
                                <a
                                   class="btn btn-block btn-github">
                                    <i class="fa fa-github"></i> <span class="hidden-xs hidden-sm">Github登陆</span>
                                </a>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-12">
                                <a href=""
                                   class="btn btn-block btn-facebook">
                                    <i class="fa fa-facebook"></i> <span class="hidden-xs hidden-sm">facebook登陆</span>
                                </a>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-12">
                                <a href=""
                                   class="btn btn-block btn-twitter">
                                    <i class="fa fa-twitter"></i> <span
                                            class="hidden-xs hidden-sm">twitter登陆</span>
                                </a>
                            </div>
                            <div class="col-xs-4 col-sm-4 col-md-12">
                                <a href=""
                                   class="btn btn-block btn-google">
                                    <i class="fa fa-google-plus"></i> <span class="hidden-xs hidden-sm">google登陆</span>
                                </a>
                            </div>
                        </div><!-- ./social-buttons -->
                    </div>
                </div>
            </div>
            <div class="col-sm-7 authfy-panel-right">
                <!-- authfy-login start -->
                <div class="authfy-login">
                    <!-- panel-login start -->
                    <div class="authfy-panel panel-login text-center active">
                        <div class="authfy-heading">
                            <h3 class="auth-title">账号登陆</h3>
                            <p>还没有账号? <a class="lnk-toggler" data-panel=".panel-signup"
                                                         href="">免费注册!</a></p>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12">
                                <form name="loginForm" class="loginForm"
                                      action="/oauth/form" method="POST">
                                    <div class="form-group wrap-input">
                                        <input type="text" class="form-control " name="username"
                                               placeholder="Email address">
                                        <span class="focus-input"></span>
                                    </div>
                                    <div class="form-group wrap-input">
                                        <div class="pwdMask">
                                            <input type="password" class="form-control password" name="password"
                                                   placeholder="Password">
                                            <span class="focus-input"></span>
                                            <span class="fa fa-eye-slash pwd-toggle"></span>
                                        </div>
                                    </div>
                                    <!-- start remember-row -->
                                    <div class="row remember-row">
                                        <div class="col-xs-6 col-sm-6">
                                            <label class="checkbox text-left">
                                                <input type="checkbox" value="remember-me">
                                                <span class="label-text">记住我</span>
                                            </label>
                                        </div>
                                        <div class="col-xs-6 col-sm-6">
                                            <p class="forgotPwd">
                                                <a class="lnk-toggler" data-panel=".panel-forgot"
                                                   href="">忘记密码?</a>
                                            </p>
                                        </div>
                                    </div> <!-- ./remember-row -->
                                    <div class="form-group">
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div> <!-- ./panel-login -->
                    <!-- panel-signup start -->
                    <div class="authfy-panel panel-signup text-center">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12">
                                <div class="authfy-heading">
                                    <h3 class="auth-title">免费注册!</h3>
                                </div>
                                <form name="signupForm" class="signupForm"
                                      action="" method="POST">
                                    <div class="form-group wrap-input">
                                        <input type="email" class="form-control" name="email"
                                               placeholder="邮箱">
                                        <span class="focus-input"></span>
                                    </div>
                                    <div class="form-group wrap-input">
                                        <input type="text" class="form-control" name="username" placeholder="用户名">
                                        <span class="focus-input"></span>
                                    </div>
                                    <div class="form-group wrap-input">
                                        <div class="pwdMask">
                                            <input type="password" class="form-control" name="password"
                                                   placeholder="密码">
                                            <span class="focus-input"></span>
                                            <span class="fa fa-eye-slash pwd-toggle"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <p class="term-policy text-muted small">我同意<a
                                                    href="">隐私政策</a>和<a
                                                    href="">服务条款</a>.</p>
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                                            立即注册
                                        </button>
                                    </div>
                                </form>
                                <a class="lnk-toggler" data-panel=".panel-login"
                                   href="">已经有账号?</a>
                            </div>
                        </div>
                    </div> <!-- ./panel-signup -->
                    <!-- panel-forget start -->
                    <div class="authfy-panel panel-forgot">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12">
                                <div class="authfy-heading">
                                    <h3 class="auth-title">重制你的密码</h3>
                                    <p>请在下面填写您的电子邮件地址，我们将向您发送一封包含进一步说明的电子邮件。</p>
                                </div>
                                <form name="forgetForm" class="forgetForm"
                                      action="" method="POST">
                                    <div class="form-group wrap-input">
                                        <input type="email" class="form-control" name="username"
                                               placeholder="Email address">
                                        <span class="focus-input"></span>
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                                          恢复你的密码
                                        </button>
                                    </div>
                                    <div class="form-group">
                                        <a class="lnk-toggler" data-panel=".panel-login"
                                           href="">已经有帐号了？</a>
                                    </div>
                                    <div class="form-group">
                                        <a class="lnk-toggler" data-panel=".panel-signup"
                                           href="">还没有帐号？</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div> <!-- ./panel-forgot -->
                </div> <!-- ./authfy-login -->
            </div>
        </div>
    </div> <!-- ./row -->
</div> <!-- ./container -->

<!-- Javascript Files -->

<!-- initialize jQuery Library -->
<script src="/js/jquery-2.2.4.min.js"></script>

<!-- for Bootstrap js -->
<script src="/js/bootstrap.min.js"></script>

<!-- Custom js-->
<script src="/js/custom.js"></script>

</body>
</html>