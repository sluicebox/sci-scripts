;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 332)
(include sci.sh)
(use Main)
(use n082)
(use rm330)
(use PolyPath)
(use Sound)
(use Motion)
(use System)

(public
	swellingPipeScr 0
	pistonExplosionScr 1
)

(instance swellingPipeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 330 3) init: cycleSpeed: 15 setCycle: End self) ; clog
			)
			(1
				(gGame handsOff:)
				(if (gCurRoom script:)
					(gCurRoom setScript: 0)
					(gEgo setMotion: 0)
				)
				(gEgo setHeading: 310 self)
			)
			(2
				(gMessager say: 2 4 6 1 self) ; "(Hmm. There seems to be a problem with that hose. Perhaps I should investigate more closely!)"
			)
			(3
				(self setScript: egoToPipeScr self)
				(= cycles 2)
			)
			(4
				(gMessager say: 2 4 6 2 self) ; "Look out, Larry! She's gonna blow!"
			)
			(5
				((ScriptID 330 3) loop: 1 cel: 0 setCycle: Fwd) ; clog
				(= register 15)
				(= cycles 2)
			)
			(6
				(if (-- register)
					((ScriptID 330 3) cycleSpeed: register) ; clog
					(= ticks 20)
					(-- state)
				else
					(= cycles 2)
				)
			)
			(7
				(script cue:)
			)
			(8
				((ScriptID 330 3) setPri: 1) ; clog
				(self setScript: tankExplosionScr self)
			)
			(9
				(= cycles 2)
			)
			(10
				(EgoDead 10 self)
			)
			(11
				(proc330_6)
				(gGame handsOn:)
				(gEgo
					view: 900
					setLoop: -1
					posn:
						((ScriptID 330 7) approachX:) ; lever
						((ScriptID 330 7) approachY:) ; lever
					loop: 8
					cel: 6
				)
				(self dispose:)
			)
		)
	)
)

(instance tankExplosionScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 330 3) loop: 0 cel: 4 setCycle: Beg) ; clog
				(explosionFx play:)
				((ScriptID 330 5) init: loop: 1 cel: 0 setCycle: CT 3 1 self) ; explosion2
			)
			(1
				(gEgo view: 903 setLoop: 3 1)
				((ScriptID 330 5) setCycle: End self) ; explosion2
			)
			(2
				((ScriptID 330 5) loop: 2 cel: 0 setCycle: End self) ; explosion2
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSounds delete: (explosionFx dispose: yourself:))
		(super dispose:)
	)
)

(instance pistonExplosionScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(gCurRoom setScript: 0)
				)
				(= ticks 10)
			)
			(1
				(gEgo setHeading: 310 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 2 4 1 0 self) ; "(Hmm. It looks like there's a problem with the piston. Perhaps I should check it out more closely...)"
				(= ticks 90)
			)
			(4
				(gEgo setHeading: 270)
			)
			(5
				(gEgo setMotion: PolyPath 100 130 self)
			)
			(6
				(gEgo setPri: 87 setHeading: 315 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(explosionFx play:)
				((ScriptID 330 4) loop: 1 cel: 0 setCycle: CT 3 1 self) ; explosion1
				((ScriptID 330 8) hide:) ; pistonShaft
			)
			(9
				(gEgo setPri: -1 view: 903 setLoop: 3)
				((ScriptID 330 4) setCycle: End self) ; explosion1
			)
			(10
				((ScriptID 330 4) loop: 2 cel: 0 setCycle: End self) ; explosion1
			)
			(11
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSounds delete: (explosionFx dispose: yourself:))
		(super dispose:)
	)
)

(instance explosionFx of Sound
	(properties
		flags 1
		number 800
	)
)

(instance egoToPipeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 151 127 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

