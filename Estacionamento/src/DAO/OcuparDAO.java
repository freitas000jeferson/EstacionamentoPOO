package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.Conexao;
import Model.Ocupar;

public class OcuparDAO extends ExecuteSQL {
	public OcuparDAO(){}
    
    public Boolean OcuparVaga(Ocupar obj){
    	try {
    		con = new Conexao().abrirConexao();
    		String sql = "insert into ocupar ( id, data_hora_inicio, vaga_fk, veiculo_fk)"
    				+ " values (?,?,?,?)";
    		stm = con.prepareStatement(sql);
    		stm.setInt(1, obj.getIdOcupar());
    		stm.setDate(2, (Date) obj.getDataIni());
    		stm.setInt(3, obj.getIdVaga());
    		stm.setInt(4, obj.getIdVeiculo());
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
    public boolean DesocuparVaga(Ocupar obj) {
    	try {
    		con = new Conexao().abrirConexao(); 
    		String sql = " update Ocupar set data_hora_fim = ? ,preco_total= ? where id = '"+obj.getIdOcupar()+"'";
	        stm = con.prepareStatement(sql);
    		stm.setDate(1, (Date) obj.getDataFim());
    		stm.setFloat(2, obj.getPrecoTotal());
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
    		String sql = "delete from Ocupar where id='"+codigo+"'";
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
    			Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}
    	return false;  
    }
    
    public List<Ocupar> getAll(){
    	String sql="select * from Ocupar order by numero_Ocupar";
    	try {
    		con = new Conexao().abrirConexao();
    		stm= con.prepareStatement(sql);
    		rs= stm.executeQuery();
    		List<Ocupar> lista = new ArrayList<>();
    		Ocupar obj;
    		while(rs.next()){
    			obj= new Ocupar();
    			obj.setIdOcupar(rs.getInt("id"));
    			obj.setDataIni(rs.getDate("data_hora_inicio"));
    			obj.setDataFim(rs.getDate("data_hora_fim"));
    			obj.setIdVaga(rs.getInt("vaga_fk"));
    			obj.setIdVeiculo(rs.getInt("veiculo_fk"));
    			obj.setPrecoTotal(rs.getInt("preco_total"));
    			lista.add(obj);
    		}
    		return lista;
    	} catch (ClassNotFoundException ex) {
    		Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} catch (SQLException ex) {
    		Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} finally{
    		try {
    			stm.close();
    			con.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}     
    	return null;
	}
    
    public Ocupar getOne(int codigo){
    	String sql="select * from Ocupar where id ='"+codigo+"'";
    	try {
    		con = new Conexao().abrirConexao();
    		stm= con.prepareStatement(sql);
    		rs= stm.executeQuery();
    		Ocupar obj= new Ocupar();
    		obj.setIdOcupar(rs.getInt("id"));
    		obj.setDataIni(rs.getDate("data_hora_inicio"));
    		obj.setDataFim(rs.getDate("data_hora_fim"));
    		obj.setIdVaga(rs.getInt("vaga_fk"));
    		obj.setIdVeiculo(rs.getInt("veiculo_fk"));
    		obj.setPrecoTotal(rs.getFloat("preco_total"));
    		return obj;
    	} catch (ClassNotFoundException ex) {
    		Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} catch (SQLException ex) {
    		Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    	} finally{
    		try {
    			stm.close();
    			con.close();
    		} catch (SQLException ex) {
    			Logger.getLogger(OcuparDAO.class.getName()).log(Level.SEVERE, null, ex);
    		}catch (Exception ex) {
    			System.out.println("Erro ao fechar conexão"+ ex.getMessage());
    		}
    	}     
    	return null;
	}
	
}
