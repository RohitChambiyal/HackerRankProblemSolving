package Non_Uploaded_Git;
// Java program to count minimum operations 
// required to remove an array 
class RemArrayPrime 
{ 

static final int MAX = 100005; 

// Return the cost to convert two 
// numbers into consecutive prime number. 
static int cost(int a, int b, 
				int prev[], int nxt[]) 
{ 
	int sub = a + b; 

	if (a <= b && prev[b - 1] >= a) 
	{ 
        System.out.println("in nxtb "+nxt[b] +" prev b-1 "+ prev[b - 1] +" a "+ a + " b "+b);
		return nxt[b] + prev[b - 1] - a - b; 
	} 

	a = Math.max(a, b); 
	a = nxt[a]; 
	b = nxt[a + 1]; 
    System.out.println("in a"+ a+" b "+b + " sub "+sub);
	return a + b - sub; 
} 

// Sieve to store next and previous 
// prime to a number. 
static void sieve(int prev[], int nxt[]) 
{ 
	int pr[] = new int[MAX]; 

	pr[1] = 1; 
	for (int i = 2; i < MAX; i++) 
	{ 
		if (pr[i] == 1) 
		{ 
			continue; 
		} 

		for (int j = i * 2; j < MAX; j += i) 
		{ 
			pr[j] = 1; 
		} 
	} 

	// Computing next prime each number. 
	for (int i = MAX - 2; i > 0; i--) 
	{ 
		if (pr[i] == 0) 
		{ 
			nxt[i] = i; 
		} 
		else
		{ 
			nxt[i] = nxt[i + 1]; 
		} 
	} 

	// Computing previous prime each number. 
	for (int i = 1; i < MAX; i++) 
	{ 
		if (pr[i] == 0) 
		{ 
			prev[i] = i; 
		} 
		else
		{ 
			prev[i] = prev[i - 1]; 
		} 
	} 
} 

// Return the minimum number 
// of operation required. 
static int minOperation(int arr[], int nxt[], 
						int prev[], int n) 
{ 
	int dp[][] = new int[n][n]; 

	// For each index. 
	for (int r = 0; r < n; r++) 
	{ 
		// Each subarray. 
		for (int l = r - 1; l >= 0; l -= 2) 
		{ 
			dp[l][r] = Integer.MAX_VALUE; 

			for (int ad = l; ad < r; ad += 2) 
			{ 
				dp[l][r] = Math.min(dp[l][r], dp[l][ad] + dp[ad + 1][r - 1] + cost(arr[ad], arr[r], prev, nxt)); 
			} 
		} 
    } 
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }

	return dp[0][n - 1] + n / 2; 
} 

// Driver Code 
public static void main(String args[]) 
{ 
	int arr[] = {1, 2, 4, 3}; 
	int n = arr.length; 

	int nxt[] = new int[MAX], prev[] = new int[MAX]; 
	sieve(prev, nxt); 

	System.out.println(minOperation(arr, nxt, prev, n)); 
} 
} 

// This code is contributed by 29AjayKumar 
