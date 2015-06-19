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

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    Account account=new Account();
    
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setHeader("Cach-Control", "private, no-store, no-cache, must-revalidate");
       response.setHeader("Pragma","no-cache");
       response.setDateHeader("Expires",0);
       double balance=account.getBalance();
      //PrintWriter out=response.getWriter()
       try(PrintWriter out=response.getWriter()){
           out.println(balance);
       }catch(IOException ex){
            System.err.println("Something Wrong: "+ ex.getMessage());
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<String> value=request.getParameterMap().keySet();
        
       try(PrintWriter out=response.getWriter()){
                if(value.contains("withdraw")&& request.getParameter("withdraw") != null)
                {
                    account.withdraw(Double.parseDouble(request.getParameter("withdraw")));
                }
                else if(value.contains("deposit"))
                {
                    account.deposit(Double.parseDouble(request.getParameter("deposit")));
                }
                else if(value.contains("close"))
                {
                    account.close();
                }
                else
                {
                    out.println("Something wrong with the post method");
                }
                   
       }
       catch(IOException ex){
           
           System.err.println(ex.getMessage());
       }
      
          
    
    }
}
