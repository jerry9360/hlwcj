package com.centit.hlwyw.sys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.centit.hlwyw.account.entity.Permission;
import com.centit.hlwyw.account.entity.Principal;
import com.centit.hlwyw.account.entity.Role;
import com.centit.hlwyw.account.service.PermissionService;
import com.centit.hlwyw.account.service.RoleService;
import com.centit.hlwyw.core.controller.BaseController;
import com.centit.hlwyw.core.util.Constantval;
import com.centit.hlwyw.sys.entity.Menu;
import com.centit.hlwyw.sys.entity.Role_permission;
import com.centit.hlwyw.sys.service.MenuService;
import com.centit.hlwyw.sys.service.Role_permissionService;

@Controller("menuController")
@RequestMapping("/adminmgr/menu")
public class MenuController extends BaseController {

	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	@Resource(name = "permissionServiceImpl")
	private PermissionService permissionService;
	
	@Resource(name = "role_permissionServiceImpl")
	private Role_permissionService role_permissionService;	
		
	/**
	 * 查看菜单
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getMenu(ModelMap model,@RequestParam(required = false) String isforbidden) {
		List<Menu> menulist = null;

		if(null!=isforbidden&&isforbidden.equals(Menu.CONSTENT_ISFORBIDDEN)){
			menulist = menuService.findALlMenus();
		}else{
			menulist = menuService.findVaidMenus();
		}
		model.addAttribute("menulist", menulist);
		model.addAttribute("isforbidden", isforbidden);
		return "/sys/menu/list";
	}
	
	/**
	 * 禁用菜单
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/forbidmenu/{id}",method = RequestMethod.GET)
	public String forbidMenu(@PathVariable String id ) {
		menuService.forbidmenu(Menu.CONSTENT_ISFORBIDDEN, id);
		return "redirect:/adminmgr/menu";
	}
	
	/**
	 * 启用菜单
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/unforbidmenu/{id}",method = RequestMethod.GET)
	public String unforbidMenu(@PathVariable String id ) {
		menuService.forbidmenu(Menu.CONSTENT_UNFORBIDDEN, id);
		return "redirect:/adminmgr/menu";
	}
	
	/**
	 * 新建父菜单
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/newfathermenu",method = RequestMethod.GET)
	public String newFathermenu(ModelMap model){
		Menu menu = menuService.newMenu();
		model.addAttribute("menu", menu);
		return "/sys/menu/form";
	}
		
	/**
	 * 新建子菜单
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/newchildmenu/{pid}",method = RequestMethod.GET)
	public String newChildmenu(@PathVariable String pid,ModelMap model){
		Menu menu = menuService.newMenu();
		Menu fmenu = menuService.find(pid);
		model.addAttribute("menu", menu);
		model.addAttribute("fmenu", fmenu);
		return "/sys/menu/form";
	}
	
	/**
	 * 编辑父菜单
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editfathermenu/{id}",method = RequestMethod.GET)
	public String editfathermenu(@PathVariable String id,ModelMap model){
		Menu menu = menuService.find(id);
		model.addAttribute("menu", menu);
		return "/sys/menu/form";
	}
	
	/**
	 * 编辑子菜单
	 * @param id
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editchildmenu/{id}/{pid}",method = RequestMethod.GET)
	public String editchildmenu(@PathVariable String id,@PathVariable String pid,ModelMap model){
		Menu menu = menuService.find(id);
		Menu fmenu = menuService.find(pid);
		model.addAttribute("menu", menu);
		model.addAttribute("fmenu", fmenu);
		return "/sys/menu/form";
	}
		
	/**
	 * 保存菜单
	 * @param menu
	 * @param redirectAttributes
	 * @return
	 */
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	@ResponseBody
	public String savemenu(@Valid Menu menu ){
		if(menu.getId()==null||"".equals(menu.getId())){
			menu = menuService.setMenuid(menu);
			menuService.save(menu);
		}else{
			menuService.update(menu);
		}
		return Constantval.CONSTANT_SUCCESS;
	}
	
