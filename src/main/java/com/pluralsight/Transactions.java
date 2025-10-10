package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;

//I looked at the SearchInventory repository on GitHub to guide me on this!
public class Transactions {
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private String description;
    private String vendor;
    private Double amount;

    public Transactions(LocalDate paymentDate,LocalTime paymentTime,String description,String vendor,Double amount){
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    public LocalDate getPaymentDate(){
        return paymentDate;
    }
    public LocalTime getPaymentTime(){
        return paymentTime;
    }
    public String getDescription(){
        return description;
    }
    public String getVendor(){
        return vendor;
    }
    public Double getAmount(){
        return amount;
    }
    @Override
    public String toString(){
        //I found a simpler way to write this instead of using something like: ("#%-10d %-18s %10.2f", id,name,price);
        return paymentDate + "|" + paymentTime + "|" + description + "|" + vendor + "|" + amount;
    }
}
