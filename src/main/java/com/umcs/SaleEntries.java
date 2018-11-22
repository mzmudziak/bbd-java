package com.umcs;

import java.util.LinkedList;
import java.util.List;

public class SaleEntries<T> {
  private String sourceFileName;
  private List<T> entries = new LinkedList<>();

  public int getSize() {
    return entries.size();
  }

  public String getSourceFileName() {
    return sourceFileName;
  }

  public void setSourceFileName(String sourceFile) {
    this.sourceFileName = sourceFile;
  }
}
