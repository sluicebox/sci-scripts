;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4550)
(include sci.sh)
(use Main)
(use ExitButton)
(use aEgoTalker)
(use skipCartoon)
(use eastFeat)
(use OogaBooga)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4550 0
	plantTalker1 1
	plantTalker2 2
	plantTalker3 3
)

(local
	local0
	local1
	local2
)

(instance rm4550 of KQRoom
	(properties
		picture 4551
		screen_mid 4552
	)

	(method (init)
		(super init:)
		(= eastSide 570)
		(SetFlag 192)
		((ScriptID 7001 1) ; maliciaTalker
			hide_mouth: 1
			view: 39061
			loop: -1
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
			client: malicia
		)
		(gKqMusic1 number: 4550 setLoop: -1 play:)
		(gEgo setScaler: Scaler 100 50 110 62)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 57 65 39 70 36 78 75 92 106 115 115 123 192 121 263 100 319 97 357 100 373 103 390 115 410 118 455 136 574 136 638 123 639 68 634 68 634 94 587 119 552 119 511 119 531 93 515 93 472 115 437 114 418 103 422 97 363 84 318 88 240 97 185 114 141 115 134 100 110 109 100 99 100 83 54 81 47 71 64 65
					yourself:
				)
		)
		(Load rsMESSAGE 4550)
		(cond
			((or (and (not (IsFlag 544)) (== gChapter 5)) (Random 0 1))
				(if (IsFlag 160)
					(barkTimer setReal: barkTimer 45)
				)
				(SetFlag 162)
			)
			((!= gPrevRoomNum 4650)
				(ClearFlag 162)
			)
		)
		(switch gPrevRoomNum
			(3050
				(self setRect: -318 0 321 136)
			)
			(6200
				(self setRect: 0 0 640 136)
			)
			(4250
				(self setRect: 0 0 640 136)
			)
			(4650
				(self setRect: -318 0 321 136)
			)
			(4450
				(self setRect: -318 0 321 136)
			)
			(3150
				(self setRect: -318 0 321 136)
			)
			(else
				(if (== gChapter 4)
					(self setRect: 0 0 640 136)
				else
					(self setRect: -318 0 321 136)
				)
			)
		)
		(cond
			((== gPrevRoomNum 4450)
				(self setScript: deathScript)
			)
			((== gPrevRoomNum 6200)
				(self setScript: sFall)
			)
			((== gPrevRoomNum 4250)
				(gEgo posn: 82 55 normalize: init:)
				(self setScript: openGate)
			)
			((and (== gChapter 5) (not (IsFlag 548)))
				(self setScript: chap5Open)
			)
		)
		(if (and (== gChapter 5) (not (gEgo has: 71))) ; Crystal_Shaft
			(lamp init:)
		)
		(if (not script)
			(switch gPrevRoomNum
				(3050
					(gEgo
						posn: 638 124
						normalize:
						init:
						setMotion: PolyPath 600 124
					)
					(gGame handsOn:)
				)
				(4650
					(gEgo posn: 623 101 heading: 180)
					(gEgo normalize: init: setMotion: PolyPath 600 124)
					(gGame handsOn:)
				)
				(3150
					(gEgo
						posn: 623 124
						heading: 270
						normalize:
						init:
						setMotion: PolyPath 600 124
					)
					(gGame handsOn:)
				)
				(else
					(if (== gChapter 4)
						(gEgo posn: 82 55 normalize: init:)
						(self setScript: openGate)
					else
						(gEgo
							posn: 638 124
							normalize:
							init:
							setMotion: PolyPath 600 124
						)
						(gargoyleTimer setReal: gargoyleTimer 30)
						(gGame handsOn:)
					)
				)
			)
		)
		(gargoyle init:)
		(plants init:)
		(gateProp init: setPri: 61)
		(if (not (IsFlag 182))
			(flower init:)
		)
		(gate init:)
		(triggerPanel init:)
		(frontDoor init:)
		(behindHouse init:)
		(wereForest init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gChapter 4)
				(not (IsFlag 160))
				(triggerPanel onMe: KQEgo)
			)
			(SetFlag 160)
			(self setScript: talkToKing)
		)
	)

	(method (dispose)
		(ClearFlag 192)
		(sfx stop:)
		(gargSound stop:)
		(gKqSound1 stop:)
		(bark stop:)
		(gargoyleTimer client: 0 delete: dispose:)
		(eatTimer client: 0 delete: dispose:)
		(barkTimer client: 0 delete: dispose:)
		((ScriptID 7001 1) ; maliciaTalker
			client: 0
			view: -1
			loop: -1
			hide_mouth: 0
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
		)
		(super dispose:)
	)
)

