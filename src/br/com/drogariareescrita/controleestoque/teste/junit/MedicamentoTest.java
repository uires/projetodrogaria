package br.com.drogariareescrita.controleestoque.teste.junit;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.drogariareescrita.controleestoque.dao.MedicamentoDAO;
import br.com.drogariareescrita.controleestoque.domains.Fabricante;
import br.com.drogariareescrita.controleestoque.domains.Medicamento;

public class MedicamentoTest {
	@Test
	public void inserirTest() {
		MedicamentoDAO dao = new MedicamentoDAO();
		Medicamento m = new Medicamento();
		m.setNome("Valerato");
		m.setQuantidade(300);
		m.setPreco(27.52);
		m.setSubstrancias("valerato de batametasona, sulfato de gentamicina, tolnaftato, clioquinol");
		m.setDescricao("Creme de uso adulto e pediatrico acima de 3 anos");
		m.setDescricaoDeUsuabilidade("Alivio das manifestacoes inflamatoria das dermatoses");
		m.setPesoLiquido(15.1);
		m.setQuantidadeMinimaDeUnidades(10);
		Fabricante fornecedor = new Fabricante();
		fornecedor.setId(1L);
		m.setFabricante(fornecedor);
		try {
			dao.inserirMedicamento(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void select() {
		Medicamento m = new Medicamento();
		m.setId(1L);
		MedicamentoDAO dao = new MedicamentoDAO();
		try {
			m = dao.selectMedicmento(m);
			System.out.println("[");
			System.out.println(m.getNome());
			System.out.println("{ "+ m.getDescricaoDeUsuabilidade() + " }");
			System.out.println("R$ " + m.getPreco());
			System.out.println("Peso L'iquido " + m.getPesoLiquido() + " g");
			System.out.println(m.getNome());
			System.out.println(m.getDataEntradaUltimoEstoque());
			System.out.println("]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void selectALl() {
		MedicamentoDAO dao = new MedicamentoDAO();
		try {
			ArrayList<Medicamento> lista = dao.selectMedicamentoALl();
			for(int i = 0; i<lista.size();i++) {
				System.out.println(lista.get(i).getDataEntradaUltimoEstoque());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
