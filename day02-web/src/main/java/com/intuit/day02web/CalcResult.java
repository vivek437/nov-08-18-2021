package com.intuit.day02web;

import org.springframework.hateoas.RepresentationModel;

public class CalcResult extends RepresentationModel<CalcResult> {
    private int resultValue;

    public int getResultValue() {
        return resultValue;
    }

    public void setResultValue(int resultValue) {
        this.resultValue = resultValue;
    }
}
