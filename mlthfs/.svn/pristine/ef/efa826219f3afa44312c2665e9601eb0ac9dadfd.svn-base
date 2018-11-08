package com.hhu.mlthfs.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.model.RvavR;
import com.hhu.mlthfs.mapper.RvavRDao;
import com.hhu.mlthfs.model.vo.WaterInfoVo;
import com.hhu.mlthfs.service.RvavRService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-08-02
 */
@Service
public class RvavRServiceImpl extends ServiceImpl<RvavRDao, RvavR> implements RvavRService {
    private static final Logger logger=  LoggerFactory.getLogger(RvavRServiceImpl.class);

    @Override
    public Page<WaterInfoVo> findWaterInfoListByMonth(Page<WaterInfoVo> page,String startTm,String endTm) {
        page.setRecords(baseMapper.findWaterInfoListByMonth(page,startTm,endTm));

        logger.info(page.toString());

        return page;
    }
}
