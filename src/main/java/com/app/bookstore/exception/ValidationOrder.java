package com.app.bookstore.exception;

import jakarta.validation.GroupSequence;

@GroupSequence({BasicInfo.class, AdvanceInfo.class})
public interface ValidationOrder {

}
