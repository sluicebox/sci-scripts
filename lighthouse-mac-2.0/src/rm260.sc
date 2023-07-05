;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
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

(instance rm260 of LightRoom
	(properties)

	(method (init &tmp temp0)
		(gGame handsOn:)
		(super init: &rest)
		(= temp0 (Random 60101 60103))
		(Load rsAUDIO temp0)
		(gBackMusic number: temp0 loop: -1 play:)
		(if (!= gPrevRoomNum 715)
			(doorSlam play:)
			(self changeScene: 3626 3)
		else
			(ClearFlag 306)
			(self changeScene: 2683 2 setScript: fromTemple)
		)
	)

	(method (dispose)
		(gBackMusic fade:)
		(gBackMusic2 fade:)
		(gGlobalVMD holdLastFrame: 0)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 715)
			(= global224 1)
			(gGame getDisc: 1)
			(super newRoom: newRoomNumber)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (changeScene param1)
		(= local7 scene)
		(= local3 0)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(= local6 0)
		(cond
			((and (== param1 2680) (IsFlag 165) (not (IsFlag 306)))
				(self changeScene: 2683 2)
			)
			((and (== param1 2675) (IsFlag 165) (not (IsFlag 306)))
				(self changeScene: 2684 3)
			)
			((and (== param1 2675) (IsFlag 306))
				(self changeScene: 2685 3)
			)
			(
				(and
					(== param1 2678)
					(not local1)
					(IsFlag 165)
					(not (IsFlag 306))
				)
				(self changeScene: 2682 12)
			)
			((and (== param1 2678) (not local1) (not (IsFlag 306)))
				(self changeScene: 2681 12)
			)
			((and (== param1 2680) (IsFlag 306))
				(self changeScene: 2686 2)
			)
			(else
				(super changeScene: param1 &rest)
				(switch param1
					(252
						(openCockpitView dispose:)
						(Load rsAUDIO 633 630 634 635 636)
						(cockpitControlCast
							add:
								leftLever
								leftDashLever
								rightDashLever
								rightLever
							eachElementDo: #init
						)
						(if (!= gPrevRoomNum 715)
							(gGame handsOff:)
							(pLid cel: 6 init: setCycle: Beg pLid)
							(lidCloseSFX play:)
						else
							(pLid cel: 0 init:)
						)
						(if (not local1)
							(rightForward
								init:
								resetProps:
								exitCode: openLidCode
							)
						)
						(= local6 252)
					)
					(691
						(proc0_9 692)
						((ScriptID 1 4) newPic: 3626 3) ; exitRight
						((ScriptID 1 3) newPic: 3624 7) ; exitLeft
						((ScriptID 1 2) newPic: 690 1) ; exitBack
					)
					(690
						(proc0_9 690)
						((ScriptID 1 2) newPic: 691 5) ; exitBack
						((ScriptID 1 4) newPic: 3624 7) ; exitRight
						((ScriptID 1 3) newPic: 3626 3) ; exitLeft
					)
					(2673
						(if (== local3 1)
							(openCockpitView init:)
							((ScriptID 1 1) newPic: 252 2 nsBottom: 225) ; exitForward
						else
							(cockpitSpot init:)
						)
						(leftForward dispose:)
						(turnTableLever dispose:)
						((ScriptID 1 3) ; exitLeft
							init:
							resetProps:
							exitCode: closeCockpit
						)
						((ScriptID 1 2) ; exitBack
							init:
							resetProps:
							exitCode: closeCockpit
						)
					)
					(2674
						((ScriptID 1 1) newPic: 2677 7) ; exitForward
						((ScriptID 1 4) newPic: 2673 11) ; exitRight
					)
					(2675
						(if (gCast contains: turnTableLever)
							(turnTableLever dispose:)
						)
						(if (gFeatures contains: leftForward)
							(leftForward dispose:)
						)
						(if (not (IsFlag 211))
							(part2675 init:)
						)
						(Load rsAUDIO 60120)
						(gBackMusic fade:)
						(gBackMusic2 number: 60120 setLoop: -1 play:)
						(setUp2678 doit: 0)
						((ScriptID 1 4) newPic: 2680 2) ; exitRight
						((ScriptID 1 3) newPic: 2678 12) ; exitLeft
						((ScriptID 1 1) newPic: 2676 3) ; exitForward
						((ScriptID 1 2) newPic: 2677 7) ; exitBack
						(if (== local7 3626)
							(doorSlam play:)
						)
					)
					(2676
						(if (gFeatures contains: leftForward)
							(leftForward dispose:)
						)
						(Load rsAUDIO 626)
						(cond
							((IsFlag 211)
								(sparePart loop: 1 x: 327 y: 145 init:)
							)
							((IsFlag 216)
								(partSpot init:)
							)
							(else
								(sparePart loop: 0 x: 306 y: 202 init:)
								(partSpot init:)
							)
						)
						((ScriptID 1 3) newPic: 2678 11) ; exitLeft
						((ScriptID 1 4) newPic: 2680 2) ; exitRight
						((ScriptID 1 2) newPic: 2677 7) ; exitBack
					)
					(2677
						(Load rsAUDIO 62306)
						(door init:)
						(gGame handsOn:)
						(setUp2678 doit: 0)
						((ScriptID 1 4) init: exitCode: doorExitRight) ; exitRight
						((ScriptID 1 3) init: exitCode: doorExitLeft) ; exitLeft
						((ScriptID 1 2) init: exitCode: doorExitBack) ; exitBack
					)
					(2678
						(setUp2678 doit: 1)
					)
					(2680
						(Load rsAUDIO 627)
						(if (IsFlag 165)
							(leftForward init: newPic: 2673 4)
							(turnTableLever cel: 9 init:)
						else
							(turnTableLever cel: 0 init:)
						)
						(rightForward
							init:
							newPic: 2861 8
							nsLeft: 200
							nsTop: 4
							nsRight: 376
							nsBottom: 100
						)
						((ScriptID 1 2) newPic: 2678 11) ; exitBack
						((ScriptID 1 4) newPic: 2677 7) ; exitRight
						((ScriptID 1 3) newPic: 2675 3) ; exitLeft
					)
					(2681
						((ScriptID 1 2) newPic: 2680 2 nsLeft: 266 nsRight: 401) ; exitBack
						(setUp2678 doit: 1)
					)
					(2682
						((ScriptID 1 2) newPic: 2680 2 nsLeft: 266 nsRight: 401) ; exitBack
						(setUp2678 doit: 1)
					)
					(2683
						(Load rsAUDIO 627)
						(if (IsFlag 165)
							(leftForward init: newPic: 2673 11)
							(turnTableLever cel: 9 init:)
						else
							(turnTableLever cel: 0 init:)
						)
						(rightForward
							init:
							newPic: 2861 8
							nsLeft: 200
							nsTop: 4
							nsRight: 376
							nsBottom: 133
						)
						((ScriptID 1 2) newPic: 2678 12) ; exitBack
						((ScriptID 1 4) newPic: 2677 7) ; exitRight
						((ScriptID 1 3) newPic: 2675 3) ; exitLeft
					)
					(2684
						(if (IsFlag 210)
							(rod2684 init:)
						)
						(setUp2678 doit: 0)
						((ScriptID 1 4) newPic: 2680 2) ; exitRight
						((ScriptID 1 3) newPic: 2678) ; exitLeft
						(if (not (IsFlag 165))
							((ScriptID 1 1) newPic: 2676 3) ; exitForward
						)
						((ScriptID 1 2) newPic: 2677 7) ; exitBack
					)
					(2685
						((ScriptID 1 4) newPic: 2680 2) ; exitRight
						((ScriptID 1 3) newPic: 2678 12) ; exitLeft
						((ScriptID 1 2) newPic: 2677 7) ; exitBack
					)
					(2686
						(turnTableLever cel: 0 init:)
						(rightForward
							init:
							newPic: 2861 8
							nsLeft: 200
							nsTop: 4
							nsRight: 376
							nsBottom: 133
						)
						((ScriptID 1 2) newPic: 2678 11) ; exitBack
						((ScriptID 1 4) newPic: 2677 7) ; exitRight
						((ScriptID 1 3) newPic: 2675 3) ; exitLeft
					)
					(2861
						(if (not (IsFlag 308))
							(littleKey init:)
						)
						((ScriptID 1 7) init: newPic: 2680 2) ; exitBackUp
					)
					(3624
						(Load rsAUDIO 62306)
						(Load rsAUDIO 62307)
						(door3624 init:)
						((ScriptID 1 2) init: exitCode: to3626) ; exitBack
						((ScriptID 1 4) init: exitCode: to691Right) ; exitRight
						((ScriptID 1 3) init: exitCode: to690Left) ; exitLeft
						(if (== local7 2677)
							(doorSlam play:)
						)
					)
					(3626
						(Load rsAUDIO 62306)
						(Load rsAUDIO 62307)
						(= local6 3626)
						(door3626 init:)
						((ScriptID 1 4) init: exitCode: to690Right) ; exitRight
						((ScriptID 1 3) init: exitCode: to691Left) ; exitLeft
						((ScriptID 1 2) init: exitCode: to3624) ; exitBack
					)
				)
			)
		)
	)
)

