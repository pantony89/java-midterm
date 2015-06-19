/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 * Updated 2015 Mark Russell <mark.russell@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Account class
 */
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testGetBalanceIsZeroOnNewAccount() {
        Account instance = new Account();
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetBalanceIs500AfterDeposit500() {
        double cash = 500.0;
        Account instance = new Account();
        instance.deposit(cash);
        double expResult = 500.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetBalanceIs100AfterDeposit500ThenWithdraw400() {
        Account ins=new Account();
        double balance=100.0;
        ins.deposit(500.0);
        ins.withdraw(400.0);
        double exp=200.0;
        double result=ins.getBalance();
        assertEquals(exp,result,200.0);
        
    }
    
    @Test
    public void testGetBalanceIsZeroAfterDeposit500ThenClose() {
        Account ins=new Account();
        double balance=0.0;
        ins.deposit(500.0);
        ins.close();
        double exp=0.0;
        double result=ins.getBalance();
        assertEquals(exp,result,0.0);
        
        
    }
}
