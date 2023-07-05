;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Print)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	[local0 7]
	local7
	local8
	local9
	local10
	local11
	local12 = 1
	local13
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

(instance rm470 of LightRoom
	(properties
		picture 476
	)

	(method (init)
		(gBackMusic stop:)
		(gMySoundFX stop:)
		(super init: &rest)
		(if (IsFlag 369)
			(SetFlag 387)
			(SetFlag 78)
			(= global115 1)
		)
		(Lock rsVIEW 4473 1)
		(if (or (IsFlag 387) (IsFlag 311))
			(gBackMusic setVol: 60)
		)
		(scriptProp init:)
		(switch gPrevRoomNum
			(480
				(cond
					((IsFlag 51)
						(ClearFlag 51)
						(self changeScene: 460)
					)
					((IsFlag 52)
						(ClearFlag 52)
						(self changeScene: 482)
					)
					(else
						(Prints
							{Error: Room 470 doesn't know which pic to show.}
						)
					)
				)
			)
			(765
				(if (IsFlag 304)
					(self changeScene: 465)
				else
					(self changeScene: 476)
				)
			)
			(else
				(= local13 1)
				(self changeScene: 476)
			)
		)
		(gBackMusic number: 1007 setLoop: -1 play: 127 0)
		(gGame handsOn:)
	)

	(method (changeScene param1)
		(modifyRC dispose:)
		((ScriptID 1 1) arrowStyle: 3) ; exitForward
		((ScriptID 1 3) arrowStyle: 1) ; exitLeft
		((ScriptID 1 4) arrowStyle: 0) ; exitRight
		(windowFeature dispose:)
		(outDoorLeft dispose:)
		(outDoorRight dispose:)
		(doorProp dispose:)
		(move479 dispose:)
		(rockOnBirdMan dispose:)
		(dooDadsFeature dispose:)
		(dooDadsGone dispose:)
		(tool dispose:)
		(dremelTable dispose:)
		(RC dispose:)
		(antenna dispose:)
		(hammer dispose:)
		(RCTipped dispose:)
		(RCGone dispose:)
		(blankWall dispose:)
		(dremel dispose:)
		(toolFeature dispose:)
		(hammerGone dispose:)
		(toolGone dispose:)
		(hallGate dispose:)
		(lockFeat dispose:)
		(toolTable dispose:)
		(radioTable dispose:)
		(topGate dispose:)
		(bottomGate dispose:)
		(pLever dispose:)
		((ScriptID 1 1) exitCode: 0) ; exitForward
		(rightWindowGate dispose:)
		(birdProp dispose:)
		(RCFeature dispose:)
		(if (!= global115 1)
			(comeToSmashRC state: (- (comeToSmashRC state:) 1))
			(if (== (birdManSmash number:) 168)
				(= local9 (+ (= local10 (birdManSmash curFrame:)) 26))
			else
				(= local10 (- (= local9 (birdManSmash curFrame:)) 26))
			)
		)
		(if global208
			(birdMan dispose:)
			(= local8 1)
			(birdManSmash dispose:)
			(= local8 0)
		)
		(super changeScene: param1 &rest)
		(if (!= global115 1)
			(birdManSmash init: 1)
		)
		(if
			(and
				(or (== (birdMan number:) 465) (== (birdMan number:) 163))
				(not (or (== (gCurRoom scene:) 467) (== (gCurRoom scene:) 465)))
			)
			(gMySoundFX stop:)
		)
		(switch param1
			(460
				(localproc_0 3)
				((ScriptID 1 1) newPic: 461 3) ; exitForward
				(if (== global226 2)
					((ScriptID 1 4) ; exitRight
						newPic: 479
						nsLeft: 330
						nsTop: 50
						nsRight: 499
						nsBottom: 299
					)
				)
				((ScriptID 1 2) newPic: 482 7) ; exitBack
				(hallGate init:)
				(if (not (IsFlag 78))
					(proc0_9 160 190 79)
				)
			)
			(461
				(localproc_0 3)
				((ScriptID 1 2) newPic: 481 7) ; exitBack
				(Load rsVIEW 4466)
				(hammer init:)
				(if (not (IsFlag 294))
					(tool init:)
				)
				(cond
					((IsFlag 164))
					((IsFlag 83)
						(RCTipped init:)
					)
					(else
						(RC init:)
					)
				)
				(if (IsFlag 68)
					(pLever init:)
					(bottomGate init: posn: 114 166)
					(topGate init: posn: 106 -19)
					(if (not (IsFlag 78))
						(birdMan init: 161 0 206 78 start: 1 10 1)
					)
				else
					((ScriptID 1 1) ; exitForward
						newPic: 465
						nsLeft: 150
						nsTop: 80
						nsRight: 350
						nsBottom: 195
					)
				)
				(if (and (not (IsFlag 78)) (not (IsFlag 68)))
					(Load rsAUDIO 450)
					(gCurRoom setScript: sCloseGate)
				)
			)
			(464
				(localproc_0 3)
				(SetFlag 181)
				((ScriptID 1 1) newPic: 465 3) ; exitForward
				((ScriptID 1 2) newPic: 481 7) ; exitBack
				(if (not (IsFlag 78))
					(gCurRoom setScript: birdManLeaves)
				)
			)
			(465
				(localproc_0 3)
				(cond
					((IsFlag 164)
						(RCGone init:)
					)
					((IsFlag 83)
						(RCTipped init:)
					)
				)
				(if (IsFlag 380)
					(dooDadsGone init:)
				)
				(dremel init:)
				(hammer init:)
				(if (IsFlag 294)
					(toolGone init:)
				)
				(toolTable init:)
				(radioTable init:)
				(if
					(and
						(not local11)
						(== (mod local7 4) 0)
						(== global115 1)
						(or
							(== (birdMan number:) 465)
							(== (birdMan number:) 163)
						)
						(< 0 (birdMan curFrame:) (birdMan maxFrame:))
						(not (IsFlag 387))
					)
					(birdMan
						init: 465 (birdMan curFrame:) -295 -13 -1
						start: 1 10
					)
					(gMySoundFX number: 44002 setLoop: -1 play:)
				else
					(++ local7)
					(if
						(and
							(not local11)
							(== (mod local7 4) 0)
							(== global115 1)
							(not (IsFlag 387))
						)
						(birdMan init: 465 0 -295 -13 -1 start: 1 10)
						(gMySoundFX number: 44002 setLoop: -1 play:)
					)
				)
				((ScriptID 1 4) newPic: 466 2) ; exitRight
				((ScriptID 1 3) newPic: 467 4) ; exitLeft
				(if (== global115 1)
					((ScriptID 1 1) ; exitForward
						newPic: 474
						nsTop: 80
						nsLeft: 60
						nsBottom: 185
						nsRight: 175
						arrowStyle: 10
					)
					((ScriptID 1 2) newPic: 470 7) ; exitBack
				)
			)
			(466
				(localproc_0 2)
				(if (IsFlag 380)
					(dooDadsGone init:)
				)
				(if (IsFlag 294)
					(toolGone init:)
				)
				(rightWindowGate init:)
				((ScriptID 1 3) newPic: 465 3) ; exitLeft
				(if (== global115 1)
					((ScriptID 1 4) newPic: 470 7) ; exitRight
					((ScriptID 1 2) newPic: 469) ; exitBack
				)
				(++ local7)
				(if
					(and
						(not (IsFlag 387))
						(== (mod local7 4) 2)
						(== global115 1)
					)
					(KillRobot 154 262 0)
				)
			)
			(467
				(localproc_0 4)
				((ScriptID 1 4) newPic: 465 3) ; exitRight
				(if (== global115 1)
					((ScriptID 1 3) newPic: 470 7) ; exitLeft
					((ScriptID 1 2) newPic: 473) ; exitBack
					((ScriptID 1 1) ; exitForward
						newPic: 474
						nsTop: 80
						nsLeft: 240
						nsBottom: 185
						nsRight: 340
						arrowStyle: 10
					)
				)
				(if (IsFlag 326)
					(RC init:)
				)
				(dremel init:)
				(dremelTable init:)
				(radioTable init:)
				(cond
					((IsFlag 164)
						(RCGone init:)
					)
					((IsFlag 83)
						(RCTipped init:)
					)
				)
				(if (IsFlag 293)
					(hammerGone init:)
					(if (not local11)
						(hammer init:)
					)
				)
				(if
					(and
						(not local11)
						(== (mod local7 4) 0)
						(== global115 1)
						(or
							(== (birdMan number:) 465)
							(== (birdMan number:) 163)
						)
						(< 0 (birdMan curFrame:) (birdMan maxFrame:))
						(not (IsFlag 387))
					)
					(birdMan
						init: 163 (birdMan curFrame:) 161 -15 -1
						start: 1 10
					)
					(gMySoundFX number: 44002 setLoop: -1 play:)
				else
					(++ local7)
					(if
						(and
							(not local11)
							(== (mod local7 4) 0)
							(== global115 1)
							(not (IsFlag 387))
						)
						(birdMan init: 163 0 161 -15 -1 start: 1 10)
						(gMySoundFX number: 44002 setLoop: -1 play:)
					)
				)
			)
			(469
				(localproc_0 6)
				((ScriptID 1 1) ; exitForward
					newPic: 470
					nsTop: 85
					nsLeft: 90
					nsBottom: 250
					nsRight: 300
					arrowStyle: 8
				)
				((ScriptID 1 4) ; exitRight
					newPic: 467
					nsTop: 85
					nsLeft: 300
					nsBottom: 250
					nsRight: 499
					arrowStyle: 7
				)
				(if (IsFlag 294)
					(toolGone init:)
				)
				(if (IsFlag 380)
					(dooDadsGone init:)
				)
				((ScriptID 1 2) newPic: 466) ; exitBack
			)
			(470
				(localproc_0 7)
				(if (== global115 1)
					((ScriptID 1 1) newPic: 481 7) ; exitForward
				)
				((ScriptID 1 3) newPic: 466 2) ; exitLeft
				((ScriptID 1 4) newPic: 467 4) ; exitRight
				((ScriptID 1 2) newPic: 465 3) ; exitBack
			)
			(472
				(localproc_0 3)
				(if (IsFlag 380)
					(dooDadsGone init:)
				else
					(dooDadsFeature init:)
				)
				(if (IsFlag 293)
					(hammerGone init:)
				)
				(if (IsFlag 294)
					(toolGone init:)
				else
					(toolFeature init:)
				)
				((ScriptID 1 2) newPic: 465 arrowStyle: 2) ; exitBack
			)
			(473
				(localproc_0 8)
				(if (IsFlag 82)
					(blankWall init:)
				)
				(if (IsFlag 294)
					(toolGone init:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 470
					nsTop: 85
					nsLeft: 210
					nsBottom: 250
					nsRight: 440
					arrowStyle: 7
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 466
					nsTop: 85
					nsLeft: 0
					nsBottom: 250
					nsRight: 210
					arrowStyle: 8
				)
				((ScriptID 1 2) newPic: 467) ; exitBack
			)
			(474
				(localproc_0 3)
				(if (IsFlag 327)
					(antenna init:)
				)
				(cond
					((IsFlag 164)
						(RCGone init:)
					)
					((IsFlag 83)
						(RCFeature init:)
						(RCTipped init:)
					)
					(else
						(RCFeature init:)
					)
				)
				(if (IsFlag 293)
					(hammer init:)
				)
				((ScriptID 1 2) newPic: 465 arrowStyle: 2) ; exitBack
			)
			(476
				(localproc_0 3)
				((ScriptID 1 1) newPic: 460 3) ; exitForward
				((ScriptID 1 2) newPic: 482 7) ; exitBack
				(SetFlag 182)
				(hallGate init:)
				(if local13
					(FrameOut)
					(= local13 0)
					(gMySoundFX number: 45110 setLoop: 0 play:)
				)
				(if (not (IsFlag 78))
					(proc0_9 159 206 63)
				)
			)
			(479
				(localproc_0 1)
				((ScriptID 1 3) newPic: 460 3) ; exitLeft
				((ScriptID 1 1) newRoom: 480) ; exitForward
				((ScriptID 1 4) newPic: 482 7) ; exitRight
			)
			(481
				(localproc_0 7)
				((ScriptID 1 1) newPic: 482 7) ; exitForward
				((ScriptID 1 2) newPic: 461 3) ; exitBack
				(if (== global226 2)
					(move479 init: newPic: 479)
				)
			)
			(482
				(localproc_0 7)
				(doorProp init:)
				(if (== global226 2)
					((ScriptID 1 3) ; exitLeft
						newPic: 479
						nsLeft: 0
						nsTop: 0
						nsRight: 130
						nsBottom: 299
						exitCode: closeDoorLeft
					)
				)
				((ScriptID 1 2) newPic: 476 exitCode: closeDoor180) ; exitBack
			)
		)
	)

	(method (dispose)
		(if (gPanels contains: RCPanel)
			(= local12 1)
		)
		(gMySoundFX stop:)
		(gBackMusic fade:)
		(clickSounds dispose:)
		(Lock rsVIEW 4473 0)
		(super dispose: &rest)
	)
)

(instance comeToSmashRC of Script
	(properties)

	(method (init)
		(== scratch 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 44001 1)
				(Lock rsAUDIO 44005 1)
				(Lock rsAUDIO 44006 1)
				(clickSounds init: number: 44301 setLoop: -1 play:)
				(ClearFlag 78)
				(= local11 1)
				(= global115 4)
				(gMySoundFX number: 446 setLoop: 0 play:)
				(= ticks 70)
			)
			(1
				(if (IsFlag 82)
					(ClearFlag 82)
					(gMySoundFX number: 447 setLoop: 0 play:)
				)
				(= cycles 1)
			)
			(2
				(if (not local8)
					(birdManSmash init: 1)
				)
			)
			(3
				(if (== (gCurRoom scene:) 466)
					(gCurRoom changeScene: 465)
				)
				(= local10 (- (= local9 0) 26))
				(= cycles 1)
			)
			(4
				(= global115 3)
				(if (not local8)
					(birdManSmash init: 1)
				)
			)
			(5
				(clickSounds stop:)
				(if (IsFlag 379)
					(= global115 1)
					(gCurRoom changeScene: 465)
					(birdManSmash dispose:)
					(KillRobot 3155 0 0 0 500)
					(dremel dispose:)
				else
					(= local9 0)
					(SetFlag 293)
					(SetFlag 83)
					(SetFlag 327)
					(= cycles 1)
				)
			)
			(6
				(gGame handsOnCode: noCode)
				(gGame handsOff:)
				(= global115 1)
				(SetFlag 78)
				(birdManSmash caller: 0)
				(birdManSmash dispose:)
				(gCurRoom changeScene: 465)
				(DoRobot)
				(KillRobot 3156 221 65 0 500)
			)
			(7
				(gCurRoom changeScene: 466)
				(DoRobot)
				(KillRobot 152 94 18)
			)
			(8
				(= local7 1)
				(if (and (== global209 0) (IsFlag 395))
					(SetFlag 387)
					(gCurRoom drawPic: 165)
					(rightWindowGate dispose:)
					(DoRobot)
					(KillRobot 3149 0 0)
				else
					(= cycles 1)
				)
			)
			(9
				(= local11 0)
				(SetFlag 311)
				(gCurRoom changeScene: 465)
				(gGame handsOnCode: 0)
				(gGame handsOn:)
				(birdMan number: 0)
				(Lock rsAUDIO 44001 0)
				(Lock rsAUDIO 44005 0)
				(Lock rsAUDIO 44006 0)
				(self dispose:)
			)
		)
	)
)

