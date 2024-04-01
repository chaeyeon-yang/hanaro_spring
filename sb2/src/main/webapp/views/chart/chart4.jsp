<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/01
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #container {
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

</style>
<script>
    let chart4 = {
        init: function () {
            $('#btn_Get').click(() => {
                let gender = $('input[name="gender"]:checked').val();
                alert(gender)
                this.get(gender)
            })
        },
        get: function (gender) {
            $.ajax({
                url: '<c:url value="/chart4"/>',
                data: {'gender':gender},
                success: (data) => {
                    this.chart(data);
                }
            })
        },
        chart: function (data) {
            Highcharts.chart('container', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45,
                        beta: 0
                    }
                },
                title: {
                    text: 'Global smartphone shipments market share, Q1 2022',
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://www.counterpointresearch.com/global-smartphone-share/"' +
                        'target="_blank">Counterpoint Research</a>',
                    align: 'left'
                },
                accessibility: {
                    point: {
                        valueSuffix: '%'
                    }
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}'
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'Share',
                    data: data
                }]
            });

        }
    };
    $(function () {
        chart4.init();
    });
</script>
<div class="container" id="chart4">
    <h1>chart4</h1>
    <div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="gender" value="f">Female
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="gender" value="m">Male
            </label>
        </div>

        <button id="btn_get" type="button" class="btn btn-primary">LOGIN</button>
    </div>
    <div id="container"></div>
</div>