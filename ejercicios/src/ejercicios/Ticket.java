package ejercicios;

import java.util.Objects;

public  abstract class Ticket implements Iticket {

	protected int kilometroEntrada;
	protected double precioKilometro;
	protected int kilometroSalida;
	
	protected Ticket(int kilometroEntrada, double precioKilometro, int kilometroSalida) {
		super();
		this.kilometroEntrada = kilometroEntrada;
		this.precioKilometro = precioKilometro;
		this.kilometroSalida = kilometroSalida;
	}
	
    public int kilometrosRecorridos() {
        return kilometroSalida - kilometroEntrada;
    }


	@Override
	public String toString() {
		return "Ticket [kilometroEntrada=" + kilometroEntrada + ", precioKilometro=" + precioKilometro
				+ ", kilometroSalida=" + kilometroSalida + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(kilometroEntrada, kilometroSalida, precioKilometro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return kilometroEntrada == other.kilometroEntrada && kilometroSalida == other.kilometroSalida
				&& Double.doubleToLongBits(precioKilometro) == Double.doubleToLongBits(other.precioKilometro);
	}
	
}
