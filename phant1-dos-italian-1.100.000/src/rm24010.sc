;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24010)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm24010 0
)

(local
	local0
	local1
	local2
	local3 = 10
	local4
	local5
	local6
	local7
)

(procedure (localproc_0 param1)
	(if (and (== gChapter 2) (IsFlag 292))
		(harrietsJunk cel: 1)
	)
	(switch param1
		(24010
			(harrietsJunk view: 24330 show: posn: 125 101)
		)
		(24330
			(harrietsJunk view: 24330 show: posn: 125 101)
		)
		(24340
			(harrietsJunk view: 24341 show: posn: 147 148)
		)
		(24320
			(harrietsJunk view: 24321 show: posn: 137 146)
		)
		(24160
			(harrietsJunk view: 24161 show: posn: 196 97)
		)
		(24300
			(harrietsJunk view: 24301 show: posn: 260 140)
		)
	)
)

(instance sHarrietWhines of Script
	(properties)

	(method (doit)
		(if (IsFlag 164)
			(if (gGDacSound handle:)
				(gGDacSound stop:)
			)
			(self dispose:)
		)
		(if
			(and
				(gGDacSound handle:)
				(gEgo robot:)
				(not (OneOf ((gEgo robot:) robot:) 3400 3350 3300))
			)
			(gGDacSound stop:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(Lock 140 24030 0) ; WAVE
		(Lock 140 24031 0) ; WAVE
		(Lock 140 24032 0) ; WAVE
		(Lock 140 24034 0) ; WAVE
		(Lock 140 24035 0) ; WAVE
		(Lock 140 24036 0) ; WAVE
		(gGDacSound client: 0)
		(= next 0)
		(if scratch
			(scratch release: dispose:)
			(= scratch 0)
		)
		(super dispose: &rest)
	)

	(method (init &tmp temp0)
		(Lock 140 24030 1) ; WAVE
		(Lock 140 24031 1) ; WAVE
		(Lock 140 24032 1) ; WAVE
		(Lock 140 24034 1) ; WAVE
		(Lock 140 24035 1) ; WAVE
		(Lock 140 24036 1) ; WAVE
		(= scratch (Set new:))
		(for ((= temp0 0)) (< temp0 100) ((++ temp0))
			(scratch add: (Random 24030 24036))
		)
		(scratch delete: 24033)
		(= next -1)
		(gGDacSound setLoop: 1)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(self changeState: (+ state 1))
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (and (& register $0001) (!= (gCurRoom number:) 24100))
					(gGame handsOff:)
					(self setScript: (ScriptID 0 5) self 5) ; takeLastStep
				else
					(self cue:)
				)
				(= register 0)
			)
			(1
				(switch gCurRoomNum
					(24610
						(gGDacSound setVol: 40)
					)
					(24010
						(gGDacSound setVol: 40)
					)
					(24000
						(gGDacSound setVol: 60)
					)
					(24100
						(gGDacSound setVol: 100)
					)
					(28300
						(self dispose:)
					)
				)
				(self cue:)
			)
			(2
				(if (IsFlag 164)
					(self dispose:)
					(return)
				else
					(= cycles 1)
				)
			)
			(3
				(if
					(and
						(not (IsFlag 164))
						(not (gCurRoom inset:))
						(not
							(and
								(gEgo robot:)
								(not
									(OneOf
										((gEgo robot:) robot:)
										3400
										3350
										3300
									)
								)
							)
						)
					)
					(if (== (++ next) (scratch size:))
						(scratch release:)
						(for ((= temp0 0)) (< temp0 100) ((++ temp0))
							(scratch add: (Random 24030 24036))
						)
						(scratch delete: 24033)
						(= next 0)
					)
					(gGDacSound number: (scratch at: next) play:)
				)
				(self cue:)
			)
			(4
				(= seconds (Random 5 12))
			)
			(5
				(self changeState: 3)
			)
		)
	)
)

