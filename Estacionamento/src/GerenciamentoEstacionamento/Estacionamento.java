package GerenciamentoEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.Conexao;

public class Estacionamento {

	public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Conexao connectionMySql = new Conexao();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        // Criar estacionamento
        String nomeEstacionamento = JOptionPane.showInputDialog(null,
				 "Qual será o nome do estacionamento?",
				 "Criar estacionamento", 
				 JOptionPane.INFORMATION_MESSAGE);
        int qntAndares  = Integer.parseInt(JOptionPane.showInputDialog(null,
				 "Quantos andares "+nomeEstacionamento+" terá?",
				 "Criar estacionamento", 
				 JOptionPane.INFORMATION_MESSAGE));


        //OCUPAR VAGA
        String placa = JOptionPane.showInputDialog(null,
				 "Informe a placa do veï¿½culo:",
				 "Ocupar vaga", 
				 JOptionPane.INFORMATION_MESSAGE);
        int tipoVaga  = JOptionPane.showConfirmDialog(null,
				"Necessita de uma vaga prioritï¿½ria?", 
				"Ocupar vaga",
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE);
        
        
        // 
	}

}