(instance sFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gKqSound1 number: 852 loop: 1 play:)
				(gEgo
					posn: 297 91
					view: 3261
					loop: 1
					cel: 0
					init:
					setCycle: CT 3 1 self
				)
			)
			(2
				(gKqSound1 number: 865 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo heading: 0 normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance zapMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Prop new:))
				(gKqSound1 number: 4656 setLoop: 1 play:)
				(register
					view: 4572
					loop: 2
					cel: 0
					x: 416
					y: 69
					init:
					setPri: 126
					setCycle: CT 3 1 self
				)
			)
			(1
				(gKqSound1 number: 4657 setLoop: 1 play:)
				(swampMonster dispose:)
				(register setCycle: End self)
			)
			(2
				(register dispose:)
				(= ticks 30)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance laugh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 2 8 27 1 2 self) ; "(A LITTLE CATTY)Well, I certainly hope you have lava-proof leaves!"
			)
			(1
				(plants view: 4576 loop: 0 cel: 0 setCycle: Fwd)
				(gMessager say: 2 8 27 3 self) ; "(LAUGH)"
			)
			(2
				(plants view: 4556 loop: 0 cel: 0 setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance halo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 8 8 1 self) ; "(ULTRA SWEET)C'mon over here, figgy pudding. I won't bite!"
			)
			(1
				(plants view: 4556 loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(gMessager sayRange: 2 8 8 2 3 self) ; "Not us!"
			)
			(3
				(plants loop: 5 cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(plants setCycle: End self)
			)
			(6
				(plants view: 4556 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtComb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 2 5 23 1 2 self) ; "(SADLY)This belongs to my daughter, a pretty young girl with blonde hair and blue eyes. Have you seen her?"
			)
			(1
				(plants view: 4574 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 2 5 23 3 self) ; "Mmmmmmmm!"
			)
			(3
				(plants setCycle: Beg self)
			)
			(4
				(plants view: 4556 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance smackHeads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
			)
			(1
				(plants view: 4574 loop: 0 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(plants setCycle: End self)
				(gKqSound1 number: 4556 setLoop: 1 play:)
			)
			(3
				(= ticks 45)
			)
			(4
				(plants view: 4556 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bonkHeads of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
			)
			(1
				(plants view: 4574 loop: 1 cel: 0 setCycle: CT 8 1 self)
			)
			(2
				(plants setCycle: End self)
				(gKqSound1 number: 4557 setLoop: 1 play:)
			)
			(3
				(= ticks 45)
			)
			(4
				(plants view: 4556 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chap5Open of Script
	(properties)

	(method (dispose)
		(ClearFlag 338)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(self cue:)
			(event claimed: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 338)
				(gGame handsOff:)
				(gEgo view: 4570 loop: 2 cel: 0 x: 575 y: 126)
				(= cycles 1)
			)
			(1
				(gEgo init: setCycle: CT 18 1 self)
				(gWalkHandler addToFront: self)
				(gKqSound1 number: 4651 setLoop: 1 play:)
			)
			(2
				(gKqSound1 number: 6556 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 7)
				(gEgo setHeading: 270 self)
			)
			(4
				(gMessager say: 0 0 30 0 self) ; "(COMPLETELY OUT OF BREATH)Don't...think...I've ever run so...fast...in my life!"
			)
			(5
				(gKqSound1 number: 4653 setLoop: 1 play:)
				(swampMonster
					view: 4570
					loop: 0
					cel: 0
					x: 417
					y: 108
					init:
					setCycle: End self
				)
			)
			(6
				(if (IsFlag 104)
					(gGame handsOn:)
					(gUser canControl: 0)
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(7
				(gGame handsOff:)
				(swampMonster loop: 1 cel: 0 x: 406 y: 113 setCycle: CT 7 1)
				(= seconds 0)
				(if (IsFlag 104)
					(SetFlag 548)
					(= register (Prop new:))
					(register
						view: 4572
						loop: 0
						cel: 0
						x: 507
						y: 127
						init:
						setCycle: End self
					)
					(gKqSound1 number: 4655 setLoop: 1 play:)
				else
					(swampMonster
						loop: 1
						cel: 0
						x: 406
						y: 113
						setCycle: End self
					)
				)
			)
			(8
				(if register
					(register loop: 1 cel: 0 x: 508 setCycle: End self)
				else
					(swampMonster
						view: 4571
						loop: 0
						cel: 0
						x: 549
						y: 132
						setCycle: CT 6 1 self
					)
				)
			)
			(9
				(if register
					(register setCycle: Beg self)
					(self setScript: zapMonster self)
				else
					(gEgo hide:)
					(gKqSound1 number: 4654 setLoop: 1 play:)
					(swampMonster cel: 7 setCycle: End self)
					(UpdateScreenItem swampMonster)
				)
			)
			(10
				(if (not register)
					(EgoDead 49 self 1)
				)
			)
			(11
				(if register
					(register loop: 0)
					(register
						cel: (register lastCel:)
						x: 507
						y: 127
						setCycle: Beg self
					)
					(gKqSound1 number: 4658 setLoop: 1 play:)
				else
					(swampMonster dispose:)
					(SetFlag 567)
					(gCurRoom newRoom: 3150)
				)
			)
			(12
				(if register
					(register dispose:)
					(gMessager say: 0 0 31 0 self) ; "Noble Attis, He was true to his word."
				else
					(self cue:)
				)
			)
			(13
				(gargoyle setHotspot: 8 10) ; Do, Exit
				(frontDoor setHotspot: 8 10) ; Do, Exit
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance escapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(monsterScript seconds: 0)
				(gKqSound1 number: 809 setLoop: 1 play:)
				(gateProp setCycle: End self)
			)
			(1
				(gKqSound1 stop:)
				(gEgo setMotion: MoveTo 73 60 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(swampMonster view: 4555 loop: 0 cel: 0 setCycle: End self)
				(gKqSound1 number: 3159 setLoop: 1 play:)
				(= cycles 20)
			)
			(4
				(Load 140 838) ; WAVE
				(gKqSound1 number: 809 setLoop: 1 play:)
				(gateProp setCycle: Beg self)
			)
			(5
				(gKqSound1 number: 838 setLoop: 1 play:)
			)
			(6
				(swampMonster view: 45555 loop: 0 cel: 0 setCycle: End self)
				(gKqSound1 number: 46570 setLoop: 1 play:)
			)
			(7
				(swampMonster view: 45555 loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(swampMonster hide:)
				(FrameOut)
				(gCurRoom newRoom: 4250)
			)
		)
	)
)

(instance monsterScript of Script
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(= register 1)
			(self cue:)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gEgo enableHotspot:)
		(ClearFlag 338)
		(gWalkHandler delete: self)
		(if (gEgo has: 53) ; Magic_Wand
			((gInventory at: 53) addRespondVerb: 74) ; Magic_Wand, Scarab
			((gInventory at: 55) addRespondVerb: 69) ; Scarab, Magic_Wand
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo disableHotspot:)
				(if (gEgo has: 53) ; Magic_Wand
					((gInventory at: 53) deleteHotVerb: 74) ; Magic_Wand, Scarab
					((gInventory at: 55) deleteHotVerb: 69) ; Scarab, Magic_Wand
				)
				(plants setHotspot: 0)
				(flower setHotspot: 0)
				(gWalkHandler addToFront: self)
				(gKqSound1 number: 4653 setLoop: 1 play:)
				(swampMonster
					view: 4551
					loop: 0
					cel: 0
					x: 98
					y: 112
					init:
					setCycle: End self
				)
				(gEgo setHeading: 150)
				(= ticks 45)
			)
			(1
				(sfx number: 46540 setLoop: 1 play:)
			)
			(2
				(gKqSound1 fade: 0 4 2 1)
				(gGame handsOn:)
				(= seconds 10)
			)
			(3
				(gGame handsOff:)
				(= seconds 0)
				(swampMonster view: 4555 loop: 0 cel: 0 setCycle: CT 4 1 self)
				(gKqSound1 number: 4654 setLoop: 1 play:)
			)
			(4
				(swampMonster setCycle: End self)
				(if (IsFlag 151)
					(gEgo view: 4252 loop: 1 cel: 0 setCycle: End)
				else
					(gEgo view: 9025 loop: 1 cel: 0 setCycle: End)
				)
				(gKqSound1 number: 4564 setLoop: 1 play:)
			)
			(5
				(plants view: 4555 loop: 1 cel: 0 x: 156 y: 83 setCycle: Fwd)
				(gKqSound1 number: 4563 setLoop: 1 play: self)
			)
			(6
				(EgoDead 30 self)
			)
			(7
				(ClearFlag 5)
				(plants view: 4556 loop: 0 cel: 0 x: 156 y: 83 setCycle: 0)
				(gEgo normalize: posn: 82 55)
				(swampMonster dispose:)
				(= cycles 1)
			)
			(8
				(client setScript: openGate)
			)
		)
	)
)

(instance talkToKing of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(gGame handsOff: 1)
					(gMessager say: 0 0 11 1 self) ; "(AS A SCARAB)STOP! We must talk, Princess."
					(gEgo setMotion: 0)
				)
				(1
					(gEgo view: 4563 loop: 0 cel: 0 setCycle: End)
					(gMessager sayRange: 0 0 11 2 4 self) ; "(URGENTLY, AS A SCARAB)Before us is the home of Malicia. We must be cautious, or we will never reach the Vulcanix Underground."
				)
				(2
					(gEgo setCycle: Beg self)
				)
				(3
					(gEgo normalize: 0)
					(if (IsFlag 162)
						(barkTimer setReal: barkTimer (Random 60 120))
					)
					(gargoyleTimer setReal: gargoyleTimer 30)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(if (IsFlag 162)
				(barkTimer setReal: barkTimer (Random 60 120))
			)
			(gargoyleTimer setReal: gargoyleTimer 30)
			(gEgo normalize:)
			(gGame handsOn:)
			(ClearFlag 539)
			(self dispose:)
		)
	)
)

(instance deathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 516 y: 96 init: normalize: 2)
				(gKqSound1 number: 802 setLoop: 1 play: self)
			)
			(1
				(EgoDead 31 self)
			)
			(2
				(ClearFlag 5)
				(gGame handsOn:)
				(gCurRoom newRoom: 4450)
			)
		)
	)
)

