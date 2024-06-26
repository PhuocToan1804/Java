package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietHoaDon;
import util.HibernateUtil;

public class ChiTietHoaDonDAO implements DAOInterface<ChiTietHoaDon> {

	@Override
	public List<ChiTietHoaDon> selectAll() {
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from ChiTietHoaDon c";
				Query query = session.createQuery(hql);
				listChiTietHoaDon = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listChiTietHoaDon;
	}

	@Override
	public ChiTietHoaDon selectById(ChiTietHoaDon t) {
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from ChiTietHoaDon c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listChiTietHoaDon = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (listChiTietHoaDon.size() > 0) {
			return listChiTietHoaDon.get(0);
		} else
			return null;
	}

	public List<ChiTietHoaDon> selectByIdList(ChiTietHoaDon t) {
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				String hql = "from ChiTietHoaDon c where c.id =: id";
				Query query = session.createQuery(hql);
				query.setParameter("id", t.getId());
				listChiTietHoaDon = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return listChiTietHoaDon;
	}

	@Override
	public boolean insert(ChiTietHoaDon t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				// Thực thi câu lệnh HQL
				// Chỉ lưu khi chưa tồn tại
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
	public boolean update(ChiTietHoaDon t) {
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
	public boolean delete(ChiTietHoaDon t) {
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
	public ChiTietHoaDon selectByIdString(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ChiTietHoaDon> searchByCriteria(String criteria) {
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();

				String hql = "from ChiTietHoaDon c where cast(c.id as string) like :criteria or c.maSach like :criteria or cast(c.soLuong as string) like :criteria or cast(c.gia as string) like :criteria";
				Query query = session.createQuery(hql);
				query.setParameter("criteria", "%" + criteria + "%");
				listChiTietHoaDon = query.getResultList();
				tr.commit();
				session.close();
			} else {
				System.out.println("Ket noi that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listChiTietHoaDon;
	}

}