(instance rockOnBirdMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(birdMan stop: init: 155 0 179 12 caller: self start: 1 10)
				((ScriptID 1 1) exitCode: myExitCode) ; exitForward
			)
			(1
				(birdMan dispose:)
				(birdProp init: cycleSpeed: 6 setCycle: End self)
			)
			(2
				(birdProp dispose:)
				(birdMan init: 161 0 206 78 start: 1 10 1)
				(if (not (IsFlag 68))
					(gCurRoom setScript: sCloseGate)
				)
				(self dispose:)
			)
		)
	)
)

(instance sCloseGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 1 1) dispose:) ; exitForward
				(birdProp dispose:)
				(topGate init:)
				(bottomGate init:)
				(if global208
					(birdMan dispose:)
				)
				(if (and (not (IsFlag 68)) (IsFlag 79))
					(KillRobot 150 204 78)
				else
					(birdMan init: 150 20 204 78 caller: self start: 1 10)
				)
			)
			(1
				(SetFlag 79)
				(DoRobot)
				(KillRobot 1501 203 79)
				(bottomGate setMotion: MoveTo (bottomGate x:) 166)
				(topGate setMotion: MoveTo (topGate x:) -19)
				(gMySoundFX number: 450 setLoop: 0 play:)
			)
			(2
				(DoRobot)
				(pLever setCel: 0 init:)
				(birdProp init: setCycle: End self)
			)
			(3
				(birdProp dispose:)
				(birdMan caller: 0 init: 161 0 206 78 start: 1 10 1)
				(SetFlag 68)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockOnLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 387))
					(gGame handsOff:)
				)
				(localproc_1)
				(pLever
					setCel: 0
					setLoop: 0
					cycleSpeed: 6
					setCycle: CT 12 1 self
				)
			)
			(1
				(gMySoundFX number: 44101 setLoop: 0 play:)
				(pLever setCycle: End self)
			)
			(2
				(gMySoundFX number: 451 setLoop: 0 play:)
				(topGate setMotion: MoveTo (topGate x:) -148)
				(bottomGate setMotion: MoveTo (bottomGate x:) 297 self)
			)
			(3
				(ClearFlag 68)
				(if (and (== (birdMan number:) 161) (not (IsFlag 387)))
					(Load rsAUDIO 450)
					(gCurRoom setScript: sCloseGate)
				else
					((ScriptID 1 1) init:) ; exitForward
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance birdManLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(birdProp dispose:)
				(gGame handsOff:)
				(gCurRoom drawPic: 464)
				(KillRobot 167 167 54)
			)
			(1
				(rightWindowGate init: hide:)
				(gCurRoom drawPic: 466)
				(rightWindowGate show:)
				(DoRobot)
				(KillRobot 152 94 18)
			)
			(2
				(rightWindowGate dispose:)
				(gGame handsOn:)
				(SetFlag 78)
				(= global115 1)
				(gCurRoom changeScene: 464)
				(self dispose:)
			)
		)
	)
)

