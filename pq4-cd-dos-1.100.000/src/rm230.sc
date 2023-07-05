;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use Styler)
(use DText)
(use Str)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm230 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(instance rm230 of Room
	(properties
		picture 230
	)

	(method (init)
		(gGame handsOn:)
		(gTheIconBar enable:)
		(bigT1 init:)
		(bigT2 init:)
		(bigT3 init:)
		(bigT4 init:)
		(smallT1 init:)
		(smallT2 init:)
		(body init:)
		(arms init:)
		(gTheIconBar disable: 0 2 1 3)
		(gGame setCursor: gTheArrowCursor 1)
		(= local6 1)
		(if
			(and
				(gTheIconBar curInvIcon:)
				(!= (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
			)
			(gTheIconBar curInvIcon: 0 disable: 4 show: 0)
		)
		(gGlobalSound0 number: 210 setLoop: -1 play:)
		(super init: &rest)
		((gInventory at: 11) owner: 230) ; handgun
		((gInventory at: 38) owner: 230) ; ammoBox
		(self setScript: sEnter)
		(Styler divisions: 15 priority: 100)
	)

	(method (dispose)
		(Styler priority: 300)
		((gInventory at: 11) owner: gEgo) ; handgun
		((gTheIconBar useIconItem:) cursorView: ((gInventory at: 11) cursorView:)) ; handgun
		((gInventory at: 38) owner: 230) ; ammoBox
		(SetCursor -2)
		(gGlobalSound0 fade: 0 4 2 1)
		(local2 release: dispose:)
		(super dispose:)
	)

	(method (doit)
		(if (!= gTheCursor gTheArrowCursor)
			(gGame setCursor: gTheArrowCursor)
		)
		(super doit:)
		(if global156
			(= global156 0)
			(= local7 1)
			(if local8
				(if local6
					(SetCursor 50 80 260 200)
				else
					(SetCursor 50 34 260 200)
				)
				(gTheCursor hide: posn: (gun x:) (- (gun y:) 2))
			else
				(gTheCursor show:)
			)
		)
	)
)

(instance gun of Actor
	(properties
		x 160
		y 145
		priority 125
		fixPriority 1
		view 233
		yStep 4
		moveSpeed 0
	)

	(method (init)
		(|= signal $4000)
		(super init: &rest)
		(SetCursor 50 80 260 200)
		(gTheCursor hide: posn: x (- y 2))
		((gInventory at: 11) state: 16) ; handgun
	)

	(method (doit)
		(cond
			(mover
				(mover doit:)
			)
			((not global156)
				(if local7
					(-- local7)
				else
					(= x gMouseX)
					(= y (Min 148 (+ gMouseY 2)))
				)
			)
		)
		(UpdateScreenItem self)
	)
)

(instance bigT1 of Prop
	(properties
		x 31
		y 32
		priority 200
		fixPriority 1
		view 232
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance bigT2 of Prop
	(properties
		x 285
		y 32
		priority 200
		fixPriority 1
		view 232
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance bigT3 of Prop
	(properties
		x 31
		y 92
		priority 200
		fixPriority 1
		view 232
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance bigT4 of Prop
	(properties
		x 285
		y 92
		priority 200
		fixPriority 1
		view 232
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance smallT1 of Prop
	(properties
		x 118
		y 85
		priority 3
		fixPriority 1
		view 232
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance smallT2 of Prop
	(properties
		x 157
		y 85
		priority 3
		fixPriority 1
		view 232
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance bulletHole of View
	(properties)

	(method (new param1 &tmp temp0 temp1)
		(if (and local4 (local4 onMe: param1))
			(= temp0 (Clone self))
			(SetNowSeen local4)
			(SetNowSeen local5)
			(temp0
				x:
					(+
						(local5 nsLeft:)
						(*
							(/
								(- (local5 nsRight:) (local5 nsLeft:))
								(- (local4 nsRight:) (local4 nsLeft:))
							)
							(+ (- (param1 x:) (local4 nsLeft:)) 1)
						)
						(Random 0 3)
					)
			)
			(temp0
				y:
					(+
						(local5 nsTop:)
						(*
							(/
								(- (local5 nsBottom:) (local5 nsTop:))
								(- (local4 nsBottom:) (local4 nsTop:))
							)
							(+ (- (param1 y:) (local4 nsTop:)) 1)
						)
						(Random 0 3)
					)
			)
			(temp0
				view: 232
				loop: 2
				cel: 0
				priority: (+ (local5 priority:) 1)
				ignoreActors:
				fixPriority: 1
				init:
			)
			(body x: (local5 x:) y: (local5 y:))
			(arms x: (local5 x:) y: (+ (local5 y:) 1))
			(UpdateScreenItem body)
			(UpdateScreenItem arms)
			(FrameOut)
			(cond
				((arms onMe: temp0)
					(+= local11 5)
				)
				((body onMe: temp0)
					(+= local11 10)
				)
			)
			(if local10
				(local10 dispose:)
			)
			(= temp1 (Str new: 10))
			(temp1 format: {%d} local11)
			(= local10
				((DText new:)
					text: (KString 8 (temp1 data:)) ; StrDup
					font: 230
					mode: 1
					fore: 22
					back: 0
					skip: 0
					setSize:
					view: 232
					loop: 3
					cel: 0
					fixPriority: 1
					priority: 300
					moveTo: 10 126
					textTop: 4
					textLeft: 8
					textRight: 60
					textBottom: 20
					init:
				)
			)
			(temp1 dispose:)
		)
	)

	(method (init)
		(super init:)
		(local2 add: self)
	)

	(method (dispose)
		(local2 delete: self)
		(super dispose:)
	)
)

(instance pullGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 8 0 self) ; "All firearms to low ready."
			)
			(1
				(if (< register 2)
					(++ register)
					(= ticks 600)
				else
					(= ticks 300)
				)
			)
			(2
				(if (== register 2)
					(gTheIconBar enable: 4 curInvIcon: (gInventory at: 11) show: 0) ; handgun
					(gTheCursor hide: posn: (gun x:) (- (gun y:) 2))
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (gTheIconBar curInvIcon:)
			(self dispose:)
		)
	)
)

(instance reload of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 9 0 self) ; "Officers, reload."
			)
			(1
				(= ticks 600)
			)
			(2
				((gInventory at: 11) state: 16) ; handgun
				(gMessager say: 1 2 10 0 self) ; "You reload your Beretta."
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (== ((gInventory at: 11) state:) 16) ; handgun
			(self dispose:)
		else
			(super doit:)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (init)
		(if argc
			(gMouseDownHandler addToFront: self)
			((= local2 (List new:)) add:)
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (or (not local4) (and local4 (local4 cycler:)))
			(event claimed: 1)
			(return)
		)
		(if (OneOf (event type:) evMOUSEBUTTON evKEYBOARD $0020) ; joyUp
			(++ register)
			((gInventory at: 11) state: (- ((gInventory at: 11) state:) 1)) ; handgun, handgun
			(bulletHole new: event)
			(if (== register local3)
				(= register 0)
				(if script
					(self setScript: 0)
				)
			)
			(gun
				x: (+ (gun x:) (Random 0 2))
				y: (- (gun y:) (Random 0 (Max 3 (- 10 gHowFast))))
			)
			(UpdateScreenItem gun)
			((= temp0 (View new:))
				view: 233
				loop: 1
				cel: 0
				x: (gun x:)
				y: (gun y:)
				signal: (gun signal:)
				priority: (+ (gun priority:) 1)
				init:
			)
			(gGlobalSound1 number: 926 setLoop: 1 play:)
			(temp0 dispose:)
			(FrameOut)
		)
		(while ((= event ((gUser curEvent:) new:)) type:)
		)
		(event claimed: 1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				0
				(if (gTheIconBar curInvIcon:)
					(= cycles 3)
				else
					(self setScript: pullGun self)
				)
			)
			(1
				1
				(= temp0 (Str new: 10))
				(temp0 format: {%d} local11)
				(= local10
					((DText new:)
						text: (KString 8 (temp0 data:)) ; StrDup
						font: 230
						mode: 1
						fore: 22
						back: 0
						skip: 0
						setSize:
						view: 232
						loop: 3
						cel: 0
						fixPriority: 1
						priority: 300
						moveTo: 10 126
						textTop: 4
						textLeft: 8
						textRight: 60
						textBottom: 20
						init:
					)
				)
				(temp0 dispose:)
				(= local8 1)
				(gun init:)
				(gGame doRemap: 2 253 140)
				(gGame doRemap: 2 254 120)
				(gMessager say: 1 2 1 0 self) ; "Phase One"
			)
			(2
				2
				(smallT1 scaleSignal: 0 x: 118 y: 85)
				(UpdateScreenItem smallT1)
				(smallT2 scaleSignal: 0 x: 157 y: 85)
				(UpdateScreenItem smallT2)
				(= cycles 10)
			)
			(3
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(4
				3
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 4)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 3 0)
			)
			(5
				4
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(6
				5
				(bigT2 setCycle: End clock)
				(smallT2 setCycle: End)
				(= local4 smallT2)
				(= local5 bigT2)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 1 5)
			)
			(7
				6
				(= local4 (= register 0))
				(smallT2 setCycle: Beg self)
			)
			(8
				7
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 11) ; "Gun to low ready. Prepare for phase two."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(9
				8
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
			)
			(10
				9
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
				(bigT2 setCycle: Beg)
			)
			(11
				10
				(gMessager say: 1 2 2 0 self) ; "Phase Two"
			)
			(12
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(13
				11
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 6)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 3 5)
			)
			(14
				12
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(15
				13
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 12) ; "Gun to low ready. Prepare for phase three."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(16
				14
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
			)
			(17
				15
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
			)
			(18
				16
				(if (!= ((gInventory at: 11) state:) 16) ; handgun
					(self setScript: reload self)
				else
					(self cue:)
				)
			)
			(19
				14
				(gMessager say: 1 2 3 0 self) ; "Phase Three"
			)
			(20
				15
				(gCurRoom drawPic: 232 9 1)
				(smallT1 x: 129 y: 77)
				(UpdateScreenItem smallT1)
				(smallT2 x: 173 y: 76)
				(UpdateScreenItem smallT2)
				(= cycles 2)
			)
			(21
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(22
				16
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 4)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 3 0)
			)
			(23
				17
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(24
				18
				(bigT2 setCycle: End clock)
				(smallT2 setCycle: End)
				(= local4 smallT2)
				(= local5 bigT2)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 1 5)
			)
			(25
				19
				(= local4 (= register 0))
				(smallT2 setCycle: Beg self)
			)
			(26
				20
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 13) ; "Gun to low ready. Prepare for phase four."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(27
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
			)
			(28
				21
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
				(bigT2 setCycle: Beg)
			)
			(29
				22
				(gMessager say: 1 2 4 0 self) ; "Phase Four"
			)
			(30
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(31
				23
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 2)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 2 0)
			)
			(32
				24
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(33
				25
				(bigT2 setCycle: End clock)
				(smallT2 setCycle: End)
				(= local4 smallT2)
				(= local5 bigT2)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 2 0)
			)
			(34
				26
				(= local4 (= register 0))
				(smallT2 setCycle: Beg self)
			)
			(35
				27
				(bigT3 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT3)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 2 0)
			)
			(36
				28
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(37
				29
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 14) ; "Gun to low ready. Prepare for phase five."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(38
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
			)
			(39
				30
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
				(bigT2 setCycle: Beg)
				(bigT3 setCycle: Beg)
			)
			(40
				(if (!= ((gInventory at: 11) state:) 16) ; handgun
					(self setScript: reload self)
				else
					(self cue:)
				)
			)
			(41
				31
				(gMessager say: 1 2 5 0 self) ; "Phase Five"
			)
			(42
				32
				(gCurRoom drawPic: 235 9 1)
				(smallT1 x: 139 y: 48 scaleSignal: 1 scaleX: 80 scaleY: 80)
				(UpdateScreenItem smallT1)
				(smallT2 x: 167 y: 48 scaleSignal: 1 scaleX: 80 scaleY: 80)
				(UpdateScreenItem smallT2)
				(= cycles 2)
			)
			(43
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(44
				33
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 10)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 30 0)
			)
			(45
				34
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(46
				35
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 15) ; "Gun to low ready. Prepare for phase six."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(47
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
			)
			(48
				36
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
			)
			(49
				37
				(gMessager say: 1 2 6 0 self) ; "Phase Six"
			)
			(50
				38
				(gCurRoom drawPic: 237 9 1)
				(smallT1 x: 143 y: 57 scaleSignal: 1 scaleX: 51 scaleY: 51)
				(UpdateScreenItem smallT1)
				(smallT2 x: 161 y: 57 scaleSignal: 1 scaleX: 51 scaleY: 51)
				(UpdateScreenItem smallT2)
				(= cycles 2)
			)
			(51
				(gMessager say: 1 2 16 0 self) ; "Ready on the right. Ready on the left. Attention!"
			)
			(52
				39
				(bigT1 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT1)
				(= local3 2)
				(= local6 0)
				(SetCursor 50 34 260 200)
				(self setScript: clock self 4 0)
			)
			(53
				40
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(54
				41
				(bigT2 setCycle: End clock)
				(smallT2 setCycle: End)
				(= local4 smallT2)
				(= local5 bigT2)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 4 0)
			)
			(55
				42
				(= local4 (= register 0))
				(smallT2 setCycle: Beg self)
			)
			(56
				43
				(bigT3 setCycle: End clock)
				(smallT1 setCycle: End)
				(= local4 smallT1)
				(= local5 bigT3)
				(= local3 2)
				(= local6 0)
				(self setScript: clock self 4 0)
			)
			(57
				44
				(= local4 (= register 0))
				(smallT1 setCycle: Beg self)
			)
			(58
				45
				(= local6 1)
				(SetCursor 50 80 260 200)
				(gMessager say: 1 2 7) ; "Holster all firearms."
				(gun setMotion: MoveTo (gun x:) 120 self)
			)
			(59
				(gTheCursor posn: (gun x:) (- (gun y:) 2))
				(= ticks 240)
				(gun dispose:)
			)
			(60
				46
				(= local4 0)
				(= local5 0)
				(local2 eachElementDo: #dispose release:)
				(bigT1 setCycle: Beg self)
				(bigT2 setCycle: Beg)
				(bigT3 setCycle: Beg)
			)
			(61
				(= cycles 3)
			)
			(62
				48
				(local0 dispose:)
				(local10 dispose:)
				(if (< local11 210)
					(gPqFlags clear: 164)
				else
					(gGame points: 4)
					(gPqFlags set: 164)
				)
				(FrameOut)
				(gGame doRemap: 2 254 75)
				(gCurRoom newRoom: 225)
			)
		)
	)
)

(instance clock of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(if argc
			(= local1 param4)
			(super init: param1 param2 param3)
		else
			(super init:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
				(if local0
					(local0 dispose:)
				)
			)
			(1
				(= temp0 (Str new: 10))
				(if (< register 10)
					(temp0 format: {0%d:%d} register local1)
				else
					(temp0 format: {%d:%d} register local1)
				)
				(= local0
					((DText new:)
						text: (KString 8 (temp0 data:)) ; StrDup
						font: 230
						mode: -1
						fore: 22
						back: 0
						skip: 0
						setSize:
						view: 232
						loop: 3
						cel: 0
						fixPriority: 1
						priority: 300
						moveTo: 265 126
						textTop: 4
						textLeft: 5
						textRight: 60
						textBottom: 20
						init:
					)
				)
				(temp0 dispose:)
			)
			(2
				(local0 dispose:)
				(= temp0 (Str new: 10))
				(if (< register 10)
					(temp0 format: {0%d:%d} register local1)
				else
					(temp0 format: {%d:%d} register local1)
				)
				(= local0
					((DText new:)
						text: (KString 8 (temp0 data:)) ; StrDup
						font: 230
						mode: -1
						fore: 22
						back: 0
						skip: 0
						setSize:
						view: 232
						loop: 3
						cel: 0
						fixPriority: 1
						priority: 300
						moveTo: 265 126
						textTop: 4
						textLeft: 5
						textRight: 60
						textBottom: 20
						init:
					)
				)
				(temp0 dispose:)
				(= ticks 6)
			)
			(3
				(cond
					(register
						(if (not local1)
							(-- register)
							(= local1 9)
						else
							(-- local1)
						)
						(= state 1)
						(self cue:)
					)
					(local1
						(-- local1)
						(= state 1)
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance body of View
	(properties
		x -50
		y -50
		fixPriority 1
		view 232
		loop 4
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)
)

(instance arms of View
	(properties
		x -50
		y -50
		z 1
		priority 1
		fixPriority 1
		view 232
		loop 4
		cel 1
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)
)

(instance doScore of Code ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(body x: (bigT1 x:) y: (bigT1 y:) init:)
		(arms x: (bigT1 x:) y: (bigT1 y:) init:)
		(= temp0 0)
		(FrameOut)
		(while (< temp0 (local2 size:))
			(cond
				((body onMe: (local2 at: temp0))
					(+= local11 10)
				)
				((arms onMe: (local2 at: temp0))
					(+= local11 5)
				)
			)
			(++ temp0)
		)
		(body x: (bigT2 x:) y: (bigT2 y:))
		(arms x: (bigT2 x:) y: (bigT2 y:))
		(UpdateScreenItem body)
		(UpdateScreenItem arms)
		(FrameOut)
		(for ((= temp0 0)) (< temp0 (local2 size:)) ((++ temp0))
			(cond
				((body onMe: (local2 at: temp0))
					(+= local11 10)
				)
				((arms onMe: (local2 at: temp0))
					(+= local11 5)
				)
			)
		)
		(body x: (bigT3 x:) y: (bigT3 y:))
		(arms x: (bigT3 x:) y: (bigT3 y:))
		(UpdateScreenItem body)
		(UpdateScreenItem arms)
		(FrameOut)
		(for ((= temp0 0)) (< temp0 (local2 size:)) ((++ temp0))
			(cond
				((body onMe: (local2 at: temp0))
					(+= local11 10)
				)
				((arms onMe: (local2 at: temp0))
					(+= local11 5)
				)
			)
		)
		(body x: (bigT4 x:) y: (bigT4 y:))
		(arms x: (bigT4 x:) y: (bigT4 y:))
		(UpdateScreenItem body)
		(UpdateScreenItem arms)
		(FrameOut)
		(for ((= temp0 0)) (< temp0 (local2 size:)) ((++ temp0))
			(cond
				((body onMe: (local2 at: temp0))
					(+= local11 10)
				)
				((arms onMe: (local2 at: temp0))
					(+= local11 5)
				)
			)
		)
		(if local10
			(local10 dispose:)
		)
		(= temp0 (Str new: 10))
		(temp0 format: {%d} local11)
		(= local10
			((DText new:)
				text: (KString 8 (temp0 data:)) ; StrDup
				font: 230
				mode: 1
				fore: 22
				back: 0
				skip: 0
				setSize:
				view: 232
				loop: 3
				cel: 0
				fixPriority: 1
				priority: 300
				moveTo: 5 126
				textTop: 4
				textLeft: 5
				textRight: 60
				textBottom: 20
				init:
			)
		)
		(temp0 dispose:)
		(body dispose:)
		(arms dispose:)
	)
)

