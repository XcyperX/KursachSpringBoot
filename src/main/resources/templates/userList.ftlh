<#import "parts/common.ftlh" as c>

<@c.page>
<div>
    <form action="/registration">
        <button class="btn btn-primary mb-4" type="submit">Добавить сотрудника</button>
    </form>
</div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col">Склад</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>
                    <#list roles as role>
                        <#if role.roleId == user.roleId>
                            ${role.name}
                        </#if>
                    </#list>
                </td>
                <td>
                    <#list stocks as stock>
                        <#if stock.stockId == user.stockId>
                            ${stock.stockName}
                        </#if>
                    </#list>
                </td>
                <td><a href="/users/${user.userId}">Редактировать</a></td>
            </tr>
        </#list>
    </table>
</@c.page>