package br.com.godenginestore.dto;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarroDTO {
	private Marca marcaCarro;
	private Modelo modeloCarro;
	private Integer anoCarro;
	private Motor motorizacao;
	private String descricao;
}
