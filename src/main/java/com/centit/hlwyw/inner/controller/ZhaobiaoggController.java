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
import com.centit.hlwyw.inner.entity.Zhaobiaogg;
import com.centit.hlwyw.inner.service.ZhaobiaoggService;

@Controller("zhaobiaoggController")
@RequestMapping("/biaosearch/zhaobiaogg")
public class ZhaobiaoggController extends BaseController {

	@Resource(name = "zhaobiaoggServiceImpl")
	private ZhaobiaoggService zhaobiaoggService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String project_name,
			@RequestParam(required=false) String zhaobiaore,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("project_name", project_name);
		model.addAttribute("zhaobiaore", zhaobiaore);
 		Page<Zhaobiaogg> page= zhaobiaoggService.findSearch(project_name,zhaobiaore,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/biaosearch/zhaobiaogglist";
	}
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Zhaobiaogg zhaobiaogg = zhaobiaoggService.find(id);
		model.addAttribute("zhaobiaogg", zhaobiaogg);
		return "/biaosearch/zhaobiaoggdetail";
	}
}
