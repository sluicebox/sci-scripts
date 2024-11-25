;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use ForwardCounter)
(use Rev)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	local0
	local1
	local2
)

(instance rm031 of Rm
	(properties
		picture 31
		style 0
		horizon 100
		east 32
		west 30
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 10)
		(Load rsSOUND 2)
		(Load rsSOUND 54)
		(Load rsSOUND 55)
		(Load rsVIEW 74)
		(Load rsVIEW 136)
		(Load rsVIEW 57)
		(Load rsVIEW 39)
		(Load rsVIEW 374)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(23
				(gEgo x: (+ (/ (* (- (gEgo x:) 241) 95) 77) 1))
			)
			(24
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 76) 158) 97))
			)
			(25
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 42) 68) 250))
			)
			(30
				(gEgo y: (+ (/ (* (- (gEgo y:) 95) 67) 79) 101))
			)
			(32
				(if (< (gEgo y:) 110)
					(gEgo x: 292)
				)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(bell1 setScript: pointerScript init:)
		(bell2 init:)
		(bell3 init:)
		(bell4 init:)
		(bell5 init:)
		(shell1 init:)
		(shell2 init:)
		(shell3 init:)
		(shell4 init:)
		(if [global675 31]
			(maryDone init:)
			(rake init:)
			(flower1 init:)
			(flower2 init:)
			(flower3 init:)
			(flower4 init:)
			(flower5 init:)
			(flower6 init:)
			(= local1 1)
		else
			(mary init:)
		)
		(if (> global131 1)
			(waterProp1 init:)
			(waterProp2 init:)
			(waterProp3 init:)
			(maid1 init:)
			(maid2 init:)
			(maid3 init:)
		else
			(waterProp1 init: addToPic:)
			(waterProp2 init: addToPic:)
			(waterProp3 init: addToPic:)
			(maid1 init: addToPic:)
			(maid2 init: addToPic:)
			(maid3 init: addToPic:)
		)
		(if (and (not [global675 31]) (proc0_11 57))
			(= [global675 31] 1)
			(gGlobalMGSound number: 1 priority: 5 loop: -1 fade:)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 6)
				)
				(2
					(gGame setSpeed: 8)
				)
			)
			(self setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 8)
						(== local2 2)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 8) (== local2 2))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 8) (== local2 2))
					(rhymeScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local1 1))
					(cond
						((proc0_16 event 50 99 60 124)
							(pointerScript changeState: 1)
						)
						((proc0_16 event 34 103 44 131)
							(pointerScript changeState: 3)
						)
						((proc0_16 event 16 117 27 140)
							(pointerScript changeState: 5)
						)
						((proc0_16 event 69 103 77 111)
							(pointerScript changeState: 7)
						)
						((proc0_16 event 86 103 94 111)
							(pointerScript changeState: 9)
						)
						((proc0_16 event 103 103 113 111)
							(pointerScript changeState: 11)
						)
						((proc0_16 event 121 102 131 110)
							(pointerScript changeState: 13)
						)
						((proc0_16 event 140 104 147 111)
							(pointerScript changeState: 15)
						)
						((proc0_16 event 41 134 57 139)
							(pointerScript changeState: 17)
						)
						((proc0_16 event 73 135 88 140)
							(pointerScript changeState: 17)
						)
						((proc0_16 event 105 134 119 139)
							(pointerScript changeState: 17)
						)
						(
							(and
								(proc0_16 event 138 120 155 155)
								(not [global675 31])
							)
							(LookAt mary)
							(mary setScript: talkScript)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 2)
			(gCurRoom newRoom: 32)
		)
		(if (== (gEgo edgeHit:) EDGE_TOP)
			(cond
				((< (gEgo x:) 97)
					(gCurRoom newRoom: 23)
				)
				((< (gEgo x:) 250)
					(gCurRoom newRoom: 24)
				)
				(else
					(gCurRoom newRoom: 25)
				)
			)
		)
		(super doit:)
		(if (> (gEgo distanceTo: mary) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 31])
				(not global108)
				(< (gEgo distanceTo: mary) 30)
			)
			(= global108 1)
			(LookAt mary)
			(mary setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(= global103 1)
				(HandsOff)
				(mary view: 374 setLoop: 0 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Kindly\nfetch my\nwatering can\nfor me.}
					dsWIDTH
					80
					dsCOORD
					151
					52
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(mary setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(mary view: 74 setLoop: 2 setCycle: Fwd)
				(= global103 0)
				(= local1 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global209 1)
				(= global103 1)
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(cond
					((< (gEgo y:) 106)
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 210 101 self
						)
					)
					((and (< (gEgo x:) 30) (< (gEgo y:) 145))
						(gEgo setAvoider: Avoid setMotion: MoveTo 5 145 self)
					)
					(else
						(gEgo setAvoider: Avoid)
						(= cycles 1)
					)
				)
			)
			(1
				(if (> (gEgo x:) 180)
					(gEgo setMotion: MoveTo 190 160 self)
				else
					(= cycles 1)
				)
			)
			(2
				(mary setLoop: 3 setCel: 1 stopUpd:)
				(gEgo setMotion: MoveTo 150 150 self)
			)
			(3
				(proc0_18)
				(rake init:)
				(mary setScript: maryScript)
				(gEgo setMotion: MoveTo 145 170 self)
			)
			(4
				(if (> global131 1)
					(gEgo setScript: musicScript)
				)
				(gEgo setAvoider: 0 setLoop: 3 stopUpd:)
			)
			(5
				(bell1 setCycle: Fwd)
				(bell2 setCycle: Fwd)
				(bell3 setCycle: Fwd)
				(bell4 setCycle: Fwd)
				(bell5 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(bell1 stopUpd:)
				(bell2 stopUpd:)
				(bell3 stopUpd:)
				(bell4 stopUpd:)
				(bell5 stopUpd:)
				(shell1 setCycle: Fwd)
				(shell2 setCycle: Fwd)
				(shell3 setCycle: Fwd)
				(shell4 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(shell1 stopUpd:)
				(shell2 stopUpd:)
				(shell3 stopUpd:)
				(shell4 stopUpd:)
				(maid1 setCycle: ForwardCounter 2)
				(maid2 setCycle: ForwardCounter 2)
				(maid3 setCycle: ForwardCounter 2)
			)
			(8
				(if (> global131 1)
					(maid1 stopUpd:)
					(maid2 stopUpd:)
					(maid3 stopUpd:)
					(waterProp1 setCycle: Fwd)
					(waterProp2 setCycle: Fwd)
					(waterProp3 setCycle: Fwd)
				)
				(mary
					setLoop: 3
					setCel: 4
					illegalBits: $8000
					ignoreActors: 0
					stopUpd:
				)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(9
				(gGame setSpeed: global206)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(proc0_14 210 170)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local2 2)
		)
	)
)