(instance openRC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local12 0)
				(gMySoundFX number: 44804 setLoop: 0 play:)
				(RCProp cycleSpeed: 5 setCycle: CT 17 1 self)
			)
			(1
				(modifyRC init: RCPanel 1 1 doit:)
				(RCProp setCycle: End self)
			)
			(2
				(springFeature init: RCPanel)
				(SetFlag 330)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeRC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 44004 setLoop: 0 play:)
				(if (not (IsFlag 328))
					(RCProp view: 4473)
				else
					(RCProp view: 4478)
				)
				(if (not (IsFlag 328))
					(wallPaper view: 4475 setLoop: 0)
				else
					(wallPaper view: 4476 setLoop: 0)
				)
				(RCProp loop: 1 cycleSpeed: 5 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(modifyRC setPri: -101)
				(RCProp setCycle: End self)
			)
			(2
				(ClearFlag 330)
				(= local12 1)
				(RCPanel dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance topGate of Actor
	(properties
		x 106
		y -148
		view 4466
	)

	(method (init)
		(self
			setStep: 1 2
			cycleSpeed: 1
			setLoop: 1
			moveSpeed: 0
			ignoreActors: 1
			setPri: 600
			ignoreHorizon:
		)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance bottomGate of Actor
	(properties
		x 114
		y 297
		view 4466
	)

	(method (init)
		(self setStep: 1 2 cycleSpeed: 1 setLoop: 2 moveSpeed: 0 setPri: 600)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance dremel of Prop
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 467)
			(self view: 170 setPri: 6000 x: 31 y: 173)
		else
			(self view: 169 setPri: 600 x: 0 y: 233)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
		(self setCel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (== local11 1) (== (gCurRoom scene:) 467))
					(if
						(and
							(< 22 (birdManSmash curFrame:) 58)
							(== (birdManSmash number:) 168)
						)
						(SetFlag 379)
						(birdManSmash caller: 0)
						(gGame handsOff:)
						(comeToSmashRC cue:)
					)
					(if (!= (birdManSmash number:) 168)
						(gGame handsOff:)
						(gMySoundFX number: 44802 setLoop: 0 play:)
						(self setCycle: End self)
					)
				)
				(if (and (== (gCurRoom scene:) 467) (not local11))
					(gGame handsOff:)
					(gMySoundFX number: 44802 setLoop: 0 play:)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pLever of Prop
	(properties
		x 150
		y 250
		view 4465
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 9)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; invRocks
				(Load rsAUDIO 451)
				(if (IsFlag 68)
					(scriptProp setScript: rockOnLever)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance birdProp of Prop
	(properties
		x 250
		y 254
		view 3157
	)
)

(instance doorProp of Prop
	(properties
		x 129
		y 1
		view 482
	)

	(method (init)
		(self setCel: 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(outDoorLeft init: exitCode: exitLeft)
		(outDoorRight init: newRoom: 447)
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

(instance rightWindowGate of Prop
	(properties
		x 232
		y 299
		view 4467
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 82))
			(self setCel: (self lastCel:))
		else
			(self setCel: 0)
			(lockFeat init:)
			(windowFeature init:)
		)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(lockFeat init:)
		(windowFeature init:)
		(gGame handsOn:)
		(SetFlag 82)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (or (IsFlag 81) (!= global115 1))
					(return)
				)
				(if (IsFlag 82)
					(ClearFlag 82)
					(lockFeat dispose:)
					(windowFeature dispose:)
					(gMySoundFX number: 447 setLoop: 0 play:)
					(self setCycle: End)
				else
					(gGame handsOff:)
					(gMySoundFX number: 448 setLoop: 0 play:)
					(self cycleSpeed: 4 setCycle: Beg self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scriptProp of Prop
	(properties
		view 4465
		z 1000
	)
)

(instance RCTipped of View
	(properties)

	(method (init)
		(cond
			((== (gCurRoom scene:) 467)
				(self view: 2302 setLoop: 2 x: 333 y: 124 setPri: 2000)
			)
			((== (gCurRoom scene:) 465)
				(self view: 2301 setLoop: 2 x: 89 y: 121 setPri: 450)
			)
			((== (gCurRoom scene:) 474)
				(self view: 2307 setLoop: 1 x: 155 y: 70 setPri: 210)
			)
			((== (gCurRoom scene:) 461)
				(self view: 461 setLoop: 2 x: 179 y: 195 setPri: 200)
			)
		)
		(super init: &rest)
	)
)

(instance RCGone of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 467)
			(self view: 2302 setLoop: 1 x: 286 y: 115 setPri: 2000)
		)
		(if (== (gCurRoom scene:) 465)
			(self view: 2301 setLoop: 1 x: 89 y: 122 setPri: 450)
		)
		(if (== (gCurRoom scene:) 474)
			(self view: 2307 setLoop: 0 x: 100 y: 44 setPri: 200)
		)
		(super init: &rest)
	)
)

(instance dooDadsGone of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 465)
			(self view: 2301 setLoop: 5 x: 311 y: 245 setPri: 450)
		)
		(if (== (gCurRoom scene:) 466)
			(self view: 4467 setLoop: 3 x: 0 y: 279 setPri: 200)
		)
		(if (== (gCurRoom scene:) 472)
			(self view: 2305 setLoop: 2 x: 285 y: 48 setPri: 200)
		)
		(if (== (gCurRoom scene:) 469)
			(self view: 469 setLoop: 0 x: 443 y: 264 setPri: 200)
		)
		(super init: &rest)
	)
)

