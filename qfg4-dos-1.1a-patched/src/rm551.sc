;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 551)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm551 0
)

(instance rm551 of GloryRm
	(properties
		picture 420
		style 1024
		east 555
		south 520
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 168 189 168 179 319 179
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 70 290 70 290 91 205 104 179 104 188 79 118 79 118 62 90 62 90 83 61 91 61 107 106 107 106 119 55 119 55 130 22 140 61 162 61 168 22 168 22 189 0 189 0 0 319 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 319 189 0 189 0 145 240 111 270 136 319 139
					yourself:
				)
				60
				((Polygon new:)
					init: 31 88 121 90 126 100 181 114 131 121 36 105
					yourself:
				)
				130
		)
		(atp1 init: setPri: 42)
		(atp2 init: setPri: 116)
		(if gNight
			(atp3 view: 427 loop: 1 cel: 0 x: 319 y: 82 setPri: 180)
		)
		(atp3 init: setPri: 75)
		(atp4 init: setPri: 180)
		(atp5 init: setPri: 53)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 203
		y 74
		view 416
		loop 1
		cel 3
	)
)

(instance atp2 of ForestView
	(properties
		x 95
		y 34
		view 421
		loop 1
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 285
		y 3
		view 416
		loop 3
	)
)

(instance atp4 of ForestView
	(properties
		x 316
		y 169
		view 422
		loop 1
	)
)

(instance atp5 of ForestView
	(properties
		x 190
		y 1
		view 420
		loop 1
	)
)

