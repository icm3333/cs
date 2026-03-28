import java.util.Scanner;

class Driver{
  int in;
  int out;

  public Driver(int in, int out){
    this.in = in;
    this.out = out;
  }
}

class Stack{
  Driver[] arr;
  int top;

  public Stack(int MaxCap){
   arr = new Driver[MaxCap];
   this.top = -1;
  }
  
  public boolean push(int in, int out){
    while((top >= 0) && (arr[top].out <= in)){
      top--;
    }

   if((top >= 0) && (out > arr[top].out)){
    return false; 
   }

   if(top+1 >= arr.length){
    return false;
   }

   top++;
   arr[top] = new Driver(in, out);
   return true;
  }
}

class ParkingLot{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    while(sc.hasNextLine()){
      int DriverCount = sc.nextInt();
      int MaxCap = sc.nextInt();

      if(DriverCount == 0 && MaxCap == 0) break;

      Stack lot = new Stack(MaxCap);
      boolean possible = true;
      
      for(int i=0; i<DriverCount; i++){
        if(!lot.push(sc.nextInt(), sc.nextInt())){
          possible = false;
        }
      }

      if(possible){
        System.out.println("SIM");
      }else{
        System.out.println("NAO");
      }
    }
    sc.close();
  }
}