(instance RC of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 461)
			(self view: 461 setLoop: 4 x: 179 y: 199 setPri: 199)
		else
			(self view: 2302 setLoop: 4 x: 55 y: 92 setPri: 900)
			(if (IsFlag 328)
				(self setCel: 1)
			else
				(self setCel: 0)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((and (IsFlag 329) (not (IsFlag 328)))
						(SetFlag 312)
						(invAddSound play:)
						(gInventory addItem: (ScriptID 9 45)) ; invRadioControl
						(ClearFlag 326)
						(self dispose:)
					)
					((== (gCurRoom scene:) 467)
						(RCPanel init:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tool of View
	(properties)

	(method (init)
		(self view: 461 setLoop: 0 x: 259 y: 218 setPri: 218)
		(super init:)
	)
)

(instance antenna of View
	(properties)

	(method (init)
		(self view: 2307 setLoop: 2 x: 167 y: 226 setPri: 500)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX number: 43512 setLoop: 0 play:)
				(gInventory addItem: (ScriptID 9 83)) ; invAntenna
				(ClearFlag 327)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hammerGone of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 467)
			(self view: 2302 setLoop: 0 x: 298 y: 220 setPri: 2000)
		)
		(if (== (gCurRoom scene:) 472)
			(self view: 2305 setLoop: 0 x: 39 y: 27 setPri: 200)
		)
		(super init: &rest)
	)
)

