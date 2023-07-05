;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 578)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm578 0
)

(instance rm578 of GloryRm
	(properties
		picture 420
		style 1024
		horizon 70
		north 577
		east 584
		south 579
		topX 157
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 140 0 140 72 114 72 103 88 45 88 45 107 106 107 106 119 64 119 43 135 22 135 22 145 52 158 65 162 65 167 30 167 19 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 173 72 173 0 319 0 319 119 241 118 241 101 178 101
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 319 189 0 189 0 152 319 100 yourself:)
				60
				((Polygon new:) init: 247 51 146 78 104 46 yourself:)
				130
		)
		(atp1 init:)
		(atp2 init: setPri: 85)
		(atp3 init:)
		(atp4 init:)
		(atp5 init:)
		(atp6 init: setPri: 116)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 246
		y 5
		view 424
		cel 2
	)
)

(instance atp2 of ForestView
	(properties
		x 48
		y 1
		view 416
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 276
		y 1
		view 416
		loop 3
	)
)

(instance atp4 of ForestView
	(properties
		x 205
		y 74
		view 416
		loop 1
		cel 3
	)
)

(instance atp5 of ForestView
	(properties
		x 96
		y 3
		view 416
		cel 2
	)
)

(instance atp6 of ForestView
	(properties
		x 95
		y 34
		view 421
		loop 1
		cel 1
	)
)

