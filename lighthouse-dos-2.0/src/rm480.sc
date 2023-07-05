;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use LightRoom)
(use TrackingProp)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm480 of LightRoom
	(properties
		picture 480
	)

	(method (newRoom newRoomNumber)
		(= local6 1)
		(if (gPanels contains: cranePanel)
			(cranePanel dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(switch gPrevRoomNum
			(470
				(self changeScene: 480 1)
			)
			(else
				(= local4 1)
				(gMySoundFX number: 460 setLoop: -1 play: setVol: 127)
				(gBackMusic number: 1008 setLoop: -1 play:)
				(self changeScene: 5452 3)
			)
		)
	)

	(method (dispose)
		(gBackMusic fade:)
		(gBackMusic2 fade:)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		(weightATP dispose:)
		(if (gCast contains: weight)
			(weight dispose:)
		)
		(if (gCast contains: weight1)
			(weight1 dispose:)
		)
		(if (gCast contains: extendedBridge)
			(extendedBridge dispose:)
		)
		(super changeScene: param1 &rest)
		(switch param1
			(477
				(gMySoundFX stop:)
				(if (== (gBackMusic number:) 1007)
					(gBackMusic fade:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 478 5
					nsLeft: 122
					nsTop: 41
					nsRight: 382
					nsBottom: 207
				)
				(bigMoveBack newPic: 483 13)
			)
			(478
				((ScriptID 1 2) newPic: 480 1) ; exitBack
				((ScriptID 1 4) ; exitRight
					newPic: 470 7
					nsLeft: 256
					nsRight: 353
					nsTop: 1
					nsBottom: 299
					exitCode: rightExitCode
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 470 7
					nsLeft: 138
					nsTop: 1
					nsRight: 249
					nsBottom: 299
					exitCode: leftExitCode
				)
			)
			(480
				(if (!= (gMySoundFX number:) 460)
					(gMySoundFX number: 460 setLoop: -1 play: setVol: 32)
				)
				(if (!= (gBackMusic number:) 1008)
					(gBackMusic number: 1008 setLoop: -1 play:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 483 13
					nsLeft: 157
					nsTop: 47
					nsRight: 351
					nsBottom: 240
				)
				((ScriptID 1 2) ; exitBack
					newPic: 478 5
					nsLeft: 87
					nsTop: 250
					nsRight: 411
					nsBottom: 300
				)
			)
			(483
				((ScriptID 1 1) ; exitForward
					newPic: 484 6
					nsLeft: 83
					nsTop: 58
					nsRight: 361
					nsBottom: 237
				)
				(bigMoveBack newPic: 5459 7)
			)
			(484
				(proc0_9 6480 369 177)
				((ScriptID 1 1) ; exitForward
					newPic: 486 12
					nsLeft: 100
					nsTop: 60
					nsRight: 400
					nsBottom: 230
				)
				(bigMoveBack newPic: 5458 8)
				((ScriptID 1 4) ; exitRight
					newPic: 485 4
					nsLeft: 400
					nsTop: 50
					nsRight: 500
					nsBottom: 240
				)
			)
			(485
				(if (IsFlag 130)
					(proc0_9 6492)
				else
					(proc0_9 6481 0 0)
				)
				(if (global216 at: 5)
					(weight view: 6494 cel: 1 x: 225 y: 13 init:)
				)
				(if (IsFlag 127)
					(weight1
						view: 6494
						cel: (if (IsFlag 128) 4 else 3)
						x: 255
						y: 63
						init:
					)
				)
				(if (IsFlag 92)
					(extendedBridge view: 6494 cel: 0 x: 199 y: 83 init:)
				)
				((ScriptID 1 4) ; exitRight
					newPic: 5458 8
					nsLeft: 400
					nsTop: 50
					nsRight: 500
					nsBottom: 240
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 484 6
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
			)
			(486
				(proc0_9 6482 272 45)
				(gMySoundFX setVol: 64)
				(if (IsFlag 92)
					(extendedBridge view: 6495 cel: 0 x: 456 y: 78 init:)
				)
				(if (global216 at: 5)
					(weight view: 6495 cel: 1 x: 461 y: 40 init:)
				)
				(if (!= (gBackMusic number:) 1007)
					(gBackMusic number: 1008 setLoop: -1 play:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 487 3
					nsLeft: 140
					nsTop: 42
					nsRight: 388
					nsBottom: 227
				)
				(bigMoveBack newPic: 5457 1)
			)
			(487
				(gMySoundFX setVol: 96)
				(if (IsFlag 130)
					(proc0_9 6491)
				else
					(proc0_9 6483 253 135)
				)
				(if (global216 at: 5)
					(weight view: 6496 cel: 0 x: 223 y: 166 init:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 488 2
					nsLeft: 132
					nsTop: 83
					nsRight: 427
					nsBottom: 212
				)
				(bigMoveBack newPic: 5456 8)
			)
			(488
				(gMySoundFX setVol: 127)
				(Load rsAUDIO 2019 2020 2021 2022 2034 2035 2036)
				(crane
					view: (global216 at: 0)
					loop: (global216 at: 1)
					cel: (if (== (global216 at: 0) 4480) 26 else 0)
					x: (global216 at: 3)
					y: (global216 at: 4)
					init:
				)
				(scale
					view: (global216 at: 7)
					loop: (global216 at: 8)
					cel: (global216 at: 9)
					x: (global216 at: 10)
					y: (global216 at: 11)
					init:
					setPri: 500
				)
				(= local1 4)
				(if (IsFlag 129)
					(ring cel: 0 x: 135 y: 277 init:)
				else
					(ring init:)
				)
				(if (global216 at: 5)
					(leftWeight init:)
				)
				(if (global216 at: 6)
					(rightWeight init:)
				)
				(craneControls init:)
				(if (IsFlag 130)
					(proc0_9 6490 0 0)
				else
					(proc0_9 6484 115 146)
				)
				((ScriptID 1 4) init: exitCode: craneExitRight) ; exitRight
				((ScriptID 1 2) init: exitCode: craneExitBack) ; exitBack
			)
			(5460
				(if (gCast contains: crank)
					(crank dispose:)
					(bridge dispose:)
					(latch dispose:)
				)
				(bigMoveBack newPic: 5451 1)
				((ScriptID 1 1) ; exitForward
					newPic: 5454 5
					nsLeft: 93
					nsTop: 67
					nsRight: 400
					nsBottom: 231
				)
			)
			(5450
				(if (== (global216 at: 0) 4480)
					(weightATP init:)
				)
				(if (gCast contains: crane)
					(crane dispose:)
					(scale dispose:)
					(ring dispose:)
					(craneControls dispose:)
					(leftWeight dispose:)
					(rightWeight dispose:)
				)
				(proc0_9 6485 0 163)
				(if (IsFlag 92)
					(extendedBridge view: 6497 cel: 2 x: 237 y: 195 init:)
				)
				(if (IsFlag 127)
					(weight
						view: 6497
						cel: (if (IsFlag 128) 1 else 0)
						x: 66
						y: 185
						init:
					)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 5451 1
					nsLeft: 154
					nsTop: 94
					nsRight: 344
					nsBottom: 259
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 488 2
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
				((ScriptID 1 4) ; exitRight
					newPic: 5455 7
					nsLeft: 400
					nsTop: 50
					nsRight: 500
					nsBottom: 240
				)
			)
			(5451
				(Load rsAUDIO 2025 461 462)
				(proc0_9 6486 0 141 10)
				(if (not (IsFlag 92))
					(crank
						cel: 0
						init:
						setPoints:
							0
							-36
							-10
							-38
							-17
							-33
							-26
							-28
							-30
							-19
							-35
							-10
							-36
							0
							-34
							10
							-30
							20
							-26
							29
							-20
							34
							-10
							36
							-2
							38
							8
							36
							13
							31
							21
							26
							35
							18
							29
							9
							31
							-1
							29
							-11
							30
							-21
							22
							-27
							16
							-37
							8
							-36
					)
					(bridge cel: 0 init:)
					(latch cel: 0 init:)
				else
					(crank
						cel: 0
						init:
						setPoints:
							0
							-36
							-10
							-38
							-17
							-33
							-26
							-28
							-30
							-19
							-35
							-10
							-36
							0
							-34
							10
							-30
							20
							-26
							29
							-20
							34
							-10
							36
							-2
							38
							8
							36
							13
							31
							21
							26
							35
							18
							29
							9
							31
							-1
							29
							-11
							30
							-21
							22
							-27
							16
							-37
							8
							-36
					)
					(bridge cel: 24 init:)
					(latch cel: 6 init:)
					((ScriptID 1 1) newPic: 5452 3) ; exitForward
				)
				((ScriptID 1 2) newPic: 5460 5) ; exitBack
			)
			(5452
				(if (IsFlag 130)
					(proc0_9 6493)
				else
					(proc0_9 6487 0 0)
				)
				(if (gCast contains: crank)
					(crank dispose:)
					(latch dispose:)
					(bridge dispose:)
				)
				(Load rsAUDIO 2026)
				(hatch init: setCel: (if local4 22 else 0))
				(if local4
					((ScriptID 1 5) ; exitDown
						newRoom: 212
						nsLeft: 177
						nsTop: 60
						nsRight: 402
						nsBottom: 212
					)
				)
				((ScriptID 1 3) ; exitLeft
					init:
					exitCode: hatchBack
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
			)
			(5453
				(if (gCast contains: hatch)
					(hatch dispose:)
				)
				(if (global216 at: 5)
					(weight view: 6498 cel: 0 x: 452 y: 53 init:)
				)
				(proc0_9 6488 0 59)
				((ScriptID 1 1) newPic: 5454 5) ; exitForward
				(bigMoveBack newPic: 5452 3)
			)
			(5454
				(if (gCast contains: crank)
					(crank dispose:)
					(latch dispose:)
					(bridge dispose:)
				)
				((ScriptID 1 4) ; exitRight
					newPic: 488 2
					nsLeft: 400
					nsTop: 50
					nsRight: 500
					nsBottom: 240
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 5455 7
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
				(bigMoveBack newPic: 5450 1)
			)
			(5455
				(if (gCast contains: crane)
					(crane dispose:)
					(scale dispose:)
					(ring dispose:)
					(leftWeight dispose:)
					(craneControls dispose:)
					(rightWeight dispose:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 5456 8
					nsLeft: 112
					nsTop: 54
					nsRight: 369
					nsBottom: 222
				)
				(bigMoveBack newPic: 488 2)
				((ScriptID 1 3) ; exitLeft
					newPic: 5450 1
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
			)
			(5456
				((ScriptID 1 1) ; exitForward
					newPic: 5457 1
					nsLeft: 228
					nsTop: 72
					nsRight: 486
					nsBottom: 230
				)
				(bigMoveBack newPic: 487 3)
			)
			(5457
				(gMySoundFX setVol: 96)
				((ScriptID 1 1) ; exitForward
					newPic: 5458 8
					nsLeft: 169
					nsTop: 90
					nsRight: 463
					nsBottom: 229
				)
				(bigMoveBack newPic: 486 12)
			)
			(5458
				(gMySoundFX setVol: 64)
				((ScriptID 1 1) ; exitForward
					newPic: 5459 7
					nsLeft: 148
					nsTop: 80
					nsRight: 397
					nsBottom: 234
				)
				(bigMoveBack newPic: 484 6)
				((ScriptID 1 3) ; exitLeft
					newPic: 485 4
					nsLeft: 0
					nsTop: 50
					nsRight: 100
					nsBottom: 240
				)
			)
			(5459
				(if (not (gMySoundFX handle:))
					(gMySoundFX number: 460 setLoop: -1 play: setVol: 32)
				else
					(gMySoundFX setVol: 32)
				)
				(bigMoveBack newPic: 483 13)
				((ScriptID 1 1) ; exitForward
					newPic: 477 6
					nsLeft: 104
					nsTop: 54
					nsRight: 399
					nsBottom: 231
				)
			)
		)
	)
)

(instance hatchBack of ExitCode
	(properties)

	(method (cue)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 5453)
		(if (!= (hatch cel:) 0)
			(gGame handsOff:)
			(= local4 0)
			(hatchSound number: 2026 play:)
			(hatch setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance craneExitRight of ExitCode
	(properties)

	(method (cue)
		(craneLoop stop:)
		(if local5
			(= local5 0)
			(craneStop play:)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(gGame handsOff:)
		(= nextScene 5450)
		(cond
			((== (crane view:) 4480)
				(if (!= (crane cel:) 26)
					(craneLoop play:)
					(= local5 1)
					(crane
						setCycle: CT 26 (if (> (crane cel:) 26) -1 else 1) self
					)
					(return)
				)
			)
			((crane cel:)
				(craneLoop play:)
				(= local5 1)
				(crane setCycle: Beg self)
				(return)
			)
		)
		(self cue:)
	)
)

(instance craneExitBack of ExitCode
	(properties)

	(method (cue)
		(craneLoop stop:)
		(if local5
			(= local5 0)
			(craneStop play:)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(gGame handsOff:)
		(= nextScene 5455)
		(cond
			((== (crane view:) 4480)
				(if (!= (crane cel:) 26)
					(craneLoop play:)
					(= local5 1)
					(crane
						setCycle: CT 26 (if (> (crane cel:) 26) -1 else 1) self
					)
					(return)
				)
			)
			((crane cel:)
				(craneLoop play:)
				(= local5 1)
				(crane setCycle: Beg self)
				(return)
			)
		)
		(self cue:)
	)
)

(instance disposeCrane of Code
	(properties)

	(method (doit)
		(openSeaGate dispose:)
		(cranePanel dispose:)
		(gGame handsOn:)
	)
)

(instance rightExitCode of Code
	(properties)

	(method (doit)
		(SetFlag 51)
		(gCurRoom newRoom: 470)
		((ScriptID 1 4) nextRoomNum: 0) ; exitRight
	)
)

(instance leftExitCode of Code
	(properties)

	(method (doit)
		(SetFlag 52)
		(gCurRoom newRoom: 470)
		((ScriptID 1 3) nextRoomNum: 0) ; exitLeft
	)
)

(instance crank of TrackingProp
	(properties
		x 371
		y 157
		loop 1
		view 4484
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(if local3
			(= local3 0)
			(crank setCel: 0)
			(bridgeSound setLoop: 1 stop:)
			(= local0 0)
			(if script
				(crankSnapsBack dispose:)
			)
			(gGame handsOn:)
		else
			(super cue: &rest)
		)
	)

	(method (doMouseUp)
		(cond
			((== (bridge cel:) 24)
				(self setScript: crankSnapsBack)
			)
			((self cel:)
				(= local3 1)
				(gGame handsOff:)
				(bridgeSound loop: -1 play:)
				(self setCycle: Beg)
				(bridge setCycle: Beg self)
			)
		)
	)

	(method (handleEvent event)
		(if (IsFlag 92)
			(if
				(and
					(& (event type:) evMOUSEBUTTON)
					(== (gUser curVerb:) 5)
					(IsFlag 92)
				)
				(latch doVerb: (gUser curVerb:))
				(return)
			else
				(return)
			)
		else
			(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON) script)
				(self setScript: 0)
			)
			(super handleEvent: event &rest)
		)
	)

	(method (nextCel &tmp [temp0 4] temp4 temp5)
		(= temp4 cel)
		(= temp5 (super nextCel: &rest))
		(cond
			((and (<= (+= local0 temp5) 0) (< temp5 0))
				(= local0 0)
				(self setCel: temp4)
			)
			((and (> local0 24) (> temp5 0))
				(= local0 24)
				(self setCel: temp4)
			)
		)
		(bridge setCel: local0)
		(UpdateScreenItem self)
	)
)

(instance bridge of Prop
	(properties
		x 182
		y 275
		view 4484
	)

	(method (setCel param1)
		(if (!= param1 cel)
			(bridgeSound play:)
		)
		(if cycler
			(-- local0)
		)
		(super setCel: param1 &rest)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance hatch of Prop
	(properties
		x 190
		y 194
		view 4490
	)

	(method (init)
		(super init: &rest)
		(self setPri: 400)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(if local4
			(= local4 0)
			((ScriptID 1 5) dispose:) ; exitDown
		else
			(= local4 1)
			((ScriptID 1 5) ; exitDown
				newRoom: 212 nsLeft 177
				nsTop: 60
				nsRight: 402
				nsBottom: 212
			)
		)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(if local4
				(hatchSound number: 20270 play:)
				(self setCycle: Beg self)
			else
				(hatchSound number: 2026 play:)
				(self setCycle: End self)
			)
		)
	)
)

(instance latch of Prop
	(properties
		x 321
		y 125
		loop 2
		view 4484
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((IsFlag 92)
					(gCurRoom setScript: retractBridge)
				)
				((== (bridge cel:) 24)
					(crankSnapsBack dispose:)
					(latchSound play:)
					(self setCycle: End)
					(SetFlag 92)
					((ScriptID 1 1) newPic: 5452 3) ; exitForward
				)
			)
		)
	)
)

(instance latchSound of Sound
	(properties
		number 461
		flags 1
	)
)

(instance unlatchSound of Sound
	(properties
		number 462
		flags 1
	)
)

(instance crane of Prop
	(properties
		y 12
		cycleSpeed 10
		view 4485
	)
)

(instance scale of Prop
	(properties
		x 384
		y 201
		loop 3
		cel 3
		view 4483
	)
)

(instance craneControls of Feature
	(properties
		y 200
		nsBottom 285
		nsLeft 301
		nsRight 347
		nsTop 235
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 163 273 163 273 204 231 204 231 163
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cranePanel init:)
		)
	)
)

(instance cranePanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(craneLeft init: self)
		(craneCenter init: self)
		(craneRight init: self)
		(craneTop init: self)
		(craneBottom init: self)
		(cranePanelProp init: self 0 0)
		(leftCraneLever init: self 1 0)
		(rightCraneLever init: self 1 0)
	)

	(method (dispose)
		(if (and (gCurRoom script:) (not local6))
			(return)
		else
			(global216 at: 0 (crane view:))
			(global216 at: 1 (crane loop:))
			(global216 at: 2 (crane cel:))
			(global216 at: 3 (crane x:))
			(global216 at: 4 (crane y:))
			(global216 at: 5 (gCast contains: leftWeight))
			(global216 at: 6 (gCast contains: rightWeight))
			(global216 at: 7 (scale view:))
			(global216 at: 8 (scale loop:))
			(global216 at: 9 (scale cel:))
			(global216 at: 10 (scale x:))
			(global216 at: 11 (scale y:))
			(super dispose: &rest)
		)
	)
)

(instance cranePanelProp of PanelProp
	(properties
		loop 2
		view 4483
	)
)

(instance craneLeft of PanelFeature
	(properties
		nsBottom 110
		nsLeft 35
		nsRight 53
		nsTop 55
	)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom setScript: rotateCraneLeft)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (OneOf (crane view:) 4480 4485)) ; Do
			(if (leftCraneLever script:)
				(leverSoundScript dispose:)
			)
			(if (not (leftCraneLever script:))
				(leftCraneLever setScript: leverSoundScript setCycle: Beg self)
			else
				(leftCraneLever setCycle: Beg self)
			)
		)
	)
)

(instance craneCenter of PanelFeature
	(properties
		nsBottom 101
		nsLeft 61
		nsRight 81
		nsTop 73
	)

	(method (cue)
		(gGame handsOn:)
		(switch (crane cel:)
			(10
				(if
					(and
						(== (crane view:) 4485)
						(gCast contains: rightWeight)
					)
					(= local1 2)
				)
			)
			(12
				(if (and (not (IsFlag 129)) (== (crane view:) 4485))
					(= local1 3)
				)
			)
			(14
				(if (and (== (crane view:) 4485) (gCast contains: leftWeight))
					(= local1 1)
				)
			)
			(26
				(if (== (crane view:) 4480)
					(= local1 4)
				)
			)
			(else
				(= local1 0)
			)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not local2)) ; Do
			(gGame handsOff:)
			(crane cycleSpeed: 14)
			(if (== (leftCraneLever cel:) 0)
				(leftCraneLever setCycle: CT 11 1 self)
			else
				(leftCraneLever setCycle: CT 11 -1 self)
			)
			(if (OneOf (gCurRoom script:) rotateCraneLeft rotateCraneRight)
				(crane setCycle: 0)
				(gCurRoom setScript: 0)
				(leverSoundScript dispose:)
			)
		)
	)
)

(instance craneRight of PanelFeature
	(properties
		nsBottom 110
		nsLeft 86
		nsRight 102
		nsTop 55
	)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom setScript: rotateCraneRight)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (OneOf (crane view:) 4480 4485)) ; Do
			(gGame handsOff:)
			(if (leftCraneLever script:)
				(leverSoundScript dispose:)
			)
			(if (not (leftCraneLever script:))
				(leftCraneLever setScript: leverSoundScript setCycle: End self)
			else
				(leftCraneLever setCycle: Beg self)
			)
		)
	)
)

