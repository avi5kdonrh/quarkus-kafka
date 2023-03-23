package org.example;

import io.smallrye.health.api.AsyncHealthCheck;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.impl.ReactiveKafkaConsumer;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.reactive.messaging.spi.IncomingConnectorFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;

@Liveness
@ApplicationScoped
public class LivenessAsync implements AsyncHealthCheck {



    @Override
    public Uni<HealthCheckResponse> call() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> CALL >>>>>>>>>>>> ");

        return Uni.createFrom().item(HealthCheckResponse.down("topic"))
                .onItem().delayIt().by(Duration.ofMillis(1000));
    }
}