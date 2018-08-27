package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.Config;
import pages.CurriculoPage;
import pages.LoginPage;

public class EdicaoCurriculoTest {

	public WebDriver driver;
	public LoginPage loginpage;
	public CurriculoPage curriculopage;
	
	@Before
	public void setup(){
		WebDriver driver = Config.configuracao("https://www.vagas.com.br/login-candidatos");
		loginpage = PageFactory.initElements(driver, LoginPage.class);
		curriculopage = PageFactory.initElements(driver, CurriculoPage.class);
		loginpage.login("elluytest", "Teste123");	
	}
	
	@After
	public void finaliza() {
		curriculopage.driver.quit();
	}
	
	
	@Test
	public void editaNomeCompletoValido() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarNomeCompleto();
		curriculopage.campoNomeCompleto("Elluy Pereira");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
		
	}
	@Test
	public void editaNomeCompletoInvalido() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarNomeCompleto();
		curriculopage.campoNomeCompleto("");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemErroGenerica();
		
	}
	@Test
	public void editaEnderecoValido() throws InterruptedException {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarEndereco();
		curriculopage.selecionaComboPais("Brasil");
		curriculopage.selecionaComboUF("São Paulo");
		curriculopage.selecionaComboCidade("São Paulo");
		curriculopage.preencheCampoCEP("08140110");
		curriculopage.preencheCampoBairro("Itaim Pta");
		curriculopage.preencheCampoEndereco("Xyz jhdsd");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
		
	}
	
	@Test
	public void editaEnderecoIncompleto() throws InterruptedException {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarEndereco();
		curriculopage.selecionaComboPais("Bahamas");
		Thread.sleep(1000);
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemErroGenerica();
		
	}
	
	@Test
	public void editaDadosPessoaisValidos() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarDadosPessoais();
		curriculopage.selecionaGeneroFeminino();
		curriculopage.selecionaEstadoCivil("Casado(a)");
		curriculopage.selecionaPossuiFilhos();
		curriculopage.preencheNumeroFilhos("2");
		curriculopage.selecionaPaisNacionalidade("China");
		curriculopage.selecionaPaisDocumento("Brasil");
		curriculopage.selecionaTipoDocumento("CPF (BRA)");
		curriculopage.preencheCPF("30030030030");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
	}
	
	@Test
	public void editaDadosPessoaisCPFInvalido() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarDadosPessoais();
		curriculopage.selecionaGeneroMasculino();
		curriculopage.selecionaEstadoCivil("Solteiro(a)");
		curriculopage.selecionaPossuiFilhos();
		curriculopage.preencheNumeroFilhos("3");
		curriculopage.selecionaPaisNacionalidade("China");
		curriculopage.selecionaPaisDocumento("Brasil");
		curriculopage.selecionaTipoDocumento("CPF (BRA)");
		curriculopage.preencheCPF("12345678900");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemErroGenerica();
	}
	
	@Test
	public void editaInformacoesContatoValida() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarInformacoesContato();
		curriculopage.preencheCampoEmail("elluytest01@gmail.com");
		curriculopage.preencheCampoConfirmacaoEmail("elluytest01@gmail.com");
		curriculopage.preencheTelefone("1132483999");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
	}
	
	@Test
	public void editaInformacoesContatoConfirmacaoEmailInvalida() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarInformacoesContato();
		curriculopage.preencheCampoEmail("elluytest01@gmail.com");
		curriculopage.preencheCampoConfirmacaoEmail("elluytest02@gmail.com");
		curriculopage.preencheTelefone("1132483333");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemErroGenerica();
	}
	
	@Test
	public void editaDeficienciasComSucesso() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarDeficiencias();
		curriculopage.clicaOpcaoPossuiDeficiencia();
		curriculopage.clicaOpcaoFala();
		curriculopage.selecionaComboTipoDeficiencia("Mudez");
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
	}
	
	@Test
	public void editaDeficienciasSemDeficiencias() {
		curriculopage.clicaLinkAtualizarCurriculo();
		curriculopage.clicaLinkEditarDeficiencias();
		curriculopage.clicaOpcaoNaoPossuiDeficiencia();
		curriculopage.clicaBotaoSalvar();
		curriculopage.apresentaMensagemSucesso();
	}
	

}
