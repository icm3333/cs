
module Guia_0302;
  //variaveis originais
  reg [5:0] a = 6'b100111; 
  reg [7:0] b = 8'hD6;
  reg [5:0] c = 6'b110110;
  reg [9:0] d = 10'o157;   
  reg [7:0] e = 8'h8E;

  //variaveis "invertidas"
  reg [5:0] cc = 0;
  reg [9:0] dd = 0;
  reg [7:0] ee = 0;

  initial
  begin:main
    $display ( "Guia_0302 - Tests" );
    cc = ~c+1;
    dd = ~d+1;
    ee = ~e+1;

    $display("A.) [%6b] -> C1 [%6b]", a, ~a);
    $display("B.) [%8b] -> C1 [%8b]", b, ~b);
    $display("C.) [%6b] -> C1 [%6b] -> C2 [%6b]", c, ~c, cc);
    $display("D.) [%10b] -> C1 [%10b] -> C2 [%10b]", d, ~d, dd);
    $display("E.) [%8b] -> C1 [%8b] -> C2 [%8b]", e, ~e, ee);
  end//main

endmodule//guia
