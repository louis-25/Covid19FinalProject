package com.multi.covid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.covid.domain.LiveVO;
import com.multi.covid.domain.ResultVO;
import com.multi.covid.mapper.ChartMapper;

@Service
public class ChartServiceImpl implements ChartService {
	@Autowired
	private ChartMapper chartMapper;
	
	@Override
	public List<ResultVO> get7DaysResult(String location) {
		List<ResultVO> sqlResult = chartMapper.get7DaysResult(location);
		
		for(int i = 0; i < 7; i++) {
			sqlResult.get(i).setResult_date(sqlResult.get(i).getResult_date().substring(5));
		}
		
		return sqlResult;
	}
	
	@Override
	public List<ResultVO> get4WeeksResult(String location) {
		List<ResultVO> sqlResult = chartMapper.get4WeeksResult(location);

		List<ResultVO> returnList = new ArrayList<ResultVO>();
		for (int i = 0; i < 4; i++) {
			ResultVO temp = new ResultVO();
			temp.setResult_date(sqlResult.get(0).getResult_date().substring(5));
			temp.setLocation(sqlResult.get(0).getLocation());
			for (int j = 0; j < 7; j++) {
				temp.setIncrement_count(temp.getIncrement_count() + sqlResult.get(0).getIncrement_count());
				if (j == 6) {
					temp.setResult_date(temp.getResult_date() + " ~ " + sqlResult.get(0).getResult_date().substring(5));
					temp.setTotal_count(sqlResult.get(0).getTotal_count());
				}
				sqlResult.remove(0);
			}
			returnList.add(temp);
		}
		return returnList;
	}
	
	@Override
	public List<ResultVO> get12MonthsResult(String location) {
		List<ResultVO> sqlResult = chartMapper.get12MonthsResult(location);
		
		return sqlResult;
	}

	@Override
	public LiveVO getOneLive(String date) {
		// TODO Auto-generated method stub
		return null;
	}
}
