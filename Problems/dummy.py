# Dynamic Programming Python implementation of Matrix 
# Chain Multiplication. See the Cormen book for details 
# of the following algorithm 
import sys 
  
# Matrix Ai has dimension p[i-1] x p[i] for i = 1..n 
  
  
def MatrixChainOrder(p, n): 
    # For simplicity of the program,  
    # one extra row and one 
    # extra column are allocated in m[][].   
    # 0th row and 0th 
    # column of m[][] are not used 
    m = [[0 for x in range(n)] for x in range(n)] 
    s = [[0 for x in range(n)] for x in range(n)] 
  
    # m[i, j] = Minimum number of scalar  
    # multiplications needed 
    # to compute the matrix A[i]A[i + 1]...A[j] =  
    # A[i..j] where 
    # dimension of A[i] is p[i-1] x p[i] 
  
    # cost is zero when multiplying one matrix. 
    for i in range(1, n): 
        m[i][i] = 0

    for i in range(1, n): 
        s[i][i] = 0
  
    # L is chain length. 
    for L in range(2, n): 
        for i in range(1, n-L + 1): 
            j = i + L-1
            m[i][j] = 1000000;
            for k in range(i, j): 
  
                # q = cost / scalar multiplications 
                q = m[i][k] + m[k + 1][j] + p[i-1]*p[k]*p[j] 
                if q < m[i][j]: 
                    s[i][j] = k
                    m[i][j] = q 
    for i in range(len(m)):
      print(m[i])

    for i in range(len(m)):
      print(s[i])
    return m[1][n-1] 
  
  
# Driver code 
arr = [10, 20, 1, 40, 5, 30 , 15] 
size = len(arr) 
  
print("Minimum number of multiplications is " +
      str(MatrixChainOrder(arr, size))) 
# This Code is contributed by Bhavya Jain 
