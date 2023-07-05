;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 447)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm447 0
)

(local
	[local0 2]
	local2
	local3
)

(procedure (localproc_0 param1)
	(gCurRoom compassDir: param1)
	(if (IsFlag 368)
		((gGame compassFace:) setLoop: param1 setCel: 0)
	)
)

(procedure (localproc_1)
	(if (== ((ScriptID 9 11) cel:) 0) ; invRocks
		(gInventory deleteItem: (ScriptID 9 11)) ; invRocks
	else
		((ScriptID 9 11) cel: (- ((ScriptID 9 11) cel:) 1)) ; invRocks, invRocks
	)
	(cond
		((IsFlag 18)
			(ClearFlag 18)
			(if (IsFlag 425)
				(ClearFlag 425)
			else
				(SetFlag 425)
			)
		)
		((IsFlag 19)
			(ClearFlag 19)
			(if (IsFlag 419)
				(ClearFlag 419)
			else
				(SetFlag 419)
			)
		)
		((IsFlag 20)
			(ClearFlag 20)
			(if (IsFlag 420)
				(ClearFlag 420)
			else
				(SetFlag 420)
			)
		)
		((IsFlag 21)
			(ClearFlag 21)
			(if (IsFlag 421)
				(ClearFlag 421)
			else
				(SetFlag 421)
			)
		)
		((IsFlag 22)
			(ClearFlag 22)
			(if (IsFlag 422)
				(ClearFlag 422)
			else
				(SetFlag 422)
			)
		)
		((IsFlag 23)
			(ClearFlag 23)
			(if (IsFlag 423)
				(ClearFlag 423)
			else
				(SetFlag 423)
			)
		)
		((IsFlag 24)
			(ClearFlag 24)
			(if (IsFlag 424)
				(ClearFlag 424)
			else
				(SetFlag 424)
			)
		)
	)
)

