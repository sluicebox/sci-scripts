;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use ExitFeature)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
	sallyTalker 1
	benTalker 16
	deborahTalker 17
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(switch local2
		(1
			(benTalker x: 26 y: 81 talkWidth: 180 tailPosn: 1)
		)
		(2
			(benTalker x: 59 y: 108 talkWidth: 180 tailPosn: 0)
		)
	)
)

(procedure (localproc_1)
	(if argc
		(gNarrator x: 25 y: 20)
	else
		(gNarrator x: -1 y: -1)
	)
)

(instance rm320 of ADRoom
	(properties
		noun 44
		south 310
		vanishingY -60
	)

	(method (init)
		(if (!= gPrevRoomNum 331)
			(= picture 320)
		)
		(super init: &rest)
		((ScriptID 895 0) ; pepper
			init:
			normalize:
			setScale: 0
			ignoreActors: 1
			illegalBits: 0
			x: 129
			y: 114
		)
		(= curPic (= picture 320))
		(gGame setCursor: gNormalCursor 1 304 172)
		(cond
			((and (not (IsFlag 75)) (== gAct 6))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 212 110 225 149 140 186 88 166 100 144 100 127 152 113
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 92 108 81 108 65 109 59 114 45 114 61 119 67 126 96 126 96 136 65 174 42 171 27 168 32 189 212 189 212 185 258 185 258 162 217 120 217 108 130 108
							yourself:
						)
				)
			)
			((and (IsFlag 58) (not (IsFlag 55)))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 92 108 81 108 65 109 59 114 45 114 61 119 67 126 81 125 86 140 82 165 65 174 42 171 27 168 32 189 218 189 218 185 258 185 258 162 228 133 228 146 191 164 144 179 88 156 101 144 200 113
							yourself:
						)
				)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 212 110 225 149 140 186 88 166 96 129 152 113
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 92 108 81 108 65 109 59 114 45 114 61 119 67 126 81 125 86 140 82 165 65 174 42 171 27 168 32 189 218 189 218 185 258 185 258 162 217 120 217 108 130 108
							yourself:
						)
				)
			)
		)
		(if (not (IsFlag 22))
			(magnet init: stopUpd:)
		)
		(if (not (IsFlag 70))
			(stopper init: stopUpd:)
		)
		(if (not (IsFlag 34))
			(schematic init: stopUpd:)
		)
		(if (IsFlag 47)
			(stepStool init: stopUpd:)
		)
		(if (and (not (IsFlag 61)) (IsFlag 55))
			(specialEdition init: stopUpd:)
		)
		(if (!= gPrevRoomNum 331)
			(gLongSong number: 320 setLoop: -1 play:)
		)
		(if (OneOf gAct 5 6)
			(cond
				((< gAct 6)
					(if (and (IsFlag 58) (not (IsFlag 55)))
						(ben
							init:
							view: 323
							loop: 0
							cel: 0
							posn: 224 128
							setCycle: Fwd
						)
						(= local2 1)
					else
						(ben
							init:
							view: 327
							loop: 0
							cel: 0
							posn: 47 154
							setPri: 12
							setScript: writingScr
						)
						(= local2 2)
					)
				)
				((IsFlag 60)
					(ben
						init:
						view: 327
						loop: 0
						cel: 0
						posn: 47 154
						setPri: 12
						setScript: writingScr
						ignoreActors: 1
					)
				)
				(else
					(kite init: stopUpd:)
					(ben
						init:
						view: 322
						setLoop: 1
						cel: 0
						posn: 60 135
						ignoreActors: 1
					)
				)
			)
		)
		(ladder init: approachVerbs: 7 setOnMeCheck: 1 2) ; Do
		(printingPress init: setOnMeCheck: 1 8)
		(bottomOfLadder init:)
		(northBin init: setOnMeCheck: 1 64)
		(southBin init: setOnMeCheck: 1 16384)
		(clock init: setOnMeCheck: 1 2048)
		(barrel init: setOnMeCheck: 1 4096)
		(desk init: setOnMeCheck: 1 8192)
		(door init: setOnMeCheck: 1 -32768)
		(plasterBag init: setOnMeCheck: 1 4)
		(if (IsFlag 311)
			(lever init:)
		)
		(pic1 init:)
		(pic2 init:)
		(pic3 init:)
		(pic4 init:)
		(pic5 init:)
		(inkWell init:)
		(papers init:)
		(candle init:)
		(coonskin init:)
		(shelf1 init:)
		(shelf2 init:)
		(shelf3 init:)
		(shelf4 init:)
		(shelf5 init:)
		(shelf6 init:)
		(bookOnBarrel init:)
		(brokenRung init: setOnMeCheck: 1 256)
		(toolChest init: setOnMeCheck: 1 1)
		(tools init:)
		(stool init:)
		(westExitFeature init:)
		(switch gPrevRoomNum
			(321
				(gCurRoom setScript: fromAtticScr)
			)
			(310
				(if (and (== gAct 2) (not (IsFlag 85)))
					(gCurRoom setScript: deborahIntroScr)
				else
					(gCurRoom setScript: fromSitRoomScr)
				)
			)
			(330
				(gCurRoom setScript: fromGardenScr)
			)
			(601
				(switch gAct
					(5
						((ScriptID 895 0) ; pepper
							posn: 83 175
							normalize:
							heading: 315
							loop: 8
							cel: 7
							forceUpd:
						)
						(gCurRoom setScript: actFiveScr)
					)
					(6
						((ScriptID 895 0) ; pepper
							posn: 83 175
							normalize:
							heading: 315
							loop: 8
							cel: 7
							forceUpd:
						)
						(gCurRoom setScript: saveLockjawScr)
					)
				)
			)
			(331
				(gCurRoom setScript: actSixReturnScr)
			)
		)
		(localproc_1 1)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 331)
			(gLongSong fade:)
		)
		((ScriptID 895 0) ignoreActors: 1) ; pepper
		(localproc_1)
		(specialEditionTimer dispose: delete:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $0020)
				(= gNewRoomNum 330)
			)
			(
				(InRect
					26
					189
					215
					189
					((ScriptID 895 0) x:) ; pepper
					((ScriptID 895 0) y:) ; pepper
				)
				(gCurRoom setScript: enterSitRoomScr)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 7 6 85 84)) ; Do, Look, Talk, Trivia
			(gMessager say: 44 88) ; "That won't help Pepper or Ben, either."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ladder of Feature
	(properties
		x 112
		y 49
		approachX 108
		approachY 96
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 47))
			(self noun: 31)
		else
			(self noun: 32)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 63 7) ; StepStool, Do
			(switch theVerb
				(63 ; StepStool
					(gCurRoom setScript: setStoolDownScr)
				)
				(7 ; Do
					(if (IsFlag 47)
						(gGame points: 306 1)
						(gCurRoom setScript: climbLadderScr)
					else
						(gMessager say: 31 7 0) ; "Oh, man, I'm too short to climb up past those broken rungs! If only I had something to step up on..."
					)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance toolChest of Feature
	(properties
		x 236
		y 105
		noun 59
		nsTop 72
		nsLeft 227
		nsBottom 123
		nsRight 247
	)
)

(instance tools of Feature
	(properties
		x 290
		y 65
		noun 60
		nsTop 56
		nsLeft 277
		nsBottom 75
		nsRight 304
		sightAngle 40
		approachX 235
		approachY 142
		approachDist 152
	)
)

(instance stool of Feature
	(properties
		x 57
		y 147
		noun 57
		nsTop 141
		nsLeft 46
		nsBottom 153
		nsRight 69
		sightAngle 40
		approachX 77
		approachY 140
		approachDist 47
	)
)

(instance brokenRung of Feature
	(properties
		noun 10
		approachX 111
		approachY 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; StepStool
				(gCurRoom setScript: setStoolDownScr 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance printingPress of Feature
	(properties
		x 161
		y 117
		noun 41
		sightAngle 40
		approachX 112
		approachY 170
		approachDist 5
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 55)
			(= noun 42)
		else
			(= noun 41)
		)
	)

	(method (doVerb theVerb)
		(localproc_0)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(62 ; Press_Lever
				(self noun: 42)
				(cond
					((not (gCast contains: ben))
						(gMessager say: 44 7) ; "Pepper doesn't want to mess with Ben's stuff. She might break something."
						(return 1)
					)
					((IsFlag 58)
						(gGame points: 311 2)
						(gCurRoom setScript: printPressScr)
					)
					(else
						(gMessager say: 41 62 21) ; "Hmm? What are you doing, child? Be a good lad, and don't distract me now! I'm trying to write something."
					)
				)
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb)
			)
			(else
				(if (not (IsFlag 311))
					(gMessager say: 41 88) ; "That won't fix the printing press."
				else
					(gMessager say: 41 88 24) ; "That really won't improve the design of the printing press."
				)
			)
		)
	)
)

