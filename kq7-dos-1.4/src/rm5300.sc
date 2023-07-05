;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5300)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use scaryInvInit)
(use eastFeat)
(use Inset)
(use Talker)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm5300 0
	chickenPetite 1
	chickenSound 2
	chickenTimerScript 3
	proc5300_4 4
	archDuke 5
	townHallDoor 6
	gateGuard 7
	enterFromGate 8
	archDukeSound 9
	fauxDoor 10
	bull 11
	chinaDoor 12
	archTalker 29
	chickenTalker 30
	guardTalker 31
	mockingBirdTalker 33
	snakeTalker 34
	chinaBirdTalker 35
	bullTalker 36
	fauxOwnerTalker 37
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(procedure (proc5300_4)
	(cond
		((and (gEgo has: 47) (not (IsFlag 111))) ; Magic_Statue
			(Load rsVIEW 5314)
			(chickenPetite
				view: 5311
				setLoop: 0 1
				cel: 0
				x: 607
				y: 117
				setCycle: 0
				init:
			)
		)
		((not (IsFlag 409))
			(chickenPetite
				view: 5323
				loop: 0
				cel: 0
				x: 520
				y: 108
				setCycle: 0
				init:
			)
		)
		((gCast contains: chickenPetite)
			(chickenPetite dispose:)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0)
	(return
		(<= (= temp0 (Abs (gThePlane left:))) param1 (+ temp0 (gThePlane resX:)))
	)
)

(procedure (localproc_1)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(gCurRoom
		addObstacle:
			(if (or (<= gChapter 4) (IsFlag 202))
				((Polygon new:)
					type: PContainedAccess
					init: 16 117 39 121 102 129 191 124 232 110 264 101 299 101 342 119 449 123 497 109 536 121 587 121 562 110 548 113 507 104 475 86 475 70 455 75 432 68 416 75 358 75 345 70 307 70 294 77 251 95 216 102 142 111 100 111 45 99
					yourself:
				)
			else
				((Polygon new:)
					type: PContainedAccess
					init: 57 105 57 116 21 116 14 117 39 121 102 129 191 124 232 110 264 101 299 101 342 119 449 123 497 109 536 121 587 121 562 108 548 113 507 104 475 86 475 70 455 75 432 68 416 75 357 75 343 68 307 68 294 77 251 95 216 102 142 111 100 111 51 98 39 105
					yourself:
				)
			)
			((Polygon new:)
				type: PBarredAccess
				init: 396 90 476 98 455 111 341 111 326 108 325 101
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 278 94 284 85 374 85 374 90 341 94
				yourself:
			)
	)
)

(instance rm5300 of KQRoom
	(properties
		picture 5301
		screen_mid 5302
	)

	(method (init &tmp temp0 temp1)
		(SetFlag 21)
		(Load rsMESSAGE 5300)
		(super init:)
		(= global372 -1)
		(= temp1 0)
		(= local13 0)
		(= temp0 5300)
		(= local10 gFtrInitializer)
		(= gFtrInitializer roomFeatureInitCode)
		(SetFlag 55)
		(= local6 ((ScriptID 19 1) nsTop:)) ; westFeat
		(= local7 ((ScriptID 19 0) nsTop:)) ; eastFeat
		((ScriptID 19 1) nsTop: 60) ; westFeat
		((ScriptID 19 0) nsTop: 60) ; eastFeat
		(localproc_1)
		(gEgo init: normalize: ignoreActors: 1 setScaler: Scaler 83 53 98 78)
		(= local1 (or (gEgo has: 43) (IsFlag 137) (IsFlag 121))) ; Mask
		(if (gEgo has: 47) ; Magic_Statue
			(SetFlag 123)
		)
		(ClearFlag 138)
		(genericEnterScript register: 0)
		(switch gPrevRoomNum
			(5400
				(self setRect: 0 0 640 136)
				(gEgo normalize: 3 heading: 0 posn: 20 112)
				(self setScript: enterFromGate)
			)
			(5050
				(self setRect: 0 0 640 136)
				(gEgo normalize: 3 heading: 0 posn: 127 118)
				(genericEnterScript register: (chinaDoor cel: 4 yourself:))
			)
			(5100
				(self setRect: 0 0 640 136)
				(gEgo posn: 239 100 normalize: 4 heading: 135)
				(SetFlag 449)
			)
			(5000
				(self setRect: -318 0 321 136)
				(gEgo normalize: 6 heading: 45 posn: 419 75)
				(fauxDoor cel: 5)
				(genericEnterScript register: fauxDoor)
			)
			(6200
				(self setRect: -318 0 321 136)
				(gEgo hide: setScale: 0)
				(gCurRoom setScript: (ScriptID 5301 7)) ; fallFromCloudland
			)
			(else
				(self setRect: 0 0 640 136)
				(gEgo normalize: 0 heading: 90 posn: 35 112)
				(if (and (== gChapter 5) (not (IsFlag 202)))
					(gEgo posn: 72 117)
				)
			)
		)
		(chinaDoor init:)
		(littleDoor init:)
		(glint1 init:)
		(cageDoor init:)
		(townHallDoor init:)
		(fauxDoor init:)
		(fauxSign init:)
		(if (and (!= gChapter 4) (not (IsFlag 203)) (not (IsFlag 204)))
			(wagon init:)
		)
		(if (or (<= gChapter 4) (IsFlag 202))
			(littleDoorExit init:)
		else
			(gateGuard init:)
		)
		(if (and (IsFlag 110) (not (IsFlag 203)))
			(chinaDoorExit init:)
		)
		(if (genericEnterScript register:)
			(self setScript: genericEnterScript)
		)
		(switch gChapter
			(3
				(if (and (not (gEgo has: 42)) (not (IsFlag 109))) ; China_Bird
					(birdCage init:)
					(cageCover init:)
					(chinaBird init:)
				)
				(if (and (not (IsFlag 126)) (IsFlag 111))
					(pool init:)
					(moon init: setScript: bobbingMoon)
				)
				(proc5300_4)
				(if (not (IsFlag 113))
					(mockingBird init:)
				)
				(if
					(and
						(IsFlag 113)
						(not (gEgo has: 44)) ; Wooden_Nickel
						(not (IsFlag 125))
					)
					(nickel init:)
				)
				(if (not (IsFlag 123))
					(fauxDoor loop: 5 x: 433 y: 71)
					(UpdateScreenItem fauxDoor)
					(snakeSalesman init: setScript: keepSalesmanBusy)
				else
					(if (IsFlag 122)
						(fauxDoorExit init:)
					)
					(wagonSign init:)
				)
				(gEgo actions: egoActions)
				(if local1
					(= local2 (if (< (gEgo x:) 181) 181 else 239))
					(= local3
						(Max
							(-
								50
								(Min
									(Abs (GetDistance (gEgo x:) 0 local2 0))
									50
								)
							)
							20
						)
					)
					(= local16 1)
					(partySound1 play: local3 0)
					(partySound2 play: local3 0)
				)
				(switch gPrevRoomNum
					(5400 0)
					(5100
						(townHallDoor cel: 4)
						(Load rsVIEW 5309)
						(Load rsVIEW 5307)
						(gEgo
							normalize: 4 9050
							posn: 206 88
							setPri: 88
							setScaler: Scaler 83 53 98 78
						)
						(gCurRoom setScript: fromAssembly)
					)
				)
				(cond
					((not (IsFlag 404))
						(Load rsSOUND 5301)
						(gCurRoom setScript: (ScriptID 5301 2)) ; openingScript
					)
					((not (IsFlag 110))
						(archDuke view: 5301 setLoop: 4 posn: 157 111)
						(archDuke cel: (archDuke lastCel:) init:)
					)
					((and (OneOf gPrevRoomNum 5050 5400) (not (IsFlag 407)))
						(SetFlag 407)
						(= local13 1)
						(gCurRoom setScript: (ScriptID 5301 0)) ; chickenCartoon2
					)
					(
						(and
							(IsFlag 407)
							(!= gPrevRoomNum 5100)
							(not (IsFlag 408))
						)
						(SetFlag 449)
						(townHallDoor cel: 4 setPri: 20)
						(badger
							view: 5313
							setLoop: 2
							setCel: 0
							x: 218
							y: 99
							setPri: 110
							init:
						)
						(stork init:)
						(hippo init:)
					)
				)
			)
			(4
				(mockingBird init:)
				(curtain init:)
				(if (IsFlag 149)
					(fauxDoorExit init:)
				)
				(if (== gPrevRoomNum 5100)
					(townHallDoor cel: 4)
					(gEgo
						posn: 206 88
						normalize: 4
						setPri: 88
						setScaler: Scaler 83 53 98 78
					)
					(gCurRoom setScript: fromAssembly)
				)
				(if (not (SetFlag 450))
					(= temp1 1)
					(SetFlag 166)
					(gCurRoom setScript: rosellaFirstEnter)
				)
			)
			(5
				(if (not (IsFlag 198))
					(snakeSalesman init: setScript: keepSalesmanBusy)
				else
					(curtain init:)
				)
				(if (not (IsFlag 203))
					(mockingBird init:)
				)
				(if (not (IsFlag 202))
					(bigGate init:)
				)
				(if
					(and
						(IsFlag 202)
						(not (IsFlag 136))
						(not (gEgo has: 41)) ; Feather
					)
					(feather init:)
				)
				(if (IsFlag 203)
					(= local2 (if (< (gEgo x:) 181) 181 else 239))
					(= local3
						(Max
							(-
								127
								(Min
									(Abs (GetDistance (gEgo x:) 0 local2 0))
									127
								)
							)
							0
						)
					)
					(= local16 1)
					(partySound1 number: 5409 play: local3 0)
				)
				(if (gEgo has: 48) ; Moon
					(sky init:)
				)
				(if (not (IsFlag 203))
					(fauxDoorExit init:)
				)
				(cond
					((IsFlag 273)
						(rubChicken init:)
					)
					((not (IsFlag 202))
						(yBranch init:)
					)
				)
				(if (== gPrevRoomNum 5100)
					(townHallDoor cel: 4)
					(if (IsFlag 154)
						(gEgo
							posn: 206 88
							normalize: 4
							setPri: 88
							setScaler: Scaler 83 53 98 78
						)
						(gCurRoom setScript: fromAssembly)
					else
						(gCurRoom setScript: escortedOutOfTownHall)
					)
				)
			)
		)
		(if
			(and
				(= local11 (gCast contains: snakeSalesman))
				(== gPrevRoomNum 5000)
			)
			(= temp0 5325)
		)
		(if (or (!= (gKqMusic1 number:) temp0) (not (gKqMusic1 handle:)))
			(gKqMusic1 number: temp0 loop: -1)
			(if (not temp1)
				(gKqMusic1 play:)
			)
		else
			(gKqMusic1 fade: 127 25 10 0)
		)
		(SetFlag 404)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (setScript param1)
		(if
			(and
				(not
					(OneOf
						param1
						(ScriptID 5301 2) ; openingScript
						rosellaFirstEnter
						escortedOutOfTownHall
					)
				)
				(OneOf
					script
					genericEnterScript
					enterFromGate
					fromAssembly
				)
			)
			(script next: param1)
		else
			(super setScript: param1 &rest)
		)
		(gEgo setSpeed: 6)
	)

	(method (doit)
		(super doit:)
		(if (== gChapter 3)
			(if
				(and
					(IsFlag 138)
					(gEgo has: 42) ; China_Bird
					(gCast contains: cageCover)
					(not (localproc_0 (- (cageCover nsLeft:) 40)))
				)
				(cageCover dispose:)
				(cageDoor cel: 0)
				(UpdateScreenItem cageDoor)
			)
			(if (not script)
				(if (and (not (IsFlag 110)) (>= (gEgo x:) 107))
					(gCurRoom setScript: cantPassDuke)
				)
				(if (and (not (IsFlag 409)) (localproc_0 561))
					(SetFlag 409)
					(if (IsFlag 97)
						(gEgo setMotion: 0)
					)
					(snakeSalesman setScript: 0)
					(gCurRoom setScript: snakeChickenCartoon)
				)
				(if
					(and
						(IsFlag 407)
						(not local13)
						(not (IsFlag 408))
						(localproc_0 193)
					)
					(SetFlag 408)
					(gCurRoom setScript: partyGoers)
				)
				(if
					(and
						(not (IsFlag 111))
						(gEgo has: 47) ; Magic_Statue
						(localproc_0 500)
					)
					(SetFlag 111)
					(gCurRoom setScript: moveEgoIntoPosition)
				)
			)
			(if (and local16 (not (<= 181 (gEgo x:) 239)))
				(cond
					((localproc_0 239)
						(= local2 (if (< (gEgo x:) 181) 181 else 239))
						(if
							(!=
								(= local3
									(Max
										(-
											50
											(Min
												(Abs
													(GetDistance
														(gEgo x:)
														0
														local2
														0
													)
												)
												50
											)
										)
										20
									)
								)
								(partySound1 vol:)
							)
							(partySound1 setVol: local3)
							(partySound2 setVol: local3)
						)
					)
					((partySound1 vol:)
						(partySound1 setVol: 20)
						(partySound2 setVol: 20)
					)
				)
			)
		)
		(if (== gChapter 5)
			(if (and local16 (not (<= 181 (gEgo x:) 239)))
				(cond
					((localproc_0 239)
						(= local2 (if (< (gEgo x:) 181) 181 else 239))
						(if
							(!=
								(= local3
									(Max
										(-
											127
											(Min
												(Abs
													(GetDistance
														(gEgo x:)
														0
														local2
														0
													)
												)
												127
											)
										)
										0
									)
								)
								(partySound1 vol:)
							)
							(partySound1 setVol: local3)
						)
					)
					((partySound1 vol:)
						(partySound1 setVol: 0)
					)
				)
			)
			(if (and local16 (not (IsFlag 347)) (<= 181 (gEgo x:) 239))
				(SetFlag 347)
				(gCurRoom setScript: (ScriptID 5301 6)) ; wereGonnaDie
			)
		)
		(if (not local12)
			(if (and local11 (localproc_0 541) (== (gKqMusic1 number:) 5300))
				(= local12 1)
				(gEgo setScript: switchMusic 0 5325)
			)
			(if
				(and
					(!= (gKqMusic1 number:) 5300)
					(or (not (localproc_0 541)) (not local11))
				)
				(= local12 1)
				(gEgo setScript: switchMusic 0 5300)
			)
		)
	)

	(method (notify)
		(fauxDoor setHotspot: 0)
		(fauxDoorExit init:)
	)

	(method (newRoom)
		(= gFtrInitializer local10)
		((ScriptID 19 1) nsTop: local6) ; westFeat
		((ScriptID 19 0) nsTop: local7) ; eastFeat
		(super newRoom: &rest)
	)

	(method (dispose)
		(gEgo actions: 0)
		(DisposeScript 5301)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance genericEnterScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gEgo mover:)
				((gCurRoom obstacles:)
					firstTrue: #onMe (gEgo x:) (gEgo y:)
				)
			)
			(gEgo setMotion: 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 802) ; WAVE
				(gEgo posn: (register approachX:) (register approachY:))
				(= cycles 1)
			)
			(1
				(register cel: (register lastCel:) setCycle: Beg self)
			)
			(2
				(gKqSound1 number: 802 setLoop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(3
				(if
					(not
						((gCurRoom obstacles:)
							firstTrue: #onMe (gEgo x:) (gEgo y:)
						)
					)
					(gEgo setMotion: MoveTo (gEgo x:) 150)
				else
					(= cycles 1)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(littleDoor cel: (littleDoor lastCel:))
				(= cycles 4)
			)
			(1
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(2
				(littleDoor setCycle: Beg self)
			)
			(3
				(gKqSound1 number: 802 loop: 1 play:)
				(gEgo setHeading: 90 self)
			)
			(4
				(if (== next (ScriptID 5301 0)) ; chickenCartoon2
					(gEgo setMotion: MoveTo 60 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 40 (gEgo y:) self)
				)
			)
			(5
				(if (and (not next) (== client gCurRoom))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance chickenRunsOff of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gKqMusic1 pause: 1)
					(chickenSound number: 5310 loop: -1 play:)
					(chickenPetite
						view: 5311
						setLoop: 6 1
						setCel: 0
						setPri: -1
						setCycle: End self
					)
				)
				(1
					(if (< (chickenPetite x:) 320)
						(= global372 8)
						(proc11_3 gEgo 315 104 0)
						(chickenPetite
							setLoop: 7 1
							setCel: 0
							setCycle: Walk
							setMotion: PolyPath 315 104 self
						)
					else
						(= global372 9)
						(= temp0 (- (Abs (gThePlane left:)) 15))
						(proc11_3 gEgo temp0 (chickenPetite y:) 0)
						(chickenPetite
							setLoop: 0 1
							setCycle: Walk
							setMotion: PolyPath temp0 (chickenPetite y:) self
						)
					)
					(gMessager say: 0 0 13 0 chickenPetite) ; "THE SKY IS FALLING! THE SKY IS FALLING! BAGAWK!"
				)
				(2
					(chickenSound fade:)
					(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
					(chickenPetite setCycle: 0)
					(proc5300_4)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(chickenSound stop:)
			(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
			(chickenPetite setCycle: 0 setMotion: 0)
			(proc5300_4)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance archDukeTalk of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) register)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(archDuke
					view: 5303
					setLoop: 0
					setCel: 0
					posn: 147 115
					setCycle: End self
				)
			)
			(1
				(if (not register)
					(archDuke setLoop: 1 setCel: 0 setCycle: Fwd)
				else
					(self cue:)
				)
			)
			(2
				(archDuke setLoop: 2 setCel: 0 setCycle: CT 16 1 self)
			)
			(3
				(gEgo setScript: getBlownOn)
				(archDuke setLoop: 2 setCel: 17 setCycle: CT 20 1 self)
			)
			(4
				(gKqSound1 number: 5305 loop: 1 play:)
				(archDuke setCycle: CT 24 1 self)
			)
			(5
				(gKqSound1 stop:)
				(archDuke setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance getBlownOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 5303
					setLoop: 8
					cel: 0
					setScale: 0
					posn: (+ (gEgo x:) 25) (gEgo y:)
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: 0
					x: (- (gEgo x:) 25)
					setScaler: Scaler 83 53 98 78
				)
				(self dispose:)
			)
		)
	)
)

(instance showTheComb of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsVIEW 5303)
					(Load 140 5305) ; WAVE
					(Load rsVIEW 8132)
					(Load rsVIEW 5334)
					(= register (gEgo cycleSpeed:))
					(gEgo
						view: 8241
						setLoop: (if (< 0 (gEgo heading:) 180) 0 else 1)
						setCel: 0
						cycleSpeed: 12
						setCycle: CT 20 1 self
					)
				)
				(1
					(gKqSound1 number: 1256 setLoop: -1 play:)
					(gEgo setCycle: End self)
				)
				(2
					(gEgo setCycle: CT 20 -1 self)
				)
				(3
					(gKqSound1 setLoop: 1 stop:)
					(gEgo setCycle: Beg self)
				)
				(4
					(gEgo
						normalize: 0
						setScaler: Scaler 83 53 98 78
						cycleSpeed: register
					)
					(= cycles 1)
				)
				(5
					(archTalker clientCel: -2 hide_mouth: 1 modeless: 2)
					(gMessager say: 1 5 6 1 self) ; "(SADLY, VOICE BREAKS ON LAST SENTENCE, SOFT SOB AFTERWARDS)Good sir, I want nothing from your town. I am only searching from my lost daughter, Rosella. She was stolen by some form of dark magic. Now I fear I will never see her again."
				)
				(6
					(self setScript: archDukeTalk self)
					(gMessager say: 1 5 6 2 self) ; "WAAAAAH! That'th the thaddetht thing I've ever heard! BOO HOO HOO! (slurp) Enjoy your thtay in Falderal, dear lady. Be thure to take the Faux Shop with a grain of thalt. I hope you find your daughter! (slurp snort) WAAAAAAH!"
				)
				(7
					(script register: 1)
				)
				(8
					(gKqMusic1 pause: 1)
					(chickenSound number: 5310 loop: -1 play:)
					(archTalker clientCel: -1 hide_mouth: 0 modeless: 1)
					(self setScript: standUpDuke self self)
					(= register (gEgo cycleSpeed:))
					(chickenPetite
						posn: 308 102
						setPri: 130
						view: 5303
						setLoop: 4
						setCel: 0
						init:
						setCycle: CT 16 1 self
					)
					(chickenTalker modeless: 2)
					(= global372 7)
					(gMessager say: 1 5 6 3 chickenPetite) ; "(SCREAMING)BAGAWK! THE SKY IS FALLING! THE SKY IS FALLING!"
				)
				(9
					(chickenPetite setCycle: CT 36 1 self)
					(gEgo
						view: 8132
						setLoop: 0
						setCel: 6
						cycleSpeed: 13
						setCycle: Beg
					)
				)
				(10
					(chickenPetite setCycle: End self)
					(gEgo setCycle: End)
				)
				(11
					(chickenSound fade:)
					(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
					(gEgo
						normalize: 0
						setScaler: Scaler 83 53 98 78
						cycleSpeed: register
					)
					(proc5300_4)
					(= cycles 2)
				)
				(12
					(archTalker clientCel: 4)
					(gMessager say: 1 5 6 4 self) ; "Jutht never mind her, my lady. (slurp) She'th very thilly."
				)
				(13
					(archTalker clientCel: -1)
					(archDuke setCycle: CT 12 1 self)
				)
				(14
					(archDuke setPri: 86 setCycle: End self)
				)
				(15
					(archDuke hide:)
					(townHallDoor setHotspot: 8 10 setCycle: Beg self) ; Do, Exit
				)
				(16
					(gKqSound1 number: 802 setLoop: 1 play:)
					(archDuke
						view: 5334
						setLoop: 3 1
						cel: 0
						posn: 218 88
						setPri: 82
						show:
						setCycle: Walk
						setScaler: Scaler 92 73 86 78
						setMotion: MoveTo 177 75 self
					)
				)
				(17
					(chickenTalker modeless: 1)
					(archDuke dispose:)
					(SetFlag 110)
					(if (gEgo scratch:)
						(gEgo addRespondVerb: 51) ; Salt_Crystals
					else
						(gEgo setHotspot: 0 51) ; Salt_Crystals
					)
					(chinaDoorExit init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gKqSound1 stop:)
					(gEgo setScript: 0)
					(if script
						(script caller: 0)
					)
					(= cycles 2)
				)
				(1
					(gEgo
						normalize: 0
						setScaler: Scaler 83 53 98 78
						posn: (archDuke approachX:) (archDuke approachY:)
						cycleSpeed: register
					)
					(archDuke dispose:)
					(SetFlag 110)
					(if (gEgo scratch:)
						(gEgo addRespondVerb: 51) ; Salt_Crystals
					else
						(gEgo setHotspot: 0 51) ; Salt_Crystals
					)
					(chickenPetite setCycle: 0 setMotion: 0)
					(proc5300_4)
					(archTalker clientCel: -1 hide_mouth: 0 modeless: 1)
					(chickenTalker modeless: 1)
					(chinaDoorExit init:)
					(chickenSound fade:)
					(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
					(archTalker clientCel: -1)
					(townHallDoor setHotspot: 8 10 cel: 0) ; Do, Exit
					(UpdateScreenItem townHallDoor)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance standUpDuke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(archDuke posn: 147 116 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(archDuke
					posn: 206 107
					setLoop: 5
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theMoonFalls of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load 140 907) ; WAVE
					(Load 140 854) ; WAVE
					(Load 140 836) ; WAVE
					(Load rsVIEW 5314)
					(localproc_1)
					(= global372 9)
					(chickenPetite
						view: 5311
						setLoop: 0 1
						setCycle: Walk
						posn: 607 117
						moveSpeed: 3
						setPri: -1
						init:
						setMotion: MoveTo 500 107 self
					)
					(chickenTalker hide_mouth: 1 modeless: 2)
					(gMessager say: 0 0 16 1 chickenPetite) ; "THE SKY IS FALLING! BAGAWK! THE SKY IS FALLING!"
				)
				(1
					(chickenPetite setMotion: PolyPath 468 94 self)
				)
				(2
					(chickenPetite setMotion: PolyPath 393 86 self)
				)
				(3
					(chickenPetite setMotion: PolyPath 321 102 self)
				)
				(4
					(= global372 8)
					(chickenPetite setLoop: (if (gTalkers size:) 7 else 8) 1)
					(chickenPetite setMotion: PolyPath 402 117 self)
				)
				(5
					(chickenPetite setMotion: PolyPath 477 98 self)
				)
				(6
					(= global372 8)
					(chickenPetite setLoop: (if (gTalkers size:) 0 else 9) 1)
					(chickenPetite setMotion: PolyPath 468 94 self)
				)
				(7
					(= global372 -1)
					(chickenPetite
						view: 5314
						setLoop: 5
						cel: 0
						x: 475
						y: 135
						setPri: 100
						setCycle: 0
					)
					(UnLoad 128 5311)
					(chickenTalker hide_mouth: 1 clientCel: -2)
					(moon
						view: 5314
						loop: 0
						cel: 0
						x: 382
						y: 95
						setPri: 150
						init:
						setCycle: End self
					)
				)
				(8
					(moon loop: 1 cel: 0 setCycle: End self)
				)
				(9
					(mockingBird
						view: 5314
						loop: 3
						cel: 0
						x: 349
						y: 49
						z: 0
						setPri: 150
						setCycle: CT 2 1
					)
					(moon loop: 2 cel: 0 setCycle: CT 1 1 self)
				)
				(10
					(gKqSound1 number: 907 loop: 1 play:)
					(moon loop: 2 setCycle: CT 11 1 self)
				)
				(11
					(self setScript: mockingBirdFlysAway)
					(moon setCycle: End self)
				)
				(12
					(chickenPetite setPri: -1 setCycle: CT 6 1 self)
				)
				(13
					(archDukeSound number: 854 loop: 1 play:)
					(chickenPetite setCycle: End self)
				)
				(14
					(gKqSound1 number: 836 loop: 1 play:)
					(chickenPetite
						view: 5315
						loop: 0
						cel: 0
						posn: 415 93
						setPri: 125
						setCycle: End self
					)
				)
				(15
					(moon setScript: bobbingMoon)
					(gKqSound1 number: 836 loop: 1 play:)
					(chickenPetite loop: 1 cel: 0 setCycle: End self)
				)
				(16
					(chickenPetite
						loop: 2
						cel: 0
						setHotspot: 8 10 ; Do, Exit
						approachVerbs: 8 ; Do
						setPri: 110
						setCycle: End self
					)
				)
				(17
					(gGame handsOn:)
					(pool init:)
					(self dispose:)
				)
			)
		else
			(self setScript: 0)
			(gKqSound1 stop:)
			(SetFlag 113)
			(mockingBird dispose:)
			(chickenPetite view: 5315 loop: 2)
			(chickenPetite
				cel: (chickenPetite lastCel:)
				posn: 415 93
				setPri: 110
				setMotion: 0
				setCycle: 0
				setHotspot: 8 10 ; Do, Exit
				approachVerbs: 8 ; Do
			)
			(nickel init:)
			(if (not (moon script:))
				(moon init: setScript: bobbingMoon)
			)
			(gEgo normalize: 5)
			(pool init:)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance bobbingMoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(moon
					setLoop: 6 1
					cel: 14
					cycleSpeed: 8
					posn: 409 93
					setPri: 110
					setCycle: Beg self
				)
			)
			(1
				(if register
					(moon setCycle: End self)
				else
					(-- state)
					(moon setCycle: ROsc 1 4 9 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance mockingBirdFlysAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 5312 loop: 1 play:)
				(mockingBird view: 5314 loop: 3 cel: 2 setCycle: End self)
			)
			(1
				(nickel init:)
				(mockingBird
					setLoop: 4 1
					cel: 0
					setCycle: Fwd
					posn: 362 52
					setPri: 150
					moveSpeed: 1
					setMotion: MoveTo 640 1 self
				)
			)
			(2
				(SetFlag 113)
				(mockingBird dispose:)
				(self dispose:)
			)
		)
	)
)

