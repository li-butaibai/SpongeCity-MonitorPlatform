package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
//import SpongeCity.MonitorPlatform.DBAccess.DataAccess.AreaData;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import models.AreaModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value="/menu")
public class MenuContoller {
    @RequestMapping(value="/areamenu",method = RequestMethod.GET)
    public ModelAndView GetAreaMenu()
    {
        ModelAndView modelAndView = new ModelAndView("/menu/leftmenu");
        List<AreaModel> areaModelList= new ArrayList<AreaModel>();
        //TODO: get area list
        AreaDataOperation areaDataOperation = new AreaDataOperation();
        List<DB_AreaModel> areaDataList = areaDataOperation.getAllArea();
        for(DB_AreaModel areaDbModel : areaDataList){

            if(areaDbModel.getParentarea_id() ==0)
            {
                AreaModel areaModel = new AreaModel();
                areaModel.setId(areaDbModel.getId());
                areaModel.setName(areaDbModel.getName());
                areaModel.setSubArea(getSubAreaList(areaModel.getId(), areaDataList));
                areaModelList.add(areaModel);
            }
            //areaModel.setCoordinates();
        }
        modelAndView.addObject("areamenus", areaModelList);
        return modelAndView;
    }

    private List<AreaModel> getSubAreaList(int aid, List<DB_AreaModel> db_areaModelList)
    {
        List<AreaModel> subAreaModelList = new ArrayList<AreaModel>();
        for(DB_AreaModel areaDbModel : db_areaModelList){
            if(areaDbModel.getParentarea_id() == aid)
            {
                AreaModel areaModel = new AreaModel();
                areaModel.setId(areaDbModel.getId());
                areaModel.setName(areaDbModel.getName());
                areaModel.setSubArea(getSubAreaList(areaModel.getId(), db_areaModelList));
                subAreaModelList.add(areaModel);
            }
        }
        return subAreaModelList;
    }
}
