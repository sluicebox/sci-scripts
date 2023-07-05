;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1100 0
	ratTalker 1
)

(local
	local0
	local1 = 911
	local2 = 911
	local3 = 826
	local4
	local5 = 3
	local6
	local7
)

(instance rm1100 of KQRoom
	(properties
		picture 1101
		screen_mid 1150
		screen_right 1200
	)

	(method (init)
		(super init:)
		(= eastSide 890)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 894 84 871 99 847 95 833 82 784 77 768 80 770 85 768 93 750 96 707 86 707 90 752 105 731 117 667 102 630 110 578 92 570 72 554 67 540 68 550 81 541 99 462 118 440 112 422 98 377 98 367 90 326 91 326 81 296 81 292 84 278 95 206 97 196 85 215 68 195 66 182 74 179 83 180 99 170 111 107 111 27 120 3 114 4 158 954 156 957 126 908 117 927 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 292 109 319 105 342 114 345 127 336 132 308 132 289 123
					yourself:
				)
		)
		(Load rsMESSAGE 1100)
		(SetFlag 21)
		(eSouth init:)
		(eWest init:)
		(eEast init:)
		(if (and (IsFlag 43) (== gChapter 1))
			(cornPlant init:)
		)
		(leftDrip init:)
		(rightDrip init:)
		(Load 140 911) ; WAVE
		(Load 140 912) ; WAVE
		(Load 140 913) ; WAVE
		(if (and (IsFlag 43) (IsFlag 329))
			(bustedGourd init:)
		)
		(door init:)
		(cave init:)
		(if (== gChapter 1)
			(theSign init:)
		)
		(if (not (IsFlag 203))
			(hole init:)
		)
		(if (== gChapter 1)
			(glyphs init:)
		)
		(if (not (IsFlag 13))
			(head init:)
		)
		(if (and (not (IsFlag 315)) (== gChapter 1))
			(sandTracks init:)
		)
		(if
			(and
				(== gChapter 1)
				(not (IsFlag 42))
				(not (gCast contains: bustedGourd))
			)
			(gourd init:)
		)
		(if (and (not (IsFlag 43)) (== gValOrRoz -4)) ; Val
			(wetSand init:)
		)
		(if (IsFlag 13)
			(colossusExit init:)
		)
		(if (not (IsFlag 29))
			(cond
				((IsFlag 314)
					(pear cel: 9 approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
				)
				((<= gChapter 3)
					(prickly init:)
				)
			)
			(pear init:)
		)
		(if (not (IsFlag 304))
			(colDoor init:)
		)
		(if (IsFlag 7)
			(if
				(and
					(== ((gInventory at: 10) owner:) 1100) ; Jackalope_Fur
					(not (IsFlag 218))
					(not (gEgo has: 10)) ; Jackalope_Fur
				)
				(hair init:)
			)
			(if (and (not (IsFlag 6)) (not (gEgo has: 9))) ; Glasses
				(specs init:)
			)
		)
		(gEgo init: normalize:)
		(switch gPrevRoomNum
			(1250
				(cond
					((< (gEgo x:) 320)
						(self setRect: 0 0 959 136)
						(gEgo posn: 156 140)
					)
					((< (gEgo x:) 640)
						(self setRect: -318 0 640 136)
						(gEgo posn: 480 140)
					)
					(else
						(self setRect: 64897 0 319 136)
						(gEgo posn: 800 140)
					)
				)
				(gCurRoom setScript: enterFromBottom)
			)
			(1500
				(cond
					((and (== global312 0) (== global313 1))
						(self setRect: 0 0 959 136)
						(gEgo posn: 0 120)
					)
					((and (== global312 0) (== global313 3))
						(self setRect: 64897 0 319 136)
						(gEgo posn: 960 132)
					)
				)
				(gCurRoom setScript: enterFromDesert)
			)
			(1105
				(self setRect: 0 0 959 136)
				(gEgo posn: 170 121)
				(if (and (IsFlag 13) (not (IsFlag 304)))
					(gCurRoom setScript: colossusDoorOpen)
				else
					(gGame handsOn:)
				)
			)
			(1050
				(self setRect: -318 0 640 136)
				(gEgo posn: 566 77 setHeading: 135)
				(gGame handsOn:)
			)
			(1160
				(self setRect: -318 0 640 136)
				(gEgo posn: 420 125)
			)
			(1190
				(self setRect: -318 0 640 136)
				(gEgo posn: 380 109)
			)
			(1155
				(self setRect: -318 0 640 136)
				(gEgo
					posn: (glyphs approachX:) (glyphs approachY:)
					setScript: lookedAtGlyphs
				)
			)
			(1210
				(self setRect: 64897 0 319 136)
				(gEgo posn: 883 105)
			)
			(1000
				(self setRect: 0 0 959 136)
				(gEgo posn: 118 95)
				(self setScript: fromColossus)
			)
			(else
				(self setRect: 64897 0 319 136)
				(gEgo posn: 800 105)
				(gGame handsOn:)
			)
		)
		(if (or (== gPrevRoomNum 1000) (== gPrevRoomNum 1050) (== gPrevRoomNum 26))
			(ClearFlag 48)
			(gKqMusic1
				number: 1320
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(IsFlag 32)
				(not script)
				(not (gEgo script:))
				(== (jackTimer seconds:) -1)
				(> (gEgo x:) 750)
				(<= (gEgo distanceTo: hole) 40)
			)
			(if (IsFlag 203)
				(gEgo setScript: depressedJack)
			else
				(gEgo setScript: randomJack)
			)
		)
	)

	(method (dispose)
		(jackTimer client: 0 delete: dispose:)
		(ratTimer client: 0 delete: dispose:)
		(if (== (gEgo script:) changeSong)
			(changeSong dispose:)
		)
		(if (or (== gNewRoomNum 1000) (== gNewRoomNum 1050) (== gNewRoomNum 26))
			(gKqMusic1 fade:)
		)
		(if (and local7 (not (IsFlag 41)))
			(SetFlag 329)
		)
		(DisposeScript 64939)
		(DisposeScript 64938)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (ratTimer seconds:))
			(ratTimer cue:)
			(event claimed: 1)
		)
		(super handleEvent: event)
	)
)

