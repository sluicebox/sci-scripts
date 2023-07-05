;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 573)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm573 0
)

(instance rm573 of GloryRm
	(properties
		picture 420
		horizon 70
		north 572
		east 580
		south 574
		west 569
		topX 169
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 112 134 112 134 139 0 138
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 136 214 136 214 102 319 102
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 81 261 90 205 83 189 72 189 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 146 0 146 74 123 77 145 102 107 102 79 93 26 93 41 70 0 70
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 0 89 60 89 60 117 0 117 yourself:)
				130
				((Polygon new:)
					init: 0 127 160 123 297 137 316 161 274 164 276 189 0 189
					yourself:
				)
				60
				((Polygon new:) init: 319 110 300 106 286 83 319 74 yourself:)
				60
		)
		(atp1 init: setPri: 116)
		(atp2 init: setPri: 116)
		(if gNight
			(atp3 view: 427 loop: 0 cel: 1 x: 296 y: 74 setPri: 249)
			(atp5 view: 427 loop: 0 cel: 2 x: 302 y: 189 setPri: 249)
		)
		(atp3 init:)
		(atp4 init:)
		(atp5 init:)
		(atp6 setPri: 64 init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 223
		y 99
		view 416
		cel 4
	)
)

(instance atp2 of ForestView
	(properties
		x 1
		y 6
		view 416
	)
)

(instance atp3 of ForestView
	(properties
		x 227
		y 76
		view 424
		loop 2
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 260
		y 4
		view 416
		cel 1
	)
)

(instance atp5 of ForestView
	(properties
		x 35
		y 3
		view 416
		loop 2
	)
)

(instance atp6 of ForestView
	(properties
		x 117
		y 74
		view 416
		cel 3
	)
)