(instance northBin of Feature
	(properties
		x 255
		y 114
		noun 36
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (not (IsFlag 70))
					(gGame points: 307 1)
					(gCurRoom setScript: walkToBinsScr)
				else
					(gMessager say: 36 7 6) ; "Pepper doesn't need another stopper."
				)
			)
			(84 ; Trivia
				(= gDictionaryWord 109)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southBin of Feature
	(properties
		x 279
		y 132
		noun 58
	)
)

(instance clock of Feature
	(properties
		x 264
		y 59
		noun 7
		nsTop 48
		nsLeft 256
		nsBottom 68
		nsRight 276
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barrel of Feature
	(properties
		x 266
		y 168
		noun 4
		nsTop 152
		nsLeft 224
		nsBottom 185
		nsRight 290
	)
)

(instance desk of Feature
	(properties
		x 28
		y 126
		noun 19
	)
)

(instance door of Feature
	(properties
		x 41
		y 76
		noun 20
	)
)

(instance plasterBag of Feature
	(properties
		x 76
		y 95
		noun 40
	)
)

(instance pic1 of Feature
	(properties
		x 220
		y 36
		noun 22
		nsTop 26
		nsLeft 204
		nsBottom 46
		nsRight 237
		sightAngle 40
		approachX 220
		approachY 36
		approachDist 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pic2 of Feature
	(properties
		x 221
		y 59
		noun 21
		nsTop 51
		nsLeft 205
		nsBottom 68
		nsRight 237
		sightAngle 40
		approachX 221
		approachY 59
		approachDist 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pic3 of Feature
	(properties
		x 277
		y 30
		noun 23
		nsTop 18
		nsLeft 259
		nsBottom 43
		nsRight 296
		sightAngle 40
		approachX 277
		approachY 30
		approachDist 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: 84 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pic4 of Feature
	(properties
		x 231
		y 78
		noun 24
		nsTop 72
		nsLeft 225
		nsBottom 84
		nsRight 237
		sightAngle 40
		approachX 231
		approachY 78
		approachDist 15
	)
)

(instance pic5 of Feature
	(properties
		x 71
		y 62
		noun 25
		nsTop 52
		nsLeft 65
		nsBottom 72
		nsRight 78
		sightAngle 40
		approachX 71
		approachY 62
		approachDist 15
	)
)

(instance inkWell of Feature
	(properties
		x 7
		y 123
		noun 27
		nsTop 121
		nsLeft 3
		nsBottom 126
		nsRight 12
		sightAngle 40
		approachX 7
		approachY 123
		approachDist 10
	)
)

(instance papers of Feature
	(properties
		x 29
		y 140
		z 18
		noun 38
		nsTop 118
		nsLeft 16
		nsBottom 127
		nsRight 42
		sightAngle 40
		approachX 29
		approachY 122
		approachDist 10
	)
)

(instance candle of Feature
	(properties
		x 13
		y 85
		noun 13
		nsTop 74
		nsLeft 6
		nsBottom 97
		nsRight 20
		sightAngle 40
		approachX 13
		approachY 85
		approachDist 10
	)
)

(instance lever of View
	(properties
		x 155
		y 115
		view 323
		loop 5
		priority 11
		signal 16400
	)
)

(instance magnet of View
	(properties
		x 285
		y 123
		noun 35
		view 320
		cel 4
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 7 6 85 84) ; Do, Look, Talk, Trivia
			(gMessager say: noun theVerb 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance stopper of View
	(properties
		x 270
		y 107
		noun 36
		view 320
		cel 3
	)

	(method (doVerb theVerb)
		(northBin doVerb: theVerb &rest)
	)
)

(instance schematic of View
	(properties
		x 137
		y 132
		noun 47
		view 320
		cel 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 11)
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 104)
		(switch theVerb
			(7 ; Do
				(gGame points: 305 1)
				(gCurRoom setScript: getSchematicScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stepStool of View
	(properties
		x 91
		y 76
		noun 56
		view 320
		cel 2
	)

	(method (init)
		(self approachVerbs: 7 6 stopUpd:) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(gMessager say: 56 theVerb 18)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ben of Actor
	(properties
		x 113
		y 167
		noun 8
		approachX 73
		approachY 126
		approachDist 10
		view 323
		cel 1
		detailLevel 1
	)

	(method (init)
		(if (!= gAct 6)
			(self approachVerbs: 85) ; Talk
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(localproc_0)
		(switch theVerb
			(64 ; King_s_Letter
				(gGame points: 310 2)
				(gCurRoom setScript: benWorkingScr)
			)
			(62 ; Press_Lever
				(if (IsFlag 58)
					(gMessager say: 8 62 27) ; "Look, Ben, I found the lever!"
				else
					(gMessager say: 41 62 21) ; "Hmm? What are you doing, child? Be a good lad, and don't distract me now! I'm trying to write something."
				)
			)
			(85 ; Talk
				(if (!= ((ScriptID 895 0) heading:) 190) ; pepper
					((ScriptID 895 0) setHeading: 190) ; pepper
				)
				(switch gAct
					(5
						(gGame points: 314 1)
					)
					(6
						(gGame points: 315 1)
					)
				)
				(cond
					((!= gAct 6)
						(cond
							(
								(and
									(not
										(and
											(IsFlag 441)
											(IsFlag 265)
											(IsFlag 266)
											(IsFlag 267)
											(IsFlag 276)
											(IsFlag 277)
											(IsFlag 284)
											(IsFlag 289)
											(IsFlag 219)
											(IsFlag 236)
										)
									)
									(IsFlag 55)
								)
								(gMessager say: 8 85 25) ; "Hurry and deliver the Special Editions, lad! There's no time to waste!"
							)
							(((ScriptID 895 0) has: 28) ; pepper, King_s_Letter
								(gMessager say: 8 85 3) ; "There's nothing more we can do until one of us thinks of a good reason to gather the colonists together, lad."
							)
							((not (IsFlag 311))
								(gMessager say: 8 85 26) ; "The sooner you fix that press, lad, the sooner we can save your dog!"
							)
							(else
								(gMessager say: 8 85 2) ; "Oh, geez, Ben, there HAS to be a reason for the colonists to help us. What if we told them that the Pughs are a bunch of lying, dog-napping, tyrannical creeps?"
							)
						)
					)
					((not (IsFlag 60))
						(if (gCurRoom script:)
							((gCurRoom script:) setScript: talkBenScr)
						else
							(gCurRoom setScript: talkBenScr)
						)
					)
					(else
						(gMessager say: 8 85 23) ; "You'd best hurry and save your dog, lad! We've no time to waste!"
					)
				)
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(if
					(and
						(not
							(and
								(IsFlag 441)
								(IsFlag 265)
								(IsFlag 266)
								(IsFlag 267)
								(IsFlag 276)
								(IsFlag 277)
								(IsFlag 284)
								(IsFlag 289)
								(IsFlag 219)
								(IsFlag 236)
							)
						)
						(IsFlag 55)
						(!= gAct 6)
					)
					(gMessager say: 8 85 25) ; "Hurry and deliver the Special Editions, lad! There's no time to waste!"
				else
					(super doVerb: theVerb)
				)
			)
			(84 ; Trivia
				(gMessager say: 8 84) ; "TRUE. Ben Franklin was real, of course. He really did have a workshop where he invented some amazing things."
			)
			(else
				(gMessager say: 8 88) ; "Hmm? Oh, no thank you, lad."
			)
		)
	)
)

(instance sally of Actor
	(properties
		x 181
		y 176
		noun 46
		view 326
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setScript: sweepingScr)
	)
)

(instance specialEdition of View
	(properties
		x 121
		y 130
		noun 54
		view 320
		cel 7
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 312 1)
				(gCurRoom setScript: getSpecialEditionScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance climbLadderScr of Script
	(properties)

	(method (init)
		(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setCycle: Walk setMotion: PolyPath 91 76 self) ; pepper
			)
			(2
				((ScriptID 895 0) setHeading: 360 self) ; pepper
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 1)
			)
			(4
				(gMessager say: 32 7 0 0 self) ; "I'll just go check out the attic."
			)
			(5
				((ScriptID 895 0) ; pepper
					cycleSpeed: 10
					view: 321
					setLoop: 1
					cel: 0
					ignoreActors: 1
					posn: 91 76
					setCycle: End self
				)
			)
			(6
				((ScriptID 895 0) ; pepper
					setLoop: 2
					cel: 0
					posn: 109 84
					setCycle: End self
				)
			)
			(7
				((ScriptID 895 0) ; pepper
					setLoop: 3
					cel: 0
					posn: 109 38
					setCycle: End self
				)
			)
			(8
				(= gNewRoomNum 321)
				(= cycles 1)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance fromAtticScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: setLoop: 2 cel: 0 posn: 109 107)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance writingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 2)
				(= ticks 30)
			)
			(1
				(ben
					view: 327
					setLoop: 0
					cel: 0
					posn: 47 154
					setCycle: End self
				)
			)
			(2
				(= ticks 300)
			)
			(3
				(ben setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance fromGardenScr of Script
	(properties)

	(method (init)
		(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 35 119
					cycleSpeed: 4
					setCycle: Walk
					setMotion: MoveTo 66 119 self
				)
			)
			(1
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 5)
			)
			(2
				(if (== gAct 4)
					(self setScript: pigeonWarningScr self)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromSitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 150 240
					setCycle: Walk
					setMotion: MoveTo 150 179 self
				)
			)
			(1
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 5)
			)
			(2
				(if (== gAct 4)
					(self setScript: pigeonWarningScr self)
				else
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goQuizScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 600)
				(self dispose:)
			)
		)
	)
)

(instance benWorkingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(writingScr dispose:)
				(gEgo put: 28 gCurRoomNum) ; King_s_Letter
				(SetFlag 58)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 13 164 self
				)
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 325
					setLoop: 2
					cel: 0
					posn: 13 164
					setCycle: End self
				)
			)
			(3
				(gMessager say: 8 64 1 1 2 self) ; "I, uh, I found this letter. It proves that the Stamp Tax is just a dirty trick to fill the General's pockets!"
			)
			(4
				(ben view: 322 setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) view: 1790) ; pepper
				(ben setScript: benReadingScr self)
			)
			(7
				(= gDictionaryWord 13)
				(gMessager say: 8 64 1 3 self) ; "That...that |r||c0|CAD|c||r|! He's been robbing the colony blind! This is just the thing we need to get the colonists on the march to Penn mansion!"
			)
			(8
				(gMessager say: 8 64 1 4 self) ; "Good work, boy! Oh, now I know EXACTLY what to say in this pamphlet!"
			)
			(9
				(self setScript: writingScr)
				(= ticks 160)
			)
			(10
				(writingScr dispose:)
				(ben
					view: 322
					setLoop: 5
					cel: 0
					posn: 56 159
					setCycle: End self
				)
			)
			(11
				(benTalker x: 58 y: 109 tailPosn: 0)
				(gMessager say: 8 64 1 5 self) ; "There! A good piece of work, if I do say so myself! Now to typeset and print this..."
			)
			(12
				(ben
					view: 817
					setLoop: 6
					cel: 0
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo 111 121 self
				)
			)
			(13
				(benTalker x: 129 y: 81 talkWidth: 180 tailPosn: 0)
				(= gDictionaryWord 6)
				(gMessager say: 8 64 1 6 10 self) ; "Oh, dear!"
			)
			(14
				(ben
					setPri: 8
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 224 128 self
				)
			)
			(15
				(ben view: 323 loop: 0 setCycle: Fwd cycleSpeed: 6)
				(= local2 1)
				(= cycles 1)
			)
			(16
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setMotion: MoveTo 54 178 self
				)
			)
			(17
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(18
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 92 108 81 108 65 109 59 114 45 114 61 119 67 126 81 125 86 140 82 165 65 174 42 171 27 168 32 189 218 189 218 185 258 185 258 162 228 133 228 146 191 164 144 179 88 156 101 144 200 113
							yourself:
						)
				)
				(= seconds 2)
			)
			(19
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance benReadingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (= register 1))
			)
			(1
				(ben setCel: 6)
				(= seconds 2)
			)
			(2
				(ben setCel: 7)
				(= cycles 3)
			)
			(3
				(if register
					(-- register)
					(-= state 3)
				)
				(self cue:)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance printPressScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 26 gCurRoomNum) ; Press_Lever
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(printingPress noun: 42)
				(= cycles 1)
			)
			(2
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 176 163 self
				)
			)
			(3
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= seconds 1)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 323
					setLoop: 1
					cycleSpeed: 10
					cel: 0
					posn: 158 162
					setCycle: End self
				)
			)
			(5
				(lever init:)
				((ScriptID 895 0) normalize: setMotion: MoveTo 218 185 self) ; pepper
			)
			(6
				((ScriptID 895 0) setHeading: 315 self) ; pepper
			)
			(7
				(= cycles 2)
			)
			(8
				(gMessager say: 41 62 0 1 2 self) ; "Look, Ben! This lever fits the printing press perfectly!"
			)
			(9
				(ben
					view: 817
					setLoop: -1
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 115 123 self
				)
			)
			(10
				(ben setMotion: MoveTo 130 147 self)
			)
			(11
				(lever dispose:)
				(ben
					view: 323
					setLoop: 3
					setPri: 14
					cel: 0
					posn: 139 150
					setCycle: CT 6 1 self
				)
			)
			(12
				(ben view: 323 setLoop: 2 cel: 0 setCycle: End self)
			)
			(13
				(ben
					view: 323
					setLoop: 3
					cel: 7
					posn: 139 150
					setCycle: End self
				)
			)
			(14
				(gLongSong2 number: 3207 setLoop: 1 play: self)
			)
			(15
				(ben
					view: 323
					setLoop: 3
					setPri: 14
					cel: 0
					posn: 139 150
					setCycle: CT 6 1 self
				)
			)
			(16
				(ben view: 323 setLoop: 2 cel: 0 setCycle: End self)
			)
			(17
				(ben
					view: 323
					setLoop: 3
					cel: 7
					posn: 139 150
					setCycle: End self
				)
			)
			(18
				(gLongSong2 number: 3207 setLoop: 1 play: self)
			)
			(19
				(SetFlag 55)
				(specialEdition init: ignoreActors: 1 stopUpd:)
				(= cycles 1)
			)
			(20
				(lever init:)
				(ben setPri: 8 setCycle: 0 setLoop: 3 cel: 0)
				(= cycles 1)
			)
			(21
				(gMessager say: 41 62 0 3 7 self) ; "Here, "apprentice". Distribute these to the colonists. Knock on all the doors, seek the people out in the shops and the streets!"
			)
			(22
				(gMessager say: 55 0 15 0 self) ; "Go on, lad! The sooner we round up the colonists, the sooner your dog can be rescued!"
			)
			(23
				(ben
					view: 817
					setLoop: -1
					cel: 0
					posn: 130 147
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 88 141 self
				)
			)
			(24
				(ben setPri: -1 setMotion: PolyPath 53 158 self)
			)
			(25
				(ben
					view: 322
					loop: 5
					cel: 0
					posn: 56 157
					setPri: (+ (ben priority:) 1)
					setCycle: Beg self
				)
			)
			(26
				(ben view: 327 loop: 0 cel: 0 posn: 47 151 ignoreActors: 0)
				(= cycles 1)
			)
			(27
				(ben setScript: writingScr)
				(= local2 2)
				(= cycles 10)
			)
			(28
				(specialEditionTimer setReal: specialEditionTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance benWarnPepperScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not gModelessDialog)
					(gMessager say: 55 0 15 0 self) ; "Go on, lad! The sooner we round up the colonists, the sooner your dog can be rescued!"
				else
					(= cycles 2)
				)
			)
			(1
				(specialEditionTimer
					setReal: specialEditionTimer (Random 20 30)
				)
				(self dispose:)
			)
		)
	)
)

