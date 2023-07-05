;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Portal)
(use TrackingProp)
(use PanelPlane)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm800 0
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
)

(procedure (localproc_0)
	(cond
		((and (IsFlag 355) (IsFlag 354) (== global242 0))
			(= global251 3)
			(pBlueLights cel: 1)
			(pScreen init: setCycle: Fwd)
		)
		((and (not (IsFlag 355)) (IsFlag 354) (== global242 5))
			(= global251 2)
			(pBlueLights cel: 1)
			(pScreen init: setCycle: Fwd)
		)
		((and (IsFlag 355) (not (IsFlag 354)) (== global242 11))
			(= global251 1)
			(pBlueLights cel: 1)
			(pScreen init: setCycle: Fwd)
		)
		(else
			(= global251 0)
			(pBlueLights cel: 0)
			(pScreen dispose:)
		)
	)
)

(instance rm800 of LightRoom
	(properties)

	(method (init)
		(if (and (not (IsFlag 349)) (not (IsFlag 351)) (not (IsFlag 172)))
			(= global250 0)
			(= global252 0)
			(= global253 0)
			(ClearFlag 214)
			(ClearFlag 219)
			(ClearFlag 213)
			(ClearFlag 401)
			(ClearFlag 190)
			(ClearFlag 370)
		)
		(if (IsFlag 349)
			(Lock rsAUDIO 9101 1)
			(gBackMusic number: 9101 loop: -1 play: 127 0)
		else
			(Lock rsAUDIO 800 1)
			(gBackMusic number: 800 loop: -1 play: 127 0)
		)
		(super init: &rest)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(340
				(Load rsVIEW 2852 2853 2854)
				(if (IsFlag 290)
					(= local1 1)
				)
				(Portal startSound: 937)
				(self changeScene: 841 13)
			)
			(765
				(self changeScene: 839 9)
			)
			(270
				(if (== global229 9)
					(self changeScene: 994 16)
				else
					(self changeScene: 852 9)
				)
			)
			(else
				(self changeScene: 851 1)
			)
		)
	)

	(method (changeScene param1)
		(if (gSounds contains: sndLightRow)
			(if (== param1 838)
				(sndLightRow fade: 127 10 5 0 0)
			else
				(sndLightRow fade: 60 10 5 0 0)
			)
		)
		(if (gSounds contains: sndStorm)
			(if (== param1 838)
				(sndStorm fade: 127 10 5 0 0)
			else
				(sndStorm fade: 60 10 5 0 0)
			)
		)
		(= local4 (rDarkBeing curFrame:))
		(if (and (not (IsFlag 370)) (> local4 0))
			(cond
				((> local4 218)
					(SetFlag 214)
					(SetFlag 219)
				)
				((> local4 130)
					(SetFlag 214)
				)
			)
		)
		(DoRobot)
		(pBrainJars dispose:)
		(pBlueTube dispose:)
		(pPurpleTube dispose:)
		(pDoor dispose:)
		(pGreenLights dispose:)
		(pLightRow dispose:)
		(pLightStorm dispose:)
		(pOtherDoor dispose:)
		(pTbar dispose:)
		(pLittleLever dispose:)
		(pBigLever dispose:)
		(pWheel dispose:)
		(pCrank dispose:)
		(pTrunk dispose:)
		(pBlueLights dispose:)
		(pLeftControlLever dispose:)
		(pRightControlLever dispose:)
		(pLeftSwitch dispose:)
		(pRightSwitch dispose:)
		(pDial dispose:)
		(pScreen dispose:)
		(pHat dispose:)
		(pLittleScreen dispose:)
		(pPipe dispose:)
		(vBlueLights dispose:)
		(vLeftSwitch dispose:)
		(vRightSwitch dispose:)
		(vLeftLever dispose:)
		(vPipe dispose:)
		(vModulatorInPlace dispose:)
		(vDoctor dispose:)
		(vStock dispose:)
		(vModulatorOnTable dispose:)
		(fBluePrints dispose:)
		(fToolBox dispose:)
		(moveUpRight dispose:)
		(moveUpLeft dispose:)
		(moveGateLeft dispose:)
		(moveGateRight dispose:)
		(rDarkBeing dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(0
				(gBackMusic stop:)
				(Portal kill:)
				(if (IsFlag 394)
					((ScriptID 19 0) seconds: 0) ; BombTimer
				else
					(gGame getDisc: 2)
					(gCurRoom newRoom: 400)
				)
			)
			(830
				(if (not (IsFlag 349))
					(vDoctor init:)
				)
				(pBlueTube init: setCycle: Fwd)
				(pGreenLights init: setCycle: Fwd)
				(if (IsFlag 214)
					(if (IsFlag 272)
						(pBrainJars init:)
					)
					(pBigLever init:)
				)
				(if (IsFlag 219)
					(pLittleLever init:)
					(if (IsFlag 272)
						(pLightRow init: setCycle: Fwd)
					)
				)
				(cond
					((IsFlag 213)
						(vPipe init:)
					)
					((IsFlag 190)
						(vModulatorInPlace init:)
					)
				)
				((ScriptID 1 1) newPic: 837 2) ; exitForward
				((ScriptID 1 4) newPic: 839 9) ; exitRight
				((ScriptID 1 3) newPic: 840 3) ; exitLeft
				((ScriptID 1 2) newPic: 836 5) ; exitBack
				(if (IsFlag 172)
					(Portal init: 2830 188 89)
				)
				(if
					(and
						(IsFlag 272)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(IsFlag 215)
						(gInventory contains: (ScriptID 9 64)) ; invCannon
					)
					(SetFlag 370)
					(gBackMusic pause: 1)
					(gBackMusic2 stop:)
					(proc0_8 146)
					(gBackMusic pause: 0)
				)
			)
			(831
				(cond
					((IsFlag 213)
						(vPipe init:)
					)
					((IsFlag 190)
						(vModulatorInPlace init:)
					)
				)
				((ScriptID 1 7) newPic: 851 1 exitCode: doorExitCode) ; exitBackUp
				(if (IsFlag 214)
					(pBigLever init:)
					(if (IsFlag 272)
						(pBrainJars init:)
					)
				)
				(if (IsFlag 219)
					(pLittleLever init:)
					(if (IsFlag 272)
						(pLightRow init: setCycle: Fwd)
					)
				)
				(if (IsFlag 212)
					((ScriptID 1 1) ; exitForward
						newPic: 832 1
						createPoly: 218 0 310 0 310 299 218 299
					)
				)
				(if (and (IsFlag 272) (not (IsFlag 370)))
					(vModulatorOnTable init:)
				)
				(pDoor init:)
			)
			(832
				(pPurpleTube init: setCycle: Fwd)
				(if (and (IsFlag 272) (not (IsFlag 370)))
					(Load rsAUDIO 8009 859)
					(ClearFlag 412)
					(ClearFlag 190)
					(gCurRoom setScript: sDarkBeing)
					((ScriptID 1 1) newPic: 834 1 exitCode: beingExitCode) ; exitForward
				else
					((ScriptID 1 1) newPic: 834 1) ; exitForward
					(pTbar init:)
					(cond
						((IsFlag 213)
							(pLightStorm init: setCycle: Fwd)
							(vPipe init:)
						)
						((IsFlag 190)
							(vModulatorInPlace init:)
						)
					)
					(if (IsFlag 214)
						(pBigLever init:)
						(if (IsFlag 272)
							(pBrainJars init:)
						)
					)
					(if (IsFlag 219)
						(pLittleLever init:)
						(if (IsFlag 272)
							(pLightRow init: setCycle: Fwd)
						)
					)
					((ScriptID 1 7) newPic: 831 1) ; exitBackUp
				)
			)
			(833
				(if (IsFlag 213)
					(pLightStorm init: setCycle: Fwd)
				else
					(pTbar init:)
				)
				(pPurpleTube init: setCycle: Fwd)
				(if
					(and
						(IsFlag 272)
						(IsFlag 215)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(not (gInventory contains: (ScriptID 9 64))) ; invCannon
					)
					(WalkieTalkie showFrame: 129 0 63 0 400)
					(self setScript: sSmackPlayer2)
				else
					((ScriptID 1 2) newPic: 835 3) ; exitBack
					((ScriptID 1 4) newPic: 836 5) ; exitRight
					((ScriptID 1 3) newPic: 834 1) ; exitLeft
				)
			)
			(834
				(pBlueTube init: setCycle: Fwd)
				(if (IsFlag 219)
					(pLittleLever init:)
					(if (IsFlag 272)
						(pLightRow init: setCycle: Fwd)
					)
				)
				(if (IsFlag 214)
					(pBigLever init:)
					(if (IsFlag 272)
						(pBrainJars init:)
					)
				)
				(if (IsFlag 213)
					(pLightStorm init: setCycle: Fwd)
					(vPipe init:)
				else
					(if (IsFlag 190)
						(vModulatorInPlace init:)
					)
					(pTbar init:)
				)
				((ScriptID 1 1) newPic: 838 16) ; exitForward
				((ScriptID 1 2) newPic: 836 5) ; exitBack
				((ScriptID 1 4) newPic: 833 8) ; exitRight
				((ScriptID 1 3) newPic: 837 2) ; exitLeft
				(if (and (IsFlag 272) (not (IsFlag 370)) (IsFlag 212))
					(SetFlag 370)
					(gBackMusic pause: 1)
					(gBackMusic2 stop:)
					(proc0_8 147)
					(gBackMusic pause: 0)
					(FrameOut)
				)
			)
			(835
				(if (not (IsFlag 349))
					(vDoctor init:)
				)
				(pBlueTube init: setCycle: Fwd)
				(if global251
					(vBlueLights init:)
					(pLittleScreen init: setCycle: Fwd)
				)
				(if (not (IsFlag 354))
					(vLeftSwitch init:)
				)
				(if (not (IsFlag 355))
					(vRightSwitch init:)
				)
				(if (IsFlag 356)
					(vLeftLever init:)
				)
				((ScriptID 1 1) newPic: 848 3) ; exitForward
				((ScriptID 1 2) newPic: 833 8) ; exitBack
				((ScriptID 1 4) newPic: 837 2) ; exitRight
				((ScriptID 1 3) newPic: 836 5) ; exitLeft
			)
			(836
				(pDoor init:)
				(pOtherDoor init:)
				((ScriptID 1 4) newPic: 835 3) ; exitRight
				((ScriptID 1 3) newPic: 833 8) ; exitLeft
				(if
					(and
						(IsFlag 272)
						(IsFlag 215)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(not (gInventory contains: (ScriptID 9 64))) ; invCannon
					)
					((ScriptID 1 2) newPic: 833 8) ; exitBack
				else
					((ScriptID 1 2) newPic: 834 1) ; exitBack
				)
				(cond
					((IsFlag 212)
						((ScriptID 1 1) ; exitForward
							newPic: 995 12
							createPoly: 248 0 382 0 382 269 251 267
						)
					)
					((== global237 4)
						((ScriptID 1 1) ; exitForward
							newPic: 869 8
							createPoly: 31 1 159 1 160 282 35 297
						)
					)
					(else
						((ScriptID 1 1) ; exitForward
							newPic: 855 8
							createPoly: 31 1 159 1 160 282 35 297
						)
					)
				)
			)
			(837
				(if (not (IsFlag 349))
					(vDoctor init:)
				)
				(pBlueTube init: setCycle: Fwd)
				(pPurpleTube init: setCycle: Fwd)
				(pGreenLights init: setCycle: Fwd)
				(if global251
					(vBlueLights init:)
				)
				(if (not (IsFlag 354))
					(vLeftSwitch init:)
				)
				(if (not (IsFlag 355))
					(vRightSwitch init:)
				)
				(if
					(and
						(IsFlag 272)
						(IsFlag 215)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(not (gInventory contains: (ScriptID 9 64))) ; invCannon
					)
					((ScriptID 1 4) newPic: 833 8) ; exitRight
				else
					((ScriptID 1 4) newPic: 834 1) ; exitRight
				)
				((ScriptID 1 3) newPic: 835 3) ; exitLeft
				(moveUpLeft newPic: 844 4)
				(moveUpRight newPic: 843 1)
				(if (IsFlag 172)
					(Portal init: 2833 0 0)
					((ScriptID 1 1) newRoom: 340 exitCode: portalExitCode) ; exitForward
				)
			)
			(838
				(pPurpleTube init: setCycle: Fwd)
				(pBigLever init:)
				(pTbar init:)
				(pLittleLever init:)
				(pCrank
					init:
					setPoints:
						0
						-24
						3
						-23
						4
						-22
						9
						-21
						14
						-18
						19
						-13
						22
						-5
						24
						2
						20
						12
						12
						19
						1
						22
						-10
						20
						-20
						14
						-23
						6
						-24
						-4
						-21
						-12
						-15
						-17
						-9
						-20
						-4
						-21
						-1
						-22
				)
				(pWheel
					init:
					setPoints:
						3
						-27
						5
						-26
						9
						-25
						13
						-25
						18
						-20
						22
						-14
						26
						-6
						27
						4
						22
						16
						14
						23
						3
						26
						-10
						23
						-17
						17
						-22
						5
						-23
						-5
						-19
						-15
						-13
						-21
						-7
						-24
						-2
						-25
						2
						-26
				)
				(if (and (IsFlag 272) (IsFlag 219))
					(pLightRow init: setCycle: Fwd)
				)
				(if (and (IsFlag 272) (IsFlag 214))
					(pBrainJars init:)
				)
				(if (IsFlag 213)
					(vPipe init:)
					(pLightStorm init: setCycle: Fwd)
				else
					(vModulatorInPlace init:)
				)
				((ScriptID 1 2) newPic: 836 5) ; exitBack
				((ScriptID 1 4) newPic: 833 8) ; exitRight
			)
			(839
				(SetFlag 184)
				(pPurpleTube init: setCycle: Fwd)
				(pGreenLights init: setCycle: Fwd)
				(if (IsFlag 214)
					(pBigLever init:)
					(if (IsFlag 272)
						(pBrainJars init:)
					)
				)
				(if (IsFlag 219)
					(pLittleLever init:)
					(if (IsFlag 272)
						(pLightRow init: setCycle: Fwd)
					)
				)
				(if (IsFlag 213)
					(vPipe init:)
				else
					(pTbar init:)
					(if (IsFlag 190)
						(vModulatorInPlace init:)
					)
				)
				(if
					(and
						(IsFlag 272)
						(IsFlag 215)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(not (gInventory contains: (ScriptID 9 64))) ; invCannon
					)
					((ScriptID 1 1) newPic: 833 8) ; exitForward
				else
					((ScriptID 1 1) newPic: 834 1) ; exitForward
				)
				((ScriptID 1 3) newPic: 830 2) ; exitLeft
				(if (IsFlag 172)
					(Portal init: 2834 0 64)
				)
			)
			(840
				(if (not (IsFlag 349))
					(vDoctor init:)
				)
				(pBlueTube init: setCycle: Fwd)
				(pGreenLights init: setCycle: Fwd)
				((ScriptID 1 4) newPic: 830 2) ; exitRight
				((ScriptID 1 1) newPic: 835 3) ; exitForward
				(if (IsFlag 172)
					(Portal init: 2835 407 0)
				)
			)
			(841
				(if local1
					((ScriptID 1 4) newPic: 844 4) ; exitRight
					((ScriptID 1 3) newPic: 842 8) ; exitLeft
				else
					(pDoor init:)
					(pOtherDoor init:)
					((ScriptID 1 1) newPic: 836 5) ; exitForward
					((ScriptID 1 2) newPic: 843 1) ; exitBack
					((ScriptID 1 4) newPic: 844 4) ; exitRight
					(if
						(and
							(IsFlag 272)
							(IsFlag 215)
							(not (IsFlag 370))
							(not (IsFlag 351))
							(not (gInventory contains: (ScriptID 9 64))) ; invCannon
						)
						((ScriptID 1 3) newPic: 833 8) ; exitLeft
					else
						((ScriptID 1 3) newPic: 842 8) ; exitLeft
					)
				)
			)
			(842
				(if local1
					(vPipe init:)
					(pPurpleTube init: setCycle: Fwd)
					(pLightStorm init: setCycle: Fwd)
					(pLittleLever init:)
					(pLightRow init: setCycle: Fwd)
					(pBrainJars init:)
					(pBigLever init:)
					((ScriptID 1 4) newPic: 841 13) ; exitRight
					((ScriptID 1 3) newPic: 843 1) ; exitLeft
					(WalkieTalkie showFrame: 137 0 63 0 400)
					(self setScript: sSmackPlayer)
				else
					(if (IsFlag 214)
						(pBigLever init:)
						(if (IsFlag 272)
							(pBrainJars init:)
						)
					)
					(pPurpleTube init: setCycle: Fwd)
					(if (IsFlag 213)
						(vPipe init:)
						(pLightStorm init: setCycle: Fwd)
					else
						(pTbar init:)
						(if (IsFlag 190)
							(vModulatorInPlace init:)
						)
					)
					(if (IsFlag 219)
						(pLittleLever init:)
						(if (IsFlag 272)
							(pLightRow init: setCycle: Fwd)
						)
					)
					((ScriptID 1 1) newPic: 838 16) ; exitForward
					((ScriptID 1 2) newPic: 844 4) ; exitBack
					((ScriptID 1 4) newPic: 841 13) ; exitRight
					((ScriptID 1 3) newPic: 843 1) ; exitLeft
				)
			)
			(843
				(if local1
					((ScriptID 1 4) newPic: 842 8) ; exitRight
					((ScriptID 1 3) newPic: 844 4) ; exitLeft
					(pPurpleTube init: setCycle: Fwd)
					(vPipe init:)
					(pLittleLever init:)
					(pBigLever init:)
				else
					(cond
						((IsFlag 213)
							(vPipe init:)
						)
						((IsFlag 190)
							(vModulatorInPlace init:)
						)
					)
					(pPurpleTube init: setCycle: Fwd)
					(if (IsFlag 219)
						(pLittleLever init:)
					)
					(if (IsFlag 214)
						(pBigLever init:)
					)
					((ScriptID 1 3) newPic: 844 4) ; exitLeft
					((ScriptID 1 1) newPic: 846 1) ; exitForward
					(if
						(and
							(IsFlag 272)
							(IsFlag 215)
							(not (IsFlag 370))
							(not (IsFlag 351))
							(not (gInventory contains: (ScriptID 9 64))) ; invCannon
						)
						((ScriptID 1 4) newPic: 833 8) ; exitRight
					else
						((ScriptID 1 4) newPic: 842 8) ; exitRight
					)
				)
				(if (IsFlag 172)
					(Portal init: 2836 0 6)
					(moveGateLeft newRoom: 340 exitCode: portalExitCode)
				)
			)
			(844
				(cond
					(local1
						(vDoctor init:)
						(pBlueTube init: setCycle: Fwd)
						((ScriptID 1 4) newPic: 843 1) ; exitRight
						((ScriptID 1 3) newPic: 841 13) ; exitLeft
					)
					(local0
						(= local0 0)
						(pBlueTube init: setCycle: Fwd)
						((ScriptID 1 2) newPic: 842 8) ; exitBack
						((ScriptID 1 4) newPic: 843 1) ; exitRight
						((ScriptID 1 3) newPic: 841 13) ; exitLeft
						(if global251
							(vBlueLights init:)
						)
						(self setScript: sWakeHimUp)
					)
					(else
						(if (not (IsFlag 349))
							(vDoctor init:)
						)
						(pBlueTube init: setCycle: Fwd)
						(if global251
							(vBlueLights init:)
						)
						((ScriptID 1 2) newPic: 842 8) ; exitBack
						((ScriptID 1 4) newPic: 843 1) ; exitRight
						((ScriptID 1 3) newPic: 841 13) ; exitLeft
					)
				)
				(if (IsFlag 172)
					(Portal init: 844 350 0)
					(moveGateRight newRoom: 340 exitCode: portalExitCode)
				)
			)
			(846
				(pTrunk init:)
				(pBlueTube init: setCycle: Fwd)
				(if
					(and
						(IsFlag 272)
						(IsFlag 215)
						(not (IsFlag 370))
						(not (IsFlag 351))
						(not (gInventory contains: (ScriptID 9 64))) ; invCannon
					)
					((ScriptID 1 2) newPic: 833 8 exitCode: domainExitCode) ; exitBack
				else
					((ScriptID 1 2) newPic: 847 13 exitCode: domainExitCode) ; exitBack
				)
			)
			(847
				(pDoor init:)
				(pOtherDoor init:)
				((ScriptID 1 3) newPic: 842 8) ; exitLeft
				((ScriptID 1 4) newPic: 844 4) ; exitRight
				((ScriptID 1 1) newPic: 841 13) ; exitForward
				((ScriptID 1 2) newPic: 846 1) ; exitBack
			)
			(848
				(if (not (IsFlag 349))
					(vDoctor init:)
				)
				(pHat loop: 1 init:)
				(pBlueLights init:)
				(pLeftControlLever init:)
				(pRightControlLever init:)
				(pLeftSwitch init:)
				(pRightSwitch init:)
				(pDial
					init:
					setPoints:
						20
						16
						25
						12
						28
						9
						32
						6
						35
						2
						37
						-3
						39
						-7
						40
						-11
						40
						-16
						39
						-20
						38
						-25
						33
						-33
						30
						-36
						27
						-39
						22
						-41
						17
						-45
				)
				(localproc_0)
				(myBackUp newPic: 835 3)
			)
			(849
				(pPurpleTube init: setCycle: Fwd)
				(pGreenLights init: setCycle: Fwd)
				((ScriptID 1 7) newPic: 852 9 exitCode: otherDoorExitCode) ; exitBackUp
				(if (IsFlag 172)
					(Portal init: 2838 231 85 fadeSound:)
				)
				(pOtherDoor init:)
			)
			(851
				(if (IsFlag 172)
					(Portal fadeSound:)
				)
				(if (gSounds contains: sndLightRow)
					(sndLightRow stop:)
				)
				(if (gSounds contains: sndStorm)
					(sndStorm stop:)
				)
				((ScriptID 1 1) newPic: 831 1) ; exitForward
				((ScriptID 1 2) newPic: 995 12) ; exitBack
			)
			(852
				(if (IsFlag 172)
					(Portal fadeSound:)
				)
				(if (gSounds contains: sndLightRow)
					(sndLightRow stop:)
				)
				(if (gSounds contains: sndStorm)
					(sndStorm stop:)
				)
				((ScriptID 1 1) newPic: 849 9) ; exitForward
				(if (== global237 4)
					((ScriptID 1 2) newPic: 869 8) ; exitBack
				else
					((ScriptID 1 2) newPic: 855 8) ; exitBack
				)
			)
			(855
				(if (IsFlag 215)
					(ClearFlag 215)
					(gMySoundFX do: 861)
				)
				(if (IsFlag 172)
					(Portal fadeSound:)
				)
				(if (gSounds contains: sndLightRow)
					(sndLightRow stop:)
				)
				(if (gSounds contains: sndStorm)
					(sndStorm stop:)
				)
				(fToolBox init:)
				((ScriptID 1 1) ; exitForward
					newRoom: 270
					createPoly:
						261
						56
						288
						70
						302
						102
						305
						158
						298
						195
						286
						204
						250
						210
						240
						199
						234
						142
						228
						81
						241
						59
				)
				((ScriptID 1 2) newPic: 852 9) ; exitBack
			)
			(869
				(if (IsFlag 215)
					(ClearFlag 215)
					(gMySoundFX do: 861)
				)
				(if (IsFlag 172)
					(Portal fadeSound:)
				)
				(if (gSounds contains: sndLightRow)
					(sndLightRow stop:)
				)
				(if (gSounds contains: sndStorm)
					(sndStorm stop:)
				)
				(fToolBox init:)
				((ScriptID 1 1) ; exitForward
					newRoom: 270
					createPoly:
						112
						84
						134
						66
						161
						60
						198
						75
						213
						105
						209
						233
						189
						247
						123
						248
						111
						241
				)
				((ScriptID 1 2) newPic: 852 9) ; exitBack
			)
			(994
				(if (IsFlag 408)
					(vStock init:)
				)
				((ScriptID 1 1) newPic: 851 1) ; exitForward
				((ScriptID 1 3) newPic: 997 3) ; exitLeft
				((ScriptID 1 2) newPic: 996 5) ; exitBack
			)
			(995
				(if (IsFlag 212)
					(ClearFlag 212)
					(gMySoundFX do: 861)
				)
				(if (IsFlag 172)
					(Portal stopSound:)
				)
				(if (gSounds contains: sndLightRow)
					(sndLightRow stop:)
				)
				(if (gSounds contains: sndStorm)
					(sndStorm stop:)
				)
				(if (IsFlag 408)
					(vStock init:)
				)
				((ScriptID 1 1) newPic: 996 5) ; exitForward
				((ScriptID 1 4) newPic: 997 3) ; exitRight
				((ScriptID 1 2) newPic: 851 1) ; exitBack
			)
			(996
				((ScriptID 1 1) newRoom: 270) ; exitForward
				((ScriptID 1 2) newPic: 994 16) ; exitBack
			)
			(997
				(if (not (IsFlag 408))
					(vStock init:)
				)
				((ScriptID 1 7) newPic: local3) ; exitBackUp
			)
		)
		(gGame handsOn:)
		(= local3 scene)
	)

	(method (dispose)
		(Lock rsAUDIO 8011 0)
		(Lock rsAUDIO 9101 0)
		(Lock rsAUDIO 800 0)
		(gBackMusic stop:)
		(gBackMusic2 stop:)
		(super dispose: &rest)
	)

	(method (notify)
		(cond
			((== (gCurRoom scene:) 837)
				((ScriptID 1 1) exitCode: 0 dispose:) ; exitForward
			)
			((== (gCurRoom scene:) 843)
				(moveGateLeft exitCode: 0 dispose:)
			)
			((== (gCurRoom scene:) 844)
				(moveGateRight exitCode: 0 dispose:)
			)
			(else
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
				)
				(if (not (gPanels contains: (ScriptID 16 0))) ; cannonPanel
					(if (== (gCurRoom scene:) 838)
						(gCurRoom setScript: sGateExpires)
					else
						(gCurRoom setScript: sShowGateClose)
					)
				)
			)
		)
	)

	(method (cue)
		(vStock dispose:)
	)
)

