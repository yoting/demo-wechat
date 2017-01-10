package com.gusi.demo.mng.response;

import com.gusi.demo.mng.model.Group;

/**
 * @author peiyu
 */
public class CreateGroupResponse extends BaseResponse {

	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
