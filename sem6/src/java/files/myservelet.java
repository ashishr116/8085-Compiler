/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raush
 */
public class myservelet extends HttpServlet {

  Assembler o=new Assembler();
trainer t=new trainer(o);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try(PrintWriter out=response.getWriter()){
            String button = request.getParameter("name");
        if ("reset".equals(button)) {
            out.print(t.reset());}
        else if("next".equals(button)){
            out.print(t.next());
        }
        else if("strngpre".equals(button)){
            out.print(t.buttonPrevActionPerformed());
        }
        else if("delgo".equals(button)){
            out.print(t.buttonGoActionPerformed());
            
        }
        else if("exregsi".equals(button)){
            out.print(t.buttonRegActionPerformed());
        }
        else if("relexmem".equals(button)){
            out.print(t.buttonMemActionPerformed());
        }
        else if("6".equals(button)){
            out.print(t.button6());
        }
        else if("8".equals(button)){
            out.print(t.button8());
        }
        else if("0".equals(button)){
            out.print(t.button0());
        }
        else if("1".equals(button)){
            out.print(t.button1());
        }
        else if("2".equals(button)){
            out.print(t.button2());
        }
        else if("3".equals(button)){
            out.print(t.button3());
        }
        else if("4".equals(button)){
            out.print(t.button4());
        }
        else if("5".equals(button)){
            out.print(t.button5());
        }
        else if("7".equals(button)){
            out.print(t.button7());
        }
        else if("9".equals(button)){
            out.print(t.button9());
        }
        else if("A".equals(button)){
            out.print(t.buttonA());
        }
        else if("B".equals(button)){
            out.print(t.buttonB());
        }
        else if("C".equals(button)){
            out.print(t.buttonC());
        }
        else if("D".equals(button)){
            out.print(t.buttonD());
        }
        else if("E".equals(button)){
            out.print(t.buttonE());
        }
        else if("F".equals(button)){
            out.print(t.buttonF());
        }
        else if("exec".equals(button)){
            t.buttonExec();
        }
        
        
        
        
       else{
               out.print(button);
               }
       }
    }
    
   
}
