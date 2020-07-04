package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.emums.PedidoStatus;

public class Pedido {
	
	public final SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private PedidoStatus status;
	private List<PedidoItem> itens = new ArrayList<>(); //Criando uma lista de itens, pois um pedido pode conter um ou mais itens.
	private Cliente cliente;
	
	public Pedido(Date momento, PedidoStatus status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<PedidoItem> getPedidoItem() {
		return itens;
	}
	
	public void adicionarItem (PedidoItem item) {//Método para adicionar um item na lista.
		itens.add(item); 
	}
	
	public void RemoverItem (PedidoItem item) {//Método para remover um item na lista.
		itens.remove(item);
	}
	
	public double total () {//calculando o total do pedido completo.
		double soma = 0.0;
		for (PedidoItem item : itens) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		//Usando o stringBuilder para uma string muito grande.
		//Isso é para fazer o sumário do pedido.
		StringBuilder sb = new StringBuilder ();
		sb.append("Instante do Pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		for (PedidoItem item : itens ) {// foreach para percorrer todos os itens do pedido.
			sb.append(item + "\n");
		}
		sb.append("Preço Total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
	}

}
