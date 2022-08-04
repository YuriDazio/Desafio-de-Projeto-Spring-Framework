import facade.facede;
import singleton.SingletonEager;
import singleton.SingletonLazy;
import singleton.SingletonLazyHolder;
import strategy.Comportamento;
import strategy.ComportamentoDefensivo;
import strategy.ComportamentoNormal;
import strategy.ComportamentoOfensivo;
import strategy.Robo;

public class test {

	public static void main(String[] args) {
		
		// Testes reloacionados ao DDesign Pattern Sigleton
		
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyholder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyholder);
		lazyholder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyholder);
	
		// Strategy
		
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento ofensivo = new ComportamentoOfensivo();
		Comportamento normal = new ComportamentoNormal();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		robo.mover();
		robo.mover();
		robo.setComportamento(ofensivo);
		robo.mover();
		robo.mover();
		robo.mover();
		robo.mover();
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.mover();
		robo.mover();
		robo.mover();
		
		//Facede
		
		facede facede = new facede();
		facede.migrarCliente("Yuri Dazio", "02154963");
		
		
	}
}
