<div class='mainContent'>
 <p> Welcome Admin</p>

    <#if users?has_content>
        <ul>
        <#list users as u>
            <li>User: ${u.name}</li>
            <li>Password: ${u.password}</li>
            <li>Salt: ${u.salt}</li>
        </#list>
        </ul>
    </#if>
</div>