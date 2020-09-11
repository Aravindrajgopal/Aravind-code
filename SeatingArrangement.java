import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class SeatingArrangement
{
    static boolean isPrime(int num){
        int i,m=0,flag=0;
        m=num/2;
        for(i=1;i<=m;i++)
        {
            if(num%i==0)
            {
                flag=1;
                return false;
            }
        }
        if(flag==0)
        return true;
	return false;
    }
    static boolean isPowOfTwo(int num){
        while(num>2)
        {
            if(num%2!=0)
                return false;
            else
            {
                num=num/2;
                return isPowOfTwo(num);
            }
        }
        if (num==2 || num==0)
            return true;
        else
            return false;
    }
     private static void print(List<int[][]> seats) {

        System.out.println("printing...");

        for (int[][] temp : seats) {

            for (int[] tempArray : temp) {
                System.out.println(Arrays.toString(tempArray));
            }
            System.out.println(); //blank line
        }
    }
     //method to create 2D array and initialize to zero
    private static List<int[][]> load(List<int[]> IP) {
        List<int[][]> result = new ArrayList<>();
        for (int[] temp : IP) {
            int[][] array = new int[temp[0]][temp[1]];

            //filling Array elements with zero (Initial value)
            for (int itr = 0; itr < temp[0]; itr++) {
                Arrays.fill(array[itr], 0);
            }
            result.add(array);

        }
        System.out.println("Seats are blanked now...");

        return result;
    }


    //method to decode the rows and columns
    public static List<int[]> decode(String IP) {

        String temp = IP.substring(1, IP.length()-1);
        int traverse = 0;
        List<int[]> tempList = new ArrayList();

        while (traverse < temp.length() - 1)
        {
            int[] tempArray = new int[2];
            tempArray[0] = Integer.parseInt(String.valueOf(IP.charAt(traverse + 1)));
            tempArray[1] = Integer.parseInt(String.valueOf(IP.charAt(traverse + 3)));
            traverse = traverse + 6;
            tempList.add(tempArray);
        }

        return tempList;
    }


  public static void main(String[] args) {
    int i,j,k=0,p,m=0,x;
   Scanner sc= new Scanner(System.in);
    System.out.print("enter the number of rows and columns");
    String IP1 = sc.nextLine();
    List<int[]> IP1List = decode(IP1.substring(1, IP1.length() - 1));
    System.out.print("enter the number of passenger id");
    int passengerId=sc.nextInt();
     int[] a=new int[passengerId];
     int[] prime=new int[passengerId];
     int[] twoPow=new int[passengerId];
     int[] b=new int[passengerId];
      System.out.print("enter the values in passenger id");
    for(i=0;i<passengerId;i++)
    {
     x=sc.nextInt();
         if(isPrime(x)==true)
          {
            prime[k++]=x;
          }
          else if(isPowOfTwo(x)==true)
          {
           twoPow[m++]=x;
           }
           else
              a[i]=x;
   }
       for(i=0;i<k;i++)
       {
           b[i]=prime[i];
       }
       for(j=i,p=0;j<m;j++)
       {
           b[k++]=twoPow[p++];
       }
       for(j=k,p=0;j<passengerId;j++)
       {
           b[k++]=a[p++];
       }
    List<int[][]> seats = new ArrayList<>();
        seats = load(IP1List);
         print(seats);
}
}
