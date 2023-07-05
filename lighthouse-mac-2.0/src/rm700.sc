;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Stem)
(use ROsc)
(use Osc)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
	local2
	local3
	local4 = -2
	local5 = -1
	local6
	local7
	local8 = 1
	local9 = -1
	local10
	local11 = -1
	local12 = 1
	[local13 5] = [0 -1 -1 -1 -1]
	local18
	local19
	local20
	local21 = 595
	[local22 32] = [0 0 1 1 2 2 3 1 4 0 3 -1 2 -2 1 -1 0 0 -1 1 -2 2 -3 1 -4 0 -3 -1 -2 -2 -1 -1]
	local54
)

(instance rm700 of LightRoom
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(Lock rsAUDIO 456 1)
		(Lock rsAUDIO 457 1)
		(Lock rsAUDIO 459 1)
		(gIRandomMusic musicOne: 456 musicTwo: 457 musicThree: 459 play: 127 0)
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) dispose:) ; PlCompass
		)
		(SetFlag 403)
		(self changeScene: 216)
		(scriptProp init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (changeScene param1)
		(forwardDir dispose:)
		(leftDir dispose:)
		(rightDir dispose:)
		(dropLever dispose:)
		(doitLever dispose:)
		(actualArmLever dispose:)
		(armControls dispose:)
		(throttle dispose:)
		(foreGround dispose:)
		(directionLever dispose:)
		(armControls dispose:)
		(ballast dispose:)
		(leftHatchLever dispose:)
		(rightHatchLever dispose:)
		(rbtArm dispose:)
		(wreckBot dispose:)
		(swayBot dispose:)
		(gCurRoom setScript: 0)
		(super changeScene: param1 &rest)
		(switch param1
			(0
				(if (not local20)
					(forwardDir init:)
					(leftDir init:)
					(rightDir init:)
					(dropLever init:)
					(throttle init:)
					(directionLever init:)
					(if local10
						(armControls init:)
						(actualArmLever init:)
					)
					(leftHatchLever init:)
					(rightHatchLever init:)
					(foreGround init:)
					(rbtArm init:)
					(wreckBot init: local0 local1 local2 local3 1)
					(if (not (wreckBot paused:))
						(wreckBot pause: 1)
					)
					(gCurRoom setScript: swayBot)
					((ScriptID 1 3) newPic: 241) ; exitLeft
					((ScriptID 1 4) newPic: 242) ; exitRight
					(= local11 param1)
				)
			)
			(216
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
					(actualArmLever init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				((ScriptID 1 3) newPic: 241) ; exitLeft
				((ScriptID 1 4) newPic: 242) ; exitRight
				(if local12
					((ScriptID 1 6) ; exitUp
						newPic: 243
						nsTop: 0
						nsLeft: 227
						nsBottom: 73
						nsRight: 269
					)
				else
					((ScriptID 1 6) ; exitUp
						newPic: 257
						nsTop: 0
						nsLeft: 227
						nsBottom: 73
						nsRight: 269
					)
				)
				(= local11 param1)
			)
			(241
				(if (IsFlag 166)
					((ScriptID 1 4) newPic: 0) ; exitRight
				else
					((ScriptID 1 4) newPic: 216) ; exitRight
				)
				(if local12
					((ScriptID 1 6) newPic: 243) ; exitUp
				else
					((ScriptID 1 6) newPic: 257) ; exitUp
				)
				((ScriptID 1 2) newPic: 242) ; exitBack
				(= local11 param1)
			)
			(242
				(ballast init:)
				(if (IsFlag 166)
					((ScriptID 1 3) newPic: 0) ; exitLeft
				else
					((ScriptID 1 3) newPic: 216) ; exitLeft
				)
				(if local12
					((ScriptID 1 6) newPic: 243) ; exitUp
				else
					((ScriptID 1 6) newPic: 257) ; exitUp
				)
				((ScriptID 1 2) newPic: 241) ; exitBack
				(= local11 param1)
			)
			(243
				(if local12
					((ScriptID 1 1) newRoom: 212) ; exitForward
				)
				((ScriptID 1 5) newPic: 216) ; exitDown
			)
			(257
				((ScriptID 1 5) newPic: local11) ; exitDown
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(ClearFlag 403)
		(gIRandomMusic fade:)
		(wreckBot dispose:)
		(wreckSound stop: dispose:)
		(Lock rsAUDIO 456 0)
		(Lock rsAUDIO 457 0)
		(Lock rsAUDIO 459 0)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (wreckBot cycler:)
			(if
				(or
					(& (event type:) evMOUSEBUTTON)
					(and
						(& (event type:) evKEYBOARD)
						(or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
					)
				)
				(cond
					((== (gCurRoom script:) goTo7)
						(gCurRoom setScript: 0)
						(wreckBot
							caller: 0
							stop:
							pause: 1
							init: 2558 100 14 12 1
						)
						(= local6 1)
						(= local8 7)
						(throttle setCycle: Beg)
						(= local0 2558)
						(= local6 0)
						(= local1 100)
						(= local2 14)
						(= local3 12)
						(if (not (directionLever cel:))
							(directionLever setCycle: CT 2 1)
						else
							(directionLever setCycle: CT 2 -1)
						)
						(gCurRoom setScript: swayBot)
					)
					((== (gCurRoom script:) goTo3)
						(gCurRoom setScript: 0)
						(= local6 2)
						(= local8 3)
						(wreckBot caller: 0 stop: pause: 1 init: 2558 0 14 12 1)
						(throttle setCycle: Beg)
						(= local0 2558)
						(= local6 0)
						(= local1 0)
						(= local2 14)
						(= local3 12)
						(if (not (directionLever cel:))
							(directionLever setCycle: CT 2 1)
						else
							(directionLever setCycle: CT 2 -1)
						)
						(= local9 50)
						(gCurRoom setScript: swayBot)
					)
					((== (gCurRoom script:) upToCaptainsRoom)
						(gCurRoom setScript: 0)
						(wreckBot caller: 0 pause: 1 init: 587 0 0 0 1)
						(= local6 1)
						(= local0 (wreckBot number:))
						(= local1 (wreckBot curFrame:))
						(= local2 (wreckBot x:))
						(= local3 (wreckBot y:))
						(= local8 13)
						(gCurRoom changeScene: 0)
						(gCurRoom setScript: swayBot)
					)
					((== (gCurRoom script:) downToSkull)
						(gCurRoom setScript: 0)
						(= local6 2)
						(wreckBot caller: 0 pause: 1 init: 577 0 14 12 1)
						(= local0 (wreckBot number:))
						(= local1 (wreckBot curFrame:))
						(= local2 (wreckBot x:))
						(= local3 (wreckBot y:))
						(= local8 12)
						(gCurRoom changeScene: 0)
						(gCurRoom setScript: swayBot)
					)
					(else
						(gCurRoom setScript: 0)
						(wreckBot curFrame: local9)
					)
				)
				(= local18 0)
				(gGame handsOn:)
			)
			(event claimed: 1)
			(return)
		)
		(super handleEvent: event &rest)
	)
)

(instance swayBot of Script
	(properties)

	(method (dispose)
		(= local4 -2)
		(= local5 -1)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(not (gGame isHandsOn:))
						(not local18)
						(not (throttle cel:))
					)
					(gGame handsOn:)
				)
				(wreckBot
					init:
						local0
						local1
						(+ [local22 (+= local4 2)] local2)
						(+ [local22 (+= local5 2)] local3)
						1
				)
				(= ticks 1)
			)
			(1
				(if (== local4 30)
					(= local4 -2)
					(= local5 -1)
				)
				(= state -1)
				(= ticks 4)
			)
		)
	)
)

