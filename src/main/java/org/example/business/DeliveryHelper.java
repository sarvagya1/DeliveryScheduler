package org.example.business;

import org.example.exception.DeliveryUnserviceException;
import org.example.exception.OverlapScheduleException;

import static org.example.business.OverlapFetcher.deliveryTimingOverlap;

public class DeliveryHelper {
    public static void serveDelivery(int totalNumberOfCustomerOrder, int totalDeliveryPersonal, int[][] orderDetailsArray) throws DeliveryUnserviceException {
        if (totalNumberOfCustomerOrder == 0 || totalDeliveryPersonal == 0) {
            throw new DeliveryUnserviceException("Food delivery cannot happen");
        }

        int[] deliveryAvailableStatus = new int[totalDeliveryPersonal];

        for (int i = 0; i< orderDetailsArray.length;i++) {
            for (int j =0; j < orderDetailsArray[i].length; j++) {
                for (int k = 0 ; k < totalDeliveryPersonal; k++) {
                    if (deliveryPersonalAvailable(deliveryAvailableStatus, k)){
                        // check for timing overlap
                        try {
                            if (deliveryTimingOverlap(orderDetailsArray).length != 0) {
                                System.out.println("Delivery will be served");
                            }
                        } catch (OverlapScheduleException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("Delivery will not be served");
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public static boolean deliveryPersonalAvailable(int[] deliveryAvailableStatus, int k) {
        if (deliveryAvailableStatus[k] == 0 || deliveryAvailableStatus[k] == -1) {
            // means delivery person is available
            deliveryAvailableStatus[k] = 1;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
