package com.centit.hlwyw.task;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.centit.hlwyw.inner.service.CorpinfoService;
import com.centit.hlwyw.inner.service.PersoninfoService;
import com.centit.hlwyw.sys.service.IndexService;

@Component("tagtask")
public class TagTask {


	@Resource(name = "corpinfoServiceImpl")
	private CorpinfoService corpinfoService;
	
	@Resource(name = "personinfoServiceImpl")
	private PersoninfoService personinfoService;
	
	@Resource(name = "indexServiceImpl")
	private IndexService indexService;
	
	public void corpTag(){
//		List<Corpinfo> infos = corpinfoService.findAllUnTag("Y");
//		Jedis jedis = JedisPoolUtils.getInstance().getJedis();
//		String keyval = null;
//		for(Corpinfo info:infos){
//			if(StringUtils.isNotBlank(info.getCorp_name())){
//				if(StringUtils.isNotBlank(info.getCorp_short())){
//					keyval = info.getCorp_name()+"+"+info.getCorp_short();
//				}else{
//					keyval = info.getCorp_name();
//				}
//			}
//			jedis.set("TaglibCorp:"+info.getCorp_id(), keyval);
//			keyval = null;
//			info.setIstag("Y");
//			corpinfoService.update(info);
//		}
//		JedisPoolUtils.getInstance().returnRes(jedis);
	}
	
	public void personTag(){
//		List<Personinfo> infos = personinfoService.findPersoninfoUnTag("Y");
//		Jedis jedis = JedisPoolUtils.getInstance().getJedis();
//		String keyval = null;
//		for(Personinfo info:infos){
//			if(StringUtils.isNotBlank(info.getName())){
//				if(StringUtils.isNotBlank(info.getCard_no())){
//					keyval = info.getName()+"+"+info.getCard_no();
//				}else{
//					keyval = info.getName();
//				}
//			}
//			jedis.set("TaglibPerson:"+info.getPerid(),keyval);
//			keyval = null;
//			info.setIstag("Y");
//			personinfoService.update(info);
//		}
//		JedisPoolUtils.getInstance().returnRes(jedis);
	}
	
	public void initStat(){
		indexService.statinitInfo();
	}
	
}
