<#import "parts/common.ftlh" as c>

<@c.page>
    <form id="updateUser" name="updateUser">
        <div class="form-row">
            <label for="heading">Изменить пользователя</label>
        </div>
        <div class="form-row">
            <input id="user_id" type="text" hidden name="user_id" value="${user.userId}">
            <div class="form-group col-md-6">
                <label for="inputLogin">Логин</label>
                <input id="username" type="text" name="username" class="form-control" placeholder="Введите логин" value="${user.username}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Пароль</label>
                <input id="password" name="password" type="text" class="form-control" placeholder="Введите пароль" value="${user.password}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputRole">Уровень доступа</label>
                <select id="role_id" class="form-control">
                    <#list roles as role>
                        <#if role.roleId == user.roleId>
                            <option value="${role.roleId}" selected>${role.name}</option>
                        </#if>
                        <option value="${role.roleId}">${role.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputStock">Название склада</label>
                <select id="stock_id" class="form-control">
                    <#list stocks as stock>
                        <#if stock.stockId == user.stockId>
                            <option value="${stock.stockId}" selected>${stock.stockName}</option>
                        </#if>
                        <option value="${stock.stockId}">${stock.stockName}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <input class="btn btn-primary mb-4" type="button" onclick="submitUpdateUser()" value="Изменить сотрудника">
            </div>
            <div class="form-group col-md-6">
                <input class="btn btn-primary mb-4" type="button" onclick="deleteUser(${user.userId})" value="Удалить сотрудника">
            </div>
        </div>
    </form>
</@c.page>