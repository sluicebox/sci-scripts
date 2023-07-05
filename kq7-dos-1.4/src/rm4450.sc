;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4450)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use OogaBooga)
(use Inset)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm4450 0
	malTimer 1
)

(local
	local0
	local1 = 1
	local2
	local3
)

(instance rm4450 of KQRoom
	(properties
		picture 4450
	)

	(method (init)
		((ScriptID 7001 1) ; maliciaTalker
			client: malicia
			view: -1
			loop: -1
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 270 189 270 125 306 123 254 71 205 71 227 92 131 94 110 70 87 69 96 87 64 87 51 80 39 86 12 81 0 87 0 104 122 136 125 190
					yourself:
				)
		)
		(gKqMusic1 number: 4450 setLoop: -1 setVol: 127 play:)
		(candles setCycle: RandCycle init:)
		(candles2 setCycle: RandCycle init:)
		(SetFlag 192)
		(Load rsMESSAGE 4450)
		(board init:)
		(cond
			((IsFlag 496)
				(sock cel: (sock lastCel:) init:)
			)
			((IsFlag 163)
				(drawerRosView init: setCel: (drawerRosView lastCel:))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 255 75 261 87 227 87 212 75
							yourself:
						)
				)
				(switch (OogaBooga underWearCntr:)
					(1
						(pile
							init:
							view: 4455
							setLoop: 7
							setCel: 0
							posn: 232 74
						)
					)
					(2
						(pile
							init:
							view: 4455
							setLoop: 8
							setCel: 0
							posn: 232 74
						)
					)
					(3
						(pile
							init:
							view: 4455
							setLoop: 9
							setCel: 6
							posn: 233 74
						)
					)
					(4
						(pile
							init:
							view: 4455
							setLoop: 10
							setCel: 5
							posn: 232 74
						)
					)
					(5
						(pile
							init:
							view: 4455
							setLoop: 10
							setCel: 5
							setHotspot: 8 10 ; Do, Exit
							approachVerbs: 8 10 ; Do, Exit
							posn: 232 74
						)
					)
				)
			)
		)
		((ScriptID 7001 1) client: malicia) ; maliciaTalker
		(floorBoard init:)
		(cond
			((IsFlag 299)
				(gCurRoom setScript: sValRaiseBoard)
				(gWalkHandler addToEnd: floorBoard self)
			)
			((and (== gPrevRoomNum 4650) (IsFlag 5))
				(= local1 0)
				(ClearFlag 5)
				(malicia init: hide: setLoop: -1 setLooper: Grooper)
				((ScriptID 7001 0) client: otar) ; kingTalker
				(gEgo
					normalize: 2
					setScaler: Scaler 131 100 138 90
					posn: 170 100
					init:
				)
				((ScriptID 4001 2) setReal: (ScriptID 4001 2) 180) ; myReturnTimer, myReturnTimer
				(mySouthExit init:)
				(drawer1 init:)
				(drawer2 init:)
				(drawer3 init:)
				(vanity init:)
				(table init:)
				(gGame handsOn:)
			)
			((and (== gPrevRoomNum 4650) (not (IsFlag 165)) (== gChapter 4))
				(malicia init: hide: setLoop: -1 setLooper: Grooper)
				(gCurRoom setScript: sRosEnter)
			)
			((and (== gPrevRoomNum 4650) (IsFlag 162))
				(malicia init: hide: setLoop: -1 setLooper: Grooper)
				(gCurRoom setScript: sZapEgo)
			)
			((and (== gPrevRoomNum 4600) (not (IsFlag 165)) (IsFlag 164))
				(Load 140 4463) ; WAVE
				(Load rsVIEW 4461)
				(malicia view: 4461 setLoop: 1 setCel: 0 posn: 94 87 init:)
				(dog
					view: 4461
					setLoop: 0
					setCel: 0
					posn: 85 87
					setPri: 88
					init:
				)
				(gCurRoom setScript: sVal4600TimerDone)
			)
			((and (== gPrevRoomNum 4600) (IsFlag 164) (IsFlag 165))
				(malicia
					hide:
					setCycle: StopWalk -1
					setLoop: -1
					setLooper: Grooper
					init:
				)
				(if (== gChapter 4)
					(gCurRoom setScript: sDogSprayed)
				else
					(gCurRoom setScript: sDogAmbrosed)
				)
			)
			(else
				(malicia init: hide: setLoop: -1 setLooper: Grooper)
				(gWalkHandler addToEnd: floorBoard self)
				(if (== gValOrRoz -3) ; Roz
					(gCurRoom setScript: sRosRaiseBoard)
				else
					(gCurRoom setScript: sValRaiseBoard)
				)
			)
		)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and local3 (not (gCurRoom script:)))
			(= local3 0)
			(if (== gValOrRoz -4) ; Val
				(gCurRoom setScript: maliciaZapVal)
			else
				(gCurRoom setScript: maliciaZapRos)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((== (malicia script:) getDownTimer)
				(getDownTimer cue:)
				(event claimed: 1)
				(super handleEvent: event)
			)
			(local1
				(gWalkHandler delete: floorBoard)
				(= local1 0)
				(gEgo enableHotspot:)
				(cond
					((and (== gChapter 4) (IsFlag 164))
						(getDownTimer cue:)
					)
					((== gChapter 4)
						((ScriptID 7001 0) client: otar) ; kingTalker
						(gCurRoom setScript: sRosClimbOut)
					)
					(else
						(gCurRoom setScript: sClimbOut)
					)
				)
				(event claimed: 1)
				(super handleEvent: event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (IsFlag 474)
			(self setScript: maliciaReturns)
		)
	)

	(method (dispose)
		(mySound stop:)
		(malTimer client: 0 delete: dispose:)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: floorBoard self)
		)
		((ScriptID 7001 0) client: 0) ; kingTalker
		(gEgo enableHotspot:)
		(DisposeScript 64941)
		(super dispose:)
	)
)