(instance getHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo
						posn: 659 107
						view: 8071
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				else
					(gEgo
						posn: 668 107
						view: 8431
						setLoop: 0
						setCel: 0
						setCycle: CT 6 1 self
					)
				)
			)
			(1
				(hair dispose:)
				(if (== gValOrRoz -4) ; Val
					(gEgo get: 10 setCycle: Beg self) ; Jackalope_Fur
				else
					(gEgo get: 10 setCycle: End self) ; Jackalope_Fur
				)
			)
			(2
				(if (== gValOrRoz -4) ; Val
					(gEgo posn: 662 107 normalize: 0)
				else
					(gEgo posn: 667 107 normalize: 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bendToGetSpecs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 8061)
				else
					(gEgo view: 8421)
				)
				(gEgo posn: 750 122 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(specs dispose:)
				(gEgo get: 9 setCycle: Beg self) ; Glasses
			)
			(2
				(gEgo normalize: setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance colossusDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(colDoor setLoop: 0 setCel: 0 cycleSpeed: 14 setCycle: End self)
				(gKqSound1 number: 1107 play:)
			)
			(1
				(SetFlag 304)
				(colDoor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance swingStick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1008) ; WAVE
				(Load 140 1007) ; WAVE
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 1101
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(1
				(gKqSound1 number: 1007 setLoop: 1 play:)
				(gEgo setCel: 4 setCycle: End)
				(pear
					approachVerbs: 8 10 ; Do, Exit
					setHotspot: 8 10 ; Do, Exit
					setCycle: CT 5 1 self
				)
				(SetFlag 314)
			)
			(2
				(gKqSound1 number: 1008 setLoop: 1 play:)
				(pear setCel: 6 setCycle: End self)
			)
			(3
				(gEgo normalize: 1 cycleSpeed: register)
				(prickly dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getPear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 284 self)
			)
			(1
				(gEgo view: 8061 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(pear dispose:)
				(SetFlag 29)
				(gEgo get: 20 setCycle: Beg self) ; Prickly_Pear
			)
			(3
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterCave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				(gEgo
					setPri: 43
					setScaler: Scaler 100 66 65 50
					setMotion: MoveTo 504 50 self
				)
			)
			(2
				(gEgo setPri: -1)
				(gCurRoom newRoom: 1050)
			)
		)
	)
)

(instance enterColossus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self cue:)
			)
			(1
				(gEgo
					setPri: 70
					setScaler: Scaler 100 67 120 50
					setMotion: MoveTo 110 99 self
				)
			)
			(2
				(gCurRoom newRoom: 1000)
			)
		)
	)
)

(instance fromColossus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(if (IsFlag 127)
						(gEgo view: 800)
					else
						(gEgo view: 801)
					)
				)
				(gEgo setPri: 70 setMotion: PolyPath 170 121 self)
			)
			(1
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
			)
			(1
				(gCurRoom newRoom: 1250)
			)
		)
	)
)

(instance walkEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 990 130 self)
			)
			(1
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -13 121 self)
			)
			(1
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance touchPrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8075)
				(Load rsSOUND 832)
				(gEgo setHeading: 23 self)
			)
			(1
				(gEgo
					posn: 214 101
					view: 8075
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gKqSound1 number: 832 setLoop: 1 play: self)
				(gMessager say: 11 8 17 0) ; "Ow!"
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo posn: 214 103 normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance touchPear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8075)
				(gEgo setHeading: 23 self)
			)
			(1
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gEgo
					posn: 214 101
					view: 8075
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 12 8 18 1) ; "Ouch!"
				(gKqSound1 number: 832 setLoop: 1 play: self)
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo posn: 214 103 normalize: 6)
				(= cycles 2)
			)
			(5
				(gMessager say: 12 8 18 2 self) ; "Blast. I can't reach it."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance inspectGlyphs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 8295)
				else
					(gEgo view: 8645)
				)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(1
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(2
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gCurRoom newRoom: 1155)
			)
		)
	)
)