(instance rm447 of LightRoom
	(properties
		picture 447
	)

	(method (init)
		(super init: &rest)
		(Random)
		(if (IsFlag 369)
			(SetFlag 387)
			(SetFlag 78)
		)
		(ClearFlag 75)
		(Lock rsAUDIO 41100 1)
		(Lock rsAUDIO 1006 1)
		(switch gPrevRoomNum
			(440
				(if (== (gBackMusic2 number:) 1006)
					(gBackMusic2 fade:)
				)
				(self changeScene: 446)
			)
			(470
				(= local3 1)
				(if (IsFlag 373)
					(self changeScene: 453)
				else
					(self changeScene: 458)
				)
			)
			(490
				(= local3 1)
				(self changeScene: 457)
			)
			(else
				(self changeScene: 446)
			)
		)
		(ClearFlag 373)
	)

	(method (dispose)
		(Lock rsAUDIO 41100 0)
		(Lock rsAUDIO 41101 0)
		(Lock rsAUDIO 1006 0)
		(windSound dispose:)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		((ScriptID 1 1) arrowStyle: 3) ; exitForward
		(sparrow dispose:)
		(hawkfea dispose:)
		(pend dispose:)
		(fidgitHawk dispose:)
		(fidgitHawk2 dispose:)
		(clock dispose:)
		(move447 dispose:)
		(move447_2 dispose:)
		(gateOpen dispose:)
		(bedRoomDoor dispose:)
		(waterFountain dispose:)
		(move448 dispose:)
		(move458 dispose:)
		(doorExit dispose:)
		(windChime dispose:)
		(hallDoor dispose:)
		(hawkBot dispose:)
		(hawkGate dispose:)
		(chimeSound stop:)
		(fountainSound stop:)
		(super changeScene: param1 &rest)
		(switch param1
			(429
				(localproc_0 5)
				(windChime view: 4463 posn: 248 199 setPri: 600 init:)
				(chimeSound init: number: 433 setLoop: -1 play:)
				((ScriptID 1 1) ; exitForward
					newPic: 454
					nsTop: 90
					nsLeft: 185
					nsBottom: 245
					nsRight: 315
				)
				((ScriptID 1 2) newPic: 438 6) ; exitBack
				(proc0_9 4440 152 32)
			)
			(438
				(localproc_0 6)
				((ScriptID 1 1) ; exitForward
					newPic: 449
					nsTop: 65
					nsLeft: 130
					nsBottom: 245
					nsRight: 295
				)
				((ScriptID 1 2) ; exitBack
					newPic: 429
					nsTop: 250
					nsLeft: 110
					nsBottom: 299
					nsRight: 330
				)
				(if (and (IsFlag 75) global209 (not (IsFlag 176)))
					(gCurRoom setScript: fidgitHawk2)
				)
				(if (IsFlag 404)
					(gateOpen init:)
				)
				(windSound number: 41100 setLoop: -1 play: setVol: 127)
			)
			(439
				(localproc_0 3)
				((ScriptID 1 1) ; exitForward
					newPic: 456
					nsTop: 50
					nsLeft: 220
					nsBottom: 245
					nsRight: 350
				)
				((ScriptID 1 2) newPic: 459) ; exitBack
				(windSound number: 41100 setLoop: -1 play: setVol: 110)
				(proc0_9 4442 0 85)
			)
			(446
				(localproc_0 4)
				((ScriptID 1 1) ; exitForward
					newPic: 439
					nsTop: 23
					nsLeft: 40
					nsBottom: 261
					nsRight: 222
				)
				((ScriptID 1 3) newRoom: 440) ; exitLeft
				(waterFountain init: setCycle: Fwd)
				(fountainSound init: number: 43301 setLoop: -1 play:)
				(windSound number: 41100 setLoop: -1 play: setVol: 110)
			)
			(447
				(localproc_0 3)
				(hallDoor init:)
				((ScriptID 1 4) newPic: 453 exitCode: closeHallDoor453) ; exitRight
				(move448 newPic: 448 init: exitCode: closeHallDoor448)
				(move458 init: newPic: 458 exitCode: closeHallDoor458)
				(windSound number: 41100 setLoop: -1 play: setVol: 120)
			)
			(448
				(localproc_0 2)
				((ScriptID 1 2) newPic: 447 arrowStyle: 2) ; exitBack
				(if (not (IsFlag 78))
					(proc0_9 151 119 93)
				)
			)
			(449
				(localproc_0 13)
				(if (not (gCast contains: pend))
					(pend init:)
				)
				(clock init:)
				(windSound number: 41100 setLoop: -1 play: setVol: 100)
				(if (IsFlag 404)
					(gateOpen init:)
				)
				((ScriptID 1 2) newPic: 429) ; exitBack
				((ScriptID 1 6) newPic: 452) ; exitUp
				((ScriptID 1 1) newPic: 450 exitCode: exitToGate) ; exitForward
				(if (and (not (IsFlag 176)) (IsFlag 75))
					(if (IsFlag 187)
						(gCurRoom setScript: landHawk)
					else
						(gCurRoom setScript: fidgitHawk)
						(hawkfea init:)
					)
				)
			)
			(450
				(localproc_0 13)
				(if (not (IsFlag 176))
					(gCurRoom setScript: hawkAttack)
				else
					(if (IsFlag 404)
						((ScriptID 1 1) ; exitForward
							newPic: 451
							nsTop: 95
							nsLeft: 260
							nsBottom: 299
							nsRight: 400
						)
						(gateOpen init:)
					else
						(hawkGate init:)
					)
					((ScriptID 1 2) newPic: 429) ; exitBack
				)
			)
			(451
				(localproc_0 4)
				((ScriptID 1 2) newPic: 457 exitCode: closeBedDoor) ; exitBack
				(bedRoomDoor init:)
				(hawkBot init: 4447 0 0 0 start: 1 10)
			)
			(452
				(localproc_0 11)
				((ScriptID 1 5) newPic: 449) ; exitDown
				(gMySoundFX number: 10060 setLoop: 1 play:)
				(cond
					((IsFlag 176))
					((== global209 3)
						(if (IsFlag 75)
							(proc0_9 4499 0 0)
						else
							(proc0_9 4498 0 0)
						)
					)
					((== global209 2)
						(if (IsFlag 75)
							(proc0_9 4500 0 0)
						else
							(proc0_9 4499 0 0)
						)
					)
					((and (== global209 1) (not (IsFlag 75)))
						(proc0_9 4500 0 0)
					)
				)
			)
			(453
				(localproc_0 5)
				((ScriptID 1 1) ; exitForward
					newPic: 459
					nsTop: 60
					nsLeft: 163
					nsBottom: 235
					nsRight: 305
				)
				((ScriptID 1 2) newPic: 456) ; exitBack
				(windSound number: 41100 setLoop: -1 play: setVol: 115)
				(if local3
					(= local3 0)
					(gMySoundFX number: 44801 setLoop: 0 play:)
				)
				(proc0_9 4448 0 0)
			)
			(454
				(localproc_0 1)
				(move447 init: newPic: 447)
				((ScriptID 1 1) ; exitForward
					newPic: 453
					nsTop: 35
					nsLeft: 310
					nsBottom: 289
					nsRight: 491
				)
				((ScriptID 1 3) newPic: 458) ; exitLeft
				(proc0_9 4449 302 129)
			)
			(456
				(localproc_0 12)
				(move447_2 init: newPic: 447)
				((ScriptID 1 1) ; exitForward
					newPic: 458
					nsTop: 39
					nsLeft: 30
					nsBottom: 298
					nsRight: 164
				)
				((ScriptID 1 2) newPic: 453) ; exitBack
				(windSound number: 41100 setLoop: -1 play: setVol: 105)
				(proc0_9 4450 0 88)
			)
			(457
				(localproc_0 9)
				(windSound number: 41100 setLoop: -1 play: setVol: 105)
				((ScriptID 1 1) ; exitForward
					newPic: 429
					nsTop: 80
					nsLeft: 100
					nsBottom: 255
					nsRight: 245
				)
				((ScriptID 1 2) ; exitBack
					newPic: 451
					nsTop: 257
					nsLeft: 85
					nsBottom: 299
					nsRight: 276
				)
				(proc0_9 4451 0 0)
				(FrameOut)
				(if local3
					(= local3 0)
					(gMySoundFX number: 43522 setLoop: 0 play:)
				)
			)
			(458
				(localproc_0 3)
				((ScriptID 1 1) ; exitForward
					newPic: 438
					nsTop: 30
					nsLeft: 205
					nsBottom: 240
					nsRight: 375
					arrowStyle: 7
				)
				((ScriptID 1 2) newPic: 454) ; exitBack
				(windChime view: 4460 posn: 137 139 init:)
				(chimeSound init: number: 433 setLoop: -1 play:)
				(windSound number: 41100 setLoop: -1 play: setVol: 110)
				(if local3
					(= local3 0)
					(gMySoundFX number: 44801 setLoop: 0 play:)
				)
				(proc0_9 4452 0 93)
			)
			(459
				(localproc_0 8)
				((ScriptID 1 1) ; exitForward
					newRoom: 440
					nsTop: 100
					nsLeft: 195
					nsBottom: 245
					nsRight: 400
					arrowStyle: 7
				)
				((ScriptID 1 2) newPic: 439) ; exitBack
				(windSound number: 41100 setLoop: -1 play: setVol: 120)
				(proc0_9 4453 73 85)
			)
		)
	)
)

