package com.xindai.credit.service;

import com.xindai.credit.bean.NplmBorrowerInfo;

import java.util.List;

public interface NplmBorrowerInfoService {

    // 获取所有借款人的信息列表
    List<NplmBorrowerInfo> getAllBorrower();
}