(instance lookedAtGlyphs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 8295)
				else
					(gEgo view: 8645)
				)
				(gEgo setLoop: 0 setCel: 8 setCycle: Beg self)
			)
			(1
				(gEgo normalize: setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getGourdSeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 42)
				(gMessager say: 7 8 12 0 self) ; "How strange. The gourd split in the sun. It looks like there's a loose seed in there."
			)
			(1
				(gEgo view: 8065 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo get: 6) ; Gourd_Seed
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

(instance lookAtWetSand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 411 101 self)
			)
			(1
				(gEgo view: 8173 setLoop: 0 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gMessager say: 5 8 0 0 self) ; "This sand is damp. How strange."
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(4
				(SetFlag 301)
				(gEgo normalize: 3 setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance plantCornSeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 397 99 self)
				(Load rsVIEW 1150)
				(Load rsVIEW 8065)
				(Load 140 824) ; WAVE
				(Load rsSOUND 831)
			)
			(1
				(gEgo
					view: 8065
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: Osc 1 self
				)
			)
			(2
				(gEgo normalize: 6 put: 14) ; Corn_Kernel
				(cornPlant init: cycleSpeed: 13 setCycle: End self)
				(gKqSound1 number: 831 play:)
			)
			(3
				(cornPlant setLoop: 1 setCycle: End self)
				(gKqSound1 number: 824 play:)
			)
			(4
				(SetFlag 43)
				(gMessager say: 5 24 0 0 self) ; "Oh...my..."
			)
			(5
				(wetSand dispose:)
				(= local7 1)
				(gGame handsOn:)
				(self dispose:)
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
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 1201)
				else
					((ScriptID 7001 0) client: door hide_mouth: 1) ; kingTalker
					(gEgo view: 1210)
				)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
				(if (not (IsFlag 32))
					(Load 140 1207) ; WAVE
					(Load 140 1211) ; WAVE
				)
				(Load rsVIEW 1200)
			)
			(1
				(= local5 3)
				(gEgo setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(if (not (-- local5))
					(++ state)
				)
				(gEgo cel: 5)
				(gKqSound1 number: 808 setLoop: 1 play: self)
			)
			(3
				(gEgo cel: 4)
				(-= state 2)
				(= cycles 20)
			)
			(4
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setScript: changeSong 0 1205)
				(if (IsFlag 203)
					(gMessager say: 1 8 24 0 self) ; "(FRIGHTENED, FROM BEHIND THE DOOR)The shop is closed! You'd better go! The volcano is about to blow!"
				else
					(rat init:)
					(if (IsFlag 6)
						(rat view: 1202 loop: 3 cel: 15 setCycle: Beg self)
					else
						(rat view: 1200 loop: 1 cel: 0 setCycle: CT 7 1 self)
					)
					(door hide:)
				)
			)
			(6
				(cond
					((IsFlag 203)
						(gCurRoom setScript: egoStands)
					)
					((IsFlag 6)
						(self cue:)
					)
					(else
						(rat setCel: 8)
						(gKqSound1 number: 5401 setLoop: 1 play: self)
					)
				)
			)
			(7
				(if (IsFlag 6)
					(self cue:)
				else
					(rat setCycle: CT 10 1 self)
				)
			)
			(8
				(if (IsFlag 6)
					(self cue:)
				else
					(rat setCycle: End self)
					(gKqSound1 number: 5401 setLoop: 1 play:)
				)
			)
			(9
				(Load 140 802) ; WAVE
				(cond
					((gEgo has: 9) ; Glasses
						(gMessager say: 1 8 2 0 self) ; "This is all I have to say! Go away! Go away!"
					)
					((IsFlag 6)
						(gMessager say: 1 8 3 0 self) ; "Would you like to trade with me? You won't believe what you will see!"
					)
					(else
						(gMessager say: 1 8 1 0 self) ; "Who can that be? I cannot see!"
					)
				)
			)
			(10
				(gCurRoom setScript: ratTimerScript)
			)
		)
	)
)

(instance ratTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 19 1) nsBottom: 0) ; westFeat
				((ScriptID 19 0) nsBottom: 0) ; eastFeat
				(eSouth nsRight: 0)
				(for ((= local0 0)) (< local0 (global123 size:)) ((++ local0))
					(tempHotCast add: (global123 at: local0))
				)
				(global123 release:)
				(global123 add: rat)
				(if (== register 58)
					(self cue:)
				else
					(gGame handsOn:)
					(if (not (IsFlag 32))
						(ratTimer setReal: ratTimer 6)
					else
						(ratTimer setReal: ratTimer 30)
					)
				)
			)
			(1
				(if (or script (KQTalker dialog:))
					(-- state)
					(ratTimer setReal: ratTimer 10)
				else
					(gGame handsOff:)
					(ratTimer client: 0 dispose: delete:)
					(global123 release:)
					(for
						((= local0 0))
						(< local0 (tempHotCast size:))
						((++ local0))
						
						(global123 add: (tempHotCast at: local0))
					)
					(rat setHotspot:)
					((ScriptID 19 1) nsBottom: 140) ; westFeat
					((ScriptID 19 0) nsBottom: 140) ; eastFeat
					(eSouth nsRight: 950)
					(= cycles 1)
				)
			)
			(2
				(gCurRoom setScript: ratGoesAway)
			)
		)
	)
)

(instance ratGoesAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 802) ; WAVE
				(= cycles 1)
			)
			(1
				(door hide:)
				(if (IsFlag 6)
					(rat view: 1202 cel: 0 loop: 1 setCycle: CT 5 1 self)
				else
					(rat view: 1200 cel: 0 loop: 2 setCycle: End self)
				)
			)
			(2
				(gKqSound1 number: 802 play: self)
				(if (IsFlag 6)
					(rat setCycle: End)
				)
			)
			(3
				(UnLoad 140 802)
				(UnLoad 128 1202)
				(rat dispose:)
				(door
					show:
					view: 1200
					loop: 0
					cel: 0
					x: 919
					y: 84
					setHotspot: 8 10 ; Do, Exit
				)
				(= cycles 1)
			)
			(4
				(if
					(and
						(not (IsFlag 6))
						(not (IsFlag 32))
						(not (IsFlag 4))
					)
					(SetFlag 32)
					(if (not (IsFlag 7))
						(hole addRespondVerb: 18) ; Hunting_Horn
					)
					(gGame handsOn:)
					(gCurRoom setScript: rudeToon)
				else
					(SetFlag 32)
					(if (not (IsFlag 7))
						(hole addRespondVerb: 18) ; Hunting_Horn
					)
					(gCurRoom setScript: egoStands)
				)
			)
		)
	)
)

