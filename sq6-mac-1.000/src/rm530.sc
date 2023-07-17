;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Styler)
(use Scaler)
(use ROsc)
(use Osc)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
	Dr 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 1
	local6 = 1
	local7
)

(instance rm530 of SQRoom
	(properties
		picture 530
	)

	(method (init)
		(= gAct 3)
		(= local7 (gGSound1 vol:))
		(gEgo
			posn: 226 112
			normalize: 0
			setScaler: Scaler 50 51 115 98
			setSpeed: 9
			put: 29 ; Dead_Fish2
			get: 30 ; Dead_Fish3
			init:
		)
		(gGame handsOff:)
		(Load 140 535) ; WAVE
		(Load 140 532) ; WAVE
		(Load 140 406) ; WAVE
		(Load 140 407) ; WAVE
		(roger init: hide:)
		(rogerArm init: hide:)
		(cover init: hide:)
		(blast init: hide:)
		(blast2 init: hide:)
		(gun1 init:)
		(gun2 init:)
		(cone init:)
		(dr init:)
		(monitors init:)
		(spark init: setCycle: Fwd)
		(floorLights init:)
		(lights init:)
		(monitor2 init:)
		(shuttle init:)
		(super init:)
		(self setScript: sPlayShow)
	)
)

(instance Dr of SmallTalker
	(properties
		talkView 532
	)

	(method (init)
		(= client dr)
		(super init:)
	)
)