(instance rm24010 of ScaryRoom
	(properties)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 28300)
			(global114 stop: 1)
		)
		(ClearFlag 121)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init &tmp temp0)
		(= temp0 0)
		(gEgo init: setScaler: Scaler 184 44 143 81 normalize: 3)
		(switch gPrevRoomNum
			(900)
			(else
				(= picture 24300)
				(doorExit init: 1)
				(mainCH init: 4)
				(gEgo
					normalize: 4
					setScaler: Scaler 93 60 120 93
					posn: 158 117
				)
				(= temp0 (ScriptID 0 5)) ; takeLastStep
			)
		)
		(cond
			((== gChapter 3)
				(if (IsFlag 164)
					(= picture 24300)
					(gEgo setScaler: Scaler 93 60 120 93)
					(if (not (IsFlag 358))
						(cyrusCooker init: setHotspot: 4 3) ; Do, Move
					)
					(if (not (IsFlag 359))
						(harrietCooker init: setHotspot: 4 3 15) ; Do, Move, invTarot
					else
						(harrietCooker init: setHotspot: 0 15) ; invTarot
					)
					(doorExit init: 1)
					(mainCH init: 4)
					(= local6 1)
					(listOfSounds addToFront: 24037)
					(listOfSounds addToFront: 24038)
					(listOfSounds addToFront: 24039)
					(listOfSounds addToFront: 24040)
					(Lock 140 24037 1) ; WAVE
					(Lock 140 24038 1) ; WAVE
					(Lock 140 24039 1) ; WAVE
					(Lock 140 24040 1) ; WAVE
					(peelPotatoes init: setScript: sCooking)
				else
					(gGame handsOn:)
					(= temp0 sHarrietWhines)
				)
			)
			((== gChapter 4)
				(= picture 24300)
				(gEgo setScaler: Scaler 93 60 120 93)
				(doorExit init: 1)
				(mainCH init: 4)
				(cond
					((and (not (IsFlag 185)) (IsFlag 325))
						(gEgo posn: 158 114 view: 4)
						(gEgo cel: 0 setCycle: End)
						(gCurRoom picture: 24300)
						(cyrusSkinner init: setHotspot: 4 3) ; Do, Move
						(bob init: setScript: sSkinning)
					)
					((IsFlag 185)
						(gEgo posn: 158 117 normalize: 4)
						(harrietsJunk init:)
						(localproc_0 24300)
						(harrietSleeps init: cycleSpeed: 6 setCycle: Fwd)
						(Load 140 24045) ; WAVE
						(Lock 140 24045 1) ; WAVE
						(= local5 24045)
						(harrietSnores init: setLoop: -1 play:)
						(= temp0 (ScriptID 0 5)) ; takeLastStep
					)
					(else
						(gEgo posn: 158 117 normalize: 4)
						(= temp0 (ScriptID 0 5)) ; takeLastStep
						(harrietsJunk init:)
						(localproc_0 24300)
					)
				)
			)
			((and (== gChapter 6) (not (IsFlag 206)))
				(if (not (IsFlag 349))
					(= picture 24300)
					(gEgo setScaler: Scaler 93 60 120 93)
					(if (not (IsFlag 369))
						(cyrusPacker init: setHotspot: 4 3) ; Do, Move
					)
					(if (not (IsFlag 368))
						(harrietPacker init: setHotspot: 4 3) ; Do, Move
					)
					(doorExit init: 1)
					(mainCH init: 4)
					(= local6 1)
					(listOfSounds addToFront: 24041)
					(listOfSounds addToFront: 24042)
					(listOfSounds addToFront: 24043)
					(listOfSounds addToFront: 24044)
					(Lock 140 24041 1) ; WAVE
					(Lock 140 24042 1) ; WAVE
					(Lock 140 24043 1) ; WAVE
					(Lock 140 24044 1) ; WAVE
					(= temp0 sBumsPack)
				)
			)
			((and (== gChapter 6) (IsFlag 206) (not (IsFlag 381)))
				(gCurRoom baseView: 6000)
				(= picture 24300)
				(= temp0 sBumsGone)
			)
		)
		(if (and (< gChapter 4) (not (IsFlag 164)))
			(harrietsJunk init:)
			(if (and (== gChapter 2) (not (IsFlag 292)))
				(harrietsJunk setHotspot: 4 3 approachVerbs: 4 3) ; Do, Move, Do, Move
			)
			(= picture 24160)
			(if (gFeatures contains: doorExit)
				(doorExit dispose:)
			)
			(if (gFeatures contains: mainCH)
				(mainCH dispose:)
			)
			(westDoor init: 4)
			(southExit init: 3)
			(localproc_0 24160)
			(gCurRoom baseView: 6000)
			(gEgo
				init:
				show:
				posn: 146 133 0
				normalize: 616
				setScaler: Scaler 67 47 129 93
			)
		)
		(if (== picture -1)
			(= picture 24300)
			(gEgo setScaler: Scaler 93 60 120 93)
		)
		(super init: &rest)
		(if temp0
			(if (== temp0 sHarrietWhines)
				(sHarrietWhines register: 1 init:)
			else
				(gCurRoom setScript: temp0)
			)
		else
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(ClearFlag 139)
		(if (!= 0 local5)
			(Lock 140 local5 0) ; WAVE
		)
		(if (!= 0 local6)
			(for ((= local7 0)) (< local7 4) ((++ local7))
				(Lock 140 (listOfSounds at: local7) 0) ; WAVE
			)
		)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance bob of Prop
	(properties
		x -1
		y -99
		view 0
		signal 16384
	)
)

