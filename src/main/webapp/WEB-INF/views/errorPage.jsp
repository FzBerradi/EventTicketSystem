<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }

        .card {
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.08);
            background-color: #ff4444; /* Couleur de fond rouge */
            color: white; /* Texte blanc */
            text-align: center;
            transform: translateZ(0); /* Effet 3D */
            transition: transform 0.25s ease-out; /* Animation de transition */
        }

        .card:hover {
            transform: translateY(-5px); /* Effet de lévitation au survol */
        }
    </style>
</head>

<body>
    <div class="card">
        <h1>An Error has occurred</h1>
        <p>We apologize for the inconvenience. Please try again later.</p>
    </div>
</body>

</html>
