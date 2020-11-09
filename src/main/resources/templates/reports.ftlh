<#import "parts/common.ftlh" as c>

<@c.page>
    <label for="inputStock">Название склада</label>
    <select id="stock_id" class="form-control mb-4" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option value=""></option>
        <#list stocks as stock>
            <#if stock.stockName == "All">
                <option value="/reports/stocks?stockId=0">Все</option>
            <#else>
                <option value="/reports/stocks?stockId=${stock.stockId}">${stock.stockName}</option>
            </#if>
        </#list>
    </select>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Склад</th>
            <th scope="col">Цена</th>
            <th scope="col">Расходы</th>
            <th scope="col">Прибыль</th>
            <th scope="col">Чистая прибыль</th>
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
                <td>${product.getPriceProduct()}</td>
                <td>${product.getPriceProduct() * product.getAmountOnStock()!1 + product.getPriceProduct() * product.getOrderedSupplier()!1}</td>
                <td>${product.getPriceProduct() * product.getAmountOnSale()!1}</td>
                <td>${(product.getPriceProduct() * product.getAmountOnSale()!1) - (product.getPriceProduct() * product.getAmountOnStock()!1 + product.getPriceProduct() * product.getOrderedSupplier()!1)}</td>
            </tr>
        </#list>
    </table>
    <a href="/api/pdf/products" class="btn btn-primary mb-4" type="button">Создать отчет</a>
</@c.page>