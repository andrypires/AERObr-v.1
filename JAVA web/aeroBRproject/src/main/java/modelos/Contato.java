package modelos;

public class Contato {

	int id;
	String contat, coment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContat() {
		return contat;
	}

	public void setContat(String contat) {
		this.contat = contat;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", contat=" + contat + ", coment=" + coment + "]";
	}
	
}
