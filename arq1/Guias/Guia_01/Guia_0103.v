
module Guia_0103;
  integer x = 49;
  reg[15:0] b = 0;

  initial
   begin:main
      $display("Guia_0103 - Tests");
      $write(" A.) %d(10) =", x);
      b = x;
      $write(" B = %b(2) | O = %o(8) | Hex = %x", b, b, b);
      
      x = 61;
      $write("\n B.) %d(10) =", x);
      b = x;
      $write(" B = %b(2) | O = %o(8) | Hex = %X", b, b, b);

      x = 77;
      $write("\n C.) %d(10) =", x);
      b = x;
      $write(" B = %b(2) | O = %o(8) | Hex = %X", b, b, b);

      x = 135;
      $write("\n D.) %d(10) =", x);
      b = x;
      $write(" B = %b(2) | O = %o(8) | Hex = %X", b, b, b);

      x = 763;
      $write("\n B.) %d(10) =", x);
      b = x;
      $write(" B = %b(2) | O = %o(8) | Hex = %X", b, b, b);

      
   end//main
endmodule//Guia_0103
