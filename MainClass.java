package p5_package;


import p5_package.StackClass;
import p5_package.IteratorClass;

public class MainClass {

   public static void main(String[] args) 
   {
       int index; 
       int value;
       int arrayCapacity = 10;
       
       IteratorClass iteratorTest = new IteratorClass(arrayCapacity);
       
       System.out.println("ITERATOR TEST");
       
       //before current
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           value = (int) (index *10 * Math.random());
           if( !iteratorTest.setBeforeCurrent(value) )
           {
        	   System.out.println( "Failed to insert!" );
           }
           iteratorTest.runDiagnosticDisplay();
       }
       
       //Move down list
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           iteratorTest.movePrev();
           iteratorTest.runDiagnosticDisplay();
       }
       
       //Move up list
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           iteratorTest.moveNext();
           iteratorTest.runDiagnosticDisplay();
       }
       
       //after current
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           value = (int) (index *10 * Math.random());
           iteratorTest.setAfterCurrent(value);
           iteratorTest.runDiagnosticDisplay();
       }
       
       //removes
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           iteratorTest.removeAtCurrent();
           iteratorTest.runDiagnosticDisplay();
       }

       StackClass stack = new StackClass(arrayCapacity);
       
       System.out.println("STACK TEST");
       
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           value = (int) (index+1 *10 * Math.random());
           stack.push(value);
           stack.displayStack();
           
       }
       
       
           
       for ( index = 0; index < (arrayCapacity * 2); index ++)
       {
           int topvalue=stack.peekTop();
           System.out.println("Top:"+topvalue);
           stack.pop();
           stack.displayStack();
       }
       
   }

}