(instance craneTop of PanelFeature
	(properties
		nsBottom 69
		nsLeft 121
		nsRight 150
		nsTop 45
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) local2) ; Do
			(craneCableSound play:)
			(switch local1
				(2
					(if (== (craneHook cel:) 10)
						(= local2 0)
						(pickUpWeight2 cue:)
					)
				)
				(4
					(if
						(or
							(and
								(gCast contains: craneHook)
								(== (craneHook cel:) (craneHook lastCel:))
							)
							(and (gCast contains: scale) (== (scale cel:) 10))
						)
						(= local2 0)
						(dropWeight cue:)
					)
				)
				(1
					(if (== (craneHook cel:) 11)
						(= local2 0)
						(pickUpWeight cue:)
					)
				)
				(3
					(if (== (craneHook cel:) 12)
						(= local2 0)
						(pullRing cue:)
					)
				)
			)
		)
	)
)

(instance craneRCenter of PanelFeature ; UNUSED
	(properties
		nsBottom 103
		nsLeft 126
		nsRight 150
		nsTop 72
	)

	(method (doVerb theVerb)
		(return (== theVerb 5)) ; Do
	)
)

(instance craneBottom of PanelFeature
	(properties
		nsBottom 138
		nsLeft 122
		nsRight 150
		nsTop 109
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 130)) (not local2)) ; Do
			(switch local1
				(2
					(craneCableSound play:)
					(= local2 1)
					(gCurRoom setScript: pickUpWeight2)
				)
				(4
					(if (== (crane view:) 4480)
						(craneCableSound play:)
						(= local2 1)
						(gCurRoom setScript: dropWeight)
					)
				)
				(1
					(craneCableSound play:)
					(= local2 1)
					(gCurRoom setScript: pickUpWeight)
				)
				(3
					(craneCableSound play:)
					(= local2 1)
					(gCurRoom setScript: pullRing)
				)
			)
		)
	)
)

