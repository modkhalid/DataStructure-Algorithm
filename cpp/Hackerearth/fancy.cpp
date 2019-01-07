#include <iostream>
#include <string>
#include<algorithm>
void display(int arr[],int asize){
  for (size_t i = 0; i < asize; i++) {
    std::cout << arr[i] << ' ';
  }
  std::cout  << '\n';
}

int main(){
  int arr[]={1,4,5,6,3,1,2,3,78,1};
  display(arr,sizeof(arr)/sizeof(arr[0]));
  std::sort(arr,arr+sizeof(arr)/sizeof(arr[0]));
  display(arr,sizeof(arr)/sizeof(arr[0]));
  bool t=std::binary_search(arr,arr+sizeof(arr)/sizeof(arr[0]),1);
  std::cout << t << '\n';
}
