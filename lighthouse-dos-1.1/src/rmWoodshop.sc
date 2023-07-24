;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use rm400)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rmWoodshop 0
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
)

(procedure (localproc_0)
	(if (not (gInventory contains: (ScriptID 9 71))) ; invSmallPlanks
		(gInventory addItem: ((ScriptID 9 71) cel: 0 yourself:)) ; invSmallPlanks
	else
		((ScriptID 9 71) cel: (+ ((ScriptID 9 71) cel:) 1)) ; invSmallPlanks, invSmallPlanks
	)
)

(procedure (localproc_1)
	(if (not (gInventory contains: (ScriptID 9 72))) ; invLargePlanks
		(gInventory addItem: (ScriptID 9 72)) ; invLargePlanks
	else
		((ScriptID 9 72) cel: (+ ((ScriptID 9 72) cel:) 1)) ; invLargePlanks, invLargePlanks
	)
)

(procedure (localproc_2)
	(return
		(and
			(IsFlag 249)
			(IsFlag 251)
			(not (IsFlag 252))
			(not (IsFlag 250))
		)
	)
)

(instance rmWoodshop of LightRoom
	(properties)

	(method (init &tmp temp0 temp1)
		(= temp1 (if (Random 0 1) 60002 else 60200))
		(Load rsAUDIO temp1)
		(gBackMusic number: temp1 loop: -1 play: 0 fade: 127 25 10 0 0)
		(SetFlag 246)
		(if (IsFlag 300)
			(if (not (localproc_2))
				(ClearFlag 300)
			else
				(Load rsAUDIO (beltSFX number:))
				(beltSFX loop: -1 play: 0 0)
			)
		)
		(super init: &rest)
		(gGame handsOn:)
		(self
			changeScene:
				(switch gPrevRoomNum
					(600
						(doorCloseSound play:)
						611
					)
					(650
						(= local0 1)
						(waterGateTimer setReal: self 60)
						3652
					)
					(630 621) ; rmWindPower
					(else 615)
				)
		)
	)

	(method (cue)
		(= local0 0)
	)

	(method (changeScene param1)
		(if (and (== scene 615) (door615 cel:))
			(self setScript: closeDoorScr 0 param1)
			(return)
		)
		(forwardLeft dispose:)
		(forwardRight dispose:)
		(forward dispose:)
		(forward1 dispose:)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(if (and (== scene 618) (!= param1 619))
			(= local1 0)
		)
		(if (and (== param1 618) (!= scene 619))
			(lookOutside doit:)
		)
		(if (and local2 (OneOf param1 618 619 620))
			(showMonsterCode doit:)
		)
		(if (beltSFX handle:)
			(switch param1
				(612
					(beltSFX setVol: 110)
				)
				(613
					(beltSFX setVol: 127)
				)
				(else
					(beltSFX setVol: 101)
				)
			)
		)
		(if (monsterSFX handle:)
			(cond
				((== param1 618)
					(monsterSFX setVol: 90)
				)
				((OneOf param1 619 620)
					(monsterSFX setVol: 127)
				)
			)
		)
		(if (and (gBackMusic2 handle:) (not (OneOf param1 619 620 618)))
			(gBackMusic2 fade:)
			(if (not (gBackMusic handle:))
				(gBackMusic play: 0 0)
			)
			(gBackMusic fade: 127 25 10 0 0)
		)
		(super changeScene: param1 &rest)
		(switch param1
			(611
				(proc400_1 9)
				(forwardLeft
					nsLeft: 127
					nsTop: 69
					nsRight: 247
					nsBottom: 202
					newPic: 612
				)
				(forward
					nsLeft: 269
					nsTop: 61
					nsRight: 408
					nsBottom: 236
					newPic: 613
				)
				((ScriptID 1 2) newPic: 615) ; exitBack
			)
			(612
				(proc400_1 2)
				((ScriptID 1 2) newPic: 615) ; exitBack
				(forwardLeft
					nsLeft: 5
					nsTop: 27
					nsRight: 150
					nsBottom: 135
					newPic: 618
				)
				(forward
					nsLeft: 204
					nsTop: 56
					nsRight: 287
					nsBottom: 231
					newRoom: 630 ; rmWindPower
				)
				(forwardRight
					nsLeft: 324
					nsTop: 53
					nsRight: 495
					nsBottom: 251
					newPic: 613
				)
				((ScriptID 1 3) newPic: 617) ; exitLeft
				(if (IsFlag 300)
					(sawHead init: setCycle: Fwd)
				)
			)
			(613
				(proc400_1 8)
				((ScriptID 1 3) newPic: 612) ; exitLeft
				((ScriptID 1 4) newPic: 614) ; exitRight
				((ScriptID 1 2) newPic: 615) ; exitBack
				(leverFtr613 init:)
				(lever613 init:)
				(plank613 init:)
				(saw613 init:)
				(belt613 init:)
			)
			(614
				(proc400_1 7)
				(windPowerGear init:)
				((ScriptID 1 3) newPic: 613) ; exitLeft
				((ScriptID 1 4) newPic: 615) ; exitRight
			)
			(615
				(proc400_1 6)
				(door615 init:)
				((ScriptID 1 3) newPic: 614) ; exitLeft
				((ScriptID 1 4) newPic: 616) ; exitRight
				((ScriptID 1 2) newPic: 612) ; exitBack
			)
			(616
				(proc400_1 4)
				(lever616 init:)
				(saw616 init:)
				(boards616 init:)
				(planks616 init:)
				((ScriptID 1 3) newPic: 615) ; exitLeft
				((ScriptID 1 4) newPic: 617) ; exitRight
				((ScriptID 1 2) newPic: 612) ; exitBack
			)
			(617
				(proc400_1 3)
				((ScriptID 1 3) newPic: 616) ; exitLeft
				((ScriptID 1 4) newPic: 612) ; exitRight
				((ScriptID 1 2) newPic: 3652) ; exitBack
				(forward
					nsLeft: 178
					nsTop: 23
					nsRight: 290
					nsBottom: 262
					newRoom: 650
				)
			)
			(618
				(proc400_1 10)
				((ScriptID 1 1) exitCode: lookOutside init:) ; exitForward
				((ScriptID 1 7) newPic: 612) ; exitBackUp
			)
			(619
				(proc400_1 2)
				(down
					nsLeft: 90
					nsTop: 200
					nsRight: 430
					nsBottom: 275
					newPic: 620
				)
				(myBackUp
					nsLeft: 90
					nsTop: 276
					nsRight: 430
					nsBottom: 300
					newPic: 618
				)
			)
			(620
				(proc400_1 2)
				(water620 init:)
				((ScriptID 1 6) newPic: 619) ; exitUp
				((ScriptID 1 7) newPic: 618) ; exitBackUp
			)
			(621
				(proc400_1 13)
				(forward
					nsLeft: 207
					nsTop: 61
					nsRight: 246
					nsBottom: 152
					newPic: 615
				)
				(forwardRight
					nsLeft: 415
					nsTop: 91
					nsRight: 494
					nsBottom: 262
					newPic: 617
				)
				(forward1
					nsLeft: 299
					nsTop: 6
					nsRight: 423
					nsBottom: 198
					newPic: 616
				)
				(forwardLeft
					nsLeft: 1
					nsTop: 47
					nsRight: 157
					nsBottom: 235
					newPic: 614
				)
				((ScriptID 1 2) newRoom: 630) ; exitBack, rmWindPower
			)
			(3652
				(proc400_1 7)
				((ScriptID 1 2) newPic: 617) ; exitBack
				(forward
					nsLeft: 120
					nsTop: 34
					nsRight: 223
					nsBottom: 207
					newPic: 614
				)
				(forward1
					nsLeft: 298
					nsTop: 33
					nsRight: 404
					nsBottom: 207
					newPic: 614
				)
				(forwardRight
					nsLeft: 418
					nsTop: 39
					nsRight: 482
					nsBottom: 210
					newPic: 615
				)
				(forwardLeft
					nsLeft: 0
					nsTop: 24
					nsRight: 123
					nsBottom: 240
					newPic: 613
				)
			)
		)
		(if (not (OneOf param1 618 619 620))
			(monsterRbt caller: 0 dispose:)
			(monsterSFX dispose:)
		)
		(if (gTheDoits contains: monsterRbt)
			(cond
				((not (OneOf param1 618 619 620)) 0)
				((and local4 (!= local4 param1))
					(monsterRbt x: 1000 y: 1000)
					(Robot 1 (monsterRbt curFrame:) 1000 1000) ; DisplayFrame
				)
				(local4
					(monsterRbt x: local5 y: local6)
					(Robot 1 (monsterRbt curFrame:) local5 local6) ; DisplayFrame
				)
			)
		)
	)

	(method (dispose)
		(if (beltSFX handle:)
			(beltSFX dispose:)
		)
		(if (gBackMusic handle:)
			(gBackMusic fade:)
		)
		(if (gBackMusic2 handle:)
			(gBackMusic2 stop:)
		)
		(if (gTimers contains: waterGateTimer)
			(gTimers delete: waterGateTimer)
			(waterGateTimer dispose:)
		)
		(super dispose: &rest)
	)
)