(instance don of Actor ; UNUSED
	(properties
		x 232
		y 99
		view 0
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local2 0)
					(++ local2)
					(gCurRoom setScript: sDonWaits)
				else
					(gCurRoom setScript: sIGoToWork)
				)
			)
			(19 ; invDrainCln
				(gCurRoom setScript: sGiveDonCleaner)
			)
			(else
				(gCurRoom setScript: sOtherInvOnDon)
			)
		)
	)
)

(instance harrietsJunk of View
	(properties
		approachX 197
		approachY 91
		x 208
		y 136
		view 24341
	)

	(method (init)
		(if (and (== gChapter 2) (IsFlag 292))
			(= cel 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(harrietsJunk setHotspot: 0)
				(gCurRoom setScript: sDonTimer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getPacking of Prop
	(properties
		x 188
		y 135
		view 5543
	)
)

(instance packNoises of Sound
	(properties
		number 24041
	)
)

(instance harrietSleeps of Prop
	(properties
		x 165
		y 127
		view 4604
	)
)

(instance harrietSnores of Sound
	(properties
		number 24045
	)
)

(instance peelPotatoes of Prop
	(properties
		x 249
		y 131
		view 3482
	)
)

(instance donFarHotspot of Feature
	(properties
		nsLeft 199
		nsTop 51
		nsRight 224
		nsBottom 118
		y 200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sIGoToWork)
			)
			(19 ; invDrainCln
				(gCurRoom setScript: sGiveDonCleaner)
			)
			(else
				(gCurRoom setScript: sOtherInvOnDon)
			)
		)
	)
)

(instance donCloseHotspot of Feature ; UNUSED
	(properties
		nsLeft 127
		nsTop 21
		nsRight 248
		nsBottom 129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sIGoToWork)
			)
			(19 ; invDrainCln
				(gCurRoom setScript: sGiveDonCleaner)
			)
			(else
				(gCurRoom setScript: sOtherInvOnDon)
			)
		)
	)
)

