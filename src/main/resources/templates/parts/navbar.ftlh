<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Торговое предприятие</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isZAM_ADMIN>
                <li class="nav-item">
                    <a class="nav-link" href="/supplier">Поставщики</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products/stocks?stockId=0">Склады</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/reports/stocks?stockId=0">Отчеты</a>
                </li>
            <#elseif isUser>
                    <li class="nav-item">
                        <a class="nav-link" href="/supplier">Поставщики</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/products">Склад</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/reports/stocks?stockId=0">Отчеты</a>
                    </li>
            <#elseif isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/products/stocks?stockId=0">Склады</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users">Сотрудники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/reports/stocks?stockId=0">Отчеты</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3">${role}</div>
        <@l.logout />
    </div>
</nav>