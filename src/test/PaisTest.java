package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import model.Pais;
import service.PaisService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class PaisTest {
	Pais pais, copia;
	static int id = 1;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("\nSetup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("India");
		pais.setPopulacao(128193591);
		pais.setArea(3287590.00);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("India");
		copia.setPopulacao(128193591);
		copia.setArea(3287590.00);
		System.out.println(pais);
		System.out.println(copia);
	}
	
	@Test
	public void test01Carregar() {
		System.out.println("Carregar");
		Pais fixture = new Pais();
		fixture.setId(2);
		fixture.setNome("Brasil");
		fixture.setPopulacao(210147125);
		fixture.setArea(8515767.0);
		Pais novo = new Pais();
		PaisService ps = new PaisService();
		novo = ps.carregar(2);
		System.out.print(novo);
		System.out.print("\n" + fixture);
		System.out.println("\n--------------------------");
		assertEquals(fixture.toString(),novo.toString());
	}
	
	@Test
	public void test02Criar() {
		System.out.println("Criar");
		PaisService ps = new PaisService();
		id = ps.criar(pais);
		System.out.println(id);
		copia.setId(id);
		System.out.println("\n--------------------------");
		assertEquals("testa criacao", pais.toString(), copia.toString());
	}

	@Test
	public void test03Atualizar() {
		System.out.println("Atualizar");
		pais.setPopulacao(999999);
		copia.setPopulacao(999999);
		PaisService ps = new PaisService();
		ps.atualizar(pais);
		pais = ps.carregar(1);
		System.out.print(pais);
		System.out.print("\n" + copia);
		System.out.println("\n--------------------------");
		assertEquals("testa atualizacao", pais.toString(), copia.toString());
	}

	@Test
	public void test04Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		PaisService ps = new PaisService();
		ps.excluir(1);
		pais = ps.carregar(1);
		System.out.println(copia);
		System.out.println(pais);
		System.out.println("--------------------------");
		assertEquals("testa exclusao", pais.toString(), copia.toString());
	}	
	
	@Test
	void test05MaiorPopulacao() {
		PaisService ps = new PaisService();
		String maiorpop = ps.maiorPopulacao();
		System.out.println("Maior Populacao");
		System.out.print("China");
		System.out.print("\n" + maiorpop);
		System.out.println("\n--------------------------");
		assertEquals("Testa Maior populacao",maiorpop, "China");

	}


	@Test
	void test06MenorArea() {
		PaisService ps = new PaisService();
		String menorarea = ps.menorArea();
		System.out.println("Menor Area");
		System.out.print("India");
		System.out.print("\n" + menorarea);
		System.out.println("\n--------------------------");
		assertEquals("Testa menor Area: ",menorarea, "India");
	}
}
