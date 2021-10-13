import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AbreviandoPostsBlog {

    protected static Map<String, Integer> ocorrencias;
    //protected static Map<String, Integer> subtraidas;
    protected static Map<Character, String> abreviacoes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;

        while (!".".equals(linha = br.readLine())) {
            StringTokenizer stringTokenizer = new StringTokenizer(linha);
            ocorrencias = new HashMap<>();
            //subtraidas  = new HashMap<>();
            abreviacoes = new TreeMap<>();
            while (stringTokenizer.hasMoreTokens()) {
                String palavra = stringTokenizer.nextToken();
                if (palavra.length() > 2) {
                    ocorrencias.put(palavra, ocorrencias.containsKey(palavra) ? ocorrencias.get(palavra) + 1 : 1);
                    abreviacoes.put(palavra.charAt(0), melhorAbrv(palavra));
                }
            }
            //subtraidas = ocorrencias.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, o -> o.getValue()*(o.getKey().length() - 2)));
            //abreviacoes = subtraidas.keySet().stream().collect(Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1,(s1, s2) -> subtraidas.get(s1) > subtraidas.get(s2) ? s1 : s2, HashMap::new));

            for (Character c : abreviacoes.keySet()) {
                linha = linha.replaceAll("\\b" + abreviacoes.get(c) + "\\b", " " + c + ". ");
            }
            System.out.println(linha.trim());
            System.out.println(abreviacoes.size());
            abreviacoes.entrySet().stream().map(abrv ->  abrv.getKey() + ". = " + abrv.getValue()).forEach(System.out::println);
        }
    }

    private static String melhorAbrv(String palavra) {
        if (!abreviacoes.containsKey(palavra.charAt(0))) {
            return palavra;
        }
        String abrv = abreviacoes.get(palavra.charAt(0));
        int reducaoAbrv = ocorrencias.get(abrv) * (abrv.length() - 2);
        int reducaoPalavra = ocorrencias.get(palavra) * (palavra.length() - 2);
        return reducaoPalavra > reducaoAbrv ? palavra : abrv;
    }
}