(instance sFakeExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 823) ; WAVE
				(Load 140 8640) ; WAVE
				(Load 140 8640) ; WAVE
				(Load 140 4412) ; WAVE
				(gEgo setMotion: PolyPath 170 180 self)
			)
			(1
				(gEgo setMotion: MoveTo 170 212 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gCurRoom setInset: fakeExit 0 0 1)
				(door init:)
				(gargolye setLoop: 0 setCel: 0 posn: 142 90 init:)
				(fakeEgo
					x: 208
					y: 89
					loop: 8
					cel: 4
					heading: 225
					setPri: -1
					init:
				)
				((gCurRoom inset:) drawInset:)
				(gKqSound1 number: 801 loop: 1 play:)
				(door setCycle: End self)
			)
			(4
				(fakeEgo setCycle: Walk setMotion: MoveTo 202 96 self)
			)
			(5
				(door setCycle: Beg self)
			)
			(6
				(gKqSound1 number: 802 loop: 1 play: self)
			)
			(7
				(fakeEgo setCycle: Walk setMotion: MoveTo 196 104 self)
			)
			(8
				(gargolye setCycle: End self)
			)
			(9
				(mySound number: 8640 loop: 1 play:)
				(gargolye loop: 1 cel: 0 posn: 165 95 setCycle: CT 7 1 self)
				(fakeEgo setMotion: MoveTo 190 114 self)
			)
			(10 0)
			(11
				(mySound number: 4402 loop: 1 play:)
				(gargolye posn: 177 103 setCycle: End self)
				(fakeEgo
					view: (if (== gChapter 4) 8574 else 8214)
					loop: 1
					setPri: 100
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(12
				(mySound number: 4412 loop: 1 play: self)
			)
			(13 0)
			(14
				(gargolye dispose:)
				(fakeEgo dispose:)
				(fakeExit dispose:)
				(EgoDead 54 self)
			)
			(15
				(ClearFlag 5)
				(gEgo normalize: posn: 170 110)
				(if (== gChapter 4)
					(malTimer setReal: malTimer 300)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4460
					setLoop: 0
					setCel: 0
					posn: 57 88
					setPri: 88
					init:
				)
				(= cycles 3)
			)
			(1
				(gEgo setCycle: End self)
				(mySound number: 923 setLoop: 1 play: self)
				(board hide:)
			)
			(2
				(gEgo loop: 1 cel: 0 posn: 92 94 setCycle: End self)
			)
			(3
				(gEgo setCycle: CT 12 -1 self)
			)
			(4
				(gEgo setLoop: 0 1)
				(gEgo cel: (gEgo lastCel:) posn: 57 88)
				(= local1 1)
				(gEgo disableHotspot:)
				(User canControl: 0)
				(gWalkHandler addToEnd: floorBoard gCurRoom)
				(gCurRoom setScript: maliciaWalkIn)
			)
		)
	)
)

(instance sRosStartUnder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 123 89 self)
			)
			(1
				(gEgo
					view: 4451
					setLoop: 0
					setScale: 0
					setPri: 88
					posn: 57 89
					setCel: 59
					setCycle: CT 51 -1 self
				)
			)
			(2
				(mySound number: 923 setLoop: 1 play:)
				(board hide:)
				(gEgo setCycle: Beg self)
			)
			(3
				(mySound number: 44501 loop: 1 play:)
				(gKqMusic1 fade:)
				(User canControl: 0)
				(gCurRoom newRoom: 4650)
			)
		)
	)
)

(instance sRosClimbOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 836)
				(gEgo
					view: 4451
					setLoop: 0
					posn: 57 89
					setCycle: CT 51 1 self
				)
			)
			(1
				(mySound number: 44501 setLoop: 1 play:)
				(board show:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo
					posn: 123 89
					setScaler: Scaler 131 100 138 90
					normalize: 4
				)
				((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
				(gMessager say: 0 0 5 0 self) ; "(AS A SCARAB)Rosella! The thing we are looking for is a device made of brass and many lenses. It is an ancient and mysterious artifact; the only thing in Etheria that could destroy Malicia, but she doesn't know that. It could be anywhere."
			)
			(3
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(mySouthExit init:)
				(drawer1 init:)
				(drawer2 init:)
				(drawer3 init:)
				(vanity init:)
				(table init:)
				(User canControl: 0)
				(SetFlag 161)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMalComeHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 9 0 self) ; "(TALKING TO DOG)it's our big night, my widdle Cuddles! We're going to blow that rotten old Etheria right out of the sky. And we just might take the rest of the world with it, won't we, kissy boy?"
			)
			(1
				(= seconds 5)
			)
			(2
				(gGame handsOff:)
				(gKqMusic1 number: 941 loop: -1 play:)
				(gEgo setCycle: 0 setMotion: 0)
				(cond
					((== (gEgo view:) 4460)
						(gEgo setCycle: End self)
					)
					((== (gEgo view:) 4451)
						(gEgo setCycle: Beg self)
					)
					(
						(and
							(== (gEgo view:) 836)
							(< 150 (gEgo x:) 190)
							(< 120 (gEgo y:) 140)
						)
						(gEgo setMotion: PolyPath 140 100 self)
					)
					(else
						(= cycles 1)
					)
				)
				(malicia
					view: 9060
					setCycle: StopWalk -1
					posn: 170 155
					show:
					setMotion: PolyPath 170 135 self
				)
				(mySound number: 823 loop: 1 play:)
			)
			(3 0)
			(4
				(gEgo normalize:)
				(proc11_3 gEgo malicia self)
				(proc11_3 malicia gEgo self)
			)
			(5 0)
			(6
				((ScriptID 7001 1) ; maliciaTalker
					hide_mouth: 0
					view: 39060
					loop: (malicia cel:)
				)
				(gMessager say: 0 0 4 0 self) ; "(NASTY)My my! The weevils are just getting bigger and bigger around here!"
			)
			(7
				((ScriptID 7001 1) hide_mouth: 1 view: -1 loop: -1) ; maliciaTalker
				(malicia
					view: 4477
					loop: (malicia cel:)
					cel: 0
					setCycle: CT 8 1 self
				)
			)
			(8
				(malicia setCycle: End self)
				(mySound number: 845 loop: 1 play:)
				(gEgo
					view: 4478
					setLoop: (gEgo cel:)
					cel: 0
					setCycle: End self
				)
			)
			(9 0)
			(10
				(EgoDead 7 self)
			)
			(11
				(ClearFlag 5)
				(malicia hide: view: 9060 posn: 170 200)
				(gEgo
					normalize:
					setScaler: Scaler 131 100 138 90
					posn: 170 100
					setHeading: 180
				)
				(gKqMusic1 number: 4450 loop: -1 setVol: 127 play:)
				(malTimer setReal: malTimer 300)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sVal4600TimerDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dog setCycle: End self)
				(mySound number: 4463 setLoop: 1 play:)
			)
			(1
				(gMessager say: 0 0 13 1 self) ; "What is it, Cuddles? What did you find, my precious one?"
			)
			(2
				(malicia setCycle: CT 4 1 self)
			)
			(3
				(dog dispose:)
				(malicia setCycle: End self)
			)
			(4
				(malicia setLoop: 2 setCel: 0 posn: 88 91)
				(= cycles 2)
			)
			(5
				(gMessager say: 0 0 13 2 self) ; "(NASTY)Aha! You found a nasty little bug!"
			)
			(6
				(malicia setCycle: End self)
			)
			(7
				(SetFlag 298)
				(gCurRoom newRoom: 4600)
			)
		)
	)
)

