;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm810 0
)

(instance rm810 of LightRoom
	(properties
		picture 810
	)

	(method (init)
		(if (IsFlag 402)
			(gBackMusic2 loop: -1 number: 808 play: 127 0)
		)
		(gBackMusic loop: -1 number: 801 play: 127 0)
		(super init: &rest)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(270
				(self changeScene: 817 3)
			)
			(765
				(self changeScene: 815 7)
			)
			(else
				(self changeScene: 810 1)
			)
		)
	)

	(method (changeScene param1)
		(fToolBox dispose:)
		(pTrainDoor dispose:)
		(rGate dispose:)
		(vGate dispose:)
		(moveDownLeft dispose:)
		(moveUpLeft dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(810
				((ScriptID 1 4) newPic: 811 7) ; exitRight
				((ScriptID 1 2) newPic: 812 5) ; exitBack
				((ScriptID 1 3) newPic: 813 3) ; exitLeft
				(proc0_9 3810 0 0)
			)
			(811
				((ScriptID 1 3) newPic: 810 1) ; exitLeft
				((ScriptID 1 4) newPic: 812 5) ; exitRight
				((ScriptID 1 2) newPic: 813 3) ; exitBack
				((ScriptID 1 1) newPic: 815 7) ; exitForward
				(if (IsFlag 394)
					(moveDownLeft newRoom: 212 exitCode: cExit811)
				else
					(moveDownLeft newRoom: 212)
				)
				(if (IsFlag 259)
					(vGate init:)
				)
				(proc0_9 3811 0 0)
			)
			(812
				((ScriptID 1 2) newPic: 810 1) ; exitBack
				((ScriptID 1 3) newPic: 811 7) ; exitLeft
				((ScriptID 1 4) newPic: 813 3) ; exitRight
				(proc0_9 3812 0 0)
			)
			(813
				((ScriptID 1 2) newPic: 811 7) ; exitBack
				((ScriptID 1 4) newPic: 810 1) ; exitRight
				((ScriptID 1 3) newPic: 812 5) ; exitLeft
				(if (and (not (IsFlag 260)) (not (IsFlag 351)))
					(gGame handsOff:)
					(SetFlag 260)
					(gCurRoom setScript: sShowDarkBeing)
				)
			)
			(814
				((ScriptID 1 1) newPic: 818 8 nsRight: 420 nsBottom: 240) ; exitForward
				((ScriptID 1 4) newPic: 815 7 nsLeft: 421) ; exitRight
				((ScriptID 1 3) newPic: 817 3 nsRight: 169) ; exitLeft
				((ScriptID 1 2) newPic: 816 5 nsTop: 241) ; exitBack
				(proc0_9 3814 0 0)
			)
			(815
				(SetFlag 185)
				((ScriptID 1 2) newPic: 817 3) ; exitBack
				((ScriptID 1 4) newPic: 816 5) ; exitRight
				((ScriptID 1 3) newPic: 814 1) ; exitLeft
				(moveUpLeft newPic: 819 7)
				(if (IsFlag 259)
					(vGate init:)
				)
			)
			(816
				((ScriptID 1 4) newPic: 817 3) ; exitRight
				((ScriptID 1 2) newPic: 814 1) ; exitBack
				((ScriptID 1 3) newPic: 815 7) ; exitLeft
				(proc0_9 3816 0 0)
			)
			(817
				((ScriptID 1 1) newPic: 813 3) ; exitForward
				((ScriptID 1 4) newPic: 814 1) ; exitRight
				((ScriptID 1 3) newPic: 816 5) ; exitLeft
				((ScriptID 1 2) newPic: 815 7) ; exitBack
				(proc0_9 3817 0 0)
			)
			(818
				((ScriptID 1 7) newPic: 814 1 exitCode: trainDoorExitCode814) ; exitBackUp
				((ScriptID 1 3) newPic: 817 3 exitCode: trainDoorExitCode817) ; exitLeft
				((ScriptID 1 4) newPic: 819 7 exitCode: trainDoorExitCode819) ; exitRight
				(fToolBox init:)
				(pTrainDoor init:)
			)
			(819
				(cond
					((IsFlag 259)
						(rGate init: 827 15 97 24 300)
					)
					((IsFlag 27)
						(rGate init: 827 1 97 24 300)
					)
					(else
						(rGate init: 827 0 97 24 300)
					)
				)
				((ScriptID 1 2) newPic: 820 3) ; exitBack
			)
			(820
				((ScriptID 1 1) newPic: 817 3) ; exitForward
				((ScriptID 1 2) newPic: 819 7) ; exitBack
			)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (IsFlag 402)
			(gBackMusic2 fade:)
		)
		(gBackMusic stop:)
		(super dispose: &rest)
	)
)