(instance rockOnHawk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(++ global212)
				(localproc_1)
				(hawkBot dispose:)
				(if (and (not (mod global212 3)) global209)
					(KillRobot 4495 0 0 0)
					(if (== (-- global209) 0)
						(SetFlag 176)
					)
					(= global212 0)
				else
					(KillRobot 4506 0 0 0)
				)
			)
			(1
				(cond
					((not global209)
						(gGame handsOn:)
						(self dispose:)
					)
					((and global209 (not global212))
						(gGame handsOn:)
						(ClearFlag 75)
					)
					(else
						(gCurRoom setScript: fidgitHawk)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance showHawk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(KillRobot 4493 0 0 0)
			)
			(2
				(SetFlag 75)
				(DoRobot)
				(gCurRoom setScript: fidgitHawk)
				(hawkfea init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fidgitHawk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hawkBot dispose:)
				(if (< (Random 1 100) 75)
					(KillRobot 4501 0 0 0)
				else
					(KillRobot 4503 0 0 0)
				)
			)
			(1
				(DoRobot)
				(if (< (Random 1 100) 60)
					(KillRobot 4501 0 0 0)
				else
					(self changeState: (+ state 1))
				)
			)
			(2
				(DoRobot)
				(hawkBot init: 4501 6 0 0)
				(= local2 1)
				(= ticks (Random 30 60))
			)
			(3
				(= local2 0)
				(self changeState: 0)
			)
		)
	)
)

