package com.gusi.demo.mng.response;

import java.util.List;

import com.gusi.demo.mng.model.Group;

/**
 * 新建实体类Group，将id，name，count属性移动到Group实体中。本实体采用List封装Groups信息
 *
 * @author peiyu, Nottyjay
 *
 */
public class GetGroupsResponse extends BaseResponse {

	private List<Group> groups;

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
