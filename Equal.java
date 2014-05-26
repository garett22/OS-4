import java.util.ArrayList;

public class Equal{
	ArrayList<Proces> procesy=new ArrayList<>();

	Equal(int ramki,ArrayList<Integer> len,ArrayList<Integer> ran){
		int n=len.size();
		for(int i=0;i<n;i++)
			procesy.add(new Proces((ramki/n),len.get(i),ran.get(i)));
	}

	void wykonaj(){
		for(int i=0;i<procesy.size();i++)
			while(!procesy.get(i).arr.isEmpty())
				procesy.get(i).wykonaj();
	}
}