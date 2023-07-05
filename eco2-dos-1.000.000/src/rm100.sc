;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Docks)
(use Talker)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
	gossipTalker 1
)

(local
	local0
	local1
)

(class HelpScript of Script
	(properties)

	(method (report))
)

(instance rm100 of Eco2Room
	(properties
		noun 27
		picture 100
		style 10
		east 160
		picAngle 45
		vanishingY 28
	)

	(method (init)
		(LoadMany rsVIEW 100 101 102 103 105 106 120)
		(Load rsMESSAGE 100)
		(if (!= gPrevRoomNum 160)
			(gEgo
				view: 101
				loop: 1
				cel: 0
				init:
				setScale: Scaler 108 37 189 56
			)
		else
			(gEgo init: normalize: 0 setScale: Scaler 108 37 189 56)
		)
		(if (== gPrevRoomNum 160)
			(= style 11)
			(gCurrentRegionFlags set: 1)
		)
		(if (== gPrevRoomNum 40) ; intro
			(gGameSound1 fade:)
		else
			(gGameSound1 fade: 30 5 5)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 238 95 262 95 314 97 314 126 276 126 270 117 251 117 238 114
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 156 89 189 89 193 96 212 106 212 129 167 129 165 124 158 109
					yourself:
				)
		)
		(cond
			((or (gCurrentRegionFlags test: 3) (gCurrentRegionFlags test: 4))
				(self
					addObstacle:
						(changePoly
							init: 320 82 310 82 270 90 250 90 187 86 166 86 139 82 71 95 71 107 147 107 158 115 158 137 136 151 138 151 138 158 167 158 167 176 208 156 208 144 245 146 269 147 288 136 320 165 320 158 305 136 320 134
							yourself:
						)
						(bmPoly init: 171 134 202 134 202 146 171 146 yourself:)
				)
			)
			((gCurrentRegionFlags test: 1)
				(self
					addObstacle:
						(changePoly
							init: 320 82 310 82 270 90 250 90 187 86 166 86 139 82 71 95 71 107 147 107 158 115 158 137 136 151 138 151 138 158 167 158 167 176 217 153 241 134 274 134 288 136 320 165 320 158 305 136 320 134
							yourself:
						)
						(bmPoly init: 171 134 202 134 202 146 171 146 yourself:)
				)
			)
			(else
				(self
					addObstacle:
						(changePoly
							init: 320 82 310 82 270 90 250 90 187 86 166 86 139 82 71 95 71 107 147 107 147 179 217 153 241 134 274 134 288 136 320 165 320 158 305 136 320 134
							yourself:
						)
				)
			)
		)
		(if (!= gPrevRoomNum 160)
			(gCurRoom
				addObstacle:
					(customsPoly init: 39 138 138 178 138 163 55 138 yourself:)
			)
			(gEgo posn: 39 139 view: 101 loop: 1 cel: 0)
			(gagman init:)
			(slaughter init:)
			(dad init:)
			(official init:)
			(boatman init:)
			(plane addToPic:)
			(gossip1 init: stopUpd: approachVerbs: 2) ; Talk
			(gossip2 init: stopUpd: approachVerbs: 2) ; Talk
			(rope addToPic:)
			(box1 addToPic:)
			(stool addToPic:)
			(stampPad init: stopUpd:)
			(self setScript: sDoTheGag)
		else
			(customsArea init: setOnMeCheck: 1 4096)
			(gCurrentRegionFlags set: 1)
			(if (or (gCurrentRegionFlags test: 3) (gCurrentRegionFlags test: 4))
				(dad posn: 226 150)
			else
				(dad posn: 242 145)
			)
			(dad
				view: 107
				loop: 5
				setCycle: RandCycle
				detailLevel: 2
				init:
				cycleSpeed: 30
				setPri: 10
				setScript: (sYakYak new:)
			)
			(if (or (gCurrentRegionFlags test: 3) (gCurrentRegionFlags test: 4))
				(if (gCurrentRegionFlags test: 4)
					(thug2 view: 107 init: setScale: Scaler 100 12 161 39)
				else
					(thug2 view: 107 init: hide: setScale: Scaler 100 12 161 39)
				)
			)
			(if (IsEcorderFlag 46)
				(boatman posn: 220 131)
			)
			(boatman
				view: 107
				loop: 3
				setCycle: RandCycle
				cycleSpeed: 17
				detailLevel: 2
				init:
				setScript: (sYakYak new:)
			)
			(if (or (gCurrentRegionFlags test: 3) (gCurrentRegionFlags test: 4))
				(rope view: 100 init: stopUpd:)
				(dadsuitcase view: 107 loop: 4 init: stopUpd:)
				(if (IsEcorderFlag 46)
					(if (not (gCurrentRegionFlags test: 5))
						(self setScript: sAdamGetsEcorder)
					)
				else
					(dad setScript: sDadInterim)
				)
			else
				(dadsuitcase addToPic:)
				(rope addToPic:)
				(gossip1
					setCycle: RandCycle
					init:
					stopUpd:
					approachVerbs: 2 ; Talk
					setScript: (sYakYak new:)
				)
				(gossip2
					setCycle: RandCycle
					init:
					stopUpd:
					approachVerbs: 2 ; Talk
					setScript: (sYakYak new:)
				)
				(box1 addToPic:)
			)
			(if (not script)
				(gGame handsOn:)
			)
		)
		(package
			setCel:
				(if (gCurrentRegionFlags test: 4)
					(package lastCel:)
				else
					0
				)
			init:
		)
		(canoe init:)
		(waterRipple setCycle: Fwd init:)
		(desk init: setOnMeCheck: 1 2)
		(fence init: setOnMeCheck: 1 4)
		(shed init: setOnMeCheck: 1 256)
		(shacksign init: setOnMeCheck: 1 1024)
		(town init: setOnMeCheck: 1 64)
		(umbrella init: setOnMeCheck: 1 16)
		(jungle init: setOnMeCheck: 1 2048)
		(river init: setOnMeCheck: 1 128)
		(water init: setOnMeCheck: 1 16384)
		(shop init: setOnMeCheck: 1 32)
		(fruit init:)
		(pier init:)
		(pierControl init: setOnMeCheck: 1 8192)
		(popstand init: setOnMeCheck: 1 8)
		(eastExit init:)
		(eastExit2 init:)
		(gGameSound1 number: 120 loop: -1 play: 127)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 135 151 140 159) (not (gCurRoom script:)))
			(gCurRoom setScript: sGoAway)
		)
		(cond
			((<= (gEgo y:) 90)
				(if (not local0)
					(= local0 1)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(gMessager say: 27 0 43 0) ; "Son, don't go into town! I'll be ready in a sec."
				)
			)
			(local0
				(= local0 0)
			)
		)
		(if (and (pierControl onMe: gEgo) (not (gEgo script:)))
			(if (gCurrentRegionFlags test: 5)
				(gEgo setScript: sWalkOffPier)
			else
				(gEgo setScript: sWalkOnPier)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 938 941)
		(super dispose:)
	)

	(method (notify)
		(if (gCurrentRegionFlags test: 8)
			(gCurrentRegionFlags set: 3)
			(if
				(and
					(not (gCast contains: box1))
					(not (gAddToPics contains: box1))
				)
				(dad setScript: sDadInterim)
			)
		else
			(gCurrentRegionFlags set: 8)
			(Docks docksTimer: 90)
		)
	)
)