(instance cyrusSkinner of Feature
	(properties
		nsLeft 243
		nsTop 100
		nsRight 283
		nsBottom 128
		approachX 263
		approachY 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 121)
				(if (or (IsFlag 184) (not (IsFlag 176)))
					(if (IsFlag 378)
						(gCurRoom setScript: stillSkinning)
					else
						(gCurRoom setScript: skinSquirrels)
					)
				else
					(gCurRoom setScript: cyrusGivesInfo)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stewPot of Feature ; UNUSED
	(properties
		nsLeft 143
		nsTop 97
		nsRight 173
		nsBottom 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 4 3) ; Do, Move
				(gCurRoom setScript: checkOutStew)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cyrusCooker of Feature
	(properties
		nsLeft 236
		nsTop 94
		nsRight 273
		nsBottom 126
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 121)
				(gCurRoom setScript: cyrusCooking)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance harrietCooker of Feature
	(properties
		nsLeft 198
		nsTop 76
		nsRight 222
		nsBottom 96
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; invTarot
				(ClearFlag 121)
				(gCurRoom setScript: giveCards)
			)
			(4 ; Do
				(ClearFlag 121)
				(if (not (IsFlag 359))
					(gCurRoom setScript: harrietCooking)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cyrusPacker of Feature
	(properties
		nsLeft 227
		nsTop 93
		nsRight 259
		nsBottom 121
		approachX 243
		approachY 107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 121)
				(if (not (IsFlag 138))
					(gCurRoom setScript: sBumsPacking)
				else
					(gCurRoom setScript: cyrusBailing)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance harrietPacker of Feature
	(properties
		nsLeft 195
		nsTop 81
		nsRight 208
		nsBottom 104
		approachX 201
		approachY 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(ClearFlag 121)
				(if (not (IsFlag 138))
					(gCurRoom setScript: sBumsPacking)
				else
					(gCurRoom setScript: stillBailing)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance donHotspot of Feature
	(properties
		nsLeft 219
		nsTop 67
		nsRight 260
		nsBottom 126
		y 150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local2 0)
					(++ local2)
					(gCurRoom setScript: sDonWaits)
				else
					(gCurRoom setScript: sIGoToWork)
				)
			)
			(19 ; invDrainCln
				(gCurRoom setScript: sGiveDonCleaner)
			)
			(else
				(gCurRoom setScript: sOtherInvOnDon)
			)
		)
	)
)

(instance westDoor of ExitFeature
	(properties
		nextRoom 24610
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 131
		nsTop 41
		nsRight 179
		nsBottom 90
		approachX 155
		approachY 65
		x 155
		y 65
		nextRoom 28300
	)
)

(instance mainCH of ExitFeature
	(properties
		nsLeft 68
		nsTop 62
		nsRight 113
		nsBottom 84
		approachX 90
		approachY 73
		x 90
		y 73
		nextRoom 24000
	)
)

(instance door of ExitFeature ; UNUSED
	(properties
		nsLeft 131
		nsTop 37
		nsRight 183
		nsBottom 92
		approachX 148
		approachY 97
		x 157
		y 64
		nextRoom 28300
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or local0 local1)
					(gCurRoom setScript: sIGoToWork)
				else
					(gCurRoom newRoom: 28300)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 128
		nsRight 319
		nsBottom 130
		approachX 160
		approachY 200
		y 164
		nextRoom 24000
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 0
		nsTop -1
		nsRight 49
		nsBottom 129
		approachY 200
		nextRoom 24000
	)
)

(instance sSkinning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom plane:)
					(gCurRoom drawPic: 24300 picture: 24300)
				)
				(self cue:)
			)
			(1
				(gEgo hide:)
				(proc1111_7 4600 172 92)
				(gEgo show:)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance sSnoring of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(gGame handsOn:)
				(gCurRoom drawPic: 24340 picture: 24340)
				(proc1111_7 4605 20 55)
			)
			(1
				(ClearFlag 121)
				(self changeState: 0)
			)
		)
	)
)

(instance cookSound of Sound
	(properties
		number 24037
	)
)

(instance listOfSounds of List
	(properties)
)

(instance sCooking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gEgo posn: 158 117 view: 4)
				(if (== local4 0)
					(gEgo cel: 0 setCycle: End)
					(= local4 1)
				)
				(if (!= (gCurRoom picture:) 24300)
					(gCurRoom drawPic: 24300 picture: 24300)
				)
				(self cue:)
			)
			(1
				(peelPotatoes init: cycleSpeed: 6 cel: 0 setCycle: End self)
				(cookSound number: (Random 24037 24040) play:)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance sBumsPack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gEgo posn: 158 117 view: 4)
				(if (== local4 0)
					(gEgo cel: 0 setCycle: End)
					(= local4 1)
				)
				(gCurRoom drawPic: 24300 picture: 24300)
				(self cue:)
			)
			(1
				(getPacking init: cel: 0 setCycle: End self cycleSpeed: 6)
				(packNoises number: (Random 24041 24044) play:)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance harrietCooking of Script
	(properties)

	(method (dispose)
		(if (IsFlag 179)
			(harrietCooker dispose:)
			(= global118 1)
			(= global192 gNormalCursor)
		else
			(harrietCooker setHotspot: 0 15) ; invTarot
			(= global118 1)
			(= global192 gNormalCursor)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(gCurRoom drawPic: 24160 picture: 24160)
			(westExit init: 4)
			(gGame handsOn:)
			(peelPotatoes setScript: sCooking)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(SetFlag 359)
					(if (gCast contains: peelPotatoes)
						(peelPotatoes dispose:)
					)
					(gGame handsOff:)
					(westExit dispose:)
					(proc1111_6)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 3481)
				)
				(2
					(gCurRoom drawPic: 24160 picture: 24160)
					(westExit init: 4)
					(gGame handsOn:)
					(peelPotatoes setScript: sCooking)
					(self dispose:)
				)
			)
		)
	)
)

