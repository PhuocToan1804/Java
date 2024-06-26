package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.NhanVien;
import util.HibernateUtil;

public class nhanVienDAO implements DAOInterface<NhanVien> {

	@Override
	public List<NhanVien> selectAll() {
		List<NhanVien> listNhanVien = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from NhanVien c";
				Query query = session.createQuery(hql);
				listNhanVien = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listNhanVien;
	}

	@Override
	public NhanVien selectById(NhanVien t) {
		List<NhanVien> listNhanVien = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from NhanVien c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listNhanVien = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listNhanVien.size() > 0) {
			return listNhanVien.get(0);
		}
		else return null;
	}

	
	
	@Override
	public boolean insert(NhanVien t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				//Chỉ lưu khi chưa tồn tại
				session.save(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}
	
	@Override
	public boolean update(NhanVien t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				session.update(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(NhanVien t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				session.delete(t);
				tr.commit();
				session.close();
				return true;
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return false;
	}
	
	@Override
	public NhanVien selectByIdString(String id) {
	    NhanVien nhanVien = null;
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            // Thực thi câu lệnh HQL
	            String hql = "from NhanVien nv where nv.id = :id";
	            Query query = session.createQuery(hql);
	            query.setParameter("id", id);
	            List<NhanVien> resultList = query.getResultList();
	            tr.commit();
	            session.close();
	            if (!resultList.isEmpty()) {
	                nhanVien = resultList.get(0);
	            }
	        } else {
	            System.out.println("Kết nối thất bại");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return nhanVien;
	}
	public List<NhanVien> searchByCriteria(String criteria) {
	    List<NhanVien> listNhanVien = new ArrayList();
	    try {
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            Transaction tr = session.beginTransaction();
	            
	            String hql = "from NhanVien c where c.id like :criteria or c.hoTen like :criteria or c.gioiTinh like :criteria or c.viTri like :criteria or c.sdt like :criteria";
	            Query query = session.createQuery(hql);
	            query.setParameter("criteria", "%" + criteria + "%");
	            listNhanVien = query.getResultList();
	            tr.commit();
	            session.close();
	        } else {
	            System.out.println("Ket noi that bai");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listNhanVien;
	}


}