(instance setStoolDownScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(ladder noun: 32)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 47)
				(Load rsVIEW 320)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 3)
			)
			(1
				((ScriptID 895 0) normalize: setMotion: PolyPath 112 107 self) ; pepper
			)
			(2
				((ScriptID 895 0) setHeading: 180 self) ; pepper
			)
			(3
				(= cycles 2)
			)
			(4
				(if register
					(gMessager say: 10 63 0 1 self) ; "Hmm, I wonder if I could use this stepstool..."
				else
					(gMessager say: 31 63 0 1 self) ; "Hmm, I wonder if this will do it..."
				)
			)
			(5
				((ScriptID 895 0) setHeading: 310 self) ; pepper
			)
			(6
				(= cycles 2)
			)
			(7
				((ScriptID 895 0) ; pepper
					view: 321
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(8
				(gGame points: 309 2)
				(= cycles 1)
			)
			(9
				(gLongSong2 number: 3201 flags: 1 loop: 1 play:)
				((ScriptID 895 0) setCycle: CT 6 1 self) ; pepper
			)
			(10
				(stepStool init: stopUpd:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(11
				((ScriptID 895 0) normalize: setHeading: 180 self) ; pepper
			)
			(12
				(= cycles 2)
			)
			(13
				(if register
					(gMessager say: 10 63 0 2 self) ; "YES!"
				else
					(gMessager say: 31 63 0 2 self) ; "YES! I think I can climb it now!"
				)
			)
			(14
				(gEgo put: 27 gCurRoomNum) ; StepStool
				(= cycles 1)
			)
			(15
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bottomOfLadder of Feature
	(properties
		x 112
		y 95
		nsTop 88
		nsLeft 99
		nsBottom 103
		nsRight 126
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 63) ; StepStool
			(gCurRoom setScript: setStoolDownScr)
		else
			(ladder doVerb: theVerb)
		)
	)
)

(instance walkToBinsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 247 139 self
				)
			)
			(2
				(gMessager say: 36 7 0 1 self) ; "Pepper takes one of the rubber stoppers. She doesn't think Ben will miss it, in his present condition!"
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 326
					loop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(4
				(stopper dispose:)
				(= cycles 2)
			)
			(5
				(gMessager say: 36 7 0 2 self) ; "Cool! This looks like just what I need!"
			)
			(6
				((ScriptID 895 0) setCycle: CT 9 1 self) ; pepper
				(magnet dispose:)
			)
			(7
				(gEgo get: 20) ; Stopper
				(gEgo get: 33) ; Magnet
				(SetFlag 22)
				(SetFlag 70)
				(gGame points: 308 1)
				(= cycles 10)
			)
			(8
				((ScriptID 895 0) setLoop: 2 cel: 0 setCycle: End self) ; pepper
			)
			(9
				(gMessager say: 36 7 0 3 4 self) ; "YIKES! The magnet's stuck to my buttons!"
			)
			(10
				(= ticks 30)
			)
			(11
				((ScriptID 895 0) normalize: setMotion: MoveTo 232 143 self) ; pepper
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance actFiveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ben
					view: 327
					loop: 0
					cel: 2
					x: 47
					y: 154
					priority: 13
					signal: 16
				)
				(= ticks 30)
			)
			(1
				(if (and (not (IsFlag 166)) (SetFlag 166))
					(= gDictionaryWord 30)
					(gMessager say: 55 0 13 1 self) ; "Come in, lad. I've been trying to write a new pamphlet. I must help the people get back to the good old colonial ethics of hard work and |r||c0|diligence|c||r|!"
				else
					(++ state)
					(= cycles 1)
				)
			)
			(2
				(gMessager say: 55 0 13 2 11 self) ; "But don't worry your head about that. What are we going to do about that dog of yours, lad?"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance saveLockjawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 55 0 12 1 3 self) ; "Ah, there you are! I was growing concerned."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkBenScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 75)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 106 129 self
				)
			)
			(2
				((ScriptID 895 0) view: 805 setLoop: 3 cel: 0) ; pepper
				(= cycles 30)
			)
			(3
				(gMessager say: 8 85 12 1 2 self) ; "So, Ben, do you have a plan to get me into the mansion?"
			)
			(4
				(ben setCycle: CT 3 1 self)
			)
			(5
				(gGame points: 313 1)
				(= cycles 1)
			)
			(6
				(kite dispose:)
				(ben setCycle: CT 8 1 self)
			)
			(7
				((ScriptID 895 0) ; pepper
					setPri: (+ (ben priority:) 2)
					setCycle: End self
				)
			)
			(8
				(= cycles 10)
			)
			(9
				(ben setCel: 0)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(10
				((ScriptID 895 0) ; pepper
					get: 13 ; Kite
					normalize:
					loop: 8
					cel: 5
					setHeading: 260
				)
				(ben setCel: 0)
				(= cycles 1)
			)
			(11
				(gMessager say: 8 85 12 3 11 self) ; "You get in the river, and the kite pulls you along, right?"
			)
			(12
				(SetFlag 60)
				(SetFlag 75)
				(= cycles 1)
			)
			(13
				(ben
					view: 817
					setLoop: -1
					cel: 0
					posn: 76 135
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 53 158 self
				)
			)
			(14
				(ben
					view: 322
					loop: 5
					cel: 0
					posn: 56 157
					setPri: 13
					setCycle: Beg self
				)
			)
			(15
				(ben view: 327 loop: 0 cel: 0 posn: 47 151 ignoreActors: 0)
				(= cycles 1)
			)
			(16
				(ben setScript: writingScr)
				(= local2 2)
				(= cycles 10)
			)
			(17
				(gGame handsOn:)
				(gCurRoom newRoom: 331)
				(self dispose:)
			)
		)
	)
)

