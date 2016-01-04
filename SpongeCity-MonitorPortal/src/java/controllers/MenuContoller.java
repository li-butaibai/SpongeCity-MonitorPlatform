package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value="/menu")
public class MenuContoller {
    @RequestMapping(value="/areamenu",method = RequestMethod.GET)
    public ModelAndView GetAreaMenu(@RequestParam int parentId)
    {return null;}
}
