package com.ElectiveManagment.ElectiveManagment.service.Factory;

import com.ElectiveManagment.ElectiveManagment.service.Strategy.EnrollCourseStrategy;
import com.ElectiveManagment.ElectiveManagment.service.Strategy.StrategyImpl.CgpaEnrollmentCourseStrategy;
import com.ElectiveManagment.ElectiveManagment.service.Strategy.StrategyImpl.FirstComeFirstServeEnrollCourseStrategy;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentStrategyFactory {

    public static EnrollCourseStrategy enrollFactory(String type){
        if(type.equals("CGPA")){
            return new CgpaEnrollmentCourseStrategy();
        }else if(type.equals("FCFS")){
            return new FirstComeFirstServeEnrollCourseStrategy();
        }

        return new FirstComeFirstServeEnrollCourseStrategy();
    }
}
