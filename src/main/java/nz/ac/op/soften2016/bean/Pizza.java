package nz.ac.op.soften2016.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adonm on 18/07/2016.
 * 
 * 
 */
public class Pizza {

    private Long id;
    private String name;
    private Set<PizzaTopping> pizzaToppings = new HashSet<PizzaTopping>();
    private Long[] pizzaToppingsId;

    //Setters & getters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<PizzaTopping> getPizzaToppings() { return pizzaToppings; }
    public void setPizzaToppings(Set<PizzaTopping> pizzaToppings) { this.pizzaToppings = pizzaToppings; }

    public Long[] getPizzaToppingsId() { return pizzaToppingsId; }
    public void setPizzaToppingsId(Long[] pizzaToppingsId) { this.pizzaToppingsId = pizzaToppingsId; }

    //Methods
    public Pizza(){    }

    public Pizza(String name){ this.name = name; }

    public void addPizzaTopping(PizzaTopping pizzaTopping){
        pizzaTopping.setPizza(this);
        pizzaToppings.add(pizzaTopping);
    }

    public void createPizzaTopping(Topping topping){
        PizzaTopping pizzaTopping = new PizzaTopping();
        pizzaTopping.setTopping(topping);
        addPizzaTopping(pizzaTopping);
    }

}
