package com.centit.hlwyw.shiro.security;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import com.centit.hlwyw.account.entity.Permission;
import com.centit.hlwyw.account.entity.Principal;
import com.centit.hlwyw.account.entity.User;
import com.centit.hlwyw.account.service.PermissionService;
import com.centit.hlwyw.account.service.UserService;

/**
 * The Spring/Hibernate sample application's one and only configured Apache
 * Shiro Realm.
 * 
 * <p>
 * Because a Realm is really just a security-specific DAO, we could have just
 * made Hibernate calls directly in the implementation and named it a
 * 'HibernateRealm' or something similar.
 * </p>
 * 
 * <p>
 * But we've decided to make the calls to the database using a UserDAO, since a
 * DAO would be used in other areas of a 'real' application in addition to here.
 * We felt it better to use that same DAO to show code re-use.
 * </p>
 */

public class LoginRealm extends AuthorizingRealm {

	@Resource(name = "userServiceImpl")
	private UserService userService;

	@Resource(name = "permissionServiceImpl")
	private PermissionService permissionService;

	@Resource(name = "passwordHelper")
	private PasswordHelper passwordHelper;

	public LoginRealm() {
		setName("LoginRealm");
		// setCredentialsMatcher(new AllowAllCredentialsMatcher());
	}

	// 认证信息，主要针对用户登录，（下文讲述在action或者controller登录过程代码）
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		RoleUsernamePasswordToken token = (RoleUsernamePasswordToken) authcToken;
		String username = (String) token.getUsername();
		if (username == null) {
			throw new UnknownAccountException();
		}

		User user = userService.findByLoginname(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if ("1".equals(user.getIsvaild())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		//用来标记已登录
		Principal principal = new Principal(user.getId(), user.getLoginname(),
				user.getUsername());
		principal.setRoles(user.getRoles());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				principal, 
				user.getPassword(), 
				ByteSource.Util.bytes(user.getSalt()), 
				getName());
		return authenticationInfo;
	}

	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Principal principal = (Principal) principals.getPrimaryPrincipal();
		System.out.println("----授权----");
		if (principal == null) {
			return null;
		}
		String id = principal.getId();
		User user = null;
		if (id != null) {
			user = userService.find(id);
		}
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			Set<Role> roles = user.getRoles();
//			for (Role r : roles) {
//				info.addRole(r.getRolecode());
//			}
//			List<Permission> permissions = permissionService
//					.findUserPermissions(principal.getId());
//			addPermissions(info, permissions);
			return info;
		} else {
			return null;
		}
	}

	private void addPermissions(SimpleAuthorizationInfo info,
			List<Permission> permissions) {
		List<String> authorities = new ArrayList<String>();

		for (Permission permission : permissions) {
			if (StringUtils.isEmpty(permission.getPermission())) {
				authorities.add(permission.getValue());
			} else {
				authorities.add(getValue(permission.getPermission(),
						"perms\\[(.*?)\\]"));
			}
		}
		info.addStringPermissions(authorities);

	}

	private String getValue(String permission, String regex) {
		if (permission == null) {
			return null;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(permission);

		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return permission;
		}

		// return null;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}



}
