package com.sdwproject.sdwbackend.exceptions;

import com.sdwproject.sdwbackend.util.MessageUtils;

public class NotFoundException extends RuntimeException  {

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}
