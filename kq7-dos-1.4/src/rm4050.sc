;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use OogaBooga)
(use Print)
(use Inset)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4050 0
	gdTalker 1
)

(local
	local0 = 1
	local1
)

(class PlatformExitFeature of ExitFeature
	(properties
		sightAngle 370
		savX 0
		savY 0
		thePlatform 0
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canControl:)
					(& (gEgo state:) $0002)
					gApproachCode
					(& _approachVerbs (gApproachCode doit: (event message:)))
				)
				(= temp0 0)
				(cond
					((event claimed:)
						(return 1)
					)
					(
						(and
							(& (event type:) evVERB)
							(self onMe: event)
							(self isNotHidden:)
						)
						(CueObj
							state: 0
							cycles: 0
							client: self
							theVerb: (event message:)
						)
						(= temp0 (event claimed: 1))
						(if
							(and
								(gUser canControl:)
								(!= plane gInterfacePlane)
								(!= gCurRoomNum 20) ; nameGameRoom
							)
							(cond
								((== self global311)
									(if
										(and
											(& (gEgo state:) $0002)
											(>
												(GetDistance
													(gEgo x:)
													(gEgo y:)
													approachX
													approachY
												)
												approachDist
											)
											gApproachCode
											(&
												_approachVerbs
												(gApproachCode
													doit: (event message:)
												)
											)
										)
										(if (!= local0 thePlatform)
											(= savX (event x:))
											(= savY (event y:))
											(if (== thePlatform 1)
												(gEgo
													setMotion:
														PolyPath
														275
														(+ (gEgo z:) 100)
														self
												)
											else
												(gEgo
													setMotion:
														PolyPath
														272
														(+ (gEgo z:) 119)
														self
												)
											)
											(event claimed: 1)
										else
											(gEgo
												setMotion:
													PolyPath
													approachX
													(+ (gEgo z:) approachY)
													CueObj
											)
											(event claimed: 1)
										)
									else
										(gEgo setMotion: 0)
										(if (self facingMe:)
											(CueObj changeState: 3)
										)
									)
								)
								((not (self isKindOf: (ScriptID 33 0))) ; Dune
									(gGame pragmaFail:)
								)
							)
						else
							(gEgo setMotion: 0)
							(if (self facingMe:)
								(CueObj changeState: 3)
							)
						)
					)
					((and scratch (not (event type:)) (self onMe: event))
						(= temp0 (event claimed: 1))
						(= global311 self)
						((self scratch:) doit:)
					)
				)
				(return temp0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (cue)
		(gGame handsOff: 0 1)
		(if (== (= local0 thePlatform) 1)
			(gCurRoom setScript: sGoUp 0 self)
		else
			(gCurRoom setScript: sGoDown 0 self)
		)
	)

	(method (continueMove)
		(gEgo
			setMotion: PolyPath approachX (+ (gEgo z:) approachY) CueObj
		)
	)
)

