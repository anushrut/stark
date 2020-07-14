package com.anush.onlinemess.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Day {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private int day;

    private Day(int day) {
        this.day = day;
    }

    @JsonValue
    public int getDay() {
        return day;
    }
}