(instance fidgitHawk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hawkBot dispose:)
				(if (< (Random 1 100) 55)
					(KillRobot 4502 0 0 0)
				else
					(KillRobot 4505 0 0 0)
				)
			)
			(1
				(DoRobot)
				(hawkBot init: 4502 21 0 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance hawkAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(windSound stop:)
				(SetFlag 187)
				(gCurRoom drawPic: 449)
				(pend init:)
				(proc0_8 4494)
				(gCurRoom changeScene: 449 13)
				(self dispose:)
			)
		)
	)
)

(instance landHawk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(KillRobot 4504 0 0 0)
			)
			(1
				(DoRobot)
				(ClearFlag 187)
				(gGame handsOn:)
				(gCurRoom setScript: fidgitHawk)
				(hawkfea init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hawksRoost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Lock rsAUDIO 42203 1)
				(cond
					((or (IsFlag 176) (not (IsFlag 75)))
						(self changeState: 1)
					)
					(local2
						(fidgitHawk dispose:)
						(hawkBot init: 4501 0 0 0)
						(self changeState: 1)
					)
					(else
						(= state -1)
						(= ticks 10)
					)
				)
			)
			(1
				(if (and (not (IsFlag 176)) (IsFlag 75))
					(fidgitHawk dispose:)
					(hawkBot init: 4501 6 0 0)
				)
				(pend setCycle: CT 6 1 self)
			)
			(2
				(gMySoundFX number: 42203 setLoop: 0 play:)
				(pend setCycle: CT 15 1 self)
			)
			(3
				(gMySoundFX number: 42203 setLoop: 0 play:)
				(pend setCycle: End self)
			)
			(4
				(pend setCel: 0)
				(sparrowSings init:)
				(gMySoundFX number: 42202 setLoop: 0 play:)
				(sparrowSings setCycle: End self)
			)
			(5
				(sparrowSings cel: 0)
				(gMySoundFX number: 42202 setLoop: 0 play:)
				(sparrowSings setCycle: End self)
			)
			(6
				(sparrowSings cel: 0)
				(gMySoundFX number: 42202 setLoop: 0 play:)
				(sparrowSings setCycle: End self)
			)
			(7
				(sparrowSings dispose:)
				(if (and (not (IsFlag 176)) (IsFlag 75))
					(hawkBot dispose:)
					(KillRobot 4497 0 0 0)
					(SetFlag 176)
				else
					(= cycles 1)
				)
			)
			(8
				(DoRobot)
				(Lock rsAUDIO 42203 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pendSwings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 42203 1)
				(gGame handsOff:)
				(pend setCycle: CT 6 1 self)
			)
			(1
				(gMySoundFX number: 42203 setLoop: 0 play:)
				(pend setCycle: CT 15 1 self)
			)
			(2
				(gMySoundFX number: 42203 setLoop: 0 play:)
				(pend setCycle: End self)
			)
			(3
				(pend setCel: 0)
				(Lock rsAUDIO 42203 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openHawkGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(KillRobot 4457 0 0 0)
			)
			(1
				(SetFlag 404)
				(gateOpen init:)
				(DoRobot)
				(hawkGate dispose:)
				((ScriptID 1 1) ; exitForward
					newPic: 451
					nsTop: 95
					nsLeft: 260
					nsBottom: 299
					nsRight: 400
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hawkBot of RobotPlayer
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 9)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; invRocks
				(if (== (gCurRoom scene:) 449)
					(gCurRoom setScript: rockOnHawk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bedRoomDoor of Prop
	(properties
		x 179
		y 299
		view 4459
	)

	(method (init)
		(self setPri: 10 setCel: 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		((ScriptID 1 1) ; exitForward
			newRoom: 490
			nsTop: 65
			nsLeft: 180
			nsBottom: 225
			nsRight: 225
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(gMySoundFX number: 44800 setLoop: 0 play:)
					(self setCycle: End self)
				)
			)
		)
	)
)

(instance sparrow of Prop
	(properties
		x 204
		y 112
		view 4455
	)

	(method (cue)
		(SetFlag 374)
		(gInventory deleteItem: (ScriptID 9 40)) ; invSparrow
		(self dispose:)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gMySoundFX number: 42201 setLoop: 0 play:)
		(self setCycle: End self)
	)
)

(instance sparrowSings of Prop
	(properties
		x 384
		y 103
		loop 1
		view 4455
	)

	(method (init)
		(self view: 4455 setLoop: 1 setCel: 0 x: 382 y: 103)
		(super init: &rest)
	)
)

(instance gateOpen of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 450)
			(self view: 5444 setLoop: 0 setCel: 0 x: 240 y: 299)
		)
		(if (== (gCurRoom scene:) 438)
			(self view: 5446 setLoop: 0 setCel: 0 x: 242 y: 213)
		)
		(if (== (gCurRoom scene:) 449)
			(self view: 5443 setLoop: 0 setCel: 0 x: 177 y: 264)
		)
		(super init: &rest)
	)
)

