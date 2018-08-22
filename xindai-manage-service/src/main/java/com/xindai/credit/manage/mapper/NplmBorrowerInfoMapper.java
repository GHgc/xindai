package com.xindai.credit.manage.mapper;

import com.xindai.credit.bean.NplmBorrowerInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NplmBorrowerInfoMapper extends Mapper<NplmBorrowerInfo> {

    // 查询所有借贷人的所有信息
    List<NplmBorrowerInfo> selectBorrowerAllInfo();

    // 分页查询所有合同的信息列表
//    List<NplmBorrowerInfo> getPageQuery(int pageNum,int rows);

    // 分页过滤查询   所有合同的信息列表
    List<NplmBorrowerInfo> getPageQuery(int pageNum,int rows,@Param("nplmBorrowerInfo") NplmBorrowerInfo nplmBorrowerInfo);

    // 查询数据的总条数
    int getTotal();
}
