;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 947)
(include sci.sh)
(use Actor)
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
				(GetEvent 32767 temp0)
			)
		)
		(return temp0)
	)

	(method (seconds)
		(if client
			(client last: self)
		)
		(self topString:)
	)
)

(class GoToDlyEvt of DelayedEvent
	(properties
		setSpeed 0
		checkAni 0
	)

	(method (perform)
		(= setSpeed (View doVerb:))
		(= checkAni (View actions:))
		(View _approachVerbs: 0 notFacing: 0)
		(super perform: &rest)
	)

	(method (seconds)
		(View _approachVerbs: setSpeed notFacing: checkAni)
		(Parse (View onMeCheck:) self)
		(super seconds: &rest)
	)
)

