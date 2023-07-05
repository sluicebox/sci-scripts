;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm780 0
)

(local
	local0
	local1
)

(instance rm780 of LightRoom
	(properties)

	(method (init)
		(gGame handsOff:)
		(roomMusic setVol: 64 play:)
		(super init: &rest)
		(self changeScene: -1)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(plans792 dispose:)
		(box794 dispose:)
		(hatch796 dispose:)
		(lever796 dispose:)
		(leftHorn798 dispose:)
		(rightHorn798 dispose:)
		(boxOTubes798 dispose:)
		(boxOParts798 dispose:)
		(boxOBoxes798 dispose:)
		(plans798 dispose:)
		(switch param1
			(-1
				(gCurRoom setScript: sFromCentral)
			)
			(790
				((ScriptID 1 3) newPic: 796 3) ; exitLeft
				((ScriptID 1 4) newPic: 792 7) ; exitRight
				((ScriptID 1 2) newPic: 794 5) ; exitBack
			)
			(792
				(if (not (gInventory contains: (ScriptID 9 90))) ; invPlans
					(plans792 init:)
				)
				((ScriptID 1 3) newPic: 790 1) ; exitLeft
				((ScriptID 1 4) newPic: 794 5) ; exitRight
				((ScriptID 1 1) newPic: 798 7) ; exitForward
				((ScriptID 1 2) newPic: 796 3) ; exitBack
			)
			(794
				(if (not (IsFlag 310))
					(box794 init:)
				)
				((ScriptID 1 3) newPic: 792 7 exitCode: cExit794Left) ; exitLeft
				((ScriptID 1 4) newPic: 796 3 exitCode: cExit794Right) ; exitRight
				((ScriptID 1 2) newPic: 790 1 exitCode: cExit794Back) ; exitBack
			)
			(796
				(lever796 init:)
				(if (not (IsFlag 221))
					(hatch796 init:)
					((ScriptID 1 4) ; exitRight
						newPic: 790 1
						exitCode: cExit796Right
						nsLeft: 440
						nsTop: 0
						nsRight: 499
						nsBottom: 91
					)
				else
					((ScriptID 1 4) newPic: 790 1 exitCode: cExit796Right) ; exitRight
				)
				((ScriptID 1 3) newPic: 794 5 exitCode: cExit796Left) ; exitLeft
				((ScriptID 1 2) newPic: 792 7 exitCode: cExit796Back) ; exitBack
			)
			(798
				(if (not (gInventory contains: (ScriptID 9 90))) ; invPlans
					(plans798 init:)
				)
				(leftHorn798 init:)
				(rightHorn798 init:)
				(boxOTubes798 init:)
				(boxOParts798 init:)
				(boxOBoxes798 init:)
				((ScriptID 1 7) newPic: 792 7 exitCode: cExit798Back) ; exitBackUp
			)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(roomMusic fade: 0 10 7 1)
		(super newRoom: newRoomNumber)
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance roomMusic of Sound
	(properties
		number 702
		loop -1
	)
)

(instance sFromCentral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 796)
				(proc0_8 752)
				(self cue:)
			)
			(1
				(gCurRoom changeScene: 796 3)
				(self dispose:)
			)
		)
	)
)

(instance plans792 of View
	(properties
		x 186
		y 62
		view 789
	)
)

(instance box794 of Prop
	(properties
		x 338
		y 223
		view 786
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (self cel:)
					(gCurRoom setScript: sGetPowerSupply)
				else
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGetPowerSupply of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(box794 view: 787 x: 339 y: 231 setCycle: End self)
			)
			(1
				(box794 dispose:)
				(roomSfx number: 791 play:)
				(gInventory addItem: (ScriptID 9 60)) ; invPowerSupply
				(SetFlag 310)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 782 play:)
				(box794 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 782 play:)
				(box794 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: register)
			)
		)
	)
)

(instance cExit794Left of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: box794) (box794 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseBox 0 792)
		else
			(gCurRoom changeScene: 792 7)
		)
	)
)

(instance cExit794Right of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: box794) (box794 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseBox 0 796)
		else
			(gCurRoom changeScene: 796 3)
		)
	)
)

(instance cExit794Back of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: box794) (box794 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseBox 0 790)
		else
			(gCurRoom changeScene: 790)
		)
	)
)

(instance lever796 of Prop
	(properties
		x 204
		y 236
		view 758
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(roomSfx number: 777 play:)
				(gCurRoom setScript: sDoLever)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sDoLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lever796 setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance hatch796 of Prop
	(properties
		x 436
		y 145
		view 2749
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 475 89 492 89 501 103 501 174 439 171 444 99)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (self cel:)
					(gCurRoom setScript: sGetBoard)
				else
					(gCurRoom setScript: sOpenHatch)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGetBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 781 play:)
				(hatch796 loop: 1 setCycle: End self)
			)
			(1
				(hatch796 dispose:)
				(roomSfx number: 790 play:)
				(gInventory addItem: (ScriptID 9 56)) ; invCircuitBoard
				(SetFlag 221)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 781 play:)
				(hatch796 setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 781 play:)
				(hatch796 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: register)
			)
		)
	)
)