(instance cantPassDuke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(archTalker modeless: 2)
				(gMessager say: 0 0 2 0 self) ; "HALT! YIPYIPYIPYIPYIPYIPYIP!"
				(self setScript: stepBackEgo self)
			)
			(2 0)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stepBackEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 8021 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(gEgo
					normalize: 0
					setScaler: Scaler 83 53 98 78
					posn: 90 (gEgo y:)
					ignoreActors: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance walkThroughDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 801 loop: 1 play:)
				(fauxDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 457 69 self)
			)
			(2
				(gEgo setMotion: MoveTo 466 69 self)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(= seconds 3)
			)
			(5
				(gEgo
					setMotion:
						MoveTo
						(fauxDoor approachX:)
						(fauxDoor approachY:)
						self
				)
			)
			(6
				(fauxDoor setCycle: Beg self)
			)
			(7
				(gKqSound1 number: 802 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance partyGoers of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo setMotion: 0)
					(proc11_3 gEgo badger 0)
					(stork setCycle: CT 11 1 self)
					(hippo setCycle: CT 9 1 self)
				)
				(1 0)
				(2
					(badger setCycle: CT 12 1 self)
				)
				(3
					(guardTalker clientCel: -2 client: badger)
					(gMessager say: 0 0 15 0 self) ; "(ULTRA POLITE)Good evening, Sir and Madam. Do come right in."
				)
				(4
					(badger setPri: 110 setCycle: End self)
				)
				(5
					(stork setCycle: End self)
					(hippo setCycle: End self)
				)
				(6 0)
				(7
					(stork dispose:)
					(hippo view: 53130 setLoop: 0 cel: 0 setCycle: End self)
				)
				(8
					(hippo dispose:)
					(badger setCycle: CT 15 -1 self)
				)
				(9
					(badger
						view: 5305
						setLoop: 3
						posn: 217 93
						cel: 0
						setPri: 82
						setCycle: End self
					)
				)
				(10
					(badger dispose:)
					(townHallDoor setCycle: Beg self)
				)
				(11
					(gKqSound1 number: 802 loop: 1 play:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(ClearFlag 539)
			(gKqSound1 stop:)
			(badger dispose:)
			(hippo dispose:)
			(stork dispose:)
			(townHallDoor cel: 0)
			(UpdateScreenItem townHallDoor)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance rosellaFirstEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 5307)
				(Load rsSOUND 5308)
				(Load 140 5408) ; WAVE
				(townHallDoor cel: 4 setPri: 80)
				(archDukeSound number: 5307 loop: -1 play:)
				(archDuke
					view: 5341
					loop: 0
					cel: 0
					x: 229
					y: 105
					cycleSpeed: 10
					init:
					setCycle: Fwd
				)
				(self setScript: enterFromGate self)
			)
			(1
				(gEgo setMotion: PolyPath 170 111 self)
			)
			(2
				(archDukeSound number: 5308 loop: 1 play:)
				(archDuke cel: 0 setCycle: End self)
			)
			(3
				(archDuke loop: 1 cel: 0 x: 233 y: 105 setCycle: End self)
			)
			(4
				(archDuke loop: 2 cel: 0 x: 233 y: 105 setCycle: End self)
			)
			(5
				(archDukeSound fade: 0 50 20 1)
				(archTalker clientCel: -2)
				(gMessager sayRange: 0 0 35 1 3 self) ; "(EXCITED)OOH! It'th another one of thoth pink thingth! (slurp) Hello, pink thing! Welcome to Falderal! I am Arch-Duke Fifi le YipYap."
			)
			(6
				(archDukeSound number: 5307 loop: -1 play:)
				(archDuke view: 5341 loop: 0 cel: 0 x: 229 y: 105 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(archDukeSound number: 5308 loop: 1 play: fade: 0 50 20 1)
				(archDuke
					view: 5342
					loop: 0
					cel: 0
					x: 233
					y: 103
					setCycle: End self
				)
			)
			(8
				(gKqSound1 number: 5408 loop: 1 play:)
				(archDuke view: 5342 loop: 1 cel: 0 x: 233 y: 103)
				(UpdateScreenItem archDuke)
				(FrameOut)
				(= cycles 1)
			)
			(9
				(archTalker hide_mouth: 1 clientCel: -2)
				(gMessager say: 0 0 35 4 self) ; "YIPE! YIPE! YIPE!"
			)
			(10
				(gKqMusic1 loop: -1 play: setVol: 0 fade: 127 25 10 0)
				(archDuke
					view: 5334
					setLoop: 3 1
					cel: 0
					x: 234
					y: 100
					setPri: 82
					setCycle: Walk
					setMotion: MoveTo 177 75 self
				)
			)
			(11
				(archDuke dispose:)
				(townHallDoor setCycle: Beg self)
			)
			(12
				(gKqSound1 number: 802 loop: 1 play:)
				(if (not (SetFlag 167))
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 0 0 36 0 self) ; "(THINKS TO HERSELF IN AMAZEMENT)Mother...here? ARRESTED? No. No way. It couldn't be."
				else
					(self cue:)
				)
			)
			(13
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(if (gEgo scratch:)
					(gEgo addRespondVerb: 51) ; Salt_Crystals
				else
					(gEgo setHotspot: 0 51) ; Salt_Crystals
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snakeChickenCartoon of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsVIEW 5323)
					(Load rsVIEW 5325)
					(chickenPetite
						view: 5323
						loop: 0
						cel: 0
						x: 520
						y: 108
						init:
					)
					(chickenTalker hide_mouth: 0 clientCel: -2 modeless: 2)
					(gMessager say: 0 0 21 1 self) ; "BAGAWK! THE SKY IS FALLING! THE SKY IS FALLING!"
				)
				(1
					(snakeSalesman
						view: 5323
						loop: 1
						cel: 0
						posn: 529 92
						setCycle: End self
					)
				)
				(2
					(gMessager say: 0 0 21 2 self) ; "Aah, Then maybe you would prefer some of Professor Gluten'ss All Purposse Extra-Ssticky Glue to put it back!"
				)
				(3
					(snakeSalesman
						view: 5323
						loop: 2
						cel: 0
						posn: 534 95
						setCycle: End self
					)
				)
				(4
					(gMessager sayRange: 0 0 21 3 4 self) ; "SQUAAAAAWK! WHY doesn't anyone LISTEN to me? WHY? WHY? WHY?"
				)
				(5
					(snakeSalesman
						view: 5323
						loop: 3
						cel: 0
						posn: 543 90
						setCycle: End self
					)
				)
				(6
					(gMessager say: 0 0 21 5 self) ; "(FURIOUS)"OOOH! BAGAAAAAAWK!""
				)
				(7
					(chickenPetite setCycle: End self)
				)
				(8
					(chickenPetite dispose:)
					(snakeSalesman
						view: 5325
						loop: 0
						cel: 4
						posn: 491 128
						setCycle: End self
					)
				)
				(9
					(snakeSalesman setScript: keepSalesmanBusy)
					(gEgo setHeading: 180 self)
				)
				(10
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(chickenPetite dispose:)
			(if (not (snakeSalesman script:))
				(snakeSalesman setScript: keepSalesmanBusy)
			)
			(gEgo normalize: 2)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance getTheMoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5319)
				(guardTalker client: archDuke loop: 28)
				(gCurRoom centerScreen: -318 self 10)
			)
			(1
				(moon setScript: 0 cel: 9 setCycle: End)
				(gEgo
					view: 5319
					loop: 0
					cel: 0
					x: 463
					y: 101
					setPri: 109
					setScale: 0
					setCycle: CT 9 1 self
				)
			)
			(2
				(gKqSound1 number: 836 loop: -1 play:)
				(gEgo cel: 10 setCycle: End self)
			)
			(3
				(gEgo view: 5319 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 5319 loop: 2 cel: 0 setCycle: CT 5 1 self)
			)
			(5
				(gKqSound1 stop:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo view: 5319 loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(gKqSound1 number: 836 loop: -1 play:)
				(gEgo cel: 4 setCycle: End self)
			)
			(8
				(self setScript: crookFalls)
				(gEgo view: 5319 loop: 5 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				(gKqSound1 stop:)
				(gEgo setCycle: CT 15 1 self)
			)
			(10
				(gEgo setCycle: End self)
				(= local12 1)
				(gKqMusic1 number: 5315 loop: 1 play:)
				(gateGuard
					view: 5328
					setLoop: 2 1
					cel: 0
					init:
					posn: 290 113
					setCycle: Walk
					setSpeed: 4
					setMotion: MoveTo 420 118 gateGuard
				)
				(archDuke
					view: 5319
					loop: 6
					cel: 0
					x: 469
					y: 136
					setPri: 90
					cycleSpeed: 6
					init:
					setScale: 0
					setCycle: CT 29 1 self
				)
			)
			(11
				(archDuke setPri: 100 setCycle: End self)
			)
			(12
				(gEgo hide:)
				(archDuke view: 5319 loop: 7 cel: 0 setCycle: End self)
			)
			(13
				(if (gateGuard mover:)
					(-- state)
				)
				(= cycles 3)
			)
			(14
				(gMessager sayRange: 0 0 18 1 2 self) ; "(ANGRILY)Yipyipyip! I thaw what you jutht did! You jutht thtole the moon! MOON THIEF! Yapyapyap HUMAN! (slurp) yipyipyip PARTY POOPER!"
			)
			(15
				(guardTalker client: gateGuard loop: -1)
				(gMessager sayRange: 0 0 18 3 4 self) ; "Let's lock her up till we figure out what to do with her."
			)
			(16
				(= local12 1)
				(gKqMusic1 number: 5316 loop: 1 play: self)
			)
			(17
				(gEgo get: 48) ; Moon
				(SetFlag 126)
				(gCurRoom newRoom: 35) ; chapEndRm
			)
		)
	)
)

