<!--Heading-->
# Useing hash_algorithm

## Qusetion
___
<br/>

### 문제 설명
- 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
<br/>

### 제한사항
  - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
  - completion의 길이는 participant의 길이보다 1 작습니다.
  - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
  - 참가자 중에는 동명이인이 있을 수 있습니다.
<br/>
<br/>

## Code
____
<br/>

```Java
class Solution {
    final static int N_limit  = 100000;
    final static int hash_size= 1000;
    final static int hash_len = 400;
    final static int hash_value = 13;
    static String name;
        
    static String[][] s_data = new String[hash_size][hash_len];//데이터를 해시 맵으로 지정
    static int[][] repeat_data = new int[hash_size][hash_len];//해당 자료에 같은 데이터 중복횟수
    static int[] data_length = new int[hash_size];//해당 key에 저장된 자료 갯수 저장 
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
    
        int len_participant = participant.length;
        int len_completion = completion.length;
        int key = 0 ;
        
        for(int i = 0 ; i < len_completion ; i ++){//해시 데이터 작성
            name = completion[i];
            check(make_key(completion[i]),0);
        }
        
        //합격자 명단과 확인
        int result = 0;
        
        for(int i = 0 ; i < len_participant; i ++){
            name = participant[i];
            result = check(make_key(participant[i]),1);
            
            if(result == -2 || result == -1){
                answer = participant[i];
                break;
            }
            
        }
        
        return answer;
    }
    
    int make_key(String str){
        int key = 0;
        
        for(int i = 0;i<str.length();i++)
            key = (key * hash_value) + str.charAt(i) + hash_value;
        
        if (key < 0 )
            key = -key;
        
        return key%hash_size;
    }
    
    int check(int key,int case_num){
        int count_length = data_length[key];//key에 저장되어있는 데이터 갯수 
        
        if(count_length !=0 ){//해당 데이터가 있을때
            for(int i = 0  ; i < count_length ;  i++){
                if(name.equals(s_data[key][i])){
                    if(case_num == 0){
                        repeat_data[key][i]++;
                        return 1;
                    }
                    else
                        return repeat_data[key][i]--;// 중복은 하나 추가를 하는 상황이 아닐때
                }
            }
        }
        //해당 데이터가 없을떄 
        if(case_num == 0){
            s_data[key][data_length[key]++] = name;
            return 0;
        }
        else
            return -2;//데이터가 없고 추가를 하는 사항이 아닐때
    }
}
```
