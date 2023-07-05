;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use LightRoom)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	local0
	local1 = 1
)

(instance rm720 of LightRoom
	(properties)

	(method (init)
		(SetFlag 9)
		(super init: &rest)
		(gGame handsOff:)
		(ClearFlag 9)
		(= local1 1)
		(roomMusic play:)
		(gBackMusic number: 705 loop: -1 setVol: 127 play:)
		(switch gPrevRoomNum
			(710
				(self changeScene: 728 3)
			)
			(740
				(self changeScene: 724 7)
			)
			(750
				(self changeScene: 732 16)
			)
			(else
				(self changeScene: 730 13)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(elevDoor724 dispose:)
		(door725 dispose:)
		(water730 dispose:)
		(door731 dispose:)
		(water732 dispose:)
		(door733 dispose:)
		(switch param1
			(724
				(elevDoor724 init: cycleSpeed: 12)
				(if (and local1 (== gPrevRoomNum 740))
					(roomSfx number: 775 play:)
				)
				((ScriptID 1 2) newPic: 734 3 exitCode: cExit724Back) ; exitBack
				((ScriptID 1 3) newPic: 726 9 exitCode: cExit724Left) ; exitLeft
				((ScriptID 1 4) newPic: 727 12 exitCode: cExit724Right) ; exitRight
			)
			(725
				(door725 init: cycleSpeed: 12)
				((ScriptID 1 2) newPic: 724 7 exitCode: cExit725Back) ; exitBack
			)
			(726
				((ScriptID 1 1) newPic: 731 2) ; exitForward
				((ScriptID 1 2) newPic: 727 12) ; exitBack
				((ScriptID 1 3) newPic: 734 3) ; exitLeft
				((ScriptID 1 4) newPic: 724 7) ; exitRight
			)
			(727
				((ScriptID 1 1) newPic: 733 4) ; exitForward
				((ScriptID 1 2) newPic: 726 9) ; exitBack
				((ScriptID 1 4) newPic: 734 3) ; exitRight
				((ScriptID 1 3) newPic: 724 7) ; exitLeft
			)
			(728
				(if local0
					(door728 init:)
					(gCurRoom setScript: sCloseDoor728)
				else
					(door728 init:)
					(gCurRoom setScript: sOpenDoor728)
				)
			)
			(730
				(if (and local1 (== gPrevRoomNum 770))
					(roomSfx number: 775 play:)
				)
				(water730 init:)
				((ScriptID 1 2) newPic: 731 2) ; exitBack
				((ScriptID 1 3) ; exitLeft
					newPic: 724 7
					arrowStyle: 8
					nsLeft: 123
					nsTop: 66
					nsRight: 238
					nsBottom: 210
				)
				((ScriptID 1 4) ; exitRight
					newPic: 727 12
					arrowStyle: 7
					nsLeft: 292
					nsTop: 88
					nsRight: 420
					nsBottom: 200
				)
			)
			(731
				(door731 init: cycleSpeed: 12)
				((ScriptID 1 2) newPic: 730 13 exitCode: cExit731Back) ; exitBack
			)
			(732
				(if (and local1 (== gPrevRoomNum 750))
					(roomSfx number: 775 play:)
				)
				(water732 init:)
				((ScriptID 1 2) newPic: 733 4) ; exitBack
				((ScriptID 1 3) ; exitLeft
					newPic: 726 9
					arrowStyle: 8
					nsLeft: 109
					nsTop: 95
					nsRight: 194
					nsBottom: 190
				)
				((ScriptID 1 4) ; exitRight
					newPic: 724 7
					arrowStyle: 7
					nsLeft: 254
					nsTop: 68
					nsRight: 428
					nsBottom: 210
				)
			)
			(733
				(door733 init: cycleSpeed: 12)
				((ScriptID 1 2) newPic: 732 16 exitCode: cExit733Back) ; exitBack
			)
			(734
				((ScriptID 1 1) newPic: 725 3) ; exitForward
				((ScriptID 1 3) newPic: 727 12) ; exitLeft
				((ScriptID 1 4) newPic: 726 9) ; exitRight
			)
		)
		(= local1 0)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(roomMusic stop:)
		(if (== newRoomNumber 710)
			(gBackMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance roomMusic of Sound
	(properties
		number 751
		loop -1
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance elevDoor724 of Prop
	(properties
		x 168
		y 272
		view 724
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((and (IsFlag 188) (IsFlag 145))
						(roomSfx number: 708 play:)
					)
					((not cel)
						(gGame handsOff:)
						(gCurRoom setScript: sOpenDoor)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 707 play:)
				(elevDoor724 setCycle: End self)
			)
			(1
				((ScriptID 1 1) newRoom: 710 exitCode: cExitElevator724) ; exitForward
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 707 play:)
				(elevDoor724 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(switch register
					(726
						(gCurRoom changeScene: register 9)
					)
					(727
						(gCurRoom changeScene: register 12)
					)
					(734
						(gCurRoom changeScene: register 3)
					)
				)
			)
		)
	)
)

(instance cExitElevator724 of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(= local0 1)
		(gCurRoom changeScene: 728 3)
	)
)

(instance cExit724Back of Code
	(properties)

	(method (doit)
		(if (elevDoor724 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor 0 734)
		else
			(gCurRoom changeScene: 734 3)
		)
	)
)

(instance cExit724Left of Code
	(properties)

	(method (doit)
		(if (elevDoor724 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor 0 726)
		else
			(gCurRoom changeScene: 726 9)
		)
	)
)

(instance cExit724Right of Code
	(properties)

	(method (doit)
		(if (elevDoor724 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor 0 727)
		else
			(gCurRoom changeScene: 727 12)
		)
	)
)

(instance cExit725Back of Code
	(properties)

	(method (doit)
		(if (door725 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor725 0 724)
		else
			(gCurRoom changeScene: 724 7)
		)
	)
)

(instance door725 of Prop
	(properties
		x 81
		y 299
		view 725
	)

	(method (init)
		(super init: &rest)
		(= cel 0)
		(if (and (== global236 740) (not (IsFlag 286)))
			(= view 2725)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (self cel:))
					(gGame handsOff:)
					(gCurRoom setScript: sOpenDoor725)
				)
			)
		)
	)
)

