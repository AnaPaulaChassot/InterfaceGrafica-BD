/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaoBD;
import java.sql.*;
/**
 *
 * @author Suporte
 */
public class conexao {
    
    public static Connection Conector(){
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver"; // conexao direto com site jdbc, site ao contrario 
        String url = "jdbc:mysql://localhost:3306/senac?characterEncoding=utf-8"; //banco de dados
        String user = "admin"; 
        String password = "admin";
        
        try{
            Class.forName(driver); // pega a informação do conector direto no site
            conexao = DriverManager.getConnection(url, user, password); // busca banco, usuario e senha do mysql
            return conexao; //retorna conexão
            
        
        }catch (Exception e){
            
            System.out.println(e); // Armazena erro
            return null; // Se der erro retorna nulo
            
        }
    }

    public static PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
