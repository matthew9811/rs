package com.shengxi;


import com.shengxi.rs.common.config.RsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author matthew
 * @date 2019.03.17
 */
@EnableWebSecurity
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableConfigurationProperties({RsProperties.class})
@EnableCaching
@EnableAsync
public class RsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsApplication.class, args);
        System.out.println("" +
                "                              .d8888b.  8888888b.  \n" +
                "                             d88P  Y88b 888   Y88b \n" +
                "                             Y88b.      888    888 \n" +
                "                              \"Y888b.   888   d88P \n" +
                "                                 \"Y88b. 8888888P\"  \n" +
                "                                   \"888 888 T88b   \n" +
                "                             Y88b  d88P 888  T88b  \n" +
                "                              \"Y8888P\"  888   T88b \n" +
                "                                                   \n" +
                "                                                   \n" +
                "                                                   \n" +
                "  .d8888b.   .d8888b.  8888888888  .d8888b.   .d8888b.  888     888  .d8888b.  \n" +
                " d88P  Y88b d88P  Y88b 888        d88P  Y88b d88P  Y88b 888     888 d88P  Y88b \n" +
                " Y88b.      Y88b.      888        888    888 888    888 888     888 Y88b.      \n" +
                "  \"Y888b.    \"Y888b.   8888888    888        888        888     888  \"Y888b.   \n" +
                "     \"Y88b.     \"Y88b. 888        888        888        888     888     \"Y88b. \n" +
                "       \"888       \"888 888        888    888 888    888 888     888       \"888 \n" +
                " Y88b  d88P Y88b  d88P 888        Y88b  d88P Y88b  d88P Y88b. .d88P Y88b  d88P \n" +
                "  \"Y8888P\"   \"Y8888P\"  8888888888  \"Y8888P\"   \"Y8888P\"   \"Y88888P\"   \"Y8888P\" ");
    }
}
