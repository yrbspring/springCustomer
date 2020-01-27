package com.yubi.spring.service;

import com.yubi.spring.dao.CustomerDaoRepository;
import com.yubi.spring.dao.CustomerMongoDao;
import com.yubi.spring.dao.entity.CustomerDocument;
import com.yubi.spring.dao.entity.CustomerEntity;
import com.yubi.spring.service.impl.CustService;
import com.yubi.spring.vo.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustServiceImpl implements CustService {
    @Autowired
    private CustomerDaoRepository customerDaoRepository;

    @Autowired
    private CustomerMongoDao customerMongoDao;

    @Override
    public int save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerDaoRepository.save(customerEntity);
        CustomerDocument customerDocument = new CustomerDocument();
        BeanUtils.copyProperties(customer, customerDocument);
        customerMongoDao.save(customerDocument);
        return 100;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = new ArrayList<>();
        Iterable<CustomerEntity> custDaoReprositoryAll = customerDaoRepository.findByName(name);
        for (CustomerEntity customerEntity : custDaoReprositoryAll) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerEntity, customer);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Iterable<CustomerEntity> custDaoReprositoryAll = customerDaoRepository.findAll();
        for (CustomerEntity customerEntity : custDaoReprositoryAll) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerEntity, customer);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void deleteById(int cid) {
        customerDaoRepository.deleteById(cid);
    }


    @Override
    public Customer findCustById(int cid) {
        Customer customer = new Customer();
        Optional<CustomerEntity> optionalCustomerEntity = customerDaoRepository.findById(cid);
        if (optionalCustomerEntity.isPresent()) {
            CustomerEntity customerEntity = optionalCustomerEntity.get();
            BeanUtils.copyProperties(customerEntity, customer);
        }
        return customer;
    }





       /* Customer customer= new Customer();
        customer.setName("Yubaraj");
        customer.setCid(cid);
        customer.setAddress("1821 granite Drive");
        customer.setDob("10/31/1995");
        customer.setEmail("bhattayuvaraj95@gmail.com");
        customer.setGender("Male");
        customer.setPhone("4695256698");
        customer.setPhoto("www.yubi/photo.com");
        return customer;
    }
*/
}

