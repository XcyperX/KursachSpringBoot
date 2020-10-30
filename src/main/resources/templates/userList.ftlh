<#import "parts/common.ftlh" as c>

<@c.page>
List of users
<div>
    <form action="/registration">
        <button class="btn btn-primary" type="submit">Add new user</button>
    </form>
</div>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th>Stock</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
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
            <td><a href="/users/${user.userId}">edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>