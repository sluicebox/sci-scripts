;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 441)
(include sci.sh)
(use Main)
(use LightRoom)
(use Stem)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm441 0
)

(local
	[local0 2]
	local2
)

(procedure (localproc_0 param1)
	(gCurRoom compassDir: param1)
	(if (IsFlag 368)
		((gGame compassFace:) setLoop: param1 setCel: 0)
	)
)

(instance rm441 of LightRoom
	(properties
		picture 441
	)

	(method (init)
		(gGame handsOn:)
		(localproc_0 3)
		(super init: &rest)
		(winchPanel init:)
		(winchLever
			addStem: 4435 1 67 53 100 18432 34 34 34 29 34 24 34 20 34 14
			addStem: 4435 2 67 53 100 20480 34 37 34 42 34 47 34 52 34 57
			addStem: 4435 3 67 53 100 19200 34 34 27 34 22 34 16 34 9 34
			addStem: 4435 4 67 53 100 19712 40 34 45 34 51 34 56 34 60 34
		)
		(bridgeHook init: setLoop: 0 1)
		(spinnerHook init:)
		(fountain init:)
		(Load rsAUDIO 417)
		(Lock rsAUDIO 41700 1)
		(Lock rsAUDIO 10061 1)
		(gBackMusic2 fade: 0 25 10 1)
		(myMusic init: number: 10061 setLoop: -1 play: 0 0 fade: 100 26 7 0)
		(global206 add: self)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (winchPanel onMe: event)))
			(myMusic fade:)
			(gCurRoom newRoom: 440)
		)
	)

	(method (cue)
		(super cue: &rest)
		(gCurRoom newRoom: 440)
	)

	(method (dispose)
		(global206 delete: self)
		(myMusic fade:)
		(winchPanel dispose:)
		(Lock rsAUDIO 41700 0)
		(Lock rsAUDIO 10061 0)
		(super dispose: &rest)
	)
)

(instance bridgeHook of Actor
	(properties
		x 348
		y 33
		view 4430
	)

	(method (doit)
		(super doit: &rest)
		(if (and (not mover) (moveSound handle:))
			(moveSound stop:)
		)
	)

	(method (setMotion param1)
		(if (and (not (moveSound handle:)) param1)
			(moveSound number: 41700 setLoop: -1 play:)
		)
		(super setMotion: param1 &rest)
	)
)

