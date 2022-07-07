package program;

import entities.Cliente;
import entities.Produto;
import entities.enuns.ordemDeStatus;
import entities.itemDoPedido;
import entities.ordemDeServico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Insira os dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date dataDeNascimento = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, dataDeNascimento);

        System.out.println("Informe os dados do pedido:");
        System.out.print("Status: ");
        ordemDeStatus status = ordemDeStatus.valueOf(sc.next());

        ordemDeServico ordem = new ordemDeServico(new Date(), status, cliente);

        System.out.print("Quantos itens para este pedido? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Entre com o item #" + i + ":");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preco do produto: ");
            double productPrice = sc.nextDouble();

            Produto product = new Produto(productName, productPrice);

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            itemDoPedido orderItem = new itemDoPedido(quantity, productPrice, product);

            ordem.addProduto(orderItem);
        }
        System.out.println();
        System.out.println("RESUMO DO PEDIDO:");
        System.out.println(ordem);

        sc.close();

    }

}
