;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use ExitButton)
(use Sound)
(use Motion)
(use System)

(public
	takeABiteOutOfMoon 0
)

(instance takeABiteOutOfMoon of Script
	(properties)

	(method (dispose)
		(moonChomp dispose:)
		(super dispose: &rest)
		(DisposeScript 112)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gEgo view:) 800)
					(Load 140 5408) ; WAVE
					(= register (gEgo heading:))
					(gEgo setMotion: 0 setHeading: 180 self)
				else
					(self dispose:)
				)
			)
			(1
				(gEgo
					view: 5335
					loop: 0
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(2
				(SetFlag 249)
				(gEgo setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(moonChomp play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gEgo normalize: 2)
				(= cycles 2)
			)
			(6
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 2 71 0 0 self 800) ; "I never did like green cheese much."
			)
			(7
				(= cycles 5)
			)
			(8
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setHeading: register self)
			)
			(9
				(= cycles 5)
			)
			(10
				((gInventory at: 48) view: 348 loop: 1 cLoop: 3 cCel: 3) ; Moon
				(gGame handsOn:)
				(gTheInvCursor loop: 3 cel: 2 init:)
				(self dispose:)
			)
		)
	)
)

(instance moonChomp of Sound
	(properties
		number 5408
	)
)

