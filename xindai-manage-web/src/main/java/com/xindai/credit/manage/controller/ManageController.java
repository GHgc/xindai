package com.xindai.credit.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xindai.credit.service.NplmBorrowerInfoService;
import com.xindai.credit.bean.NplmBorrowerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ManageController {

    @Reference
    private NplmBorrowerInfoService nplmBorrowerInfoService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    // 合同列表
    @RequestMapping("contractListPage")
    public String contractListPage(HttpServletRequest request){
        /**
         * 取出三张表中的信息
         * 以   nplm_borrower_info              '客户_借款人信息'   为主
         *          NplmBorrowerInfo
         *
         *      NPLM_loan_contract              '合同_贷款合同表'
         *          NplmLoanContract
         *
         *      nplm_contract_attribute         '合同_合同属性表'
         *          NplmContractAttribute
         */
        // 取得贷款人的所有信息
        List<NplmBorrowerInfo> borrowerList = nplmBorrowerInfoService.getAllBorrower();


        request.setAttribute("borrowerList",borrowerList);

        return "contractListPage";
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
