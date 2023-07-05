;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 555)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm555 0
)

(instance rm555 of GloryRm
	(properties
		picture 430
		east 560
		south 556
		west 551
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 132 231 132 231 115 196 109 69 109 0 102
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 0 85 74 107 33 113 105 189 0 189
					yourself:
				)
				130
				((Polygon new:) init: 147 120 134 136 86 121 95 109 yourself:)
				130
				((Polygon new:) init: 269 135 287 137 284 144 234 164 yourself:)
				130
				((Polygon new:)
					init: 163 189 111 166 195 131 169 99 220 100 258 141
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init:)
		(if gNight
			(atp3 init: setPri: 127)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 107
		y 64
		view 430
	)
)

(instance atp2 of ForestView
	(properties
		x 3
		y 58
		view 434
		loop 2
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 304
		y 143
		view 437
	)
)

