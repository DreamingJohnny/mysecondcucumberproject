Feature: Current Work

  Scenario: Fill in frame
	Given the user is on the correct page
	And the user sees the container for "frames"
	When the user switches to "frames"
	And the url is now the one for "db.practiceFormUrl"
	And the user enters "John Doe" into the "frames name" field
	Then the "frames name" field should contain "John Doe"

  Scenario: Select from dropdown
	Given the user is on the correct page
	And the user sees the container for "frames"
	When the user switches to "frames"
	And the url is now the one for "db.practiceFormUrl"
	And the user selects "QA Engineer" from the "job drop down"
	Then the "job drop down" contains "QA Engineer"
