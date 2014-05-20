public class Strona{
	int val=0; // id strony
	int bit=0; // bit odniesienia

	public Strona(int val){
		this.val=val;
	}

	public Strona(int val,int bit){
		this(val);
		this.bit=bit;
	}

	public boolean equals(Object o){
		return o instanceof Strona ? ((Strona)o).val==val : false;
	}

	public String toString(){
		//return ((Integer)val).toString()+" "+((Integer)bit).toString();
		return ((Integer)val).toString();
	}
}
