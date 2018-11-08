package com.hhu.mlthfs.service.impl;

import com.hhu.mlthfs.model.ClimateName;
import com.hhu.mlthfs.mapper.ClimateNameDao;
import com.hhu.mlthfs.service.ClimateNameService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hhu.mlthfs.utils.LayerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HHU
 * @since 2018-07-24
 */
@Service
public class ClimateNameServiceImpl extends ServiceImpl<ClimateNameDao, ClimateName> implements ClimateNameService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public List<ClimateName> findAllClimateName() {

        logger.info(baseMapper.findAllClimateName().toString());
        return baseMapper.findAllClimateName();
    }
}
