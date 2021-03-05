package com.rfhernandes.Controllers;

import com.rfhernandes.Entities.Food;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class FoodController {

    public Food update(Long id, Food food) {
        Food foodEntity = Food.findById(id);

        if (foodEntity == null) {
            throw new WebApplicationException("Food with id " + id + " not found.", Response.Status.NOT_FOUND);
        }

        foodEntity.setName(food.getName());
        foodEntity.setCalories(food.getCalories());

        return foodEntity;
    }

    public List<Food> getAll() {
        return Food.listAll();
    }
}
