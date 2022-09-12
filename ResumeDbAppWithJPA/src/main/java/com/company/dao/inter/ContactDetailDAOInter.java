package com.company.dao.inter;

import com.company.model.ContactDetail;
import com.company.model.User;

import java.util.List;

public interface ContactDetailDAOInter {
    List<ContactDetail> getAllContactDetail();
    ContactDetail getContactDetailById(User userId);
    ContactDetail addContactDetail(ContactDetail contactDetail);
    ContactDetail updateContactDetail(ContactDetail contactDetail);
    void deleteContactDetail(Integer id);
}