(instance cyrusCooking of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(cyrusCooker setHotspot: 0)
			(westExit init: 4)
			(gGame handsOn:)
			(peelPotatoes setScript: sCooking)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(SetFlag 358)
					(if (gCast contains: peelPotatoes)
						(peelPotatoes dispose:)
					)
					(westExit dispose:)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24610 picture: 24610)
					(proc1111_7 3490 27 -32)
				)
				(2
					(gCurRoom drawPic: 24580 picture: 24580)
					(proc1111_7 3491 80 -37 gEgo 200)
				)
				(3
					(gCurRoom drawPic: 24610 picture: 24610)
					(proc1111_7 3492 17 -31)
				)
				(4
					(gCurRoom drawPic: 24580 picture: 24580)
					(proc1111_7 3493 67 -27)
				)
				(5
					(gCurRoom drawPic: 24610 picture: 24610)
					(proc1111_7 3494 38 -31)
				)
				(6
					(cyrusCooker setHotspot: 0)
					(gCurRoom drawPic: 24160 picture: 24160)
					(westExit init: 4)
					(gGame handsOn:)
					(peelPotatoes setScript: sCooking)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveCards of Script
	(properties)

	(method (dispose)
		(if (gEgo has: 9) ; invTarot
			(gEgo put: 9) ; invTarot
		)
		(SetFlag 179)
		(if (IsFlag 359)
			(harrietCooker dispose:)
			(= global118 1)
			(= global192 gNormalCursor)
		else
			(harrietCooker setHotspot: 4 3) ; Do, Move
			(= global118 1)
			(= global192 gNormalCursor)
		)
		(= next sCooking)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (gEgo has: 9) ; invTarot
						(gEgo put: 9) ; invTarot
					)
					(SetFlag 179)
					(if (gCast contains: peelPotatoes)
						(peelPotatoes dispose:)
					)
					(westExit dispose:)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24610 picture: 24610)
					(proc1111_7 3500 -3 -22)
				)
				(2
					(gCurRoom drawPic: 24570 picture: 24570)
					(proc1111_7 3501 -4 -39)
				)
				(3
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 3502 -4 -39)
				)
				(4
					(self dispose:)
				)
			)
		)
	)
)

(instance checkOutStew of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(gGame handsOn:)
			(gCurRoom setScript: sCooking)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (gCast contains: peelPotatoes)
						(peelPotatoes dispose:)
					)
					(westExit dispose:)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 3510 0 -35)
				)
				(2
					(gGame handsOn:)
					(westExit init:)
					(gCurRoom setScript: sCooking)
					(self dispose:)
				)
			)
		)
	)
)

(instance myTimer of Timer
	(properties)
)

