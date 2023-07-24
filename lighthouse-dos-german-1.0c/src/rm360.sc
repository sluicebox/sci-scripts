;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Portal)
(use ROsc)
(use Osc)
(use PanelPlane)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 287
	local7
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(pDigit1 cel: 0 init:)
	(pDigit2 cel: 0 init:)
	(pDigit3 cel: 0 init:)
	(pDigit4 cel: 0 init:)
	(sndMemory play:)
	(for ((= temp1 1)) (<= temp1 10) ((++ temp1))
		(for ((= temp2 1)) (<= temp2 10) ((++ temp2))
			(for ((= temp3 0)) (<= temp3 10) ((++ temp3))
				(pDigit4 cel: temp3)
				(gGame doit:)
			)
			(pDigit3 cel: temp2)
			(gGame doit:)
		)
		(pDigit3 cel: 0)
		(pDigit2 cel: temp1)
		(pDigit3 cel: temp2)
	)
	(pDigit4 setCel: 0)
	(pDigit3 setCel: 0)
	(pDigit2 setCel: 0)
	(pDigit1 setCel: 1)
	(FrameOut)
	(for ((= temp2 1)) (<= temp2 2) ((++ temp2))
		(for ((= temp3 0)) (<= temp3 10) ((++ temp3))
			(pDigit4 cel: temp3)
			(gGame doit:)
		)
		(pDigit3 cel: temp2)
		(gGame doit:)
	)
	(for ((= temp3 0)) (<= temp3 4) ((++ temp3))
		(pDigit4 cel: temp3)
		(gGame doit:)
	)
	(pComputerScreen setCel: 1)
	(UpdateScreenItem pComputerScreen)
	(pDigit1 dispose:)
	(pDigit2 dispose:)
	(pDigit3 dispose:)
	(pDigit4 dispose:)
	(sndMemory stop:)
	(FrameOut)
)

