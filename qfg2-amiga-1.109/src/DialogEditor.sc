;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 947)
(include sci.sh)
(use VerbMessager)
(use System)

(class DelayedEvent of Event
	(properties
		client 0
	)

	(method (perform param1 param2 &tmp temp0)
		(= temp0 (super perform:))
		(if argc
			(temp0 client: param1)
			(if (>= argc 2)
				(temp0
					type: (param2 type:)
					message: (param2 message:)
					modifiers: (param2 modifiers:)
					y: (param2 y:)
					x: (param2 x:)
					claimed: (param2 claimed:)
				)
			else
				(GetEvent evALL_EVENTS temp0)
			)
		)
		(return temp0)
	)

	(method (changeState)
		(if client
			(client indexOf: self)
		)
		(self new:)
	)
)

(class GoToDlyEvt of DelayedEvent
	(properties
		bottomToY 0
		rightFromX 0
	)

	(method (perform)
		(= bottomToY (VerbMessager ssOpen:))
		(= rightFromX (VerbMessager ssLook:))
		(VerbMessager alterEgo: 0 controls: 0)
		(super perform: &rest)
	)

	(method (changeState)
		(VerbMessager alterEgo: bottomToY controls: rightFromX)
		(Parse (VerbMessager ssEat:) self)
		(super changeState: &rest)
	)
)

