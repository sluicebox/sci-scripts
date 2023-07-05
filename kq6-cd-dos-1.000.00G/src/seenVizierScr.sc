;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use n913)
(use Scaler)
(use DPath)
(use Motion)
(use System)

(public
	seenVizierScr 0
)

(instance egoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: 6
					ignoreActors:
					posn: 75 100
					setPri: 2
					show:
					setMotion: MoveTo 107 94 self
				)
			)
			(1
				(gEgo
					setPri: -1
					setScale: Scaler 100 94 189 95
					setMotion: DPath 118 107 120 111 123 121 self
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 0 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance seenVizierScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(SetFlag 72)
				((ScriptID 220 5) setCycle: End self) ; castleDoor
			)
			(1
				(self setScript: egoScr)
				(= ticks 30)
			)
			(2
				((ScriptID 220 6) init: setMotion: MoveTo 105 94 self) ; saladin
			)
			(3
				((ScriptID 220 6) ; saladin
					setPri: -1
					setScale: Scaler 100 94 189 95
					setMotion: DPath 115 107 117 111 118 115 self
				)
			)
			(4
				((ScriptID 220 6) setHeading: 180 self) ; saladin
			)
			(5
				(if script
					(-- state)
				)
				(= cycles 2)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 1 0 5 1 self) ; "(FIRMLY, BUT NOT UNKINDLY) You have had your hearing with Vizier Alhazred. I trust you'll respect his wishes and not return."
			)
			(8
				(gMessager say: 1 0 5 2 self) ; "I have been instructed NOT to let you into the castle again. Good day, m'lord."
			)
			(9
				((ScriptID 220 6) setMotion: MoveTo 117 111 self) ; saladin
			)
			(10
				(= cycles 2)
			)
			(11
				(gMessager say: 1 0 5 3 self) ; "Captain Saladin whispers something to the guard dogs at the castle gate, and they nod with understanding."
			)
			(12
				((ScriptID 220 6) setMotion: DPath 115 107 105 94 self) ; saladin
			)
			(13
				((ScriptID 220 6) cue: self) ; saladin
			)
			(14
				((ScriptID 220 6) dispose:) ; saladin
				(self setScript: (ScriptID 220 2) self) ; guardCloseDoorScr
			)
			(15
				(gMessager say: 1 0 5 4 self) ; "Alexander has a feeling they won't be letting HIM into the castle again."
			)
			(16
				(gEgo reset: 3)
				(gGame handsOn:)
				((ScriptID 220 5) stopUpd:) ; castleDoor
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 221)
	)
)

