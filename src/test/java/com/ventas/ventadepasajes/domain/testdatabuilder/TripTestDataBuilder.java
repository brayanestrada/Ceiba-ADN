package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Trip;

public class TripTestDataBuilder {

    private long idTest;
    private int seatsAvailableTest;
    private int seatsSoldTest;
    private String startCityTest;
    private String endCityTest;
    private String tripDateTest;
    private long idDriverTest;
    private double ticketAmountTest;

    public TripTestDataBuilder(){
        this.idTest = 1;
        this.seatsAvailableTest = 10;
        this.seatsSoldTest = 0;
        this.startCityTest = "Medellín";
        this.endCityTest = "Bogotá";
        this.tripDateTest = "01-02-2020";
        this.idDriverTest = 1;
        this.ticketAmountTest = 2000;
    }

    public void withoutSeatsAvailable(){
        this.seatsAvailableTest = 0;
    }

    public void withoutSeatsSold(){
        this.seatsSoldTest = 0;
    }

    public void withoutStartCity(){
        this.startCityTest = null;
    }

    public void withoutEndCity(){
        this.endCityTest = null;
    }

    public void withoutIdDriver(){
        this.idDriverTest = 0;
    }

    public void validateMinimumValueSeatsAvailable(){
        this.seatsAvailableTest = -1;
    }

    public void validateTripDateFormat(){
        this.tripDateTest = "12/12/2019";
    }

    public Trip build(){return new Trip(this.idTest, this.seatsAvailableTest, this.seatsSoldTest, this.startCityTest, this.endCityTest, this.idDriverTest, this.tripDateTest, this.ticketAmountTest); }

    public Trip buildWithoutId(){return new Trip(this.seatsAvailableTest, this.seatsSoldTest, this.startCityTest, this.endCityTest, this.idDriverTest, this.tripDateTest, this.ticketAmountTest); }

}
