package application;

public class ChampSaisi {

	private int textbill;
	private int textnbPeople;
	private int textTip;
	
	public ChampSaisi(int bill,int nbPeople, int tip) {
		super();
		this.textbill = bill;
		this.textnbPeople = nbPeople;
		this.textTip = tip;
		// TODO Auto-generated constructor stub
	}

	public int getTextbill() {
		return textbill;
	}

	public void setTextbill(int textbill) {
		this.textbill = textbill;
	}

	public int getTextnbPeople() {
		return textnbPeople;
	}

	public void setTextnbPeople(int textnbPeople) {
		this.textnbPeople = textnbPeople;
	}

	public int getTextTip() {
		return textTip;
	}

	public void setTextTip(int textTip) {
		this.textTip = textTip;
	}

	public String calcultotal() {
		return Integer.toString(this.textbill/this.textnbPeople);
	}
	
	public String calcultip() {
		return Integer.toString(Integer.parseInt(this.calcultotal())/this.textTip);
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.getTextbill()) + ";" + Integer.toString(this.getTextTip()) + ";" + Integer.toString(this.getTextnbPeople()) + "\n";
	}

}
