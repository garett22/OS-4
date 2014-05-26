import java.util.ArrayList;

public class Proporcjonalny{
	ArrayList<Proces> procesy=new ArrayList<>();

	Proporcjonalny(int ramki,ArrayList<Integer> len,ArrayList<Integer> ran){
		int n=len.size();
		long suma=0;
		for(int i=0;i<n;i++)
			suma+=len.get(i)*ran.get(i);
		for(int i=0;i<n;i++)
			procesy.add(new Proces((int)((len.get(i)*ran.get(i))/suma)*ramki,
					len.get(i),ran.get(i)));
	}

	void wykonaj(){
		for(int i=0;i<procesy.size();i++)
			while(!procesy.get(i).arr.isEmpty())
				procesy.get(i).wykonaj();
	}
}