;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Game)

(public
	rm820 0
)

(instance rm820 of Room
	(properties
		picture 820
		horizon 104
	)

	(method (init)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 150 150 247 150 307 143 301 135 246 142 230 140 192 130 166 120 131 106 102 109 124 122 136 129 143 140
					yourself:
				)
		)
		(gGame handsOn:)
		(gEgo
			setHeading: 175
			normalize: 0
			init:
			posn: 131 116 0
			setScale: Scaler 100 43 156 99
			setMotion: PolyPath 131 122
		)
		(puzzle init: approachVerbs: 1) ; Look
	)

	(method (doit)
		(super doit:)
		(cond
			((< (gEgo y:) (+ horizon 5))
				(self newRoom: gPrevRoomNum)
			)
			((>= (gEgo y:) 145)
				(gEgo setMotion: 0 y: 144)
				(barkSnd play:)
			)
		)
	)
)

(instance puzzle of Feature
	(properties
		nsLeft 45
		nsTop 82
		nsRight 74
		nsBottom 102
		sightAngle 40
		approachX 99
		approachY 108
		approachDist 0
		x 59
		y 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: (ScriptID 20 0)) ; shoeInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barkSnd of Sound
	(properties
		number 995
	)
)

