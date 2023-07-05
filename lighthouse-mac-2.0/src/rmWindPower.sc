;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use rm400)
(use Polygon)
(use Feature)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rmWindPower 0
)

(local
	local0
	local1 = 630
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 &tmp temp0)
	(gBackMusic stop:)
	(beltSFX dispose:)
	(gearSFX dispose:)
	(if (gBackMusic handle:)
		(gBackMusic stop:)
	)
	(= temp0
		(switch (Random 0 2)
			(0 60101)
			(1 60102)
			(2 60103)
		)
	)
	(Load rsAUDIO temp0)
	(gBackMusic2 number: temp0 loop: -1 play: 0 0 fade: 127 25 10 0 0)
)

(procedure (localproc_1)
	(Load rsAUDIO 60002)
	(gBackMusic number: 60002 loop: -1 play: 0 0 fade: 127 25 10 0 0)
	(if (gBackMusic2 handle:)
		(gBackMusic2 stop:)
	)
	(if (localproc_2)
		(Load rsAUDIO (gearSFX number:))
		(gearSFX play: 70 0)
		(if (localproc_3)
			(Load rsAUDIO (beltSFX number:))
			(beltSFX play: 70 0)
		)
	)
)

(procedure (localproc_2)
	(return (and (IsFlag 249) (not (IsFlag 250))))
)

(procedure (localproc_3)
	(return (and (localproc_2) (IsFlag 251) (not (IsFlag 252))))
)

