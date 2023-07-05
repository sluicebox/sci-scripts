;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Cursor)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm490 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
	local6
	local7
	local8 = 1
)

(procedure (localproc_0 param1)
	(gCurRoom compassDir: param1)
	(if (IsFlag 368)
		((gGame compassFace:) setLoop: param1 setCel: 0)
	)
)

(procedure (localproc_1)
	(switch (gGame printLang:)
		(49
			(bigScrollPanel init: 140 5 500 445)
		)
		(else
			(bigScrollPanel init: 155 20 485 430)
		)
	)
)

(instance rm490 of LightRoom
	(properties
		picture 491
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 369)
			(SetFlag 387)
		)
		(if (== global111 0)
			(= global111 9)
			(= global112 6)
			(= global113 8)
		)
		(Lock rsAUDIO 10070 1)
		(gBackMusic number: 10070 setLoop: -1 play: 0 0 fade: 127 25 10 0)
		(vaseWithHandles where: global112)
		(skinnyVase where: global113)
		(brassVase where: global111)
		(switch gPrevRoomNum
			(500
				(self changeScene: 497)
				(self notify:)
			)
			(765
				(ClearFlag 89)
				(self changeScene: 493)
			)
			(else
				(ClearFlag 89)
				(= local8 1)
				(self changeScene: 491)
			)
		)
		(= local2 0)
	)

	(method (notify)
		(if local4
			(self setScript: moveLadder)
			(= local4 0)
		else
			(= local4 1)
		)
	)

	(method (dispose)
		(whistlePanel scratch: 1)
		(glassAlcovePanel scratch: 1)
		(Lock rsAUDIO 10070 0)
		(gBackMusic fade:)
		(if global208
			(birdManBot dispose:)
		)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		((ScriptID 1 3) arrowStyle: 1) ; exitLeft
		((ScriptID 1 4) arrowStyle: 0) ; exitRight
		((ScriptID 1 1) arrowStyle: 3) ; exitForward
		(cannonGone dispose:)
		(windowLock dispose:)
		(windowFeature dispose:)
		(door dispose:)
		(sky dispose:)
		(doorBot dispose:)
		(windowShut dispose:)
		(amulet dispose:)
		(deadHead dispose:)
		(deskFeature dispose:)
		(trapDoor dispose:)
		(whistleDrawer dispose:)
		(windowGrate dispose:)
		(topLeftDrawer dispose:)
		(topVasePos dispose:)
		(secondLevelLeft dispose:)
		(secondLevelRight dispose:)
		(thirdLevelLeft dispose:)
		(thirdLevelRight dispose:)
		(vaseWithHandles dispose:)
		(skinnyVase dispose:)
		(brassVase dispose:)
		(glassAlcoveView dispose:)
		(smallFileDrawer dispose:)
		(smallScrollDoor dispose:)
		(smallThrottleDrawer dispose:)
		(smallGrateDrawer dispose:)
		(autoLadder dispose:)
		(deadGuyView dispose:)
		(ionizerFarView dispose:)
		(super changeScene: param1 &rest)
		(if local6
			(birdManBot init:)
		)
		(switch param1
			(489
				(localproc_0 6)
				(if (not (IsFlag 121))
					(deadHead init:)
				)
				(if (not (IsFlag 218))
					(amulet init:)
				)
				((ScriptID 1 2) newPic: 493 arrowStyle: 2) ; exitBack
				((ScriptID 1 4) newPic: 492) ; exitRight
			)
			(490
				(localproc_0 16)
				((ScriptID 1 3) newPic: 494) ; exitLeft
				(if (IsFlag 89)
					((ScriptID 1 4) newPic: 498) ; exitRight
				else
					((ScriptID 1 4) newPic: 496) ; exitRight
				)
				(if
					(and
						(== local6 0)
						(not (IsFlag 387))
						(== (mod local3 3) 0)
					)
					(KillRobot 173 1 -1)
				)
				(++ local3)
				((ScriptID 1 2) newPic: 493) ; exitBack
			)
			(491
				(localproc_0 3)
				(if (IsFlag 122)
					(cannonGone init:)
				)
				(if (IsFlag 121)
					(deadHead init:)
				)
				(if (IsFlag 217)
					(windowShut init:)
				)
				(vaseWithHandles init:)
				(skinnyVase init:)
				(brassVase init:)
				((ScriptID 1 1) newPic: 494) ; exitForward
				((ScriptID 1 2) newPic: 495) ; exitBack
				((ScriptID 1 3) ; exitLeft
					newPic: 492
					nsTop: 90
					nsLeft: 45
					nsBottom: 245
					nsRight: 165
					arrowStyle: 8
				)
				((ScriptID 1 4) ; exitRight
					newPic: 490
					nsTop: 90
					nsLeft: 330
					nsBottom: 245
					nsRight: 480
					arrowStyle: 7
				)
				(if local8
					(= local8 0)
					(gMySoundFX number: 43522 setLoop: 0 play:)
				)
			)
			(492
				(localproc_0 12)
				(if (not (IsFlag 122))
					(glassAlcoveView init:)
				)
				(topVasePos init:)
				(secondLevelLeft init:)
				(secondLevelRight init:)
				(thirdLevelLeft init:)
				(thirdLevelRight init:)
				(vaseWithHandles init:)
				(skinnyVase init:)
				(brassVase init:)
				(whistleDrawer init:)
				(topLeftDrawer init:)
				(smallFileDrawer init:)
				(smallScrollDoor init:)
				(smallThrottleDrawer init:)
				(smallGrateDrawer init:)
				((ScriptID 1 2) newPic: 493 arrowStyle: 2) ; exitBack
				(if (not local6)
					((ScriptID 1 3) newPic: 489 nsTop: 126) ; exitLeft
				)
			)
			(493
				(localproc_0 5)
				(vaseWithHandles init:)
				(skinnyVase init:)
				(brassVase init:)
				(SetFlag 180)
				(deskFeature init:)
				(deadGuyView init:)
				(if (not (IsFlag 122))
					(ionizerFarView init:)
				)
				((ScriptID 1 4) newPic: 494) ; exitRight
				(if (not local6)
					((ScriptID 1 1) ; exitForward
						newPic: 489
						nsTop: 85
						nsLeft: 115
						nsBottom: 185
						nsRight: 190
						arrowStyle: 9
					)
					((ScriptID 1 3) newPic: 495) ; exitLeft
					((ScriptID 1 2) newPic: 490) ; exitBack
				)
			)
			(494
				(localproc_0 3)
				(vaseWithHandles init:)
				(skinnyVase init:)
				(brassVase init:)
				(if
					(and
						(== local6 0)
						(not (IsFlag 387))
						(== (mod local3 3) 0)
					)
					(KillRobot 3154 121 39)
				)
				(++ local3)
				(if local6
					(windowGrate init: setLoop: 1 posn: 265 267 setPri: 5)
				else
					(windowGrate init:)
				)
				((ScriptID 1 3) newPic: 493) ; exitLeft
				(if (not local6)
					((ScriptID 1 4) newPic: 490) ; exitRight
					((ScriptID 1 2) newPic: 495) ; exitBack
				)
			)
			(495
				(localproc_0 7)
				(door init:)
				(doorBot init: 5469 0 0 0 priority: 10)
				(sky init: setPri: 1)
				(if (IsFlag 89)
					((ScriptID 1 3) newPic: 498 exitCode: closeDoor498) ; exitLeft
				else
					((ScriptID 1 3) newPic: 496 exitCode: closeDoor496) ; exitLeft
				)
				((ScriptID 1 4) newPic: 493 exitCode: closeDoor493) ; exitRight
				((ScriptID 1 2) newPic: 494 exitCode: closeDoor494) ; exitBack
			)
			(496
				(localproc_0 8)
				((ScriptID 1 4) newPic: 495) ; exitRight
				((ScriptID 1 3) newPic: 490) ; exitLeft
				((ScriptID 1 6) newPic: 497) ; exitUp
			)
			(498
				(localproc_0 8)
				((ScriptID 1 4) newPic: 495) ; exitRight
				((ScriptID 1 3) newPic: 490) ; exitLeft
				((ScriptID 1 6) newPic: 497) ; exitUp
			)
			(497
				(localproc_0 8)
				(trapDoor init:)
				(autoLadder init:)
				(if (IsFlag 89)
					((ScriptID 1 6) newRoom: 500 exitCode: ExitToHanger) ; exitUp
				)
				(if (IsFlag 89)
					((ScriptID 1 5) newPic: 498) ; exitDown
				else
					((ScriptID 1 5) newPic: 496) ; exitDown
				)
			)
		)
	)
)

