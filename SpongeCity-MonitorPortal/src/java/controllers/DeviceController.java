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
@RequestMapping(value = "/devices/")
public class DeviceController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index()
    {return null;}

    @RequestMapping(value="/detail",method = RequestMethod.GET)
    public ModelAndView detail()
    {
        return null;
    }

    public Map<String,Object> devices(@RequestParam int areaId, int[] deviceTypeIds)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }
}
