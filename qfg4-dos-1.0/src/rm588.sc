;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 588)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm588 0
)

(instance rm588 of GloryRm
	(properties
		picture 420
		horizon 70
		north 460
		west 582
		topX 153
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 151 0 151 71 168 91 137 105 119 105 59 92 28 92 28 70 0 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 0 189 0 173 240 173 300 145 300 139 259 133 259 121 224 121 210 114 152 114 152 104 180 104 180 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 0 124 49 139 78 109 265 144 319 125 319 189 0 189
					yourself:
				)
				60
				((Polygon new:) init: 210 28 211 86 157 87 117 60 yourself:)
				130
		)
		(atp1 init: setPri: 180)
		(atp2 init: setPri: 95)
		(atp3 init: setPri: 106)
		(atp4 init:)
		(atp5 init: setPri: 180)
		(stream1 setPri: 74 setCycle: Fwd init:)
		(stream2 setPri: 74 setCycle: Fwd init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 316
		y 169
		view 422
		loop 1
	)
)

(instance atp2 of ForestView
	(properties
		x 224
		y 37
		view 421
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 159
		y 5
		view 424
		cel 2
	)
)

(instance atp4 of ForestView
	(properties
		x 35
		y 2
		view 416
		loop 2
	)
)

(instance atp5 of ForestView
	(properties
		x 174
		y 152
		view 422
		loop 1
		cel 1
	)
)

(instance stream1 of ForestView
	(properties
		x 133
		y 102
		view 420
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 290
		y 126
		view 420
		loop 6
		signal 16385
		detailLevel 2
	)
)

