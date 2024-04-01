<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #container {
        width: 800px;
        height: 500px;
        border: 2px solid red;
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

</style>
<script>
    let chart1 = {
        init:function(){
// Data retrieved https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature
            Highcharts.chart('container', {
                chart: {
                    type: 'spline'
                },
                title: {
                    text: 'Monthly Average Temperature'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                        'target="_blank">Wikipedia.com</a>'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                    accessibility: {
                        description: 'Months of the year'
                    }
                },
                yAxis: {
                    title: {
                        text: 'Temperature'
                    },
                    labels: {
                        format: '{value}°'
                    }
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                plotOptions: {
                    spline: {
                        marker: {
                            radius: 4,
                            lineColor: '#666666',
                            lineWidth: 1
                        }
                    }
                },
                series: [{
                    name: 'Tokyo',
                    marker: {
                        symbol: 'square'
                    },
                    data: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, 22.8, 17.5, 12.1, 7.6]

                }, {
                    name: 'Bergen',
                    marker: {
                        symbol: 'diamond'
                    },
                    data: [{
                        y: 1.5,
                        marker: {
                            symbol: 'url(https://www.highcharts.com/samples/graphics/snow.png)'
                        },
                        accessibility: {
                            description: 'Snowy symbol, this is the coldest point in the chart.'
                        }
                    }, 1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
                }, {
                    name: 'Korea',
                    marker: {
                        symbol: 'diamond'
                    },
                    data: [{
                        y: 1.5,
                        marker: {
                            symbol: 'url(https://www.highcharts.com/samples/graphics/snow.png)'
                        },
                        accessibility: {
                            description: 'Snowy symbol, this is the coldest point in the chart.'
                        }
                    }, -1.6, 2.3, 10.9, 13.5, 18.5, 30.5, 35.4, 16.5, 14.7, 10.7, 2.6]
                }]
            });

        }
    };
    $(function(){
        chart1.init();
    });
</script>
<div class="container">
    <h2>Chart1 Page</h2>
    <div id="container">
        <p class="highcharts-description">
            This chart shows how symbols and shapes can be used in charts.
            Highcharts includes several common symbol shapes, such as squares,
            circles and triangles, but it is also possible to add your own
            custom symbols. In this chart, custom weather symbols are used on
            data points to highlight that certain temperatures are warm while
            others are cold.
        </p>
    </div>

</div>

