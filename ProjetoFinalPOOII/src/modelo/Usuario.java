package modelo;

public class Usuario {

	private String usuario;
	private String senha;
	
	public Usuario(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
	public Usuario() {
		super();
		this.usuario = null;
		this.senha = null;
	}

	//-------------------------------------------------
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	//-------------------------------------------------
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	//-------------------------------------------------
	
}