(instance returnPort of Script
	(properties)

	(method (changeState)
		(SetPort -1)
		(self dispose:)
	)

	(method (cue)
		(self changeState:)
	)
)

(instance sTutorScript of HelpScript
	(properties)

	(method (init param1 param2 param3)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(if (== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
			(gTheIconBar swapCurIcon:)
		)
		(= state (- start 1))
		(returnPort client: self)
		(self cue:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (report &tmp temp0)
		(gMessager say: 27 0 42) ; "Try again."
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
			)
		)
		(switch state
			(1
				(gMessager say: 27 0 31 1 0) ; "Move the cursor to the top of the screen. This will show the icon bar."
			)
			(3
				(gMessager say: 27 0 31 2 returnPort) ; "Click the cursor on the inventory icon to open your inventory window."
			)
			(5
				(gMessager say: 27 0 32 0 0) ; "Click on the hand icon to select the hand cursor."
			)
			(7
				(gMessager say: 27 0 33 0 0) ; "Click the hand cursor on the passport."
			)
			(9
				(gMessager say: 27 0 34 2 0) ; "Click the arrow icon to change to that cursor."
			)
			(11
				(gMessager say: 27 0 34 3 0) ; "Click the arrow cursor on the passport/card to select it."
			)
			(13
				(gMessager say: 27 0 35 0 0) ; "Close the inventory window by clicking OK."
			)
			(16
				(gMessager say: 27 0 37 0 0) ; "Click the passport cursor on the customs official."
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event type:))
		(cond
			((or (== state 1) (== state 3))
				(cond
					((& temp0 $0040) ; direction
						(self report:)
						(event claimed: 1)
					)
					((& temp0 evMOUSEBUTTON)
						(event claimed: 1)
						(self report:)
						(return 1)
					)
					((& temp0 evKEYBOARD)
						(switch (event message:)
							(KEY_RETURN
								(self report:)
								(event claimed: 1)
							)
							(KEY_INSERT
								(if (gUser canControl:)
									(self report:)
								)
								(event claimed: 1)
							)
							(JOY_NULL
								(if (& (event type:) $0040) ; direction
									(self report:)
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
			((and (== state 16) (or (& temp0 evMOUSEBUTTON) (& temp0 evKEYBOARD)))
				(cond
					((official onMe: event)
						(official handleEvent: event)
					)
					((& temp0 $0040) ; direction
						(return 0)
					)
					(else
						(self report:)
						(event claimed: 1)
					)
				)
			)
		)
		(return 0)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetFlag 3)
				(gNarrator x: -1 y: 150)
				(if (IsObject (= temp0 (gTheIconBar curInvIcon:)))
					(if
						(and
							(== (gTheIconBar curIcon:) (gTheIconBar findIcon: 21))
							(== (temp0 message:) 8)
							((gInventory findIcon: 8) cel:)
						)
						(self changeState: 15)
					else
						(= cycles 5)
					)
				else
					(= cycles 5)
				)
			)
			(1
				(= register gTheIconBar)
				(gMessager say: 27 0 31 1 0) ; "Move the cursor to the top of the screen. This will show the icon bar."
			)
			(2
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(3
				(gMessager say: 27 0 31 2 returnPort) ; "Click the cursor on the inventory icon to open your inventory window."
				(= register (gTheIconBar findIcon: 69))
			)
			(4
				(ClearFlag 4)
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(5
				(if ((gInventory findIcon: 8) cel:)
					(self changeState: 9)
				else
					(gMessager say: 27 0 32 0) ; "Click on the hand icon to select the hand cursor."
					(= register (gInventory findIcon: 4))
				)
			)
			(6
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(7
				(gMessager say: 27 0 33 0 0) ; "Click the hand cursor on the passport."
				(= register (gInventory findIcon: 8))
			)
			(8
				(gMessager say: 27 0 34 1 self) ; "Congratulations! You've found Adam's immunization card."
			)
			(9
				(gMessager say: 27 0 34 2 0) ; "Click the arrow icon to change to that cursor."
				(= register (gInventory findIcon: 70))
			)
			(10
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(11
				(gMessager say: 27 0 34 3 0) ; "Click the arrow cursor on the passport/card to select it."
				(= register (gInventory findIcon: 8))
			)
			(12
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(13
				(gMessager say: 27 0 35 0 0) ; "Close the inventory window by clicking OK."
				(= register (gInventory findIcon: 54))
			)
			(14
				(if ((gUser curEvent:) type:)
					((gUser curEvent:) claimed: 1)
					((gUser curEvent:) dispose:)
				)
				(gMessager say: 27 0 44 0 self) ; "Good!"
			)
			(15
				(gMessager say: 27 0 36 0 self) ; "The passport is now in the inventory display window in the icon bar."
			)
			(16
				(SetFlag 7)
				(gMessager say: 27 0 37 1) ; "Click the passport cursor on the customs official."
				(= register official)
			)
			(17
				(ClearFlag 3)
				(ClearFlag 7)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToGossips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
				(gossip1 setScript: 0 stopUpd:)
				(gossip2 setScript: 0 stopUpd:)
			)
			(1
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: 12 2 15 1 self) ; "Are you still on your break?"
				else
					(gMessager say: 12 2 14 1 2 self) ; "Are you selling the fruit pops?"
				)
			)
			(2
				(gossip2 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: 12 2 15 2 self) ; "Yeah, my break ends when I say it does."
				else
					(gMessager say: 12 2 14 3 4 self) ; "(TO ADAM)Do you mind? This is private!"
				)
			)
			(4
				(gossip2 setCycle: Beg self)
			)
			(5
				(gossip2 setLoop: 1 setScript: (sYakYak new:))
				(gossip1 setScript: (sYakYak new:))
				(gCurrentRegionFlags set: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWalkOnPier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 320 162 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sWalkOffPier of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 298 134 self)
			)
			(1
				(gCurrentRegionFlags clear: 5)
				(if (IsEcorderFlag 46)
					(gCurRoom setScript: sAdamGetsEcorder)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoTheGag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sLocalSnd2 number: 133 loop: -1 play: 127)
				(= seconds 1)
			)
			(1
				(gMessager say: 27 0 1 0 self) ; "I can't believe we're here. I can smell the jungle!"
			)
			(2
				(gEgo stopUpd:)
				(gagman setLoop: 0 setCycle: Walk ignoreActors: 1)
				(= ticks 6)
			)
			(3
				(gMessager say: 27 0 2 0 self) ; "Just one moment, Senor. Open your luggage."
			)
			(4
				(gagman posn: 102 164 setLoop: 1 setCycle: CT 9 1 self)
			)
			(5
				(gagman cel: 10)
				(briefcase init:)
				(sLocalSnd number: 140 loop: 1 play: 127)
				(= ticks 6)
			)
			(6
				(gagmanLeg init: stopUpd:)
				(gagman posn: 97 146 setLoop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(7
				(sLocalSnd2 fade: 30 1 1 1)
				(= ticks 120)
			)
			(8
				(briefcase setCycle: CT 1 1)
				(sLocalSnd number: 144 loop: 1 play: 127)
				(= ticks 6)
			)
			(9
				(gagman setCel: 2)
				(briefcase stopUpd:)
				(= ticks 30)
			)
			(10
				(gagman setCel: 4 setPri: 12)
				(= ticks 60)
			)
			(11
				(sLocalSnd2 number: 139 loop: -1 play: 127)
				(= cycles 1)
			)
			(12
				(gagman setCel: 3 setPri: 12)
				(things3 setCel: 0 posn: 96 172 init:)
				(= ticks 10)
			)
			(13
				(gagman setCel: 4)
				(= ticks 10)
			)
			(14
				(gagman setCel: 3)
				(things3 y: (- (things3 y:) 5))
				(if (>= (things3 y:) 140)
					(-= state 2)
				)
				(= ticks 10)
			)
			(15
				(= ticks 60)
			)
			(16
				(gagman setCel: 4)
				(things3 y: (+ (things3 y:) 5))
				(= ticks 10)
			)
			(17
				(gagman setCel: 3)
				(if (<= (things3 y:) 172)
					(-= state 2)
				)
				(= ticks 10)
			)
			(18
				(gagman setCel: 3)
				(things3 posn: 67 141 setCel: 1)
				(= ticks 10)
			)
			(19
				(gagman setCel: 4)
				(= ticks 10)
			)
			(20
				(gagman setCel: 3)
				(things3 y: (- (things3 y:) 5))
				(if (>= (things3 y:) 99)
					(-= state 2)
				)
				(= ticks 10)
			)
			(21
				(= ticks 60)
			)
			(22
				(gagman setCel: 4)
				(things3 y: (+ (things3 y:) 5))
				(= ticks 10)
			)
			(23
				(gagman setCel: 3)
				(if (<= (things3 y:) 141)
					(-= state 2)
				)
				(= ticks 10)
			)
			(24
				(official view: 106 setLoop: 9 setCel: 0 setCycle: CT 3 1 self)
			)
			(25
				(= ticks 60)
			)
			(26
				(official setCycle: End self)
			)
			(27
				(= ticks 120)
			)
			(28
				(official setCycle: CT 5 -1 self)
			)
			(29
				(gMessager say: 27 0 3 0 self) ; "This is ridiculous! Move along now!"
			)
			(30
				(official view: 101 loop: 3 cel: 0)
				(= cycles 1)
			)
			(31
				(official stopUpd:)
				(= cycles 1)
			)
			(32
				(gagman setCel: 3 setCycle: Fwd)
				(sLocalSnd number: 143 loop: 1 play: 127)
				(things3
					posn: 85 157
					moveSpeed: 0
					setLoop: 5
					setCel: 0
					setMotion: MoveTo 85 147 self
				)
			)
			(33
				(gagman setCycle: Walk)
				(things3 cycleSpeed: 10 setCycle: CT 4 1 self)
			)
			(34
				(things3
					setCel: 5
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 85 134 self
				)
				(= local1 2)
				(gagman setLoop: 6 cel: 0 setCycle: CT 2 1 self)
			)
			(35)
			(36
				(things3 setMotion: MoveTo 92 85 self)
			)
			(37
				(waterRipple stopUpd:)
				(gagman setSpeed: 0 setCycle: CT 6 1 self)
			)
			(38
				(gagman setSpeed: 6 setCycle: CT 7 1 self)
				(briefcase cel: 1 setCycle: CT 0 -1 self)
			)
			(39)
			(40
				(gagman cel: 8 setCycle: CT 10 1 self)
				(briefcase setCel: 1 setCycle: CT 2 1)
			)
			(41
				(gagman setCel: 11)
				(briefcase dispose:)
				(= cycles 1)
			)
			(42
				(gagmanLeg dispose:)
				(things3 dispose:)
				(gagman
					posn: 96 143
					setLoop: 7
					setCel: 0
					illegalBits: 0
					ignoreActors: 1
					setSpeed: 6
					setPri: 13
					setCycle: Fwd
					setMotion: MoveTo 96 138 self
				)
			)
			(43
				(official setCycle: CT 1 1 self)
				(dad setCycle: CT 1 1 self)
				(slaughter setCycle: CT 1 1 self)
				(boatman setCycle: CT 1 1 self)
				(gEgo setCycle: CT 1 1 self)
			)
			(44)
			(45)
			(46)
			(47)
			(48
				(official stopUpd:)
				(dad stopUpd:)
				(slaughter stopUpd:)
				(boatman stopUpd:)
				(gEgo stopUpd:)
				(gagman setMotion: MoveTo 96 -5 self)
			)
			(49
				(sLocalSnd2 fade: 30 2 2 1 self)
				(gagman setMotion: MoveTo 96 -20 self)
			)
			(50)
			(51
				(gagman dispose:)
				(slaughter setCycle: CT 0 -1 self)
			)
			(52
				(gMessager say: 27 0 29 0 self) ; "I can't believe it!"
			)
			(53
				(slaughter stopUpd:)
				(boatman setCycle: CT 0 -1 self)
			)
			(54
				(boatman stopUpd:)
				(official setCycle: CT 0 -1 self)
			)
			(55
				(official stopUpd:)
				(dad setCycle: CT 0 -1 self)
			)
			(56
				(dad stopUpd:)
				(gEgo setCycle: CT 0 -1 self)
				(waterRipple startUpd: detailLevel: 2)
			)
			(57
				(= cycles 1)
			)
			(58
				(gCurRoom setScript: sSlaughterBribes)
			)
		)
	)
)

(instance sSlaughterBribes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sLocalSnd2 number: 130 loop: -1 play: 127)
				(slaughter
					view: 30
					loop: 0
					setPri: -1
					setCycle: Walk
					setLoop: Grooper
					setMotion: MoveTo 95 162 self
				)
			)
			(1
				(slaughter view: 103 loop: 2 cel: 0)
				(= ticks 6)
			)
			(2
				(gMessager say: 27 0 4 1 self) ; "NOW it is YOUR turn."
			)
			(3
				(gMessager say: 27 0 4 2 self) ; "Passport and immunization card, please."
			)
			(4
				(slaughter setCycle: End self)
			)
			(5
				(official view: 106 loop: 4 setCycle: CT 3 1 self)
			)
			(6
				(official setCycle: CT 6 1 self)
				(slaughter setCel: 0)
			)
			(7
				(= ticks 120)
			)
			(8
				(gMessager say: 27 0 9 0 self) ; "Just stamp it, I've got to get out of here."
			)
			(9
				(= seconds 3)
			)
			(10
				(gMessager say: 27 0 8 1 3 self) ; "Can we get on with this?"
			)
			(11
				(official setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
			)
			(12
				(official setCycle: Beg self)
			)
			(13
				(gMessager say: 27 0 8 4 6 self) ; "Right now, Senor."
			)
			(14
				(= seconds 2)
			)
			(15
				(slaughter loop: 3 cel: 0 setCycle: End self)
			)
			(16
				((= register (Prop new:))
					view: 103
					loop: 4
					cel: 0
					posn: 49 166 40
					ignoreActors: 1
					setPri: 15
					init:
				)
				(= ticks 120)
			)
			(17
				(register dispose:)
				(official setLoop: 4 setCel: 0 setCycle: CT 3 1 self)
			)
			(18
				(official setLoop: 2 cel: 0 setCycle: End self)
				(slaughter loop: 2 setCel: 0)
			)
			(19
				(= ticks 120)
			)
			(20
				(stampPad startUpd:)
				(official setLoop: 4 cel: 7 setCycle: CT 8 1 self)
			)
			(21
				(stampPad setCel: 0)
				(official setCel: 9)
				(= cycles 1)
			)
			(22
				(stampPad stopUpd:)
				(official setLoop: 5 setCel: 0 setCycle: End self)
			)
			(23
				(sLocalSnd number: 110 loop: 1 play: 127)
				(official setCycle: Beg self)
			)
			(24
				(stampPad startUpd:)
				(official setLoop: 4 setCel: 9)
				(= cycles 1)
			)
			(25
				(stampPad setCel: 1)
				(official setCel: 8)
				(= cycles 1)
			)
			(26
				(stampPad stopUpd:)
				(official setCycle: CT 4 -1 self)
			)
			(27
				(slaughter loop: 2 setCel: 4 setCycle: Beg self)
				(official setCycle: Beg self)
			)
			(28)
			(29
				(gMessager say: 27 0 7 0 self) ; "Welcome to our country."
			)
			(30
				(slaughter
					view: 30
					loop: 4
					setCycle: Walk
					setLoop: Grooper
					setPri: -1
					setMotion: MoveTo 162 174 self
				)
			)
			(31
				(slaughter setHeading: 180 self)
			)
			(32
				(slaughter setCycle: StopWalk -1)
				(= cycles 1)
			)
			(33
				(= ticks 60)
			)
			(34
				(sLocalSnd number: 131 loop: 1 play: 127)
				(gMessager say: 27 0 6 0 self) ; "This place is a sewer."
			)
			(35
				(official view: 101 loop: 3 cel: 0)
				(slaughter setCycle: 0 view: 101 loop: 2 cel: 2)
				(= cycles 1)
			)
			(36
				(official stopUpd:)
				(slaughter stopUpd:)
				(= cycles 1)
			)
			(37
				(dad
					view: 102
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 90 164 self
				)
				(gEgo normalize: 0 4 setMotion: PolyPath 75 156 self)
			)
			(38)
			(39
				(official view: 101 loop: 3 cel: 0)
				(dad setCycle: 0 view: 101 loop: 0 cel: 0)
				(gEgo setCycle: 0 view: 101 loop: 1 cel: 0)
				(= cycles 1)
			)
			(40
				(official stopUpd:)
				(dad stopUpd:)
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(41
				(boatman view: 120 loop: 0 setCel: 2 setCycle: CT 0 -1 self)
				(slaughter
					view: 30
					loop: 4
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 209 145 self
				)
			)
			(42)
			(43
				(dad startUpd: cel: 2)
				(gEgo startUpd: cel: 2)
				(= cycles 1)
			)
			(44
				(dad stopUpd:)
				(gEgo stopUpd:)
				(= cycles 1)
			)
			(45
				(gCurRoom setScript: sSlaughterSlugsBoatman)
			)
		)
	)
)

(instance sSlaughterSlugsBoatman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boatman view: 120 setCel: 0 setCycle: End self)
				(slaughter view: 103 loop: 0 ignoreActors: 1 setCycle: End self)
			)
			(1)
			(2
				(slaughter posn: 204 147 view: 30 loop: 8 cel: 1)
				(boatman setLoop: 1 setCel: 2)
				(= ticks 15)
			)
			(3
				(boatman setCycle: CT 0 -1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(slaughter
					view: 32
					ignoreActors: 1
					loop: 1
					cel: 0
					moveSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(6
				(boatman setCel: 1 setCycle: CT 3 1 self)
			)
			(7
				(slaughter setCycle: End self)
			)
			(8
				(sLocalSnd number: 132 loop: 1 play: 127)
				(gMessager say: 27 0 5 1 self) ; "Hey, watch the suit!"
			)
			(9
				(= ticks 60)
			)
			(10
				(boatman setCycle: CT 2 -1 self)
				(slaughter
					setCycle: 0
					view: 30
					loop: 1
					heading: 270
					setHeading: 180 self
				)
			)
			(11)
			(12
				(slaughter setCycle: StopWalk -1)
				(= cycles 1)
			)
			(13
				(= ticks 60)
			)
			(14
				(slaughter
					view: 103
					loop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: ForwardCounter 3 self
				)
			)
			(15
				(boatman view: 101 loop: 4 setCel: 4 cycleSpeed: 6)
				(slaughter view: 30 loop: 2 heading: 180 setHeading: 90 self)
			)
			(16
				(boatman stopUpd:)
				(slaughter
					setLoop: Grooper
					setCycle: Walk
					setMotion: DPath 227 135 230 127 335 126 self
				)
			)
			(17
				(sLocalSnd2 fade: 30 1 1 1)
				(slaughter setMotion: MoveTo 335 136 self)
			)
			(18
				(gMessager say: 27 0 28 0 self) ; "That was majorly rude."
			)
			(19
				(gGameSound2 number: 135 loop: 1 play: 127)
				(slaughter dispose:)
				(gCurRoom
					addObstacle:
						(bmPoly init: 171 134 202 134 202 146 171 146 yourself:)
				)
				(gossip1 setScript: (sYakYak new:))
				(gossip2 setScript: (sYakYak new:))
				(gCurRoom setScript: sDadEntersCountry)
			)
		)
	)
)

(instance sDadEntersCountry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(boatman setCel: 0)
				(dad view: 102 loop: 1 cel: 0)
				(gEgo normalize: 0 5)
				(= cycles 2)
			)
			(1
				(gEgo stopUpd:)
				(= ticks 10)
			)
			(2
				(gMessager say: 27 0 22 1 8 self) ; "Business or pleasure, Senor?"
			)
			(3
				(gMessager say: 27 0 22 9 self) ; "Passport and immunization card, please."
			)
			(4
				(dad loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(official view: 106 setLoop: 4 setCel: 0 setCycle: CT 3 1 self)
			)
			(6
				(official setCycle: CT 5 1 self)
				(dad setCycle: CT 3 1 self)
			)
			(7)
			(8
				(stampPad startUpd:)
				(dad cel: 0)
				(official setLoop: 5 cel: 0)
				(= cycles 1)
			)
			(9
				(stampPad setCel: 0)
				(official setCel: 1)
				(= cycles 1)
			)
			(10
				(stampPad stopUpd:)
				(official setCycle: End self)
			)
			(11
				(stampPad startUpd:)
				(sLocalSnd number: 110 loop: 1 play: 127)
				(official setCycle: CT 1 -1 self)
			)
			(12
				(stampPad setCel: 1)
				(official setCel: 0)
				(= cycles 1)
			)
			(13
				(official setLoop: 4 setCel: 5 setCycle: CT 3 -1 self)
			)
			(14
				(dad cel: 3 setCycle: CT 1 -1 self)
			)
			(15
				(official setCycle: CT 0 -1 self)
				(dad setCycle: CT 0 -1 self)
			)
			(16)
			(17
				(gMessager say: 27 0 7 0 self) ; "Welcome to our country."
			)
			(18
				(official stopUpd:)
				(dad loop: 0 setCycle: Walk setMotion: MoveTo 171 169 self)
			)
			(19
				(dad
					setLoop: 2
					setCel: 0
					signal: (| (dad signal:) $1000)
					setCycle: CT 5 1 self
				)
			)
			(20
				(dad
					view: 108
					setLoop: 0
					setPri: 14
					detailLevel: 2
					cycleSpeed: 15
					setScript: (sYakYak new:)
				)
				(= ticks 6)
			)
			(21
				(gEgo setMotion: MoveTo 85 156 self)
			)
			(22
				(gEgo setHeading: 225 self)
			)
			(23
				(gMessager say: 27 0 22 9 self) ; "Passport and immunization card, please."
			)
			(24
				(gGame handsOn:)
				(gCurRoom setScript: sCountdown)
				(self dispose:)
			)
		)
	)
)

(instance sCountdown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(gGame setScript: sTutorScript)
				(self dispose:)
			)
		)
	)
)