(instance crookFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crook
					view: 5319
					loop: 4
					cel: 0
					x: 425
					y: 93
					setPri: 140
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo put: 39) ; Crook
				(crook dispose:)
				(self dispose:)
			)
		)
	)
)

(instance talkToChicken of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(proc11_3 gEgo chickenPetite self)
				)
				(1
					(chickenTalker hide_mouth: 0)
					(gMessager say: 4 8 14 0 self) ; "(SLIGHTLY AMUSED)I had no choice but to hear you, my lady. What makes you think the sky is falling?"
				)
				(2
					(chickenPetite
						setLoop: 6 1
						setCel: 0
						setCycle: Fwd
						ignoreActors: 1
						setMotion: PolyPath 400 (chickenPetite y:) self
					)
				)
				(3
					(gEgo setHeading: 180 self)
				)
				(4
					(proc5300_4)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(gEgo normalize: 2)
			(chickenPetite setCycle: 0 setMotion: 0)
			(proc5300_4)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance talkToChickenAboutMoon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 8 17 1 self) ; "(CONSOLING)Don't be sad, little hen. I'm sure you can buy some more green cheese somewhere in town."
			)
			(1
				(chickenPetite view: 5311 setLoop: 6 cel: 0 posn: 424 82)
				(UpdateScreenItem chickenPetite)
				(FrameOut)
				(chickenTalker hide_mouth: 0 modeless: 2)
				(= cycles 1)
			)
			(2
				(gMessager say: 4 8 17 2 self) ; "Green cheese?"
			)
			(3
				(chickenTalker hide_mouth: 1 modeless: 2 loop: -1)
				(chickenPetite setCycle: CT 3 1 self)
			)
			(4
				(chickenPetite setLoop: 2 1 cel: 4 setCycle: Beg self)
			)
			(5
				(gMessager say: 4 8 17 3 self) ; "(GETTING ANGRY)Buck buck buck GREEN CHEESE?"
			)
			(6
				(gKqSound1 number: 5311 loop: 1 play:)
				(chickenPetite
					setCycle: ROsc -1 0 2
					moveSpeed: 8
					setMotion: MoveTo 452 64 self
				)
			)
			(7
				(chickenPetite setCycle: End self)
			)
			(8
				(gEgo hide:)
				(chickenPetite
					setLoop: 3
					cel: 0
					setPri: -1
					posn: 459 100
					setCycle: Fwd
				)
				(gMessager say: 4 8 17 4 self) ; "(SCREAMING)BAGAWK! That was not GREEN CHEESE! That was the MOON! THE SKY IS FALLING!"
			)
			(9
				(chickenPetite setCycle: End self)
			)
			(10
				(chickenPetite
					setLoop: 4
					cel: 0
					posn: 451 93
					setCycle: End self
				)
			)
			(11
				(gEgo show:)
				(= temp0 (- (Abs (gThePlane left:)) 10))
				(chickenPetite
					setLoop: 0 1
					setCel: 0
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath temp0 (chickenPetite y:) self
				)
				(gMessager say: 4 8 17 5 self) ; "BUCK BUCK BAGAWK!"
			)
			(12
				(gEgo
					normalize: 1
					posn: (chickenPetite approachX:) (chickenPetite approachY:)
					setHeading: 180 self
				)
			)
			(13 0)
			(14
				(proc5300_4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance uncoverCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 138)
				(cageCover dispose:)
				(chinaBird view: 5329 loop: 1 cel: 0 x: 571 y: 97 init:)
				(gEgo
					view: 5327
					loop: 0
					cel: 0
					x: 503
					y: 138
					setPri: 119
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(cageCover init:)
				(gEgo
					normalize: 2
					posn: (birdCage approachX:) (birdCage approachY:)
					setScaler: Scaler 83 53 98 78
					setHeading: 90
				)
				(chinaBird
					view: 5327
					loop: 1
					cel: 0
					x: 502
					y: 141
					setCycle: End self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openCageDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					view: 5327
					loop: 3
					cel: 0
					x: 535
					y: 123
					setScale: 0
					setCycle: CT 5 1 self
				)
			)
			(2
				(gKqSound1 number: 5330 loop: 1 play:)
				(cageDoor setCycle: End)
				(gEgo setCycle: CT 9 1 self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					normalize: 0
					posn: local8 local9
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTheChinaBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(gEgo setHeading: 90 self)
			)
			(1
				(gMessager say: 7 8 28 0 self) ; "(GENTLY)Hello, little bird."
			)
			(2
				(gEgo
					view: 5327
					loop: 3
					cel: 0
					x: 535
					y: 123
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(gEgo hide:)
				(chinaBird
					view: 5327
					loop: 4
					cel: 1
					x: 557
					y: 114
					setPri: 123
					setCycle: End self
				)
			)
			(4
				(chinaBird dispose:)
				(gEgo get: 42) ; China_Bird
				(birdCage dispose:)
				(gEgo
					show:
					posn: local8 local9
					normalize: 4
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryGetBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 119 setHeading: 90 self)
			)
			(1
				(cond
					((not (SetFlag 118))
						(self setScript: firstAttemptToGetBird self)
					)
					((not (SetFlag 119))
						(self setScript: secondAttemptToGetBird self)
					)
				)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstAttemptToGetBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(gMessager sayRange: 7 8 29 1 3 self) ; "(GENTLY)Hello there."
			)
			(1
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(2
				(chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(3
				(chinaBirdTalker hide_mouth: 1)
				(gMessager say: 7 8 29 4 self) ; "(TERRIFIED, STARTS TO SCREAM)Don't TOUCH me! I don't know you! HELP! HEEEEELP!"
			)
			(4
				(snakeSalesman hide:)
				(= seconds 2)
			)
			(5
				(chinaBirdTalker hide_mouth: 0)
				(snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					show:
					setCycle: CT 6 1 self
				)
			)
			(6
				(snakeSalesman setPri: 121 setCycle: End self)
			)
			(7
				(gMessager say: 7 8 29 5 self) ; "(MENACING)Shoplifters are not welcome at this wagon, lady. The lasst one I encountered is for sale, in that little jar in the back."
			)
			(8
				(ClearFlag 138)
				(snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(9
				(cageCover dispose:)
				(snakeSalesman cel: 3 setCycle: CT 10 1 self)
			)
			(10
				(gKqSound1 number: 5331 loop: 1 play:)
				(cageDoor cel: (cageDoor lastCel:) setCycle: Beg self)
				(snakeSalesman setCycle: CT 24 1 self)
			)
			(11
				(cageCover init:)
				(snakeSalesman cel: 25 setCycle: End self)
				(chinaBird setCycle: Beg)
			)
			(12
				(snakeSalesman
					view: 5329
					setLoop: 8
					cel: 4
					posn: 554 108
					setCycle: CT 13 1 self
				)
			)
			(13
				(snakeSalesman setPri: 80 setCycle: End self)
			)
			(14
				(snakeSalesman hide:)
				(= seconds 2)
			)
			(15
				(snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					show:
					setScript: keepSalesmanBusy
				)
				(gEgo
					posn: local8 local9
					normalize:
					setScaler: Scaler 83 53 98 78
				)
				(self dispose:)
			)
		)
	)
)

(instance secondAttemptToGetBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(1
				(chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(2
				(chinaBirdTalker hide_mouth: 1)
				(gMessager say: 7 8 31 1 self) ; "NO! NO! HELP! HELP!"
			)
			(3
				(snakeSalesman hide:)
				(= seconds 2)
			)
			(4
				(chinaBirdTalker hide_mouth: 0)
				(snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					show:
					setCycle: CT 6 1 self
				)
			)
			(5
				(snakeSalesman setPri: 121 setCycle: End self)
			)
			(6
				(gMessager say: 7 8 31 2 self) ; "(VERY MENACING)I wouldn't do that if I were you, madam. No indeed!"
			)
			(7
				(ClearFlag 138)
				(snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(8
				(cageCover dispose:)
				(snakeSalesman cel: 3 setCycle: CT 10 1 self)
			)
			(9
				(gKqSound1 number: 5331 loop: 1 play:)
				(cageDoor cel: (cageDoor lastCel:) setCycle: Beg self)
				(snakeSalesman setCycle: CT 24 1 self)
			)
			(10
				(cageCover init:)
				(snakeSalesman cel: 25 setCycle: End self)
			)
			(11
				(snakeSalesman
					view: 5329
					setLoop: 8
					cel: 4
					posn: 554 108
					setCycle: CT 13 1 self
				)
			)
			(12
				(snakeSalesman setPri: 80 setCycle: End self)
			)
			(13
				(snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					setScript: keepSalesmanBusy
				)
				(gEgo
					posn: local8 local9
					normalize:
					setScaler: Scaler 83 53 98 78
				)
				(self dispose:)
			)
		)
	)
)

(instance takeBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(gEgo
					setScale: 0
					view: 5329
					loop: 0
					cel: 0
					x: 550
					y: 109
					setCycle: End self
				)
			)
			(1
				(chinaBird
					view: 5329
					loop: 1
					cel: 0
					x: 571
					y: 97
					setCycle: End self
				)
			)
			(2
				(chinaBirdTalker hide_mouth: 1)
				(gMessager say: 7 8 32 1 self) ; "AAAAH! HELP! HELP!"
			)
			(3
				(chinaBirdTalker hide_mouth: 0)
				(snakeSalesman
					setScript: 0
					view: 5329
					loop: 2
					cel: 0
					x: 522
					y: 96
					setPri: 88
					setCycle: CT 6 1 self
				)
			)
			(4
				(snakeSalesman setPri: 121 setCycle: End self)
			)
			(5
				(ClearFlag 138)
				(snakeSalesman
					view: 5329
					loop: 3
					cel: 0
					x: 519
					y: 105
					setCycle: CT 2 1 self
				)
			)
			(6
				(cageCover dispose:)
				(snakeSalesman cel: 3 setCycle: CT 10 1 self)
			)
			(7
				(gKqSound1 number: 5331 loop: 1 play:)
				(cageDoor cel: (cageDoor lastCel:) setCycle: Beg self)
				(snakeSalesman setCycle: CT 24 1 self)
			)
			(8
				(cageCover init:)
				(snakeSalesman cel: 25 setCycle: End self)
			)
			(9
				(snakeTalker hide_mouth: 1 clientCel: -2)
				(gMessager say: 7 8 32 2 self) ; "(VERY MENACING)Don't say I didn't warn you!"
			)
			(10
				(gEgo hide:)
				(snakeSalesman
					view: 5329
					loop: 5
					cel: 0
					x: 552
					y: 112
					setCycle: CT 14 1 self
				)
			)
			(11
				(gKqSound1 number: 831 loop: 1 play:)
				(snakeSalesman setCycle: End self)
			)
			(12
				(snakeSalesman
					view: 5329
					loop: 6
					cel: 0
					x: 576
					y: 113
					setCycle: CT 11 1 self
				)
			)
			(13
				(gKqSound1 number: 825 loop: 1 play:)
				(snakeSalesman setCycle: CT 34 1 self)
			)
			(14
				(snakeTalker hide_mouth: 1)
				(gMessager say: 7 8 32 3 self) ; "(NASTY LAUGH)Oh well. I've always liked my ladies...statuesque!"
			)
			(15
				(snakeTalker hide_mouth: 0)
				(snakeSalesman setCycle: End self)
			)
			(16
				(EgoDead 45 self)
			)
			(17
				(snakeSalesman
					view: 5323
					loop: 1
					cel: 0
					posn: 531 90
					setPri: 90
					setScript: keepSalesmanBusy
				)
				(gEgo
					show:
					normalize:
					posn: local8 local9
					setScaler: Scaler 83 53 98 78
				)
				(gEgo setHeading: 180 self)
			)
			(18
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveStatue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 61 0 1 self) ; "Here you are. The magic statuette."
			)
			(1
				(if (snakeSalesman script:)
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(2
				(snakeSalesman hide:)
				(wagon dispose:)
				(gEgo
					view: 5338
					setLoop: 1 1
					cel: 0
					posn: 515 107
					setScale: 0
					setCycle: CT 9 1 self
				)
			)
			(3
				(SetFlag 204)
				(gEgo put: 47 setCycle: CT 11 1 self) ; Magic_Statue
			)
			(4
				(gEgo
					normalize: 6
					posn: 494 108
					setScaler: Scaler 83 53 98 78
				)
				(snakeSalesman
					view: 5338
					setLoop: 1 1
					posn: 515 107
					cel: 12
					show:
					setPri: 110
					setCycle: End self
				)
			)
			(5
				(snakeSalesman setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(6
				(snakeSalesman setLoop: 3 1 cel: 0 setCycle: CT 6 1 self)
				(gEgo view: 8075 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(7 0)
			(8
				(snakeSalesman setCycle: End self)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 6 posn: 494 108)
				((ScriptID 13 0) ; aEgoTalker
					client: gEgo
					view: -1
					loop: -1
					clientCel: -2
				)
				(snakeTalker view: 5338 loop: 24 clientCel: -2)
				(gMessager sayRange: 6 61 0 2 6 self) ; "And here is your were-beasst salve, my Lady Valanice."
			)
			(10
				(gKqSound1 number: 5333 loop: 1 play:)
				(snakeSalesman setLoop: 4 1 cel: 0 setCycle: End self)
			)
			(11
				(gKqSound1 stop:)
				(curtain init:)
				(= local11 0)
				(gEgo get: 65) ; Were-beast_Salve
				(SetFlag 198)
				(= cycles 1)
			)
			(12
				(gEgo setHeading: 180 self)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockOnTownHallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5305)
				(Load rsVIEW 5306)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 5306
					loop: 0
					cel: 0
					posn: 231 104
					setScale: 0
					setCycle: CT 2 1 self
				)
				(gKqSound1 number: 808 loop: 1 play:)
			)
			(2
				(gKqSound1 number: 808 loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(3
				(gKqSound1 number: 801 setLoop: 1 play:)
				(townHallDoor setCycle: CT 4 1 self)
			)
			(4
				(if (not (IsFlag 421))
					(gEgo
						view: 5306
						setLoop: 3
						cel: 0
						posn: 236 100
						setCycle: End
					)
				else
					(gEgo normalize: 7 setScaler: Scaler 83 53 98 78)
				)
				(badger
					view: 5306
					setLoop: 2
					cel: 0
					posn: 226 97
					setPri: 86
					init:
					setCycle: End self
				)
			)
			(5
				(cond
					((not (SetFlag 421))
						(self setScript: firstDoorKnock self)
					)
					((not (SetFlag 420))
						(gMessager say: 3 8 9 0 self) ; "(TRYING TO BE PATIENT)Sir, I'm not trying to interrupt the party. All I want is--"
					)
					(else
						(gMessager say: 3 8 10 0 self) ; "GO AWAY! No mask, no party!"
					)
				)
			)
			(6
				(badger
					view: 5305
					setLoop: 3
					posn: 217 93
					cel: 0
					setCycle: End self
				)
			)
			(7
				(badger dispose:)
				(townHallDoor setCycle: Beg self)
			)
			(8
				(gKqSound1 number: 802 setLoop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstDoorKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 8 8 1 self) ; "(BELLIGERANT)What do you want?"
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 7
					posn: (townHallDoor approachX:) (townHallDoor approachY:)
					setScaler: Scaler 83 53 98 78
				)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gMessager sayRange: 3 8 8 2 3 self) ; "Well, I'm trying to find my daughter Rosella, and--"
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance escortedOutOfTownHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(townHallDoor cel: 4 setPri: 10)
				(badger
					view: 5306
					loop: 2
					cel: 0
					x: 226
					y: 98
					priority: 83
					fixPriority: 1
					init:
					setCycle: End self
				)
				(gEgo
					normalize: 4
					posn: 220 97
					setMotion: MoveTo 240 103 self
				)
			)
			(1
				(proc11_3 gEgo badger)
			)
			(2
				(badger
					view: 5305
					setLoop: 3
					posn: 217 93
					cel: 0
					setCycle: End self
				)
			)
			(3
				(badger dispose:)
				(townHallDoor setCycle: Beg self)
			)
			(4
				(gKqSound1 number: 802 loop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterTownHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 232 100
					view: 5307
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setScale: 0
				)
				(UpdateScreenItem gEgo)
				(FrameOut)
				(gKqSound1 number: 808 loop: 1 play: self)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gKqSound1 play:)
				(gEgo setCycle: CT 2 1 self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gKqSound1 play:)
				(gEgo setCycle: CT 3 1 self)
			)
			(6
				(gKqSound1 number: 801 loop: 1 play:)
				(townHallDoor setPri: 80 setCycle: CT 4 1 self)
			)
			(7
				(badger
					view: 5306
					loop: 2
					cel: 0
					x: 226
					y: 98
					priority: 83
					fixPriority: 1
					init:
					setCycle: End self
				)
			)
			(8
				(gEgo cel: 5 posn: 221 103 setPri: 83 setCycle: CT 6 1 self)
			)
			(9
				(badger hide:)
				(gEgo cel: 7 setCycle: End self)
			)
			(10
				(guardTalker client: gEgo)
				(gMessager say: 3 8 11 0 self) ; "Welcome, my lady."
			)
			(11
				(gEgo posn: 240 101 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo
					posn: 242 100
					setLoop: 2
					setCel: 0
					setCycle: CT 12 1 self
				)
			)
			(13
				(gEgo setPri: 88 setCycle: End self)
			)
			(14
				(gCurRoom newRoom: 5100)
			)
		)
	)
)

(instance dukeStopsVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(proc11_3 gEgo archDuke)
				(archDuke posn: 160 111 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(1
				(archTalker modeless: 2)
				(gMessager say: 0 0 2 0 self) ; "HALT! YIPYIPYIPYIPYIPYIPYIP!"
				(self setScript: egoBackOff self)
			)
			(2 0)
			(3
				(archTalker modeless: 1)
				(archDuke setCycle: Beg self)
			)
			(4
				(archDuke posn: 225 112 setLoop: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoBackOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 5301
					setLoop: 5
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 0 setScaler: Scaler 83 53 98 78)
				(self dispose:)
			)
		)
	)
)

(instance fromAssembly of Script
	(properties)

	(method (changeState newState)
		(= cycles 0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 4)
			)
			(1
				(gEgo
					setLoop: (gEgo loop:) 1
					setMotion: MoveTo 229 99 self
				)
			)
			(2
				(townHallDoor setCycle: Beg self)
			)
			(3
				(gKqSound1 number: 802 loop: 1 play:)
				(gEgo setHeading: 225 self)
			)
			(4
				(if (== gChapter 3)
					(self setScript: removeValsMask self)
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo normalize: 5 setScaler: Scaler 83 53 98 78)
				(gEgo setHeading: 180 self)
			)
			(6
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance removeValsMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 5309
					setLoop: 0
					setCel: 21
					setScale: 0
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(1
				(gEgo setLoop: 2 cel: 27 setCycle: Beg self)
			)
			(2
				(gEgo get: 43) ; Mask
				(ClearFlag 137)
				(self dispose:)
			)
		)
	)
)

(instance putOnMask of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(and
					(& (event type:) evMOUSEBUTTON)
					(= temp0 1)
					(or (event localize: gThePlane) 1)
					(gThePlane onMe: event)
					(not (townHallDoor onMe: event))
				)
				(& (event type:) evMOVE)
			)
			(event claimed: 1)
			(self changeState: 4)
		)
		(if temp0
			(event globalize:)
		)
		(event claimed:)
	)

	(method (dispose)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 237 98 self)
			)
			(1
				(gEgo
					view: 5309
					setLoop: 2
					setCel: 0
					setScale: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo view: 5309 setLoop: 0 1 setCel: 0 setCycle: End self)
				(SetFlag 137)
				(gEgo put: 43) ; Mask
			)
			(3
				(gWalkHandler add: self)
				(gMouseDownHandler add: self)
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(gWalkHandler delete: self)
				(gMouseDownHandler delete: self)
				(gEgo
					view: 5309
					setLoop: 0
					setCel: 21
					setScale: 0
					setCycle: Beg self
				)
				(ClearFlag 137)
				(gEgo get: 43) ; Mask
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(gGame handsOn:)
				(gEgo normalize: 5 setScaler: Scaler 83 53 98 78)
				(self dispose:)
			)
		)
	)
)

