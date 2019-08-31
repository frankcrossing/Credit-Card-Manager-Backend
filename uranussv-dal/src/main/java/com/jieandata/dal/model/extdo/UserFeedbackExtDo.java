package com.jieandata.dal.model.extdo;
import lombok.Data;

@Data
public class UserFeedbackExtDo {

    private Integer Id;

    private Integer userId;

    private Long mobile;

    private Integer createTime;

    private String memo;
}
