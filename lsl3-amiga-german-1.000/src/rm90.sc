;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm90 0
)

(instance rm90 of Rm
	(properties
		picture 90
	)

	(method (init)
		(cls)
		(super init:)
		(gTheMenuBar hide:)
		(SL disable:)
		(gEgo hide:)
		(HandsOff)
		(gUser canInput: 1)
		(gTheMenuBar state: 1)
		(Animate 0)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSERELEASE) (event claimed:))
			(return)
		)
		(Print 90 0) ; "Sorry, but from here, all you can do is Restart or Restore a saved game."
		(Print 90 1 #at -1 144) ; "(Hope you didn't get caught!)"
		(event claimed: 1)
	)
)