(instance chickenTimerScript of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp1 0)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(= temp1 1)
				(or (event localize: gThePlane) 1)
				(chickenPetite onMe: event)
			)
			(event globalize:)
			(self dispose:)
			(return 0)
		)
		(if temp1
			(event globalize:)
		)
		(if
			(and
				(gThePlane onMe: event)
				(or (& (event type:) evMOVE) (& (event type:) evMOUSEBUTTON))
			)
			(event claimed: 1)
			(self seconds: 0 cycles: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(chickenPetite setHotspot: 8 10) ; Do, Exit
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gWalkHandler add: self)
				(gMouseDownHandler add: self)
				(chickenPetite setHotspot: 8 10) ; Do, Exit
				(= seconds (+ register 1))
			)
			(1
				(chickenPetite setHotspot: 0)
				(gCurRoom setScript: chickenRunsOff)
				(self dispose:)
			)
		)
	)
)

(instance enterChinaShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gValOrRoz -3) ; Roz
					(gEgo
						view: 8123
						setLoop: 1 1
						cel: 0
						setCycle: CT 14 1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gKqSound1 number: 801 setLoop: 1 play:)
				(chinaDoor setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 5050)
			)
		)
	)
)

(instance getWoodenNickel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5317
					loop: 0
					cel: 0
					x: 371
					y: 89
					setScale: 0
					cycleSpeed: 6
					setPri: 108
					setCycle: End self
				)
			)
			(1
				(gEgo
					loop: 1
					cel: 0
					posn: 372 82
					setPri: 150
					setCycle: CT 6 1 self
				)
			)
			(2
				(nickel dispose:)
				(gEgo get: 44) ; Wooden_Nickel
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setCycle: CT 7 -1 self)
			)
			(4
				(gEgo
					loop: 0
					cel: 15
					x: 371
					y: 89
					setPri: -1
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					normalize: 5
					posn: (nickel approachX:) (nickel approachY:)
					setScaler: Scaler 83 53 98 78
					setHeading: 180 self
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance switchMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqMusic1 fade: 30 25 20 1 self)
			)
			(1
				(gKqMusic1 number: register loop: -1 play: setVol: 30)
				(gKqMusic1 fade: 127 25 20 0)
				(= local12 (= register 0))
				(self dispose:)
			)
		)
	)
)