(class PlatformFeature of Feature
	(properties
		savX 0
		savY 0
		thePlatform 0
		addWalkHandler 0
	)

	(method (init)
		(super init: &rest)
		(if addWalkHandler
			(gWalkHandler add: self)
			(self approachVerbs: 10) ; Exit
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(if addWalkHandler
			(gWalkHandler delete: self)
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(if (!= local0 thePlatform)
				(= savX (event x:))
				(= savY (event y:))
				(gEgo
					setMotion:
						PolyPath
						approachX
						(+ (gEgo z:) approachY)
						self
				)
				(event claimed: 1)
			else
				(gEgo setMotion: PolyPath (event x:) (event y:))
				(event claimed: 1)
			)
		)
		(super handleEvent: event)
	)

	(method (cue)
		(gGame handsOff: 0 1)
		(if (== (= local0 thePlatform) 1)
			(gCurRoom setScript: sGoUp 0 self)
		else
			(gCurRoom setScript: sGoDown 0 self)
		)
	)

	(method (continueMove)
		(gEgo setMotion: PolyPath savX savY)
	)
)

(class PlatformActor of Actor
	(properties
		savX 0
		savY 0
		thePlatform 0
	)

	(method (handleEvent event &tmp temp0)
		(if script
			(script handleEvent: event)
		)
		(= temp0 0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(= temp0 (event claimed: 1))
				(if
					(and
						(gUser canControl:)
						(!= plane gInterfacePlane)
						(!= gCurRoomNum 20) ; nameGameRoom
					)
					(cond
						((== self global311)
							(if
								(and
									(& (gEgo state:) $0002)
									(>
										(GetDistance
											(gEgo x:)
											(gEgo y:)
											approachX
											approachY
										)
										approachDist
									)
									gApproachCode
									(&
										_approachVerbs
										(gApproachCode doit: (event message:))
									)
								)
								(if (!= local0 thePlatform)
									(= savX (event x:))
									(= savY (event y:))
									(if (== thePlatform 1)
										(gEgo
											setMotion:
												PolyPath
												275
												(+ (gEgo z:) 100)
												self
										)
									else
										(gEgo
											setMotion:
												PolyPath
												272
												(+ (gEgo z:) 119)
												self
										)
									)
									(event claimed: 1)
								else
									(gEgo
										setMotion:
											PolyPath
											approachX
											(+ (gEgo z:) approachY)
											CueObj
									)
									(event claimed: 1)
								)
							else
								(gEgo setMotion: 0)
								(if (self facingMe:)
									(CueObj changeState: 3)
								)
							)
						)
						((not (self isKindOf: (ScriptID 33 0))) ; Dune
							(gGame pragmaFail:)
						)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= temp0 (event claimed: 1))
				(= global311 self)
				((self scratch:) doit:)
			)
		)
		(return temp0)
	)

	(method (cue)
		(gGame handsOff: 0 1)
		(if (== (= local0 thePlatform) 1)
			(gCurRoom setScript: sGoUp 0 self)
		else
			(gCurRoom setScript: sGoDown 0 self)
		)
	)

	(method (continueMove)
		(gEgo
			setMotion: PolyPath approachX (+ (gEgo z:) approachY) CueObj
		)
	)
)

(instance rm4050 of KQRoom
	(properties
		picture 4050
	)

	(method (init)
		(if (== gChapter 6)
			(gGame handsOff:)
		)
		(Load rsPIC 4050)
		(if (proc98_9)
			(SetFlag 192)
			(gEgo get: 57) ; Grave_Digger_s_Rat
			(if
				(Print
					addText: {Speech or text?}
					addButton: 1 {Text} 0 20
					addButton: 0 {Speech} 20 20
					init:
				)
				(= gMsgType 1)
			)
		)
		(if (and (not (IsFlag 150)) (== gChapter 4))
			(SetFlag 192)
			(= picture 4060)
		)
		(super init:)
		(Load rsMESSAGE 4050)
		(Load rsVIEW 4052)
		(Load rsVIEW 4053)
		(Load rsVIEW 836)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 96 109 191 109 191 119 96 119
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 0 136 277 138 286 122 281 102 319 102 319 94 273 94 261 79 238 79 228 85 233 92 271 100 272 105 237 110 180 104 135 104 173 88 122 64 84 75 78 92 21 83 0 93
					yourself:
				)
		)
		(cond
			((and (== gChapter 4) (not (IsFlag 150)))
				(= local0 0)
				(self setScript: sChapter4IntroScript)
			)
			((== gChapter 6)
				(Load rsVIEW 40503)
				(Load rsVIEW 40502)
				(Load rsVIEW 40501)
				(Load 140 4107) ; WAVE
				(Load 140 813) ; WAVE
				(Load 140 2269) ; WAVE
				(Load 140 4055) ; WAVE
				(crashElevator
					view: 40515
					cel: 17
					setLoop: 2
					cycleSpeed: 12
					posn: 237 77
					setPri: (- (smallGraveDigger priority:) 1)
					init:
					setHotspot: 0
				)
				(shedDoor init: setCel: 1)
				(chapter6GraveDigger init: setScript: sCh6GD)
				(self setScript: sChap6Toon)
			)
			((IsFlag 151)
				(crashElevator
					view: 40515
					cel: 17
					setLoop: 2
					cycleSpeed: 12
					posn: 237 77
					setPri: (- (smallGraveDigger priority:) 1)
					init:
				)
				(if
					(and
						(== gChapter 4)
						(not (gEgo has: 56)) ; Shovel
						(IsFlag 157)
					)
					(theShovel init:)
				)
				(shedDoor init: setCel: 1)
				(gKqMusic1 number: 4092 loop: -1 play:)
				(upperPlatform init:)
				(lowerPlatform init:)
				(graveStone1 init:)
				(graveStone2 init:)
				(graveStone3 init:)
				(wExit init:)
				(seExit init:)
				(switch gPrevRoomNum
					(4250
						(= local0 0)
						(self setScript: sEnterSE)
					)
					(else
						(= local0 1)
						(self setScript: sEnterWest)
					)
				)
			)
			((IsFlag 157)
				(crashElevator
					view: 40515
					cel: 17
					setLoop: 2
					cycleSpeed: 12
					posn: 237 77
					setPri: (- (smallGraveDigger priority:) 1)
					init:
				)
				(shedDoor init: setCel: 1)
				(if (IsFlag 203)
					(smallGraveDigger
						view: 4058
						setLoop: 0
						cel: 0
						posn: 216 67
						cycleSpeed: 12
						init:
						setCycle: Fwd
					)
					(gKqMusic1 number: 4091 loop: -1 play:)
					(if (IsFlag 345)
						(smallGraveDigger setHotspot: 0)
					)
				else
					(gKqMusic1 number: 40801 loop: -1 play:)
				)
				(if
					(and
						(== gChapter 4)
						(not (gEgo has: 56)) ; Shovel
						(IsFlag 157)
					)
					(theShovel init:)
				)
				(upperPlatform init:)
				(lowerPlatform init:)
				(graveStone1 init:)
				(graveStone2 init:)
				(graveStone3 init:)
				(wExit init:)
				(seExit init:)
				(switch gPrevRoomNum
					(4250
						(= local0 0)
						(self setScript: sEnterSE)
					)
					(else
						(= local0 1)
						(self setScript: sEnterWest)
					)
				)
			)
			(else
				(crashElevator
					view: 40515
					cel: 17
					setLoop: 2
					cycleSpeed: 12
					posn: 237 77
					setPri: (- (smallGraveDigger priority:) 1)
					init:
				)
				(shedDoor init: setCel: 1)
				(gKqMusic1 number: 4080 loop: -1 play:)
				(smallGraveDigger
					view: 40525
					cel: 0
					setPri: 101
					setLoop: 3
					posn: 138 102
					cycleSpeed: 12
					setCycle: Fwd
					init:
				)
				(if (IsFlag 345)
					(smallGraveDigger setHotspot: 0)
				)
				(upperPlatform init:)
				(lowerPlatform init:)
				(graveStone1 init:)
				(graveStone2 init:)
				(graveStone3 init:)
				(wExit init:)
				(seExit init:)
				(switch gPrevRoomNum
					(4250
						(= local0 0)
						(self setScript: sEnterSE)
					)
					(else
						(= local0 1)
						(self setScript: sEnterWest)
					)
				)
			)
		)
	)

	(method (newRoom)
		(ClearFlag 192)
		(gKqSound1 stop:)
		(if (not (== gChapter 6))
			(gKqMusic1 stop:)
		)
		(super newRoom: &rest)
	)

	(method (notify)
		(cond
			((IsFlag 151)
				(OogaBooga setScript: (ScriptID 4001 1)) ; wakeTheDead
			)
			((IsFlag 157)
				(if (gCast contains: smallGraveDigger)
					(self setScript: sHornWhileGDHere)
				else
					(self setScript: sDiggerComes4050)
				)
			)
		)
	)
)