(instance sComeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 27 0 30 0 self) ; "You cannot enter the city until I stamp your passport!"
			)
			(1
				(gEgo setMotion: MoveTo 85 156 self)
			)
			(2
				(gEgo setHeading: 225 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOfficialSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(official setCycle: End self)
			)
			(2
				(official
					view: 101
					setLoop: 3
					setCel: 3
					setCycle: ROsc -1 2 3
					setSpeed: 45
				)
				(= cycles 1)
			)
			(3
				(official detailLevel: 2)
				(self dispose:)
			)
		)
	)
)

(instance sGoAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: official)
					(official
						setSpeed: 6
						view: 106
						setLoop: 3
						setCel: 5
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (gCast contains: official)
					(gMessager say: 27 0 27 0 self) ; "Off limits! I've checked your passport."
				else
					(gMessager say: 27 3 24 0 self) ; "Hmm, the customs guy told me to stay away. Maybe I shouldn't go in there..."
				)
			)
			(2
				(if (gCast contains: official)
					(official setScript: sOfficialSleeps)
				)
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo 148 155 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAdamEntersCountry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 85 156 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo view: 4 loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(official setLoop: 4 setCel: 0 setCycle: CT 3 1 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo cel: 0)
				(official setCycle: CT 6 1 self)
			)
			(6
				(stampPad startUpd:)
				(official setLoop: 4 setCel: 7 setCycle: CT 8 1 self)
			)
			(7
				(stampPad setCel: 0)
				(official setCel: 9)
				(= cycles 1)
			)
			(8
				(stampPad stopUpd:)
				(official setLoop: 5 setCel: 0 setCycle: End self)
			)
			(9
				(sLocalSnd number: 110 loop: 1 play: 127)
				(official setCycle: CT 1 -1 self)
			)
			(10
				(stampPad startUpd:)
				(official setLoop: 4 setCel: 9)
				(= cycles 1)
			)
			(11
				(stampPad setCel: 1)
				(official setCel: 8)
				(= cycles 1)
			)
			(12
				(stampPad stopUpd:)
				(official setCycle: CT 4 -1 self)
			)
			(13
				(gEgo setCycle: CT 2 1 self)
			)
			(14
				(gEgo setCycle: End self)
				(official setCycle: Beg self)
			)
			(15)
			(16
				(gEgo normalize: 0 5)
				(= cycles 1)
			)
			(17
				(gNarrator x: -1 y: -1)
				(changePoly dispose:)
				(gMessager say: 26 48 0 1 self) ; "Welcome to our country."
			)
			(18
				(gCurRoom
					addObstacle:
						(changePoly
							init: 320 82 310 82 270 90 250 90 187 86 166 86 139 82 71 95 71 107 147 107 158 115 158 137 136 151 138 151 138 158 164 162 193 162 217 153 241 134 274 134 288 136 320 165 320 158 305 136 320 134
							yourself:
						)
				)
				(gEgo setMotion: MoveTo 148 155 self)
			)
			(19
				(official loop: 1 cel: 0 setCycle: End self)
			)
			(20
				(= ticks 90)
			)
			(21
				(official setCycle: Beg self)
			)
			(22
				(official loop: 3 cel: 0 setCycle: End self)
				(customsPoly dispose:)
				(proc0_5 gEgo dad self)
			)
			(23)
			(24
				(official
					view: 101
					loop: 3
					cel: 3
					approachX: 137
					approachY: 155
					approachVerbs: 4 2 8 ; Do, Talk, passport
				)
				(= cycles 1)
			)
			(25
				(official setSpeed: 45 setCycle: ROsc -1 2 3 detailLevel: 2)
				(= ticks 60)
			)
			(26
				(boatman view: 120 loop: 0 cel: 2 setCycle: CT 0 -1 self)
			)
			(27
				(customsArea init: setOnMeCheck: 1 4096)
				(boatman stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDadBoatmanToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dad setScript: 0)
				(gCurrentRegionFlags set: 1)
				(proc0_5 gEgo boatman self)
			)
			(1
				(changePoly dispose:)
				(gMessager say: 27 0 23 1 self) ; "Adam and Noah Greene?"
			)
			(2
				(gMessager say: 27 0 23 2 3 self) ; "That's us!"
			)
			(3
				(gCurRoom
					addObstacle:
						(changePoly
							init: 320 82 310 82 270 90 250 90 187 86 166 86 139 82 71 95 71 107 147 107 158 115 158 137 136 151 138 151 138 158 167 158 167 176 217 153 241 134 274 134 288 136 320 165 320 158 305 136 320 134
							yourself:
						)
				)
				(= cycles 2)
			)
			(4
				(dad
					view: 102
					setLoop: 2
					setCel: 6
					setSpeed: 6
					setCycle: End self
				)
			)
			(5
				(dadsuitcase view: 101 loop: 0 cel: 4 init:)
				(dad
					setPri: -1
					view: 20
					posn: 166 174
					loop: 0
					setCycle: StopWalk -1
					setLoop: Grooper
					setMotion: MoveTo 186 158 self
				)
			)
			(6
				(dad setHeading: 0 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gMessager say: 27 0 23 4 7 self) ; "I am Nicanor, from the Ecology Emergency Network. I am your contact with the tribes in this region."
			)
			(9
				(boatman setLoop: 2 setCycle: End self)
				(dad setLoop: Grooper setMotion: MoveTo 242 145 self)
			)
			(10)
			(11
				(boatman
					setLoop: 3
					detailLevel: 2
					cycleSpeed: 17
					setScript: (sYakYak new:)
				)
				(dad
					view: 102
					setLoop: 5
					cycleSpeed: 30
					detailLevel: 2
					setScript: (sYakYak new:)
				)
				(dadsuitcase view: 102 loop: 3 cel: 0 stopUpd:)
				(= ticks 5)
			)
			(12
				(dad signal: (| (dad signal:) $1000) setPri: 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThiefRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound2 number: 146 loop: -1 play: 127)
				(thug2
					view: 151
					setLoop: 3
					setCel: 0
					setCycle: Walk
					setSpeed: 2
					setStep: 7 7
					setMotion: DPath 169 152 167 148 165 135 135 106 150 78 self
				)
			)
			(1
				(thug2
					setPri: 1
					setMotion:
						DPath
						166
						68
						186
						66
						196
						62
						210
						56
						234
						41
						241
						39
						self
				)
			)
			(2
				(thug2 setMotion: DPath 245 31 241 31 self)
				(gGameSound2 fade: 30 2 2 1)
			)
			(3
				(thug2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sAdamOpensPackage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 245 145 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 1)
			)
			(3
				(gCurrentRegionFlags clear: 3)
				(gCurrentRegionFlags set: 4)
				(dad setPri: -1)
				(gEgo view: 5 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(package setCycle: End self)
			)
			(5
				(gEgo setCycle: CT 5 1 self)
			)
			(6
				(gEgo setCycle: 0 view: 107 loop: 2 cel: 0)
				(boatman setScript: 0 setSpeed: 6 startUpd:)
				(dad setScript: 0 setSpeed: 6 startUpd:)
				(= cycles 1)
			)
			(7
				(gCast eachElementDo: #stopUpd)
				(= cycles 3)
			)
			(8
				(gMessager say: 27 0 46 0 self) ; "A handheld computer! What does it do?"
			)
			(9
				(self setScript: (ScriptID 333 0) self) ; showEcorder
			)
			(10
				(= cycles 6)
			)
			(11
				(gMessager say: 19 0 49 0 self) ; "Why don't you try it? I'll give you a hint -- I think something about that launch is on your list."
			)
			(12
				(dad setScript: sDadEcorder)
				(gEgo normalize: 0 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDadWalksAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dad
					setSpeed: 6
					setLoop: -1
					setScale: Scaler 100 70 140 108
					scaleSignal: 5
					ignoreActors: 1
					setCycle: Walk
					setMotion: DPath 226 143 231 131 223 108 self
				)
			)
			(1
				(dad
					setScale: Scaler 70 55 107 86
					setMotion: MoveTo 214 86 self
				)
			)
			(2
				(dad
					setScale: Scaler 55 11 86 39
					setMotion: DPath 214 67 225 39 self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sBMWalkAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boatman
					setLoop: 5
					setScale: Scaler 100 70 131 108
					scaleSignal: 5
					ignoreActors: 1
					setSpeed: 6
					setCycle: Fwd
					setMotion: DPath 218 131 215 108 self
				)
			)
			(1
				(boatman
					setScale: Scaler 70 55 107 86
					setMotion: MoveTo 215 86 self
				)
			)
			(2
				(boatman
					setScale: Scaler 55 12 86 39
					setMotion: DPath 214 71 225 39 self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sAdamGetsEcorder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 245 145 self)
			)
			(1
				(dad setPri: -1)
				(gEgo setHeading: 270 self)
			)
			(2
				(boatman setScript: 0 setSpeed: 6 setCycle: 0 startUpd:)
				(dad setScript: 0 setSpeed: 6 setCycle: 0 startUpd:)
				(= cycles 1)
			)
			(3
				(dad view: 20 loop: 4 cel: 4)
				(gEgo normalize: 0 1)
				(= cycles 1)
			)
			(4
				(thug2 view: 151 startUpd: setCycle: End self)
			)
			(5
				(gGameSound2 number: 145 loop: -1 play: 127)
				(thug2
					setLoop: 1
					setCycle: Walk
					setMotion: DPath 165 136 165 140 165 145 154 165 self
				)
			)
			(6
				(dadsuitcase dispose:)
				(thug2 setLoop: 2 setCel: 0 setCycle: CT 1 1 self)
			)
			(7
				(gEgo setHeading: 270 self)
				(boatman view: 120 setLoop: 4 cel: 0 setCycle: ROsc 1 0 1 self)
				(thug2 setCycle: CT 2 1 self)
			)
			(8)
			(9)
			(10
				(gMessager say: 27 0 38 1 self) ; "Dad! Look out!"
			)
			(11
				(thug2 setScript: sThiefRuns)
				(boatman cel: 1 setCycle: CT 4 1 self)
				(dad
					view: 20
					setLoop: -1
					loop: 2
					heading: 180
					setHeading: 0 self
				)
			)
			(12)
			(13
				(= ticks 30)
			)
			(14
				(boatman setSpeed: 2 setCycle: ROsc 6 4 6 self)
			)
			(15
				(gMessager say: 27 0 38 2 3 self) ; "Senor Greene! Your suitcase!"
			)
			(16
				(boatman setSpeed: 6 setCel: 7)
				(= ticks 60)
			)
			(17
				(boatman setSpeed: 10 setCycle: CT 9 1 self)
			)
			(18
				(dad
					setCycle: Walk
					setMotion: MoveTo (dad x:) (- (dad y:) 5) self
				)
			)
			(19
				(boatman setSpeed: 6 setCycle: CT 11 1 self)
			)
			(20
				(gMessager say: 27 0 38 4 7 self) ; "Such people are a disease here. I am so sorry. Did you have valuables?"
			)
			(21
				(gEgo setHeading: 315 self)
			)
			(22
				(gMessager say: 27 0 38 8 self) ; "What do you want me to do, Dad?"
			)
			(23
				(dad loop: 4 setCel: 6)
				(= ticks 6)
			)
			(24
				(dad setCel: 0)
				(= ticks 6)
			)
			(25
				(dad setCel: 4)
				(= ticks 6)
			)
			(26
				(dad setCel: 2 heading: 180)
				(= ticks 36)
			)
			(27
				(gMessager say: 27 0 38 9 11 self) ; "Stay here and watch our stuff. I'll be back as soon as I can."
			)
			(28
				(dad setCel: 4)
				(= ticks 6)
			)
			(29
				(dad setCel: 0)
				(= ticks 6)
			)
			(30
				(dad setCel: 6)
				(= ticks 6)
			)
			(31
				(dad setCel: 3 heading: 0)
				(= ticks 6)
			)
			(32
				(bmPoly dispose:)
				(boatman setScript: sBMWalkAway self)
				(dad setScript: sDadWalksAway self)
			)
			(33)
			(34
				(dad dispose:)
				(boatman dispose:)
				(= cycles 1)
			)
			(35
				(gEgo setSpeed: 6 setMotion: PolyPath 217 150 self)
			)
			(36
				(package setPri: 12)
				(gEgo setPri: 12 setMotion: MoveTo 235 168 self)
			)
			(37
				(gEgo
					posn: 239 170
					setPri: 14
					view: 150
					loop: 4
					cel: 0
					setCycle: End self
				)
				(canoe hide:)
			)
			(38
				(= seconds 3)
			)
			(39
				(canoe show:)
				(gEgo view: 15 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(40
				(gEgo setCel: 6 setCycle: End self)
			)
			(41
				(sLocalSnd number: 216 loop: 1 play: 127)
				(= ticks 120)
			)
			(42
				(gEgo setCycle: CT 6 -1 self)
			)
			(43
				(gEgo setCel: 3 setCycle: CT 5 1 self)
			)
			(44
				(gEgo setCycle: ROsc -1 4 5)
				(= ticks 180)
			)
			(45
				(gEgo setCycle: Beg self)
			)
			(46
				(gEgo posn: 236 170 loop: 1 cel: 0 setCycle: End self)
			)
			(47
				(= ticks 120)
			)
			(48
				(gGameSound2 number: 730 loop: -1 play: 127)
				(morpheus init: setCycle: End self)
				(orpheus init: setCycle: End self)
			)
			(49
				(gMessager say: 27 0 39 0 self) ; "Quietly, Orpheus. No one is watching."
			)
			(50
				(orpheus setCycle: CT 4 -1 self)
			)
			(51
				(orpheus view: 150 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(52
				(rope view: 150 setCycle: End self)
				(orpheus setCycle: End self)
			)
			(53)
			(54
				(rope loop: 3 cel: 0)
				(orpheus setCycle: Beg self)
			)
			(55
				(gMessager say: 27 0 40 1 self) ; "Stay low. Keep going!"
			)
			(56
				(orpheus setCycle: End self)
			)
			(57
				(orpheus setCycle: Beg self)
			)
			(58
				(orpheus view: 150 loop: 5 cel: 4 setCycle: Beg self)
				(rope setCycle: End self)
			)
			(59)
			(60
				(= seconds 3)
			)
			(61
				(orpheus posn: 251 185 loop: 6 cel: 0 setCycle: End self)
			)
			(62
				(gMessager say: 27 0 41 0 self) ; "I'm done! Let's get out of here, Morpheus. I'm scared."
			)
			(63
				(gGameSound1 fade: 30 2 2 1 self)
				(gGameSound2 fade: 30 2 2 1 self)
			)
			(64)
			(65
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sDadInterim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (gCurrentRegionFlags test: 3)
					(gMessager say: 19 0 0 1 self) ; "Son! I found something I mailed to you! Come open it."
				else
					(gMessager say: 19 0 46 1 self) ; "Go on! Try out the Ecorder! There's something about the launch..."
				)
			)
			(2
				(if (gCurrentRegionFlags test: 3)
					(dad setScript: sDadCalls)
				else
					(dad setScript: sDadEcorder)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDadCalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 300)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 19 0 45 1 self) ; "Come over here and open up your surprise!"
			)
			(2
				(client setScript: self)
			)
		)
	)
)

(instance sDadEcorder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 300)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 19 0 46 1 self) ; "Go on! Try out the Ecorder! There's something about the launch..."
			)
			(2
				(client setScript: self)
			)
		)
	)
)

