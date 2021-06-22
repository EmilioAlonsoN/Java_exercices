package com.my_webside.web.schedular;


import com.my_webside.web.service.AddressService;
import com.my_webside.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobSchedular {

    private  static final Logger logger = LoggerFactory.getLogger(JobSchedular.class);

    private final UserService userService;
    private final AddressService addressService;

    @Autowired
    public JobSchedular(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void scheduleUsingCron() {
        //logger.info(String.valueOf(userService.userList()));
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleUsingFixedDelayWithInitialDelay() {
       //logger.info(String.valueOf(userService.findOne(1L)));
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleDelay() {
        //logger.info(String.valueOf(addressService.addressList()));
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleUsingRate() {
        //logger.info(String.valueOf(addressService.findOne(1L)));
    }
}
