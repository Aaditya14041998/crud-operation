package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	// List<Course> list;

	public CourseServiceImpl() {

//		list = new ArrayList<>();
//		list.add(new Course(145, "core java", "lecture 1"));
//		list.add(new Course(125, "MySql", "lecture 2"));

	}

	@Override
	public List<Course> getCourses() 
	{
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);

	}

	@Override
	public Course addCourse(Course course) {
		// list.add(course);

		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});

		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// list = this.list.stream().filter(e -> e.getId() !=
		// parseLong).collect(Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);

	}

}