(instance birdManTakesLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 1)
				(clickSounds init: number: 44301 setLoop: -1 play:)
				(gMySoundFX number: 446 setLoop: 0 play:)
				(= ticks 30)
			)
			(1
				(if (IsFlag 217)
					(ClearFlag 217)
					(gMySoundFX number: 439 setLoop: 0 play:)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(birdManBot init:)
			)
			(3
				(gGame handsOnCode: noCode)
				(gGame handsOff:)
				(if (gPanels contains: whistlePanel)
					(if (IsFlag 74)
						(gInventory deleteItem: (ScriptID 9 34)) ; invBatKey
					)
					(whistlePanel scratch: 1 dispose:)
				)
				(if (gPanels contains: glassAlcovePanel)
					(glassAlcovePanel scratch: 1 dispose:)
				)
				(if (gPanels contains: springDrawerPanel)
					(springDrawerPanel dispose:)
				)
				(if (gPanels contains: scrollPanel)
					(scrollPanel dispose:)
				)
				(if (gPanels contains: fileDrawerPanel)
					(fileDrawerPanel dispose:)
				)
				(if (gPanels contains: throttlePanel)
					(throttlePanel dispose:)
				)
				(if (gPanels contains: gratePanel)
					(gratePanel dispose:)
				)
				(if (gPanels contains: bigScrollPanel)
					(bigScrollPanel dispose:)
				)
				(= local6 0)
				(birdManBot dispose:)
				(gCurRoom changeScene: 493)
				(birdManBot dispose:)
				(clickSounds stop:)
				(if (IsFlag 69)
					(KillRobot 3153)
				else
					(KillRobot 158)
					(SetFlag 69)
					(SetFlag 257)
				)
			)
			(4
				(gCurRoom changeScene: 494)
				(if (IsFlag 257)
					(KillRobot 3152 0 3)
				else
					(KillRobot 3151 0 39)
				)
			)
			(5
				(if (and (== global209 0) (IsFlag 311))
					(SetFlag 387)
					(windowGrate dispose:)
					(vaseWithHandles dispose:)
					(skinnyVase dispose:)
					(brassVase dispose:)
					(gCurRoom drawPic: 165)
					(= local5 1)
					(KillRobot 3149 0 0)
				else
					(= cycles 1)
				)
			)
			(6
				(if local5
					(gCurRoom changeScene: 494)
				)
				(smallThrottleDrawer setCel: 0 setLoop: 1)
				(SetFlag 395)
				(gGame handsOnCode: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeWhistle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 43517 setLoop: 0 play:)
				(whistleProp setCycle: Beg self)
			)
			(1
				(if (IsFlag 74)
					(gInventory deleteItem: (ScriptID 9 34)) ; invBatKey
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openFileDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 43503 setLoop: 0 play:)
				(smallFileDrawer setCycle: End self)
			)
			(1
				(fileDrawerPanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openScrollDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 43701 setLoop: 0 play:)
				(smallScrollDoor setPri: 600 setCycle: End self)
			)
			(1
				(scrollPanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openThrottleDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 43501 setLoop: 0 play:)
				(smallThrottleDrawer setPri: 600 setCycle: End self)
			)
			(1
				(throttlePanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openGrateDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 43505 setLoop: 0 play:)
				(smallGrateDrawer setCycle: End self)
			)
			(1
				(gratePanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openTopLeftDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(topLeftDrawer setCycle: End self)
				(gMySoundFX number: 43505 setLoop: 0 play:)
			)
			(1
				(springDrawerPanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
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
		(lockInset init: self 1 1)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(lockPanel dispose:)
	)
)

(instance whistlePanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(whistleProp init: self 1 1)
		(whistleKeyFeat init: whistlePanel 1 1)
		(= scratch 0)
	)

	(method (cue)
		(= scratch 1)
		(self dispose:)
	)

	(method (dispose)
		(if (== scratch 1)
			(super dispose: &rest)
		else
			(whistleProp setScript: closeWhistle self)
		)
	)
)

(instance springDrawerPanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(openDrawerProp init: self 1 1)
		(doNothing init: self 1 1)
		(moveStuff init: self 1 1)
	)

	(method (dispose)
		(topLeftDrawer setCycle: Beg topLeftDrawer)
		(doNothing dispose:)
		(gMySoundFX number: 43506 setLoop: 0 play:)
		(super dispose: &rest)
	)
)

