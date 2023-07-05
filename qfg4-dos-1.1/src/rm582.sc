;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 582)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm582 0
)

(instance rm582 of GloryRm
	(properties
		picture 410
		east 588
		south 583
		west 576
		rightY 135
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 126 221 126 144 112 144 107 251 75 251 63 206 63 168 74 136 62 104 62 104 74 153 81 159 90 95 109 112 132 0 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 271 189 205 169 205 145 319 145
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 33 154 47 139 36 146 18 140 37 134 19 129 54 35 314 64 115 114 157 121 149 138 124 135 52 189
					yourself:
				)
				60
				((Polygon new:) init: 143 189 319 101 319 189 yourself:)
				60
		)
		(atp1 init: setPri: 106)
		(atp2 init:)
		(atp3 init:)
		(atp4 init: setPri: 169)
		(if gNight
			(atp5 init: setPri: 249)
			(atp6 init: setPri: 249)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 154
		y 56
		view 411
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 70
		y 5
		view 414
		cel 5
	)
)

(instance atp3 of ForestView
	(properties
		x 141
		y 3
		view 410
	)
)

(instance atp4 of ForestView
	(properties
		x 210
		y 119
		view 414
		cel 6
	)
)

(instance atp5 of ForestView
	(properties
		x 28
		y 189
		view 417
	)
)

(instance atp6 of ForestView
	(properties
		x 18
		y 77
		view 417
		cel 1
	)
)

