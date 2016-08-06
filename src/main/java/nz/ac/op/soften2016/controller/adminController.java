package nz.ac.op.soften2016.controller;

import  nz.ac.op.soften2016.bean.UserProfile;
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
public class adminController
{
    ServletContext servletContext;
    private final String MAIN_TEMPLATE = "main";

    @Autowired
    private Dao dao;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    private final static Logger log = LoggerFactory.getLogger(adminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView defaultPage(HttpServletRequest request){
    	List<UserProfile> users = dao.list(UserProfile.class);
        if (users.size() == 0) {
            UserProfile user = new UserProfile();
            user.setName("Lee");
            user.setPassword("P@ssw0rd");
            user.setSalt("salt");
            
            users.add(user);
            dao.save(user);
            
        }
        
        Map model = new HashMap();
        model.put("users",users);
        model.put("page","admin");
        return new ModelAndView(MAIN_TEMPLATE,model);
    }

}
