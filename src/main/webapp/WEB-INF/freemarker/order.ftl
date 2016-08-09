<div class='mainContent'>
    <p>Welcome to the ordering page</p>

    <#if pizzas?has_content>
        <ul>
        <#list pizzas as p>
            <li>${p.name}
                <#if p.pizzaToppings?has_content>
                (
                    <#list p.pizzaToppings as pt>
                        ${pt.topping.name}
                        ${pt.topping.quantity}
                        <#if pt_has_next>, </#if>
                    </#list>
                )
                </#if>
            </li>
        </#list>
        </ul>
    </#if>
</div>