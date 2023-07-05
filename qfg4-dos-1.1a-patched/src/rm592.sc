;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 592)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm592 0
)

(instance rm592 of GloryRm
	(properties
		picture 410
		style 1024
		horizon 70
		north 591
		south 593
		topX 140
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 217 489 217 183 273 162 283 162 283 158 250 158 250 143 287 143 287 131 207 131 207 98 159 89 192 72 192 -300 619 -300 619 489
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 489 -300 -300 76 -300 76 78 171 103 171 117 111 117 111 126 56 126 56 147 118 147 118 171 53 489
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 157 125 200 115 -300 75 -300 28 94 28 136 74 160 66 159 29 619 30 619 99 186 138
					yourself:
				)
				60
				((Polygon new:)
					init: -300 489 -300 90 132 168 171 172 142 489
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init: setPri: 64)
		(atp3 init: setPri: 148)
		(atp4 init: setPri: 180)
		(atp5 init: setPri: 169)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 166
		y 56
		view 411
		loop 1
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 225
		y 49
		view 413
		loop 1
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 319
		y 108
		view 413
		loop 1
	)
)

(instance atp4 of ForestView
	(properties
		x 111
		y 119
		view 411
		loop 1
	)
)

(instance atp5 of ForestView
	(properties
		x 109
		y 119
		view 414
		loop 1
		cel 6
	)
)

