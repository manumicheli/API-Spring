document.addEventListener("DOMContentLoaded", () => {
    const root = document.documentElement;
    const storedColor = localStorage.getItem('primaryColor');

    if (storedColor) {
        root.style.setProperty('--primary-color', storedColor);
    }

    document.querySelectorAll('.color-btn').forEach(button => {
        button.addEventListener('click', (event) => {
            const selectedColor = event.target.getAttribute('data-color');
            root.style.setProperty('--primary-color', selectedColor);
            localStorage.setItem('primaryColor', selectedColor);
        });
    });
});