(instance part2675 of View
	(properties
		x 240
		y 235
		view 2675
	)
)

(instance door3626 of Prop
	(properties
		x 204
		y 273
		view 4626
	)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 1 1) newPic: 2675 3) ; exitForward
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== cel 0) (== theVerb 5)) ; Do
			(gGame handsOff:)
			(doorSound number: 62306 play:)
			(self setCycle: End self)
		)
	)
)

(instance rod2684 of View
	(properties
		x 47
		y 272
		view 3688
	)
)

(instance littleKey of View
	(properties
		x 274
		y 119
		view 2862
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(SetFlag 308)
			(gInventory addItem: (ScriptID 9 75)) ; invStatueKey
			(self dispose:)
		)
	)
)

(instance keySound of Sound ; UNUSED
	(properties
		flags 1
		number 11003
	)
)

(instance to3626 of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 3)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 3 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 3626)
		(if (!= (door3624 cel:) 0)
			(gGame handsOff:)
			(doorSlam play:)
			(door3624 setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance to691Right of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 5)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 5 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 691)
		(if (!= (door3624 cel:) 0)
			(gGame handsOff:)
			(doorSlam play:)
			(door3624 setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance to690Left of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 1)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 1 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 690)
		(if (!= (door3624 cel:) 0)
			(gGame handsOff:)
			(doorSlam play:)
			(door3624 setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance to690Right of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 1)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 1 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 690)
		(if (!= (door3626 cel:) 0)
			(gGame handsOff:)
			(doorSlam play:)
			(door3626 setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance to691Left of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 5)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 5 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 691)
		(if (!= (door3626 cel:) 0)
			(gGame handsOff:)
			(doorSlam play:)
			(door3626 setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance to3624 of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 7)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 7 setCel: 0)
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 3624)
		(if (and (gCast contains: door3626) (!= (door3626 cel:) 0))
			(gGame handsOff:)
			(door3626 setCycle: Beg self)
		else
			(if (gCast contains: door)
				(doorSlam play:)
			)
			(self cue:)
		)
	)
)