(instance sweepingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sally setCycle: CT 4 1 self)
			)
			(1
				(gLongSong2 number: 3200 setLoop: 1 flags: 1 play: self)
			)
			(2
				(sally cel: 5 setCycle: CT 7 1 self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance deborahIntroScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(deborah posn: 80 230 init:)
				(sally init:)
				((ScriptID 895 0) posn: 106 240 cycleSpeed: 8 moveSpeed: 8) ; pepper
				(= cycles 3)
			)
			(1
				(deborah view: 841 setCycle: Walk setMotion: MoveTo 90 188)
				((ScriptID 895 0) setMotion: MoveTo 155 188 self) ; pepper
			)
			(2
				(sally setCycle: 0)
				(deborahTalker x: 85 y: 122 tailPosn: 0)
				(= cycles 5)
			)
			(3
				(sallyTalker x: 21 y: 127 tailPosn: 1)
				(= cycles 2)
			)
			(4
				(gMessager say: 55 0 16 0 self) ; "Sally, you missed a spot."
			)
			(5
				(deborah
					view: 841
					setCycle: Walk
					setMotion: PolyPath 58 120 deborah
				)
				(= ticks 25)
			)
			(6
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 58 120 self
				)
			)
			(7
				((ScriptID 895 0) dispose:) ; pepper
				(= cycles 1)
			)
			(8
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance deborah of Actor
	(properties
		x 150
		y 170
		view 841
	)

	(method (cue)
		(self dispose:)
	)
)

