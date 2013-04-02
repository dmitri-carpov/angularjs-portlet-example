package com.savoirfairelinux.liferay.template.angularjs.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.savoirfairelinux.liferay.template.angularjs.model.User;
import com.savoirfairelinux.liferay.template.angularjs.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dmitri Carpov
 */
@Controller
@RequestMapping("/services/users")
public class UserController {
    private Log log = LogFactoryUtil.getLog(getClass());
    
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> list(HttpServletRequest request) {
        
        try {
            com.liferay.portal.model.User user = PortalUtil.getUser(request);

            PrincipalThreadLocal.setName(user.getUserId());
            PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);
            CompanyThreadLocal.setCompanyId(PortalUtil.getCompanyId(request));
            
            
        } catch (Exception ex) {
            log.debug("Cannot get users list. Caused by: " + ex.getMessage(), ex);
        }
        return userService.getUsers();
    }
}