(instance sShowGateClose of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(or
						(gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(> (gPanels size:) 1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if (!= (gPanels at: temp0) (ScriptID 9 1)) ; PlInterface
						((gPanels at: temp0) hide:)
					)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(= cycles 1)
			)
			(2
				(proc0_8 3881)
				(= cycles 1)
			)
			(3
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if
						(and
							(== (gPanels at: temp0) (ScriptID 9 3)) ; PlCompass
							(gPanels contains: (ScriptID 9 4)) ; InvInset
						)
						0
					else
						((gPanels at: temp0) show:)
					)
				)
				(gCurRoom changeScene: (gCurRoom scene:))
				(self dispose:)
			)
		)
	)
)

(instance sGateExpires of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(or
						(gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(> (gPanels size:) 1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if (!= (gPanels at: temp0) (ScriptID 9 1)) ; PlInterface
						((gPanels at: temp0) hide:)
					)
				)
				(sndStorm dispose:)
				(sndLightRow fade: 40 10 5 0 0)
				(pLightStorm dispose:)
				(proc0_8 3881)
				(= cycles 1)
			)
			(2
				(sndLightRow fade: 127 10 5 0 0)
				(ClearFlag 401)
				(= global250 0)
				(= global252 0)
				(= global253 0)
				(ClearFlag 213)
				(vPipe dispose:)
				(vModulatorInPlace init:)
				(pPipe cel: 10 init: setCycle: Beg pPipe)
				(pBrainJars setCycle: 0)
				(pBrainJars cel: 0)
				(gMySoundFX do: 900)
				(pTbar setCycle: End self)
			)
			(3
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if
						(and
							(== (gPanels at: temp0) (ScriptID 9 3)) ; PlCompass
							(gPanels contains: (ScriptID 9 4)) ; InvInset
						)
						0
					else
						((gPanels at: temp0) show:)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShutDownGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Portal kill:)
				(sndStorm dispose:)
				(sndLightRow fade: 40 10 5 0 0)
				(pLightStorm dispose:)
				(proc0_8 3881)
				(= cycles 1)
			)
			(1
				(sndLightRow fade: 127 10 5 0 0)
				(ClearFlag 401)
				(= global250 1)
				(= global252 0)
				(= global253 0)
				(vPipe dispose:)
				(vModulatorInPlace init:)
				(pPipe cel: 10 init: setCycle: Beg pPipe)
				(pBrainJars setCycle: 0)
				(pBrainJars cel: 0)
				(ClearFlag 213)
				(gMySoundFX do: 900)
				(pTbar setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWakeHimUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(Lock rsAUDIO 941 1)
				(Lock rsAUDIO 942 1)
			)
			(1
				(gGame handsOff:)
				(pWakeDoctor init: setCycle: CT 3 1 self)
			)
			(2
				(gMySoundFX do: 941)
				(pWakeDoctor setCycle: End self)
			)
			(3
				(pWakeDoctor view: 197 cel: 0 setCycle: End self)
				(= cycles 20)
			)
			(4
				(gMySoundFX do: 942)
			)
			(5
				(Lock rsAUDIO 941 0)
				(Lock rsAUDIO 942 0)
				(pWakeDoctor dispose:)
				(vDoctor init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pWakeDoctor of Prop
	(properties
		y 240
		view 195
	)
)

(instance sShockTheMonkey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pBlueLights setCycle: Fwd)
				(vDoctor hide:)
				(pHat hide:)
				(switch register
					(1
						(cond
							((IsFlag 390)
								(SetFlag 416)
							)
							((IsFlag 389)
								(SetFlag 390)
							)
							(else
								(SetFlag 389)
							)
						)
						(pScreen loop: 8)
						(KillRobot 194 0 0)
					)
					(2
						(ClearFlag 389)
						(ClearFlag 390)
						(pScreen loop: 9)
						(KillRobot 193 0 0)
					)
					(3
						(ClearFlag 389)
						(ClearFlag 390)
						(pScreen loop: 10)
						(KillRobot 192 0 0)
					)
				)
			)
			(1
				(pScreen loop: 7)
				(pBlueLights setCycle: 0 cel: 1)
				(vDoctor show:)
				(pHat show:)
				(pRightControlLever setCycle: Beg self)
			)
			(2
				(if (IsFlag 416)
					(ClearFlag 356)
					(ClearFlag 354)
					(pLeftControlLever setCycle: Beg self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gMySoundFX do: 903)
				(pHat setCycle: Beg self)
			)
			(4
				(= local0 1)
				(gCurRoom changeScene: 844 4)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks 90)
				(sndLightRow fade: 60 10 5 0 0)
				(sndStorm fade: 60 10 5 0 0)
			)
			(2
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(if (gPanels contains: (ScriptID 9 4)) ; InvInset
					((ScriptID 9 4) dispose:) ; InvInset
				)
				(gInventory disable: 1)
				(proc0_8 3880)
				(= cycles 1)
			)
			(3
				(gCurRoom drawPic: 837)
				(if (not (IsFlag 349))
					(pTmpDoctor init:)
				)
				(pTmpTube1 init: setCycle: Fwd)
				(pTmpTube2 init: setCycle: Fwd)
				(pTmpLights init: setCycle: Fwd)
				(KillRobot 2832 0 0)
			)
			(4
				(Portal startSound: 937)
				(sndLightRow fade: 127 10 5 0 0)
				(sndStorm fade: 127 10 5 0 0)
				(pTmpDoctor dispose:)
				(pTmpTube1 dispose:)
				(pTmpTube2 dispose:)
				(pTmpLights dispose:)
				(gCurRoom drawPic: 838)
				(gInventory disable: 0)
				(gCast eachElementDo: #show)
				(= cycles 1)
			)
			(5
				(SetFlag 172)
				(SetFlag 413)
				(Portal startTimer:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDarkBeing of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(gBackMusic pause: 0)
				(gBackMusic2 loop: -1 number: 8009 play: 0 0)
				(gBackMusic2 fade: 127 10 5 0 0)
				(rDarkBeing init: 135 0 0 0 300)
				(= cycles 1)
			)
			(2
				(gMySoundFX do: 859)
				(SetFlag 190)
				(= global250 1)
				(= global252 0)
				(= global253 0)
				(rDarkBeing caller: self cycleTo: 58 1 10)
			)
			(3
				(gGame handsOn:)
				(rDarkBeing caller: self cycleTo: 67 1 10)
			)
			(4
				(robotSound1 number: 868 play:)
				(rDarkBeing caller: self cycleTo: 83 1 10)
			)
			(5
				(robotSound1 number: 868 play:)
				(rDarkBeing caller: self cycleTo: 96 1 10)
			)
			(6
				(robotSound1 number: 868 play:)
				(rDarkBeing caller: self cycleTo: 121 1 10)
			)
			(7
				(= global252 2)
				(= global250 2)
				(robotSound1 number: 823 play:)
				(rDarkBeing caller: self cycleTo: 125 1 10)
			)
			(8
				(sndLightRow play:)
				(pLightRow init: setCycle: Fwd)
				(SetFlag 214)
				(= global250 3)
				(rDarkBeing caller: self cycleTo: 141 1 10)
			)
			(9
				(robotSound1 number: 824 play:)
				(rDarkBeing caller: self cycleTo: 145 1 10)
			)
			(10
				(pBrainJars init:)
				(SetFlag 219)
				(= global250 4)
				(rDarkBeing caller: self cycleTo: 158 1 10)
			)
			(11
				(robotSound1 number: 829 play:)
				(rDarkBeing caller: self cycleTo: 165 1 10)
			)
			(12
				(= global253 1)
				(pBrainJars cycleSpeed: 10 setCycle: Fwd)
				(rDarkBeing caller: self cycleTo: 170 1 10)
			)
			(13
				(= global253 2)
				(pBrainJars cycleSpeed: 7)
				(rDarkBeing caller: self cycleTo: 176 1 10)
			)
			(14
				(= global253 3)
				(pBrainJars cycleSpeed: 3)
				(= global250 5)
				(rDarkBeing caller: self cycleTo: 233 1 10)
			)
			(15
				(if
					(or
						(gPanels contains: (ScriptID 9 2)) ; PlBagPlane
						(> (gPanels size:) 1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(gGame handsOff:)
				(robotSound1 stop:)
				(= global250 6)
				(SetFlag 213)
				(SetFlag 401)
				(robotSound1 number: 831 play:)
				(rDarkBeing caller: self cycleTo: 272 1 10)
			)
			(17
				(sndStorm play:)
				(pLightStorm init: setCycle: Fwd)
				(robotSound1 number: 858 play:)
				(rDarkBeing caller: self cycleTo: 315 1 10)
			)
			(18
				(SetFlag 172)
				(SetFlag 413)
				(SetFlag 370)
				(= global250 6)
				(rDarkBeing dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0)
				(gBackMusic2 stop:)
				(= cycles 1)
			)
			(19
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if (!= (gPanels at: temp0) (ScriptID 9 1)) ; PlInterface
						((gPanels at: temp0) hide:)
					)
				)
				(= cycles 1)
			)
			(20
				(proc0_8 3880)
				(= cycles 1)
			)
			(21
				(gCurRoom drawPic: 837)
				(pTmpDoctor init:)
				(pTmpTube1 init: setCycle: Fwd)
				(pTmpTube2 init: setCycle: Fwd)
				(pTmpLights init: setCycle: Fwd)
				(KillRobot 2832 0 0)
			)
			(22
				(Portal startSound: 937)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0)
				(proc0_8 148)
				(= cycles 1)
			)
			(23
				(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
					(if
						(and
							(== (gPanels at: temp0) (ScriptID 9 3)) ; PlCompass
							(gPanels contains: (ScriptID 9 4)) ; InvInset
						)
						0
					else
						((gPanels at: temp0) show:)
					)
				)
				(gBackMusic pause: 0)
				(Portal startTimer:)
				(gCurRoom changeScene: 832 1)
				(self dispose:)
			)
		)
	)
)

