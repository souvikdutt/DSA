#include<bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    struct ListNode {
       int val;
       ListNode *next;
       ListNode() : val(0), next(nullptr) {}
       ListNode(int x) : val(x), next(nullptr) {}
       ListNode(int x, ListNode *next) : val(x), next(next) {}
     };
    ListNode* rotateRight(ListNode* head, int k) {
        if(head==NULL || head->next==NULL || k==0) return head;
        int n = 1;
        ListNode* temp = head;
        
        while(temp->next!=NULL) {
            n++;
            temp = temp->next;
        }
        
        temp->next = head;
        k = n - (k%n);
        while(k-- > 0) temp=temp->next;
        
        head = temp->next;
        temp->next = NULL;
        
        return head;
    }
};