    #include<bits/stdc++.h>
    using namespace std;
    const int m = 1E+5;
    vector<int> a,l,r;
    int pre[m];
     
    int main(){
        int t,i,j,ans,n;
        cin>>t;
        while(t--){
            string s;
            int x,y;
            cin>>n>>s;
            ans = 1;
            
            for(i=0;i<26;i++){
                
                memset(pre,0, sizeof(pre));
                int cnt = 0;
                for(j=0;j<n;j++){
                    if(s[j]-'a' == i)
                        cnt++;
                    pre[j] = cnt;
                }
     
                // creating L[i] = 2*pre[i-1]-i and R[i] = 2*pre[i]-i
     
                for(j=0;j<n;j++){
                  l.push_back(2 * pre[j-1] - j);
                  r.push_back(2 * pre[j]- j);
                }
                int max_len = INT_MIN;
                int min_val = INT_MAX;
     
                for(j=0;j<n;j++){
                    min_val= min(min_val, l[j]);
                    a.push_back(min_val);
                                   
                    x=0, y=j;
                    while(x<=y){
     
                        int mid =(x+y)>>1;
                        if(a[mid]<= r[j]){
                            max_len = max(max_len,j-mid+1);
                            y=mid-1;
                        }
                        else{
                            x = mid+1;
                        }
                    }
     
                
                }
                ans = max(ans,max_len);
                a.clear();
                l.clear();
                r.clear();
     
            }
     
            cout<<ans<<endl;
     
     
     
     
        }
     
     
        return 0;
    }