(instance rmWindPower of LightRoom
	(properties)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(gGame handsOn:)
		(if (not (IsFlag 249))
			(= local1 640)
		)
		(= local0 0)
		(= local4 0)
		(if (== gPrevRoomNum 680)
			(gGame handsOff:)
			(= local4 0)
			(= local0 1)
			(sndFX number: 60107 loop: 0 play: cueHitScr)
			(localproc_0)
			(gCurRoom changeScene: 3622)
		else
			(localproc_1)
			(gCurRoom changeScene: local1)
		)
	)

	(method (changeScene param1 &tmp temp0 temp1 temp2)
		(if (== scene 632)
			(Lock rsAUDIO 60115 0)
			(Lock rsAUDIO 60117 0)
		)
		(if (and (== scene 3620) local4)
			(self setScript: closeDoorScr 0 param1)
			(= local4 0)
			(return)
		)
		(if (gTimers contains: grindTimer)
			(grindTimer dispose:)
			(self setScript: disasterScr 0 param1)
			(return)
		)
		(= temp0 0)
		(forwardLeft dispose:)
		(forwardRight dispose:)
		(forward dispose:)
		(down dispose:)
		(fanRbt dispose:)
		(waterRbt dispose:)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(= temp2 scene)
		(super changeScene: param1)
		(cond
			((not (gearSFX handle:)) 0)
			((== scene 631)
				(gearSFX setVol: 127)
			)
			(else
				(gearSFX setVol: 70)
			)
		)
		(cond
			((not (beltSFX handle:)) 0)
			((== scene 631)
				(beltSFX setVol: 127)
			)
			(else
				(beltSFX setVol: 70)
			)
		)
		(switch scene
			(local1
				(proc400_1 16)
				(forward
					nsLeft: 263
					nsTop: 34
					nsRight: 382
					nsBottom: 203
					newPic: 632
				)
				(forwardLeft
					nsLeft: 50
					nsTop: 56
					nsRight: 207
					nsBottom: 229
					newPic: 631
				)
				((ScriptID 1 2) newPic: 633) ; exitBack
			)
			(631
				(proc400_1 2)
				((ScriptID 1 4) newPic: 632) ; exitRight
				((ScriptID 1 3) newPic: 633) ; exitLeft
				(leverFtr init:)
				(if (IsFlag 252)
					(armFtr init:)
				)
				(if (IsFlag 251)
					(lever init: cel: (lever lastCel:))
					(if (and (IsFlag 249) (not (IsFlag 250)))
						(engine init: setCycle: Fwd)
						(= temp0 1)
					else
						(arm init: cel: (arm lastCel:))
					)
				)
				(if (and (not temp0) (not (IsFlag 250)) (IsFlag 249))
					(gear init: setCycle: Fwd)
				)
			)
			(632
				(proc400_1 8)
				((ScriptID 1 2) newPic: 633) ; exitBack
				((ScriptID 1 3) newPic: 631) ; exitLeft
				(if (not (IsFlag 249))
					(fanRbt init: 5642 0 4 0 500)
				)
				(Lock rsAUDIO 60115 1)
				(Lock rsAUDIO 60117 1)
				(crankFtr init:)
				(crank init:)
				(crankShadow init:)
				(brake init:)
			)
			(633
				(proc400_1 11)
				((ScriptID 1 2) newPic: (if (== temp2 local1) local1 else 632)) ; exitBack
				((ScriptID 1 4) newPic: 631) ; exitRight
				(forwardRight
					nsLeft: 335
					nsTop: 50
					nsRight: 459
					nsBottom: 177
					newPic: 635
				)
				(forwardLeft
					nsLeft: 111
					nsTop: 48
					nsRight: 235
					nsBottom: 225
					newRoom: 610 ; rmWoodshop
				)
			)
			(635
				(proc400_1 3)
				((ScriptID 1 3) newPic: local1) ; exitLeft
				(if local0
					(up init:)
				)
				(trapDoor init:)
			)
			(3622
				(proc400_1 5)
				((ScriptID 1 2) newPic: 3620) ; exitBack
				((ScriptID 1 4) newPic: 692) ; exitRight
				((ScriptID 1 3) newPic: 688) ; exitLeft
				(down
					nsLeft: 234
					nsTop: 64
					nsRight: 296
					nsBottom: 151
					exitCode: fromRoofCode
					init:
				)
				(waterRbt init: 3622 0 0 0 -1 start: 1 10 1)
			)
			(3620
				(proc400_1 1)
				((ScriptID 1 2) newPic: 3622) ; exitBack
				((ScriptID 1 4) newPic: 688) ; exitRight
				((ScriptID 1 3) newPic: 692) ; exitLeft
				(door3620 init:)
				(if local4
					(forwardDoor init:)
				)
			)
			(688
				(proc400_1 7)
				((ScriptID 1 3) newPic: 3620) ; exitLeft
				((ScriptID 1 4) newPic: 3622) ; exitRight
				(if (IsFlag 249)
					(fan688 init:)
				)
			)
			(692
				(proc400_1 3)
				((ScriptID 1 3) newPic: 3622) ; exitLeft
				((ScriptID 1 4) newPic: 3620) ; exitRight
				(water692 init:)
			)
		)
	)

	(method (cue)
		(self setScript: disasterScr 0 0)
	)

	(method (newRoom)
		(if (gBackMusic handle:)
			(gBackMusic fade:)
		)
		(if (gBackMusic2 handle:)
			(gBackMusic2 fade:)
		)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (== scene 632)
			(Lock rsAUDIO 60115 0)
			(Lock rsAUDIO 60117 0)
		)
		(gearSFX dispose:)
		(beltSFX dispose:)
		(super dispose: &rest)
	)
)

(instance toRoofCode of Code
	(properties)

	(method (doit)
		(gCurRoom changeScene: 3620)
		(localproc_0)
	)
)

(instance fromRoofCode of Code
	(properties)

	(method (doit)
		(gCurRoom changeScene: 635)
		(localproc_1)
	)
)

(instance fanRbt of RobotPlayer
	(properties)
)

(instance trapDoor of Prop
	(properties
		x 200
		y 83
		view 3644
	)

	(method (init)
		(super init: &rest)
		(= cel
			(if local0
				(self lastCel:)
			else
				0
			)
		)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(if (not cel)
			(sndFX number: 60108 loop: 0 play:)
		)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(sndFX number: 60107 loop: 0 play:)
			(if local0
				(gGame handsOff:)
				(up dispose:)
				(= local0 0)
				(self setCycle: Beg self)
			else
				(gGame handsOff:)
				(up init:)
				(= local0 1)
				(self setCycle: End self)
			)
		)
	)
)