(instance fileDrawerPanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(fileDrawerBackground init: self 1 1)
		(fileDrawerProp init: self 1 1 setCel: 0)
		(if (not (IsFlag 72))
			(batKey init: self 1 1)
		)
		(fileDrawerForward init: self 1 1)
	)

	(method (dispose)
		(diagramView hide:)
		(gMySoundFX number: 43504 setLoop: 0 play:)
		(smallFileDrawer setCycle: Beg smallFileDrawer)
		(super dispose: &rest)
	)
)

(instance glassAlcovePanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= scratch 0)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(glassAlcoveProp init: self 1 1)
	)

	(method (dispose)
		(if (== scratch 1)
			(gGame handsOn:)
			(super dispose: &rest)
		else
			(gGame handsOff:)
			(= local2 1)
			(cond
				(
					(and
						(== (glassAlcoveProp view:) 5474)
						(> (glassAlcoveProp cel:) 0)
					)
					(gMySoundFX number: 43509 setLoop: 0 play:)
					(glassAlcoveProp setCycle: Beg glassAlcoveProp)
				)
				(
					(and
						(== (glassAlcoveProp view:) 6474)
						(== (glassAlcoveProp cel:) 0)
					)
					(gMySoundFX number: 43509 setLoop: 0 play:)
					(glassAlcoveProp setCycle: End glassAlcoveProp)
				)
				(else
					(glassAlcoveProp cue:)
				)
			)
		)
	)
)

(instance scrollPanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(scrollOneFeat init: self 1 1)
		(scrollTwoFeat init: self 1 1)
		(scrollThreeFeat init: self 1 1)
		(scrollProp init: self 1 0)
	)

	(method (dispose)
		(gMySoundFX number: 43702 setLoop: 0 play:)
		(smallScrollDoor setCycle: Beg smallScrollDoor)
		(scrollOne hide:)
		(scrollTwo hide:)
		(scrollThree hide:)
		(super dispose: &rest)
	)
)

(instance throttlePanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(throttleProp init: self 1 1)
		(if (not (IsFlag 69))
			(throttleFeat init: self 1 1)
		)
	)

	(method (dispose)
		(smallThrottleDrawer setCycle: Beg smallThrottleDrawer)
		(gMySoundFX number: 43502 setLoop: 0 play:)
		(super dispose: &rest)
	)
)

(instance gratePanel of InsetPanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(grateProp init: self 1 1)
		(shuffleStuff init: self 1 1)
		(secretPanel init: self 1 1)
		(if (not (IsFlag 88))
			(shuffleNails init: self 1 1)
		)
	)

	(method (dispose)
		(smallGrateDrawer setCycle: Beg smallGrateDrawer)
		(gMySoundFX number: 43506 setLoop: 0 play:)
		(super dispose: &rest)
	)
)

(instance bigScrollPanel of PanelPlane
	(properties)

	(method (init)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: (event x:) (event y:)))
			)
			(event claimed: 1)
			(bigScrollPanel dispose:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance lockInset of PanelProp
	(properties)

	(method (init)
		(self view: 5493 setLoop: 1 setCel: 0)
		(super init: &rest)
		(approachX hotVerbs: 42)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; invDeskKey
				(gGame handsOff:)
				(gMySoundFX number: 43901 setLoop: 0 play:)
				(if (IsFlag 87)
					(ClearFlag 87)
					(self setLoop: 0 setCel: 14 setCycle: Beg lockPanel)
				else
					(SetFlag 87)
					(self setLoop: 0 setCel: 0 setCycle: End lockPanel)
				)
			)
		)
	)
)

(instance whistleProp of PanelProp
	(properties)

	(method (init)
		(self view: 6476 setCel: 0 setLoop: 1)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance openDrawerProp of PanelProp
	(properties
		y 200
		view 5475
	)

	(method (init)
		(if (IsFlag 73)
			(= view 6475)
		else
			(= view 5475)
		)
		(self setCel: 6)
		(super init: &rest)
		(= local0 1)
		(approachX hotVerbs: 0)
	)

	(method (cue)
		(springDrawerPanel dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch local0
					(2
						(gMySoundFX number: 436 setLoop: 0 play:)
						(self setCycle: CT 6 -1)
						(moveStuff
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 100 77 92 88 99 106 122 111 142 98 135 79 111 71
									yourself:
								)
						)
						(= local0 1)
					)
					(3
						(gMySoundFX number: 437 setLoop: 0 play:)
						(self setCycle: CT 9 -1)
						(moveStuff
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 144 100 165 125 186 105 185 66 136 76
									yourself:
								)
						)
						(= local0 2)
					)
					(4
						(= local0 3)
						(self setCycle: CT 15 -1)
						(moveStuff
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 107 122 127 131 140 115 128 98 110 104
									yourself:
								)
						)
					)
				)
			)
		)
	)
)

