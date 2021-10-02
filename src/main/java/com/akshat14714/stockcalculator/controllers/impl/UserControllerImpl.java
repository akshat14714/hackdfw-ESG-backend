package com.akshat14714.stockcalculator.controllers.impl;

import com.akshat14714.stockcalculator.common.dtos.StockInvestment;
import com.akshat14714.stockcalculator.common.dtos.User;
import com.akshat14714.stockcalculator.common.dtos.UserStocks;
import com.akshat14714.stockcalculator.common.dtos.request.StockInvestmentRequest;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import com.akshat14714.stockcalculator.controllers.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserControllerImpl implements UserController {

    @Override
    public UserProfileResponse getUserProfileFromId(String email) {
        UserProfileResponse response = new UserProfileResponse(email);

        response.setUserName("Akshat");
        response.setEmail(email);

        return response;
    }

    @Override
    public boolean addUserInvestment(String email, List<StockInvestmentRequest> stocks) {

//        User user = getUserFromEmail(email);
        User user = new User();

        user.setEmail(email);

//        int incentive = user.getIncentive();
        int incentive = 0;

        for (StockInvestmentRequest stock : stocks) {
            incentive += stock.getIncentive();
        }
        user.setIncentive(incentive);

        addUserStocksInInvestment(user.getUserId(), stocks);

        log.info("Incentive: " + incentive);

        return true;
    }

    private void addUserStocksInInvestment(int userId, List<StockInvestmentRequest> stocks) {
        for (StockInvestmentRequest stock : stocks) {
//            UserStocks userStocks = getUserStocksFromUserIdAndStockId(userId, stock.getId());
            UserStocks userStocks = new UserStocks();
            userStocks.setUserId(userId);
            userStocks.setQuantity(userStocks.getQuantity() + stock.getQuantity());
            userStocks.setTotalPurchasePrice(userStocks.getTotalPurchasePrice() + stock.getPrice()*stock.getQuantity());
            // Save userStocks record
            log.info(userStocks.toString());
        }
    }
}
