package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView("/account/login");
        return modelAndView;
    }
}