(instance saw613 of Prop
	(properties
		x 60
		y 140
		view 613
	)

	(method (init)
		(if (IsFlag 300)
			(self loop: 3 setCycle: Fwd)
		else
			(self loop: 2 cel: 0)
		)
		(super init: &rest)
	)
)

(instance leverFtr613 of Feature
	(properties
		nsBottom 221
		nsLeft 175
		nsRight 218
		nsTop 186
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((not (localproc_2))
					(gCurRoom setScript: failSawScr)
				)
				((IsFlag 300)
					(gCurRoom setScript: stopSawScr)
				)
				(else
					(gCurRoom setScript: startSawScr)
				)
			)
		)
	)
)

(instance belt613 of Prop
	(properties
		x 232
		y 105
		loop 1
		view 613
	)

	(method (init)
		(if (IsFlag 300)
			(self setCycle: Fwd)
		)
		(super init: &rest)
	)
)

(instance plank613 of View
	(properties
		x 140
		y 134
		view 613
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(IsFlag 300)
				(!= global239 6)
				(not
					(and
						(>= ((ScriptID 9 72) cel:) 1) ; invLargePlanks
						(gInventory contains: (ScriptID 9 72)) ; invLargePlanks
					)
				)
			)
			(gCurRoom setScript: cutLargeBoardScr)
		)
	)
)

