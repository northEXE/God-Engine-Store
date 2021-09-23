package br.com.godenginestore.dto;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Motor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {
	private Marca marca;
	private String nomeModelo;
	private String anosEmFabricacao;
	private String descricaoModelo;
	private Motor motor;
}
