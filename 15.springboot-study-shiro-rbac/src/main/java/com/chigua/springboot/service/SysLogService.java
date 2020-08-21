package com.chigua.springboot.service;

import com.chigua.springboot.entity.SysLog;

/**
 * ProjectName: springboot-study-aop
 * ClassName: com.chigua.springboot.service.SysLogService
 *
 * @author Mr.zhou <ijiami.cn>
 * @description aop 户操作日志
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/07/30 - 14:56
 */
public interface SysLogService {
    /**
     * 保存用户操作日志
     * @param syslog
     * @return void
     * @author Mr.zhou
     * @date 2020-07-30
     */
    void saveSysLog(SysLog syslog);
}