(instance goTo7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 1)
				(= local9 0)
				(throttle setCycle: CT 2 1)
				(wreckBot
					pause: 0
					caller: self
					init: 2560 37 0 0 1
					start: local6 local7
				)
			)
			(1
				(= local8 7)
				(= local6 1)
				(wreckBot caller: self init: 2558 50 14 12 1 start: 1 local7)
			)
			(2
				(wreckBot caller: 0 stop: pause: 1)
				(throttle setCycle: Beg)
				(= local0 2558)
				(= local6 0)
				(= local1 100)
				(= local2 14)
				(= local3 12)
				(if (not (directionLever cel:))
					(directionLever setCycle: CT 2 1)
				else
					(directionLever setCycle: CT 2 -1)
				)
				(= local9 50)
				(gGame handsOn:)
				(gCurRoom setScript: swayBot)
			)
		)
	)
)

(instance goTo3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 2)
				(= local9 0)
				(throttle setCycle: CT 2 1)
				(wreckBot
					pause: 0
					caller: self
					init: 2560 12 0 0 1
					start: local6 local7
				)
			)
			(1
				(= local8 3)
				(= local6 2)
				(wreckBot caller: self init: 2558 50 14 12 1 start: 2 local7)
			)
			(2
				(wreckBot caller: 0 stop: pause: 1)
				(throttle setCycle: Beg)
				(= local0 2558)
				(= local6 0)
				(= local1 0)
				(= local2 14)
				(= local3 12)
				(if (not (directionLever cel:))
					(directionLever setCycle: CT 2 1)
				else
					(directionLever setCycle: CT 2 -1)
				)
				(= local9 50)
				(gGame handsOn:)
				(gCurRoom setScript: swayBot)
			)
		)
	)
)

