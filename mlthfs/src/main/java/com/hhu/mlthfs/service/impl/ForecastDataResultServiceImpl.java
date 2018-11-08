package com.hhu.mlthfs.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hhu.mlthfs.model.ForecastDataResult;
import com.hhu.mlthfs.mapper.ForecastDataResultDao;
import com.hhu.mlthfs.model.vo.ForecastDepartureVo;
import com.hhu.mlthfs.service.ForecastDataResultService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-10-24
 */
@Service
public class ForecastDataResultServiceImpl extends ServiceImpl<ForecastDataResultDao, ForecastDataResult> implements ForecastDataResultService {

    @Override
    public Page<ForecastDepartureVo> selectForecastDepartureByTimeAndSection(Page<ForecastDepartureVo> page, String ForecastTimeStart, String ForecastSection, Wrapper<ForecastDepartureVo> wrapper) {
        page.setRecords(baseMapper.findForecastDepartureByTimeAndSection(page,ForecastTimeStart,ForecastSection,wrapper));

        return page;
    }
}
