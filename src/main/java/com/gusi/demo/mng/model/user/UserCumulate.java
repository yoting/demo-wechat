package com.gusi.demo.mng.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.gusi.demo.mng.model.base.BaseDataCube;

/**
 * 累计用户数据
 *
 * @author peiyu
 */
public class UserCumulate extends BaseDataCube {

    @JSONField(name = "cumulate_user")
    private Integer cumulateUser;

    public Integer getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }
}