(instance maryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mary
					setLoop: 0
					setCycle: Fwd
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 28 140 self
				)
			)
			(1
				(if (< global131 2)
					(gEgo setScript: musicScript)
				)
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 44 140 self)
			)
			(3
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 62 140 self)
			)
			(5
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 85 140 self)
			)
			(7
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(8
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 110 140 self)
			)
			(9
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 132 140 self)
			)
			(11
				(mary setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(mary setLoop: 0 setCycle: Rev setMotion: MoveTo 141 145 self)
			)
			(13
				(mary setCel: 0 stopUpd:)
			)
			(14
				(flower1 init: setCycle: End self)
			)
			(15
				(flower2 init: setCycle: End self)
			)
			(16
				(flower3 init: setCycle: End self)
			)
			(17
				(flower4 init: setCycle: End self)
			)
			(18
				(flower5 init: setCycle: End self)
			)
			(19
				(flower6 init: setCycle: End self)
			)
			(20
				(flower1 stopUpd:)
				(flower2 stopUpd:)
				(flower3 stopUpd:)
				(flower4 stopUpd:)
				(flower5 stopUpd:)
				(flower6 stopUpd:)
				(RedrawCast)
				(self dispose:)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 10
		priority 10
	)
)

(instance maryDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 74 setLoop: 3 setCel: 4 posn: 141 147 stopUpd:)
	)
)

(instance rake of View
	(properties)

	(method (init)
		(super init:)
		(self view: 74 setLoop: 3 setCel: 5 posn: 154 150 stopUpd:)
	)
)

(instance flower1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 28 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance flower2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 44 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance flower3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 62 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance flower4 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 85 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance flower5 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 110 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance flower6 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 132 140
			setLoop: 6
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance bell1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 72 103 setLoop: 4 setCel: 0 setPri: 7 stopUpd:)
	)
)

(instance bell2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 89 103 setLoop: 4 setCel: 1 setPri: 7 stopUpd:)
	)
)

(instance bell3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 107 103 setLoop: 4 setCel: 2 setPri: 7 stopUpd:)
	)
)

(instance bell4 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 125 103 setLoop: 4 setCel: 3 setPri: 7 stopUpd:)
	)
)

(instance bell5 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 143 103 setLoop: 4 setCel: 0 setPri: 7 stopUpd:)
	)
)

(instance maid1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			posn: 55 114
			setLoop: 7
			setCel: 0
			cycleSpeed: (if (> global131 1) 3 else 0)
			stopUpd:
		)
	)
)

(instance maid2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 40 121 setLoop: 8 setCel: 1 cycleSpeed: 6 stopUpd:)
	)
)

(instance maid3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 23 131 setLoop: 9 setCel: 0 cycleSpeed: 6 stopUpd:)
	)
)

(instance shell1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 49 130 setLoop: 5 setCel: 0 stopUpd:)
	)
)

(instance shell2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 80 130 setLoop: 5 setCel: 1 stopUpd:)
	)
)

(instance shell3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 112 130 setLoop: 5 setCel: 0 stopUpd:)
	)
)

(instance shell4 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 74 posn: 142 130 setLoop: 5 setCel: 1 stopUpd:)
	)
)

