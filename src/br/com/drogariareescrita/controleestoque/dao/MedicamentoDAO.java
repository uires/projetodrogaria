package br.com.drogariareescrita.controleestoque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogariareescrita.controleestoque.domains.Fabricante;
import br.com.drogariareescrita.controleestoque.domains.Medicamento;
import br.com.drogariareescrita.controleestoque.factory.ConnectionFactory;

public class MedicamentoDAO {
	public void inserirMedicamento(Medicamento medicamento) throws SQLException {
		String sql = "INSERT INTO medicamento SET nome = ?,"
				+ " quantidade = ?, preco = ?, substancias = ?, descricao_de_usuabilidade = ?, peso_liquido = ?, "
				+ "id_fornecedor = ?, data_entrada_ultimo_estoque = ?";
		Connection conexaoBancoDeDados = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentencaQuery = conexaoBancoDeDados.prepareStatement(sql.toString());
		sentencaQuery.setString(1, medicamento.getNome());
		sentencaQuery.setInt(2, medicamento.getQuantidade());
		sentencaQuery.setDouble(3, medicamento.getPreco());
		sentencaQuery.setString(4, medicamento.getSubstrancias());
		sentencaQuery.setString(5, medicamento.getDescricaoDeUsuabilidade());
		sentencaQuery.setDouble(6, medicamento.getPesoLiquido());
		sentencaQuery.setLong(7, medicamento.getFabricante().getId());
		sentencaQuery.setDate(8, new java.sql.Date(medicamento.getDataEntradaUltimoEstoque().getTime()));
		sentencaQuery.execute();
	}

	public void excluirMedicamento(Medicamento medicamento) throws SQLException {
		String sql = "DELETE FROM medicamento WHERE id = ?";
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		sentenca.setLong(1, medicamento.getId());
		sentenca.execute();
	}

	public Medicamento selectMedicmento(Medicamento medicamentoRecebido) throws SQLException {
		Medicamento medicamento = null;
		String sql = "SELECT * FROM medicamento WHERE id = ?";
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sql);
		sentenca.setLong(1, medicamentoRecebido.getId());
		ResultSet resultadoQuerySelect = sentenca.executeQuery();
		if (resultadoQuerySelect.next()) {
			medicamento = new Medicamento();
			medicamento.setNome(resultadoQuerySelect.getString("nome"));
			medicamento.setQuantidade(resultadoQuerySelect.getInt("quantidade"));
			medicamento.setSubstrancias(resultadoQuerySelect.getString("substancias"));
			medicamento.setPreco(resultadoQuerySelect.getDouble("preco"));
			medicamento.setDescricaoDeUsuabilidade(resultadoQuerySelect.getString("descricao_de_usuabilidade"));
			medicamento.setPesoLiquido(resultadoQuerySelect.getDouble("peso_liquido"));
			medicamento.setFabricante(new Fabricante());
			medicamento.getFabricante().setId(resultadoQuerySelect.getLong("id_fornecedor"));
			medicamento.setDataEntradaUltimoEstoque(resultadoQuerySelect.getDate("data_entrada_ultimo_estoque"));
		}
		return medicamento;
	}

	public ArrayList<Medicamento> selectMedicamentoALl() throws SQLException {
		ArrayList<Medicamento> listaMedicamentosObjetos = null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM medicamento");
		Connection conexao = ConnectionFactory.getConnectionFactoryBank();
		PreparedStatement sentenca = conexao.prepareStatement(sqlBuilder.toString());
		ResultSet resultadoQuerySelectMedicamentos = sentenca.executeQuery();
		listaMedicamentosObjetos = new ArrayList<>();
		while (resultadoQuerySelectMedicamentos.next()) {
			Medicamento medicamento = new Medicamento();
			medicamento.setId(resultadoQuerySelectMedicamentos.getLong("id"));
			medicamento.setNome(resultadoQuerySelectMedicamentos.getString("nome"));
			medicamento.setQuantidade(resultadoQuerySelectMedicamentos.getInt("quantidade"));
			medicamento.setSubstrancias(resultadoQuerySelectMedicamentos.getString("substancias"));
			medicamento.setPreco(resultadoQuerySelectMedicamentos.getDouble("preco"));
			medicamento.setDescricaoDeUsuabilidade(
					resultadoQuerySelectMedicamentos.getString("descricao_de_usuabilidade"));
			medicamento.setPesoLiquido(resultadoQuerySelectMedicamentos.getDouble("peso_liquido"));
			medicamento.setFabricante(new Fabricante());
			medicamento.getFabricante().setId(resultadoQuerySelectMedicamentos.getLong("id_fornecedor"));
			medicamento.setDataEntradaUltimoEstoque(
					resultadoQuerySelectMedicamentos.getDate("data_entrada_ultimo_estoque"));
			listaMedicamentosObjetos.add(medicamento);
		}
		return listaMedicamentosObjetos;
	}
}