(instance sPlayShow of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo
					put: 31 ; Donut
					put: 91 ; Recall_Notice
					put: 96 ; Second_Negative
					put: 98 ; Second_Positive
					put: 48 ; First_Negative
					put: 50 ; First_Positive
					put: 40 ; Elmo_Gluzall
					put: 100 ; Sidney_Arm
					put: 25 ; Cyber_Jack
					get: 103 ; Subroutine_Card
				)
				(gGame points: 1)
				(gGSound2 number: 532 setLoop: -1 play:)
				(= ticks 170)
			)
			(1
				(= local2 (gEgo cycleSpeed:))
				(gEgo setSpeed: 7 setMotion: MoveTo 196 110 self)
				(dr
					setLoop: 1 1
					setCycle: Walk
					setSpeed: 9 1
					setMotion: MoveTo 291 113 self
				)
			)
			(2)
			(3
				(gEgo
					setScaler: Scaler 100 100 200 0
					view: 533
					posn: 190 98
					setCel: 0
					setLoop: 0
					setCycle: End
				)
				(= ticks 50)
			)
			(4
				(dr setLoop: 3 cycleSpeed: 11 1 setCycle: Fwd)
				(= ticks 30)
			)
			(5
				(spark hide:)
				(gGSound2 number: (RandomNumber 354 356) setLoop: 0 play:)
				(= ticks 20)
			)
			(6
				(gEgo setSpeed: local2 hide:)
				(if (== local1 8)
					(= ticks 1)
				else
					(++ local1)
					(self changeState: (- state 1))
				)
			)
			(7
				(gGSound2 number: (RandomNumber 354 356) setLoop: 0 play:)
				(dr setCel: 0 setLoop: 4 setCycle: CT 2 1 self)
			)
			(8
				(dr setCel: 1 setLoop: 6)
				(= ticks 1)
			)
			(9
				(gun1 setMotion: MoveTo 34 32)
				(gun2 setMotion: MoveTo 250 30 self)
			)
			(10
				(cone setMotion: MoveTo 160 33 self)
			)
			(11
				(= seconds 2)
			)
			(12
				(gGSound1 stop:)
				(gGSound2 number: 535 setLoop: -1 play:)
				(blast show: setCel: 0 setCycle: Fwd)
				(blast2 show: setCel: 0 setCycle: Fwd)
				(shuttle setLoop: 2 setCel: 0 setCycle: ROsc -1 0 5)
				(= ticks 1)
			)
			(13
				(PalVary 0 531 0 (RandomNumber 60 100)) ; PalVaryStart
				(= ticks (RandomNumber 2 3))
			)
			(14
				(PalVary 1 0 (RandomNumber 0 40)) ; PalVaryReverse
				(= ticks (RandomNumber 4 6))
			)
			(15
				(if (<= local0 20)
					(++ local0)
					(self changeState: (- state 2))
				else
					(gGSound2 stop:)
					(= ticks 1)
				)
			)
			(16
				(gGSound2 number: 536 setLoop: 0 play:)
				(blast dispose:)
				(blast2 dispose:)
				(spark hide:)
				(PalVary 0 5310 3 100) ; PalVaryStart
				(shuttle setCel: 5 setCycle: End self)
			)
			(17
				(gGSound2 stop:)
				(gMessager say: 0 0 1 0 self) ; "The shuttle is nicely miniaturized by the beam deal. Hopefully, it is reversible. Perhaps you should have asked about that. There are some things you can't afford to have smaller."
			)
			(18
				(gGSound1 stop:)
				(= seconds 2)
			)
			(19
				(gGSound1 number: 530 setLoop: -1 play:)
				(PalVary 1 7 0) ; PalVaryReverse
				(= seconds 3)
			)
			(20
				(= local4 1)
				(dr
					setLoop: 2 1
					setCycle: Walk
					setSpeed: 10
					setMotion: MoveTo 172 119 self
				)
			)
			(21
				(gGSound1 number: 51021 setLoop: -1 play:)
				(= local4 0)
				(spark show:)
				(gGSound2 number: 532 setLoop: -1 play:)
				(dr setLoop: 5 cycleSpeed: 12 setCycle: End self)
			)
			(22
				(= ticks 100)
			)
			(23
				(gGSound2 stop:)
				(blast hide:)
				(blast2 hide:)
				(gun1 dispose:)
				(gun2 dispose:)
				(cone dispose:)
				(dr hide:)
				(monitors hide:)
				(spark dispose:)
				(floorLights dispose:)
				(lights dispose:)
				(monitor2 dispose:)
				(shuttle dispose:)
				(gCurRoom style: 0 exitStyle: 0 picture: 490)
				(roger show:)
				(rogerArm show:)
				(cover show:)
				(gCurRoom drawPic: 490)
				(= gAutoRobot
					((WalkieTalkie new:)
						x: 0
						y: 0
						priority: 100
						init: 0 4904 self
						start:
						yourself:
					)
				)
			)
			(24
				(gGSound1 fade: 0 3 1 1)
				(rogerArm dispose:)
				(roger dispose:)
				(cover dispose:)
				(gCurRoom drawPic: 531 0 1)
				(monitors
					view: 5350
					posn: 265 37
					setLoop: 1
					setCel: 0
					show:
					setCycle: Osc
				)
				(dr posn: 191 4 view: 535 setLoop: 0 setCel: 0 show:)
				(= ticks 60)
			)
			(25
				(gGSound1 number: 199 setLoop: -1 setVol: local7 play:)
				(dr cycleSpeed: 9 setCycle: ROsc 2 0 1 self)
			)
			(26
				(dr cycleSpeed: 10 setCycle: End self)
			)
			(27
				(gGSound2 number: 513 setLoop: -1 play:)
				(gCurRoom picture: 532)
				(gCurRoom drawPic: 532)
				(monitors hide:)
				(dr
					posn: 50 95
					view: 536
					setLoop: 0
					setCel: 0
					cycleSpeed: 11
					show:
					setCycle: Fwd
				)
				(= seconds 6)
			)
			(28
				(gGSound2 stop:)
				(dr setLoop: 1 setCel: 0 cycleSpeed: 13 setCycle: End self)
			)
			(29
				(= seconds 6)
			)
			(30
				(dr setLoop: 1 setCel: 100 cycleSpeed: 13 setCycle: Beg self)
			)
			(31
				(gGSound2 play:)
				(dr setLoop: 0 setCel: 0 cycleSpeed: 11 setCycle: Fwd)
				(= seconds 8)
			)
			(32
				(gGSound2 stop:)
				(monitors
					view: 5370
					setLoop: 0
					setCel: 0
					posn: 51 42
					show:
					setCycle: Osc
				)
				(dr setLoop: 1 setCel: 0 cycleSpeed: 13 setCycle: End self)
			)
			(33
				(dr setSpeed: 5)
				(dr setMotion: MoveTo (- (dr x:) 15) (+ (dr y:) 2) self)
				(dr setCel: (- (dr cel:) 1))
			)
			(34
				(dr setMotion: MoveTo (- (dr x:) 17) (- (dr y:) 2) self)
				(dr setCel: (+ (dr cel:) 1))
			)
			(35
				(if (== (++ local3) 4)
					(= ticks 1)
				else
					(self changeState: (- state 2))
				)
			)
			(36
				(= temp0 (Styler divisions:))
				(Styler changeDivisions: 8)
				(gCurRoom drawPic: 533 12 1)
				(Styler changeDivisions: temp0)
				(= ticks 190)
			)
			(37
				(dr setSpeed: 7 view: 537 setCel: 0 setPri: 400 posn: -80 89)
				(= local3 0)
				(= ticks 1)
			)
			(38
				(dr setMotion: MoveTo (+ (dr x:) 20) (+ (dr y:) 4) self)
			)
			(39
				(dr setMotion: MoveTo (+ (dr x:) 20) (- (dr y:) 4) self)
			)
			(40
				(if (== (++ local3) 3)
					(= ticks 1)
				else
					(self changeState: (- state 2))
				)
			)
			(41
				(gGSound1 fade: 0 3 1 1)
				(dr cycleSpeed: 10 setCycle: End self)
			)
			(42
				(= ticks 40)
			)
			(43
				(gGSound1 stop:)
				(gCurRoom newRoom: 495)
			)
		)
	)
)

