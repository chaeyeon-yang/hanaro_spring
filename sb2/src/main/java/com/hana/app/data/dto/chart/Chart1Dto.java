package com.hana.app.data.dto.chart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chart1Dto {
    private String name;
    private int m1;
    private int m2;
    private int m3;

    public List<Integer> getM() {
        List<Integer> list = new ArrayList<>();
        list.add(this.m1);
        list.add(this.m2);
        list.add(this.m3);
        return list;
    }
}
