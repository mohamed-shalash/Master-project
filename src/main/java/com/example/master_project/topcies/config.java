package com.example.master_project.topcies;

import java.util.ArrayList;
import java.util.List;

public class config {

        public List<Criteria> criteria=new ArrayList<>();

        public config(){
            criteria.add(new Criteria("speed of construction",7.03));
            criteria.add(new Criteria("availability of equipment",6.88));
            criteria.add(new Criteria("Effect of construction on design",6.73));
            criteria.add(new Criteria("Budget Cost",6.73));
            criteria.add(new Criteria("Availability Of Material",6.45));
            criteria.add(new Criteria("degree of risk during construction",6.16));
            criteria.add(new Criteria("latest technology of world's vision",6.16));
            criteria.add(new Criteria("cost of maintenance",6.02));
            criteria.add(new Criteria("life cycle cost",6.02));
            criteria.add(new Criteria("availability of skilled man power",6.02));
            criteria.add(new Criteria("Ease of maintenance",5.87));
            criteria.add(new Criteria("contractor experience and capabilities",5.87));
            criteria.add(new Criteria("diversion cost of existing utilities",5.59));
            criteria.add(new Criteria("future extension",5.3));
            criteria.add(new Criteria("Aesthetics of bridge",4.87));
            criteria.add(new Criteria("difficulty in logistics",4.58));
        }

}
