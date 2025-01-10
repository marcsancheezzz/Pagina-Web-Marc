function canviarTema() {
            const body = document.body;
            const currentBgColor = body.style.backgroundColor;
            const newBgColor = currentBgColor === 'black' ? '#f9f9f9' : 'black';
            const newTextColor = newBgColor === 'black' ? 'white' : '#333';
    
            body.style.transition = 'background-color 0.5s, color 0.5s'; 
            body.style.backgroundColor = newBgColor;
            body.style.color = newTextColor;
        }
        function mostrarPreu(paquet) {
        const preus = {
            'Bàsic': '500€ - Ideal per projectes petits.',
            'Avançat': '900€ - Per webs amb més funcionalitats.',
            'Premium': '1500€ - Tot inclòs, amb disseny personalitzat.'
        };
        document.getElementById('preu-dinamico').innerText = preus[paquet] || 'Selecciona un paquet.';
    }


    function mostrarMissatge(msg) {
        const missatgeDiv = document.createElement('div');
        missatgeDiv.classList.add('missatge');
        missatgeDiv.innerText = msg;
        document.body.appendChild(missatgeDiv);

        setTimeout(() => {
            missatgeDiv.remove();  
        }, 3000);
    }

    let tempsRestant = 24 * 60 * 60;
    function iniciarContador() {
        const contadorDiv = document.getElementById('preu-dinamico');
        setInterval(() => {
            if (tempsRestant > 0) {
                tempsRestant--; 

                const hores = Math.floor(tempsRestant / 3600);
                const minuts = Math.floor((tempsRestant % 3600) / 60);
                const segons = tempsRestant % 60;

                contadorDiv.innerHTML = `Queden: ${hores}h ${minuts}m ${segons}s per l'oferta`;
                contadorDiv.style.color = 'red';
            } else {
                contadorDiv.innerHTML = 'L\'oferta ha acabat!';
            }
        }, 1000);
    }

    iniciarContador();