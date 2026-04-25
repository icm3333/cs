
module f (output s, input x, input y);
    wire w1, w2, w3, w4, w5;
    not NOT_1 (w1, x); // saida x'
    not NOT_2 (w2, y); // saida y'
    and OR__1 (w3, x, w1); // X E X', saida 0 em w3
    or OR__2 (w4, w2, y); // (w2= y')e y, saida 1 em w4
    not NOT_3 (w5, w4); // w4 = 1, saida 0 em w5
    and AND_1 (s, w3, w5); // w3 = 0, w5 = 0, saida 0 em S
endmodule // s = f (x,y)

module tb;
 reg xx, yy;
 wire ss;

 f teste (ss, xx, yy);

 initial begin
    $display("x y | s");
    $display("----|--");

    xx=0; yy=0; #10;
    $display("%b %b | %b", xx, yy, ss);

    xx=0; yy=1; #10;
    $display("%b %b | %b", xx, yy, ss);

    xx=1; yy=0; #10;
    $display("%b %b | %b", xx, yy, ss);

    xx=1; yy=1; #10;
    $display("%b %b | %b", xx, yy, ss);

    $finish;

 end

endmodule //tb