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
	talk1 1
	talk3 2
)

(local
	[local0 12] = [0 3 3 3 7 1 1 1 2 2 2 2]
	[local12 12] = [7 3 3 3 6 0 4 2 2 2 5 1]
)

(instance talk1 of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gPrevRoomNum 400)
					((ScriptID 2 1) init: 2 0 0 44 1 self) ; Adam, "You've had a tough time, but we're not going to keep you or anything. We're just trying to help you get better."
				else
					((ScriptID 2 1) init: 3 0 0 18 1 self) ; Adam, "I wish I could make you understand how much we want to help you."
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(if (== gPrevRoomNum 400)
					(Narrator posn: 160 20 init: 5 0 0 33 self) ; "Adam's soothing voice got through to him. It looks like he's decided to make friends."
				else
					(Narrator posn: 160 20 init: 6 0 0 20 self) ; "The dolphin suddenly focuses on Adam. Adam's voice must have gotten through to him!"
				)
			)
			(3
				(gLongSong number: 381 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talk3 of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 59)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 44 1 self) ; Adam, "You've had a tough time, but we're not going to keep you or anything. We're just trying to help you get better."
			)
			(1
				(= seconds 3)
			)
			(2
				(Narrator posn: 160 20 init: 5 0 0 33 self) ; "Adam's soothing voice got through to him. It looks like he's decided to make friends."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
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
				(== ((ScriptID gCurRoomNum 3) view:) 382)
				(== ((ScriptID gCurRoomNum 3) loop:) 7)
			)
			(gEgo setLoop: [local12 ((ScriptID gCurRoomNum 3) cel:)])
		)
		(if
			(and
				(== ((ScriptID gCurRoomNum 3) view:) 394)
				(== ((ScriptID gCurRoomNum 3) loop:) 1)
			)
			(gEgo setLoop: [local0 ((ScriptID gCurRoomNum 3) cel:)])
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global247 7)
				(gEgo setMotion: PolyPath 71 106 self)
			)
			(1
				((ScriptID gCurRoomNum 3)
					setMotion:
						MoveTo
						(- (gEgo x:) 17)
						(+ (gEgo y:) 14)
						self
				)
			)
			(2
				((ScriptID gCurRoomNum 3) setHeading: 90 self)
			)
			(3
				((ScriptID gCurRoomNum 3) setCycle: 0)
				(= cycles 1)
			)
			(4
				((ScriptID gCurRoomNum 3)
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
				((ScriptID gCurRoomNum 3)
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
				((ScriptID gCurRoomNum 3) setCycle: ForwardCounter 3 self)
			)
			(8
				(Narrator posn: 160 20 init: 5 0 0 42 self)
			)
			(9
				((ScriptID gCurRoomNum 3) setCycle: ForwardCounter 3 self)
			)
			(10
				(gSoundEffects stop: flags: 0)
				(gEgo setHeading: 180)
				((ScriptID gCurRoomNum 3) hide:)
				(= global247 9)
				((ScriptID 2 1) init: 2 0 0 46 1 self) ; Adam, "That was fun! Do it again!"
			)
			(11
				((ScriptID gCurRoomNum 3)
					show:
					posn:
						(- ((ScriptID gCurRoomNum 3) x:) 25)
						((ScriptID gCurRoomNum 3) y:)
				)
				((ScriptID gCurRoomNum 3)
					view: 382
					loop: 8
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(12
				(proc380_5)
				((ScriptID gCurRoomNum 3) setMotion: MoveTo 51 139 self)
			)
			(13
				((ScriptID 2 1) init: 2 0 0 55 1 self) ; Adam, "Hey, where are you going?"
			)
			(14
				((ScriptID gCurRoomNum 3) setMotion: MoveTo 51 149 self)
			)
			(15
				(gEgo setLoop: -1)
				(Face gEgo (ScriptID gCurRoomNum 3))
				((ScriptID gCurRoomNum 3) setHeading: 0 self)
			)
			(16
				((ScriptID gCurRoomNum 3) setCycle: 0)
				(= cycles 1)
			)
			(17
				((ScriptID gCurRoomNum 3)
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
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(19
				(= seconds 4)
			)
			(20
				(gEgo setHeading: 270)
				(gLongSong number: 382 loop: 1 play:)
				((ScriptID gCurRoomNum 3)
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
				((ScriptID gCurRoomNum 3) setCycle: CT 10 1 self)
			)
			(23
				(gLongSong number: 383 loop: -1 play:)
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) cel: 11 setCycle: End self)
			)
			(24
				((ScriptID 2 1) init: 2 0 0 56 1 self) ; Adam, "Whoa, good one!"
			)
			(25
				(= register 3)
				((ScriptID gCurRoomNum 3)
					view: 394
					loop: 1
					cel: 8
					posn: 78 106
					setCycle: CT 10 1 self
				)
			)
			(26
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(27
				((ScriptID gCurRoomNum 3) setPri: 6 setCycle: CT 2 1 self)
			)
			(28
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setCycle: CT 6 1 self)
			)
			(29
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setPri: 1 setCycle: CT 7 1 self)
			)
			(30
				((ScriptID gCurRoomNum 3) setPri: 6 setCycle: CT 10 1 self)
			)
			(31
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(32
				(if (-- register)
					(-= state 6)
				)
				(if (== register 1)
					((ScriptID 2 1) init: 2 0 0 57 1 self) ; Adam, "You're making me dizzy!"
				else
					(= ticks 3)
				)
			)
			(33
				((ScriptID gCurRoomNum 3) hide:)
				(= seconds 4)
			)
			(34
				(gEgo setLoop: -1 setMotion: MoveTo 104 105 self)
				((ScriptID gCurRoomNum 3)
					show:
					view: 382
					loop: 8
					cel: 0
					posn: 103 139
					setCycle: End
				)
			)
			(35
				((ScriptID 2 1) init: 3 0 0 19 1 self) ; Adam, "Catch me if you can! Ha!"
			)
			(36
				(gEgo setMotion: MoveTo 114 105 self)
			)
			(37
				(Face gEgo (ScriptID gCurRoomNum 3) self)
			)
			(38
				((ScriptID gCurRoomNum 3) setCycle: Beg self)
			)
			(39
				((ScriptID gCurRoomNum 3)
					view: 386
					loop: 0
					cel: 0
					posn: 150 107
					setCycle: CT 4 1 self
				)
				(gEgo hide:)
			)
			(40
				(Narrator posn: 160 20 init: 5 0 0 77 self)
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
				((ScriptID 2 1) init: 3 0 0 20 1 self) ; Adam, "Wow, I accept!"
			)
			(43
				(Narrator posn: 160 20 init: 6 0 0 7 self) ; "Adam cups his hand and the dolphin swims up under it and pulls Adam into a whirling, swooping ride around the pool."
			)
			(44
				(self setScript: giveEgoRide self)
			)
			(45
				(proc380_5)
				(= global247 11)
				((ScriptID gCurRoomNum 3) setMotion: MoveTo 40 167 self)
			)
			(46
				((ScriptID gCurRoomNum 3) setHeading: 90 self)
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
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(1
				((ScriptID gCurRoomNum 3)
					loop: 3
					cel: 7
					posn: 60 116
					setCycle: End self
				)
			)
			(2
				((ScriptID gCurRoomNum 3) cel: 0 setCycle: ForwardCounter 3 self)
			)
			(3
				(proc380_8)
				(proc380_5)
				((ScriptID gCurRoomNum 3) show: posn: 42 150 heading: 315 loop: 7)
				(gEgo show: posn: 42 148 setMotion: PolyPath 74 108 self)
			)
			(4
				((ScriptID gCurRoomNum 3) view: 382 loop: 6)
				(Face gEgo (ScriptID gCurRoomNum 3) self)
			)
			(5
				((ScriptID 2 1) init: 2 0 0 48 1 self) ; Adam, "Hey, thanks, that was the greatest!"
			)
			(6
				(Narrator posn: 160 20 init: 5 0 0 80 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