(instance sYakYak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(if (< (client detailLevel:) (gGame detailLevel:))
					(client startUpd: setCycle: RandCycle)
					(= seconds (Random 3 5))
				else
					(client stopUpd:)
					(= state 0)
					(= cycles 1)
				)
			)
			(2
				(client setCel: 0)
				(= cycles 1)
			)
			(3
				(client stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance gagman of Actor
	(properties
		x 97
		y 164
		noun 15
		view 105
		signal 8192
	)
)

(instance things3 of Actor
	(properties
		view 105
		loop 4
		priority 13
		signal 26640
		illegalBits 0
	)
)

(instance slaughter of Actor
	(properties
		x 76
		y 156
		noun 20
		view 101
		loop 2
		priority 12
		signal 17
	)
)

(instance dad of Actor
	(properties
		x 56
		y 148
		noun 19
		view 101
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((gCurrentRegionFlags test: 4)
						(gMessager say: 19 2 46 0) ; "Go ahead, try the Ecorder!"
					)
					((and (gCurrentRegionFlags test: 3) (gAddToPics contains: box1))
						(gMessager say: 19 2 13 0) ; "Are we ready to leave yet?"
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: 19 2 45 0) ; "I'll give you a hint -- it has a computer chip. Come open the package."
					)
					((gCurrentRegionFlags test: 1)
						(gMessager say: 19 2 16 0) ; "Look around, son. I've really got to straighten out this list."
					)
					(else
						(gMessager say: 19 2 10 0) ; "Can we leave for the jungle right away?"
					)
				)
			)
			(1 ; Look
				(cond
					((gCurrentRegionFlags test: 4)
						(gMessager say: 19 1 46 0) ; "Dad waits impatiently for Adam to try out the Ecorder."
					)
					((and (gCurrentRegionFlags test: 3) (gAddToPics contains: box1))
						(gMessager say: 19 1 16 0) ; "Adam's Dad is checking the supplies for the journey into the rainforest."
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: 19 1 45 0) ; "Dad is waiting for Adam to open the package."
					)
					((gCurrentRegionFlags test: 1)
						(gMessager say: 19 1 16 0) ; "Adam's Dad is checking the supplies for the journey into the rainforest."
					)
					(else
						(gMessager say: 19 1 10 0) ; "Dad kneels by his suitcase. His things are pretty messy after the long flight to Iquitos."
					)
				)
			)
			(4 ; Do
				(cond
					((gCurrentRegionFlags test: 4)
						(gMessager say: 19 4 46 0) ; "Go ahead! Try the Ecorder out over there. I think there's something about the launch..."
					)
					((and (gCurrentRegionFlags test: 3) (gAddToPics contains: box1))
						(gMessager say: 19 4 16 0) ; "Dad looks busy. I'd better not bother him."
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: 19 4 45 0) ; "I remember what I sent you! Come open the package."
					)
					((gCurrentRegionFlags test: 1)
						(gMessager say: 19 4 16 0) ; "Dad looks busy. I'd better not bother him."
					)
					(else
						(gMessager say: 19 4 10 0) ; "Dad's rearranging his stuff. Adam really can't help."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance official of Actor
	(properties
		x 54
		y 161
		noun 26
		view 101
		loop 3
		priority 15
		signal 20497
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; passport
				(cond
					((gCurrentRegionFlags test: 0)
						(gMessager say: 26 4 24 0) ; "Move on, young man. I'm doing important work here."
					)
					((== ((gInventory at: 1) cel:) 1) ; passport
						(if (IsFlag 3)
							((gGame script:) cue:)
						)
						(gGame points: 10)
						(gCurrentRegionFlags set: 0)
						(gCurRoom setScript: sAdamEntersCountry)
					)
					(else
						(gMessager say: 26 8 0 0) ; "I'm not here to sort your papers, young man."
					)
				)
			)
			(4 ; Do
				(if (gCurrentRegionFlags test: 0)
					(gMessager say: 26 4 24 0) ; "Move on, young man. I'm doing important work here."
				)
			)
			(2 ; Talk
				(if (gCurrentRegionFlags test: 0)
					(gMessager say: 26 2 13 0) ; "I've checked your passport. Move along now!"
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 0)
					(gMessager say: 26 1 24) ; "The customs officer is dozing in the sun."
				else
					(gMessager say: 26 1 10 1) ; "A bored customs official checks passports. He seems to have had too much sun."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or
					(gEgo inRect: 39 138 56 141)
					(gEgo inRect: 130 163 139 179)
				)
				(== (gCurRoom script:) sCountdown)
				(not (gEgo script:))
			)
			(gEgo setScript: sComeBack)
		)
	)
)

