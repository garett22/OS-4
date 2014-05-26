import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	static int err(ArrayList<Proces> arr){
		int s=0;
		for(Proces p:arr)
			s+=p.cpu.err;
		return s;
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Podaj liczbę ramek");
		int ramki=sc.nextInt();
		System.out.println("Podaj liczbę procesów");
		int procesy=sc.nextInt();
		System.out.println("Podaj długość min i max");
		int minLen=sc.nextInt();
		int maxLen=sc.nextInt();
		System.out.println("Podaj zakres min i max");
		int minRan=sc.nextInt();
		int maxRan=sc.nextInt();
		sc.close();

		ArrayList<Integer> len=new ArrayList<>(); // długości
		ArrayList<Integer> ran=new ArrayList<>(); // zakresy
		for(int i=0;i<procesy;i++){
			// generowanie właściwości procesów
			len.add((int)(Math.random()*(maxLen-minLen)+minLen));
			ran.add((int)(Math.random()*(maxRan-minRan)+minRan));
		}

		Equal e=new Equal(ramki,len,ran);
		Proporcjonalny p=new Proporcjonalny(ramki,len,ran);
		Sterowany s=new Sterowany(ramki,len,ran);
		// Strefowy ss=new Strefowy(ramki,procesy,minLen,maxLen,minRan,maxRan);

		e.wykonaj();
		p.wykonaj();
		s.wykonaj();
		// ss.wykonaj();

		System.out.println("\n\nBłędy strony:");
		System.out.println("Równy: "+err(e.procesy));
		System.out.println("Proporcjonalny: "+err(p.procesy));
		System.out.println("Sterowany: "+err(s.procesy));
		// System.out.println("Strefowy: "+err(ss.procesy));
	}
}