(instance sLoopDarkBeing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= ticks (Random 120 600))
				else
					(= local6 1)
					(= cycles 1)
				)
			)
			(1
				(KillRobot 133 0 0)
			)
			(2
				(= ticks (Random 120 600))
			)
			(3
				(KillRobot 134 0 0)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sSmackPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(= ticks 1)
			)
			(2
				(KillRobot 137 63 0 0 400)
			)
			(3
				(gCurRoom fade: 2 1 self)
			)
			(4
				(gCurRoom changeScene: 0)
				(self dispose:)
			)
		)
	)
)

(instance sSmackPlayer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(gInventory deleteItem: (ScriptID 9 63)) ; invBluePrints
				(gInventory deleteItem: (ScriptID 9 36)) ; invAmanda
				(ClearFlag 225)
				(ClearFlag 378)
				(if (not (IsFlag 394))
					(ClearFlag 350)
				)
				(ClearFlag 377)
				(ClearFlag 416)
				(ClearFlag 390)
				(ClearFlag 389)
				(KillRobot 129 63 0 0 400 1)
			)
			(2
				(gCurRoom fade: 2 1 self)
			)
			(3
				(gCurRoom changeScene: 0)
				(self dispose:)
			)
		)
	)
)

(instance pLittleScreen of Prop
	(properties
		x 283
		y 133
		view 2845
	)

	(method (init)
		(if (IsFlag 356)
			(= loop 5)
		else
			(= loop 4)
		)
		(= cel 0)
		(super init: &rest)
	)
)