(instance moveEgoIntoPosition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 482 91 self)
			)
			(1
				(gCurRoom centerScreen: -318 self)
				(gEgo setHeading: 225 self)
			)
			(2 0)
			(3
				(gCurRoom setScript: theMoonFalls)
			)
		)
	)
)

(instance archDuke of Actor
	(properties
		heading 270
		noun 1
		sightAngle 90
		approachX 105
		approachY 116
		x 210
		y 115
		view 5301
		loop 2
	)

	(method (init)
		(super init:)
		(if (!= gChapter 4)
			(self setHotspot: 9998 approachVerbs: 9998)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: talkToDuke)
			)
			(5 ; Golden_Comb
				(gCurRoom setScript: showTheComb)
			)
			(else
				(gMessager say: noun 0 5 0) ; "Sir, I wonder if you might be interested in--"
			)
		)
	)
)

(instance talkToDuke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo archDuke self)
			)
			(1
				(if (not (SetFlag 410))
					(gMessager say: 1 8 3 0 self) ; "Please, noble Arch-Duke, you must let me by. I am on an errand of great importance."
				else
					(gMessager say: 1 8 4 0 self) ; "Sir--"
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chickenPetite of Actor
	(properties
		noun 4
		x 180
		y 90
		view 5300
		cel 1
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (super onMe: param1))
		(if (and (param1 type:) (IsFlag 111))
			(= approachX 464)
			(= approachY 97)
		)
		(return temp0)
	)

	(method (doVerb)
		(if (IsFlag 111)
			(gCurRoom setScript: talkToChickenAboutMoon)
		else
			(gCurRoom setScript: talkToChicken)
		)
	)

	(method (cue)
		(return
			(if (!= global372 -1)
				(self setLoop: global372 1)
				(== global372 -1)
			)
		)
	)
)