(instance shedDoor of PlatformActor
	(properties
		approachX 102
		approachY 78
		x 69
		y 73
		view 40567
		loop 6
		thePlatform 1
	)

	(method (setCel param1)
		(if (== param1 0)
			(self posn: 69 73)
		else
			(self posn: 69 73)
		)
		(= cel param1)
	)

	(method (init)
		(super init: &rest)
		(if (or (and (not (IsFlag 151)) (IsFlag 152)) (IsFlag 393))
			(self setHotspot: 0)
		else
			(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		)
		(self setPri: 67)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 151)
					(SetFlag 393)
					(gCurRoom setScript: sApproachDoor)
				else
					(gCurRoom setScript: sLookInset)
				)
			)
		)
	)
)

(instance smallGraveDigger of PlatformActor
	(properties
		sightAngle 120
		approachX 226
		approachY 116
		thePlatform 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 78 ; Do, Exit, Grave_Digger_s_Rat
			approachVerbs: 8 10 78 ; Do, Exit, Grave_Digger_s_Rat
			signal: (| signal $1000)
		)
		(Load 140 40810) ; WAVE
		(Load 140 4081) ; WAVE
		(Lock 140 40810 1) ; WAVE
		(Lock 140 4081 1) ; WAVE
	)

	(method (dispose)
		(Lock rsSOUND 40810 0)
		(Lock rsSOUND 4081 0)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (== view 40525) (== loop 3) (== cel 8) (not (gdSound number:)))
			(= temp0 (if (<= (Random 1 1000) 500) 40810 else 4081))
			(gdSound number: temp0 loop: 1 play: cueSnd)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(78 ; Grave_Digger_s_Rat
				(gGame handsOff: 1)
				(gCurRoom setScript: sGiveRat)
			)
			(8 ; Do
				(cond
					((IsFlag 346)
						(gMessager say: 3 8 13 0) ; "(SHOUTING OVER THE NOISE)You'd better go hide, lady. The volcano's gonna be real hard on you breathing types."
						(SetFlag 345)
						(self setHotspot: 0)
					)
					((IsFlag 157)
						(SetFlag 346)
						(gMessager say: 3 8 12 0) ; "(SHOUTING OVER THE NOISE)Hello! Hello! Good sir!"
					)
					((IsFlag 451)
						(gGame handsOff:)
						(gCurRoom setScript: sGoAwayNow)
					)
					((IsFlag 275)
						(gGame handsOff:)
						(SetFlag 451)
						(gCurRoom setScript: sTalkAboutRat)
					)
					((IsFlag 274)
						(gGame handsOff:)
						(SetFlag 275)
						(gCurRoom setScript: sShowMachine)
					)
					(else
						(gGame handsOff:)
						(SetFlag 274)
						(gCurRoom setScript: sMeasureRos)
					)
				)
			)
		)
	)
)

(instance crashElevator of PlatformActor
	(properties
		sightAngle 90
		approachX 237
		approachY 82
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -3) ; Roz
			(self approachVerbs: 8 10) ; Do, Exit
			(if (not (IsFlag 396))
				(self setHotspot: 8 10) ; Do, Exit
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: 2 8 4) ; "(THINKS TO HERSELF DEJECTEDLY)Nobody will be using THAT elevator again."
				(SetFlag 396)
				(self setHotspot:)
			)
		)
	)
)

(instance dirt of Actor
	(properties
		x 171
		y 126
		view 4061
	)
)

(instance largeGraveDigger of Actor
	(properties
		x 181
		y 135
		view 4071
	)
)

(instance shovel of Feature
	(properties
		nsLeft 148
		nsTop 118
		nsRight 191
		nsBottom 150
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gGame handsOff: 1)
				(gCurRoom setScript: sLiftEgoOutOfHole)
				(largeGraveDigger dispose:)
				(self dispose:)
			)
		)
	)
)

(instance machine of PlatformActor
	(properties
		x 81
		y 110
		view 40565
		loop 1
		thePlatform 1
	)
)

(instance theShovel of PlatformActor
	(properties
		approachX 93
		approachY 79
		x 86
		y 76
		view 4058
		loop 1
		thePlatform 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sGetShovel)
			)
		)
	)
)

(instance theDigger of Actor
	(properties)
)

(instance sGetShovel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 151)
					(= cycles 3)
				else
					(gEgo
						view: 8435
						setLoop: 1 1
						setCel: 0
						setCycle: CT 8 1 self
					)
				)
			)
			(1
				(if (IsFlag 151)
					(= cycles 3)
				else
					(gEgo setCycle: End self)
				)
				(gEgo get: 56) ; Shovel
				(theShovel dispose:)
			)
			(2
				(gEgo normalize: 2 setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upperPlatform of PlatformFeature
	(properties
		approachX 275
		approachY 100
		thePlatform 1
		addWalkHandler 1
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 10 133 10 133 18 129 24 121 37 115 66 177 97 196 98 215 87 224 96 234 100 243 103 257 104 264 112 264 115 290 115 292 110 299 107 305 106 309 100 320 100 320 148 0 148
					yourself:
				)
		)
	)
)

(instance lowerPlatform of PlatformFeature
	(properties
		approachX 272
		approachY 119
		addWalkHandler 1
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 135 10 320 10 320 98 307 98 304 104 293 106 286 114 266 113 263 107 257 102 246 102 237 99 234 96 225 95 215 85 193 96 177 95 145 80 117 65 125 32 136 18
					yourself:
				)
		)
	)
)

(instance graveStone1 of PlatformActor
	(properties
		noun 5
		approachX 117
		approachY 125
		x 122
		y 111
		view 4058
		loop 2
		thePlatform 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; Do
				(gEgo normalize: 3 setStep: 4 3)
				(if (== gValOrRoz -3) ; Roz
					(= temp0 10)
				else
					(= temp0 14)
				)
				(gMessager say: noun theVerb temp0 0)
			)
		)
	)
)

