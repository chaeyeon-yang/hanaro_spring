package com.hana.app.data.dto.chart;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Chart2Dto {
    private int minPointSize;
    private String innerSize;
    private int zMin;
    private String name;
    private int borderRadius;
    List<CircleDto> circleList;

    @Builder
    public Chart2Dto(int minPointSize, String innerSize, int zMin, String name, int borderRadius, List<CircleDto> circleList) {
        this.minPointSize = minPointSize;
        this.innerSize = innerSize;
        this.zMin = zMin;
        this.name = name;
        this.borderRadius = borderRadius;
        this.circleList = circleList;
    }
}
