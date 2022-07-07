
package entities;

import entities.enuns.ordemDeStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ordemDeServico {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date momento;
    private ordemDeStatus status;
    
    private Cliente cliente;
    private List<itemDoPedido> pedidos = new ArrayList<>();

    public ordemDeServico(Date momento, ordemDeStatus status, Cliente cliente) {
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

    public ordemDeStatus getStatus() {
        return status;
    }

    public void setStatus(ordemDeStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<itemDoPedido> getPedidos() {
        return pedidos;
    }

    public void addProduto(itemDoPedido produto){
        pedidos.add(produto);
    }
    public void removeProduto(itemDoPedido produto){
        pedidos.remove(produto);
    }
    public double total(){
        double soma=0.0;
        for(itemDoPedido pedido: pedidos){
            soma+=pedido.subTotal();
        }
        return soma;
    }
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens:\n");
		for (itemDoPedido item : pedidos) {
			sb.append(item + "\n");
		}
		sb.append("Preco total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

   
    
}
