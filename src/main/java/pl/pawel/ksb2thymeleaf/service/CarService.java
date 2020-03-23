package pl.pawel.ksb2thymeleaf.service;

import org.springframework.stereotype.Service;
import pl.pawel.ksb2thymeleaf.interfaces.CarServiceInt;
import pl.pawel.ksb2thymeleaf.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInt {


    private List<Car> carList;

    public CarService() {

        carList = new ArrayList<>();
        carList.add(new Car(1L, "BMW", "E36"));
        carList.add(new Car(this.getLastID() + 1, "Toyota", "Corolla"));
        carList.add(new Car(this.getLastID() + 1, "BMW", "jakies"));
        carList.add(new Car(this.getLastID() + 1, "Mercedes", "LOL"));
        carList.add(new Car(this.getLastID() + 1, "Peguet", "407"));
    }

    private long getLastID() {
        return carList.get(carList.size() - 1).getId();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public boolean DeleteCarByID(long id) {
        Optional<Car> carf = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (carf.isPresent()) {
            carList.remove(carf.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean AddCar(Car car) {
        carList.add(new Car(this.getLastID() + 1, car.getMark(), car.getModel()));
        return true;
    }

    @Override
    public boolean EditCar(Car editcar) {
        Optional<Car> carf = carList.stream().filter(car -> car.getId() == editcar.getId()).findFirst();
        if (carf.isPresent()) {
            if (!editcar.getMark().equals("")) {
                carf.get().setMark(editcar.getMark());

            }
            if (!editcar.getModel().equals("")) {
                carf.get().setModel(editcar.getModel());
            }
            return true;
        }

        return false;
    }

}