(instance graveStone2 of PlatformActor
	(properties
		noun 6
		sightAngle 10
		approachX 71
		approachY 138
		x 45
		y 142
		view 4058
		loop 2
		cel 1
		thePlatform 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; Do
				(gEgo normalize: 5 setStep: 4 3)
				(if (== gValOrRoz -3) ; Roz
					(= temp0 10)
				else
					(= temp0 14)
				)
				(gMessager say: noun theVerb temp0 0)
			)
		)
	)
)

(instance graveStone3 of PlatformActor
	(properties
		noun 7
		approachX 20
		approachY 92
		x 24
		y 75
		view 4058
		loop 2
		cel 2
		thePlatform 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(8 ; Do
				(gEgo normalize: 3 setStep: 4 3)
				(if (== gValOrRoz -3) ; Roz
					(= temp0 10)
				else
					(= temp0 14)
				)
				(gMessager say: noun theVerb temp0 0)
			)
		)
	)
)

(instance smallMachine of Prop
	(properties)
)

(instance chapter6GraveDigger of Actor
	(properties
		view 40502
	)
)

(instance horseLands of Actor
	(properties)
)

(instance ed of Actor
	(properties)
)

(instance val6 of Actor
	(properties)
)

(instance sLookInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(1
				(gCurRoom setInset: iGraffiti self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sApproachDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 869)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 45631
					setLoop: 3
					cycleSpeed: 10
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(gKqSound1 number: 869 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(5
				(gMessager say: 8 8 11 0 self) ; "(SHOUTING OVER THE NOISE)Hello?"
			)
			(6
				(shedDoor setHotspot: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChapter4IntroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dirt init: setCycle: Fwd)
				(ambianceSound number: 2550 loop: -1 play: fade: 0 50 1 1)
				(fallingDirt number: 4075 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(gKqSound1 number: 2552 loop: -1 play:)
				(gEgo
					init:
					view: 4061
					loop: 1
					cel: 0
					posn: 144 63
					setPri: 140
					cycleSpeed: 12
					setStep: 4 3
					show:
					setCycle: CT 13 1 self
				)
			)
			(2
				(gKqSound1 number: 887 loop: 1 play:)
				(gKqMusic1 number: 4070 loop: 1 play:)
				(= cycles 1)
			)
			(3
				(screamSound number: 4076 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo dispose:)
				(dirt dispose:)
				(= cycles 1)
			)
			(5
				(gCurRoom drawPic: 4070 0 1)
				(largeGraveDigger init: setPri: 200)
				(= cycles 1)
			)
			(6
				(ambianceSound stop:)
				(gKqSound1 number: 154 loop: 1 play:)
				(largeGraveDigger setCycle: End self)
			)
			(7
				(shovel init:)
				(gGame handsOn:)
				(= seconds 15)
			)
			(8
				(largeGraveDigger dispose:)
				(gCurRoom drawPic: 999 0 1)
				(= seconds 2)
			)
			(9
				(gGame handsOff:)
				(shovel dispose:)
				(screamSound number: 4073 loop: 1 play: self)
			)
			(10
				(gKqMusic1 number: 4074 loop: 1 play: self)
			)
			(11
				(gKqMusic1 stop:)
				(EgoDead 36 self 1)
			)
			(12
				(gGame handsOff:)
				(self changeState: 5)
			)
		)
	)
)

(instance sLiftEgoOutOfHole of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(SetFlag 150)
					(gEgo init: hide: setStep: 4 3)
					(Load rsVIEW 40525)
					(Load rsVIEW 4052)
					(Load rsVIEW 4051)
					(Load 140 4074) ; WAVE
					(gCurRoom drawPic: 4050 0 1)
					(shedDoor init: setCel: 1)
					(smallGraveDigger
						view: 4051
						cel: 0
						setLoop: 0
						posn: 226 77
						init:
					)
					(= cycles 10)
				)
				(1
					(gKqSound1 number: 818 loop: 1 play:)
					(smallGraveDigger setCycle: End self)
				)
				(2
					(smallGraveDigger setLoop: 1 cel: 0 setCycle: End self)
				)
				(3
					(gEgo
						show:
						normalize: 1
						setStep: 4 3
						posn: 239 77
						setScaler: Scaler 86 38 137 76
					)
					(smallGraveDigger
						view: 4052
						setLoop: 0
						cel: 0
						posn: 206 75
						cycleSpeed: 12
						setPri: 90
					)
					(= cycles 1)
				)
				(4
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
					)
				)
				(5
					(gEgo normalize: 1 setStep: 4 3)
					(= cycles 2)
				)
				(6
					(gKqSound1 number: 4074 loop: 1 play:)
					(crashElevator
						view: 4051
						cel: 0
						setLoop: 2
						cycleSpeed: 12
						posn: 237 77
						setPri: (- (smallGraveDigger priority:) 1)
						init:
						setCycle: End self
					)
					(gEgo setPri: (+ (crashElevator priority:) 1))
				)
				(7
					(crashElevator view: 40515 cel: 17 setLoop: 2)
					(= seconds 3)
				)
				(8
					(gKqMusic1 number: 4080 loop: -1 play:)
					(gMessager say: 1 8 2 1 self) ; "(SCARED BUT GRATEFUL)Th--thank you, kind sir."
				)
				(9
					(smallGraveDigger
						view: 4052
						setLoop: 0
						cel: 0
						posn: 206 75
						cycleSpeed: 12
						setPri: 91
						setCycle: End self
					)
				)
				(10
					(proc11_3 gEgo smallGraveDigger)
					(smallGraveDigger
						view: 4052
						ignoreActors: 1
						illegalBits: 0
						setPri: 150
						cycleSpeed: 12
						setLoop: 1 1
						posn: 218 72
						cel: 0
						setCycle: End self
					)
				)
				(11
					(proc11_3 gEgo smallGraveDigger)
					(smallGraveDigger
						view: 4052
						cel: 0
						setPri: 140
						setLoop: 2
						posn: 164 136
						setCycle: CT 28 1 self
					)
				)
				(12
					(gKqSound1 number: 40810 loop: 1 play:)
					(smallGraveDigger setCycle: End self)
				)
				(13
					(proc11_3 gEgo smallGraveDigger)
					(smallGraveDigger
						view: 40525
						cel: 0
						setPri: 101
						setLoop: 3
						posn: 138 102
						cycleSpeed: 12
						setCycle: Fwd
					)
					(= cycles 10)
				)
				(14
					(gMessager say: 1 8 2 2 self) ; "(MUTTERING TO HIMSELF)Nuts, nuts, NUTS! This is gonna take forever. I can't STAND this rotten, worthless little shovel!"
				)
				(15
					(gMessager say: 1 8 2 3 self) ; "(MUTTERING TO HIMSELF)Look at that! Pathetic. That wasn't enough dirt to suffocate a bug. NUTS!"
				)
				(16
					(crashElevator setPri: -1)
					(upperPlatform init:)
					(lowerPlatform init:)
					(graveStone1 init:)
					(graveStone2 init:)
					(graveStone3 init:)
					(wExit init:)
					(seExit init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(smallGraveDigger
						view: 40525
						cel: 0
						setPri: 101
						setLoop: 3
						posn: 138 102
						cycleSpeed: 12
						setCycle: Fwd
					)
					(crashElevator
						view: 40515
						cel: 17
						setLoop: 2
						cycleSpeed: 12
						posn: 237 77
						setPri: -1
						init:
					)
					(gEgo init:)
					(gEgo
						posn: 239 82
						normalize: 2
						setStep: 4 3
						setScaler: Scaler 86 38 137 76
					)
					(upperPlatform init:)
					(lowerPlatform init:)
					(graveStone1 init:)
					(graveStone2 init:)
					(graveStone3 init:)
					(wExit init:)
					(seExit init:)
					(ClearFlag 192)
					(if (!= (gKqMusic1 number:) 4080)
						(gKqMusic1 number: 4080 loop: -1 play:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMeasureRos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(1
				(gMessager say: 3 8 5 1 self) ; "(KIND OF SCARED OF HIM)Um, hello, good fellow. Thank you again. I wonder--"
			)
			(2
				(smallGraveDigger setCycle: End self)
			)
			(3
				(smallGraveDigger
					view: 4053
					setLoop: 0
					cel: 0
					setPri: -1
					posn: 201 103
					setCycle: End self
				)
			)
			(4
				(smallGraveDigger
					view: 4053
					setLoop: 1
					cel: 0
					posn: 201 104
					setCycle: End self
				)
			)
			(5
				(gKqSound1 number: 4083 loop: 1 play:)
				(smallGraveDigger
					view: 4053
					setLoop: 2
					cel: 0
					setPri: (- (gEgo priority:) 1)
					posn: 202 104
					setCycle: CT 10 1 self
				)
			)
			(6
				(= seconds 4)
			)
			(7
				(smallGraveDigger setCycle: End self)
			)
			(8
				(gMessager say: 3 8 5 2 self) ; "(WEARILY)Okay lady, I got your length. I can't start digging your grave until tomorrow, though. Sorry."
			)
			(9
				(smallGraveDigger
					view: 4053
					setLoop: 3
					cel: 0
					posn: 196 103
					setCycle: End self
				)
			)
			(10
				(smallGraveDigger
					view: 40525
					cel: 11
					setPri: 101
					setLoop: 3
					posn: 138 102
					cycleSpeed: 12
					setCycle: Fwd
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowMachine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 40566)
				(Load rsSOUND 4085)
				(Load rsSOUND 4086)
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(1
				(gMessager sayRange: 3 8 6 1 4 self) ; "(CAUTIOUSLY)I don't need a grave just yet, thanks to you, sir. Could you tell me if this is the land of Ooga Booga?"
			)
			(2
				(smallGraveDigger setCycle: End self)
			)
			(3
				(smallGraveDigger
					view: 4054
					setLoop: 0
					cel: 0
					posn: 175 102
					setCycle: End self
				)
			)
			(4
				(smallGraveDigger
					view: 4054
					setLoop: 1
					cel: 0
					posn: 175 104
					setCycle: End self
				)
			)
			(5
				(smallGraveDigger
					view: 4054
					setLoop: 2
					cel: 0
					posn: 111 69
					setCycle: End self
				)
			)
			(6
				(shedDoor hide:)
				(gKqSound1 number: 4084 loop: 1 play:)
				(smallGraveDigger
					view: 4054
					setLoop: 3
					cel: 0
					posn: 110 77
					setCycle: End self
				)
			)
			(7
				(smallMachine
					view: 40566
					setLoop: 0
					posn: 78 102
					setPri: (- (shedDoor priority:) 1)
					cel: 0
					init:
				)
				(shedDoor show: setCel: 0)
				(smallGraveDigger
					view: 4054
					setLoop: 4
					cel: 0
					posn: 108 76
					setCycle: End self
				)
			)
			(8
				(gMessager say: 3 8 6 5 self) ; "(PROUD, THEN ANGRY)This here is a fully automatic, steam-driven, rat-powered grave digging machine. I made it myself. Those rotten kids broke in and stole my power source. They took my rat!"
			)
			(9
				(smallGraveDigger
					view: 4054
					setLoop: 6
					cel: 0
					posn: 111 76
					setCycle: CT 7 1 self
				)
			)
			(10
				(gKqSound1 number: 4085 loop: 1 play:)
				(shedDoor hide:)
				(smallGraveDigger setCycle: End self)
			)
			(11
				(smallMachine dispose:)
				(shedDoor show: setCel: 1)
				(smallGraveDigger
					view: 4054
					setLoop: 7
					cel: 0
					posn: 112 76
					setCycle: CT 9 1 self
				)
			)
			(12
				(gKqSound1 number: 4086 loop: 1 play:)
				(smallGraveDigger setCycle: End self)
			)
			(13
				(smallGraveDigger
					view: 40525
					cel: 11
					setPri: 101
					setLoop: 3
					posn: 138 102
					cycleSpeed: 12
					setCycle: Fwd
					init:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkAboutRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(1
				(smallGraveDigger setCycle: End self)
			)
			(2
				(smallGraveDigger
					view: 4052
					setLoop: 4
					posn: 199 101
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gMessager say: 3 8 7 0 self) ; "(TRYING TO BE HELPFUL)Sir, couldn't you just get another rat for your machine?"
			)
			(4
				(smallGraveDigger setCycle: Beg self)
			)
			(5
				(smallGraveDigger
					view: 40525
					cel: 0
					setPri: 101
					setLoop: 3
					posn: 138 102
					cycleSpeed: 12
					setCycle: Fwd
					init:
				)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveRat of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(Load 140 4089) ; WAVE
					(Load 140 4090) ; WAVE
					(Load rsVIEW 4057)
					(Load rsVIEW 40575)
					(gEgo normalize: 7 setStep: 4 3)
					(shedDoor setHotspot: 0)
					((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 0))
					((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 0))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 136 277 138 286 122 281 102 319 102 319 94 273 94 253 76 237 80 228 85 233 92 271 100 272 105 186 119 97 119 97 103 123 103 94 75 84 75 78 92 21 83 0 93
								yourself:
							)
					)
					(= cycles 2)
				)
				(1
					(SetFlag 157)
					(smallGraveDigger
						view: 4055
						cel: 0
						setLoop: 0
						setPri: (+ (smallGraveDigger priority:) 10)
						posn: 188 102
						setCycle: End self
					)
				)
				(2
					(gMessager say: 3 78 0 1 self) ; "(HAPPY)Look who I found!"
				)
				(3
					(gEgo
						setScale: 0
						view: 4055
						setLoop: 4
						cel: 0
						posn: 227 116
						cycleSpeed: 10
						setCycle: CT 32 1 self
					)
				)
				(4
					(smallGraveDigger
						view: 4055
						cel: 0
						setLoop: 1
						posn: 188 102
						setCycle: CT 5 1 self
					)
				)
				(5
					(gMessager say: 3 78 0 2 self) ; "(DELIGHTED)IGGY!"
				)
				(6
					(smallGraveDigger setCycle: End self)
				)
				(7
					(smallGraveDigger
						view: 4055
						setLoop: 2
						cel: 0
						posn: 190 106
						setCycle: End self
					)
				)
				(8
					(gEgo setCycle: CT 40 1 self)
				)
				(9
					(gEgo put: 57 4050 setCycle: End self) ; Grave_Digger_s_Rat
					(gKqSound1 number: 4087 loop: 1 play:)
					(smallGraveDigger
						view: 4055
						setLoop: 3
						cel: 0
						posn: 190 108
						setCycle: End self
					)
				)
				(10
					(gEgo
						normalize: 7
						setStep: 4 3
						setScaler: Scaler 93 83 138 113
					)
				)
				(11
					(gMessager say: 3 78 0 3 self) ; "(GRUFF, NOT WANTING TO SHOW EMOTION)Thank you, lady. Thank you so much. My only talent in the world is for digging, but I'll dig you a grave anywhere you want it. Here, take this horn."
				)
				(12
					(smallGraveDigger
						view: 4056
						setLoop: 0
						cel: 0
						posn: 175 109
						setCycle: CT 26 1 self
					)
				)
				(13
					(gEgo
						setScale: 0
						get: 49 ; Grave_Digger_s_Horn
						view: 4056
						posn: 227 116
						cel: 0
						setLoop: 1
						setCycle: CT 5 1 self
					)
				)
				(14
					(smallGraveDigger view: 4056 setLoop: 2 cel: 0 posn: 137 83)
					(gEgo setCycle: End self)
				)
				(15
					(gEgo
						normalize:
						setStep: 4 3
						setScaler: Scaler 93 83 138 113
					)
					(= cycles 1)
				)
				(16
					(gMessager say: 3 78 0 4 self) ; "If you blow this horn, I'll hear you, and I'll come and dig your grave. Okay? C'mon, Iggy. Let's go fire that bad boy up!"
				)
				(17
					(smallGraveDigger setCycle: End self)
				)
				(18
					(smallGraveDigger
						view: 4056
						setLoop: 3
						cel: 0
						posn: 173 109
						setCycle: End self
					)
				)
				(19
					(smallGraveDigger
						view: 4056
						setLoop: 4
						posn: 108 73
						cel: 0
						setCycle: End self
					)
				)
				(20
					(shedDoor hide:)
					(gKqSound1 number: 4084 loop: 1 play:)
					(smallGraveDigger
						setLoop: 5
						cel: 0
						posn: 109 77
						setCycle: End self
					)
				)
				(21
					(shedDoor show: setCel: 0)
					(Load rsVIEW 40565)
					(= cycles 1)
				)
				(22
					(gKqSound1 number: 4088 loop: -1 play:)
					(smallGraveDigger
						view: 40565
						setPri: 110
						setLoop: 0
						cel: 0
						posn: 81 110
						init:
						setCycle: CT 27 1 self
					)
				)
				(23
					(gKqSound1 stop:)
					(smallGraveDigger setCycle: End self)
				)
				(24
					(machine setPri: 100 init:)
					(smallGraveDigger
						view: 40565
						setLoop: 3
						cel: 0
						posn: 81 110
						setPri: (+ (machine priority:) 10)
						setCycle: End self
					)
				)
				(25
					(machine cel: 1)
					(gMessager say: 3 78 0 5 self) ; "WAAAAAAAAAAAHOOOOOOO!"
				)
				(26
					(gKqSound1 loop: 1 number: 4089 play: self)
				)
				(27
					(gKqMusic1 loop: -1 number: 4091 play:)
					(gKqSound1 loop: -1 number: 4090 play:)
					(machine
						view: 4057
						cel: 0
						setLoop: 0
						posn: 140 109
						setPri: 110
						setCycle: End self
					)
					(smallGraveDigger hide:)
				)
				(28
					(= local1 1)
					(machine
						view: 40575
						cel: 0
						setLoop: 1
						cycleSpeed: 12
						posn: 185 112
						setCycle: Fwd
						setPri: 110
					)
					(gGame handsOn:)
					(gEgo
						normalize:
						setStep: 4 3
						setScaler: Scaler 93 83 138 113
					)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(SetFlag 157)
					(gEgo put: 57 4050 get: 49) ; Grave_Digger_s_Rat, Grave_Digger_s_Horn
					(shedDoor show: setCel: 0)
					(smallGraveDigger hide:)
					(gKqMusic1 loop: -1 number: 4091 play:)
					(gKqSound1 loop: -1 number: 4090 play:)
					(machine
						view: 40575
						init:
						cel: 0
						setLoop: 1
						cycleSpeed: 12
						posn: 185 112
						setCycle: Fwd
						setPri: 110
					)
					(= local1 1)
					(gGame handsOn:)
					(gEgo normalize: setStep: 4 3)
					(self dispose:)
				)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: -10 109
					normalize:
					init:
					setScaler: Scaler 93 83 138 113
					setStep: 4 3
					setMotion: MoveTo 53 109 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 340 108
					normalize:
					init:
					setStep: 4 3
					setScaler: Scaler 86 38 137 76
					setMotion: MoveTo 276 102 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 100 setMotion: PolyPath 277 112 self)
			)
			(1
				(gEgo
					setScaler: Scaler 93 83 138 113
					setLoop: (gEgo loop:) 1
					setMotion: MoveTo 275 105 self
				)
			)
			(2
				(gEgo
					setLoop: -1
					setPri: -1
					setScaler: Scaler 93 83 138 113
					setMotion: MoveTo 274 117 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(register continueMove:)
				(self dispose:)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 275 105 self)
			)
			(1
				(gEgo
					setPri: 100
					setScaler: Scaler 86 38 137 76
					setLoop: (gEgo loop:) 1
					setMotion: MoveTo 277 113 self
				)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 275 100 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo setScaler: Scaler 86 38 137 76 setPri: -1)
				(gGame handsOn:)
				(register continueMove:)
				(self dispose:)
			)
		)
	)
)

