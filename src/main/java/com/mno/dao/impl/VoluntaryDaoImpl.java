/**
 * FileName: VoluntaryDaoImpl
 * Author:   10418
 * Date:     2020-01-05 20:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 楠楠(Nannan))
 */
package com.mno.dao.impl;

import com.mno.dao.BaseDao;
import com.mno.dao.VoluntaryDao;
import com.mno.model.Voluntary;

/**
 * DESC〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 10418
 * @create 2020-01-05
 * @since 1.0.0
 */
public class VoluntaryDaoImpl extends BaseDao<Voluntary> implements VoluntaryDao {
    @Override
    public Voluntary getOneByUserId(int userId) {
        Voluntary oneData = getOneData("select * from voluntary where userId=?", userId);
        return oneData;

    }

    @Override
    public boolean insertOne(Voluntary voluntary) {
        int iud = iud("insert into voluntary(userId,status) values(?,?)", voluntary.getUserId(), voluntary.getStatus());
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateOne(Voluntary voluntary) {
        int iud = iud("update voluntary set status=?,speciality1=?,speciality2=?,speciality3=?,speciality4=?,speciality5=?,speciality6=?,speciality7=?,speciality8=?,speciality9=?,speciality10=?,speciality11=?,speciality12=?,speciality13=?,speciality14=?,speciality15=?,speciality16=?,speciality17=?,speciality18=?,speciality19=?,speciality20=? where userId=?",
                "已填报", voluntary.getSpeciality1(), voluntary.getSpeciality2(), voluntary.getSpeciality3(), voluntary.getSpeciality4(), voluntary.getSpeciality5(), voluntary.getSpeciality6(), voluntary.getSpeciality7(), voluntary.getSpeciality8(), voluntary.getSpeciality9(), voluntary.getSpeciality10(), voluntary.getSpeciality11(), voluntary.getSpeciality12(), voluntary.getSpeciality13(), voluntary.getSpeciality14(), voluntary.getSpeciality15(), voluntary.getSpeciality16(), voluntary.getSpeciality17(), voluntary.getSpeciality18(), voluntary.getSpeciality19(), voluntary.getSpeciality20(), voluntary.getUserId());
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean submit(int userId) {
        int iud = iud("update voluntary set status='已提交' where userId=?", userId);
        if (iud > 0) {
            return true;
        } else {
            return false;
        }
    }
}
