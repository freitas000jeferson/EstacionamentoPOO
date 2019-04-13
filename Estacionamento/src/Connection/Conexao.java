package Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
	public Conexao() throws ClassNotFoundException, SQLException {}

    public Connection abrirConexao(){
        Connection connection = null;
         
        try {
              String dir = new File("src/passwordMySql.txt").getCanonicalPath();
              FileReader file = new FileReader(dir);
              BufferedReader readFile = new BufferedReader(file);
              final String database = "jdbc:mysql://localhost/Estacionamento";
              final String name = "root";
              String password=readFile.readLine();

              Class.forName("com.mysql.jdbc.Driver");
              connection = DriverManager.getConnection(database, name, password);

              if(connection==null){
                   JOptionPane.showMessageDialog(null,"Conexão falhou");
              } else { 
                   JOptionPane.showMessageDialog(null,"Conexão ok");
              }
              readFile.close();
              return connection;
        } catch (SQLException errosql) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir dados" + errosql.getMessage());
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "erro na Conexão com o Banco","Estacionamento", JOptionPane.ERROR_MESSAGE);
             e.getMessage();
        }
        
        return null;
    }
    
    public void fecharConexao(Connection connection){
         try {
              connection.close();
         } catch (Exception e) {
              System.out.println(e.getMessage());
         }
    }
}
