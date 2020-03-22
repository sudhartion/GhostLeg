package applet1;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Applet10 extends Applet implements MouseListener
{
    int a[][] = new int[10][10];
    int x,y;
    int i,j,k,l;
    int q;

    Graphics b1,b2;
    Image off1,off2;
            
    public void init()
    {
        setLayout(null);
        x=0;
        y=0;
        q=0;
        
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                if(j%2==0)
                {a[i][j]=1;}
                else
                {a[i][j]=0;}
            }
            
        }
        
        
        addMouseListener(this);
                
        off1=createImage(50,50);
        off2=createImage(1,1);
        b1=off1.getGraphics();
        b2=off2.getGraphics();
    }   
        
        
    public void paint(Graphics g)
    {
        if(q==0)
        {build(g);}
        else
        {solve(g);}
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }
        
   
    public void mouseClicked(MouseEvent m)
    {
        x=m.getX();
        y=m.getY();
        
        x=(x-5)/50;
        y=(y-5)/50;
        
        if(y>=0 && y<10 && x>=0 && x<10 && x%2!=0)
        {
            if(a[y][x-1]!=2 && a[y][x+1]!=2)
            {
            a[y][x-1]=2;
            a[y][x]=2;
            a[y][x+1]=2;
            }
            
            else if(a[y][x-1]==2 && a[y][x]==2 && a[y][x+1]==2)
            {
                a[y][x-1]=1;
                a[y][x]=0;
                a[y][x+1]=1;
            }
        }
        
        if(x>10 || y>10)
        {q=1;}
        
        repaint();
    }
    
    public void delay(int t)
    {
        try{TimeUnit.MILLISECONDS.sleep(t);}catch(InterruptedException ex){}
    }
    
    public void build(Graphics g)
    {
        for(i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                    if(a[i][j]==1)
                    {
                        b1.drawLine(25,0,25,24);
                        b1.drawLine(25,26,25,50);
                    }
                    
                    if(a[i][j]==2)
                    {
                        if(j==0 || (a[i][j-1]!=2 && a[i][j+1]==2))
                        {
                            b1.drawLine(25,25,50,25);
                            b1.drawLine(25,0,25,50);
                        }
                        
                        else if(a[i][j-1]==2 && a[i][j+1]==2)
                        {b1.drawLine(0,25,50,25);}
                        
                        else if(a[i][j-1]==2 && a[i][j+1]!=2)
                        {
                            b1.drawLine(0,25,25,25);
                            b1.drawLine(25,0,25,50);
                        }
                    }
                    
                    g.drawImage(off1,5+j*50,5+i*50,this);
                    b1.clearRect(0,0,50,50);
                }
            }
    }
    
    public void solve(Graphics g)
    {
        b2.clearRect(0,0,1,1);
        for(j=0;j<10;j++)
        {
            if(j%2==0)
            {continue;}
            
            for(i=0;i<10;i++)
            {
                if(a[i][j]==2)
                {
                    a[i][j-1]=3;
                    a[i][j+1]=4;
                }
            }
        }
        
        for(j=0;j<10;j++)
        {
            if(j%2!=0)
            {continue;}
            
            switch(j)
            {
                case 0:
                    //b2.setColor(Color.GREEN);
                    break;
                    
                case 2:
                    //b2.setColor(Color.BLUE);
                    break;
                    
                case 4:
                    //b2.setColor(Color.RED);
                    break;
                    
                case 6:
                    //b2.setColor(Color.GRAY);
                    break;
                    
                case 8:
                    //b2.setColor(Color.MAGENTA);
                    break;
            }
            
            l=j;
            for(i=0;i<10;i++)
            {
                for(k=0;k<25;k++)
                {
                    x=5+25+(j/2)*100;
                    y=5+i*50;
                    b2.drawLine(0,0,0,0);
                    g.drawImage(off2,x,y+k,this);
                    delay(5);
                }
                                
                if(a[i][j]==3)
                {
                    for(k=0;k<100;k++)
                    {
                        x=5+25+(j/2)*100;
                        y=5+i*50+25;
                        b2.drawLine(0,0,0,0);
                        g.drawImage(off2,x+k,y,this);
                        delay(5);
                    }
                    j+=2;
                }
                
                else if(a[i][j]==4)
                {
                    for(k=0;k<100;k++)
                    {
                        x=5+25+(j/2)*100;
                        y=5+i*50+25;
                        b2.drawLine(0,0,0,0);
                        g.drawImage(off2,x-k,y,this);
                        delay(5);
                    }
                    j-=2;
                }
                
                for(k=0;k<25;k++)
                {
                    x=5+25+(j/2)*100;
                    y=5+i*50+25;
                    b2.drawLine(0,0,0,0);
                    g.drawImage(off2,x,y+k,this);
                    delay(5);
                }
            }
            b2.clearRect(0,0,1,1);
            g.drawString(((l/2)+1)+"->"+((j/2)+1),500,100+l*50);
            j=l;
        }
    }
    
    
    
    public void mousePressed(MouseEvent m)
    {
        
    }
    
    public void mouseReleased(MouseEvent m)
    {
        
    }
    
    public void mouseEntered(MouseEvent m)
    {
        
    }
    
    public void mouseExited(MouseEvent m)
    {
        
    }
    
    
}