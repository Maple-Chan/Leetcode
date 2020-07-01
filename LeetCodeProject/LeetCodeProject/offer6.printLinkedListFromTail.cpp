//#define offer6
#ifdef offer6

 #include <vector>
 #include <stack>
 #include <iostream>
 using namespace std;


 /*
	 ����һ�������������β��ͷ��˳�򷵻�һ��ArrayList��
 */

 /**
 *
 */


 struct ListNode {
         int val;
         struct ListNode *next;
         ListNode(int x) :
               val(x), next(NULL) {
         }
  };

 class Solution {
 public:
     /**
      * ����������ÿ��Ԫ�ش��������У�������vector����
      * 
     */
     vector<int> printListFromTailToHead(ListNode* head) {

		 ListNode* curptr = head;
		 stack<ListNode*> list2stack;
		 vector<int> retvector;

		 if (curptr == NULL) {
			 /*�׳��쳣������*/
			 return retvector;
		 }


		 list2stack.push(curptr);
         while (curptr->next != NULL)
         {
             /* code */
             list2stack.push(curptr->next);
             curptr = curptr->next;
         }

         while (!list2stack.empty())
         {
			 /* code */
             int data = list2stack.top()->val;list2stack.pop();
             retvector.push_back(data);
             
         }
		 //vector<int>::iterator itr;
		 //for(itr = retvector.begin();itr != retvector.end();++itr)
		 //{
			// cout << *(itr) << endl;
		 //}

         return retvector;
     }

     ListNode* createList(vector<int> vec){
         if(vec.empty()){
             return nullptr;
         }

         size_t sizevec = vec.size();
         int passData = 0;
         ListNode* Head = new ListNode(vec[passData]);
         ListNode* curptr = Head;
         passData ++ ;


         ListNode* newNode = nullptr;
         while (passData < sizevec)
         {
             /* code */
             newNode = new ListNode(vec[passData]);
             curptr->next = newNode;
             curptr = newNode;
			 passData++;
         }
         return Head;
     }
 };


 /*
     ���Ժ���
 */
 int main(){
     vector<int> vec = {2,3,5,7,10,4,5};
     Solution so;
     ListNode* head = so.createList(vec);

	 so.printListFromTailToHead(head);

	 // ��ʾ��������
     ListNode* cur = head;
     cout << head->val<<endl;
     while (cur->next != NULL)
     {
         /* code */
         cout << cur->next->val << endl;
         cur = cur->next;
     }

	 system("pause");


     return 0;
 }


#endif offer6