;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18250)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm18250 0
)

(instance rm18250 of ScaryRoom
	(properties
		picture 18250
	)

	(method (init)
		(proc1111_6)
		(gEgo
			init:
			normalize:
			view: 617
			setLoop: 0 1
			cel: 19
			setScaler: Scaler 114 113 162 161
			x: 159
			y: 172
			z: 0
			approachVerbs: 0
			setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
		)
		(reflection init:)
		(towel init: approachVerbs: 0 setHotspot: 4 1 3 2 21) ; Do, ???, Move, ???, Exit
		(if (< gChapter 4)
			(lotion init: approachVerbs: 0 setHotspot: 4 1 3 2 21) ; Do, ???, Move, ???, Exit
			(compact init: approachVerbs: 0 setHotspot: 4 1 3 2 21) ; Do, ???, Move, ???, Exit
			(brush init: approachVerbs: 0 setHotspot: 4 1 3 2 21) ; Do, ???, Move, ???, Exit
			(lipstick init:)
			(theMirror init:)
		)
		(faucet init:)
		(super init:)
		(lowerExit init:)
		(gGame handsOn:)
	)
)

(instance reflection of View
	(properties
		sightAngle 360
		x 78
		y 155
		priority 4
		fixPriority 1
		view 614
		cel 17
	)
)

(instance brush of View
	(properties
		sightAngle 360
		x 87
		y 124
		priority 120
		fixPriority 1
		view 18250
		cel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 77)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance compact of View
	(properties
		sightAngle 360
		x 130
		y 116
		priority 120
		fixPriority 1
		view 18250
		cel 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 76)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lotion of View
	(properties
		sightAngle 360
		x 53
		y 115
		priority 120
		fixPriority 1
		view 18250
		cel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 79)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance towel of View
	(properties
		sightAngle 360
		x 118
		y 101
		priority 120
		fixPriority 1
		view 18250
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 93 119 98 131 101 133 96
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 78)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lowerExit of Trigger
	(properties
		exitDir 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 138 211 103 292 103 292 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitScr 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance upperExit of Trigger ; UNUSED
	(properties
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 102 213 0 292 0 292 102
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gCurRoom setScript: sExitScr 0 self)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sExitScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= seconds 3)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(gCurRoom newRoom: 18200)
		(super dispose: &rest)
	)
)

(instance theMirror of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 27 0 29 5 21 5 17 14 47 35 51 52 42 65 52 65 40 80 115 73 104 68 105 65 111 65 107 45 122 31 118 28 115 26 121 19 118 9 107 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 70)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance faucet of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 98 90 98 105 74 105 74 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(towel doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lipstick of Feature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			approachVerbs: 0
			setHotspot: 4 1 3 2 21 ; Do, ???, Move, ???, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 100 150 101 158 108 166 102
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 75)
			(gCurRoom newRoom: 18210)
		else
			(super doVerb: theVerb)
		)
	)
)