(instance kite of View
	(properties
		x 38
		y 135
		view 322
		loop 2
		cel 1
	)
)

(instance pigeonWarningScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (not (IsFlag 157)) (not (IsFlag 158)))
						(SetFlag 157)
						(gLongSong2 number: 3208 setLoop: 1 flags: 1 play:)
						(gMessager say: 55 0 19 0 self) ; "Hmm? Hey, it sounds like there's some kind of bird up in the attic! I wonder what it is?"
					)
					((and (IsFlag 157) (not (IsFlag 158)))
						(gLongSong2 number: 3208 setLoop: 1 flags: 1 play:)
						(gMessager say: 55 0 20 0 self) ; "Hey, I hear that bird again! I wonder what his problem is?"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance deborahTalker of BalloonTalker
	(properties
		x 95
		y 119
		talkWidth 150
	)
)

(instance sallyTalker of BalloonTalker
	(properties
		x 11
		y 116
		talkWidth 150
		tailPosn 1
	)
)

(instance benTalker of BalloonTalker
	(properties
		x 15
		y 100
		talkWidth 150
		tailPosn 1
	)
)

(instance getSchematicScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 11) ; Schematic
				(SetFlag 34)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 180 173 self
				)
			)
			(2
				((ScriptID 895 0) setMotion: MoveTo 165 164 self) ; pepper
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(schematic dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(8
				(= gDictionaryWord 104)
				(gMessager say: 47 7 0 0 self) ; "Pepper picks up the |r||c0|schematic|c||r| for the kite/key experiment."
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getSpecialEditionScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 32) ; Special_Edition
				(SetFlag 61)
				(= local1 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 180 173 self
				)
			)
			(2
				((ScriptID 895 0) setMotion: PolyPath 165 164 self) ; pepper
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(specialEdition dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(8
				(gMessager say: 54 7 0 0 self) ; "There sure are a lot of these things!"
			)
			(9
				(gGame handsOn:)
				(specialEditionTimer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterSitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion:
						MoveTo
						((ScriptID 895 0) x:) ; pepper
						(+ ((ScriptID 895 0) y:) 70) ; pepper
						self
				)
			)
			(2
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance coonskin of Feature
	(properties
		x 305
		y 89
		noun 64
		nsTop 77
		nsLeft 298
		nsBottom 101
		nsRight 312
		sightAngle 40
		approachX 305
		approachY 89
		approachDist 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelf1 of Feature
	(properties
		x 162
		y 23
		noun 48
		nsTop 17
		nsLeft 136
		nsBottom 29
		nsRight 188
		sightAngle 40
		approachX 137
		approachY 108
		approachDist 100
	)
)

(instance shelf2 of Feature
	(properties
		x 162
		y 37
		noun 49
		nsTop 32
		nsLeft 137
		nsBottom 42
		nsRight 188
		sightAngle 40
		approachX 138
		approachY 108
		approachDist 88
	)
)

(instance shelf3 of Feature
	(properties
		x 162
		y 51
		noun 50
		nsTop 46
		nsLeft 136
		nsBottom 56
		nsRight 188
		sightAngle 40
		approachX 138
		approachY 108
		approachDist 73
	)
)

(instance shelf4 of Feature
	(properties
		x 162
		y 64
		noun 51
		nsTop 59
		nsLeft 136
		nsBottom 70
		nsRight 189
		sightAngle 40
		approachX 139
		approachY 108
		approachDist 63
	)
)

(instance shelf5 of Feature
	(properties
		x 162
		y 78
		noun 52
		nsTop 75
		nsLeft 136
		nsBottom 82
		nsRight 189
		sightAngle 40
		approachX 137
		approachY 110
		approachDist 53
	)
)

(instance shelf6 of Feature
	(properties
		x 142
		y 92
		noun 53
		nsTop 87
		nsLeft 136
		nsBottom 97
		nsRight 148
		sightAngle 40
		approachX 139
		approachY 110
		approachDist 30
	)
)

(instance bookOnBarrel of Feature
	(properties
		x 304
		y 150
		noun 65
		nsTop 141
		nsLeft 274
		nsBottom 177
		nsRight 319
		sightAngle 40
		approachX 244
		approachY 148
		approachDist 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(gMessager say: 65 84) ; "|c1|TRUE. Ben bought a book on swimming when he was just a child. By reading it and then trying the techniques in the local swimming hole and the Boston harbor, he became an expert swimmer.|c|"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 189
		nsLeft 26
		nsBottom 189
		nsRight 215
		cursor 910
		exitDir 3
		noun 44
	)
)

(instance specialEditionTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) setScript: benWarnPepperScr)
		else
			(gCurRoom setScript: benWarnPepperScr)
		)
	)
)

(instance actSixReturnScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) normalize: loop: 8 cel: 5 posn: 105 126) ; pepper
				(ben view: 327 loop: 0 cel: 0 posn: 47 151 ignoreActors: 0)
				(= local2 2)
				(ben setScript: writingScr)
				(= cycles 10)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

