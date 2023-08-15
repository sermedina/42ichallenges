//Coded and tested in https://www.jdoodle.com/online-java-compiler/
public class MyClass {
    
    public static int smallestDifference(int[] a, int[] b) {
    
        int substract= -1;
        int smallestInABLoop = 0;

        int[] smallestAB = new int[a.length];

        //Looping from A to B. Storing in smallestAB each smallest value for each loop
        for (int i=0; i<a.length;i++) {        
            smallestInABLoop = b[i]- a[i];       
            for (int j=i; j<b.length;j++) {            
                substract = a[i] - b[j];            
                if (substract >=0 && substract <= smallestInABLoop) {
                    smallestInABLoop= substract;
                }
                smallestAB[i] = smallestInABLoop;    
            }
        }

        int smallestInBALoop = 0;

        int[] smallestBA = new int[b.length];
        //Looping from B to A. Storing in smallestBA each smallest value for each loop
        for (int i=0; i<b.length;i++) {      
            smallestInBALoop = b[i]- a[i];        
            for (int j=i; j<a.length;j++) {           
                substract = b[i] - a[j];
                if (substract >=0 && substract <= smallestInBALoop) {
                    smallestInBALoop= substract;
                }
                smallestBA[i] = smallestInBALoop;    
            }    
        }

        int smallestABValue = smallestAB[0];

        //Looping through smallestAB to get its smallest value
        for (int i=1; i<smallestAB.length;i++) {
            if (smallestAB[i]<smallestABValue) {
                 smallestABValue = smallestAB[i];
            }

         }

        int smallestBAValue = smallestBA[0];

        //Looping through smallestBA to get its smallest value
        for (int i=1; i<smallestBA.length;i++) {
            if (smallestBA[i]<smallestBAValue) {
                 smallestBAValue = smallestBA[i];
            }

        }

        //Comparing AB and BA smallest values
        if (smallestABValue < smallestBAValue) {
            return smallestABValue;
        } else {
            return smallestBAValue;
        }
    
    }
 
    
    public static void main(String args[]) {
        int[]  a = {1,3,15,11,2};
        int[]  b = {23,127,235,19,8};

        //int[] a = {10, 5, 40};
        //int[] b = {50, 90, 80};

        int result = smallestDifference(a,b);

        if (result >= 0) {
            System.out.println("Smallest difference = " + result);
        } else {
            System.out.println("There are not positive difference");
        }
  
    }
  
}


