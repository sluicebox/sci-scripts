;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 586)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm586 0
)

(instance rm586 of GloryRm
	(properties
		picture 410
		style 1024
		horizon 70
		north 585
		south 587
		topX 140
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 489 -300 -300 101 -300 101 81 142 81 175 116 109 116 109 124 61 124 61 147 119 147 119 170 55 489
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 619 -300 619 489 213 489 249 168 280 162 280 159 249 159 249 144 297 144 297 130 216 130 163 82 191 71 191 -300
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: -300 489 -300 103 165 170 143 489
					yourself:
				)
				60
				((Polygon new:)
					init: 619 86 184 140 164 126 197 111 140 88 69 90 65 47 111 48 137 72 161 69 139 39 619 32
					yourself:
				)
				60
		)
		(atp1 init: setPri: 148)
		(atp2 init:)
		(atp3 init: setPri: 169)
		(atp4 init:)
		(atp5 init: setPri: 41)
		(atp6 init: setPri: 159)
		(stream1 setPri: 42 setCycle: Fwd init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 319
		y 109
		view 413
		loop 1
	)
)

(instance atp2 of ForestView
	(properties
		x 166
		y 55
		view 411
		loop 1
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 111
		y 119
		view 411
		loop 1
	)
)

(instance atp4 of ForestView
	(properties
		x 225
		y 49
		view 413
		loop 1
		cel 1
	)
)

(instance atp5 of ForestView
	(properties
		x 262
		y 73
		view 414
		loop 1
		cel 2
	)
)

(instance atp6 of ForestView
	(properties
		x 109
		y 119
		view 414
		loop 1
		cel 6
	)
)

(instance stream1 of ForestView
	(properties
		x 263
		y 73
		view 414
		loop 3
		signal 16385
		detailLevel 2
	)
)