(instance sDonTimer of Script
	(properties)

	(method (dispose)
		(= global115 0)
		(ClearFlag 248)
		(ClearFlag 121)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (and global115 (< state 6))
			(= global115 0)
			(SetFlag 121)
			(SetFlag 292)
			(proc1111_6)
			(gEgo normalize: 613 z: 1000)
			(= state 6)
			(self cue:)
		else
			(switch (= state newState)
				(0
					(if (gFeatures contains: westDoor)
						(westDoor dispose:)
					)
					(SetFlag 121)
					(SetFlag 248)
					(gEgo normalize: 613 z: 1000)
					(harrietsJunk setHotspot: 0)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(localproc_0 24300)
					(harrietsJunk setPri: 1)
					(gCurRoom drawPic: 24300 picture: 24300)
					(proc1111_7 2570 53 11 gEgo 150)
				)
				(2
					(localproc_0 24320)
					(gCurRoom drawPic: 24320 picture: 24320)
					(proc1111_7 2571 -8 0)
					(ClearFlag 121)
				)
				(3
					(harrietsJunk hide:)
					(gCurRoom drawPic: 24330 picture: 24330)
					(proc1111_7 2572 -8 0)
				)
				(4
					(localproc_0 24340)
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 2573 13 -6 gEgo -1)
				)
				(5
					(harrietsJunk cel: 1)
					(UpdateScreenItem harrietsJunk)
					(SetFlag 292)
				)
				(6
					(harrietsJunk hide:)
					(gCurRoom drawPic: 24350 picture: 24350)
					(proc1111_7 2574 -10 0)
				)
				(7
					(gGame handsOn:)
					(SetFlag 417)
					(harrietsJunk hide:)
					(myTimer set: self 10)
					(Load rsMESSAGE 24010)
					(Lock rsMESSAGE 24010 1)
					(gCurRoom drawPic: 24300 picture: 24300)
					(donHotspot
						init:
						setHotspot:
							4 ; Do
							3 ; Move
							0
							8 ; invLibKey
							6 ; invMoney
							7 ; invNail
							9 ; invNewspaper
							10 ; invPoker
							11 ; invHammer
							12 ; invStairKey
							13 ; invVampBook
							14 ; invMatch
							15 ; invTarot
							16 ; invBrooch
							17 ; invPhoto
							18 ; invLensPiece
							19 ; invDrainCln
							20 ; invCrucifix
							22 ; invBeads
							23 ; invSpellBook
							25 ; invXmasOrn
							26 ; invStone
							27 ; invCutter
							28 ; invDogBone
							34 ; invFigurine
					)
					(= local0 1)
					(if (gFeatures contains: southExit)
						(southExit dispose:)
					)
					(proc1111_7 2575 136 23 gEgo 100)
				)
				(8
					(gGame handsOff:)
					(ClearFlag 417)
					(= local0 0)
					(donHotspot dispose:)
					(gCurRoom drawPic: 24350 picture: 24350)
					(proc1111_7 2650 -16 -9)
				)
				(9
					(localproc_0 24300)
					(gCurRoom drawPic: 24300 picture: 24300)
					(proc1111_7 2591 108 20)
				)
				(10
					(gCurRoom drawPic: 24160 picture: 24160)
					(localproc_0 24160)
					(southExit init: 3)
					(westDoor init: 4)
					(gEgo show: posn: 173 108 0 normalize: 611)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDonWaits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gFeatures contains: donHotspot)
					(donHotspot dispose:)
				)
				(proc1111_6)
				(gCast eachElementDo: #hide)
				(self cue:)
			)
			(1
				(SetFlag 121)
				(gGame handsOff:)
				(gCurRoom drawPic: 24350 picture: 24350)
				(proc1111_7 2580)
			)
			(2
				(gGame handsOn:)
				(if (myTimer seconds:)
					(myTimer set: self (myTimer seconds:))
				else
					(= seconds 1)
				)
				(donFarHotspot
					init:
					setHotspot:
						4 ; Do
						3 ; Move
						0
						8 ; invLibKey
						6 ; invMoney
						7 ; invNail
						9 ; invNewspaper
						10 ; invPoker
						11 ; invHammer
						12 ; invStairKey
						13 ; invVampBook
						14 ; invMatch
						15 ; invTarot
						16 ; invBrooch
						17 ; invPhoto
						18 ; invLensPiece
						19 ; invDrainCln
						20 ; invCrucifix
						22 ; invBeads
						23 ; invSpellBook
						25 ; invXmasOrn
						26 ; invStone
						27 ; invCutter
						28 ; invDogBone
						34 ; invFigurine
				)
				(localproc_0 24300)
				(gCurRoom drawPic: 24300 picture: 24300)
				(proc1111_7 2581 128 13)
			)
			(3
				(proc1111_6)
				(donFarHotspot dispose:)
				(gGame handsOff:)
				(= next sIGoToWork)
				(self dispose:)
			)
		)
	)
)

