package xiaowang.test;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class ceshi {
    public static void main(String[]args){
        Configuration configuration =new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

//        CarEntity carEntity = (CarEntity) session.get(CarEntity.class,1);
//        String name =carEntity.getName();
//        System.out.println(name);
//
//        String sql=" from CarEntity where id=:id";
//        Query query=session.createQuery(sql);
//        query.setParameter("id",1);
//        List list = query.list();
//        Iterator iterator=list.iterator();
//        while(iterator.hasNext()){
//            carEntity= (CarEntity) iterator.next();
//            name=carEntity.getName();
//            System.out.println(name);
//        }
//
//        CarEntity carEntity1= (CarEntity) session.load(CarEntity.class,1);
//        name=carEntity1.getName();
//        System.out.println(name);

//        for(int i=0;i<100;i++)
//        {
//            Transaction transaction =session.beginTransaction();
//            CarEntity carEntity2 =new CarEntity();
//
//            carEntity2.setName(i+""+i);
//
//            session.save(carEntity2);
//            transaction.commit();
//            session.clear();
//        }
//        Query query =session.createQuery("select count(1) from CarEntity");
//        List list =query.list();
//        Iterator iterator=list.iterator();
//
//        Long aLong = (Long) iterator.next();
//
//        System.out.println(aLong);
//
        Criteria criteria =session.createCriteria(CarEntity.class);
        criteria.setFirstResult(2);
        criteria.setMaxResults(1);

        List list1 =criteria.list();
        Iterator iterator1=list1.iterator();

        CarEntity carEntity=null;
        while(iterator1.hasNext()) {
             carEntity = (CarEntity) iterator1.next();

            System.out.println(carEntity.getId() + " " + carEntity.getName());

        }

//        Transaction transaction=session.beginTransaction();
        carEntity.setName("sTest");
        session.update(carEntity);

//        transaction.commit();

//        session.flush();
        session.clear();

        session.evict(carEntity);
        int carid =carEntity.getId();
        CarEntity carEntity1 = (CarEntity) session.get(CarEntity.class,carid);

        String string = carEntity1.getName();
        System.out.println(carid+"  "+string);

        session.close();
        sessionFactory.close();

    }
}
