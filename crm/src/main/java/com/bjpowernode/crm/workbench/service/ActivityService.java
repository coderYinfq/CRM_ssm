package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Activity;
import com.sun.tools.internal.ws.wsdl.parser.AbstractReferenceFinderImpl;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

/**
 * @项目名：crm-project
 * @创建人： Administrator
 * @创建时间： 2020-05-23
 * @公司： www.bjpowernode.com
 * @描述：
 */
public interface ActivityService {
    int saveCreateActivity(Activity activity);

    List<Activity> queryActivityForPageByCondition(Map<String,Object> map);

    long queryCountOfActivityByCondition(Map<String,Object> map);

    Activity queryActivityById(String id);

    int saveEditActivity(Activity activity);

    int deleteActivityByIds(String[] ids);

    List<Activity> queryAllActivityForDetail();

    List<Activity> queryActivityForDetailByIds(String[] ids);

    int saveCreateActivityByList(List<Activity> activityList);

    Activity queryActivityForDetailById(String id);

    List<Activity> queryActivityForDetailByClueId(String clueId);

    List<Activity> queryActivityForDetailByNameClueId(Map<String,Object> map);

    List<Activity> queryActivityForDetailByName(String name);
}