(instance sShowDarkBeing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(if (IsFlag 402)
					(gBackMusic2 fade: 50 5 10 0 0)
				)
				(gBackMusic fade: 50 5 10 0 0)
			)
			(1
				(KillRobot 136 0 0)
			)
			(2
				(if (IsFlag 402)
					(gBackMusic2 fade: 127 5 10 0 0)
				)
				(gBackMusic fade: 127 5 10 0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fToolBox of Feature
	(properties)

	(method (init)
		(self createPoly: 246 165 309 165 309 190 246 190)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				((ScriptID 271 0) init:) ; toolBoxPanel
			)
		)
	)
)

(instance pTrainDoor of Prop
	(properties
		x 192
		y 246
		view 818
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
					((ScriptID 1 1) dispose:) ; exitForward
					(gMySoundFX number: 822 setLoop: 0 play:)
					(self setCycle: Beg self)
				else
					((ScriptID 1 1) ; exitForward
						newRoom: 270
						nsLeft: 192
						nsTop: 98
						nsBottom: 189
						nsRight: 245
					)
					(gMySoundFX number: 8220 setLoop: 0 play:)
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

(instance trainDoorExitCode814 of Code
	(properties)

	(method (doit)
		(if (pTrainDoor cel:)
			(gGame handsOff:)
			(gMySoundFX number: 822 setLoop: 0 play:)
			(pTrainDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 814 1)
	)
)

(instance trainDoorExitCode817 of Code
	(properties)

	(method (doit)
		(if (pTrainDoor cel:)
			(gGame handsOff:)
			(gMySoundFX number: 822 setLoop: 0 play:)
			(pTrainDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 817 1)
	)
)

(instance trainDoorExitCode819 of Code
	(properties)

	(method (doit)
		(if (pTrainDoor cel:)
			(gGame handsOff:)
			(gMySoundFX number: 822 setLoop: 0 play:)
			(pTrainDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 819 1)
	)
)

(instance cExit811 of Code
	(properties)

	(method (doit)
		((ScriptID 19 0) seconds: 1) ; BombTimer
	)
)

(instance rGate of RobotPlayer
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 259)
			(approachX hotVerbs: 0)
		else
			(approachX hotVerbs: 88 5)
		)
		(self setNowSeen:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(88 ; invBoltCutter
				(if (or (IsFlag 27) (IsFlag 259))
					(super doVerb: theVerb &rest)
				else
					(pplGateLock init:)
				)
			)
			(5 ; Do
				(cond
					((IsFlag 259)
						(super doVerb: theVerb &rest)
					)
					((IsFlag 27)
						(gGame handsOff:)
						(approachX hotVerbs: 0)
						(SetFlag 259)
						(self caller: gCurRoom start: 1 10)
						(gMySoundFX do: 8431)
					)
					(else
						(pplGateLock init:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pplGateLock of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 826 0 0)
		(ppGateLock init: self 1 1)
		(global105 delete: (bitmap approachX:))
	)
)

(instance ppGateLock of PanelProp
	(properties
		y 1
		view 826
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 43 48 128 134 128 134 43
					yourself:
				)
		)
		(approachX hotVerbs: 88)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(88 ; invBoltCutter
				(if (IsFlag 27)
					(super doVerb: theVerb &rest)
				else
					(gGame handsOff:)
					(gInventory deleteItem: (ScriptID 9 80)) ; invBoltCutter
					(ClearFlag 261)
					(SetFlag 27)
					(gMySoundFX do: 821)
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
		(rGate init: 827 1 97 24 300)
		(pplGateLock dispose:)
	)
)

(instance vGate of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 811)
			(= view 811)
			(= x 198)
			(= y 137)
		else
			(= view 815)
			(= x 137)
			(= y 116)
		)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance moveDownLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 9)
		(self createPoly: -1 222 106 222 106 300 -1 300)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 9)
		(self setPolygon: 0 createPoly: -1 222 106 222 106 300 -1 300)
	)
)

(instance moveUpLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self createPoly: 39 59 229 59 229 190 39 190)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self createPoly: 39 59 229 59 229 190 39 190)
	)
)

(instance localSound of Sound ; UNUSED
	(properties)
)

