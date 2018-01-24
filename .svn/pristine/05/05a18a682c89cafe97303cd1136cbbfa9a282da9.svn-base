package com.centit.hlwyw.inner.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import redis.clients.jedis.Jedis;

import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.core.util.JedisPoolUtils;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.entity.Organinfo;
import com.centit.hlwyw.inner.service.OrganinfoService;

@Controller("organinfoController")
@RequestMapping("orgmgr/organs")
public class OrganinfoController extends BaseController {

	@Resource(name = "organinfoServiceImpl")
	private OrganinfoService organinfoService;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required = false) String name,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,
			ModelMap model) {
		model.addAttribute("name", name);
		name = StringUtils.isBlank(name) ? "%%" : "%" + name + "%";
		Page<Organinfo> page = organinfoService.findAll(name, pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "organinfo/list";
	}

	/**
	 * save
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(@RequestParam(required = false) String id,
			String orgname, String keyval) {
		Organinfo org = null;
		if (StringUtils.isNotBlank(id)) {
			org = organinfoService.find(id);
			if (org == null) {
				return "redirect:/orgmgr/organs";
			}
			org.setOrgname(orgname);
			org.setKeyval(keyval);
			org.setModifydate(new Date());
			Jedis jedis = JedisPoolUtils.getInstance().getJedis();
			jedis.set("TaglibOrginfo:" + orgname, keyval);
			JedisPoolUtils.getInstance().returnRes(jedis);
			organinfoService.update(org);
		} else {
			org = new Organinfo();
			org.setOrgid(KeyUtils.getKey());
			org.setOrgname(orgname);
			org.setKeyval(keyval);
			org.setModifydate(new Date());
			org.setCreatedate(new Date());
			Jedis jedis = JedisPoolUtils.getInstance().getJedis();
			jedis.set("TaglibOrginfo:" + orgname, keyval);
			JedisPoolUtils.getInstance().returnRes(jedis);
			organinfoService.save(org);
		}
		return "redirect:/orgmgr/organs";
	}

	/**
	 * delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	String delete(@PathVariable String id) {
		Organinfo org = organinfoService.find(id);
		Jedis jedis = JedisPoolUtils.getInstance().getJedis();
		jedis.del("TaglibOrginfo:" + org.getOrgname());
		JedisPoolUtils.getInstance().returnRes(jedis);
		organinfoService.delete(id);
		return "redirect:/orgmgr/organs";
	}

}
