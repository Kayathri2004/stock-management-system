/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pratap
 */
public class addtocart extends javax.swing.JFrame {

    /**
     * Creates new form addtocart
     */
    String roll;
    public addtocart() {
        initComponents();
        roll="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item_id", "item_name", "quantity", "unit price", "total price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setRowHeight(25);
        table2.setRowMargin(3);
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(1).setMinWidth(140);
        }

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton1.setText("View Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Total Amount");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("Proceed to bill");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        int  total = 0;
        String tot = "";
        
      //   ProductInformation.categoryChooser = "electronics";
        try {
            //Class.forName("java.sql.DriverManager");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/java_stock", "root", "12345");

            Statement stmt = con.createStatement();
            String query = "select * from cart ";
            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()) {
                String id = rs.getString("item_id");
                String name = rs.getString("item_name");
                String qun = rs.getString("quantity");
                 String price1 = rs.getString("price");
                
                String mfd = rs.getString("totprice");
               
                
               model.addRow(new Object[] {id,name,qun,price1,mfd});
            }
            rs.close();
      
            //stmt.close();
            //con.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            //e.printStackTrace();
        } 
        int sum=0;
     for(int i=0;i<table2.getRowCount();i++)
     {
    sum=sum+Integer.parseInt(table2.getValueAt(i,4).toString());
     }
jLabel2.setText(Integer.toString(sum));
//String b=jLabel2.getText();


// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.setVisible(false);
        Searchproduct mm=new Searchproduct();
        mm.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       workWithDatabase();
    
    
    

try
{
    DefaultTableModel model=(DefaultTableModel)table2.getModel();
           int selectedRowIndex =table2.getSelectedRow();
          String a=model.getValueAt(selectedRowIndex,0).toString();
           String b=model.getValueAt(selectedRowIndex,1).toString();
            String c=model.getValueAt(selectedRowIndex,2).toString();
             String d=model.getValueAt(selectedRowIndex,3).toString(); 
             String e=model.getValueAt(selectedRowIndex,4).toString();
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_stock","root","12345");
             String query = "insert into bill(item_id,item_name,quantity,price,totprice) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"')";
             Statement smt3=con.createStatement();
         //ResultSet   rs=smt3.executeQueryUpdate(query);
             
                       int success=smt3.executeUpdate(query);
                           if(success==1)
                            {
                              JOptionPane.showMessageDialog(this, "Product Successfully Added to bill ");
                               //emp1.showMessageDialog(this, "Problem in Saving. Retry");
                            }
                            else
                            {

                                JOptionPane.showMessageDialog(this, "Problem in Saving. Retry");
                            }
             
          
            
}
catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
        
     public void workWithDatabase()
    {
        Connection c=null;
         Statement  s=null;
         ResultSet rs1=null;
         int flag=0;
         try{
             
        Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3307/java_stock","root","12345");
       s=c.createStatement();

  DefaultTableModel model = (DefaultTableModel) table2.getModel();   
           int selectedRowIndex =table2.getSelectedRow();
          String a=model.getValueAt(selectedRowIndex,0).toString();
         
            String c1=model.getValueAt(selectedRowIndex,2).toString();
            
   
              String s1=a;
        
   //  rs1 = s.executeQuery ("select quantity from  inventory where item_id="+"'"+s1+"'");
        
         int id=Integer.parseInt(c1);
    rs1 = s.executeQuery ("select quantity from  inventory where item_id="+"'"+s1+"'");
    
       
   // jLabel6.setText(s1);
           
             while(rs1.next()) {
                  String id1=rs1.getString("quantity");
                  int id2=Integer.parseInt(id1);
        
                 int id3=id2-id;
               s.executeUpdate("Update inventory set quantity="+id3+" where item_id="+"'"+s1+"'");
       
           }
         /*     while(rs1.next())
       {
               String quantity1=rs1.getString("quantity");
               String q3 = quantity1;
               
              
         }*/
             rs1.close();
    
             
                  
            
}
 catch(SQLException | ClassNotFoundException e1)
         {
             System.out.println(e1);
         }
         try {
            //Class.forName("java.sql.DriverManager");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/java_stock", "root", "12345");

            Statement stmt = con.createStatement();
            String query = "delete from cart ";
           // ResultSet   rs=smt3.executeQueryUpdate(query);

             
            // Statement smt3=con.createStatement();
         //
             
                       int success=stmt.executeUpdate(query);
            
      
            //stmt.close();
            //con.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            //e.printStackTrace();
        } 
//  String b=jLabel2.getText();
this.setVisible(false);
        bill mm=new bill();
        mm.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addtocart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addtocart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
