package br.com.godenginestore.exception;

public class RegraNegocioException extends RuntimeException {

	
	private static final long serialVersionUID = 727L;

	public RegraNegocioException(String mensagem) {
		super(mensagem);
	}
}
