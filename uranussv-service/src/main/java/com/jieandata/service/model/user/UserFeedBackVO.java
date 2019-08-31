package com.jieandata.service.model.user;

import com.jieandata.service.annotation.SensitiveField;
import com.jieandata.service.annotation.SensitiveField.SensitiveTypeEnum;
import lombok.Data;

@Data
public class UserFeedBackVO {

    private Integer Id;

    private Integer userId;
    /**
     * 手机号
     */
    @SensitiveField(type = SensitiveTypeEnum.MP)
    private String mobile;

    /**
     * 时间
     */
    private String createTime;

    /**
     * 留言
     */
    private String memo;

    public UserFeedBackVO(Integer Id, Integer userId, String mobile,
                     String time, String memo) {
        this.Id = Id;
        this.userId = userId;
        this.mobile = mobile;
        this.createTime = time;
        this.memo = memo;
    }

    public UserFeedBackVO() {

    }
}
