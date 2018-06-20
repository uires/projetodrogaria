package br.com.drogariareescrita.controleestoque.teste.junit;

import java.sql.SQLException;

import org.junit.Test;

import br.com.drogariareescrita.controleestoque.dao.FabricanteDAO;
import br.com.drogariareescrita.controleestoque.domains.Fabricante;

public class FabricanteTest {
	
	@Test
	public void testeInsercao() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f = new Fabricante();
		f.setDescricao("Uma empresa com anos de tradição, "
				+ "que tem uma linha de produtos diferenciados por sua qualidade e sofisticação.");
		f.setCnpj("86.458.293/0001-70");
		f.setNomeFabricante("Caiabí");
		try {
			dao.inserirFabricante(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeExclusao() {
		Fabricante f = new Fabricante();
		f.setId(1L);
		FabricanteDAO dao = new FabricanteDAO();
		try {
			dao.excluirFabricante(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void resultadoQuery() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante result;
		Fabricante f = new Fabricante();
		f.setId(2L);
		try {
			result = dao.selectFabricante(f);
			System.out.println("[");
			System.out.println(result.getNomeFabricante());
			System.out.println(result.getCnpj());
			System.out.println(result.getDescricao());
			System.out.println("]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
