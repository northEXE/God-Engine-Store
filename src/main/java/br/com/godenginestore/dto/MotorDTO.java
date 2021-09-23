package br.com.godenginestore.dto;

import br.com.godenginestore.model.Marca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotorDTO {
	private String codigoMotor;
	private String nomeMotor;
	private Marca fabricante;
	private Double cilindrada;
	private String descricaoMotor;
}