(instance door3624 of Prop
	(properties
		x 218
		y 237
		view 4624
	)

	(method (cue)
		(gCurRoom compassDir: 3)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 3 setCel: 0)
		)
		(gGame handsOn:)
		((ScriptID 1 1) newRoom: 680) ; exitForward
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== cel 0) (== theVerb 5)) ; Do
			(gGame handsOff:)
			(doorSound number: 62306 play:)
			(self setCycle: End self)
		)
	)
)

(instance door of Prop
	(properties
		x 179
		y 299
		view 3689
	)

	(method (cue)
		(if (== cel 0)
			(doorSlam play:)
			((ScriptID 1 1) dispose:) ; exitForward
		else
			((ScriptID 1 1) init: exitCode: to3624) ; exitForward
		)
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== cel 0) (== theVerb 5)) ; Do
			(doorSound play:)
			(self setCycle: End self)
		else
			(self setCycle: Beg self)
		)
	)
)

(instance turnTableLever of Prop
	(properties
		x 334
		y 241
		view 3673
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (not (IsFlag 210)) (not (IsFlag 306))) ; Do
			(gCurRoom setScript: rotateRoom)
		)
	)
)

(instance leverSound of Sound
	(properties
		flags 1
		number 627
	)
)

(instance doorSound of Sound
	(properties
		flags 1
		number 62306
	)
)

(instance closeCockpit of ExitCode
	(properties)

	(method (doit)
		(= nextScene 2677)
		(if (gCast contains: openCockpitView)
			(gGame handsOff:)
			(openCockpitView dispose:)
			(= local3 0)
			(KillRobot 3687)
		else
			(self cue:)
		)
	)
)