(instance badger of Actor
	(properties
		noun 10
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((not (SetFlag 411))
						(gMessager say: noun theVerb 39 0) ; "Good day, sir. Kindly let me pass."
					)
					((not (SetFlag 412))
						(gMessager say: noun theVerb 38 0) ; "This is ridiculous. Let me out, guard."
					)
					(else
						(gMessager say: noun theVerb 40 0) ; "Go away, you little convict!"
					)
				)
			)
		)
	)
)

(instance curtain of View
	(properties
		x 533
		y 84
		priority 98
		fixPriority 1
		view 5302
		loop 6
	)
)

(instance chinaBird of Prop
	(properties
		x 504
		y 143
		priority 95
		fixPriority 1
		view 5327
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance mockingBird of Actor
	(properties
		noun 5
		sightAngle 10
		approachX 371
		approachY 89
		x 349
		y 89
		z 40
		priority 93
		fixPriority 1
		view 5321
		cel 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((and (== gValOrRoz -3) (not (SetFlag 414))) ; Roz
						(gMessager say: 5 8 37 0) ; "Hello there, little bird."
					)
					((and (== gValOrRoz -4) (not (SetFlag 413))) ; Val
						(gMessager say: 5 8 19 0) ; "What a sweet little bird! Hello there, pretty!"
					)
					(
						(if (IsFlag 415)
							(gMessager say: noun theVerb 20 global315)
						else
							(gMessager say: noun theVerb 0 global315)
						)
						(cond
							((IsFlag 415)
								(if (== global315 15)
									(ClearFlag 415)
									(= global315 0)
								)
							)
							((== global315 35)
								(SetFlag 415)
								(= global315 0)
							)
						)
						(++ global315)
					)
				)
			)
		)
	)
)

(instance stork of Prop
	(properties
		x 272
		y 106
		view 5313
	)

	(method (init)
		(super init: &rest)
		(if (not (localproc_0 195))
			(= cel 11)
		)
	)
)

(instance hippo of Prop
	(properties
		x 264
		y 107
		view 5313
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (not (localproc_0 195))
			(= cel 9)
		)
	)
)

(instance moon of Prop
	(properties
		approachX 362
		approachY 78
		x 350
		y 75
		view 5314
	)

	(method (init)
		(super init:)
		(self heading: 135 setHotspot: 0 52 approachVerbs: 52) ; Crook, Crook
	)

	(method (doVerb theVerb)
		(pool doVerb: theVerb)
	)
)

(instance nickel of View
	(properties
		approachX 371
		approachY 89
		x 351
		y 48
		priority 95
		fixPriority 1
		view 5321
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		(&= signal $efff)
	)

	(method (doVerb)
		(gCurRoom setScript: getWoodenNickel)
	)
)

(instance yBranch of Feature
	(properties
		approachX 279
		approachY 102
		x 288
		y 81
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 60 ; Do, Exit, Rubber_Chicken
			approachVerbs: 8 60 ; Do, Rubber_Chicken
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 57 294 47 316 53 311 89
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sayHmmm)
			)
			(60 ; Rubber_Chicken
				(gCurRoom setScript: putChickenOnTree)
				(self dispose:)
			)
		)
		(return 1)
	)
)

(instance sayHmmm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8295 setLoop: 0 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(1
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putChickenOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 5330
					loop: 0
					cel: 0
					x: 269
					y: 103
					setCycle: End self
				)
			)
			(1
				(gEgo loop: 1 cel: 0 x: 269 y: 103 setCycle: End self)
			)
			(2
				(SetFlag 273)
				(gEgo put: 46) ; Rubber_Chicken
				(rubChicken init:)
				(gEgo
					normalize: 6
					posn: 283 102
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rubChicken of Actor
	(properties
		approachX 279
		approachY 102
		x 298
		y 61
		priority 93
		fixPriority 1
		view 5331
		loop 4
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 71 approachVerbs: 8 71) ; Do, Exit, Moon, Do, Moon
		(&= signal $efff)
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1))
			(if (== (gUser message:) 8)
				(= approachX 279)
				(= approachY 102)
			)
			(if (== (gUser message:) 71)
				(= approachX 282)
				(= approachY 100)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getChickenDown)
				(return 1)
			)
			(71 ; Moon
				(gCurRoom setScript: replaceTheMoon)
				(return 1)
			)
		)
	)
)

(instance getChickenDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 5332
					loop: 0
					cel: 0
					x: 269
					y: 103
					setScale: 0
					setCycle: End self
				)
				(gEgo get: 46) ; Rubber_Chicken
				(ClearFlag 273)
				(rubChicken dispose:)
				(yBranch init:)
			)
			(1
				(gEgo
					normalize: 3
					posn: (rubChicken approachX:) (rubChicken approachY:)
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance replaceTheMoon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 5405) ; WAVE
				(Load rsSOUND 854)
				(Load 140 5404) ; WAVE
				(gEgo
					view: 5331
					loop: 0
					cel: 0
					x: 282
					y: 99
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(rubChicken hide:)
				(gKqSound1 number: 5404 loop: 1 play:)
				(gEgo
					view: 5331
					loop: 1
					cel: 0
					x: 281
					y: 103
					setCycle: End self
				)
			)
			(2
				(= cycles 60)
			)
			(3
				(if (and (not (IsFlag 136)) (not (gEgo has: 41))) ; Feather
					(feather init:)
				)
				(gKqSound1 number: 854 loop: 1 play:)
				(gEgo
					view: 5331
					loop: 2
					cel: 0
					x: 280
					y: 103
					setCycle: End self
				)
			)
			(4
				(gEgo
					put: 48 ; Moon
					normalize: 6
					posn: 278 102
					setScaler: Scaler 83 53 98 78
				)
				(gKqSound1 number: 5405 loop: 1 play:)
				(rubChicken
					show:
					view: 5331
					loop: 3
					cel: 0
					x: 296
					y: 96
					setCycle: End self
				)
			)
			(5
				(= temp0 (+ (Abs ((gCurRoom plane:) left:)) 330))
				(rubChicken
					setLoop: 6 1
					cel: 0
					posn: 327 94
					setCycle: Walk
					setPri: -1
					setMotion: PolyPath temp0 94 self
				)
			)
			(6
				(ClearFlag 273)
				(rubChicken dispose:)
				(littleDoorExit init:)
				(bigGate dispose:)
				(SetFlag 202)
				(localproc_1)
				(archTalker clientCel: -2)
				(gCurRoom setScript: (ScriptID 5301 1)) ; congrats
			)
		)
	)
)

(instance cageCover of View
	(properties
		x 572
		y 89
		view 5300
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 138)
			(self loop: 0 x: 510 y: 120 setPri: 1)
		else
			(self loop: 1 cel: 0 x: 559 y: 70 setPri: 110)
		)
		(self ignoreActors:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance sky of Feature
	(properties
		nsRight 640
		nsBottom 45
		y 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 71 sightAngle: 7000) ; Moon
	)

	(method (doVerb)
		(gCurRoom setScript: tryAndThrowMoonUp)
	)
)

(instance tryAndThrowMoonUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 5336 setLoop: 0 1 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(gKqSound1 number: 824 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 1 cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(gKqSound1 number: 856 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bigGate of Feature
	(properties
		noun 9
		nsLeft 38
		nsTop 25
		nsRight 59
		nsBottom 70
		approachX 55
		approachY 106
		y 2
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 97 55 91 56 66 63 30 61 23 53 18 43 16 35 18 25 27 21 35 34 35 34 40 31 45 30 70
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			(gMessager say: noun theVerb 38 0) ; "(THINKING TO HERSELF, IRRITATED)What--? No hinges! This gate can NEVER open!"
			((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
			(self setHotspot: 0)
			(return 1)
		)
	)
)

(instance littleDoor of Prop
	(properties
		approachX 50
		approachY 112
		x 7
		y 109
		priority 10
		fixPriority 1
		view 5302
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance littleDoorExit of ExitFeature
	(properties
		approachX 42
		approachY 112
		x 20
		y 113
		exitDir 4
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 110 7 95 8 83 11 74 15 73 22 78 24 89 24 105
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: exitToGate)
		(return 1)
	)
)

(instance exitToGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 801 loop: 1 play:)
				(littleDoor setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 27 113 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(if (== gValOrRoz -4) ; Val
					(gEgo
						view: 8065
						loop: 1
						cel: 0
						priority: 109
						fixPriority: 1
						setCycle: CT 4 1 self
					)
				else
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 5400)
			)
		)
	)
)