(instance forwardRight of ExitFeature
	(properties
		arrowStyle 7
	)
)

(instance forward of ExitFeature
	(properties)
)

(instance forwardDoor of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 234 249 97 263 77 198 77 194 250 315 249 312 74 290 74 288 238
					yourself:
				)
			nextRoomNum: 680
		)
		(super init: &rest)
	)
)

(instance down of ExitFeature
	(properties
		arrowStyle 6
	)
)

(instance forwardLeft of ExitFeature
	(properties
		arrowStyle 8
	)
)

(instance up of ExitFeature
	(properties
		nsLeft 182
		nsTop 87
		nsRight 324
		nsBottom 296
		arrowStyle 5
	)

	(method (init)
		(super init: &rest)
		(self exitCode: toRoofCode)
	)
)

(instance crankFtr of Feature
	(properties
		nsLeft 218
		nsTop 148
		nsRight 257
		nsBottom 215
	)

	(method (handleEvent event)
		(cond
			((and local2 (not (& (event type:) evMOUSERELEASE)))
				(event claimed: 1)
				(return)
			)
			(local2
				(= local2 0)
				(gPanels delete: self)
				(gCurRoom setScript: fanFallScr)
				(event claimed: 1)
				(return)
			)
			((and (self onMe: event) (not (event claimed:)))
				(cond
					((not (IsFlag 249))
						(if (not gPanels)
							(= gPanels (Set new:))
						)
						(gPanels add: self)
						(gCurRoom setScript: crankScr)
						(event claimed: (= local3 (= local2 1)))
						(return)
					)
					((and (== (event message:) JOY_DOWN) (IsFlag 250))
						(gPanels delete: self)
						(gCurRoom setScript: dropFanScr)
					)
				)
			)
		)
	)
)

(instance crank of Prop
	(properties
		x 185
		y 290
		view 3642
	)

	(method (init)
		(super init: &rest)
		(self setPri: 501)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance crankShadow of Prop
	(properties
		x 185
		y 290
		view 3642
		loop 1
	)

	(method (handleEvent)
		(return 0)
	)

	(method (doit)
		(if local3
			(= cel (crank cel:))
		)
		(super doit: &rest)
	)
)

(instance brake of Prop
	(properties
		x 281
		y 178
		view 3642
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 250)
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(&= signal $efff)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
		(if (gearSFX handle:)
			(gearSFX dispose:)
		)
		(if (beltSFX handle:)
			(beltSFX dispose:)
		)
	)

	(method (doVerb)
		(cond
			((not (IsFlag 249))
				(gCurRoom setScript: brakeFailScr)
			)
			((IsFlag 250)
				(gCurRoom setScript: releaseBrakeScr)
			)
			(else
				(gGame handsOff:)
				(sndFX number: 60117 loop: 1 play:)
				(SetFlag 250)
				(self setCycle: End self)
			)
		)
	)
)

(instance shadowBrake of Prop
	(properties
		x 283
		y 186
		view 3642
		loop 3
	)
)

(instance engine of Prop
	(properties
		x 90
		y 241
		view 3641
	)
)

(instance gear of Prop
	(properties
		x 378
		y 240
		view 3640
	)
)

(instance lever of Prop
	(properties
		x 1
		y 225
		view 3640
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 500)
	)
)

(instance arm of Prop
	(properties
		x 340
		y 140
		view 3640
		loop 2
	)
)

(instance grind of Prop
	(properties
		x 336
		y 240
		view 3640
		loop 3
	)
)

(instance disaster of Prop
	(properties
		x 333
		y 211
		view 3640
		loop 4
	)
)

(instance door3620 of Prop
	(properties
		x 210
		y 240
		view 4620
	)

	(method (init)
		(= cel
			(if local4
				(self lastCel:)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (= local4 (not local4))
				(gGame handsOff:)
				(Load rsAUDIO 60107)
				(sndFX number: 60107 loop: 0 play:)
				(forwardDoor init:)
				(self setCycle: End self)
			else
				(forwardDoor dispose:)
				(self setScript: closeDoorScr)
			)
		)
	)
)

