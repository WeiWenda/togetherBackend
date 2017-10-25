package com.together.vivid.service.impl;

import com.together.vivid.dao.ActivityDao;
import com.together.vivid.dao.ParticipateDao;
import com.together.vivid.dto.ParticipateStateEnum;
import com.together.vivid.entity.Activity;
import com.together.vivid.entity.Participate;
import com.together.vivid.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weiwenda on 2017/9/28.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ParticipateDao participate;
    @Autowired
    ActivityDao activityDao;

    public ParticipateStateEnum addParticipate(int user_id, int activity_id) {
        Participate tmp =  participate.queryByAIUI(user_id,activity_id);
        if(tmp==null){
            participate.saveParticipate(new Participate(user_id,activity_id,ParticipateStateEnum.NOTICE.getState()));
            return ParticipateStateEnum.NOTICE;
        }
        else if(ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.ABSENT
                || ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.ABNORMAL){
            participate.updateParticipate(user_id,activity_id,ParticipateStateEnum.SUCCESS.getState());
            return ParticipateStateEnum.SUCCESS;
        }else if(ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.SUCCESS){
            return ParticipateStateEnum.REPEATED;
        }else if(ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.NOTICE){
            return ParticipateStateEnum.NOTICE;
        }
        return ParticipateStateEnum.ABNORMAL;
    }

    public List<Participate> getParticipators(int activity_id) {
        return participate.queryById(activity_id);
    }

    public ParticipateStateEnum signUp(int user_id, int activity_id) {
        Participate tmp =  participate.queryByAIUI(user_id,activity_id);
        if(tmp==null){
            participate.saveParticipate(new Participate(user_id,activity_id,ParticipateStateEnum.ABSENT.getState()));
            return ParticipateStateEnum.SUCCESSSIGN;
        }else if(ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.ABSENT
                || ParticipateStateEnum.stateOf(tmp.getState())==ParticipateStateEnum.ABNORMAL){
            return ParticipateStateEnum.REPEATEDSIGN;
        }
        return ParticipateStateEnum.ABNORMAL;
    }

    @Override
    public void saveActivity(Activity activity) {
        activityDao.saveActivity(activity);
    }

    @Override
    public void removeActivity(int activity_id) {
        activityDao.removeActivity(activity_id);

    }
}
