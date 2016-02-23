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

<div style="height:0px; overflow:hidden;">&nbsp;</div>
<div class="table_wrap">
<select id="dtSelect">
  <c:forEach items="${dataTypes}" var="dt">
    <option value="${dt.id}">${dt.unit}</option>
  </c:forEach>
</select>
  <div id="dataDiv" style="height: 300px; width: 100%"></div>
</div>
<script type="text/javascript">
  var axisData = [];
  var cpuData = [];
  var drData = [];
  var dwData = [];
  var niData = [];
  var noData = [];

  function drawEChart() {

    require.config({
      paths: {
        echarts: 'http://echarts.baidu.com/build/dist'
      }
    });
    require(
            [
              'echarts',
              'echarts/chart/line'
            ],
            function (ec) {
              // 基于准备好的dom，初始化echarts图表
              var myChartC = ec.init(document.getElementById('dataDiv'));
              //设置数据     var myChart = ec.init(document.getElementById('cpu_div'));
              var optionC = {
                //设置标题
                title: {
                  text: 'CPU'
                },
                //设置提示
                tooltip: {
                  trigger: 'axis',
                  formatter: function (params) {
                    var res = params[0].name;
                    res += '<br/>Percentage CPU: ' + params[0].value.toFixed(2) + "%";
                    return res;
                  },
                  showDelay: 0

                },
                //设置图例//"Percentage CPU", "Disk Read Bytes/sec", "Disk Write Bytes/sec", "Network Out", "Network In"
                legend: {
                  data: ['Percentage CPU']
                },
                //设置坐标轴
                xAxis: [
                  {
                    type: 'category',
                    data: axisData
                  }
                ],
                yAxis: [
                  {
                    type: 'value',
                    axisLabel: {
                      formatter: function (v) {
                        return v + '%';
                      }
                    }
                  }
                ],
                //设置数据
                series: [
                ]
              };
              optionC.series.push({
                "name": "Percentage CPU",
                "type": "line",
                "data": cpuData
              })
              // 为echarts对象加载数据
              myChartC.setOption(optionC);
            }
    );
  }
  function loadMonitorData(hours) {
    $.ajax({
      url: "/VirtualMachine/GetMonitorData",
      type: "get",
      async: true,
      dataType: "json",
      data: { "rnd": Math.random(), "vmId": '@Request["vmId"].ToString()', "hours": hours },
      success: function (data) {
        axisData = data.TD;
        cpuData = data.CD;
        drData = data.DRD;
        dwData = data.DWD;
        niData = data.NID;
        noData = data.NOD;

        drawEChart();
      },
      error: function (data) {
        alert("Error");
        rtn = false;
      }
    });
  }
  loadMonitorData(1);
</script>