(instance pPipe of Prop
	(properties
		x 60
		y 294
		view 2848
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(cond
			((IsFlag 412)
				(= view 28392)
			)
			((IsFlag 190)
				(= view 28391)
			)
			(else
				(= view 2839)
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(if cel
			(vPipe init:)
		)
		(self dispose:)
	)
)

(instance pWheel of TrackingProp
	(properties
		x 121
		y 170
		view 2848
		loop 10
		cycleSpeed 1
		oneWay 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (setCel param1)
		(if (== param1 0)
			(++ global252)
		)
		(super setCel: param1 &rest)
	)

	(method (doMouseUp)
		(self setCycle: End self)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (!= cel local8) (OneOf cel 4 8 13))
			(gMySoundFX do: 868)
		)
		(= local8 cel)
	)

	(method (cue)
		(self setCel: 0)
		(if (and (>= global252 2) (== global250 1) (IsFlag 272))
			(= global250 2)
		)
	)
)

(instance pCrank of TrackingProp
	(properties
		x 228
		y 123
		view 2848
		loop 3
		cycleSpeed 1
		oneWay 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (setCel param1)
		(if (== param1 0)
			(++ global253)
		)
		(super setCel: param1 &rest)
		(if (and (IsFlag 272) (IsFlag 214))
			(switch global253
				(1
					(pBrainJars cycleSpeed: 10 setCycle: Fwd)
				)
				(2
					(pBrainJars cycleSpeed: 7)
				)
				(3
					(pBrainJars cycleSpeed: 3)
				)
			)
		)
	)

	(method (doMouseUp)
		(self setCycle: End self)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= cel local7)
			(gMySoundFX do: 870)
		)
		(= local7 cel)
	)

	(method (cue)
		(self setCel: 0)
		(if (and (>= global253 3) (== global250 4) (IsFlag 272))
			(= global250 5)
		)
	)
)

