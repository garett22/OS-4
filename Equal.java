import java.util.ArrayList;

public class Equal{
	ArrayList<Proces> procesy=new ArrayList<>();

	Equal(int ramki,int n,int minLen,int maxLen,int minRan,int maxRan){
		for(int i=0;i<n;i++)
			procesy.add(new Proces((ramki/n),(int)(Math.random()
					*(maxLen-minLen)+minLen),(int)(Math.random()
					*(maxRan-minRan)+minRan)));
	}

	void wykonaj(){
		for(int i=0;i<procesy.size();i++)
			procesy.get(i).wykonaj();
	}
}