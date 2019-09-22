package com.wilson.ProcessFile.model;

import lombok.*;

@Getter
@Builder
@ToString
public class Result {
   private final Integer coutUser;
   private final Integer coutSalesman;
   private final String idMaxSale;
   private final  String idMinSalesman;
}
