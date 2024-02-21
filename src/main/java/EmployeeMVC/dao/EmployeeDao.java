package EmployeeMVC.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import EmployeeMVC.dto.Employee;

public class EmployeeDao {

	@Autowired
	EntityManager em;
	
	public Employee saveEmployee(Employee emp) {
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.persist(emp);
		et.commit();
		return emp;
	}
	
	public Employee findEmployee(int id) {
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		em.getTransaction().commit();
		return emp;
	}
	
	public Employee deleteEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		if(emp!= null) {
		em.getTransaction().begin();
		em.remove(emp);
		em.getTransaction().commit();
		return emp;
		}
		return null;
	}
	
	public Employee updateEmployee(int id, Employee emp) {
		Employee exEmp = em.find(Employee.class, id);
		if(exEmp != null) 
		{
			emp.setEmployeeId(id);
			em.getTransaction().begin();
			Employee updateEmp = em.merge(emp);
			em.getTransaction().commit();
			return updateEmp;
		}
		return null;
	}
	
	public List<Employee> findAll(){
		Query query=em.createQuery("select e from Employee e");
		List<Employee> empList=query.getResultList();
		return empList;
	}
	
	public Employee findByEmail(String email) {
		Query query=em.createQuery("select e from Employee e where e.employeeEmail=?1");
		query.setParameter(1, email);
		return (Employee) query.getSingleResult();
	}
	
}
