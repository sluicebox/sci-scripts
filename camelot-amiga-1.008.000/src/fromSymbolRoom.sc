;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 176)
(include sci.sh)
(use Main)
(use Rm64)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	fromSymbolRoom 0
	knockOnSideDoor 1
	getWater 2
	fallDownTrap 3
)

(local
	local0
	local1
	local2
)

(instance fromSymbolRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 310 85 loop: 1 setMotion: MoveTo 290 87 self)
				(global186 setCel: 255)
			)
			(1
				(global186 cue: 0)
				(= cycles 10)
			)
			(2
				(gTObj talkCue: self)
				(if (not (IsFlag 157))
					(proc64_1 176 0) ; "Do not despair so easily, seeker. I entreat you to return and take the Test again or you will regret leaving here in failure."
					(SetFlag 163)
				else
					(proc64_1 176 1) ; "Truly you are the most worthy of all men who have passed my door. Go with my blessings and find the hierophant."
					(ClearFlag 163)
				)
			)
			(3
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 176)
			)
		)
	)
)

(instance knockOnSideDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 285 86 self)
			)
			(1
				(= register (gEgo cycler:))
				(gEgo
					view: 62
					loop: 1
					illegalBits: $8004
					cycler: 0
					setCycle: Fwd
				)
				(gSFX number: (proc0_20 83) loop: 1 play:)
				(= seconds 3)
			)
			(2
				(gEgo view: 0 loop: 0 cycler: register)
				(gTObj talkCue: self)
				(proc64_1 176 2) ; "There is no-one within. Only I can open that door."
			)
			(3
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 176)
			)
		)
	)
)

(instance getWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (gEgo cycler:))
				(gEgo cycler: 0)
				(= local1 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 0 moveSpeed: 0 setAvoider: (Avoid new:))
				(if (gEgo inRect: 6 79 280 108)
					(gEgo loop: 2 setMotion: MoveTo 164 99 self)
				else
					(gEgo loop: 3 setMotion: MoveTo 200 137 self)
				)
			)
			(1
				(= local0 (gEgo illegalBits:))
				(gEgo setAvoider: 0 illegalBits: 0)
				(DisposeScript 985)
				(if (> (gEgo y:) 130)
					(= register 1)
					(gEgo setPri: 10)
				else
					(= register 5)
					(gEgo setPri: 8)
				)
				(gEgo
					view: 89
					setLoop: (if (== register 5) 1 else 5)
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(if (== register 1)
					(gEgo posn: 197 121)
				else
					(gEgo posn: 164 99)
				)
				(gEgo
					setLoop: (+ (gEgo loop:) 1)
					cel: -1
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: (+ (gEgo loop:) 1)
					cel: -1
					setCycle: End self
				)
			)
			(4
				(gEgo
					setLoop: (- (gEgo loop:) 1)
					setCel: 255
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					setLoop: (- (gEgo loop:) 1)
					setCel: 255
					setCycle: Beg self
				)
				(if (== register 1)
					(gEgo posn: 200 137)
				)
			)
			(6
				(gEgo
					view: 0
					setLoop: -1
					loop: (if (== register 1) 3 else 2)
					cycleSpeed: local1
					moveSpeed: local1
					setPri: -1
					illegalBits: local0
					setCycle: local2
				)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 176)
			)
		)
	)
)

(instance trapDoor of Prop
	(properties
		y 92
		x 77
		view 164
		loop 2
		signal 16400
	)
)

(instance fallDownTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 296 1 -10)
				(SetFlag 162)
				(gEgo
					view: 91
					ignoreActors:
					illegalBits: 0
					setStep: 6 6
					setCycle: End
					cycleSpeed: 1
					moveSpeed: 0
					setPri: 1
					setMotion: MoveTo 71 110 self
				)
				(gRmMusic stop:)
				(gSFX number: (proc0_20 77) loop: 1 play:)
				(trapDoor init: setCycle: End)
			)
			(1
				(gEgo setPri: 1 setStep: 6 8 setMotion: MoveTo 71 143 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 65)
			)
		)
	)
)

