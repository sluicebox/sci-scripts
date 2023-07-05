;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 572)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm572 0
)

(instance rm572 of GloryRm
	(properties
		picture 430
		style 1024
		horizon 80
		north 571
		south 573
		west 568
		topX 137
	)

	(method (init)
		(if gNight
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 118 0 118 83 88 88 0 88
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 619 189 202 189 202 174 245 174 268 167 288 154 297 133 277 133 236 113 236 105 158 105 158 0 619 0
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 118 0 118 83 88 88 0 88
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 619 189 101 189 101 174 245 174 268 167 288 154 297 133 277 133 236 113 236 105 158 105 158 0 619 0
						yourself:
					)
			)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 195 42 198 83 83 109 82 90 107 81 108 59
					yourself:
				)
				130
				((Polygon new:)
					init: 150 189 58 139 73 116 174 92 269 103 159 123 182 132 230 121 271 155 202 189
					yourself:
				)
				60
		)
		(atp1 init:)
		(if (not gNight)
			(atp2 init: setPri: 180)
		)
		(atp3 init:)
		(if gNight
			(atp4 view: 437 loop: 1 cel: 0 x: 15 y: 137 setPri: 130)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 118 57 118 57 131 0 131
						yourself:
					)
			)
		)
		(atp4 init:)
		(atp5 init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 318
		y 104
		view 433
		loop 1
	)
)

(instance atp2 of ForestView
	(properties
		x 118
		y 165
		view 434
	)
)

(instance atp3 of ForestView
	(properties
		x 223
		y 7
		view 434
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self signal: (& (self signal:) $efff))
	)
)

(instance atp4 of ForestView
	(properties
		x 179
		y 83
		view 434
		cel 2
	)
)

(instance atp5 of ForestView
	(properties
		x 319
		y 60
		view 434
		loop 3
		cel 1
	)
)

