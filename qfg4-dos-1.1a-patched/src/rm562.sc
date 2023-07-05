;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 562)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)

(public
	rm562 0
)

(instance rm562 of GloryRm
	(properties
		picture 410
		horizon 70
		north 561
		south 535
		west 530
		topX 182
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 127 -300 127 75 159 84 159 92 110 98 97 107 108 132 -300 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 236 -300 619 -300 619 489 264 489 202 172 202 164 221 134 298 134 298 127 226 127 204 118 150 118 147 100 236 82
					yourself:
				)
		)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 619 489 177 489 136 173 182 170 197 152 619 147
					yourself:
				)
				60
				((Polygon new:)
					init: 91 82 202 91 120 113 159 125 143 139 88 128
					yourself:
				)
				60
				((Polygon new:)
					init: -300 489 -300 126 31 133 20 141 46 166 58 184 97 159 131 489
					yourself:
				)
				130
		)
		(atp1 init:)
		(atp2 init: setPri: 106)
		(atp3 init: setPri: 169)
		(if gNight
			(atp3Night init:)
			(atp4Night init: setPri: 189)
		else
			(atp3Day init: setPri: 169)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 71
		y 5
		view 414
		cel 5
	)
)

(instance atp2 of ForestView
	(properties
		x 154
		y 56
		view 411
		cel 1
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

(instance atp3Day of ForestView
	(properties
		x 208
		y 119
		view 411
	)
)

(instance atp3Night of ForestView
	(properties
		x 28
		y 189
		view 417
	)
)

(instance atp4Night of ForestView
	(properties
		x 18
		y 77
		view 417
		cel 1
	)
)