(instance toWatchTower of ExitCode ; UNUSED
	(properties)

	(method (cue)
		(gCurRoom newRoom: 680)
	)

	(method (doit)
		(gGame handsOff:)
		(door3624 setCycle: End self)
	)
)

(instance doorExitRight of ExitCode
	(properties)

	(method (doit)
		(= nextScene 2678)
		(if (== (door cel:) 0)
			(self cue:)
		else
			(doorSlam play:)
			(door setCycle: Beg self)
		)
	)
)

(instance doorExitLeft of ExitCode
	(properties)

	(method (doit)
		(= nextScene 2680)
		(if (!= (door cel:) 0)
			(doorSlam play:)
			(door setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance doorExitBack of ExitCode
	(properties)

	(method (doit)
		(= nextScene 2675)
		(if (!= (door cel:) 0)
			(door setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance setUp2678 of Code
	(properties)

	(method (doit param1)
		(cond
			((and argc param1)
				((ScriptID 1 4) newPic: 2675 3) ; exitRight
				((ScriptID 1 3) newPic: 2677 7) ; exitLeft
				(dialGuage init:)
				(rodSwitch init:)
				(extendingRod init:)
				(rodSpot init:)
				(rodCrank init:)
			)
			((gCast contains: dialGuage)
				(dialGuage dispose:)
				(rodSwitch dispose:)
				(extendingRod dispose:)
				(rodCrank dispose:)
				(rodSpot dispose:)
			)
		)
	)
)

(instance rodSwitch of Prop
	(properties
		x 201
		y 92
		view 3667
	)

	(method (init)
		(if (IsFlag 210)
			(= cel 21)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((IsFlag 210)
				(gCurRoom setScript: retractRod)
			)
			((and (not (IsFlag 210)) (IsFlag 165))
				(gCurRoom setScript: extendRod)
			)
			((not (IsFlag 210))
				(gCurRoom setScript: rodHitsOrnithopter)
			)
		)
	)
)

(instance dialGuage of Prop
	(properties
		x 114
		y 85
		view 3674
		cycleSpeed 16
	)

	(method (init)
		(if local2
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance extendingRod of Prop
	(properties
		x 310
		y 93
		view 3668
	)

	(method (init)
		(if (IsFlag 210)
			(= cel 18)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance rodSound of Sound
	(properties
		flags 1
		number 629
	)
)

(instance rodCrank of Prop
	(properties
		x 204
		y 191
		view 3676
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 210) (== theVerb 5)) ; Do
			(gCurRoom setScript: turnCrank)
		)
	)

	(method (init)
		(if local2
			(= cel (self lastCel:))
		else
			(= cel 0)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)
)

(instance crankSound of Sound
	(properties
		flags 1
		number 638
		loop -1
	)
)

(instance sparePart of Prop
	(properties
		x 306
		y 202
		view 3675
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 56)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 5) (not (IsFlag 211))) ; Do
				(gCurRoom setScript: removePart)
			)
			((== theVerb 56) ; invOrnithopterPart
				(partSpot doVerb: theVerb)
			)
		)
	)
)

(instance cockpitControlCast of Set
	(properties)
)

(instance leftLever of Prop
	(properties
		x 55
		y 252
		view 254
	)

	(method (doVerb)
		(cond
			((not local1)
				(gCurRoom setScript: moveOrnithopterOut)
			)
			((and local1 (not local4) (not local0))
				(gCurRoom setScript: moveOrnithopterIn)
			)
		)
	)
)

(instance leftLeverSound of Sound
	(properties
		flags 1
		number 633
	)
)

(instance leftDashLever of Prop
	(properties
		x 151
		y 222
		view 254
		loop 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				(
					(and
						local1
						local4
						local2
						(not local5)
						(IsFlag 211)
						(not local0)
					)
					(gCurRoom setScript: wingsFlap)
				)
				(local5
					(gCurRoom setScript: wingsStopFlapping)
				)
				(else
					(gCurRoom setScript: wingsDontFlap)
				)
			)
		)
	)
)

(instance leftDashLeverSound of Sound
	(properties
		flags 1
		number 634
	)
)

(instance rightDashLever of Prop
	(properties
		x 352
		y 186
		view 254
		loop 2
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((and local1 (IsFlag 211) (not local4) (not local0))
					(gCurRoom setScript: lowerWings)
				)
				((and local1 local4)
					(gCurRoom setScript: raiseWings)
				)
				(else
					(gCurRoom setScript: bogusRelease)
				)
			)
		)
	)
)