(instance sZapEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(malicia view: 4470 setLoop: 1 setCel: 0 posn: 159 107 show:)
				(board hide:)
				(gEgo
					view: 4470
					setLoop: 0 1
					setCel: 0
					posn: 56 90
					setPri: 88
					init:
				)
				(= cycles 3)
			)
			(1
				(mySound number: 923 loop: 1 play:)
				(gEgo setCycle: CT 18 1 self)
			)
			(2
				(gEgo setPri: -1 setCycle: CT 39 1 self)
			)
			(3
				(mySound number: 44501 setLoop: 1 play:)
				(board show:)
				(gEgo setCycle: End self)
				(malicia setCycle: End self)
				(FrameOut)
			)
			(4 0)
			(5
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
				(gMessager say: 0 0 8 1 self) ; "(NASTY)I just KNEW I had vermin under the floor!"
			)
			(6
				(malicia loop: 2 cel: 0 posn: 140 110 setCycle: CT 4 1 self)
				(mySound number: 845 loop: 1 play:)
			)
			(7
				(gEgo hide:)
				(malicia setCycle: CT 10 1 self)
			)
			(8
				(mySound number: 808 loop: 1 play:)
				(malicia setCycle: End self)
			)
			(9
				(EgoDead 7 self)
			)
			(10
				(gKqMusic1 fade:)
				(gCurRoom newRoom: 4650)
			)
		)
	)
)

(instance sLookVanity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(gMessager say: 2 8 6 0 self) ; "(CATTILY)Look at all that make-up! I wonder where she keeps the trowel?"
				else
					(gEgo view: 8165 loop: 1 cel: 0 setCycle: End self)
				)
			)
			(1
				(if (== gValOrRoz -4) ; Val
					((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
					(gMessager say: 2 8 12 0 self) ; "(THINKS TO HERSELF CATTILY)Hmmph. No one's probably seen her REAL face in years."
				else
					(= cycles 1)
				)
			)
			(2
				(if (== gValOrRoz -4) ; Val
					((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo normalize: setHeading: 180 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					view: 4475
					setLoop: 1
					setCel: 0
					setScale: 0
					setCycle: CT 7 1 self
				)
			)
			(2
				(SetFlag 497)
				(gEgo get: 71) ; Crystal_Shaft
				(mySound number: 4459 setLoop: 1 play: self)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					normalize:
					setScaler: Scaler 139 82 160 75
					setHeading: 180 self
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTouchLamp of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					view: 4475
					setLoop: 0
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(mySound number: 4458 setLoop: 1 play: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					normalize:
					setScaler: Scaler 139 82 160 75
					setHeading: 180 self
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setCycle: CT 18 1 self)
			)
			(2
				(gEgo setPri: -1 setCycle: CT 39 1 self)
			)
			(3
				(mySound number: 44501 setLoop: 1 play:)
				(board show:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					setScaler: Scaler 139 82 160 75
					normalize: 0
					posn: 126 92
					setHeading: 180 self
				)
			)
			(5
				(SetFlag 161)
				(if (not (IsFlag 475))
					(bed init:)
				)
				(drawer3 init:)
				(if (not (IsFlag 497))
					(lamp init:)
				)
				(vanity init:)
				(table init:)
				(mySouthExit init:)
				(if (not local3)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sValStartUnder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(gEgo disableHotspot:)
				(gEgo setMotion: PolyPath 126 91 self)
			)
			(1
				(gEgo
					view: 4476
					setLoop: 0
					setCel: 0
					posn: 114 90
					setScaler: 0
					scaleX: 128
					scaleY: 128
					maxScale: 128
					setCycle: CT 11 1 self
				)
			)
			(2
				(board hide:)
				(mySound number: 923 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 4650)
			)
		)
	)
)

(instance sBackUnder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: Beg self)
			)
			(1
				(gCurRoom newRoom: 4600)
			)
		)
	)
)

