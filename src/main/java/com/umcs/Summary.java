package com.umcs;

import java.util.LinkedList;
import java.util.List;

public class Summary {
  private String month;
  private Double averagePrice;
  private Double lowestPrice;
  private Double highestPrice;
  private List<String> top3 = new LinkedList<>();
  private Boolean perYear = false;

  public Summary() {
    this.month = month;
    this.averagePrice = averagePrice;
    this.lowestPrice = lowestPrice;
    this.highestPrice = highestPrice;
  }

  public Double getHighestPrice() {
    return highestPrice;
  }

  public void setHighestPrice(Double highestPrice) {
    this.highestPrice = highestPrice;
  }

  public Double getLowestPrice() {
    return lowestPrice;
  }

  public void setLowestPrice(Double lowestPrice) {
    this.lowestPrice = lowestPrice;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public Boolean isPerYear() {
    return perYear;
  }

  public void setPerYear(Boolean perYear) {
    this.perYear = perYear;
  }

  public boolean companyStoppedBeingTraded() {
    return false;
  }

  public List<String> getTop3() {
    return top3;
  }

  public void setTop3(List<String> top3) {
    this.top3 = top3;
  }
}
