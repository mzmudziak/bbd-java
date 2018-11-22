package com.umcs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVFileReader {
  public static SaleEntries<CompanySaleEntry> read(String filename, Integer numRecords, Character character) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(filename));
    scanner.useDelimiter(";");
    while (scanner.hasNext()) {
      System.out.print(scanner.next() + "|");
    }
    scanner.close();

    SaleEntries<CompanySaleEntry> saleEntries = new SaleEntries<>();
    saleEntries.setSourceFileName(filename);
    return saleEntries;
  }
}
