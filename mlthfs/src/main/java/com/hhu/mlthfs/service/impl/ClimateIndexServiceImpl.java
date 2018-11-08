package com.hhu.mlthfs.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hhu.mlthfs.mapper.ClimateIndexDao;
import com.hhu.mlthfs.model.ClimateIndex;
import com.hhu.mlthfs.model.vo.ClimateIndexVO;
import com.hhu.mlthfs.service.ClimateIndexService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-07-26
 */
@Service
public class ClimateIndexServiceImpl extends ServiceImpl<ClimateIndexDao, ClimateIndex> implements ClimateIndexService {


    @Override
    public Page<ClimateIndexVO> selectClimateIndexListByTime(Page<ClimateIndexVO> page, String tm, Wrapper<ClimateIndexVO> wrapper) {
        page.setRecords(baseMapper.findClimateIndexListByTime(page,tm,wrapper));
        return page;
    }
}
