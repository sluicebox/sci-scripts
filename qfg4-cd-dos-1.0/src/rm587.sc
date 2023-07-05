;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 587)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm587 0
)

(instance rm587 of GloryRm
	(properties
		picture 420
		horizon 70
		north 586
		east 591
		west 580
		topX 170
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 148 0 148 73 129 76 139 101 105 101 32 88 32 70 0 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 67 294 88 233 88 190 73 190 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 135 213 135 213 104 319 104
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 174 319 174
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 319 189 0 189 0 124 53 136 73 114 273 139 319 42
					yourself:
				)
				60
		)
		(if gNight
			(atp5 view: 426 loop: 0 cel: 0 x: 61 y: 189)
			(atp1 view: 426 loop: 0 cel: 1 x: 225 y: 189)
		)
		(atp1 init: setPri: 189)
		(atp2 init: setPri: 116)
		(atp3 init:)
		(atp4 init:)
		(atp5 init: setPri: 189)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 146
		y 152
		view 422
		cel 1
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
		x 40
		y 14
		view 424
		loop 2
		cel 4
	)
)

(instance atp5 of ForestView
	(properties
		x 4
		y 169
		view 422
	)
)

