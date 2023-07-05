;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 566)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm566 0
)

(instance rm566 of GloryRm
	(properties
		picture 420
		style 1024
		horizon 70
		north 565
		west 560
		topX 152
	)

	(method (init)
		(if gDebugging
			(= gNight 1)
		)
		(if
			(or
				(and gNight (not (IsFlag 60)))
				(and (IsFlag 60) (not (IsFlag 55)))
				(and (== gCombatMonsterNum 850) (== gPrevRoomNum 810)) ; wraith, combat
			)
			(if (IsFlag 60)
				(SetFlag 66)
			)
			(if (IsFlag 55)
				(SetFlag 65)
			)
			(self setRegions: 53) ; barrows
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 128 -300 128 87 24 87 -300 65
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 135 -300 109 107 109 107 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 267 95 228 95 215 102 176 102 176 -300 619 -300 619 489 -300 489 -300 173 266 173 266 156 224 156 224 141 267 141
					yourself:
				)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: -300 130 123 129 211 106 619 144 619 489 -300 489
					yourself:
				)
				60
				((Polygon new:) init: 193 47 207 64 146 80 106 49 yourself:)
				130
				((Polygon new:)
					init: 29 88 102 88 135 101 121 107 100 97 30 96
					yourself:
				)
				130
		)
		(atp1 init: setPri: 180)
		(atp2 init: setPri: 180)
		(atp3 init: setPri: 148)
		(atp4 init: setPri: 127)
		(atp5 init:)
		(if (not gNight)
			(atp6 init: setPri: 85)
		)
		(atp7 init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 175
		y 152
		view 422
		loop 1
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 316
		y 169
		view 422
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		x 316
		y 50
		view 423
		loop 1
	)
)

(instance atp4 of ForestView
	(properties
		x 96
		y 98
		view 416
		loop 1
		cel 4
	)
)

(instance atp5 of ForestView
	(properties
		x 203
		y 73
		view 416
		loop 1
		cel 3
	)
)

(instance atp6 of ForestView
	(properties
		x 79
		y 5
		view 424
		loop 3
	)
)

(instance atp7 of ForestView
	(properties
		x 285
		y 3
		view 416
		loop 3
	)
)