(instance pend of Prop
	(properties
		x 415
		y 165
		view 4456
	)

	(method (cue)
		(self setCel: 0)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 374)
					(pend setScript: hawksRoost)
				else
					(self setScript: pendSwings)
				)
			)
		)
	)
)

(instance waterFountain of Prop
	(properties
		x 304
		y 97
		view 4464
	)
)

(instance windChime of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance hallDoor of Prop
	(properties
		x 284
		y 285
		view 4454
	)

	(method (init)
		(self setLoop: 0 setCel: 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(doorExit newRoom: 470)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(gMySoundFX number: 45109 setLoop: 0 play:)
					(self setCycle: End self)
				)
			)
		)
	)
)

(instance hawkfea of Feature
	(properties
		x 120
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 32 76 209 76 209 163 32 163
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 9)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; invRocks
				(if
					(and
						(== (gCurRoom scene:) 449)
						(not (IsFlag 176))
						(IsFlag 75)
					)
					(gCurRoom setScript: rockOnHawk)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clock of Feature
	(properties
		x 407
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 370 68 437 44 444 130 377 144
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 21)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; invSparrow
				(if (IsFlag 346)
					(sparrow init:)
				)
			)
		)
	)
)

(instance hawkGate of Feature
	(properties
		x 241
		y 173
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 297 419 298 408 100 327 62 254 102
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: openHawkGate)
			)
		)
	)
)

(instance move447 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(= nsLeft 245)
		(= nsTop 134)
		(= nsRight 305)
		(= nsBottom 299)
		(= arrowStyle 1)
		(super init: &rest)
	)
)

(instance move447_2 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(= nsLeft 165)
		(= nsTop 55)
		(= nsRight 220)
		(= nsBottom 250)
		(= arrowStyle 0)
		(super init: &rest)
	)
)

(instance move448 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(= nsLeft 51)
		(= nsTop 0)
		(= nsRight 80)
		(= nsBottom 139)
		(super init: &rest)
		(= x 52)
	)
)

(instance move458 of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 0)
		(= nsTop 20)
		(= nsRight 50)
		(= nsBottom 250)
		(super init: &rest)
	)
)

(instance doorExit of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 286)
		(= nsTop 80)
		(= nsRight 389)
		(= nsBottom 280)
		(super init: &rest)
	)
)

(instance closeBedDoor of Code
	(properties)

	(method (doit)
		(if (!= (bedRoomDoor cel:) 0)
			(gMySoundFX number: 45110 setLoop: 0 play:)
			(bedRoomDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 457)
	)
)

(instance closeHallDoor453 of Code
	(properties)

	(method (doit)
		(if (!= (hallDoor cel:) 0)
			(gMySoundFX number: 44801 setLoop: 0 play:)
			(hallDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 453)
	)
)

(instance closeHallDoor448 of Code
	(properties)

	(method (doit)
		(if (!= (hallDoor cel:) 0)
			(gMySoundFX number: 44801 setLoop: 0 play:)
			(hallDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 448)
	)
)

(instance closeHallDoor458 of Code
	(properties)

	(method (doit)
		(if (!= (hallDoor cel:) 0)
			(gMySoundFX number: 44801 setLoop: 0 play:)
			(hallDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 458)
	)
)

(instance exitToGate of Code
	(properties)

	(method (doit)
		(if (and (not (IsFlag 75)) (not (IsFlag 176)))
			(gCurRoom setScript: showHawk)
		else
			(gCurRoom changeScene: 450)
		)
	)
)

(instance chimeSound of Sound
	(properties)
)

(instance fountainSound of Sound
	(properties)
)

(instance windSound of Sound
	(properties)
)

