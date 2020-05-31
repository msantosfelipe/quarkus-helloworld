package br.com.food.controller;

import br.com.food.entity.Car;
import br.com.food.repository.CarRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {

    @Inject
    private CarRepository carRepository;

    @GET
    public List<Car> listAll() {
        return Car.listAll();
    }

    @POST
    @Transactional
    public Response create(Car car) {
        Car carEntity = carRepository.save(car);
        return Response.ok(carEntity).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/listCarsByYear")
    public List<Car> listCarsByYear(@QueryParam("year") int year) {
        return carRepository.listCarsByYear(year);
    }

}
