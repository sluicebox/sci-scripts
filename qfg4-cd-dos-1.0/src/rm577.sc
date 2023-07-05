;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 577)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Motion)

(public
	rm577 0
)

(instance rm577 of GloryRm
	(properties
		picture 410
		horizon 70
		north 576
		east 583
		south 578
		topX 182
		rightY 137
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 117 0 117 71 160 88 160 93 132 101 110 132 27 132 27 146 67 146 67 158 34 158 34 162 57 162 108 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 147 319 189 243 189 205 163 205 147
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 127 226 127 204 115 149 115 149 101 240 71 240 0 319 0
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 80 56 152 48 161 73 184 74 209 54 319 59 123 112 165 126 131 138 79 124
					yourself:
				)
				60
				((Polygon new:) init: 319 189 180 189 144 175 319 121 yourself:)
				60
		)
		(atp1 init: setPri: 148)
		(atp2 init:)
		(atp3 init:)
		(atp4 init: setPri: 169)
		(if gNight
			(atp5 init: setPri: 249)
		)
		(stream1 setPri: 74 setCycle: Fwd init:)
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
		y 108
		view 413
	)
)

(instance atp2 of ForestView
	(properties
		x 94
		y 49
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
		x 87
		y 189
		view 418
		loop 1
		cel 2
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

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 153 110 118 113 149 82 211 83 154 110)
	)
)

