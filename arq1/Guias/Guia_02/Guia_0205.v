
module Guia_0205;
// define data
reg [7:0] a = 8'b000_1010 ; // binary
reg [7:0] b = 8'b000_1100 ; // binary
reg [7:0] c;
// actions
  initial
    begin : main
 
      $display ( "Guia_0205 - Tests" );

      a = 8'b0010_0011; 
      b = 8'b0001_0010; 
      c = a + b;
      $display ( "a.) a+b = %4b,%4b", c[7:4], c[3:0]);

      a = 8'b0101_0010; 
      b = 8'b0001_1011; 
      c = a - b;
      $display ( "b.) a-b = %4b,%4b", c[7:4], c[3:0]);

      a = 8'b0101_0101; 
      b = 8'b0000_1111; 
      c = a / b;
      $display ( "d.) a/b = %4b,%4b", c[7:4], c[3:0]);

      a = 8'b0110_1101; 
      b = 8'b0000_1101; 
      c = a % b;
      $display ( "e.) a%%b = %b", c);
    end // main
endmodule // Guia_0205
