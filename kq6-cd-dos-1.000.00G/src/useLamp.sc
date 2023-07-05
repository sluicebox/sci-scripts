;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 754)
(include sci.sh)
(use Main)
(use rm750)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	useLamp 0
	stabEgo 1
)

(instance useLamp of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 752)
		(UnLoad 128 7501)
		(UnLoad 128 7503)
		(UnLoad 128 7504)
		(UnLoad 128 702)
		(DisposeScript 1012)
		(DisposeScript 991)
		(DisposeScript 754)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 5)
				(gEgo
					view: 7503
					normal: 0
					setScale: 0
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				((ScriptID 750 1) ; roomConv
					add: -1 5 92 0 1 ; "Shamir Shamazel! Hold your spells! I am your master now. I order you to go back into your lamp."
					add: -1 5 92 0 2 ; "(ASTONISHED) WHAT? How did you get my lamp! You thief! You...you...you.... You've ruined me!"
					add: -1 5 92 0 3 ; "My lamp! Oh, thank Balhalla! I hated working for that loathsome creature! I already feel his nastiness leaving me! How I've longed for a master like you!"
					init: self
				)
			)
			(2
				(self setScript: (ScriptID 752 2) self (ScriptID 750 4)) ; geniePoofOut, genie
			)
			(3
				((ScriptID 750 4) posn: 165 137) ; genie
				(= ticks 60)
			)
			(4
				(self setScript: (ScriptID 752 1) self (ScriptID 750 4)) ; geniePoofIn, genie
			)
			(5
				((ScriptID 750 4) ; genie
					view: 7503
					loop: 1
					cel: 0
					ignoreActors: 1
					x: (+ ((ScriptID 750 4) x:) 32) ; genie
					y: (- ((ScriptID 750 4) y:) 8) ; genie
					setCycle: End self
				)
			)
			(6
				((ScriptID 1012 32) ; tlkGeniePage
					x: 50
					y: 59
					talkWidth: (- ((ScriptID 750 4) x:) 50) ; genie
				)
				((ScriptID 750 4) dispose:) ; genie
				(= cycles 3)
			)
			(7
				(gMessager say: 5 92 0 4 self) ; "I've got a new master! I've got a new master!"
			)
			(8
				(gEgo setCycle: CT 1 -1)
				((ScriptID 750 2) dispose:) ; vizHead
				(if global169
					(gCurRoom drawPic: 750 15)
				else
					(gCurRoom drawPic: 750 100)
				)
				((ScriptID 750 9) addToPic:) ; sword
				((ScriptID 750 3) ; vizier
					view: 7504
					loop: 0
					cel: 0
					signal: 16384
					init:
					setCycle: Walk
					setMotion: MoveTo 167 139 self
				)
			)
			(9
				((ScriptID 750 3) ; vizier
					view: 7504
					setLoop: 0
					cel: 0
					setCycle: Walk
					setSpeed: 4
					setMotion: MoveTo 168 141 self
				)
			)
			(10
				((ScriptID 750 3) ; vizier
					view: 7504
					setLoop: 1
					cel: 0
					x: 164
					y: 140
					setCycle: CT 8 1 self
				)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
			)
			(11
				(gEgo view: 703 setLoop: 0 cel: 0 setCycle: End)
				((ScriptID 750 3) setCycle: End) ; vizier
				(jar init: setCycle: Walk)
				(self setScript: jarGoesFlying self)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					normal: 0
					view: 7500
					setLoop: 3
					setCycle: 0
					looper: 0
					scaleSignal: 1
					scaleX: 96
					scaleY: 96
				)
				(= cycles 2)
			)
			(14
				(gMessager say: 5 92 0 5 self oneOnly: 0) ; "(CHALLENGINGLY) So you are a thief as well, Alexander? Stealing the lamp was very clever, I'll grant you that, but I am the master thief! Face my sword, if you dare! The man left standing shall have the lamp!"
			)
			(15
				((ScriptID 755 0) register: 1) ; startFight
				(= cycles 4)
			)
			(16
				(gEgo put: 25 740) ; newLamp
				(proc750_5)
				(gTheIconBar disable: 5)
				(if (or (not gHowFast) (not (HaveMouse)))
					(= seconds 15)
				else
					(= seconds 8)
				)
			)
			(17
				(self setScript: stabEgo)
			)
		)
	)
)

(instance stabEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc750_5 1)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(if (== ((gInventory at: 25) owner:) 740) ; newLamp
					(= cycles 2)
				else
					((ScriptID 750 3) ; vizier
						view: 7504
						setLoop: 5
						setCycle: Walk
						setScale: 0
						posn: 120 138
						setStep: 6 6
						setMotion: MoveTo 180 144 self
					)
				)
			)
			(2
				(gEgo hide:)
				((ScriptID 750 3) ; vizier
					view: 755
					setLoop: 0
					cel: 0
					posn: 187 140
					scaleSignal: 1
					scaleX: 132
					scaleY: 132
					setCycle: CT 3 1 self
				)
			)
			(3
				((ScriptID 750 3) setCycle: End self) ; vizier
				(gGlobalSound2 number: 756 setLoop: 1 play:)
			)
			(4
				((ScriptID 750 3) setLoop: 1 cel: 0 setCycle: End self) ; vizier
				(gGlobalSound2 number: 756 setLoop: 1 play:)
			)
			(5
				(= ticks 30)
			)
			(6
				((ScriptID 750 3) setLoop: 2 cel: 0 setCycle: CT 3 1 self) ; vizier
			)
			(7
				(gGlobalSound2 number: 971 setLoop: 1 play:)
				(gGlobalSound number: 705 setLoop: 1 play:)
				(= cycles 2)
			)
			(8
				(gMessager say: 6 23 16 3 self) ; "ALEXANDER! NO!"
			)
			(9
				((ScriptID 750 3) setCycle: End self) ; vizier
				(gGlobalSound2 number: 652 setLoop: 1 play:)
			)
			(10
				(EgoDead 41) ; "Touche! Alexander should have been on guard."
			)
		)
	)
)

(instance jarGoesFlying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jar setMotion: JumpTo 255 134 self)
			)
			(1
				(jar priority: 2 setMotion: JumpTo 271 148 self)
			)
			(2
				(jar setMotion: JumpTo 287 168 self)
			)
			(3
				(jar dispose:)
				(self dispose:)
			)
		)
	)
)

(instance jar of Actor
	(properties
		x 194
		y 106
		view 7504
		loop 2
		cel 1
		priority 9
		signal 16400
	)
)