(instance closeHatch of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(and
					(== (hatchProp cel:) 15)
					(hatchProp cycler:)
					(== ((hatchProp cycler:) cycleDir:) -1)
				)
				(gMySoundFX number: 45905 setLoop: 0 play:)
			)
			(
				(and
					(== (hatchProp cel:) 5)
					(hatchProp cycler:)
					(== ((hatchProp cycler:) cycleDir:) 1)
				)
				(gMySoundFX number: 45906 setLoop: 0 play:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hatchInset init:)
				(= ticks 90)
			)
			(1
				(if local12
					(= local12 0)
					(hatchProp cycleSpeed: 12 setCel: 0 setCycle: End self)
					((ScriptID 1 6) ; exitUp
						newPic: 257
						nsTop: 0
						nsLeft: 227
						nsBottom: 73
						nsRight: 269
					)
				else
					(= local12 1)
					(hatchProp
						cycleSpeed: 12
						setCel: (hatchProp lastCel:)
						setCycle: Beg self
					)
					((ScriptID 1 6) ; exitUp
						newPic: 243
						nsTop: 0
						nsLeft: 227
						nsBottom: 73
						nsRight: 269
					)
				)
			)
			(2
				(hatchInset dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance releasePod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(releaseInset init:)
				(= ticks 90)
			)
			(1
				(if (IsFlag 174)
					(ClearFlag 174)
					(releaseProp
						cycleSpeed: 12
						setCel: (releaseProp lastCel:)
						setCycle: Beg self
					)
				else
					(SetFlag 174)
					(releaseProp cycleSpeed: 12 setCel: 0 setCycle: End self)
				)
				(gMySoundFX number: 45911 setLoop: 0 play:)
			)
			(2
				(= ticks 45)
			)
			(3
				(releaseInset dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance offToWreck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(gGlobalVMD number: 238 stretch: 1 init: play:)
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
				(ballast dispose:)
				(gCurRoom drawPic: 0)
				(gGlobalVMD close:)
				(gGame handsOff:)
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				(SetFlag 166)
				(wreckBot
					caller: self
					init: 2561 0 14 12 1
					pause: 0
					start: 1 30
				)
			)
			(1
				(wreckBot caller: 0 init: 2550 0 14 12 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(gGame handsOn:)
				(gCurRoom changeScene: 0)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance upToCaptainsRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local18 1)
				(gGame handsOff:)
				(ballast dispose:)
				(gCurRoom drawPic: 0)
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				(cond
					((OneOf local1 0 101)
						(= cycles 1)
					)
					((< local1 50)
						(wreckBot
							init: 577 local1 14 12 1
							caller: self
							pause: 0
							start: 2 10
						)
					)
					(else
						(wreckBot
							init: 577 local1 14 12 1
							caller: self
							pause: 0
							start: 1 10
						)
					)
				)
			)
			(1
				(wreckBot caller: self init: 579 0 0 0 1 pause: 0 start: 1 10)
			)
			(2
				(wreckBot caller: 0 init: 587 0 0 0 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local8 13)
				(= local18 0)
				(gGame handsOn:)
				(gCurRoom changeScene: 0)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance downToSkull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local18 1)
				(gGame handsOff:)
				(ballast dispose:)
				(gCurRoom drawPic: 0)
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				(cond
					((OneOf local1 0 99)
						(= cycles 1)
					)
					((< local1 50)
						(wreckBot
							init: 587 local1 0 0 1
							caller: self
							pause: 0
							start: 2 10
						)
					)
					(else
						(wreckBot
							init: 587 local1 0 0 1
							caller: self
							pause: 0
							start: 1 10
						)
					)
				)
			)
			(1
				(wreckBot caller: self init: 579 50 0 0 1 pause: 0 start: 2 10)
			)
			(2
				(wreckBot caller: 0 init: 577 0 14 12 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local8 12)
				(= local18 0)
				(gGame handsOn:)
				(gCurRoom changeScene: 0)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance removeDebris of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(wreckBot caller: self init: 598 0 0 0 1 pause: 0 start: 1 30)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(rbtArm
					view: (if (IsFlag 175) 594 else 2594)
					setCel: 0
					setCycle: End
				)
				(= local21 (rbtArm view:))
			)
			(2
				(rbtArm setCel: 0)
				(wreckBot caller: 0 init: 583 78 0 0 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local18 0)
				(SetFlag 430)
				(gGame handsOn:)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance downToHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(gGlobalVMD number: 239 stretch: 1 init: play:)
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
				(ballast dispose:)
				(gCurRoom drawPic: 0)
				(gGlobalVMD close:)
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				(if (IsFlag 434)
					(wreckBot caller: 0 init: 591 50 0 0 1 pause: 1)
				else
					(wreckBot caller: 0 init: 590 50 0 0 1 pause: 1)
				)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local8 14)
				(gGame handsOn:)
				(gCurRoom changeScene: 0)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance getHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rbtArm view: 592 setCel: 0 setCycle: CT 21 1 self)
			)
			(1
				(= local21 592)
				(rbtArm setCycle: End self)
				(wreckBot init: 591 local1 0 0 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(SetFlag 175)
				(SetFlag 434)
			)
			(2
				(= local18 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upFromHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(gGlobalVMD number: 237 stretch: 1 myBlackLines: 1 init: play:)
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
				(ballast dispose:)
				(gCurRoom drawPic: 0)
				(gGlobalVMD close:)
				(forwardDir init:)
				(leftDir init:)
				(rightDir init:)
				(dropLever init:)
				(throttle init:)
				(directionLever init:)
				(if local10
					(armControls init:)
				)
				(leftHatchLever init:)
				(rightHatchLever init:)
				(foreGround init:)
				(rbtArm init:)
				(wreckBot init: 2552 50 14 12 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local8 11)
				(= local18 0)
				(gGame handsOn:)
				(gCurRoom changeScene: 0)
				(self dispose:)
			)
		)
	)
)

(instance placeHook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 597)
				(rbtArm view: 593 setCel: 0 setCycle: CT 14 1 self)
			)
			(1
				(rbtArm view: 597 setCel: 0)
				(= local21 (rbtArm view:))
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(gGlobalVMD number: 2596 stretch: 1 myBlackLines: 1 init: play:)
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
				(wreckBot caller: 0 init: 584 78 0 0 1 pause: 1)
				(gGlobalVMD close:)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(SetFlag 429)
				(= local18 0)
				(ClearFlag 175)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance openSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wreckBot caller: self init: 596 5 0 0 1 pause: 0 start: 1 30)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(rbtArm view: 595 setCel: 0 setCycle: End)
				(= local21 (rbtArm view:))
			)
			(1
				(rbtArm setCel: 0)
				(wreckBot caller: 0 init: 585 78 0 0 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
				(= local18 0)
				(SetFlag 431)
				(gCurRoom setScript: swayBot)
				(self dispose:)
			)
		)
	)
)

