;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 562)
(include sci.sh)
(use Main)
(use Inset)
(use Timer)
(use Sound)
(use Actor)

(public
	theIntercom 0
)

(procedure (localproc_0)
	(olympiaButton setCel: 1)
	(yvetteButton setCel: 1)
	(ernieButton setCel: 1)
	(heimlichButton setCel: 1)
	(nextButton setCel: 1)
	(lastButton setCel: 1)
)

(procedure (localproc_1)
	(DisposeScript 1892)
	(DisposeScript 1889)
	(DisposeScript 1885)
	(DisposeScript 1888)
	(DisposeScript 1893)
	(DisposeScript 1890)
)

(instance theIntercom of Inset
	(properties
		view 563
		loop 3
		x 105
		y 109
		disposeNotOnMe 1
		modNum 562
		noun 54
	)

	(method (init)
		(super init: &rest)
		(onOff init:)
		(sendReceive init:)
		(olympiaButton init:)
		(yvetteButton init:)
		(ernieButton init:)
		(heimlichButton init:)
		(nextButton init:)
		(lastButton init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (and (== (onOff cel:) 2) (== (sendReceive cel:) 2))
					(gMessager say: 54 theVerb 0 (Random 2 7) 0 562)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(localproc_1)
		(sFX dispose:)
		(super dispose:)
		(DisposeScript 562)
	)
)

(instance onOff of Prop
	(properties
		x 133
		y 133
		noun 57
		modNum 562
		view 563
		loop 3
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 1)
					(self setCel: 2)
				else
					(self setCel: 1)
				)
				(sFX number: 558 flags: 1 setLoop: 1 play:)
			)
			(8 ; magnifier
				(if (== cel 2)
					(gMessager say: noun theVerb 8 0 0 562) ; "The button is currently in the ON position."
				else
					(gMessager say: noun theVerb 9 0 0 562) ; "The button is currently in the OFF position."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sendReceive of Prop
	(properties
		x 139
		y 117
		noun 77
		modNum 562
		view 563
		loop 3
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (self cel:) 1)
					(self setCel: 2)
				else
					(self setCel: 1)
				)
				(sFX number: 558 flags: 1 setLoop: 1 play:)
			)
			(8 ; magnifier
				(if (== cel 2)
					(gMessager say: noun theVerb 6 0 0 562) ; "The button is in the SEND position."
				else
					(gMessager say: noun theVerb 7 0 0 562) ; "The button is in the RECEIVE position."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class Button of Prop
	(properties
		noun 84
		modNum 562
		view 563
		loop 3
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 1)
					(localproc_0)
					(localproc_1)
					(self pushButton:)
				else
					(self setCel: 1)
				)
				(sFX number: 558 flags: 1 setLoop: 1 play:)
			)
			(8 ; magnifier
				(if (== cel 2)
					(gMessager say: noun theVerb 12 0 0 562) ; "The button looks depressed."
				else
					(gMessager say: noun theVerb 13 0 0 562) ; "The button is in the up position, indicating that it's not in use."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (and (== (onOff cel:) 2) (== (sendReceive cel:) 1))
			(sFX number: 567 flags: 1 setLoop: 1 play:)
			(gMessager say: 54 4 5 0 0 562) ; "When you press the button, all you hear is static."
		)
	)

	(method (pushButton)
		(self setCel: 2)
		((Timer new:) setCycle: self 2)
	)
)

(instance olympiaButton of Button
	(properties
		x 139
		y 135
	)

	(method (cue)
		(if (and (== (onOff cel:) 2) (== (sendReceive cel:) 1))
			(sFX number: 567 flags: 1 setLoop: 1 play:)
			(if (IsFlag 51)
				(gMessager say: 54 4 2 0 0 562) ; "You hear only static this time."
			else
				(gMessager say: 54 4 1 0 0 562) ; "The intercom crackles and you overhear a conversation:"
				(SetFlag 51)
			)
		)
	)
)

(instance yvetteButton of Button
	(properties
		x 140
		y 132
	)

	(method (cue)
		(if (and (== (onOff cel:) 2) (== (sendReceive cel:) 1))
			(sFX number: 567 flags: 1 setLoop: 1 play:)
			(if (not (IsFlag 52))
				(SetFlag 52)
				(if (not (IsFlag 5))
					(gMessager say: 54 4 3 0 0 562) ; "The intercom crackles and you overhear a conversation:"
				else
					(gMessager say: 54 4 5 0 0 562) ; "When you press the button, all you hear is static."
				)
			else
				(gMessager say: 54 4 2 0 0 562) ; "You hear only static this time."
			)
		)
	)
)

(instance ernieButton of Button
	(properties
		x 141
		y 129
	)

	(method (cue)
		(if (and (== (onOff cel:) 2) (== (sendReceive cel:) 1))
			(sFX number: 567 flags: 1 setLoop: 1 play:)
			(if (not (IsFlag 53))
				(SetFlag 53)
				(if (and (not (IsFlag 2)) (not (IsFlag 4)))
					(gMessager say: 54 4 4 0 0 562) ; "The intercom crackles and you overhear a conversation:"
				else
					(gMessager say: 54 4 5 0 0 562) ; "When you press the button, all you hear is static."
				)
			else
				(gMessager say: 54 4 2 0 0 562) ; "You hear only static this time."
			)
		)
	)
)

(instance heimlichButton of Button
	(properties
		x 142
		y 126
	)
)

(instance nextButton of Button
	(properties
		x 143
		y 123
	)
)

(instance lastButton of Button
	(properties
		x 144
		y 120
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

