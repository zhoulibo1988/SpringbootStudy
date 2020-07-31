package com.chigua.springboot.service.impl;
import com.chigua.springboot.entity.SysLog;
import com.chigua.springboot.mapper.SysLogMapper;
import com.chigua.springboot.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameSysLogServiceImpl
 * @Description
 * @Author Mr.Zhou
 * @Date2020/7/30 14:58
 * @Version V1.0
 **/
@Service("sysLogServiceImpl")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public void saveSysLog(SysLog syslog) {
        sysLogMapper.insert(syslog);
    }
}
