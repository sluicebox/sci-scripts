;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use n913)
(use Scaler)
(use Motion)
(use System)

(public
	giveRingScr 0
)

(instance giveRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 3)
				(= cycles 1)
			)
			(1
				(gMessager say: 5 70 register 1 self)
			)
			(2
				(gEgo
					setSpeed: 6
					normal: 0
					view: 221
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 5 70 register 2 self)
			)
			(5
				((ScriptID 220 3) setCycle: Beg self) ; guard1
			)
			(6
				((ScriptID 220 3) ; guard1
					view: 725
					setCycle: Walk
					setMotion: MoveTo 99 119 self
				)
			)
			(7
				((ScriptID 220 3) setHeading: 90 self) ; guard1
			)
			(8
				(= cycles 2)
			)
			(9
				(gMessager say: 5 70 register 3 self)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(gMessager say: 5 70 register 4 self)
			)
			(12
				(if (== register 14)
					(gMessager say: 5 70 register 5 self) ; "Kingdom of Daventry...Prince Alexander.... <Growlf>. Wait here while I go see what Captain Saladin thinks of this."
				else
					(self cue:)
				)
			)
			(13
				(gEgo reset: 7)
				((ScriptID 220 4) setCycle: Beg) ; guard2
				((ScriptID 220 3) setHeading: 0 self) ; guard1
			)
			(14
				(gEgo loop: 3)
				(self setScript: (ScriptID 220 1) self 0) ; guardOpenDoorScr
			)
			(15
				(= seconds 4)
			)
			(16
				(script cue:)
			)
			(17
				((ScriptID 220 6) init: setMotion: MoveTo 105 94 self) ; saladin
			)
			(18
				((ScriptID 220 6) ; saladin
					setPri: -1
					setScale: Scaler 100 94 189 95
					setMotion: MoveTo 117 111 self
				)
			)
			(19
				(if (not (== ((ScriptID 220 6) loop:) 2)) ; saladin
					((ScriptID 220 6) setHeading: 0 self) ; saladin
				else
					(self cue:)
				)
			)
			(20
				(= cycles 2)
			)
			(21
				(gMessager say: 5 70 14 6 self) ; "The guard returns a moment later with a majestic-looking creature. Captain Saladin speaks with a voice that is gentle but reflects a will of iron."
			)
			(22
				(gMessager say: 5 70 14 7 self) ; "Prince Alexander of Daventry, I presume. I'm afraid I'm unfamiliar with your country, but I'm sure Vizier Alhazred will want to meet you--if indeed, you are a friend of the princess."
			)
			(23
				(gMessager say: 5 70 14 8 self) ; "Please, follow me."
			)
			(24
				((ScriptID 220 6) setMotion: MoveTo 109 93 self) ; saladin
			)
			(25
				((ScriptID 220 6) cue:) ; saladin
				(gEgo
					setSpeed: 10
					ignoreActors:
					setMotion: MoveTo 107 93 self
				)
			)
			(26
				(gEgo
					setPri: 2
					setScale: Scaler 64 94 103 95
					moveSpeed: 8
					setMotion: MoveTo 75 100 self
				)
			)
			(27
				(self setScript: (ScriptID 220 2) self) ; guardCloseDoorScr
			)
			(28
				(gGame handsOn:)
				(SetFlag 72)
				(gCurRoom newRoom: 150)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 222)
	)
)

