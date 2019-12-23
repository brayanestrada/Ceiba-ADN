package com.ventas.ventadepasajes.domain.service.purchase;

import com.ventas.ventadepasajes.domain.model.entity.Purchase;
import com.ventas.ventadepasajes.domain.model.entity.Trip;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryPurchase;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryTrip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServiceUpdatePurchase {

    private RepositoryPurchase repositoryPurchase;
    private RepositoryTrip repositoryTrip;
    private Purchase purchase;

    public ServiceUpdatePurchase(RepositoryPurchase repositoryPurchase, RepositoryTrip repositoryTrip){
        this.repositoryPurchase = repositoryPurchase;
        this.repositoryTrip = repositoryTrip;
    }

    public Purchase run(long id, Purchase purchase) {
        int weekDayUpdate = 0;
        this.purchase = purchase;
        Trip trip = getTripUpdate(purchase.getIdTrip());
        try{
            weekDayUpdate = getDayOfWeek(trip.getTripDate());
        }catch (ParseException e) {
            e.printStackTrace();
        }
        setPurchaseUpdateValues(id, purchase, trip, weekDayUpdate);
        updateTrip(trip);
        return this.repositoryPurchase.createPurchase(this.purchase);
    }

    public String getDateNow(){
        LocalDate now = LocalDate.now();
        return now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private int getDayOfWeek(String tripDate) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(tripDate);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private int getDiscountPercentage(int numberPurchasedTickets, int weekDay){
        int discountPercentage = 0;
        if( numberPurchasedTickets >= 4 ) { discountPercentage+=10; }
        if( weekDay<=4 ) { discountPercentage+=10; }
        return  discountPercentage;
    }

    private void updateTrip(Trip trip){
        trip.setSeatsAvailable(trip.getSeatsAvailable()-1);
        trip.setSeatsSold(trip.getSeatsSold()+1);
        this.repositoryTrip.updateTrip(trip.getId(), trip);
    }

    private void setPurchaseUpdateValues(long id, Purchase purchaseValues, Trip tripValues, int weekDay){
        this.purchase.setId(id);
        this.purchase.setPurchaseDate(getDateNow());
        this.purchase.setTripDate(tripValues.getTripDate());
        this.purchase.setTicketAmount(tripValues.getTicketAmount());
        double totalWithoutDiscount = purchase.getNumberPurchasedTickets() * purchase.getTicketAmount();
        double discountAmount = totalWithoutDiscount*(purchaseValues.getDiscountPercentage())/100;
        this.purchase.setDiscountPercentage(getDiscountPercentage(purchaseValues.getNumberPurchasedTickets(), weekDay));
        this.purchase.setTotalPurchaseAmount(totalWithoutDiscount-discountAmount);
    }

    public Trip getTripUpdate(long id){
        return this.repositoryTrip.searchTrip(id);
    }
}