(instance hammer of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 465)
			(if (IsFlag 293)
				(if (not (IsFlag 379))
					(self view: 2301 setLoop: 4 x: 98 y: 227 setPri: 455)
				else
					(return)
				)
			else
				(self view: 2301 setLoop: 3 x: 178 y: 230 setPri: 600)
			)
		)
		(if (== (gCurRoom scene:) 474)
			(if (not (IsFlag 379))
				(self view: 471 x: 109 y: 206 setPri: 220)
			else
				(return)
			)
		)
		(if (== (gCurRoom scene:) 467)
			(if (not (IsFlag 379))
				(self view: 2302 setLoop: 3 x: 297 y: 224 setPri: 2240)
			else
				(return)
			)
		)
		(if (== (gCurRoom scene:) 461)
			(if (IsFlag 293)
				(if (not (IsFlag 379))
					(self view: 461 setLoop: 3 x: 145 y: 199 setPri: 200)
				else
					(return)
				)
			else
				(self view: 461 setLoop: 1 x: 215 y: 225 setPri: 225)
			)
		)
		(super init: &rest)
	)
)

(instance toolGone of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 465)
			(self view: 2301 setLoop: 0 x: 181 y: 210 setPri: 450)
		)
		(if (== (gCurRoom scene:) 472)
			(self view: 2305 setLoop: 1 x: 198 y: 132 setPri: 200)
		)
		(if (== (gCurRoom scene:) 473)
			(self view: 2306 setLoop: 0 x: 0 y: 0 setPri: 200)
		)
		(if (== (gCurRoom scene:) 466)
			(self view: 4467 setLoop: 2 x: 0 y: 299 setPri: 200)
		)
		(if (== (gCurRoom scene:) 469)
			(self view: 469 setLoop: 1 x: 346 y: 238 setPri: 200)
		)
		(super init: &rest)
	)
)

