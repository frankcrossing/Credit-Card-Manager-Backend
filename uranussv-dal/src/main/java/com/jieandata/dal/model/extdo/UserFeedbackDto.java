package com.jieandata.dal.model.extdo;

import com.jieandata.service.annotation.SensitiveField;
import com.jieandata.service.annotation.SensitiveField.SensitiveTypeEnum;
import lombok.Data;

@Data
public class UserFeedbackDto {

    private Integer Id;

    private Integer userId;

    private String mobile;

    private String createTime;

    private String memo;
}
