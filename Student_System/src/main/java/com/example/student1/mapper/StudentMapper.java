package com.example.student1.mapper;

import com.example.student1.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    // 查询全部
    @Select("select * from student")
    public abstract List<Student> selectAll();

    // 添加学生
    @Insert("insert into student values(#{name}, #{age}, #{address}, #{numbersss})")
    public abstract void addStu(Student student);

    // 修改学生数据
    @Update("update student set name=#{name}, age=#{age}, address=#{address}, numbersss=#{numbersss} where name=#{name}")
    public abstract void updateStu(Student student);

    // 删除学生数据
    @Delete("delete from student where name=#{name}")
    public abstract void deleteStu(String name);
}