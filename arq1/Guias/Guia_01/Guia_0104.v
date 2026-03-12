
module Guia_0104;
  reg[7:0]b=8'b10101;

  initial
    begin:main
      $display("Guia_0104 - Tests");
    
      $write(" A.) %8b(2) =", b);
      $write(" %d%d%d(4)", b[5:4], b[3:2], b[1:0]);

      b=8'b11000;
      $write("\n B.) %8b(2) =", b);
      $write(" %d%d(8)", b[5:3],b[2:0]);

      b=8'b100101;
      $write("\n C.) %8b(2) =", b);
      $write(" %h%h(16)", b[7:4],b[3:0]);

      b=8'b101101;
      $write("\n D.) %8b(2) =", b);
      $write(" %d%d(8)", b[5:3],b[2:0]);

      b=8'b110101;
      $write("\n B.) %8b(2) =", b);
      $write(" %d%d%d(4)", b[5:4],b[3:2],b[1:0]);
      

    end//main
endmodule//guia_0104
