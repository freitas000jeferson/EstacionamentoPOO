package GerenciamentoEstacionamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import Connection.Conexao;

public class Estacionamento {

	public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Conexao connectionMySql = new Conexao();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

	}

}