(instance leftCraneLever of PanelProp
	(properties
		x 21
		y 137
		cycleSpeed 0
		loop 4
		cel 11
		view 4483
	)
)

(instance rightCraneLever of PanelProp
	(properties
		x 21
		y 137
		cycleSpeed 0
		loop 5
		cel 11
		view 4483
	)
)

(instance weight of View
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance weight1 of View
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance extendedBridge of View
	(properties)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance leftWeight of View
	(properties
		x 65
		y 245
		loop 3
		view 4483
	)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance rightWeight of View
	(properties
		x 146
		y 227
		loop 3
		cel 1
		view 4483
	)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance ring of View
	(properties
		x 79
		y 217
		loop 1
		cel 1
		view 4483
	)

	(method (init)
		(super init: &rest)
		(self setPri: 999)
	)
)

(instance craneHook of Prop
	(properties)
)

(instance leverSoundScript of Script
	(properties)

	(method (dispose)
		(leverSound stop:)
		(craneLoop stop:)
		(craneStop play:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leverSound play: self)
			)
			(1
				(craneLoop play:)
			)
		)
	)
)

(instance pickUpWeight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightCraneLever setCycle: End self)
			)
			(1
				(pickUpSound play:)
				(craneHook
					view: 4481
					loop: 3
					cel: 0
					x: 25
					y: 68
					init:
					setCycle: CT 11 1 self
				)
				(leftWeight dispose:)
				(crane view: 4481 loop: 2 setCel: 0 x: 25 y: 68)
			)
			(2
				(rightCraneLever setCycle: CT 11 -1 self)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(rightCraneLever setCycle: Beg self)
			)
			(5
				(craneHook setCycle: End self)
			)
			(6
				(rightCraneLever setCycle: CT 10 1 self)
			)
			(7
				(= local1 0)
				(global216 at: 5 0)
				(gGame handsOn:)
				(crane view: 4480 x: 136 y: 277 setCel: 4)
				(craneHook dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pullRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightCraneLever setCycle: End self)
			)
			(1
				(craneHook
					view: 4481
					loop: 5
					cel: 0
					x: 135
					y: 277
					init:
					setCycle: CT 12 1 self
				)
				(crane view: 4481 loop: 4 setCel: 0 x: 135 y: 277)
			)
			(2
				(pickUpSound play:)
				(rightCraneLever setCycle: CT 11 -1 self)
			)
			(3
				(ring dispose:)
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(rightCraneLever setCycle: Beg self)
			)
			(5
				(craneHook setCycle: End self)
			)
			(6
				(rightCraneLever setCycle: CT 11 1 self)
			)
			(7
				(SetFlag 129)
				(ring cel: 0 x: 135 y: 277 init:)
				(craneHook dispose:)
				(crane view: 4485 loop: 0 cel: 12 x: 0 y: 12)
				(= local1 0)
				(= local2 0)
				(if (and (IsFlag 127) (IsFlag 128) (IsFlag 129))
					(gCurRoom setScript: openSeaGate)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance dropWeight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightCraneLever setCycle: End self)
			)
			(1
				(if (IsFlag 127)
					(scale
						view: 4482
						loop: 3
						x: 355
						y: 253
						init:
						setCycle: CT 10 1 self
					)
				else
					(craneHook
						view: 4482
						loop: 1
						cel: 0
						cycleSpeed: 12
						x: 195
						y: 117
						init:
						setCycle: End self
					)
				)
				(crane view: 4482 loop: 0 x: 195 y: 117)
			)
			(2
				(weightDrop play:)
				(rightCraneLever setCycle: CT 11 -1 self)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(rightCraneLever setCycle: Beg self)
			)
			(5
				(scaleSound play:)
				(craneHook dispose:)
				(if (IsFlag 127)
					(scale setCycle: End self)
				else
					(scale
						view: 4482
						loop: 2
						x: 355
						y: 253
						init:
						setCycle: End self
					)
				)
			)
			(6
				(rightCraneLever setCycle: CT 11 1 self)
			)
			(7
				(if (not (IsFlag 127))
					(SetFlag 127)
				else
					(SetFlag 128)
				)
				(scale view: 4483 loop: 0 cel: (if (IsFlag 128) 1 else 0))
				(crane view: 4485 loop: 0 setCel: 0 x: 0 y: 12)
				(= local1 0)
				(if (and (IsFlag 127) (IsFlag 128) (IsFlag 129))
					(gCurRoom setScript: openSeaGate)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance pickUpWeight2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightCraneLever setCycle: End self)
			)
			(1
				(crane view: 4481 loop: 0 setCel: 0 x: 133 y: 89)
				(craneHook
					view: 4481
					loop: 1
					cel: 0
					x: 133
					y: 89
					init:
					setPri: 999
					setCycle: CT 10 1 self
				)
			)
			(2
				(pickUpSound play:)
				(rightWeight dispose:)
				(rightCraneLever setCycle: CT 11 -1 self)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(rightCraneLever setCycle: Beg self)
			)
			(5
				(craneHook setCycle: End self)
			)
			(6
				(rightCraneLever setCycle: CT 10 1 self)
			)
			(7
				(= local1 0)
				(global216 at: 6 0)
				(gGame handsOn:)
				(crane view: 4480 x: 136 y: 277)
				(craneHook dispose:)
				(self dispose:)
			)
		)
	)
)

