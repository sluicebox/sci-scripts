;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v040 0
)

(instance rm21v040 of ShiversRoom
	(properties
		picture 21040
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21041)
		)
		(efExitForwardLeftPlaque init: 3)
		(efExitForwardLeftBox init: 3)
		(efExitForwardRight init: 3)
		(efExitForwardPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_11 2 21000)
			(proc951_9 20608)
			(gSounds play: 20608 -1 32 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 2 21000) (!= newRoomNumber 21050)) ; rm21v050
			(gSounds fade: 20608 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21440
	)

	(method (init)
		(self createPoly: 1 1 20 1 20 86 1 86 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21020
	)
)

(instance efExitForwardLeftBox of ExitFeature
	(properties
		nextRoom 21050
	)

	(method (init)
		(self createPoly: 15 131 15 98 73 90 108 93 108 124 47 139 15 131)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21060
	)

	(method (init)
		(self createPoly: 194 124 191 23 216 3 239 8 253 13 250 118 238 129)
		(super init: &rest)
	)
)

(instance efExitForwardPlaque of ExitFeature
	(properties
		nextRoom 21075
	)

	(method (init)
		(self
			createPoly:
				128
				85
				148
				85
				147
				116
				156
				118
				158
				120
				158
				122
				156
				125
				137
				126
				122
				123
				122
				120
				124
				117
				127
				116
				128
				85
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeftPlaque of ExitFeature
	(properties
		nextRoom 21321
	)

	(method (init)
		(self
			createPoly:
				22
				130
				30
				137
				30
				141
				2
				146
				0
				145
				0
				90
				9
				90
				21
				101
				21
				105
				11
				107
				11
				129
				21
				130
		)
		(super init: &rest)
	)
)