(instance lever613 of Prop
	(properties
		x 157
		y 232
		loop 4
		view 613
	)

	(method (handleEvent)
		(return 0)
	)

	(method (init)
		(= cel
			(if (IsFlag 300)
				(self lastCel:)
			else
				0
			)
		)
		(super init: &rest)
	)
)

(instance belt of Prop ; UNUSED
	(properties
		x 232
		y 105
		loop 1
		view 613
	)
)

(instance lever616 of Prop
	(properties
		x 75
		y 146
		loop 1
		view 616
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(= loop 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (!= loop 1)
				(return)
			)
			(cond
				((not (localproc_2))
					(gCurRoom setScript: failCutScr)
				)
				((and (IsFlag 296) (not (IsFlag 297)))
					(gCurRoom setScript: cutSmallBoardScr)
				)
				((IsFlag 296)
					(gCurRoom setScript: failCutScr)
				)
				(else
					(gCurRoom setScript: runSawScr)
				)
			)
		)
	)

	(method (cue)
		(switch cel
			(4
				(sndFX number: 60905 loop: 0 play:)
				(self setCycle: CT 40 1 self)
			)
			(40
				(sndFX number: 60906 play:)
				(self setCycle: End self)
			)
			(else
				(= loop 1)
			)
		)
	)
)

(instance door615 of Prop
	(properties
		x 248
		y 231
		view 615
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gMySoundFX do: 60908)
			(self setCycle: End self)
		)
	)

	(method (cue)
		(forward nsLeft: 241 nsTop: 64 nsRight: 301 nsBottom: 232 newRoom: 600)
		(gGame handsOn:)
	)
)

