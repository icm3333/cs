
module Guia_0202;
    real x = 0.625000;
    integer xI = 0;
    reg[7:0] b;

  function automatic [7:0] decimalParaBinario(input real x);
      real temp_x;
      integer y;
      reg [7:0] b;

      begin
        temp_x = x;
        b = 8'b0;
        y = 7;

        while(temp_x>0 && y>=0) begin
          if(temp_x*2 >= 1) begin
            b[y] = 1;
            temp_x = temp_x*2.0 - 1.0;
          end else begin
            b[y] = 0;
            temp_x = temp_x*2;
          end
          y = y-1;
        end // while
        decimalParaBinario = b;
      end
  endfunction // decimalParaBinario

  initial begin:main
    $display ( "Guia_0202 - Tests" );
    
    $write(" A.) %.6f (10) =", x);
    b = decimalParaBinario(x);
    $write(" %b.%8b",xI[0:0], b);
    
    x = 0.125000;
    xI= 1;
    $write("\n B.) %.6f (10) =", x);
    b = decimalParaBinario(x);
    $write(" %b.%8b",xI[0:0], b);

    x = 0.250000;
    xI= 2;
    $write("\n C.) %.6f (10) =", x);
    b = decimalParaBinario(x);
    $write(" %3b.%8b",xI[1:0], b);

    x = 0.750000;
    xI= 4;
    $write("\n D.) %.6f (10) =", x);
    b = decimalParaBinario(x);
    $write(" %3b.%8b",xI[2:0], b);

    x = 0.875000;
    xI= 5;
    $write("\n E.) %.6f (10) =", x);
    b = decimalParaBinario(x);
    $write(" %3b.%8b",xI[2:0], b);

  end//main
endmodule //Guia_0202;
