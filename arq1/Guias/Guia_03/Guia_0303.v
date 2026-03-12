
module Guia_0303;
  reg signed [4:0] a = 5'b10111;
  reg signed [5:0] b = 6'b110101;
  reg signed [5:0] c = 6'b100100;
  reg signed [6:0] d = 7'b1011011;
  reg signed [6:0] e = 7'b1111101;
  
  reg signed[7:0] aux1 =0;
  reg signed[7:0] aux2 = 0;

  initial
    begin:main
      $display ("Guia_0303 - Tests" );
      aux1 = ~a+1;
      aux2 = ~(a-1);
      $display ("a = %5b -> C1(a) = %5b -> (+a) = %5b = %d (10)", a, ~a, aux1[4:0], aux2 );

      aux1 = ~b+1;
      aux2 = ~(b-1);
      $display ("b = %6b -> C1(b) = %6b -> (+b) = %6b = %d (10)", b, ~b, aux1[5:0], aux2 );

      aux1 = ~c+1;
      aux2 = ~(c-1);
      $display ("c = %6b -> C1(c) = %6b -> (+c) = %6b = %b (2)", c, ~c, aux1[5:0], aux2[5:0] );

      aux1 = ~d+1;
      aux2 = ~(d-1);
      $display ("d = %7b -> C1(d) = %7b -> (+d) = %7b = %b (2)", d, ~d, aux1[6:0], aux2[6:0] );

      aux1 = ~e+1;
      aux2 = ~(e-1);
      $display ("e = %7b -> C1(e) = %7b -> (+e) = %7b = %h (16)", e, ~e, aux1[6:0], aux2[3:0] );

    end//main
endmodule //guia
