package Util;

import models.DataModel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sabermai on 2016/1/12.
 */
public class DeviceDataFileWriter {
    public void writeCSV(String[] heads, List<DataModel> dataModels, String filePath, String fileName) {
        try {
            File csv = new File(filePath + fileName);
            if(!csv.getParentFile().exists()) {
                //如果目标文件所在的目录不存在，则创建父目录
                if(!csv.getParentFile().mkdirs()) {
                    return;
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.newLine();
            String strHead = "";
            for (String head : heads) {
                strHead += head + ",";
            }
            bw.write(strHead.substring(0, strHead.length() - 1));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (DataModel dataModel : dataModels) {
                // 新增一行数据
                bw.newLine();
                StringBuilder sb = new StringBuilder();
                sb.append(sdf.format(dataModel.getDatatime()) + ",");
                sb.append(dataModel.getAreaName() + ",");
                sb.append(dataModel.getBlockName() + ",");
                sb.append(dataModel.getMeasureName() + ",");
                sb.append(dataModel.getDevice_id() + ",");
                sb.append(dataModel.getDatatype() + ",");
                sb.append(dataModel.getDatavalue() + ",");
                sb.append(dataModel.getUnit());
                bw.write(sb.toString());
            }
            bw.close();
        } catch (FileNotFoundException e) {
            // 捕获File对象生成时的异常
            e.printStackTrace();
        } catch (IOException e) {
            // 捕获BufferedWriter对象关闭时的异常
            e.printStackTrace();
        }
    }
}
