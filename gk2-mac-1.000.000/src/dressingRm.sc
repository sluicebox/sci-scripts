;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1160)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	dressingRm 0
	proc1160_1 1
)

(local
	local0
)

(procedure (proc1160_1 param1 param2 param3 &tmp temp0 temp1)
	(if (gTimers contains: (ScriptID 1030 1)) ; engelTimer
		(= temp1 1)
		(= temp0 ((ScriptID 1030 1) seconds:)) ; engelTimer
		((ScriptID 1030 1) dispose: delete:) ; engelTimer
	else
		(= temp1 0)
	)
	(cond
		((== argc 3)
			(PlayScene param1 param2 param3)
		)
		((== argc 2)
			(PlayScene param1 param2)
		)
		(else
			(PlayScene param1)
		)
	)
	(if temp1
		((ScriptID 1030 1) setReal: (ScriptID 1030 1) temp0) ; engelTimer, engelTimer
	)
)

(instance dressingRm of ExitRoom ; "Wittelsbacher Theater: Dressing Room"
	(properties
		noun 8
		picture 11601
	)

	(method (init)
		(self setRegions: 1030) ; dressRegion
		(= gEgo GabeEgo)
		(gUser alterEgo: gEgo)
		(if (== gPrevRoomNum 666) ; uDie
			(ClearFlag 779)
			(ClearFlag 783)
			(ClearFlag 782)
			(ClearFlag 780)
			(ClearFlag 781)
			(ClearFlag 778)
			(ClearFlag 777)
			(gEgo put: 84) ; invPowder
			(Lock rsAUDIO 1104 1)
			(gGk2Music setLoop: -1 number: 1104 play:)
		)
		(if (IsFlag 778)
			(gEgo
				view: 11603
				setLoop: 0 1
				cel: 0
				posn: 419 290
				setScaler: Scaler 111 111 294 292
				init:
			)
		else
			(gEgo
				posn: 407 303
				normalize: 225
				init:
				view: 11607
				setScaler: Scaler 92 68 328 239
			)
		)
		(UpdateScreenItem gEgo)
		(Palette 2 0 255 0) ; PalIntensity
		(super init: &rest)
		(switch gPrevRoomNum
			(666 ; uDie
				(proc11_13)
			)
			(1150 ; backStageRm
				(PlayScene 1879)
			)
		)
		(if (IsFlag 777)
			(missingCostume init:)
		)
		(door init:)
		(mirror init:)
		(if (not (gEgo has: 84)) ; invPowder
			(powder init:)
		)
		(if (IsFlag 782)
			(powderOnGlass init:)
		)
		(costumes init:)
		(changeArea init:)
		(if (== gPrevRoomNum 11641)
			(cond
				((IsFlag 784)
					(self notify:)
				)
				((== global145 889)
					(Lock 140 1160 1) ; WAVE
					(gGk2Music number: 1160 setLoop: -1 play:)
					((ScriptID 1030 1) setReal: (ScriptID 1030 1) 15) ; engelTimer, engelTimer
				)
			)
		)
		(= global145 0)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 665) ; gabeNews
			(Lock rsAUDIO 1160 0)
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(ClearFlag 784)
		(cond
			((and (IsFlag 779) (not (IsFlag 781)))
				(PlayScene 879 0 665) ; gabeNews
			)
			((and (IsFlag 779) (IsFlag 781) (IsFlag 782))
				(self setScript: sDo881)
			)
			((IsFlag 779)
				(self setScript: sDo880)
			)
			((and (IsFlag 783) (IsFlag 782))
				(PlayScene 883 0 665) ; gabeNews
			)
			(else
				(PlayScene 884 0 665) ; gabeNews
			)
		)
	)
)

(instance sDo880 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1030 1) dispose: delete:) ; engelTimer
				(PlayScene 880 self)
			)
			(1
				(gEgo y: 1000)
				(SetFlag 780)
				(engelhart init:)
				(= cycles 2)
			)
			(2
				(ClearFlag 779)
				(SetFlag 783)
				((ScriptID 1030 1) setReal: (ScriptID 1030 1) 10) ; engelTimer, engelTimer
				(self dispose:)
			)
		)
	)
)

(instance sDo881 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1030 1) dispose: delete:) ; engelTimer
				(PlayScene 881 self)
			)
			(1
				(gEgo y: 1000)
				(SetFlag 780)
				(engelhart init:)
				(= cycles 2)
			)
			(2
				(ClearFlag 779)
				(SetFlag 783)
				((ScriptID 1030 1) setReal: (ScriptID 1030 1) 10) ; engelTimer, engelTimer
				(self dispose:)
			)
		)
	)
)

