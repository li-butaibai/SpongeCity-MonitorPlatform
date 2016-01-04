package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value={"","/","/home"})
public class HomeController {
    @RequestMapping(value={"","/","/index"},method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("/home/index");
        return modelAndView;
    }


}