(instance maliciaAppears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< 280 (gEgo x:) 320)
					(malicia x: (- (gEgo x:) 45))
				else
					(malicia
						x:
							(if (> (gEgo x:) 610)
								590
							else
								(Min 620 (+ (gEgo x:) 45))
							)
					)
				)
				(malicia view: 4565 cel: 0 y: 122 init:)
				(gEgo setMotion: 0)
				(proc11_3 malicia gEgo)
				(proc11_3 gEgo malicia)
				(malicia setCycle: End self)
				(gKqSound1 number: 816 play:)
			)
			(1
				(malicia view: 4566 cel: 0 setCycle: End self)
			)
			(2
				(gKqSound1 number: 4656 setLoop: 1 play: 64 0)
				(if (== gValOrRoz -3) ; Roz
					(if (IsFlag 151)
						(gEgo
							view: 4568
							loop:
								(if (== (gEgo loop:) (gEgo lastLoop:))
									(gEgo cel:)
								else
									(gEgo loop:)
								)
							cel: 0
							setCycle: End self
						)
					else
						(gEgo
							view: 4567
							loop:
								(if (== (gEgo loop:) (gEgo lastLoop:))
									(gEgo cel:)
								else
									(gEgo loop:)
								)
							cel: 0
							setCycle: End self
						)
					)
				else
					(gEgo
						view: 4580
						loop: (if (< (gEgo x:) (malicia x:)) 2 else 1)
						cel: 0
						setCycle: End self
					)
				)
				(sfx
					number: (if (== gValOrRoz -3) 2478 else 3160) ; Roz
					setLoop: 1
					play: 64 0
				)
				(= ticks 45)
			)
			(3)
			(4
				(gEgo hide:)
				(malicia setCycle: Beg self)
			)
			(5
				(malicia view: 9061 setCycle: StopWalk -1)
				((ScriptID 7001 1) loop: (malicia cel:) hide_mouth: 0) ; maliciaTalker
				(UpdateScreenItem malicia)
				(if (== gValOrRoz -3) ; Roz
					(gMessager say: 0 0 12 0 self) ; "(NASTY, GLEEFUL)Nice try, sweetie."
				else
					(self cue:)
				)
			)
			(6
				((ScriptID 7001 1) loop: -1 hide_mouth: 1) ; maliciaTalker
				(cond
					((== gValOrRoz -3) ; Roz
						(EgoDead 54 self)
					)
					((< (malicia x:) (- (gargoyle x:) 20))
						(+= state 3)
						(self cue:)
					)
					(else
						(malicia
							view: 9061
							loop: (malicia cel:)
							cel: 0
							setCycle: StopWalk -1
							setLooper: Grooper
							setMotion: PolyPath 492 116 self
						)
					)
				)
			)
			(7
				(if (== gValOrRoz -3) ; Roz
					(malicia dispose:)
					(gEgo normalize: show:)
					(ClearFlag 5)
					(gargoyleTimer setReal: gargoyleTimer 30)
					(gGame handsOn:)
					(self dispose:)
				else
					(malicia setHeading: 315 self)
				)
			)
			(8
				(malicia
					view: 4573
					loop: 0
					cel: 0
					x: (+ (malicia x:) 5)
					setCycle: End self
				)
				(gMessager say: 0 0 16 0 self) ; "(TO GARGOYLE)Good boy!"
			)
			(9)
			(10
				(EgoDead 7 self)
			)
			(11
				(malicia dispose:)
				(gEgo normalize: show:)
				(ClearFlag 5)
				(gargoyleTimer setReal: gargoyleTimer 30)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eatenByPlants of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gValOrRoz -3) ; Roz
					(if (== (gEgo view:) 4560)
						(if (gEgo cycler:)
							(-- state)
							(= cycles 1)
							(return)
						else
							(gEgo setScript: 0)
							(plants
								view: 4560
								loop: 0
								cel: 0
								x: 108
								y: 102
								setCycle: End self
							)
						)
					else
						(plants
							view: 4561
							loop: 0
							x: 153
							y: 83
							setCycle: End self
						)
					)
				else
					(plants view: 4578 loop: 0 x: 156 y: 84 setCycle: End self)
				)
				(gGame handsOff:)
				(gKqSound1 number: 4569 setLoop: 1 play: self)
				(gEgo setMotion: 0 hide:)
			)
			(1
				(gKqSound1 number: 4570 setLoop: 1 play:)
				(sfx number: 4561 setLoop: 1 play:)
			)
			(2
				(plants
					view: 4574
					loop: 3
					cel: 0
					x: 156
					y: 83
					setCycle: End self
				)
				(sfx number: 4573 setLoop: 1 play:)
			)
			(3
				(plants view: 4556 loop: 0 cel: 0 x: 156 y: 83)
				(= ticks 10)
			)
			(4
				(if (== gValOrRoz -3) ; Roz
					((= register (View new:))
						view: 4561
						loop: 1
						cel: 0
						x: 90
						y: 102
						init:
					)
					(gKqSound1 number: 4571 setLoop: 1 play: self)
				else
					(self cue:)
				)
			)
			(5
				(sfx stop:)
				(cond
					(local0
						(if (== gValOrRoz -3) ; Roz
							(gMessager say: 3 8 10 0 self) ; "Mmmmm! Must've been a princess!"
						else
							(gMessager say: 3 8 29 0 self) ; "Yum!"
						)
					)
					((== gValOrRoz -3) ; Roz
						(gMessager say: 3 8 10 0 self) ; "Mmmmm! Must've been a princess!"
					)
					(else
						(gMessager say: 0 0 28 0 self) ; "Mmmmmmm!"
					)
				)
			)
			(6
				(gKqSound1 stop:)
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 13 self)
				else
					(EgoDead 55 self)
				)
			)
			(7
				(if register
					(register dispose:)
					(= register 0)
				)
				(gEgo normalize: posn: 131 117)
				(ClearFlag 5)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance keyHoleZap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 8 13 0 self) ; "(NASTY)Peek-a-boo! I see you...PRINCESS!"
			)
			(1
				(gEgo
					view: (if (IsFlag 151) 4568 else 4567)
					loop: 3
					cel: 0
					setCycle: End self
				)
				(sfx number: 2478 setLoop: 1 play: 64 0)
				(gKqSound1 number: 4656 setLoop: 1 play: 64 self)
			)
			(2)
			(3
				(EgoDead 56 self)
			)
			(4
				(ClearFlag 5)
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance maliciaZap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(malicia
					view: 4565
					loop: 6
					cel: 0
					x: 490
					y: 130
					init:
					setCycle: End self
				)
				(gKqSound1 number: 4655 setLoop: 1 play:)
			)
			(1)
			(2
				(malicia view: 4566 loop: 6 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 3 cel: 0 setCycle: End self)
				(sfx number: 3160 setVol: 64 setLoop: 1 play: 64 0)
				(gKqSound1 number: 4656 setLoop: 1 play: 64 0)
			)
			(4
				(gEgo hide:)
				(malicia setCycle: Beg self)
			)
			(5
				(malicia view: 9061 heading: 0 setCycle: StopWalk -1)
				((ScriptID 7001 1) loop: (malicia cel:) hide_mouth: 0) ; maliciaTalker
				(sfx setVol: 127)
				(= cycles 5)
			)
			(6
				(gMessager say: 4 8 15 0 self) ; "(SATISFIED)Oh, that was SUCH fun!"
			)
			(7
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
				(EgoDead 7 self)
			)
			(8
				(ClearFlag 5)
				(malicia dispose:)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getFlower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo y: 100 x: 134)
				(= local0 1)
				(if (== gValOrRoz -3) ; Roz
					(gEgo view: 4560 loop: 3 cel: 0 setCycle: End self)
				else
					(self dispose:)
				)
			)
			(1
				(= cycles 10)
			)
			(2
				(gEgo get: 60) ; Fragrant_Flower
				(SetFlag 182)
				(flower dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					y: 101
					normalize:
					setMotion: PolyPath (gEgo x:) 120 self
				)
			)
			(4
				(if (plants cycler:)
					(self setScript: stopPlants self)
				else
					(self cue:)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gateProp setCycle: End self)
				(gKqSound1 number: 809 setLoop: 1 play:)
			)
			(2
				(gKqSound1 stop:)
				(if register
					(gEgo setMotion: MoveTo 77 55 self)
				else
					(gEgo setMotion: MoveTo 52 70 self)
				)
			)
			(3
				(gKqSound1 number: 809 setLoop: 1 play:)
				(Load 140 838) ; WAVE
				(gateProp setCycle: Beg self)
			)
			(4
				(gKqSound1 number: 838 setLoop: 1 play: self)
			)
			(5
				(cond
					(register
						(self dispose:)
						(gCurRoom newRoom: 4250)
					)
					((and (== gChapter 4) (not (IsFlag 159)))
						(client setScript: monsterScript)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance howl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gargoyle distanceTo: gEgo) 150)
					(gargoyleTimer setReal: gargoyleTimer 30)
					(self dispose:)
					(return)
				)
				(SetFlag 338)
				(if local2
					(proc11_3 gEgo gargoyle)
					(= register 1)
					(gGame handsOff:)
				)
				(gargoyle setCycle: End self)
			)
			(1
				(if local2
					(gEgo
						view: (if (== gValOrRoz -3) 4552 else 8345) ; Roz
						loop: 0
						cel: 0
						setCycle: End
					)
					(gKqSound1 number: 4402 setLoop: 1 play:)
					(self cue:)
				else
					(gargoyle loop: 1 cel: 0 setCycle: Fwd)
					(gargSound number: 4006 setLoop: -1 play:)
					(= seconds 10)
				)
			)
			(2
				(ClearFlag 338)
				(gargSound stop:)
				(if
					(or
						(and local1 (> (gargoyle distanceTo: gEgo) 75))
						(and (not register) (not (gUser canControl:)))
						(gCurRoom script:)
						(gEgo script:)
					)
					(+= state 3)
					(self cue:)
				else
					(gargoyle loop: 2 cel: 0 setCycle: End self)
				)
				(= local1 0)
			)
			(3
				(if (not register)
					(gGame handsOff:)
					(gEgo setMotion: 0)
				)
				(= local1 0)
				(gargSound number: 4553 setLoop: 1 play: self)
			)
			(4
				(if local2
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(5
				(if local2
					(gEgo normalize:)
				)
				(= local1 0)
				(= local2 0)
				(if (and (not (gTalkers size:)) (not (gCurRoom script:)))
					(self setScript: maliciaAppears)
				)
				(gargoyle setCycle: Beg self)
			)
			(6
				(gargoyle loop: 0)
				(= local1 0)
				(gargoyle cel: (gargoyle lastCel:) setCycle: Beg self)
			)
			(7
				(= local1 0)
				(if script
					(client script: script)
					(script client: client)
					(= script 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance knockOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(gEgo
						view: 4563
						loop: (if (IsFlag 151) 2 else 1)
						cel: 0
						setCycle: End self
					)
				else
					(gEgo view: 4573 loop: 1 cel: 0 setCycle: End)
				)
				(= cycles 10)
			)
			(1
				(gKqSound1 number: 808 setLoop: 1 play: self)
			)
			(2
				(gKqSound1 number: 808 setLoop: 1 play: self)
			)
			(3
				(if (IsFlag 162)
					(if (== gValOrRoz -3) ; Roz
						(client setScript: keyHoleZap)
					else
						(client setScript: maliciaZap)
					)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(gEgo normalize: 6)
				(if (not local1)
					(= local1 1)
					(if (not (gargoyle script:))
						(gargoyleTimer setReal: gargoyleTimer 1)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sprayPlants of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 4557 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gKqSound1 number: 4565 setLoop: 1 play: self)
				((= register (Prop new:))
					view: 4553
					loop: 1
					cel: 0
					cycleSpeed: 0
					x: 113
					y: 60
					setPri: 105
					init:
					setCycle: End self
				)
			)
			(3)
			(4
				(register dispose:)
				(gEgo setCycle: Beg)
				(if (plants cycler:)
					(self setScript: stopPlants self)
				else
					(self cue:)
				)
			)
			(5
				(plants view: 4557 loop: 2 cel: 0 setCycle: End self)
				(gKqSound1 number: 4568 setLoop: 1 play:)
			)
			(6
				(plants loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(plants view: 4556 loop: 0 cel: 0)
				(gEgo normalize:)
				(gMessager say: 2 68 0 0 self) ; "That wasn't very nice, sugar plum. Do we look like swamp sludge to you? HMMPH!"
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance monsterDissolve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKqSound1 number: 4566 setLoop: 1 play:)
				(swampMonster
					view: 4554
					loop: 1
					cel: 0
					x: 151
					y: 122
					setCycle: End self
				)
			)
			(1
				(swampMonster loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(plants setHotspot: 8 10) ; Do, Exit
				(flower setHotspot: 8 10) ; Do, Exit
				(if (!= client sprayMonster)
					(gGame handsOn:)
				)
				(swampMonster dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance gargSound of Sound
	(properties)
)

(instance pFirstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 189)
				(gGame handsOff:)
				(plants view: 4556 loop: 0 cel: 1)
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 2 1 self) ; "(DOING A 'BIG BOPPER')Hello baaaaaaby! You sure look sweet, little bon-bon!"
				(gEgo setMotion: 0)
				(proc11_3 gEgo plants self)
			)
			(2)
			(3
				(plants setCycle: End self)
			)
			(4
				(gKqSound1 number: 4559 setLoop: 1 play: self)
			)
			(5
				(plants setCycle: Beg self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kissyFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(proc11_3 gEgo plants self)
			)
			(1
				(plants view: 4556 loop: 0 setCycle: End self)
			)
			(2
				(gKqSound1 number: 4559 setLoop: 1 play: self)
			)
			(3
				(plants setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance feedPlants of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo view: 4559 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(plants
					view: 4559
					loop: 1
					cel: 0
					setHotspot: 0
					setCycle: End self
				)
				(gKqSound1 number: 4572 setLoop: 1 play:)
			)
			(3
				(gEgo loop: 2 cel: 0 setCycle: CT 10 1 self)
			)
			(4
				(plants loop: 3 cel: 0 setCycle: End self)
				(gEgo setCycle: End)
			)
			(5
				(plants loop: 4 cel: 0 setCycle: Fwd)
				(sfx number: 4561 setLoop: -1 play:)
				(self cue:)
			)
			(6
				(if (gEgo cycler:)
					(-- state)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(7
				(gEgo normalize:)
				(gGame handsOn:)
				(eatTimer setReal: eatTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance stopPlants of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eatTimer client: 0 delete: dispose:)
				(plants setCycle: End self)
			)
			(1
				(sfx stop:)
				(plants loop: 5 cel: 0 setCycle: End self)
			)
			(2
				(plants view: 4556 loop: 0 cel: 0 setHotspot: 8 10 68 79 5) ; Do, Exit, Defoliant, Foot-In-A-Bag, Golden_Comb
				(self dispose:)
			)
		)
	)
)

(instance sprayMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 159)
				(gEgo setMotion: PolyPath 52 85 self)
			)
			(1
				(gEgo
					view: 4553
					loop: 0
					cel: 0
					setScaler: 0
					scaleX: 120
					scaleY: 120
					setCycle: End self
				)
			)
			(2
				(gKqSound1 number: 4565 setLoop: 1 play: self)
				((= register (Prop new:))
					view: 4553
					loop: 1
					cel: 0
					cycleSpeed: 0
					x: 55
					y: 56
					setPri: 113
					init:
					setCycle: End self
				)
			)
			(3)
			(4
				(register dispose:)
				(swampMonster
					view: 4554
					loop: 0
					cel: 0
					x: 98
					y: 112
					setCycle: End self
				)
				(gKqSound1 number: 4657 setLoop: 1 play:)
			)
			(5
				(self setScript: monsterDissolve)
				(gMessager say: 1 68 0 1 self) ; "(AS A SCARAB)Well done, Princess!"
			)
			(6
				(gEgo view: 4553 loop: 2 cel: 0 setCycle: End self)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(gMessager say: 1 68 0 2 self) ; "(COUGHS BEFORE ANSWERING)Thank you, your majesty. Oh, I can't believe how that defoliant STINKS!"
			)
			(7
				(if (not (gEgo cycler:))
					(gEgo normalize: 0 setScaler: Scaler 100 50 110 62)
					(if ((ScriptID 13 0) mouth:) ; aEgoTalker
						(((ScriptID 13 0) mouth:) ; aEgoTalker
							view: (+ (gEgo view:) 30000)
							loop: 0
							scaleSignal: 1
							scaleX: (gEgo scaleX:)
							scaleY: (gEgo scaleY:)
							show:
						)
					)
				)
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
			)
			(8
				(gEgo normalize: 0 setScaler: Scaler 100 50 110 62)
				(UpdateScreenItem gEgo)
				(= cycles 1)
			)
			(9
				(gMessager say: 1 68 0 3 self) ; "(AS A SCARAB)Fortunately, I have no nostrils at the moment."
			)
			(10
				(if script
					(client script: script)
					(script client: client)
					(= script 0)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance malicia of Actor
	(properties
		view 4565
	)
)

(instance swampMonster of Actor
	(properties
		noun 1
		x 90
		y 50
		view 4551
	)

	(method (init)
		(super init:)
		(|= signal $1000)
		(self setHotspot: 8 10 68) ; Do, Exit, Defoliant
	)

	(method (doVerb theVerb)
		(switch theVerb
			(68 ; Defoliant
				(gCurRoom setScript: sprayMonster)
			)
			(else
				(if (gCurRoom script:)
					(cond
						((== (gCurRoom script:) monsterScript)
							(gMessager say: 1 8 1 0 (gCurRoom script:)) ; "(VERY SCARED)Um, hello there. I'm Rosella of Daven--"
						)
						((== (gCurRoom script:) chap5Open)
							(gMessager say: 1 8 29 0 (gCurRoom script:)) ; "(SCARED)Wait! Don't--"
						)
					)
				)
			)
		)
	)
)

(instance gargoyle of Actor
	(properties
		x 464
		y 92
		priority 90
		fixPriority 1
		view 4564
	)

	(method (doit)
		(if
			(and
				(not script)
				(not (gCurRoom script:))
				(== (gargoyleTimer seconds:) -1)
				(IsFlag 160)
			)
			(gargoyleTimer setReal: gargoyleTimer 30)
		)
		(super doit:)
	)

	(method (init)
		(if (or (== gChapter 4) (IsFlag 548))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self approachVerbs: 8 approachX: 426 approachY: 108 sightAngle: 10) ; Do
		(super init:)
	)

	(method (doVerb)
		(if (and (== view 4564) (== loop 0) (not cycler))
			(= local2 1)
			(gargoyleTimer setReal: gargoyleTimer 1)
			(= cel 1)
			(sfx number: 4551 setLoop: 1 play:)
		)
	)
)

(instance gateProp of Prop
	(properties
		x 59
		y 59
		view 45515
	)
)

(instance plants of Prop
	(properties
		noun 2
		sightAngle 10
		approachX 110
		approachY 118
		x 156
		y 83
		view 4556
	)

	(method (init)
		(super init:)
		(if (== gChapter 5)
			(self approachVerbs: 8 10) ; Do, Exit
			(if (IsFlag 492)
				(self setHotspot: 8 10 5) ; Do, Exit, Golden_Comb
			else
				(self setHotspot: 8 10) ; Do, Exit
			)
		else
			(self approachVerbs: 8 10) ; Do, Exit
			(self setHotspot: 8 10 68 79) ; Do, Exit, Defoliant, Foot-In-A-Bag
		)
		(self setPri: 100)
		(|= signal $1000)
	)

	(method (doit)
		(cond
			((or (gCurRoom script:) (OogaBooga script:) (gTalkers size:)) 0)
			(
				(and
					(== (gEgo x:) 134)
					(== (gEgo y:) 100)
					(not script)
					(<= (eatTimer seconds:) 0)
				)
				(self setScript: eatenByPlants)
			)
			(
				(and
					(>= (gEgo x:) (- approachX 20))
					(<= (gEgo x:) (+ approachX 60))
				)
				(cond
					((and (== gChapter 4) (not (IsFlag 189)))
						(self
							approachVerbs: 8 10 ; Do, Exit
							setHotspot: 8 10 68 79 5 ; Do, Exit, Defoliant, Foot-In-A-Bag, Golden_Comb
							setScript: pFirstTalk
						)
					)
					((and (== gChapter 5) (not (IsFlag 492)))
						(SetFlag 492)
						(self setHotspot: 8 10 5) ; Do, Exit, Golden_Comb
						(gEgo setMotion: 0)
						(proc11_3 gEgo plants)
						(gMessager say: 0 0 17 0) ; "(SINGS)Helloooooo!"
					)
					((and (== gChapter 5) (IsFlag 203) (not (IsFlag 493)))
						(SetFlag 493)
						(gEgo setMotion: 0)
						(proc11_3 gEgo plants)
						(gMessager say: 0 0 25 0) ; "(SUPER FRIENDLY)Hidely hi, sugar pie!"
					)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(cond
							((IsFlag 184)
								(gCurRoom setScript: halo)
							)
							((IsFlag 185)
								(gMessager say: 2 8 7 0) ; "(VERY INTERESTED BUT CAUTIOUS)What did you mean when you said I couldn't get through the were woods unless I had silver?"
								(SetFlag 184)
							)
							((IsFlag 186)
								(gMessager say: 2 8 6 0) ; "(CURIOUS BUT WARY)Would you know any way to get through the Wood of the Were folk, noble plants?"
								(SetFlag 185)
							)
							((IsFlag 187)
								(gCurRoom setScript: smackHeads)
								(gMessager say: 2 8 5 0 smackHeads) ; "(NERVOUS)Can you, uh, gentleplants tell me how to get out of this swamp?"
								(SetFlag 186)
							)
							((IsFlag 188)
								(gMessager say: 2 8 4 0) ; "(NERVOUS)You know, I've never seen a plant with teeth before!"
								(SetFlag 187)
							)
							(else
								(gMessager say: 2 8 3 0) ; "(NOT SURE ABOUT THIS)Um, hello. My name is Rosella. Who are you?"
								(SetFlag 188)
							)
						)
					)
					((IsFlag 203)
						(cond
							((IsFlag 494)
								(gCurRoom setScript: kissyFace)
							)
							((IsFlag 232)
								(SetFlag 494)
								(gCurRoom setScript: laugh)
							)
							((IsFlag 233)
								(gCurRoom setScript: smackHeads self)
								(gMessager sayRange: 2 8 26 1 2 smackHeads) ; "(SCOLDING A LITTLE)I KNOW you want to eat me for dinner. Why don't you just admit it?"
								(SetFlag 232)
							)
							(else
								(gMessager say: 2 8 24 0) ; "(SCOLDING A LITTLE)Aren't you meat-eating magnolias worried about the volcano? You don't look flame resistant to me!"
								(SetFlag 233)
							)
						)
					)
					((IsFlag 228)
						(gMessager say: 2 8 22 0) ; "You're just too far away, sugar pie. Come closer and we'll talk all cozy-like."
					)
					((IsFlag 229)
						(gCurRoom setScript: bonkHeads)
						(gMessager say: 2 8 21 0 bonkHeads) ; "There are no plants like you in Daventry, that's for sure."
						(SetFlag 228)
					)
					((IsFlag 230)
						(gCurRoom setScript: smackHeads)
						(gMessager say: 2 8 20 0 smackHeads) ; "Tell me, good, um, plant, who lives in the house over yonder?"
						(SetFlag 229)
					)
					((IsFlag 231)
						(gMessager say: 2 8 19 0) ; "(CAUTIOUS)What sort of creature are you?"
						(SetFlag 230)
					)
					(else
						(gMessager say: 2 8 18 0) ; "(UNSURE)Well...hello!"
						(SetFlag 231)
					)
				)
			)
			(68 ; Defoliant
				(if (== argc 1)
					(approachScript init: self theVerb 100 94)
				else
					(gCurRoom setScript: sprayPlants)
				)
			)
			(79 ; Foot-In-A-Bag
				(if (== argc 1)
					(approachScript init: self theVerb 97 106)
				else
					(gCurRoom setScript: feedPlants)
					(gEgo put: 59) ; Foot-In-A-Bag
				)
			)
			(5 ; Golden_Comb
				(if (== argc 1)
					(approachScript init: self theVerb approachX approachY)
				else
					(self deleteHotVerb: 5) ; Golden_Comb
					(gCurRoom setScript: lookAtComb)
				)
			)
		)
	)

	(method (cue)
		(gMessager say: 2 8 26 3) ; "Yeah!"
	)
)

(instance flower of View
	(properties
		noun 3
		sightAngle 10
		approachX 134
		approachY 101
		x 153
		y 97
		view 45515
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gEgo setScript: getFlower)
			)
		)
	)
)

(instance light of View ; UNUSED
	(properties
		x 550
		y 85
		view 4551
		loop 4
	)

	(method (init))
)

(instance gate of ExitFeature
	(properties
		exitDir 1
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			x: 67
			y: 60
			approachX: 52
			approachY: 69
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 31 62 60 86 67 92 30 74 24
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== (gCurRoom script:) monsterScript)
						(gCurRoom setScript: escapeScript)
					)
					((< (gEgo y:) approachY)
						(gCurRoom setScript: openGate)
					)
					(else
						(gCurRoom setScript: openGate 0 1)
					)
				)
			)
		)
	)
)

