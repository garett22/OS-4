import java.util.ArrayList;

public class Proporcjonalny{
	ArrayList<Proces> procesy=new ArrayList<>();

	Proporcjonalny(int ramki,int n,int minLen,int maxLen,int minRan,int maxRan){
		int[][] t=new int[2][n];
		int suma=0;
		for(int i=0;i<n;i++){
			t[0][i]=(int)(Math.random()*(maxLen-minLen)+minLen);
			t[1][i]=(int)(Math.random()*(maxRan-minRan)+minRan);
			suma+=(t[0][i]*t[1][i])/100;
		}
		for(int i=0;i<n;i++)
			procesy.add(new Proces((int)((t[0][i]*t[1][i])/100/suma)*ramki,
					t[0][i],t[1][i]));
	}

	void wykonaj(){
		for(int i=0;i<procesy.size();i++)
			while(!procesy.get(i).arr.isEmpty())
				procesy.get(i).wykonaj();
	}
}