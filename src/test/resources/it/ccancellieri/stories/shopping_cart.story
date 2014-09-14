Scenario: shopping cart 1

Given a <quantity> of <good_name> at <price>
When the <good_name> is <imported> and is <regular>
Then the price is <price_after_taxes>
And the sales taxes is <taxes>

Examples:     
|quantity|good_name|price|imported|regular|price_after_taxes|taxes|
|1|Book|12.49|false|false|12.49|0|
|1|Music_cd|14.99|false|true|16.49|1.50|
|1|Food|0.85|false|false|0.85|0|
|1|Food|10.00|true|false|10.50|0.50|
|1|Perfume|47.50|true|true|54.65|7.15|
|1|Perfume|27.99|true|true|32.19|4.20|
|1|Perfume|18.99|false|true|20.89|1.90|
|1|Medical|9.75|false|false|9.75|0|
|1|Food|11.25|true|false|11.85|0.60|