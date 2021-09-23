package br.com.godenginestore.dto;

import java.util.List;

import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {
	private String nomeMarca;
	private  List<Modelo> modelos;
	private List<Motor> motores;
}
