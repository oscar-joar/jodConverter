
package com.myTest.demo.configuration;

import com.sun.star.awt.Size;
import com.sun.star.beans.PropertyValue;
import com.sun.star.lang.IllegalArgumentException;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.view.PaperFormat;
import com.sun.star.view.XPrintable;

import org.jodconverter.core.office.OfficeContext;
import org.jodconverter.local.filter.FilterChain;
import org.jodconverter.local.filter.RefreshFilter;


/**
 * Configure paper properties.
 */
public class JodFilter extends RefreshFilter {

  public static final Size A6;
  public static final Size A5;
  public static final Size A4;
  public static final Size A3;
  public static final Size A2;
  public static final Size A1;
  public static final Size A0;

  public static final Size B6;
  public static final Size B5;
  public static final Size B4;
  public static final Size B3;
  public static final Size B2;
  public static final Size B1;
  public static final Size B0;

  public static final Size CUSTOM;

  static {
    A6 = new Size(10500, 14800);
    A5 = new Size(14800, 21000);
    A4 = new Size(21000, 29700);
    A3 = new Size(29700, 42000);
    A2 = new Size(42000, 59400);
    A1 = new Size(59400, 84100);
    A0 = new Size(84100, 118900);

    B6 = new Size(12500, 17600);
    B5 = new Size(17600, 25000);
    B4 = new Size(25000, 35300);
    B3 = new Size(35300, 50000);
    B2 = new Size(50000, 70700);
    B1 = new Size(70700, 100000);
    B0 = new Size(100000, 141400);

    CUSTOM = new Size(67000, 20000);
  }

  /**
   * Creates a new filter.
   */
  public JodFilter() {
    this(false);
  }

  /**
   * Creates a new refresh filter that can call next filter in the chain according to the specified argument.
   *
   * @param lastFilter If {@code true}, the filter won't call the next filter in the chain. If {@code false}, the next
   *                   filter in the chain, if any, will be applied.
   */
  public JodFilter(final boolean lastFilter) {
    super(lastFilter);
  }

  @Override
  public void doFilter(
      final OfficeContext context,
      final XComponent document,
      final FilterChain chain)
      throws Exception {

    setPaperInfo(document, A3);

    super.doFilter(context, document, chain);
  }

  /**
   * Configure the paper format and size. The orientation is portrait by default.
   *
   * @param document  the document to configure.
   * @param paperSize A0, ..., A6, B0, ..., B6
   * @throws IllegalArgumentException when errors in paper properties.
   */
  private void setPaperInfo(final XComponent document, final Size paperSize) throws IllegalArgumentException {

    final XPrintable xPrintable = UnoRuntime.queryInterface(XPrintable.class, document);
    final PropertyValue[] printerDesc = new PropertyValue[3];

    // Paper Format
    printerDesc[0] = new PropertyValue();
    printerDesc[0].Name = "PaperFormat";
    printerDesc[0].Value = PaperFormat.USER;

    // Paper Size
    printerDesc[1] = new PropertyValue();
    printerDesc[1].Name = "PaperSize";
    printerDesc[1].Value = paperSize;

    xPrintable.setPrinter(printerDesc);

  }
}
