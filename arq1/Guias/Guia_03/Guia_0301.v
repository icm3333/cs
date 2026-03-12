
module Guia_0301;
  //variaveis originais
  reg [5:0] a = 6'b1010;
  reg [7:0] b = 8'b1001;
  reg [5:0] c = 6'b101001;
  reg [6:0] d = 7'b101011;
  reg [7:0] e = 8'b111010;
  //variaveis "invertidas"
  reg [5:0] cc = 0;
  reg [6:0] dd = 0;
  reg [7:0] ee = 0;

  initial
  begin:main
    $display ( "Guia_0301 - Tests" );
    cc = ~c+1;
    dd = ~d+1;
    ee = ~e+1;

    $display("A.) [%4b] -> C1 [%6b]", a[3:0], ~a);
    $display("B.) [%4b] -> C1 [%8b]", b[3:0], ~b);
    $display("C.) [%6b] -> C1 [%6b] -> C2 [%6b]", c[5:0], ~c, cc);
    $display("D.) [%6b] -> C1 [%7b] -> C2 [%7b]", d[5:0], ~d, dd);
    $display("A.) [%6b] -> C1 [%8b] -> C2 [%8b]", e[5:0], ~e, ee);
  end//main
endmodule//guia
