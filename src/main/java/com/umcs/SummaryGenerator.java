package com.umcs;

import java.util.Map;

public class SummaryGenerator<T> {
  public Summary monthlySummary(SaleEntries<T> saleEntries) {
    return new Summary();
  }

  public Summary yearlySummary(Map<String, SaleEntries<T>> months) {
    return new Summary();
  }
}
