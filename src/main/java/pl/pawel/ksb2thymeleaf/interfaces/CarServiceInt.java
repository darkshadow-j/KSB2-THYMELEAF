package pl.pawel.ksb2thymeleaf.interfaces;

import pl.pawel.ksb2thymeleaf.model.Car;

public interface CarServiceInt {

     boolean deleteCarByID(long id);
     boolean addcar(Car car);
     boolean editCar(Car editcar);

}