(instance rightDashLeverSound of Sound
	(properties
		flags 1
		number 630
	)
)

(instance rightLever of Prop
	(properties
		x 399
		y 294
		view 254
		loop 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(if (and local1 local4 local5 local2 (not local3) (not local0))
				(gCurRoom setScript: launchOrnithopter)
			else
				(gCurRoom setScript: bogusLaunch)
			)
		)
	)
)

(instance rightLeverSound of Sound
	(properties
		flags 1
		number 635
	)
)

(instance rightLeverBack of Sound
	(properties
		flags 1
		number 636
	)
)

(instance openCockpitView of View
	(properties
		x 218
		y 296
		view 3677
	)
)

(instance cockpitSpot of Feature
	(properties
		nsLeft 171
		nsTop 160
		nsRight 326
		nsBottom 293
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: openCockpit)
		)
	)
)

(instance partSpot of Feature
	(properties
		nsLeft 204
		nsTop 101
		nsRight 407
		nsBottom 245
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 56)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 211))
					(sparePart doVerb: 5)
				)
			)
			(56 ; invOrnithopterPart
				(gCurRoom setScript: insertPart)
			)
		)
	)
)

(instance rodSpot of Feature
	(properties
		nsLeft 173
		nsTop 70
		nsRight 231
		nsBottom 128
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(rodSwitch doVerb: theVerb)
	)
)

(instance leftForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(= nsTop (= nsLeft 0))
		(= nsRight 140)
		(= nsBottom 299)
		(super init: &rest)
	)
)

(instance rightForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(= nsLeft 261)
		(= nsRight 499)
		(= nsTop 0)
		(= nsBottom 129)
		(super init: &rest)
	)
)

(instance fromTemple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD number: 3681 holdLastFrame: 1 init: play:)
				(gCurRoom changeScene: 252 2)
				(gGlobalVMD holdLastFrame: 0 close:)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(SetFlag 165)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance insertPart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(partSound play:)
				(sparePart init: setLoop: 1 x: 327 y: 145)
				(partSpot dispose:)
				(gInventory deleteItem: (ScriptID 9 47)) ; invOrnithopterPart
				(SetFlag 211)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance removePart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(partSound play:)
				(sparePart setCycle: End self)
			)
			(1
				(partSound play:)
				(sparePart setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance partSound of Sound
	(properties
		flags 1
		number 626
	)
)

(instance extendRod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 629)
				(rodSound play:)
				(rodSwitch setCycle: End self)
				(extendingRod setCycle: End self)
			)
			(1)
			(2
				(SetFlag 210)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance retractRod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 629)
				(rodSound play:)
				(rodSwitch setCycle: Beg self)
				(extendingRod setCycle: Beg self)
			)
			(1)
			(2
				(ClearFlag 210)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rodHitsOrnithopter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 639)
				(rodSwitch setCycle: End self)
				(extendingRod setCycle: CT 4 1 self)
				(bumpSound play:)
			)
			(1)
			(2
				(extendingRod setCycle: Beg self)
				(rodSwitch setCycle: Beg self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bumpSound of Sound
	(properties
		flags 1
		number 639
	)
)

(instance turnCrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 638 629)
				(crankSound play:)
				(rodCrank setCycle: Fwd)
				(dialGuage setCycle: End self)
			)
			(1
				(rodCrank setCycle: 0)
				(rodSwitch setCycle: Beg self)
				(rodSound play:)
				(crankSound stop:)
				(extendingRod setCycle: Beg self)
			)
			(2)
			(3
				(ClearFlag 210)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rotateRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leverSound play:)
				(if (IsFlag 165)
					(turnTableLever setCycle: Beg self)
				else
					(turnTableLever setCycle: End self)
				)
			)
			(1
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(if (IsFlag 165)
					(gGlobalVMD
						number: 3680
						stretch: 1
						holdLastFrame: 1
						init:
						play:
					)
				else
					(gGlobalVMD
						number: 3681
						stretch: 1
						holdLastFrame: 1
						init:
						play:
					)
				)
				(if (IsFlag 165)
					(leftForward dispose:)
					(ClearFlag 165)
					(gCurRoom drawPic: 2680)
				else
					(leftForward init: newPic: 2673 11)
					(SetFlag 165)
					(gCurRoom drawPic: 2683)
				)
				(gGlobalVMD close:)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance launchOrnithopter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightLeverSound play:)
				(rightLever setCycle: End self)
			)
			(1
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gBackMusic stop:)
				(gBackMusic2 stop:)
				(gMySoundFX stop:)
				(gGlobalVMD
					number: 3678
					stretch: 1
					holdLastFrame: 0
					init:
					play:
					close:
				)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(= local0 1)
				(SetFlag 306)
				(gGame handsOn:)
				(gCurRoom newRoom: 715)
			)
		)
	)
)