(instance egoStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 1201)
				else
					((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
					(gEgo view: 1210)
				)
				(gEgo setLoop: 0 setCel: 10 setCycle: Beg self)
			)
			(1
				(gEgo normalize: 0 setScript: changeSong 0 1320)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveGlasses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 9) ; Glasses
				(SetFlag 6)
				(gMessager say: 2 19 0 1 self) ; "Here you are."
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(rat view: 1202 setLoop: 2 setCel: 12 setCycle: Beg self)
				(door
					view: 1202
					setLoop: 5
					cel: 1
					setPri: 75
					posn: 916 73
					show:
					setHotspot:
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 2 cel: 3 setCycle: End self)
			)
			(4 0)
			(5
				(gMessager say: 2 19 0 2 self) ; "Oh joy! Oh joy! Oh happy me! I can see! I can see! Thanks to you, I'm not afraid. Now I'm free to deal and trade."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exchangeSomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 58)
					(gMessager say: 2 register 0 0 self) ; "Aha! You offer me a book! I'll get my finest shepherd's crook!"
				else
					(gMessager say: 2 register 6 0 self)
				)
			)
			(1
				(door
					view: 1202
					setLoop: 5
					cel: 1
					setPri: 75
					posn: 919 73
					show:
					setHotspot:
				)
				(rat setLoop: 4 cel: 7 setCycle: Beg self)
				(gEgo setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2 0)
			(3
				(gEgo setCycle: Beg self)
				(rat setCycle: End self)
			)
			(4 0)
			(5
				(cond
					((== register 15)
						(gEgo get: 11 put: 6) ; Turquoise_Bead, Gourd_Seed
					)
					((== register 24)
						(gEgo get: 11 put: 14) ; Turquoise_Bead, Corn_Kernel
					)
					((== register 58)
						(gEgo get: 39 put: 45) ; Crook, Book
					)
				)
				(gEgo setLoop: 2 cel: 3 setCycle: End self)
			)
			(6
				(door hide:)
				(rat setLoop: 3 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1205)
				(Load 140 1209) ; WAVE
				(if (IsFlag 325)
					(Load rsSOUND 817)
					(Load 140 1213) ; WAVE
					(Load 140 824) ; WAVE
					(Load 140 1210) ; WAVE
				else
					(Load 140 1215) ; WAVE
				)
				(= register (gEgo cycleSpeed:))
				(gEgo setHeading: 270 self)
			)
			(1
				(if (IsFlag 325)
					(gMessager say: 4 18 0 1 self) ; "Here it comes, you little fiend!"
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 1205
					setLoop: 0
					setCel: 0
					posn: 743 113
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(3
				(if (not (IsFlag 325))
					(gMessager say: 2 18 1 0 self 800) ; "Oh Dear, the horn is clogged with sand."
				else
					(self cue:)
				)
			)
			(4
				(gEgo setLoop: 2 setCel: 0 setCycle: CT 1 1 self)
			)
			(5
				(gKqSound1 number: 1209 setLoop: 1 play: self)
			)
			(6
				(if (IsFlag 325)
					(gEgo setCel: 2 setCycle: CT 4 1 self)
				else
					(gEgo view: 1206 setLoop: 0 setCel: 0 setCycle: End)
					(= ticks 60)
				)
			)
			(7
				(if (IsFlag 325)
					(Load rsSOUND 817)
					(Load 140 1212) ; WAVE
					(Load 140 830) ; WAVE
					(gKqSound1 number: 1210 play: self)
				else
					(gKqSound1 number: 1215 play: self)
				)
			)
			(8
				(if (IsFlag 325)
					(gEgo
						view: 1205
						setLoop: 0
						setCel: 12
						cycleSpeed: 11
						setCycle: Beg
					)
					(self cue:)
				else
					(gEgo
						view: 1205
						setLoop: 0
						setCel: 12
						cycleSpeed: 11
						setCycle: Beg self
					)
				)
			)
			(9
				(if (IsFlag 325)
					(SetFlag 4)
					(self setScript: useCleanedOutHorn self register)
				else
					(SetFlag 325)
					(= cycles 1)
				)
			)
			(10
				(gEgo normalize: 1 posn: 748 113 cycleSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useCleanedOutHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 337)
				(jack
					view: 1207
					setLoop: 0
					setCel: 0
					posn: 697 95
					init:
					setPri: 110
					setCycle: CT 2 1 self
				)
				(gMessager say: 4 18 0 2) ; "AIEEEEEEEEEE!"
			)
			(1
				((gInventory at: 10) owner: 1100) ; Jackalope_Fur
				(hair init:)
				(gKqSound1 number: 830 setLoop: 1 play: self)
				(jack setCel: 3 setCycle: End self)
			)
			(2 0)
			(3
				(specs init:)
				(jack dispose:)
				(soundFX number: 1212 play: self)
				(gEgo normalize: 1 posn: 748 113)
			)
			(4
				(gMessager say: 4 18 0 3 self) ; "Ha ha! I got you, didn't I?"
			)
			(5
				(hole setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance lookInHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8271)
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo view: 8271 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gKqSound1 number: 896 setLoop: 1 play: self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1204)
				(gEgo view: 1204 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(gEgo setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gMessager say: 4 8 10 1 self) ; "...Hello?"
			)
			(3
				(gEgo setCycle: CT 7 1 self)
			)
			(4
				(Load rsSOUND 817)
				(jack
					posn: 699 95
					init:
					view: 1204
					setLoop: 0
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(5
				(gMessager say: 4 8 10 2 self) ; "BOO!"
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(6
				(jack cel: 10 setCycle: End)
				(gMessager say: 4 8 10 3) ; "EEK!"
				(gEgo cycleSpeed: 4 setCycle: CT 18 1 self)
			)
			(7
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gKqSound1 number: 817 setLoop: 1 play:)
				(gEgo cycleSpeed: 6 setCycle: End self)
			)
			(8
				(gEgo normalize: 1)
				(jack setCycle: ROsc -1 4 9)
				(gMessager say: 4 8 10 4 self) ; "Eeeheeheeheehee!"
			)
			(9
				(jack setCycle: Beg self)
			)
			(10
				(jack dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance changeSong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND register)
				(gKqMusic1 fade: 0 5 20 0 self)
			)
			(1
				(gKqMusic1 number: register setLoop: -1 play: fade: 127 25 10 0)
				(gKqMusic1 client: 0)
				(self dispose:)
			)
		)
	)
)

(instance rudeToon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						view: 1203
						setLoop: 1
						setCel: 0
						posn: 788 106
						setCycle: CT 11 1
					)
					(jack
						view: 1203
						init:
						posn: 788 106
						setLoop: 0
						setCel: 0
						cycleSpeed: 12
						setCycle: End self
					)
					(gKqSound1 number: 1211 setLoop: 1 play:)
				)
				(1
					(gKqSound1 stop:)
					(gEgo cel: 10)
					(jack setCel: 0 setLoop: 2 setCycle: End self)
				)
				(2
					(Load 140 1315) ; WAVE
					(gEgo cel: 9)
					(jack
						posn: 827 106
						setCel: 0
						setLoop: 3
						setCycle: CT 4 1 self
					)
				)
				(3
					(gEgo setCel: 8 setCycle: CT 11 1 self)
				)
				(4
					(gKqSound1 number: 1315 setLoop: 1 play:)
					(jack setLoop: 3 setCycle: CT 9 1 self)
				)
				(5
					(jack setCel: 9 setCycle: CT 11 1 self)
				)
				(6
					(jack setCel: 12 setCycle: End self)
					(= register (gEgo cycleSpeed:))
				)
				(7
					(gKqSound1 number: 1207 setLoop: -1 play:)
					(gEgo cycleSpeed: 10 setCel: 12 setCycle: CT 18 1 self)
					(jack hide:)
				)
				(8
					(gKqSound1 stop:)
					(Load 140 825) ; WAVE
					(jack
						show:
						posn: 788 106
						setCel: 0
						setLoop: 4
						setCycle: End self
					)
					(gEgo setCel: 19 cycleSpeed: register setCycle: End)
				)
				(9
					(gKqSound1 number: 825 setLoop: 1 play: self)
				)
				(10
					(jack hide:)
					(gMessager say: 0 0 4 2 self) ; "Of all the rude, incosiderate--"
				)
				(11
					(jack show: setLoop: 5 setCel: 0 setCycle: CT 3 1 self)
				)
				(12
					(gMessager say: 0 0 4 3 self) ; "Pthpthpthpth!"
					(jack
						setLoop: 5
						setCel: 4
						cycleSpeed: 3
						setCycle: ROsc -1 4 5
					)
				)
				(13
					(jack cycleSpeed: 6 setCel: 6 setCycle: End self)
				)
				(14
					(jack dispose:)
					(gEgo cel: 7 setCycle: Beg self)
				)
				(15
					(gEgo
						posn: 895 100
						view: 1201
						setLoop: 0
						setCel: 10
						setCycle: Beg self
					)
				)
				(16
					(gEgo
						normalize:
						setScript: changeSong 0 1320
						setHeading: 180 self
					)
				)
				(17
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(jack dispose:)
					(gEgo
						posn: 895 100
						normalize:
						setScript: changeSong 0 1320
						setHeading: 180
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance jackJumpAndLaugh of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jack setLoop: 3 setCycle: CT 9 1 self)
			)
			(1
				(gMessager say: 0 0 4 1 self) ; "Eeeheeheeheehee!"
				(jack setCycle: ROsc -1 9 11)
			)
			(2
				(jack setCel: 11 setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance randomJack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= temp0 (GetAngle (gEgo x:) (gEgo y:) 698 89))
				(gEgo setHeading: temp0)
				(cond
					((>= local3 840)
						(= local3 826)
					)
					((== local3 830)
						(= local3 840)
					)
				)
				(Load 140 local3) ; WAVE
				(jack
					init:
					posn: 754 96
					view: (if (== gValOrRoz -4) 1203 else 1212) ; Val
					setCel: 0
					setLoop:
						(if
							(and
								(not (IsFlag 7))
								(not (gEgo has: 9)) ; Glasses
								(not (IsFlag 6))
							)
							5
						else
							6
						)
					cycleSpeed: 14
					setCycle: CT 3 1 self
				)
			)
			(1
				(jack setCel: 4 setCycle: End self)
				(gKqSound1 number: local3 play:)
			)
			(2
				(jack dispose:)
				(if (== gValOrRoz -4) ; Val
					(gEgo view: 8311 cycleSpeed: 13)
				else
					(gEgo view: 8661 cycleSpeed: 11)
				)
				(gEgo setLoop: 1 setCel: 0 setCycle: Osc 1 self)
				(gKqSound1 number: 896 setLoop: 1 play:)
			)
			(3
				(gEgo normalize: 1)
				(++ local3)
				(jackTimer setReal: jackTimer 40)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance depressedJack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= temp0 (GetAngle (gEgo x:) (gEgo y:) 698 89))
				(gEgo setHeading: temp0)
				(jack
					init:
					posn: 700 97
					view: 1211
					setLoop: 0
					setCel: 0
					cycleSpeed: 13
					setCycle: CT 5 1 self
				)
			)
			(1
				(jack setCel: 5 setCycle: End self)
				(gKqSound1 number: 1219 setLoop: 1 play:)
			)
			(2
				(jack dispose:)
				(gEgo normalize: 1)
				(jackTimer setReal: jackTimer 40)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickCorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8073)
				(self cue:)
			)
			(1
				(gMessager say: 6 8 0 1 self) ; "Oh, what a beauty!"
			)
			(2
				(gEgo view: 8073 setLoop: 0 setCel: 0 setCycle: Osc 1 self)
			)
			(3
				(gEgo normalize: get: 19 setHeading: 180 self) ; Ear_of_Corn
			)
			(4
				(SetFlag 16)
				(cornPlant setHotspot: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTracks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 315)
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo view: 8291 setLoop: 1 setCel: 0 setCycle: End self)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			)
			(2
				(gMessager say: 1 8 3 0 self 1250) ; "Hmmm."
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromDesert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((and (== global312 0) (== global313 1))
						(gEgo setMotion: MoveTo 80 120 self)
					)
					((and (== global312 0) (== global313 3))
						(gEgo setMotion: MoveTo 900 132 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (gEgo x:) 320)
						(gEgo setMotion: MoveTo 156 125 self)
					)
					((< (gEgo x:) 640)
						(gEgo setMotion: MoveTo 480 125 self)
					)
					(else
						(gEgo setMotion: MoveTo 800 125 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leftDripIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< 529 (gThePlane right:) 865) (Random 0 1))
					(leftDrip show: setCel: 0 setCycle: End self)
				else
					(self changeState: 2)
				)
			)
			(1
				(if (> local1 913)
					(= local1 911)
					(soundFX number: 911 setLoop: 1 play: self)
				else
					(soundFX number: local1 setLoop: 1 play: self)
					(++ local1)
				)
				(leftDrip hide:)
			)
			(2
				(= ticks 60)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance rightDripIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< 529 (gThePlane right:) 865) (Random 0 2))
					(rightDrip show: setCel: 0 setCycle: End self)
				else
					(self changeState: 2)
				)
			)
			(1
				(if (> local2 913)
					(= local2 911)
					(soundFX number: 911 setLoop: 1 play: self)
				else
					(soundFX number: local2 setLoop: 1 play: self)
					(++ local2)
				)
				(rightDrip hide:)
			)
			(2
				(= ticks 60)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance jack of Actor
	(properties
		x 788
		y 106
		view 1203
	)
)

