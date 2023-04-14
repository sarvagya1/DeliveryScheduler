package org.example.exception;

public class OverlapScheduleException extends Exception {
    public OverlapScheduleException(String deliveryCannotHappen) {
        super(deliveryCannotHappen);
    }
}
