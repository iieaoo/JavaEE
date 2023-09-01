package com.example.springbootdemo4.mapper;

import com.example.springbootdemo4.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.example.springbootdemo4.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/26 15:39
 * Version 1.0
 */
@Mapper
public interface UserMapper {
    /*
        根据用户 id 查询用户信息
        @param userId
        @return
     */
    Userinfo getUserById(@Param("user_id") Integer id);

    List<Userinfo> getUserByName(@Param("username") String username);
    /*
    * 查询全部
    *
    * @return
    */
    List<Userinfo> getAll();
    /*
    * 添加用户对象
    *
    * @param userinfo
    * @return
    */
    int add(Userinfo userinfo);
    /*
    * 添加用户并返回用户 Id
    *
    * @param userinfo
    * @return
    */
    int addGetId(Userinfo userinfo);
    /*
    * 修改用户
    * @param userinfo
    * @return
    */
    int upUserName(Userinfo userinfo);
    /*
     * 删除用户
     * @param userinfo
     * @return
     */
    int delById(@Param("id") Integer id);
    /*
     * 按id顺序打印
     * @param userinfo
     * @return
     */
    List<Userinfo> getListByOrder(@Param("order") String order);
    /*
     *
     * @param userinfo
     * @return
     */
    Userinfo login(@Param("username") String username,
                   @Param("password") String password);

    List<Userinfo> getListByName(@Param("username") String username);

    int add2(Userinfo userinfo);

    int add3(Userinfo userinfo);

    List<Userinfo> getListByParam(String username, String password);

    int update2(Userinfo userinfo);

    int delts(List<Integer> ids);

}