(instance getPiece of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rbtArm view: 597 setCel: 0 setCycle: CT 8 1 self)
				(= local21 (rbtArm view:))
			)
			(1
				(rbtArm setCycle: End self)
				(wreckBot caller: 0 init: 586 78 0 0 1 pause: 1)
				(= local0 (wreckBot number:))
				(= local1 (wreckBot curFrame:))
				(= local2 (wreckBot x:))
				(= local3 (wreckBot y:))
			)
			(2
				(= local20 1)
				(gCurRoom changeScene: 0)
				(= ticks 1)
			)
			(3
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(PlayVMD 0 {240.vmd} 1024) ; Open
				(gIRandomMusic stop:)
				(wreckSound stop:)
				(PlayVMD 23 0 199) ; RestrictPalette
				(PlayVMD 1 70 75 272 5 0 199) ; Put
				(ClearFlag 166)
				(SetFlag 385)
				(ClearFlag 174)
				(gInventory addItem: (ScriptID 9 61)) ; invFiringMechanism
				(gCurRoom newRoom: 212)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
			)
		)
	)
)

(instance headBackEarly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local20 1)
				(gCurRoom changeScene: 0)
				(= ticks 3)
			)
			(1
				(if (not (gInventory disabled:))
					(= local54 1)
					(gInventory disable: 1)
				)
				(PlayVMD 0 {240.vmd} 1024) ; Open
				(gIRandomMusic stop:)
				(wreckSound stop:)
				(PlayVMD 23 0 199) ; RestrictPalette
				(PlayVMD 1 70 75 272 5 0 199) ; Put
				(ClearFlag 166)
				(ClearFlag 174)
				(leftHatchLever setCel: 0)
				(releaseProp setCel: 0)
				(gCurRoom changeScene: 216)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(if local54
					(gInventory disable: 0)
					(= local54 0)
				)
				(= local20 0)
				(= local8 1)
				(gGame handsOn:)
				(gIRandomMusic
					musicOne: 456
					musicTwo: 457
					musicThree: 459
					play: 127 0
				)
				(self dispose:)
			)
		)
	)
)

(instance hatchInset of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(hatchProp init: self 1 1)
	)
)

(instance releaseInset of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(releaseProp init: self 1 1)
	)
)

(instance directionLever of Prop
	(properties
		x 173
		y 248
		view 247
		cel 2
	)

	(method (init)
		(self setPri: 601)
		(super init: &rest)
	)
)

(instance throttle of Prop
	(properties
		x 54
		y 208
		view 247
		loop 1
	)

	(method (init)
		(self setPri: 601)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (setCycle param1)
		(if param1
			(throttleSound number: 45923 setLoop: 0 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Do
					(if (not (IsFlag 166))
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(if (wreckBot paused:)
						(if (not (getRobot doit:))
							(return)
						)
					else
						(gGame handsOff:)
					)
					(= local0 (wreckBot number:))
					(= local1 (wreckBot curFrame:))
					(= local2 (wreckBot x:))
					(= local3 (wreckBot y:))
					(switch (self cel:)
						(0
							(self setCycle: CT 2 1)
							(= local7 30)
							(wreckBot pause: 0 start: local6 10 1)
						)
						(2
							(= local9 local1)
							(self setCycle: Beg)
							(= local7 10)
						)
						((self lastCel:)
							(= local9 local1)
							(self setCycle: Beg)
							(= local7 10)
						)
					)
				)
			)
		)
	)
)

(instance dropLever of Prop
	(properties
		x 375
		y 186
		view 246
	)

	(method (init)
		(self setPri: 601)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(if local10
			(doitLever dispose:)
			(actualArmLever dispose:)
			(rbtArm setMotion: MoveTo 250 370 rbtArm)
			(armControls setCycle: Beg armControls)
			(gMySoundFX number: 45922 setLoop: 0 play:)
		else
			(armControls init:)
		)
	)

	(method (doVerb)
		(if (and (not cycler) (not (armControls cycler:)))
			(= local18 1)
			(gGame handsOff:)
			(dropLeverSound number: 45925 setLoop: 0 play:)
			(if cel
				(self setCycle: Beg self)
			else
				(self setCycle: End self)
			)
		)
	)
)

(instance armControls of Prop
	(properties
		x 252
		view 246
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 601 setCycle: End actualArmLever)
		(if (not local10)
			(gMySoundFX number: 45922 setLoop: 0 play:)
		)
		(= local10 1)
	)

	(method (cue)
		(= local10 0)
		(self dispose:)
	)
)

(instance ballast of Prop
	(properties
		x 291
		y 80
		view 245
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(
						(and
							(not (IsFlag 166))
							(not local12)
							(IsFlag 174)
							(not (IsFlag 385))
						)
						(gGame handsOff:)
						(gMySoundFX number: 45912 setLoop: 0 play:)
						(self setCycle: CT 5 1 self)
					)
					((== local8 12)
						(gGame handsOff:)
						(gMySoundFX number: 45913 setLoop: 0 play:)
						(self setCycle: CT 0 -1 self)
					)
					((== local8 13)
						(gGame handsOff:)
						(gMySoundFX number: 45912 setLoop: 0 play:)
						(self setCycle: CT 5 1 self)
					)
					((== local8 11)
						(gGame handsOff:)
						(gMySoundFX number: 45912 setLoop: 0 play:)
						(self setCycle: CT 10 1 self)
					)
					((== local8 14)
						(= local18 1)
						(gGame handsOff:)
						(gMySoundFX number: 45913 setLoop: 0 play:)
						(self setCycle: CT 5 -1 self)
					)
					((and (<= 1 local8 8) (IsFlag 166))
						(= local18 1)
						(gGame handsOff:)
						(gMySoundFX number: 45913 setLoop: 0 play:)
						(self setCycle: CT 0 -1 self)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(cond
			((not (IsFlag 166))
				(gCurRoom setScript: offToWreck)
			)
			((== local8 12)
				(gCurRoom setScript: upToCaptainsRoom)
			)
			((== local8 13)
				(gCurRoom setScript: downToSkull)
			)
			((== local8 11)
				(gCurRoom setScript: downToHook)
			)
			((== local8 14)
				(gCurRoom setScript: upFromHook)
			)
			((<= 1 local8 8)
				(scriptProp setScript: headBackEarly)
			)
		)
	)
)

(instance rightHatchLever of Prop
	(properties
		x 175
		y 43
		view 249
	)

	(method (init)
		(self setPri: 602)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(gMySoundFX number: 45910 setLoop: 0 play:)
					(self setCycle: Beg)
				else
					(gMySoundFX number: 45909 setLoop: 0 play:)
					(self setCycle: End)
				)
				(if (and (not (IsFlag 166)) (not (IsFlag 174)))
					(scriptProp setScript: closeHatch)
				)
			)
		)
	)
)

