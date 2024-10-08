CREATE TABLE IF NOT EXISTS public.customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS public.ticketStatus (
    id SERIAL PRIMARY KEY,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.places (
    id SERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.events (
    id SERIAL PRIMARY KEY,
    event_date DATE NOT NULL,
    name VARCHAR(100) NOT NULL,
    place_id INT NOT NULL REFERENCES public.places(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.tickets (
    id SERIAL PRIMARY KEY,
    cost DECIMAL(10, 2) NOT NULL,
    number INT NOT NULL,
    customer_id INT REFERENCES public.customers(id) ON DELETE SET NULL,
    event_id INT NOT NULL REFERENCES public.events(id) ON DELETE CASCADE,
    status_id INT NOT NULL REFERENCES public.ticketStatus(id)
);



