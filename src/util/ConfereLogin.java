package util;



import java.io.IOException;
import java.util.Calendar;

import model.Usuario;
import service.UserService;

public class ConfereLogin {
	private String login, senha;
	private UserService us;
	private Usuario user;
	private Log log;
	private String arquivo = "E:\\Praticas de Programacao Integrada\\Lab\\Aula 8 Ex 2\\WebContent\\log\\RegistroDeAcesso.txt";
    

	public ConfereLogin(String login, String senha) {
		setLogin(login);
		setSenha(senha);
		us = new UserService();
		log = new Log();

	}

	public Usuario Confere() {
		if(Busca(getLogin()) == true) {
	    
			if(user.getSenha().equals(senha)) {
				Calendar c = Calendar.getInstance();
				try {
					log.abrir(arquivo);
					log.escrever("\nUsuario: "+getLogin()+" Fez acesso : "+c.getTime()+"\n\n");
					log.fechar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return user;
			}else {
				Calendar c = Calendar.getInstance();
				try {
					log.abrir(arquivo);
					log.escrever("\nUsuario: "+getLogin()+" errou a senha"+getSenha()+"\n Fez acesso : "+c.getTime()+"\n\n");
					log.fechar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}
		return null;
	}

	public boolean Busca(String login){
		user = us.carregarLogin(login);
		if(user != null) {
			return true;
		}else {
			try {
				Calendar c = Calendar.getInstance();
				log.abrir(arquivo);
				log.escrever("\nUsuario: "+login+" Nao encontrado \n Tentou acesso : "+c.getTime()+"\n\n");
				log.fechar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	}
	
	
	
	public String getLogin() {
		return login;
	}

	public String getSenha(){
		return senha;
	}
	
	
	public void setLogin(String login) {
		this.login = login;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

}
