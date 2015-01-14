import java.util.Scanner;
public class LCS {
	public static String lcs(String s1,String s2,int n1,int n2)
	{
		String s3;
		s3 = new String();
		int[][] c;
		char[][] d;
		int i,j;
		c = new int[n1+1][n2+1];
		d = new char[n1+1][n2+2];
		for(i=0;i<=n1;i++)
			for(j=0;j<=n2;j++)
			{
				c[i][j]=0;
				d[i][j]='-';
			}
		
		for(i=1;i<=n1;i++)
			for(j=1;j<=n2;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					{
					c[i][j] = c[i-1][j-1]+1;
					d[i][j] = '\\';
					}
				else
				{
					if(c[i][j-1]>c[i-1][j])
					{
						c[i][j] = c[i][j-1];
						d[i][j] = '-';
					}
					else
					{
						c[i][j] = c[i-1][j];
						d[i][j] = '|';	
					}
				}
			}
/*		for(i=0;i<=n1;i++)
		{
			for(j=0;j<=n2;j++)
			System.out.print(c[i][j]+" ");
			System.out.print("\n");
		}
		for(i=0;i<=n1;i++)
		{
			for(j=0;j<=n2;j++)
			System.out.print(d[i][j]+" ");
			System.out.print("\n");
		}
*/		i=n1;
		j=n2;
		while(true)
		{
			if(c[i][j]==0)
				break;
			switch(d[i][j]){
			case '-':j--;
			break;
			case '\\':i--;j--;
			s3 =  s1.charAt(i) + s3;
			break;
			case '|':i--;
			}
			}
		
		return s3;
	}

	public static void main(String[] args) {
		Scanner a;
		a = new Scanner(System.in);
		String s1,s2,s3;
		System.out.println("Enter two strings to find their longest common subsequence");
		s1 = a.nextLine();
		s2 = a.nextLine();
		s3 = lcs(s1,s2,s1.length(),s2.length());
		if(s3.length()==0)
			System.out.println("No Subsequence exist");
		else
			System.out.print("The Longest common Subsequence:"+s3);
		
	}

}
