package com.optimus.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimus.dao.OperatorMapper;
import com.optimus.entity.Operator;



/**
 * shiro重写验证类
 * @author Dongchuang
 *
 */
@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm{
	
	@Autowired
	private OperatorMapper operatorMapper;

	public MonitorRealm() {
		super();
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		Set<String> roles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();

		roles.add("admin");
		permissions.add("login.do?main");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setStringPermissions(permissions);
		info.setRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Operator user = operatorMapper.selectByPhone(token.getUsername(), "'0','1'");
		if (user == null) {
			throw new UnknownAccountException("No account found for user ["
					+ token.getUsername() + "]");
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUsername(), user.getPasswd(), getName());
		return authenticationInfo;
	}

	public void clearCachedAuthorizationInfo(String principal) {

		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}
}