(instance glassAlcoveProp of PanelProp
	(properties
		y 200
		view 5474
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 133 135 133 135 113 115 115
					yourself:
				)
		)
		(gGame handsOn:)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (cue)
		(if (== local2 1)
			(= local2 0)
			(glassAlcovePanel scratch: 1)
			(glassAlcovePanel dispose:)
		else
			(gGame handsOn:)
			(if (gFeatures contains: deviceFeat)
				(glassAlcovePanel dispose:)
			else
				(deviceFeat init: glassAlcovePanel 1 1)
			)
		)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (== loop 0)
					(if (== cel 0)
						(gMySoundFX number: 43508 setLoop: 0 play:)
						(self setCycle: End self)
					else
						(gMySoundFX number: 43508 setLoop: 0 play:)
						(self setCycle: Beg self)
					)
				)
			)
		)
	)
)

(instance fileDrawerBackground of PanelProp
	(properties
		y 200
	)

	(method (init)
		(self setLoop: 1 setPri: 5)
		(if (IsFlag 72)
			(self view: 6477)
		else
			(self view: 5477)
		)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance fileDrawerProp of PanelProp
	(properties
		y 200
	)

	(method (init)
		(if (IsFlag 72)
			(self view: 6477)
		else
			(self view: 5477)
		)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance scrollProp of PanelProp
	(properties
		y 200
		view 5485
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance throttleProp of PanelProp
	(properties
		view 5478
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 69)
			(self setCel: 1)
		else
			(self setCel: 0)
			(approachX hotVerbs: 5)
		)
	)
)

(instance grateProp of PanelProp
	(properties
		view 5479
		loop 3
	)
)

(instance shuffleStuff of PanelProp
	(properties
		view 5479
		loop 2
	)

	(method (cue)
		(gMySoundFX number: 436 setLoop: 0 play:)
		(if (== (self cel:) 10)
			(self setCycle: End)
		else
			(self setCycle: Beg)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(gMySoundFX number: 437 setLoop: 0 play:)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(self setCycle: CT 10 1 self)
				else
					(self setCycle: CT 11 -1 self)
				)
			)
		)
	)
)

(instance shuffleNails of PanelProp
	(properties
		view 5479
		loop 1
	)

	(method (init)
		(self setPri: (+ (secretPanel priority:) 1))
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
		(super cue: &rest)
	)

	(method (handleEvent)
		(if (IsFlag 88)
			(return 0)
		else
			(super handleEvent: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 88)
				(gGame handsOff:)
				(gMySoundFX number: 43514 setLoop: 0 play:)
				(self setCycle: End self)
			)
		)
	)
)

(instance secretPanel of PanelProp
	(properties
		view 5479
	)

	(method (init)
		(self setPri: (+ (shuffleStuff priority:) 10))
		(if (gInventory contains: (ScriptID 9 33)) ; invDeskKey
			(= cel (self lastCel:))
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((and (IsFlag 88) (== cel 0))
						(shuffleNails setCel: 0 setPri: 0)
						(gGame handsOff:)
						(gMySoundFX number: 43524 setLoop: 0 play:)
						(self setCycle: CT 5 1 self)
					)
					((and (!= cel 0) (not (gInventory contains: (ScriptID 9 33)))) ; invDeskKey
						(self setCel: 6)
						(gInventory addItem: (ScriptID 9 33)) ; invDeskKey
					)
				)
			)
		)
	)
)

(instance scrollOne of PanelProp
	(properties
		view 5466
	)

	(method (init)
		(super init: &rest)
		(scrollTwo hide:)
		(scrollThree hide:)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(self init: bigScrollPanel 1 1)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (self onMe: (event x:) (event y:)))
			(event claimed: 1)
			(super handleEvent: event &rest)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(scrollProp setCel: 0)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance scrollTwo of PanelProp
	(properties
		view 5467
	)

	(method (init)
		(super init: &rest)
		(scrollOne hide:)
		(scrollThree hide:)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(self init: bigScrollPanel 1 1)
	)

	(method (handleEvent event)
		(cond
			((and (& (event type:) evMOUSEBUTTON) (self onMe: (event x:) (event y:)))
				(event claimed: 1)
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: (event x:) (event y:)))
				)
				(event claimed: 1)
				(bigScrollPanel dispose:)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		(scrollProp setCel: 0)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance scrollThree of PanelProp
	(properties
		view 5468
	)

	(method (init)
		(super init: &rest)
		(scrollOne hide:)
		(scrollTwo hide:)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(self init: bigScrollPanel 1 1)
	)

	(method (handleEvent event)
		(cond
			((and (& (event type:) evMOUSEBUTTON) (self onMe: (event x:) (event y:)))
				(event claimed: 1)
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: (event x:) (event y:)))
				)
				(event claimed: 1)
				(bigScrollPanel dispose:)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		(scrollProp setCel: 0)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance windowGrate of Prop
	(properties
		x 264
		y 266
		view 5492
	)

	(method (init)
		(self setLoop: 0)
		(if (IsFlag 217)
			(self setCel: (self lastCel:))
			(windowLock init:)
			(windowFeature init:)
		else
			(self setCel: 0)
		)
		(self setPri: 888)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(if (== cel 0)
			(ClearFlag 217)
			(windowLock dispose:)
			(windowFeature dispose:)
		else
			(SetFlag 217)
			(windowLock init:)
			(windowFeature init:)
		)
		(gGame handsOn:)
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not local6)
					(cond
						((not (IsFlag 217))
							(gGame handsOff:)
							(gMySoundFX number: 438 setLoop: 0 play:)
							(self setCycle: End self)
						)
						((and (IsFlag 217) (not (IsFlag 87)))
							(gGame handsOff:)
							(gMySoundFX number: 439 setLoop: 0 play:)
							(self setCycle: Beg self)
						)
					)
				)
			)
		)
	)
)