(instance pTrunk of Prop
	(properties
		x 249
		y 279
		view 2855
	)

	(method (init)
		(= cel 0)
		(= loop (if (IsFlag 225) 1 else 2))
		(super init: &rest)
		(approachX hotVerbs: 5 76)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 227)
					(gGame handsOff:)
					(if cel
						(if (not (IsFlag 225))
							(fBluePrints dispose:)
						)
						(self setCycle: Beg self)
					else
						(if (not (IsFlag 225))
							(fBluePrints init:)
						)
						(gMySoundFX do: 921)
						(self setCycle: End self)
					)
				else
					(pplTrunk init:)
				)
			)
			(76 ; invRockHammer
				(if (not (IsFlag 227))
					(pplTrunk init:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (not cel)
			(gMySoundFX do: 922)
		)
		(gGame handsOn:)
	)
)

(instance pBrainJars of Prop
	(properties
		cycleSpeed 12
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 4)
				(= cel 0)
				(= x 479)
				(= y 92)
			)
			(831
				(= view 2840)
				(= loop 2)
				(= cel 0)
				(= x 294)
				(= y 136)
			)
			(832
				(= view 2842)
				(= loop 4)
				(= cel 0)
				(= x 212)
				(= y 128)
			)
			(834
				(= view 2844)
				(= loop 4)
				(= cel 0)
				(= x 236)
				(= y 54)
			)
			(838
				(= view 2848)
				(= loop 7)
				(= cel 0)
				(= x 193)
				(= y 75)
			)
			(839
				(= view 2849)
				(= loop 4)
				(= cel 0)
				(= x 354)
				(= y 96)
			)
			(842
				(= view 2852)
				(= loop 3)
				(= cel 0)
				(= x 249)
				(= y 56)
			)
		)
		(super init: &rest)
		(if (>= global250 5)
			(self cycleSpeed: 3 setCycle: Fwd)
		)
	)
)

(instance pBlueTube of Prop
	(properties
		priority 10
		fixPriority 1
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= cel (= loop 0))
				(= x 193)
				(= y 150)
			)
			(834
				(= view 2844)
				(= cel (= loop 0))
				(= x 334)
				(= y 174)
			)
			(835
				(= view 2845)
				(= cel (= loop 0))
				(= x 429)
				(= y 34)
			)
			(837
				(= view 2847)
				(= cel (= loop 0))
				(= x 120)
				(= y 171)
			)
			(839
				(= view 2849)
				(= cel (= loop 0))
				(= x 73)
				(= y 177)
			)
			(840
				(= view 2850)
				(= cel (= loop 0))
				(= x 347)
				(= y 113)
			)
			(844
				(= view 2854)
				(= cel (= loop 0))
				(= x 424)
				(= y 128)
			)
			(846
				(= view 2855)
				(= loop 3)
				(= cel 0)
				(= x 26)
				(= y 73)
			)
		)
		(super init: &rest)
	)
)

(instance pPurpleTube of Prop
	(properties
		priority 10
		fixPriority 1
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(832
				(= view 2842)
				(= loop 3)
				(= cel 0)
				(= x 274)
				(= y 208)
			)
			(833
				(= view 2843)
				(= loop 2)
				(= cel 0)
				(= x 23)
				(= y 183)
			)
			(837
				(= view 2847)
				(= loop 1)
				(= cel 0)
				(= x 373)
				(= y 153)
			)
			(838
				(= view 2848)
				(= loop 11)
				(= cel 0)
				(= x 346)
				(= y 210)
			)
			(839
				(= view 2849)
				(= cel (= loop 0))
				(= x 73)
				(= y 177)
			)
			(842
				(= view 2852)
				(= cel (= loop 0))
				(= x 327)
				(= y 178)
			)
			(843
				(= view 2853)
				(= cel (= loop 0))
				(= x 80)
				(= y 133)
			)
			(849
				(= view 2859)
				(= loop 1)
				(= cel 0)
				(= x 251)
				(= y 152)
			)
		)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		priority 501
		fixPriority 1
	)

	(method (init)
		(= priority 400)
		(switch (gCurRoom scene:)
			(831
				(= view 2865)
				(= loop 0)
				(= x 172)
				(= y 299)
			)
			(836
				(= view 2846)
				(= loop 1)
				(= x 235)
				(= y 273)
			)
			(841
				(= view 2851)
				(= loop 1)
				(= x 292)
				(= y 244)
			)
			(847
				(= view 2857)
				(= loop 1)
				(= x 367)
				(= y 215)
			)
			(850
				(= view 2860)
				(= loop 0)
				(= x 166)
				(= y 210)
			)
		)
		(= cel
			(if (IsFlag 212)
				(self lastCel:)
			else
				0
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (== (gCurRoom scene:) 831) (IsFlag 271))
					(gGame handsOff:)
					(if cel
						(ClearFlag 212)
						((ScriptID 1 1) dispose:) ; exitForward
						(gMySoundFX do: 861)
						(self setCycle: Beg self)
					else
						(if (IsFlag 172)
							(Portal startSound: 937)
						)
						(if (and (IsFlag 272) (IsFlag 219))
							(sndLightRow play: 60 0)
						)
						(if (and (IsFlag 272) (IsFlag 213))
							(sndStorm play: 60 0)
						)
						(SetFlag 212)
						((ScriptID 1 1) ; exitForward
							newPic: 832 1
							createPoly: 218 0 310 0 310 299 218 299
						)
						(gMySoundFX do: 861)
						(self setCycle: End self)
					)
				else
					(if (not (IsFlag 212))
						(gMySoundFX do: 776)
					)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (and cel (IsFlag 272) (not (IsFlag 370)))
			(vModulatorOnTable init:)
			(gCurRoom setScript: sLoopDarkBeing)
		)
		(if (not cel)
			(if (IsFlag 172)
				(Portal fadeSound:)
			)
			(if (gSounds contains: sndLightRow)
				(sndLightRow stop:)
			)
			(if (gSounds contains: sndStorm)
				(sndStorm stop:)
			)
		)
		(gGame handsOn:)
	)
)

(instance pOtherDoor of Prop
	(properties
		priority 501
		fixPriority 1
	)

	(method (init)
		(switch (gCurRoom scene:)
			(836
				(= view 2846)
				(= loop 0)
				(= x 17)
				(= y 297)
			)
			(841
				(= view 2851)
				(= loop 0)
				(= x 131)
				(= y 267)
			)
			(847
				(= view 2857)
				(= loop 0)
				(= x 235)
				(= y 217)
			)
			(849
				(= view 2859)
				(= loop 0)
				(= x 251)
				(= y 276)
			)
			(850
				(= view 2860)
				(= loop 1)
				(= x 51)
				(= y 230)
			)
		)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (== (gCurRoom scene:) 849) (IsFlag 274))
					(gGame handsOff:)
					(if cel
						(ClearFlag 215)
						((ScriptID 1 1) dispose:) ; exitForward
						(gMySoundFX do: 861)
						(self setCycle: Beg self)
					else
						(if (IsFlag 172)
							(Portal startSound: 937)
						)
						(if (and (IsFlag 272) (IsFlag 219))
							(sndLightRow play: 60 0)
						)
						(if (and (IsFlag 272) (IsFlag 213))
							(sndStorm play: 60 0)
						)
						(SetFlag 215)
						((ScriptID 1 1) newPic: 830 2) ; exitForward
						(gMySoundFX do: 861)
						(self setCycle: End self)
					)
				else
					(if (not (IsFlag 215))
						(gMySoundFX do: 776)
					)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (not cel)
			(if (IsFlag 172)
				(Portal fadeSound:)
			)
			(if (gSounds contains: sndLightRow)
				(sndLightRow stop:)
			)
			(if (gSounds contains: sndStorm)
				(sndStorm stop:)
			)
		)
		(gGame handsOn:)
	)
)

