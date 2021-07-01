

package com.mycompany.notepad;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.io.*;

public class Notepad extends javax.swing.JFrame implements ActionListener{
    JMenuBar  mb;
    JMenu file,edit,format,font,size,style;
    JMenuItem nf,open,exit,save,cut,copy,paste,delete,font1,font2,font3,font4,bold,italic,underline,underline1,size1,size2,size3,size4;
    JTextArea ta;
    JScrollPane s;
    Notepad()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Notepad");
        setVisible(true);
        setSize(300,300);
        
        
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        format=new JMenu("Format");
        nf=new JMenuItem("New");
        open=new JMenuItem("Open");
        save=new JMenuItem("Save as");
        exit=new JMenuItem("Exit");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        delete=new JMenuItem("Delete");
        font=new JMenu("Font");
        
            font1=new JMenuItem("Arial");
            font.add(font1);
            font2=new JMenuItem("Times New Roman");
            font.add(font2);
            font3=new JMenuItem("Calibiri");
            font.add(font3);
            font4=new JMenuItem("Comic Sans MS");
            font.add(font4);
            
            
        
        size=new JMenu("Size");
        size1=new JMenuItem("10");
          size2=new JMenuItem("11");
          size3=new JMenuItem("12");
          size4=new JMenuItem("13");
        style=new JMenu("Style");
        
            bold=new JMenuItem("Bold");
            style.add(bold);
            italic=new JMenuItem("Italic");
            style.add(italic);
            underline=new JMenuItem("Bold Italic");
            style.add(underline);
            underline1=new JMenuItem("Plain");
            style.add(underline1);
        
        file.add(nf);
        file.add(open);
        file.add(save);
        file.add(exit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        format.add(font);
        size.add(size1);
          size.add(size2);
          size.add(size3);
          size.add(size4);
        format.add(size);
        format.add(style);
        mb.add(file);
        mb.add(edit);
        mb.add(format);
        setJMenuBar(mb);
        
        ta=new JTextArea();
         Font font = new Font("Arial", Font.PLAIN, 12);
        ta.setFont(font);
         s=new JScrollPane(ta);
        add(s,BorderLayout.CENTER);
        
        nf.addActionListener(this);
        open.addActionListener(this);
        exit.addActionListener(this);
        save.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        font1.addActionListener(this);
        font2.addActionListener(this);
        font3.addActionListener(this);
        font4.addActionListener(this);
        bold.addActionListener(this);
        italic.addActionListener(this);
        underline.addActionListener(this);
        underline1.addActionListener(this);
        size1.addActionListener(this);
        size2.addActionListener(this);
        size3.addActionListener(this);
        size4.addActionListener(this);
    }
    
    public static void main(String[] args) {
        new Notepad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
     if(e.getActionCommand()=="New")
     {
         new Notepad();
     }
     else if(e.getActionCommand()=="Exit")
     {
         dispose();
     }
     else if(e.getActionCommand()=="Open")
     {
         JFileChooser c=new JFileChooser();
         if(c.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
         {
            ta.setText("");
            BufferedReader r=new BufferedReader(new FileReader(c.getSelectedFile().getAbsolutePath()));
            String line;
            while((line=r.readLine())!=null)
            {
                ta.append(line+"\n");
            }
         }
     }
     else if(e.getActionCommand()=="Save As")
     {
         JFileChooser c=new JFileChooser();
         if(c.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)  
         {
             BufferedWriter w=new BufferedWriter(new FileWriter(c.getSelectedFile().getAbsolutePath()));
             w.write(ta.getText());
             w.close();
         }
     }
         else if(e.getActionCommand()=="Cut")
      {
          ta.cut();
      }
     else if(e.getActionCommand()=="Copy")
      {
          ta.copy();
      }
     else if(e.getActionCommand()=="Paste")
      {
          ta.paste();
      }
     else if(e.getActionCommand()=="Delete")
      {
          ta.replaceSelection("");
      }
     else if(e.getActionCommand()=="Bold")
     {
         ta.setFont(ta.getFont().deriveFont(Font.BOLD));
       
     }
     else if(e.getActionCommand()=="Italic")
     {
         ta.setFont(ta.getFont().deriveFont(Font.ITALIC));
     }
     else if(e.getActionCommand()=="Bold Italic")
     {
         ta.setFont(ta.getFont().deriveFont(Font.BOLD|Font.ITALIC));
     }
     else if(e.getActionCommand()=="Plain")
     {
        ta.setFont(ta.getFont().deriveFont(Font.PLAIN));
     }
     
     else if(e.getActionCommand()=="Arial")
     {
         Font f=new Font("Arial",Font.PLAIN,12);
          ta.setFont(f);
     }
      else if(e.getActionCommand()=="Times New Roman")
     {
         Font f=new Font("Times New Roman",Font.PLAIN,12);
          ta.setFont(f);
     }
      else if(e.getActionCommand()=="Calibiri")
     {
         Font f=new Font("Calibiri",Font.PLAIN,12);
          ta.setFont(f);
     }
      
       else if(e.getActionCommand()=="Comic Sans MS")
     {
         Font f=new Font("Comic Sans MS",Font.PLAIN,12);
          ta.setFont(f);
     }
       
     
      else if(e.getActionCommand()=="10")
     {
         ta.setFont(ta.getFont().deriveFont(10f));
     }
      else if(e.getActionCommand()=="11")
     {
         ta.setFont(ta.getFont().deriveFont(11f));
     }
      else if(e.getActionCommand()=="12")
     {
         ta.setFont(ta.getFont().deriveFont(12f));
     }
      else if(e.getActionCommand()=="13")
     {
         ta.setFont(ta.getFont().deriveFont(13f));
     }
     
        }
        
        
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
    
    
    
}
