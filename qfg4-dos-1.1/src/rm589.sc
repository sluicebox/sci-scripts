;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 589)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm589 0
)

(instance rm589 of GloryRm
	(properties
		picture 420
		south 590
		west 584
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 619 -300 619 489 293 489 293 167 257 167 257 155 272 155 298 143 298 137 263 129 263 118 215 118 215 101 125 105 90 96 65 96 34 69 -300 69
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 489 -300 173 133 173 133 489
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: -300 147 32 147 80 111 122 111 257 142 619 126 619 489 -300 489
					yourself:
				)
				60
				((Polygon new:) init: 229 92 188 116 129 100 yourself:)
				130
		)
		(atp1 init:)
		(atp2 init: setPri: 95)
		(atp3 init: setPri: 180)
		(atp4 init: setPri: 95)
		(stream1 setPri: 74 setCycle: Fwd init:)
		(stream2 setPri: 74 setCycle: Fwd init:)
		(stream3 setPri: 74 setCycle: Fwd init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 131
		y 1
		view 420
	)
)

(instance atp2 of ForestView
	(properties
		x 282
		y 5
		view 416
		loop 1
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 124
		y 7
		view 429
		loop 1
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 224
		y 34
		view 421
		cel 1
	)
)

(instance stream1 of ForestView
	(properties
		x 69
		y 73
		view 420
		loop 2
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 133
		y 102
		view 420
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance stream3 of ForestView
	(properties
		x 290
		y 126
		view 420
		loop 6
		signal 16385
		detailLevel 2
	)
)