(instance sRosRaiseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(board hide:)
				(gEgo view: 4451 setLoop: 0 1 setCel: 0 posn: 56 89 init:)
				(= cycles 3)
			)
			(1
				(gEgo setCycle: CT 23 1 self)
				(mySound number: 923 setLoop: 1 play:)
			)
			(2
				(malTimer setReal: malTimer 300)
				(gGame handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sValRaiseBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(board hide:)
				(gEgo
					view: 4470
					setLoop: 0 1
					setCel: 0
					posn: 56 90
					setScale: 0
					scaleX: 128
					scaleY: 128
					setPri: 88
					init:
				)
				(= cycles 3)
			)
			(1
				(gEgo setCycle: CT 8 1 self)
				(mySound number: 923 setLoop: 1 play:)
			)
			(2
				(= local1 1)
				(gEgo disableHotspot:)
				(if (not (IsFlag 299))
					(gCurRoom setScript: maliciaEnterChap5)
				else
					(gWalkHandler addToEnd: floorBoard gCurRoom)
					(gEgo setPri: -1)
					(SetFlag 161)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDogSprayed of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOn:)
					(gGame handsOff: 1)
					(ClearFlag 164)
					(malicia view: 9060 setHeading: 315 posn: 163 118 show:)
					(mySound number: 888 loop: 1 play:)
					(dog
						init:
						view: 4461
						loop: 0
						cel: 0
						posn: 83 88
						setCycle: End self
					)
				)
				(1
					(dog
						view: 4462
						posn: 81 88
						loop: 0
						cel: 0
						setCycle: End self
					)
					(mySound number: 4464 loop: 1 play: self)
				)
				(2 0)
				(3
					(dog
						view: 4462
						loop: 1
						cel: 0
						posn: 79 87
						setCycle: End self
					)
				)
				(4
					(dog
						loop: 0
						cel: 0
						posn: 83 88
						setPri: 90
						setCycle: End self
					)
					(mySound number: 4465 loop: 1 play:)
				)
				(5
					(dog loop: 0 cel: 0)
					(malicia setMotion: PolyPath 120 85 self)
				)
				(6
					(malicia setMotion: PolyPath 79 83 self)
				)
				(7
					(malicia setHeading: 225 self)
				)
				(8
					(malicia
						view: 4461
						loop: 1
						cel: 0
						posn: 87 87
						setCycle: CT 5 1 self
					)
				)
				(9
					(dog dispose:)
					(malicia setCycle: CT 22 1 self)
				)
				(10
					(malicia view: 4463 loop: 0 cel: 0 setCycle: End self)
				)
				(11
					(gMessager sayRange: 0 0 3 1 2 self) ; "(VERY CONCERNED)Oh! Poor babeums! What's wong, kissy boy?"
				)
				(12
					(malicia view: 4463 loop: 2 cel: 0 setCycle: End self)
				)
				(13
					(malicia view: 4463 loop: 0 cel: 0 setCycle: End self)
				)
				(14
					(gMessager say: 0 0 3 3 self) ; "(INDULGENT)Anything my Cuddles wants, him gets!"
				)
				(15
					(SetFlag 165)
					(ClearFlag 162)
					(SetFlag 476)
					(gGame scratch: 1)
					(gCurRoom newRoom: 4600)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(mySound stop:)
					(malicia dispose:)
					(dog dispose:)
					(ClearFlag 162)
					(SetFlag 165)
					(SetFlag 476)
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gGame scratch: 1)
					(gCurRoom newRoom: 4600)
				)
			)
		)
	)
)

(instance sDogAmbrosed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 299)
				(gGame handsOff:)
				(malicia
					view: 9060
					posn: 170 200
					setCycle: StopWalk -1
					show:
					setMotion: MoveTo 170 140 self
				)
				(dog
					view: 4473
					loop: 0
					cel: 0
					posn: 78 89
					setCycle: ROsc -1 0 6
					init:
				)
				(mySound number: 4461 loop: -1 play:)
			)
			(1
				(malicia setMotion: PolyPath 32 84 self)
			)
			(2
				(malicia loop: 8 cel: 0 setMotion: MoveTo 57 84)
				(dog setCycle: CT 11 1 self)
			)
			(3
				(mySound number: 4454 loop: 1 play: self)
			)
			(4
				(dog setCycle: End self)
			)
			(5
				(bone setPri: 150 posn: 87 75 init: setCycle: End self)
				(mySound number: 4456 loop: -1 play:)
				(dog setLoop: 4 1 cel: 0 setCycle: Fwd)
				(malicia
					view: 4473
					loop: 2
					cel: 0
					posn: 53 84
					setCycle: CT 43 1 self
				)
			)
			(6 0)
			(7
				(bone setCycle: Beg)
				(malicia setCycle: End self)
			)
			(8
				(bone hide:)
				(mySound stop:)
				((ScriptID 7001 1) clientCel: -2) ; maliciaTalker
				(gMessager say: 0 0 11 1 self) ; "(TALKING TO DOG)It's too bad there won't be anyone left to admire my beauty...Cuddles! What do you have in your mouth? Let me see!"
			)
			(9
				((ScriptID 7001 1) mouth_x: -999) ; maliciaTalker
				(= cycles 6)
			)
			(10
				(bone dispose:)
				(mySound number: 4457 loop: 1 play:)
				(malicia
					view: 4473
					loop: 3
					cel: 0
					setPri: 90
					posn: 24 86
					setCycle: CT 7 1 self
				)
			)
			(11
				((ScriptID 7001 1) clientCel: -2) ; maliciaTalker
				(gMessager say: 0 0 11 2 self) ; "No matter, you naughty boy! Let's go watch the fireworks!"
			)
			(12
				(malicia setCycle: CT 11 1 self)
			)
			(13
				(dog dispose:)
				(malicia setCycle: CT 37 1 self)
			)
			(14
				(malicia setPri: 100 setCycle: End self)
				((ScriptID 7001 1) view: register clientCel: -2) ; maliciaTalker
			)
			(15
				(gGame scratch: 1)
				(gCurRoom newRoom: 4600)
			)
		)
	)
)