(instance sGoAwayNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 7 setStep: 4 3)
				(= cycles 2)
			)
			(1
				(smallGraveDigger setCycle: End self)
			)
			(2
				(smallGraveDigger
					view: 4052
					setLoop: 4
					posn: 199 101
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gMessager say: 3 8 8 0 self) ; "Forgive me, lady, I don't mean to be rude or nothin', but I gotta get some work done before I get even farther behind."
			)
			(4
				(smallGraveDigger setCycle: Beg self)
			)
			(5
				(smallGraveDigger
					view: 40525
					cel: 0
					setPri: 101
					setLoop: 3
					posn: 138 102
					cycleSpeed: 12
					setCycle: Fwd
					init:
				)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sChap6Toon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gKqMusic1 number: 4051 loop: -1 play:)
				(horseLands
					view: 40501
					loop: 0
					cel: 0
					x: 255
					y: 77
					z: 0
					xStep: 3
					yStep: 2
					priority: 150
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
					init:
					setCycle: End self
				)
			)
			(2
				(gKqSound1 number: 813 loop: 1 play:)
				(= cycles 10)
			)
			(3
				(horseLands
					view: 40501
					loop: 1
					cel: 0
					x: 260
					y: 88
					z: 0
					xStep: 3
					yStep: 2
					priority: 88
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
					setCycle: End self
				)
				(gKqSound1 number: 4107 loop: 1 play:)
			)
			(4
				(horseLands
					view: 40501
					loop: 2
					cel: 0
					x: 235
					y: 88
					z: 0
					xStep: 3
					yStep: 2
					priority: 200
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
					setCycle: End self
				)
			)
			(5
				(horseLands view: 40502 setLoop: 3 cel: 0 posn: 258 88)
				(val6
					view: 40502
					setLoop: 3
					cel: 1
					setPri: (+ (horseLands priority:) 10)
					posn: 262 58
					init:
				)
				(ed
					view: 40502
					loop: 2
					cel: 0
					x: 245
					y: 89
					z: 0
					xStep: 3
					yStep: 2
					setPri: (+ (val6 priority:) 1)
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
					init:
					setCycle: CT 8 1 self
				)
			)
			(6
				(ed setPri: (- (horseLands priority:) 1) setCycle: End self)
			)
			(7
				(gKqSound1 number: 2269 loop: 1 play:)
				(ed
					view: 40503
					loop: 0
					cel: 1
					x: 229
					y: 78
					z: 0
					xStep: 3
					yStep: 2
					setPri: (- (horseLands priority:) 10)
					fixPriority: 1
					signal: 16385
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(8
				(val6
					view: 40503
					setLoop: 2
					cel: 0
					posn: 264 91
					setCycle: End
					cycleSpeed: 10
				)
				(gKqSound1 number: 4055 loop: 1 play:)
				(crashElevator
					view: 40503
					loop: 1
					cel: 0
					x: 237
					y: 79
					z: 0
					xStep: 3
					yStep: 2
					priority: 80
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 10
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
					setCycle: End self
				)
			)
			(9
				(gKqSound1 stop:)
				(= cycles 2)
			)
			(10
				(gCurRoom newRoom: 2400)
			)
		)
	)
)

