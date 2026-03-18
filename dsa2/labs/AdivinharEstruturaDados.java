import java.util.Scanner;

class Queue{
    int[] arr;
    int n;

    public Queue(int maxSize){
        this.arr = new int[maxSize];
        this.n = 0;
    }
    public void push(int num){
        this.n++;
        this.arr[this.n-1] = num;
    }
    public int pop(){
        if (this.n == 0) {
            return -1;
        }
        int removed = this.arr[0];
        for(int i=0; i<this.n-1; i++){
            this.arr[i] = this.arr[i+1];
        }
        this.n--;
        return removed;
    }
}

class Stack{
    int[] arr;
    int n;

    public Stack(int maxSize){
        this.arr = new int[maxSize];
        this.n = 0;
    }
    public void push(int num){
        this.arr[this.n] = num;
        this.n++;
    }
    public int pop(){
        if (this.n == 0) {
            return -1;
        }
        int removed = this.arr[this.n-1];
        this.n--;
        return removed;
    }
}

class PQueue{
    int[] arr;
    int n;

    public PQueue(int maxSize){
        this.arr = new int[maxSize];
        this.n = 0;
    }
    public void push(int num){
        this.n++;
        this.arr[this.n-1] = num;
    }
    public int pop(){
        if (this.n == 0) {
            return -1;
        }
        int bIndex = 0;
        for(int i=1; i<this.n; i++){
            if(this.arr[i] > this.arr[bIndex]) bIndex = i;
        }
        int removed = this.arr[bIndex];
        for(int i=bIndex; i<this.n-1; i++){
            this.arr[i] = this.arr[i+1];
        }
        this.n--;
        return removed;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int inputs = sc.nextInt();
            int command; int entry;
            Queue queue = new Queue(inputs); boolean isQueue = true;
            Stack stack = new Stack(inputs); boolean isStack = true;
            PQueue pqueue = new PQueue(inputs); boolean isPQueue = true;
            
            for(int j=0; j<inputs; j++){
                command = sc.nextInt();
                entry = sc.nextInt();
                if(command == 1){
                    queue.push(entry);
                    stack.push(entry);
                    pqueue.push(entry);
                }else if(command == 2){
                    if(queue.pop() != entry){
                        isQueue = false;
                    }
                    if(stack.pop() != entry){
                        isStack = false;
                    }
                    if(pqueue.pop() != entry){
                        isPQueue = false;
                    }
                }
            }
            if(isQueue && !isPQueue && !isStack){
                System.out.println("queue");
            }else if(!isQueue && isPQueue && !isStack){
                System.out.println("priority queue");
            }else if(!isQueue && !isPQueue && isStack){
                System.out.println("stack");
            }else if(!isQueue && !isPQueue && !isStack){
                System.out.println("impossible");
            }else{
                System.out.println("not sure");
            }
        }

        sc.close();
    }
}