(instance triggerPanel of Feature
	(properties
		nsLeft 317
		nsTop 75
		nsRight 320
		nsBottom 94
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 385 80 385 117 400 117 400 80
					yourself:
				)
		)
	)
)

(instance frontDoor of Feature
	(properties)

	(method (init)
		(super init:)
		(if (or (== gChapter 4) (IsFlag 548))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			approachVerbs: 8 ; Do
			x: 516
			y: 80
			approachX: 516
			approachY: 96
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 506 90 505 42 515 23 530 22 540 34 543 91
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: knockOnDoor)
			)
		)
	)
)

(instance wereForest of ExitFeature
	(properties
		nsLeft 620
		nsTop 79
		nsRight 640
		nsBottom 140
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (handleEvent event)
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
				(super handleEvent: event &rest)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(event type:)
					(!= (event type:) evMOUSERELEASE)
					(not global308)
					(self onMe: event)
				)
				(exitRight client: gEgo state: 0)
				(gEgo setMotion: PolyPath 639 125 exitRight)
			)
		)
	)
)

(instance exitRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 650 (gEgo y:) self)
			)
			(2
				(gCurRoom newRoom: 3150)
			)
		)
	)
)

(instance behindHouse of ExitFeature
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 79
		x 620
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 approachX: 620 approachY: 78 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 4650)
	)
)