(instance topLeftDrawer of Prop
	(properties
		x 115
		y 147
		view 5480
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(if (== (++ global114) 2)
						(SetFlag 395)
						(if (not (IsFlag 87))
							((ScriptID 0 10) setScript: birdManTakesLever) ; dummyProp
						)
					else
						(gCurRoom setScript: openTopLeftDrawer)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setPri: -1)
	)
)

(instance smallFileDrawer of Prop
	(properties
		x 114
		y 235
		view 5481
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(if (== (++ global114) 2)
						(SetFlag 395)
						(if (not (IsFlag 87))
							((ScriptID 0 10) setScript: birdManTakesLever) ; dummyProp
						)
					else
						(gCurRoom setScript: openFileDrawer)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setPri: -1)
	)
)

(instance smallScrollDoor of Prop
	(properties
		x 184
		y 58
		view 5487
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0 setPri: 600)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not cel)
					(gCurRoom setScript: openScrollDoor)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setPri: -1)
	)
)

(instance smallThrottleDrawer of Prop
	(properties
		x 184
		y 224
		view 5482
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 69)
			(self setCel: 0 setLoop: 1)
		else
			(self setCel: 0 setLoop: 0)
		)
		(self setPri: 600)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(if (and (>= (++ global114) 1) (not (IsFlag 395)))
						(= global114 3)
						(SetFlag 395)
						(if (not (IsFlag 87))
							((ScriptID 0 10) setScript: birdManTakesLever) ; dummyProp
						)
					else
						(gCurRoom setScript: openThrottleDrawer)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setPri: -1)
	)
)

(instance smallGrateDrawer of Prop
	(properties
		x 357
		y 225
		view 5483
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== cel 0)
					(if (== (++ global114) 2)
						(SetFlag 395)
						(if (not (IsFlag 87))
							((ScriptID 0 10) setScript: birdManTakesLever) ; dummyProp
						)
					else
						(gCurRoom setScript: openGrateDrawer)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setPri: -1)
	)
)

(instance trapDoor of Prop
	(properties
		x 152
		y 102
		view 5470
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)

	(method (cue)
		(gCurRoom newRoom: 500)
		(super cue: &rest)
	)
)

(instance autoLadder of Prop
	(properties
		x 158
		y 245
		view 5471
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 89)
			(self setCel: (self lastCel:))
		else
			(self setCel: 0)
		)
	)
)

(instance moveLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 89)
					(ladderSoundFX number: 43519 setLoop: 0 play:)
					(ClearFlag 89)
					((ScriptID 1 6) dispose:) ; exitUp
					((ScriptID 1 5) newPic: 496) ; exitDown
					(autoLadder setCycle: Beg self)
				else
					(ladderSoundFX number: 43518 setLoop: 0 play:)
					((ScriptID 1 6) newRoom: 500 exitCode: ExitToHanger) ; exitUp
					(SetFlag 89)
					((ScriptID 1 5) newPic: 498) ; exitDown
					(autoLadder setCycle: End self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deadHead of Prop
	(properties
		x 30
		y 223
		view 489
		loop 2
	)

	(method (init)
		(if (== (gCurRoom scene:) 491)
			(self view: 499 setLoop: 0 x: 21 y: 156)
		else
			(self view: 489 setLoop: 2 x: 30 y: 223)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 489)
					(gMySoundFX number: 43903 setLoop: 0 play:)
					(SetFlag 121)
					(self setCycle: End self)
				)
			)
		)
	)
)

(instance amulet of View
	(properties
		x 95
		y 295
		view 489
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX number: 43904 setLoop: 0 play:)
				(SetFlag 218)
				(gInventory addItem: (ScriptID 9 73)) ; invPuzzleAmulet
				(self dispose:)
			)
		)
	)
)

(instance cannonGone of View
	(properties
		x 100
		y 131
		view 499
		loop 1
	)
)

(instance sky of View
	(properties
		x 212
		y 295
		view 5499
	)
)

(instance windowShut of View
	(properties
		x 202
		y 48
		view 5460
	)
)

(instance diagramView of View
	(properties
		view 5496
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1000)
		(gMouseDownHandler add: self)
	)

	(method (handleEvent event)
		(cond
			((and (& (event type:) evMOUSEBUTTON) (self onMe: (event x:) (event y:)))
				(event claimed: 1)
				(super handleEvent: event &rest)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: (event x:) (event y:)))
				)
				(event claimed: 1)
				(self dispose:)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance deadGuyView of View
	(properties
		x 32
		y 130
		view 5498
	)

	(method (init)
		(if (IsFlag 121)
			(self setCel: 1)
		else
			(self setCel: 0)
		)
		(self setPri: 3000)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not local6)
					(gCurRoom changeScene: 489)
				)
			)
		)
	)
)

(instance ionizerFarView of View
	(properties
		x 322
		y 92
		priority 1
		view 5497
	)
)

(instance glassAlcoveView of View
	(properties
		x 256
		y 72
		view 5473
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 142 321 142 321 71 257 71
					yourself:
				)
		)
	)
)

