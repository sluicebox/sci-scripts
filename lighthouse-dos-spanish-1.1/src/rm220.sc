;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use LightRoom)
(use VMDPlayer)
(use ROsc)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	local0
	local1
	local2
	local3 = 1
)

(instance rm220 of LightRoom
	(properties
		picture 230
	)

	(method (init)
		(SetFlag 109)
		(if (== (gBackMusic number:) 2011)
			(gBackMusic setVol: 127)
		)
		(if (and (OneOf global226 3 2 1) (not (IsFlag 204)))
			(windowView230 init:)
		)
		(gMySoundFX setVol: 50)
		(SetFlag 186)
		(gGame handsOn:)
		(super init: &rest)
		(cond
			((and (IsFlag 383) (== global226 4))
				(self changeScene: 225)
			)
			((IsFlag 383)
				(ClearFlag 345)
				(self changeScene: 225 setScript: subPowerDown)
			)
			(else
				((ScriptID 1 1) newPic: 225) ; exitForward
				((ScriptID 1 2) newPic: 227) ; exitBack
				((ScriptID 1 4) newPic: 229) ; exitRight
				((ScriptID 1 3) newPic: 228) ; exitLeft
				(if (and (IsFlag 108) (IsFlag 105))
					(rightLights init:)
					(leftLights230 init:)
					(ballastLight230 init: setCycle: Fwd)
				)
			)
		)
	)

	(method (dispose)
		(gGlobalVMD holdLastFrame: 0 myBlackLines: 0)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		(if (gCast contains: controlDoorCrank)
			(controlDoorCrank dispose:)
		)
		(if (gCast contains: ballastLight230)
			(ballastLight230 dispose:)
			(leftLights230 dispose:)
			(rightLights dispose:)
		)
		(if (gCast contains: lever230)
			(lever230 dispose:)
		)
		(if (gCast contains: subControl8)
			(subControl8 dispose:)
		)
		(gFeatures eachElementDo: #dispose)
		(super changeScene: param1 &rest)
		(switch param1
			(225
				(Load rsAUDIO 2001 2010 2011 2004 2016 2023 2024)
				(if (gCast contains: windowView230)
					(windowView230 dispose:)
				)
				(if (not (subControlCast2 isEmpty:))
					(subControlCast2 dispose:)
				)
				(subControlCast
					add:
						subControl1
						subControl2
						subControl3
						subControl4
						subControl5
						subControl6
						subPowerLight
						powerIndicator
					eachElementDo: #init
				)
				(if (and (OneOf global226 3 2 1) (not (IsFlag 204)))
					(subControlCast add: (windowView init: yourself:))
				else
					(proc0_9 2226)
				)
				(if (not (IsFlag 111))
					(throttleSpot init:)
				else
					(subControl7
						loop: 13
						cel:
							(if global226
								0
							else
								(subControl7 lastCel:)
							)
						init:
					)
					(if global226
						(throttleUp init:)
					)
				)
				(if (IsFlag 105)
					(subGuages
						loop: 7
						x: 243
						y: 136
						cycleSpeed: 8
						init:
						setCycle: Fwd
					)
					(subControl8 init:)
					(spinningDial init:)
					(subPowerLight setCycle: Fwd)
				)
				((ScriptID 1 7) newPic: 230) ; exitBackUp
			)
			(230
				(if (and (OneOf global226 3 2 1) (not (IsFlag 204)))
					(windowView230 init:)
				)
				(if (not (subControlCast2 isEmpty:))
					(subControlCast2 dispose:)
				)
				(if (not (subControlCast isEmpty:))
					(subControlCast dispose:)
					(if (gCast contains: subGuages)
						(subGuages dispose:)
					)
					(if (IsFlag 111)
						(subControl7 dispose:)
						(throttleUp dispose:)
					else
						(throttleSpot dispose:)
					)
				)
				(if (IsFlag 111)
					(lever230 init:)
				)
				(if (and (IsFlag 108) (IsFlag 105))
					(rightLights init:)
					(leftLights230 init:)
					(ballastLight230 init: setCycle: Fwd)
				)
				(disposeBallastPuzzle doit:)
				(spinningDial dispose:)
				(controlRoomDoor dispose:)
				((ScriptID 1 1) newPic: 225) ; exitForward
				((ScriptID 1 2) newPic: 227) ; exitBack
				((ScriptID 1 4) newPic: 229) ; exitRight
				((ScriptID 1 3) newPic: 228 nsRight: 100) ; exitLeft
			)
			(226
				(if (gCast contains: windowView230)
					(windowView230 dispose:)
				)
				(subControlCast2
					add:
						subControl9
						subControl10
						subControl11
						subControl12
						subControl13
						subControl14
						subControl16
						subControl17
					eachElementDo: #init
				)
				(if (IsFlag 111)
					(subControlCast2 add: subControl15)
					(subControl15 init:)
				)
				((ScriptID 1 1) newPic: 225) ; exitForward
				((ScriptID 1 2) newPic: 227) ; exitBack
			)
			(227
				(if (gCast contains: windowView230)
					(windowView230 dispose:)
				)
				(controlRoomDoor init:)
				(controlDoorCrank init:)
				(disposeBallastPuzzle doit:)
				((ScriptID 1 2) newPic: 230) ; exitBack
				((ScriptID 1 4) newPic: 228) ; exitRight
				((ScriptID 1 3) newPic: 229) ; exitLeft
				(if local3
					((ScriptID 1 1) newRoom: 225) ; exitForward
				)
			)
			(228
				(if (gCast contains: windowView230)
					(windowView230 dispose:)
				)
				(controlRoomDoor dispose:)
				(initBallastPuzzle doit:)
				((ScriptID 1 2) newPic: 229) ; exitBack
				((ScriptID 1 3) newPic: 227) ; exitLeft
				((ScriptID 1 4) newPic: 230) ; exitRight
			)
			(229
				(if (gCast contains: windowView230)
					(windowView230 dispose:)
				)
				(controlRoomDoor dispose:)
				(disposeBallastPuzzle doit:)
				((ScriptID 1 2) newPic: 228) ; exitBack
				((ScriptID 1 4) newPic: 227) ; exitRight
				((ScriptID 1 3) newPic: 230) ; exitLeft
			)
		)
	)
)

(instance alarmSound of Sound
	(properties
		number 2015
		flags 1
		loop -1
	)
)

(instance leverSound1 of Sound
	(properties
		number 2012
		flags 1
	)
)

(instance leverSound2 of Sound
	(properties
		number 2012
		flags 1
	)
)

(instance valveSound1 of Sound
	(properties
		number 2013
		flags 1
	)
)

(instance valveSound2 of Sound
	(properties
		number 2013
		flags 1
	)
)

(instance pumpSound1 of Sound
	(properties
		number 2014
		flags 1
	)
)

(instance pumpSound2 of Sound
	(properties
		number 2014
		flags 1
	)
)

(instance roomSound of Sound ; UNUSED
	(properties
		number 455
		flags 1
		loop -1
	)
)

(instance tryThrottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(subControl7 setCycle: CT 4 1 self)
			)
			(1
				(subControl7 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance resetBallast of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(alarmSound play:)
				(warningLight setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(warningLight setCycle: End self)
			)
			(2
				(alarmSound stop:)
				(= temp0 1)
				(puzzleCast eachElementDo: #setCycle Beg)
				(if (not (guageCast1 isEmpty:))
					(= temp0 0)
					(guageCast1
						eachElementDo: #cycleSpeed 6
						eachElementDo: #setCycle Beg
					)
				)
				(if (not (guageCast2 isEmpty:))
					(= temp0 0)
					(guageCast2
						eachElementDo: #cycleSpeed 6
						eachElementDo: #setCycle Beg
					)
				)
				(if temp0
					(= cycles 10)
				else
					(= ticks 300)
				)
			)
			(3
				(valveSound1 stop:)
				(valveSound2 stop:)
				(pumpSound1 stop:)
				(pumpSound2 stop:)
				(ClearFlag 298)
				(ClearFlag 299)
				(= local0 0)
				(if (not (guageCast1 isEmpty:))
					(guageCast1 dispose:)
				)
				(if (not (guageCast2 isEmpty:))
					(guageCast2 dispose:)
				)
				(if (IsFlag 204)
					(ClearFlag 204)
					(Sounds eachElementDo: #pause)
					(gGlobalVMD
						number: 4488
						myBlackLines: 1
						stretch: 1
						init:
						play:
						close:
					)
					(Sounds eachElementDo: #pause 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance onLever1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 298)
				(guageCast1 add: guage1 bigGuage1 leftTubes)
				(guageCast1 eachElementDo: #init)
				(tankDiagram setCycle: ROsc 5 2 3 self)
			)
			(1
				(tankDiagram setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance onLever2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 299)
				(guageCast2 add: guage2 bigGuage2 rightTubes)
				(guageCast2 eachElementDo: #init)
				(tankDiagram setCycle: ROsc 5 0 1 self)
			)
			(1
				(tankDiagram setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startGuage1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pumpSound1 play:)
				(guageCast1
					eachElementDo: #cycleSpeed 14
					eachElementDo: #setCycle End
				)
				(= ticks 120)
			)
			(1
				(gCurRoom setScript: resetBallast)
			)
		)
	)
)

(instance crankUpGuage1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pumpSound1 play:)
				(guageCast1 eachElementDo: #cycleSpeed 14)
				(guageCast1 eachElementDo: #setCycle End self)
			)
			(1)
			(2)
			(3
				(if (not local1)
					(gCurRoom setScript: resetBallast)
				)
				(self dispose:)
			)
		)
	)
)

(instance blowBallast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(guageCast2
					eachElementDo: #cycleSpeed 16
					eachElementDo: #setCycle End self
				)
			)
			(1)
			(2)
			(3
				(Sounds eachElementDo: #pause)
				(SetFlag 204)
				(gGlobalVMD
					number: 4486
					myBlackLines: 1
					stretch: 1
					init:
					play:
					close:
				)
				(Sounds eachElementDo: #pause 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance subPowerUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gBackMusic stop:)
				(subGuages
					loop: 0
					cel: 0
					x: 243
					y: 133
					cycleSpeed: 8
					init:
					setCycle: End self
				)
				(subControl8 init: setCycle: End)
				(subPowerMonitor doit: 3 self)
			)
			(1)
			(2
				(subPowerMonitor doit: 3 self)
			)
			(3
				(subPowerLight setCycle: Fwd)
				(spinningDial init:)
				(subGuages loop: 7 x: 243 y: 136 setCycle: Fwd)
				(if (IsFlag 106)
					(subPowerMonitor doit: 3 self)
				else
					(self cue:)
				)
			)
			(4
				(if (IsFlag 107)
					(subPowerMonitor doit: 3 self)
				else
					(self cue:)
				)
			)
			(5
				(if (IsFlag 108)
					(subPowerMonitor doit: 3 self)
				else
					(self cue:)
				)
			)
			(6
				(SetFlag 105)
				(if (and (not (IsFlag 348)) (not (IsFlag 110)))
					(SetFlag 110)
				)
				(if (and (IsFlag 348) (IsFlag 110))
					(ClearFlag 110)
				)
				(if (and (not (IsFlag 347)) (not (IsFlag 109)))
					(SetFlag 109)
				)
				(if (and (IsFlag 347) (IsFlag 109))
					(gCurRoom setScript: closeControlDoor)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance subPowerDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 383)
				(ClearFlag 384)
				(subPowerLight setCycle: 0)
				(controlSound4 stop:)
				(controlSound4p5 stop:)
				(powerDownSound play: self)
				(spinningDial dispose:)
				(subControl8 dispose:)
				(subGuages setLoop: 0 x: 243 y: 133 setCel: setCycle: Beg self)
				(if
					(and
						(!= (subControl7 cel:) 0)
						(gCast contains: subControl7)
					)
					(subControl7 setCycle: Beg)
					(throttleUp init:)
				)
			)
			(1)
			(2
				(gBackMusic number: 455 loop: -1 play:)
				(subGuages dispose:)
				(ClearFlag 105)
				(= local2 0)
				(powerIndicator setCel: 0)
				(subControl4 setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance powerDownSound of Sound
	(properties
		number 2016
		flags 1
	)
)

(instance insertThrottle2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(subControl15 init: setCycle: End self)
			)
			(1
				(SetFlag 111)
				(throttleSpot2 dispose:)
				(gInventory deleteItem: (ScriptID 9 32)) ; invThrottle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance insertThrottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 45501 45502)
				(subControl7 x: 431 y: 298 init: setCycle: End self)
				(insertThrottleSound play:)
			)
			(1
				(SetFlag 111)
				(throttleSpot dispose:)
				(throttleUp init:)
				(subControl7 x: 397 y: 299 loop: 13 cel: 0)
				(gInventory deleteItem: (ScriptID 9 32)) ; invThrottle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crankUpThrottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 2031)
				(if (!= global226 2)
					(SetFlag 204)
				)
				(gGame handsOff:)
				(gMySoundFX number: 2031 setLoop: 1 play: self)
				(subControl7 setCycle: CT 4 1 self)
			)
			(1)
			(2
				(if (and (IsFlag 130) (IsFlag 229) (IsFlag 204))
					(gCurRoom setScript: launchSub)
				else
					(subControl7 setCycle: Beg self)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance launchSub of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gCast contains: windowView)
					(subControlCast delete: windowView)
					(windowView dispose:)
					(proc0_9 2226)
				)
				(ClearFlag 108)
				(subControl1 cel: 0)
				(Sounds eachElementDo: #pause)
				(gGame setCursor: gTheInvisCursor 1)
				(if (== global226 2)
					(gGlobalVMD
						number: 4487
						myBlackLines: 1
						stretch: 1
						holdLastFrame: 1
						init:
						play: self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (!= global227 global226)
					(gGlobalVMD
						number: 4489
						stretch: 1
						holdLastFrame: 1
						init:
						play: self
					)
				else
					(gGlobalVMD close:)
					(= global226 0)
					(self cue:)
				)
			)
			(2
				(= temp0 0)
				(switch global227
					(4
						(= temp0 1)
						(gGlobalVMD
							number: 235
							stretch: 1
							holdLastFrame: 0
							init:
							play:
						)
						(SetFlag 204)
					)
					(2
						(= temp0 1)
						(gGlobalVMD
							number: 4429
							stretch: 1
							holdLastFrame: 0
							boostRGB: -40
							init:
							play:
						)
						(SetFlag 204)
					)
					(1
						(= temp0 1)
						(if (IsFlag 427)
							(gGlobalVMD
								number: 801
								stretch: 0
								doubled: 1
								holdLastFrame: 0
								init:
								play:
								stretch: 0
							)
						else
							(gGlobalVMD
								number: 800
								stretch: 0
								doubled: 1
								holdLastFrame: 0
								init:
								play:
								stretch: 0
							)
							(SetFlag 427)
						)
						(ClearFlag 204)
					)
					(3
						(= temp0 1)
						(gGlobalVMD
							number: 600
							stretch: 1
							holdLastFrame: 0
							init:
							play:
						)
						(ClearFlag 204)
					)
				)
				(Sounds eachElementDo: #pause 0)
				(= global226 global227)
				(if (and (OneOf global226 3 2 1) (not (IsFlag 204)))
					(DoRobot)
					(subControlCast add: (windowView init: yourself:))
				else
					(proc0_9 2226)
				)
				(gGlobalVMD close:)
				(gGlobalVMD doubled: 0)
				(gGame normalizeCursor:)
				(spinningDial init:)
				(if temp0
					(ClearFlag 106)
					(subControl7 setScript: soundDown setCycle: Beg)
					(ClearFlag 229)
					(ClearFlag 345)
					(ClearFlag 108)
					(gCurRoom setScript: subPowerDown)
				else
					(SetFlag 384)
					(throttleUp dispose:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance soundDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMySoundFX number: 2033 setLoop: 1 play: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance crankDownThrottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(subControl7 setCycle: Beg self)
			)
			(1
				(gMySoundFX number: 2030 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openControlDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(controlSound5 play: self)
			)
			(1
				(SetFlag 109)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeControlDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(controlSound5p3 play: self)
				else
					(self cue:)
				)
			)
			(1
				(= local3 0)
				(ClearFlag 109)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crankUpGuage2 of Code
	(properties)

	(method (doit)
		(pumpSound2 play:)
		(guageCast2 eachElementDo: #cycleSpeed 16)
		(guageCast2 eachElementDo: #setCycle End)
	)
)

(instance initBallastPuzzle of Code
	(properties)

	(method (doit)
		(Load rsAUDIO 2012 2013 2014 2015)
		(puzzleCast add: valve1 valve2 lever1 lever2 warningLight tankDiagram)
		(puzzleCast eachElementDo: #init)
		(if (!= global226 2)
			(ClearFlag 108)
		)
		(if (and (IsFlag 105) (IsFlag 108))
			(powerLight init: setCycle: Fwd)
		)
		(if (and (IsFlag 298) (IsFlag 105))
			(guageCast1 add: guage1 bigGuage1 leftTubes)
			(guageCast1 eachElementDo: #init)
		)
		(if (and (IsFlag 299) (IsFlag 105))
			(guageCast2 add: guage2 bigGuage2 rightTubes eachElementDo: #init)
		)
		(if (IsFlag 204)
			(leftTubes init:)
			(rightTubes init:)
		)
	)
)

(instance disposeBallastPuzzle of Code
	(properties)

	(method (doit)
		(if (not (puzzleCast isEmpty:))
			(puzzleCast dispose:)
			(powerLight dispose:)
		)
		(if (not (guageCast1 isEmpty:))
			(guageCast1 dispose:)
		)
		(if (not (guageCast2 isEmpty:))
			(guageCast2 dispose:)
		)
		(if (gCast contains: leftTubes)
			(leftTubes dispose:)
		)
		(if (gCast contains: rightTubes)
			(rightTubes dispose:)
		)
	)
)

(instance puzzleCast of Set
	(properties)
)

(instance guageCast1 of Set
	(properties)
)

(instance guageCast2 of Set
	(properties)
)

(instance windowView230 of View
	(properties
		x 85
		y 17
		view 230
	)

	(method (init)
		(if (== global226 3)
			(= loop 4)
		else
			(= loop 0)
		)
		(super init: &rest)
	)
)

(instance windowView of View
	(properties
		view 225
	)

	(method (init)
		(if (== global226 3)
			(= loop 2)
		else
			(= loop 0)
		)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance leftTubes of Prop
	(properties
		x 146
		y 257
		loop 1
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance rightTubes of Prop
	(properties
		x 218
		y 257
		loop 4
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance valve1 of Prop
	(properties
		x 134
		y 124
		loop 3
		view 2227
	)

	(method (cue)
		(cond
			((not (and (IsFlag 108) (IsFlag 105)))
				(gGame handsOn:)
			)
			((and (not local0) (IsFlag 298) (IsFlag 299))
				(++ local0)
				(self setScript: crankUpGuage1)
				(gGame handsOn:)
			)
			((IsFlag 298)
				(self setScript: startGuage1)
			)
			(else
				(gCurRoom setScript: resetBallast)
			)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(valveSound1 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance valve2 of Prop
	(properties
		x 203
		y 125
		loop 6
		view 2227
	)

	(method (cue)
		(cond
			((not (and (IsFlag 108) (IsFlag 105)))
				(gGame handsOn:)
			)
			((and (== local0 1) (IsFlag 299) local1)
				(gCurRoom setScript: blowBallast)
			)
			((IsFlag 299)
				(crankUpGuage2 doit:)
				(gCurRoom setScript: resetBallast)
			)
			(else
				(gCurRoom setScript: resetBallast)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(valveSound2 play:)
			(if (== cel 0)
				(if (and (< (leftTubes cel:) 18) (> (leftTubes cel:) 9))
					(= local1 1)
				)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance lever1 of Prop
	(properties
		x 178
		y 124
		loop 2
		view 2227
	)

	(method (cue)
		(cond
			((not (and (IsFlag 108) (IsFlag 105)))
				(gGame handsOn:)
			)
			((not (IsFlag 298))
				(gCurRoom setScript: onLever1)
			)
			((IsFlag 204)
				(gCurRoom setScript: resetBallast)
			)
			((and (IsFlag 298) (not local0))
				(ClearFlag 298)
				(guageCast1 dispose:)
				(gGame handsOn:)
			)
			(else
				(gCurRoom setScript: resetBallast)
			)
		)
		(super cue:)
	)

	(method (init)
		(if (not (IsFlag 298))
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(leverSound1 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance lever2 of Prop
	(properties
		x 245
		y 124
		loop 5
		view 2227
	)

	(method (cue)
		(cond
			((not (and (IsFlag 108) (IsFlag 105)))
				(gGame handsOn:)
			)
			((not (IsFlag 299))
				(gCurRoom setScript: onLever2)
			)
			((IsFlag 204)
				(gCurRoom setScript: resetBallast)
			)
			((and (not local0) (IsFlag 299))
				(ClearFlag 299)
				(guageCast2 dispose:)
				(gGame handsOn:)
			)
			(else
				(gCurRoom setScript: resetBallast)
			)
		)
	)

	(method (init)
		(if (not (IsFlag 299))
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(leverSound2 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance guage1 of Prop
	(properties
		x 140
		y 74
		loop 8
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance guage2 of Prop
	(properties
		x 212
		y 74
		loop 9
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance bigGuage1 of Prop
	(properties
		x 351
		y 97
		loop 10
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance bigGuage2 of Prop
	(properties
		x 344
		y 176
		loop 11
		view 2227
	)

	(method (init)
		(if (IsFlag 204)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance tankDiagram of Prop
	(properties
		x 296
		y 230
		loop 12
		view 2227
	)
)

(instance powerLight of Prop
	(properties
		x 301
		y 100
		loop 13
		cel 3
		view 2227
	)
)

(instance warningLight of Prop
	(properties
		x 302
		y 46
		loop 7
		view 2227
	)
)

(instance subPowerMonitor of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 1)
		(if (> (+= local2 param1) 12)
			(= temp0 0)
			(gCurRoom setScript: subPowerDown)
		else
			(if (== param1 3)
				(powerIndicator setCel: (+ (powerIndicator cel:) 1))
			else
				(powerIndicator setCel: (- (powerIndicator cel:) 1))
			)
			(if (< argc 2)
				(gGame handsOn:)
			)
		)
		(if (and (> argc 1) temp0)
			(param2 cue:)
		)
	)
)

(instance subControlCast of Set
	(properties)
)

(instance subControlCast2 of Set
	(properties)
)

(instance subControl1 of Prop
	(properties
		x 40
		y 218
		loop 8
		view 2225
	)

	(method (init)
		(if (IsFlag 108)
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(cond
			((IsFlag 108)
				(gGame handsOn:)
				(if (IsFlag 105)
					(subPowerMonitor doit: -3)
				)
				(ClearFlag 108)
			)
			((not (IsFlag 108))
				(if (IsFlag 105)
					(subPowerMonitor doit: 3)
				else
					(gGame handsOn:)
				)
				(SetFlag 108)
			)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (== global226 2)) ; Do
			(gGame handsOff:)
			(controlSound1 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance insertThrottleSound of Sound
	(properties
		number 45501
		flags 1
	)
)

(instance throttleClank of Sound ; UNUSED
	(properties
		number 45502
		flags 1
	)
)

(instance controlSound1 of Sound
	(properties
		number 2001
		flags 1
	)
)

(instance subControl2 of Prop
	(properties
		x 52
		y 182
		loop 2
		view 2225
	)

	(method (init)
		(if (IsFlag 106)
			(= cel 2)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(if (IsFlag 106)
			(if (IsFlag 105)
				(subPowerMonitor doit: -3)
			)
			(ClearFlag 106)
			(gGame handsOn:)
		else
			(if (IsFlag 105)
				(subPowerMonitor doit: 3)
			else
				(gGame handsOn:)
			)
			(SetFlag 106)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(controlSound2 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance controlSound2 of Sound
	(properties
		number 2002
		flags 1
	)
)

(instance subControl3 of Prop
	(properties
		x 84
		y 155
		loop 1
		view 2225
	)

	(method (init)
		(if (IsFlag 107)
			(= cel 2)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(if (IsFlag 107)
			(if (IsFlag 105)
				(subPowerMonitor doit: -3)
			)
			(ClearFlag 107)
			(gGame handsOn:)
		else
			(if (IsFlag 105)
				(subPowerMonitor doit: 3)
			else
				(gGame handsOn:)
			)
			(SetFlag 107)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(controlSound3 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance controlSound3 of Sound
	(properties
		number 2001
		flags 1
	)
)

(instance subControl4 of Prop
	(properties
		x 164
		y 232
		loop 3
		view 2225
	)

	(method (cue)
		(if (IsFlag 105)
			(gCurRoom setScript: subPowerDown)
		else
			(gCurRoom setScript: subPowerUp)
		)
	)

	(method (init)
		(if (IsFlag 105)
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gBackMusic stop:)
			(controlSound4 play: soundCue)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		)
	)
)

(instance soundCue of CueObj
	(properties)

	(method (cue)
		(if (!= (gCurRoom script:) subPowerDown)
			(gBackMusic number: 2011 setLoop: -1 play:)
		)
	)
)

(instance controlSound4 of Sound
	(properties
		number 2010
		flags 1
	)
)

(instance controlSound4p5 of Sound
	(properties
		number 2011
		flags 1
		loop -1
	)
)

(instance subControl5 of Prop
	(properties
		x 424
		y 184
		loop 6
		view 2225
	)

	(method (cue)
		(if (IsFlag 347)
			(ClearFlag 347)
			(if (IsFlag 105)
				(gCurRoom setScript: openControlDoor)
			else
				(gGame handsOn:)
			)
		else
			(SetFlag 347)
			(if (IsFlag 105)
				(gCurRoom setScript: closeControlDoor)
			else
				(gGame handsOn:)
			)
		)
	)

	(method (init)
		(if (IsFlag 347)
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(controlSound5 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance controlSound5 of Sound
	(properties
		number 2004
		flags 1
	)
)

(instance controlSound5p2 of Sound
	(properties
		number 2023
		flags 1
	)
)

(instance controlSound5p3 of Sound
	(properties
		number 2024
		flags 1
	)
)

(instance subControl6 of Prop
	(properties
		x 454
		y 187
		loop 5
		view 2225
	)

	(method (init)
		(if (IsFlag 348)
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (cue)
		(if (IsFlag 348)
			(ClearFlag 348)
			(if (IsFlag 105)
				(SetFlag 110)
			)
		else
			(SetFlag 348)
			(if (IsFlag 105)
				(ClearFlag 110)
			)
		)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(controlSound6 play:)
			(if (== cel 0)
				(self setCycle: End self)
			else
				(self setCycle: Beg self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance controlSound6 of Sound
	(properties
		number 2004
		flags 1
	)
)

(instance subControl7 of Prop
	(properties
		x 397
		y 299
		loop 9
		view 2225
	)

	(method (doVerb theVerb)
		(if (gFeatures contains: throttleUp)
			(throttleUp doVerb: theVerb)
		)
	)
)

(instance subControl8 of Prop
	(properties
		x 288
		y 128
		loop 14
		view 2225
	)

	(method (init)
		(if (IsFlag 105)
			(= cel 9)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance subGuages of Prop
	(properties
		view 2225
	)
)

(instance subPowerLight of Prop
	(properties
		x 399
		y 149
		loop 11
		view 2225
	)
)

(instance powerIndicator of Prop
	(properties
		x 112
		y 117
		loop 4
		view 2225
	)

	(method (init)
		(cond
			((not (IsFlag 105))
				(= cel 0)
			)
			(
				(or
					(and (IsFlag 106) (IsFlag 108) (not (IsFlag 107)))
					(and (IsFlag 107) (IsFlag 106) (not (IsFlag 108)))
					(and (IsFlag 108) (IsFlag 107) (not (IsFlag 106)))
				)
				(= cel 4)
			)
			(
				(or
					(and (IsFlag 106) (not (IsFlag 108)) (not (IsFlag 107)))
					(and (IsFlag 108) (not (IsFlag 106)) (not (IsFlag 107)))
					(and (IsFlag 107) (not (IsFlag 106)) (not (IsFlag 108)))
				)
				(= cel 3)
			)
			(else
				(= cel 2)
			)
		)
		(super init: &rest)
	)
)

(instance throttleSpot of Feature
	(properties
		nsBottom 374
		nsLeft 405
		nsRight 563
		nsTop 255
	)

	(method (doVerb theVerb)
		(if (== theVerb 41) ; invThrottle
			(gCurRoom setScript: insertThrottle)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance throttleSpot2 of Feature
	(properties
		nsBottom 295
		nsLeft 193
		nsRight 357
		nsTop 291
	)

	(method (doVerb theVerb)
		(if (== theVerb 41) ; invThrottle
			(gCurRoom setScript: insertThrottle2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance throttleUp of Feature
	(properties
		nsBottom 275
		nsLeft 361
		nsRight 389
		nsTop 190
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(== theVerb 5) ; Do
					(!= global226 global227)
					(IsFlag 105)
					(IsFlag 229)
				)
				(gCurRoom setScript: crankUpThrottle)
			)
			((IsFlag 111)
				(gCurRoom setScript: tryThrottle)
			)
		)
	)
)

(instance throttleDown of Feature ; UNUSED
	(properties
		nsBottom 298
		nsLeft 442
		nsRight 483
		nsTop 227
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (== (subControl7 cel:) 0)) ; Do
			(gCurRoom setScript: crankDownThrottle)
		)
	)
)

(instance controlRoomDoor of Prop
	(properties
		y 164
		view 2230
	)

	(method (init)
		(if local3
			(= cel 12)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance subControl9 of View
	(properties
		x 83
		y 200
		view 2224
	)

	(method (init)
		(if (IsFlag 105)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance subControl10 of View
	(properties
		x 18
		y 145
		loop 1
		view 2224
	)

	(method (init)
		(if (IsFlag 106)
			(= cel 1)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance subControl11 of View
	(properties
		x 18
		y 145
		loop 2
		view 2224
	)

	(method (init)
		(if (IsFlag 107)
			(= cel 1)
		else
			(= cel 2)
		)
		(super init: &rest)
	)
)

(instance subControl12 of Prop
	(properties
		x 325
		y 132
		loop 3
		view 2224
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 105)
			(self setCycle: Fwd)
		)
	)
)

(instance subControl13 of View
	(properties
		x 432
		y 156
		loop 4
		view 2224
	)

	(method (init)
		(if (IsFlag 109)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)
)

(instance subControl14 of View
	(properties
		x 463
		y 152
		loop 5
		view 2224
	)

	(method (init)
		(if (IsFlag 110)
			(= cel 0)
		else
			(= cel 1)
		)
		(super init: &rest)
	)
)

(instance subControl15 of Prop
	(properties
		x 287
		y 237
		loop 6
		view 2224
	)

	(method (init)
		(if (IsFlag 111)
			(= cel 26)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance subControl16 of Prop
	(properties
		x 105
		y 174
		view 2224
	)

	(method (init)
		(if (IsFlag 105)
			(= loop 9)
			(self setCycle: Fwd)
		else
			(= loop 8)
		)
		(super init: &rest)
	)
)

(instance ballastLight230 of Prop
	(properties
		x 66
		y 156
		loop 3
		view 230
	)
)

(instance subControl17 of View
	(properties
		x 116
		y 66
		loop 10
		view 2224
	)

	(method (init)
		(cond
			((not (IsFlag 105))
				(= cel 0)
			)
			(
				(or
					(and (IsFlag 106) (IsFlag 108) (not (IsFlag 107)))
					(and (IsFlag 107) (IsFlag 106) (not (IsFlag 108)))
					(and (IsFlag 108) (IsFlag 107) (not (IsFlag 106)))
				)
				(= cel 4)
			)
			(
				(or
					(and (IsFlag 106) (not (IsFlag 108)) (not (IsFlag 107)))
					(and (IsFlag 108) (not (IsFlag 106)) (not (IsFlag 107)))
					(and (IsFlag 107) (not (IsFlag 106)) (not (IsFlag 108)))
				)
				(= cel 3)
			)
			(else
				(= cel 2)
			)
		)
		(super init: &rest)
	)
)

(instance spinningDial of Prop
	(properties
		x 215
		y 135
		loop 15
		view 2225
	)

	(method (init)
		(switch global227
			(0
				(= x 215)
				(= y 135)
				(= loop 15)
			)
			(2
				(= loop 18)
				(= x 214)
				(= y 135)
			)
			(1
				(= loop 16)
				(= x 214)
				(= y 135)
			)
			(3
				(= loop 17)
				(= x 214)
				(= y 135)
			)
			(4
				(= loop 19)
				(= x 214)
				(= y 135)
			)
		)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance myVMD of VMDPlayer ; UNUSED
	(properties
		x 70
		y 75
		buffSize 1024
		palStart 0
		palEnd 201
	)
)

(instance controlDoorCrank of Prop
	(properties
		x 353
		y 161
		loop 1
		view 2230
	)

	(method (cue)
		(if local3
			(= local3 0)
			((ScriptID 1 1) dispose:) ; exitForward
		else
			(= local3 1)
			((ScriptID 1 1) newRoom: 225) ; exitForward
		)
		(gGame handsOn:)
	)

	(method (init)
		(if 0
			(= cel 0)
		else
			(= cel 6)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (IsFlag 109)) ; Do
			(gGame handsOff:)
			(if local3
				(self setCycle: Beg self)
				(controlSound5p2 play:)
				(controlRoomDoor setCycle: Beg)
			else
				(controlSound5p2 play:)
				(self setCycle: End self)
				(controlRoomDoor setCycle: End)
			)
		)
	)
)

(instance leftLights230 of View
	(properties
		x 20
		y 109
		view 2222
	)
)

(instance rightLights of View
	(properties
		x 79
		y 102
		loop 1
		view 2222
	)
)

(instance lever230 of View
	(properties
		x 276
		y 83
		loop 2
		view 2222
	)
)

