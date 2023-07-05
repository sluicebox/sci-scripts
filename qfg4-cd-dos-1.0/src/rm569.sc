;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 569)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm569 0
)

(instance rm569 of GloryRm
	(properties
		picture 430
		horizon 78
		north 568
		east 573
		south 570
		topX 191
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 29 155 98 181 98 189 0 189 0 0 177 0 177 112 93 112 29 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 205 80 205 0 319 0 319 89 222 89
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 139 62 223 62 243 109 141 90 yourself:)
				130
				((Polygon new:)
					init: 144 91 247 113 259 144 184 189 114 189 70 139 108 127 145 135 184 123 128 109
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init:)
		(atp3 init:)
		(if gNight
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 223 189 223 168 319 168
						yourself:
					)
			)
			(atp4 init: setPri: 189)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 82
		y 6
		view 434
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 4
		y 75
		view 434
		loop 2
		cel 2
	)
)

(instance atp3 of ForestView
	(properties
		x 3
		y 104
		view 433
	)
)

(instance atp4 of ForestView
	(properties
		x 279
		y 189
		view 438
		loop 1
		cel 3
	)
)

