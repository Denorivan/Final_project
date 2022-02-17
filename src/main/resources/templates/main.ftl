<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout />
</div>
<div>
    <form method="post">
        <label>
            <input type="text" name="text" placeholder="Введите сообщение" />
        </label>
        <label>
            <input type="text" name="tag" placeholder="Тэг">
        </label>
        <input type="hidden" name="_csrf" value="@{_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<form method="post" action="filter">
    <label>
        <input type="text" name="filter">
    </label>
    <input type="hidden" name="_csrf" value="@{_csrf.token}" />
    <button type="submit">Найти</button>
</form>
<#list massages as message>
<div>
    <b>@{message.id}</b>
    <span>@{message.text}</span>
    <i>@{message.tag}</i>
    <strong>{{authorName}}</strong>
</div>
<#else>
    No message
</#list>
</@c.page>