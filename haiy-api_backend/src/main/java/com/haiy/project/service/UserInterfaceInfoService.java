package com.haiy.project.service;

import com.haiy.project.model.entity.InterfaceInfo;
import com.haiy.project.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lhynb54
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-02-05 16:00:43
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
