package edu.miu.cs489;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World Docker!" );
        int count = 0;
        try {
            while(true) {
                Thread.sleep(2000);
                System.out.printf("App is still running. Iteration #: %d\n", ++count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