(instance rm360 of LightRoom
	(properties
		picture 360
	)

	(method (init)
		(if (not (IsFlag 36))
			(if (IsFlag 103)
				(SetFlag 160)
			)
			(ClearFlag 159)
			(if (and (IsFlag 172) (IsFlag 289))
				(Portal kill:)
			)
		)
		(super init: &rest)
		(gGame handsOff:)
		(gBackMusic number: 250 loop: -1 play: 127 0)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 35 5 10 0 0)
		)
		(if (IsFlag 36)
			(sndGateDevicePower play: 40 0)
		)
		(if (vToggle1 checkToggles:)
			(sndLensPower play: 40 0)
		)
		(if (and (IsFlag 37) (IsFlag 49))
			(sndComputer play: 40 0)
		)
		(switch gPrevRoomNum
			(400
				(= local5 1)
				(self changeScene: 362 5)
			)
			(320
				(gUser canInput: 0)
				(gMySoundFX do: 135 self)
				(self changeScene: 360 3)
			)
			(765
				(if (IsFlag 285)
					(self changeScene: 373 3)
				else
					(self changeScene: 376 3)
				)
			)
			(else
				(self changeScene: 360 3)
			)
		)
	)

	(method (changeScene param1)
		(if (IsFlag 36)
			(sndGateDevicePower fade: 40 10 5 0 0)
		)
		(if (vToggle1 checkToggles:)
			(sndLensPower fade: 40 10 5 0 0)
		)
		(if (and (IsFlag 37) (IsFlag 49))
			(sndComputer fade: 40 10 5 0 0)
		)
		(if (IsFlag 160)
			(ClearFlag 159)
		)
		(rLens dispose:)
		(rLensDoor dispose:)
		(Portal dispose:)
		(moveUpLeft dispose:)
		(moveUpMiddle dispose:)
		(moveUpRight dispose:)
		(moveUpStairs dispose:)
		(fTv dispose:)
		(fSuperComputer dispose:)
		(fGateDevice dispose:)
		(fComputerPower dispose:)
		(fDesk dispose:)
		(fCooler dispose:)
		(fTrapDoorlock dispose:)
		(fComputer dispose:)
		(fTubeSocket dispose:)
		(fWire dispose:)
		(fRightSideOfWire dispose:)
		(fLeftSideOfWire dispose:)
		(fRetry dispose:)
		(pRightHandle dispose:)
		(pLeftHandle dispose:)
		(pPower1 dispose:)
		(pPower2 dispose:)
		(pPower3 dispose:)
		(pLabDoor dispose:)
		(pComputerScreen dispose:)
		(pTrapDoor dispose:)
		(pComputerPower dispose:)
		(pGoodTube dispose:)
		(pBurntTube dispose:)
		(pWire dispose:)
		(pButtonStartup dispose:)
		(pBadWire dispose:)
		(pGateDeviceDoor dispose:)
		(pLittleDevice dispose:)
		(vLittleBurntWire dispose:)
		(vLittleGoodWire dispose:)
		(vLittleBurntTube dispose:)
		(vLittleGoodTube dispose:)
		(vSolderingIron dispose:)
		(vLabNotes dispose:)
		(vTube dispose:)
		(vWire dispose:)
		(vToggle1 dispose:)
		(vToggle2 dispose:)
		(vToggle3 dispose:)
		(vToggle4 dispose:)
		(vToggle5 dispose:)
		(vToggle6 dispose:)
		(vToggle7 dispose:)
		(vToggle8 dispose:)
		(vLensWire dispose:)
		(vNoModulator dispose:)
		(vLens dispose:)
		(vNoIron dispose:)
		(vWireATP dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(0
				(gCurRoom setScript: sOpenThePortal)
			)
			(280
				(cond
					((and (IsFlag 172) (IsFlag 289))
						(Portal init: 4286 0 0)
						(Portal stopSound:)
						(sndLens play: 70 0)
					)
					((and (not (IsFlag 155)) (IsFlag 153))
						(vNoModulator init:)
					)
				)
				(if (not (IsFlag 154))
					(vWireATP view: 4280 init:)
				)
				((ScriptID 1 1) newPic: 282 7) ; exitForward
				((ScriptID 1 2) newPic: 287 3) ; exitBack
			)
			(281
				((ScriptID 1 6) newPic: local6 3) ; exitUp
				((ScriptID 1 5) newPic: 389 8 nsTop: 125) ; exitDown
				(if (IsFlag 137)
					((ScriptID 1 2) newPic: 280 7) ; exitBack
				else
					((ScriptID 1 2) newPic: 288 7) ; exitBack
				)
			)
			(282
				(Load rsAUDIO 310 31001 31002)
				(if (and (IsFlag 172) (IsFlag 289))
					(Portal init: 286 0 0)
					(Portal stopSound:)
					(sndLens fade: 127 10 5 0 0)
				else
					(cond
						((IsFlag 155)
							(rLensDoor init: 285 0 0 0)
						)
						((not (IsFlag 153))
							(rLensDoor init: 4293 0 0 0)
						)
						(else
							(rLensDoor init: 4289 0 0 0)
						)
					)
					((ScriptID 1 6) newPic: 284 7 exitCode: exitUpCode) ; exitUp
				)
				((ScriptID 1 2) newPic: 287 3 exitCode: exitBackCode) ; exitBack
			)
			(283
				(= local0 0)
				(= local1 0)
				(gCurRoom setScript: sPlayRobot 0 4287)
				(if (IsFlag 137)
					((ScriptID 1 2) newPic: 280 7) ; exitBack
				else
					((ScriptID 1 2) newPic: 288 7) ; exitBack
				)
				(= local6 283)
				((ScriptID 1 5) newPic: 281 3) ; exitDown
			)
			(284
				(if (IsFlag 137)
					(vLensWire init:)
					((ScriptID 1 5) newPic: 282 7) ; exitDown
				else
					((ScriptID 1 5) newPic: 289 7) ; exitDown
				)
				((ScriptID 1 5) ; exitDown
					nsLeft: 170
					nsTop: 270
					nsRight: 330
					nsBottom: 300
				)
			)
			(287
				(sndLens fade: 70 10 5 0 0)
				(= local0 0)
				(= local1 0)
				(gCurRoom setScript: sPlayRobot 0 4288)
				((ScriptID 1 1) newPic: 283 3) ; exitForward
				(if (IsFlag 137)
					((ScriptID 1 2) newPic: 280 7) ; exitBack
				else
					((ScriptID 1 2) newPic: 288 7) ; exitBack
				)
				(= local6 287)
				((ScriptID 1 5) newPic: 281 3) ; exitDown
			)
			(288
				(if (not (IsFlag 154))
					(vWireATP view: 4281 init:)
				)
				((ScriptID 1 1) newPic: 289 7) ; exitForward
				((ScriptID 1 2) newPic: 287 3) ; exitBack
			)
			(289
				((ScriptID 1 6) newPic: 284 7) ; exitUp
				((ScriptID 1 2) newPic: 287 3) ; exitBack
			)
			(360
				(moveUpLeft newPic: 361 3)
				(moveUpMiddle newPic: 364 1)
				(moveUpRight newPic: 373 3)
				((ScriptID 1 2) newPic: 392 7) ; exitBack
				((ScriptID 1 3) newPic: 390 4) ; exitLeft
				((ScriptID 1 4) newPic: 375 2) ; exitRight
				(pComputerScreen init:)
				(if (and (IsFlag 172) (IsFlag 289))
					(Portal init: 4391 146 46)
				)
				(if (and (IsFlag 37) (IsFlag 49))
					(pComputerPower init: setCycle: Fwd)
				)
			)
			(361
				((ScriptID 1 1) newPic: 367 3) ; exitForward
				((ScriptID 1 2) newPic: 363 7) ; exitBack
				((ScriptID 1 4) newPic: 364 1) ; exitRight
				((ScriptID 1 3) newPic: 362 5) ; exitLeft
				(pRightHandle init:)
				(pLeftHandle init:)
				(if (vToggle1 checkToggles:)
					(pPower1 init: setCycle: Fwd)
					(pPower2 init: setCycle: Fwd)
					(pPower3 init: setCycle: Fwd)
					(pButtonStartup init: setCycle: Osc -1)
				)
				(pComputerScreen init:)
				(fSuperComputer init:)
				(fGateDevice init:)
				(fTv init:)
			)
			(362
				(fDesk init:)
				(fComputer init:)
				(if (not (IsFlag 67))
					(vLabNotes init:)
				)
				(pComputerScreen init:)
				((ScriptID 1 2) newPic: 364 1) ; exitBack
				((ScriptID 1 3) newPic: 363 7) ; exitLeft
				((ScriptID 1 4) newPic: 361 3) ; exitRight
				(if (and local5 (IsFlag 172) (IsFlag 289))
					(= local5 0)
					(Portal startSound:)
				)
			)
			(363
				(fCooler init:)
				((ScriptID 1 1) newPic: 392 7) ; exitForward
				((ScriptID 1 2) newPic: 361 3) ; exitBack
				((ScriptID 1 3) newPic: 364 1) ; exitLeft
				((ScriptID 1 4) newPic: 362 5) ; exitRight
				(moveUpStairs newPic: 375 2)
			)
			(364
				((ScriptID 1 2) newPic: 362 5) ; exitBack
				((ScriptID 1 3) newPic: 361 3) ; exitLeft
				((ScriptID 1 4) newPic: 363 7) ; exitRight
				(if (and (IsFlag 172) (IsFlag 289))
					((ScriptID 1 1) newRoom: 400 exitCode: portalExitCode) ; exitForward
					(Portal init: 4392 0 0)
				else
					(if (and (IsFlag 37) (IsFlag 49))
						(pComputerPower init: setCycle: Fwd)
					)
					(pRightHandle init:)
				)
			)
			(365
				(if (and (IsFlag 37) (IsFlag 49))
					(sndGateDevicePower fade: 100 10 5 0 0)
				)
				((ScriptID 1 2) newPic: 368 7 exitCode: exitBackCode) ; exitBack
				((ScriptID 1 4) newPic: 368 7 exitCode: exitRightCode) ; exitRight
				(pGateDeviceDoor init:)
				(if (and (IsFlag 37) (IsFlag 49))
					(pComputerPower init: setCycle: Fwd)
				)
				(if (vToggle1 checkToggles:)
					(pPower3 init: setCycle: Fwd)
					(pButtonStartup init: setCycle: Osc -1)
				)
				(cond
					((IsFlag 99)
						(vLittleGoodTube init:)
					)
					((not (IsFlag 98))
						(vLittleBurntTube init:)
					)
				)
				(cond
					((IsFlag 100)
						(vLittleGoodWire init:)
					)
					((not (IsFlag 135))
						(vLittleBurntWire init:)
					)
				)
				(if (IsFlag 36)
					(pLittleDevice init: setCycle: Fwd)
				)
			)
			(366
				(fCooler init:)
				((ScriptID 1 1) newPic: 392 7) ; exitForward
				((ScriptID 1 2) newPic: 373 3) ; exitBack
				((ScriptID 1 4) newPic: 390 4) ; exitRight
			)
			(367
				(moveUpToRight newPic: 365 9)
				((ScriptID 1 2) newPic: 368 7) ; exitBack
				((ScriptID 1 3) newPic: 369 5) ; exitLeft
				((ScriptID 1 4) newPic: 370 1) ; exitRight
			)
			(368
				((ScriptID 1 1) newPic: 363 7) ; exitForward
				((ScriptID 1 2) newPic: 367 3) ; exitBack
				((ScriptID 1 3) newPic: 370 1) ; exitLeft
				((ScriptID 1 4) newPic: 369 5) ; exitRight
				(fDesk init:)
				(if (not (IsFlag 39))
					(vTube view: 5351 x: 384 y: 242 init:)
				)
				(if (not (IsFlag 41))
					(vSolderingIron view: 5351 x: 314 y: 254 init:)
				)
			)
			(369
				(pComputerScreen init:)
				((ScriptID 1 2) newPic: 370 1) ; exitBack
				((ScriptID 1 3) newPic: 368 7) ; exitLeft
				((ScriptID 1 4) newPic: 367 3) ; exitRight
			)
			(370
				(Load rsVIEW 5370 5371)
				(if (vToggle1 checkToggles:)
					(sndLensPower fade: 127 10 5 0 0)
				)
				((ScriptID 1 6) newPic: 388 2) ; exitUp
				((ScriptID 1 2) newPic: 369 5 nsRight: 290) ; exitBack
				((ScriptID 1 3) newPic: 367 3) ; exitLeft
				((ScriptID 1 4) newPic: 368 7) ; exitRight
				(pRightHandle init:)
				(pLeftHandle init:)
				(if (and (IsFlag 172) (IsFlag 289))
					(Portal init: 4393 371 0)
				)
				(vToggle1 init:)
				(vToggle2 init:)
				(vToggle3 init:)
				(vToggle4 init:)
				(vToggle5 init:)
				(vToggle6 init:)
				(vToggle7 init:)
				(vToggle8 init:)
				(if (vToggle1 checkToggles:)
					(pPower1 init: setCycle: Fwd)
					(pPower2 init: setCycle: Fwd)
					(pPower3 init: setCycle: Fwd)
					(pButtonStartup cel: 0 init: setCycle: Osc -1)
				)
				(if (and (IsFlag 37) (IsFlag 49))
					(pComputerPower init: setCycle: Fwd)
				)
			)
			(372
				(if (not (IsFlag 67))
					(vLabNotes init:)
				)
				(if (not (IsFlag 39))
					(vTube view: 5350 x: 140 y: 60 init:)
				)
				(if (not (IsFlag 40))
					(vWire view: 5350 x: 264 y: 124 init:)
				)
				(if (not (IsFlag 41))
					(vSolderingIron view: 5350 x: 44 y: 136 init:)
				)
				((ScriptID 1 7) newPic: 362 5) ; exitBackUp
				((ScriptID 1 3) newPic: 363 7) ; exitLeft
				((ScriptID 1 4) newPic: 361 3) ; exitRight
			)
			(373
				(if (and (IsFlag 37) (IsFlag 49))
					(sndComputer fade: 127 10 5 0 0)
				)
				(SetFlag 178)
				(fComputerPower init:)
				((ScriptID 1 2) newPic: 366 6) ; exitBack
				(cond
					((and (IsFlag 172) (IsFlag 289))
						(Portal init: 4394 0 0)
					)
					((and (IsFlag 37) (IsFlag 49))
						(pComputerPower init: setCycle: Fwd)
					)
				)
			)
			(374
				(if (and (IsFlag 37) (IsFlag 49))
					(sndGateDevicePower fade: 127 10 5 0 0)
				)
				(= local0 0)
				(= local1 0)
				(gCurRoom setScript: sPlayRobot 0 4376)
				((ScriptID 1 7) newPic: 365 9) ; exitBackUp
			)
			(375
				((ScriptID 1 1) newPic: 376 3) ; exitForward
				((ScriptID 1 2) newPic: 390 4) ; exitBack
				((ScriptID 1 3) newPic: 360 3) ; exitLeft
				((ScriptID 1 4) newPic: 392 7) ; exitRight
			)
			(376
				(SetFlag 177)
				(if
					(and
						(not (IsFlag 162))
						(not (gTimers contains: gTGlobalTimer))
						(not (IsFlag 266))
					)
					(gTGlobalTimer setReal: gTGlobalTimer 30)
				)
				((ScriptID 1 1) newPic: 379 5) ; exitForward
				((ScriptID 1 2) newPic: 390 4) ; exitBack
			)
			(377
				((ScriptID 1 1) newPic: 390 4) ; exitForward
				((ScriptID 1 2) newPic: 379 5) ; exitBack
				((ScriptID 1 4) newPic: 381 6) ; exitRight
			)
			(378
				((ScriptID 1 7) newPic: 365 9) ; exitBackUp
				(if (not (IsFlag 98))
					(pBurntTube init:)
				)
				(if (IsFlag 99)
					(pGoodTube cel: 3 init:)
				)
				(if (and (IsFlag 98) (not (IsFlag 99)))
					(fTubeSocket init:)
				)
				(cond
					((IsFlag 100)
						(if (not (IsFlag 101))
							(fLeftSideOfWire init:)
						)
						(if (not (IsFlag 102))
							(fRightSideOfWire init:)
						)
						(cond
							((and (IsFlag 101) (IsFlag 102))
								(pWire loop: 6 cel: 3 init:)
							)
							((IsFlag 102)
								(pWire loop: 6 cel: 2 init:)
							)
							((IsFlag 101)
								(pWire loop: 6 cel: 1 init:)
							)
							(else
								(pWire loop: 6 cel: 0 init:)
							)
						)
					)
					((IsFlag 135)
						(fWire init:)
					)
					(else
						(pBadWire init:)
					)
				)
			)
			(379
				((ScriptID 1 1) newPic: 387 4) ; exitForward
				((ScriptID 1 2) newPic: 377 7) ; exitBack
				((ScriptID 1 3) newPic: 381 6) ; exitLeft
			)
			(381
				((ScriptID 1 6) newPic: 385 6) ; exitUp
				((ScriptID 1 3) newPic: 377 7) ; exitLeft
				((ScriptID 1 4) newPic: 379 5) ; exitRight
				((ScriptID 1 5) newPic: 383 6) ; exitDown
				(if (not (IsFlag 137))
					(vLens init:)
				)
			)
			(383
				((ScriptID 1 6) newPic: 381 6) ; exitUp
				(pComputerScreen init:)
				(if (IsFlag 41)
					(vNoIron init:)
				)
				(pPower3 init: setCycle: Fwd)
				(if (and (IsFlag 172) (IsFlag 289))
					(Portal init: 4395 0 0)
				)
			)
			(385
				(if (IsFlag 137)
					(vLens init:)
				)
				((ScriptID 1 5) newPic: 381 6) ; exitDown
			)
			(387
				((ScriptID 1 1) newPic: 393 4) ; exitForward
				((ScriptID 1 2) newPic: 389 8) ; exitBack
			)
			(388
				((ScriptID 1 5) newPic: 370 1) ; exitDown
				(cond
					(local4
						(if (IsFlag 137)
							(rLens init: 4388 29 0 0)
						else
							(rLens init: 4388 0 0 0)
						)
						(gCurRoom setScript: sRaiseTheLens)
					)
					((IsFlag 137)
						(rLens init: 4388 29 0 0)
					)
					(else
						(rLens init: 4388 0 0 0)
					)
				)
			)
			(389
				(if (and (IsFlag 172) (IsFlag 289) (== local3 281))
					(Portal startSound:)
					(sndLens stop:)
				)
				((ScriptID 1 2) newPic: 387 4) ; exitBack
				((ScriptID 1 1) newPic: 377 7) ; exitForward
				(if (and (IsFlag 37) (IsFlag 49))
					(pComputerPower init: setCycle: Fwd)
				)
				(if (== local3 281)
					(gUser canInput: 0)
					(gMySoundFX do: 319 self)
				)
			)
			(390
				(fDesk init:)
				(fTv init:)
				(pComputerScreen init:)
				((ScriptID 1 2) newPic: 375 2) ; exitBack
				((ScriptID 1 3) newPic: 392 7) ; exitLeft
				((ScriptID 1 4) newPic: 360 3) ; exitRight
				(if (not (IsFlag 39))
					(vTube view: 5352 x: 283 y: 225 init:)
				)
				(if (not (IsFlag 41))
					(vSolderingIron view: 5352 x: 301 y: 239 init:)
				)
			)
			(392
				(pLabDoor setCel: 0 init:)
				((ScriptID 1 2) newPic: 360 3 exitCode: exitBackCode) ; exitBack
				((ScriptID 1 3) newPic: 375 2 exitCode: exitLeftCode) ; exitLeft
				((ScriptID 1 4) newPic: 390 4 exitCode: exitRightCode) ; exitRight
			)
			(393
				(if (not (IsFlag 86))
					(fTrapDoorlock init:)
				)
				(pTrapDoor init:)
				((ScriptID 1 7) newPic: 387 4 exitCode: exitBackCode) ; exitBackUp
			)
		)
		(= local3 param1)
		(gGame handsOn:)
	)

	(method (notify)
		(if argc
			(sndLens stop:)
		else
			(gGame handsOff:)
			(pRightHandle setCycle: Beg self)
		)
	)

	(method (cue)
		(gUser canInput: 1)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (gPanels contains: plCooler)
			(plCooler dispose:)
		)
		(if (gPanels contains: pplTrapDoor)
			(pplTrapDoor dispose:)
		)
		(if (gPanels contains: pplComputerPower)
			(pplComputerPower dispose:)
		)
		(rLens dispose:)
		(rLensDoor dispose:)
		(if (!= gNewRoomNum 320)
			(gBackMusic stop:)
		)
		(super dispose: &rest)
	)
)

