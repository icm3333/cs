
//https://embarcados.com.br/tutorial-de-verilog-mux-em-verilog/
module mux(output out, input a, input b, input chave);
    wire c1, a1, b1;
    not NOT_1(c1, chave);
    and AND_1(a1, c1, a);
    and AND_2(b1, chave, b);
    or  OR_1(out, a1, b1);
endmodule //mux

module a(output s, input a, input b, input c);

    wire saida_mux1, saida_mux2;

    mux saida1(saida_mux1, a, b, c);
    mux saida2(saida_mux2, ~b, ~a, c);
    mux final(s, saida_mux1, saida_mux2, ~c);

endmodule //a

module tb;

    reg a, b, c;
    wire s;
    a teste(s, a, b, c);

    initial begin
        $display("a b c | s");
        $display("------|--");

        a=0; b=0; c=0; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=0; b=0; c=1; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=0; b=1; c=0; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=0; b=1; c=1; #10;
        $display("%b %b %b | %b", a, b, c, s);
        
        a=1; b=0; c=0; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=1; b=0; c=1; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=1; b=1; c=0; #10;
        $display("%b %b %b | %b", a, b, c, s);

        a=1; b=1; c=1; #10;
        $display("%b %b %b | %b", a, b, c, s);
        $finish;
    end//begin

endmodule //tb;