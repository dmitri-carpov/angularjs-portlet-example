package com.savoirfairelinux.liferay.template.angularjs.model;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Dmitri Carpov
 */
public class User {
    private static Log log = LogFactoryUtil.getLog(User.class);

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String jobTitle;
    private String comments;
    private String pictureUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public static User toUser(com.liferay.portal.model.User liferayUser) {
        User user = new User();

        if (liferayUser != null) {
            user.setId(liferayUser.getUserId());
            user.setFirstName(liferayUser.getFirstName());
            user.setLastName(liferayUser.getLastName());
            user.setJobTitle(liferayUser.getJobTitle());
            user.setEmailAddress(liferayUser.getEmailAddress());
            user.setComments(liferayUser.getComments());

            try {
                StringBuilder pictureUrlBuilder = new StringBuilder();
                String sex = liferayUser.isFemale() ? "female" : "male";

                pictureUrlBuilder.append("/image/user_").append(sex).
                        append("_portrait?img_id=").append(liferayUser.getPortraitId());
                user.setPictureUrl(pictureUrlBuilder.toString());
            } catch (Exception ex) {
                log.error("Cannot get user's picture url. Caused by: " + ex.getMessage(), ex);
            }
        }

        return user;
    }
}
