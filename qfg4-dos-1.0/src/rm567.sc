;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 567)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm567 0
)

(instance rm567 of GloryRm
	(properties
		picture 420
		east 571
		south 568
		west 564
		rightY 140
	)

	(method (init)
		(if gDebugging
			(= gNight 1)
		)
		(if
			(or
				(and gNight (not (IsFlag 61)))
				(and (IsFlag 61) (not (IsFlag 56)))
				(and (== gCombatMonsterNum 850) (== gPrevRoomNum 810)) ; wraith, combat
			)
			(if (IsFlag 61)
				(SetFlag 66)
			)
			(if (IsFlag 56)
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
					init: 0 0 319 0 319 120 296 128 219 116 233 106 215 99 192 104 105 104 32 88 32 71 0 71
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 180 85 180 85 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 210 177 319 177 319 189 188 189
					yourself:
				)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 0 157 200 157 190 132 319 142 319 189 0 189
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init:)
		(atp3 init:)
		(atp4 init: setPri: 189)
		(atp5 init: setPri: 189)
		(stream1 setCycle: Fwd setPri: 70 init:)
		(stream2 setCycle: Fwd setPri: 70 init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 131
		y 1
		view 420
	)
)

(instance atp2 of ForestView
	(properties
		x 39
		y 14
		view 424
		loop 2
		cel 4
	)
)

(instance atp3 of ForestView
	(properties
		x 228
		y 75
		view 424
		loop 2
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 4
		y 7
		view 429
	)
)

(instance atp5 of ForestView
	(properties
		x 196
		y 7
		view 429
		cel 1
	)
)

(instance stream1 of ForestView
	(properties
		x 133
		y 102
		view 420
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 290
		y 126
		view 420
		loop 6
		signal 16385
		detailLevel 2
	)
)

