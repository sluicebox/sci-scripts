;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 564)
(include sci.sh)
(use Main)
(use GloryRm)
(use forest)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)

(public
	rm564 0
)

(instance rm564 of GloryRm
	(properties
		picture 410
		style 1024
		horizon 70
		north 563
		east 567
		south 565
		topX 140
	)

	(method (init)
		(streamFX play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 78 0 78 81 136 81 173 115 82 128 67 128 67 142 114 142 114 168 63 189 0 189 0 127
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 204 117 164 85 164 80 192 72 192 0 319 0 319 132 205 132
					yourself:
				)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 319 189 283 189 277 148 300 143 282 133 319 122
					yourself:
				)
				130
				((Polygon new:)
					init: 143 189 205 181 188 165 217 157 266 189
					yourself:
				)
				130
				((Polygon new:)
					init: 169 170 122 159 154 117 155 150 206 139 229 150 172 152
					yourself:
				)
				130
				((Polygon new:)
					init: 184 136 166 123 193 112 144 83 191 79 226 125
					yourself:
				)
				60
		)
		(atp1 init:)
		(atp3 init: setPri: 106)
		(atp4 init: setPri: 116)
		(atp5 init: setPri: 169)
		(if gNight
			(atp2Night init:)
		else
			(atp2Day init: setPri: 180)
		)
		(stream1 setPri: 74 setCycle: Fwd init:)
		(streamMat init:)
		(leftTree init:)
		(rightTree init:)
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
		x 262
		y 73
		view 414
		loop 1
		cel 2
	)
)

(instance atp3 of ForestView
	(properties
		x 165
		y 57
		view 411
		loop 1
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 28
		y 110
		view 411
		loop 1
		cel 2
	)
)

(instance atp5 of ForestView
	(properties
		x 109
		y 119
		view 414
		loop 1
		cel 6
	)
)

(instance atp2Day of ForestView
	(properties
		x 62
		y 157
		view 414
		loop 1
		cel 4
	)
)

(instance atp2Night of ForestView
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
		x 263
		y 73
		view 414
		loop 3
		signal 16385
		detailLevel 2
	)
)

(instance streamFX of Sound
	(properties
		number 982
		loop -1
	)
)

(instance leftTree of Feature
	(properties
		noun 6
		modNum 50
		nsLeft 32
		nsRight 63
		nsBottom 136
		sightAngle 40
		approachX 47
		approachY 68
		x 47
		y 68
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if [gEgoStats 11] ; climbing
					(gEgo trySkill: 11 300) ; climbing
					(gMessager say: 12 6 7 0 0 50) ; "You get in some climbing practice, but you really can't see any more from up the tree than from the ground. (In fact, you can scarcely see the forest for the trees.)"
				else
					(gMessager say: 12 6 8 0 0 50) ; "The trees in this part of the forest feel particularly wooden."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightTree of Feature
	(properties
		noun 6
		modNum 50
		nsLeft 230
		nsTop -2
		nsRight 249
		nsBottom 114
		sightAngle 40
		approachX 239
		approachY 56
		x 239
		y 110
	)

	(method (doVerb theVerb)
		(leftTree doVerb: theVerb &rest)
	)
)

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 206 115 156 108 132 83 172 88 206 115)
	)
)

