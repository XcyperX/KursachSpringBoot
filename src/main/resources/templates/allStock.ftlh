<#import "parts/common.ftlh" as c>

<@c.page>
    <label for="inputStock">Название склада</label>
    <select id="stock_id" class="form-control" onchange="window.location.href=this.options[this.selectedIndex].value">

        <option value="http://localhost:8080/products/all">Все</option>
        <#list stocks as stock>
<#--            <#if stock.stockId == products-->
            <option value="http://localhost:8080/products/all/stock/${stock.stockId}">${stock.stockName}</option>
        </#list>
    </select>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Склад</th>
            <th scope="col">Количество на складе</th>
            <th scope="col">Количество проданных</th>
            <th scope="col">Цена</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
            <tr>
                <td>${product.nameProduct}</td>
                <td>
                    <#list stocks as stock>
                        <#if stock.stockId == product.stockId>
                            ${stock.stockName}
                        </#if>
                    </#list>
                </td>
                <td>${product.amountOnStock}</td>
                <td>${product.amountOnSale}</td>
                <td>${product.priceProduct}</td>
                <td><a href="/products/${product.productId}">Редактировать</a></td>
            </tr>
        </#list>
    </table>
</@c.page>