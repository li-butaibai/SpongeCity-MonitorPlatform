<%--
  Created by IntelliJ IDEA.
  User: EriclLee
  Date: 15/12/29
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<div id="allmap" style="min-height: 530px; width:96%; background-color: white;margin-left:20px;padding-left: 20px;padding-top:20px;">
<c:forEach items="${dataTypes}" var="dt" >
  <div id="dataDiv_${dt.id}" style="height: 200px; width: 100%; "></div>
  </c:forEach>
</div>
<c:forEach items="${dataTypes}" var="dt">
<script type="text/javascript">
  var hashObject = GetHash();
  var devices=[];
  var markers=[];
  var infoWindows=[];
  var labels=[];
  if( hashObject.hasOwnProperty('dataTypeIds') ){
    var dtIds = hashObject['dataTypeIds'].split(',');
    for(var i =0; i<dtIds.length; i++)
    {
      $("#dt_"+dtIds[i]).attr("checked","checked");
    }
  }
  else{
    $("input[type=checkbox]").each(function(){
      $(this).attr("checked","checked");
    });
  }
      // 基于准备好的dom，初始化echarts图表
  var myChartC_${dt.id}  = echarts.init(document.getElementById('dataDiv_${dt.id}'));
      function randomData_${dt.id}() {
        now = new Date(+now + Math.random()*${dt.id}*60* 1000);
        value = value + Math.random() * 21 - 10;
        return {
          name: now.toString(),
          value: [
            now.toString(),
            Math.round(value)
          ]
        }
      }

      <%--var data_${dt.id} = [];--%>
      <%--var now = +new Date(2015, 9, 3);--%>
      <%--var oneDay = 24 * 3600 * 1000;--%>
      <%--var value = Math.random() * 100;--%>
      <%--for (var i = 0; i < 100; i++) {--%>
        <%--data_${dt.id}.push(randomData_${dt.id}());--%>
      <%--}--%>


      //设置数据     var myChart = ec.init(document.getElementById('cpu_div'));
  var optionC_${dt.id} = {
    //设置标题
    title: {
      text: '${dt.datatype}(${dt.unit})'
    },
    //设置提示
    tooltip: {
      trigger: 'axis',
      formatter: function (params) {
        date = new Date();
        date.setTime(params[0].value[0]);
        var content = date.getFullYear()+"/"
                +(date.getMonth()+1)+"/"
                +date.getDate()+" "
                +date.getHours()+":"
                +date.getMinutes()+":"
                +date.getSeconds()+'</br>';//date.toISOString()+'</br>';
        for(i=0;i<params.length;i++) {
          param = params[i];
          var date = new Date(param.value[0]);
          content += param.name + ' : '
                  + param.value[1] +'${dt.unit}</br>';
        }
        return content;
      },
      axisPointer: {
        animation: false
      }
    },
    //设置图例//"Percentage CPU", "Disk Read Bytes/sec", "Disk Write Bytes/sec", "Network Out", "Network In"
    legend: {
      data:["Percentage CPU", "Disk Read Bytes/sec", "Disk Write Bytes/sec", "Network Out", "Network In"]
    },
    //设置坐标轴
    xAxis: {
      type: 'time',
      splitLine: {
        show: false
      }
    },
    yAxis: {
      type: 'value',
      splitLine: {
        show: false
      }
    },
    //设置数据
    series: [
    ]
  };
  myChartC_${dt.id}.setOption(optionC_${dt.id});
      // 为echarts对象加载数据

  //var timeTicket_${dt.id};
  //timeTicket_${dt.id} = setInterval(function(){

    $.ajax({
      url: "/data/getdata?areaId="+hashObject.areaId+"&dataTypeIdList=${dt.id}",
      type: "get",
      async: true,
      dataType: "json",
      data: { "rnd": Math.random() },
      success: function (data) {
        for(var i = 0; i < data.length; i++ ) {
          optionC_${dt.id}.series=[];
          //optionC_${dt.id}.legend.data=[];
          for(var j=0; j<data[i].dataList.length;j++)
          {
            var dds_${dt.id} = new Array();
            for(var k=0; k<data[i].dataList[j].datas.length;k++)
            {
            dds_${dt.id}.push(
                    {name: data[i].dataList[j].modelName,
                    value: [
            data[i].dataList[j].dates[k].toString(),
            data[i].dataList[j].datas[k]]});
            }

            optionC_${dt.id}.series.push({
              type: 'line',
              smooth: true,
              showSymbol: false,
              data: dds_${dt.id}
            });
            optionC_${dt.id}.legend.data.push(data[i].dataList[j].modelName);

            myChartC_${dt.id}.setOption(optionC_${dt.id});
            //myChartC_${dt.id}.setOption(optionC_${dt.id});
          }
        }
      },
      error: function (data) {
        rtn = false;
      }
    });
    //myChartC_${dt.id}.setOption(optionC_${dt.id});
  //}, 2000);
      //
</script>
</c:forEach>