;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 581)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm581 0
)

(instance rm581 of GloryRm
	(properties
		picture 420
		style 1024
		horizon 66
		north 580
		west 574
		topX 155
		leftY 136
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -300 143 38 143 72 160 121 160 139 168 171 168 181 176 265 176 265 153 221 153 221 148 281 113 267 104 277 93 191 105 145 90 177 68 177 -300 619 -300 619 489 -300 489
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: -300 -300 127 -300 127 87 155 102 135 103 104 98 84 106 101 115 33 130 -300 130
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 619 69 619 489 36 489 102 121 184 123 194 100 125 93 114 75
					yourself:
				)
				60
				((Polygon new:) init: -300 57 40 64 38 114 -300 122 yourself:)
				60
		)
		(atp1 init: setPri: 180)
		(atp2 init:)
		(atp3 init: setPri: 42)
		(atp4 init:)
		(bridge init: setPri: 116)
		(if gNight
			(atp6Night init: setPri: 180)
		else
			(atp6Day init: setPri: 95)
		)
		(stream1 setPri: 42 setCycle: Fwd init:)
		(stream2 setPri: 42 setCycle: Fwd init:)
		(stream3 setPri: 42 setCycle: Fwd init:)
		(streamMat init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; glideSpell
				(if (streamMat onMe: (gEgo x:) (gEgo y:))
					(gMessager say: 12 6 10 0 0 50) ; "The water is too shallow for this spell to work."
				else
					(gMessager say: 30 0 18 0 0 50) ; "The Glide spell only works on liquid; you can't cast it here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(streamMat dispose:)
		(super dispose:)
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
		x 316
		y 50
		view 423
		loop 1
	)
)

(instance atp3 of ForestView
	(properties
		x 197
		y 132
		view 424
		loop 1
		cel 3
	)
)

(instance atp4 of ForestView
	(properties
		x 280
		y 14
		view 424
		loop 3
		cel 4
	)
)

(instance bridge of ForestView
	(properties
		x 13
		y 148
		view 424
		loop 1
		cel 4
	)
)

(instance atp6Day of ForestView
	(properties
		x 78
		y 5
		view 424
		loop 3
	)
)

(instance atp6Night of ForestView
	(properties
		x 319
		y 81
		view 427
		loop 1
	)
)

(instance stream1 of ForestView
	(properties
		x 187
		y 102
		view 420
		loop 5
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 30
		y 126
		view 420
		loop 7
		signal 16385
		detailLevel 2
	)
)

(instance stream3 of ForestView
	(properties
		x 56
		y 188
		view 424
		loop 5
		signal 16385
		detailLevel 2
	)
)

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 185 101 146 101 141 97 173 96)
	)
)

