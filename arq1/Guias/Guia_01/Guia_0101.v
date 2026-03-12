
module Guia_0101;
  integer x=27;
  reg [15:0] b=0;

  initial
   begin : main
      $display("Guia_0101 - Tests");

      $write(" A.) %d(10) =", x);
      b = x;
      $write(" %8b(2)", b);
      x = 56;
      $write("\n B.) %d(10) =", x);
      b = x;
      $write(" %8b(2)", b);
      x = 753;
      $write("\n C.) %d(10) =", x);
      b = x;
      $write(" %16b(2) =", b);
      x = 321;
      $write("\n D.) %d(10) =", x);
      b = x;
      $write(" %16b(2)",b);
      x = 366;
      $write("\n E.) %d(10) =", x);
      b = x;
      $write(" %16b(2)", b);
    end // main
endmodule // Guia_0101