(instance hallGate of View
	(properties)

	(method (init)
		(self setPri: 200)
		(cond
			((== (gCurRoom scene:) 476)
				(if (IsFlag 68)
					(self view: 2309 setLoop: 1 posn: 223 40)
				else
					(self view: 2309 setLoop: 0 posn: 201 6)
				)
			)
			((IsFlag 68)
				(self view: 2308 setLoop: 1 posn: 202 39)
			)
			(else
				(self view: 2308 setLoop: 0 posn: 191 1)
			)
		)
		(super init: &rest)
	)
)

(instance dremelTable of Feature
	(properties
		x 127
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 134 154 134 255 187 255 194 0 234
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 55 54)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; invRadioBroke
				(if (not (IsFlag 329))
					(gMySoundFX number: 43905 setLoop: 0 play:)
					(SetFlag 326)
					(gInventory deleteItem: (ScriptID 9 46)) ; invRadioBroke
					(RC init:)
				)
			)
			(54 ; invRadioControl
				(if (not (IsFlag 329))
					(gMySoundFX number: 43905 setLoop: 0 play:)
					(SetFlag 326)
					(gInventory deleteItem: (ScriptID 9 45)) ; invRadioControl
					(RC init:)
				)
			)
			(5 ; Do
				(if (IsFlag 326)
					(RC doVerb: 5)
				)
			)
		)
	)
)

(instance RCFeature of Feature
	(properties
		x 260
		y 162
	)

	(method (init)
		(self
			setPolygon:
				(if (IsFlag 83)
					((Polygon new:)
						type: PTotalAccess
						init: 245 242 268 233 287 231 290 217 302 213 302 181 279 179 268 179 233 177 218 180 210 192 203 197 200 220 210 228 213 238
						yourself:
					)
				else
					((Polygon new:)
						type: PTotalAccess
						init: 221 195 287 211 299 203 298 168 288 159 299 154 296 141 285 134 272 113 250 113 234 132 225 138 225 152 236 152 221 176
						yourself:
					)
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 81)
					(SetFlag 311)
				)
				(if (or (IsFlag 311) (IsFlag 387))
					(SetFlag 164)
					(RCGone init:)
					(RCTipped dispose:)
					(invAddSound play:)
					(if (IsFlag 83)
						(SetFlag 328)
						(gInventory addItem: (ScriptID 9 46)) ; invRadioBroke
						(self dispose:)
					else
						(gInventory addItem: (ScriptID 9 45)) ; invRadioControl
						(self dispose:)
					)
				else
					(SetFlag 388)
					((ScriptID 9 45) doVerb: 5) ; invRadioControl
					(ClearFlag 388)
					(if (not local11)
						(gCurRoom setScript: comeToSmashRC)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blankWall of View
	(properties
		view 2306
	)

	(method (init)
		(self setPri: 200)
		(self setLoop: 1)
		(super init: &rest)
	)
)

(instance modifyRC of PanelProp
	(properties
		view 4473
	)

	(method (init)
		(self x: 0 y: 0 setPri: 888)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(cond
			((IsFlag 329)
				(self setLoop: 4 setCel: 0)
			)
			((IsFlag 331)
				(self setLoop: 2 setCel: 0)
			)
			(else
				(self setLoop: 3 setCel: 0)
			)
		)
		(self show:)
		(super doit: &rest)
	)
)

(instance dooDadsFeature of Feature
	(properties
		x 321
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 65 324 136 362 114 351 95 362 71 320 51
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 380)
				(dooDadsGone init:)
				(invAddSound play:)
				(gInventory addItem: (ScriptID 9 85)) ; invDooDads
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toolFeature of Feature
	(properties
		x 280
		y 194
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 214 222 232 264 217 285 226 289 235 274 246 284 261 329 247 328 225 305 230 302 219 315 195 322 194 332 201 345 191 334 163 317 171 316 181 306 182 280 169 277 162 286 155 282 145 274 143 270 127 261 134 260 140 248 132 243 137 248 147 245 165 247 173 266 172 266 175 256 198
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 294)
				(toolGone init:)
				(invAddSound play:)
				(gInventory addItem: (ScriptID 9 70)) ; invTool
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toolTable of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 215 95 282 500 282 494 259 426 213
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== global115 1)
					(gCurRoom changeScene: 472)
				)
			)
		)
	)
)

(instance radioTable of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (== (gCurRoom scene:) 465)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 96 210 185 212 208 192 180 181 169 164 154 161 142 191
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 289 218 393 231 429 207 346 197
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== global115 1)
					(gCurRoom changeScene: 474)
				)
			)
		)
	)
)

