;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 574)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm574 0
)

(instance rm574 of GloryRm
	(properties
		picture 430
		style 1024
		horizon 82
		north 573
		east 581
		south 575
		west 570
		topX 136
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 221 189 221 177 282 177 282 169 319 169
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 169 77 169 77 177 135 177 135 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 94 277 94 229 106 187 106 187 96 153 96 153 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 119 0 119 83 81 87 0 87
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 235 99 136 123 188 147 213 189 154 189 51 136 52 115 183 86
					yourself:
				)
				60
				((Polygon new:) init: 172 122 224 109 235 123 189 136 yourself:)
				130
				((Polygon new:)
					init: 319 189 218 189 213 181 276 152 263 123 291 114 262 108 307 101
					yourself:
				)
				130
				((Polygon new:) init: 188 70 183 84 83 106 90 66 yourself:)
				130
		)
		(if (not gNight)
			(atp1 init:)
		)
		(atp2 init:)
		(atp3 init:)
		(atp4 init: setPri: 180)
		(atp5 init: setPri: 180)
		(atp6 init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 197
		y 84
		view 434
		cel 2
	)
)

(instance atp2 of ForestView
	(properties
		x 316
		y 7
		view 434
		loop 5
	)
)

(instance atp3 of ForestView
	(properties
		x 130
		y 7
		view 434
		loop 5
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 129
		y 7
		view 439
		loop 1
		cel 1
	)
)

(instance atp5 of ForestView
	(properties
		x 316
		y 7
		view 439
		loop 1
	)
)

(instance atp6 of ForestView
	(properties
		x 223
		y 7
		view 434
		cel 3
	)
)

