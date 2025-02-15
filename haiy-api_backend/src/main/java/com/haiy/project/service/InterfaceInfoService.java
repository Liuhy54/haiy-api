package com.haiy.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haiy.haiyapicommon.model.entity.InterfaceInfo;

/**
* @author lhynb54
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-01-22 21:45:05
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
