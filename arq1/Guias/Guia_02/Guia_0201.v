
module Guia_0201;
  real resultado;

  function automatic real mudaBaseFracionaria(input [7:0] b);
    real x;
    real power2;
    integer y;

      begin
        x = 0.0;
        power2=1.0;
        y = 7;

        while(y>=0)
          begin
            power2 = power2/2.0;
            if(b[y] == 1)
            begin
                x = x + power2;
            end
            y = y-1;
          end
          mudaBaseFracionaria = x;
        end //while
  endfunction //mudaBase

  initial begin
    $display("Guia_0201 - Tests");
    
    resultado = mudaBaseFracionaria(8'b00011000);
    $display(" A.) %.5f", resultado);

    resultado = mudaBaseFracionaria(8'b01101000);
    $display(" B.) %.5f", resultado);

    resultado = mudaBaseFracionaria(8'b10001000);
    $display(" C.) %.5f", resultado);

    resultado = mudaBaseFracionaria(8'b1011000);
    resultado = resultado + 1.0; // somando parte inteira
    $display(" D.) %.5f", resultado);

    resultado = mudaBaseFracionaria(8'b10101000);
    resultado = resultado + 2.0; // somando parte inteira
    $display(" E.) %.5f", resultado);



  end //main
endmodule//Guia_0201
