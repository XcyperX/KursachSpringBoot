<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <form id="addProduct" name="addProduct">
        <div class="form-row">
            <label for="heading">Добавить товар</label>
        </div>
        <div class="form-row">
            <input id="product_id" type="hidden" name="product_id">
            <div class="form-group col-md-6">
                <label for="inputName">Наименование</label>
                <input id="name_product" type="text" name="nameProduct" class="form-control" placeholder="Введите название товара">
            </div>
            <div class="form-group col-md-6">
                <label for="inputStock">Название склада</label>
                <#if isUser>
                    <select id="stock_id" class="form-control">
                        <option value="${user.getStock().getId()}">${stockName}</option>
                    </select>
                </#if>
                <#if isZAM_ADMIN>
                    <select id="stock_id" class="form-control">
                        <#list stocks as stock>
                            <option value="${stock.stockId}">${stock.stockName}</option>
                        </#list>
                    </select>
                </#if>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputOnStock">Количество на складе</label>
                <input id="amount_on_stock" type="text" name="amountOnStock" class="form-control" placeholder="Введите количество товара на складе">
            </div>
            <div class="form-group col-md-6">
                <label for="inputOnStock">Количество проданного товара</label>
                <input id="amount_on_sale" type="text" name="amountOnSale" class="form-control" placeholder="Введите количество проданного товара">
            </div>
            <div class="form-group col-md-6">
                <label for="inputOnStock">Цена</label>
                <input id="price_product" type="text" name="priceProduct" class="form-control" placeholder="Введите количество проданного товара">
            </div>
        </div>
        <input class="btn btn-primary  mb-4" type="button" onclick="submitNewProduct()" value="Добавить товар">
    </form>
</@c.page>