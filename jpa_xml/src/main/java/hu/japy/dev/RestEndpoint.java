package hu.japy.dev;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * This class is a simple REST-Ful endpoint to see the code example in action.
 *
 * @author GHajba
 */
@Path("/entities")
@Transactional
public class RestEndpoint {

    @Inject
    private ExampleRepository repository;

    /**
     * POST endpoint for the example application
     *
     * @param model
     *            the model as a multivalued map containing form input information
     * @return the site to render for the user -- containing all the entities in the database
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html; charset=UTF-8")
    public Response addEntity(final MultivaluedMap<String, String> model) {
        this.repository.save(new ExampleEntity(model.get("createdBy").get(0)));
        return displayEntities("");
    }

    /**
     * GET endpoint for the example application.
     *
     * @param createdBy
     *            an optional parameter to indicate the filter to use
     * @return the site to render for the user -- containing the filtered results
     */
    @GET
    @Produces("text/html; charset=UTF-8")
    public Response displayEntities(@DefaultValue("") @QueryParam("createdBy") String createdBy) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<html><head> <meta charset=\"UTF-8\"> </head>Following entities are in the database:<br/>");
        final List<EntityDTO> dtos = this.repository.findInformationBasedOnCreator("%" + createdBy + "%").stream()
                .map(v -> new EntityDTO(((BigInteger) v[0]).longValue(), (String) v[1])).collect(Collectors.toList());
        if (dtos.isEmpty()) {
            sb.append("No entries found :(");
        }
        else {
            dtos.forEach(e -> {
                sb.append(e);
                sb.append("<br/>");
            });
        }
        sb.append("<hr/><a href=\"/jpa_xml\">Back</a></html>");

        return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML)
                .entity(sb.toString())
                .build();
    }
}