(instance leftHatchLever of Prop
	(properties
		x 155
		y 44
		view 250
	)

	(method (init)
		(self setPri: 601)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not local12) (not (IsFlag 166)) (== global226 4))
					(if (IsFlag 174)
						(gMySoundFX number: 45907 setLoop: 0 play:)
						(self setCel: (self lastCel:) setCycle: Beg)
					else
						(gMySoundFX number: 45908 setLoop: 0 play:)
						(self setCel: 0 setCycle: CT 4 1)
					)
					(releaseInset init:)
					(scriptProp setScript: releasePod)
				)
			)
		)
	)
)

(instance rbtArm of Actor
	(properties
		x 250
		y 370
		view 595
	)

	(method (init)
		(super init: &rest)
		(self view: local21 setPri: 100)
	)

	(method (cue)
		(super cue: &rest)
		(if (or (== (gCurRoom script:) swayBot) (not (gCurRoom script:)))
			(= local18 0)
			(gGame handsOn:)
		)
	)
)

(instance actualArmLever of StemTracker
	(properties
		nsLeft 287
		nsTop 7
		nsRight 331
		nsBottom 55
	)

	(method (init)
		(super init: &rest)
		(doitLever init:)
		(gTheDoits add: moveArm)
	)

	(method (cue)
		(super cue: &rest)
		(rbtArm setMotion: MoveTo 250 332 rbtArm)
		(self
			addStem:
				246
				2
				309
				33
				(+ (armControls priority:) 100)
				18432
				-7
				4
				-5
				-7
				-3
				-15
				-2
				-18
			addStem:
				246
				3
				309
				33
				(+ (armControls priority:) 100)
				20480
				-7
				4
				-9
				10
				-12
				23
				-14
				29
			addStem:
				246
				4
				309
				33
				(+ (armControls priority:) 100)
				19712
				-7
				4
				0
				5
				7
				6
				13
				8
			addStem:
				246
				5
				309
				33
				(+ (armControls priority:) 100)
				19200
				-7
				4
				-13
				2
				-22
				1
				-27
				0
		)
	)

	(method (doMouseUp)
		(self moveTo: 0 0)
	)

	(method (dispose)
		(gTheDoits delete: moveArm)
		(doitLever dispose:)
		(super dispose: &rest)
	)
)

(instance doitLever of Prop
	(properties
		x 334
		y 6
		view 246
		loop 6
	)

	(method (init)
		(gCast addToFront: self)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(self setPri: (+ (armControls priority:) 1))
		(approachX hotVerbs: 5)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(if (gCast contains: indicatorLight)
			(indicatorLight dispose:)
		)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(or
					(and
						(== local8 13)
						(== local1 78)
						(IsFlag 431)
						(< 220 (rbtArm x:) 274)
						(< 295 (rbtArm y:) 342)
					)
					(and
						(== local8 13)
						(== local1 78)
						(IsFlag 429)
						(not (IsFlag 431))
						(<= 255 (rbtArm x:) 285)
						(<= 305 (rbtArm y:) 325)
					)
					(and
						(== local8 13)
						(== local1 74)
						(not (IsFlag 429))
						(IsFlag 175)
						(< 240 (rbtArm x:) 267)
						(< 280 (rbtArm y:) 315)
					)
					(and
						(== local8 13)
						(== local1 78)
						(not (IsFlag 430))
						(< 235 (rbtArm x:) 270)
						(< 285 (rbtArm y:) 333)
					)
					(and
						(== local0 590)
						(not (IsFlag 175))
						(not (IsFlag 429))
						(== local8 14)
						(== local1 0)
						(< 244 (rbtArm x:) 256)
						(< 304 (rbtArm y:) 325)
					)
				)
				(if (not (gCast contains: indicatorLight))
					(indicatorLight init:)
				)
			)
			((gCast contains: indicatorLight)
				(indicatorLight dispose:)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(5 ; Do
				(switch view
					(2592
						(= temp0 45914)
					)
					(2593
						(= temp0 45915)
					)
					(2594
						(= temp0 45916)
					)
					(592
						(= temp0 45917)
					)
					(593
						(= temp0 45918)
					)
					(594
						(= temp0 45919)
					)
					(595
						(= temp0 45920)
					)
					(597
						(= temp0 45921)
					)
					(else
						(= temp0 45914)
					)
				)
				(cond
					(
						(and
							(== local8 13)
							(== local1 78)
							(IsFlag 431)
							(< 220 (rbtArm x:) 274)
							(< 295 (rbtArm y:) 342)
						)
						(self setCycle: Osc 1)
						(= local18 1)
						(scriptProp setScript: getPiece)
					)
					(
						(and
							(== local8 13)
							(== local1 78)
							(IsFlag 429)
							(not (IsFlag 431))
							(<= 255 (rbtArm x:) 285)
							(<= 305 (rbtArm y:) 325)
						)
						(self setCycle: Osc 1)
						(= local18 1)
						(scriptProp setScript: openSafe)
					)
					(
						(and
							(== local8 13)
							(== local1 74)
							(not (IsFlag 429))
							(IsFlag 175)
							(< 240 (rbtArm x:) 267)
							(< 280 (rbtArm y:) 315)
						)
						(self setCycle: Osc 1)
						(= local18 1)
						(scriptProp setScript: placeHook)
					)
					(
						(and
							(== local8 13)
							(== local1 78)
							(not (IsFlag 430))
							(< 235 (rbtArm x:) 270)
							(< 285 (rbtArm y:) 333)
						)
						(self setCycle: Osc 1)
						(= local18 1)
						(scriptProp setScript: removeDebris)
					)
					(
						(and
							(== local0 590)
							(not (IsFlag 175))
							(not (IsFlag 429))
							(== local8 14)
							(== local1 0)
							(< 244 (rbtArm x:) 256)
							(< 304 (rbtArm y:) 325)
						)
						(self setCycle: Osc 1)
						(= local18 1)
						(scriptProp setScript: getHook)
					)
					(else
						(self setCycle: Osc 1)
						(if (and (IsFlag 175) (not (IsFlag 429)))
							(rbtArm view: 2593 setCel: 0 setCycle: End)
							(= local21 (rbtArm view:))
						else
							(rbtArm view: 2592 setCel: 0 setCycle: End)
							(= local21 (rbtArm view:))
						)
					)
				)
				(armSound init: number: temp0 setLoop: 0 play: 127 0)
			)
		)
	)
)

