<#import "parts/common.ftlh" as c>

<@c.page>
User editor

<form action="/users" method="post">
    <input id="username" type="text" value="${user.username}" name="username">
    <input id="paswword" type="text" value="${user.password}" name="password">
    <#list roles as role>
        <div>
            <label><input id="roles" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input id="user_id" type="hidden" value="${user.user_id}" name="user_id">

    <select id="stock_id" class="custom-select">
        <#list stocks as stock>
        <option value="${stock.id}">${stock.nameStock}</option>
        </#list>
    </select>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Save</button>
</form>
</@c.page>