(instance sAct3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCast eachElementDo: #dispose)
				(PlayScene 896 self -1)
			)
			(1
				(gGame handsOff:)
				(Lock rsAUDIO 1160 0)
				(gGk2Music fade: 0 20 10 1)
				(= ticks 270)
			)
			(2
				(gGame handsOff:)
				(pActThree init: setCycle: End self)
			)
			(3
				(= ticks 180)
			)
			(4
				(pActThree setCycle: Beg self)
			)
			(5
				(pActThree dispose:)
				(= ticks 60)
			)
			(6
				((ScriptID 1030 0) keep: 0) ; dressRegion
				(PlayScene 943 0 1180) ; basementHallRm
				(self dispose:)
			)
		)
	)
)

(instance pActThree of Prop
	(properties
		x 165
		y 120
		view 106
		loop 4
	)
)

(instance sFidgetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 180))
			)
			(1
				(client cel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance mirror of Feature
	(properties
		modNum 1160
		nsLeft 465
		nsTop 103
		nsRight 607
		nsBottom 190
		x 532
		y 108
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or (IsFlag 779) (IsFlag 780) (IsFlag 781) (IsFlag 778))
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (IsFlag 779) (IsFlag 782))
						(gMessager say: 5 62 0 0 0 modNum) ; "(HURRIED)There's no time to check my hair now!"
					)
					((and (IsFlag 781) (not (IsFlag 780)))
						(gCurRoom setScript: sComeOutMirror 0 theVerb)
					)
					(
						(and
							(IsFlag 778)
							(not (IsFlag 780))
							(not local0)
							(== (gEgo cel:) 0)
						)
						(gCurRoom setScript: sApproachMirror 0 theVerb)
					)
					((not (IsFlag 780))
						(gCurRoom newRoom: 11641)
					)
					(else
						(gMessager say: 6 62 0 0 0 modNum) ; "(CLICK ON MIRROR WHEN ENGLEHART IS HERE)Someone else is usin' it at the moment."
					)
				)
			)
			(36 ; invPowder
				(cond
					((and (IsFlag 781) (not (IsFlag 780)))
						(gCurRoom setScript: sComeOutMirror 0 theVerb)
					)
					(
						(and
							(IsFlag 778)
							(not (IsFlag 780))
							(not local0)
							(== (gEgo cel:) 0)
						)
						(gCurRoom setScript: sApproachMirror 0 theVerb)
					)
					((IsFlag 780)
						(gMessager say: 7 theVerb 0 0 0 modNum) ; "(TRY TO PUT POWDER ON MIRROR, ENGLEHART IS HERE)I should have thought of that BEFORE."
					)
					(else
						(gCurRoom newRoom: 11641)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sComeOutMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 781)
				((gUser hotCursor:) add: changeArea)
				(if (IsFlag 778)
					(= local0 1)
					(gEgo show:)
					((Actor new:)
						view: 11604
						setLoop: 0 1
						cel: 0
						init:
						posn: 90 330
						setScaler: Scaler 70 60 334 297
						setSpeed: 5
						setCycle: Walk
						setStep: 18 7
						setMotion: MoveTo 406 297 self
					)
				else
					(gEgo
						view: 11605
						setLoop: 0 1
						cel: 0
						posn: 281 350
						setScaler: Scaler 85 85 250 350
						cycleSpeed: 5
						show:
						setCycle: End self
					)
				)
			)
			(1
				(mirror doVerb: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sApproachMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 11603
					setLoop: 0 1
					cel: 0
					posn: 419 290
					setScaler: Scaler 111 111 294 292
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(1
				(mirror doVerb: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance powderOnGlass of View
	(properties
		modNum 1160
		sightAngle 5
		x 471
		y 250
		z 75
		view 30882
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance powder of View
	(properties
		modNum 1160
		sightAngle 5
		x 441
		y 228
		view 30882
		cel 3
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance costumes of Feature
	(properties
		noun 3
		modNum 1160
		nsLeft 196
		nsTop 95
		nsRight 297
		nsBottom 200
		sightAngle 360
		x 255
		y 309
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 777)
						(super doVerb: theVerb)
					)
					((IsFlag 781)
						(gCurRoom setScript: sComeOutCostumes)
					)
					(else
						(SetFlag 777)
						(gEgo get: 85) ; invCostume
						(missingCostume init:)
						(proc1160_1 886)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sComeOutCostumes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 781)
				((gUser hotCursor:) add: changeArea)
				(gEgo
					view: 11605
					setLoop: 0 1
					cel: 0
					posn: 281 350
					setScaler: Scaler 85 85 250 350
					cycleSpeed: 5
					show:
					setCycle: CT 22 1 self
				)
			)
			(1
				(gEgo
					posn: 407 300
					normalize: 225
					view: 11607
					setScaler: Scaler 92 68 328 239
				)
				(costumes doVerb: 62)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance changeArea of Feature
	(properties
		modNum 1160
		nsLeft 12
		nsTop 48
		nsRight 167
		nsBottom 345
		sightAngle 360
		x 103
		y 350
	)

	(method (onMe)
		(if (IsFlag 781)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (IsFlag 781))
					(gCurRoom setScript: sHide)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 781)
				(if (IsFlag 778)
					(gEgo
						view: 11602
						setLoop: 0 1
						cel: 0
						posn: 419 290
						setScaler: Scaler 111 111 294 292
						setSpeed: 5
						setCycle: End self
					)
				else
					(gEgo
						view: 11606
						setLoop: 0 1
						cel: 0
						posn: 294 323
						setScaler: Scaler 86 98 321 320
						cycleSpeed: 5
						setCycle: End self
					)
				)
			)
			(1
				(gEgo hide:)
				((gUser hotCursor:) delete: changeArea)
				(gGame changeScore: 1156 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance missingCostume of View
	(properties
		noun 3
		sightAngle 360
		x 146
		y 102
		view 30882
		cel 1
	)
)

(instance engelhart of Prop
	(properties
		modNum 1160
		sightAngle 360
		x 437
		y 280
		view 20882
	)

	(method (init)
		(mirror dispose:)
		(if (gCast contains: powderOnGlass)
			(powderOnGlass dispose:)
		)
		(if (IsFlag 782)
			(= view 21882)
			(= x 436)
			(= y 281)
		else
			(= view 20882)
			(= x 437)
			(= y 280)
		)
		(super init: &rest)
		(mirror init:)
		(if (IsFlag 782)
			(powderOnGlass init:)
		)
		(self setScript: sFidgetScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(ClearFlag 779)
				(ClearFlag 783)
				(ClearFlag 780)
				(ClearFlag 781)
				(ClearFlag 778)
				(ClearFlag 777)
				(gEgo put: 84) ; invPowder
				((ScriptID 1030 1) dispose: delete:) ; engelTimer
				(if (IsFlag 782)
					(ClearFlag 782)
					(PlayScene 895 0 665) ; gabeNews
				else
					(PlayScene 893 0 665) ; gabeNews
				)
			)
			(35 ; invRollOfTape
				((ScriptID 1030 1) dispose: delete:) ; engelTimer
				(if (IsFlag 782)
					(ClearFlag 778)
					(gCurRoom setScript: sAct3)
				else
					(ClearFlag 779)
					(ClearFlag 783)
					(ClearFlag 782)
					(ClearFlag 780)
					(ClearFlag 781)
					(ClearFlag 778)
					(ClearFlag 777)
					(gEgo put: 84) ; invPowder
					(PlayScene 894 0 665) ; gabeNews
				)
			)
			(else
				(gMessager say: 17 62 0 0 0 1180) ; "(PICKUP, LOOK AT OTHER ITEMS IN BASEMENT OF THEATER, CH 6, DARK)I can't do anythin' with THAT."
			)
		)
	)
)

(instance door of GKFeature
	(properties
		modNum 1160
		x 390
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 352 226 352 41 429 36 429 234
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 778) (IsFlag 781)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 779)
						((ScriptID 1030 1) setReal: (ScriptID 1030 1) 0) ; engelTimer, engelTimer
					)
					((and (IsFlag 781) (not (IsFlag 778)))
						(gCurRoom setScript: sComeOutDoor)
					)
					((not (IsFlag 778))
						(gCurRoom newRoom: 1150) ; backStageRm
					)
					((not (IsFlag 780))
						(gMessager say: 1 62 0 0 0 modNum) ; "(THEATER DRESING ROOM, TRY TO LEAVE IN COSTUME)"Englehart's" already on stage. I'd better not be seen like this just yet."
					)
					((IsFlag 780)
						(gMessager say: 2 62 0 0 0 modNum) ; "(TRY TO LEAVE WHEN ENGLEHART IS HERE)There're people outside, and they're expecting "Engelhart.""
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sComeOutDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 781)
				((gUser hotCursor:) add: changeArea)
				(gEgo
					view: 11605
					setLoop: 0 1
					cel: 0
					posn: 281 350
					setScaler: Scaler 85 85 250 350
					cycleSpeed: 5
					show:
					setCycle: CT 22 1 self
				)
			)
			(1
				(door doVerb: 62)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

