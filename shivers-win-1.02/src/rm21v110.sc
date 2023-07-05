;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21110)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm21v110 0
)

(instance rm21v110 of ShiversRoom
	(properties
		picture 21110
	)

	(method (init)
		(pLionProp init:)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(efExitForwardBook init: 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 21115) (!= newRoomNumber 21111) (IsFlag 43)) ; rm21v115, rm21v111
			(gSounds play: 12109 0 82 0)
			(ClearFlag 43)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 21100
	)

	(method (init)
		(self createPoly: 1 1 152 1 130 30 130 40 70 40 40 56 40 140 1 140 1 1)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 21100
	)

	(method (init)
		(self
			createPoly: 194 1 220 38 206 71 180 100 180 140 262 140 262 1 194 1
		)
		(super init: &rest)
	)
)

(instance efExitForwardBook of ExitFeature
	(properties
		nextRoom 21115
	)

	(method (init)
		(self
			createPoly:
				85
				131
				117
				118
				137
				129
				139
				131
				137
				133
				120
				139
				103
				143
				85
				132
		)
		(super init: &rest)
	)
)

(instance efExitLion of ExitFeature
	(properties
		nextRoom 21111
	)

	(method (init)
		(self
			createPoly:
				43
				60
				43
				74
				58
				77
				58
				95
				180
				95
				190
				83
				202
				68
				202
				57
				199
				53
				204
				53
				215
				40
				216
				37
				214
				35
				194
				14
				189
				4
				155
				3
				133
				31
				133
				43
				68
				43
				43
				57
		)
		(super init: &rest)
	)
)

(instance pLionProp of ShiversProp
	(properties
		priority 110
		fixPriority 1
		view 21110
	)

	(method (init)
		(if (IsFlag 43)
			(self cel: (self lastCel:))
			(self createPoly: 0 0 0 0 0 0 0 0 0 0)
			(efExitLion init: 3)
		else
			(self
				createPoly:
					43
					60
					43
					74
					58
					77
					58
					95
					180
					95
					190
					83
					202
					68
					202
					57
					199
					53
					204
					53
					215
					40
					216
					37
					214
					35
					194
					14
					189
					4
					155
					3
					133
					31
					133
					43
					68
					43
					43
					57
			)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(SetFlag 43)
		(self createPoly: 0 0 0 0 0 0 0 0 0 0)
		(gSounds play: 12108 0 82 0)
		(self setCycle: End)
		(efExitLion init: 3)
	)
)

