package com.hhu.mlthfs.base;

import com.hhu.mlthfs.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected UserService userService;

    @Autowired
    protected RoleService roleService;

    @Autowired
    protected BasicinfoService basicinfoService;

    @Autowired
    protected ClimateIndexService climateIndexService;

    @Autowired
    protected ClimateNameService climateNameService;

    @Autowired
    protected RsvravRService rsvravRService;


    @Autowired
    protected RvavRService rvavRService;

    @Autowired
    protected MenuService menuService;

    @Autowired
    protected PlanInfoService planInfoService;

    @Autowired
    protected PlanAssessIndexService planAssessIndexService;

    @Autowired
    protected ForecastResultService forecastResultService;

    @Autowired
    protected SelectedFactorsService selectedFactorsService;

    @Autowired
    protected TrainResultService trainResultService;

    @Autowired
    protected TestResultService testResultService;

    @Autowired
    protected ForecastDataResultService forecastDataResultService;

    @Autowired
    protected ForecastReleaseResultService forecastReleaseResultService;

    @Autowired
    protected HistoryQDataService historyQDataService;


}
