import java.util.ArrayList;

public class Proces{
	int ramki=0; // liczba przydzielonych ramek
	ArrayList<Integer> arr=new ArrayList<>();
	LRU cpu;

	Proces(int ramki,int n,int zakres){
		this.ramki=ramki;
		generuj(n,zakres);
		cpu=new LRU(arr.size());
	}

	void generuj(int n,int zakres){
		arr.add(0); // program rozpoczyna się od początku było nie było
		for(int i=1;i<n;i++){
			// 90/9/1 lokalne/skoki-lokalne/skoki-globalne
			// tutaj dla wzbogacenia zrobiłem 70/25/5
			int rodzaj=(int)(Math.random()*100);
			if(rodzaj>10)
				arr.add(arr.get(i-1)+(int)(Math.random()*4)-1);
			// lokalne +[-1,2]
			else if(rodzaj>1)
				arr.add((int)(Math.random()*8)-3);
			// skok lokalny +[-3,+5]
			else
				arr.add((int)(Math.random()*zakres));
			// skok globalny
		}
	}

	void wykonaj(){
		if(!arr.isEmpty()){
			cpu.wykonaj(arr.get(0));
			arr.remove(0);
		}
	}
}