(instance maliciaWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 162)
				(SetFlag 164)
				(mySound number: 801 loop: 1 play: self)
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
			)
			(1
				(gMessager say: 0 0 1 0 self) ; "(SWEET-TALKING TO CUDDLES)Here we are, Cuddle-poo. Home again, to this awful, dreary, miserable little house."
			)
			(2
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
				(malicia setScript: getDownTimer)
				(gGame handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance maliciaZapVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 number: 941 loop: -1 play:)
				(cond
					(local3
						(= cycles 1)
					)
					(local1
						(gEgo setCycle: CT 18 1 self)
					)
					(else
						(proc11_3 gEgo malicia self)
					)
				)
			)
			(1
				(cond
					(local3
						(= cycles 1)
					)
					(local1
						(gEgo setPri: -1 setCycle: CT 39 1 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(board show:)
				(cond
					(local3
						(= cycles 1)
					)
					(local1
						(mySound number: 44501 setLoop: 1 play:)
						(gEgo setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
				(malicia
					show:
					setCycle: StopWalk -1
					setMotion: MoveTo 184 98 self
				)
			)
			(3 0)
			(4
				(proc11_3 malicia gEgo self)
			)
			(5
				(malicia view: 4472 setLoop: 0 setCel: 0 setCycle: End)
				(mySound number: 4451 setLoop: 1 play: self)
			)
			(6
				(malicia setCycle: Beg)
				(mySound number: 4452 play: self)
			)
			(7
				(malicia view: 4470 loop: 1 posn: 157 104 setCycle: End self)
			)
			(8
				(gMessager say: 0 0 10 0 self) ; "(NASTILY AMUSED)You humans don't have the best survival instincts, do you."
			)
			(9
				(gEgo
					posn: 126 92
					setScaler: Scaler 139 82 160 75
					view: 8284
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(10
				(malicia
					setLoop: 2
					setCel: 0
					posn: 134 105
					setCycle: CT 4 1 self
				)
				(mySound number: 845 setLoop: 1 play:)
			)
			(11
				(gEgo hide:)
				(malicia setCycle: End self)
			)
			(12
				(EgoDead 12 self)
			)
			(13
				(ClearFlag 5)
				(gKqMusic1 number: 4450 loop: -1 setVol: 127 play:)
				(malicia hide: view: 9060 posn: 170 200)
				(ClearFlag 164)
				(gCurRoom setScript: sValRaiseBoard)
			)
		)
	)
)

(instance maliciaZapRos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 number: 941 loop: -1 play:)
				(if local3
					(malicia
						view: 9060
						show:
						setScaler: Scaler 131 100 138 90
						setCycle: StopWalk -1
						posn: 170 170
						setMotion: MoveTo 170 150 self
					)
				else
					(gEgo view: 4451 loop: 0 cel: 12 setCycle: CT 51 1 self)
					(malicia
						view: 9060
						show:
						setScaler: Scaler 131 100 138 90
						setCycle: StopWalk -1
						posn: 170 170
						setMotion: MoveTo 170 150
					)
				)
			)
			(1
				(board show:)
				(if local3
					(= cycles 1)
				else
					(gEgo setCycle: End self)
				)
			)
			(2
				(proc11_3 malicia gEgo self)
			)
			(3
				(gEgo
					normalize: 0
					posn: 123 89
					setScaler: Scaler 131 100 138 90
					setMotion: PolyPath 115 113 self
				)
				(malicia setMotion: PolyPath 234 111 self)
			)
			(4 0)
			(5
				(malicia
					view: 44601
					setCycle: 0
					setLoop: 1 1
					cel: 0
					posn: 247 111
				)
				(gEgo setHeading: 90 self)
			)
			(6
				(gMessager say: 0 0 2 0 self) ; "(GLEEFUL)Well! That's the biggest floor rat I've ever seen...and I happen to know its name is ROSELLA!"
			)
			(7
				(malicia setCycle: CT 13 1 self)
			)
			(8
				(malicia setCycle: End)
				(gEgo
					view: 44600
					posn: 111 113
					loop: 0
					cel: 0
					setCycle: CT 34 1 self
				)
			)
			(9
				(zap
					loop: 2
					cel: 0
					posn: 223 51
					setPri: 120
					init:
					setCycle: End
				)
				(mySound number: 845 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(10
				(gEgo
					view: 4460
					loop: 3
					cel: 0
					posn: 91 125
					setCycle: End self
				)
			)
			(11
				(EgoDead 11 self)
			)
			(12
				(ClearFlag 5)
				(gEgo hide:)
				(zap dispose:)
				(malicia hide: setLoop: -1 view: 9060 posn: 170 200)
				(gKqMusic1 number: 4450 loop: -1 setVol: 127 play:)
				(gCurRoom setScript: sRosEnter)
			)
		)
	)
)

(instance comeBackAfterMal of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScaler: Scaler 131 100 138 90 normalize: 4)
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 5 0 self) ; "(AS A SCARAB)Rosella! The thing we are looking for is a device made of brass and many lenses. It is an ancient and mysterious artifact; the only thing in Etheria that could destroy Malicia, but she doesn't know that. It could be anywhere."
			)
			(2
				(SetFlag 476)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance maliciaReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 number: 941 loop: -1 play:)
				((ScriptID 4001 2) client: 0 delete: dispose:) ; myReturnTimer
				(gMessager say: 0 0 4 0 self) ; "(NASTY)My my! The weevils are just getting bigger and bigger around here!"
			)
			(1
				(malicia
					show:
					setCycle: StopWalk -1
					setMotion: PolyPath 120 112 self
				)
			)
			(2
				(malicia view: 4470 loop: 0 posn: 120 112 setCycle: End self)
			)
			(3
				(malicia loop: 1 cel: 0 posn: 140 110 setCycle: End self)
			)
			(4
				(EgoDead 8 self)
			)
			(5
				(ClearFlag 5)
				(ClearFlag 474)
				(gKqMusic1 number: 4450 loop: -1 setVol: 127 play:)
				((ScriptID 4001 2) setReal: (ScriptID 4001 2) 20) ; myReturnTimer, myReturnTimer
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValLookAtBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 20 self)
			)
			(1
				(gMessager say: 1 8 12 0 self) ; "How could anyone sleep in...in that."
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(SetFlag 475)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValOpenDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4474
					setScaler: 0
					scaleX: 128
					scaleY: 128
					maxScale: 128
					loop: 1
					cel: 0
					posn: 226 84
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: CT 9 1 self)
				(mySound number: 860 loop: 1 play: self)
			)
			(2 0)
			(3
				(drawerView init:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo loop: 2 cel: 0 posn: 238 79 setCycle: End self)
			)
			(5
				(gEgo loop: 3 cel: 0 posn: 221 85 setCycle: CT 15 1 self)
			)
			(6
				(drawerView dispose:)
				(gEgo setCycle: End self)
				(mySound number: 861 loop: 1 play: self)
			)
			(7 0)
			(8
				(gEgo
					posn: 237 76
					setScaler: Scaler 139 82 160 75
					normalize: 3
				)
				(= cycles 1)
			)
			(9
				(gMessager say: 4 8 12 0 self) ; "(THINKS TO HERSELF CATTILY)Tacky, tacky, tacky!"
			)
			(10
				(gEgo setHeading: 180 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance maliciaEnterChap5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 801 loop: 1 play: self)
				((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
			)
			(1
				(gMessager say: 0 0 9 0 self) ; "(TALKING TO DOG)it's our big night, my widdle Cuddles! We're going to blow that rotten old Etheria right out of the sky. And we just might take the rest of the world with it, won't we, kissy boy?"
			)
			(2
				((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
				(SetFlag 164)
				(malicia setScript: getDownTimer)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 860) ; WAVE
				(Load 140 861) ; WAVE
				(if (!= (gEgo heading:) 315)
					(proc11_3 gEgo drawer3 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 4454
					loop: 1
					cel: 0
					posn: 203 72
					setCycle: End self
				)
				(mySound number: 860 loop: 1 play: self)
			)
			(2 0)
			(3
				(gEgo cel: 7 setCycle: Beg self)
				(mySound number: 861 play: self)
			)
			(4 0)
			(5
				(gEgo
					posn: 244 74
					setScaler: Scaler 131 100 138 90
					normalize: 7
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 860) ; WAVE
				(Load 140 861) ; WAVE
				(if (!= (gEgo heading:) 315)
					(proc11_3 gEgo drawer3 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 4454
					loop: 2
					cel: 0
					posn: 228 73
					setCycle: End self
				)
				(mySound number: 860 loop: 1 play: self)
			)
			(2 0)
			(3
				(gEgo cel: 8 setCycle: Beg self)
				(mySound number: 861 loop: 1 play: self)
			)
			(4 0)
			(5
				(gEgo
					posn: 244 74
					setScaler: Scaler 131 100 138 90
					normalize: 7
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer3First of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 860) ; WAVE
				(Load 140 861) ; WAVE
				(SetFlag 163)
				(gEgo
					view: 44551
					setLoop: 1
					setCel: 0
					posn: 225 74
					setCycle: CT 8 1 self
				)
			)
			(1
				(gEgo setCycle: CT 13 1 self)
				(mySound number: 860 setLoop: 1 play: self)
			)
			(2 0)
			(3
				(drawerRosView init:)
				(gEgo setCycle: End self)
			)
			(4
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 4 8 6 0 self) ; "(TALKING TO HERSELF)This looks promising."
			)
			(5
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo
					view: 44552
					setLoop: 2
					setCel: 0
					posn: 226 74
					setCycle: CT 10 1 self
				)
			)
			(6
				(gKqSound1 number: 929 setLoop: 1 play: self)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(pile init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 255 75 261 87 227 87 212 75
							yourself:
						)
				)
				(gEgo posn: 244 74 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer3Second of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 44553
					setLoop: 3
					setCel: 0
					posn: 227 74
					setCycle: CT 30 1 self
				)
			)
			(1
				(gKqSound1 number: 930 setLoop: 1 play: self)
			)
			(2
				(gEgo setCycle: CT 43 1 self)
			)
			(3
				(pile setLoop: 8 posn: 232 74)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo posn: 244 74 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer3Third of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 44554
					setLoop: 4
					setCel: 0
					posn: 222 75
					setCycle: CT 15 1 self
				)
			)
			(1
				(gKqSound1 number: 931 setLoop: 1 play: self)
			)
			(2
				(gEgo setCycle: CT 28 1 self)
			)
			(3
				(pile2 init: setCycle: End self)
				(gEgo setCycle: End self)
			)
			(4 0)
			(5
				(pile dispose:)
				(gEgo posn: 244 74 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer3Fourth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 44555
					setLoop: 5
					setCel: 0
					posn: 228 75
					setCycle: CT 16 1 self
				)
			)
			(1
				(gKqSound1 number: 932 setLoop: 1 play: self)
			)
			(2
				(gEgo setCycle: CT 23 1 self)
			)
			(3
				(pile init: setLoop: 10 setCel: 0 setCycle: End self)
				(gEgo setCycle: End self)
				(FrameOut)
			)
			(4 0)
			(5
				(pile2 dispose:)
				(gEgo posn: 244 74 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosDrawer3Fifth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 44556
					setLoop: 6
					setCel: 0
					posn: 232 74
					setCycle: CT 13 1 self
				)
			)
			(1
				((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
				(gMessager say: 0 0 7 0 self) ; "(AS A SCARAB, EXCITED)That's it! Take it, quickly!"
			)
			(2
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(gEgo setCycle: End self)
				(SetFlag 180)
				(gEgo get: 62) ; Device
			)
			(3
				(pile setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				(drawer1 setHotspot: 0)
				(drawer2 setHotspot: 0)
				(gEgo posn: 244 74 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPickClothesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 163)
				(gEgo
					view: 8534
					loop: 1
					cel: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					maxScale: 128
					posn: 251 82
					setPri: 79
					setCycle: End self
				)
			)
			(1
				(pile dispose:)
				(gEgo
					view: 4457
					loop: 0
					cel: 0
					posn: 227 82
					setCycle: CT 31 1 self
				)
			)
			(2
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					obstacles: 0
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 270 189 270 125 306 123 254 71 205 71 227 92 131 94 110 70 87 69 96 87 64 87 51 80 39 86 12 81 0 87 0 104 122 136 125 190
							yourself:
						)
				)
				(SetFlag 496)
				(sock init: setCycle: End self)
				(gEgo setCycle: End self)
			)
			(3 0)
			(4
				(gEgo loop: 2 cel: 0 posn: 218 75 setCycle: End self)
			)
			(5
				(gEgo view: 44551 loop: 1 posn: 226 74)
				(gEgo cel: (gEgo lastCel:) setCycle: CT 13 -1 self)
			)
			(6
				(drawerRosView dispose:)
				(gEgo setCycle: Beg self)
				(mySound number: 861 loop: 1 play: self)
			)
			(7 0)
			(8
				(gEgo
					posn: 237 76
					setScaler: Scaler 131 100 138 90
					normalize: 7
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetSock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 8534
					loop: 0
					cel: 0
					posn: 234 73
					setScaler: 0
					scaleX: 128
					scaleY: 128
					maxScale: 128
					setCycle: CT 10 1 self
				)
			)
			(1
				(ClearFlag 496)
				(sock dispose:)
				(gEgo
					view: 4458
					loop: 0
					cel: 0
					posn: 232 80
					setCycle: End self
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gMessager say: 5 8 0 0 self) ; "(THINKS TO HERSELF)This looks useful...not to mention UGLY!"
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(drawer1 setHotspot: 0)
				(drawer2 setHotspot: 0)
				(gEgo get: 61 setScaler: Scaler 131 100 138 90 normalize: 4) ; Woolen_Stocking
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRosLookTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 84 138 self)
			)
			(1
				(gEgo
					view: 4454
					setLoop: 3
					posn: 76 130
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
				(gEgo
					setScaler: Scaler 131 100 138 90
					normalize: 5
					posn: 84 138
				)
				(= cycles 2)
			)
			(3
				(gMessager sayRange: 3 8 6 1 3 self) ; "(WHISPERING)Psst! King Otar! What is all this stuff?"
			)
			(4
				(gEgo setMotion: MoveTo 114 123 self)
			)
			(5
				(gEgo setHeading: 90)
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance board of View
	(properties
		x 55
		y 83
		view 4450
	)
)

(instance dog of Actor
	(properties
		view 4462
		signal 16385
	)
)

(instance malicia of Actor
	(properties
		x 170
		y 200
		view 9060
	)
)

(instance fakeEgo of Actor
	(properties)

	(method (init)
		(self view: (gEgo view:) setScaler: Scaler 103 85 140 89)
		(super init:)
	)
)

(instance door of Prop
	(properties
		x 192
		y 40
		priority 90
		fixPriority 1
		view 4569
		loop 2
	)
)

(instance candles of Prop
	(properties
		x 208
		y 30
		view 4450
		loop 1
	)
)

(instance candles2 of Prop
	(properties
		x 18
		y 60
		view 4450
		loop 2
	)
)

(instance drawerView of Prop
	(properties
		x 225
		y 85
		priority 78
		fixPriority 1
		view 4474
	)
)

(instance drawerRosView of Prop
	(properties
		approachX 244
		approachY 74
		x 207
		y 58
		priority 20
		fixPriority 1
		view 4455
	)

	(method (init)
		(super init:)
		(if (< (OogaBooga underWearCntr:) 4)
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(drawer3 doVerb: theVerb)
	)
)

(instance bone of Prop
	(properties
		x 101
		y 68
		view 4473
		loop 1
	)
)

(instance otar of Prop
	(properties
		x 78
		y 100
		view 4454
	)
)

(instance pile of Prop
	(properties
		approachX 253
		approachY 81
		x 232
		y 74
		priority 80
		fixPriority 1
		view 4455
		loop 7
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(self setHotspot: 0)
			(gCurRoom setScript: sPickClothesUp)
		)
	)
)

(instance sock of Prop
	(properties
		approachX 234
		approachY 73
		x 221
		y 64
		view 4457
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sGetSock)
		)
	)
)

