;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use StopWalk)
(use Sound)
(use Motion)
(use System)

(public
	giftScript 0
)

(instance giftScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (if (< (gEgo heading:) 180) 0 else 1))
				(gEgo
					setMotion: 0
					view: 33
					setCel: 0
					setLoop: register
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo setCel: 0 setCycle: End self)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo
					setLoop: (+ (gEgo loop:) 2)
					setCel: 0
					setCycle: End self
				)
				(giftSfx number: 930 play:)
			)
			(4
				(gMessager say: 26 6 28 0 0 0) ; ""That old Keapon, what a joker!", you say to yourself."
				(gEgo
					view: 0
					cycleSpeed: gSpeed
					setLoop: -1
					setLoop: (ScriptID 28 1) ; stopGroop
					setCycle: StopWalk 5
				)
				(= ticks 60)
			)
			(5
				(HandsOn)
				(proc0_16)
				(self dispose:)
			)
		)
	)
)

(instance giftSfx of Sound
	(properties)
)

