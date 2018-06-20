package com.javacodegeeks.ultimate.aws.eb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tutorial")
public class TutorialResource {

    private static final Log LOGGER = LogFactory.getLog(TutorialResource.class);

    @GET
    @Produces("text/json")
    @Path("/list-all-courses")
    public Response listAllCourses() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Listing all courses.");
        }
        final List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial("Linus Meyer", "Linux"));
        tutorials.add(new Tutorial("Bill Famous", "Microsoft"));
        tutorials.add(new Tutorial("Josh Hotspot", "Java"));
        return Response.status(200).entity(tutorials).build();
    }
}