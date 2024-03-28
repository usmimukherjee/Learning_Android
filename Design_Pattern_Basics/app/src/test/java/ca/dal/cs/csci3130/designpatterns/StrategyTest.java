package ca.dal.cs.csci3130.designpatterns;


import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.strategy.CityBus;
import ca.dal.cs.csci3130.designpatterns.strategy.PersonalCar;
import ca.dal.cs.csci3130.designpatterns.strategy.Strategy;
import ca.dal.cs.csci3130.designpatterns.strategy.Taxi;
import ca.dal.cs.csci3130.designpatterns.strategy.TransportService;

public class StrategyTest {

    @Test
    public void testStrategy() {
        Strategy vehicle1 = new CityBus();
        TransportService service = new TransportService(vehicle1);
        service.executeStrategy();

        Strategy vehicle2 = new PersonalCar();
        service = new TransportService(vehicle2);
        service.executeStrategy();

        Strategy vehicle3 = new Taxi();
        service = new TransportService(vehicle3);
        service.executeStrategy();
    }
}
