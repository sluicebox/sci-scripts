;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1105)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm1105 0
)

(instance rm1105 of KQRoom
	(properties
		picture 1105
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 1100)
		(gEgo init: hide:)
		(if (IsFlag 39)
			(keyHalf1 init:)
		)
		(if (IsFlag 40)
			(keyHalf2 init:)
		)
		(keyHole init:)
		(Load 140 1105) ; WAVE
		(Load rsVIEW 1106)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		(gGame handsOn:)
		(proc11_6 1100)
	)

	(method (dispose)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(super dispose:)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 13) ; Puzzle
				(keyHalf1 init:)
				(keyHalf2 init:)
				(Load 140 1106) ; WAVE
				(gKqSound1 number: 1105 play: self)
			)
			(1
				(gKqSound1 number: 1106 play: self)
			)
			(2
				(SetFlag 13)
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance keyHalf1 of View
	(properties
		x 164
		y 105
		view 1106
		signal 4129
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(ClearFlag 39)
				(gEgo get: 5) ; Turquoise_Piece_a
				(self dispose:)
			)
		)
	)
)

(instance keyHalf2 of View
	(properties
		x 164
		y 106
		z 1
		view 1106
		loop 1
		signal 4129
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(ClearFlag 40)
				(gEgo get: 12) ; Turquoise_Piece_b
				(self dispose:)
			)
		)
	)
)

(instance keyHole of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 23 20 22 ; Do, Exit, Puzzle, Turquoise_Piece_a, Turquoise_Piece_b
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 107 214 42 185 45 178 27 139 35 144 53 118 59
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb 14 0 0 1100) ; "It looks like something is supposed to fit in there."
			)
			(23 ; Puzzle
				(gCurRoom setScript: openDoor)
			)
			(20 ; Turquoise_Piece_a
				(if (IsFlag 40)
					(gMessager say: noun theVerb 15 0 0 1100) ; "It won't go in! I wonder if I have to put them together first."
				else
					(gEgo put: 5) ; Turquoise_Piece_a
					(keyHalf1 init:)
					(SetFlag 39)
					(gKqSound1 number: 1105 play:)
				)
			)
			(22 ; Turquoise_Piece_b
				(if (IsFlag 39)
					(gMessager say: noun theVerb 15 0 0 1100) ; "It won't go in! I wonder if I have to put them together first."
				else
					(gEgo put: 12) ; Turquoise_Piece_b
					(keyHalf2 init:)
					(SetFlag 40)
					(gKqSound1 number: 1105 play:)
				)
			)
		)
	)
)

