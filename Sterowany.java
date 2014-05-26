import java.util.ArrayList;

public class Sterowany{
	ArrayList<Proces> procesy=new ArrayList<>();
	ArrayList<Integer> err=new ArrayList<>();
	int ramki=0;

	Sterowany(int ramki,ArrayList<Integer> len,ArrayList<Integer> ran){
		this.ramki=ramki;
		int n=len.size();
		long suma=0;
		for(int i=0;i<n;i++)
			suma+=len.get(i)*ran.get(i);
		// wstępny przydział ramek proporcjonalny
		for(int i=0;i<n;i++){
			procesy.add(new Proces((int)((len.get(i)*ran.get(i))/suma)*ramki,
					len.get(i),ran.get(i)));
			err.add(0); // inicjalizacja listy zapisanych błędów
		}		
	}

	void wykonaj(){
		boolean b=true;
		while(b){
			for(int i=0;i<procesy.size();i++)
				if(!procesy.get(i).arr.isEmpty()){
					// zapisz ilość błędów i wyzeruj licznik
					err.set(i,err.get(i)+procesy.get(i).cpu.err);
					procesy.get(i).cpu.err=0;
					// wykonaj 15
					for(int j=0;j<15;j++)
						procesy.get(i).wykonaj();
				}
			b=przydzielRamki();
		}
		for(int i=0;i<procesy.size();i++)
			procesy.get(i).cpu.err=err.get(i);
	}

	boolean przydzielRamki(){
		int err=0,n=0; // suma, pracujące procesy

		// zbierz średnią
		for(int i=0;i<procesy.size();i++)
			if(!procesy.get(i).arr.isEmpty()){
				err+=procesy.get(i).cpu.err;
				n++;
			}
		if(n>0){
			err=(int)err/n;

			// zbierz ramki
			for(int i=0;i<procesy.size();i++)
				if(procesy.get(i).cpu.err<err)
					ramki+=procesy.get(i).ramki(
							(err-procesy.get(i).cpu.err)/err
									*procesy.get(i).ramki);

			// rozdziel ramki
			for(int i=0;i<procesy.size();i++)
				ramki-=procesy.get(i).ramki(
						(err-procesy.get(i).cpu.err)/err*procesy.get(i).ramki);
		}
		return n>0;
	}
}