(instance sOpenThePortal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(SetFlag 162)
				(SetFlag 16)
				(if (gTimers contains: gTGlobalTimer)
					(gTGlobalTimer dispose: delete:)
				)
				(gBackMusic2 stop:)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(= cycles 1)
			)
			(2
				(proc0_8 315)
				(= cycles 1)
			)
			(3
				(if (not (gInventory disabled:))
					(= local7 1)
					(gInventory disable: 1)
				)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD
					number: 4390
					doubled: 1
					stretch: 0
					init:
					play:
					close:
				)
				(if local7
					(gInventory disable: 0)
					(= local7 0)
				)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(gGlobalVMD doubled: 0 stretch: 1)
				(= cycles 5)
			)
			(4
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(ClearFlag 290)
				(ClearFlag 413)
				(Portal stopTimer:)
				(SetFlag 289)
				(SetFlag 172)
				(gCurRoom changeScene: 364 1)
				(self dispose:)
			)
		)
	)
)

(instance sFadeTheMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic fade: 0 10 20 1 0)
				(= ticks 120)
			)
			(1
				(gCurRoom newRoom: 320)
				(self dispose:)
			)
		)
	)
)

(instance sRaiseTheLens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(if (IsFlag 137)
					(ClearFlag 137)
					(ClearFlag 154)
					(if (and (IsFlag 172) (IsFlag 289))
						(Portal kill:)
						(ClearFlag 43)
						(SetFlag 160)
					)
					(if (IsFlag 156)
						(SetFlag 160)
					)
					(gMySoundFX do: 321)
					(rLens caller: self start: 2 30)
				else
					(SetFlag 137)
					(gMySoundFX do: 320)
					(rLens caller: self start: 1 30)
				)
			)
			(2
				(if (IsFlag 137)
					(gMySoundFX do: 32000)
				else
					(gMySoundFX do: 32100)
				)
				(= local4 0)
				(= ticks 60)
			)
			(3
				(gCurRoom changeScene: 370 1)
				(self dispose:)
			)
		)
	)
)