(instance sIGoToWork of Script
	(properties)

	(method (dispose)
		(ClearFlag 121)
		(ClearFlag 248)
		(if (gTimers contains: myTimer)
			(gTimers delete: myTimer)
		)
		(Lock rsMESSAGE 24010 0)
		(westDoor init: 4)
		(gEgo show: posn: 173 108 0 normalize: 611)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(if (gFeatures contains: donHotspot)
				(donHotspot dispose:)
			)
			(gCast eachElementDo: #show)
			(localproc_0 24160)
			(if (gFeatures contains: donFarHotspot)
				(donFarHotspot dispose:)
			)
			(southExit init: 3)
			(gCurRoom drawPic: 24160 picture: 24160)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gTimers contains: myTimer)
						(gTimers delete: myTimer)
					)
					(if (gFeatures contains: donHotspot)
						(donHotspot dispose:)
					)
					(= local0 0)
					(= local1 0)
					(proc1111_6)
					(if (gFeatures contains: donFarHotspot)
						(donFarHotspot dispose:)
					)
					(self cue:)
				)
				(1
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 24350 picture: 24350)
					(proc1111_7 2620 -10 -45)
				)
				(2
					(ClearFlag 121)
					(localproc_0 24300)
					(gCurRoom drawPic: 24300 picture: 24300)
					(proc1111_7 2591 108 20)
				)
				(3
					(gCurRoom drawPic: 24160 picture: 24160)
					(southExit init: 3)
					(donHotspot dispose:)
					(gCast eachElementDo: #show)
					(localproc_0 24160)
					(self dispose:)
				)
			)
		)
	)
)

(instance sOtherInvOnDon of Script
	(properties)

	(method (dispose)
		(ClearFlag 248)
		(if (gTimers contains: myTimer)
			(gTimers delete: myTimer)
		)
		(Lock rsMESSAGE 24010 0)
		(westDoor init: 4)
		(gEgo show: posn: 173 108 0 normalize: 611)
		(if (gFeatures contains: donHotspot)
			(donHotspot dispose:)
		)
		(gCast eachElementDo: #show)
		(localproc_0 24160)
		(southExit init: 3)
		(gCurRoom drawPic: 24160 picture: 24160)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (gTimers contains: myTimer)
						(gTimers delete: myTimer)
					)
					(if (gFeatures contains: donFarHotspot)
						(donFarHotspot dispose:)
					)
					(proc1111_6)
					(gGame handsOff:)
					(self cue:)
					(gCast eachElementDo: #hide)
				)
				(1
					(gCurRoom drawPic: 24350 picture: 24350)
					(proc1111_7 2640 -6 -6)
				)
				(2
					(localproc_0 24300)
					(gCurRoom drawPic: 24300 picture: 24300)
					(proc1111_7 2591 108 20)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

(instance sGiveDonCleaner of Script
	(properties)

	(method (dispose)
		(ClearFlag 248)
		(ClearFlag 121)
		(gEgo show: posn: 173 108 0 normalize: 611)
		(if (gTimers contains: myTimer)
			(gTimers delete: myTimer)
		)
		(Lock rsMESSAGE 24010 0)
		(gCurRoom drawPic: 24160 picture: 24160)
		(localproc_0 24160)
		(gGame handsOn:)
		(southExit init: 3)
		(westDoor init: 4)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(if (gEgo has: 13) ; invDrainCln
						(gEgo put: 13) ; invDrainCln
					)
					(SetFlag 163)
					(proc1111_6)
					(if (gFeatures contains: donHotspot)
						(donHotspot dispose:)
					)
					(if (gFeatures contains: donFarHotspot)
						(donFarHotspot dispose:)
					)
					(= global115 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gTimers contains: myTimer)
						(gTimers delete: myTimer)
					)
					(gEgo put: 13) ; invDrainCln
					(SetFlag 163)
					(if (gFeatures contains: donFarHotspot)
						(donFarHotspot dispose:)
					)
					(if (gFeatures contains: donHotspot)
						(donHotspot dispose:)
					)
					(if (gCast contains: harrietsJunk)
						(harrietsJunk hide:)
					)
					(proc1111_6)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24350 picture: 24350)
					(proc1111_7 2630 -25 0)
				)
				(2
					(ClearFlag 121)
					(localproc_0 24300)
					(gCurRoom drawPic: 24300 picture: 24300)
					(proc1111_7 2591 108 20)
				)
				(3
					(self dispose:)
				)
			)
		)
	)
)

