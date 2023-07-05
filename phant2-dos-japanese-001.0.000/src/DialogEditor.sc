;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64947)
(include sci.sh)
(use Main)
(use WriteFeature)

(class EventHandler of Obj
	(properties)

	(method (handleEvent event)
		(return (& state (event type:)))
	)
)

(class MessageHandler of EventHandler
	(properties
		state 2
		noun 0
		case 0
		modNum -1
	)

	(method (init)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
	)

	(method (doVerb theVerb)
		(return
			(if gMessager
				1
			else
				(PrintDebug
					{No messager for %d %d %d %d %d}
					modNum
					noun
					theVerb
					case
					0
				)
			)
		)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(self doVerb: (event message:))
		)
		(event claimed: self)
	)
)

