;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 585)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm585 0
)

(instance rm585 of GloryRm
	(properties
		picture 420
		horizon 75
		north 584
		east 590
		south 586
		west 579
		topX 169
		rightY 136
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 130 294 130 209 114 136 114 136 105 164 105 179 93 179 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 160 0 160 88 129 104 95 104 95 97 62 97 35 70 0 70 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 113 189 164 163 187 163 201 158 255 158 283 141 319 141
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:) init: 218 43 187 85 147 83 118 54 yourself:)
				130
				((Polygon new:)
					init: 277 189 0 189 0 123 47 140 82 111 241 139
					yourself:
				)
				60
		)
		(atp1 init: setPri: 42)
		(atp2 init: setPri: 107)
		(bridge init: setPri: 116)
		(if gNight
			(atp3 init: setPri: 249)
			(atp4 init: setPri: 249)
		)
		(stream1 setPri: 74 setCycle: Fwd init:)
		(stream2 setPri: 74 setCycle: Fwd init:)
		(stream3 setPri: 74 setCycle: Fwd init:)
		(stream4 setPri: 74 setCycle: Fwd init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 121
		y 131
		view 424
		cel 3
	)
)

(instance atp2 of ForestView
	(properties
		x 147
		y 5
		view 424
		cel 2
	)
)

(instance bridge of ForestView
	(properties
		x 306
		y 148
		view 424
		cel 4
	)
)

(instance atp3 of ForestView
	(properties
		x 19
		y 73
		view 428
	)
)

(instance atp4 of ForestView
	(properties
		x 26
		y 189
		view 428
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

(instance stream4 of ForestView
	(properties
		x 264
		y 188
		view 424
		loop 4
		signal 16385
		detailLevel 2
	)
)

