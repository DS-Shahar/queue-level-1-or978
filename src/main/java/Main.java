class Main
{
    public static void main(String[] args)
    {
        Queue<Integer> Q1 = new Queue<Integer>();
        Q1.insert(1);
        Q1.insert(2);
        Q1.insert(3);

        //ex1
        Queue<Integer> dup = Duplicate(Q1);

        //ex2
        int average = avg(Q1);
        System.out.println("avg: " + average);

        //ex3
        int modCount = mod(Q1, 6);
        System.out.println("mod: " + modCount);

        //ex4
        Queue<Integer> Q2 = new Queue<Integer>();
        Q2.insert(1);
        Q2.insert(3);
        boolean dual = DualMod(Q1, Q2);
        System.out.println("DualMod: " + dual);

        //ex5
        boolean hasStreak = streak(Q1, 2);
        System.out.println("Streak: " + hasStreak);
    }

    //ex1
    public static Queue<Integer> Duplicate(Queue<Integer> original) 
    {
        Queue<Integer>copy=new Queue<Integer>();
        if(original.isEmpty())
            return copy;
        original.insert(null);
        while(original.head()!=null)
        {
            int temp=original.remove();
            copy.insert(temp);
            original.insert(temp);
        }
        original.remove();
        return copy;

    }

    //ex2
    public static int avg(Queue<Integer> original)
    {
        if(original.isEmpty()) return -1;
        int sum=0;
        int count=0;

        original.insert(null);
        while (original.head()!=null)
        {
            int temp=original.remove();
            count++;sum+=temp;
            original.insert(temp);
        }
        original.remove();
        return sum/count;
    }

    //ex3
    public static int mod(Queue<Integer>original,int num)
    {
        if(original.isEmpty()) return -1;

        int count=0;
        original.insert(null);
        while (original.head()!=null)
        {
            int temp=original.remove();
            original.insert(temp);
            if(num%temp==0)
            {
                count++;
            }
        }
        original.remove();
        return count;
    }

    //ex4
    public static boolean DualMod(Queue<Integer>queue1,Queue<Integer>queue2)
    {
        if (queue1.isEmpty() && queue2.isEmpty()) return false;
        boolean once=false;
        queue1.insert(null);
        while (queue1.head()!=null)
        {
            int temp1=queue1.remove();
            queue1.insert(temp1);
            
            queue2.insert(null);
            while (queue2.head()!=null)
            {
                int temp2=queue2.remove();
                queue2.insert(temp2);

                if(temp1%temp2==0) once=true;
            }
            if(once==false)return once;
            once=false;
            queue2.remove();
        }
        queue1.remove();
        return true;
    }

    //ex5
    public static boolean streak(Queue<Integer>original,int num)
    {
        if (original.isEmpty()) return false;
        
        int count=0;
        original.insert(null);
        while (original.head()!=null) 
        {
            int temp=original.remove();
            original.insert(temp);
            
            if(temp==num) 
                count++;
            else count=0;
            if(count>1) return true;
        }
        original.remove();
        return false;
    }
}
