<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<input type="text" ng-model="userName"/>
<div class="users" ng-controller="UsersListController" ng-cloak>
    <div class="user" ng-repeat="user in users |orderBy:'lastName'|filter:userName">        
        <div class="right-panel">
            <div class="first-name"><a href="mailto: {{user.emailAddress}}">{{user.firstName}} {{user.lastName}}</a></div>            
        </div>
        <div class="clear"/>
    </div>
</div>
