;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use User)
(use Actor)

(class InterProp of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToEnd: self)
		(gKeyDownHandler addToEnd: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(== (User canInput:) 1)
				(self onMe: event)
				(or
					(== ((gUser curEvent:) message:) KEY_RETURN)
					(== ((gUser curEvent:) type:) evMOUSEBUTTON)
				)
			)
			(self doVerb:)
		else
			(super handleEvent: event)
		)
	)
)

