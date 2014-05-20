import java.util.ArrayList;

public class LRU{
	// TODO usuń najdłużej nieużywaną
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	// int zegar=0;
	int err=0; // licznik błędów stron

	LRU(int size){ // przekaż ile ramek ma być
		this.size=size;
	}

	// ze względu na to, że ma być to najdłużej nie używana strona zamiast
	// bitu odniesienia będziemy wyrzucać użytą stronę na koniec kolejki ramek
	void wykonaj(int val){ // wykonaj odwołanie, przekaż wartość strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zrób miejsce
				ramki.remove(0); // usuń z pierwszej ramki
			ramki.add(new Strona(val));
		} else{ // !!! jeśli jest, to użyj i przenieś na koniec
			ramki.remove(new Strona(val)); // usuń
			ramki.add(new Strona(val)); // i dodaj na koniec
		}
	}
}