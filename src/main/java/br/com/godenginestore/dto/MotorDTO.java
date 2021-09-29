package br.com.godenginestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotorDTO {
	private Integer idMotor;
	private String codigoMotor;
	private String nomeMotor;
	private Double cilindrada;
	private String descricaoMotor;
	private Integer fabricante;
	private String nomeFabricante;
}
	