(instance pile2 of Prop
	(properties
		x 233
		y 74
		priority 80
		fixPriority 1
		view 4455
		loop 9
	)
)

(instance gargolye of Prop
	(properties
		x 142
		y 90
		view 4569
	)
)

(instance zap of Prop
	(properties
		view 44601
	)
)

(instance lamp of Feature
	(properties
		approachX 259
		approachY 137
		x 259
		y 200
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 80 278 67 284 64 284 61 290 55 294 48 301 47 295 55 304 63 304 65 308 70 308 80 296 84 298 123 305 136 279 135 290 102 290 84
					yourself:
				)
		)
	)

	(method (doVerb)
		(self setHotspot: 0)
		(gCurRoom setScript: sGetCrystal)
	)
)

(instance drawer1 of Feature
	(properties
		nsLeft 201
		nsTop 34
		nsRight 231
		nsBottom 40
		approachX 244
		approachY 74
		x 242
		y 72
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sRosDrawer1)
		)
	)
)

(instance drawer2 of Feature
	(properties
		nsLeft 201
		nsTop 42
		nsRight 231
		nsBottom 48
		approachX 244
		approachY 74
		x 243
		y 73
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sRosDrawer2)
		)
	)
)

(instance drawer3 of Feature
	(properties
		noun 4
		nsLeft 199
		nsTop 49
		nsRight 225
		nsBottom 54
		approachX 244
		approachY 74
		x 244
		y 74
	)

	(method (init)
		(super init:)
		(if (or (== gChapter 5) (< (OogaBooga underWearCntr:) 4))
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gChapter 4)
					(switch (= local2 (OogaBooga underWearCntr:))
						(0
							(SetFlag 163)
							(if (== gValOrRoz -3) ; Roz
								(gCurRoom setScript: sRosDrawer3First)
							else
								(self setHotspot: 0)
								(gMessager say: noun theVerb 12 0) ; "(THINKS TO HERSELF CATTILY)Tacky, tacky, tacky!"
							)
						)
						(1
							(SetFlag 163)
							(gCurRoom setScript: sRosDrawer3Second)
						)
						(2
							(SetFlag 163)
							(gCurRoom setScript: sRosDrawer3Third)
						)
						(3
							(SetFlag 163)
							(gCurRoom setScript: sRosDrawer3Fourth)
						)
						(else
							(SetFlag 163)
							(self setHotspot: 0)
							(drawerRosView setHotspot: 0)
							(gCurRoom setScript: sRosDrawer3Fifth)
						)
					)
					(OogaBooga underWearCntr: (++ local2))
				else
					(self setHotspot: 0)
					(gCurRoom setScript: sValOpenDrawer)
				)
			)
		)
	)
)

