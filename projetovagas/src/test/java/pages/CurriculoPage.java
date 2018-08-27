package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class CurriculoPage {
	
	public WebDriver driver;
	
	public CurriculoPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Mapeamento botoes de editar/atualizar
	
	@FindBy (how=How.XPATH, using="//*[@id=\"lateral-servicos\"]/div/div[3]/a")
	WebElement lnkAtualizarCurriculo;
	
	@FindBy (how=How.XPATH, using="//*[@title=\"Editar nome\"]")
	WebElement lnkEditarNomeCompleto;
	
	@FindBy (how=How.XPATH, using="//*[@title=\"Editar endereço\"]")
	WebElement lnkEditarEndereco;
	
	@FindBy (how=How.XPATH, using="//*[@title=\"Editar dados pessoais\"]")
	WebElement lnkEditarDadosPessoais;
	
	@FindBy (how=How.XPATH, using= "//*[@title=\"Editar informações de contato\"]")
	WebElement lnkEditarInformacoesContato;
	
	@FindBy (how=How.XPATH, using="//*[@title=\"Editar deficiências\"]")
	WebElement lnkEditarDeficiencias;
	
	// Mapeamento campos
	
	@FindBy (id="curriculo_nome_completo")
	WebElement campoNomeCompleto;
	
	@FindBy (id="endereco_cep")
	WebElement campoCEP;
	
	@FindBy (id="endereco_logradouro")
	WebElement campoEndereco;
	
	@FindBy (id="endereco_bairro")
	WebElement campoBairro;
	
	@FindBy (id="dados_pessoais_filhos")
	WebElement campoFilhos;
	
	@FindBy (how=How.XPATH, using= "//*[@id=\"dados_pessoais_documentos_attributes_0_numero\"]")
	WebElement campoCPF;
	
	@FindBy (id="informacoes_de_contato_email")
	WebElement campoEmail;
	
	@FindBy (id="informacoes_de_contato_confirmacao_de_email")
	WebElement campoConfirmacaoEmail;
	
	@FindBy (id="informacoes_de_contato_telefone_numero")
	WebElement campoTelefone;
	
	//Mapeamento botão salvar
	
	@FindBy (how=How.CSS, using= "button[type='submit']")
	WebElement btnSalvar;
	
	//Mapeamento combos
	

	
	@FindBy (id="endereco_pais_id")
	WebElement comboPais;
	
	@FindBy (id="endereco_uf_id")
	WebElement comboUF;
	
	@FindBy (id="endereco_cidade_id")
	WebElement comboCidade;
	
	@FindBy (id="dados_pessoais_estado_civil")
	WebElement comboEstadoCivil;
	
	@FindBy (id="dados_pessoais_pais_de_nacionalidade")
	WebElement comboPaisNacionalidade;
	
	@FindBy (how=How.XPATH, using= "//*[@id=\"dados_pessoais_documentos_attributes_0_pais_id\"]")
	WebElement comboPaisDocumento;
	
	@FindBy (how=How.XPATH, using= "//*[@id=\"dados_pessoais_documentos_attributes_0_tipo_id\"]")
	WebElement comboTipoDocumento;
	
	@FindBy (id="deficiencias_tipo_de_deficiencia_fala")
	WebElement comboTipoDeficiencia;
	
	//Mapeamento mensagens de falha e sucesso
	
	@FindBy (how=How.XPATH, using= "//*[@class=\"validate-error\"]")
	WebElement msgErro;
	
	@FindBy (how=How.XPATH, using="//*[@id=\"curriculoNotificacao\"][@style=\"display: block;\"]")
	WebElement msgSucesso;
	
	//Mapeamento opções
	
	@FindBy (id="dados_pessoais_genero_feminino")
	WebElement opcaoFeminino;
	
	@FindBy (id="dados_pessoais_genero_masculino")
	WebElement opcaoMasculino;
	
	@FindBy (id="filhos_sim")
	WebElement opcaoPossuiFilhos;
		
	@FindBy (id="deficiencias_possui_alguma_deficiencia_true")
	WebElement opcaoPossuiDeficiencia;
	
	@FindBy (id="deficiencias_possui_alguma_deficiencia_false")
	WebElement opcaoNaoPossuiDeficiencia;
	
	@FindBy (id="deficiencias_possui_deficiencia_fala")
	WebElement opcaoFala;
	
	
	//Métodos utilizados nos testes
	
	public void clicaLinkAtualizarCurriculo() {
		lnkAtualizarCurriculo.click();
	}
	
	public void clicaLinkEditarNomeCompleto() {
		lnkEditarNomeCompleto.click();
	}
	
	public void campoNomeCompleto(String nomeCompleto) {
		campoNomeCompleto.clear();
		campoNomeCompleto.sendKeys(nomeCompleto);
	}
	
	public void clicaBotaoSalvar() {
		btnSalvar.click();
	}
	
	public void clicaLinkEditarEndereco() {
		lnkEditarEndereco.click();
	}
	
	public void selecionaComboPais(String pais) {
		comboPais.click();
		new Select(driver.findElement(By.id("endereco_pais_id"))).selectByVisibleText(pais);
	}
	
	public void selecionaComboUF(String uf) {
		comboUF.click();
		new Select(driver.findElement(By.id("endereco_uf_id"))).selectByVisibleText(uf);
	}
	
	public void selecionaComboCidade(String cidade) {
		comboCidade.click();
		new Select(driver.findElement(By.id("endereco_cidade_id"))).selectByVisibleText(cidade);
	}
	
	public void preencheCampoCEP(String CEP) {
		campoCEP.clear();
		campoCEP.sendKeys(CEP);
	}
	
	public void preencheCampoEndereco(String endereco) {
		campoEndereco.clear();
		campoEndereco.sendKeys(endereco);
	}
	
	public void preencheCampoBairro(String bairro) {
		campoBairro.clear();
		campoBairro.sendKeys(bairro);
	}
	
	public void apresentaMensagemErroGenerica() {
		msgErro.isDisplayed();
	}
	
	public void apresentaMensagemSucesso() {
		msgSucesso.isDisplayed();
	}
	
	public void clicaLinkEditarDadosPessoais() {
		lnkEditarDadosPessoais.click();
	}
	
	public void selecionaGeneroFeminino() {
		opcaoFeminino.click();
	}
	
	public void selecionaGeneroMasculino() {
		opcaoMasculino.click();
	}
	
	public void selecionaEstadoCivil(String estadoCivil) {
		comboEstadoCivil.click();
		new Select(driver.findElement(By.id("dados_pessoais_estado_civil"))).selectByVisibleText(estadoCivil);
	}
	
	public void selecionaPossuiFilhos() {
		opcaoPossuiFilhos.click();
	}
	
	public void preencheNumeroFilhos(String numeroFilhos) {
		campoFilhos.clear();
		campoFilhos.sendKeys(numeroFilhos);
	}
	
	public void selecionaPaisNacionalidade(String paisNacionalidade) {
		comboPaisNacionalidade.click();
		new Select(driver.findElement(By.id("dados_pessoais_pais_de_nacionalidade"))).selectByVisibleText(paisNacionalidade);
	}
	
	public void selecionaPaisDocumento(String paisDocumento) {
		comboPaisDocumento.click();
		new Select(driver.findElement(By.xpath("//*[@id=\"dados_pessoais_documentos_attributes_0_pais_id\"]"))).selectByVisibleText(paisDocumento);
	}

	public void selecionaTipoDocumento(String tipoDocumento) {
		comboTipoDocumento.click();
		new Select(driver.findElement(By.xpath("//*[@id=\"dados_pessoais_documentos_attributes_0_tipo_id\"]"))).selectByVisibleText(tipoDocumento);
	}

	public void preencheCPF(String cpf) {
		campoCPF.clear();
		campoCPF.sendKeys(cpf);
	}

	public void clicaLinkEditarInformacoesContato() {
		lnkEditarInformacoesContato.click();
	}
	
	public void preencheCampoEmail(String email) {
		campoEmail.clear();
		campoEmail.sendKeys(email);
	}
	
	public void preencheCampoConfirmacaoEmail(String confEmail) {
		campoConfirmacaoEmail.clear();
		campoConfirmacaoEmail.sendKeys(confEmail);
	}
	
	public void preencheTelefone(String telefone) {
		campoTelefone.clear();
		campoTelefone.sendKeys(telefone);
	}
	
	public void clicaLinkEditarDeficiencias() {
		lnkEditarDeficiencias.click();
	}
	
	public void clicaOpcaoPossuiDeficiencia() {
		opcaoPossuiDeficiencia.click();
	}
	
	public void clicaOpcaoNaoPossuiDeficiencia() {
		opcaoNaoPossuiDeficiencia.click();
	}
	
	public void clicaOpcaoFala() {
		opcaoFala.click();
	}
	
	public void selecionaComboTipoDeficiencia(String tipoDeficiencia) {
		comboTipoDeficiencia.click();
		new Select(driver.findElement(By.id("deficiencias_tipo_de_deficiencia_fala"))).selectByVisibleText(tipoDeficiencia);
	}
}
