package com.jzhl.yunjia.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class QQUtils {

    /**
     * 云+ 设备上下线
     */
    public static void sendMailOnlineOrOffline(String districtName, String deviceName, String Online){

        try {
            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.qq.com");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getInstance(props);

            Message msg = new MimeMessage(session);
            if(Online.equals("0")){
                msg.setSubject(districtName + " 云+ 控制器设备下线通知");
            }else if(Online.equals("1")){
                msg.setSubject(districtName + " 云+ 控制器设备上线通知");
            }else{
                msg.setSubject(districtName + " 云+ 控制器设备");
            }
            StringBuilder builder = new StringBuilder();
            if(Online.equals("0")){
                builder.append(districtName + "- -" + deviceName + ": 云+ 控制器设备 已下线. 下线时间: " + DateUtils.noeDate());
            }else if(Online.equals("1")){
                builder.append(districtName + "- -" + deviceName + ": 云+ 控制器设备 已上线. 下线时间: " + DateUtils.noeDate());
            }
            builder.append(" 设备后台查看(http://www.cnblogs.com/hzxy-blog/)");
            msg.setText(builder.toString());
            msg.setFrom(new InternetAddress("540623741@qq.com"));

            Transport transport = session.getTransport();
            transport.connect("smtp.qq.com",
                    "540623741@qq.com"
                    ,
                    "hhmipgdqgcbabeji"
            );

            transport.sendMessage(msg, new Address[] { new InternetAddress(
                    "540623741@qq.com"
            ) });
            transport.close();
        }catch (Exception e) {

        }
    }
}