(instance colDoor of Prop
	(properties
		noun 8
		approachX 170
		approachY 121
		x 142
		y 107
		view 1100
		loop 1
	)

	(method (init)
		(super init:)
		(cond
			((and (IsFlag 39) (not (IsFlag 40)))
				(self setLoop: 3 setCel: 0)
			)
			((and (not (IsFlag 39)) (IsFlag 40))
				(self setLoop: 3 setCel: 1)
			)
		)
	)
)

(instance cornPlant of Prop
	(properties
		sightAngle 20
		approachX 417
		approachY 103
		x 417
		y 92
		view 1150
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 43)
			(self setLoop: 1 cel: 24)
		)
		(if (not (IsFlag 16))
			(self
				approachVerbs: 8 10 ; Do, Exit
				setHotspot: 8 10 ; Do, Exit
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 415 63 420 51 431 53 425 63 416 72
						yourself:
					)
			)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: pickCorn)
	)
)

(instance rat of Prop
	(properties
		noun 2
		sightAngle 360
		x 919
		y 84
		view 1208
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 9998)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (IsFlag 6)
			(cond
				((OneOf theVerb 43 25 68 88 37) ; Lantern, Rope, Defoliant, Golden_Grape, Silver_Pellet
					(if (== gValOrRoz -4) ; Val
						(gMessager say: noun 30 5 2) ; "No, that's all right."
					else
						(gMessager say: noun 79 0 2) ; "No, that's okay."
					)
					(return 1)
				)
				((OneOf theVerb 17 16 30 28 18 6 12 26 20 22 23 27 11 53) ; Basket, Turquoise_Bead, Ear_of_Corn, Fresh_Water, Hunting_Horn, Ripped_Petticoat, Clay_Pot, Bug_Reducing_Powder, Turquoise_Piece_a, Turquoise_Piece_b, Puzzle, Salt_Water, Stick, Turquoise_Shape
					(gMessager say: noun theVerb 5 0)
					(return 1)
				)
				(
					(OneOf
						theVerb
						55 ; Feather
						60 ; Rubber_Chicken
						72 ; Were-beast_Salve
						21 ; Jackalope_Fur
						52 ; Crook
						54 ; Nectar_in_Pot
						59 ; Wooden_Nickel
						57 ; Mask
						61 ; Magic_Statue
						13 ; Flag
						50 ; Prickly_Pear
						56 ; China_Bird
						46 ; Hammer_and_Chisel
						69 ; Magic_Wand
						74 ; Scarab
						75 ; Shovel
						77 ; Extra_Life
						80 ; Fragrant_Flower
						85 ; Device
						84 ; Woolen_Stocking
						90 ; Femur
						79 ; Foot-In-A-Bag
						94 ; Horseman_s_Fife
						93 ; Horseman_s_Head
						89 ; Horseman_s_Medal
						71 ; Moon
					)
					(gMessager say: noun theVerb 0 0)
					(return 1)
				)
			)
		)
		(if (and (not (IsFlag 6)) (not (OneOf theVerb 8 19))) ; Do, Glasses
			(if (gEgo has: 9) ; Glasses
				(gMessager say: noun 8 2 0) ; "Leave me be! I cannot see!"
			else
				(gMessager say: 1 8 1 0) ; "Who can that be? I cannot see!"
			)
			(return 1)
		)
		(switch theVerb
			(8 ; Do
				(cond
					(
						(or
							(gEgo has: 9) ; Glasses
							(and (not (IsFlag 6)) (IsFlag 321))
						)
						(gMessager say: noun theVerb 2 0 ratTimerScript) ; "Leave me be! I cannot see!"
					)
					((not (IsFlag 6))
						(SetFlag 321)
						(gMessager say: noun theVerb 1 0) ; "I am Valanice of Daventry, good sir. Is there a problem with your eyes?"
					)
					((and (not (IsFlag 6)) (IsFlag 321))
						(gMessager say: noun theVerb 1 0 ratTimerScript) ; "I am Valanice of Daventry, good sir. Is there a problem with your eyes?"
					)
					((== gChapter 3)
						(gMessager say: noun theVerb 19 0) ; "I have no time for idle chat. I'm a strictly business rat!"
					)
					((== gChapter 4)
						(gMessager say: noun theVerb 22 0) ; "I've no time for idle chat. I'm a strictly business rat!"
					)
					(else
						(gMessager say: noun 0 5 0) ; "No time to chat, the day is fading. Come, Valanice, let's do some trading."
					)
				)
				(return 1)
			)
			(19 ; Glasses
				(ratTimerScript setScript: giveGlasses)
				(return 1)
			)
			(15 ; Gourd_Seed
				(if (IsFlag 14)
					(gMessager say: noun 24 7 0) ; "Yet another yellow seed? I cannot trade. You have my bead."
				else
					(SetFlag 14)
					(ratTimerScript setScript: exchangeSomething 0 theVerb)
				)
			)
			(24 ; Corn_Kernel
				(if (IsFlag 14)
					(gMessager say: noun theVerb 7 0) ; "Yet another yellow seed? I cannot trade. You have my bead."
				else
					(SetFlag 14)
					(SetFlag 41)
					(if (not (IsFlag 43))
						(SetFlag 84)
					)
					(ratTimerScript setScript: exchangeSomething 0 theVerb)
				)
			)
			(58 ; Book
				(ratTimerScript
					setScript: exchangeSomething ratTimerScript theVerb
				)
			)
			(5 ; Golden_Comb
				(cond
					((and (IsFlag 6) (not (IsFlag 328)))
						(gMessager say: noun theVerb 8 0) ; "The lovely lady shows me gold! How would you like some fine blue mold?"
						(SetFlag 328)
					)
					((IsFlag 328)
						(gMessager say: noun 0 5 0) ; "No time to chat, the day is fading. Come, Valanice, let's do some trading."
					)
				)
			)
			(51 ; Salt_Crystals
				(if (== gValOrRoz -4) ; Val
					(gMessager say: noun theVerb 28 0) ; "Mmm! A tasty grain of salt! Will you take a chocolate malt?"
				else
					(gMessager say: noun theVerb 27 0) ; "What a perfect grain of salt! How about a chocolate malt?"
				)
			)
			(else
				(if (IsFlag 6)
					(gMessager say: noun theVerb 2 0)
				else
					(gMessager say: noun theVerb 2 0)
				)
			)
		)
		(return (ratTimer setReal: ratTimer 30))
	)
)

