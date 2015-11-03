/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigos;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoEMetodos {
	
	//Método para Conectar ao Banco de Dados Local chamado 'cadastro', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bibliotecamusical", "root","");
			return(c);
		} catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null,"Problema na configuração do Driver do MySQL!");
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na conexão com o banco de dados!");
		}
		return(null);
	}
	
	//Retorna o relatorio contendo todas as Pessoa do Banco
        public static ResultSet relatorio(String tipoID, String tabela) throws SQLException {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery("SELECT * FROM pessoa;"));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na consulta na tabela pessoa!");
		}
		return(null);
	}
        
        
        public static ResultSet retornaIDGenero() throws SQLException {
		Connection con = conectar();
		Statement st = null;
		try {
			st = con.createStatement();
			return(st.executeQuery("SELECT id,nome FROM genero;"));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na consulta na tabela pessoa!");
		}
		return(ResultSet) (st);
	}
        
        
	public static ResultSet relatorio(String sql) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery(sql));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na consulta!");
		}
		return(null);
	}
	
	//Método para inserir no banco uma Pessoa passada como par�metro
	public static int inserir(String ins) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(ins));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Problema no cadastro!");
		}
		return(0);
	}
	
	
	//Metodo para remover do banco uma Pessoa pelo 'telefone'
	public static int removerPeloTelefone(String tel) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(tel));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na remoção da pessoa!");
		}
		return(0);
	}
	
	
	//Método para Atualizar os campos no banco uma Pessoa passada como parâmetro, buscando-a pelo nome atual!!!
	public static int atualizar(String n) {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(n));
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Problema na atualização da pessoa!");
		}
		return(0);
	}
	
}