(instance sOpenDoor725 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door725 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				((ScriptID 1 1) newRoom: 740) ; exitForward
			)
		)
	)
)

(instance sCloseDoor725 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door725 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: 724 7)
			)
		)
	)
)

(instance door728 of Prop
	(properties
		x 113
		y 299
		view 728
	)

	(method (init)
		(super init: &rest)
		(if local0
			(self cel: (self lastCel:))
		)
	)
)

(instance sOpenDoor728 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 707 play:)
				(door728 setCycle: End self)
			)
			(1
				(door728 dispose:)
				(gGame handsOn:)
				((ScriptID 1 1) newPic: 734 3) ; exitForward
				(self dispose:)
			)
		)
	)
)

(instance sCloseDoor728 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 707 play:)
				(door728 setCycle: Beg self)
			)
			(1
				(door728 dispose:)
				(gCurRoom drawPic: -1)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD
					number: 2703
					holdLastFrame: 1
					stretch: 0
					doubled: 1
					dir: 1
					myBlackLines: 1
					init:
					play:
					close:
				)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(gGlobalVMD putOptions: 256 boostRGB: 0)
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance water730 of Prop
	(properties
		x -8
		y 253
		view 7300
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 45 setCycle: Rev)
	)
)

(instance cExit731Back of Code
	(properties)

	(method (doit)
		(if (door731 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor731 0 730)
		else
			(gCurRoom changeScene: 730 13)
		)
	)
)

(instance door731 of Prop
	(properties
		x 152
		y 299
		view 731
	)

	(method (init)
		(super init: &rest)
		(= cel 0)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (self cel:))
					(gGame handsOff:)
					(gCurRoom setScript: sOpenDoor731)
				)
			)
		)
	)
)

(instance sOpenDoor731 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door731 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				((ScriptID 1 1) newRoom: 770) ; exitForward
			)
		)
	)
)

(instance sCloseDoor731 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door731 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: 730 13)
			)
		)
	)
)

(instance water732 of Prop
	(properties
		x 411
		y 251
		view 7302
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 45 setCycle: Fwd)
	)
)

(instance cExit733Back of Code
	(properties)

	(method (doit)
		(if (door733 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor733 0 732)
		else
			(gCurRoom changeScene: 732 16)
		)
	)
)

(instance door733 of Prop
	(properties
		x 152
		y 299
		view 733
	)

	(method (init)
		(super init: &rest)
		(= cel 0)
		(if (and (== global236 750) (not (IsFlag 286)))
			(self view: 2726 x: 153)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (self cel:))
					(gGame handsOff:)
					(gCurRoom setScript: sOpenDoor733)
				)
			)
		)
	)
)

(instance sOpenDoor733 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door733 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				((ScriptID 1 1) newRoom: 750) ; exitForward
			)
		)
	)
)

(instance sCloseDoor733 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 775 play:)
				(door733 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: 732 16)
			)
		)
	)
)

