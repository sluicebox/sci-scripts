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
				(GetEvent evALL_EVENTS temp0)
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
		newRoom 0
		startRoom 0
	)

	(method (perform)
		(= newRoom (PicView setTest:))
		(= startRoom (PicView waitApogeeY:))
		(PicView onMeCheck: 0 approachY: 0)
		(super perform: &rest)
	)

	(method (seconds)
		(PicView onMeCheck: newRoom approachY: startRoom)
		(Parse (PicView doVerb:) self)
		(super seconds: &rest)
	)
)

