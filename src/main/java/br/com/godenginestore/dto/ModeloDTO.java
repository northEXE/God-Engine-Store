package br.com.godenginestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {
	private Integer idModelo;
	private Integer marca;
	private String nomeMarca;
	private String nomeModelo;
	private String anosEmFabricacao;
	private String descricaoModelo;
	private Integer motor;
	private String nomeMotor;
}
