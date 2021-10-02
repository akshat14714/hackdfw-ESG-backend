package com.akshat14714.stockcalculator.controllers.impl;

import com.akshat14714.stockcalculator.common.dtos.StockInvestment;
import com.akshat14714.stockcalculator.common.dtos.User;
import com.akshat14714.stockcalculator.common.dtos.UserStocks;
import com.akshat14714.stockcalculator.common.dtos.request.StockInvestmentRequest;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import com.akshat14714.stockcalculator.controllers.UserController;
import com.akshat14714.stockcalculator.repository.StockRepository;
import com.akshat14714.stockcalculator.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserControllerImpl implements UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public UserProfileResponse getUserProfileFromId(String email) {
        UserProfileResponse response = new UserProfileResponse(email);

        User user = userRepository.findUserByEmail(email);
        response.setUserName(user.getName());

        List<UserStocks> userStocks = stockRepository.findAllStocksByUserId(user.getUserId());
        response.setStocks(userStocks);

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
