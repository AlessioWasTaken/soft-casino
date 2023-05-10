package backend.Slot;

public class Logica{
	private Immagine [][] Numeri;
	private int Scommessa;

	public void Genera() {
		for(int i=0;i<Numeri.length;i++) {
			for(int j=0;j<Numeri[i].length;j++) {
				Numeri[i][j]=new Immagine();
			}
		}
	}
	
	public int getScommessa() {
		return Scommessa;
	}

	public void setScommessa(int Scommessa) {
		this.Scommessa = Scommessa;
	}

	public Logica() {
		Numeri=new Immagine[6][3];
	}

	public Immagine[][] getNumeri() {
		return Numeri;
	}

	public void setNumeri(Immagine[][] Numeri) {
		this.Numeri = Numeri;
	}
	
	public int Win(){
		int Vincite=0;
		//Riga 1
		if(Numeri[0][0].getNum()==Numeri[0][1].getNum() && Numeri[0][0].getNum()==Numeri[0][2].getNum())
			Vincite=Vincite+1;
		//Riga 2
		if(Numeri[1][0].getNum()==Numeri[1][1].getNum() && Numeri[1][0].getNum()==Numeri[1][2].getNum())
			Vincite=Vincite+1;
		//Riga 3
		if(Numeri[2][0].getNum()==Numeri[2][1].getNum() && Numeri[2][0].getNum()==Numeri[2][2].getNum())
			Vincite=Vincite+1;
		//Colonna 1
		if(Numeri[0][0].getNum()==Numeri[1][0].getNum() && Numeri[0][0].getNum()==Numeri[2][0].getNum())
			Vincite=Vincite+1;
		//Colonna 2
		if(Numeri[0][1].getNum()==Numeri[1][1].getNum() && Numeri[0][1].getNum()==Numeri[2][1].getNum())
			Vincite=Vincite+1;
		//Colonna 3
		if(Numeri[0][2].getNum()==Numeri[1][2].getNum() && Numeri[0][2].getNum()==Numeri[2][2].getNum())
			Vincite=Vincite+1;
		//Diagonale 1
		if(Numeri[0][0].getNum()==Numeri[1][1].getNum() && Numeri[0][0].getNum()==Numeri[2][2].getNum())
			Vincite=Vincite+1;
		//Diagonale 2
		if(Numeri[0][2].getNum()==Numeri[1][1].getNum() && Numeri[0][2].getNum()==Numeri[2][0].getNum())
			Vincite=Vincite+1;
		//Schema a V 1
		if(Numeri[0][0].getNum()==Numeri[1][1].getNum() && Numeri[0][0].getNum()==Numeri[0][2].getNum())
			Vincite=Vincite+1;
		//Schema a V 2
		if(Numeri[2][0].getNum()==Numeri[1][1].getNum() && Numeri[2][0].getNum()==Numeri[2][2].getNum())
			Vincite=Vincite+1;
		for(int i=0;i<3;i++) {
			for(int y=0;y<Numeri[i].length;y++) {
				if(Numeri[i][y].getNum()==69420) {
					Vincite=Vincite+10;
				}
			}
		}
		
		//Ritorna il numero di vincite
		if(Vincite>0) {
			return Vincite * Scommessa;
		}
		return Scommessa * (-1);
	}
}
