package net.dagar.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.dagar.hellodropwizard.net.dagar.hellodropwizard.net.dagar.hellodropwizard.health.TemplateHealthCheck;
import net.dagar.hellodropwizard.net.dagar.hellodropwizard.resources.HelloResource;

/**
 * Created by dan on 6/10/16.
 */
public class HelloApplication extends Application<HelloConfiguration> {

    /**
     * When the application runs, this is called after the {@link Bundle}s are run. Override it to add
     * providers, resources, etc. for your application.
     *
     * @param configuration the parsed {@link Configuration} object
     * @param environment   the application's {@link Environment}
     * @throws Exception if something goes wrong
     */
    @Override
    public void run(HelloConfiguration configuration, Environment environment) throws Exception {
        final HelloResource helloResource = new HelloResource(
            configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(helloResource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
            configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

    @Override
    public String getName() {
        return "hello-dropwizard";
    }

    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {

    }

    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }
}
