package ejercicios;

import java.util.Objects;

public class TicketEspecial extends Ticket {
	
	private double descuento;
	private double precioTotal;
	
	public TicketEspecial(int kilometroEntrada, double precioKilometro, int kilometroSalida) {
		super(kilometroEntrada, precioKilometro, kilometroSalida);
		
		this.descuento=0.05;
		this.precioTotal=calcularPrecio();
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
		TicketEspecial other = (TicketEspecial) obj;
		return Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento)
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal);
	}
	
}
