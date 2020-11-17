package 排序;

public class ArrayPrint {

    static String printlnArr(int[] arr) {
        String str1 = "{";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                str1 = str1 + arr[i];
            } else {
                str1 = str1 + ", " + arr[i];
            }
        }
        str1 = str1 + "}";
        return str1;
    }

}
/*
#include<stdio.h>
#include<stdbool.h>

bool compare(int a,int b){
    return a>b;
}

void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}
//基数排序
void radixsort(int arr[],int n,int flag){

    int radix=10;
    int cnt[10];
    int num=5;//位数
    int temp[n];

    for(int r=1,k=0;k<num;k++,r*=radix){
        for(int i=0;i<radix;i++){
            cnt[i]=0;
        }

        for(int j=0;j<n;j++){
            cnt[arr[j]/r%radix]++;
        }

        for(int j=1;j<radix;j++){
            cnt[j]=cnt[j]+cnt[j-1];
        }

        for(int j=n-1;j>=0;j--){
            cnt[arr[j]/r%radix]--;
            temp[cnt[arr[j]/r%radix]]=arr[j];
        }

        for(int j=0;j<n;j++){
            arr[j]=temp[j];
        }
    }

    for(int i=0;i<n;i++){
        if(flag)
            printf("%d ",arr[n-i-1]);
        else
            printf("%d ",arr[i]);
    }

    printf("\n");
}
//堆排序
void partition(int arr[],int n,int i,int flag){
    int j=2*i+1;
    if(flag){  //降序建小顶堆
        while(j<n){
            if(j+1<n&&arr[j+1]<arr[j]){ //左右子节点中找最小
                j++;
            }

            if(arr[j]>arr[i])
                break;
            swap(&arr[i],&arr[j]);

            i=j;
            j=j*2+1;
        }
    }else{ //升序建大顶堆
        while(j<n){
            if(j+1<n&&arr[j+1]>arr[j]){ //左右子节点中找最小
                j++;
            }

            if(arr[j]<arr[i])
                break;
            swap(&arr[i],&arr[j]);

            i=j;
            j=j*2+1;
        }
    }
}

void makeHeap(int arr[],int n,int flag){
    for(int j=(n-1)/2;j>=0;j--)
        partition(arr,n,j,flag);
}
void heapsort(int arr[],int n,int flag){
    makeHeap(arr,n,flag);
    for(int j=n-1;j>0;j--){
        swap(&arr[0],&arr[j]);
        partition(arr, j, 0, flag);
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}
//希尔排序
void shellsort(int arr[],int n,int flag){

    int incre=n/2;
    while(incre){
        for(int i=0;i<incre;i++){
            for(int j=i+incre;j<n;j+=incre){
                for(int k=j;k>i;k-=incre){
                    if(flag){
                        if(arr[k]>arr[k-incre]){
                            swap(&arr[k-incre],&arr[k]);
                        }
                        else{
                            break;
                        }
                    }else{
                        if(arr[k]<arr[k-incre]){
                            swap(&arr[k],&arr[k-incre]);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        incre/=2;
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}
//快速排序
int qpartition(int arr[],int left,int right,int flag){
    int pivot=left;
    int temp=arr[left];
    if(flag){
        while(left<right){
            while(right>left&&arr[right]<=temp)
                right--;
            while(right>left&&arr[left]>=temp)
                left++;
            if(left!=right)
                swap(&arr[left],&arr[right]);
        }

    }else{
        while(left<right){
            while(right>left&&arr[right]>=temp)
                right--;
            while(right>left&&arr[left]<=temp)
                left++;
            if(left!=right)
                swap(&arr[left],&arr[right]);
        }
    }
    swap(&arr[left],&arr[pivot]);
    return left;

}
int qspilt(int arr[],int left,int right,int flag){
    int pivot=left;
    int temp=arr[left];
    int index=left;
    if(flag){
        for(int i=left+1;i<=right;i++){
            if(arr[i]>=temp){
                index++;
                swap(&arr[index], &arr[i]);
            }
        }
    }else{
        for(int i=left+1;i<=right;i++){
            if(arr[i]<=temp){
                index++;
                swap(&arr[index], &arr[i]);
            }
        }
    }
    swap(&arr[left],&arr[index]);
    return index;

}
void solve(int arr[],int begin,int end,int flag){
    if(begin<end){
        int i=0;
        i=qpartition(arr, begin,end,flag);
        solve(arr,begin,i-1,flag);
        solve(arr,i+1,end,flag);
    }
}
void quicksort(int arr[],int n,int flag){

    solve(arr,0,n-1,flag);

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}



//归并排序
void merge(int arr[],int left,int middle,int right,int flag,int harr[]){
    int i=left,j=middle+1,k=0;
    while(i<=middle&&j<=right){
        if(compare(arr[i], arr[j])) {
            if (flag)
                harr[k++] = arr[i++];
            else
                harr[k++] = arr[j++];
        }
        else{
            if (flag)
                harr[k++] = arr[j++];
            else
                harr[k++] = arr[i++];
        }

    }
    while(i<=middle){
        harr[k++]=arr[i++];
    }

    while(j<=right){
        harr[k++]=arr[j++];
    }

    k=0;
    while(left<=right)
        arr[left++]=harr[k++];
}

void msort(int arr[],int left,int right,int flag,int harr[]){
    if(left<right) {
        int middle = (left + right) / 2;
        msort(arr, left, middle, flag, harr);
        msort(arr, middle+1, right, flag, harr);
        merge(arr, left, middle, right, flag, harr);
    }
}
void mergesort(int arr[],int n,int flag){

    int harr[n];
    int left=0,right=n-1;
    int middle=(left+middle)/2;
    msort(arr,0,n-1,flag,harr);
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}
//选择排序
void selectsort(int arr[],int n,int flag){
    int i,j;
    for(i=0;i<n;i++){
        int index=i;
        for(j=i+1;j<n;j++){
            if(flag){
                if(compare(arr[j], arr[index])){
                    index=j;
                }
            }
            else{
                if(compare(arr[index],arr[j])){
                    index=j;
                }
            }

        }
        int temp=arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}
//插入排序
void insertsort(int arr[],int n,int flag){
    int i,j;
    for(i=1;i<n;i++){
        int temp=arr[i];
        for(j=i;j>0;j--){
            if(flag){
                if(compare(arr[j-1], temp)){
                    break;
                }
            }
            else{
                if(compare(temp,arr[j-1])){
                    break;
                }
            }
            arr[j]=arr[j-1];
        }
        arr[j]=temp;
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}
//冒泡排序
void bubblesort(int arr[],int n,int flag){
    int i,j;
    for(i=0;i<n-1;i++){
        for(j=n-1;j>i;j--){
            if(flag){
                if(compare(arr[j], arr[j-1])){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
            else{
                if(compare(arr[j-1], arr[j])){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

    printf("\n");
}

int main(){
    int n,iSortFlag;
    while(scanf("%d",&n)!=EOF){
        int arr[n];
        for(int i=0;i<n;i++)
            scanf("%d",&arr[i]);

        scanf("%d",&iSortFlag);
        radixsort(arr, n, iSortFlag);
    }
    return 0;
}
* */
