package com.centit.hlwyw.inner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.inner.entity.Zhongbiaogg;
import com.centit.hlwyw.inner.service.ZhongbiaoggService;

@Controller("zhongbiaoggController")
@RequestMapping("/biaosearch/zhongbiaogg")
public class ZhongbiaoggController extends BaseController {

	@Resource(name = "zhongbiaoggServiceImpl")
	private ZhongbiaoggService zhongbiaoggService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(HttpSession session,
			@RequestParam(required=false) String project_name,
			@RequestParam(required=false) String zhaobiaore,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("project_name", project_name);
		model.addAttribute("zhaobiaore", zhaobiaore);
 		Page<Zhongbiaogg> page= zhongbiaoggService.findSearch(project_name,zhaobiaore,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/biaosearch/zhongbiaogglist";
	}
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Zhongbiaogg zhongbiaogg = zhongbiaoggService.find(id);
		model.addAttribute("zhongbiaogg", zhongbiaogg);
		return "/biaosearch/zhongbiaoggdetail";
	}
}