(instance sCh6GD of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chapter6GraveDigger
					view: 40502
					loop: 0
					cel: 0
					x: 97
					y: 88
					z: 0
					xStep: 3
					yStep: 2
					priority: 88
					fixPriority: 1
					moveSpeed: 6
					cycleSpeed: 6
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
				)
				(= seconds 2)
			)
			(1
				(chapter6GraveDigger setCycle: End self)
			)
			(2
				(chapter6GraveDigger setCycle: Beg self)
			)
			(3
				(chapter6GraveDigger
					view: 40502
					loop: 1
					cel: 2
					x: 97
					y: 89
					z: 0
					xStep: 3
					yStep: 2
					priority: 89
					fixPriority: 1
					signal: 2049
					moveSpeed: 6
					cycleSpeed: 6
					scaleSignal: 0
					scaleX: 0
					scaleY: 0
				)
				(= seconds 2)
			)
			(4
				(chapter6GraveDigger setCycle: End self)
			)
			(5
				(chapter6GraveDigger setCycle: Beg self)
			)
			(6
				(self init:)
			)
		)
	)
)

(instance sHornWhileGDHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(Load rsVIEW 4355)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 4355 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(3
				(Load rsSOUND 4358)
				(gEgo setLoop: 1 1 setCel: 0)
				(= cycles 6)
			)
			(4
				(sndEffect number: 4358 loop: 1 play: self)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: CT 2 1)
			)
			(5
				(gEgo loop: 1 1 cel: 2 setCycle: End self)
			)
			(6
				(gEgo normalize: 0)
				(if (gCast contains: smallGraveDigger)
					(proc11_3 gEgo smallGraveDigger self)
				else
					(= cycles 1)
				)
			)
			(7
				(if (IsFlag 171)
					(gMessager say: 1 65 2 3 self 4001) ; "(EXAPERATED)Geez, lady, call me when you know what you want. And don't blow that horn too often! It's enough to wake the dead!"
				else
					(gMessager say: 1 65 2 0 self 4001) ; "Where do you want me to dig?"
				)
			)
			(8
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDiggerComes4050 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theDigger view: 43551 setCel: 0 init: hide:)
				(if (> (gEgo x:) 165)
					(gEgo setMotion: PolyPath 150 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 4355)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 4355 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(3
				(Load rsSOUND 4358)
				(gEgo setLoop: 1 1 setCel: 0)
				(gKqMusic1 stop:)
				(gSounds eachElementDo: #pause 1)
				(= cycles 6)
			)
			(4
				(sndEffect number: 4358 loop: 1 play: self)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: CT 2 1)
			)
			(5
				(gEgo loop: 1 1 cel: 2 setCycle: End self)
			)
			(6
				(gEgo normalize: 1)
				(= cycles 2)
			)
			(7
				(Load rsSOUND 4091)
				(= cycles 6)
			)
			(8
				(sfx number: 4092 loop: -1 play:)
				(sfx2 number: 4091 loop: -1 play:)
				(= cycles 6)
			)
			(9
				(theDigger y: 109)
				(= register 98)
				(if (gEgo scaler:)
					(theDigger setScaler: gEgo)
				)
				(theDigger
					setLoop: 2 1
					x: -10
					setCel: 0
					setCycle: Fwd
					show:
					setMotion: MoveTo register (theDigger y:) self
				)
			)
			(10
				(theDigger setCel: 0 setCycle: End self)
			)
			(11
				(sfx stop:)
				(theDigger setCel: 3)
				(if (IsFlag 171)
					(gMessager say: 1 65 2 3 self 4001) ; "(EXAPERATED)Geez, lady, call me when you know what you want. And don't blow that horn too often! It's enough to wake the dead!"
				else
					(gMessager say: 1 65 2 0 self 4001) ; "Where do you want me to dig?"
				)
			)
			(12
				(sfx play:)
				(theDigger
					setLoop: 2 1
					setCycle: Rev
					setMotion: MoveTo -10 (theDigger y:) self
				)
			)
			(13
				(sfx stop:)
				(sfx2 stop:)
				(gSounds eachElementDo: #pause 0)
				(gEgo normalize: 1)
				(gKqMusic1 play:)
				(theDigger dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sndEffect of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance wExit of PlatformExitFeature
	(properties
		nsTop 82
		nsRight 49
		nsBottom 119
		approachX -10
		approachY 109
		exitDir 4
		thePlatform 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Exit
			(gCurRoom setScript: sLeaveRoomWest)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 10 setHotspot: 10 10) ; Exit, Exit, Exit, Exit
	)
)

(instance sLeaveRoomWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 109 self)
			)
			(1
				(gCurRoom newRoom: 4000)
			)
		)
	)
)

