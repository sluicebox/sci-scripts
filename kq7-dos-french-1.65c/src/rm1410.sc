;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1410)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm1410 0
)

(local
	local0
	local1
	local2
)

(instance rm1410 of KQRoom
	(properties
		picture 1470
	)

	(method (init)
		(super init:)
		(= south 1400)
		(SetFlag 21)
		(if (not (gEgo has: 22)) ; Turquoise_Shape
			(theShape init:)
		)
		(if
			(and
				(== gChapter 1)
				(not (gEgo has: 12)) ; Turquoise_Piece_b
				(not (gEgo has: 13)) ; Puzzle
				(not (IsFlag 13))
				(not (IsFlag 40))
			)
			(theKey init:)
		)
		(if (IsFlag 320)
			(theBead init:)
		)
		(bowl init:)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		(gGame handsOn:)
		(proc11_6 1400)
	)

	(method (dispose)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(super dispose:)
	)
)

(instance egoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1413) ; WAVE
				(self cue:)
			)
			(1
				(gGame handsOn:)
				(SetFlag 306)
				(gCurRoom newRoom: 1400)
			)
		)
	)
)

(instance putBead of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 1412 play: self)
			)
			(1
				(theBead init:)
				(gEgo put: 11) ; Turquoise_Bead
				(SetFlag 12)
				(self cue:)
			)
			(2
				(gCurRoom newRoom: 1400)
			)
		)
	)
)

(instance getObject of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(gEgo put: register)
					(local2 init:)
				else
					(gEgo get: register)
					(local1 dispose:)
				)
				(= ticks 30)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theShape of View
	(properties
		x 132
		y 57
		view 1470
		cel 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 ignoreActors: 1) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (gCast contains: theBead) (gCast contains: theKey))
					(gEgo get: 22) ; Turquoise_Shape
					(ClearFlag 330)
					(SetFlag 333)
					(gCurRoom newRoom: 1400)
				else
					(gEgo get: 22) ; Turquoise_Shape
					(SetFlag 333)
					(gCurRoom setScript: egoDies)
				)
			)
		)
	)
)

(instance theKey of View
	(properties
		x 152
		y 64
		view 1470
		cel 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 ignoreActors: 1) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(gCast contains: theBead)
						(gCast contains: theShape)
					)
					(gEgo get: 12) ; Turquoise_Piece_b
					(ClearFlag 330)
					(SetFlag 334)
					(gCurRoom newRoom: 1400)
				else
					(gCurRoom setScript: egoDies)
				)
			)
		)
	)
)

(instance theBead of View
	(properties
		x 134
		y 57
		view 1470
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 ignoreActors: 1) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(and
						(gCast contains: theKey)
						(gCast contains: theShape)
					)
					(gEgo get: 11) ; Turquoise_Bead
					(ClearFlag 330)
					(ClearFlag 320)
					(SetFlag 335)
					(gCurRoom newRoom: 1400)
				else
					(gEgo get: 11) ; Turquoise_Bead
					(SetFlag 335)
					(gCurRoom setScript: egoDies)
				)
			)
		)
	)
)

(instance bowl of Feature
	(properties
		noun 1
		y 200
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 91)
			(self y: 0 setHotspot: 0 16 53 22) ; Turquoise_Bead, Turquoise_Shape, Turquoise_Piece_b
		else
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 41 42 53 22 72 45 103 106 124 229 121 282 87 284 62 221 42 142 36
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb 1 0) ; "That looks like some kind of offering bowl."
				(self y: 0 setHotspot: 0 setHotspot: 0 16 53 22) ; Turquoise_Bead, Turquoise_Shape, Turquoise_Piece_b
				(SetFlag 91)
			)
			(16 ; Turquoise_Bead
				(gEgo put: 11) ; Turquoise_Bead
				(theBead init:)
				(if
					(and
						(gCast contains: theKey)
						(gCast contains: theShape)
					)
					(SetFlag 12)
					(gCurRoom newRoom: 1400)
				)
			)
			(53 ; Turquoise_Shape
				(SetFlag 342)
				(if (and (gCast contains: theKey) (gCast contains: theBead))
					(SetFlag 12)
					(gCurRoom newRoom: 1400)
				)
			)
			(22 ; Turquoise_Piece_b
				(SetFlag 343)
				(if
					(and
						(gCast contains: theShape)
						(gCast contains: theBead)
					)
					(SetFlag 12)
					(gCurRoom newRoom: 1400)
				)
			)
		)
	)
)