(instance leverFtr of Feature
	(properties
		nsLeft 115
		nsTop 78
		nsRight 160
		nsBottom 146
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((IsFlag 252)
					(gCurRoom setScript: armFailScr)
				)
				((IsFlag 251)
					(gCurRoom setScript: armBackScr)
				)
				((and (IsFlag 249) (not (IsFlag 250)))
					(gCurRoom setScript: armOutGrindScr)
				)
				(else
					(gCurRoom setScript: armOutScr)
				)
			)
		)
	)
)

(instance armBackScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60110)
				(sndFX loop: 0 number: 60110 play: self)
				(lever setCycle: Beg self)
			)
			(1 0)
			(2
				(lever dispose:)
				(if (gCast contains: grind)
					(grindTimer dispose:)
					(grind dispose:)
					(grindSFX dispose:)
				)
				(if (gCast contains: engine)
					(engine dispose:)
					(gear init: setCycle: Fwd)
				)
				(arm init: cel: (arm lastCel:))
				(= cycles 1)
			)
			(3
				(arm setCycle: Beg self)
				(beltSFX dispose:)
				(Load rsAUDIO 60111)
				(sndFX number: 60111 play: self)
			)
			(4 0)
			(5
				(ClearFlag 251)
				(if (and (IsFlag 249) (not (IsFlag 250)))
					(grindTimer dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance armOutGrindScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever init: cel: 0 setCycle: End self)
				(Load rsAUDIO 60110)
				(sndFX loop: 0 number: 60110 play: self)
			)
			(1 0)
			(2
				(arm init: cel: 0 setCycle: End self)
				(Load rsAUDIO 60111)
				(sndFX number: 60111 play: self)
			)
			(3 0)
			(4
				(SetFlag 251)
				(gGame handsOn:)
				(arm dispose:)
				(grind init: setCycle: Fwd)
				(grindSFX play:)
				(grindTimer setReal: gCurRoom 7)
				(self dispose:)
			)
		)
	)
)

(instance armOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60110)
				(sndFX loop: 0 number: 60110 play: self)
				(lever init: cel: 0 setCycle: End self)
			)
			(1 0)
			(2
				(Load rsAUDIO 60111)
				(sndFX number: 60111 play: self)
				(arm init: cel: 0 setCycle: End self)
			)
			(3 0)
			(4
				(SetFlag 251)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance armFailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60110)
				(sndFX loop: 0 number: 60110 play: self)
				(lever init: setCycle: End self)
			)
			(1 0)
			(2
				(sndFX loop: 0 number: 60110 play: self)
				(lever setCycle: Beg self)
			)
			(3 0)
			(4
				(lever dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance armFtr of Feature
	(properties
		nsLeft 340
		nsTop 98
		nsRight 436
		nsBottom 150
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 74)
	)

	(method (doVerb theVerb)
		(if (== theVerb 74) ; invWindGear
			(gCurRoom setScript: replaceArmScr)
		)
	)
)

(instance fanFallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sndFX stop:)
				(crank setCycle: 0)
				(= cycles 2)
			)
			(1
				(sndFX play:)
				(crank setCycle: Rev)
				(fanRbt caller: self playDir: 64969)
			)
			(2
				(sndFX stop:)
				(= local3 0)
				(crank setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crankScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 60115)
				(sndFX number: 60115 loop: -1 play:)
				(crank setCycle: Fwd)
				(fanRbt caller: self cycleTo: 32 1 10)
			)
			(1
				(gGame handsOff:)
				(= local2 0)
				(gPanels delete: crankFtr)
				(global206 delete: crankFtr)
				(fanRbt caller: self start: 1 10 0)
			)
			(2
				(sndFX stop:)
				(proc0_8 638)
				(= cycles 1)
			)
			(3
				(= local1 630)
				(crank setCycle: 0)
				(= local3 0)
				(fanRbt dispose:)
				(gGame handsOn:)
				(SetFlag 249)
				(self dispose:)
			)
		)
	)
)

