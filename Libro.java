public class Libro{
	
	private String Titulo;
	private String Autor;
	private int Año;
	
	public Libro(String T,String A,int Añ) {
		// TODO Auto-generated constructor stub
		Titulo = T;
		Autor = A;
		Año = Añ;
	}
	
	public String getAutor() {
		return Autor;
	}
	public String getTitulo() {
		return Titulo;
	}
	public int getAño() {
		return Año;
	}
	
	public void setAutor(String autor) {
		Autor = autor;
	}
	public void setAño(int año) {
		Año = año;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Titulo: "+ getTitulo()+"\n Autor: "+getAutor()+"\n Publicacion: "+ getAño();
	}
	
}
