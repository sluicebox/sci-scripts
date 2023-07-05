;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm560 0
)

(instance rm560 of GloryRm
	(properties
		picture 410
		horizon 70
		north 559
		east 566
		south 561
		west 555
		topX 180
		rightY 130
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 157 0 157 73 143 121 166 121 165 136 106 136 0 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 122 257 123 199 90 249 71 249 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 218 139 319 139 319 189 227 189 203 166
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 176 189 138 170 181 168 319 84 319 189
					yourself:
				)
				60
				((Polygon new:) init: 225 61 257 70 169 105 132 105 yourself:)
				60
				((Polygon new:)
					init: 0 124 37 134 20 142 31 146 48 139 33 154 50 185 97 164 99 189 0 189
					yourself:
				)
				130
		)
		(atp1 init:)
		(atp2 init: setPri: 127)
		(atp3 init: setPri: 169)
		(if gNight
			(atp4 init: setPri: 249)
		)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 155
		y 91
		view 415
		cel 5
	)
)

(instance atp2 of ForestView
	(properties
		x 64
		y 4
		view 415
	)
)

(instance atp3 of ForestView
	(properties
		x 210
		y 119
		view 414
		cel 6
	)
)

(instance atp4 of ForestView
	(properties
		x 61
		y 189
		view 418
		cel 1
	)
)

