<%-- 
    Document   : index
    Created on : Feb 20, 2019, 8:16:34 AM
    Author     : raush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="files.*"%>

<%

%>
<!DOCTYPE html>

<html>
    <head>
        <title>8085 KIT</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="index.css">
 		<script src="bootstrap/jquery.min.js"></script>
  		<script src="bootstrap/bootstrap.min.js"></script>
  		<script src="bootstrap/bootstrap.min.js"></script>
  		
  		<script src="index.js"></script>
                <script>
                    function button_hit(name){
                    $(document).ready(function(){
                           $.ajax({
                               type:'POST',
                               data:{name:name},
                               url:'myservelet',
                               success:function(result){
                                   display(result);
                               }
                           }); 
                       
                    });}
                </script>
    </head>
    <body>
        
        <table class="button_group">
            <tr class="display_row">
                <td colspan="1" ></td>
                <td colspan="6" class="display">
                    <table class="display_table">
                        <tr class="fake_digits_row">
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="c4"></p>
                            </td>
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="c3"></p>
                            </td>
                        
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="c2"></p>
                            </td>
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="c1"></p>
                            </td>
                            
                            <td class="digits_fake">
                                <p class="fd">&nbsp;</p>
                                <p class="rd" id="c1"></p>
                            </td>
                            
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="d2"></p>
                            </td>
                            <td class="digits_fake">
                                <p class="fd">8</p>
                                <p class="rd" id="d1"></p>
                            </td>
                            
                        </tr>
                    </table>
                    
                    
                </td>
            </tr>
            <tr class="button_row">
                <td><button type="submit" value="reset" name="button" class="btn btn-success" id="reset" onclick="button_hit('reset')">RESET</button></td>
                <td><button type="submit" name="vctint" class="btn btn-danger" onclick="button_hit('halt');">HALT</button></td>
                
                <td><button type="button" class="btn btn-primary" id="C" onclick="button_hit('C');">C</button></td>
                <td><button type="button" class="btn btn-primary" id="D" onclick="button_hit('D');">D</button></td>
                <td><button type="button" class="btn btn-primary" id="E" onclick="button_hit('E');">E</button></td>
                <td><button type="button" class="btn btn-primary" id="F" onclick="button_hit('F');">F</button></td>
            </tr>
            
            <tr class="button_row">
                <td><button type="button" class="btn btn-danger" onclick="button_hit('strngpre');">DCR</button></td>
                <td><button type="button" class="btn btn-danger" onclick="button_hit('relexmem');">SET/MEM</button></td>
                <td><button type="button" class="btn btn-primary" id="8" onclick="button_hit('8');">8</button></td>
                <td><button type="button" class="btn btn-primary" id="9" onclick="button_hit('9');">9</button></td>
                <td><button type="button" class="btn btn-primary" id="A" onclick="button_hit('A');">A</button></td>
                <td><button type="button" class="btn btn-primary" id="B" onclick="button_hit('B');">B</button></td>
            </tr>
            
            <tr class="button_row">
                <td><button type="submit" value="next" name="button" class="btn btn-danger" id="next" onclick="button_hit('next')">INR</button></td>
                <td><button type="button" class="btn btn-danger" onclick="button_hit('exregsi');">REG</button></td>
                <td><button type="button" class="btn btn-primary" id="4" onclick="button_hit('4');">4<br>PCH</button></td>
                <td><button type="button" class="btn btn-primary" id="5" onclick="button_hit('5');">5<br>PCL</button></td>
                <td><button type="button" class="btn btn-primary" id="6" onclick="button_hit('6');">6<br>SPH</button></td>
                <td><button type="button" class="btn btn-primary" id="7" onclick="button_hit('7');">7<br>SPL</button></td>
            </tr>
            
            <tr class="button_row">
                <td><button type="button" class="btn btn-danger" onclick="button_hit('delgo');">GO</button></td>
                
                <td><button type="button" class="btn btn-danger" onclick="button_hit('exec');">EXEC</button></td>
                <td><button type="button" class="btn btn-primary" id="0" onclick="button_hit('0');">0</button></td>
                <td><button type="button" class="btn btn-primary" id="1" onclick="button_hit('1');">1</button></td>
                <td><button type="button" class="btn btn-primary" id="2" onclick="button_hit('2');">2<br>CRT</button></td>
                <td><button type="button" class="btn btn-primary" id="3" onclick="button_hit('3');">3<br>I</button></td>
            </tr>
        </table>

    </body>
</html>
