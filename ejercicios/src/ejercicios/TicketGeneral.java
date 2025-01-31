package ejercicios;

import java.util.Objects;

public class TicketGeneral extends Ticket {
	
	private double descuento;
	private double precioTotal;
	
	public TicketGeneral(int kilometroEntrada, double precioKilometro, int kilometroSalida) {
		super(kilometroEntrada, precioKilometro, kilometroSalida);
		
		this.descuento=calcularDescuento();
		this.precioTotal=calcularPrecio();
	}

	private double calcularDescuento() {
		
		int kilometrosRecorridos=kilometrosRecorridos();
		if(kilometrosRecorridos>500) {
		return (double) kilometrosRecorridos/500*0.1;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public double calcularPrecio() {
		int kilometrosRecorridos=kilometrosRecorridos();
		
		return (kilometrosRecorridos*precioKilometro)-(kilometrosRecorridos*precioKilometro)*this.descuento;
	}

	@Override
	public String toString() {
		return "TicketGeneral [descuento=" + descuento + ", precioTotal=" + precioTotal + ", kilometroEntrada="
				+ kilometroEntrada + ", precioKilometro=" + precioKilometro + ", kilometroSalida=" + kilometroSalida
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descuento, precioTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketGeneral other = (TicketGeneral) obj;
		return Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento)
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal);
	}
	
}
