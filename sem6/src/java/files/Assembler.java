package files;



public class Assembler {
    AssemblerEngine engine;
    Matrix matrix;
    Disassembler disassembler;
    PPI8255 ppi8255;
    Preprocessor preprocessor;
    String textEditor;
int tableState=0;
    String path="";
    boolean closeStateCall=false;
    float[] speed=new float[4];
    int timingDiagramX = 0;
    
    String recover="";
    String[] comments=new String[1000];
    String[] macro=new String[1000];
    int oIndex=0;
    boolean stop=false;
    boolean pause=false;
    boolean properShutdown=false;
    int stopAtIndex=207;
    int memShift=0;
    
    int continueFrom=0;
String fileSeparator=System.getProperty("file.separator");


public Assembler() {

        matrix = new Matrix(this);
        engine = new AssemblerEngine(matrix);
        ppi8255=new PPI8255(this);
        preprocessor = new Preprocessor();
        disassembler = new Disassembler(this);
     /*   //textEditor=new TextEditor(this);
        //initComponents();
      /// jTabbedPaneAssemblerEditor.removeAll();
        //jTabbedPaneAssemblerEditor.addTab("Assembler",jScrollPane9);
        //jTabbedPaneAssemblerEditor.addTab("Disassembler",jScrollPane5);
        
        //setParameters();
        matrix.PC=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldBeginFrom));
        matrix.beginAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemBegin));
        matrix.stopAddress=engine.Hex2Dec(engine.HexAutoCorrect4digit(jTextFieldMemStop));
        //sampleCode();
        //jScrollPane16.setVisible(true);
        //jMenu12.setVisible(false);
      
        //jTabbedPaneInterface.setVisible(true);
        //jTabbedPaneInterface.addTab("I/O Port Editor", jScrollPane4);
        */
        
        
   //___________________________________________________________________________________________________________________________     
       //jTableAssembler.setRowSelectionAllowed(true);
        //jTableAssembler.setRowSelectionInterval(0, 1);
    //_____________________________________________________________________________________________________________________   
    
jButtonRun.setMnemonic('r');
    jButtonRun.setText("Run all At a Time");
    jButtonRun.setName("jButtonRun"); // NOI18N
    jButtonRun.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonRunActionPerformed(evt);
        }
    });
}


 private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {                                           

       //jButtonStop.setVisible(true);
       //jButtonRun.setVisible(false);
       //jButtonStep.setVisible(false);
       //jLabelErrorHang.setVisible(false);
       stop=false;
       //ExecutorService exec = Executors.newCachedThreadPool();
       //exec.execute(this);


   } 

  public void set()
    {
        setIOPort();
        setMemory();
        setResister();
        ppi8255.set();
       // jRadioButtonUsedMemoryLocationActionPerformed(null);

    }
  
   public void setIOPort() {
        for (int i = 0,row=0,col=1; i < 256; i++, col++) {
            jTablePort[row][col]= engine.Dec2Hex2digit(matrix.port[i]);
            if(col==16){col=0;row++;}
        }
        for (int i = 0; i < 16; i++) {
            jTablePort[i][0]="   "+engine.Dec2Hex2digit(i*16);
        }
    }
   
    public void setMemory()
   {
       try {
           int lower = engine.Hex2Dec(jTextFieldMemBegin);
           int upper = engine.Hex2Dec(jTextFieldMemStop);
           int n = (upper - lower + 1) / 16;
           if (n % 16 != 0) {
               n = n - (n % 16) + 16;
           }
           jTableMemory.setModel(new javax.swing.table.DefaultTableModel(
                   new Object[n][17],
                   new String[]{
                       "        ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
                   }) {

               Class[] types = new Class[]{
                   java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
               };
               boolean[] canEdit = new boolean[]{
                   false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
               };

               public Class getColumnClass(int columnIndex) {
                   return types[columnIndex];
               }

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                   return canEdit[columnIndex];
               }
           });
           jTableMemory.getColumnModel().getColumn(0).setPreferredWidth(330);
       }catch(Exception e){}
       
       int lower=engine.Hex2Dec(jTextFieldMemBegin);
       int upper=engine.Hex2Dec(jTextFieldMemStop);
       int n = (upper - lower+1)/16;
       String s = "";
       int l=lower;
       for (int i = 0; i < n; i++, l+=16) {
           s = engine.Dec2Hex(l);
           jTableMemory.setValueAt(s, i, 0);
           
       }
      
       for(int i=lower,row=0,col=1;i<=upper;i++,col++)
       {

           jTableMemory.setValueAt(engine.Dec2Hex2digit(matrix.memory[i]),row,col);
           if(col==16){col=0;row++;}
           
       }

       
       
       tableState = 0;
   }
    
     private void setResister() {
        String s;
        jTableRegister[0][1]="       " + engine.Dec2Hex2digit(matrix.A);
        s = engine.Dec2Bin(matrix.A);
        for (int i = 0; i < 8; i++) {
            jTableRegister[0][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[1][1]="       " + engine.Dec2Hex2digit(matrix.B);
        s = engine.Dec2Bin(matrix.B);
        for (int i = 0; i < 8; i++) {
            jTableRegister[1][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[2][1]="       " + engine.Dec2Hex2digit(matrix.C);
        s = engine.Dec2Bin(matrix.C);
        for (int i = 0; i < 8; i++) {
            jTableRegister[2][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[3][1]="       " + engine.Dec2Hex2digit(matrix.D);
        s = engine.Dec2Bin(matrix.D);
        for (int i = 0; i < 8; i++) {
            jTableRegister[3][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[4][1]="       " + engine.Dec2Hex2digit(matrix.E);
        s = engine.Dec2Bin(matrix.E);
        for (int i = 0; i < 8; i++) {
            jTableRegister[4][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[5][1]="       " + engine.Dec2Hex2digit(matrix.H);
        s = engine.Dec2Bin(matrix.H);
        for (int i = 0; i < 8; i++) {
            jTableRegister[5][i+2]=s.charAt(i) + "  ";
        }

        jTableRegister[6][1]="       " + engine.Dec2Hex2digit(matrix.L);
        s = engine.Dec2Bin(matrix.L);
        for (int i = 0; i < 8; i++) {
            jTableRegister[6][i+2]=s.charAt(i) + "  ";
        }
        if((256*matrix.H+matrix.L)<65536  ){
        jTableRegister[7][1]="       " + engine.Dec2Hex2digit(matrix.memory[256*matrix.H+matrix.L]);
        s = engine.Dec2Bin(matrix.memory[256*matrix.H+matrix.L]);
        for (int i = 0; i < 8; i++) {
            jTableRegister[7][i+2]=s.charAt(i) + "  ";
        }}
        else{
            jTableRegister[7][1]="       " + engine.Dec2Hex2digit(0);
        s = engine.Dec2Bin(0);
        for (int i = 0; i < 8; i++) {
            jTableRegister[7][i+2]=s.charAt(i) + "  ";
        }

        }

        jTableFlagregister[0][1]="       " + engine.Dec2Hex2digit(matrix.F);
        s = engine.Dec2Bin(matrix.F);
        for (int i = 0; i < 8; i++) {
            jTableFlagregister[0][i+2]=s.charAt(i) + "  ";
        }

        jTableCounter[0][1]="                  " + engine.Dec2Hex(matrix.SP);
        jTableCounter[1][1]="                  " + engine.Dec2Hex2digit(matrix.H) + engine.Dec2Hex2digit(matrix.L);
        jTableCounter[2][1]="                  " + engine.Dec2Hex2digit(matrix.A) + engine.Dec2Hex2digit(matrix.F);
        jTableCounter[3][1]="                  " + engine.Dec2Hex(matrix.PC);
        jTableCounter[4][1]="                  " + matrix.clockCycleCounter;
        jTableCounter[5][1]="                  " + matrix.instructionCounter;

        int SOD;
        SOD=(matrix.SOD&matrix.SDE);
        jTableInterrupt[0][0]="       "+SOD;
        jTableInterrupt[0][1]="       "+matrix.SID;
        jTableInterrupt[0][2]="       "+matrix.INTR;
        jTableInterrupt[0][3]="       "+matrix.TRAP;
        jTableInterrupt[0][4]="       "+matrix.R75;
        jTableInterrupt[0][5]="       "+matrix.R65;
        jTableInterrupt[0][6]="       "+matrix.R55;

        jTableSIM[0][0]="    "+matrix.SOD;
        jTableSIM[0][1]="    "+matrix.SDE;
        jTableSIM[0][2]="    "+matrix.D1;
        jTableSIM[0][3]="    "+matrix.RR75;
        jTableSIM[0][4]="    "+matrix.MSE;
        jTableSIM[0][5]="    "+matrix.M75;
        jTableSIM[0][6]="    "+matrix.M65;
        jTableSIM[0][7]="    "+matrix.M55;

        jTableRIM[0][0]="    "+matrix.SID;
        jTableRIM[0][1]="    "+matrix.R75;
        jTableRIM[0][2]="    "+matrix.R65;
        jTableRIM[0][3]="    "+matrix.R55;
        jTableRIM[0][4]="    "+matrix.IE;
        jTableRIM[0][5]="    "+matrix.M75;
        jTableRIM[0][6]="    "+matrix.M65;
        jTableRIM[0][7]="    "+matrix.M55;




    }
     
     
      public void disAssemble()
   {
      int begin=engine.Hex2Dec(jTextFieldMemBegin);
      int index=0,n=begin;
      String temp="",value="";
      jump:
      for(int i=0,x=0;jTableAssembler.getValueAt(i, 4)!=null;begin++,i++)
      {
            jTableAssembler.setValueAt("  "+engine.Dec2Hex(begin),i,1);
            index=engine.Hex2Dec(jTableAssembler.getValueAt(i, 4).toString());
            if(index<255)temp=engine.S[index];
            else break jump;
            x=engine.getBytesFromMnemonics(temp);
            value="";
            if(engine.S[index].equalsIgnoreCase("NOP")){jTableAssembler.setValueAt("X",i,0);}
            else jTableAssembler.setValueAt("√",i,0);

            jTableAssembler.setValueAt("       "+engine.I[index][0],i,5);
            jTableAssembler.setValueAt("        "+engine.I[index][1],i,6);
            jTableAssembler.setValueAt("        "+engine.I[index][2],i,7);
            jTableAssembler.setValueAt("      "+engine.HexAutoCorrect2digit(jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()),i,4);

            for(int j=1;j<x;j++)
            {
                            begin++;
                            i++;
                            jTableAssembler.setValueAt("  "+engine.Dec2Hex(begin),i,1);
                            try{
                            value=jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()+value;
                            }catch(Exception e)
                            {
                                value="00"+value;
                                jTableAssembler.setValueAt("00",i,4);

                            }
                            temp=temp.substring(0, temp.length()-2*j)+value;
                            jTableAssembler.setValueAt("      "+engine.HexAutoCorrect2digit(jTableAssembler.getValueAt(i, 4).toString().toUpperCase().trim()),i,4);
            }
            jTableAssembler.setValueAt("  "+temp,i-x+1,3);
      }
      for(int i=0;jTableAssembler.getValueAt(i, 4)!=null;i++)
      {
          matrix.memory[i+n]=engine.Hex2Dec(jTableAssembler.getValueAt(i, 4).toString());
      }
      setMemory();
      //jTabbedPaneAssemblerEditor.setSelectedIndex(1);
      //jButtonAssemble.setVisible(false);
      //jButtonDisassemble.setVisible(true);

   }
     
     public javax.swing.JButton jButtonRun = new javax.swing.JButton();
     
     
    
  //____________________________________________________________________________________________________________________  
   public javax.swing.JTable jTableAssembler;
   private javax.swing.JTable jTableNoConverter;
    private javax.swing.JTable jTableMemory;
    public javax.swing.JTable jTable8255;
  //_______________________________________________________________________________________________________________________ 
    
    
    
    
    public String[][] jTableCounter=new String[6][2];
    public String[][] jTableFlagregister=new String[1][8];
    public String[][] jTableInterrupt=new String[1][8];
    public String[][] jTablePort=new String[17][257];
    public String[][] jTableRIM=new String[1][8];
    public String[][] jTableRegister=new String[8][8];
    public String[][] jTableSIM=new String[1][8];
     
     
    
    
     public String jTextArea8255;
    public String jTextAreaAssemblyLanguageEditor;
    public String jTextAreaDisassembler;
    private String jTextAreaLabel;
    public String jTextFieldBeginFrom;
    private String jTextFieldMemBegin;
    private String jTextFieldMemStop; 
    
}
