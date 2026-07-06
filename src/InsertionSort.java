import java.util.ArrayList;

public class InsertionSort {
	private int movimentacoes = 0;

	public void insertSort(ArrayList<TitleBasic> titles) {
		movimentacoes = 0;
		int in, out;
		
		for(out = 1; out < titles.size(); out++) {
			TitleBasic temp = titles.get(out);
			Integer anoTemp = temp.getStartYear();
			if (anoTemp == null) anoTemp = Integer.MAX_VALUE;
			
			in = out;
			
			while(in > 0) {
				Integer anoAnterior = titles.get(in - 1).getStartYear();
				if (anoAnterior == null) {
					anoAnterior = Integer.MAX_VALUE;
				}
				if (anoAnterior >= anoTemp) {
			        titles.set(in, titles.get(in - 1));
			        movimentacoes++;
			        in--;
			    } else {
			    	  break;
			    }
			}
			
			titles.set(in, temp);
			movimentacoes++;
		
		}
	}

	public int getMovimentacoes() {
		return movimentacoes;
	}
}
