package com.easycar.controller;

import com.easycar.entity.bean.IndexData;
import com.easycar.entity.querybean.*;
import com.easycar.entity.querybean.OrdersQuery;
import com.easycar.entity.vo.ResponseVO;
import com.easycar.service.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController("allData")
@RequestMapping("/allData")
public class AllDataController extends ABaseController{
    @Resource
   private AppUserInfoService appUserInfoService;
    @Resource
    private DriverService driverService;
    @Resource
   private OrdersService ordersService;
    @Resource
    private VehicleService vehicleService;
    @Resource
    private RetucarService retucarService;
    @RequestMapping("/loadData")
    public ResponseVO loadDataList(){
        AppUserInfoQuery aq=new AppUserInfoQuery();
        DriverQuery dq=new DriverQuery();
        RetucarQuery rq=new RetucarQuery();
        OrdersQuery oq=new OrdersQuery();
        VehicleQuery vq=new VehicleQuery();
        Integer countforappuser = appUserInfoService.findCountByParam(aq);
        Integer countfordriver = driverService.findCountByParam(dq);
        Integer countfororders = ordersService.findCountByParam(oq);
        Integer countforvehicle = vehicleService.findCountByParam(vq);
        Integer countforrecar = retucarService.findCountByParam(rq);
        IndexData indexDataforuser= new IndexData("App用户数",countforappuser);
        IndexData indexDatafordriver= new IndexData("系统司机数",countfordriver);
        IndexData indexDatafororders= new IndexData("总订单数",countfororders);
        IndexData indexDataforvehicle= new IndexData("系统车辆数",countforvehicle);
        IndexData indexDataforrecar= new IndexData("租赁记录数",countforrecar);
        List<IndexData> list=new ArrayList<>();
        list.add(indexDataforuser);
        list.add(indexDatafordriver);
        list.add(indexDatafororders);
        list.add(indexDataforvehicle);
        list.add(indexDataforrecar);
        return getSuccessResponseVO(list);
    }

}