(instance lockFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 142 300 185 260 182 259 141
					yourself:
				)
		)
		(approachX hotVerbs: 5 42)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(lockPanel init:)
			)
			(42 ; invDeskKey
				(lockPanel init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance RCPanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(ClearFlag 330)
		(RCProp init: self 1 1)
		(dremelFeature init: self 1 1)
		(wallPaper view: 4476 init: RCPanel 1 1 setLoop: 0 setPri: -100)
		(leftGearFeature init: self)
		(rightGearFeature init: self)
		(antennaFeature init: self)
	)

	(method (dispose)
		(if local12
			(RC init:)
			(gGame handsOn:)
			(super dispose: &rest)
		else
			(gCurRoom setScript: closeRC)
		)
	)
)

(instance lockPanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(wallPaper view: 4468 init: self 1 1 setLoop: 1 setCel: 0 setPri: -100)
		(lockInset init: self 1 1)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(lockPanel dispose:)
	)
)

(instance lockInset of PanelProp
	(properties)

	(method (init)
		(self view: 4468 setLoop: 1 setCel: 0)
		(super init: &rest)
		(approachX hotVerbs: 42)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; invDeskKey
				(gGame handsOff:)
				(gMySoundFX number: 43901 setLoop: 0 play:)
				(if (IsFlag 81)
					(ClearFlag 81)
					(self setLoop: 0 setCel: 14 setCycle: Beg lockPanel)
				else
					(SetFlag 81)
					(self setLoop: 0 setCel: 0 setCycle: End lockPanel)
				)
			)
		)
	)
)

(instance wallPaper of PanelProp
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (onMe)
		(return 0)
	)
)

(instance RCProp of PanelProp
	(properties)

	(method (init)
		(if (not (IsFlag 328))
			(self view: 4475 setLoop: 0 setCel: 0)
		else
			(self view: 4476 setLoop: 0 setCel: 0)
		)
		(self setPri: -99)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 329)
					(RCPanel dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftGearFeature of PanelFeature
	(properties
		x 67
		y 158
	)

	(method (init)
		(if (not (IsFlag 333))
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 101 121 34 121 34 195 101 195
						yourself:
					)
			)
			(super init: &rest)
			(approachX hotVerbs: 81)
			(global105 delete: approachX)
			(global105 addToFront: approachX)
		)
	)

	(method (cue)
		(SetFlag 333)
		(if (IsFlag 332)
			(gInventory deleteItem: (ScriptID 9 70)) ; invTool
		)
		(if (not (IsFlag 328))
			(RCProp view: 4475 setLoop: 0 setCel: 21)
		else
			(RCProp view: 4476 setLoop: 0 setCel: 21)
		)
		(modifyRC setPri: 888)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; invTool
				(modifyRC setPri: -101)
				(if (IsFlag 330)
					(gGame handsOff:)
					(if (not (IsFlag 328))
						(RCProp
							view: 4474
							setCel: 0
							setLoop: 0
							setScript: sRCPropUnscrew self
						)
					else
						(RCProp
							view: 4477
							setCel: 0
							setLoop: 0
							setScript: sRCPropUnscrew self
						)
					)
				)
			)
		)
	)
)

(instance rightGearFeature of PanelFeature
	(properties
		x 143
		y 158
	)

	(method (init)
		(if (not (IsFlag 332))
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 108 121 108 196 178 196 178 122
						yourself:
					)
			)
			(super init: &rest)
			(approachX hotVerbs: 81)
			(global105 delete: approachX)
			(global105 addToFront: approachX)
		)
	)

	(method (cue)
		(SetFlag 332)
		(if (IsFlag 333)
			(gInventory deleteItem: (ScriptID 9 70)) ; invTool
		)
		(if (not (IsFlag 328))
			(RCProp view: 4475 setLoop: 0 setCel: 21)
		else
			(RCProp view: 4476 setLoop: 0 setCel: 21)
		)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; invTool
				(if (IsFlag 330)
					(gGame handsOff:)
					(if (not (IsFlag 328))
						(RCProp
							view: 4474
							setCel: 0
							setLoop: 1
							cycleSpeed: 6
							setScript: sRCPropUnscrew self
						)
					else
						(RCProp
							view: 4477
							setCel: 0
							setLoop: 1
							cycleSpeed: 6
							setScript: sRCPropUnscrew self
						)
					)
				)
			)
		)
	)
)

(instance sRCPropUnscrew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 328))
					(wallPaper view: 4475 setLoop: 0)
				else
					(wallPaper view: 4476 setLoop: 0)
				)
				(client setCycle: CT 3 1 self)
			)
			(1
				(localSound number: 44003 setLoop: 1 play:)
				(client setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance antennaFeature of PanelFeature
	(properties
		x 106
		y 57
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 26 68 89 145 89 145 27
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 91)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91 ; invAntenna
				(ClearFlag 328)
				(RCProp view: 4475)
				(gInventory deleteItem: (ScriptID 9 83)) ; invAntenna
				(gMySoundFX number: 44013 setLoop: 0 play:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance springFeature of PanelFeature
	(properties
		x 106
		y 170
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 176 134 183 135 164 79 158
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 31)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (IsFlag 329))
						(IsFlag 333)
						(IsFlag 332)
						(not (IsFlag 331))
					)
					(SetFlag 331)
					(gMySoundFX number: 44014 setLoop: 0 play:)
					(modifyRC init: RCPanel 1 1 doit:)
				)
			)
			(31 ; invSpring
				(if (IsFlag 331)
					(SetFlag 329)
					(gMySoundFX number: 44015 setLoop: 0 play:)
					(modifyRC init: RCPanel 1 1 doit:)
					(gInventory deleteItem: (ScriptID 9 23)) ; invSpring
				)
			)
		)
	)
)