(instance chinaDoor of Prop
	(properties
		noun 11
		approachX 116
		approachY 109
		x 128
		y 104
		priority 10
		fixPriority 1
		view 5302
	)

	(method (init)
		(super init: &rest)
		(if (and (IsFlag 203) (not (IsFlag 284)))
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		)
	)

	(method (doVerb)
		(gCurRoom setScript: (ScriptID 5301 5)) ; crackChinaDoor
	)
)

(instance chinaDoorExit of ExitFeature
	(properties
		noun 11
		approachX 116
		approachY 109
		exitDir 1
	)

	(method (init)
		(super init:)
		(= x approachX)
		(= y (chinaDoor y:))
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (onMe param1)
		(return (chinaDoor onMe: param1))
	)

	(method (doVerb)
		(if (or (IsFlag 110) (!= gChapter 3))
			(gCurRoom setScript: enterChinaShop)
		else
			(gCurRoom setScript: dukeStopsVal)
		)
		(return 1)
	)
)

(instance townHallDoor of Prop
	(properties
		heading 90
		noun 3
		sightAngle 15
		approachX 239
		approachY 100
		x 231
		y 90
		priority 85
		fixPriority 1
		view 5302
		loop 4
	)

	(method (init)
		(super init:)
		(if
			(or
				(and (== gChapter 3) (not local1))
				(and (== gChapter 5) (IsFlag 203))
			)
			(= loop 3)
		)
		(if (not (IsFlag 110))
			(= cel 4)
		else
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 98 206 67 206 52 212 45 220 44 227 47 231 55 233 70 235 91
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0 temp1 temp2)
		(= temp0 (super onMe: param1))
		(= temp1 (- (param1 x:) nsLeft))
		(= temp2 (- (param1 y:) nsTop))
		(if
			(and
				(== loop 3)
				(not (IsFlag 137))
				(or
					(and (OneOf temp1 9 10) (<= 24 temp2 34))
					(and (<= 10 temp1 18) (OneOf temp2 23 24))
					(and (OneOf temp1 18 19) (<= 24 temp2 34))
					(and (<= 10 temp1 18) (OneOf temp2 34 35))
				)
			)
			(return 0)
		)
		(if (and temp0 (param1 type:))
			(if
				(and
					(== loop 3)
					(not (IsFlag 137))
					(<= 10 temp1 18)
					(<= 24 temp2 34)
				)
				(if (IsFlag 137)
					(return 0)
				)
				(= noun 2)
				(if (not (IsFlag 137))
					(= approachX 239)
					(= approachY 100)
				else
					(= approachX (gEgo x:))
					(= approachY (gEgo y:))
				)
			else
				(= noun 3)
				(if (and (== gChapter 5) (== (gUser message:) 8))
					(= approachX 226)
					(= approachY 102)
				else
					(if (or (!= gChapter 3) (IsFlag 449))
						(= approachX 232)
						(= approachY 103)
					)
					(if (IsFlag 137)
						(= approachX 237)
						(= approachY 98)
					)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(return
			(if (and (> gChapter 3) (== noun 3) (== theVerb 8)) ; Do
				(gCurRoom setScript: openTownHallDoor 0 (== gChapter 5))
			else
				(if (and (== gChapter 5) (== noun 2))
					(gCurRoom setScript: showTownHallSign)
					(return 1)
				)
				(cond
					(
						(and
							(not (IsFlag 137))
							(or
								(and (== loop 3) (not (IsFlag 449)))
								(== noun 2)
							)
						)
						((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
						(gMessager say: 2 theVerb 7 0 self)
						(SetFlag 449)
					)
					((== gValOrRoz -3) ; Roz
						(gCurRoom newRoom: 5100)
					)
					((!= gChapter 3)
						(gCurRoom newRoom: 5100)
					)
					((IsFlag 137)
						(gCurRoom setScript: enterTownHall)
					)
					(else
						(gCurRoom setScript: knockOnTownHallDoor)
					)
				)
			)
		)
	)

	(method (cue)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
	)
)

(instance showTownHallSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: iSign self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance openTownHallDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo
						view: 8125
						loop: 1
						cel: 0
						posn: 228 100
						setPri: 88
						setCycle: CT 5 1 self
					)
				else
					(gEgo
						view: 8485
						setLoop: 1
						cel: 0
						setPri: 88
						setCycle: CT 5 1 self
					)
				)
			)
			(1
				(if register
					(gKqSound1 number: 803 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					((ScriptID 13 0) hide_mouth: 1 clientCel: -2) ; aEgoTalker
					(gMessager say: 0 0 47 0 self) ; "It's Locked"
				else
					(gKqSound1 number: 801 loop: 1 play:)
					(townHallDoor setPri: 10 setCycle: End self)
					(gEgo setCycle: End self)
				)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(if register
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(if register
					(gEgo
						normalize: 7
						posn:
							(townHallDoor approachX:)
							(townHallDoor approachY:)
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo
						normalize: 3
						posn: 222 101
						setPri: 20
						setMotion: MoveTo 177 75 self
					)
				)
			)
			(5
				(gCurRoom newRoom: 5100)
			)
		)
	)
)

(instance wagon of Feature
	(properties
		noun 6
		approachX 511
		approachY 115
		x 534
		y 112
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 9998
			approachVerbs: 9998
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 518 57 550 55 550 81 541 86 516 81 521 98
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (IsFlag 349) (== (gUser message:) 5))
			(return 0)
		)
		(if (and local15 (not (OneOf (gUser message:) 8 10)))
			(return 0)
		)
		(= temp0 (or (super onMe: param1) (snakeSalesman onMe: param1)))
		(if (param1 type:)
			(cond
				((== (gUser message:) 61)
					(= approachX 490)
					(= approachY 108)
				)
				((and (not (IsFlag 116)) (not (IsFlag 461)))
					(= approachX 506)
					(= approachY 104)
				)
				(else
					(= approachX 495)
					(= approachY 100)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if local15
			(gMessager say: noun 8 46 0) ; "Taking advantage of Suckers. Back Soon."
			(return 1)
		)
		(return
			(and
				(!= gValOrRoz -3) ; Roz
				(switch theVerb
					(8 ; Do
						(gCurRoom setScript: snakeDoVerbDo)
					)
					(61 ; Magic_Statue
						(gCurRoom setScript: giveStatue)
					)
					(5 ; Golden_Comb
						(gCurRoom setScript: snakeDoVerbComb)
					)
					(else
						(gCurRoom setScript: snakeDoVerbElse)
					)
				)
			)
		)
	)
)

(instance snakeDoVerbElse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (snakeSalesman script:)
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(1
				(if (or (IsFlag 116) (IsFlag 95))
					(gMessager say: 6 0 45 0 self) ; "No substitutions, my lady. I will take only the magic sstatuette for the were beast ssalve."
				else
					(gMessager say: 6 98 5 0 self) ; "(SNOTTY)This is not a pawn shop, madam. I deal in cash and PRECIOUSS objects."
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				(snakeSalesman setScript: keepSalesmanBusy)
				(self dispose:)
			)
		)
	)
)

(instance snakeDoVerbDo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (snakeSalesman script:)
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((or (IsFlag 116) (IsFlag 95))
						(if (or (not (IsFlag 123)) (== gChapter 5))
							(cond
								((and (not (IsFlag 95)) (not (SetFlag 416)))
									(gMessager say: 6 8 22 0 self) ; "(HOPEFULLY BUT UNSURE ABOUT THE SALESMAN)Sir, I was told of a merchant who sells an item which can get me through the Wood of the Were folk. Would that be you?"
								)
								((not (SetFlag 417))
									(gMessager say: 6 8 23 0 self) ; "(SUSPICIOUS)Sir, may I ask you why you want this magic statuette? What are its powers?"
								)
								(else
									(gMessager say: 6 8 24 0 self) ; "(SLICK AND UNPLEASANT)I am a very busy man, my lady. come back here when you have the magic sstatuette, yess?"
								)
							)
						else
							(gMessager say: 6 8 24 0 self) ; "(SLICK AND UNPLEASANT)I am a very busy man, my lady. come back here when you have the magic sstatuette, yess?"
						)
					)
					((or (not (IsFlag 123)) (== gChapter 5))
						(cond
							((not (SetFlag 418))
								(gMessager say: 6 8 25 0 self) ; "Good day, sir. I wonder if you might be able to help me?"
							)
							((not (SetFlag 419))
								(gMessager say: 6 8 26 0 self) ; "(CAUTIOUSLY)Good merchant, I really would appreciate a moment of your time."
							)
							(else
								((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
								(gMessager say: 6 8 27 0 self) ; "(THINKS TO HERSELF)I've had about as much of that fellow as I can stand for the moment."
							)
						)
					)
					(else
						((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
						(snakeSalesman setScript: keepSalesmanBusy)
						(gMessager say: 6 8 27 0 self) ; "(THINKS TO HERSELF)I've had about as much of that fellow as I can stand for the moment."
					)
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				(if (not (snakeSalesman script:))
					(snakeSalesman setScript: keepSalesmanBusy)
				)
				(self dispose:)
			)
		)
	)
)

(instance snakeDoVerbComb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (snakeSalesman script:)
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((IsFlag 116)
						(gMessager say: 6 5 22 0 self) ; "(SADLY)This comb belongs to my daughter, who was taken from me by dark magic. Have you heard anything about a beautiful girl with hair of gold?"
						(SetFlag 349)
					)
					((not (SetFlag 461))
						(SetFlag 95)
						(self setScript: haveSalesmanPoint)
					)
					((not (SetFlag 417))
						(gMessager say: 6 5 26 0 self) ; "(SUSPICIOUS)Sir, may I ask why do you want this magic statuette? What are its powers?"
					)
					(else
						(SetFlag 349)
						(gMessager say: 6 5 27 0 self) ; "(SLICK AND UNPLEASANT)I am a very bussy man, my lady. Come back when you have the magic statuette, yess?"
					)
				)
			)
			(2
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				(snakeSalesman setScript: keepSalesmanBusy)
				(self dispose:)
			)
		)
	)
)

(instance haveSalesmanPoint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 5 25 1 self) ; "(SAD, DESPERATE)Please, sir, you must help me. This comb belongs to my daughter, and she is missing. She is a beautiful girl, with sky-blue eyes and golden hair. Have you heard of her?"
			)
			(1
				(if (snakeSalesman script:)
					(keepSalesmanBusy caller: self register: 1)
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager sayRange: 6 5 25 2 4 self) ; "(SLY)Indeed I have, lady. I have just recently heard she is to be married to the Troll King in the Vulcanix Underground in a few days. It'ss too bad you can't possibly go there and ssave her."
			)
			(3
				(if (not (gEgo has: 47)) ; Magic_Statue
					(gMessager say: 6 5 25 5 self) ; "(DETERMINED)Just were can I find this magic statuette?"
				else
					(gGame handsOn:)
					(snakeSalesman setScript: keepSalesmanBusy)
					(self dispose:)
				)
			)
			(4
				(gEgo hide:)
				(= register (snakeSalesman priority:))
				(snakeSalesman
					view: 5325
					setLoop: 2 1
					cel: 0
					posn: 491 134
					setPri: 150
					setCycle: CT 8 1 self
				)
			)
			(5
				(snakeSalesman cel: 9)
				(UpdateScreenItem snakeSalesman)
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gMessager say: 6 5 25 6 self) ; "(WHISPERING IN HER EAR)I cannot be ssure, but last I heard, the Arch-Duke had it."
			)
			(7
				(snakeSalesman setCycle: Beg self)
			)
			(8
				(gEgo show:)
				(snakeSalesman setLoop: 5 cel: 7 setPri: register posn: 497 129)
				(UpdateScreenItem snakeSalesman)
				(FrameOut)
				(= cycles 3)
			)
			(9
				(gMessager sayRange: 6 5 25 7 9 self) ; "(INDIGNANT)I can't just take something from the Arch-Duke!"
			)
			(10
				(gGame handsOn:)
				(snakeSalesman setScript: keepSalesmanBusy)
				(self dispose:)
			)
		)
	)
)

