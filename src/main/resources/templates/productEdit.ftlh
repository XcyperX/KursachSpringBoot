<#import "parts/common.ftlh" as c>

<@c.page>
    <form id="updateProduct" name="updateProduct">
        <div class="form-row">
            <label for="heading">Изменить товар</label>
        </div>
        <div class="form-row">
            <input id="product_id" type="text" hidden name="product_id" value="${products.productId}">
            <div class="form-group col-md-6">
                <label for="inputName">Наименование</label>
                <input id="name_product" type="text" name="nameProduct" class="form-control" placeholder="Введите название товара" value="${products.getNameProduct()}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputStock">Название склада</label>
                <select id="stock_id" class="form-control">
                    <#list stocks as stock>
                        <#if stock.stockId == products.getStockId()>
                            <option value="${stock.stockId}" selected>${stock.stockName}</option>
                        </#if>
                        <option value="${stock.stockId}">${stock.stockName}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputOnStock">Количество на складе</label>
                <input id="amount_on_stock" type="text" name="amountOnStock" class="form-control" placeholder="Введите количество товара на складе" value="${products.getAmountOnStock()?c}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputOnStock">Количество проданного товара</label>
                <input id="amount_on_sale" type="text" name="amountOnSale" class="form-control" placeholder="Введите количество проданного товара" value="${products.getAmountOnSale()?c}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputOnStock">Цена</label>
                <input id="price_product" type="text" name="priceProduct" class="form-control" placeholder="Введите цену товара" value="${products.getPriceProduct()?c}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <input class="btn btn-primary mb-4" type="button" onclick="submitUpdateProduct()" value="Изменить товар">
            </div>
            <div class="form-group col-md-6">
                <input class="btn btn-primary mb-4" type="button" onclick="deleteProduct(${products.productId})" value="Удалить товар">
            </div>
        </div>
    </form>
</@c.page>