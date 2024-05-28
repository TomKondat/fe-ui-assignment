# fe-ui-assignment

This repo contains the second assignment. It uses Maven to manage packages.

## Setting up the environment

We use an email and a password to login to LinkedIn, and we shouldn't push this sensitive information to Git, so I used environment variables to pass them into my program.

Create a `.env` file in the project's root and insert this:

```
SELENIUM_EMAIL=<INSERT EMAIL HERE>
SELENIUM_PASSWORD=<INSERT PASSWORD HERE>
```

## Manually solving CAPTCHAs

LinkedIn detects suspicious / automated login attempts, so it flags our automation as such and prompt us with a CAPTCHA.

Since my automation can't solve CAPTCHAs, I gave myself enough timeout window (30 seconds), and I solve the CAPTCHA manually.
