package controllers;

import SpongeCity.MonitorPlatform.Core.PlatformData.AlertDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.AreaDataOperation;
import SpongeCity.MonitorPlatform.Core.PlatformData.DeviceDataOperation;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AlertModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_AreaModel;
import SpongeCity.MonitorPlatform.DBAccess.Model.DB_DeviceModel;
import Util.ModelConverter;
import models.AlertLevel;
import models.AlertModel;
import models.PageDivisionModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EriclLee on 15/12/29.
 */
@Controller
@RequestMapping(value = "/alerts")
public class AlertContoller {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(int pageIndex, int areaId, String sortKey, String sortDes) {
        ModelAndView modelAndView = new ModelAndView("/alerts/index");
        PageDivisionModel<AlertModel> alertPageDivisionModel = new PageDivisionModel<AlertModel>();
        List<AlertModel> alertList = new ArrayList<AlertModel>();
        AlertDataOperation alertDataOperation = new AlertDataOperation();
        AreaDataOperation areaDataOperation = new AreaDataOperation();
        ModelConverter converter = new ModelConverter();

        List<DB_AreaModel> db_areaModelList = areaDataOperation.getAllArea();
        List<DB_AlertModel> db_alertList = alertDataOperation.getAreaAlertList(areaId, pageIndex, alertPageDivisionModel.getPageSize());
        if (db_alertList != null && db_alertList.size() > 0) {
            for (DB_AlertModel db_alert : db_alertList) {
                alertList.add(converter.convertDBAlertModel2PortalAlertModel(db_alert,db_areaModelList));
            }
        }
        alertPageDivisionModel.setData(alertList);
        alertPageDivisionModel.setCurrentPageIndex(pageIndex);
        alertPageDivisionModel.setRecordCount(alertDataOperation.getAreaAlertCount(areaId));

        modelAndView.addObject("alerts", alertPageDivisionModel);
        modelAndView.addObject("sortKey", sortKey);
        modelAndView.addObject("sortDes", sortDes);
        return modelAndView;
    }
}