(instance bed of Feature
	(properties
		noun 1
		approachX 139
		approachY 98
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 89 207 88 213 0 113 0 113 64
					yourself:
				)
			approachVerbs: 8 10 ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(gCurRoom setScript: sValLookAtBed)
			)
		)
	)
)

(instance vanity of Feature
	(properties
		noun 2
		approachX 59
		approachY 89
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 24 74 68 80 87 80 88 41 69 57 60 55 49 26 35 19 22 40
					yourself:
				)
			approachVerbs: 8 10 ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(gCurRoom setScript: sLookVanity)
			)
		)
	)
)

(instance table of Feature
	(properties
		noun 3
		sightAngle 360
		approachX 98
		approachY 118
	)

	(method (init)
		(super init:)
		(if (== gValOrRoz -3) ; Roz
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 100 12 99 17 102 15 105 19 105 22 101 28 105 25 108 31 109 34 108 36 103 41 101 42 101 49 99 53 101 59 105 62 109 58 117 89 121 129 131 127 135 120 138 120 151 0 151
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setHotspot: 0)
				(gCurRoom setScript: sRosLookTable)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 125
		nsTop 129
		nsRight 282
		nsBottom 159
		sightAngle 360
		x 203
		y 159
		exitDir 3
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (malicia script:))
			(malicia setScript: 0)
			(getDownTimer dispose:)
		)
		(= approachX (gEgo x:))
		(= approachY (gEgo y:))
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(malTimer client: 0 delete: dispose:)
		(gCurRoom setScript: sFakeExit)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 10 setHotspot: 10 10) ; Exit, Exit, Exit, Exit
	)
)

