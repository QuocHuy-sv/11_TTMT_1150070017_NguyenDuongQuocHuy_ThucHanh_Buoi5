package com.example.nguyenduongquochuylab3;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<Topic> getTopics() {
        List<Topic> list = new ArrayList<>();
        list.add(new Topic("Essentials"));
        list.add(new Topic("While Traveling"));
        list.add(new Topic("Help / Medical"));
        list.add(new Topic("At the Hotel"));
        list.add(new Topic("At the Restaurant"));
        list.add(new Topic("At the Bar"));
        list.add(new Topic("At the Store"));
        list.add(new Topic("At Work"));
        list.add(new Topic("Time, Date, Numbers"));
        list.add(new Topic("Education"));
        list.add(new Topic("Entertainment"));
        return list;
    }
}