(instance treeHouse of ExitFeature ; UNUSED
	(properties
		nsLeft 45
		nsRight 80
		nsBottom 65
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 approachX: 77 approachY: 55 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(ClearFlag 162)
		(gCurRoom newRoom: 4250)
	)
)

(instance eatTimer of Timer
	(properties)

	(method (cue)
		(plants setScript: stopPlants)
	)
)

(instance gargoyleTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gargoyle script:)) (not (gCurRoom script:)))
			(= seconds -1)
			(gargoyle setScript: howl)
		else
			(gargoyleTimer setReal: gargoyleTimer 30)
		)
	)
)

(instance plantTalker1 of KQTalker
	(properties)

	(method (init)
		(= view 45561)
		(= client plants)
		(cond
			((client loop:)
				(= loop 4)
			)
			((client cel:)
				(= loop 0)
			)
			(else
				(= loop 1)
			)
		)
		(super init:)
	)
)

(instance plantTalker2 of KQTalker
	(properties)

	(method (init)
		(= view 45561)
		(= client plants)
		(if (client loop:)
			(= loop 5)
		else
			(= loop 2)
		)
		(super init:)
	)
)

(instance plantTalker3 of KQTalker
	(properties)

	(method (init)
		(= view 45561)
		(= client plants)
		(if (client loop:)
			(= loop 6)
		else
			(= loop 3)
		)
		(super init:)
	)
)

(instance bark of Sound
	(properties)
)

(instance barkTimer of Timer
	(properties)

	(method (cue)
		(if (> (gEgo x:) 320)
			(bark number: 917 setLoop: 1 play:)
		)
		(self setReal: self (Random 60 120))
	)
)

(instance approachScript of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(gEgo setMotion: PolyPath param3 param4 self)
		(= client param1)
		(= state -1)
		(= register param2)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc11_3 gEgo client self)
			)
			(1
				(client doVerb: register 1)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		noun 5
		nsLeft 580
		nsTop 40
		nsRight 591
		nsBottom 52
		sightAngle 10
		approachX 595
		approachY 116
		x 585
		y 46
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10) ; Do, Exit
		(self approachVerbs: 8 10) ; Do, Exit
	)

	(method (doVerb)
		(gMessager say: noun 8 14 0) ; "(THINKS TO HERSELF)A lovely crystal lamp! What a strange thing to see in this desolate place."
	)
)

