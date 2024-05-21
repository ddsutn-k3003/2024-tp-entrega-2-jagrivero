package ar.edu.utn.dds.k3003.controller;

public class Formula {
		String pesosDonados;
		String viandasDistribuidas;
		String viandasDonadas;
	    String tarjetasRepartidas;
	    String heladerasActivas;
		public Formula() {}
		public void setPesosDonados(String pesosDonados) {
			this.pesosDonados =pesosDonados;
		}
		public void setViandasDistribuidas(String viandasDistribuidas) {
			this.viandasDistribuidas =viandasDistribuidas;
		}
		public void setViandasDonadas(String viandasDonadas) {
			this.viandasDonadas =viandasDonadas;
		}
		public void setTarjetasRepartidas(String tarjetasRepartidas) {
			this.tarjetasRepartidas =tarjetasRepartidas;
		}
		public void setHeladerasActivas(String heladerasActivas) {
			this.heladerasActivas =heladerasActivas;
		}
		public Formula(String pesosDonados, String viandasDistribuidas, String viandasDonadas,
                String tarjetasRepartidas, String heladerasActivas) {
			this.pesosDonados = pesosDonados;
     		this.viandasDistribuidas = viandasDistribuidas;
     		this.viandasDonadas = viandasDonadas;
     		this.tarjetasRepartidas = tarjetasRepartidas;
     		this.heladerasActivas = heladerasActivas;
		}
}
