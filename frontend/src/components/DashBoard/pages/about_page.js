import React from 'react'

function AboutPage() {
    const developerName1 = 'Michael Loh'
    const developerName2 = 'Bobur Murtozaev'
    const developerName3= 'Pasinee Mosby'
    const developerName4= 'Ann Gurung'
    const developerName5 = 'Brock Pace'
    const developerName6 = 'Henry Smith'
    return (
        <div id="about_page" className = "App-page">
            <h1>Our Project</h1>
            <p>
                We're creating a simple React application.
                It's about trading game online!
            </p>
            <h2>Team 5</h2>

            <p>
              Front-End Developer-1: {developerName1}
            </p>
            <p>
              Front-End Developer-2: {developerName2}
            </p>
            <p>
              Front-End Developer-3: {developerName3}
            </p>
            <p>
              Back-End Developer-1: {developerName4}
            </p>
            <p>
              Back-End Developer-2: {developerName5}
            </p>
            <p>
              Back-End Developer-3: {developerName6}
            </p>
        </div>
    )
}

export default AboutPage
