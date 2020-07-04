package aplicacao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Pedido;
import entidades.PedidoItem;
import entidades.Produto;
import entidades.emums.PedidoStatus;

/*Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
sumário do pedido.
Nota: o instante do pedido deve ser o instante do sistema: new Date()
 */

public class programa {

	public static void main(String[] args) throws ParseException {

		
		Scanner ent = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os Dados do Cliente: ");
		System.out.print("Nome: ");
		String nome = ent.nextLine();
		System.out.print("E-mail: ");
		String email = ent.nextLine();
		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		Date dataNascimento = sdf.parse(ent.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Informe os Dados do Pedido: ");
		System.out.print("Status: ");
		PedidoStatus status = PedidoStatus.valueOf(ent.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens para esse pedido? ");
		int n = ent.nextInt();
		for (int i = 1; i <= n; i++) {//laço for para controlar quantos itens serão informados para compor o pedido.
			
			System.out.println("Informe #" + i + " Dado do item:");
			System.out.print("Nome do produto: ");
			ent.nextLine();
			String nomeProduto = ent.nextLine();
			System.out.print("Preço do produto: ");
			double PrecoProduto = ent.nextDouble();

			Produto produto = new Produto(nomeProduto, PrecoProduto);

			System.out.print("Quantidade: ");
			int quantidade = ent.nextInt();

			PedidoItem pedidoItem = new PedidoItem(quantidade, PrecoProduto, produto); 

			pedido.adicionarItem(pedidoItem);//Acessando esse método para adicionar o item ao pedido.
		}
		
		System.out.println();
		System.out.println("SUMÁRIO DO PEDIDO: ");
		System.out.println(pedido); //Imprimindo o sumário do pedido.
	
		ent.close();
	}

}
