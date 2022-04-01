# java-pong

[Link para o vídeo de demonstração](https://youtu.be/h_yZjS4hur8).

<img src="https://img.youtube.com/vi/h_yZjS4hur8/maxresdefault.jpg" width="50%" height="50%" />

## Detalhes sobre posições relativas

* Posicionamento inicial X do jogador 2:

_Resultado = LarguraJanela - LarguraDesenho_

* Alinhamento no centro vertical da janela (usos: Janela, ThreadJogo, desenhos da bola e jogadores):

_Resultado = (AlturaJanela - AlturaDesenho)/2_

* Alinhamento no centro horizontal da janela (apenas para a bola):

_Resultado = (LarguraJanela - LarguraDesenho)/2_

* Restrições de movimentação (em ThreadJogador):

_yMinimo = 0_  
_yMaximo = AlturaJanela - AlturaDesenho_

* Condições de escape da bola (em ThreadJogo):

_ResultEsquerda = Condição: (xBola + LarguraBola) <= 0?_  
_ResultDireita = Condição: (xBola - LarguraBola) >= LarguraJanela?_

* Detecção de colisão nos limites superior e inferior da janela:

_ResultCima = Condição: (yBola <= 0)?_  
_ResultBaixo = Condição: (yBola >= AlturaJanela - AlturaBola)?_