(instance skinSquirrels of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(gGame handsOn:)
			(bob setScript: sSkinning)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(SetFlag 378)
					(proc1111_6)
					(gGame handsOff:)
					(bob setScript: 0)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 4601 -53 -41)
				)
				(2
					(gCurRoom drawPic: 24580 picture: 24580)
					(proc1111_7 4602 -12 -51)
				)
				(3
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 4603 -33 -51)
				)
				(4
					(gGame handsOn:)
					(bob setScript: sSkinning)
					(self dispose:)
				)
			)
		)
	)
)

(instance stillSkinning of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_6)
					(bob setScript: 0)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 4610 -53 -41 gEgo 20)
				)
				(2
					(gGame handsOn:)
					(bob setScript: sSkinning)
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(gGame handsOn:)
			(bob setScript: sSkinning)
			(self dispose:)
		)
	)
)

(instance cyrusGivesInfo of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(SetFlag 185)
			(= global115 0)
			(gCurRoom newRoom: 28300)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 4620 -15 -45)
				)
				(1
					(gCurRoom drawPic: 24580 picture: 24580)
					(proc1111_7 4623 85 -10)
				)
				(2
					(gCurRoom drawPic: 24340 picture: 24340)
					(gEgo hide:)
					(proc1111_7 4624 28 -43 gEgo -1 1)
				)
				(3
					(SetFlag 185)
					(gCurRoom newRoom: 28300)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBumsPacking of Script
	(properties)

	(method (dispose)
		(SetFlag 138)
		(= next sBumsPack)
		(global114 endPause: 1)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gCast contains: getPacking)
						(getPacking dispose:)
					)
					(if (gSounds contains: packNoises)
						(packNoises dispose:)
					)
					(gGame handsOff:)
					(SetFlag 138)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24330 picture: 24330)
					(proc1111_7 5540 -5 -60 gEgo 200)
				)
				(2
					(global114 pause:)
					(gCurRoom drawPic: 24570 picture: 24570)
					(proc1111_7 5541 -33 -44)
				)
				(3
					(gCurRoom drawPic: 24330 picture: 24330)
					(proc1111_7 5542 -13 -44)
				)
				(4
					(self dispose:)
				)
			)
		else
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance stillBailing of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(gCurRoom setScript: sBumsPack)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (gSounds contains: packNoises)
						(packNoises dispose:)
					)
					(if (gFeatures contains: harrietPacker)
						(harrietPacker dispose:)
					)
					(SetFlag 368)
					(if (gCast contains: getPacking)
						(getPacking dispose:)
					)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 5570 -22 -25)
				)
				(2
					(gCurRoom setScript: sBumsPack)
				)
				(3
					(proc1111_6)
					(gCurRoom setScript: sBumsPack)
					(self dispose:)
				)
			)
		)
	)
)

(instance cyrusBailing of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(gGame handsOn:)
			(gCurRoom setScript: sBumsPack)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (gSounds contains: packNoises)
						(packNoises dispose:)
					)
					(if (gFeatures contains: cyrusPacker)
						(cyrusPacker dispose:)
					)
					(SetFlag 369)
					(proc1111_6)
					(if (gCast contains: getPacking)
						(getPacking dispose:)
					)
					(gGame handsOff:)
					(self cue:)
				)
				(1
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 5580 -32 -29)
				)
				(2
					(SetFlag 121)
					(gCurRoom drawPic: 24580 picture: 24580)
					(proc1111_7 5581 -10 -52)
				)
				(3
					(ClearFlag 121)
					(gCurRoom drawPic: 24340 picture: 24340)
					(proc1111_7 5582 -6 -37)
				)
				(4
					(gCurRoom setScript: sBumsPack)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBumsGone of Script
	(properties)

	(method (dispose)
		(SetFlag 381)
		(gCurRoom picture: 24160 drawPic: 24160)
		(gEgo normalize: 614 setScaler: Scaler 67 47 129 93 posn: 237 116)
		(if (gFeatures contains: doorExit)
			(doorExit dispose:)
		)
		(if (gFeatures contains: mainCH)
			(mainCH dispose:)
		)
		(westDoor init: 4)
		(southExit init: 3)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(= global115 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 5530 115 28)
				)
				(1
					(self dispose:)
				)
			)
		)
	)
)

