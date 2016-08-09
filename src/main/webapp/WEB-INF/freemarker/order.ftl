<div class='mainContent'>

<h1>TEAM ROCKY PIZZA</h1>
    <p>Welcome to the ordering page</p>
    
<form action="/addpizza" method="POST">
<button>HELLO</button>
</form>

    <#if pizzas?has_content>
        <ul>
        <#list pizzas as p>
            <li>${p.name}
                <#if p.pizzaToppings?has_content>
                (
                    <#list p.pizzaToppings as pt>
                        ${pt.topping.name}
                        <#if pt_has_next>, </#if>
                    </#list>
                )
                </#if>
            </li>
        </#list>
        </ul>
    </#if>
</div>