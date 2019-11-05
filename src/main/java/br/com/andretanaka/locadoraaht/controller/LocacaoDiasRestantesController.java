package br.com.andretanaka.locadoraaht.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andretanaka.locadoraaht.dao.LocacaoDao;
import br.com.andretanaka.locadoraaht.entity.LocacaoEntity;
import br.com.andretanaka.locadoraaht.logger.SLF4JAHT;
import br.com.andretanaka.locadoraaht.queue.RabbitMQSenderAHT;
import br.com.andretanaka.locadoraaht.util.DiferencaEntreDatasFullAHT;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@RestController
@RequestMapping("/calcular-dias-restantes")
public class LocacaoDiasRestantesController {
	
	private static final Logger logger = SLF4JAHT.getLogger(LocacaoDiasRestantesController.class);
	
	@Autowired
	private LocacaoDao locacaoDao;
	
	@Autowired
	RabbitMQSenderAHT rabbitMQSender;
	
	@PostMapping()
	public void calcularEPublicar() {
		List<LocacaoEntity> lista = locacaoDao.findAll();
		for (LocacaoEntity locacaoEntity : lista) {
			double dias = calcularDiasRestantes(locacaoEntity.getFim());
			publishMessage(locacaoEntity.getNome(), (int)dias);
		}
	}

	private void publishMessage(String nome, int dias) {
		rabbitMQSender.send(nome + "," + dias);
	}

	private double calcularDiasRestantes(Date fim) {
		DiferencaEntreDatasFullAHT diferencaEntreDatasFullAHT = new DiferencaEntreDatasFullAHT();
		double dias = diferencaEntreDatasFullAHT.calculaQuantidadeEntreDatas(new Date(), fim, DiferencaEntreDatasFullAHT.TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_DIAS);
		if(dias<0) {
			return 0;
		}
		return dias;
	}
	
	

}
