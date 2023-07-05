;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use LightRoom)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	local0
)

(instance rm710 of LightRoom
	(properties)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(waveSound play:)
		(roomMusic play:)
		(= local0 1)
		(switch gPrevRoomNum
			(720
				(self changeScene: 708 7)
			)
			(760
				(self changeScene: 702 7)
			)
			(500
				(self changeScene: 706 9)
			)
			(else
				(self changeScene: 706 9)
			)
		)
	)

	(method (notify)
		(switch scene
			(704
				(bat704 init:)
			)
			(705
				(bat705 init:)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(pLid dispose:)
		(pSpringLatch dispose:)
		(pSpringHandle dispose:)
		(pNeedle dispose:)
		(fLidHandle dispose:)
		(shell702 dispose:)
		(bat704 dispose:)
		(bat705 dispose:)
		(door707 dispose:)
		(switch param1
			(-1
				(gGame handsOff:)
				(gCurRoom setScript: sUpElevator)
			)
			(256
				(gGame handsOff:)
				(pLid init: setPri: 1 setCel: 11 setScript: sEnterCockpit)
				(pSpringHandle init:)
				(pSpringLatch
					init:
					setCel: 8
					setPri: (+ (pSpringHandle priority:) 1)
				)
				(pNeedle init: setCel: 6)
				(fLidHandle init:)
			)
			(701
				((ScriptID 1 1) newPic: 707 3) ; exitForward
				((ScriptID 1 3) newPic: 704 5) ; exitLeft
				((ScriptID 1 4) newPic: 703 1) ; exitRight
				((ScriptID 1 2) newPic: 702 7) ; exitBack
			)
			(702
				(if (not (IsFlag 415))
					(shell702 init:)
				)
				((ScriptID 1 2) newPic: 701 3) ; exitBack
				((ScriptID 1 3) newPic: 703 1) ; exitLeft
				((ScriptID 1 4) newPic: 704 5) ; exitRight
			)
			(703
				((ScriptID 1 2) newPic: 704 5) ; exitBack
				((ScriptID 1 3) newPic: 701 3) ; exitLeft
				((ScriptID 1 4) newPic: 702 7) ; exitRight
			)
			(704
				(if (== global232 710)
					(bat704 init:)
				)
				((ScriptID 1 2) newPic: 703 1) ; exitBack
				((ScriptID 1 1) newPic: 705 7 arrowStyle: 1) ; exitForward
				((ScriptID 1 3) newPic: 702 7) ; exitLeft
				((ScriptID 1 4) newPic: 701 3) ; exitRight
			)
			(705
				(if (== global232 710)
					(bat705 init:)
				)
				(if (not local0)
					(waveSound play:)
					(roomMusic play:)
					(= local0 1)
				)
				((ScriptID 1 3) newPic: 706 9) ; exitLeft
			)
			(706
				((ScriptID 1 1) ; exitForward
					newPic: 703 1
					nsLeft: 127
					nsTop: 54
					nsRight: 381
					nsBottom: 210
				)
				((ScriptID 1 4) newPic: 705 7) ; exitRight
			)
			(707
				(door707 init:)
				((ScriptID 1 7) newPic: 701 3 exitCode: cExit707) ; exitBackUp
			)
			(708
				((ScriptID 1 1) newPic: 702 7) ; exitForward
				(proc0_8 2706)
				(if (not local0)
					(waveSound play:)
					(roomMusic play:)
					(= local0 1)
				)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(roomMusic stop:)
		(waveSound stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance batLatchSound of Sound
	(properties
		number 45013
	)
)

(instance waveSound of Sound
	(properties
		number 704
		loop -1
	)
)

(instance roomMusic of Sound
	(properties
		number 750
		loop -1
	)
)

(instance pLid of Prop
	(properties
		y 187
		loop 3
		view 3256
	)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom changeScene: 705 7)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)
)

(instance pSpringLatch of Prop
	(properties
		x 45
		y 171
		view 3256
	)
)

(instance pSpringHandle of Prop
	(properties
		x 45
		y 171
		loop 1
		view 3256
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(= global232 500)
		(gCurRoom drawPic: 0)
		(self hide:)
		(pLid hide:)
		(pNeedle hide:)
		(pSpringLatch hide:)
		(waveSound stop:)
		(roomMusic stop:)
		(FrameOut)
		(gInventory disable: 1)
		(PlayVMD 0 {6516.vmd} 1024) ; Open
		(PlayVMD 1 73 75 276 5 0 236) ; Put
		(PlayVMD 21 0 0 640 480) ; Black
		(PlayVMD 14 7) ; WaitEvent
		(PlayVMD 6) ; Close
		(gInventory disable: 0)
		(= global224 2)
		(= global225 500)
		(gGame getDisc: global224)
		(gCurRoom newRoom: global225)
	)

	(method (doVerb)
		(gGame handsOff:)
		(batLatchSound number: 45013 setLoop: 1 play:)
		(self setPri: (+ (pSpringLatch priority:) 1) setCycle: End self)
	)
)

(instance pNeedle of Prop
	(properties
		x 45
		y 171
		loop 2
		view 3256
	)
)

(instance fLidHandle of Feature
	(properties
		x 262
		y 154
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(roomSfx number: 45010 play:)
				(pLid setCel: 0 setCycle: End pLid)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 136 274 136 272 172 252 172
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sEnterCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 45011 play:)
				(pLid setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shell702 of View
	(properties
		x 89
		y 192
		view 702
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory addItem: (ScriptID 9 88)) ; invShell
				(SetFlag 415)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bat704 of View
	(properties
		y 140
		view 704
	)
)

(instance bat705 of View
	(properties
		x 251
		y 234
		view 705
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sFadeSound705)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFadeSound705 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gCurRoom changeScene: 256 5)
				(self dispose:)
			)
		)
	)
)

(instance door707 of Prop
	(properties
		x 164
		y 299
		view 707
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not cel)
					(gGame handsOff:)
					(gCurRoom setScript: sOpenDoor)
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
				(door707 setCycle: End self)
			)
			(1
				((ScriptID 1 1) newRoom: 720 exitCode: cExitElevator707) ; exitForward
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
				(door707 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: 701 3)
			)
		)
	)
)

(instance cExit707 of Code
	(properties)

	(method (doit)
		(if (door707 cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseDoor)
		else
			(gCurRoom changeScene: 701 3)
		)
	)
)

(instance cExitElevator707 of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gCurRoom changeScene: -1 7)
	)
)

(instance sUpElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD number: 2705 holdLastFrame: 1 init: play: close:)
				(gGlobalVMD
					number: 2702
					stretch: 0
					doubled: 1
					myBlackLines: 1
					init:
					play:
					close:
				)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(gGlobalVMD holdLastFrame: 0 putOptions: 256 boostRGB: 0)
				(gCurRoom newRoom: 720)
			)
		)
	)
)

