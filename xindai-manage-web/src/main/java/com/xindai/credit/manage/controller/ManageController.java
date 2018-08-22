package com.xindai.credit.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.xindai.credit.bean.NplmBorrowerInfo;
import com.xindai.credit.service.NplmBorrowerInfoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {
    private static final Logger LOGOGER = Logger.getLogger(ManageController.class);
    @Reference
    private NplmBorrowerInfoService nplmBorrowerInfoService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    // 合同列表
    @RequestMapping("contractListPage")
    public String contractListPage(){
        return "contractListPage";
    }


    // 查询数据
    @RequestMapping("pageQuery")
    @ResponseBody
    public Map<String,Object> getPageQuery(  HttpServletRequest request){

        // 过滤查询
        String clientName = request.getParameter("clientName");
        NplmBorrowerInfo nplmBorrowerInfo = new NplmBorrowerInfo();
        nplmBorrowerInfo.setClientName(clientName);

        // 从前台获取数据
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        int pageSize = rows;
        int pageNum = (page-1)*rows;

        int total = nplmBorrowerInfoService.getCount();



        List<NplmBorrowerInfo> borrowerList = nplmBorrowerInfoService.getPageQuery(pageNum, rows,nplmBorrowerInfo);

        Map map = new HashMap<>();
        map.put("total",total);
        map.put("rows",borrowerList);

        System.out.println(JSON.toJSONString(map));
        return map;
    }


    // 放款列表
    @RequestMapping("loanList")
    public String loanList(){
        return "loanList";
    }
    // 前期费用列表
    @RequestMapping("upfrontFeeList")
    public String upfrontFeeList(){
        return "upfrontFeeList";
    }
    // 费用明细列表
    @RequestMapping("costDetailList")
    public String costDetailList(){
        return "costDetailList";
    }
    // 正常待还款
    @RequestMapping("ForReimbursement")
    public String ForReimbursement(){
        return "ForReimbursement";
    }
    // 逾期列表
    @RequestMapping("overdueList")
    public String overdueList(){
        return "overdueList";
    }
    // 违约沟通
    @RequestMapping("breakAContract")
    public String breakAContract(){
        return "breakAContract";
    }
    // 已还款列表
    @RequestMapping("HasBeenPaymentList")
    public String HasBeenPaymentList(){
        return "HasBeenPaymentList";
    }
    // 扣款结果
    @RequestMapping("processingResults")
    public String processingResults(){
        return "processingResults";
    }
    // 信托扣款明细查询
    @RequestMapping("deductionsDetail")
    public String deductionsDetail(){
        return "deductionsDetail";
    }


    // 查看还款情况
    @RequestMapping("checkRepayment")
    public String checkRepayment(){
        return "common/checkRepayment";
    }
    // 修改还款情况
    @RequestMapping("modificationOfRepayment")
    public String modificationOfRepayment(){
        return "common/modificationOfRepayment";
    }
}
