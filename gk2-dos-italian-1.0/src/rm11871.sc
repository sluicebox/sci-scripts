;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11871)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use BaseRegion)
(use Motion)
(use Actor)
(use System)

(public
	rm11871 0
)

(local
	[local0 13] = [201 306 410 516 201 306 410 516 201 306 410 516 516]
	[local13 13] = [55 55 55 55 127 127 127 127 201 201 201 201 274]
	local26
)

(instance rm11871 of ExitRoom
	(properties
		picture 11871
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		((ScriptID 15000 3) hide:) ; doorLeft
		((ScriptID 15000 4) hide:) ; doorMid
		((ScriptID 15000 5) hide:) ; doorRight
		(super init:)
		(gabeWolf init:)
		(vgWolf init:)
		(door1 init:)
		(door2 init:)
		(door3 init:)
		(door4 init:)
		(door5 init:)
		(door6 init:)
		(door7 init:)
		(door8 init:)
		(door9 init:)
		(door10 init:)
		(door11 init:)
		(door12 init:)
		(door13 init:)
		(door14 init:)
		(door15 init:)
		(door16 init:)
		(door17 init:)
		(proproomDoor init:)
		(exitButton init:)
		(= local26 (Wolf BAD_SELECTOR:))
		(self notify:)
	)

	(method (notify)
		(cond
			((IsFlag 809)
				(gCurRoom setScript: sVonGlowerEscapes)
			)
			((IsFlag 810)
				(gCurRoom setScript: sVonGlowerTrapped)
			)
			((IsFlag 811)
				(gCurRoom setScript: sBlockedIn)
			)
			((IsFlag 813)
				(gCurRoom setScript: sEscapeToBackstage)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(script)
			((!= local26 (Wolf BAD_SELECTOR:))
				(= temp0 (Wolf BAD_SELECTOR:))
				(vgWolf
					setLoop: 5 1
					setMotion: MoveTo [local0 (- temp0 1)] [local13 (- temp0 1)]
				)
				(= local26 temp0)
			)
		)
	)
)

(instance sVonGlowerEscapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if (== (vgWolf x:) [local0 8])
					(= cycles 3)
				else
					(vgWolf
						setLoop: 5 1
						setMotion: MoveTo [local0 8] [local13 8] self
					)
				)
			)
			(2
				(= ticks 120)
			)
			(3
				(vgWolf setLoop: 5 1 setMotion: MoveTo 160 201 self)
				((ScriptID 15000 2) dispose: delete:) ; wolfTimer
			)
			(4
				(= ticks 90)
			)
			(5
				(vgWolf setMotion: MoveTo 146 201 self)
			)
			(6
				(vgWolf setMotion: MoveTo 116 185 self)
			)
			(7
				(vgWolf setMotion: MoveTo 64 260 self)
			)
			(8
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 11854)
				(= ticks 240)
			)
			(9
				(BaseRegion keep: 0)
				(ClearFlag 809)
				(gGame handsOn:)
				(gGk2Music stop:)
				(PlayScene 4930 0 666) ; uDie
				((ScriptID 15000 3) hide:) ; doorLeft
				((ScriptID 15000 4) hide:) ; doorMid
				((ScriptID 15000 5) hide:) ; doorRight
				(self dispose:)
			)
		)
	)
)

(instance sEscapeToBackstage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if (== (vgWolf x:) [local0 (- (Wolf BAD_SELECTOR:) 1)])
					(= cycles 3)
				else
					(vgWolf
						setLoop: 5 1
						setMotion:
							MoveTo
							[local0 (- (Wolf BAD_SELECTOR:) 1)]
							[local13 (- (Wolf BAD_SELECTOR:) 1)]
							self
					)
				)
			)
			(2
				(= ticks 120)
			)
			(3
				(vgWolf setLoop: 5 1 setMotion: MoveTo 160 (vgWolf y:) self)
				((ScriptID 15000 2) dispose: delete:) ; wolfTimer
			)
			(4
				(= ticks 90)
			)
			(5
				(vgWolf setMotion: MoveTo 91 (vgWolf y:) self)
			)
			(6
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 11501)
				(= ticks 240)
			)
			(7
				(BaseRegion keep: 0)
				(ClearFlag 813)
				(gGame handsOn:)
				(gGk2Music stop:)
				(PlayScene 4930 0 666) ; uDie
				(self dispose:)
			)
		)
	)
)

(instance sVonGlowerTrapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gabeWolf x: (- (gabeWolf x:) 14) cel: 1)
				(if (== (vgWolf x:) [local0 (- (Wolf BAD_SELECTOR:) 1)])
					(= cycles 3)
				else
					(vgWolf
						setLoop: 5 1
						setMotion:
							MoveTo
							[local0 (- (Wolf BAD_SELECTOR:) 1)]
							[local13 (- (Wolf BAD_SELECTOR:) 1)]
							self
					)
				)
			)
			(2
				(= ticks 240)
			)
			(3
				((ScriptID 15000 2) dispose: delete:) ; wolfTimer
				(BaseRegion keep: 0)
				(ClearFlag 810)
				(gGame handsOn:)
				(gGk2Music stop:)
				(PlayScene 3930 0 666) ; uDie
				((ScriptID 15000 3) hide:) ; doorLeft
				((ScriptID 15000 4) hide:) ; doorMid
				((ScriptID 15000 5) hide:) ; doorRight
				(self dispose:)
			)
		)
	)
)

