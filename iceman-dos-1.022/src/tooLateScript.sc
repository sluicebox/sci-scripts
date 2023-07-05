;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 319)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Motion)
(use System)

(public
	tooLateScript 0
)

(instance tooLateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 84 142 142 160)
					(gEgo setMotion: MoveTo 80 140)
				)
				((ScriptID 310 3) ; agent
					init:
					ignoreActors: 0
					setCycle: Walk
					setMotion: MoveTo ((ScriptID 310 3) x:) 160 self ; agent
				)
				(Print 319 0) ; "Just then Stacy enters the room and says..."
			)
			(1
				(gEgo heading: 180 cycleSpeed: 1)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(2
				(Print 319 1) ; "It's too late, John, the Ambassador has been moved and we don't know where they have taken him."
				(= seconds 1)
			)
			(3
				(EgoDead 918 0 0 319 2) ; "Faster action might have saved the Ambassador. You have caused the mission to fail."
			)
		)
	)
)