(instance fountain of Prop
	(properties
		x 394
		y 213
		view 4461
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance spinnerHook of View
	(properties
		x 235
		y 210
		view 4430
		loop 2
	)
)

(instance winchPanel of View
	(properties
		view 4435
	)

	(method (init)
		(self setPri: 1)
		(super init: &rest)
	)
)

(instance winchLever of StemTracker
	(properties
		nsLeft 80
		nsTop 65
		nsRight 125
		nsBottom 110
		useKey 1
	)

	(method (celChange param1 param2)
		(if (IsFlag 409)
			(return)
		)
		(if (== param2 (stemView lastCel:))
			(switch param1
				(0
					(hookMover doit: 1)
				)
				(1
					(hookMover doit: 2)
				)
				(2
					(hookMover doit: 3)
				)
				(3
					(hookMover doit: 4)
				)
			)
		else
			(hookMover doit: -1)
		)
	)

	(method (handleEvent)
		(if (IsFlag 409)
			(return)
		)
		(super handleEvent: &rest)
	)

	(method (track param1)
		(super track: param1)
		(if (not tracking)
			(self moveTo: 0 0)
		)
	)
)

(instance hookMover of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (bridgeHook mover:)
			(return)
		)
		(= temp0 (bridgeHook x:))
		(if (== (= temp1 (bridgeHook y:)) 225)
			(bridgeHook setPri: 10)
		else
			(bridgeHook setPri: 500)
		)
		(switch param1
			(1
				(if
					(OneOf
						temp0
						199
						222
						252
						254
						280
						283
						296
						307
						321
						352
						368
					)
					(switch temp0
						(199
							(bridgeHook setMotion: MoveTo 199 122)
						)
						(222
							(switch temp1
								(205
									(bridgeHook setMotion: MoveTo 222 122)
								)
								(122
									(bridgeHook setMotion: MoveTo 222 100)
								)
							)
						)
						(252
							(switch temp1
								(122
									(bridgeHook setMotion: MoveTo 252 77)
								)
								(180
									(bridgeHook setMotion: MoveTo 252 122)
								)
							)
						)
						(254
							(bridgeHook setMotion: MoveTo 254 41)
						)
						(280
							(bridgeHook setMotion: MoveTo 280 139)
						)
						(283
							(cond
								((== temp1 77)
									(bridgeHook setMotion: MoveTo 283 61)
								)
								((!= temp1 61)
									(bridgeHook setMotion: MoveTo 283 17)
								)
							)
						)
						(296
							(bridgeHook setMotion: MoveTo 296 77)
						)
						(307
							(bridgeHook
								setLoop: 1
								setCel: 0
								setPri: 400
								posn: 235 150
								setCycle: End gCurRoom
							)
							(SetFlag 409)
							(winchLever track: 0)
							(winchLever keyTracking: 0)
							(gKeyDownHandler delete: winchLever)
							(gMySoundFX number: 417 setLoop: 0 play:)
						)
						(321
							(switch temp1
								(41
									(bridgeHook setMotion: MoveTo 321 33)
								)
								(77
									(bridgeHook setMotion: MoveTo 321 41)
								)
								(122
									(bridgeHook setMotion: MoveTo 321 96)
								)
								(139
									(bridgeHook setMotion: MoveTo 321 122)
								)
							)
						)
						(352
							(switch temp1
								(139
									(bridgeHook setMotion: MoveTo 352 112)
								)
								(225
									(bridgeHook setMotion: MoveTo 352 139)
								)
							)
						)
						(368
							(switch temp1
								(112
									(bridgeHook setMotion: MoveTo 368 47)
								)
								(230
									(bridgeHook setMotion: MoveTo 368 112)
								)
							)
						)
					)
				)
			)
			(2
				(if
					(OneOf
						temp0
						199
						222
						252
						254
						280
						283
						296
						307
						321
						352
						368
					)
					(switch temp0
						(199
							(bridgeHook setMotion: MoveTo 199 138)
						)
						(222
							(switch temp1
								(100
									(bridgeHook setMotion: MoveTo 222 122)
								)
								(122
									(bridgeHook setMotion: MoveTo 222 205)
								)
							)
						)
						(252
							(switch temp1
								(77
									(bridgeHook setMotion: MoveTo 252 122)
								)
								(122
									(bridgeHook setMotion: MoveTo 252 180)
								)
							)
						)
						(254
							(bridgeHook setMotion: MoveTo 254 68)
						)
						(280
							(bridgeHook setMotion: MoveTo 280 183)
						)
						(283
							(cond
								((== temp1 61)
									(bridgeHook setMotion: MoveTo 283 77)
								)
								((!= temp1 77)
									(bridgeHook setMotion: MoveTo 283 41)
								)
							)
						)
						(296
							(bridgeHook setMotion: MoveTo 296 107)
						)
						(307
							(bridgeHook setMotion: MoveTo 307 225)
						)
						(321
							(switch temp1
								(33
									(bridgeHook setMotion: MoveTo 321 41)
								)
								(41
									(bridgeHook setMotion: MoveTo 321 77)
								)
								(96
									(bridgeHook setMotion: MoveTo 321 122)
								)
								(122
									(bridgeHook setMotion: MoveTo 321 139)
								)
							)
						)
						(352
							(switch temp1
								(112
									(bridgeHook setMotion: MoveTo 352 139)
								)
								(139
									(bridgeHook setMotion: MoveTo 352 225)
								)
							)
						)
						(368
							(switch temp1
								(47
									(bridgeHook setMotion: MoveTo 368 112)
								)
								(112
									(bridgeHook setMotion: MoveTo 368 230)
								)
							)
						)
					)
				)
			)
			(3
				(if (OneOf temp1 33 41 68 77 112 122 139 183 225)
					(switch temp1
						(33
							(bridgeHook setMotion: MoveTo 321 33)
						)
						(41
							(if (<= temp0 283)
								(bridgeHook setMotion: MoveTo 254 41)
							else
								(bridgeHook setMotion: MoveTo 283 41)
							)
						)
						(68
							(bridgeHook setMotion: MoveTo 228 68)
						)
						(77
							(cond
								((> temp0 321)
									(bridgeHook setMotion: MoveTo 321 77)
								)
								((== temp0 321)
									(bridgeHook setMotion: MoveTo 296 77)
								)
								((== temp0 296)
									(bridgeHook setMotion: MoveTo 283 77)
								)
								((== temp0 283)
									(bridgeHook setMotion: MoveTo 252 77)
								)
							)
						)
						(112
							(switch temp0
								(352
									(bridgeHook setMotion: MoveTo 335 112)
								)
								(368
									(bridgeHook setMotion: MoveTo 352 112)
								)
							)
						)
						(122
							(switch temp0
								(222
									(bridgeHook setMotion: MoveTo 199 122)
								)
								(252
									(bridgeHook setMotion: MoveTo 222 122)
								)
							)
						)
						(139
							(switch temp0
								(321
									(bridgeHook setMotion: MoveTo 280 139)
								)
								(352
									(bridgeHook setMotion: MoveTo 321 139)
								)
							)
						)
						(183
							(bridgeHook setMotion: MoveTo 280 183)
						)
						(225
							(bridgeHook setMotion: MoveTo 307 225)
						)
					)
				)
			)
			(4
				(if (OneOf temp1 33 41 68 77 112 122 139 183 225)
					(switch temp1
						(33
							(bridgeHook setMotion: MoveTo 354 33)
						)
						(41
							(if (>= temp0 283)
								(bridgeHook setMotion: MoveTo 321 41)
							else
								(bridgeHook setMotion: MoveTo 283 41)
							)
						)
						(68
							(bridgeHook setMotion: MoveTo 254 68)
						)
						(77
							(cond
								((== temp0 321)
									(bridgeHook setMotion: MoveTo 350 77)
								)
								((== temp0 296)
									(bridgeHook setMotion: MoveTo 321 77)
								)
								((== temp0 283)
									(bridgeHook setMotion: MoveTo 296 77)
								)
								((== temp0 252)
									(bridgeHook setMotion: MoveTo 283 77)
								)
							)
						)
						(112
							(switch temp0
								(335
									(bridgeHook setMotion: MoveTo 352 112)
								)
								(352
									(bridgeHook setMotion: MoveTo 368 112)
								)
							)
						)
						(122
							(switch temp0
								(199
									(bridgeHook setMotion: MoveTo 222 122)
								)
								(222
									(bridgeHook setMotion: MoveTo 252 122)
								)
								(252
									(bridgeHook setMotion: MoveTo 321 122)
								)
							)
						)
						(139
							(switch temp0
								(280
									(bridgeHook setMotion: MoveTo 321 139)
								)
								(321
									(bridgeHook setMotion: MoveTo 352 139)
								)
							)
						)
						(183
							(bridgeHook setMotion: MoveTo 288 183)
						)
						(225
							(bridgeHook setMotion: MoveTo 352 225)
						)
					)
				)
			)
			(else
				(bridgeHook setMotion: 0)
			)
		)
		(= local2 -1)
	)
)

(instance moveSound of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

