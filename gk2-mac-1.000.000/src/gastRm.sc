;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	gastRm 0
)

(local
	local0
)

(instance gastRm of ExitRoom ; "Gasthof Goldener L\94we"
	(properties
		noun 31
		picture 7401
	)

	(method (init &tmp temp0)
		(Load rsVIEW 20171 22171)
		(if
			(and
				(OneOf gPrevRoomNum 700 24) ; sqRm, whereTo
				(OneOf gChapter 2 4)
				(or (not (gGk2Music handle:)) (!= 740 (gGk2Music number:)))
			)
			(Lock rsAUDIO 740 1)
			(gGk2Music number: 740 setLoop: 1 play: 0 0 fade: 63 10 10 0)
		)
		(werner init: setScript: wernerFidget)
		(if (== 2 gChapter)
			(extraDude init: setScript: (FidgetScript new:))
		)
		(cond
			((== gChapter 6)
				(mrsSmith init: setScript: FidgetScript)
			)
			((!= gChapter 4))
			((or (not (IsFlag 605)) (not (gEgo has: 72))) ; invCarKeys
				(mrSmith init: setScript: FidgetScript)
				(mrsSmith init: setScript: mrsScript)
			)
			((== gPrevRoomNum 7424) ; smithTopicRm
				(SetFlag 620)
				(ClearFlag 633) ; disable "The Smiths" in gastTopicRm
				(mrSmith init: setScript: FidgetScript)
				(mrsSmith init: setScript: mrsScript)
			)
			((proc11_15 7424)
				(ClearFlag 312)
				(SetFlag 633) ; enable "The Smiths" in gastTopicRm
			)
		)
		(if (== gChapter 6)
			(rolls init:)
		)
		(door init:)
		(pic init:)
		(arti init:)
		(gGame handsOn:)
		(cond
			((OneOf gPrevRoomNum 7428 7427 7441)
				(gEgo
					posn: 457 167
					heading: 225
					normalize:
					init:
					setScaler: Scaler 72 37 292 154
				)
				(= global141 arti)
			)
			((== gPrevRoomNum 7440)
				(gEgo
					heading: 135
					normalize:
					setScaler: Scaler 72 37 292 154
					init:
				)
				(= global141 pic)
			)
			(else
				(gEgo
					posn: 233 162
					heading: 135
					normalize:
					setScaler: Scaler 72 37 292 154
					init:
				)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 700) ; sqRm
			(gGk2Music fade:)
			(Lock rsAUDIO 740 0)
		)
		(if (and (== gChapter 4) (== newRoomNumber 7422) (gCast contains: mrSmith)) ; gastTopicRm
			(SetFlag 312)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance wernerFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: (if (Random 0 1) 20171 else 22171))
				(client cel: 0 setCycle: End self)
			)
			(1
				(if (< (gGame detailLevel:) 2)
					(= state -1)
				)
				(= seconds (Random 4 9))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 190
		nsTop 38
		nsRight 246
		nsBottom 144
		sightAngle 0
		approachX 236
		nextRoomNum 700 ; sqRm
		exitDir 0
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== global141 arti))
			(= approachX 236)
			(= approachY 167)
		)
		(super handleEvent: event)
	)
)

(instance pic of GKFeature
	(properties
		nsLeft 318
		nsTop 50
		nsRight 342
		nsBottom 86
		approachX 330
		approachY 100
		nextRoomNum 7440 ; rm7440
	)
)

(instance arti of GKFeature
	(properties
		nsLeft 538
		nsTop 60
		nsRight 564
		nsBottom 110
		approachX 640
		approachY 310
		nextRoomNum 7427 ; rm7427
	)
)

(instance mrSmith of Prop
	(properties
		sightAngle 180
		approachX 212
		approachY 600
		x 257
		y 185
		view 20435
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(and (== gChapter 6) (not (proc11_15 7426)))
					(and (!= gChapter 6) (not (proc11_15 7424)))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(mrsSmith doVerb: &rest)
	)
)

(instance mrsSmith of Prop
	(properties
		sightAngle 0
		approachX 212
		approachY 600
		x 58
		y 255
		cycleSpeed 12
	)

	(method (init)
		(= view
			(if (== gChapter 6)
				21435
			else
				(Load rsVIEW 21436)
				21437
			)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(and (== gChapter 6) (not (proc11_15 7426)))
					(and (== gChapter 4) (not (proc11_15 7424)))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== gChapter 6)
				(switch theVerb
					(96 ; invVonGlowerLetter
						(if (IsFlag 705)
							(= noun 17)
						else
							(= noun 16)
						)
						(super doVerb: theVerb)
					)
					(62 ; Do
						(if (proc11_15 7426)
							(gCurRoom newRoom: 7426) ; smithTopicCh6
						else
							(= noun 48)
							(super doVerb: theVerb)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((!= theVerb 62) ; Do
				(super doVerb: theVerb)
			)
			((proc11_15 7424)
				(gCurRoom newRoom: 7424) ; smithTopicRm
			)
			(else
				(= noun 47)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance extraDude of Prop
	(properties
		sightAngle 360
		x 114
		y 99
		view 20740
	)

	(method (doVerb)
		(gMessager say: 23 62 0 1 0 730) ; "(PICKUP, CLICK ON PENITENTS)I don't want to disturb him."
	)
)

(instance werner of Prop
	(properties
		noun 46
		sightAngle 0
		approachX 450
		approachY 160
		x 412
		y 72
		view 20171
		cycleSpeed 4
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(== gChapter 6)
					(and (IsFlag 473) (not (proc11_15 7422)))
					(!= (event message:) $003e) ; >
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(= global141 0)
		(switch theVerb
			(62 ; Do
				(cond
					((== gChapter 6)
						(= noun 15)
						(super doVerb: theVerb)
					)
					((not (IsFlag 473))
						(PlayScene 173)
						(gEgo normalize: 135)
					)
					((proc11_15 7422)
						(gCurRoom newRoom: 7422) ; gastTopicRm
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rolls of View
	(properties
		sightAngle 5
		approachX 212
		approachY 600
		x 143
		y 231
		view 30764
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 776))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 776)
				(gMessager say: 14 62) ; "(RITTERSBERG GASTHOF, TRY TO TAKE SECOND ROLL)I don't need another roll."
			else
				(SetFlag 776)
				(gEgo get: 75 heading: 135 normalize:) ; invRoll
				(PlayScene 764)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mrsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mrsSmith cel: 0 view: (Random 21435 21437) setCycle: End self)
			)
			(1
				(if (Random 0 1)
					(self cue:)
				else
					(mrsSmith setCycle: Beg self)
				)
			)
			(2
				(= state -1)
				(= seconds (Random 1 4))
			)
		)
	)
)