(instance roger of Prop
	(properties
		x 22
		y 83
		view 492
	)

	(method (init)
		(self setLoop: 0 setCel: 0 setPri: 133 hide:)
		(super init:)
	)
)

(instance rogerArm of Prop
	(properties
		x 22
		y 83
		view 492
	)

	(method (init)
		(self setLoop: 0 setCel: 1 setPri: 133 hide:)
		(super init:)
	)
)

(instance cover of Prop
	(properties
		x 163
		y 119
		view 499
	)

	(method (init)
		(self setLoop: 0 setCel: 0 setPri: 133 hide:)
		(super init:)
	)
)

(instance blast of Prop
	(properties
		x 173
		y 107
		view 530
		loop 3
	)
)

(instance blast2 of Prop
	(properties
		x 148
		y 107
		view 530
		loop 4
	)
)

(instance cone of Actor
	(properties
		view 530
		signal 24609
	)

	(method (init)
		(super init:)
		(self setLoop: 1 1 setCel: 0 setCycle: 0 posn: 160 -10)
	)
)

(instance dr of Actor
	(properties
		view 532
	)

	(method (doit)
		(if local4
			(if (and (== (self cel:) 3) local5)
				(= local5 0)
				(= local6 1)
				(gGSound2 number: 407 setLoop: 0 play:)
			)
			(if (and (== (self cel:) 7) local6)
				(= local6 0)
				(= local5 1)
				(gGSound2 number: 406 setLoop: 0 play:)
			)
		)
		(super doit:)
	)

	(method (init)
		(super init:)
		(self posn: 245 111)
	)
)

(instance gun1 of Actor
	(properties
		view 530
		signal 24609
	)

	(method (init)
		(super init:)
		(self setLoop: 1 1 cel: 1 setCycle: 0 posn: 34 -10)
	)
)

(instance gun2 of Actor
	(properties
		view 530
		signal 24609
	)

	(method (init)
		(super init:)
		(self setLoop: 1 1 setCel: 2 setCycle: 0 posn: 250 -12)
	)
)

(instance monitors of Prop
	(properties
		x 2
		y 84
		view 531
	)

	(method (init)
		(self cycleSpeed: 8 setCycle: Fwd)
		(super init:)
	)
)

(instance spark of Prop
	(properties
		x 42
		y 91
		view 531
		loop 1
	)

	(method (init)
		(self cycleSpeed: 3)
		(super init:)
	)
)

(instance floorLights of Prop
	(properties
		x 115
		y 65
		view 531
		loop 3
	)

	(method (init)
		(self cycleSpeed: 7 setCycle: Fwd)
		(super init:)
	)
)

(instance lights of Prop
	(properties
		x 104
		y 55
		view 531
		loop 2
	)

	(method (init)
		(self cycleSpeed: 9 setCycle: Fwd)
		(super init:)
	)
)

(instance monitor2 of Prop
	(properties
		x 295
		y 89
		view 531
		loop 4
	)

	(method (init)
		(self cycleSpeed: 9 setCycle: Fwd)
		(super init:)
	)
)

(instance shuttle of Prop
	(properties
		x 106
		y 142
		view 530
	)
)

