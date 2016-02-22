/**
 * Project Name:movie-recommender
 * File Name:ProdEigenVectorServiceImpl.java
 * Package Name:com.wx.movie.rec.eigenvector.service.impl
 * Date:2016年2月14日下午9:07:28
 *
*/

package com.wx.movie.rec.eigenvector.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wx.movie.rec.pojo.UserActionData;
import com.wx.movie.rec.eigenvector.service.ProdEigenVectorService;

/**
 * 生成特征向量服务
 */
@Service("prodEigenVector")
public class ProdEigenVectorServiceImpl implements ProdEigenVectorService{
  
  @Qualifier("bseUserEigVec")
  @Autowired
private ProdEigenVectorService bseUsrEigVecService;
  
  @Qualifier("bseMovieEigVec")
  @Autowired
private ProdEigenVectorService bseMovieEigVecService;
  
  @Override
  public void produceEigenVector(List<UserActionData> userActionDatas) {
    
    bseUsrEigVecService.produceEigenVector(userActionDatas);
    bseMovieEigVecService.produceEigenVector(userActionDatas);
    
  }

}
