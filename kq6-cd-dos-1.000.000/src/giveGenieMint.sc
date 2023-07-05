;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 753)
(include sci.sh)
(use Main)
(use rm750)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	giveGenieMint 0
)

(local
	[local0 18] = [14 77 37 13 71 16 9 259 44 10 33 79 9 138 104 -1 -1 -1]
	local18
)

(instance giveGenieMint of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 752)
		(UnLoad 128 7501)
		(UnLoad 128 7503)
		(UnLoad 128 702)
		(DisposeScript 1012)
		(DisposeScript 753)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 67 0 1 self) ; "Look what I have here, my friend. Peppermint! Nice fresh peppermint!"
			)
			(1
				(gGame givePoints: 1)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					view: 7500
					setLoop: 2
					normal: 0
					setScale: 0
					cel: 0
					cycleSpeed: 8
					looper: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				((ScriptID 750 4) ; genie
					view: 702
					loop: 6
					cel: 0
					cycleSpeed: 7
					setCycle: CT 4 1 self
				)
			)
			(3
				((ScriptID 750 4) setCycle: Beg self) ; genie
			)
			(4
				(gMessager say: 5 67 0 2 self) ; "Razzle...er...Dazzle...hmmm!"
			)
			(5
				((ScriptID 750 2) cel: 1 forceUpd:) ; vizHead
				(= cycles 4)
			)
			(6
				(gMessager say: 5 67 0 3 self) ; "(ANXIOUS, ANGRY/AFRAID) Forget the stupid peppermint! Don't you DARE even think about it!"
			)
			(7
				(self setScript: (ScriptID 752 2) self (ScriptID 750 4)) ; geniePoofOut, genie
			)
			(8
				(gEgo setCel: 255)
				((ScriptID 750 2) cel: 2 forceUpd:) ; vizHead
				((ScriptID 750 4) ; genie
					view: 752
					loop: 1
					cel: 0
					cycleSpeed: 8
					posn: 170 137
				)
				(= ticks 60)
			)
			(9
				(self setScript: (ScriptID 752 1) self (ScriptID 750 4)) ; geniePoofIn, genie
			)
			(10
				((ScriptID 750 4) setCycle: CT 1 1 self) ; genie
			)
			(11
				(= cycles 2)
			)
			(12
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					normal: 0
					view: 7500
					setLoop: 3
					setCycle: 0
					looper: 0
					setScale: Scaler 102 76 189 139
				)
				((ScriptID 750 4) setCycle: End self) ; genie
			)
			(13
				(gMessager say: 5 67 0 4 self) ; "HMMM! MINT!"
			)
			(14
				(gMessager say: 5 67 0 5 self) ; "(HALF-CRYING, HOPELESS) Oh, no! Not now!"
			)
			(15
				(gMessager say: 5 67 0 6 self) ; "Tee, hee <hic>. Tee, hee, hee."
			)
			(16
				((ScriptID 750 4) ; genie
					loop: 2
					cel: 8
					cycleSpeed: 4
					setCycle: CT 2 1 self
				)
			)
			(17
				(= cycles 10)
			)
			(18
				((ScriptID 750 4) cel: 3) ; genie
				(= cycles 8)
			)
			(19
				((ScriptID 750 4) setCycle: CT 5 1 self) ; genie
			)
			(20
				(= cycles 10)
			)
			(21
				(gMessager say: 5 67 0 7 self) ; "DO something, SHAMIR SHAMAZEL! KILL HIM!!!!!!"
			)
			(22
				(gMessager say: 5 67 0 8 self) ; "SEND A SMALL...I MEAN A BALL OF <hic> LIGHT TO FRAZZLE!"
			)
			(23
				((ScriptID 750 4) cycleSpeed: 6 setCycle: End self) ; genie
			)
			(24
				(gGlobalSound2 number: 707 setLoop: 1 play:)
				((ScriptID 750 4) ; genie
					view: 702
					loop: 7
					cel: 1
					x: (- ((ScriptID 750 4) x:) 13) ; genie
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(25
				(gGlobalSound2 number: 708 setLoop: 1 play:)
				(dazzleBall init: setCycle: Fwd)
				(= cycles 2)
			)
			(26
				(gMessager say: 5 67 0 9 self) ; "The dazzle ball goes wild!"
			)
			(27
				(if (!= [local0 local18] -1)
					(-- state)
					(dazzleBall
						loop: [local0 local18]
						setMotion:
							MoveTo
							[local0 (+ local18 1)]
							[local0 (+ local18 2)]
							self
					)
					(if (>= local18 3)
						(gGlobalSound2 number: 709 loop: 1 play:)
					)
					(+= local18 3)
				else
					(= cycles 1)
				)
			)
			(28
				(gMessager say: 5 67 0 11 self) ; "Uh, <hic> oh."
			)
			(29
				(dazzleBall setMotion: MoveTo 160 111 self)
			)
			(30
				(dazzleBall loop: 15 cel: 0 cycleSpeed: 7 setCycle: End self)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 753 setLoop: 1 play: self)
			)
			(31
				((ScriptID 750 4) dispose:) ; genie
				(dazzleBall dispose:)
			)
			(32
				(gMessager say: 5 67 0 12 self) ; "You killed my genie! You idiot! Don't you know how valuable he was! You fool!"
			)
			(33
				((ScriptID 750 2) dispose:) ; vizHead
				(if global169
					(gCurRoom drawPic: 750 15)
				else
					(gCurRoom drawPic: 750 100)
				)
				((ScriptID 750 9) addToPic:) ; sword
				((ScriptID 750 3) ; vizier
					view: 751
					loop: 8
					cel: 0
					signal: 16384
					init:
					setCycle: CT 4 1 self
				)
			)
			(34
				(gGlobalSound2 number: 652 setLoop: 1 play:)
				((ScriptID 750 3) setCycle: End self) ; vizier
			)
			(35
				(gMessager say: 5 67 0 13 self) ; "I'll kill you myself for that outrage!"
			)
			(36
				(gMessager say: 5 67 0 14 self) ; "(QUIETLY ANGRY--FED UP) So shall it be, Alhazred! I'm ready!"
			)
			(37
				(proc750_5)
				(if (or (not gHowFast) (not (HaveMouse)))
					(= seconds 15)
				else
					(= seconds 8)
				)
			)
			(38
				(gCurRoom setScript: (ScriptID 754 1)) ; stabEgo
			)
		)
	)
)

(instance dazzleBall of Actor
	(properties
		x 150
		y 100
		yStep 7
		view 702
		loop 14
		priority 15
		signal 26640
		cycleSpeed 3
		illegalBits 0
		xStep 7
		moveSpeed 0
	)
)