(instance cExit796Left of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: hatch796) (hatch796 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 794)
		else
			(gCurRoom changeScene: 794 5)
		)
	)
)

(instance cExit796Right of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: hatch796) (hatch796 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 790)
		else
			(gCurRoom changeScene: 790 1)
		)
	)
)

(instance cExit796Back of Code
	(properties)

	(method (doit)
		(if (and (gCast contains: hatch796) (hatch796 cel:))
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 792)
		else
			(gCurRoom changeScene: 792 7)
		)
	)
)

(instance plans798 of View
	(properties
		x 136
		y 55
		view 791
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory addItem: (ScriptID 9 90)) ; invPlans
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxOTubes798 of Feature
	(properties
		nsBottom 227
		nsLeft 36
		nsRight 136
		nsTop 182
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (gInventory contains: (ScriptID 9 49))) ; invMachineTube
						(not (IsFlag 200))
					)
					(roomSfx number: 794 play:)
					(gInventory addItem: (ScriptID 9 49)) ; invMachineTube
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxOParts798 of Feature
	(properties
		nsBottom 260
		nsLeft 290
		nsRight 374
		nsTop 187
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (gInventory contains: (ScriptID 9 48))) ; invMachinePart
						(not (IsFlag 201))
					)
					(roomSfx number: 792 play:)
					(gInventory addItem: (ScriptID 9 48)) ; invMachinePart
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxOBoxes798 of Feature
	(properties
		nsBottom 240
		nsLeft 403
		nsRight 496
		nsTop 187
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (gInventory contains: (ScriptID 9 50))) ; invMachineBox
						(not (IsFlag 201))
					)
					(roomSfx number: 793 play:)
					(gInventory addItem: (ScriptID 9 50)) ; invMachineBox
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cExit798Back of Code
	(properties)

	(method (doit)
		(if (or (gCast contains: leftCoord) (gCast contains: rightCoord))
			(gGame handsOff:)
			(gCurRoom setScript: sShutDownHorns)
		else
			(gCurRoom changeScene: 792 7)
		)
	)
)

(instance sShutDownHorns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(volcano setScript: sVolcanoOff)
				(if (and (gCast contains: leftCoord) (leftCoord cel:))
					(leftCoord setCycle: Beg self)
				else
					(= cycles 2)
				)
				(if (and (gCast contains: rightCoord) (rightCoord cel:))
					(rightCoord setCycle: Beg self)
				else
					(= ticks 20)
				)
				(= local0 0)
				(= local1 0)
			)
			(1 0)
			(2
				(leftCoord dispose:)
				(rightCoord dispose:)
				(= cycles 10)
			)
			(3
				(gCurRoom changeScene: 792 7)
				(self dispose:)
			)
		)
	)
)

(instance leftHorn798 of Prop
	(properties
		x 89
		y 154
		view 788
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: sPushLeftHorn)
				(if (gCast contains: leftCoord)
					(leftCoord dispose:)
					(gCurRoom setScript: sVolcanoOff)
					(= local0 0)
				else
					(leftCoord init:)
					(if (and local1 (not local0))
						(gCurRoom setScript: sVolcanoOn)
					)
					(= local0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPushLeftHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 710 play:)
				(leftHorn798 cel: 1)
				(= ticks 30)
			)
			(1
				(leftHorn798 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance rightHorn798 of Prop
	(properties
		x 107
		y 154
		loop 1
		view 788
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: sPushRightHorn)
				(if (gCast contains: rightCoord)
					(rightCoord dispose:)
					(gCurRoom setScript: sVolcanoOff)
					(= local1 0)
				else
					(rightCoord init:)
					(if (and local0 (not local1))
						(gCurRoom setScript: sVolcanoOn)
					)
					(= local1 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPushRightHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 710 play:)
				(rightHorn798 cel: 1)
				(= ticks 30)
			)
			(1
				(rightHorn798 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance leftCoord of Prop
	(properties
		x 153
		y 173
		loop 2
		view 788
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(self setCycle: End)
	)
)

(instance rightCoord of Prop
	(properties
		x 153
		y 173
		loop 3
		view 788
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(self setCycle: End)
	)
)

(instance volcano of Prop
	(properties
		x 197
		y 140
		loop 4
		view 788
	)
)

(instance sVolcanoOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 426)
				(volcano init: loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(volcano loop: 5 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance sVolcanoOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(volcano loop: 4)
				(volcano cel: (volcano lastCel:) setCycle: Beg self)
			)
			(1
				(volcano dispose:)
				(self dispose:)
			)
		)
	)
)

