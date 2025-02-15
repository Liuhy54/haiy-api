package com.haiy.haiyapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haiy.haiyapicommon.model.entity.UserInterfaceInfo;

/**
* @author lhynb54
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-02-05 16:00:43
*/
public interface InnerUserInterfaceInfoService{


    /**
     * 检验接口剩余调用次数是否足够
     * @param interfaceInfoId
     * @return
     */
    boolean inspectLeftNum(long interfaceInfoId, long userId);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