(instance boatman of Actor
	(properties
		x 188
		y 140
		noun 24
		view 101
		loop 4
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurrentRegionFlags test: 1)
					(gMessager say: 24 4 16 0) ; "Nicanor looks too busy. I'd better not bother him."
				else
					(gMessager say: 24 4 10 0) ; "Poking strangers isn't a good idea."
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 1)
					(gMessager say: 24 1 16 0) ; "Nicanor is checking off his list against the crates ready for loading."
				else
					(gMessager say: 24 1 10 0) ; "A man holds a sign that says "Noah and Adam Greene.""
				)
			)
			(2 ; Talk
				(cond
					((gCurrentRegionFlags test: 1)
						(gMessager say: 24 2 16 0) ; "Are we going soon?"
					)
					((gCurrentRegionFlags test: 0)
						(gGame points: 1)
						(gCurRoom setScript: sDadBoatmanToon)
					)
					(else
						(gMessager say: 24 2 10 1) ; "Get a little closer."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (and (not (gCurrentRegionFlags test: 1)) (< (gEgo distanceTo: boatman) 40))
			(gCurRoom setScript: sDadBoatmanToon)
		)
		(super doit:)
	)
)

(instance thug2 of Actor
	(properties
		x 145
		y 132
		noun 28
		view 151
		signal 20480
		scaleSignal 1
	)
)

