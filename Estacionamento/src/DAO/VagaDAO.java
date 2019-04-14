package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Connection.Conexao;
import Model.Vaga;

public class VagaDAO extends ExecuteSQL {
	public VagaDAO(){}
     
    public Boolean inserir(Vaga obj){
    	try {
    		con = new Conexao().abrirConexao();
    		String sql = "insert into vaga values (?,?,?,?)";
    		stm = con.prepareStatement(sql);
    		stm.setInt(1, obj.getIdVaga());
    		stm.setInt(2, obj.getNumeroVaga());
    		stm.setBoolean(3, obj.isPrioridade());
    		stm.setInt(4, obj.getAndar());
    		stm.setBoolean(5, obj.isLiberado());
    		if (stm.executeUpdate() > 0) {
    			System.out.println("inserido com sucesso.");
    			return true;
    		} 
    	} catch (SQLException errosql) {
    		System.out.println("Erro ao inserir dados" + errosql.getMessage());
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
    public boolean alterar(Vaga obj) {
    	try {
    		con = new Conexao().abrirConexao(); 
    		String sql = " update vaga set"
    				+ " numero_vaga= ?, prioridade = ?, andar = ?,"
    				+ "liberado = ?";
	        stm = con.prepareStatement(sql);
	        stm.setInt(1, obj.getNumeroVaga());
	        stm.setBoolean(2, obj.isPrioridade());
	        stm.setInt(3, obj.getAndar());
	        stm.setBoolean(4, obj.isLiberado());
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
    		String sql = "delete from vaga where id='"+codigo+"'";
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
    			Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}
    	return false;  
    }
    public List<Vaga> listarVagas(){
    	String sql="select * from vaga order by numero_vaga";
    	try {
    		con = new Conexao().abrirConexao();
    		stm= con.prepareStatement(sql);
    		rs= stm.executeQuery();
    		List<Vaga> lista = new ArrayList<>();
    		Vaga obj;
    		while(rs.next()){
    			obj= new Vaga();
    			obj.setIdVaga(rs.getInt("id"));
    			obj.setNumeroVaga(rs.getInt("numero_vaga"));
    			obj.setPrioridade(rs.getBoolean("prioridade"));
    			obj.setAndar(rs.getInt("andar"));
    			obj.setLiberado(rs.getBoolean("liberado"));
    			lista.add(obj);
    		}
    		return lista;
    	} catch (ClassNotFoundException ex) {
    		Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} catch (SQLException ex) {
    		Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} finally{
    		try {
    			stm.close();
    			con.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}     
    	return null;
	}
    public List<Vaga> listarVagasDesocupadas(String parametro){
    	String sql;
    	if(parametro.equals("listar"))
    		sql="select *  from vaga order by numero_vaga where liberado = true";
    	else {
    		int andar= Integer.parseInt(parametro);
    		sql="select * from vaga order by numero_vaga where liberado = true and andar ="+andar;
    	}
    	try {
    		con = new Conexao().abrirConexao();
    		stm= con.prepareStatement(sql);
    		rs= stm.executeQuery();
    		List<Vaga> lista = new ArrayList<>();
    		Vaga obj;
    		while(rs.next()){
    			obj= new Vaga();
    			obj.setIdVaga(rs.getInt("id"));
    			obj.setNumeroVaga(rs.getInt("numero_vaga"));
    			obj.setPrioridade(rs.getBoolean("prioridade"));
    			obj.setAndar(rs.getInt("andar"));
    			obj.setLiberado(rs.getBoolean("liberado"));
    			lista.add(obj);
    		}
    		return lista;
    	} catch (ClassNotFoundException ex) {
    		Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} catch (SQLException ex) {
    		Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} finally{
    		try {
    			stm.close();
    			con.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}     
    	return null;
	}
}
