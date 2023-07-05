;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Motion)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	[local0 100]
)

(instance rm180 of KQ6Room
	(properties
		picture 180
		autoLoad 0
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 99) ; speedRoom
			(gGlobalSound number: 752 setLoop: -1 play:)
		)
		(gEgo init: view: 180 normal: 0 cel: 0 posn: 86 94 setPri: 14)
		(self setScript: sKissStuff)
	)
)

(instance sKissStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo cel: 3)
				(= ticks 30)
			)
			(4
				(gEgo cel: 2)
				(= ticks 30)
			)
			(5
				(gEgo cel: 3)
				(= ticks 30)
			)
			(6
				((ScriptID 1015 6) talkWidth: 100 x: 170 y: 140) ; tlkGuardDog1
				(= seconds 5)
			)
			(7
				(gMessager say: 1 0 3 1 self) ; "<growl!> Ahem!"
			)
			(8
				(gEgo setCycle: Beg self)
				((ScriptID 1015 6) talkWidth: 150 x: 70 y: 40) ; tlkGuardDog1
			)
			(9
				(= seconds 2)
			)
			(10
				(gEgo
					view: 758
					setLoop: 0
					cel: 3
					posn: 29 179
					scaleSignal: 1
					scaleX: 128
					scaleY: 128
					signal: 26624
				)
				(body init: setLoop: 0 cel: 0)
				(leftGuard init: cel: 2)
				(rightGuard init:)
				(sword init: setPri: 1 ignoreActors: 1 addToPic:)
				(gCurRoom drawPic: 750 10)
				(gTheIconBar disable: 6)
				(= cycles 2)
			)
			(11
				(body setCycle: End self)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo
					reset: 0
					scaleSignal: 1
					scaleX: 115
					scaleY: 115
					setPri: 13
					posn: 21 177
				)
				(cassima init: setPri: 14 setCycle: Beg self)
			)
			(14
				(cassima view: 784 setLoop: 0 posn: 29 188 addToPic:)
				(gEgo addToPic:)
				(= cycles 2)
			)
			(15
				(gMessager say: 1 0 2 1 self) ; "Oh! Guards!"
			)
			(16
				(cassima dispose:)
				(gEgo dispose:)
				(body setCycle: End self)
			)
			(17
				(gMessager say: 1 0 2 2 self) ; "Princess Cassima, are you well?"
			)
			(18
				(body setCycle: End self)
			)
			(19
				(gMessager say: 1 0 2 3 self) ; "I am quite well, thank you. Please take Abdul and put him in the dungeon. See to it that he gets a doctor."
			)
			(20
				(body setCycle: End self)
				(rightGuard cel: 3)
			)
			(21
				(gMessager say: 1 0 2 4 self) ; "Yes, Majesty."
			)
			(22
				(leftGuard cel: 0)
				(body setLoop: 1 cel: 0 setCycle: End self)
			)
			(23
				(body setLoop: 2 cel: 0 setCycle: End self)
			)
			(24
				(= ticks 30)
			)
			(25
				(body setCycle: CT 1 -1 self)
			)
			(26
				(body setCycle: End self)
			)
			(27
				(body setCycle: Beg self)
			)
			(28
				(rightGuard
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 233 133 self
				)
			)
			(29
				(rightGuard setLoop: 0 setPri: 1 setMotion: MoveTo 249 135 self)
			)
			(30
				(rightGuard setLoop: 2 setMotion: MoveTo 289 184 rightGuard)
				(body
					view: 145
					scaleSignal: 1
					scaleX: 95
					scaleY: 95
					setStep: 4 4
					posn: 169 149
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 233 133 self
				)
			)
			(31
				(body setPri: 1 setMotion: MoveTo 249 135 self)
				(leftGuard
					view: 765
					setLoop: 0
					cel: 0
					posn: 115 150
					setCycle: End
				)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
			)
			(32
				(body setLoop: 2 setMotion: MoveTo 289 184 body)
				(leftGuard
					view: 7651
					posn: 127 150
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 233 133 self
				)
			)
			(33
				(leftGuard setPri: 1 setMotion: MoveTo 249 135 self)
			)
			(34
				(leftGuard setLoop: 2 setMotion: MoveTo 289 184 self)
			)
			(35
				(leftGuard dispose:)
				(= cycles 2)
			)
			(36
				(gCurRoom drawPic: 98 9)
				(gTheIconBar enable: 6)
				(gGlobalSound fade:)
				(= seconds 4)
			)
			(37
				(Message msgGET 180 1 0 2 5 @local0) ; "One week later...."
				(gCurRoom drawPic: 98 12)
				(Display @local0 dsCOORD 85 85 dsCOLOR 14 dsFONT 0)
				(gGlobalSound number: 743 setLoop: -1 play:)
				(= seconds 3)
			)
			(38
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance cassima of Actor
	(properties
		x 29
		y 178
		view 753
		loop 4
		cel 3
		signal 16384
		illegalBits 0
	)
)

(instance leftGuard of Actor
	(properties
		x 115
		y 150
		view 724
		loop 4
	)
)

(instance rightGuard of Actor
	(properties
		x 204
		y 161
		view 726
		loop 4
		cel 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance body of Actor
	(properties
		x 159
		y 150
		view 757
		loop 2
		cel 1
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sword of View
	(properties
		x 157
		y 143
		view 757
		loop 3
	)
)

