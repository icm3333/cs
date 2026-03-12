
module Guia_0304;

  reg signed [15:0] a = 0 ;
  reg signed [15:0] b = 0 ;
  reg signed [15:0] d = 0 ;


  initial
    begin : main
      $display ("Guia_0304 - Tests" );

      a = 6'b011011; 
      b = 6'b001101; 
      d = a-b;
      $display ( "a.) d = a-b = %b(2) - %b(2) = %b(2)", a[4:0], b[3:0], d[4:0] );

      a = 8'b01011001; 
      b = 8'b00101100; 
      d = a-b;
      $display ( "b.) d = a-b = %b,%b(2) - %b,%b(2) = %b,%b(2)", a[6:4], a[3:0], b[5:4], b[3:0], d[5:4], d[3:0] );

      a = 7'b0110110; 
      b = 7'b0011011; 
      d = a-b;
      $display ("C) d = a-b = %7b-%7b = %7b = %d (10)", a[6:0], b[6:0], d[6:0], d );

      a = 10'o0754; 
      b = 10'o0367; 
      d = a-b;
      $display ("D) d = a-b = %10b-%10b = %10b = %o (8)", a[9:0], b[9:0], d[9:0], d );

      a = 16'h0A85; 
      b = 16'h0C14; 
      d = a-b;
      $display ("E) d = a-b = %16b-%16b = %16b = %h (16)", a, b, d, d );

    end // main
endmodule // Guia_0304
