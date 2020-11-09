<#import "parts/common.ftlh" as c>

<@c.page>
<form action="/authorization" method="post">
    <div class="form-row">
        <label for="heading">Войти</label>
    </div>
    <div class="form-row">
        <input id="user_id" type="hidden" name="user_id">
        <div class="form-group col-md-6">
            <label for="inputLogin">Логин</label>
            <input id="username" type="text" name="username" class="form-control" placeholder="Введите логин">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Пароль</label>
            <input id="password" name="text" type="password" class="form-control" placeholder="Введите пароль">
        </div>
    </div>
    <input class="btn btn-primary  mb-4" type="submit" value="Войти">
</form>
</@c.page>

