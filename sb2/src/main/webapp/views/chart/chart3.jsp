<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<style>
    #container {
        width: 800px;
        height: 500px;
        border: 2px solid red;
    }
    .chart_layout {
        width: 300px;
        height: 300px;
        border: 2px solid red;
    }
    #c1 {
        height: 400px;
    }

    .highcharts-figure,
    .highcharts-data-table table {
        min-width: 310px;
        max-width: 800px;
        margin: 1em auto;
    }

    .highcharts-data-table table {
        font-family: Verdana, sans-serif;
        border-collapse: collapse;
        border: 1px solid #ebebeb;
        margin: 10px auto;
        text-align: center;
        width: 100%;
        max-width: 500px;
    }

    .highcharts-data-table caption {
        padding: 1em 0;
        font-size: 1.2em;
        color: #555;
    }

    .highcharts-data-table th {
        font-weight: 600;
        padding: 0.5em;
    }

    .highcharts-data-table td,
    .highcharts-data-table th,
    .highcharts-data-table caption {
        padding: 0.5em;
    }

    .highcharts-data-table thead tr,
    .highcharts-data-table tr:nth-child(even) {
        background: #f8f8f8;
    }

    .highcharts-data-table tr:hover {
        background: #f1f7ff;
    }

    #c2 {
        height: 500px;
    }

    .highcharts-figure,
    .highcharts-data-table table {
        min-width: 320px;
        max-width: 700px;
        margin: 1em auto;
    }

    .highcharts-data-table table {
        font-family: Verdana, sans-serif;
        border-collapse: collapse;
        border: 1px solid #ebebeb;
        margin: 10px auto;
        text-align: center;
        width: 100%;
        max-width: 500px;
    }

    .highcharts-data-table caption {
        padding: 1em 0;
        font-size: 1.2em;
        color: #555;
    }

    .highcharts-data-table th {
        font-weight: 600;
        padding: 0.5em;
    }

    .highcharts-data-table td,
    .highcharts-data-table th,
    .highcharts-data-table caption {
        padding: 0.5em;
    }

    .highcharts-data-table thead tr,
    .highcharts-data-table tr:nth-child(even) {
        background: #f8f8f8;
    }

    .highcharts-data-table tr:hover {
        background: #f1f7ff;
    }


</style>
<script>
    let chart3 = {
        init:function(){
            $('#chart1').click(()=>{
                this.getChart1();
            })

        },
        getChart1: function () {
            $.ajax({
                url: '<c:url value="/chart/getchart1data" />',
                success: (data) => {
                    this.chart1(data);
                }
            })
        },
        getChart2: function () {
            $.ajax({
                url: '<c:url value="/chart/getchart2data" />',
                success: (data) => {
                    this.chart1(data);
                }
            })
        },
        chart1: function (data) {
            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Domestic passenger transport by mode of transport, Norway',
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: <a href="https://www.ssb.no/transport-og-reiseliv/landtransport/statistikk/innenlandsk-transport">SSB</a>',
                    align: 'left'
                },
                xAxis: {
                    categories: ['2019', '2020', '2021']
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Percent'
                    }
                },
                tooltip: {
                    pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
                    shared: true
                },
                plotOptions: {
                    column: {
                        stacking: 'percent',
                        dataLabels: {
                            enabled: true,
                            format: '{point.percentage:.0f}%'
                        }
                    }
                },
                series: data
            });

        },
        chart2: function (data) {
            Highcharts.chart('container', {
                chart: {
                    type: 'variablepie'
                },
                title: {
                    text: 'Countries compared by population density and total area, 2022.',
                    align: 'left'
                },
                tooltip: {
                    headerFormat: '',
                    pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
                        'Area (square km): <b>{point.y}</b><br/>' +
                        'Population density (people per square km): <b>{point.z}</b><br/>'
                },
                series: [{
                    minPointSize: 10,
                    innerSize: '20%',
                    zMin: 0,
                    name: 'countries',
                    borderRadius: 5,
                    data: [{
                        name: 'Spain',
                        y: 505992,
                        z: 92
                    }, {
                        name: 'France',
                        y: 551695,
                        z: 119
                    }, {
                        name: 'Poland',
                        y: 312679,
                        z: 121
                    }, {
                        name: 'Czech Republic',
                        y: 78865,
                        z: 136
                    }, {
                        name: 'Italy',
                        y: 301336,
                        z: 200
                    }, {
                        name: 'Switzerland',
                        y: 41284,
                        z: 213
                    }, {
                        name: 'Germany',
                        y: 357114,
                        z: 235
                    }],
                    colors: [
                        '#4caefe',
                        '#3dc3e8',
                        '#2dd9db',
                        '#1feeaf',
                        '#0ff3a0',
                        '#00e887',
                        '#23e274'
                    ]
                }]
            });

        },
    };
    $(function(){
        chart3.init();
    });
</script>
<div class="container" id="container">
    <h2>Chart3 Page</h2>
    <div class="row well">
        <div id="c1" class="col-sm4 well chart_layout">
            <button id="chart1" type="button" class="btn btn-primary">CHART1</button>

            <p class="highcharts-description">

            </p>
        </div>
        <div id="c2" class="col-sm4 well chart_layout">
            <button id="chart2" type="button" class="btn btn-primary">CHART2</button>

        </div>
        <div id="c3" class="col-sm4 well chart_layout">
            <button id="chart3" type="button" class="btn btn-primary">CHART3</button>

        </div>
    </div>

</div>

