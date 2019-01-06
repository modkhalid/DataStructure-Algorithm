
#include<iostream>
#include<math.h>
using namespace std;

int bt[int(pow(10,18))]={-1};

int getBeauty(long long int number){
    int beauty=0;
    while(number>0){
        if(bt[number]!=-1){
            beauty+=bt[number].data;
            break;
        }else{
            beauty+=(number&1);
            number/=2;
        }
        
    }
    return beauty;
}

void merge(int arr[],int l,int m,int r){
    int i,j,k;
    int n1=m-l+1;
    int n2=r-m;
    int L[n1],R[n2];
    for(i=0;i<n1;i++)
        L[i]=arr[l+i];
    for(j=0;j<n2;j++)
        R[j]=arr[m+1+j];
    i=0;j=0;k=l;
    while(i<n1 && j<n2){
        if(L[i]>=R[j]){
            arr[k]=L[i];
            i++;
        }else{
            arr[k]=R[j];
            j++;
        }
        k++;
    }
    while(i<n1){
        arr[k]=L[i];
        i++;k++;
    }
    while(j<n2){
        arr[k]=R[j];
        j++;k++;
    }
    
}
sort(int arr[],int l,int r){
    if(l<r){
        int m=(l+r)/2;
        sort(l,m);
        sort(m+1,r);
        merge(arr,l,m,r);
    }
}
int main(){
    int t;
    cin>>t;
    long long int arr[t],max=-1;
    int temp=t;
    // while(t>0){
    //     t--;
    //     cin>>arr[temp-t+1];
    //     if(max<arr[t])
    //         max=arr[t];
        
    // }
    for(int i=0;i<t;i++){
        cin>>arr[i];
        if(max<arr[i])
            max=arr[i];
    }
    // bt[0]=0;
    for(long long int i=1;i<max;i++){
        bt[i]=getBeauty(i);
        
    }
    sort(bt,0,max-1);
    for(int i=0;i<t;i++){
        long long int temp=arr[i];
        long long int counter=0;
        int sum=0;
        while(temp){
            sum+=bt[counter];
            counter++;
        }
        cout<<counter<<"\n";
    }
    
    
    
    
}