(instance rotateCraneRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crane setCycle: Beg self)
			)
			(1
				(crane setCel: (crane lastCel:))
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance rotateCraneLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crane setCycle: End self)
			)
			(1
				(crane setCel: 0)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance crankSnapsBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(gGame handsOff:)
				(bridgeSound loop: -1 play:)
				(crank setCycle: Rev)
				(bridge setCycle: Beg self)
			)
			(2
				(crank setCycle: 0 setCel: 0)
				(bridgeSound setLoop: 1 stop:)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openSeaGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(KillRobot 6489)
			)
			(1
				(proc0_9 6490 0 0)
				(SetFlag 130)
				(disposeCrane doit:)
			)
		)
	)
)

(instance retractBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1 1) dispose:) ; exitForward
				(unlatchSound play:)
				(latch setCycle: Beg self)
			)
			(1
				(bridgeSound loop: -1 play:)
				(crank setCycle: Rev)
				(bridge setCycle: Beg self)
			)
			(2
				(bridgeSound setLoop: 1 stop:)
				(crank setCycle: 0 setCel: 0)
				(bridge setCel: 0)
				(= local0 0)
				(ClearFlag 92)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leverSound of Sound
	(properties
		number 2019
		flags 1
	)
)

(instance craneLoop of Sound
	(properties
		number 2020
		flags 1
		loop -1
	)
)

(instance craneStop of Sound
	(properties
		number 2021
		flags 1
	)
)

(instance craneCableSound of Sound
	(properties
		number 2022
		flags 1
	)
)

(instance bridgeSound of Sound
	(properties
		number 2025
		flags 1
	)
)

(instance hatchSound of Sound
	(properties
		number 2026
		flags 1
	)
)

(instance bigMoveBack of ExitFeature
	(properties
		nsBottom 299
		nsLeft 90
		nsRight 410
		nsTop 250
		arrowStyle 4
	)
)

(instance weightATP of Prop
	(properties
		x 45
		y 137
		view 5450
	)
)

(instance pickUpSound of Sound
	(properties
		number 2034
		flags 1
	)
)

(instance scaleSound of Sound
	(properties
		number 2035
		flags 1
	)
)

(instance weightDrop of Sound
	(properties
		number 2036
		flags 1
	)
)