(instance pGreenLights of Prop
	(properties)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 3)
				(= cel 0)
				(= x 193)
				(= y 73)
			)
			(837
				(= view 2847)
				(= loop 3)
				(= cel 0)
				(= x 253)
				(= y 67)
			)
			(839
				(= view 2849)
				(= loop 3)
				(= cel 0)
				(= x 2)
				(= y 66)
			)
			(840
				(= view 2850)
				(= loop 1)
				(= cel 0)
				(= x 452)
				(= y 16)
			)
			(849
				(= view 2859)
				(= loop 2)
				(= cel 0)
				(= x 257)
				(= y 90)
			)
		)
		(super init: &rest)
	)
)

(instance pLightRow of Prop
	(properties)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 6)
				(= cel 0)
				(= x 471)
				(= y 155)
			)
			(831
				(= view 2840)
				(= loop 4)
				(= cel 0)
				(= x 295)
				(= y 173)
			)
			(832
				(= view 2842)
				(= loop 6)
				(= cel 0)
				(= x 204)
				(= y 190)
			)
			(834
				(= view 2844)
				(= loop 6)
				(= cel 0)
				(= x 223)
				(= y 154)
			)
			(838
				(= view 2848)
				(= loop 6)
				(= cel 0)
				(= x 202)
				(= y 194)
			)
			(839
				(= view 2849)
				(= loop 6)
				(= cel 0)
				(= x 334)
				(= y 183)
			)
			(842
				(= view 2852)
				(= loop 5)
				(= cel 0)
				(= x 253)
				(= y 161)
			)
		)
		(super init: &rest)
	)
)

(instance pLightStorm of Prop
	(properties)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(832
				(= view 2842)
				(= cel (= loop 0))
				(= x 299)
				(= y 180)
			)
			(833
				(= view 2843)
				(= loop 1)
				(= cel 0)
				(= x 95)
				(= y 144)
			)
			(834
				(= view 2844)
				(= loop 7)
				(= cel 0)
				(= x 403)
				(= y 50)
			)
			(842
				(= view 2852)
				(= loop 6)
				(= cel 0)
				(= x 423)
				(= y 142)
			)
			(838
				(= view 2848)
				(= loop 4)
				(= cel 0)
				(= x 407)
				(= y 170)
			)
		)
		(super init: &rest)
	)
)

(instance pTbar of Prop
	(properties)

	(method (onMe)
		(if (!= (gCurRoom scene:) 838)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(832
				(= view 2842)
				(= loop 5)
				(= cel (if (IsFlag 213) 2 else 3))
				(= x 286)
				(= y 234)
			)
			(833
				(= view 2843)
				(= cel (= loop 0))
				(= x 64)
				(= y 246)
			)
			(834
				(= view 2844)
				(= loop 5)
				(= cel 2)
				(= x 353)
				(= y 253)
			)
			(838
				(= view 2848)
				(= loop 2)
				(= cel
					(if (IsFlag 213)
						0
					else
						(self lastCel:)
					)
				)
				(= x 418)
				(= y 295)
			)
			(839
				(= view 2849)
				(= loop 5)
				(= cel 0)
				(= x 411)
				(= y 296)
			)
			(842
				(= view 2852)
				(= loop 4)
				(= cel 2)
				(= x 386)
				(= y 254)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 838)
					(gGame handsOff:)
					(cond
						((not (IsFlag 401))
							(if (and (== global250 5) (IsFlag 272))
								(SetFlag 213)
								(SetFlag 401)
							)
							(pPipe cel: 0 init: setCycle: End)
							(gMySoundFX do: 900)
							(self setCycle: Beg self)
						)
						((IsFlag 213)
							(gCurRoom setScript: sShutDownGate)
						)
						(else
							(SetFlag 213)
							(pPipe cel: 0 init: setCycle: End)
							(gMySoundFX do: 900)
							(self setCycle: Beg self)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(cond
			((and (not (IsFlag 401)) (not (IsFlag 213)))
				(if cel
					(gGame handsOn:)
				else
					(pPipe setCycle: Beg pPipe)
					(gMySoundFX do: 900)
					(self setCycle: End self)
				)
			)
			((IsFlag 213)
				(sndStorm play: 127 0)
				(pLightStorm init: setCycle: Fwd)
				(cond
					((and (== global250 5) (IsFlag 272))
						(= global250 6)
						(gCurRoom setScript: sOpenTheGate)
					)
					((and (not (IsFlag 412)) (IsFlag 190))
						(= global250 1)
					)
					(else
						(= global250 0)
					)
				)
			)
		)
	)
)

(instance pBigLever of Prop
	(properties)

	(method (onMe)
		(if (!= (gCurRoom scene:) 838)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 5)
				(= cel 0)
				(= x 424)
				(= y 203)
			)
			(831
				(= view 2840)
				(= loop 3)
				(= cel 1)
				(= x 280)
				(= y 212)
			)
			(832
				(= view 2842)
				(= loop 5)
				(= cel 0)
				(= x 168)
				(= y 248)
			)
			(834
				(= view 2844)
				(= loop 5)
				(= cel 0)
				(= x 162)
				(= y 250)
			)
			(838
				(= view 2848)
				(= loop 0)
				(= cel
					(if (IsFlag 214)
						(self lastCel:)
					else
						0
					)
				)
				(= x 165)
				(= y 295)
			)
			(839
				(= view 2849)
				(= loop 5)
				(= cel 1)
				(= x 300)
				(= y 236)
			)
			(842
				(= view 2852)
				(= loop 4)
				(= cel 0)
				(= x 172)
				(= y 258)
			)
			(843
				(= view 2853)
				(= loop 3)
				(= cel 0)
				(= x 434)
				(= y 214)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 838)
					(gGame handsOff:)
					(gMySoundFX do: 865)
					(if cel
						(ClearFlag 214)
						(self setCycle: Beg self)
					else
						(SetFlag 214)
						(self setCycle: End self)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if cel
			(if (IsFlag 272)
				(pBrainJars init:)
			)
			(if (and (== global250 2) (IsFlag 272))
				(= global250 3)
			else
				(if (IsFlag 370)
					(= global252 0)
					(= global253 0)
				)
				(if (and (not (IsFlag 412)) (IsFlag 190))
					(= global250 1)
				else
					(= global250 0)
				)
			)
			(gGame handsOn:)
		else
			(if (IsFlag 370)
				(= global252 0)
				(= global253 0)
			)
			(if (and (not (IsFlag 412)) (IsFlag 190))
				(= global250 1)
			else
				(= global250 0)
			)
			(pBrainJars dispose:)
			(if (IsFlag 172)
				(gCurRoom setScript: sShutDownGate)
			else
				(gGame handsOn:)
			)
		)
	)
)

(instance pLittleLever of Prop
	(properties)

	(method (onMe)
		(if (!= (gCurRoom scene:) 838)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 5)
				(= cel 1)
				(= x 444)
				(= y 135)
			)
			(831
				(= view 2840)
				(= loop 3)
				(= cel 0)
				(= x 288)
				(= y 163)
			)
			(832
				(= view 2842)
				(= loop 5)
				(= cel 1)
				(= x 177)
				(= y 173)
			)
			(834
				(= view 2844)
				(= loop 5)
				(= cel 1)
				(= x 177)
				(= y 72)
			)
			(838
				(= view 2848)
				(= loop 1)
				(= cel
					(if (IsFlag 219)
						(self lastCel:)
					else
						0
					)
				)
				(= x 195)
				(= y 153)
			)
			(839
				(= view 2849)
				(= loop 5)
				(= cel 2)
				(= x 289)
				(= y 159)
			)
			(842
				(= view 2852)
				(= loop 4)
				(= cel 1)
				(= x 213)
				(= y 130)
			)
			(843
				(= view 2853)
				(= loop 3)
				(= cel 1)
				(= x 491)
				(= y 90)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 838)
					(gGame handsOff:)
					(gMySoundFX do: 899)
					(if cel
						(ClearFlag 219)
						(self setCycle: Beg self)
					else
						(SetFlag 219)
						(self setCycle: End self)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if cel
			(if (IsFlag 272)
				(sndLightRow play: 127 0)
				(pLightRow init: setCycle: Fwd)
			)
			(if (and (== global250 3) (IsFlag 272))
				(= global250 4)
			else
				(if (IsFlag 370)
					(= global252 0)
					(= global253 0)
				)
				(if (and (not (IsFlag 412)) (IsFlag 190))
					(= global250 1)
				else
					(= global250 0)
				)
			)
			(gGame handsOn:)
		else
			(if (IsFlag 370)
				(= global252 0)
				(= global253 0)
			)
			(if (and (not (IsFlag 412)) (IsFlag 190))
				(= global250 1)
			else
				(= global250 0)
			)
			(sndLightRow stop:)
			(pLightRow dispose:)
			(if (IsFlag 172)
				(gCurRoom setScript: sShutDownGate)
			else
				(gGame handsOn:)
			)
		)
	)
)

(instance vModulatorOnTable of View
	(properties
		x 243
		y 171
		view 2840
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance vLeftLever of View
	(properties
		x 242
		y 154
		view 2845
		loop 2
	)
)

(instance vLeftSwitch of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(835
				(= view 2845)
				(= loop 1)
				(= cel 0)
				(= x 247)
				(= y 168)
			)
			(837
				(= view 2847)
				(= loop 4)
				(= x (= cel 1))
				(= y 216)
			)
		)
		(super init: &rest)
	)
)

(instance vRightSwitch of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(835
				(= view 2845)
				(= cel (= loop 1))
				(= x 247)
				(= y 168)
			)
			(837
				(= view 2847)
				(= loop 4)
				(= cel 0)
				(= x 1)
				(= y 216)
			)
		)
		(super init: &rest)
	)
)