(instance scriptProp of Prop
	(properties
		z 1000
		view 246
	)
)

(instance hatchProp of PanelProp
	(properties
		view 236
	)
)

(instance releaseProp of PanelProp
	(properties
		view 253
	)
)

(instance foreGround of View
	(properties
		view 240
	)

	(method (init)
		(self setPri: 210)
		(super init: &rest)
	)
)

(instance indicatorLight of View
	(properties
		x 232
		y 46
		view 240
		loop 1
	)

	(method (init)
		(self setPri: 220)
		(super init: &rest)
	)
)

(instance leftDir of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 291 222 291 223 267 185 259
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gCurRoom script:))
					(return)
				else
					(= local6 1)
					(directionSound number: 45924 setLoop: 0 play:)
					(directionLever setCycle: Beg)
				)
			)
		)
	)
)

(instance forwardDir of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 289 269 289 266 263 229 263
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gCurRoom script:))
					(return)
				else
					(= local6 0)
					(directionSound number: 45924 setLoop: 0 play:)
					(if (not (directionLever cel:))
						(directionLever setCycle: CT 2 1)
					else
						(directionLever setCycle: CT 2 -1)
					)
				)
			)
		)
	)
)

(instance rightDir of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 288 316 290 312 260 278 262
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gCurRoom script:))
					(return)
				else
					(= local6 2)
					(directionSound number: 45924 setLoop: 0 play:)
					(directionLever setCycle: End)
				)
			)
		)
	)
)

(instance wreckBot of RobotPlayer
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (doit &tmp temp0)
		(= temp0 0)
		(super doit: &rest)
		(if
			(and
				(== (= local1 (self curFrame:)) local9)
				(not (gCurRoom script:))
				(not (self paused:))
			)
			(cond
				((and (== local8 11) (== (wreckBot number:) 2552))
					(if (< local1 50)
						(if (not (gInventory disabled:))
							(= local54 1)
							(gInventory disable: 1)
						)
						(gGlobalVMD number: 242 stretch: 1 dir: 1 init: play:)
						(if local54
							(gInventory disable: 0)
							(= local54 0)
						)
					else
						(if (not (gInventory disabled:))
							(= local54 1)
							(gInventory disable: 1)
						)
						(gGlobalVMD number: 241 stretch: 1 dir: 1 init: play:)
						(if local54
							(gInventory disable: 0)
							(= local54 0)
						)
					)
					(wreckBot init: 2552 50 14 12 1)
					(= local0 (wreckBot number:))
					(= local1 (wreckBot curFrame:))
					(= local2 (wreckBot x:))
					(= local3 (wreckBot y:))
					(gGlobalVMD close:)
				)
				((and (== local8 12) (== (wreckBot number:) 572))
					(wreckBot init: 577 0 14 12 1)
					(= local0 (wreckBot number:))
					(= local1 (wreckBot curFrame:))
					(= local2 (wreckBot x:))
					(= local3 (wreckBot y:))
				)
				((and (== local8 10) (== (wreckBot number:) 573))
					(wreckBot init: 2560 25 0 0 1)
					(= local0 (wreckBot number:))
					(= local1 (wreckBot curFrame:))
					(= local2 (wreckBot x:))
					(= local3 (wreckBot y:))
				)
				(
					(and
						(== local8 14)
						(== (wreckBot number:) 590)
						(== (wreckBot curFrame:) 99)
					)
					(wreckBot init: 590 0 0 0 1)
					(= local0 (wreckBot number:))
					(= local1 (wreckBot curFrame:))
					(= local2 (wreckBot x:))
					(= local3 (wreckBot y:))
				)
			)
			(gGame handsOff:)
			(wreckBot stop: pause: 1)
			(throttle setCycle: Beg)
			(gCurRoom setScript: swayBot)
			(= local6 0)
			(if (not (directionLever cel:))
				(directionLever setCycle: CT 2 1)
			else
				(directionLever setCycle: CT 2 -1)
			)
		)
	)

	(method (stop)
		(wreckSound stop:)
		(super stop: &rest)
	)

	(method (start)
		(super start: &rest)
	)
)