(instance seExit of PlatformExitFeature
	(properties
		nsLeft 289
		nsTop 73
		nsRight 320
		nsBottom 116
		approachX 330
		approachY 108
		exitDir 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 10) ; Exit
			(gCurRoom setScript: sLeaveRoomSE)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 10 setHotspot: 10 10) ; Exit, Exit, Exit, Exit
	)
)

(instance sLeaveRoomSE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 108 self)
			)
			(1
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance cueSnd of Script
	(properties)

	(method (cue)
		(gdSound number: 0)
	)
)

(instance screamSound of Sound
	(properties)
)

(instance fallingDirt of Sound
	(properties)
)

(instance ambianceSound of Sound
	(properties)
)

(instance gdSound of Sound
	(properties)
)

(instance gdTalker of KQTalker
	(properties)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if (& gMsgType $0002)
					(==
						(DoAudio
							audPOSITION
							audModNum
							audNoun
							audVerb
							audCase
							audSequence
						)
						-1
					)
				else
					1
				)
				(or (!= modeless 0) (& gMsgType $0002))
			)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(if mouth
			(mouth doit:)
		)
		(return 1)
	)

	(method (init &tmp temp0)
		(= client
			(cond
				((== (gCurRoom script:) sDiggerComes4050) theDigger)
				(local1 machine)
				(else smallGraveDigger)
			)
		)
		(= temp0 (client cycler:))
		(client cycler: 0)
		(super init: &rest)
		(client cycler: temp0)
	)
)

(instance iGraffiti of Inset
	(properties
		picture 4051
		priority 100
	)

	(method (init)
		(super init: &rest)
		(proc11_6)
	)
)

