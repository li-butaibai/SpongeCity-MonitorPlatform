package controllers;

import Util.SortList;
import models.DeviceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value = "/devices/")
public class DeviceController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(String sortKey, String sortDes)
    {
        ModelAndView modelAndView = new ModelAndView("/devices/index");
        List<DeviceModel> deviceModels = new ArrayList<DeviceModel>();
        //TODO: get device list;
        if(sortKey== null || sortKey=="")
        {
            sortKey="getDeviceTypeName";
        }
        if(sortDes==null||sortDes=="")
        {
            sortDes="desc";
        }
        SortList<DeviceModel> sortList = new SortList<DeviceModel>();
        sortList.Sort(deviceModels, sortKey, sortDes);
        modelAndView.addObject("devices", deviceModels);
        modelAndView.addObject("sortKey",sortKey);
        modelAndView.addObject("sortDes",sortDes);
        return null;
    }

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
