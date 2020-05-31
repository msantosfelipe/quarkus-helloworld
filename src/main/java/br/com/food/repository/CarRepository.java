package br.com.food.repository;

import br.com.food.entity.Car;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    public List<Car> listAll() {
        return listAll();
    }

    public Car save(Car car) {
        persist(car);
        return car;
    }

    public List<Car> listCarsByYear(int year) {
        return find("year(modelYear) = :year", Parameters.with("year", year)).list();
    }

    public List<Car> listAllCarsToSale() {
        return list("isAvailableSale", true);
    }

    public List<Car> listCarSortNameAndBrand() {
        return list("order by name, brand");
    }

    public long countCar() {
        return count();
    }

    public List<Car> listCarByPage(int page, int size) {
        PanacheQuery<Car> listCars = find("isAvailableSale", true);
        return listCars.page(Page.of(page, size)).list();
    }

    @Transactional
    public Car update(Long id, Car car) {
        Car carEntity = findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        carEntity.setName(car.getName());
        carEntity.setBrand(car.getBrand());
        persist(carEntity);
        return carEntity;
    }

    @Transactional
    public void remove(Long id) {
        Car carEntity = findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        delete(carEntity);
    }

}