(instance disasterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(grind dispose:)
				(grindSFX dispose:)
				(Load rsAUDIO 60113)
				(sndFX number: 60113 loop: 1 play: self)
				(disaster init: cel: 0 setCycle: End self)
			)
			(1 0)
			(2
				(disaster dispose:)
				(Load rsAUDIO 60110)
				(sndFX loop: 0 number: 60110 play: self)
				(lever setCycle: Beg self)
			)
			(3
				(lever dispose:)
				(ClearFlag 251)
				(SetFlag 252)
				(armFtr init:)
				(gGame handsOn:)
				(self dispose:)
				(if register
					(gCurRoom changeScene: register)
				)
			)
		)
	)
)

(instance brakeFailScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shadowBrake init: cel: (shadowBrake lastCel:) setPri: 505)
				(= cycles 1)
			)
			(1
				(sndFX number: 60117 loop: 1 play: self)
				(shadowBrake setCycle: Beg self)
			)
			(2 0)
			(3
				(sndFX number: 60117 loop: 1 play: self)
				(shadowBrake setCycle: End self)
			)
			(4 0)
			(5
				(shadowBrake dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance disaster631Scr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(brake setCycle: Beg self)
			)
			(1
				(SetFlag 250)
				(ClearFlag 251)
				(SetFlag 252)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance brakeOnScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(brake setCycle: End self)
			)
			(1
				(SetFlag 250)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance releaseBrakeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sndFX number: 60117 loop: 1 play:)
				(brake setCycle: Beg self)
			)
			(1
				(SetFlag 317)
				(Lock 151 639 1) ; VMD
				(proc0_8 639)
				(Lock 151 639 0) ; VMD
				(= cycles 1)
			)
			(2
				(Load rsAUDIO (gearSFX number:))
				(gearSFX play: 70 0)
				(if (and (IsFlag 251) (not (IsFlag 252)))
					(Load rsAUDIO (beltSFX number:))
					(beltSFX play: 70 0)
				)
				(ClearFlag 250)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dropFanScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(crank setCycle: Rev)
				(= local3 1)
				(= ticks 5)
			)
			(1
				(proc0_8 640)
				(= cycles 1)
			)
			(2
				(Load rsAUDIO 60115)
				(sndFX number: 60115 loop: -1 play:)
				(fanRbt init: 5642 50 4 0 500 caller: self start: 64969 10 0)
			)
			(3
				(sndFX stop:)
				(= local1 640)
				(ClearFlag 249)
				(crank setCycle: 0)
				(= local3 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance replaceArmScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60111)
				(gInventory deleteItem: (ScriptID 9 74)) ; invWindGear
				(arm init: cel: (arm lastCel:) setCycle: Beg self)
				(sndFX number: 60111 loop: 0 play: self)
			)
			(1 0)
			(2
				(ClearFlag 252)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance grindTimer of Timer
	(properties)
)

(instance waterRbt of RobotPlayer
	(properties)
)

(instance gearSFX of Sound
	(properties
		number 60109
		loop -1
	)
)

(instance beltSFX of Sound
	(properties
		number 60114
		loop -1
	)
)

(instance sndFX of Sound
	(properties)
)

(instance grindSFX of Sound
	(properties
		number 60112
		loop -1
	)
)

(instance closeDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60107 60108)
				(door3620 setCycle: Beg self)
				(sndFX number: 60107 loop: 0 play:)
			)
			(1
				(sndFX number: 60108 loop: 0 play: 127 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
				(if register
					(gCurRoom changeScene: register)
					(= register 0)
				)
			)
		)
	)
)

(instance fan688 of Prop
	(properties
		view 688
	)

	(method (init)
		(if (IsFlag 250)
			(self loop: 0 posn: 119 189)
		else
			(self loop: 1 posn: 119 186 setCycle: Fwd)
		)
		(super init: &rest)
	)
)

(instance water692 of Prop
	(properties
		x 207
		y 224
		view 692
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance cueHitScr of Script
	(properties)

	(method (cue)
		(sndFX number: 60108 loop: 0 play:)
		(gGame handsOn:)
	)
)

