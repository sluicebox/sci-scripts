;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 187)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	fallChasm 0
)

(instance fallChasm of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 187)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= cycles 5)
			)
			(1
				(gEgo setLoop: 2)
				(= cycles 5)
			)
			(2
				(gEgo
					view: 537
					setLoop: 0
					cel: 0
					setPri: 7
					illegalBits: 0
					yStep: 8
					cycleSpeed: 5
					posn: (gEgo x:) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(4
				(if ((ScriptID 94 0) notify: 0) ; rm94
					((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
					((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
					((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
					((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
				)
				(= cycles 20)
			)
			(5
				(EgoDead ; "You see a sign that reads, "Beware of Porcupine". That's odd, you don't see a ... You do, however, see many archers leaning over the chasm edge with arrows pointed toward you. You now have a funny feeling you know who the porcupine is going to be in a few minutes."
					187
					0
					82
					536
					0
					2
					80
					{The thought sends quills up your spine.}
				)
				(self dispose:)
			)
		)
	)
)

