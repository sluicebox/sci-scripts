;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Main)
(use n940)
(use RandCycle)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	dilema 0
)

(local
	local0
)

(instance dilema of Rm
	(properties
		picture 98
		style 10
	)

	(method (init)
		(super init:)
		(gGame setCursor: 69 1 304 172)
		(= global105 18)
		(HandsOff)
		(gLongSong number: 300 loop: -1 play:)
		(self setScript: demoScript)
	)

	(method (dispose)
		(DisposeScript 941)
		(DisposeScript 940)
		(super dispose:)
	)
)

(instance demoScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(Sound pause: 1)
			(gGame setCursor: 999)
			(switch
				(PrintD
					{You may skip this sequence\nif you have already seen it.\n}
					67
					100
					60
					106
					81
					{Skip it}
					0
					106
					81
					{Watch it}
					1
				)
				(0
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(SetFlag 73)
					(gCurRoom newRoom: gPrevRoomNum)
				)
				(1
					(Sound pause: 0)
					(gGame setCursor: 69 1 304 172)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (OneOf state 4 8 11))
				(return)
			)
			((and (== (marie cel:) 0) (== local0 0))
				(sfx3
					number: (Random 314 315)
					loop: 1
					vol: (+ 80 (* (/ (marie y:) 30) 10))
					play:
				)
				(= local0 1)
			)
			((and (== (marie cel:) 4) (== local0 0))
				(sfx3
					number: (Random 314 315)
					loop: 1
					vol: (+ 80 (* (/ (marie y:) 30) 10))
					play:
				)
				(= local0 1)
			)
			((not (OneOf (marie cel:) 0 4))
				(= local0 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Display 890 0 dsCOORD 60 80 dsCOLOR global125 dsFONT 0 dsWIDTH 200) ; "Meanwhile, at the OakTree Mall, Sonny's wife, Marie is just getting off work."
				(= seconds 5)
			)
			(1
				(gCurRoom drawPic: 30)
				(storeWindow init: stopUpd:)
				(= cycles 50)
			)
			(2
				(ShowClock 1)
				(= seconds 3)
			)
			(3
				(sfx1 number: 304 loop: 1 play:)
				(storeWindow
					posn: 156 7
					loop: 4
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(4
				(ShowClock 0)
				(marie
					setCycle: Walk
					setLoop: 0
					cel: 1
					setMotion: MoveTo 181 27 self
					init:
				)
				(storeWindow loop: 5 cel: 0)
			)
			(5
				(sfx1 number: 304 loop: 1 play:)
				(storeWindow setCycle: End self)
			)
			(6
				(marie loop: 6 cel: 0 setCycle: CT 9 1)
				(= seconds 3)
			)
			(7
				(marie setCycle: End self)
			)
			(8
				(storeWindow dispose:)
				(marie
					setLoop: 0
					x: (+ (marie x:) 1)
					y: (+ (marie y:) 2)
					setCycle: Walk
					setMotion: MoveTo 190 47 self
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetW init:)
				(marieHead cycleSpeed: 10 setCycle: End init:)
				(sfx1 number: 305 loop: 1 play:)
				(= seconds 4)
			)
			(10
				(marieHead loop: 2 cycleSpeed: 20 setCycle: End)
				(marie posn: 222 80 setStep: 3 2 setLoop: 1)
				(= seconds 4)
			)
			(11
				(marieHead dispose:)
				(insetW dispose:)
				(marie setMotion: MoveTo 202 144 self)
			)
			(12
				(marie setLoop: 2 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(13
				(= seconds 2)
			)
			(14
				(gCurRoom drawPic: 66)
				(marieHead view: 368 loop: 0 cel: 0 posn: 174 82 init:)
				(marie hide:)
				(mArm cycleSpeed: 14 setCycle: RandCycle init:)
				(= seconds 3)
			)
			(15
				(gCurRoom style: 7 drawPic: 65)
				(mArm dispose:)
				(= cycles 5)
				(sfx3 number: 315 loop: 1 play:)
			)
			(16
				(sfx1 number: 306 loop: 1 play:)
				(marieHead
					loop: 1
					cel: 0
					posn: 149 84
					cycleSpeed: 20
					setCycle: RandCycle
				)
				(= seconds 2)
			)
			(17
				(marieHead setCycle: 0 cel: 1)
				(cigarette moveSpeed: 1 setMotion: MoveTo 68 108 self init:)
			)
			(18
				(= seconds 2)
			)
			(19
				(cigarette setMotion: MoveTo 33 96 self)
			)
			(20
				(tip setCycle: End self init:)
			)
			(21
				(tip dispose:)
				(cigarette setMotion: MoveTo 33 126 self)
			)
			(22
				(marieHead dispose:)
				(insetW view: 370 loop: 0 cel: 0 posn: 138 117 setPri: 2 init:)
				(stripe init:)
				(= cycles 3)
			)
			(23
				(smoke setCycle: End self init:)
				(sfx1 number: 313 loop: 1 play:)
			)
			(24
				(knife setMotion: MoveTo 88 112 self init:)
			)
			(25
				(sfx1 number: 310 loop: 1 play:)
				(knife setCycle: End self)
			)
			(26
				(knife loop: 2 cel: 0 setCycle: End self)
			)
			(27
				(gCurRoom style: 10 drawPic: 30)
				(cigarette dispose:)
				(insetW dispose:)
				(marieHead dispose:)
				(knife dispose:)
				(bandit1 init:)
				(bandit2 init:)
				(stripe dispose:)
				(= cycles 30)
			)
			(28
				(bandit1 cycleSpeed: 8 setCycle: End self)
				(sfx3 number: 301 loop: 1 play:)
				(gLongSong stop:)
			)
			(29
				(bandit2 loop: 1 cycleSpeed: 8 posn: 207 147 setCycle: End self)
				(bandit1 dispose:)
			)
			(30
				(sfx1 number: 307 loop: 1 play:)
				(insetW
					view: 372
					loop: 0
					cel: 0
					posn: 160 120
					setPri: 13
					cycleSpeed: 10
					init:
				)
				(= seconds 2)
			)
			(31
				(gCurRoom style: 6 drawPic: 98)
				(bandit1 dispose:)
				(bandit2 dispose:)
				(Animate (gCast elements:) 0)
				(insetW setCycle: End self)
			)
			(32
				(bandit1
					view: 372
					loop: 1
					cel: 0
					posn: 164 111
					setPri: 15
					cycleSpeed: 6
					setPri: 15
					setCycle: Fwd
					init:
				)
				(= seconds 3)
			)
			(33
				(gCurRoom style: 10 drawPic: 98)
				(bandit1 dispose:)
				(insetW dispose:)
				(= seconds 3)
			)
			(34
				(sfx3 fade:)
				(sfx1 fade:)
				(= seconds 2)
			)
			(35
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetFlag 73)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance storeWindow of Prop
	(properties
		x 140
		y 7
		view 366
		loop 3
		signal 16384
	)
)

(instance marieHead of Prop
	(properties
		x 195
		y 79
		view 367
		loop 1
		priority 14
		signal 16
	)
)

(instance insetW of Prop
	(properties
		x 195
		y 110
		view 367
		priority 13
		signal 16400
	)
)

(instance knife of Actor
	(properties
		x 88
		y 130
		view 370
		loop 1
		priority 3
		signal 2064
	)
)

(instance marie of Actor
	(properties
		x 180
		y 23
		yStep 1
		view 366
		cycleSpeed 8
		xStep 2
		moveSpeed 8
	)
)

(instance bandit1 of Actor
	(properties
		x 214
		y 145
		view 371
		signal 16384
	)
)

(instance bandit2 of Actor
	(properties
		x 210
		y 145
		view 371
		loop 2
		signal 16384
	)
)

(instance mArm of Prop
	(properties
		x 176
		y 126
		view 368
		loop 2
		priority 3
		signal 16400
	)
)

(instance cigarette of Actor
	(properties
		x 45
		y 134
		view 368
		loop 3
		signal 18448
	)
)

(instance smoke of Prop
	(properties
		x 166
		y 57
		view 370
		loop 3
		priority 6
		signal 18448
	)
)

(instance stripe of Prop
	(properties
		x 93
		y 117
		view 370
		cel 1
		priority 15
		signal 16400
	)
)

(instance tip of Prop
	(properties
		x 53
		y 64
		view 368
		loop 4
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance sfx1 of Sound
	(properties
		priority 15
	)
)

(instance sfx2 of Sound ; UNUSED
	(properties
		priority 14
	)
)

(instance sfx3 of Sound
	(properties
		priority 13
	)
)