(instance saw616 of View
	(properties
		x 175
		y 111
		loop 2
		view 616
	)

	(method (handleEvent)
		(return 0)
	)

	(method (init)
		(cond
			((and (IsFlag 296) (not (IsFlag 297)))
				(= cel 1)
			)
			((IsFlag 296)
				(= cel 2)
			)
			(else
				(= cel 0)
			)
		)
		(super init: &rest)
	)
)

(instance planks616 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) init: 135 135 151 158 414 106 377 96 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(IsFlag 297)
				(!= global239 6)
				(not
					(and
						(>= ((ScriptID 9 71) cel:) 3) ; invSmallPlanks
						(gInventory contains: (ScriptID 9 71)) ; invSmallPlanks
					)
				)
			)
			(ClearFlag 297)
			(ClearFlag 296)
			(saw616 cel: 0)
			(localproc_0)
			(sndFX loop: 0 number: 60900 play:)
		)
	)
)

(instance boards616 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) init: 165 277 156 201 412 137 401 188 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 296))) ; Do
			(sndFX loop: 0 number: 60900 play:)
			(SetFlag 296)
			(saw616 cel: 1)
		)
	)
)

(instance water620 of Prop
	(properties
		x 23
		y 299
		view 620
	)

	(method (init)
		(if (and (== global238 0) (gTheDoits contains: monsterRbt))
			(self view: 620)
		else
			(self view: 2620)
		)
		(self setCycle: Fwd setPri: 1 cycleSpeed: 11)
		(super init: &rest)
	)
)

(instance windPowerGear of Feature
	(properties
		nsBottom 300
		nsLeft 240
		nsRight 340
		nsTop 245
	)

	(method (doVerb theVerb)
		(cond
			((and (not (gInventory contains: (ScriptID 9 74))) (== theVerb 5)) ; invWindGear, Do
				(sndFX number: 61304 loop: 0 play:)
				(gInventory addItem: (ScriptID 9 74)) ; invWindGear
			)
			((== theVerb 74) ; invWindGear
				(gInventory deleteItem: (ScriptID 9 74)) ; invWindGear
			)
		)
	)
)

