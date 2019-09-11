package com.springboot.bcode.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bcode.dao.IRightDao;
import com.springboot.bcode.domain.auth.Permission;
import com.springboot.core.jdbc.BaseDaoImpl;

@Repository
public class RightDao extends BaseDaoImpl implements IRightDao {

	@Override
	public List<Permission> selectAll() {
		String sql = "SELECT id,name, parent_id as parentId,types,css,url,levels ,description,sorts,dataScope from t_web_right order by sorts asc";
		return super.find(sql, new Object[] {}, Permission.class);
	}

	@Override
	public List<Permission> selectByRoleCode(Integer roleCode) {
		String sql = "SELECT r.id,r.name, r.parent_id as parentId,r.types,r.css,r.url,r.levels ,r.description,r.sorts,r.dataScope  from t_web_role_right rr inner join t_web_right r on rr.right_id=r.id where rr.role_id=? order by r.sorts asc";
		return super.find(sql, new Object[] { roleCode }, Permission.class);
	}

	@Override
	public int insert(Permission right) {
		return super.insert(right);
	}

	@Override
	public int update(Permission right) {
		return super.update(right);
	}

	@Override
	public int delete(Permission right) {
		return super.delete(right);
	}

	@Override
	public List<Permission> find(Permission right) {
		return super.find(right);
	}

	@Override
	public List<Permission> findChild(Integer parentCode) {
		String sql = "SELECT id,name, parent_id as parentId,types,css,url,levels,sorts,dataScope,(SELECT top 1 tmp1.name  FROM t_web_right as tmp1 WHERE tmp1.parent_id=r.id )  as tmpChildName from t_web_right r where r.parent_id=? order by sorts asc ";
		return super.find(sql, new Object[] { parentCode }, Permission.class);
	}

	@Override
	public Permission select(Integer id) {
		return super.findById(id, Permission.class);
	}
}
