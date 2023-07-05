;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 584)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm584 0
)

(instance rm584 of GloryRm
	(properties
		picture 410
		style 1024
		horizon 70
		north 583
		east 589
		south 585
		west 578
		topX 138
		leftY 136
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 145 113 145 113 170 66 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 73 0 73 71 168 102 168 116 109 116 93 126 0 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 132 206 132 218 107 156 90 211 65 211 0 319 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 319 189 272 189 285 154 269 141 301 142 282 131 319 126
					yourself:
				)
				130
				((Polygon new:) init: 0 189 0 108 184 171 149 189 yourself:)
				60
				((Polygon new:)
					init: 163 125 208 117 80 88 44 48 124 57 137 73 160 68 150 52 227 41 273 114 188 139
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp3 init: setPri: 180)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 68
		y 6
		view 414
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		x 110
		y 119
		view 414
		loop 1
		cel 3
	)
)