(instance windowLock of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 190 234 190 233 226 198 226
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
		)
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
					init: 199 73 199 187 238 186 236 231 197 229 199 248 270 247 270 59 244 35 225 35 209 43
					yourself:
				)
		)
		(super init: &rest)
		(approachX hotVerbs: 5 42)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(windowGrate doVerb: 5)
			)
			(42 ; invDeskKey
				(lockPanel init:)
			)
		)
	)
)

(instance whistleDrawer of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 327 62 327 96 384 96 384 62
					yourself:
				)
		)
		(if (not (IsFlag 74))
			(approachX hotVerbs: 5 43)
		else
			(approachX hotVerbs: 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 74))
					(whistlePanel init:)
				)
			)
			(43 ; invBatKey
				(if (not (IsFlag 74))
					(whistlePanel init:)
				)
			)
		)
	)
)

(instance deskFeature of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(= arrowStyle 3)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 32 207 259 428 289 456 9
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom changeScene: 492)
			)
		)
	)
)

(instance deviceFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 153 146 155 142 92 111 93
					yourself:
				)
		)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 122)
				(gInventory addItem: (ScriptID 9 31)) ; invIonizer
				(glassAlcoveView dispose:)
				(glassAlcoveProp view: 6474 setCel: 0)
				(glassAlcovePanel dispose:)
			)
		)
	)
)

(instance fileDrawerForward of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 175 186 119 71 61 45 91 62 123
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (!= (fileDrawerProp cel:) 23)
					(gMySoundFX number: 43515 setLoop: 0 play:)
				)
				(switch (fileDrawerProp cel:)
					(0
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 5 1)
						(fileDrawerBackward
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 31 124 148 194 158 176 63 119
									yourself:
								)
						)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 161 165 185 119 72 62 55 85 68 118
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									init: 154 166 161 154 65 102 75 122
									yourself:
								)
						)
					)
					(5
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 11 1)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 167 158 185 120 73 63 58 77 72 109
									yourself:
								)
						)
						(fileDrawerBackward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 163 164 148 193 35 126 37 114 69 113
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 159 158 165 141 75 97 81 114
									yourself:
								)
						)
					)
					(11
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 17 1)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 167 154 187 119 73 63 61 72 80 105
									yourself:
								)
						)
						(fileDrawerBackward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 164 160 148 193 34 124 42 109 71 107
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 164 150 173 136 83 92 89 108
									yourself:
								)
						)
					)
					(17
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 23 1)
						(fileDrawerBackward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 170 151 148 195 33 127 47 101 76 100
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 146 128 150 112 78 80 85 94
									yourself:
								)
						)
					)
				)
			)
		)
	)
)

(instance fileDrawerBackward of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX number: 43515 setLoop: 0 play:)
				(switch (fileDrawerProp cel:)
					(5
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 0 -1)
						(fileDrawerForward
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 157 175 186 119 71 61 45 91 62 123
									yourself:
								)
						)
						(self dispose:)
					)
					(11
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 5 -1)
						(fileDrawerForward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 161 165 185 119 72 62 55 85 68 118
									yourself:
								)
						)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 31 124 148 194 158 176 63 119
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 154 160 161 154 65 102 75 122
									yourself:
								)
						)
					)
					(17
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 11 -1)
						(fileDrawerForward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 167 158 185 120 73 63 58 77 72 109
									yourself:
								)
						)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 163 164 148 193 35 126 37 114 69 113
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 159 153 165 141 75 97 81 114
									yourself:
								)
						)
					)
					(23
						(diagramView hide:)
						(fileDrawerProp setCycle: CT 17 -1)
						(fileDrawerForward
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 167 154 187 119 73 63 61 72 80 105
									yourself:
								)
						)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 164 160 148 193 34 124 42 109 71 107
									yourself:
								)
						)
						(diagram
							init: fileDrawerPanel 1 1
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 164 145 173 136 83 92 89 108
									yourself:
								)
						)
					)
				)
			)
		)
	)
)

(instance diagram of PanelFeature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (fileDrawerProp cel:)
					(5
						(diagramView setCel: 2 posn: 175 40 setPri: 600 init:)
					)
					(11
						(diagramView setCel: 1 posn: 175 40 setPri: 600 init:)
					)
					(17
						(diagramView setCel: 0 posn: 175 40 setPri: 600 init:)
					)
					(23
						(diagramView setCel: 3 posn: 175 40 setPri: 600 init:)
					)
				)
			)
		)
	)
)

(instance scrollOneFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 30 59 85 58 83 21 23 26 yourself:)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(or
						(!= (scrollProp view:) 5485)
						(!= (scrollProp cel:) (scrollProp lastCel:))
					)
					(gGame handsOff:)
					(gMySoundFX number: 43703 setLoop: 0 play:)
					(localproc_1)
					(scrollProp view: 5485)
					(scrollProp setCel: 0 setCycle: End scrollOne)
				)
			)
		)
	)
)

(instance scrollTwoFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 113 91 138 39 136 35 111
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(or
						(!= (scrollProp view:) 6485)
						(!= (scrollProp cel:) (scrollProp lastCel:))
					)
					(gGame handsOff:)
					(gMySoundFX number: 43703 setLoop: 0 play:)
					(localproc_1)
					(scrollProp view: 6485)
					(scrollProp setCel: 0 setCycle: End scrollTwo)
				)
			)
		)
	)
)

(instance scrollThreeFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 183 105 177 101 149 161 151
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(or
						(!= (scrollProp view:) 7485)
						(!= (scrollProp cel:) (scrollProp lastCel:))
					)
					(gGame handsOff:)
					(gMySoundFX number: 43703 setLoop: 0 play:)
					(localproc_1)
					(scrollProp view: 7485)
					(scrollProp setCel: 0 setCycle: End scrollThree)
				)
			)
		)
	)
)