(instance floorBoard of ExitFeature
	(properties
		y 110
		exitDir 3
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 92 120 92 120 80 48 80
					yourself:
				)
		)
		(if (== gValOrRoz -3) ; Roz
			(= approachX 124)
			(= approachY 89)
		else
			(= approachX 127)
			(= approachY 92)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(gUser canInput:)
					(self onMe: event)
					(event type:)
					local1
				)
				(event claimed: 1)
				(gCurRoom setScript: sBackUnder)
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
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					(local1
						(self sightAngle: 360)
						(gCurRoom setScript: sBackUnder)
					)
					((== gChapter 4)
						(gCurRoom setScript: sRosStartUnder)
					)
					(else
						(gCurRoom setScript: sValStartUnder)
					)
				)
			)
		)
	)
)

(instance getDownTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (not (gCurRoom script:))
					(if (== gValOrRoz -4) ; Val
						(gCurRoom setScript: maliciaZapVal)
					else
						(gCurRoom setScript: maliciaZapRos)
					)
				else
					(= local3 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance malTimer of Timer
	(properties)

	(method (cue)
		(cond
			((or (gEgo script:) (gCurRoom script:) (!= gCurRoomNum 4450))
				(self setReal: self 10)
			)
			((and (> gCurRoomNum 1000) (not (IsFlag 561)))
				(gCurRoom setScript: sMalComeHome)
				(self client: 0 delete: dispose:)
			)
			(else
				(self client: 0 dispose: delete:)
			)
		)
	)
)

(instance fakeExit of Inset
	(properties
		picture 4553
		priority 500
	)
)

(instance mySound of Sound
	(properties)
)

