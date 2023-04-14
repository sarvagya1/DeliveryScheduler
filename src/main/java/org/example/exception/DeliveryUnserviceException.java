package org.example.exception;

public class DeliveryUnserviceException extends Exception {
    public DeliveryUnserviceException(String deliveryCannotHappen) {
        super(deliveryCannotHappen);
    }
}
