;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 553)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use PChase)
(use PolyPath)
(use Polygon)

(public
	rm553 0
)

(instance rm553 of GloryRm
	(properties
		picture 430
		horizon 80
		north 552
		east 558
		south 554
		topX 180
		bottomX 144
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 203 0 319 0 319 89 244 89 203 81
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 181 184 261 160 319 160 319 189 176 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 158 0 158 97 126 97 126 106 74 105 74 111 48 111 48 122 26 122 36 156 112 171 112 179 112 189
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(if (IsFlag 35)
			(self setRegions: 51) ; theHunt
			(= north 0)
			((ScriptID 50 1) caller: self) ; enterRoomScr
		)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 246 110 147 89 134 67 219 63 yourself:)
				130
				((Polygon new:)
					init: 143 89 245 112 258 143 191 189 105 189 105 163 187 127 119 101
					yourself:
				)
				60
				((Polygon new:) init: 86 120 99 110 145 122 139 133 yourself:)
				60
		)
		(atp1 init:)
		(atp2 init: setPri: 106)
		(atp3 init:)
		(atp4 init:)
		(atp5 init: setPri: 180)
		(super init: &rest)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (cue)
		(gEgo setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 25))
		((ScriptID 51 1) ; nec1
			posn: topX (- (- (gEgo y:) 25) 20)
			init:
			setMotion: PChase gEgo 25
		)
	)

	(method (notify param1)
		(if (== param1 1)
			(gCurRoom setScript: (ScriptID 51 4)) ; sBlackOut
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 82
		y 7
		view 434
		cel 3
	)
)

(instance atp2 of ForestView
	(properties
		y 130
		view 431
		loop 1
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		y 189
		view 431
		loop 1
	)
)

(instance atp4 of ForestView
	(properties
		x 82
		y 84
		view 434
		cel 2
	)
)

(instance atp5 of ForestView
	(properties
		x 189
		y 7
		view 439
		cel 1
	)
)