(instance specs of Prop
	(properties
		approachX 753
		approachY 121
		x 771
		y 121
		view 1310
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 ignoreActors: 1) ; Do, Exit, Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: bendToGetSpecs)
			(return 1)
		)
	)
)

(instance leftDrip of Prop
	(properties
		x 409
		y 109
		view 1151
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 1 cycleSpeed: 11 setScript: leftDripIt)
	)
)

(instance rightDrip of Prop
	(properties
		x 423
		y 107
		view 1151
	)

	(method (init)
		(super init:)
		(self setPri: 1 cycleSpeed: 13 setScript: rightDripIt)
	)
)

(instance bustedGourd of View
	(properties
		noun 7
		sightAngle 20
		approachX 369
		approachY 95
		x 391
		y 76
		view 1100
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8) ; Do
		(if (or (and (IsFlag 41) (IsFlag 43)) (not (IsFlag 42)))
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((and (IsFlag 43) (not (IsFlag 41)) (not (IsFlag 42)))
						(gCurRoom setScript: getGourdSeed)
						(self setHotspot: 0)
					)
					(
						(and
							(not (IsFlag 41))
							(not (IsFlag 43))
							(== gChapter 1)
						)
						(gMessager say: noun theVerb 11 0) ; "That wouldn't taste very good. It's all dried out."
					)
				)
			)
		)
	)
)

