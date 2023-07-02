package oracle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import oracle.resources.FibResource;
import oracle.resources.HelloWorldResource;

public class TestApplication extends Application<TestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }

    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        environment.jersey().register(FibResource.class);
    }

}
