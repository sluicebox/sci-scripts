;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 556)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm556 0
)

(instance rm556 of GloryRm
	(properties
		picture 410
		horizon 70
		north 555
		east 561
		south 530
		topX 180
		rightY 135
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 134 0 134 71 154 81 110 116 110 131 43 131 43 143 69 143 69 170 105 181 105 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 205 189 205 144 319 144
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 128 234 128 213 118 178 118 145 111 183 81 231 72 231 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 319 189 177 189 163 177 221 143 319 143
					yourself:
				)
				60
				((Polygon new:)
					init: 166 118 197 152 152 172 166 189 84 189 72 173 120 138 147 141
					yourself:
				)
				130
		)
		(atp1 init: setPri: 180)
		(atp2 init: setPri: 53)
		(atp3 init:)
		(atp4 init: setPri: 169)
		(if gNight
			(atp5 init:)
		)
		(stream1 setCycle: Fwd init: setPri: 75)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		y 108
		view 413
	)
)

(instance atp2 of ForestView
	(properties
		x 94
		y 50
		view 413
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 57
		y 73
		view 414
		cel 2
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
		x 318
		y 20
		view 418
	)
)

(instance stream1 of ForestView
	(properties
		x 57
		y 73
		view 414
		loop 2
		signal 16385
		detailLevel 2
	)
)

