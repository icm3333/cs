
module a(output o, input a, input b);
    wire xnor_resultado, nor_resultado;
    xnor XNOR_1(xnor_resultado, a, b);
    nor  NOR_1(nor_resultado, ~a, ~b);
    nand (o, xnor_resultado, nor_resultado);
endmodule //a

module tb;
    reg a, b;
    wire o;
    a eba(o, a, b);

    initial begin
        $display("a b | o");
        $display("----|--");

        a = 0; b = 0; #10;
        $display("%b %b | %b", a, b, o);
        
        a = 0; b = 1; #10;
        $display("%b %b | %b", a, b, o);
        
        a = 1; b = 0; #10;
        $display("%b %b | %b", a, b, o);
        
        a = 1; b = 1; #10;
        $display("%b %b | %b", a, b, o);
        $finish;
    end//begin

endmodule//tb