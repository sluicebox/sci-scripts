;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 338)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	finalliScript 0
)

(instance finalliScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 25 7) setCel: 16) ; scopeProp2
				((ScriptID 25 1) ; captain
					init:
					posn: 214 100
					heading: 270
					loop: 1
					illegalBits: 0
				)
				(self setScript: (ScriptID 394) self) ; getUpScript
			)
			(1
				(gEgo posn: 182 95)
				(Print 338 0) ; "Westland!" The Captain says, "Come over here and take a look at this."
				(Print 338 1) ; "Continuing he says, "It looks like we have more on our hands then we anticipated.""
				(Print 338 2) ; "There's a gunboat out there keeping a close watch on the entrance to the harbor!"
				(Print 338 3) ; "Go ahead and take a look."
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 338)
	)
)

