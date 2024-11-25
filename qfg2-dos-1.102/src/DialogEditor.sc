;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 947)
(include sci.sh)
(use User)
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
		bottomToX 0
		bottomToY 0
	)

	(method (perform)
		(= bottomToX (User input:))
		(= bottomToY (User alterEgo:))
		(User verbMessager: 0 getInput: 0)
		(super perform: &rest)
	)

	(method (changeState)
		(User verbMessager: bottomToX getInput: bottomToY)
		(Parse (User prompt:) self)
		(super changeState: &rest)
	)
)

