package DAO;

import Model.Veiculo;
import java.sql.*;
import javax.swing.JOptionPane;
import Connection.Conexao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VeiculoDAO extends ExecuteSQL{
     
     public VeiculoDAO(){}
     
     public Boolean inserir(Veiculo obj){
          try {
               con = new Conexao().abrirConexao();
               String sql = "insert into veiculo values (?,?,?,?)";
               stm = con.prepareStatement(sql);
               stm.setInt(1, obj.getIdVeiculo());
               stm.setString(2, obj.getPlaca());
               stm.setBoolean(3, obj.isPrioridade());
               stm.setInt(4, obj.getTipoVeiculo());
               if (stm.executeUpdate() > 0) {
                    System.out.println("inserido com sucesso.");
                    return true;
               } 
               
          } catch (SQLException errosql) {
               JOptionPane.showMessageDialog(null,
                    "Erro ao inserir dados" + errosql.getMessage());
          } catch (Exception erro) {
        	  System.out.println("Erro ao inserir dados" + erro.getMessage());
          } finally {
               try {
                    stm.close();
                    con.close();
               } catch (SQLException ex) {
            	   System.out.println("Erro ao fechar conexão"+ ex.getMessage());
               }
          } 
          return false;
     }
     public boolean alterar(Veiculo obj) {
        try {
            con = new Conexao().abrirConexao(); 
            String sql = " update veiculo set"
                    + " placa= ?, prioridade = ?, tipo_veiculo_fk = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getPlaca());
            stm.setBoolean(2, obj.isPrioridade());
            stm.setInt(3, obj.getTipoVeiculo());
            
            if (stm.executeUpdate() > 0) {
               System.out.println("alterado com sucesso.");
               return true;
            }
        } catch (SQLException errosql) {
        	System.out.println("Erro ao alterar  dados" + errosql.getMessage());
        } catch (Exception erro) {
        	System.out.println("Erro ao alterar  dados" + erro.getMessage());
        } finally {
               try {
                    stm.close();
                    con.close();
               } catch (SQLException ex) {
            	   System.out.println("Erro ao fechar conexão"+ ex.getMessage());
               }
          } 
          return false;
    }
     
    public boolean excluir(String codigo) {
          try {
               con = new Conexao().abrirConexao();
               String sql = "delete from veiculo where id='"+codigo+"'";
               stm = con.prepareStatement(sql);
               if (stm.executeUpdate() > 0) {
                    return true;
               }
          } catch (SQLException erro) {
        	  System.out.println("Erro ao excluir dados da tabela" + erro.getMessage());
          } catch (Exception ex) {
        	  System.out.println("Erro ao fechar conexão"+ ex.getMessage());
          }finally {
               try {
                    stm.close();
                    con.close();
               } catch (SQLException ex) {
                    Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
               }catch (Exception ex) {
            	   System.out.println("Erro ao fechar conexão"+ ex.getMessage());
               }
          }
          return false;  
     }
     public List<Veiculo> listarVeiculo(String parametro){
          String sql="";
          if(parametro.equals("listar"))
               sql= "select * from veiculo order by placa";
           else
               sql= "select * from veiculo where placa like %"+parametro+"%";
          try {
               con = new Conexao().abrirConexao();
               stm= con.prepareStatement(sql);
               rs= stm.executeQuery();
               List<Veiculo> lista = new ArrayList<>();
               Veiculo obj;
            while(rs.next()){
                obj= new Veiculo();
                obj.setIdVeiculo(rs.getInt("id"));
                obj.setPlaca(rs.getString("placa"));
                obj.setPrioridade(rs.getBoolean("prioridade"));
                obj.setTipoVeiculo(rs.getInt("tipo_veiculo_fk"));
                lista.add(obj);
            }
            return lista;
          } catch (ClassNotFoundException ex) {
               Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
               Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
          } finally{
               try {
                    stm.close();
                    con.close();
               } catch (SQLException ex) {
                    Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
               }catch (Exception ex) {
            	   System.out.println("Erro ao fechar conexão"+ ex.getMessage());
               }
          }     
    
          return null;
    }

}

