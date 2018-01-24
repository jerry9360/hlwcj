package com.centit.hlwyw.inner.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import com.centit.hlwyw.inner.entity.Judgedoc;
import com.centit.hlwyw.inner.service.JudgeDocService;
import com.centit.hlwyw.inner.service.TaglibService;
@Controller("judgeDocController")
@RequestMapping("/corp/judgedoc")
public class JudgeDocController extends BaseController{

	private static Logger log = Logger.getLogger(JudgeDocController.class);  

	
	@Resource(name = "judgeDocServiceImpl")
	private JudgeDocService judgeDocService;
	
	@Resource(name = "taglibServiceImpl")
	private TaglibService taglibService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(required=false) String corp_name,
			@RequestParam(required=false) String industry,
			@PageableDefault(page = 0, size = Constantval.PAGE_SIZE_FIFTY) Pageable pageable,ModelMap model) {
		model.addAttribute("corp_name", corp_name);
		model.addAttribute("industry", industry);
 		Page<Object> page= judgeDocService.findSearch(corp_name,industry,pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/judgedoc/list";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable String id, ModelMap model) {
		Judgedoc judgedoc = judgeDocService.find(id);
		try {
			if(StringUtils.isNotBlank(judgedoc.getFilename())){
				String filename = URLDecoder.decode(judgedoc.getFilename(), "UTF-8");
				String[] files = filename.split("#");
				judgedoc.setFiles(files);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());log.info(e);
		}
		
		String content= judgedoc.getContent();
		String content1=content.substring(content.indexOf("Html\\\":\\\"")+9,content.length());
		judgedoc.setContent(content1.substring(0, content1.indexOf("\\\"}")));
		model.addAttribute("judgedoc", judgedoc);
		return "/judgedoc/detail";
	}	
}
