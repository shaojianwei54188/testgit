package com.hhu.mlthfs.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.model.RvavR;
import com.baomidou.mybatisplus.service.IService;
import com.hhu.mlthfs.model.vo.WaterInfoVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HHU
 * @since 2018-08-02
 */
public interface RvavRService extends IService<RvavR> {



    Page<WaterInfoVo> findWaterInfoListByMonth(Page<WaterInfoVo> page,String startTm,String endTm);
}
