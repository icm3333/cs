
module Guia_0203;  
  initial
   begin:main
     $display ( "Guia_0203 - Tests");
     $display("a.) 0,001011(2) = 0.%d%d%d(4)", 2'b00, 2'b10, 2'b11);
     $display("b.) 0,100011(2) = 0.%o%o(8)", 3'b100, 3'b011);
     $display("c.) 0,101100(2) = 0.%h%h(16)", 4'b1011, 4'b0000);
     $display("d.) 1,110010(2) = 1.%o%o(8)", 3'b110, 3'b010);
     $display("e.) 1101,1001(2) = %h,%h(16)", 4'b1101, 4'b1001);
  end // main
endmodule // guia_0203
