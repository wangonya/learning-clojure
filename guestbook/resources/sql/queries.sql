-- :name save-message! :! :n
-- :doc creates a new message
INSERT INTO guestbook
(name, message, timestamp)
VALUES (:name, :message, :timestamp)

-- :name update-message! :! :n
-- :doc updates an existing message record
UPDATE guestbook
SET name = :name, message = :message, timestamp = :timestamp
WHERE id = :id

-- :name get-messages :! :n
-- :doc retrieves all available messages
SELECT * FROM guestbook

-- :name get-message :? :1
-- :doc retrieves a message record given the id
SELECT * FROM guestbook
WHERE id = :id

-- :name delete-message! :! :n
-- :doc deletes a message record given the id
DELETE FROM guestbook
WHERE id = :id
