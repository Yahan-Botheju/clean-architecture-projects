package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //create delivery usecase impl
    @Bean
    public CreateDeliveryUseCase createDeliveryUseCase(
            DeliveryRepository deliveryRepository,
            CustomerCheckApi customerCheckApi,
            CustomerStatusCheckApi customerStatusCheckApi
    ){
        return new CreateDeliveryUseCaseImpl(deliveryRepository, customerCheckApi, customerStatusCheckApi);
    }
}
