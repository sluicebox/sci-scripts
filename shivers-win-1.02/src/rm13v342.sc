;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13342)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v342 0
)

(instance rm13v342 of ShiversRoom
	(properties
		picture 13840
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13343
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13341
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13344
	)

	(method (init)
		(self
			createPoly:
				82
				142
				105
				107
				112
				107
				112
				60
				132
				55
				152
				59
				152
				105
				158
				105
				184
				142
		)
		(super init: &rest)
	)
)