(instance sBlockedIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if (== (vgWolf x:) [local0 (- (Wolf BAD_SELECTOR:) 1)])
					(= cycles 3)
				else
					(vgWolf
						setLoop: 5 1
						setMotion:
							MoveTo
							[local0 (- (Wolf BAD_SELECTOR:) 1)]
							[local13 (- (Wolf BAD_SELECTOR:) 1)]
							self
					)
				)
			)
			(2
				(= ticks 240)
			)
			(3
				((ScriptID 15000 2) dispose: delete:) ; wolfTimer
				((ScriptID 15000 3) hide:) ; doorLeft
				((ScriptID 15000 4) hide:) ; doorMid
				((ScriptID 15000 5) hide:) ; doorRight
				(BaseRegion keep: 0)
				(ClearFlag 811)
				(gGame handsOn:)
				(gGk2Music stop:)
				(PlayScene 2930 0 666) ; uDie
				(self dispose:)
			)
		)
	)
)

(instance exitButton of View
	(properties
		x 7
		y 299
		view 11871
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: gPrevRoomNum)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gabeWolf of View
	(properties
		x 201
		y 55
		view 11871
		loop 4
	)

	(method (init)
		(= x (+ [local0 (- global143 1)] 6))
		(= y (- [local13 (- global143 1)] 6))
		(= cel global142)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door1 of View
	(properties
		x 261
		y 75
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 0)
			(= loop 1)
			(= x 255)
			(= y 64)
		else
			(= loop 3)
			(= x 261)
			(= y 75)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door2 of View
	(properties
		x 365
		y 75
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 1)
			(= loop 1)
			(= x 361)
			(= y 64)
		else
			(= loop 3)
			(= x 365)
			(= y 75)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door3 of View
	(properties
		x 471
		y 75
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 2)
			(= loop 1)
			(= x 466)
			(= y 64)
		else
			(= loop 3)
			(= x 471)
			(= y 75)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door4 of View
	(properties
		x 179
		y 104
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 3)
			(= loop 0)
			(= x 191)
			(= y 88)
		else
			(= loop 2)
			(= x 179)
			(= y 104)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door5 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 4)
			(= loop 0)
			(= x 296)
			(= y 88)
		else
			(= loop 2)
			(= x 283)
			(= y 104)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door6 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 5)
			(= loop 0)
			(= x 403)
			(= y 88)
		else
			(= loop 2)
			(= x 391)
			(= y 104)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door7 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 6)
			(= loop 0)
			(= x 509)
			(= y 88)
		else
			(= loop 2)
			(= x 495)
			(= y 104)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door8 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 7)
			(= loop 1)
			(= x 255)
			(= y 135)
		else
			(= loop 3)
			(= x 261)
			(= y 145)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door9 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 8)
			(= loop 1)
			(= x 361)
			(= y 135)
		else
			(= loop 3)
			(= x 365)
			(= y 145)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door10 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 9)
			(= loop 1)
			(= x 466)
			(= y 135)
		else
			(= loop 3)
			(= x 471)
			(= y 145)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door11 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 10)
			(= loop 0)
			(= x 191)
			(= y 161)
		else
			(= loop 2)
			(= y (= x 179))
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door12 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 11)
			(= loop 0)
			(= x 296)
			(= y 161)
		else
			(= loop 2)
			(= x 283)
			(= y 179)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door13 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 12)
			(= loop 0)
			(= x 403)
			(= y 161)
		else
			(= loop 2)
			(= x 391)
			(= y 179)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door14 of View
	(properties
		view 11871
		loop 2
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 13)
			(= loop 0)
			(= x 509)
			(= y 161)
		else
			(= loop 2)
			(= x 495)
			(= y 179)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door15 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 14)
			(= loop 1)
			(= x 255)
			(= y 208)
		else
			(= loop 3)
			(= x 261)
			(= y 219)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door16 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 15)
			(= loop 1)
			(= x 361)
			(= y 208)
		else
			(= loop 3)
			(= x 365)
			(= y 219)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance door17 of View
	(properties
		view 11871
		loop 3
	)

	(method (init)
		(if ((BaseRegion BAD_SELECTOR:) at: 16)
			(= loop 1)
			(= x 466)
			(= y 208)
		else
			(= loop 3)
			(= x 471)
			(= y 219)
		)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance backstageDoor of View ; UNUSED
	(properties
		x 154
		y 75
		view 11871
		loop 3
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance proproomDoor of View
	(properties
		x 150
		y 135
		view 11871
		loop 1
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance foyerDoor of View ; UNUSED
	(properties
		x 575
		y 217
		view 11871
		loop 3
	)

	(method (init)
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance vgWolf of Actor
	(properties
		x 517
		y 202
		view 11871
		loop 5
		moveSpeed 3
	)

	(method (init)
		(= x [local0 (- (Wolf BAD_SELECTOR:) 1)])
		(= y [local13 (- (Wolf BAD_SELECTOR:) 1)])
		(super init: &rest)
		((gUser BAD_SELECTOR:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

