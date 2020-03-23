package pl.pawel.ksb2thymeleaf.interfaces;

import pl.pawel.ksb2thymeleaf.model.Car;

public interface CarServiceInt {

    public boolean DeleteCarByID(long id);
    public boolean AddCar(Car car);
    public boolean EditCar(Car editcar);

}