(instance sRestartLens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(pComputerScreen setCycle: 0 loop: 1 cel: 0 show:)
				(localproc_0)
				(= ticks 60)
			)
			(2
				(SetFlag 95)
				(gMySoundFX do: 30902)
				(pHardware loop: 4 init:)
				(= ticks 60)
			)
			(3
				(SetFlag 103)
				(gMySoundFX do: 30902)
				(pDevice loop: 6 init:)
				(= ticks 60)
			)
			(4
				(gMySoundFX do: 30902)
				(cond
					((not (IsFlag 137))
						(SetFlag 156)
						(pLens loop: 7 init: setCycle: Fwd)
					)
					((not (IsFlag 155))
						(SetFlag 156)
						(SetFlag 157)
						(pLens loop: 8 init: setCycle: Fwd)
					)
					((not (IsFlag 154))
						(SetFlag 156)
						(SetFlag 157)
						(SetFlag 158)
						(pLens loop: 9 init: setCycle: Fwd)
					)
					(else
						(SetFlag 156)
						(SetFlag 157)
						(SetFlag 158)
						(SetFlag 159)
						(pLens loop: 10 init: setCycle: Fwd)
					)
				)
				(= ticks 60)
			)
			(5
				(if (IsFlag 159)
					(gMySoundFX do: 30904)
					(pRestart loop: 12)
				else
					(gMySoundFX do: 30903)
					(pRestart loop: 11)
					(fRetry init:)
				)
				(pRestart show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRestartDevice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(pComputerScreen setCycle: 0 loop: 1 cel: 0 show:)
				(localproc_0)
				(= ticks 60)
			)
			(2
				(SetFlag 95)
				(gMySoundFX do: 30902)
				(pHardware loop: 4 init:)
				(= ticks 60)
			)
			(3
				(SetFlag 103)
				(gMySoundFX do: 30902)
				(pDevice init: setCycle: Fwd)
				(= ticks 60)
			)
			(4
				(gMySoundFX do: 30903)
				(pRestart show:)
				(fRetry init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRestartPower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(pComputerScreen setCycle: 0 loop: 1 cel: 0 show:)
				(localproc_0)
				(= ticks 60)
			)
			(2
				(SetFlag 95)
				(gMySoundFX do: 30902)
				(pHardware loop: 3 setCycle: Fwd)
				(= ticks 60)
			)
			(3
				(gMySoundFX do: 30903)
				(pRestart show:)
				(fRetry init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRestart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(pComputerScreen loop: 0 show:)
				(= ticks 60)
			)
			(2
				(pRestart show:)
				(gMySoundFX do: 30903)
				(fRetry init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPlayRobot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global102
					((WalkieTalkie new:)
						doRobot: register local0 local1 self 0 0
						yourself:
					)
				)
			)
			(1
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance pGateDeviceDoor of Prop
	(properties
		x 153
		y 297
		view 4373
	)

	(method (init)
		(if (OneOf local3 374 378)
			(= cel (self lastCel:))
			(if (IsFlag 36)
				((ScriptID 1 1) newPic: 374 1) ; exitForward
			else
				((ScriptID 1 1) newPic: 378 1) ; exitForward
			)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(gMySoundFX do: 32602)
					((ScriptID 1 1) dispose:) ; exitForward
					(self setCycle: Beg self)
				else
					(gMySoundFX do: 32601)
					(if (IsFlag 36)
						((ScriptID 1 1) newPic: 374 1) ; exitForward
					else
						((ScriptID 1 1) newPic: 378 1) ; exitForward
					)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance pComputerPower of Prop
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(360
				(self view: 5378 x: 276 y: 263)
			)
			(364
				(self view: 5381 x: 0 y: 299)
			)
			(365
				(self view: 5382 x: 154 y: 299)
			)
			(370
				(self view: 5383 x: 134 y: 19)
			)
			(373
				(self view: 5384 x: 22 y: 299)
			)
			(389
				(self view: 5385 x: 289 y: 269)
			)
		)
		(super init: &rest)
	)
)

(instance pLabDoor of Prop
	(properties
		x 93
		y 299
		signal 30753
		view 4382
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(gMySoundFX do: 135)
					(self setCycle: Beg self)
				else
					(gMySoundFX do: 134)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if cel
			((ScriptID 1 1) newRoom: 330 exitCode: hallExitCode) ; exitForward
		else
			((ScriptID 1 1) dispose:) ; exitForward
		)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(not ((ScriptID 1 2) onMe: event)) ; exitBack
				(not ((ScriptID 1 3) onMe: event)) ; exitLeft
			)
			(super handleEvent: event &rest)
		else
			(return 0)
		)
	)
)

(instance pPower1 of Prop
	(properties)

	(method (handleEvent event)
		(event claimed: 0)
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(370
				(= view 5371)
				(= x 172)
				(= y 121)
			)
			(361
				(= view 5372)
				(= x 406)
				(= y 128)
			)
		)
		(= cel (= loop 0))
		(super init: &rest)
	)
)

(instance pPower2 of Prop
	(properties)

	(method (handleEvent event)
		(event claimed: 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(361
				(= view 5372)
				(= x 402)
				(= y 187)
			)
			(370
				(= view 5371)
				(= x 221)
				(= y 139)
			)
		)
		(= loop 1)
		(= cel 0)
		(super init: &rest)
	)
)

(instance pPower3 of Prop
	(properties)

	(method (handleEvent event)
		(event claimed: 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(361
				(= view 5372)
				(= x 385)
				(= y 172)
				(= loop 2)
			)
			(365
				(= view 5382)
				(= x 374)
				(= y 203)
				(= loop 1)
			)
			(370
				(= view 5371)
				(= x 145)
				(= y 184)
				(= loop 2)
			)
			(383
				(= view 5374)
				(= x 300)
				(= y 166)
				(= loop 0)
			)
		)
		(= cel 0)
		(super init: &rest)
	)
)

