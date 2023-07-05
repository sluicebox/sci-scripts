;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm9 0
)

(local
	[local0 9] = [-1 {QUEEN'S KNIGHT} 32 0 0 0 0 0 0]
	[local9 4] = [1009 0 1 0]
	[local13 4] = [1009 1 1 0]
	[local17 4] = [1009 2 1 0]
	[local21 5] = [1009 3 1 2 0]
)

(instance rm9 of Rm
	(properties
		picture 120
		style 10
	)

	(method (init)
		(= global146 gRansom)
		(AddRansom (- gRansom))
		(super init:)
		(LoadMany rsVIEW 127 212 8)
		(= gRansom 0)
		(theKnight init: setCycle: Walk)
		(myWill init:)
		(myJohn init:)
		(myTuck init:)
		(myAlan init:)
		(myMuch init:)
		(NormalEgo 5)
		(gEgo cel: 1 posn: 300 -10 signal: 24576 init:)
		(if (not (IsFlag 5))
			(maidMarian setCycle: Walk init: stopUpd:)
		)
		(gRgnMusic number: 9 loop: -1 play:)
		(gEgo setScript: doTheSlideShow)
	)

	(method (dispose)
		(gRgnMusic fade: 0 20 12 1)
		(super dispose:)
	)
)

(instance myWill of View
	(properties
		x 227
		y 120
		view 161
		loop 3
		signal 1
	)
)

(instance myJohn of View
	(properties
		x 104
		y 62
		view 152
		signal 1
	)
)

(instance myTuck of View
	(properties
		x 61
		y 57
		view 155
		signal 1
	)
)

(instance myAlan of View
	(properties
		x 38
		y 103
		view 158
		signal 1
	)
)

(instance myMuch of View
	(properties
		x 7
		y 97
		view 164
		signal 1
	)
)

(instance horseAndKnight of Prop
	(properties
		x 165
		y 90
		view 127
		loop 3
		signal 16385
	)
)

(instance knightArm of Prop
	(properties
		x 174
		y 25
		view 127
		priority 12
		signal 16
	)
)

(instance knightHead of Prop
	(properties
		x 166
		y 23
		view 127
		loop 2
		priority 12
		signal 16400
	)
)

(instance theKnight of Actor
	(properties
		x 270
		view 127
		loop 1
	)
)

(instance maidMarian of Actor
	(properties
		x 340
		y 82
		view 211
		loop 1
	)
)

(instance mule1 of Actor
	(properties
		x 256
		y -10
		view 127
		loop 4
	)
)

(instance mule2 of Actor
	(properties
		x 311
		y -60
		view 127
		loop 4
	)
)

(instance doTheSlideShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(theKnight setLoop: 1 setMotion: PolyPath 165 89 self)
				(gEgo setMotion: PolyPath 230 75)
			)
			(1
				(Face theKnight gEgo)
				(= cycles 1)
			)
			(2
				(theKnight hide:)
				(gEgo view: 8 setLoop: 0 setCel: 0 setCycle: End self)
				(horseAndKnight init:)
				(knightHead init:)
				(knightArm init:)
			)
			(3
				(NormalEgo 1 0 1)
				(if (IsFlag 65)
					(mule1
						setLoop: 4
						setCycle: Walk
						signal: 26624
						init:
						illegalBits: 0
						setMotion: PolyPath 212 60
					)
					(mule2
						setLoop: 4
						illegalBits: 0
						init:
						setCycle: Walk
						signal: 26624
						setMotion: PolyPath 185 50 self
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (and (not (IsFlag 5)) (IsFlag 62))
					(maidMarian setMotion: PolyPath 252 77 self)
				else
					(= ticks 6)
				)
			)
			(5
				(if (and (not (IsFlag 5)) (IsFlag 62))
					(maidMarian
						view: 212
						setLoop: 1
						setCel: 0
						y: (+ (maidMarian y:) 1)
						signal: 16384
					)
				)
				(= ticks 6)
			)
			(6
				(if (IsFlag 65)
					(mule1 setCel: 2)
					(mule2 setCel: 2)
				)
				(= ticks 6)
			)
			(7
				(if (IsFlag 65)
					(mule1 loop: 5)
					(mule2 loop: 5)
				)
				(Converse @local9 @local0 0 self) ; "There's no need to accompany me further. I've loyal men waiting in Nottingham to see me the rest of the way."
			)
			(8
				(Converse @local13 1 0 self) ; "Then godspeed you safely to the Queen's side."
			)
			(9
				(Converse 1 @local17 @local0 0 self) ; "I give you my heartfelt thanks, you and all your men, for your aid and loyalty."
			)
			(10
				(knightArm setCycle: End self)
			)
			(11
				(horseAndKnight delete: dispose:)
				(knightArm delete: dispose:)
				(knightHead delete: dispose:)
				(theKnight show: setCycle: Walk setMotion: PolyPath -50 285)
				(if (IsFlag 65)
					(mule1
						setLoop: 4
						setCel: 2
						setCycle: Walk
						signal: 26624
						setMotion: PolyPath -40 275
					)
				)
				(= ticks 100)
			)
			(12
				(if (IsFlag 65)
					(mule2
						setLoop: 4
						setCel: 2
						setCycle: Walk
						signal: 26624
						setMotion: PolyPath -40 260 self
					)
				else
					(self cue:)
				)
			)
			(13
				(if (and (not (IsFlag 5)) (IsFlag 62))
					(Face gEgo maidMarian self)
					(Face maidMarian gEgo)
				else
					(self cue:)
				)
			)
			(14
				(if (and (not (IsFlag 5)) (IsFlag 62))
					(Converse @local21 1 22 self) ; "I wish you'd gone with him. You'd be safer with the Queen."
				else
					(self cue:)
				)
			)
			(15
				(if (IsFlag 65)
					(mule1 dispose: delete:)
					(mule2 dispose: delete:)
				)
				(if (and (not (IsFlag 5)) (IsFlag 62))
					(maidMarian dispose: delete:)
				)
				(theKnight dispose: delete:)
				(myJohn dispose: delete:)
				(myWill dispose: delete:)
				(myTuck dispose: delete:)
				(myAlan dispose: delete:)
				(myMuch dispose: delete:)
				(gEgo hide:)
				(gCurRoom drawPic: 803 -32762)
				(= ticks 48)
			)
			(16
				(gCurRoom newRoom: 801) ; troub
			)
		)
	)
)

