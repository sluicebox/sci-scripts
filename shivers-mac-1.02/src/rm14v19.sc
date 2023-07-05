;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14190)
(include sci.sh)
(use Main)

(public
	rm14v19 0
)

(local
	local0
)

(instance rm14v19 of ShiversRoom
	(properties
		picture 14190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (== gPrevRoomNum 14200) ; rm14v20
			(hsRobot init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14200
	)

	(method (init)
		(self
			createPoly:
				181
				75
				187
				56
				229
				56
				229
				70
				212
				116
				236
				129
				239
				139
				195
				142
				171
				134
				186
				120
				193
				119
				195
				82
		)
		(super init: &rest)
	)
)

(instance hsRobot of HotSpot
	(properties)

	(method (init)
		(self createPoly: 58 24 39 14 62 9 97 9 97 16)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local0 5)
			(gSounds play: 35113 0 122 0)
			(self dispose:)
		else
			(++ local0)
		)
	)
)