(instance getRobot of Code
	(properties)

	(method (doit)
		(switch local8
			(1
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 2)
						(= local9 50)
						(wreckBot init: 2550 0 14 12 1)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 8)
						(= local9 500)
						(wreckBot init: 2550 550 14 12 1)
					)
				)
			)
			(2
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 9)
						(= local9 43)
						(wreckBot init: 2556 101 14 12 1)
					)
					(1
						(= local8 3)
						(= local9 150)
						(wreckBot init: 2550 50 14 12 1)
					)
					(2
						(= local8 1)
						(= local9 0)
						(wreckBot init: 2550 50 14 12 1)
					)
				)
			)
			(3
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 10)
						(= local9 50)
						(= local6 1)
						(wreckBot init: 2558 0 14 12 1)
					)
					(1
						(= local8 4)
						(= local9 200)
						(wreckBot init: 2550 150 14 12 1)
					)
					(2
						(= local8 2)
						(= local9 50)
						(wreckBot init: 2550 150 14 12 1)
					)
				)
			)
			(4
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 11)
						(= local9 75)
						(= local6 2)
						(wreckBot init: 2552 100 14 12 1)
					)
					(1
						(= local8 5)
						(= local9 300)
						(wreckBot init: 2550 200 14 12 1)
					)
					(2
						(= local8 3)
						(= local9 150)
						(wreckBot init: 2550 200 14 12 1)
					)
				)
			)
			(5
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 6)
						(= local9 350)
						(wreckBot init: 2550 300 14 12 1)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 4)
						(= local9 200)
						(wreckBot init: 2550 300 14 12 1)
					)
				)
			)
			(6
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 11)
						(= local9 25)
						(= local6 1)
						(wreckBot init: 2552 0 14 12 1)
					)
					(1
						(= local8 7)
						(= local9 450)
						(wreckBot init: 2550 350 14 12 1)
					)
					(2
						(= local8 5)
						(= local9 300)
						(wreckBot init: 2550 350 14 12 1)
					)
				)
			)
			(7
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 10)
						(= local9 50)
						(= local6 2)
						(wreckBot init: 2558 100 14 12 1)
					)
					(1
						(= local8 8)
						(= local9 500)
						(wreckBot init: 2550 450 14 12 1)
					)
					(2
						(= local8 6)
						(= local9 350)
						(wreckBot init: 2550 450 14 12 1)
					)
				)
			)
			(8
				(gCurRoom setScript: 0)
				(swayBot dispose:)
				(switch local6
					(0
						(= local8 9)
						(= local9 43)
						(= local6 1)
						(wreckBot init: 2556 0 14 12 1)
					)
					(1
						(= local8 1)
						(= local9 550)
						(wreckBot init: 2550 500 14 12 1)
					)
					(2
						(= local8 7)
						(= local9 450)
						(wreckBot init: 2550 500 14 12 1)
					)
				)
			)
			(9
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 2)
						(= local9 101)
						(wreckBot init: 2556 43 14 12 1)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local8 8)
						(= local9 0)
						(wreckBot init: 2556 43 14 12 1)
					)
				)
			)
			(10
				(switch local6
					(0
						(switch local1
							(12
								(gCurRoom setScript: goTo3)
								(return 0)
							)
							(25
								(= local8 12)
								(gCurRoom setScript: 0)
								(swayBot dispose:)
								(= local6 1)
								(= local9 272)
								(wreckBot init: 572 0 14 12 1)
							)
							(37
								(gCurRoom setScript: goTo7)
								(return 0)
							)
							(else
								(throttle setCycle: ROsc 1 0 2)
								(return 0)
							)
						)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local6 1)
						(switch local1
							(0
								(= local9 12)
								(wreckBot init: 2560 0 0 0 1)
							)
							(12
								(= local9 25)
								(wreckBot init: 2560 12 0 0 1)
							)
							(25
								(= local9 37)
								(wreckBot init: 2560 25 0 0 1)
							)
							(37
								(= local9 50)
								(wreckBot init: 2560 37 0 0 1)
							)
							(50
								(= local9 12)
								(wreckBot init: 2560 0 0 0 1)
							)
						)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local6 2)
						(switch local1
							(0
								(= local9 37)
								(wreckBot init: 2560 50 0 0 1)
							)
							(12
								(= local9 0)
								(wreckBot init: 2560 12 0 0 1)
							)
							(25
								(= local9 12)
								(wreckBot init: 2560 25 0 0 1)
							)
							(37
								(= local9 25)
								(wreckBot init: 2560 37 0 0 1)
							)
							(50
								(= local9 37)
								(wreckBot init: 2560 50 0 0 1)
							)
						)
					)
				)
			)
			(11
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local6 2)
						(= local8 6)
						(= local9 0)
						(wreckBot init: 2552 50 14 12 1)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(= local6 1)
						(= local8 4)
						(= local9 100)
						(wreckBot init: 2552 50 14 12 1)
					)
				)
			)
			(12
				(switch local6
					(0
						(if (== local1 0)
							(gCurRoom setScript: 0)
							(swayBot dispose:)
							(= local6 1)
							(= local8 10)
							(= local9 393)
							(wreckBot init: 573 0 0 0 1)
						else
							(throttle setCycle: ROsc 1 0 2)
							(return 0)
						)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 25)
								(wreckBot init: 577 0 14 12 1)
							)
							(25
								(= local9 50)
								(wreckBot init: 577 25 14 12 1)
							)
							(50
								(= local9 75)
								(wreckBot init: 577 50 14 12 1)
							)
							(75
								(= local9 101)
								(wreckBot init: 577 75 14 12 1)
							)
							(101
								(= local9 25)
								(wreckBot init: 577 0 14 12 1)
							)
						)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 75)
								(wreckBot init: 577 101 14 12 1)
							)
							(25
								(= local9 0)
								(wreckBot init: 577 25 14 12 1)
							)
							(50
								(= local9 25)
								(wreckBot init: 577 50 14 12 1)
							)
							(75
								(= local9 50)
								(wreckBot init: 577 75 14 12 1)
							)
							(101
								(= local9 75)
								(wreckBot init: 577 101 14 12 1)
							)
						)
					)
				)
			)
			(13
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(= local6 2)
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 78)
							)
							(25
								(= local9 0)
							)
							(50
								(= local9 25)
							)
							(74
								(= local9 50)
							)
							(78
								(if (IsFlag 430)
									(= local9 74)
								else
									(= local9 50)
								)
							)
							(99
								(= local9 78)
							)
						)
						(cond
							((IsFlag 431)
								(wreckBot init: 585 local1 0 0 1)
							)
							((IsFlag 429)
								(wreckBot init: 584 local1 0 0 1)
							)
							((IsFlag 430)
								(wreckBot init: 583 local1 0 0 1)
							)
							(else
								(wreckBot init: 587 local1 0 0 1)
							)
						)
					)
					(2
						(= local6 1)
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 25)
							)
							(25
								(= local9 50)
							)
							(50
								(if (IsFlag 430)
									(= local9 74)
								else
									(= local9 78)
								)
							)
							(74
								(= local9 78)
							)
							(78
								(= local9 99)
							)
							(99
								(= local9 25)
							)
						)
						(cond
							((IsFlag 431)
								(wreckBot init: 585 local1 0 0 1)
							)
							((IsFlag 429)
								(wreckBot init: 584 local1 0 0 1)
							)
							((IsFlag 430)
								(wreckBot init: 583 local1 0 0 1)
							)
							(else
								(wreckBot init: 587 local1 0 0 1)
							)
						)
					)
				)
			)
			(14
				(switch local6
					(0
						(throttle setCycle: ROsc 1 0 2)
						(return 0)
					)
					(1
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 25)
							)
							(25
								(= local9 50)
							)
							(50
								(= local9 75)
							)
							(75
								(= local9 99)
							)
							(99
								(= local9 25)
								(= local1 0)
							)
						)
						(if (IsFlag 434)
							(wreckBot init: 591 local1 0 0 1)
						else
							(wreckBot init: 590 local1 0 0 1)
						)
					)
					(2
						(gCurRoom setScript: 0)
						(swayBot dispose:)
						(switch local1
							(0
								(= local9 75)
								(= local1 99)
							)
							(25
								(= local9 0)
							)
							(50
								(= local9 25)
							)
							(75
								(= local9 50)
							)
							(99
								(= local9 75)
							)
						)
						(if (IsFlag 434)
							(wreckBot init: 591 local1 0 0 1)
						else
							(wreckBot init: 590 local1 0 0 1)
						)
					)
				)
			)
		)
	)
)

