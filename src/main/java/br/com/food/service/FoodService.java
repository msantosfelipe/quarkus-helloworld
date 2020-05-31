package br.com.food.service;

import br.com.food.entity.Food;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FoodService {

    public Food update(Long id, Food food) {
        Food foodEntity = Food.findById(id);

        if (foodEntity == null) {
            throw new WebApplicationException("Food with id of " + id + " dos not exists", Response.Status.NOT_FOUND);
        }

        foodEntity.setName(food.getName());
        foodEntity.setCalories(food.getCalories());

        return foodEntity;
    }

    /**
     * This method is main purpose to show simple "Business" example
     *
     * @param food
     * @return
     */
    public boolean isFoodNameIsNotEmpty(Food food) {
        return food.getName().isEmpty();

    }
}
