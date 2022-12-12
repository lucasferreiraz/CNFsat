O projeto **CNFsat** foi desenvolvido por **Lucas Ferreira dos Santos** e **Walyson Rodrigo da Silva** durante a disciplina **Lógica para Computação** ministrada pelo professor **Thiago Alves** do curso de Ciências da Computação do Instituto Federal de Educação, Ciência e Tecnologia do Ceará (IFCE), Campus Maracanaú.

<table style="margin:auto; text-align: center;">
    <tr>
        <th style="text-align: center;">arquivo</th>
        <th style="text-align: center;">nº mínimo de regras</th>
        <th style="text-align: center;">regras obtidas</th>
        <th style="text-align: center;">tempo médio de execução</th>
    </tr>
    <tr>
        <td>column_bin_3a_2p.csv</td>
        <td>1</td>
        <td>[[PI > 42.09, PI > 48.12, PI > 54.92] ⇒ P]</td>
        <td>777ms</td>
    </tr>
    <tr>
        <td>column_bin_3a_3p.csv</td>
        <td>1</td>
        <td>[[PI > 42.09, PI > 70.62] ⇒ P]</td>
        <td>750ms</td>
    </tr>
    <tr>
        <td>column_bin_3a_4p.csv</td>
        <td>2</td>
        <td>[[PI > 42.09, LA > 39.63, GS > 37.89] ⇒ P, <br>[PI > 42.09, LA <= 39.63, GS <= 37.89] ⇒ P]</td>
        <td>779ms</td>
    </tr>
    <tr>
        <td>column_bin_3a_5p.csv</td>
        <td>1</td>
        <td>[[PI > 42.09, GS > 37.89] ⇒ P]</td>
        <td>852ms</td>
    </tr>
    <tr>
        <td>column_bin_3a_6p.csv</td>
        <td>2</td>
        <td>[[PI > 42.09, LA > 39.63] ⇒ P, <br>[PI <= 42.09, LA > 39.63, GS <= 37.89] ⇒ P]</td>
        <td>800ms</td>
    </tr>
    <tr>
        <td>column_bin_5a_3p.csv</td>
        <td>1</td>
        <td>[[PI > 42.09, PI > 70.62, GS > 37.89] ⇒ P]</td>
        <td>859ms</td>
    </tr>
    <tr>
        <td>column_bin_6a_6p.csv</td>
        <td>1</td>
        <td>[[PI > 42.09, PI > 48.12, PI > 54.92, PI > 63.52] ⇒ P]</td>
        <td>783ms</td>
    </tr>
    <tr>
        <td>column_bin_8a_8p.csv</td>
        <td>3</td>
        <td>[[LA > 39.63, PI > 48.12, PI > 54.92, PI <= 70.62, PI <= 80.61, PT > 8.31, PT > 12.36] ⇒ P, <br>[LA <= 39.63, PI > 48.12, PI > 54.92, PI > 63.52, PI > 70.62, PI <= 80.61, PT > 8.31, PT > 12.36] ⇒ P, <br>[LA > 39.63, PI > 48.12, PI > 54.92, PI > 63.52, PI > 70.62, PI > 80.61, PT > 8.31, PT > 12.36] ⇒ P]</td>
        <td>824ms</td>
    </tr>
    <tr>
        <td>column_bin_10a_10p.csv</td>
        <td>3</td>
        <td>[[PI > 48.12, PI > 54.92, PI > 63.52, PI > 70.62, PT > 8.31, PT > 12.36, PT > 14.55, GS > 37.89] ⇒ P, <br>[LA > 39.63, PI > 48.12, PI <= 54.92, PI <= 63.52, PI <= 70.62, PI <= 80.61, PT <= 8.31, PT <= 12.36, PT <= 14.55, GS <= 37.89] ⇒ P, <br>[LA > 39.63, PI > 48.12, PI > 54.92, PI > 63.52, PI <= 70.62, PI <= 80.61, PT > 8.31, PT > 12.36, PT <= 14.55, GS <= 37.89] ⇒ P]</td>
        <td>972ms</td>
    </tr>
    <tr>
        <td>column_bin_11a_14p.csv</td>
        <td>2</td>
        <td>[[PI > 48.12, PI > 54.92, PT > 8.31, PT > 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PI > 63.52, PI > 70.62, PT > 8.31, PT > 12.36, PT > 14.55, PT > 17.44] ⇒ P]</td>
        <td>857ms</td>
    </tr>
    <tr>
        <td>column_bin_11a_15p.csv</td>
        <td>3</td>
        <td>[[PI > 48.12, PI <= 63.52, PI <= 80.61, PT > 8.31, PT <= 17.44] ⇒ P, <br>[PI > 42.09, PI > 54.92, PI <= 70.62, PT > 8.31] ⇒ P, <br>[PI <= 42.09, PI <= 63.52, PI <= 80.61, PT > 8.31] ⇒ P]</td>
        <td>976ms</td>
    </tr>
    <tr>
        <td>column_bin_12a_16p.csv</td>
        <td>2</td>
        <td>[[PI > 48.12, PT > 8.31, PT > 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PT > 8.31, PT > 12.36, PT > 14.55, PT > 17.44] ⇒ P]</td>
        <td>949ms</td>
    </tr>
    <tr>
        <td>column_bin_15a_19p.csv</td>
        <td>2</td>
        <td>[[PI > 54.92, PT > 8.31, PT > 12.36, PT > 14.55, PT > 17.44, LA > 32.59, LA > 39.63, LA > 46.33] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PI <= 70.62, PI <= 80.61, PT > 8.31, PT > 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63] ⇒ P]</td>
        <td>927ms</td>
    </tr>
    <tr>
        <td>column_bin_16a_23p.csv</td>
        <td>3</td>
        <td>[[PI > 42.09, PI > 48.12, PI > 54.92, PI <= 70.62, PT > 8.31, PT > 12.36, PT <= 17.44, PT <= 21.06, LA > 46.33, LA > 52.68] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PT > 8.31, PT > 17.44, LA > 32.59, LA > 39.63, LA > 46.33] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PI > 80.61, PT > 8.31, PT > 14.55, PT <= 17.44, LA > 39.63, LA > 46.33] ⇒ P]</td>
        <td>1182ms</td>
    </tr>
    <tr>
        <td>column_bin_18a_28p.csv</td>
        <td>4</td>
        <td>[[PI > 42.09, PT > 17.44, LA > 32.59, LA > 39.63, LA > 46.33] ⇒ P, <br>[PI > 54.92, PT > 8.31, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63, LA > 46.33, LA > 52.68, LA > 61.27] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI > 54.92, PI <= 70.62, PI <= 80.61, PT > 8.31, PT <= 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63, LA <= 61.27, LA <= 74.10] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI <= 54.92, PI <= 63.52, PI <= 70.62, PI <= 80.61, PT <= 8.31, PT <= 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06, LA > 32.59, LA > 39.63, LA > 46.33, LA > 52.68, LA <= 61.27, LA <= 74.10] ⇒ P]</td>
        <td>1310ms</td>
    </tr>
    <tr>
        <td>column_bin_20a_30p.csv</td>
        <td>4</td>
        <td>[[PI > 42.09, PT > 8.31, PT > 17.44, LA > 32.59, LA > 39.63] ⇒ P, <br>[PI > 54.92, PT > 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63, LA > 46.33, LA > 52.68, LA > 61.27, SS > 29.51, SS > 34.38] ⇒ P, <br>[PI > 48.12, PI <= 70.62, PI <= 80.61, PT > 8.31, PT > 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63, LA <= 61.27, LA <= 74.10, SS > 29.51, SS > 34.38] ⇒ P, <br>[PI > 42.09, PI > 48.12, PI <= 54.92, PI <= 63.52, PI <= 70.62, PI <= 80.61, PT <= 8.31, PT <= 12.36, PT <= 14.55, PT <= 17.44, PT <= 21.06, PT <= 28.68, LA > 32.59, LA > 39.63, LA > 46.33, LA > 52.68, LA <= 74.10, SS > 34.38] ⇒ P]</td>
        <td>1273ms</td>
    </tr>

