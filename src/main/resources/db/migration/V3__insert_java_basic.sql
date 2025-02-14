INSERT INTO interview_questions (question, answer, topic_id)
VALUES ('What is the difference between == and .equals() in Java?',
        '<div class="answer">
    <h1>Difference Between <code>==</code> and <code>.equals()</code> in Java</h1>

    <h2>1. <code>==</code> Operator</h2>
    <p>The <code>==</code> operator is used to compare the memory addresses (references) of two objects.</p>
    <p>If two object references point to the same memory location, <code>==</code> returns <code>true</code>; otherwise, it returns <code>false</code>.</p>

    <h3>Example:</h3>
    <pre><code>String str1 = new String("Java");
String str2 = new String("Java");

System.out.println(str1 == str2); // false (Different memory locations)
    </code></pre>

    <h2>2. <code>.equals()</code> Method</h2>
    <p>The <code>.equals()</code> method checks the content (or logical equality) of two objects.</p>
    <p>For example, in the <code>String</code> class, <code>.equals()</code> is overridden to compare the actual content instead of memory addresses.</p>

    <h3>Example:</h3>
    <pre><code>System.out.println(str1.equals(str2)); // true (Same content: "Java")</code></pre>

    <h2>3. Summary of Differences</h2>
    <table border="1" cellpadding="8">
        <thead>
            <tr>
                <th>Aspect</th>
                <th><code>==</code> Operator</th>
                <th><code>.equals()</code> Method</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Comparison Type</td>
                <td>Compares memory addresses</td>
                <td>Compares content (logical equality)</td>
            </tr>
            <tr>
                <td>Used For</td>
                <td>Primitive types and object references</td>
                <td>Objects that override <code>equals()</code></td>
            </tr>
            <tr>
                <td>Default Behavior</td>
                <td>Compares reference addresses</td>
                <td>Compares reference addresses (unless overridden)</td>
            </tr>
            <tr>
                <td>Example</td>
                <td><code>str1 == str2</code> → <code>false</code></td>
                <td><code>str1.equals(str2)</code> → <code>true</code></td>
            </tr>
        </tbody>
    </table>

    <h2>4. When to Use What?</h2>
    <ul>
        <li>Use <code>==</code> when checking if two references point to the same object in memory.</li>
        <li>Use <code>.equals()</code> when checking for logical equality (e.g., comparing string contents).</li>
        <li>Override <code>equals()</code> in custom objects if you need logical equality comparison.</li>
    </ul>
</div>
'
           , (SELECT topic_id FROM topics WHERE code = 'JAVA_BASICS'));


INSERT INTO interview_questions (question, answer, topic_id)
VALUES ('What are the primitive data types in Java?',
        '
'
           , (SELECT topic_id FROM topics WHERE code = 'JAVA_BASICS'));

-- INSERT INTO interview_questions (question, answer, topic_id)
-- VALUES ('What is the difference between == and .equals() in Java?',
--         '
-- '
--            , (SELECT topic_id FROM topics WHERE code = 'JAVA_BASICS'));
