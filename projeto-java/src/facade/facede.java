package facade;

import subsistema1.crm.crmService;
import subsistema2.cep.CepApi;

public class facede {
	public void migrarCliente(String nome, String cep) {
		
		String cidade = CepApi.getInstancia().recuperarCidade(cep);
		String estado = CepApi.getInstancia().recuperarEstado(cep);
		
		crmService.gravarCliente(nome, cep, cidade, estado);
	}
}
