package com.zayats.xmlparser.entity;

import javax.xml.bind.annotation.*;

@XmlType(name = "mealPlan")
public enum MealPlan {
    RO, BB, HB, FB, ALL;
}
