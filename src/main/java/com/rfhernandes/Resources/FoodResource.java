package com.rfhernandes.Resources;

import com.rfhernandes.Controllers.FoodController;
import com.rfhernandes.Entities.Food;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FoodResource {

    @Inject
    private FoodController foodController;

    @GET
    public List<Food> getAll() {
        return foodController.getAll();
    }

    @POST
    @Transactional
    public Response create(Food food) {
        Food.persist(food);
        return Response.ok(food).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Food food) {
        Food foodEntity = foodController.update(id, food);
        return Response.ok(foodEntity).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Food foodEntity = Food.findById(id);
        foodEntity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
