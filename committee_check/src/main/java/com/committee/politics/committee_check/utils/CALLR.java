package com.committee.politics.committee_check.utils;

import lombok.Data;

import java.util.List;

@Data
public class CALLR<T>{
    private boolean result;

    private String message;

    private List<T> data ;

    private String status;
}
