package com.centit.hlwyw.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.centit.hlwyw.account.entity.Principal;
import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.account.entity.User;
import com.centit.hlwyw.account.service.RoleService;
import com.centit.hlwyw.account.service.UserService;
import com.centit.hlwyw.core.util.KeyUtils;
import com.centit.hlwyw.inner.service.CorpinfoService;
import com.centit.hlwyw.inner.service.PersoninfoService;
import com.centit.hlwyw.shiro.security.LoginRealm;
import com.centit.hlwyw.shiro.security.PasswordHelper;
import com.centit.hlwyw.shiro.security.RoleUsernamePasswordToken;
import com.centit.hlwyw.sys.entity.Menu;
import com.centit.hlwyw.sys.service.IndexService;
import com.centit.hlwyw.sys.service.MenuService;

@Controller
@RequestMapping("/")
public class IndexController {
	private static Logger log = Logger.getLogger(IndexController.class);  
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	@Resource(name = "indexServiceImpl")
	private IndexService indexService;
	
	@Resource(name = "corpinfoServiceImpl")
	private CorpinfoService corpinfoService;
	
	@Resource(name = "personinfoServiceImpl")
	private PersoninfoService personinfoService;
	
	@Resource(name = "passwordHelper")
	private PasswordHelper passwordHelper;
	

	// 主页
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(ModelMap model, HttpSession session) {
		return "/index/home";
	}
	
	// 主页
	@RequestMapping(value = "/index-maintain",method = RequestMethod.GET)
	public String indexMaintain(ModelMap model, HttpSession session) {
		Principal principal = (Principal) session.getAttribute("userinfo");
		if(principal!=null){
			principal.setIndex("maintain");
			session.setAttribute("userinfo",principal);
		}
		//初始化统计数据
		indexService.initStat(model);
		//训练市场
		/*indexService.readData(null,null,null);
		//训练行业
		indexService.readData("daoluyunshu",null,null);
		indexService.readData("shuiluyunshu",null,null);
		indexService.readData("gonglujianshe",null,null);
		indexService.readData("shuiyunjianshe",null,null);
		//训练大类
		indexService.readData("daoluyunshu","chuzuche",null);
		indexService.readData("daoluyunshu","wangyueche",null);
		indexService.readData("daoluyunshu","jiapei",null);
		indexService.readData("daoluyunshu","daolulvke",null);
		indexService.readData("daoluyunshu","daoluhuoyun",null);
		indexService.readData("daoluyunshu","gongjiaoche",null);
		indexService.readData("daoluyunshu","guidaojiaotong",null);
		indexService.readData("daoluyunshu","qichezuling",null);
		indexService.readData("shuiluyunshu","shuiyunlvkeyunshu",null);
		indexService.readData("gonglujianshe","gonglujianshe",null);
		indexService.readData("shuiyunjianshe","shuiyunzuoye",null);
		//训练小类
		//1.出租车行业：投诉类、咨询类、反映情况类、求助类、表扬类
		indexService.readData("daoluyunshu","chuzuche","tousu");
		indexService.readData("daoluyunshu","chuzuche","zixun");
		indexService.readData("daoluyunshu","chuzuche","fanyingqingkuang");
		indexService.readData("daoluyunshu","chuzuche","qiuzhu");
		indexService.readData("daoluyunshu","chuzuche","biaoyang");
		//2.网约车行业：投诉类、咨询类 
		indexService.readData("daoluyunshu","wangyueche","tousu");
		indexService.readData("daoluyunshu","wangyueche","zixun");
		//3.驾培行业：投诉类、咨询类	
		indexService.readData("daoluyunshu","jiapei","tousu");
		indexService.readData("daoluyunshu","jiapei","zixun");
		//4.道路旅客行业：投诉类、咨询类、求助类
		indexService.readData("daoluyunshu","daolulvke","tousu");
		indexService.readData("daoluyunshu","daolulvke","zixun");
		indexService.readData("daoluyunshu","daolulvke","qiuzhu");
		//5.道路货运行业：投诉类、咨询类
		indexService.readData("daoluyunshu","daoluhuoyun","tousu");
		indexService.readData("daoluyunshu","daoluhuoyun","zixun");
		//6.公交车行业:投诉类、咨询类、反映情况类、求助类、表扬类、建议类 
		indexService.readData("daoluyunshu","gongjiaoche","tousu");
		indexService.readData("daoluyunshu","gongjiaoche","zixun");
		indexService.readData("daoluyunshu","gongjiaoche","qiuzhu");
		indexService.readData("daoluyunshu","gongjiaoche","biaoyang");
		indexService.readData("daoluyunshu","gongjiaoche","jianyi");
		//7.轨道交通行业：投诉类、咨询类、反映情况类、表扬类
		indexService.readData("daoluyunshu","guidaojiaotong","tousu");
		indexService.readData("daoluyunshu","guidaojiaotong","zixun");
		indexService.readData("daoluyunshu","guidaojiaotong","fanyingqingkuang");
		indexService.readData("daoluyunshu","guidaojiaotong","biaoyang");
		//8.汽车租赁行业：投诉类、咨询类
		indexService.readData("daoluyunshu","qichezuling","zixun");
		//1.水运旅客运输行业：咨询类
		indexService.readData("shuiluyunshu","shuiyunlvkeyunshu","zixun");
		//1.公路建设行业：咨询类、反映情况类
		indexService.readData("gonglujianshe","gonglujianshe","zixun");
		indexService.readData("gonglujianshe","gonglujianshe","fanyingqingkuang");
		//1.水运作业:投诉
		indexService.readData("shuiyunjianshe","shuiyunzuoye","tousu");*/
		return "/index/dashboard";
	}
	
