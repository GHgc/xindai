package com.xindai.credit.manage.mapper;

import com.xindai.credit.bean.NplmBorrowerInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NplmBorrowerInfoMapper extends Mapper<NplmBorrowerInfo> {

    // 查询所有借贷人的所有信息
    List<NplmBorrowerInfo> selectBorrowerAllInfo();
}
