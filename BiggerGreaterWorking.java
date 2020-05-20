import java.util.Arrays;
import java.util.Scanner;

public class BiggerGreaterWorking {
    static String biggerIsGreater(String w) {
        char word[] = w.toCharArray();
        int first=-1;
        int second =-1;
        boolean check = false;
        for (int j = word.length - 1; j >= 0; j--){
            for (int i = j; i >= 0; i--){
                if (word[i] < word[j] && i > first){
                    first = i;
                    second = j;
                } 
                else if(j<first){
                    check = true;
                    break;
                }
            }
            if(check == true)
                break;
        }
    
        if (first == second)
            return "no answer";
        else {
            char temp = word[first];
            word[first] = word[second];
            word[second] = temp;
            Arrays.sort(word,first + 1,word.length);
            return new String(word);
        }
        }
    
    
    public static void main(String[] args){
         int t =0;
        String[] cases = new String[100];
        Scanner s = new Scanner(System.in);
        while(t!=100){
        cases[t++]= s.nextLine();
        }
        t=0;
        String[] sol= new String[100];
        while(t!=100){
            sol[t++]= s.nextLine();
            }
        t=0;
        while(t!=100){
        String x= biggerIsGreater(cases[t]);
        if(!x.equals(sol[t]))
            System.out.println("------Case: "+cases[t]+"\nWrong Answer: "+ x+"\nRight Answer: "+sol[t]);
        t++;
     }
     
    // String r =BiggerGreaterperm("xildrrhpca");
    // System.out.println(r);
}
}
/*
test cases


imllmmcslslkyoegymoa
fvincndjrurfh
rtglgzzqxnuflitnlyit
mhtvaqofxtyrz
zalqxykemvzzgaka
wjjulziszbqqdcpdnhdo
japjbvjlxzkgietkm
jqczvgqywydkunmjw
ehdegnmorgafrjxvksc
tydwixlwghlmqo
wddnwjneaxbwhwamr
pnimbesirfbivxl
mijamkzpiiniveik
qxtwpdpwexuej
qtcshorwyck
xoojiggdcyjrupr
vcjmvngcdyabcmjz
xildrrhpca
rrcntnbqchsfhvijh
kmotatmrabtcomu
bnfcejmyotvw
dnppdkpywiaxddoqx
tmowsxkrodmkkra
jfkaehlegohwggf
ttylsiegnttymtyx
kyetllczuyibdkwyihrq
xdhqbvlbtmmtshefjf
kpdpzzohihzwgdfzgb
kuywptftapaa
qfqpegznnyludrv
ufwogufbzaboaepslikq
jfejqapjvbdcxtkry
sypjbvatgidyxodd
wdpfyqjcpcn
baabpjckkytudr
uvwurzjyzbhcqmrypraq
kvtwtmqygksbim
ivsjycnooeodwpt
zqyxjnnitzawipqsm
blmrzavodtfzyepz
bmqlhqndacv
phvauobwkrcfwdecsd
vpygyqubqywkndhpzw
yikanhdrjxw
vnpblfxmvwkflqobrk
pserilwzxwyorldsxksl
qymbqaehnyzhfqpqprpl
fcakwzuqlzglnibqmkd
jkscckttaeifiksgkmxx
dkbllravwnhhfjjrce
imzsyrykfvjt
tvogoocldlukwfcajvix
cvnagtypozljpragvlj
hwcmacxvmus
rhrzcpprqccf
clppxvwtaktchqrdif
qwusnlldnolhq
yitveovrja
arciyxaxtvmfgquwb
pzbxvxdjuuvuv
nxfowilpdxwlpt
swzsaynxbytytqtq
qyrogefleeyt
iotjgthvslvmjpcchhuf
knfpyjtzfq
tmtbfayantmwk
asxwzygngwn
rmwiwrurubt
bhmpfwhgqfcqfldlhs
yhbidtewpgp
jwwbeuiklpodvzii
anjhprmkwibe
lpwhqaebmr
dunecynelymcpyonjq
hblfldireuivzekegit
uryygzpwifrricwvge
kzuhaysegaxtwqtvx
kvarmrbpoxxujhvgpw
hanhaggqzdpunkugzmhq
gnwqwsylqeuqr
qzkjbnyvclrkmdtc
argsnaqbquv
obbnlkoaklcx
ojiilqieycsasvqosycu
qhlgiwsmtxbffjsxt
vvrvnmndeogyp
ibeqzyeuvfzb
sajpyegttujxyx
zmdjphzogfldlkgbchnt
tbanvjmwirxx
gmdhdlmopzyvddeqyjja
yxvmvedubzcpd
soygdzhbckfuk
gkbekyrhcwc
wevzqpnqwtpfu
rbobquotbysufwqjeo
bpgqfwoyntuhkvwo
schtabphairewhfmp
rlmrahlisggguykeu
fjtfrmlqvsekq
imllmmcslslkyoegyoam
fvincndjrurhf
rtglgzzqxnuflitnlyti
mhtvaqofxtyzr
zalqxykemvzzgkaa
wjjulziszbqqdcpdnhod
japjbvjlxzkgietmk
jqczvgqywydkunmwj
ehdegnmorgafrjxvsck
tydwixlwghlomq
wddnwjneaxbwhwarm
pnimbesirfbixlv
mijamkzpiiniveki
qxtwpdpwexuje
qtcshorwykc
xoojiggdcyjrurp
vcjmvngcdyabcmzj
xildrrpach
rrcntnbqchsfhvjhi
kmotatmrabtcoum
bnfcejmyotwv
dnppdkpywiaxddoxq
tmowsxkrodmkrak
jfkaehlegowfggh
ttylsiegnttymxty
kyetllczuyibdkwyiqhr
xdhqbvlbtmmtshejff
kpdpzzohihzwgdgbfz
kuywptftpaaa
qfqpegznnyludvr
ufwogufbzaboaepsliqk
jfejqapjvbdcxtkyr
sypjbvatgiodddxy
wdpfyqjcpnc
baabpjckkyturd
uvwurzjyzbhcqmryprqa
kvtwtmqygksbmi
ivsjycnooeodwtp
zqyxjnnitzawipsmq
blmrzavodtfzyezp
bmqlhqndavc
phvauobwkrcfwdedcs
vpygyqubqywkndhwpz
yikanhdrwjx
vnpblfxmvwkflqokbr
pserilwzxwyorldsxlks
qymbqaehnyzhfqpqrlpp
fcakwzuqlzglnidbkmq
jkscckttaeifiksgkxmx
dkbllravwnhhfjjrec
imzsyrykfvtj
tvogoocldlukwfcajvxi
cvnagtypozljprajglv
hwcmacxvsmu
rhrzcpprqcfc
clppxvwtaktchqrfdi
qwusnlldnolqh
yitverajov
arciyxaxtvmfgqwbu
pzbxvxdjuuvvu
nxfowilpdxwltp
swzsaynxbytyttqq
qyrogefletey
iotjgthvslvmjpcchufh
knfpyjtzqf
tmtbfayantwkm
asxwzygnngw
rmwiwrurutb
bhmpfwhgqfcqfldlsh
yhbidtewppg
jwwbeuiklpodziiv
anjhprmkwieb
lpwhqaebrm
dunecynelymcpyonqj
hblfldireuivzekegti
uryygzpwifrriecgvw
kzuhaysegaxtwqtxv
kvarmrbpoxxujhvgwp
hanhaggqzdpunkugzmqh
gnwqwsylqeurq
qzkjbnyvclrkmtcd
argsnaqbqvu
obbnlkoaklxc
ojiilqieycsasvqosyuc
qhlgiwsmtxbffjtsx
vvrvnmndeopgy
ibeqzyeuvzbf
sajpyegttujyxx
zmdjphzogfldlkgbchtn
tbanvjmwixrx
gmdhdlmopzyvddeyajjq
yxvmvedubzdcp
soygdzhbckkfu
gkbekyrhwcc
wevzqpnqwtpuf
rbobquotbysufwqjoe
bpgqfwoyntuhkwov
schtabphairewhfpm
rlmrahlisggguykue
fjtfrmlqvseqk






*/ 
