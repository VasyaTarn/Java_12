INSERT INTO public.customers (name, email, phone) VALUES
('John Doe', 'john.doe@example.com', '123-456-7890'),
('Jane Smith', 'jane.smith@example.com', '098-765-4321'),
('Alice Johnson', 'alice.johnson@example.com', '234-567-8901');

INSERT INTO public.ticketStatus (status) VALUES
('FREE'),
('SOLD');

INSERT INTO public.places (name, address) VALUES
('Central Park', '123 Park Ave, New York, NY'),
('Madison Square Garden', '4 Pennsylvania Plaza, New York, NY'),
('The Hollywood Bowl', '2301 N Highland Ave, Los Angeles, CA');

INSERT INTO public.events (event_date, name, place_id) VALUES
('2024-12-01', 'Winter Wonderland Concert', 1),
('2024-10-15', 'Comedy Night', 2),
('2024-11-20', 'Jazz Festival', 3);

INSERT INTO public.tickets (cost, number, customer_id, event_id, status_id) VALUES
(50.00, 1, 1, 1, 1),
(60.00, 2, 2, 1, 2),
(75.00, 1, 3, 2, 1),
(120.00, 1, NULL, 3, 1);