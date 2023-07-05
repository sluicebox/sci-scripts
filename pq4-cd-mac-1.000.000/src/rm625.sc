;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 625)
(include sci.sh)
(use Main)
(use ExitArrow)
(use Inset)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Game)
(use Actor)

(public
	rm625 0
)

(instance rm625 of Room
	(properties
		noun 8
		picture 625
	)

	(method (init)
		(gPqFlags set: 120)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 119 152 189 150 189 146 131 146 146 125 140 125
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			view: 9120
			posn: 145 146
			setHeading: 0
			setScaler: Scaler 95 74 150 124
			init:
			normalize: 9120
		)
		(dispenser init: approachVerbs: 1 4 52) ; Look, Do, notebook
		(if (== gDay 5)
			(dress init: approachVerbs: 1 4 52) ; Look, Do, notebook
		)
		(wasteCan init: approachVerbs: 4 1 52) ; Do, Look, notebook
		(sink init: approachVerbs: 4 1 52) ; Do, Look, notebook
		(toLobby init:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo y:) 147)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance dispenser of Feature
	(properties
		noun 3
		nsLeft 184
		nsTop 42
		nsRight 203
		nsBottom 53
		sightAngle 40
		approachX 173
		approachY 146
		approachDist 2
		x 193
		y 47
	)

	(method (doVerb theVerb)
		(if (== gDay 6)
			(if (gPqFlags test: 170)
				(if (gPqFlags test: 171)
					(switch theVerb
						(4 ; Do
							(super doVerb: theVerb)
							(gCurRoom setInset: dispInset)
						)
						(52 ; notebook
							(if (gPqFlags test: 172)
								(gMessager say: 6 theVerb 3) ; "You've already notated your discovery."
							else
								(gPqFlags set: 172)
								(gMessager say: 6 theVerb 1) ; "Discovery notated, Detective."
							)
						)
						(else
							(super doVerb: theVerb)
						)
					)
				else
					(switch theVerb
						(4 ; Do
							(super doVerb: theVerb)
							(gPqFlags set: 171)
							(gCurRoom setInset: dispInset)
						)
						(else
							(if (Message msgSIZE 625 noun theVerb 1 1)
								(gMessager say: noun theVerb 1)
							else
								(super doVerb: theVerb)
							)
						)
					)
				)
			else
				(switch theVerb
					(80 ; skeletonKey
						(gPqFlags set: 170)
						(gGame points: 3 77)
					)
					(else
						(if (Message msgSIZE 625 noun theVerb 1 1)
							(gMessager say: noun theVerb 1)
						else
							(super doVerb: theVerb)
						)
					)
				)
			)
		else
			(switch theVerb
				(4 ; Do
					(super doVerb: theVerb)
					(gCurRoom setInset: dispInset)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance dress of View
	(properties
		noun 2
		approachX 138
		approachY 137
		approachDist 30
		x 129
		y 115
		view 624
	)
)

(instance wasteCan of Feature
	(properties
		noun 5
		nsLeft 153
		nsTop 89
		nsRight 176
		nsBottom 144
		sightAngle 40
		approachX 173
		approachY 146
		approachDist 2
		x 164
		y 116
	)
)

(instance sink of Feature
	(properties
		noun 4
		nsLeft 180
		nsTop 87
		nsRight 205
		nsBottom 122
		sightAngle 40
		approachX 189
		approachY 146
		approachDist 2
		x 192
		y 104
	)
)

(instance toLobby of ExitArrow
	(properties
		nsTop 148
		nsBottom 160
		nsRight 319
		exitDir 3
	)
)

(instance dispInset of Inset
	(properties
		picture 630
		disposeNotOnMe 1
		noun 6
	)

	(method (init &tmp temp0)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 show: 0)
		(Platform 0 2 1)
		(super init: &rest)
		(if (and (not (gEgo has: 39)) (== gDay 6)) ; hypoBaggie
			(gGlobalSound0 stop:)
			(gGlobalSound1 number: 104 loop: 1 play:)
			(hypo init:)
		)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 65 (param1 x:) 256) (<= 12 (param1 y:) 141)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gGlobalSound1 fade: 0 3 3 1)
		(gGlobalSound0 number: 425 loop: -1 play:)
		(gTheIconBar enable: 0 3 7)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(Platform 0 2 0)
	)

	(method (doVerb theVerb)
		(if (== gDay 6)
			(cond
				((== theVerb 52) ; notebook
					(if (gPqFlags test: 172)
						(gMessager say: 6 theVerb 3) ; "You've already notated your discovery."
					else
						(gPqFlags set: 172)
						(gMessager say: 6 theVerb 1) ; "Discovery notated, Detective."
					)
				)
				((gEgo has: 39) ; hypoBaggie
					(if (Message msgSIZE 625 noun theVerb 1 1)
						(gMessager say: noun theVerb 1)
					else
						(super doVerb: theVerb)
					)
				)
				((Message msgSIZE 625 noun theVerb 2 1)
					(gMessager say: noun theVerb 2)
				)
				((Message msgSIZE 625 noun theVerb 1 1)
					(gMessager say: noun theVerb 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance roomSFX of Sound ; UNUSED
	(properties)
)

(instance hypo of Prop
	(properties
		noun 7
		x 147
		y 49
		view 630
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; caseBaggies
				(gEgo get: 39) ; hypoBaggie
				(gGame points: 3)
				(hypo dispose:)
			)
			(52 ; notebook
				(if (gPqFlags test: 172)
					(gMessager say: 6 theVerb 3) ; "You've already notated your discovery."
				else
					(gPqFlags set: 172)
					(gMessager say: 6 theVerb 1) ; "Discovery notated, Detective."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

