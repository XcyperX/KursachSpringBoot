<#import "parts/common.ftlh" as c>

<@c.page>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Склад</th>
            <th scope="col">Количество для заказа</th>
            <th scope="col"></th>
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
                <td><input id="ordered_supplier_${product.productId}" type="text" name="orderedSupplier" class="form-control" placeholder="Введите необходимое количество товара"></td>
                <td><input class="btn btn-primary mb-4" type="button" onclick="updateSupplier(${product.productId})" value="Заказать"></td>
            </tr>
        </#list>
    </table>
</@c.page>