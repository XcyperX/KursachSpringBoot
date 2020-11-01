<#macro login stocks>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <form id="createUser" name="createUser" action="/users" method="post">
                    <div class="form-row">
                        <label for="heading">Добавить нового пользователя</label>
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
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputRole">Уровень доступа</label>
                            <select id="role_id" class="form-control">
                                <#list roles as role>
                                    <option value="${role.roleId}">${role.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputStock">Название склада</label>
                            <select id="stock_id" class="form-control">
                                <#list stocks as stock>
                                    <option value="${stock.stockId}">${stock.stockName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <input class="btn btn-primary  mb-4" type="button" onclick="submitNewUser()" value="Добавить сотрудника">
                </form>
            </div>
        </div>
            <div class="row">
            <div class="col-sm">
                <label for="addRoleLabel">Добавить роль</label>
                <form id="addRole" name="addRole">
                    <input id="name" type="text" name="name" class="form-control mb-3" placeholder="Введите название роли">
                    <input class="btn btn-primary" type="button" onclick="submitNewRole()" value="Добавить роль">
                </form>
            </div>
            <div class="col-sm">
                <label for="addStockLabel">Добавить склад</label>
                <form id="addStock" name="addStock">
                    <input id="stock_id" type="hidden" name="stock_id">
                    <input id="name" type="text" name="stockName" class="form-control mb-3" placeholder="Введите название склада">
                    <input class="btn btn-primary" type="button" value="Добавить склад" onclick="submitNewStock()">
                </form>
            </div>
        </div>
    </div>
</#macro>
<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>

