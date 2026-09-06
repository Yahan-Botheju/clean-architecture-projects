package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api.CheckFlightSafetyRule1Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //flight safety rule 1
    @Bean
    public CheckFlightSafetyRule1 checkFlightSafetyRule1(){
        return new CheckFlightSafetyRule1Impl();
    }
}
