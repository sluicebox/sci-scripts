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
				(= ticks 10)
			)
			(2
				(gMessager say: 2 4 6 1 self) ; "(Hmm. There seems to be a problem with that hose. Perhaps I should investigate more closely!)"
			)
			(3
				(self setScript: egoToPipeScr self)
				((ScriptID 330 3) loop: 1 cel: 0 setCycle: Fwd) ; clog
				(= register 15)
				(= cycles 2)
			)
			(4
				(if (-- register)
					((ScriptID 330 3) cycleSpeed: register) ; clog
					(= ticks 20)
					(-- state)
				else
					(= cycles 2)
				)
			)
			(5
				(script cue:)
			)
			(6
				(gMessager say: 2 4 6 2 self) ; "Look out, Larry! She's gonna blow!"
			)
			(7
				((ScriptID 330 3) setPri: 1) ; clog
				(self setScript: tankExplosionScr self)
			)
			(8
				(= cycles 2)
			)
			(9
				(EgoDead 10 self)
			)
			(10
				(proc330_6)
				(gGame handsOn:)
				(gEgo
					posn:
						((ScriptID 330 7) approachX:) ; lever
						((ScriptID 330 7) approachY:) ; lever
					cel: 6
				)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 332)
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
			(2 0)
			(3
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
				((ScriptID 330 5) init: loop: 1 cel: 0 setCycle: End self) ; explosion2
			)
			(1
				((ScriptID 330 5) loop: 2 cel: 0 setCycle: End self) ; explosion2
			)
			(2
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
				(gMessager say: 2 4 1 0 self) ; "(Hmm. It looks like there's a problem with the piston. Perhaps I should check it out more closely...)"
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setMotion: PolyPath 111 130 self)
			)
			(4
				(gEgo setHeading: 315 self)
			)
			(5
				(= ticks 20)
			)
			(6
				(explosionFx play:)
				((ScriptID 330 4) loop: 1 cel: 0 setCycle: End self) ; explosion1
				((ScriptID 330 8) hide:) ; pistonShaft
			)
			(7
				((ScriptID 330 4) loop: 2 cel: 0 setCycle: End self) ; explosion1
			)
			(8
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSounds delete: (explosionFx dispose: yourself:))
		(super dispose:)
		(DisposeScript 332)
	)
)

(instance explosionFx of Sound
	(properties
		flags 1
		number 800
	)
)

