public class Lab1
{
    public static void main(String args[])
    {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
        lab1.bonus();
    }
    void compulsory()
    {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n *= 3;
        n += 0b10101;
        n += 0xFF;
        n *= 6;

        while(n > 9)
        {
            int x = 0;
            while(n>0)
            {
                x = x + n % 10;
                n /= 10;
            }
            n = x;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
        System.out.println();
    }
    void homework(String args[])
    {
        long start = System.currentTimeMillis();

        if(args.length > 3)
            throw new IllegalArgumentException("Numar incorect de parametri!");

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if(a<0 || b<0 || k<0)
            throw new IllegalArgumentException("Parametrii trebuie sa fie pozitivi nenuli!");

        StringBuilder string = new StringBuilder();

        for(int i = a; i<= b; i++)
        {
            int x = i;
            while(x > 9)
            {
                int sum = 0;
                while(x > 0)
                {
                    sum += (x % 10) * (x % 10);
                    x /= 10;
                }
                x = sum;
            }
            if(x == k)
            {
                string.append(i);
                string.append(' ');
            }
        }

        System.out.println(string);


        long end = System.currentTimeMillis();
        long elapsedTimeMilli = end - start;

        System.out.println("Running time in Milliseconds: " + elapsedTimeMilli);
        System.out.println();
    }
    void bonus()
    {
        int n = 4;
        int [][] mat = new int[n+1][n+1];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                mat[i][j] = 0;
        for(int i = 0; i<n-1; i++)
            mat[i][n-1] = 1;
        for(int i = 0; i<n-1; i++)
            mat[n-1][i] = 1;
        for(int i = 0; i<n; i++)
        {
            if(i == 0)
            {
                mat[i][i+1] = 1;
                mat[i][n-2] = 1;
            }
            else if(i == n-2)
            {
                mat[i][0] = 1;
                mat[i][i-1] = 1;
            }
            else
            {
                mat[i][i+1] = 1;
                mat[i][i-1] = 1;
            }
        }

        for(int i = 0 ; i<n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(mat[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        System.out.println();
        int nr = 1;
        StringBuilder currentCycle = new StringBuilder();

        for(int i = 1; i<n; i++)
        {
            currentCycle.append(i);
            currentCycle.append(' ');
        }
        currentCycle.append(1);
        System.out.println("Cycle " + nr + ": " + currentCycle);
        currentCycle.setLength(0);


        for(int i = 1; i < n - 1; i++)
            for(int j = i + 1; j < n; j++)
            {
                currentCycle.append(i);
                currentCycle.append(' ');
                currentCycle.append(n);
                currentCycle.append(' ');
                currentCycle.append(j);
                currentCycle.append(' ');

                for(int k = j-1; k >= i; k--)
                {
                    currentCycle.append(k);
                    currentCycle.append(' ');
                }

                nr++;
                System.out.println("Cycle " + nr + ": " + currentCycle);
                currentCycle.setLength(0);

                currentCycle.append(i);
                currentCycle.append(' ');
                currentCycle.append(n);
                currentCycle.append(' ');
                currentCycle.append(j);
                currentCycle.append(' ');

                for(int k = (j+1)%n; k!=i; k=(k+1)%n)
                {
                    if(k!=0)
                    {
                        currentCycle.append(k);
                        currentCycle.append(' ');
                    }

                }
                currentCycle.append(i);

                nr++;
                System.out.println("Cycle " + nr + ": " + currentCycle);
                currentCycle.setLength(0);
            }
        System.out.println();

        if(nr == n*n - 3*n + 3)
            System.out.println("The number of cycles is correct!");
    }
}
