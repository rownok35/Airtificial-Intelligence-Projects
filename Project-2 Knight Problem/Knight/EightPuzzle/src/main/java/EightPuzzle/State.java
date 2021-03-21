/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightPuzzle;

class State {

    static int goal[][];
    int board[][];

    int g;
    int f;
    State parent;

    State() {

        parent = null;
        board = new int[5][5];

    }

    public State(State b) {

        parent = null;
        g = b.g;
        board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = b.board[i][j];
            }
        }
    }

    public State(int[][] blocks) {

        parent = null;
        board = new int[5][5];
        g = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = blocks[i][j];
            }
        }

    }

    public int h_score() {                   // hamming distance: number of blocks out of place
        int distance = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != goal[i][j]) {
                    distance++;
                }
            }
        }
        return distance;
    }

  

    public boolean isGoal() {                // is this board the goal board?
        if (h_score() > 0) {
            return false;
        } else {
            return true;
        }
    }

   

    public State[] generateNextState() {
        int x=0;
        int y=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(this.board[i][j]==0)
                {
                    x=i;
                    y=j;
                }
            }
            
        }
        int valid_state=0;
        int position_x,position_y;
        position_x= x+2;
        position_y= y+1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
        
        position_x= x+2;
        position_y= y-1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
        
        position_x= x-2;
        position_y= y+1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
        
        position_x= x-2;
        position_y= y-1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4 )
            valid_state++;
        
        
        position_y=y+2;
        position_x=x+1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
        
        position_y=y+2;
        position_x=x-1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
         
        position_y=y-2;
        position_x=x+1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
        
        position_y=y-2;
        position_x=x-1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
            valid_state++;
         
        int knight_position_x[]=new int[valid_state];
        int knight_position_y[]=new int[valid_state];
        
        int m=0;
        int n=0;
        position_x= x+2;
        position_y= y+1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_x= x+2;
        position_y= y-1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_x= x-2;
        position_y= y+1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_x= x-2;
        position_y= y-1;
        if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_y=y+2;
        position_x=x+1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_y=y+2;
        position_x=x-1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4 )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
         
        position_y=y-2;
        position_x=x+1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4 )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        position_y=y-2;
        position_x=x-1;
         if(position_x >=0 && position_y >=0 && position_x <=4 && position_y <=4  )
        {
            knight_position_x[m]=position_x;
            knight_position_y[n]=position_y;
            m++;
            n++;
            
        }
        
        
        
            
        
        
        int state_number;
        
        
        
        State[] neighbors = new State[valid_state];
        

        for (int i = 0; i < valid_state; i++) {
            neighbors[i] = new State(this);
            neighbors[i].parent = this;
            neighbors[i].g = this.g + 1;
        }

        int a;
        int tempx;
        int tempy;

        for (int i = 0; i < valid_state; i++) {
           /* for (int j = 0; j < 5; j++) {

                if (board[i][j] == 0) {
                    //moving blank tiles to left
                    if (j > 0) {
                        a = neighbors[0].board[i][j - 1];
                        neighbors[0].board[i][j - 1] = neighbors[0].board[i][j];
                        neighbors[0].board[i][j] = a;
                    }

                    //moving blank tiles to right
                    if (j < 2) {
                        a = neighbors[1].board[i][j + 1];
                        neighbors[1].board[i][j + 1] = neighbors[1].board[i][j];
                        neighbors[1].board[i][j] = a;
                    }

                    //moving blank tiles to top
                    if (i > 0) {
                        a = neighbors[2].board[i - 1][j];
                        neighbors[2].board[i - 1][j] = neighbors[2].board[i][j];
                        neighbors[2].board[i][j] = a;
                    }

                    //moving blank tiles to bottom
                    if (i < 2) {
                        a = neighbors[3].board[i + 1][j];
                        neighbors[3].board[i + 1][j] = neighbors[3].board[i][j];
                        neighbors[3].board[i][j] = a;
                    }

                }

            }
            */
           
          tempx=knight_position_x[i];
          tempy=knight_position_y[i];
          a=neighbors[i].board[tempx][tempy];
          neighbors[i].board[tempx][tempy]=0;
          neighbors[i].board[x][y]=a;
           

        }

        return neighbors;

    }



    public String toString() {
        String s = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s += board[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

}