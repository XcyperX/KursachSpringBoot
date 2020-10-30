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
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isUser = user.isUser()
    >
<#else>
    <#assign
        name = "unknown"
        isUser = false
>
</#if>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        isZAM_ADMIN = user.isZAM_ADMIN()
    >
<#else>
    <#assign
        name = "unknown"
        isZAM_ADMIN = false
>
</#if>