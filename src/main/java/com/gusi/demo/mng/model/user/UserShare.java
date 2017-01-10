package com.gusi.demo.mng.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.gusi.demo.mng.model.BaseDataCube;

/**
 * @author peiyu
 */
public class UserShare extends BaseDataCube {

    @JSONField(name = "share_scene")
    private Integer shareScene;
    @JSONField(name = "share_count")
    private Integer shareCount;
    @JSONField(name = "share_user")
    private Integer shareUser;

    public Integer getShareScene() {
        return shareScene;
    }

    public void setShareScene(Integer shareScene) {
        this.shareScene = shareScene;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getShareUser() {
        return shareUser;
    }

    public void setShareUser(Integer shareUser) {
        this.shareUser = shareUser;
    }
}
