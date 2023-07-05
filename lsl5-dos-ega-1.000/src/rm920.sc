;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 920)
(include sci.sh)
(use Main)
(use eRS)
(use MCyc)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm920 0
)

(local
	[runJumpPts 25] = [0 11 91 86 0 12 92 89 0 13 91 91 0 14 111 98 0 14 153 84 0 14 173 80 -32768]
)

(instance rm920 of LLRoom
	(properties
		picture 920
	)

	(method (init)
		(Load rsPIC 1)
		(super init:)
		(gEgo
			init:
			normalize:
			view: 923
			posn: 137 117
			setCycle: 0
			setLoop: 0
			setCel: 0
			setPri: 8
			setStep: 1 1
			illegalBits: 0
			ignoreActors: 1
			hide:
		)
		(crack init: hide:)
		(bars init: hide:)
		(rope init: hide:)
		(chiChi init: setCycle: Fwd)
		(blinds init: setCel: 255)
		(gTheMusic number: 920 loop: -1 play:)
		(self setScript: sCartoon)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic stop:)
		(gTheMusic2 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFFRoom 900)
				(SetupExit 0)
				(= ticks 90)
			)
			(1
				(Say gEgo 920 0) ; "Chi Chi!" you cry. "What are you doing?"
				(= ticks 30)
			)
			(2
				(TPrint 920 1 80 {Chi Chi}) ; "Come on, my little Tito Puente," she cries, "I am ready and waiting!"
				(= ticks 90)
			)
			(3
				(blinds setCycle: Beg self)
			)
			(4
				(blinds stopUpd:)
				(= ticks 90)
			)
			(5
				(if (!= (chiChi cel:) 1)
					(-- state)
				else
					(gEgo show:)
				)
				(= register (gEgo cycleSpeed:))
				(= cycles 2)
			)
			(6
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(7
				(gTheMusic2 number: 913 loop: 1 play:)
				(gEgo cycleSpeed: register setLoop: 1 setCel: 0 posn: 85 82)
				(rope show: setCycle: End)
				(Say gEgo 920 2 67 -1 28 108) ; "UGH!"
				(ShakeScreen 5 ssUPDOWN)
				(= ticks 90)
			)
			(8
				(gEgo setStep: 3 6 setMotion: MoveTo 85 124 self)
			)
			(9
				(= seconds 3)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(= seconds 4)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(blinds setCycle: End self)
			)
			(13
				(Load rsVIEW 924)
				(Load rsVIEW 925)
				(blinds stopUpd:)
				(= seconds 4)
			)
			(14
				(gEgo
					hide:
					setMotion: 0
					view: 924
					cycleSpeed: 12
					setStep: 3 3
					setLoop: 0
					setCel: 0
					posn: 77 93
				)
				(chiChi
					view: 925
					setLoop: 0
					cycleSpeed: 18
					posn: 176 166
					setCycle: Fwd
					setPri: 13
				)
				(bars
					show:
					view: 920
					setLoop: 2
					setCel: 1
					posn: 180 159
					stopUpd:
				)
				(rope view: 920 setLoop: 2 setCel: 0 posn: 104 136 stopUpd:)
				(blinds setCycle: Beg self)
			)
			(15
				(blinds stopUpd:)
				(= seconds 4)
			)
			(16
				(TPrint 920 3 67 -1 15 70 280 80 {Chi Chi}) ; "Oh, Larry!" cries Chi Chi, "I bet you've never done it THIS way!"
				(chiChi setLoop: 1 setCel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(17
				(chiChi setCel: 0 setCycle: End self)
			)
			(18
				(= ticks 120)
			)
			(19
				(gEgo show: setCycle: CT 4 1 self)
			)
			(20
				(TPrint 920 4 67 -1 28 80 {Chi Chi}) ; "Larry! Watch out for my trampoline!"
				(gEgo setCycle: CT 10 1 self)
			)
			(21
				(gTheMusic2 number: 448 loop: 1 play:)
				(gEgo setCel: 11 cycleSpeed: 12 setCycle: MCyc @runJumpPts self)
			)
			(22
				(gTheMusic2 number: 913 loop: 1 play:)
				(Say gEgo 920 5 80 {You} 67 -1 28 108) ; "ARGGHH!"
				(gEgo hide:)
				(crack
					show:
					view: 920
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					posn: 244 59
					setPri: 15
					setCycle: End self
				)
			)
			(23
				(ShakeScreen 7 ssLEFTRIGHT)
				(crack addToPic:)
				(= seconds 4)
			)
			(24
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(blinds setCycle: End self)
			)
			(25
				(Load rsVIEW 921)
				(Load rsVIEW 922)
				(rope dispose:)
				(bars setPri: 4 posn: 131 161 setCel: 2 setLoop: 2 stopUpd:)
				(gEgo show: view: 921 posn: 85 124 setLoop: 3 setCel: 0)
				(chiChi
					view: 922
					posn: 102 123
					cycleSpeed: 9
					moveSpeed: 9
					setLoop: 0
					setCel: 0
				)
				(blinds stopUpd:)
				(= seconds 4)
			)
			(26
				(blinds setCycle: Beg self)
			)
			(27
				(blinds stopUpd:)
				(= ticks 30)
			)
			(28
				(chiChi
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo 150 (chiChi y:) self
				)
			)
			(29
				(chiChi
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 7 1 self
				)
			)
			(30
				(= ticks 30)
			)
			(31
				(chiChi setCycle: End self)
			)
			(32
				(= ticks 90)
			)
			(33
				(TPrint 920 6 80 {Chi Chi} 67 -1 15 70 280) ; "Now it's your turn, Larry!" says Chi Chi, the blood rushing to her brain. "Come and get it, Big Fella!"
				(= ticks 90)
			)
			(34
				(gEgo cycleSpeed: 11 moveSpeed: 11 setCycle: End self)
			)
			(35
				(= ticks 30)
			)
			(36
				(gEgo
					setCycle: Walk
					setLoop: 0
					setStep: 1 1
					setMotion: MoveTo 116 (gEgo y:) self
				)
			)
			(37
				(gEgo setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(38
				(gTheMusic2 number: 914 loop: 1 play:)
				(Say gEgo 920 7 80 {You} 67 -1 28 108) ; "AAWWWH!"
				(ShakeScreen 5 ssLEFTRIGHT)
				(= ticks 90)
			)
			(39
				(gEgo setCycle: End self)
			)
			(40
				(= ticks 90)
			)
			(41
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gTheMusic2 number: 915 loop: 1 play:)
				(gEgo setLoop: 2 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(42
				(= seconds 4)
			)
			(43
				(blinds setCycle: End self)
			)
			(44
				(= ticks 180)
			)
			(45
				(gEgo hide:)
				(chiChi dispose:)
				(bars dispose:)
				(blinds dispose:)
				(DrawPic 1 6)
				(gTheMusic fade:)
				(gTheMusic2 fade:)
				(= seconds 3)
			)
			(46
				(Points 40 165)
				(TPrint 920 8) ; "What a humiliating experience this has been! Finally, your lack of athletic ability has emerged to haunt you!"
				(if (>= ((Inv at: 0) state:) 100) ; Camcorder
					(RecordTape 4)
					(Points 20 167)
					(TPrint 920 9) ; "Well, at least you recorded Chi Chi on your videotape. The boys in the office will be proud of you!"
					(TPrint 920 10 67 -1 185) ; "(But so much for those fantasies you've had about you and gymnasts!)"
				else
					(TPrint 920 11) ; "What a shame you didn't get that scene on tape!"
				)
				(gCurRoom newRoom: 900)
			)
		)
	)
)

(instance chiChi of Actor
	(properties
		x 128
		y 108
		description {Chi Chi Lambada}
		sightAngle 90
		lookStr {Chi Chi loves doing sexually-explicit gymnastics routines.}
		view 922
		loop 2
		priority 7
		signal 18448
		cycleSpeed 8
	)
)

(instance blinds of Prop
	(properties
		x 128
		y 158
		description {the venetian blinds}
		sightAngle 90
		lookStr {If it weren't for these venetian blinds, we'd all have a perfect view!}
		view 920
		priority 14
		signal 18448
		cycleSpeed 10
	)
)

(instance rope of Prop
	(properties
		x 136
		y 44
		description {the rope}
		sightAngle 90
		lookStr {Hang on to this!}
		view 923
		loop 2
		signal 18448
		cycleSpeed 8
	)
)

(instance bars of View
	(properties
		view 920
		signal 18448
	)
)

(instance crack of Prop
	(properties
		view 920
		signal 18448
	)
)

