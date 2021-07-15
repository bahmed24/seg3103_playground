public class Fizz {
    private int number;
    public Fizz(int number){
        this.number = number;
    }

    public String fizzBuzz()
    {
        for (int i=1; i<=number; i++)                                
        {
           
            if (i%15==0)                                                
                return ("FizzBuzz"+" ");

            else if (i%5==0)    
                return ("Buzz"+" ");

            else if (i%3==0)    
                return ("Fizz"+" ");
                 
            else 
                return (i+" ");                        
        }
    }
}