package GerenciamentoEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.Conexao;

public class Estacionamento {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String [] btnMenu = {"Entrada", "Saída", "Faturamento", "Ver vagas"};
		
		try {
        	Conexao connectionMySql = new Conexao();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Criar estacionamento
        String nomeEstacionamento = JOptionPane.showInputDialog(null,
        		"Qual será o nome do estacionamento?",
				"Criar estacionamento", 
				JOptionPane.INFORMATION_MESSAGE
		);
        
        int qntAndares  = Integer.parseInt(JOptionPane.showInputDialog(null,
				 "Quantos andares o " + nomeEstacionamento + " terá?",
				 "Criar estacionamento", 
				 JOptionPane.INFORMATION_MESSAGE)
        );

        while(true) {
        	
            // Menu
	        int opcao = JOptionPane.showOptionDialog(
					null, 
					"Escolha uma das opções abaixo", // Mensagem 
					nomeEstacionamento,
					JOptionPane.YES_OPTION, 
					JOptionPane.QUESTION_MESSAGE,
					null, 
					btnMenu, 
					null
			);
        
	        switch(opcao) {
	        	case -1: System.exit(0);
	        	case 0: //OCUPAR VAGA
		    	        String placa = JOptionPane.showInputDialog(null,
		   					 "Informe a placa do veículo:",
		   					 nomeEstacionamento + " - Entrada de veículo", 
		   					 JOptionPane.INFORMATION_MESSAGE
			   			);
			   	        int tipoVaga  = JOptionPane.showConfirmDialog(null,
			   					"Necessita de uma vaga prioritária?", 
			   					nomeEstacionamento + " - Entrada de veículo",
			   					JOptionPane.YES_NO_CANCEL_OPTION, 
			   					JOptionPane.QUESTION_MESSAGE
			   			);
			   	        break;
	        	case 1: System.out.println("Saída");
	        			break;
	        	case 2: System.out.println("Faturamento");
	        			break;
	        	case 3: System.out.println("Ver vagas");
	        			break;
	        	default: System.out.println("Errrrrouuu");
	        			 break;
	        } // switch
	        
        } // while
         
	} // main

} // Estacionamento