(instance pLeftHandle of Prop
	(properties
		priority 300
		fixPriority 1
	)

	(method (init)
		(if (== (gCurRoom scene:) 370)
			(self view: 5370 loop: 1 x: 219 y: 299)
			(if (IsFlag 42)
				(= cel (self lastCel:))
			else
				(= cel 0)
			)
		else
			(self
				view: 5372
				loop: 3
				cel: (if (IsFlag 42) 1 else 0)
				x: 365
				y: 225
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 370)
					(gGame handsOff:)
					(if (IsFlag 42)
						(ClearFlag 42)
						(gMySoundFX do: 324)
						(self setCycle: Beg self)
					else
						(SetFlag 42)
						(gMySoundFX do: 324)
						(self setCycle: End self)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (vToggle1 checkToggles:)
			(= local4 1)
			(gCurRoom changeScene: 388 2)
		else
			(gGame handsOn:)
		)
	)
)

(instance pRightHandle of Prop
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(361
				(self view: 5372 loop: 3 x: 380 y: 245)
				(if (IsFlag 43)
					(= cel 3)
				else
					(= cel 2)
				)
			)
			(364
				(self view: 4397 loop: 0 cel: 0 x: 3 y: 285)
			)
			(370
				(self view: 5370 loop: 2 x: 299 y: 299)
				(if (IsFlag 43)
					(= cel (self lastCel:))
				else
					(= cel 0)
				)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((!= (gCurRoom scene:) 370)
						(super doVerb: theVerb)
					)
					((and (IsFlag 172) (IsFlag 289))
						(gGame handsOff:)
						(Portal kill:)
						(ClearFlag 43)
						(self setCycle: Beg self)
					)
					((IsFlag 159)
						(gGame handsOff:)
						(if (IsFlag 43)
							(ClearFlag 43)
							(self setCycle: Beg self)
						else
							(SetFlag 43)
							(gMySoundFX do: 322)
							(self setCycle: End self)
						)
					)
					(else
						(gUser canInput: 0)
						(gMySoundFX do: 325)
						(self setCycle: ROsc 1 0 1 self)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if cel
			(gCurRoom changeScene: 0)
		else
			(gUser canInput: 1)
			(gGame handsOn:)
		)
	)
)

(instance pDigit1 of Prop
	(properties
		x 216
		y 68
		loop 2
		view 5364
	)

	(method (init)
		(if (== (gGame printLang:) 33)
			(= x 231)
			(= y 79)
		)
		(super init: &rest)
	)
)

(instance pDigit2 of Prop
	(properties
		x 222
		y 68
		loop 2
		view 5364
	)

	(method (init)
		(if (== (gGame printLang:) 33)
			(= x 237)
			(= y 79)
		)
		(super init: &rest)
	)
)

(instance pDigit3 of Prop
	(properties
		x 228
		y 68
		loop 2
		view 5364
	)

	(method (init)
		(if (== (gGame printLang:) 33)
			(= x 243)
			(= y 79)
		)
		(super init: &rest)
	)
)

(instance pDigit4 of Prop
	(properties
		x 234
		y 68
		loop 2
		view 5364
	)

	(method (init)
		(if (== (gGame printLang:) 33)
			(= x 249)
			(= y 79)
		)
		(super init: &rest)
	)
)

(instance pHardware of Prop
	(properties
		x 141
		y 90
		cycleSpeed 10
		loop 3
		view 5364
	)
)

(instance pDevice of Prop
	(properties
		x 143
		y 109
		cycleSpeed 10
		loop 5
		view 5364
	)
)

(instance pLens of Prop
	(properties
		x 145
		y 128
		cycleSpeed 10
		loop 7
		view 5364
	)
)

(instance pRestart of Prop
	(properties
		x 150
		y 170
		cycleSpeed 10
		loop 11
		view 5364
	)
)

(instance pComputerScreen of Prop
	(properties
		cycleSpeed 10
	)

	(method (init)
		(if (IsFlag 37)
			(cond
				((!= (gCurRoom scene:) 369)
					(= loop
						(cond
							((IsFlag 160) 0)
							((IsFlag 159) 4)
							((or (IsFlag 156) (IsFlag 157) (IsFlag 158)) 3)
							((IsFlag 103) 2)
							((IsFlag 95) 1)
							(else 0)
						)
					)
				)
				((IsFlag 160)
					(ClearFlag 159)
					(ClearFlag 95)
					(ClearFlag 103)
					(ClearFlag 156)
					(ClearFlag 157)
					(ClearFlag 158)
					(= loop 13)
					(= cel 0)
					(self setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				((IsFlag 159)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pDevice loop: 6 init:)
					(pLens loop: 10 init:)
					(pRestart loop: 12 init: setCycle: Fwd)
				)
				((IsFlag 158)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pDevice loop: 6 init:)
					(pLens loop: 9 init: setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				((IsFlag 157)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pDevice loop: 6 init:)
					(pLens loop: 8 init: setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				((IsFlag 156)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pDevice loop: 6 init:)
					(pLens loop: 7 init: setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				((IsFlag 103)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pDevice init: setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				((IsFlag 95)
					(= cel (= loop 1))
					(pHardware loop: 4 init:)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
				(else
					(= cel (= loop 0))
					(self setCycle: Fwd)
					(pRestart loop: 11 init: setCycle: Fwd)
					(fRetry init:)
				)
			)
		)
		(switch (gCurRoom scene:)
			(360
				(self view: 5365 x: 46 y: 161)
			)
			(361
				(self view: 5366 x: 31 y: 149)
			)
			(362
				(self view: 5367 x: 383 y: 143)
			)
			(369
				(self view: 5364 x: 137 y: 56)
			)
			(383
				(self view: 5368 x: 362 y: 58)
			)
			(390
				(self view: 5369 x: 431 y: 150)
			)
		)
		(if (IsFlag 37)
			(super init: &rest)
			(if (!= (gCurRoom scene:) 369)
				(self setCycle: Fwd)
			)
		)
	)

	(method (dispose)
		(pRestart dispose:)
		(pHardware dispose:)
		(pDevice dispose:)
		(pLens dispose:)
		(super dispose: &rest)
	)
)

(instance pTrapDoor of Prop
	(properties)

	(method (init)
		(if (IsFlag 86)
			(self view: 4375 cel: 0 x: 93 y: 266)
		else
			(self view: 4377 cel: 0 x: 93 y: 266)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 86)
					(gGame handsOff:)
					(if cel
						((ScriptID 1 1) dispose:) ; exitForward
						(gMySoundFX do: 319)
						(self setCycle: Beg self)
					else
						(if (IsFlag 137)
							((ScriptID 1 1) newPic: 280 7) ; exitForward
						else
							((ScriptID 1 1) newPic: 288 7) ; exitForward
						)
						(gMySoundFX do: 318)
						(self setCycle: End self)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance pLittleDevice of Prop
	(properties
		x 165
		y 258
		loop 4
		view 4373
	)

	(method (handleEvent event)
		(event claimed: 0)
	)
)

(instance vNoIron of View
	(properties
		x 162
		y 42
		loop 1
		view 5374
	)
)

(instance vLittleBurntTube of View
	(properties
		x 192
		y 197
		loop 1
		view 4373
	)
)

(instance vLittleBurntWire of View
	(properties
		x 210
		y 204
		loop 3
		view 4373
	)
)

(instance vLittleGoodTube of View
	(properties
		x 192
		y 197
		loop 2
		view 4373
	)
)

(instance vLittleGoodWire of View
	(properties
		x 210
		y 204
		loop 3
		cel 1
		view 4373
	)
)

(instance vLabNotes of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 362)
			(self view: 362 x: 55 y: 299)
		else
			(self view: 372 x: 353 y: 197)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 67)
				(gMySoundFX do: 19201)
				(gInventory addToNotebook: (ScriptID 9 30)) ; invLabNotes
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vTube of View
	(properties
		x 140
		y 60
		view 5350
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 39)
				(gMySoundFX do: 340)
				(gInventory addItem: (ScriptID 9 19)) ; invTube
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vWire of View
	(properties
		x 264
		y 124
		loop 1
		view 5350
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 40)
				(gMySoundFX do: 341)
				(gInventory addItem: (ScriptID 9 20)) ; invWire
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vSolderingIron of View
	(properties
		x 44
		y 136
		loop 2
		view 5350
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 41)
				(gMySoundFX do: 342)
				(gInventory addItem: (ScriptID 9 18)) ; invSolderingIron
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fRetry of Feature
	(properties)

	(method (init)
		(switch (gGame printLang:)
			(33
				(self createPoly: 307 168 349 168 349 182 307 182)
			)
			(49
				(self createPoly: 150 170 237 170 237 182 150 182)
			)
			(else
				(self createPoly: 268 169 296 169 296 183 268 183)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(ClearFlag 160)
				(ClearFlag 95)
				(ClearFlag 103)
				(ClearFlag 156)
				(ClearFlag 157)
				(ClearFlag 158)
				(pHardware dispose:)
				(pDevice dispose:)
				(pLens dispose:)
				(pComputerScreen hide:)
				(pRestart hide:)
				(fRetry dispose:)
				(cond
					((and (IsFlag 49) (IsFlag 36))
						(gCurRoom setScript: sRestartLens)
					)
					(
						(and
							(IsFlag 49)
							(IsFlag 99)
							(IsFlag 100)
							(IsFlag 101)
							(IsFlag 102)
							(not (IsFlag 36))
						)
						(gCurRoom setScript: sRestartDevice)
					)
					((IsFlag 49)
						(gCurRoom setScript: sRestartPower)
					)
					(else
						(gCurRoom setScript: sRestart)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance fComputer of Feature
	(properties)

	(method (init)
		(self
			createPoly: 357 121 487 117 499 125 499 267 423 267 396 231 368 231 344 196
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 369 5)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fTrapDoorlock of Feature
	(properties)

	(method (init)
		(self createPoly: 86 171 160 173 167 201 91 216)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; invCrowbar
				(pplTrapDoor init:)
			)
			(5 ; Do
				(pplTrapDoor init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSuperComputer of Feature
	(properties
		x 409
		y 214
	)

	(method (init)
		(self
			createPoly: 319 290 332 215 375 195 391 165 378 154 386 145 419 138 498 194 499 290
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 370 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fGateDevice of Feature
	(properties
		x 406
		y 110
	)

	(method (init)
		(self
			createPoly: 335 180 352 131 313 116 349 88 345 64 354 53 334 20 346 1 500 0 499 47 482 57 482 94 500 105 500 221 334 221
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 365 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCooler of Feature
	(properties
		x 391
		y 339
	)

	(method (init)
		(switch (gCurRoom scene:)
			(363
				(self createPoly: 282 290 282 261 370 228 500 258 500 290)
			)
			(366
				(self
					createPoly: 373 232 466 232 500 256 500 300 360 301 360 253
				)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; invCrowbar
				(plCooler init:)
			)
			(5 ; Do
				(plCooler init:)
			)
		)
	)
)

(instance fTv of Feature
	(properties
		x 433
		y 171
	)

	(method (init)
		(switch (gCurRoom scene:)
			(361
				(self createPoly: -2 144 98 145 120 227 183 230 172 290 -1 290)
			)
			(else
				(self
					createPoly: 401 196 402 150 434 143 464 148 466 191 432 199
				)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 369 5)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fDesk of Feature
	(properties
		x 354
		y 271
	)

	(method (init)
		(switch (gCurRoom scene:)
			(362
				(self createPoly: -2 229 169 180 224 266 161 300 -2 301)
			)
			(390
				(self
					createPoly: 294 207 395 222 385 291 246 290 244 277 227 274 227 269
				)
			)
			(368
				(self createPoly: 245 271 393 252 463 291 262 291)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 372 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fComputerPower of Feature
	(properties
		x 247
		y 156
	)

	(method (init)
		(self
			createPoly: 156 291 147 241 180 234 170 115 161 101 163 93 186 86 194 75 190 57 204 48 212 29 253 22 281 32 296 49 304 52 305 73 337 89 334 154 332 180 315 196 315 235 348 251 345 290
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplComputerPower init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moveUpToRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(= nsLeft 377)
		(= nsTop 175)
		(= nsRight 498)
		(= nsBottom 287)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 7)
		(= nsLeft 377)
		(= nsTop 175)
		(= nsRight 498)
		(= nsBottom 287)
	)
)

(instance moveUpRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 300)
		(= nsTop 70)
		(= nsRight 390)
		(= nsBottom 260)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(= nsLeft 300)
		(= nsTop 70)
		(= nsRight 390)
		(= nsBottom 260)
	)
)

(instance moveUpLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 20)
		(= nsTop 30)
		(= nsRight 110)
		(= nsBottom 200)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(= nsLeft 20)
		(= nsTop 30)
		(= nsRight 110)
		(= nsBottom 200)
	)
)

(instance moveUpStairs of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self createPoly: 0 166 129 180 135 299 0 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self createPoly: 0 166 129 180 135 299 0 299)
	)
)

(instance moveUpMiddle of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(= nsLeft 190)
		(= nsTop 130)
		(= nsRight 280)
		(= nsBottom 210)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(= nsLeft 190)
		(= nsTop 130)
		(= nsRight 280)
		(= nsBottom 210)
	)
)

(instance ppModulators of PanelProp
	(properties
		priority 4
		loop 1
		view 398
		fixPriority 1
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (ppCooler onMe: event)))
			(super handleEvent: event &rest)
		else
			(return 0)
		)
	)

	(method (init)
		(self setCel: global207)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(> global207 0)
						(not (gInventory contains: (ScriptID 9 39))) ; invModulator
					)
					(gMySoundFX do: 309)
					(-- global207)
					(self setCel: global207 show:)
					(gInventory addItem: (ScriptID 9 39)) ; invModulator
				)
			)
		)
	)

	(method (cue)
		(if (IsFlag 97)
			(DoRobot)
			(pfCooler dispose: plCooler 1 1)
			(ppCooler cel: (ppCooler lastCel:) init: plCooler 1 1)
			(pfCoolerButton init: plCooler 1 1)
			(self init: plCooler 1 1)
			(if (IsFlag 86)
				(gInventory deleteItem: (ScriptID 9 17)) ; invCrowbar
			)
		else
			(plCooler setBitmap: 4372 0 0)
		)
		(gGame handsOn:)
	)
)

(instance pfCooler of PanelFeature
	(properties
		nsBottom 200
		nsRight 200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; invCrowbar
				(gGame handsOff:)
				(if (IsFlag 96)
					(SetFlag 97)
					(WalkieTalkie doRobot: 4372 0 0 ppModulators 0 0)
				else
					(SetFlag 96)
					(WalkieTalkie doRobot: 4371 0 0 ppModulators 0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pfCoolerButton of PanelFeature
	(properties
		nsBottom 147
		nsLeft 81
		nsRight 105
		nsTop 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (ppCooler cel:)
					(gMySoundFX do: 308)
					(ppCooler setCycle: Beg ppCooler)
				else
					(gMySoundFX do: 307)
					(ppCooler setCycle: End ppCooler)
				)
			)
		)
	)
)

(instance ppCooler of PanelProp
	(properties
		priority 5
		view 398
		fixPriority 1
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance plCooler of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppCooler cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 308)
			(ppCooler setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(WalkieTalkie plane: self)
		(Load rsVIEW 398)
		(super init: &rest)
		(cond
			((IsFlag 97)
				(ppCooler init: self 1 1)
				(pfCoolerButton init: self 1 1)
				(ppModulators init: self 1 1)
			)
			((IsFlag 96)
				(pfCooler init: self 1 1)
				(self setBitmap: 4372 0 0)
			)
			(else
				(pfCooler init: self 1 1)
				(self setBitmap: 4371 0 0)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (dispose)
		(WalkieTalkie plane: gThePlane)
		(DoRobot)
		(super dispose: &rest)
	)
)

(instance pfTrapDoor of PanelFeature
	(properties
		nsBottom 200
		nsRight 200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (or (IsFlag 84) (IsFlag 85))
					(WalkieTalkie doRobot: 4369 0 0 pplTrapDoor 0 0)
				else
					(WalkieTalkie doRobot: 4368 0 0 pplTrapDoor 0 0)
				)
			)
			(25 ; invCrowbar
				(gGame handsOff:)
				(cond
					((not (IsFlag 84))
						(SetFlag 84)
						(WalkieTalkie doRobot: 4366 0 0 pplTrapDoor 0 0)
					)
					((not (IsFlag 85))
						(SetFlag 85)
						(WalkieTalkie doRobot: 4370 0 0 pplTrapDoor 0 0)
					)
					(else
						(if (IsFlag 97)
							(gInventory deleteItem: (ScriptID 9 17)) ; invCrowbar
						)
						(SetFlag 86)
						(fTrapDoorlock dispose:)
						(WalkieTalkie doRobot: 4367 0 0 pplTrapDoor 0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pplTrapDoor of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(WalkieTalkie plane: self)
		(if (or (IsFlag 84) (IsFlag 85))
			(self setBitmap: 4370 0 0)
		else
			(self setBitmap: 4368 0 0)
		)
		(pfTrapDoor init: self 1 1)
	)

	(method (cue)
		(cond
			((IsFlag 86)
				(self setBitmap: 4368 0 0)
				(pTrapDoor view: 4375 cel: 0 x: 93 y: 266 show:)
				(self dispose:)
			)
			((IsFlag 85)
				(self setBitmap: 4370 0 0)
			)
			((IsFlag 84)
				(self setBitmap: 4369 0 0)
			)
			(else
				(self setBitmap: 4368 0 0)
			)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(WalkieTalkie plane: gThePlane)
		(DoRobot)
		(if (IsFlag 86)
			(pTrapDoor view: 4375 setCel: 0 x: 93 y: 266)
		)
		(super dispose: &rest)
	)
)

(instance pplComputerPower of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppComputerDoor cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 303)
			(ppComputerDoor setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(ppComputerDoor init: self 1 1)
		(ppComputerButton init: self 1 1)
		(self setBitmap: 396 0 0)
		(if (and (IsFlag 37) (IsFlag 49))
			(ppComputerPower loop: 1 init: self 1 1 setCycle: Fwd)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (dispose)
		(if (IsFlag 37)
			(if (IsFlag 49)
				(pComputerPower cel: 0 init: setCycle: Fwd)
			else
				(pComputerPower dispose:)
			)
		)
		(super dispose: &rest)
	)
)

(instance ppComputerDoor of PanelProp
	(properties
		priority 5
		loop 1
		view 396
		fixPriority 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(gMySoundFX do: 303)
					(self setCycle: Beg self)
				else
					(gMySoundFX do: 302)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppComputerPower of PanelProp
	(properties
		priority 200
		view 5380
		fixPriority 1
	)

	(method (cue)
		(self loop: 1 cel: 0 setCycle: Fwd)
		(gUser canInput: 1)
		(gGame handsOff:)
		(gMySoundFX do: 303)
		(ppComputerDoor setCycle: Beg pplComputerPower)
	)
)

(instance ppComputerButton of PanelProp
	(properties
		priority 4
		loop 2
		view 396
		fixPriority 1
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (ppComputerDoor onMe: event)))
			(super handleEvent: event &rest)
		else
			(return 0)
		)
	)

	(method (init)
		(= loop (if (IsFlag 37) 3 else 2))
		(= cel
			(if (IsFlag 49)
				(self lastCel:)
			else
				0
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gUser canInput: 0)
				(if (IsFlag 49)
					(gMySoundFX do: 32514)
					(ClearFlag 49)
					(self setCycle: Beg self)
				else
					(gMySoundFX do: 32513)
					(SetFlag 49)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (IsFlag 37)
			(if cel
				(gGame handsOff:)
				(ppComputerPower
					loop: 0
					cel: 0
					init: pplComputerPower 1 1
					setCycle: End ppComputerPower
				)
				(sndComputer play: 127 0)
			else
				(if (and (IsFlag 172) (IsFlag 289))
					(Portal kill:)
					(ClearFlag 43)
				)
				(sndComputer stop:)
				(ppComputerPower dispose: pplComputerPower 1 1)
				(if (IsFlag 95)
					(SetFlag 160)
				)
				(gUser canInput: 1)
			)
		else
			(gUser canInput: 1)
		)
	)
)

(instance portalExitCode of Code
	(properties)

	(method (doit)
		(SetFlag 289)
		(ClearFlag 290)
		(ClearFlag 413)
		(Portal fadeSound:)
		(if (gTimers contains: (ScriptID 19 0)) ; BombTimer
			((ScriptID 19 0) seconds: 0) ; BombTimer
		else
			(gGame getDisc: 2)
			(gCurRoom newRoom: 400)
		)
	)
)

(instance hallExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gCurRoom setScript: sFadeTheMusic)
	)
)

(instance exitLeftCode of Code
	(properties)

	(method (doit)
		(if (pLabDoor cel:)
			(gGame handsOff:)
			(gMySoundFX do: 135)
			(pLabDoor setCycle: Beg self)
		else
			(gCurRoom changeScene: 375 2)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 375 2)
	)
)

(instance exitRightCode of Code
	(properties)

	(method (doit)
		(switch (gCurRoom scene:)
			(392
				(if (pLabDoor cel:)
					(gGame handsOff:)
					(gMySoundFX do: 135)
					(pLabDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 390 4)
				)
			)
			(365
				(if (pGateDeviceDoor cel:)
					(gGame handsOff:)
					(gMySoundFX do: 32602)
					(pGateDeviceDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 368 7)
				)
			)
		)
	)

	(method (cue)
		(switch (gCurRoom scene:)
			(392
				(gCurRoom changeScene: 390 4)
			)
			(365
				(gCurRoom changeScene: 368 7)
			)
		)
	)
)

(instance exitUpCode of Code
	(properties)

	(method (doit)
		(if (rLensDoor curFrame:)
			(gGame handsOff:)
			(gMySoundFX do: 31001)
			(rLensDoor caller: self start: 2 40)
			(if (not (IsFlag 153))
				(fBadModulator dispose:)
			)
			(if (and (IsFlag 153) (not (IsFlag 155)))
				(fEmptyModulator dispose:)
			)
		else
			(gCurRoom changeScene: 284 7)
		)
	)

	(method (cue)
		(gMySoundFX do: 31002)
		(gCurRoom changeScene: 284 7)
	)
)

(instance exitBackCode of Code
	(properties)

	(method (doit)
		(switch (gCurRoom scene:)
			(282
				(if (rLensDoor curFrame:)
					(gGame handsOff:)
					(gMySoundFX do: 31001)
					(rLensDoor caller: self start: 2 40)
					(if (not (IsFlag 153))
						(fBadModulator dispose:)
					)
					(if (and (IsFlag 153) (not (IsFlag 155)))
						(fEmptyModulator dispose:)
					)
				else
					(gCurRoom changeScene: 287 3)
				)
			)
			(365
				(if (pGateDeviceDoor cel:)
					(gGame handsOff:)
					(gMySoundFX do: 32602)
					(pGateDeviceDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 368 7)
				)
			)
			(393
				(if (pTrapDoor cel:)
					(gGame handsOff:)
					(pTrapDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 387 4)
				)
			)
			(392
				(if (pLabDoor cel:)
					(gGame handsOff:)
					(gMySoundFX do: 135)
					(pLabDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 360 3)
				)
			)
		)
	)

	(method (cue)
		(switch (gCurRoom scene:)
			(282
				(gMySoundFX do: 31002)
				(gCurRoom changeScene: 287 3)
			)
			(365
				(gCurRoom changeScene: 368 7)
			)
			(393
				(gCurRoom changeScene: 387 4)
			)
			(392
				(gCurRoom changeScene: 360 3)
			)
		)
	)
)

(instance pBurntTube of Prop
	(properties
		x 67
		y 256
		view 4378
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gMySoundFX do: 313)
				(SetFlag 98)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(fTubeSocket init:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pGoodTube of Prop
	(properties
		x 63
		y 238
		loop 1
		view 4378
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance fTubeSocket of Feature
	(properties)

	(method (init)
		(self createPoly: 80 220 108 217 125 233 125 259 100 277 67 254 67 233)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; invTube
				(gGame handsOff:)
				(SetFlag 99)
				(gInventory deleteItem: (ScriptID 9 19)) ; invTube
				(gMySoundFX do: 314)
				(pGoodTube cel: 0 init: setCycle: CT 3 1 pGoodTube)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fWire of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 252 124 266 177 266 191 249 176 237 119 237
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; invWire
				(gGame handsOff:)
				(SetFlag 100)
				(gInventory deleteItem: (ScriptID 9 20)) ; invWire
				(fRightSideOfWire init:)
				(fLeftSideOfWire init:)
				(gMySoundFX do: 315)
				(pWire init: setCycle: End pWire)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pBadWire of Prop
	(properties
		x 116
		y 268
		loop 2
		view 4378
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 252 124 266 177 266 191 249 176 237 119 237
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(SetFlag 135)
				(fWire init:)
				(gMySoundFX do: 31401)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pWire of Prop
	(properties
		x 116
		y 268
		loop 5
		view 4378
	)

	(method (cue)
		(= loop 6)
		(= cel 0)
		(gGame handsOn:)
	)
)

(instance fRightSideOfWire of Feature
	(properties)

	(method (init)
		(self createPoly: 156 242 156 268 178 268 178 242)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; invSolderingIron
				(gGame handsOff:)
				(SetFlag 102)
				(if (IsFlag 101)
					(gInventory deleteItem: (ScriptID 9 18)) ; invSolderingIron
				)
				(gMySoundFX do: 316)
				(pSolderAction init: 1 setCycle: End pSolderAction)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fLeftSideOfWire of Feature
	(properties)

	(method (init)
		(self createPoly: 119 242 141 242 141 268 119 268)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; invSolderingIron
				(gGame handsOff:)
				(SetFlag 101)
				(if (IsFlag 102)
					(gInventory deleteItem: (ScriptID 9 18)) ; invSolderingIron
				)
				(gMySoundFX do: 316)
				(pSolderAction init: 0 setCycle: End pSolderAction)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pSolderAction of Prop
	(properties
		view 4378
	)

	(method (init param1)
		(= cel 0)
		(if param1
			(= loop 4)
			(= x 115)
			(= y 299)
			(= z 0)
		else
			(= loop 3)
			(= x 115)
			(= y 269)
			(= z 9)
		)
		(super init: &rest)
	)

	(method (cue)
		(self dispose:)
		(gGame handsOn:)
		(cond
			((and (IsFlag 101) (IsFlag 102))
				(pWire cel: 3)
				(return)
			)
			((IsFlag 102)
				(pWire cel: 2)
			)
			((IsFlag 101)
				(pWire cel: 1)
			)
		)
		(= global108 (ScriptID 9 18)) ; invSolderingIron
		((ScriptID 9 18) setCursor:) ; invSolderingIron
	)
)

(class ToggleView of View
	(properties
		view 5370
		toggleFlag 0
	)

	(method (checkToggles)
		(if
			(and
				(IsFlag 113)
				(IsFlag 114)
				(IsFlag 115)
				(IsFlag 116)
				(IsFlag 117)
				(IsFlag 118)
				(IsFlag 119)
				(IsFlag 120)
				(IsFlag 37)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (init)
		(cond
			((and (IsFlag (self toggleFlag:)) (not (IsFlag 37)))
				(= cel 2)
			)
			((IsFlag (self toggleFlag:))
				(= cel 1)
			)
			(else
				(= cel 0)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 32201)
				(cond
					((and (not (IsFlag (self toggleFlag:))) (not (IsFlag 37)))
						(self setCel: 2)
						(SetFlag (self toggleFlag:))
					)
					((IsFlag (self toggleFlag:))
						(self setCel: 0)
						(ClearFlag (self toggleFlag:))
						(if (gCast contains: pButtonStartup)
							(pButtonStartup dispose:)
							(pPower1 dispose:)
							(pPower2 dispose:)
							(pPower3 dispose:)
							(if (and (IsFlag 172) (IsFlag 289))
								(Portal kill:)
								(ClearFlag 43)
							)
							(if (IsFlag 137)
								(gGame handsOff:)
								(= local4 1)
								(gCurRoom changeScene: 388 2)
							)
							(sndLensPower stop:)
						)
					)
					(else
						(self setCel: 1)
						(SetFlag (self toggleFlag:))
					)
				)
				(if (self checkToggles:)
					(gCurRoom setScript: sPowerUpConsole)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vToggle1 of ToggleView
	(properties
		x 149
		y 239
		loop 5
		toggleFlag 113
	)
)

(instance vToggle2 of ToggleView
	(properties
		x 167
		y 238
		loop 6
		toggleFlag 114
	)
)

(instance vToggle3 of ToggleView
	(properties
		x 185
		y 237
		loop 7
		toggleFlag 115
	)
)

(instance vToggle4 of ToggleView
	(properties
		x 203
		y 238
		loop 8
		toggleFlag 116
	)
)

(instance vToggle5 of ToggleView
	(properties
		x 220
		y 237
		loop 9
		toggleFlag 117
	)
)

(instance vToggle6 of ToggleView
	(properties
		x 238
		y 237
		loop 10
		toggleFlag 118
	)
)

(instance vToggle7 of ToggleView
	(properties
		x 257
		y 238
		loop 11
		toggleFlag 119
	)
)

(instance vToggle8 of ToggleView
	(properties
		x 275
		y 238
		loop 12
		toggleFlag 120
	)
)

(instance sPowerUpConsole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(sndLensPower play:)
				(pButtonStartup cel: 0 init: setCycle: End self)
			)
			(2
				(pPower2 init: setCycle: Fwd)
				(pButtonStartup setCycle: Beg self)
			)
			(3
				(pPower3 init: setCycle: Fwd)
				(pButtonStartup setCycle: Osc -1)
				(pPowerStartup cel: 0 init: setCycle: End self)
			)
			(4
				(pPowerStartup dispose:)
				(pPower1 init: setCycle: Fwd)
				(= ticks 30)
			)
			(5
				(if (IsFlag 42)
					(= local4 1)
					(gCurRoom changeScene: 388 2)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance pButtonStartup of Prop
	(properties)

	(method (handleEvent event)
		(event claimed: 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(361
				(= view 5372)
				(= x 383)
				(= y 232)
				(= loop 4)
			)
			(365
				(= view 5382)
				(= x 494)
				(= y 227)
				(= loop 2)
			)
			(370
				(= view 5370)
				(= x 215)
				(= y 250)
				(= loop 4)
			)
		)
		(= cel 0)
		(super init: &rest)
	)
)

(instance pPowerStartup of Prop
	(properties
		x 172
		y 121
		view 5370
	)
)

(instance rLens of RobotPlayer
	(properties)
)

(instance rLensDoor of RobotPlayer
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: sOpenLensDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sOpenLensDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (rLensDoor curFrame:)
					(cond
						((not (IsFlag 153))
							(fBadModulator dispose:)
						)
						((and (IsFlag 153) (not (IsFlag 155)))
							(fEmptyModulator dispose:)
						)
					)
					(gMySoundFX do: 31001)
					(rLensDoor caller: self start: 2 40)
				else
					(cond
						((not (IsFlag 153))
							(fBadModulator init:)
						)
						((and (IsFlag 153) (not (IsFlag 155)))
							(fEmptyModulator init:)
						)
					)
					(gMySoundFX do: 310)
					(rLensDoor caller: self start: 1 40)
				)
			)
			(1
				(if (not (rLensDoor curFrame:))
					(gMySoundFX do: 31002)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fBadModulator of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 78 260 79 258 113 261 129 275 130 285 142 278 154 292 174 295 194 292 209 267 227 265 271 228 271 228 226 200 209 198 181 215 155 208 137 218 128 232 127 233 107
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 309)
				(SetFlag 153)
				(rLensDoor init: 4289 23 0 0)
				(fEmptyModulator init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vLensWire of View
	(properties
		x 60
		y 98
		view 4292
	)

	(method (init)
		(= cel (if (IsFlag 154) 0 else 1))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(SetFlag 154)
					(gMySoundFX do: 343)
					(self setCel: 0)
				else
					(ClearFlag 154)
					(gMySoundFX do: 344)
					(self setCel: 1)
					(if (IsFlag 158)
						(SetFlag 160)
					)
				)
				(UpdateScreenItem self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fEmptyModulator of Feature
	(properties)

	(method (init)
		(self createPoly: 206 85 298 85 298 265 206 265)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48 ; invModulator
				(gMySoundFX do: 309)
				(SetFlag 155)
				(gInventory deleteItem: (ScriptID 9 39)) ; invModulator
				(rLensDoor init: 285 23 0 0)
				(self dispose:)
			)
			(else
				(rLensDoor doVerb: theVerb &rest)
			)
		)
	)
)

(instance vNoModulator of View
	(properties
		x 275
		y 196
		view 4290
	)
)

(instance vLens of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(381
				(cond
					((IsFlag 155)
						(= view 4381)
					)
					((not (IsFlag 153))
						(= view 4379)
					)
					(else
						(= view 4389)
					)
				)
				(= x 168)
				(= z (= y 5))
			)
			(385
				(= view 4385)
				(= x 161)
				(= y 86)
				(= z 0)
			)
		)
		(super init: &rest)
	)
)

(instance vWireATP of View
	(properties
		x 258
		y 34
	)
)

(instance sndGateDevicePower of Sound
	(properties
		number 32509
		loop -1
	)

	(method (init)
		(Lock rsAUDIO 32509 1)
		(super init: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO 32509 0)
		(super dispose: &rest)
	)
)

(instance sndLensPower of Sound
	(properties
		number 32501
		loop -1
	)

	(method (init)
		(Lock rsAUDIO 32501 1)
		(super init: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO 32501 0)
		(super dispose: &rest)
	)
)

(instance sndComputer of Sound
	(properties
		number 32510
		loop -1
	)

	(method (init)
		(Lock rsAUDIO 32510 1)
		(super init: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO 32510 0)
		(super dispose: &rest)
	)
)

(instance sndMemory of Sound
	(properties
		number 30901
		loop -1
	)
)

(instance sndLens of Sound
	(properties
		number 338
		loop -1
	)

	(method (init)
		(Lock rsAUDIO 338 1)
		(super init: &rest)
	)

	(method (dispose)
		(Lock rsAUDIO 338 0)
		(super dispose: &rest)
	)
)