(instance throttleFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 175 127 168 73 107 94 94 85 86 31 123 39 132 63 115
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(UpdateScreenItem (throttleProp setCel: 1 yourself:))
				(UpdateScreenItem (smallThrottleDrawer setLoop: 1 yourself:))
				(if (not (IsFlag 69))
					(gMySoundFX number: 43905 setLoop: 0 play:)
					(gInventory addItem: (ScriptID 9 32)) ; invThrottle
				)
				(SetFlag 69)
				(throttleProp dispose:)
				(throttleProp init: throttlePanel 1 1)
				(self dispose:)
			)
		)
	)
)

(instance lid of PanelFeature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 164 93 186 166 90 138 75
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(grateProp setCycle: End)
				(self dispose:)
				(keyFeature init: gratePanel 1 1)
			)
		)
	)
)

(instance keyFeature of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 167 137 129 120 120 89 153
					yourself:
				)
		)
		(approachX hotVerb: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory addItem: (ScriptID 9 33)) ; invDeskKey
			)
		)
	)
)

(instance batKey of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 134 126 124 97 114 94 119
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (== (fileDrawerProp cel:) 17) (not (IsFlag 72)))
					(SetFlag 72)
					(fileDrawerProp view: 6477)
					(gMySoundFX number: 43512 setLoop: 0 play:)
					(gInventory addItem: (ScriptID 9 34)) ; invBatKey
					(self dispose:)
				)
			)
		)
	)
)

(instance doNothing of PanelFeature
	(properties
		y 600
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 89 1 4 197 4 197 54 82 9 41 112 145 175 196 94 196 198 1 198
					yourself:
				)
		)
		(approachX hotVerbs: 0)
	)
)

(instance moveStuff of PanelFeature
	(properties
		y 600
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 76 74 105 99 130 133 139 161 104 146 79 107 63
					yourself:
				)
		)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch local0
					(1
						(gMySoundFX number: 436 setLoop: 0 play:)
						(openDrawerProp setCycle: CT 9 1)
						(= local0 2)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 144 100 165 125 186 105 185 66 136 76
									yourself:
								)
						)
					)
					(2
						(gMySoundFX number: 437 setLoop: 0 play:)
						(openDrawerProp setCycle: CT 15 1)
						(= local0 3)
						(self
							setPolygon:
								((Polygon new:)
									type: PTotalAccess
									init: 107 122 127 131 140 115 128 98 110 104
									yourself:
								)
						)
					)
					(3
						(openDrawerProp setCycle: CT 18 1)
						(if (not (IsFlag 73))
							(= local0 4)
							(self
								setPolygon:
									((Polygon new:)
										type: PTotalAccess
										init: 131 142 151 143 143 77 124 76
										yourself:
									)
							)
						)
					)
					(4
						(if (not (IsFlag 73))
							(gMySoundFX number: 156 setLoop: 0 play:)
							(gInventory addItem: (ScriptID 9 23)) ; invSpring
							(openDrawerProp view: 6475)
							(SetFlag 73)
						)
					)
				)
			)
		)
	)
)

(instance whistleFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 85 133 122 131 153 113 115 96 74 97 50 117
					yourself:
				)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 74))
					(SetFlag 74)
					(gMySoundFX number: 43517 setLoop: 0 play:)
					(gInventory addItem: (ScriptID 9 35)) ; invWhistle
					(whistleProp view: 6476)
					((whistleDrawer approachX:) hotVerbs: 0)
				)
			)
		)
	)
)

(instance whistleKeyFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 106 99 106 159 165 159 164 101
					yourself:
				)
		)
		(approachX hotVerbs: 43)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (cue)
		(whistleFeat init: whistlePanel 1 1)
		(self dispose:)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; invBatKey
				(gGame handsOff:)
				(gMySoundFX number: 43516 setLoop: 0 play:)
				(whistleProp view: 5476 setLoop: 0 setCycle: End self)
			)
		)
	)
)