(instance door of View
	(properties
		noun 1
		x 919
		y 84
		view 1200
	)

	(method (init)
		(super init: &rest)
		(if (== gValOrRoz -4) ; Val
			(self approachX: 895 approachY: 100)
		else
			(self approachX: 896 approachY: 98)
		)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(Load 140 808) ; WAVE
				(gCurRoom setScript: knockOnDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hair of View
	(properties
		approachX 662
		approachY 107
		x 683
		y 64
		view 1310
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (!= gChapter 4)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self setPri: 105 approachVerbs: 8 ignoreActors: 1) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: getHair)
		)
	)
)

(instance gourd of Feature
	(properties
		noun 7
		sightAngle 20
		approachX 369
		approachY 95
		x 387
		y 93
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 378 86 388 90 397 81 388 72
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb 11 0) ; "That wouldn't taste very good. It's all dried out."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 3
		sightAngle 20
		approachX 890
		approachY 115
		x 926
		y 46
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 878 45 880 60 935 54 927 38
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb 9 0) ; "'Rare Curiosities. Ricardo Eduardo Rodriguez Roo Rat, Proprietor.'"
			)
		)
	)
)

(instance hole of Feature
	(properties
		noun 4
		nsLeft 707
		nsTop 95
		nsRight 746
		nsBottom 113
		sightAngle 360
		approachX 750
		approachY 115
		x 718
		y 98
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 18) ; Do, Exit, Hunting_Horn
		(if (and (IsFlag 32) (not (IsFlag 7)))
			(self setHotspot: 8 10 18) ; Do, Exit, Hunting_Horn
		else
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1))
			(cond
				((== (param1 message:) 18)
					(= approachX 748)
					(= approachY 113)
				)
				((IsFlag 38)
					(= approachX 739)
					(= approachY 97)
				)
				(else
					(= approachX 750)
					(= approachY 105)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (not (gEgo script:)))
			(switch theVerb
				(8 ; Do
					(cond
						((== gValOrRoz -3) ; Roz
							(gCurRoom setScript: randomJack)
						)
						((IsFlag 38)
							(gCurRoom setScript: lookInHole)
						)
						(else
							(SetFlag 38)
							(gCurRoom setScript: talkToHole)
						)
					)
				)
				(18 ; Hunting_Horn
					(Load rsVIEW 1207)
					(if (IsFlag 325)
						(SetFlag 7)
					)
					(gCurRoom setScript: useHorn)
				)
			)
		)
	)
)

