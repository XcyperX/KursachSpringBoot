<#macro login stocks>
    <form id="createUser" name="createUser" action="/users" method="post">
        <input id="username" type="text" name="username">
        <input id="password" type="text" name="password">
        <select id="role_id" class="custom-select">
            <#list roles as role>
                <option value="${role.roleId}">${role.name}</option>
            </#list>
        </select>
        <input id="user_id" type="hidden" name="user_id">

        <select id="stock_id" class="custom-select">
            <#list stocks as stock>
                <option value="${stock.stockId}">${stock.stockName}</option>
            </#list>
        </select>
        <input type="button" onclick="submitNewUser()">Save</input>
    </form>
    <form id="addRole" name="addRole" method="post">
        <input id="name" type="text" name="name">
        <input type="button" onclick="submitNewRole()">Save</input>
    </form>
</#macro>
<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>