(instance keepSalesmanBusy of Script
	(properties)

	(method (doit)
		(if (and seconds (or register next))
			(= seconds 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 (= state 1))
				(snakeSalesman
					view: 5325
					setLoop: 5
					cel: 7
					posn: 497 129
					setPri: 95
					setCycle: Beg self
				)
			)
			(1
				(= local14 0)
				(= seconds (Random 2 5))
			)
			(2
				(= local14 1)
				(if (and (not next) (not register))
					(if (Random 0 1)
						(self changeState: 8)
					else
						(self changeState: 4)
					)
				else
					(snakeSalesman
						setLoop: 5
						setPri: 95
						posn: 497 129
						setCycle: End self
					)
				)
			)
			(3
				(= register 0)
				(if next
					(next caller: caller)
					(= caller 0)
				)
				(self dispose:)
			)
			(4
				(snakeSalesman
					setLoop: 4
					cel: 0
					setPri: 92
					posn: 529 95
					setCycle: CT 6 1 self
				)
			)
			(5
				(if (and (not register) (Random 0 1))
					(-- state)
					(snakeSalesman setCycle: ROsc 1 6 14 self)
				else
					(= cycles 1)
				)
			)
			(6
				(snakeSalesman setCycle: CT 18 1 self)
			)
			(7
				(= state 0)
				(snakeSalesman
					setLoop: 5
					cel: 3
					setPri: 95
					posn: 497 129
					setCycle: End self
				)
			)
			(8
				(snakeSalesman
					setLoop: 3
					cel: 0
					setPri: 92
					posn: 496 129
					setCycle: End self
				)
			)
			(9
				(= seconds 3)
			)
			(10
				(snakeSalesman setCycle: Beg self)
			)
			(11
				(= state 0)
				(snakeSalesman
					setLoop: 5
					setPri: 95
					posn: 497 129
					cel: 3
					setCycle: End self
				)
			)
		)
	)
)

(instance pool of Feature
	(properties
		sightAngle 180
		approachX 471
		approachY 103
		x 466
		y 108
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 52 ; Do, Exit, Crook
			approachVerbs: 8 52 ; Do, Crook
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 445 88 436 107 349 109 330 103 324 87 326 80 355 78 428 81
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (param1 type:))
			(switch (gUser message:)
				(8
					(= approachX 442)
					(= approachY 114)
					(= x 440)
				)
				(else
					(= approachX 471)
					(= approachY 103)
					(= x 466)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: tryToGetMoon)
			)
			(52 ; Crook
				(gCurRoom setScript: getTheMoon)
			)
		)
	)
)

(instance birdCage of Feature
	(properties
		noun 7
		approachX 556
		approachY 110
		x 560
		y 113
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 565 105 561 97 561 88 562 82 571 70 574 70 584 80 586 91 585 98 582 105 574 106
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (IsFlag 117) (IsFlag 138))
			(= approachX 556)
			(= approachY 113)
		)
		(return temp0)
	)

	(method (doVerb)
		(cond
			((not (IsFlag 138))
				(gCurRoom setScript: uncoverCage)
			)
			((not (IsFlag 139))
				(gCurRoom setScript: openCageDoor)
				(SetFlag 139)
			)
			((not (gEgo has: 42)) ; China_Bird
				(cond
					((and (not (IsFlag 109)) (IsFlag 117))
						(gCurRoom setScript: getTheChinaBird)
					)
					((not (IsFlag 109))
						(if (IsFlag 119)
							(gCurRoom setScript: takeBird)
						else
							(gCurRoom setScript: tryGetBird)
						)
					)
				)
				(ClearFlag 139)
			)
		)
		(return 1)
	)
)

(instance fauxSign of Feature
	(properties
		noun 8
		approachX 413
		approachY 75
		x 413
		y 70
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 398 32 399 31 412 30 425 36 425 38 398 40
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== gValOrRoz -3) ; Roz
			(gMessager say: noun theVerb 37)
		else
			(gMessager say: noun theVerb 0)
		)
	)
)

(instance fauxDoor of Prop
	(properties
		noun 12
		approachX 435
		approachY 69
		x 439
		y 69
		z 3
		priority 66
		fixPriority 1
		view 5302
		loop 2
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 276))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 438 65 446 67 443 30 431 33
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (param1 type:) (== loop 5))
			(= approachX (- x 3))
			(= approachY y)
		)
		(return temp0)
	)

	(method (doVerb)
		(cond
			((== gValOrRoz -4) ; Val
				(cond
					((IsFlag 203)
						(gCurRoom setScript: (ScriptID 5301 4)) ; crackFauxDoor
					)
					((== gChapter 5)
						(gCurRoom setScript: enterFauxShop)
					)
					((and (IsFlag 120) (IsFlag 121))
						(gMessager say: 8 8 34 0) ; "(THINKS TO HERSELF)Inspecting a shipment of baloney. Will re-open later."
					)
					((not (IsFlag 123))
						(gMessager say: 8 8 33 0) ; ""'Busy uncrating a pack of lies. Back soon.'"."
					)
					((IsFlag 122)
						(gCurRoom setScript: enterFauxShop)
					)
					(else
						(gCurRoom setScript: walkThroughDoor)
					)
				)
			)
			((IsFlag 149)
				(gCurRoom setScript: enterFauxShop)
			)
			(else
				(gCurRoom setScript: walkThroughDoor)
			)
		)
	)
)

(instance readFauxDoorSign of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gMessager say: 8 8 register 0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fauxDoorExit of ExitFeature
	(properties
		noun 12
		approachX 435
		approachY 69
		x 439
		y 66
		exitDir 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		(fauxDoor setHotspot: 0)
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (fauxDoor onMe: param1))
				(param1 type:)
				(IsFlag 203)
			)
			(= approachX 424)
			(= approachY 72)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(fauxDoor doVerb: theVerb)
	)
)

(instance enterFauxShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= gValOrRoz -3) ; Roz
					(gEgo view: 8121 loop: 0 cel: 0 setCycle: CT 2 1 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gKqSound1 number: 801 loop: 1 play:)
				(fauxDoor setCycle: End self)
				(if (!= gValOrRoz -3) ; Roz
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2 0)
			(3
				(gEgo normalize: 0 setMotion: MoveTo 450 69 self)
			)
			(4
				(gCurRoom newRoom: 5000)
			)
		)
	)
)

(instance snakeSalesman of Prop
	(properties
		x 531
		y 90
		priority 90
		fixPriority 1
		view 5323
		loop 1
	)
)

(instance crook of Prop
	(properties)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; Mask
				(if (localproc_0 195)
					(gCurRoom setScript: putOnMask)
				else
					(return 0)
				)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)
)

(instance partySound1 of Sound
	(properties
		flags 4
		number 5100
		loop -1
	)
)

(instance partySound2 of Sound
	(properties
		flags 4
		number 5102
		loop -1
	)
)

(instance archDukeSound of Sound
	(properties
		flags 4
		number 5301
		loop -1
	)
)

(instance chickenSound of Sound
	(properties
		flags 4
		number 5310
		loop -1
	)
)

(instance gateGuard of Actor
	(properties
		noun 10
		approachX 61
		approachY 113
		x 29
		y 113
		view 5328
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (cue)
		(self view: 5328 setLoop: 0 cel: 0 setCycle: 0)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (doVerb)
		(guardTalker client: self)
		(cond
			((not (SetFlag 542))
				(gMessager say: noun 8 39 0) ; "Good day, sir. Kindly let me pass."
			)
			((not (SetFlag 543))
				(gMessager say: noun 8 38 0) ; "This is ridiculous. Let me out, guard."
			)
			(else
				(gMessager say: noun 8 40 0) ; "Go away, you little convict!"
			)
		)
	)
)

(instance feather of View
	(properties
		approachX 280
		approachY 93
		x 295
		y 62
		priority 93
		fixPriority 1
		view 5331
		loop 5
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 41)) ; Feather
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
			(&= signal $efff)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: getFeather)
	)
)

(instance getFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo x:))
				(= local9 (gEgo y:))
				(= cycles 3)
			)
			(1
				(gEgo view: 8075 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(feather dispose:)
				(gEgo get: 41 setCycle: Beg self) ; Feather
			)
			(3
				(gEgo
					normalize: 6
					posn: local8 local9
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wagonSign of View
	(properties
		x 520
		y 53
		priority 95
		fixPriority 1
		view 5300
		loop 7
	)

	(method (init)
		(super init: &rest)
		(= local15 1)
	)
)

(instance cageDoor of Prop
	(properties
		x 577
		y 94
		priority 98
		fixPriority 1
		view 5300
		loop 3
	)
)

(instance glint1 of Prop
	(properties
		x 365
		y 92
		priority 109
		fixPriority 1
		view 5300
		loop 4
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(self setScript: glintScript)
	)
)

(instance glint2 of Prop
	(properties
		x 414
		y 94
		priority 109
		fixPriority 1
		view 5300
		loop 5
		cycleSpeed 10
	)
)

(instance glint3 of Prop
	(properties
		x 394
		y 93
		priority 109
		fixPriority 1
		view 5300
		loop 6
		cycleSpeed 14
	)
)

(instance glintScript of Script
	(properties)

	(method (init)
		(glint2 init: hide:)
		(glint3 init: hide:)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glint1 show: cel: 0 setCycle: End self)
			)
			(1
				(glint1 hide:)
				(glint2 show: cel: 0 setCycle: End self)
			)
			(2
				(glint2 hide:)
				(= state -1)
				(glint3 show: cel: 0 setCycle: End self)
			)
		)
	)
)

(instance archTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client archDuke)
		(super init: &rest)
	)
)

(instance bull of Prop
	(properties
		x 108
		y 78
		priority 92
		fixPriority 1
		view 5337
		loop 1
	)
)

(instance bullTalker of KQTalker
	(properties)

	(method (init)
		(= client bull)
		(super init: &rest)
	)
)

(instance fauxOwnerTalker of KQTalker
	(properties)

	(method (init)
		(= client fauxDoor)
		(= mouth_y (* (client z:) -1))
		(super init: &rest)
	)
)

(instance mockingBirdTalker of KQTalker
	(properties)

	(method (init)
		(= client mockingBird)
		(= loop 2)
		(= mouth_y (* (client z:) -1))
		(super init: &rest)
	)
)

(instance guardTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(if (not client)
			(= client badger)
		)
		(super init: &rest)
	)
)

(instance snakeTalker of KQTalker
	(properties)

	(method (init)
		(if (!= client gEgo)
			(= client snakeSalesman)
		)
		(super init: &rest)
	)
)

(instance chickenTalker of KQTalker
	(properties
		hide_mouth 1
	)

	(method (init)
		(= client chickenPetite)
		(super init: &rest)
	)
)

(instance chinaBirdTalker of KQTalker
	(properties)

	(method (init)
		(= client chinaBird)
		(super init: &rest)
	)
)

(instance roomFeatureInitCode of Code
	(properties)

	(method (doit param1)
		(if
			(and
				(not (param1 isKindOf: KQInventory))
				(param1 respondsTo: #signal)
			)
			(param1 sightAngle: 10 signal: (| (param1 signal:) $7001))
		)
	)
)

(instance iSign of Inset
	(properties
		picture 5303
		priority 200
	)

	(method (init)
		(= x (Abs ((gCurRoom plane:) left:)))
		(super init: &rest)
		(proc11_6)
	)
)

(instance tryToGetMoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8075 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 12 8 18 2 self 1100) ; "Blast. I can't reach it."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 8295 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(4
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(5
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

