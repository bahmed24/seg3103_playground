# Lab 03

| Outline | Value |
| --- | --- |
| Course | SEG 3X03 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | James Url, jamesurl@uottawa.ca |
| Team | Andrew Forward 1484511<br>Ayana Forward 9021000 |

## Analyze Computation results
### Computation

Ran and generated the report for Computation:
![Computation coverage results](assets/Computation-coverage-results.png)

Analyzed the class coverage:
![Computation class coverage results](assets/computation-class-coverage-results.png)

We notice that there was a 1/2 branch missed "if(a == Integer.MIN_VALUE)", Similarly for catchexception at "if(i == 13)" and for divide at "if (divident == 0)".
We also see that there is no coverage for susbtract method as the test call was blank ("// do nothing").

### Date
Ran and generated the report for Date:
![Date coverage results](assets/Date-coverage-report.png)
![Date coverage results break-down](assets/Date-coverage-report-breakdown.png)

Analyzed the class coverage:
![Date class coverage results](assets/Date-class-coverage1.png)
![Date class coverage results](assets/Date-class-coverage2.png)

We notice that the 3 first if statements were not fully covered. We also see that toString hasn't been covered either.