(instance moveOrnithopterOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftLeverSound play:)
				(leftLever setCycle: End self)
			)
			(1
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD
					number: 3683
					stretch: 1
					holdLastFrame: 0
					init:
					play:
					close:
				)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(rightForward dispose:)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveOrnithopterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftLeverSound play:)
				(leftLever setCycle: Beg self)
			)
			(1
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gGlobalVMD
					number: 3682
					stretch: 1
					holdLastFrame: 0
					init:
					play:
					close:
				)
				(rightForward init: exitCode: openLidCode)
				(if
					(and
						(gPanels contains: (ScriptID 9 3)) ; PlCompass
						(not (gPanels contains: (ScriptID 9 4))) ; InvInset
					)
					((ScriptID 9 3) show:) ; PlCompass
				)
				(= local1 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openCockpit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(KillRobot 3677)
			)
			(1
				(openCockpitView init:)
				((ScriptID 1 1) ; exitForward
					newPic: 252 2
					arrowStyle: 9
					nsLeft: 150
					nsTop: 155
					nsRight: 319
					nsBottom: 241
				)
				(= local3 1)
				(cockpitSpot dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lowerWings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightDashLeverSound play:)
				(rightDashLever setCycle: End self)
			)
			(1
				(cockpitControlCast eachElementDo: #hide)
				(pLid hide:)
				(gCurRoom drawPic: 3680)
				(KillRobot 3684)
			)
			(2
				(gCurRoom drawPic: 252)
				(cockpitControlCast eachElementDo: #show)
				(pLid show:)
				(= local4 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance raiseWings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightDashLeverSound play:)
				(rightDashLever setCycle: Beg self)
			)
			(1
				(gCurRoom drawPic: 3680)
				(cockpitControlCast eachElementDo: #hide)
				(pLid hide:)
				(KillRobot 3685)
			)
			(2
				(gCurRoom drawPic: 252)
				(cockpitControlCast eachElementDo: #show)
				(pLid show:)
				(= local4 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bogusRelease of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightDashLeverSound play:)
				(rightDashLever setCycle: CT 10 1 self)
			)
			(1
				(rightDashLeverSound stop:)
				(rightDashLever setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wingsFlap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftDashLeverSound play:)
				(leftDashLever setCycle: End self)
			)
			(1
				(cockpitControlCast eachElementDo: #hide)
				(pLid hide:)
				(gCurRoom drawPic: 3680)
				(KillRobot 3680)
			)
			(2
				(gCurRoom drawPic: 252)
				(cockpitControlCast eachElementDo: #show)
				(pLid show:)
				(= local5 1)
				(gGame handsOn:)
				(= seconds 10)
			)
			(3
				(= local2 0)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance wingsStopFlapping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftDashLeverSound play:)
				(leftDashLever setCycle: Beg self)
			)
			(1
				(= local5 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wingsDontFlap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(leftDashLeverSound play:)
				(if (== (leftDashLever cel:) 0)
					(leftDashLever setCycle: CT 2 1 self)
				else
					(self cue:)
				)
			)
			(1
				(leftDashLeverSound stop:)
				(leftDashLever setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bogusLaunch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rightLeverSound play:)
				(rightLever setCycle: CT 4 1 self)
			)
			(1
				(rightLeverSound stop:)
				(rightLeverBack play:)
				(rightLever setCycle: Beg self)
			)
			(2
				(rightLeverBack stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pLid of Prop
	(properties
		y 2
		view 252
		cel 6
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance openLidCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(pLid setScript: sOpenLid)
	)
)

(instance sOpenLid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pLid setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom changeScene: 2674 14)
				(self dispose:)
			)
		)
	)
)

(instance doorSlam of Sound
	(properties
		flags 1
		number 62310
	)
)

(instance lidCloseSFX of Sound
	(properties
		flags 1
		number 45011
	)
)

