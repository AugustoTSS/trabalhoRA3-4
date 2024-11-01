import pandas as pd
import matplotlib.pyplot as plt
import os

# Carregar os dados do CSV
df = pd.read_csv("resultados.csv")

# Criar diretório para salvar os gráficos
output_dir = "graficos_resultados"
os.makedirs(output_dir, exist_ok=True)

# Obter tamanhos únicos
tamanhos = df["Tamanho"].unique()

# Loop para gerar gráficos para cada tamanho de entrada
for tamanho in tamanhos:
    # Filtrar dados para o tamanho específico
    df_tamanho = df[df["Tamanho"] == tamanho]

    # Gráfico de Tempo de Execução
    plt.figure(figsize=(10, 6))
    plt.bar(df_tamanho["Algoritmo"], df_tamanho["TempoExecucao"], color='skyblue')
    plt.title(f"Tempo de Execução para Tamanho {tamanho}")
    plt.xlabel("Algoritmo")
    plt.ylabel("Tempo de Execução (ms)")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig(f"{output_dir}/tempo_execucao_{tamanho}.png")
    plt.close()

    # Gráfico de Número de Trocas
    plt.figure(figsize=(10, 6))
    plt.bar(df_tamanho["Algoritmo"], df_tamanho["NumeroTrocas"], color='salmon')
    plt.title(f"Número de Trocas para Tamanho {tamanho}")
    plt.xlabel("Algoritmo")
    plt.ylabel("Número de Trocas")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig(f"{output_dir}/numero_trocas_{tamanho}.png")
    plt.close()

    # Gráfico de Número de Iterações
    plt.figure(figsize=(10, 6))
    plt.bar(df_tamanho["Algoritmo"], df_tamanho["NumeroIteracoes"], color='lightgreen')
    plt.title(f"Número de Iterações para Tamanho {tamanho}")
    plt.xlabel("Algoritmo")
    plt.ylabel("Número de Iterações")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig(f"{output_dir}/numero_iteracoes_{tamanho}.png")
    plt.close()

# Gráficos gerais
# 1. Comparação Geral de Tempo de Execução
plt.figure(figsize=(12, 8))
algoritmos = df["Algoritmo"].unique()
tempos_execucao = df.groupby("Algoritmo")["TempoExecucao"].sum()

plt.bar(algoritmos, tempos_execucao, color='orange')
plt.title("Comparação Geral de Tempo de Execução")
plt.xlabel("Algoritmo")
plt.ylabel("Tempo de Execução Total (ms)")
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig(f"{output_dir}/comparacao_geral_tempo_execucao.png")
plt.close()

# 2. Comparação Geral de Número de Trocas
plt.figure(figsize=(12, 8))
trocas = df.groupby("Algoritmo")["NumeroTrocas"].sum()

plt.bar(algoritmos, trocas, color='purple')
plt.title("Comparação Geral de Número de Trocas")
plt.xlabel("Algoritmo")
plt.ylabel("Número de Trocas Total")
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig(f"{output_dir}/comparacao_geral_numero_trocas.png")
plt.close()

# 3. Comparação Geral de Número de Iterações
plt.figure(figsize=(12, 8))
interacoes = df.groupby("Algoritmo")["NumeroIteracoes"].sum()

plt.bar(algoritmos, interacoes, color='teal')
plt.title("Comparação Geral de Número de Iterações")
plt.xlabel("Algoritmo")
plt.ylabel("Número de Iterações Total")
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig(f"{output_dir}/comparacao_geral_numero_iteracoes.png")
plt.close()

print("Gráficos gerados com sucesso!")