(class Vase of View
	(properties
		holder 0
		where 0
	)

	(method (init)
		(switch where
			(5
				(switch (gCurRoom scene:)
					(492
						(self posn: 349 59)
						(= holder topVasePos)
						(holder vaseHeld: self)
					)
					(491
						(self posn: 127 129)
					)
					(493
						(self posn: 385 75)
					)
					(494
						(self posn: 24 135)
					)
				)
			)
			(6
				(switch (gCurRoom scene:)
					(492
						(self posn: 133 110)
						(= holder secondLevelLeft)
						(holder vaseHeld: self)
					)
					(491
						(self posn: 31 151)
					)
					(493
						(self posn: 239 113)
					)
					(494
						(self posn: -29 -201)
					)
				)
			)
			(7
				(switch (gCurRoom scene:)
					(492
						(self posn: 161 110)
						(= holder secondLevelRight)
						(holder vaseHeld: self)
					)
					(491
						(self posn: 50 150)
					)
					(493
						(self posn: 256 113)
					)
					(494
						(self posn: -29 -201)
					)
				)
			)
			(8
				(switch (gCurRoom scene:)
					(492
						(self posn: 332 142)
						(= holder thirdLevelLeft)
						(holder vaseHeld: self)
					)
					(491
						(self posn: 123 166)
					)
					(493
						(self posn: 372 135)
					)
					(494
						(self posn: 8 204)
					)
				)
			)
			(9
				(switch (gCurRoom scene:)
					(492
						(self posn: 355 142)
						(= holder thirdLevelRight)
						(holder vaseHeld: self)
					)
					(491
						(self posn: 134 165)
					)
					(493
						(self posn: 392 135)
					)
					(494
						(self posn: 31 201)
					)
				)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 492)
					(if holder
						(holder vaseHeld: 0)
					)
					(= local1 self)
					(vaseCursor loop: loop cel: cel)
					(gUser curVerb: 39)
					(gGame setCursor: vaseCursor 1)
					(gGame normalizeCode: normCursorCode)
					(self hide:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vaseWithHandles of Vase
	(properties
		view 5489
	)

	(method (init)
		(= global112 where)
		(switch (gCurRoom scene:)
			(492
				(= view 5489)
				(self setCel: 0)
				(self setLoop: 0)
			)
			(491
				(= view 1491)
				(self setCel: 0)
				(self setLoop: 0)
			)
			(494
				(= view 494)
				(self setCel: 0)
				(self setLoop: 2)
			)
			(493
				(= view 7475)
				(self setCel: 0)
				(self setLoop: 0)
			)
		)
		(super init: &rest)
	)
)

(instance skinnyVase of Vase
	(properties
		view 5489
		cel 1
	)

	(method (init)
		(= global113 where)
		(switch (gCurRoom scene:)
			(492
				(= view 5489)
				(self setCel: 1)
				(self setLoop: 0)
			)
			(491
				(= view 1491)
				(self setCel: 0)
				(self setLoop: 1)
			)
			(494
				(= view 494)
				(self setCel: 0)
				(self setLoop: 0)
			)
			(493
				(= view 7475)
				(self setCel: 1)
				(self setLoop: 0)
			)
		)
		(super init: &rest)
	)
)

(instance brassVase of Vase
	(properties
		view 5489
		cel 2
	)

	(method (init)
		(= global111 where)
		(switch (gCurRoom scene:)
			(492
				(= view 5489)
				(self setCel: 2)
				(self setLoop: 0)
			)
			(491
				(= view 1491)
				(self setCel: 0)
				(self setLoop: 2)
			)
			(494
				(= view 494)
				(self setCel: 0)
				(self setLoop: 1)
			)
			(493
				(= view 7475)
				(self setCel: 2)
				(self setLoop: 0)
			)
		)
		(super init: &rest)
	)
)

(class VaseSlot of Feature
	(properties
		vaseHeld 0
		position 0
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(== (event message:) JOY_DOWN)
					(or (== (self position:) 8) (== (self position:) 9))
					(not (thirdLevelLeft vaseHeld:))
					(not (thirdLevelRight vaseHeld:))
				)
				(super handleEvent: event &rest)
			)
			((== (event message:) JOY_DOWN)
				(return 0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 122)
			(approachX hotVerbs: 0)
		else
			(approachX hotVerbs: 5 39)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(or (== position 8) (== position 9))
						(not (thirdLevelLeft vaseHeld:))
						(not (thirdLevelRight vaseHeld:))
						(not (IsFlag 122))
					)
					(glassAlcovePanel init:)
				)
			)
			(39 ; ???
				(if (not vaseHeld)
					(= vaseHeld local1)
					(= local1 0)
					(gGame normalizeCode: -1)
					(gGame normalizeCursor:)
					(vaseHeld where: position init: show: holder: self)
				)
			)
		)
	)
)

(instance topVasePos of VaseSlot
	(properties
		position 5
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 333 57 376 57 376 16 333 16
					yourself:
				)
		)
	)
)

(instance secondLevelRight of VaseSlot
	(properties
		position 7
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 154 127 183 127 183 64 154 64
					yourself:
				)
		)
	)
)

(instance secondLevelLeft of VaseSlot
	(properties
		position 6
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 127 152 127 152 64 115 64
					yourself:
				)
		)
	)
)

(instance thirdLevelLeft of VaseSlot
	(properties
		position 8
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 315 155 352 155 352 96 315 96
					yourself:
				)
		)
	)
)

(instance thirdLevelRight of VaseSlot
	(properties
		position 9
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 353 155 377 155 377 96 353 96
					yourself:
				)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMySoundFX number: 44800 setLoop: 0 play:)
				(doorBot caller: self start: 1 15)
			)
			(1
				(door dispose:)
				((ScriptID 1 1) newRoom: 447) ; exitForward
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 253
		y 177
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 84 210 298 296 298 296 83 278 56 226 56
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: openDoor)
			)
		)
	)
)

(instance doorBot of RobotPlayer
	(properties)
)

(instance birdManBot of RobotPlayer
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 494)
			(super init: 157 curFrame 76 73 300)
		else
			(super init: 157 curFrame -300 -300)
		)
		(self caller: birdManTakesLever cycleTo: (birdManBot maxFrame:) 1 15)
	)
)

(instance ExitToHanger of Code
	(properties)

	(method (doit)
		(gMySoundFX number: 43520 setLoop: 0 play:)
		(trapDoor setCycle: End trapDoor)
	)
)

(instance closeDoor493 of Code
	(properties)

	(method (doit)
		(if (!= (doorBot curFrame:) 0)
			(doorBot caller: self start: -1 15)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 493)
	)
)

(instance closeDoor494 of Code
	(properties)

	(method (doit)
		(if (!= (doorBot curFrame:) 0)
			(doorBot caller: self start: -1 15)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 494)
	)
)

(instance closeDoor498 of Code
	(properties)

	(method (doit)
		(if (!= (doorBot curFrame:) 0)
			(doorBot caller: self start: -1 15)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 498)
	)
)

(instance closeDoor496 of Code
	(properties)

	(method (doit)
		(if (!= (doorBot curFrame:) 0)
			(doorBot caller: self start: -1 15)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 496)
	)
)

(instance noCode of Code
	(properties)

	(method (doit))
)

(instance ladderSoundFX of Sound
	(properties)
)

(instance clickSounds of Sound
	(properties)
)

(instance vaseCursor of Cursor
	(properties
		view 5489
	)
)

(instance normCursorCode of Code
	(properties)

	(method (doit))
)

