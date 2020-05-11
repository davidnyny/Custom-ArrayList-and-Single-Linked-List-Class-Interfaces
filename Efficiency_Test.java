import java.util.Random;

public class Efficiency_Test {
    
    public static void main(String[] args) {
   
        InOrderArrayList<Integer> a = new InOrderArrayList<>();
        timeArrayList(a);
        
        InOrderSLL<Integer> s = new InOrderSLL<>();
        timeSLL(s);
        
        
    }
    
    
    /** Prints the run time using methods from InOrderSLL class
     */
    public static void timeArrayList(InOrderArrayList<Integer> testList){
        final int MAX_INT = 5000;
        final int START_SIZE = 1000;
        Random rnd = new Random(2); 
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < START_SIZE; i++) {
            int anInteger = rnd.nextInt(MAX_INT);
            testList.addOrder(anInteger);
        }
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("--------------------------------");
        System.out.println("\nPerformance of Ordered List using ArrayList");
        System.out.println(" Behaviour \t\t time ");
        System.out.println("--------------------------------");
        System.out.println(" Adding " + START_SIZE + " items " + " \t " + elapsedTime + " ms");
        
        
        // Add to beginning and end of list.
        testList.addOrder(-1);
        testList.addOrder(MAX_INT + 1);
        testList.removeOrder(1);
        testList.removeOrder(testList.size());
        
        startTime = System.currentTimeMillis();
        testList.removeOrder(testList.size());
        elapsedTime = System.currentTimeMillis() - startTime;
        
        System.out.println(" Remove last " + "\t\t " + elapsedTime + " ms");
        
        
        startTime = System.currentTimeMillis();
        testList.get(testList.size()/2);
        elapsedTime = System.currentTimeMillis() - startTime;
        
        System.out.println(" get item middle " + "\t " + elapsedTime + " ms");
        
        // Time to get the max and min of the list
        startTime = System.currentTimeMillis();
        testList.max();
        testList.min();
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(" Find max/min; " + "\t\t " + elapsedTime + " ms");
        
    }
    
    /** Prints the run time using methods from InOrderSLL class
     */
   public static void timeSLL(InOrderSLL<Integer> testList){
        
        final int MAX_INT = 5000;
        final int START_SIZE = 1000; // size of the random sequence to generated.
        Random rnd = new Random(2);
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < START_SIZE; i++) {
            int anInteger = rnd.nextInt(MAX_INT);
            testList.addOrder(anInteger);
        }
        
        long elapsedTime = System.currentTimeMillis() - startTime;
             System.out.println("--------------------------------");
        System.out.println("\nPerformance of Ordered List using SLL");
        System.out.println(" Behaviour \t\t time ");
          System.out.println("--------------------------------");
        System.out.println(" Adding " + START_SIZE + " items " + " \t " + elapsedTime + " ms");
        
        
        // Add to beginning and end of list.
        testList.addOrder(-1);
        testList.addOrder(MAX_INT + 1);
        testList.removeOrder(1);
        testList.removeOrder(testList.size());
        
        startTime = System.currentTimeMillis();
        testList.removeOrder(testList.size());
        elapsedTime = System.currentTimeMillis() - startTime;
        
        System.out.println(" Remove last " + "\t\t " + elapsedTime + " ms");
        
        //Timing method get
        startTime = System.currentTimeMillis();
        testList.get(testList.size()/2);
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(" get item middle " + "\t " + elapsedTime + " ms");
        
        // Time to get the max and min of the list
        startTime = System.currentTimeMillis();
        testList.max();
        testList.min();
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(" Find max/min; " + "\t\t " + elapsedTime + " ms");
        
        
    }

    
    
    
}