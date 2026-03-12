
module Guia_0102;
  integer x=0;
  reg[7:0] b = 8'b0;

  initial
   begin:main
      $display("Guia_0102 - Tests");
      b = 8'b10010;
      $write(" A.) %8b(2) =", b);
      x = b;
      $write(" %d(10)", x);
      b = 8'b10101;
      $write("\n B.) %8b(2) =",b);
      x = b;
      $write(" %d(10)", x);
      b = 8'b10110;
      $write("\n C.) %8b(2) =", b);
      x = b;
      $write(" %d(10)", x);
      b = 8'b101011;
      $write("\n D.) %8b(2) =", b);
      x = b;
      $write(" %d(10)", x);
      b = 8'b111011;
      $write("\n E.) %8b(2) =", b);
      x = b;
      $write(" %d(10)", x);

   end // main

endmodule //Guia_0102

