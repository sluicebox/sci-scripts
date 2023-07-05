;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10490)
(include sci.sh)
(use Main)

(public
	rm10v490 0
)

(instance rm10v490 of ShiversRoom
	(properties
		picture 10490
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efNote init: 0)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10500
	)

	(method (init)
		(self
			createPoly:
				120
				116
				96
				110
				113
				101
				131
				106
				122
				115
				122
				143
				216
				143
				169
				114
				183
				99
				193
				74
				185
				57
				170
				40
				152
				30
				120
				29
				107
				30
				93
				38
				72
				59
				66
				88
				72
				103
				82
				112
				85
				119
				68
				144
				121
				143
		)
		(super init: &rest)
	)
)

(instance efNote of ExitFeature
	(properties
		nextRoom 10132
	)

	(method (init)
		(self createPoly: 120 116 96 110 113 101 131 106 122 115)
		(super init: &rest)
	)
)

