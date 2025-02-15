package com.haiy.project.service.impl.inner;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haiy.haiyapicommon.model.entity.UserInterfaceInfo;
import com.haiy.haiyapicommon.service.InnerUserInterfaceInfoService;
import com.haiy.project.common.ErrorCode;
import com.haiy.project.exception.BusinessException;
import com.haiy.project.mapper.UserInterfaceInfoMapper;
import com.haiy.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public boolean inspectLeftNum(long interfaceInfoId, long userId) {
        // 校验
        if (interfaceInfoId <= 0||userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 查询接口信息
        QueryWrapper<UserInterfaceInfo> inquireWrapper = new QueryWrapper<>();
        inquireWrapper.eq("interfaceInfoId", interfaceInfoId);
        inquireWrapper.eq("userId", userId);
        UserInterfaceInfo interfaceInfo = userInterfaceInfoMapper.selectOne(inquireWrapper);
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口不存在");
        }
        return interfaceInfo.getLeftNum() > 0;
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