(instance sandTracks of Feature
	(properties
		sightAngle 360
		approachX 299
		approachY 130
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 296 137 229 137 188 127 155 105 183 95 201 115 239 125 277 124
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: lookAtTracks)
				(self setHotspot: 0)
			)
		)
	)
)

(instance head of Feature
	(properties
		noun 8
		nsLeft 70
		nsRight 160
		nsBottom 90
		approachX 170
		approachY 121
		x 165
		y 110
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
		(if (IsFlag 300)
			(self nsTop: 42 nsLeft: 137 nsBottom: 53 nsRight: 156)
		else
			(self nsTop: 0 nsLeft: 65 nsBottom: 90 nsRight: 160)
		)
		(if (not (IsFlag 13))
			(self approachVerbs: 8) ; Do
		else
			(self approachVerbs: 8 10 approachX: 162 approachY: 100) ; Do, Exit
		)
	)

	(method (handleEvent event)
		(if (== (gUser message:) 8)
			(Load rsPIC 1105)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 300)
					(if (IsFlag 13)
						(gCurRoom setScript: enterColossus)
					else
						(gCurRoom newRoom: 1105)
					)
				else
					(gEgo setHeading: 315)
					(SetFlag 300)
					(gMessager say: noun theVerb 13 0) ; "Incredible."
					(self nsTop: 42 nsLeft: 137 nsBottom: 53 nsRight: 156)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance prickly of Feature
	(properties
		noun 11
		nsLeft 220
		nsTop 62
		nsRight 254
		nsBottom 90
		sightAngle 360
		approachX 204
		approachY 104
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 11 setHotspot: 8 10 11) ; Do, Stick, Do, Exit, Stick
	)

	(method (handleEvent event)
		(if (& (event message:) JOY_UPLEFT)
			(= approachX 214)
			(= approachY 103)
		else
			(= approachX 204)
			(= approachY 104)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: touchPrick)
			)
			(11 ; Stick
				(self setHotspot: 0)
				(gCurRoom setScript: swingStick)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pear of Prop
	(properties
		noun 12
		sightAngle 360
		x 235
		y 74
		view 1101
		loop 1
		signal 4129
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 95
			approachVerbs: 8 10 11 ; Do, Exit, Stick
			setCel: (if (IsFlag 314) 9 else 0)
		)
		(if (IsFlag 314)
			(self setHotspot: 8 10) ; Do, Exit
		else
			(self setHotspot: 8 10 11) ; Do, Exit, Stick
		)
		(if (IsFlag 314)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 172 93 172 101 188 101 188 93
						yourself:
					)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event message:) JOY_UPLEFT)
			(if (IsFlag 314)
				(= approachX 206)
				(= approachY 98)
			else
				(= approachX 214)
				(= approachY 103)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 314)
					(gCurRoom setScript: getPear)
				else
					(gCurRoom setScript: touchPear)
				)
			)
			(11 ; Stick
				(prickly setHotspot: 0)
				(gCurRoom setScript: swingStick)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cave of ExitFeature
	(properties
		nsLeft 493
		nsTop 5
		nsRight 570
		nsBottom 58
		sightAngle 360
		approachX 540
		approachY 65
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Exit
				(gEgo setScript: enterCave)
			)
		)
	)
)

(instance glyphs of Feature
	(properties
		nsLeft 591
		nsTop 48
		nsRight 640
		nsBottom 61
		approachX 600
		approachY 103
		x 615
		y 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: inspectGlyphs)
			)
		)
	)
)

(instance wetSand of Feature
	(properties
		noun 5
		sightAngle 20
		x 417
		y 82
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 426 92 419 95 383 94 400 87 412 86 419 80 424 78
					yourself:
				)
		)
		(self setHotspot: 8 10 24) ; Do, Exit, Corn_Kernel
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Corn_Kernel
				(gEgo setScript: plantCornSeed)
			)
			(8 ; Do
				(gEgo setScript: lookAtWetSand)
			)
		)
	)
)

(instance eSouth of ExitFeature
	(properties
		nsTop 129
		nsRight 950
		nsBottom 136
		sightAngle 360
		approachY 135
		y 200
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(= approachX (event x:))
		(super handleEvent: event)
	)

	(method (doVerb)
		(gCurRoom setScript: walkSouth)
	)
)

(instance eWest of ExitFeature
	(properties
		nsRight 20
		nsBottom 140
		sightAngle 360
		approachX 1
		approachY 121
		y 200
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb)
		(= global314 4)
		(= global313 0)
		(= global312 0)
		(gCurRoom setScript: walkWest)
	)
)

(instance eEast of ExitFeature
	(properties
		nsLeft 939
		nsRight 960
		nsBottom 140
		sightAngle 360
		approachX 960
		approachY 130
		y 20
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (doVerb)
		(= global314 2)
		(= global313 4)
		(= global312 0)
		(gCurRoom setScript: walkEast)
	)
)

(instance colossusExit of ExitFeature
	(properties
		sightAngle 360
		approachX 177
		approachY 100
		y 108
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 10 10 ; Exit, Exit
			approachVerbs: 10 ; Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 40 127 104 159 93 149 34
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: enterColossus)
	)
)

(instance ratTimer of Timer
	(properties)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: gCurRoom)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (cue)
		(if (and (gCurRoom script:) (== (gCurRoom script:) ratTimerScript))
			(ratTimerScript cue:)
		)
	)
)

(instance jackTimer of Timer
	(properties)

	(method (cue)
		(self seconds: -1 client: 0 delete: dispose:)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance tempHotCast of Cast
	(properties)
)

(instance ratTalker of KQTalker
	(properties)

	(method (init)
		(= client rat)
		(super init: &rest)
	)
)