(instance waterProp1 of Prop
	(properties
		x 54
		y 191
		view 136
		loop 2
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance waterProp2 of Prop
	(properties
		x 14
		y 186
		view 136
		loop 1
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance waterProp3 of Prop
	(properties
		x 76
		y 191
		view 136
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 3 setCycle: Fwd)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self view: 57 setLoop: 1 setCel: 0 posn: 193 86 setPri: 15)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 190 111 setPri: 14 hide:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 15
			left: 10
			bottom: 81
			right: 209
			type: 4
			title: {Mary, Mary, Quite Contrary}
			back: 11
		)
	)
)

(instance gotItSound of Sound ; UNUSED
	(properties
		number 2
		priority 10
	)
)

(instance pointerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 0)
			)
			(1
				(= local1 1)
				(maid1 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(2
				(maid1 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(3
				(= local1 1)
				(maid2 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(4
				(maid2 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(5
				(= local1 1)
				(maid3 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 5)
			)
			(6
				(maid3 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(7
				(bellSound play: self)
				(= local1 1)
				(bell1 setCycle: Fwd)
			)
			(8
				(bell1 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(9
				(bellSound play: self)
				(= local1 1)
				(bell2 setCycle: Fwd)
			)
			(10
				(bell2 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(11
				(bellSound play: self)
				(= local1 1)
				(bell3 setCycle: Fwd)
			)
			(12
				(bell3 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(13
				(bellSound play: self)
				(= local1 1)
				(bell4 setCycle: Fwd)
			)
			(14
				(bell4 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(15
				(bellSound play: self)
				(= local1 1)
				(bell5 setCycle: Fwd)
			)
			(16
				(bell5 setCel: 0)
				(= state -1)
				(= cycles 1)
			)
			(17
				(shellSound play: self)
				(= local1 1)
				(shell1 setCycle: Fwd)
				(= cycles (Random 1 3))
			)
			(18
				(shell2 setCycle: Fwd)
				(= cycles (Random 1 3))
			)
			(19
				(shell3 setCycle: Fwd)
				(= cycles (Random 1 3))
			)
			(20)
			(21
				(shell1 setCycle: 0)
				(shell2 setCycle: 0)
				(shell3 setCycle: 0)
				(self init:)
			)
		)
	)
)

(instance mary of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 74
			setLoop: 2
			posn: 140 145
			setCycle: Fwd
			setStep:
				(if (> global131 1)
					3
					2
				else
					6
					4
				)
			cycleSpeed: 0
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
				(itemVisual dispose:)
			)
			(1
				(Display
					{Mary, Mary, quite contrary,}
					dsWIDTH
					320
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2
				(Display
					{How does your garden grow?}
					dsWIDTH
					320
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(bell1 setCycle: Fwd)
				(bell2 setCycle: Fwd)
				(bell3 setCycle: Fwd)
				(bell4 setCycle: Fwd)
				(bell5 setCycle: Fwd)
				(Display
					{_____With silver bells,}
					dsWIDTH
					320
					dsCOORD
					5
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(Display
					{_____And cockleshells,}
					dsWIDTH
					320
					dsCOORD
					5
					41
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
				(shell1 setCycle: Fwd)
				(shell2 setCycle: Fwd)
				(shell3 setCycle: Fwd)
				(shell4 setCycle: Fwd)
			)
			(5
				(Display
					{And pretty maids all in a row.}
					dsWIDTH
					320
					dsCOORD
					5
					53
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
				(shell1 stopUpd:)
				(shell2 stopUpd:)
				(shell3 stopUpd:)
				(shell4 stopUpd:)
				(if (> global131 1)
					(maid1 setCycle: ForwardCounter 2)
					(maid2 setCycle: ForwardCounter 2)
					(maid3 setCycle: ForwardCounter 2)
				)
			)
			(6
				(flower1 init: setCycle: End)
			)
			(7
				(flower2 init: setCycle: End)
			)
			(8
				(flower3 init: setCycle: End)
				(if (< global131 2)
					(= cycles 5)
				)
			)
			(9
				(flower4 init: setCycle: End)
				(if (< global131 2)
					(= cycles 5)
				)
			)
			(10
				(flower5 init: setCycle: End)
				(if (< global131 2)
					(= cycles 5)
				)
			)
			(11
				(flower6 init: setCycle: End)
				(if (< global131 2)
					(= cycles 5)
				)
			)
			(12
				(bell1 stopUpd:)
				(bell2 stopUpd:)
				(bell3 stopUpd:)
				(bell4 stopUpd:)
				(bell5 stopUpd:)
				(rhymeScript changeState: 8)
				(maryScript changeState: 20)
				(self dispose:)
			)
		)
	)

	(method (doit &tmp [temp0 40])
		(super doit:)
		(if (and (== local2 2) (== (rhymeScript state:) 4))
			(self changeState: 12)
		)
	)
)

(instance bellSound of Sound
	(properties
		number 55
		priority 10
	)
)

(instance shellSound of Sound
	(properties
		number 54
		priority 10
	)
)

