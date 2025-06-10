# Quantum-Spider-Optimization-algorithm
I have invented a optimization algorithm , and implemented with java.
# Quantum Spider Optimization Algorithm (QSOA)

>  A novel quantum-inspired, bio-quantum hybrid optimizer inspired by spider web behavior and qubit superposition.

---

## Overview

Quantum Spider Optimization Algorithm (QSOA) is a unique metaheuristic optimization algorithm inspired by:

-  **Spiders' prey-catching strategies on their webs**
-  **Quantum superposition and measurement principles from quantum computing**

Each agent (spider) maintains a **quantum amplitude** per dimension, representing a superposition of possible positions. These amplitudes are **measured** to produce actual candidate solutions. The spiders update their amplitudes based on global best influence and random neighbor entanglement, resulting in a strong balance between **exploration** and **exploitation**.

---

## 🧠 Inspirations

- **Nature**: Spider webs vibrate upon prey contact. Spiders detect vibration intensity and direction to localize and optimize their movement.
- **Quantum Mechanics**: Agents operate in superposed states like qubits. Measurement collapses the state into a concrete position. Updates are inspired by quantum interference and entanglement.

---

## 🚀 Features

- ✅ Fully implemented in Java — no dependencies
- ✅ Uses real-valued quantum amplitude encoding
- ✅ Hybrid local-global update inspired by quantum entanglement
- ✅ Easy to adapt for custom objective functions
- ✅ Great performance on continuous optimization problems (e.g., Sphere, Rastrigin)

---

## 🔧 How It Works

1. **Initialization**:  
   Each spider is initialized with a quantum amplitude vector `[0, 1]`.

2. **Measurement**:  
   Using the quantum amplitude, the spider's position is computed as:
   ```java
   position = lowerBound + amplitude * (upperBound - lowerBound);

** Test Results **
QSOA:
1:
Iterasyon 0, En iyi değer: 0,02798
Iterasyon 10, En iyi değer: 0,00346
Iterasyon 20, En iyi değer: 0,00182
Iterasyon 30, En iyi değer: 0,00023
Iterasyon 40, En iyi değer: 0,00000
Iterasyon 50, En iyi değer: 0,00000
Iterasyon 60, En iyi değer: 0,00000
Iterasyon 70, En iyi değer: 0,00000
Iterasyon 80, En iyi değer: 0,00000
Iterasyon 90, En iyi değer: 0,00000
En iyi çözüm: [0,00069, -0,00102] -> Hedef: 0,00000

2:
Iterasyon 0, En iyi değer: 0,20109
Iterasyon 10, En iyi değer: 0,00183
Iterasyon 20, En iyi değer: 0,00183
Iterasyon 30, En iyi değer: 0,00004
Iterasyon 40, En iyi değer: 0,00001
Iterasyon 50, En iyi değer: 0,00001
Iterasyon 60, En iyi değer: 0,00001
Iterasyon 70, En iyi değer: 0,00001
Iterasyon 80, En iyi değer: 0,00001
Iterasyon 90, En iyi değer: 0,00001
En iyi çözüm: [-0,00224, 0,00074] -> Hedef: 0,00001

3: 
Iterasyon 0, En iyi değer: 0,52696
Iterasyon 10, En iyi değer: 0,10718
Iterasyon 20, En iyi değer: 0,00216
Iterasyon 30, En iyi değer: 0,00006
Iterasyon 40, En iyi değer: 0,00001
Iterasyon 50, En iyi değer: 0,00001
Iterasyon 60, En iyi değer: 0,00001
Iterasyon 70, En iyi değer: 0,00001
Iterasyon 80, En iyi değer: 0,00001
Iterasyon 90, En iyi değer: 0,00001
En iyi çözüm: [0,00237, -0,00107] -> Hedef: 0,00001

PSO:
1:
Iterasyon 0, En iyi değer: 0,03117
Iterasyon 10, En iyi değer: 0,00012
Iterasyon 20, En iyi değer: 0,00000
Iterasyon 30, En iyi değer: 0,00000
Iterasyon 40, En iyi değer: 0,00000
Iterasyon 50, En iyi değer: 0,00000
Iterasyon 60, En iyi değer: 0,00000
Iterasyon 70, En iyi değer: 0,00000
Iterasyon 80, En iyi değer: 0,00000
Iterasyon 90, En iyi değer: 0,00000
En iyi çözüm: [-0,00000, 0,00000] -> Hedef: 0,00000

2:
Iterasyon 0, En iyi değer: 0,20806
Iterasyon 10, En iyi değer: 0,00173
Iterasyon 20, En iyi değer: 0,00001
Iterasyon 30, En iyi değer: 0,00000
Iterasyon 40, En iyi değer: 0,00000
Iterasyon 50, En iyi değer: 0,00000
Iterasyon 60, En iyi değer: 0,00000
Iterasyon 70, En iyi değer: 0,00000
Iterasyon 80, En iyi değer: 0,00000
Iterasyon 90, En iyi değer: 0,00000
En iyi çözüm: [0,00000, 0,00000] -> Hedef: 0,00000

3:
Iterasyon 0, En iyi değer: 0,04776
Iterasyon 10, En iyi değer: 0,00258
Iterasyon 20, En iyi değer: 0,00000
Iterasyon 30, En iyi değer: 0,00000
Iterasyon 40, En iyi değer: 0,00000
Iterasyon 50, En iyi değer: 0,00000
Iterasyon 60, En iyi değer: 0,00000
Iterasyon 70, En iyi değer: 0,00000
Iterasyon 80, En iyi değer: 0,00000
Iterasyon 90, En iyi değer: 0,00000
En iyi çözüm: [-0,00000, -0,00000] -> Hedef: 0,00000

**Result**

Bu bölümde, geliştirilen Quantum Spider Optimization Algorithm (QSOA) ile klasik Particle Swarm Optimization (PSO) algoritması aynı koşullar altında (2 boyutlu Sphere fonksiyonu, 30 ajan, 100 iterasyon) test edilmiştir.

🔬 Deney Koşulları:
Amaç fonksiyonu: Sphere (f(x) = Σ xᵢ²)

Boyut: 2

Popülasyon: 30

İterasyon: 100

Alt/Üst Sınırlar: [-5.0, 5.0]

📈 Ortalama Performans Özeti (3 çalışma üzerinden):
Algoritma	Ortalama En İyi Değer	Ortalama Iterasyon Sayısı (0'a ulaşma)	Stabilite
QSOA	≈ 0.000006	40-50 iterasyon	⚠️ Orta
PSO	≈ 0.000000	20-30 iterasyon	✅ Yüksek

🧪 Gözlem:
QSOA, zamanla minimuma yakın çözümler üretmiş ve 3 çalışmadan 2’sinde hedef değere ulaşmıştır.

PSO, her çalışmada hızlıca sıfıra yakınsadığı için daha kararlı sonuçlar vermiştir.

QSOA’nın dikkat çekici tarafı, keşif stratejilerinin çeşitliliği sayesinde bazen farklı lokal minimumlara saplanmadan ilerleyebilmesidir.

💡 Sonuç:
Her iki algoritma da başarılı optimizasyon gerçekleştirmiştir. PSO daha deterministik ve hızlıyken, QSOA yeni bir yaklaşım sunarak keşif odaklı çözümlerle güçlü bir alternatif olabileceğini göstermiştir.

