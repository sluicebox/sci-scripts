;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1610)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm1601 0
)

(instance rm1601 of KQRoom
	(properties
		picture 1610
	)

	(method (init)
		(super init: &rest)
		(Load rsMESSAGE 1600)
		(pouch init:)
		(gCurRoom setScript: openPouch)
	)
)

(instance takeRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rope dispose:)
				(gEgo get: 17) ; Rope
				(self cue:)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1600)
			)
		)
	)
)

(instance openPouch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1612) ; WAVE
				(= seconds 3)
			)
			(1
				(gKqSound1 number: 1612 setLoop: 1 play:)
				(if (gEgo has: 8) ; Hunting_Horn
					(pouch setLoop: 5 setCycle: End self)
				else
					(pouch setLoop: 0 setCycle: End self)
				)
			)
			(2
				(pouch setLoop: 1 1)
				(if (not (gEgo has: 8)) ; Hunting_Horn
					(rope init:)
				)
				(powder init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPowder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 19)
				(SetFlag 44)
				(gEgo get: 18) ; Bug_Reducing_Powder
				(powder dispose:)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1600)
			)
		)
	)
)

(instance pouch of Prop
	(properties
		x 204
		y 119
		view 1611
	)
)

(instance rope of View
	(properties
		noun 1
		modNum 1600
		x 204
		y 120
		z 1
		view 1611
		loop 3
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 209 77 230 75 237 94 215 102 207 87
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: takeRope)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance powder of View
	(properties
		x 204
		y 121
		z 2
		view 1611
		loop 2
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 80 197 86 203 98 196 99 184 85
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: getPowder)
		)
	)
)