(instance moveArm of Code
	(properties)

	(method (doit)
		(if
			(and
				(or (actualArmLever forcedMove:) (actualArmLever tracking:))
				((actualArmLever stemView:) cel:)
			)
			(switch (actualArmLever curStemIndex:)
				(3
					(if (> (rbtArm x:) 210)
						(rbtArm posn: (- (rbtArm x:) 1) (rbtArm y:))
					)
				)
				(2
					(if (< (rbtArm x:) 310)
						(rbtArm posn: (+ (rbtArm x:) 1) (rbtArm y:))
					)
				)
				(0
					(if
						(and
							(> (rbtArm y:) 261)
							(> ((actualArmLever stemView:) cel:) 0)
						)
						(rbtArm posn: (rbtArm x:) (- (rbtArm y:) 1))
					)
				)
				(1
					(if (< (rbtArm y:) 325)
						(rbtArm posn: (rbtArm x:) (+ (rbtArm y:) 1))
					)
				)
			)
		)
	)
)

(instance wreckSound of RandomMusic
	(properties
		number 45901
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)

	(method (play param1 param2)
		(if (not local7)
			(return)
		)
		(= vol 127)
		(= client 0)
		(if argc
			(if (== argc 1)
				(= client param1)
			else
				(= client param2)
				(= vol (& param1 $007f))
			)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound sndPLAY self)
	)

	(method (cue)
		(super cue: &rest)
	)
)

(instance armSound of RandomMusic
	(properties
		number 45914
	)

	(method (play param1 param2)
		(= vol 127)
		(= client 0)
		(if argc
			(if (== argc 1)
				(= client param1)
			else
				(= client param2)
				(= vol (& param1 $007f))
			)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound sndPLAY self)
	)

	(method (cue)
		(if (== number 45914)
			(self init: number: 45921 setLoop: 0 play:)
		)
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)
)

(instance throttleSound of Sound
	(properties)
)

(instance directionSound of Sound
	(properties)
)

(instance dropLeverSound of Sound
	(properties)
)

