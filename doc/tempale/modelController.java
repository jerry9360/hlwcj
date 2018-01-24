package {$packagename}.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.greenland.core.Message;
import com.greenland.core.controller.BaseController;
import {$packagename}.entity.{$table.upcode};
import {$packagename}.service.{$table.upcode}Service;

@Controller("{$table.code}Controller")
@RequestMapping("/{$packagelastname}/{$table.code}")
public class {$table.upcode}Controller extends BaseController {

	/** Error View */
	protected static final String ERROR_VIEW = "/common/error";

	/** Error Message */
	protected static final Message ERROR_MESSAGE = Message
			.error("{$packagelastname}.message.error");

	/** Success Message */
	protected static final Message SUCCESS_MESSAGE = Message
			.success("{$packagelastname}.message.success");

	private static final int PAGE_SIZE = 9;

	@Resource(name = "{$table.code}ServiceImpl")
	private {$table.upcode}Service {$table.code}Service;

	/**
	 * List
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@PageableDefault(page = 0, size = PAGE_SIZE) Pageable pageable,
			ModelMap model) {
		Page<{$table.upcode}> page = {$table.code}Service.findPage(pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/{$packagelastname}/{$table.code}/list";
	}

	/**
	 * EditList
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editlist(
			@PageableDefault(page = 0, size = PAGE_SIZE) Pageable pageable,
			ModelMap model) {
		Page<{$table.upcode}> page = {$table.code}Service.findPage(pageable);
		model.addAttribute("page", page);
		model.addAttribute("pageable", pageable);
		return "/{$packagelastname}/{$table.code}/listedit";
	}

	/**
	 * add
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String add(ModelMap model) {	
		{$table.upcode} {$table.code} = new {$table.upcode}();
		model.addAttribute("{$table.code}", {$table.code});
		return "/{$packagelastname}/{$table.code}/new";
	}

	/**
	 * save
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid {$table.upcode} {$table.code}, BindingResult bindingResult,
			ModelMap model,RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/{$packagelastname}/{$table.code}/new";
		}
		{$table.code}Service.save({$table.code});
		return "redirect:/{$packagelastname}/{$table.code}";
	}

	/**
	 * eidt
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, ModelMap model) {
		{$table.upcode} {$table.code} = {$table.code}Service.find(id);
		if ({$table.code} == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("{$table.code}", {$table.code});
		return "/{$packagelastname}/{$table.code}/edit";
	}

	/**
	 * update
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String update(@Valid {$table.upcode} {$table.code}, BindingResult bindingResult,
			@PathVariable String id, String companyId, ModelMap model,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/{$packagelastname}/{$table.code}/edit";
		}
		{$table.code}.setId(id);
		{$table.code}Service.update({$table.code});
		return "redirect:/{$packagelastname}/{$table.code}";
	}

	/**
	 * delete
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	String delete(@PathVariable String id) {
		{$table.code}Service.delete(id);
		return "redirect:/{$packagelastname}/{$table.code}";
	}

	/**
	 * show
	 */
	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	String show(@PathVariable String id, ModelMap model) {
		{$table.upcode} {$table.code} = {$table.code}Service.find(id);
		if ({$table.code} == null) {
			return "/common/resource_not_found";
		}
		model.addAttribute("{$table.code}", {$table.code});
		return "/{$packagelastname}/{$table.code}/show";
	}

}
