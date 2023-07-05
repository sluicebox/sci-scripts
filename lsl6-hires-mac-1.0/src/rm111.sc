;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use fileScr)
(use n082)
(use LarryRoom)
(use Interface)
(use Str)
(use Print)
(use Scaler)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm111 0
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
	local12
	local13
	local14 = 900
	local15
	local16
	local17
	local18
	local19
	local20
)

(class TestActor of Actor
	(properties
		number {x}
		forcedPri 0
		walkOn 1
	)
)

(instance theText of Print
	(properties
		doBorder 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance rm111 of LarryRoom
	(properties
		autoLoad 0
		showControls 1
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(gGlobalSound1 number: 0 stop:)
		(gGlobalSound2 number: 0 stop:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(act0 init: setCycle: Walk)
		(act1 init: setCycle: Walk hide:)
		(act2 init: setCycle: Walk hide:)
		(act3 init: setCycle: Walk hide:)
		(act4 init: setCycle: Walk hide:)
		(act5 init: setCycle: Walk hide:)
		(act6 init: setCycle: Walk hide:)
		(act7 init: setCycle: Walk hide:)
		(act8 init: setCycle: Walk hide:)
		(act9 init: setCycle: Walk hide:)
		(= local6 (gCast at: 0))
		(= local0 (Str new:))
		(gGame setCursor: gNormalCursor)
	)

	(method (doVerb))

	(method (newRoom newRoomNumber)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (theText dialog:)
			(InspectObject (theText dialog:))
			((theText dialog:) dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(= local12 gMouseX)
		(= local13 (- gMouseY 10))
		(if
			(or
				local11
				(!= local2 (local6 cel:))
				(!= local3 (local6 x:))
				(!= local4 (local6 y:))
			)
			(local0
				format:
					{%s: %d/%d/%d [%d,%d]}
					(local6 number:)
					(local6 view:)
					(local6 loop:)
					(local6 cel:)
					(local6 x:)
					(local6 y:)
			)
			(if (theText dialog:)
				((theText dialog:) dispose:)
			)
			(if local10
				(theText
					modeless: 2
					fore: 7
					back: 0
					posn: local8 local9
					font: 999
					addText: (local0 data:)
					init:
				)
			)
			(= local3 (local6 x:))
			(= local4 (local6 y:))
			(= local2 (local6 cel:))
			(= local11 0)
		)
		(if local7
			(local6 setMotion: 0 x: local12 y: local13)
			(if (not (local6 forcedPri:))
				(local6 priority: local13)
			)
		)
		(switch local19
			(1
				(= local15 -13)
				(= local16 0)
				(= local17 -26)
				(= local18 0)
				((gCurRoom plane:)
					setRect:
						(+ ((gCurRoom plane:) left:) local15)
						(+ ((gCurRoom plane:) top:) local16)
						(+ ((gCurRoom plane:) right:) local15)
						(+ ((gCurRoom plane:) bottom:) local16)
				)
				(UpdatePlane (gCurRoom plane:))
			)
			(2
				(= local15 13)
				(= local16 0)
				(= local17 26)
				(= local18 0)
				((gCurRoom plane:)
					setRect:
						(+ ((gCurRoom plane:) left:) local15)
						(+ ((gCurRoom plane:) top:) local16)
						(+ ((gCurRoom plane:) right:) local15)
						(+ ((gCurRoom plane:) bottom:) local16)
				)
				(UpdatePlane (gCurRoom plane:))
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_w
						(if (> (++ local10) 4)
							(= local10 0)
						)
						(switch local10
							(1
								(= local8 0)
								(= local9 0)
							)
							(2
								(= local8 300)
								(= local9 0)
							)
							(3
								(= local8 0)
								(= local9 189)
							)
							(4
								(= local8 300)
								(= local9 189)
							)
						)
						(= local11 1)
					)
					(KEY_ALT_t
						(gCurRoom newRoom: (GetNumber {Teleport to:}))
					)
					(KEY_a
						(Printf {DoAudio AudPlay 0 LARRY N TAKE ALL 1})
						(DoAudio audPLAY 0 2 5 0 1)
						(Printf {DoAudio AudPlay 0 LARRY N TOWEL ALL 1})
						(DoAudio audPLAY 0 2 56 0 1)
					)
					(KEY_p
						(if (!= (= temp0 (GetNumber {Pic #?})) -1)
							(gCurRoom drawPic: temp0)
							(FrameOut)
						)
					)
					(KEY_v
						(if (!= (= local14 (GetNumber {View #?})) -1)
							(local6 view: local14)
							(UpdateScreenItem local6)
							(= local11 1)
						)
					)
					(KEY_d
						(gCurRoom setScript: egoDeadScr)
					)
					(KEY_e
						(local6 setCycle: End)
					)
					(KEY_b
						(local6 setCycle: Beg)
					)
					(KEY_f
						(local6 setCycle: Fwd)
					)
					(KEY_l
						((gCast at: (gCast indexOf: local6))
							loop:
								(if
									(==
										((gCast at: (gCast indexOf: local6))
											loop:
										)
										((gCast at: (gCast indexOf: local6))
											lastLoop:
										)
									)
									0
								else
									(+
										((gCast at: (gCast indexOf: local6))
											loop:
										)
										1
									)
								)
						)
						(FrameOut)
						(= local11 1)
					)
					(KEY_h
						(if (& (local6 signal:) $0008)
							(local6 show:)
						else
							(local6 hide:)
						)
						(FrameOut)
						(= local11 1)
					)
					(KEY_t
						(if (not (gCurRoom script:))
							(gCurRoom setScript: testTalkersScr)
						else
							(gCurRoom setScript: 0)
						)
					)
					(KEY_i
						(Printf
							{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
							((gCast at: (gCast indexOf: local6)) name:)
							(((gCast at: (gCast indexOf: local6)) -super-:)
								name:
							)
							((gCast at: (gCast indexOf: local6)) view:)
							((gCast at: (gCast indexOf: local6)) loop:)
							((gCast at: (gCast indexOf: local6)) cel:)
							((gCast at: (gCast indexOf: local6)) x:)
							((gCast at: (gCast indexOf: local6)) y:)
							((gCast at: (gCast indexOf: local6)) z:)
							((gCast at: (gCast indexOf: local6)) heading:)
							((gCast at: (gCast indexOf: local6)) priority:)
							((gCast at: (gCast indexOf: local6)) signal:)
						)
					)
					(KEY_k
						(if (local6 walkOn:)
							(local6 walkOn: 0 setCycle: 0)
						else
							(local6 walkOn: 1 setCycle: Walk)
						)
					)
					(KEY_s
						(switch local19
							(0
								(= local19 1)
							)
							(1
								(= local19 2)
							)
							(2
								(= local19 0)
							)
						)
					)
					(KEY_PAUSE
						(if (sfx handle:)
							(sfx number: 0 loop: 1 stop:)
						else
							(sfx
								number: (GetNumber {Sound #?})
								loop: (GetNumber {loop?} 1)
								play:
							)
						)
					)
					(JOY_RIGHT
						(gGame hideControls:)
						(UpdatePlane
							(gThePlane setRect: 0 0 320 210 drawPic: -1 yourself:)
						)
					)
					(KEY_SHIFT
						(if (sfx number:)
							(sfx play:)
						)
					)
					(KEY_F9
						(if (not (local6 forcedPri:))
							(local6
								priority: (GetNumber {Priority #?})
								forcedPri: 1
							)
						else
							(local6 priority: local13 forcedPri: 0)
						)
						(FrameOut)
					)
					(KEY_ALT_b
						(= temp1 (local6 cel:))
						(if (> (-- temp1) -1)
							(local6 cel: temp1)
						else
							(= temp1 (local6 lastCel:))
							(local6 cel: temp1)
						)
						(FrameOut)
						(= local11 1)
					)
					(else
						(cond
							((OneOf (event message:) KEY_ALT_x KEY_q KEY_ALT_q KEY_CONTROL)
								(gGame quitGame:)
							)
							((OneOf (event message:) KEY_c KEY_n KEY_ALT_n)
								((gCast at: (gCast indexOf: local6))
									cel:
										(if
											(==
												((gCast
														at:
															(gCast
																indexOf: local6
															)
													)
													cel:
												)
												((gCast
														at:
															(gCast
																indexOf: local6
															)
													)
													lastCel:
												)
											)
											0
										else
											(+
												((gCast
														at:
															(gCast
																indexOf: local6
															)
													)
													cel:
												)
												1
											)
										)
								)
								(FrameOut)
								(= local11 1)
							)
							(
								(OneOf
									(event message:)
									KEY_0
									KEY_1
									KEY_2
									KEY_3
									KEY_4
									KEY_5
									KEY_6
									KEY_7
									KEY_8
									KEY_9
								)
								(= local6
									(gCast
										at:
											(switch (event message:)
												(KEY_0 0)
												(KEY_1 1)
												(KEY_2 2)
												(KEY_3 3)
												(KEY_4 4)
												(KEY_5 5)
												(KEY_6 6)
												(KEY_7 7)
												(KEY_8 8)
												(KEY_9 9)
											)
									)
								)
								(local6 show:)
								(UpdateScreenItem local6)
								(= local11 1)
							)
							(else
								(super handleEvent: event)
							)
						)
					)
				)
				(event claimed: 1)
				(return)
			)
			((== (event type:) evMOUSEBUTTON)
				(cond
					((& (event modifiers:) $000b) ; emALT | emSHIFT
						(if (= local5 (gCast firstTrue: #onMe event))
							(= local6 local5)
							(= local11 1)
						else
							(= local5 0)
						)
					)
					((& (event modifiers:) emCTRL)
						(= local7 1)
					)
					(else
						(local6 setMotion: MoveTo local12 local13)
					)
				)
				(event claimed: 1)
				(return)
			)
			((== (event type:) evMOUSERELEASE)
				(= local7 0)
			)
			(else
				(gGame handleEvent: event)
			)
		)
	)
)

(instance act1 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {1}
	)
)

(instance act2 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {2}
	)
)

(instance act3 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {3}
	)
)

(instance act4 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {4}
	)
)

(instance act5 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {5}
	)
)

(instance act6 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {6}
	)
)

(instance act7 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {7}
	)
)

(instance act8 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {8}
	)
)

(instance act9 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 24609
		number {9}
	)
)

(instance act0 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		view 900
		signal 24609
		number {0}
	)
)

(instance testTalkersScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not global205)
					(proc79_6 1592)
				)
				(= ticks 30)
			)
			(1
				(gMessager say: 0 0 0 35 self) ; "Carlos talker blah blah blah blah blah blah blah"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance egoDeadScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoDead 18 self)
			)
			(1
				(EgoDead 16 self)
			)
			(2
				(EgoDead 1 self)
			)
			(3
				(EgoDead 4 self)
			)
			(4
				(EgoDead 7 self)
			)
			(5
				(EgoDead 20 self)
			)
			(6
				(EgoDead 8 self)
			)
			(7
				(EgoDead 9 self)
			)
			(8
				(EgoDead 10 self)
			)
			(9
				(EgoDead 5 self)
			)
			(10
				(EgoDead 12 self)
			)
			(11
				(EgoDead 13 self)
			)
			(12
				(EgoDead 14 self)
			)
			(13
				(EgoDead 6 self)
			)
			(14
				(EgoDead 11 self)
			)
			(15
				(EgoDead 19 self)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance testScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(act0
					view: 900
					setLoop: 8 1
					cel: 1
					x: 85
					y: 107
					setScaler: Scaler 100 67 129 88
				)
				(= seconds 3)
			)
			(1
				(act0 view: 342 setLoop: 0 1 setScale: 0 cel: 0)
				(= seconds 2)
			)
			(2
				(act0 setCycle: End self)
			)
			(3
				(act0 setCycle: Beg self)
			)
			(4
				(act0
					view: 900
					setLoop: 8 1
					cel: 1
					setScaler: Scaler 100 67 129 88
				)
				(self dispose:)
			)
		)
	)
)

