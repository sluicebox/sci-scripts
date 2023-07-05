;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use GloryRm)
(use Interface)
(use Print)
(use Actor)
(use System)

(public
	rm111 0
)

(local
	local0
	local1
	local2
)

(instance rm111 of GloryRm
	(properties
		picture 0
	)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(SetFlag 50)
		(act0 init:)
		(act1 init: hide:)
		(act2 init: hide:)
		(act3 init: hide:)
		(act4 init: hide:)
		(act5 init: hide:)
		(act6 init: hide:)
		(act7 init: hide:)
		(act8 init: hide:)
		(act9 init: hide:)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(UpdatePlane (plane back: 0 picture: -1 yourself:))
		(RemapColors 2 254 50) ; ByPercent
		(= local1 (gCast at: 0))
	)

	(method (doit)
		(if local2
			(local1 x: gMouseX y: (- gMouseY 10))
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			((== (event type:) evKEYBOARD)
				(cond
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
						(= local1
							(gCast
								at:
									(switch (event message:)
										(KEY_1 0)
										(KEY_2 1)
										(KEY_3 2)
										(KEY_4 3)
										(KEY_5 4)
										(KEY_6 5)
										(KEY_7 6)
										(KEY_8 7)
										(KEY_9 8)
										(KEY_0 10)
									)
							)
						)
						(local1 show:)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_p KEY_P)
						(gCurRoom drawPic: (GetNumber {Pic #?}))
						(FrameOut)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_v KEY_V)
						(local1 view: (GetNumber {View #?}))
						(FrameOut)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_F9)
						(local1 priority: (GetNumber {Priority #?}))
						(FrameOut)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_l KEY_L)
						((gCast at: (gCast indexOf: local1))
							loop:
								(if
									(==
										((gCast at: (gCast indexOf: local1))
											loop:
										)
										((gCast at: (gCast indexOf: local1))
											lastLoop:
										)
									)
									0
								else
									(+
										((gCast at: (gCast indexOf: local1))
											loop:
										)
										1
									)
								)
						)
						(FrameOut)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_c KEY_C)
						((gCast at: (gCast indexOf: local1))
							cel:
								(if
									(==
										((gCast at: (gCast indexOf: local1))
											cel:
										)
										((gCast at: (gCast indexOf: local1))
											lastCel:
										)
									)
									0
								else
									(+
										((gCast at: (gCast indexOf: local1))
											cel:
										)
										1
									)
								)
						)
						(FrameOut)
						(event claimed: 1)
						(return)
					)
					((OneOf (event message:) KEY_i KEY_I)
						(Printf
							{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
							((gCast at: (gCast indexOf: local1)) name:)
							(((gCast at: (gCast indexOf: local1)) -super-:)
								name:
							)
							((gCast at: (gCast indexOf: local1)) view:)
							((gCast at: (gCast indexOf: local1)) loop:)
							((gCast at: (gCast indexOf: local1)) cel:)
							((gCast at: (gCast indexOf: local1)) x:)
							((gCast at: (gCast indexOf: local1)) y:)
							((gCast at: (gCast indexOf: local1)) z:)
							((gCast at: (gCast indexOf: local1)) heading:)
							((gCast at: (gCast indexOf: local1)) priority:)
							((gCast at: (gCast indexOf: local1)) signal:)
						)
						(event claimed: 1)
						(return)
					)
					(else
						(event claimed: 1)
						(return)
					)
				)
			)
			((== (event type:) evMOUSEBUTTON)
				(cond
					((== (event modifiers:) emRIGHT_SHIFT)
						(if (= local0 (gCast firstTrue: #onMe event))
							(= local1 local0)
						else
							(= local0 0)
						)
					)
					(local2
						(= local2 0)
					)
					(else
						(= local2 1)
					)
				)
				(event claimed: 1)
				(return)
			)
			(else
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance act1 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act2 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act3 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act4 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act5 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act6 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act7 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act8 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act9 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

(instance act0 of Actor
	(properties
		x 160
		y 100
		fixPriority 1
		view 0
		signal 16384
	)
)

