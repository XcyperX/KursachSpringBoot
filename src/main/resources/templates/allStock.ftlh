<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <#if isZAM_ADMIN>
        <div>
            <a href="/products/items" class="btn btn-primary mb-4" type="button">Добавить продукт</a>
        </div>
    </#if>
    <label for="inputStock">Название склада</label>
    <select id="stock_id" class="form-control mb-4" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option value=""></option>
        <#list stocks as stock>
            <#if stock.stockName == "All">
                <option value="/products/stocks?stockId=0">Все</option>
            <#else>
                <option value="/products/stocks?stockId=${stock.stockId}">${stock.stockName}</option>
            </#if>
        </#list>
    </select>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Склад</th>
            <th scope="col">Количество на складе</th>
            <th scope="col">Количество проданных</th>
            <th scope="col">Заказано у поставщика</th>
            <th scope="col">Цена</th>
            <#if isZAM_ADMIN>
                <th></th>
            </#if>
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
                <td>${product.orderedSupplier!"Заказов нет"}</td>
                <td>${product.priceProduct}</td>
                <#if isZAM_ADMIN>
                    <td><a href="/products/items/${product.productId}">Редактировать</a></td>
                </#if>
            </tr>
        </#list>
    </table>
</@c.page>