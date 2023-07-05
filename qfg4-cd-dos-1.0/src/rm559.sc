;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 559)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use PChase)
(use PolyPath)
(use Polygon)

(public
	rm559 0
)

(instance rm559 of GloryRm
	(properties
		picture 420
		horizon 70
		north 558
		east 565
		south 560
		west 554
		topX 164
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 146 0 146 73 139 97 130 104 32 91 32 70 0 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 85 243 86 183 73 183 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 134 213 134 213 102 319 102
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(if (IsFlag 35)
			(self setRegions: 51) ; theHunt
			(= east (= south 0))
			((ScriptID 51 1) init: posn: 300 100 setHeading: 270) ; nec1
			((ScriptID 51 2) init: posn: 160 170 setHeading: 315) ; nec2
		)
		((ScriptID 50 1) caller: self) ; enterRoomScr
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 0 122 50 137 79 109 205 123 293 136 314 162 275 164 277 189 0 189
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init: setPri: 127)
		(atp3 init:)
		(if gNight
			(atp4 init: setPri: 249)
			(atp5 init: setPri: 249)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (cue)
		(if (== gPrevRoomNum (gCurRoom west:))
			(gEgo setMotion: PolyPath (+ (gEgo x:) 15) (gEgo y:))
		)
	)

	(method (notify param1)
		(if (and (== param1 1) (!= (gCurRoom script:) (ScriptID 51 4))) ; sBlackOut
			(gCurRoom setScript: (ScriptID 51 4)) ; sBlackOut
		)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(IsFlag 35)
				(< (gEgo x:) 7)
				(not (gCast contains: (ScriptID 51 3))) ; nec3
				(!= (gCurRoom script:) (ScriptID 50 1)) ; enterRoomScr
			)
			((ScriptID 51 3) ; nec3
				posn: (- (- (gEgo x:) 25) 15) (gEgo y:)
				init:
				setMotion: PChase gEgo 25
			)
		)
		(if
			(and
				(IsFlag 35)
				(> (gEgo y:) 160)
				(not ((ScriptID 51 2) mover:)) ; nec2
			)
			((ScriptID 51 2) setMotion: PChase gEgo 25) ; nec2
		)
		(if
			(and
				(IsFlag 35)
				(> (gEgo x:) 300)
				(not ((ScriptID 51 1) mover:)) ; nec1
			)
			((ScriptID 51 1) setMotion: PChase gEgo 25) ; nec1
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 40
		y 14
		view 424
		loop 2
		cel 4
	)
)

(instance atp2 of ForestView
	(properties
		x 223
		y 98
		view 416
		cel 4
	)
)

(instance atp3 of ForestView
	(properties
		x 117
		y 73
		view 416
		cel 3
	)
)

(instance atp4 of ForestView
	(properties
		x 19
		y 73
		view 428
	)
)

(instance atp5 of ForestView
	(properties
		x 26
		y 189
		view 428
		cel 1
	)
)

