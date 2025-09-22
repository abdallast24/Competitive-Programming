#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n,m,type,left,right;
    cin>>n;
    long long arr[n+1],sorted[n+1],ans;
    for(int i=1;i<=n;i++)
    {
        cin>>sorted[i];
        arr[i]=sorted[i] + arr[i-1];
    }

    sort(sorted+1,sorted+n+1);
    for(int i=1;i<=n;i++)
        sorted[i]+=sorted[i-1];

    cin>>m;
    while(m--)
    {
        cin>>type;
        cin>>left;
        cin>>right;

        if(type==1)
            cout<<arr[right]-arr[left-1]<<"\n";
        else
            cout<<sorted[right]-sorted[left-1]<<"\n";

    }


    return 0;
}