(instance plane of Prop
	(properties
		x 85
		y 62
		noun 14
		view 100
		signal 20481
		cycleSpeed 64
		detailLevel 2
	)
)

(instance package of Prop
	(properties
		x 243
		y 153
		noun 22
		approachX 245
		approachY 145
		view 100
		loop 7
		signal 20481
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (gCurrentRegionFlags test: 3) (gAddToPics contains: box1))
						(gMessager say: 23 4 0 1) ; "The expedition's crates are off-limits to Adam."
					)
					((gCurrentRegionFlags test: 3)
						(gGame points: 5)
						(gCurRoom setScript: sAdamOpensPackage)
					)
					((gCurrentRegionFlags test: 4) 0)
					(else
						(gMessager say: 23 4 0 1) ; "The expedition's crates are off-limits to Adam."
					)
				)
			)
			(1 ; Look
				(cond
					((and (gCurrentRegionFlags test: 3) (gAddToPics contains: box1))
						(gMessager say: 23 1 0 1) ; "A jumble of crates is piled by the canoe."
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: 22 1 25 1) ; "It's a package addressed to Adam."
					)
					((gCurrentRegionFlags test: 4)
						(gMessager say: 22 1 25 1) ; "It's a package addressed to Adam."
					)
					(else
						(gMessager say: 23 1 0 1) ; "A jumble of crates is piled by the canoe."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canoe of Prop
	(properties
		x 206
		y 154
		noun 25
		view 100
		loop 8
		signal 20481
		detailLevel 2
	)
)

(instance gossip1 of Prop
	(properties
		x 119
		y 91
		noun 12
		approachX 147
		approachY 144
		view 118
		priority 6
		signal 20496
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(gCurRoom setScript: sTalkToGossips)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gossip2 of Prop
	(properties
		x 143
		y 139
		noun 12
		view 118
		loop 1
		priority 8
		signal 20496
		detailLevel 2
	)

	(method (doVerb theVerb)
		(gossip1 doVerb: theVerb)
	)
)

(instance briefcase of Prop
	(properties
		x 82
		y 150
		view 105
		loop 3
		priority 15
		signal 16
	)
)

(instance morpheus of Prop
	(properties
		x 278
		y 185
		view 150
		loop 7
		signal 16384
	)
)

(instance orpheus of Prop
	(properties
		x 287
		y 166
		view 150
		loop 5
		priority 15
		signal 16400
	)
)

(instance rope of Prop
	(properties
		x 271
		y 153
		noun 25
		view 150
		loop 2
		signal 20481
	)
)

(instance waterRipple of Prop
	(properties
		x 287
		y 156
		view 100
		loop 13
		signal 16384
		detailLevel 2
	)
)

(instance gagmanLeg of View
	(properties
		x 109
		y 166
		view 105
		loop 8
		signal 18433
	)
)

(instance box1 of View
	(properties
		x 251
		y 143
		noun 23
		view 100
		loop 12
		signal 20481
	)
)

(instance dadsuitcase of View
	(properties
		x 154
		y 171
		noun 21
		view 102
		loop 3
		priority 14
		signal 20497
	)
)

(instance stool of View
	(properties
		x 52
		y 159
		view 106
		loop 7
		priority 15
		signal 20497
	)
)

(instance stampPad of View
	(properties
		x 73
		y 157
		noun 26
		view 101
		loop 5
		cel 1
		priority 14
		signal 20497
	)
)

(instance prop1 of View ; UNUSED
	(properties
		x 90
		y 59
		noun 14
		view 100
		loop 1
		cel 3
		signal 16384
	)
)

(instance desk of Feature
	(properties
		x 67
		y 153
		noun 1
		onMeCheck 2
		approachX 67
		approachY 153
	)

	(method (init)
		(self setOnMeCheck: 1 2)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (gCurrentRegionFlags test: 1)
			(if
				(and
					(OneOf ((ScriptID 0 9) cel:) 0) ; eco2Cursor
					(or
						(and
							(== (event type:) evMOUSEBUTTON)
							(not (& (event modifiers:) emSHIFT))
							(not (& (event modifiers:) emCTRL))
						)
						(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					)
				)
				(if (desk onMe: event)
					(event claimed: 1)
					(gEgo setMotion: PolyPath 137 155)
					(super handleEvent: event)
				else
					0
				)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance fence of Feature
	(properties
		x 73
		y 108
		noun 2
		onMeCheck 4
		approachX 73
		approachY 108
	)
)

(instance shed of Feature
	(properties
		x 15
		y 129
		noun 3
		onMeCheck 256
		approachX 15
		approachY 129
	)
)

(instance shacksign of Feature
	(properties
		x 21
		y 76
		noun 4
		onMeCheck 1024
		approachX 21
		approachY 76
	)
)

(instance town of Feature
	(properties
		x 230
		y 22
		noun 5
		onMeCheck 64
		approachX 230
		approachY 22
	)
)

(instance umbrella of Feature
	(properties
		x 271
		y 58
		noun 6
		onMeCheck 16
		approachX 271
		approachY 58
	)
)

(instance jungle of Feature
	(properties
		x 25
		y 22
		noun 7
		onMeCheck 2048
		approachX 25
		approachY 22
	)
)

(instance river of Feature
	(properties
		x 74
		y 41
		noun 8
		onMeCheck 128
		approachX 74
		approachY 41
	)
)

(instance water of Feature
	(properties
		x 246
		y 173
		noun 9
		onMeCheck 16384
		approachX 246
		approachY 173
	)
)

(instance shop of Feature
	(properties
		x 275
		y 102
		noun 18
		onMeCheck 32
		approachX 275
		approachY 102
	)
)

(instance fruit of Feature
	(properties
		x 189
		y 97
		noun 17
		nsTop 68
		nsLeft 169
		nsBottom 127
		nsRight 209
		approachX 189
		approachY 97
	)
)

(instance pier of Feature
	(properties
		x 304
		y 156
		noun 13
		nsTop 137
		nsLeft 286
		nsBottom 150
		nsRight 319
		approachX 304
		approachY 156
	)
)

(instance pierControl of Feature
	(properties
		x 304
		y 156
		noun 13
		onMeCheck 8192
		approachX 304
		approachY 156
	)
)

(instance popstand of Feature
	(properties
		x 130
		y 125
		noun 16
		onMeCheck 8
		approachX 130
		approachY 125
	)
)

(instance customsArea of Feature
	(properties
		x 67
		y 153
		noun 27
		onMeCheck 4096
	)

	(method (init)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf ((ScriptID 0 9) cel:) 0) ; eco2Cursor
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(if (customsArea onMe: event)
				(event claimed: 1)
				(gEgo setMotion: PolyPath 137 155)
				(super handleEvent: event)
			else
				0
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 82
		nsLeft 310
		nsBottom 134
		nsRight 320
		cursor 11
		exitDir 2
	)
)

(instance eastExit2 of ExitFeature
	(properties
		nsTop 158
		nsLeft 310
		nsBottom 165
		nsRight 320
		cursor 11
		exitDir 2
	)
)

(instance changePoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance bmPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance customsPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance gossipTalker of Narrator
	(properties
		back 90
	)

	(method (init)
		(self x: 125 y: 40 font: gUserFont keepWindow: 1)
		(super init:)
	)
)

(instance sLocalSnd of Sound
	(properties)
)

(instance sLocalSnd2 of Sound
	(properties)
)

