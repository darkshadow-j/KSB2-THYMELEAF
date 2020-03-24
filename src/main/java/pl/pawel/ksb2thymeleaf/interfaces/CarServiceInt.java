package pl.pawel.ksb2thymeleaf.interfaces;

import pl.pawel.ksb2thymeleaf.model.Car;

public interface CarServiceInt {

    public boolean deleteCarByID(long id);
    public boolean addcar(Car car);
    public boolean editCar(Car editcar);

}
