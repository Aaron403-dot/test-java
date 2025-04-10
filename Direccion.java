
public class Direccion {
	private String Calle;
	
	private String Ciudad;
	
	private int CPostal;
	
	public Direccion(String Ca,String Ci, int CPo) {
		// TODO Auto-generated constructor stub
		Calle = Ca;
		Ciudad = Ci;
		CPostal = CPo;
	}
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCalle() {
		return Calle;
	}
	
	public String getCiudad() {
		return Ciudad;
	}
	public int getCPostal() {
		return CPostal;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public void setCPostal(int cPostal) {
		CPostal = cPostal;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n Calle: " + getCalle() + "\n Ciudad: " + getCiudad() + "\n Codigo Postal: " + getCPostal();
	}
	
}