	/**
	 * 更新菜单
	 * @param menu
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updatemenu(@Valid Menu menu ){
		menuService.update(menu);
		return "redirect:/adminmgr/menu";
	}
	
	/**
	 * 校验子类业务是否已全部禁用
	 */
	@RequestMapping(value = "/ischildmenuforbidden/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public String isChildMenuForbidden(@PathVariable String pid){
		List<Menu> list = menuService.findChildMenuUnforbidden(pid);
		if(null!=list&&list.size()>0){
			return "FAIL";
		}else{
			return "SUCCESS";
		}
	}
	
	/**
	 * 校验父类业务是否已启用
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/isfathermenuforbidden/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String isFatherMenuForbidden(@PathVariable String id){
		Menu cmenu = menuService.find(id);
		Menu fmenu = menuService.find(cmenu.getPid());
		if(fmenu.getIsforbidden().equals(Menu.CONSTENT_ISFORBIDDEN)){
			return "FAIL";
		}else{
			return "SUCCESS";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveMenu(@RequestParam(required = true) String roleid,@RequestParam(required = false)List<String> menuid, HttpSession session) {
		menuService.deleteByroleid(roleid);
		menuService.saveMenu(roleid, menuid);
//		List<String> roleids = new ArrayList<String>();
//		roleids.add(roleid);
		
//		List<Menu> menus = menuService.findUserMenus(roleids);
		Subject user = SecurityUtils.getSubject();
		Principal principal = (Principal)user.getPrincipal();
		
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
//		principal.setMenus(menuService.parseUserMenus(menus));
		session.removeAttribute("userinfo");
		session.setAttribute("userinfo", principal);
		return "redirect:/adminmgr/menu/"+ roleid+"/setmenu" ;
	}
	
	@RequestMapping(value = "/{roleid}/setmenu", method = RequestMethod.GET)
	public String setMenu(@PathVariable String roleid,ModelMap model) {
		List<Menu> menuexidlist = menuService.findUserRoleMenus(roleid);
		model.addAttribute("menuexidlist", menuexidlist);
		Role role = roleService.find(roleid);
		List<Menu> menulist = null;
		menulist=menuService.findVaidMenus();
		model.addAttribute("menulist", menulist);
		model.addAttribute("roleid", roleid);
		model.addAttribute("role", role);
		return "/sys/menu/rolemenu";
	}
	
	@RequestMapping(value = "/{roleid}/setpermission", method = RequestMethod.GET)
	public String setpermission(@PathVariable String roleid,ModelMap model) {
		List<Permission> permissionlist = permissionService.findAll() ;
 		Role role = roleService.find(roleid);
 		List<Role_permission> role_permissionlist=role_permissionService.findByRole_id(roleid);
 		model.addAttribute("permissionlist", permissionlist);
		model.addAttribute("roleid", roleid);
		model.addAttribute("role", role);
		model.addAttribute("role_permissionlist", role_permissionlist);
		return "/sys/menu/rolepermission";
	}
	
	
	@RequestMapping(value = "/savepermission",method = RequestMethod.POST)
	public String savepermission(
			@RequestParam(required = true) String roleid,
			@RequestParam(required = false)String permissionid ) {
		List<Role_permission> role_permissionlist=new ArrayList<Role_permission>() ;
		if (permissionid!=null&&permissionid.length()>0){
			String[]  permissionids=permissionid.split(",");
			Role_permission  role_permis =null;
			for(String perid:permissionids){
				 role_permis =new Role_permission();
				role_permis.setRole_id(roleid);
				role_permis.setPermission_id(perid);
				role_permissionlist.add(role_permis);
			}
		}
		role_permissionService.addRole_permissionlistByRole(roleid, role_permissionlist); 
		return "redirect:/adminmgr/menu/"+ roleid+"/setpermission" ;
	}
}

