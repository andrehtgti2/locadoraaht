package br.com.andretanaka.locadoraaht.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andretanaka.locadoraaht.dao.LocacaoDao;
import br.com.andretanaka.locadoraaht.entity.LocacaoEntity;
import br.com.andretanaka.locadoraaht.logger.SLF4JAHT;
import br.com.andretanaka.locadoraaht.util.MensagensAHT;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
	
	private static final Logger logger = SLF4JAHT.getLogger(LocacaoController.class);
	
	@Autowired
	private LocacaoDao locacaoDao;
	
//	@GetMapping
//	public String testeOk() {
//		logger.info("LocadoraAHT Post testeOk");
//		return "LocadoraAHT Post testeOk";
//	}
	
	@GetMapping("/{nome}")
	public List<LocacaoEntity> getLocacao(@PathVariable(value="nome") String nome) {
		logger.info("...executando getLocacao(" + nome + ")...");
		//LocacaoEntity locacaoEntity = locacaoDao.getOne(id);
		List<LocacaoEntity> locacaoEntityList = locacaoDao.findByName(nome);
		return locacaoEntityList;		
	}
	
	@PostMapping()
	public LocacaoEntity insertLocacao(@RequestBody LocacaoEntity locacaoEntity) {
		logger.info("...executando insertLocacao(" + locacaoEntity.getId() + "|" + locacaoEntity.getNome() + "|" + locacaoEntity.getInicio() + "|" + locacaoEntity.getFim() + ")...");
		if(locacaoEntity.getInicio().after(locacaoEntity.getFim())) {			//
			RuntimeException r = new RuntimeException(MensagensAHT.getInstance().getMensagem(MensagensAHT.DATA_INICIAL_POSTERIOR_A_DATA_FINAL));
			logger.warn(r.getMessage());
			throw r;
		}
		List <LocacaoEntity> lista = locacaoDao.findByName(locacaoEntity.getNome()); 
		if(lista!=null && lista.size()>0) {
			RuntimeException r = new RuntimeException(MensagensAHT.getInstance().getMensagem(MensagensAHT.CLIENTE_JA_POSSUI_LOCACAO));
			logger.warn(r.getMessage());
			throw r;
		}else {
			return locacaoDao.save(locacaoEntity);
		}
	}
	
	@DeleteMapping("/{nome}")
	public void deleteLocacao(@PathVariable(value="nome") String nome) {
		logger.info("...executando deleteLocacao(" + nome + ")...");
		List<LocacaoEntity> locacaoEntityList = locacaoDao.findByName(nome);
		if(locacaoEntityList!=null && locacaoEntityList.size()>0) {
			//locacaoDao.deleteByName(nome);
			locacaoDao.deleteById(locacaoEntityList.get(0).getId());
		}		
	}
	

	
	
	 
	
	

	
}
