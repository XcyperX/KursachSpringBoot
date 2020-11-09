<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
    isAdmin = false
    isZAM_ADMIN = false
    isUser = false
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        role = user.getRoleSecurity()
        stockName = user.getStockSecurity()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        name = "unknown"
        role = "unknown"
        isAdmin = false
    >
</#if>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        role = user.getRoleSecurity()
        stockName = user.getStockSecurity()
        isUser = user.isUser()
    >
<#else>
    <#assign
        name = "unknown"
        role = "unknown"
        isUser = false
    >
</#if>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        role = user.getRoleSecurity()
        stockName = user.getStockSecurity()
        isZAM_ADMIN = user.isZAM_ADMIN()
    >
<#else>
    <#assign
        name = "unknown"
        role = "unknown"
        isZAM_ADMIN = false
        isUser = false
    >
</#if>