<#import "parts/common.ftlh" as c>

<@c.page>
<h5>Hello, guest</h5>
<div>
    <form id="addStock" name="addStock">
        <input id="stock_id" type="hidden" name="stock_id">
        <input id="name" type="text" name="stockName" placeholder="Введите название склада" />
        <input type="button" onclick="submitNewStock()">Добавить</input>
<#--        <input class="btn btn-primary" type="submit" value="Добавить" onclick="submitNewStock()">-->
    </form>
</div>

<#list stocks as stock>
<div>
    <span>${stock.stockName}</span>
</div>
<#else>
No stock
</#list>
</@c.page>