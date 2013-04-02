package com.savoirfairelinux.liferay.template.angularjs.service;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.UserServiceUtil;
import com.savoirfairelinux.liferay.template.angularjs.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dmitri Carpov
 */
@Service
public class UserService {
    private Log log = LogFactoryUtil.getLog(getClass());
    
    public List<User> getUsers() {
        final List<User> users = new ArrayList<User>();

        try {

            List<com.liferay.portal.model.User> portalUsers = UserServiceUtil.getCompanyUsers(CompanyThreadLocal.getCompanyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            if (portalUsers != null) {
                for (com.liferay.portal.model.User portalUser : portalUsers) {
                    users.add(User.toUser(portalUser));                    
                }
            }
        } catch (Exception ex) {
            log.error("Cannot get list of users. Caused by: " + ex.getMessage());
            log.debug(ex.getMessage(), ex);
        }

        return users;
    }
}
