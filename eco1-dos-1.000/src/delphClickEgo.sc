;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use rm380)
(use n819)
(use Talker)
(use PolyPath)
(use ForwardCounter)
(use Motion)
(use System)

(public
	delphClickEgo 0
)

(local
	[local0 12] = [0 3 3 3 7 1 1 1 2 2 2 2]
	[local12 12] = [7 3 3 3 6 0 4 2 2 2 5 1]
)

(instance delphClickEgo of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== ((ScriptID 380 3) view:) 382) ; dolphin
				(== ((ScriptID 380 3) loop:) 7) ; dolphin
			)
			(gEgo setLoop: [local12 ((ScriptID 380 3) cel:)]) ; dolphin
		)
		(if
			(and
				(== ((ScriptID 380 3) view:) 394) ; dolphin
				(== ((ScriptID 380 3) loop:) 1) ; dolphin
			)
			(gEgo setLoop: [local0 ((ScriptID 380 3) cel:)]) ; dolphin
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global247 7)
				(gEgo setMotion: PolyPath 71 106 self)
			)
			(1
				((ScriptID 380 3) ; dolphin
					setMotion:
						MoveTo
						(- (gEgo x:) 17)
						(+ (gEgo y:) 14)
						self
				)
			)
			(2
				((ScriptID 380 3) setHeading: 90 self) ; dolphin
			)
			(3
				((ScriptID 380 3) setCycle: 0) ; dolphin
				(= cycles 1)
			)
			(4
				((ScriptID 380 3) ; dolphin
					view: 382
					loop: 8
					cel: 7
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(= global247 8)
				((ScriptID 380 3) ; dolphin
					view: 382
					loop: 7
					cel: 9
					posn: (- (gEgo x:) 10) (- (gEgo y:) 5)
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(7
				(gSoundEffects number: 370 loop: -1 flags: 1 play:)
				((ScriptID 380 3) setCycle: ForwardCounter 3 self) ; dolphin
			)
			(8
				(Narrator posn: 160 20 init: 42 self) ; "The weird clicking sound means the dolphin is 'memorizing' Adam by bouncing sound waves off him. It's called a 'sonar click.'"
			)
			(9
				((ScriptID 380 3) setCycle: ForwardCounter 3 self) ; dolphin
			)
			(10
				(gSoundEffects stop: flags: 0)
				(gEgo setHeading: 180)
				((ScriptID 380 3) hide:) ; dolphin
				(= global247 9)
				((ScriptID 2 1) init: 46 1 self) ; Adam, "That was fun! Do it again!"
			)
			(11
				((ScriptID 380 3) ; dolphin
					show:
					posn: (- ((ScriptID 380 3) x:) 25) ((ScriptID 380 3) y:) ; dolphin, dolphin
				)
				((ScriptID 380 3) ; dolphin
					view: 382
					loop: 8
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(12
				(proc380_5)
				((ScriptID 380 3) setMotion: MoveTo 51 139 self) ; dolphin
			)
			(13
				((ScriptID 2 1) init: 55 1 self) ; Adam, "Hey, where are you going?"
			)
			(14
				((ScriptID 380 3) setMotion: MoveTo 51 149 self) ; dolphin
			)
			(15
				(gEgo setLoop: -1)
				(Face gEgo (ScriptID 380 3)) ; dolphin
				((ScriptID 380 3) setHeading: 0 self) ; dolphin
			)
			(16
				((ScriptID 380 3) setCycle: 0) ; dolphin
				(= cycles 1)
			)
			(17
				((ScriptID 380 3) ; dolphin
					view: 395
					loop: 1
					cel: 0
					posn: 51 159
					cycleSpeed: 3
					setCycle: CT 4 1 self
				)
			)
			(18
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) setCycle: End self) ; dolphin
			)
			(19
				(= seconds 4)
			)
			(20
				(gEgo setHeading: 270)
				(gLongSong number: 382 loop: 1 play:)
				((ScriptID 380 3) ; dolphin
					view: 394
					loop: 2
					cel: 0
					posn: 17 94
					cycleSpeed: 8
					setCycle: CT 6 1 self
				)
			)
			(21
				(= cycles 13)
			)
			(22
				(gLongSong number: 385 loop: 1 play:)
				((ScriptID 380 3) setCycle: CT 10 1 self) ; dolphin
			)
			(23
				(gLongSong number: 383 loop: -1 play:)
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) cel: 11 setCycle: End self) ; dolphin
			)
			(24
				((ScriptID 2 1) init: 56 1 self) ; Adam, "Whoa, good one!"
			)
			(25
				(= register 3)
				((ScriptID 380 3) ; dolphin
					view: 394
					loop: 1
					cel: 8
					posn: 78 106
					setCycle: CT 10 1 self
				)
			)
			(26
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) setCycle: End self) ; dolphin
			)
			(27
				((ScriptID 380 3) setPri: 6 setCycle: CT 2 1 self) ; dolphin
			)
			(28
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) setCycle: CT 6 1 self) ; dolphin
			)
			(29
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) setPri: 1 setCycle: CT 7 1 self) ; dolphin
			)
			(30
				((ScriptID 380 3) setPri: 6 setCycle: CT 10 1 self) ; dolphin
			)
			(31
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID 380 3) setCycle: End self) ; dolphin
			)
			(32
				(if (-- register)
					(-= state 6)
				)
				(if (== register 1)
					((ScriptID 2 1) init: 57 1 self) ; Adam, "You're making me dizzy!"
				else
					(= ticks 3)
				)
			)
			(33
				((ScriptID 380 3) hide:) ; dolphin
				(= seconds 4)
			)
			(34
				(gEgo setLoop: -1 setMotion: MoveTo 104 105 self)
				((ScriptID 380 3) ; dolphin
					show:
					view: 382
					loop: 8
					cel: 0
					posn: 103 139
					setCycle: End
				)
			)
			(35
				((ScriptID 2 1) init: 119 1 self) ; Adam, "Catch me if you can! Ha!"
			)
			(36
				(gEgo setMotion: MoveTo 114 105 self)
			)
			(37
				(Face gEgo (ScriptID 380 3) self) ; dolphin
			)
			(38
				((ScriptID 380 3) setCycle: Beg self) ; dolphin
			)
			(39
				((ScriptID 380 3) ; dolphin
					view: 386
					loop: 0
					cel: 0
					posn: 150 107
					setCycle: CT 4 1 self
				)
				(gEgo hide:)
			)
			(40
				(Narrator posn: 160 20 init: 77 self) ; "The dolphin offers his dorsal fin to Adam. He wants to give Adam a ride!"
			)
			(41
				(= global247 10)
				(gUser canControl: 1 canInput: 1)
				(gTheIconBar enable: 1)
				(gTheIconBar enable: 2)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(42
				(SetScore 5 240)
				(HandsOff)
				((ScriptID 2 1) init: 120 1 self) ; Adam, "Wow, I accept!"
			)
			(43
				(Narrator posn: 160 20 init: 107 self) ; "Adam cups his hand and the dolphin swims up under it and pulls Adam into a whirling, swooping ride around the pool."
			)
			(44
				(self setScript: giveEgoRide self)
			)
			(45
				(proc380_5)
				(= global247 11)
				((ScriptID 380 3) setMotion: MoveTo 40 167 self) ; dolphin
			)
			(46
				((ScriptID 380 3) setHeading: 90 self) ; dolphin
			)
			(47
				(self dispose:)
			)
		)
	)
)

(instance giveEgoRide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				((ScriptID 380 3) setCycle: End self) ; dolphin
			)
			(1
				((ScriptID 380 3) ; dolphin
					loop: 3
					cel: 7
					posn: 60 116
					setCycle: End self
				)
			)
			(2
				((ScriptID 380 3) cel: 0 setCycle: ForwardCounter 3 self) ; dolphin
			)
			(3
				(proc380_8)
				(proc380_5)
				((ScriptID 380 3) show: posn: 42 150 heading: 315 loop: 7) ; dolphin
				(gEgo show: posn: 42 148 setMotion: PolyPath 74 108 self)
			)
			(4
				((ScriptID 380 3) view: 382 loop: 6) ; dolphin
				(Face gEgo (ScriptID 380 3) self) ; dolphin
			)
			(5
				((ScriptID 2 1) init: 48 1 self) ; Adam, "Hey, thanks, that was the greatest!"
			)
			(6
				(Narrator posn: 160 20 init: 80 self) ; "The dolphin looks really frisky now that he's pulled Adam around. He wants to play some more!"
			)
			(7
				(self dispose:)
			)
		)
	)
)