(instance vBlueLights of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(835
				(= view 2845)
				(= loop 3)
				(= cel 0)
				(= x 305)
				(= y 129)
			)
			(837
				(= view 2847)
				(= loop 5)
				(= cel 0)
				(= x 48)
				(= y 195)
			)
			(844
				(= view 2854)
				(= loop 1)
				(= cel 0)
				(= x 12)
				(= y 103)
			)
		)
		(super init: &rest)
	)
)

(instance vStock of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(994
				(= view 994)
				(= x (= cel (= loop 0)))
				(= y 167)
			)
			(995
				(= view 993)
				(= cel (= loop 0))
				(= x 423)
				(= y 86)
			)
			(997
				(= view 4839)
				(= cel (= loop 0))
				(= x 126)
				(= y 93)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 997)
					((ScriptID 16 0) init: (ScriptID 9 59)) ; cannonPanel, invStock
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vDoctor of View
	(properties
		priority 300
		fixPriority 1
	)

	(method (init)
		(cond
			((IsFlag 416)
				(= loop 2)
			)
			((IsFlag 356)
				(= loop 1)
			)
			(else
				(= loop 0)
			)
		)
		(= cel 0)
		(switch (gCurRoom scene:)
			(830
				(= view 3830)
				(= x 63)
				(= y 200)
			)
			(835
				(= view 3831)
				(= x 230)
				(= y 130)
			)
			(837
				(= view 3832)
				(= x 21)
				(= y 157)
			)
			(840
				(= view 3833)
				(= x 328)
				(= y 139)
			)
			(844
				(= view 3834)
				(= x 92)
				(= y 161)
			)
			(848
				(= view 3836)
				(= x 240)
				(= y 143)
				(if (IsFlag 416)
					(= loop 2)
				else
					(= loop 0)
				)
			)
		)
		(super init: &rest)
		(if (not local1)
			(approachX hotVerbs: 5 93 72)
		)
	)

	(method (doVerb theVerb)
		(if
			(and
				(OneOf (gCurRoom scene:) 844 848)
				(not local1)
				(IsFlag 416)
			)
			(switch theVerb
				(93 ; invAmanda
					(if (IsFlag 172)
						(if (IsFlag 406)
							(gGame handsOff:)
							(SetFlag 349)
							(vDoctor dispose:)
							(Lock rsAUDIO 800 0)
							(Lock rsAUDIO 9101 1)
							(gBackMusic number: 9101 loop: -1 play: 127 0)
							(proc0_8 196)
							(gGame handsOn:)
						else
							(gGame handsOff:)
							(SetFlag 405)
							(pDocTalk init: setCycle: RandCycle)
							(if ((ScriptID 11 1) seconds:) ; tGateTimer
								((ScriptID 11 1) ; tGateTimer
									seconds: (+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
								)
							)
							(gMessager say: 37 0 0 3 pDocTalk 330) ; "Where are my blueprints?"
						)
					else
						(gGame handsOff:)
						(pDocTalk init: setCycle: RandCycle)
						(switch (Random 1 2)
							(1
								(if ((ScriptID 11 1) seconds:) ; tGateTimer
									((ScriptID 11 1) ; tGateTimer
										seconds:
											(+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
									)
								)
								(gMessager say: 37 0 0 1 pDocTalk 330) ; "Ohhh... my head... Where am I?"
							)
							(else
								(if ((ScriptID 11 1) seconds:) ; tGateTimer
									((ScriptID 11 1) ; tGateTimer
										seconds:
											(+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
									)
								)
								(gMessager say: 37 0 0 4 pDocTalk 330) ; "I feel dizzy..."
							)
						)
					)
				)
				(72 ; invBluePrints
					(if (IsFlag 172)
						(if (IsFlag 405)
							(gGame handsOff:)
							(SetFlag 349)
							(vDoctor dispose:)
							(Lock rsAUDIO 800 0)
							(Lock rsAUDIO 9101 1)
							(gBackMusic number: 9101 loop: -1 play: 127 0)
							(proc0_8 196)
							(gGame handsOn:)
						else
							(gGame handsOff:)
							(SetFlag 406)
							(pDocTalk init: setCycle: RandCycle)
							(if ((ScriptID 11 1) seconds:) ; tGateTimer
								((ScriptID 11 1) ; tGateTimer
									seconds: (+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
								)
							)
							(gMessager say: 37 0 0 2 pDocTalk 330) ; "I won't leave without my Amanda!"
						)
					else
						(gGame handsOff:)
						(pDocTalk init: setCycle: RandCycle)
						(switch (Random 1 2)
							(1
								(if ((ScriptID 11 1) seconds:) ; tGateTimer
									((ScriptID 11 1) ; tGateTimer
										seconds:
											(+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
									)
								)
								(gMessager say: 37 0 0 1 pDocTalk 330) ; "Ohhh... my head... Where am I?"
							)
							(else
								(if ((ScriptID 11 1) seconds:) ; tGateTimer
									((ScriptID 11 1) ; tGateTimer
										seconds:
											(+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
									)
								)
								(gMessager say: 37 0 0 4 pDocTalk 330) ; "I feel dizzy..."
							)
						)
					)
				)
				(5 ; Do
					(gGame handsOff:)
					(pDocTalk init: setCycle: RandCycle)
					(switch (Random 1 2)
						(1
							(if ((ScriptID 11 1) seconds:) ; tGateTimer
								((ScriptID 11 1) ; tGateTimer
									seconds: (+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
								)
							)
							(gMessager say: 37 0 0 1 pDocTalk 330) ; "Ohhh... my head... Where am I?"
						)
						(else
							(if ((ScriptID 11 1) seconds:) ; tGateTimer
								((ScriptID 11 1) ; tGateTimer
									seconds: (+ ((ScriptID 11 1) seconds:) 10) ; tGateTimer
								)
							)
							(gMessager say: 37 0 0 4 pDocTalk 330) ; "I feel dizzy..."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance vPipe of View
	(properties)

	(method (onMe)
		(if (!= (gCurRoom scene:) 838)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (init)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 1)
				(= cel 0)
				(= x 402)
				(= y 203)
			)
			(831
				(= view 2840)
				(= cel (= loop 0))
				(= x 259)
				(= y 206)
			)
			(832
				(= view 2842)
				(= loop 2)
				(= cel 0)
				(= x 121)
				(= y 248)
			)
			(834
				(= view 2844)
				(= loop 1)
				(= cel 0)
				(= x 81)
				(= y 83)
			)
			(838
				(= view 2848)
				(= loop 8)
				(= cel 0)
				(= x 60)
				(= y 294)
			)
			(839
				(= view 2849)
				(= loop 1)
				(= cel 0)
				(= x 253)
				(= y 238)
			)
			(842
				(= view 2852)
				(= loop 1)
				(= cel 0)
				(= x 96)
				(= y 287)
			)
			(843
				(= view 2853)
				(= loop 1)
				(= cel 0)
				(= x 346)
				(= y 210)
			)
		)
		(super init: &rest)
	)
)

(instance vModulatorInPlace of View
	(properties)

	(method (onMe)
		(if (!= (gCurRoom scene:) 838)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (init)
		(= cel
			(cond
				((IsFlag 412) 3)
				((IsFlag 190) 2)
				(else 1)
			)
		)
		(switch (gCurRoom scene:)
			(830
				(= view 2841)
				(= loop 1)
				(= x 401)
				(= y 159)
			)
			(831
				(= view 2840)
				(= loop 0)
				(= x 257)
				(= y 182)
			)
			(832
				(= view 2842)
				(= loop 2)
				(= x 120)
				(= y 202)
			)
			(834
				(= view 2844)
				(= loop 1)
				(= x 81)
				(= y 172)
			)
			(838
				(= view 2848)
				(= loop 8)
				(= x 33)
				(= y 236)
			)
			(839
				(= view 2849)
				(= loop 1)
				(= x 253)
				(= y 186)
			)
			(842
				(= view 2852)
				(= loop 1)
				(= x 87)
				(= y 177)
			)
			(843
				(= view 2853)
				(= loop 1)
				(= x 352)
				(= y 133)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 48)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48 ; invModulator
				(if (and (== cel 1) (== (gCurRoom scene:) 838))
					(gInventory deleteItem: (ScriptID 9 39)) ; invModulator
					(= global250 1)
					(SetFlag 190)
					(= cel 2)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(5 ; Do
				(if (and (== (gCurRoom scene:) 838) (== cel 3))
					(ClearFlag 190)
					(ClearFlag 412)
					(= global250 0)
					(= cel 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fToolBox of Feature
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 855)
			(self createPoly: 94 195 228 186 228 228 97 246)
		else
			(self createPoly: 230 216 369 211 368 258 227 265)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				((ScriptID 271 0) init:) ; toolBoxPanel
			)
		)
	)
)

(instance fBluePrints of Feature
	(properties)

	(method (init)
		(self
			createPoly:
				194
				206
				211
				192
				226
				205
				235
				196
				251
				194
				265
				201
				280
				189
				294
				238
				194
				238
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 225)
				(gInventory addItem: (ScriptID 9 63)) ; invBluePrints
				(pTrunk loop: 1)
				(UpdateScreenItem pTrunk)
				(gMySoundFX do: 923)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance domainExitCode of Code
	(properties)

	(method (doit)
		(if (pTrunk cel:)
			(gGame handsOff:)
			(pTrunk setCycle: Beg self)
		else
			(self cue: 1)
		)
	)

	(method (cue)
		(if (not argc)
			(gMySoundFX do: 922)
		)
		(if
			(and
				(IsFlag 272)
				(IsFlag 215)
				(not (IsFlag 370))
				(not (IsFlag 351))
				(not (gInventory contains: (ScriptID 9 64))) ; invCannon
			)
			(gCurRoom changeScene: 833 8)
		else
			(gCurRoom changeScene: 847 13)
		)
	)
)

(instance portalExitCode of Code
	(properties)

	(method (doit)
		(if (and (IsFlag 350) (IsFlag 349))
			(SetFlag 407)
			(if (gTimers contains: (ScriptID 19 0)) ; BombTimer
				((ScriptID 19 0) seconds: 0) ; BombTimer
			else
				(gCurRoom newRoom: 380)
			)
		else
			(gCurRoom newRoom: 340)
		)
	)
)

(instance doorExitCode of Code
	(properties)

	(method (doit)
		(if (pDoor cel:)
			(gGame handsOff:)
			(gCurRoom setScript: 0)
			(ClearFlag 212)
			(gMySoundFX do: 861)
			(pDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(DoRobot)
		(gCurRoom changeScene: 851 1)
	)
)

(instance otherDoorExitCode of Code
	(properties)

	(method (doit)
		(if (pOtherDoor cel:)
			(gGame handsOff:)
			(ClearFlag 215)
			(gMySoundFX do: 861)
			(pOtherDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 852 9)
	)
)

(instance beingExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(robotSound1 stop:)
		(gMySoundFX stop:)
		(gCurRoom setScript: 0)
		(rDarkBeing dispose:)
		(gCurRoom changeScene: 834 1)
	)
)

(instance pplTrunk of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(ppLock init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance ppLock of PanelProp
	(properties
		view 2856
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 76)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(76 ; invRockHammer
				(gGame handsOff:)
				(SetFlag 227)
				(gInventory deleteItem: (ScriptID 9 67)) ; invRockHammer
				(ClearFlag 262)
				(gMySoundFX do: 920)
				(self setCycle: End pplTrunk)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pScreen of Prop
	(properties
		x 206
		y 190
		view 2858
	)

	(method (init)
		(= loop (if (IsFlag 356) 7 else 6))
		(super init: &rest)
	)
)

(class TableProp of Prop
	(properties
		view 2858
		cycleSpeed 5
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(self setCycle: Beg self)
				else
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

(instance pBlueLights of Prop
	(properties
		x 245
		y 181
		view 2858
		cycleSpeed 5
	)
)

(instance pLeftControlLever of Prop
	(properties
		x 111
		y 260
		view 2858
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((IsFlag 416)
						(super doVerb: theVerb &rest)
					)
					(cel
						(gGame handsOff:)
						(self setCycle: Beg self)
					)
					(else
						(gGame handsOff:)
						(self setCycle: End self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gMySoundFX do: 903)
		(pScreen loop: 6)
		(if cel
			(pHat loop: 1 setCycle: End pHat)
		else
			(pHat loop: 1 setCycle: Beg pHat)
		)
	)
)

(instance pLeftSwitch of TableProp
	(properties
		x 167
		y 259
		loop 2
	)

	(method (init)
		(= cel (if (IsFlag 354) 0 else 10))
		(super init: &rest)
	)

	(method (cue)
		(if cel
			(ClearFlag 354)
		else
			(SetFlag 354)
		)
		(localproc_0)
		(gMySoundFX do: 903)
		(super cue:)
	)
)

(instance pRightSwitch of TableProp
	(properties
		x 167
		y 259
		loop 3
	)

	(method (init)
		(= cel (if (IsFlag 355) 0 else 10))
		(super init: &rest)
	)

	(method (cue)
		(if cel
			(ClearFlag 355)
		else
			(SetFlag 355)
		)
		(localproc_0)
		(gMySoundFX do: 903)
		(super cue:)
	)
)

(instance pRightControlLever of TableProp
	(properties
		x 361
		y 253
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(self setCycle: Beg self)
				else
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if cel
			(cond
				((and (IsFlag 355) (IsFlag 354) (== global242 0))
					(if (IsFlag 356)
						(self setScript: sShockTheMonkey 0 3)
					else
						(pBlueLights setCycle: Fwd)
						(sndShock play:)
						(pHat loop: 0 setCycle: ForwardCounter 3 pHat)
					)
				)
				((and (not (IsFlag 355)) (IsFlag 354) (== global242 5))
					(if (IsFlag 356)
						(self setScript: sShockTheMonkey 0 2)
					else
						(pBlueLights setCycle: Fwd)
						(sndShock play:)
						(pHat loop: 0 setCycle: ForwardCounter 2 pHat)
					)
				)
				((and (IsFlag 355) (not (IsFlag 354)) (== global242 11))
					(if (IsFlag 356)
						(self setScript: sShockTheMonkey 0 1)
					else
						(pBlueLights setCycle: Fwd)
						(sndShock play:)
						(pHat loop: 0 setCycle: ForwardCounter 1 pHat)
					)
				)
				(else
					(self setCycle: Beg self)
				)
			)
		else
			(super cue: &rest)
		)
	)
)

(instance pHat of Prop
	(properties
		x 74
		y 14
		priority 400
		fixPriority 1
		view 3837
		loop 1
	)

	(method (init)
		(= cel (if (IsFlag 356) 8 else 0))
		(super init: &rest)
	)

	(method (cue)
		(cond
			((not loop)
				(ClearFlag 389)
				(ClearFlag 390)
				(pBlueLights setCycle: 0 cel: 1)
				(= loop 1)
				(= cel 0)
				(pRightControlLever setCycle: Beg pRightControlLever)
				(sndShock stop:)
			)
			(cel
				(SetFlag 356)
				(pScreen loop: 7)
				(gGame handsOn:)
			)
			(else
				(ClearFlag 356)
				(gGame handsOn:)
			)
		)
	)
)

(instance pDial of TrackingProp
	(properties
		x 248
		y 253
		view 2858
		loop 5
		wrap 0
	)

	(method (init)
		(= cel global242)
		(= local9 cel)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= cel local9)
			(gMySoundFX do: 904)
			(= global242 cel)
			(localproc_0)
		)
		(= local9 cel)
	)
)

(instance myBackUp of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 249 501 249 500 300 422 300
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -1 250 76 250 76 302 -1 300
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 249 501 249 500 300 422 300
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -1 250 76 250 76 302 -1 300
					yourself:
				)
		)
	)
)

(instance rDarkBeing of RobotPlayer
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 73)
		(self setNowSeen:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(73 ; invCannon
				(gGame handsOff:)
				(gCurRoom setScript: 0)
				(rDarkBeing dispose:)
				(gBackMusic2 stop:)
				(gMySoundFX stop:)
				(SetFlag 370)
				(SetFlag 351)
				(gInventory deleteItem: (ScriptID 9 64)) ; invCannon
				(pTbar init:)
				(vModulatorInPlace init:)
				(proc0_8 149)
				(gInventory addItem: (ScriptID 9 89)) ; invBeingInBottle
				(gBackMusic fade: 127 10 5 0 0)
				(gGame handsOn:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robotSound1 of Sound
	(properties)

	(method (stop)
		(super stop: &rest)
		(self dispose:)
	)
)

(instance pTmpDoctor of Prop
	(properties
		x 21
		y 157
		view 3832
	)

	(method (init)
		(if (IsFlag 416)
			(= loop 2)
		else
			(= loop 0)
		)
		(super init: &rest)
	)
)

(instance pTmpTube1 of Prop
	(properties
		x 120
		y 171
		priority 10
		fixPriority 1
		view 2847
	)
)

(instance pTmpTube2 of Prop
	(properties
		x 373
		y 153
		view 2847
		loop 1
	)
)

(instance pTmpLights of Prop
	(properties
		x 253
		y 67
		view 2847
		loop 3
	)
)

(instance moveUpRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(self createPoly: 343 160 499 160 499 299 343 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 7)
		(self createPoly: 343 160 499 160 499 299 343 299)
	)
)

(instance moveUpLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self createPoly: 127 79 199 79 199 290 127 290)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self createPoly: 127 79 199 79 199 290 127 290)
	)
)

(instance sndStorm of Sound
	(properties
		number 864
		loop -1
	)

	(method (stop)
		(super stop: &rest)
		(self dispose:)
	)
)

(instance sndLightRow of Sound
	(properties
		number 901
		loop -1
	)

	(method (stop)
		(super stop: &rest)
		(self dispose:)
	)
)

(instance moveGateLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self
			createPoly:
				0
				30
				43
				66
				68
				98
				98
				150
				121
				195
				126
				239
				125
				271
				118
				299
				0
				299
		)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self
			createPoly:
				0
				30
				43
				66
				68
				98
				98
				150
				121
				195
				126
				239
				125
				271
				118
				299
				0
				299
		)
	)
)

(instance moveGateRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(self createPoly: 372 299 381 204 431 93 499 54 499 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 7)
		(self createPoly: 372 299 381 204 431 93 499 54 499 299)
	)
)

(instance pDocTalk of Prop
	(properties)

	(method (init)
		(vDoctor hide:)
		(if (== (gCurRoom scene:) 844)
			(= view 3834)
			(= loop 3)
			(= cel 0)
			(= x 92)
			(= y 162)
			(= z 1)
		else
			(= view 3836)
			(= loop 4)
			(= cel 0)
			(= x 240)
			(= y 144)
			(= z 1)
		)
		(super init: &rest)
	)

	(method (cue)
		(vDoctor show:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance sndShock of Sound
	(properties
		flags 1
		number 943
		loop -1
	)

	(method (stop)
		(super stop: &rest)
		(self dispose:)
	)
)

