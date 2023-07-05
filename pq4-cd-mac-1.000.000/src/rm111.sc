;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use Interface)
(use Str)
(use Print)
(use Scaler)
(use Sound)
(use Motion)
(use Game)
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
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
)

(class TestActor of Actor
	(properties
		view 170
		number {x}
		forcedPri 0
		walkOn 1
	)
)

(instance theText of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance rm111 of Room
	(properties
		picture 170
		style 0
	)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(= local1 170)
		(gGlobalSound0 number: 0 stop:)
		(gGlobalSound1 number: 0 stop:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(act0 init:)
		(act1 init: setCycle: Walk hide:)
		(act2 init: setCycle: Walk hide:)
		(act3 init: setCycle: Walk hide:)
		(act4 init: setCycle: Walk hide:)
		(act5 init: setCycle: Walk hide:)
		(act6 init: setCycle: Walk hide:)
		(act7 init: setCycle: Walk hide:)
		(act8 init: setCycle: Walk hide:)
		(act9 init: setCycle: Walk hide:)
		(= local8 (gCast at: 0))
		(= local2 (Str new:))
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
		(= local14 gMouseX)
		(= local15 (- gMouseY 10))
		(if
			(and
				(local8 isKindOf: TestActor)
				(or
					local13
					(!= local4 (local8 cel:))
					(!= local5 (local8 x:))
					(!= local6 (local8 y:))
				)
			)
			(local2
				format:
					{%s: %d/%d/%d [%d,%d]}
					(local8 number:)
					(local8 view:)
					(local8 loop:)
					(local8 cel:)
					(local8 x:)
					(local8 y:)
			)
			(if (theText dialog:)
				((theText dialog:) dispose:)
			)
			(if local12
				(theText
					fore: 28
					back: 0
					modeless: 2
					posn: local10 local11
					font: 4
					addText: (local2 data:)
					init:
				)
			)
			(= local5 (local8 x:))
			(= local6 (local8 y:))
			(= local4 (local8 cel:))
			(= local13 0)
		)
		(if local9
			(local8 setMotion: 0 x: local14 y: local15)
			(if (and (local8 isKindOf: TestActor) (not (local8 forcedPri:)))
				(local8 priority: local15)
			)
		)
		(switch local20
			(1
				(= local16 -13)
				(= local17 0)
				(= local18 -26)
				(= local19 0)
				((gCurRoom plane:)
					setRect:
						(+ ((gCurRoom plane:) left:) local16)
						(+ ((gCurRoom plane:) top:) local17)
						(+ ((gCurRoom plane:) right:) local16)
						(+ ((gCurRoom plane:) bottom:) local17)
				)
				(UpdatePlane (gCurRoom plane:))
			)
			(2
				(= local16 13)
				(= local17 0)
				(= local18 26)
				(= local19 0)
				((gCurRoom plane:)
					setRect:
						(+ ((gCurRoom plane:) left:) local16)
						(+ ((gCurRoom plane:) top:) local17)
						(+ ((gCurRoom plane:) right:) local16)
						(+ ((gCurRoom plane:) bottom:) local17)
				)
				(UpdatePlane (gCurRoom plane:))
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(cond
			((event claimed:))
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_ALT_s
						(if (local8 scaler:)
							(Printf
								{%s Scaler %d %d %d %d}
								(local8 name:)
								((local8 scaler:) frontSize:)
								((local8 scaler:) backSize:)
								((local8 scaler:) frontY:)
								((local8 scaler:) backY:)
							)
							(= temp1 (GetNumber {frontSize?}))
							(= temp2 (GetNumber {backSize?}))
							(= temp3 (GetNumber {frontY?}))
							(= temp4 (GetNumber {backY?}))
							(local8 setScaler: Scaler temp1 temp2 temp3 temp4)
						)
					)
					(KEY_w
						(if (> (++ local12) 4)
							(= local12 0)
						)
						(switch local12
							(1
								(= local10 0)
								(= local11 0)
							)
							(2
								(= local10 300)
								(= local11 0)
							)
							(3
								(= local10 0)
								(= local11 189)
							)
							(4
								(= local10 300)
								(= local11 189)
							)
						)
						(= local13 1)
					)
					(KEY_ALT_t
						(gCurRoom newRoom: (GetNumber {Teleport to:}))
					)
					(KEY_p
						(if (!= (= temp0 (GetNumber {Pic #?})) -1)
							(gCurRoom drawPic: temp0)
							(FrameOut)
						)
						(cond
							((== temp0 512)
								(local8 setScaler: Scaler 140 43 154 79)
							)
							((and (== temp0 115) (== (act0 view:) 9120))
								(local8
									scaleY: (/ (* (act0 scaleY:) 130) 100)
									scaleX: (/ (* (act0 scaleX:) 130) 100)
									setScaler: 0
									scaleSignal: 1
								)
							)
							(else
								(local8 setScale: 0)
							)
						)
					)
					(KEY_v
						(if (!= (= local1 (GetNumber {View #?})) -1)
							(local8 view: local1)
							(UpdateScreenItem local8)
							(= local13 1)
						)
					)
					(KEY_ALT_v
						(= temp0 (GetNumber {new volume (0 127)?}))
						(DoAudio audVOLUME temp0 sfx)
					)
					(KEY_ALT_m)
					(KEY_e
						(local8 setCycle: End)
					)
					(KEY_b
						(local8 setCycle: Beg)
					)
					(KEY_f
						(local8 setCycle: Fwd)
					)
					(KEY_l
						((gCast at: (gCast indexOf: local8))
							loop:
								(if
									(==
										((gCast at: (gCast indexOf: local8))
											loop:
										)
										((gCast at: (gCast indexOf: local8))
											lastLoop:
										)
									)
									0
								else
									(+
										((gCast at: (gCast indexOf: local8))
											loop:
										)
										1
									)
								)
						)
						(FrameOut)
						(= local13 1)
					)
					(KEY_h
						(if (& (local8 signal:) $0008)
							(local8 show:)
						else
							(local8 hide:)
						)
						(FrameOut)
						(= local13 1)
					)
					(KEY_t)
					(KEY_i
						(Printf
							{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
							((gCast at: (gCast indexOf: local8)) name:)
							(((gCast at: (gCast indexOf: local8)) -super-:)
								name:
							)
							((gCast at: (gCast indexOf: local8)) view:)
							((gCast at: (gCast indexOf: local8)) loop:)
							((gCast at: (gCast indexOf: local8)) cel:)
							((gCast at: (gCast indexOf: local8)) x:)
							((gCast at: (gCast indexOf: local8)) y:)
							((gCast at: (gCast indexOf: local8)) z:)
							((gCast at: (gCast indexOf: local8)) heading:)
							((gCast at: (gCast indexOf: local8)) priority:)
							((gCast at: (gCast indexOf: local8)) signal:)
						)
					)
					(KEY_k
						(if (local8 walkOn:)
							(local8 walkOn: 0 setCycle: 0)
						else
							(local8 walkOn: 1)
						)
					)
					(KEY_s
						(switch local20
							(0
								(= local20 1)
							)
							(1
								(= local20 2)
							)
							(2
								(= local20 0)
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
						(gTheIconBar disable:)
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
						(if (not (local8 forcedPri:))
							(local8
								priority: (GetNumber {Priority #?})
								forcedPri: 1
							)
						else
							(local8 priority: local15 forcedPri: 0)
						)
						(FrameOut)
					)
					(KEY_ALT_b
						(= temp5 (local8 cel:))
						(if (> (-- temp5) -1)
							(local8 cel: temp5)
						else
							(= temp5 (local8 lastCel:))
							(local8 cel: temp5)
						)
						(FrameOut)
						(= local13 1)
					)
					(else
						(cond
							((OneOf (event message:) KEY_ALT_x KEY_q KEY_ALT_q KEY_CONTROL)
								(gGame quitGame:)
							)
							((OneOf (event message:) KEY_ALT_c KEY_c KEY_n KEY_ALT_n)
								((gCast at: (gCast indexOf: local8))
									cel:
										(if
											(==
												((gCast
														at:
															(gCast
																indexOf: local8
															)
													)
													cel:
												)
												((gCast
														at:
															(gCast
																indexOf: local8
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
																indexOf: local8
															)
													)
													cel:
												)
												1
											)
										)
								)
								(FrameOut)
								(= local13 1)
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
								(= local8
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
								(local8 show:)
								(UpdateScreenItem local8)
								(= local13 1)
							)
						)
					)
				)
			)
			((== (event type:) evMOUSEBUTTON)
				(cond
					((& (event modifiers:) $000b) ; emALT | emSHIFT
						(if (= local7 (gCast firstTrue: #onMe event))
							(= local8 local7)
							(= local13 1)
						else
							(= local7 0)
						)
					)
					((& (event modifiers:) emCTRL)
						(= local9 1)
					)
					(else
						(local8 setMotion: MoveTo local14 local15)
					)
				)
				(event claimed: 1)
				(return)
			)
			((== (event type:) evMOUSERELEASE)
				(= local9 0)
			)
			(else
				(gGame handleEvent: event)
			)
		)
	)

	(method (cue)
		(sfx pause: 0)
	)
)

(instance act1 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {1}
	)
)

(instance act2 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {2}
	)
)

(instance act3 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {3}
	)
)

(instance act4 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {4}
	)
)

(instance act5 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {5}
	)
)

(instance act6 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {6}
	)
)

(instance act7 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {7}
	)
)

(instance act8 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {8}
	)
)

(instance act9 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {9}
	)
)

(instance act0 of TestActor
	(properties
		x 160
		y 100
		fixPriority 1
		signal 24609
		number {0}
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance sfx2 of Sound ; UNUSED
	(properties
		flags 5
	)
)

(instance testScr of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(switch (GetNumber {1-12?})
					(1
						(PalVary 4 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryTarget
					)
					(2
						(PalVary 2 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryInfo
					)
					(3
						(PalVary 7 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryNewTarget
					)
					(4
						(PalVary 8 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryNewSource
					)
					(5
						(PalVary 9 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryMergeSource
					)
					(6
						(PalVary 8 170) ; PalVaryNewSource
					)
					(7
						(PalVary 8 999) ; PalVaryNewSource
					)
					(8
						(gGame doRemap: 2 243 150 2)
					)
					(9
						(PalVary 4 170) ; PalVaryTarget
					)
					(10
						(PalVary 9 170) ; PalVaryMergeSource
					)
					(11
						(PalVary 7 170) ; PalVaryNewTarget
					)
					(12
						(PalVary 3) ; PalVaryKill
					)
				)
				(FrameOut)
				(= seconds 2)
				(-- state)
			)
		)
	)
)

