package modelo;

public class Formulario {
	
	private String solicitante;
	private String telefone;
	private String email;
	private int numeroAlunos;
	private String atividade;
	private String modalidade;
	private String curso;
	private String equipamentos;
	private String [] data = new String[6];
	private int [] horaInicial = new int[6];
	private int [] horaFinal = new int[6];
	
	
	public Formulario(String solicitante, String telefone, String email, int numeroAlunos, String atividade,
			String modalidade, String curso, String equipamentos, String[] data, int[] horaInicial, int[] horaFinal) {
		super();
		this.solicitante = solicitante;
		this.telefone = telefone;
		this.email = email;
		this.numeroAlunos = numeroAlunos;
		this.atividade = atividade;
		this.modalidade = modalidade;
		this.curso = curso;
		this.equipamentos = equipamentos;
		this.data = data;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}
	
	@SuppressWarnings("null")
	public Formulario() {
		super();
		this.solicitante = null;
		this.telefone = null;
		this.email = null;
		this.numeroAlunos = (Integer) null;
		this.atividade = null;
		this.modalidade = null;
		this.curso = null;
		this.equipamentos = null;
		this.data = null;
		this.horaInicial = null;
		this.horaFinal = null;
	}
	
	//-------------------------------------------------
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	//-------------------------------------------------
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	//-------------------------------------------------
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//-------------------------------------------------
	public int getNumeroAlunos() {
		return numeroAlunos;
	}
	public void setNumeroAlunos(int numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}
	//-------------------------------------------------
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	//-------------------------------------------------
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	//-------------------------------------------------
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	//-------------------------------------------------
	public String getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}
	//-------------------------------------------------
	public String[] getData() {
		return data;
	}
	public String getData(int index) {
		return data[index];
	}
		
	public void setData(String[] data) {
		this.data = data;
	}
	public void setData(int index, String data) {
		this.data[index] = data;
	}
	//-------------------------------------------------
	public int[] getHoraInicial() {
		return horaInicial;
	}
	public int getHoraInicial(int index) {
		return horaInicial[index];
	}
		
	public void setHoraInicial(int[] horaInicial) {
		this.horaInicial = horaInicial;
	}
	public void setHoraInicial(int index, int horaInicial) {
		this.horaInicial[index] = horaInicial;
	}
	//-------------------------------------------------	
	public int[] getHoraFinal() {
		return horaFinal;
	}
	public int getHoraFinal(int index) {
		return horaFinal[index];
	}
	
	public void setHoraFinal(int[] horaFinal) {
		this.horaFinal = horaFinal;
	}
	public void setHoraFinal(int index, int horaFinal) {
		this.horaFinal[index] = horaFinal;
	}
	//-------------------------------------------------

}
