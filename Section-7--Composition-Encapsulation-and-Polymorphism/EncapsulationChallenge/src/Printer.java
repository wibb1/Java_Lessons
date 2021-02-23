public class Printer {
  private double toner;
  private int pages;
  private boolean duplex;
  private boolean tonerAlert;

  public Printer(boolean duplex) {
    this.duplex = duplex;
    this.pages = 0;
    this.toner = 0;
  }

  public int getPages() {
    return pages;
  }

  public double getToner() {
    return toner;
  }

  public boolean isDuplex() {
    return duplex;
  }

  public boolean isTonerAlert() {
    return tonerAlert;
  }

  public void fillToner() {
    this.toner = 100;
    System.out.println("\nToner has been filled to 100%.");
    this.tonerAlert = false;
  }

  public void printPages(int pages) {
    int lessPages = 0;
    int printedPages = 0;
    if (useToner(pages) > this.toner) {
      printedPages = (int) (this.toner / 0.01);
      lessPages = pages - printedPages;
      pages = printedPages;
      this.tonerAlert = true;
    } else {
      this.toner -= useToner(pages);
    }
    this.pages += pages;
    if (this.isTonerAlert()) {
      printMessage(printedPages, lessPages);
    } else if (isDuplex()) {
      printMessage(pages);
    } else {
      printMessage(pages);
    }
  }

  public double useToner(int pages) {
    return pages * 0.01;
  }

  public void printMessage(int pages) {
    duplexMessage();
    System.out.println(pages + " pages printed, you have printed " + this.pages + " pages in total");
    System.out.println("Your printer ink is " + this.toner + "% full.");
  }

  public void printMessage(int pages, int lessPages) {
    duplexMessage();
    System.out.println(pages + " pages printed, you have printed " + this.pages
        + " pages in total, and your printer ink is empty.");
    System.out.println("Please refill your printer ink to print the remaining "
        + lessPages + " pages.");
  }

  public void duplexMessage() {
    if (duplex) {
      System.out.print("\nYou are printing on both sides and have ");
    } else {
      System.out.print("\nYou are printing single sided and have ");
    }
  }
}
