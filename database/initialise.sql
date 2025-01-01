CREATE TABLE IF NOT EXISTS sociallink_users (
    id SERIAL PRIMARY KEY,
    discord_id VARCHAR(255) UNIQUE NOT NULL,
    minecraft_token VARCHAR(255),
    minecraft_uuid VARCHAR(255),
    email VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
