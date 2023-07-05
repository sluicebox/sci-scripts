;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 583)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm583 0
)

(instance rm583 of GloryRm
	(properties
		picture 430
		style 1024
		horizon 85
		north 582
		south 584
		west 577
		topX 130
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 114 -300 114 87 -300 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 619 -300 619 489 220 489 220 178 269 171 295 131 272 131 242 117 190 115 135 105 135 96 154 96 154 -300
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 150 99 160 99 172 7 489 -300 489
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 99 59 170 62 173 89 73 110 yourself:)
				130
				((Polygon new:)
					init: 235 103 173 125 182 132 206 128 251 153 206 152 225 171 214 489 -300 489 -300 172 48 122 180 88
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp2 init:)
		(atp3 init: setPri: 169)
		(atp4 init: setPri: 106)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 316
		y 81
		view 434
		loop 3
		cel 2
	)
)

(instance atp2 of ForestView
	(properties
		x 317
		y 104
		view 433
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		y 140
		view 434
		loop 2
		cel 2
	)
)

(instance atp4 of ForestView
	(properties
		x 233
		y 6
		view 434
		loop 1
		cel 1
	)
)