(instance failCutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever616 loop: 0 setCycle: CT 4 1 self)
			)
			(1
				(sndFX number: 60905 loop: 0 play:)
				(lever616 setCycle: Beg self)
			)
			(2
				(lever616 loop: 1 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cutSmallBoardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever616 loop: 0 cel: 0 setCycle: CT 4 1 lever616)
				(saw616 dispose:)
				(KillRobot 6160)
			)
			(1
				(SetFlag 297)
				(saw616 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance runSawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever616 loop: 0 cel: 0 setCycle: CT 4 1 lever616)
				(= cycles 1)
			)
			(1
				(saw616 dispose:)
				(KillRobot 616)
			)
			(2
				(saw616 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance failSawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever613 setCycle: End self)
				(sndFX number: 60903 loop: 0 play: self)
			)
			(1 0)
			(2
				(lever613 setCycle: Beg self)
				(sndFX number: 60903 loop: 0 play: self)
			)
			(3 0)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startSawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO (beltSFX number:))
				(lever613 setCycle: End self)
				(sndFX number: 60903 loop: 0 play: self)
			)
			(1 0)
			(2
				(beltSFX loop: -1 play:)
				(saw613 setCycle: End self)
				(belt613 setCycle: Fwd)
			)
			(3
				(saw613 loop: 3 setCycle: Fwd)
				(SetFlag 300)
				(= ticks 5)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stopSawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sndFX number: 60903 loop: 0 play: self)
				(lever613 setCycle: Beg self)
			)
			(1 0)
			(2
				(saw613 loop: 2 cel: (saw613 lastCel:) setCycle: Beg self)
			)
			(3
				(beltSFX dispose:)
				(belt613 setCycle: 0)
				(ClearFlag 300)
				(= ticks 5)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cutLargeBoardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(plank613 hide:)
				(belt613 hide:)
				(saw613 hide:)
				(KillRobot 613)
			)
			(2
				(plank613 show:)
				(belt613 show:)
				(saw613 show:)
				(= cycles 1)
			)
			(3
				(localproc_1)
				(= ticks 5)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance forwardLeft of ExitFeature
	(properties
		arrowStyle 8
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

(instance forward1 of ExitFeature
	(properties)
)

(instance down of ExitFeature
	(properties
		arrowStyle 6
	)
)

(instance myBackUp of ExitFeature
	(properties
		arrowStyle 2
	)
)

(instance lookOutside of Script
	(properties)

	(method (doit)
		(if (not (IsFlag 291))
			(if (and (not local0) (not local1))
				(= local1 1)
				(if (> (++ global238) 4)
					(= global238 3)
				)
				(= local2 1)
				(= local4 0)
				(= local3 0)
			else
				(= local2 0)
			)
		)
		(gCurRoom changeScene: 619)
	)
)

(instance traverseRightCuee of Script
	(properties)

	(method (cue)
		(PrintDebug {In tower... Timer set.})
		(SetFlag 344)
		(monsterRbt dispose:)
		((ScriptID 0 12) setReal: (ScriptID 0 12) 90) ; monsterTimer, monsterTimer
		(= local3 1)
	)
)

(instance traverseLeftCuee of Script
	(properties)

	(method (cue)
		(monsterRbt dispose:)
		(= local3 1)
	)
)

(instance monsterRbt of RobotPlayer
	(properties)
)

(instance waterGateTimer of Timer
	(properties)
)

(instance showMonsterCode of Code
	(properties)

	(method (doit)
		(ClearFlag 344)
		(if (gTimers contains: (ScriptID 0 12)) ; monsterTimer
			(gTimers delete: (ScriptID 0 12)) ; monsterTimer
			((ScriptID 0 12) dispose:) ; monsterTimer
		)
		(= local2 0)
		(= local7 0)
		(monsterRbt caller: 0)
		(switch global238
			(3
				(if (not (or local3 (gTheDoits contains: monsterRbt)))
					(Load rsAUDIO (= local7 62305))
					(monsterSFX number: local7 loop: 0 play:)
					(monsterRbt
						caller: traverseLeftCuee
						init: 2188 0 1000 1000 -1
						start: 1 10 0
					)
					(= local4 619)
					(= local5 0)
					(= local6 0)
				)
			)
			(4
				(if (not (or local3 (gTheDoits contains: monsterRbt)))
					(Load rsAUDIO (= local7 62304))
					(monsterRbt
						caller: traverseRightCuee
						init: 188 0 1000 1000 -1
						start: 1 10 0
					)
					(monsterSFX number: local7 loop: 0 play:)
					(= local4 619)
					(= local5 216)
					(= local6 17)
				)
			)
			(0
				(if (not (gTheDoits contains: monsterRbt))
					(Load rsAUDIO (= local7 62302))
					(monsterRbt init: 182 0 1000 1000 -1 start: 1 10 1)
					(monsterSFX number: local7 loop: -1 play:)
					(= local4 620)
					(= local5 151)
					(= local6 90)
				)
			)
			(1
				(if (not (gTheDoits contains: monsterRbt))
					(Load rsAUDIO (= local7 62303))
					(monsterRbt init: 185 0 1000 1000 -1 start: 1 10 1)
					(monsterSFX number: local7 loop: -1 play:)
					(= local4 620)
					(= local5 262)
					(= local6 149)
				)
			)
			(else
				(return)
			)
		)
		(if local7
			(gBackMusic stop:)
			(Load rsAUDIO 60008)
			(gBackMusic2 number: 60008 loop: -1 play:)
		)
	)
)

(instance sawHead of Prop
	(properties
		x 353
		y 153
		view 612
	)
)

(instance monsterSFX of Sound
	(properties)
)

(instance sndFX of Sound
	(properties)
)

(instance beltSFX of Sound
	(properties
		number 60904
		loop -1
	)
)

(instance doorCloseSound of Sound
	(properties
		number 60909
		flags 1
	)
)

(instance closeDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorCloseSound play:)
				(door615 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gCurRoom changeScene: register)
			)
		)
	)
)

