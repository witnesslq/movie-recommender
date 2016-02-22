package com.wx.movie.rec.eigenvector.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.wx.movie.rec.eigenvector.service.ProdEigenVectorService;
import com.wx.movie.rec.pojo.UserActionData;
import com.wx.movie.rec.similarity.service.ProdSimilarityService;

/**
 * 生成基于用户推荐方法使用的特征向量
 * 
 * 本来UserActionData 中Map集合中的 key是 用户id value:表示用户操作的影片集合，
 * 如果要基于用户推荐的话 需要将Map集合的key换成 影片no 表示的是操作影片的用户集合
 * 
 */
@Service("bseUserEigVec")
public class ProdEigVecBseUserServiceImpl implements ProdEigenVectorService {
  
  @Qualifier("bseUsrSimilarity")
  @Autowired
  private ProdSimilarityService bseMovieSimilarityService;
  
  private Logger logger = LoggerFactory.getLogger(ProdEigVecBseUserServiceImpl.class);

  @Override
  @Async("prodEigenVectorExecutor")
  public void produceEigenVector(List<UserActionData> userActionDatas) {
   //调用上一层 计算相似度
    bseMovieSimilarityService.prodSimilarity(userActionDatas.get(0));
  }
}
