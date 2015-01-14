import java.util.*;

public class Quicksort {
private static Scanner s;
public static void input(int[] z,int num){
	System.out.println("Enter "+num+" elements one at a time:");
	for(int i=0;i<num;i++){
		z[i] = s.nextInt();
		}
	
}
static void swap(int[] a,int n1,int n2)
{
	a[n1]= a[n1]+a[n2];
	a[n2]= a[n1]-a[n2];
	a[n1]=a[n1]-a[n2];
}
static int partition(int[] z,int start, int end)
{
	int pivot = z[start];
	int p = start;
	int temp;
	for(int i=start+1;i<=end;i++)
	{
		if(z[i]<=pivot)
		{
			p++;
			temp=z[i];
			z[i]=z[p];
			z[p]=temp;
		}
	}
	temp=z[start];
	z[start]=z[p];
	z[p]=temp;
	return p;
}
static void quicksort(int[] z,int start,int end){
	if(start<end)
	{
		int pivot = partition(z,start,end);
		quicksort(z,start,pivot-1);
		quicksort(z,pivot+1,end);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("How many Numbers you want to enter");
		String a;
		s = new Scanner(System.in);
		int n;
		while(true)
		{
		try{
		a = s.nextLine();
		n = Integer.parseInt(a);
		break;
		}
		catch(NumberFormatException ex){
			System.out.println("Enter Valid Number");
		}
		}
		int[] arr;
		arr = new int[n];
		input(arr,n);
		quicksort(arr,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
	}
		}
