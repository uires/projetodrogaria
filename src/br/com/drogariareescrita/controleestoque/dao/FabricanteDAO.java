package br.com.drogariareescrita.controleestoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.drogariareescrita.controleestoque.domains.Fabricante;
import br.com.drogariareescrita.controleestoque.factory.ConnectionFactory;
import br.com.drogariareescrita.controleestoque.util.UtilTratamentoDados;

public class FabricanteDAO {

	public void inserirFabricante(Fabricante fabricante) throws SQLException {
		String sql = "INSERT INTO fabricante (nome_fabricante, cnpj, descricao, telefone) VALUES (?, ?, ?, ?)";
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		sentenca.setString(1, fabricante.getNomeFabricante());
		if (UtilTratamentoDados.isCNPJ(fabricante.getCnpj())) {
			sentenca.setString(2, fabricante.getCnpj());
		} else {
			sentenca.setString(2, " ");
		}
		sentenca.setString(3, fabricante.getDescricao());
		sentenca.setString(3, fabricante.getTelefone());
		sentenca.execute();
	}

	public void excluirFabricante(Fabricante fabricante) throws SQLException {
		String sql = "DELETE FROM fabricante WHERE id = ?";
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		sentenca.setLong(1, fabricante.getId());
		sentenca.execute();
	}

	public void editarFabricante(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET nome_fabricante = ?, cnpj = ?, descricao = ? ");
		sql.append("WHERE id = ?");
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql.toString());
		sentenca.setString(1, fabricante.getNomeFabricante());
		sentenca.setString(2, fabricante.getCnpj());
		sentenca.setString(3, fabricante.getDescricao());
		sentenca.setLong(4, fabricante.getId());
		sentenca.execute();
	}

	public ArrayList<Fabricante> selectFabricanteAll() throws SQLException {
		String sql = "SELECT * FROM fabricante";
		ArrayList<Fabricante> listaResultado = new ArrayList<>();
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		ResultSet resultado = sentenca.executeQuery();
		
		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCnpj(resultado.getString("cnpj"));
			f.setDescricao(resultado.getString("descricao"));
			f.setId(resultado.getLong("id"));
			f.setNomeFabricante(resultado.getString("nome_fabricante"));
			f.setTelefone(resultado.getString("telefone"));
			listaResultado.add(f);
		}
		return listaResultado;
	}
	
	public Fabricante selectFabricante(Fabricante fabricante) throws SQLException {
		Fabricante f = null;
		String sql = "SELECT * FROM fabricante WHERE id = ?";
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		sentenca.setLong(1, fabricante.getId());
		ResultSet resultado = sentenca.executeQuery();
		if(resultado.next()) {
			f = new Fabricante();
			f.setCnpj(resultado.getString("cnpj"));
			f.setNomeFabricante(resultado.getString("nome_fabricante"));
			f.setId(resultado.getLong("id"));
			f.setDescricao(resultado.getString("descricao"));
			f.setTelefone(resultado.getString("telefone"));
		}
		return f;
	}
}
