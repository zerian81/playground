package net.dagar.hellodropwizard.net.dagar.hellodropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import net.dagar.hellodropwizard.net.dagar.hellodropwizard.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dan on 6/11/16.
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(this.template, name.orElse(this.defaultName));
        return new Saying(this.counter.incrementAndGet(), value);
    }
}
