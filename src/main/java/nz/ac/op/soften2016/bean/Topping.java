package nz.ac.op.soften2016.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adonm on 18/07/2016.
 */
public class Topping {

    private Long id;
    private String name;
    private String description;
    private Set<PizzaTopping> pizzaToppings = new HashSet<PizzaTopping>();


    //Setters and getters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name;}
    
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Set<PizzaTopping> getPizzaToppings() { return pizzaToppings; }
    public void setPizzaToppings(Set<PizzaTopping> pizzaToppings) { this.pizzaToppings = pizzaToppings; }

    //Methods
    public Topping(){
    }

    public Topping(String name){
        this.name = name;
    }

}