	// 主页
	@RequestMapping(value = "/index-service",method = RequestMethod.GET)
	public String indexService(ModelMap model, HttpSession session) {
		Principal principal = (Principal) session.getAttribute("userinfo");
		if(principal!=null){
			principal.setIndex("service");
			session.setAttribute("userinfo",principal);
		}
		return "/index/dashboard-service";
	}
	
	// 主页
	@RequestMapping(value = "/index-analyze",method = RequestMethod.GET)
	public String indexAnalyze(ModelMap model, HttpSession session) {
		Principal principal = (Principal) session.getAttribute("userinfo");
		if(principal!=null){
			principal.setIndex("analyze");
			session.setAttribute("userinfo",principal);
		}
		indexService.init_analyzeStat(model);
		return "/index/dashboard-analyze";
	}
	
	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/index/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(
  			HttpSession session,
			@RequestParam(required = true) String loginname,
			@RequestParam(required = true) String password,
			@RequestParam(required = false, defaultValue = "false") boolean rememberMe,ModelMap model) {
		Subject user = SecurityUtils.getSubject();
		if (user.isAuthenticated() || user.isRemembered()) {
			user.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		RoleUsernamePasswordToken token = new RoleUsernamePasswordToken(
				loginname, password, rememberMe);
		String fallbackUrl = "/";
		try {
			user.login(token);
			if (user.isAuthenticated()) {
				Principal principal = (Principal)user.getPrincipal();
				intUserinfoAndUserroleinfoAndmenuinfo(principal, session);
				return "redirect:" + fallbackUrl;
			}
		return "redirect:" + fallbackUrl;
		} catch (ExcessiveAttemptsException e) {
			log.error(e.getMessage());log.info(e);
			token.clear();
			model.addAttribute("loginname", loginname);
			model.addAttribute("errorMsg", "登录次数超过限定次数！");
			return "/index/login";
		} catch (Exception e) {
			log.error(e.getMessage());log.info(e);
			token.clear();
			model.addAttribute("loginname", loginname);
			model.addAttribute("errorMsg", "用户名或密码错误，请重新输入！");
			return "/index/login";
		}
	}

	// 退出登录
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated() || subject.isRemembered()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/pwdmgr/changepwd", method = RequestMethod.GET)
	public String changepassword(){
		return "/index/pwd";
	}
	
	@RequestMapping(value = "/pwdmgr/changepwd", method = RequestMethod.POST)
	@ResponseBody
	public String changepassword(String oldpassage,String passage,String conpassage,HttpSession session){
		Principal principal = (Principal) session.getAttribute("userinfo");
		if(StringUtils.isBlank(oldpassage)){
			return "noOldpwd";
		}
		if(StringUtils.isBlank(passage)){
			return "noNewpwd";
		}
		if(StringUtils.isBlank(conpassage)){
			return "noConpwd";
		}
		if(!passage.equals(conpassage)){
			return "notequal";
		}
		String id = principal.getId();
		User userinfo = userService.find(id);
		String salt =userinfo.getSalt();
		String oldpasswordtemp = passwordHelper.getPassword(salt, oldpassage);
		if(userinfo.getPassword().equals(oldpasswordtemp)){
			String newpasswordtemp =  passwordHelper.getPassword(salt, passage);
			if(oldpasswordtemp.equals(newpasswordtemp)){
				return "equalpwd";
			}
			salt = KeyUtils.getKey();
			String passwordtemp = passwordHelper.getPassword(salt, passage);
			userService.updatePassword(passwordtemp,salt,id);
		    RealmSecurityManager securityManager =  
		    	      (RealmSecurityManager) SecurityUtils.getSecurityManager();  
			LoginRealm userRealm = (LoginRealm)securityManager.getRealms().iterator().next();  
		    userRealm.clearAllCache();
			return "OK";
		}else{
			return "erroroldpwd";
		}
	}
	

	/**
	 * 
	 * @param principal
	 * @param session
	 */
	private void intUserinfoAndUserroleinfoAndmenuinfo(Principal principal,HttpSession session){
		//角色信息加载
		Set<Role> roles = principal.getRoles();
		List<Menu> menus = null;
		if(roles!=null&&roles.size()>0){
			List<String> roleids = new ArrayList<String>();
			for(Role r:roles){
				roleids.add(r.getId());
			}
			menus = menuService.findUserMenus(roleids);
			principal.setMenus(menuService.parseUserMenus(menus));
		}
		session.setAttribute("userinfo", principal);
	}
	
}