(instance dremelFeature of PanelFeature
	(properties
		x 40
		y 42
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 2 67 10 62 28 31 27 29 83 6 44 4 17 0 17 1 1
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self dispose:)
				(RCProp setScript: openRC)
			)
		)
	)
)

(instance move479 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 105)
		(= nsTop 120)
		(= nsRight 190)
		(= nsBottom 299)
		(= arrowStyle 9)
		(super init: &rest)
	)
)

(instance windowFeature of Feature
	(properties
		x 233
		y 141
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 214 370 223 366 0 257 0 258 135 301 139 303 189 259 186
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 42)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(rightWindowGate doVerb: 5)
			)
			(42 ; invDeskKey
				(lockPanel init:)
			)
		)
	)
)

(instance birdMan of RobotPlayer
	(properties)

	(method (doit)
		(if (and (== number 155) (== curFrame 12))
			(gMySoundFX number: 443 setLoop: 0 play:)
		)
		(if (and (or (== number 465) (== number 163)) (>= curFrame 83))
			(gMySoundFX stop:)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 9)
		(self setNowSeen:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; invRocks
				(if (and (not (gCurRoom script:)) (IsFlag 68))
					(gCurRoom setScript: rockOnBirdMan)
				)
			)
		)
	)
)

(instance birdManSmash of RobotPlayer
	(properties)

	(method (doit)
		(if (and (== number 153) (== curFrame 26) (== (gCurRoom scene:) 467))
			(= local10 0)
			(self init: 1)
		)
		(if (and (== number 153) (== curFrame 26) (== (gCurRoom scene:) 474))
			((ScriptID 9 45) cue:) ; invRadioControl
			(gCurRoom changeScene: 465)
		)
		(if
			(or
				(and (== number 153) (> curFrame 42))
				(and (== number 168) (> curFrame 18))
			)
			(SetFlag 293)
			(if (== (gCurRoom scene:) 465)
				(hammer dispose:)
			)
		)
		(if
			(or
				(and (== number 153) (== curFrame 88))
				(and (== number 168) (== curFrame 62))
			)
			(gMySoundFX number: 44001 setLoop: 0 play:)
		)
		(if
			(or
				(and (== number 153) (== curFrame 96))
				(and (== number 168) (== curFrame 70))
			)
			(gMySoundFX number: 44005 setLoop: 0 play:)
		)
		(if
			(or
				(and (== number 153) (== curFrame 106))
				(and (== number 168) (== curFrame 80))
			)
			(gMySoundFX number: 44006 setLoop: 0 play:)
		)
		(super doit: &rest)
	)

	(method (init param1)
		(if param1
			(cond
				((== global115 4)
					(if (== (gCurRoom scene:) 466)
						(self
							init: 0 156 local9 39 11
							caller: comeToSmashRC
							start: 1 10
						)
					else
						(self
							init: 0 156 local9 -300 -300
							caller: comeToSmashRC
							start: 1 10
						)
					)
				)
				((== global115 3)
					(cond
						((== (gCurRoom scene:) 465)
							(self
								init: 0 153 local9 0 0 500
								caller: comeToSmashRC
								start: 1 10
							)
						)
						((and (== (gCurRoom scene:) 467) (< -1 local10 95))
							(self
								init: 0 168 local10 239 4 500
								caller: comeToSmashRC
								start: 1 10
							)
						)
						(else
							(self
								init: 0 153 local9 -300 -300
								caller: comeToSmashRC
								start: 1 10
							)
						)
					)
				)
			)
		else
			(super init: &rest)
		)
	)
)

(instance outDoorRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(= nsLeft 250)
		(= nsTop 80)
		(= nsRight 300)
		(= nsBottom 265)
		(super init: &rest)
	)
)

(instance outDoorLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(= nsLeft 190)
		(= nsTop 80)
		(= nsRight 249)
		(= nsBottom 265)
		(super init: &rest)
	)
)

(instance exitLeft of Code
	(properties)

	(method (doit)
		(SetFlag 373)
		(gCurRoom newRoom: 447)
	)
)

(instance myExitCode of Code
	(properties)

	(method (doit)
		(if
			(and
				(== (birdMan number:) 155)
				(>= (birdMan curFrame:) 13)
				(== (gUser curVerb:) 5)
			)
			(gCurRoom changeScene: 464 3)
		)
	)
)

(instance closeDoor180 of Code
	(properties)

	(method (doit)
		(if (!= (doorProp cel:) 0)
			(gMySoundFX number: 44801 setLoop: 0 play:)
			(doorProp setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 476)
	)
)

(instance closeDoorLeft of Code
	(properties)

	(method (doit)
		(if (!= (doorProp cel:) 0)
			(gMySoundFX number: 44801 setLoop: 0 play:)
			(doorProp setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 479)
	)
)

(instance noCode of Code
	(properties)

	(method (doit))
)

(instance clickSounds of Sound
	(properties)
)

(instance localSound of Sound
	(properties)
)

(instance invAddSound of Sound
	(properties
		number 44803
	)
)

