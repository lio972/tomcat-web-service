package com.javacodegeeks.ultimate.aws.eb;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TutorialIntegrationTest {

	private static final Logger logger = Logger.getLogger( "TutorialIntegrationTest" );
	private static final Feature loggingFeature = new LoggingFeature(logger, LoggingFeature.Verbosity.PAYLOAD_ANY);

	@Test
    @SuppressWarnings("unchecked")
    public void testListAllCourses() {
        final Client client = ClientBuilder.newBuilder()
				.register(loggingFeature)  // verbose logging
				.build();

        final WebTarget target = client.target("http://localhost:8080")
			.path("/tomcat-web-service/tutorial-service/tutorial/list-all-courses");
        final Response response = target.request().get();
        System.err.println( response );
        assertThat(response.getStatus(), is(200));
        final List<Tutorial> tutorials = (List<Tutorial>) response.readEntity(new GenericType<List<Tutorial>>(){});
        assertThat(tutorials.size(), is(3));
        assertThat(tutorials, hasItem(new Tutorial("Linus Meyer", "Linux")));
        assertThat(tutorials, hasItem(new Tutorial("Bill Famous", "Microsoft")));
        assertThat(tutorials, hasItem(new Tutorial("Josh Hotspot", "Java")));
    }
}