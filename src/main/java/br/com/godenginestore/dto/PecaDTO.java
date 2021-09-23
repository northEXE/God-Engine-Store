package br.com.godenginestore.dto;

import java.util.List;

import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.model.TipoPeca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PecaDTO {
	private String codigoPeca;
	private TipoPeca tipoPeca;
	private String marcaPeca;
	private String modeloPeca;
	private Double precoPeca;
	private String descricaoPeca;
	private List<Modelo> modelosAplicaveis;
	private List<Motor> motoresAplicaveis;
	private Long qtdEstoque;
}
