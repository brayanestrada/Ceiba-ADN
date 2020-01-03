package com.ventas.ventadepasajes.domain.testdatabuilder;

import com.ventas.ventadepasajes.domain.model.entity.Trip;

public class TripTestDataBuilder {

     private long idTest = 1;
     private int seatsAvailableTest = 50;
     private int seatsSoldTest = 0;
     private String startCityTest = "Medellín";
     private String endCityTest = "Bogotá";
     private String tripDateTest = "2020-10-20";
     private int idDriverTest = 1;
     private double ticketAmountTest = 2000;

    public TripTestDataBuilder(){}

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

    public Trip build(){return new Trip(this.idTest, this.seatsAvailableTest, this.startCityTest, this.endCityTest, this.idDriverTest, this.tripDateTest, this.ticketAmountTest); }

    public Trip buildWithoutId(){return new Trip(this.seatsAvailableTest, this.startCityTest, this.endCityTest, this.idDriverTest, this.tripDateTest, this.ticketAmountTest); }

    public Trip buildMonday(){
        String tripDate = "2020-01-06";
        return new Trip(this.seatsAvailableTest, this.startCityTest, this.endCityTest, this.idDriverTest, tripDate, this.ticketAmountTest);
    }

    public Trip buildThursday(){
        String tripDate = "2020-01-09";
        return new Trip(this.seatsAvailableTest, this.startCityTest, this.endCityTest, this.idDriverTest, tripDate, this.ticketAmountTest);
    }

    public Trip buildFriday(){
        String tripDate = "2020-01-10";
        return new Trip(this.seatsAvailableTest, this.startCityTest, this.endCityTest, this.idDriverTest, tripDate, this.ticketAmountTest);
    }


}
