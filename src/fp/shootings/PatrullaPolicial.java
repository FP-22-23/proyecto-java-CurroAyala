package fp.shootings;

public record PatrullaPolicial(TipoPolicia tipoPolicia, Integer numAgentes) {
	
	public String getDifAgentes(PatrullaPolicial p) {
		int difAgentes = this.numAgentes - p.numAgentes;
		String res = "Había el mismo número de agentes.";
		if (difAgentes > 0) {
			res =  "Había " + difAgentes + " agente(s) más en el primer caso.";
		}
		else if (difAgentes < 0) {
			res ="Había " + Math.abs(difAgentes) + " agente(s) más en el segundo caso.";
		}
		return res;
	}

}
