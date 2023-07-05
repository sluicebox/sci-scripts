;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v220 0
)

(instance rm10v220 of ShiversRoom
	(properties
		picture 10220
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10230
	)

	(method (init)
		(self
			createPoly:
				49
				122
				57
				104
				45
				75
				52
				55
				67
				41
				93
				34
				114
				32
				139
				36
				154
				42
				172
				55
				171
				69
				174
				101
				179
				120
		)
		(super init: &rest)
	)
)