</table>

## Comparando os dois últimos arquivos:

O arquivo **column_bin_36a_155p.csv** obteve o seguinte resultado:

<table style="margin:auto; text-align: center;">
    <tr>
        <th style="text-align: center;">arquivo</th>
        <th style="text-align: center;">nº mínimo de regras</th>
        <th style="text-align: center;">regras obtidas</th>
        <th style="text-align: center;">tempo médio de execução</th>
    </tr>
    <tr>
        <td>column_bin_36a_155p.csv</td>
        <td>9</td>
        <td>[[PI <= 48.12, PI <= 70.62, PI <= 80.61, PT > 8.31, PT <= 14.55, PT <= 17.44, SS <= 56.31, GS > 2.10, GS <= 37.89] ⇒ P, <br>[PI > 54.92, GS > 6.42] ⇒ P, <br>[PI <= 48.12, PT > 8.31, PT > 12.36, PT <= 17.44, LA <= 39.63, RP <= 124.89, GS > -0.74] ⇒ P, <br>[SS <= 44.44, RP <= 111.98, RP <= 124.89] ⇒ P, <br>[PI <= 48.12, PI <= 80.61, LA <= 32.59, SS <= 39.81, SS <= 56.31, RP <= 120.08, RP <= 130.30] ⇒ P, <br>[PT > 14.55, LA > 32.59, SS <= 56.31, RP <= 124.89, GS <= 2.10, GS <= 6.42] ⇒ P, <br>[PI <= 80.61, PT <= 12.36, SS <= 29.51, SS <= 44.44, RP > 124.89] ⇒ P, <br>[PI <= 48.12, PT > 12.36, PT > 17.44, LA <= 39.63, SS <= 56.31, GS <= 2.10] ⇒ P, <br>[PI > 48.12, PT > 14.55, LA > 32.59, SS <= 39.81, RP <= 130.30, GS > -0.74] ⇒ P]</td>
        <td>11.839s</td>
    </tr>
</table>

O conjunto de regras gerado pelo arquivo acima gera [este relatório](/src/records/36a_155p_record.txt) que possui uma taxa de acertos de 100% como esperado, visto que o resultado do laudo dos pacientes deste mesmo arquivo obedece as regras geradas pelo mesmo arquivo.

Entretanto, ao aplicar o conjunto de regras gerado pelo arquivo acima no conjunto de valores do arquivo **column_bin_36a_155p_test.csv** é notório uma discrepância no diagnóstico de alguns pacientes do arquivo citado como é possível ver [neste relatório](/src/records/36a_155p_test_record.txt) gerado.

Comparando os dois relatórios, é possível quantificar que a discrepância é de 24 pacientes de um total de 155. Ou seja, **15,48387%** dos diagnósticos não obedecem ao conjunto de regras aplicado, desta forma, possuindo uma taxa de acerto de **84,51612%.**