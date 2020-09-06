import java.util.*;
class Oblig3{

  public int[] seleksjon(int[] list){


    for(int i = 0; i < list.length; i++){
        int lagreVerdi = list[i];
        int talletNu= list[i];
        int lagreIndex= i;
            for(int j = i+1; j < list.length; j++ ){
              if(talletNu > list[j]){
                talletNu = list[j];
                lagreIndex = j;
              }
            }

        list[i] = talletNu;
        list[lagreIndex] = lagreVerdi;
    }

    return list;
  }


  public int[] insertsjon(int[] list){

    for(int i = 0; i < list.length; i++){

        int talletNu= list[i];
        for(int j = i ; j >= 0 ; j--){
          int lagreVerdi = list[j];
            if( talletNu < list[j]){
                list[j]= talletNu;
                list[j+1]= lagreVerdi;
            }
        }

      }

    return list;
  }

	void quickSort(int[] array, int fra, int til){
		if(fra <= til){
			int a= del(array,fra,til);
			quickSort(array, fra, a-1);
			quickSort(array,a+1, til);
			
		}
	}
	
	private static int faPivot(int lav, int hoy){
		Random r = new Random();
		return r.nextInt((hoy-lav)+1) + lav;
	}

	int del(int[] array, int fra, int til){
		int pivot = faPivot( fra, til);
		int verdi = array[fra];
		array[fra]= array[pivot];
		array[pivot] = verdi;
		
		int j = fra+1;
		for(int i = j; i<=til; i++){
			if(array[i] < array[fra]){
				int lagre = array[i];
				array[i] = array[j];
				array[j] = lagre;
				j++;
			}
			
		}
		int lagre = array[fra];
				array[fra] = array[j-1];
				array[j-1] = lagre;
				return j-1;
		
		
		
	}
	


  public int[] bucketSort(int[] list){ //antar at tallene er positive
    int lengde= list.length;

    // finne min og maks
    int min = list[0];
    int max = list[0];
    for (int i = 1; i < list.length; i++) {
        if (list[i] < min) {
            min = list[i];
        } else if (list[i] >= max) {
            max = list[i];
        }
    }

    //deretter lager vi midlertidig [] og setter inn verdiene i list
    ArrayList<ArrayList<Integer>> midlertidig = new ArrayList<ArrayList<Integer>>();

    for(int a = min ; a <= max ; a++){

           midlertidig.add(a, new ArrayList<Integer>());
    }

    for(int j = 0; j < lengde; j++ ){
        int tallverdi = list[j];
        midlertidig.get(tallverdi).add(tallverdi);
        list[j] = 0; //tømmer listen vi fikk inn
    }

    //til slutt sett vi tilbake til listen
    int index = 0;
	for(ArrayList<Integer> a : midlertidig){
      if(a.isEmpty() == false){
              for(Object o : a ){
                int c = Integer.parseInt(o.toString());
                list[index++] = c;
               
              }

		}
	}

return list;
}



}
