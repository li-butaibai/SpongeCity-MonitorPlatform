package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceTypeModel;
import models.AreaModel;
import models.Coordinate;
import models.DeviceModel;
import models.DeviceTypeModel;
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
@RequestMapping(value={"","/","/home"})
public class HomeController {
    @RequestMapping(value={"","/","/index"},method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("/home/index");
        return modelAndView;
    }

    @RequestMapping(value={"/areamap"},method = RequestMethod.GET)
    public ModelAndView MapInfo(int areaId)
    {
        ModelAndView modelAndView = new ModelAndView("/home/areamap");
        AreaDataOperation areaDataOperation = new AreaDataOperation();
        DB_AreaModel db_areaModel = areaDataOperation.getAreaInfo(areaId);
        AreaModel areaModel = new AreaModel();
        areaModel.setId(areaId);
        areaModel.setName(db_areaModel.getName());
        areaModel.setSize(db_areaModel.getSize());
        String position = db_areaModel.getPosition();
        areaModel.setCoordinates(convertToCoordinate(position));
        modelAndView.addObject("areaInfo", areaModel);
        DeviceDataOperation deviceDataOperation = new DeviceDataOperation();
        List<DB_DeviceTypeModel> db_deviceTypeModels = deviceDataOperation.getAllDeviceType();
        List<DeviceTypeModel> deviceTypeModelList = new ArrayList<DeviceTypeModel>();
        for(DB_DeviceTypeModel typeDBModel : db_deviceTypeModels){
            DeviceTypeModel typeModel = new DeviceTypeModel(typeDBModel.getId(), typeDBModel.getName(),typeDBModel.getName());
            deviceTypeModelList.add(typeModel);
        }
        modelAndView.addObject("deviceTypes", deviceTypeModelList);
        return modelAndView;
    }

    private List<Coordinate> convertToCoordinate(String position)
    {
        String[] ps = position.split("\\(|\\)");
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        for(String p : ps)
        {
            if(!p.isEmpty() && p!="")
            {
                String[] xy = p.split(",");
                Coordinate coordinate = new Coordinate(xy[0],xy[1]);
                coordinateList.add(coordinate);
            }
        }
        return coordinateList;
    }
}
