<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<style>
#loginpage {
    background: linear-gradient(45deg, rgba(207, 163, 4, 0.8) 0%, rgba(255, 255, 224, 0.5) 100%);
}

#loginHead {
    padding-top: 130px;
}

.login-form {
    position: relative;
    width: 500px;
    background-color: #ffffff;
    border-radius: 4px;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.1);
    box-sizing: border-box;
    margin: 70px auto 10px;
    overflow: hidden;
}

.login-form-panel {
    padding: 30px 50px 50px 50px;
    box-sizing: border-box;
}

.login-form-header {
    margin: 0 0 20px;
}

.login-form-header h1 {
    padding: 4px 0;
    color: #000000;
    font-size: 24px;
    font-weight: 700;
    text-transform: uppercase;
}

.form-group {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    margin: 0 0 20px;
}

.form-group input {
    outline: none;
    display: block;
    background: rgba(0, 0, 0, 0.1);
    width: 100%;
    border: 0;
    border-radius: 7px;
    box-sizing: border-box;
    padding: 10px 20px;
    font-weight: 500;
}

.form-group .form-remember-me {
    font-size: 12px;
    font-weight: 400;
    letter-spacing: 0;
    text-transform: none;
}

.form-group .form-remember-me input[type='checkbox'] {
    display: inline-block;
    width: auto;
    margin: 0 10px 0 0;
}

.form-group .forgot-pass{
    color: #4285F4;
    font-size: 12px;
    text-decoration: none;
}

.form-group:last-child {
    margin: 0;
}

.form-group .login-btn {
    background: #000000;
    width: 100%;
    border: 0;
    border-radius: 7px;
    padding: 12px 20px;
    color: #FFFFFF;
    font-weight: 500;
    text-transform: uppercase;
    cursor: pointer;
}
</style>

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>


<body>
<input type="checkbox" id="check">
<header>
    <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
    </label>
    <div class="left">
        <h1><img src="https://pics.harstatic.com/office/986021.png" width="66" height="54" class="company_logo">Yun Global LLC</h1>
    </div>
</header>
<div class="content">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <body>
    <div class="content" id="loginpage">
        <h2 id="loginHead">Welcome!</h2>

        <!-- Login form starts here -->
        <div class="login-form">
            <div class="login-form-panel">
                <div class="login-form-header">
                    <h1>Log In</h1>
                </div>
                <div class="login-form-content">
                    <form action="/Home">
                        <div class="form-group">
                            <input type="text" placeholder="Username" name="username">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" name="password">
                        </div>
                        <div class="form-group">
                            <label class="form-remember-me">
                                <input type="checkbox">Remember Me
                            </label>
                            <a class="forgot-pass" href="#">Forgot Password?</a>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="login-btn">Log In</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Login form ends here -->

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>