package nz.ac.op.soften2016.controller;

import nz.ac.op.soften2016.bean.Pizza;
import nz.ac.op.soften2016.bean.PizzaTopping;
import nz.ac.op.soften2016.bean.Topping;
import nz.ac.op.soften2016.service.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class CommonController
{
    ServletContext servletContext;
    private final String MAIN_TEMPLATE = "main";

    @Autowired
    private Dao dao;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    private final static Logger log = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView defaultPage(HttpServletRequest request){
    	Map model = new HashMap();
        model.put("page","home");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest request){
    	Map model = new HashMap();
        model.put("page","home");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contactPage(HttpServletRequest request){
    	Map model = new HashMap();
        model.put("page","contact");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(HttpServletRequest request){
    	Map model = new HashMap();
        model.put("page","admin");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView orderPage(HttpServletRequest request){

    	Map model = new HashMap();
        List<Pizza> pizzas = dao.list(Pizza.class);

       String[] pizzaToppings = {"Beef", "Cheese", "Bacon", "BBQ Sauce"};
       Pizza meatLovers = new Pizza();
       meatLovers.setName("MeatLovers");
       for(String s : pizzaToppings)
       {
    	   Topping topping = new Topping();
    	   topping.setName(s);
    	   dao.save(topping);
    	   meatLovers.createPizzaTopping(topping);
       }
       dao.save(meatLovers);
       pizzas.add(meatLovers);
       
       
        
        //TODO: add an admin interface for adding pizzas
        if(pizzas.size() == 0)
        {
            String[] toppingList = {"Pepperoni","Cheese"};
            Pizza pepperoniPizza = new Pizza();
            pepperoniPizza.setName("Pepperoni");
            for(String s : toppingList)
            {
                Topping topping = new Topping();
                topping.setName(s);
                dao.save(topping);
                pepperoniPizza.createPizzaTopping(topping);
            }

            dao.save(pepperoniPizza);
            pizzas.add(pepperoniPizza);
        }

        model.put("pizzas", pizzas);
        model.put("page","order");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }

}
