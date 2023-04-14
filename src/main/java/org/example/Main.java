package org.example;

import org.example.business.DeliveryHelper;
import org.example.exception.DeliveryUnserviceException;

public class Main {
    public static void main(String[] args) {
        int totalNumberOfCustomerOrder = 6;
        int totalDeliveryPersonal = 2;
        int[][] orderDetailsArray = { {1,10}, {4,20}, {15,5}, {22,20}, {24,10}, {25,10} };

        try {
            DeliveryHelper.serveDelivery(totalNumberOfCustomerOrder, totalDeliveryPersonal, orderDetailsArray);
        } catch (DeliveryUnserviceException e) {
            System.out.println(e.getMessage());
        }
    }

}