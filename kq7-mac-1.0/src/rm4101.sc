;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4101)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use scaryInvInit)
(use eastFeat)
(use Talker)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4101 0
	WIBWeeps 3
	elspethTalker 46
	countTalker 59
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm4101 of KQRoom
	(properties
		modNum 4100
		picture 4101
		horizon 70
	)

	(method (init)
		(super init:)
		(SetFlag 55)
		(Load rsMESSAGE 4100)
		(= local5 0)
		(= local3 gFtrInitializer)
		(= gFtrInitializer roomFeatureInitCode)
		(gEgo init: normalize:)
		(= local6 0)
		(gEgo setScaler: Scaler 100 83 101 84)
		(switch gPrevRoomNum
			(4350
				(gEgo posn: 262 220)
			)
			(4000
				(gEgo posn: 282 95 setPri: 90)
				(= local6 1)
				(gEgo setScaler: Scaler 100 76 109 94)
			)
			(4110
				(SetFlag 219)
				(gEgo setPri: 69 posn: 101 77)
			)
			(else
				(gEgo posn: 330 130)
				(= local6 1)
				(gEgo setScaler: Scaler 100 76 109 94)
			)
		)
		(cond
			((IsFlag 220)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 204 111 71 80 63 84 35 78 35 103 148 137 320 138 320 124 279 124 258 111 288 95 274 95
							yourself:
						)
				)
			)
			((not (IsFlag 219))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 204 111 77 89 57 87 35 78 35 103 148 137 320 138 320 124 279 124 258 111 288 95 274 95
							yourself:
						)
				)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 204 111 83 79 63 84 35 78 35 103 148 137 320 138 320 124 279 124 258 111 288 95 274 95
							yourself:
						)
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 97 95 178 109 150 125 76 104
					yourself:
				)
		)
		(switch gChapter
			(4
				(= local0 8)
				(womanInBlack setPri: 85 init: setScript: mornWIB)
			)
			(5
				(= local0 10)
				(= local5 (gEgo has: 75)) ; Horseman_s_Head
				(cond
					((not (IsFlag 219))
						(if (gEgo has: 73) ; Horseman_s_Medal
							(womanInBlack
								view: 4123
								setLoop: 1 1
								cel: 0
								x: 73
								y: 92
								setPri: 85
								init:
								setScript: mornWIBStanding
							)
						else
							(womanInBlack
								view: 4122
								setPri: 85
								init:
								setScript: mornWIB
							)
						)
					)
					((not (IsFlag 220))
						(keyHole init:)
					)
				)
				(wrongSpot init:)
			)
		)
		(stone1 init:)
		(stone2 init:)
		(stone3 init:)
		(stone4 init:)
		(stone5 init:)
		(tombDoor1 init: setPri: 70)
		(if (IsFlag 220)
			(tombDoor init:)
			(keyHole dispose:)
			(tombDoor1 cel: 2)
		)
		(myNWExit init:)
		(myEastExit init:)
		(myLeftSouthExit init:)
		(horseman init: hide:)
		(if (not (IsFlag 224))
			(horseManTimer setReal: horseManTimer 15)
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(if
			(and
				(!= gPrevRoomNum 4102)
				(or
					(!= (gKqMusic1 number:) 4100)
					(== (gKqMusic1 prevSignal:) -1)
				)
			)
			(gKqMusic1 number: 4100 loop: -1 play:)
		)
		(gCurRoom setScript: sEnter)
	)

	(method (doit)
		(if (and local6 (< (gEgo x:) 220))
			(= local6 0)
			(gEgo setScaler: Scaler 100 83 101 84)
		)
		(if (and (not local6) (> (gEgo x:) 220))
			(= local6 1)
			(gEgo setScaler: Scaler 100 76 109 94)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 4102) (not (gKqMusic1 handle:)))
			(gKqMusic1 number: 4100 loop: -1 play:)
		)
		(if (or (== (gKqSound1 number:) 4101) (not (gKqSound1 handle:)))
			(gKqSound1 stop:)
		)
		(if (!= newRoomNumber 4102)
			(gKqMusic1 fade:)
		)
		(= gFtrInitializer local3)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(horseManTimer client: 0 delete: dispose:)
		(super dispose:)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(4350
						(gEgo setMotion: MoveTo (gEgo x:) 136 self)
					)
					(4000
						(gEgo setLoop: 2 1)
						(= cycles 1)
					)
					(4110
						(gEgo setMotion: MoveTo 85 78 self)
					)
					(else
						(gEgo setMotion: MoveTo 314 130 self)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(4000
						(gEgo setPri: -1 setMotion: MoveTo 261 105 self)
					)
					(4110
						(gEgo setPri: -1 setMotion: MoveTo 85 85 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mornWIB of Script
	(properties)

	(method (dispose)
		(WIBWeeps stop:)
		(womanInBlack setCycle: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(womanInBlack view: 4122 setLoop: 0 1 cel: 0 setCycle: Fwd)
				(WIBWeeps play: self)
			)
			(1
				(womanInBlack setCycle: 0)
				(= state -1)
				(= cycles (Random 100 200))
			)
		)
	)
)

(instance mornWIBStanding of Script
	(properties)

	(method (dispose)
		(WIBWeeps stop:)
		(womanInBlack setCycle: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(womanInBlack
					view: 4123
					setLoop: 1 1
					cel: 0
					setCycle: ROsc -1 0 1
				)
				(WIBWeeps play: self)
			)
			(1
				(womanInBlack setCycle: 0)
				(= state -1)
				(= cycles (Random 200 400))
			)
		)
	)
)

(instance exitToEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 330 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance exitToLeftSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath local7 local8 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 220 self)
			)
			(3
				(gCurRoom newRoom: 4350)
			)
		)
	)
)

(instance exitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: 6 1)
				(= cycles 6)
			)
			(1
				(gCurRoom newRoom: 4000)
			)
		)
	)
)

(instance womanKillsRose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 818)
				(gEgo setHeading: 315 self)
			)
			(1
				(elspethTalker clientCel: -2 hide_mouth: 1)
				(WIBWeeps stop:)
				(gMessager sayRange: 3 8 8 1 2 self 4100) ; "(KINDLY)Are you all right, ma'am? Can I help you?"
			)
			(2
				(womanInBlack
					view: 4114
					setLoop: 3
					cel: 0
					posn: 90 88
					setCycle: End self
				)
			)
			(3
				((ScriptID 13 0) modeless: 2 hide_mouth: 1) ; aEgoTalker
				(gEgo setCycle: ROsc -1 2 5)
				(gMessager say: 3 8 8 3 self 4100) ; "(TERRIFIED SCREAM)EEEEEEEEEEEEEE!"
				(gEgo
					view: 41142
					setLoop: 4
					posn: 100 96
					cel: 0
					setCycle: CT 7 1
				)
			)
			(4
				(elspethTalker clientCel: 19 hide_mouth: 0)
				((ScriptID 13 0) modeless: 1 hide_mouth: 0) ; aEgoTalker
				(= cycles 6)
			)
			(5
				(EgoDead 33 self)
			)
			(6
				(gEgo normalize: 2 posn: 135 100)
				(womanInBlack
					view: 4114
					setLoop: 0
					cel: 0
					posn: 89 89
					setCycle: Fwd
				)
				(WIBWeeps play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance womanKillsVal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 4123)
				(gEgo setHeading: 315 self)
			)
			(1
				(elspethTalker hide_mouth: 1 clientCel: -2)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(WIBWeeps stop:)
				(= cycles 1)
			)
			(2
				(gMessager sayRange: 3 8 10 1 2 self 4100) ; "(CONCERNED)My lady, are you ill?"
			)
			(3
				(if (gEgo has: 73) ; Horseman_s_Medal
					(womanInBlack
						view: 4123
						loop: 4
						cel: 0
						posn: 50 90
						setCycle: End self
					)
				else
					(womanInBlack
						view: 4114
						setLoop: 3
						cel: 0
						posn: 90 88
						setCycle: End self
					)
				)
			)
			(4
				(sDoor number: 41080 loop: 1 play:)
				(gEgo
					view: 41222
					loop: 1
					cel: 0
					posn: 134 100
					setCycle: End self
				)
			)
			(5
				(sDoor number: 41081 loop: 1 play: self)
			)
			(6
				(elspethTalker clientCel: 19 hide_mouth: 0)
				((ScriptID 13 0) modeless: 1 hide_mouth: 0) ; aEgoTalker
				(= cycles 1)
			)
			(7
				(EgoDead 32 self)
			)
			(8
				(WIBWeeps play:)
				((ScriptID 13 0) hide_mouth: 0 modeless: 1) ; aEgoTalker
				(gEgo normalize: 7 posn: 127 100)
				(if (gEgo has: 73) ; Horseman_s_Medal
					(womanInBlack
						view: 4123
						setLoop: 1 1
						cel: 0
						x: 73
						y: 92
						setScript: mornWIBStanding
					)
				else
					(womanInBlack
						view: 4114
						setLoop: 0
						cel: 0
						posn: 89 89
						setScript: mornWIB
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance womanTakesMedal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 204 111 83 79 63 84 35 78 35 103 148 137 320 138 320 124 279 124 258 111 288 95 274 95
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 97 95 178 109 150 125 76 104
							yourself:
						)
				)
				(elspethTalker clientCel: -2 hide_mouth: 1)
				(womanInBlack
					view: 4123
					loop: 1
					cel: 0
					x: 73
					y: 92
					setCycle: End self
				)
			)
			(1
				(gMessager say: 3 89 10 0 self 4100) ; "Here you go."
			)
			(2
				(elspethTalker clientCel: 19 hide_mouth: 0)
				(gEgo hide:)
				(womanInBlack
					view: 4123
					loop: 0
					cel: 0
					x: 135
					y: 102
					setPri: 90
					setCycle: End self
				)
			)
			(3
				(gEgo show:)
				(WIBWeeps number: 41082 loop: 1 play:)
				(womanInBlack
					view: 4123
					loop: 3
					cel: 0
					x: 120
					y: 96
					setCycle: CT 63 1 self
				)
			)
			(4
				(sReunion number: 940 loop: 1 play:)
				(womanInBlack view: 4123 loop: 3 setCycle: End self)
			)
			(5
				(womanInBlack dispose:)
				(gEgo
					put: 73 ; Horseman_s_Medal
					normalize: 5
					posn: (womanInBlack approachX:) (womanInBlack approachY:)
				)
				(SetFlag 219)
				(keyHole init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goIntoTomb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 69 setMotion: MoveTo 101 77 self)
			)
			(1
				(gCurRoom newRoom: 4110)
			)
		)
	)
)

(instance blowOffLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4001 6) client: 0 delete: dispose:) ; firecrackerTimer
				(Load 140 41090) ; WAVE
				(Load 140 41091) ; WAVE
				(Load 140 41092) ; WAVE
				(= cycles 6)
			)
			(1
				(gEgo
					view: 4125
					setLoop: 0 1
					cel: 0
					posn: 82 85
					setScale: 0
					setCycle: End self
				)
				(sBlows number: 41090 loop: -1 play:)
			)
			(2
				(gEgo setLoop: 1 1 cel: 5 posn: 65 92 setCycle: CT 29 1 self)
			)
			(3
				(sBlows number: 41091 loop: 1 play:)
				(sExplosion number: 41092 loop: 1 play:)
				(gEgo setCycle: ROsc -1 30 35)
				(tombDoor1 setCycle: End)
				(explosion init: posn: 88 53 setPri: 150 setCycle: End self)
			)
			(4
				(explosion dispose:)
				(gEgo put: 74 setCycle: End self) ; Firecracker
			)
			(5
				(gEgo cel: 0 setCycle: CT 4 1 self)
			)
			(6
				(gEgo
					normalize: 6
					posn: 78 87
					setScaler: Scaler 100 83 101 84
				)
				(tombDoor init:)
				(keyHole dispose:)
				(tombDoor1 setHotspot: 0)
				(SetFlag 220)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance horsemanRidesThrough of Script
	(properties)

	(method (dispose)
		(gKqSound1 dispose:)
		(if (not (IsFlag 219))
			(WIBWeeps play:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 338)
				(gEgo disableHotspot:)
				((ScriptID 4001 5) client: 0 delete: dispose:) ; boogeyShowTimer
				((ScriptID 4001 6) client: 0 delete: dispose:) ; firecrackerTimer
				(horseManTimer setReal: horseManTimer 60)
				(gKqMusic1 stop:)
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				(horseSound number: 4101 loop: -1 play:)
				(= seconds 2)
			)
			(1
				(horseman
					view: 4116
					setLoop: 0 1
					setCel: 0
					x: 309
					y: 49
					setPri: 1
					cycleSpeed: 15
					setHotspot: 0 93 ; Horseman_s_Head
					show:
					setCycle: CT 14 1 self
				)
			)
			(2
				(horseman hide: setHotspot: 0)
				(FrameOut)
				(cond
					((and (gCurRoom script:) ((ScriptID 4001 0) script:)) ; OogaBooga
						(horseSound fade:)
						(gKqSound1 stop:)
						(gKqMusic1 play:)
						(horseManTimer setReal: horseManTimer 60)
						((ScriptID 4001 5) setReal: self (Random 30 50)) ; boogeyShowTimer
						(if
							(and
								(gEgo has: 74) ; Firecracker
								(!= (gCurRoom script:) blowOffLock)
							)
							((ScriptID 4001 6) setCycle: (ScriptID 4001 6) 6000) ; firecrackerTimer, firecrackerTimer
						)
						(horseman hide:)
						(self dispose:)
					)
					((and local2 (wrongSpot onMe: gEgo))
						(gCurRoom setScript: reunionScript)
					)
					(else
						(gKqSound1 number: 4103 loop: -1 play:)
						(= seconds 3)
					)
				)
			)
			(3
				(if (and (gCurRoom script:) ((ScriptID 4001 0) script:)) ; OogaBooga
					(horseSound fade:)
					(gKqSound1 stop:)
					(gKqMusic1 play:)
					(horseManTimer setReal: horseManTimer 60)
					((ScriptID 4001 5) setReal: self (Random 30 50)) ; boogeyShowTimer
					(if
						(and
							(gEgo has: 74) ; Firecracker
							(!= (gCurRoom script:) blowOffLock)
						)
						((ScriptID 4001 6) setCycle: (ScriptID 4001 6) 6000) ; firecrackerTimer, firecrackerTimer
					)
					(horseman hide:)
					(self dispose:)
				else
					(horseman setPri: 99 posn: 316 48 show:)
					(horseman
						cycleSpeed: 6
						setLoop: 0 1
						setCel: 15
						setCycle: CT 27 1 self
					)
					(if (wrongSpot onMe: gEgo)
						(gGame handsOff:)
						(sBlows number: 41081 loop: 1 play:)
						(gEgo
							show:
							normalize: (gEgo loop:)
							setMotion: PolyPath 250 140
						)
					)
				)
			)
			(4
				(if (wrongSpot onMe: gEgo)
					(horseman setPri: 100)
					(gCurRoom setScript: runOverVal)
				else
					(sBlows number: 4102 loop: 1 play:)
					(horseman
						setLoop: 0 1
						setCel: 27
						setPri: 113
						cycleSpeed: 6
						setCycle: CT 35 1 self
					)
				)
			)
			(5
				(horseman hide:)
				((ScriptID 4001 5) setReal: self (Random 30 50)) ; boogeyShowTimer
				(if (and (gEgo has: 74) (!= (gCurRoom script:) blowOffLock)) ; Firecracker
					((ScriptID 4001 6) setCycle: (ScriptID 4001 6) 6000) ; firecrackerTimer, firecrackerTimer
				)
				(horseSound fade:)
				(gKqSound1 stop:)
				(gKqMusic1 play:)
				(ClearFlag 338)
				(gEgo enableHotspot:)
				(horseManTimer setReal: horseManTimer 60)
				(self dispose:)
			)
		)
	)
)

(instance runOverVal of Script
	(properties)

	(method (dispose)
		(if (not (IsFlag 219))
			(WIBWeeps play:)
		)
		(horseManTimer setReal: horseManTimer 60)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(horseman setCycle: End horseman)
				(gEgo
					view: 4116
					loop: 1
					cel: 0
					x: 254
					y: 140
					priority: 140
					fixPriority: 1
					setCycle: End self
				)
			)
			(1
				(sBlows stop:)
				(= cycles 1)
			)
			(2
				(EgoDead 34 self)
			)
			(3
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gEgo posn: 245 122 normalize: 1)
				(horseSound fade:)
				(gKqSound1 stop:)
				(gKqMusic1 play:)
				(horseManTimer setReal: horseManTimer 60)
				(ClearFlag 338)
				(gEgo enableHotspot:)
				(gGame handsOn:)
				(horseman hide:)
				(self dispose:)
			)
		)
	)
)

(instance horsemanFlysOverhead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo show: setMotion: 0)
				(if
					(and
						(not (gCurRoom script:))
						(not ((ScriptID 4001 0) script:)) ; OogaBooga
						(gUser canControl: 1)
					)
					(proc11_3 gEgo horseman 0)
				)
				(gKqMusic1 stop:)
				(horseSound play:)
				(horseman
					view: 4113
					setLoop: 0
					cel: 0
					posn: 228 80
					setPri: 10
					show:
					setCycle: End self
				)
				(horsemanShadow
					view: 4113
					setLoop: 1
					cel: 0
					posn: 228 80
					setPri: 150
					init:
					setCycle: End
				)
			)
			(1
				(horseman hide:)
				(horsemanShadow hide: dispose:)
				(horseSound fade:)
				(gKqMusic1 play:)
				(self dispose:)
			)
		)
	)
)

(instance reunionScript of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsVIEW 4117)
					(Load rsVIEW 41171)
					(Load rsVIEW 41175)
					(Load rsVIEW 4118)
					(Load rsVIEW 4119)
					(Load rsVIEW 4120)
					(Load rsVIEW 4121)
					(= cycles 6)
				)
				(1
					(gEgo setMotion: PolyPath 237 119 self)
				)
				(2
					(sBlows number: 4103 loop: -1 play:)
					(gEgo
						loop: 0
						priority: 121
						fixPriority: 1
						setHeading: 0 self
					)
				)
				(3
					(horseman
						view: 41175
						loop: 2
						cel: 0
						x: 286
						y: 96
						setPri: 99
						init:
						setCycle: CT 13 1 self
					)
				)
				(4
					(gEgo
						view: 4117
						loop: 0
						cel: 0
						x: 244
						y: 117
						setCycle: CT 17 1 self
					)
				)
				(5
					(sBlows stop:)
					(horseman loop: 2 cel: 13 setCycle: CT 19 1 self)
					(sExplosion number: 4104 loop: 1 play:)
				)
				(6
					(horseman loop: 2 cel: 19 setCycle: End self)
				)
				(7
					(horse
						view: 41171
						loop: 1
						cel: 0
						x: 286
						y: 97
						priority: (- (horseman priority:) 1)
						fixPriority: 1
						init:
						setCycle: End
					)
					(horseman view: 41171 loop: 0 cel: 0 x: 224 y: 109)
					(gEgo setCycle: CT 20 1 self)
				)
				(8
					(gEgo hide:)
					(horseman
						view: 4117
						loop: 1
						cel: 0
						x: 247
						y: 115
						setCycle: End self
					)
				)
				(9
					(horseman
						view: 41175
						loop: 3
						cel: 0
						x: 222
						y: 82
						setCycle: End self
					)
					(gEgo
						show:
						setLoop: 0
						cel: 21
						x: 245
						y: 115
						put: 75 ; Horseman_s_Head
						setPri: 130
						setCycle: End self
					)
				)
				(10 0)
				(11
					(sSFX number: 2490 loop: 1 play:)
					(horseman
						view: 4118
						loop: 1
						cel: 0
						x: 224
						y: 84
						priority: 127
						setCycle: CT 14 1 self
					)
					(gEgo
						view: 4120
						loop: 3
						cel: 0
						x: 245
						y: 115
						priority: 126
						fixPriority: 1
					)
				)
				(12
					(sReunion number: 41040 loop: -1 play:)
					(horseman loop: 1 setCycle: End)
					(gEgo
						view: 800
						setLoop: 5 1
						cel: 0
						x: 249
						y: 105
						priority: 126
						fixPriority: 1
						setCycle: Rev
						setMotion: MoveTo 257 106 self
					)
				)
				(13
					(gEgo
						view: 4120
						loop: 3
						cel: 0
						x: 256
						y: 108
						priority: 126
						fixPriority: 1
						setCycle: 0
					)
					(horseman
						view: 4118
						loop: 2
						cel: 0
						x: 223
						y: 84
						setCycle: CT 12 1 self
					)
				)
				(14
					(sReunion stop:)
					(horseman view: 4118 loop: 2 cel: 12 setCycle: CT 16 1 self)
				)
				(15
					(horseman setLoop: 2 1 setCycle: End self)
				)
				(16
					(gMessager say: 0 0 9 1 self 4100) ; "(SLOWLY, AS IF HE HASN'T SPOKEN IN A LONG TIME)You haff lifted the curse that vas placed on my, my lady. I am deeply indebted to you."
				)
				(17
					(dog
						view: 4118
						setLoop: 3 1
						cel: 0
						x: 161
						y: 108
						priority: 130
						fixPriority: 1
						init:
						setCycle: CT 2 1 self
					)
				)
				(18
					(dog setScript: getDownDog)
					(horseman
						view: 4118
						loop: 0
						cel: 0
						x: 214
						y: 83
						setCycle: End self
					)
				)
				(19
					(countTalker clientCel: -1 loop: -1)
					(gMessager say: 0 0 9 2 self 4100) ; "(DELIGHTED)Black Valient!"
				)
				(20
					(getDownDog cue:)
					(sReunion stop:)
					(horseman
						view: 4118
						loop: 4
						cel: 0
						x: 219
						y: 82
						setCycle: End self
					)
				)
				(21
					(sBlows number: 4105 loop: -1 play:)
					(womanInBlack
						view: 4119
						setLoop: 0 1
						cel: 0
						x: 108
						y: 131
						setPri: 100
						init:
						setCycle: CT 6 1 self
					)
				)
				(22
					(womanInBlack setPri: 134)
					(horseman
						view: 4119
						setLoop: 1 1
						cel: 0
						x: 177
						y: 123
						setCycle: CT 3 1 self
					)
				)
				(23
					(countTalker hide_mouth: 1 modeless: 2 clientCel: -2)
					(elspethTalker client: womanInBlack modeless: 2)
					(self setScript: countAndWifeUnite self)
					(gMessager sayRange: 0 0 9 3 4 self 4100) ; "(MURMURING IN ADORATION)Elspeth, my Elspeth. How I haff missed you, my love."
				)
				(24 0)
				(25
					(countTalker modeless: 1 clientCel: -1)
					(horseman setCycle: End self)
					(gEgo
						view: 4120
						loop: 3
						cel: 0
						x: 249
						y: 108
						priority: 128
						fixPriority: 1
						setCycle: End
					)
				)
				(26
					(horse view: 4120 loop: 5 cel: 0 x: 211 y: 115)
					(horseHead
						view: 4120
						loop: 4
						cel: 0
						x: 201
						y: 72
						priority: 126
						fixPriority: 1
						init:
						setCycle: CT 28 1 self
					)
				)
				(27
					(sExplosion number: 928 loop: 1 play:)
					(horseHead loop: 4 setCycle: End self)
				)
				(28
					(horseman
						view: 41205
						loop: 0
						cel: 0
						x: 153
						y: 119
						setCycle: CT 15 1 self
					)
				)
				(29
					(womanInBlack
						view: 41205
						loop: 0
						cel: 17
						x: 153
						y: 122
						show:
						setScript: relaxScript
					)
					(gKqMusic1 fade: 0 60 14 1)
					(horseman
						view: 4121
						loop: 0
						cel: 0
						x: 196
						y: 124
						priority: 130
						fixPriority: 1
						setCycle: CT 9 1 self
					)
				)
				(30
					(countTalker hide_mouth: 1 clientCel: -2)
					((ScriptID 13 0) view: 4120 loop: 23 clientCel: -2) ; aEgoTalker
					(gMessager sayRange: 0 0 9 5 6 self 4100) ; "You haff done me an immeasurable kindness. Tell me vat I can do for you in return."
				)
				(31
					(horseman setCycle: CT 17 1 self)
				)
				(32
					(gEgo hide:)
					(horseman cel: 18 setCycle: End self)
				)
				(33
					(countTalker clientCel: -1 loop: -1 hide_mouth: 0)
					(gMessager say: 0 0 9 7 self 4100) ; "Consider it done. I vill giff you the use of my horse. Here, take this fife. With it, you can call him to take you to Etheria. ONce there, you cannot summon him, for he vill not be able to hear you, but he vill alvays come to you anyvere on the surfacelands."
				)
				(34
					(horseman
						view: 4121
						loop: 1
						cel: 0
						x: 238
						y: 125
						setCycle: End self
					)
				)
				(35
					((ScriptID 13 0) ; aEgoTalker
						clientCel: -2
						client: horseman
						view: 4121
						loop: 23
						mouth_x: -50
						mouth_y: 4
					)
					(gMessager sayRange: 0 0 9 8 9 self 4100) ; "Thank you, Count."
				)
				(36
					(sBlows number: 4106 loop: -1 play:)
					((ScriptID 13 0) ; aEgoTalker
						clientCel: -1
						client: gEgo
						view: -1
						loop: -1
						mouth_x: -999
						mouth_y: -999
					)
					(horse dispose:)
					(horseHead dispose:)
					(gKqSound1 number: 4107 loop: 1 play:)
					(ClearFlag 338)
					(gEgo enableHotspot:)
					(gEgo
						view: 41210
						loop: 0
						cel: 0
						x: 188
						y: 128
						setPri: 99
						show:
						setCycle: End self
					)
					(horseman
						view: 4121
						loop: 3
						cel: 0
						x: 241
						y: 127
						priority: 170
						fixPriority: 1
						setCycle: End
					)
				)
				(37
					(gEgo get: 76) ; Horseman_s_Fife
					(SetFlag 224)
					(gCurRoom newRoom: 6200)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(if (gEgo has: 75) ; Horseman_s_Head
						(gEgo put: 75) ; Horseman_s_Head
					)
					(if (not (gEgo has: 76)) ; Horseman_s_Fife
						(gEgo get: 76) ; Horseman_s_Fife
					)
					(SetFlag 224)
					(gCurRoom newRoom: 6200)
				)
			)
		)
	)
)

(instance getDownDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sReunion number: 935 loop: -1 play:)
				(dog setCycle: CT 12 1)
			)
			(1
				(sExplosion number: 936 loop: 1 play:)
				(dog setCycle: End self)
			)
			(2
				(dog hide:)
				(self dispose:)
			)
		)
	)
)

(instance countAndWifeUnite of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(horseman setLoop: 1 1 setCycle: CT 7 1 self)
				)
				(1
					(self setScript: dismountHorse self)
					(womanInBlack
						setLoop: 0 1
						cycleSpeed: 9
						setCycle: CT 18 1 self
					)
				)
				(2
					(veil
						view: 4119
						setLoop: 2 1
						cel: 0
						x: 48
						y: 142
						priority: 150
						fixPriority: 1
						init:
						setCycle: End veil
					)
					(womanInBlack setLoop: 0 1 cel: 19 setCycle: End)
				)
				(3
					(horseSound stop:)
					(womanInBlack hide:)
					(horseman
						view: 4120
						loop: 0
						cel: 1
						x: 148
						y: 122
						cycleSpeed: 7
						setCycle: CT 19 1 self
					)
				)
				(4
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(if (gEgo has: 75) ; Horseman_s_Head
						(gEgo put: 75) ; Horseman_s_Head
					)
					(if (not (gEgo has: 76)) ; Horseman_s_Fife
						(gEgo get: 76) ; Horseman_s_Fife
					)
					(SetFlag 224)
					(gCurRoom newRoom: 6200)
				)
			)
		)
	)
)

(instance dismountHorse of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(horseman setLoop: 1 1 cycleSpeed: 9 setCycle: CT 12 1 self)
				)
				(1
					(dog
						show:
						view: 4120
						setLoop: 1 1
						cel: 0
						x: 228
						y: 124
						setCycle: End
					)
					(horseman
						setLoop: 1 1
						cel: 13
						priority: 127
						setCycle: End self
					)
				)
				(2
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(if (gEgo has: 75) ; Horseman_s_Head
						(gEgo put: 75) ; Horseman_s_Head
					)
					(if (not (gEgo has: 76)) ; Horseman_s_Fife
						(gEgo get: 76) ; Horseman_s_Fife
					)
					(SetFlag 224)
					(gCurRoom newRoom: 6200)
				)
			)
		)
	)
)

(instance relaxScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(womanInBlack
					view: 4121
					loop: 2
					cel: 0
					x: 128
					y: 128
					priority: 170
					fixPriority: 1
					setCycle: End
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance roseTalksAsWIB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(womanInBlack
					view: 4114
					setLoop: 3
					cel: 0
					posn: 90 88
					setCycle: End self
				)
			)
			(1
				(WIBWeeps stop:)
				(gMessager say: 3 8 5 0 self 4100) ; "(SOFTLY, TO HERSELF)I've been haunting this spot toooo loooooong!"
			)
			(2
				(womanInBlack setCycle: Beg self)
			)
			(3
				(WIBWeeps play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowDustOffLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8115)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 8115
					posn: 84 85
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 800
					setLoop: 6 1
					setCycle: Rev
					setMotion: MoveTo 73 89 self
				)
			)
			(3
				(gEgo posn: 72 89 normalize: 6)
				(= cycles 6)
			)
			(4
				(gMessager say: 0 8 18 0 self 4100) ; "It's locked."
			)
			(5
				(if (not (IsFlag 495))
					(gEgo
						view: 4124
						setLoop: 0 1
						cel: 0
						posn: 74 92
						setScale: 0
						setCycle: CT 12 1 self
					)
				else
					(SetFlag 495)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(6
				(sBlows number: 4109 loop: 1 play:)
				(gEgo loop: 0 cel: 12 setCycle: End self)
			)
			(7
				(gEgo
					normalize: 6
					setScaler: Scaler 100 83 101 84
					posn: 66 87
				)
				(= cycles 2)
			)
			(8
				(SetFlag 495)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStone1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(= cycles 1)
			)
			(1
				(gMessager say: 4 8 local0 0 self 4100)
			)
			(2
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStone2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(= cycles 1)
			)
			(1
				(gMessager say: 5 8 local0 0 self 4100)
			)
			(2
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStone3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(= cycles 2)
			)
			(1
				(gMessager say: 6 8 local0 0 self 4100)
			)
			(2
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStone4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(= cycles 1)
			)
			(1
				(gMessager say: 7 8 local0 0 self 4100)
			)
			(2
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sStone5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 360 self)
			)
			(1
				(if (not (IsFlag 219))
					(WIBWeeps stop:)
				)
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(= cycles 1)
			)
			(2
				(gMessager say: 8 8 local0 0 self 4100)
			)
			(3
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(if (not (IsFlag 219))
					(WIBWeeps play:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance womanInBlack of Actor
	(properties
		approachX 136
		approachY 96
		x 89
		y 89
		view 4114
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 89 approachVerbs: 8 89 ignoreHorizon:) ; Do, Exit, Horseman_s_Medal, Do, Horseman_s_Medal
		(if (== gValOrRoz -4) ; Val
			(if (gEgo has: 73) ; Horseman_s_Medal
				(self approachX: 158 approachY: 102)
			else
				(= approachX 126)
				(= approachY 103)
			)
		)
	)

	(method (cue)
		(self setScript: (if (gEgo has: 73) mornWIBStanding else mornWIB)) ; Horseman_s_Medal
	)

	(method (doVerb theVerb)
		(self setScript: 0)
		(switch theVerb
			(89 ; Horseman_s_Medal
				(gCurRoom setScript: womanTakesMedal)
			)
			(8 ; Do
				(cond
					((IsFlag 151)
						(gCurRoom setScript: roseTalksAsWIB self)
					)
					((== gValOrRoz -3) ; Roz
						(gCurRoom setScript: womanKillsRose self)
					)
					(else
						(gCurRoom setScript: womanKillsVal self)
					)
				)
			)
		)
	)
)

(instance horseman of Actor
	(properties
		x 255
		y 30
		view 4113
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors:)
		(&= signal $efff)
	)

	(method (doVerb theVerb)
		(if (and (wrongSpot onMe: gEgo) (== theVerb 93)) ; Horseman_s_Head
			(gGame handsOff:)
			(= local2 1)
		else
			(return 0)
		)
		(return 1)
	)
)

(instance horsemanShadow of Prop
	(properties)
)

(instance horse of Actor
	(properties)
)

(instance horseHead of Prop
	(properties)
)

(instance dog of Actor
	(properties)
)

(instance veil of Prop
	(properties)

	(method (cue)
		(veil dispose:)
	)
)

(instance explosion of Prop
	(properties
		x 88
		y 53
		priority 73
		fixPriority 1
		view 4125
		loop 2
	)
)

(instance tombDoor1 of Prop
	(properties
		approachX 72
		approachY 89
		x 120
		y 32
		view 4100
	)

	(method (init)
		(super init:)
		(if (and (== gValOrRoz -4) (not (IsFlag 220))) ; Val
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				((ScriptID 13 0) modeless: 2) ; aEgoTalker
				(gMessager say: 9 8 10 1 self 4100) ; "Count Vladimir Tsepish; Fearless Warrior, Devoted Husband, and Lord Protector of Ooga Booga land."
				((ScriptID 13 0) modeless: 1) ; aEgoTalker
				(gGame handsOn:)
				(return 1)
			)
		)
	)
)

(instance keyHole of Feature
	(properties
		x 120
		y 60
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 220))
			(self setHotspot: 8 10 92 approachVerbs: 8 92) ; Do, Exit, Firecracker, Do, Firecracker
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 94 39 100 40 99 52 95 64 91 65
					yourself:
				)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1)) (param1 type:))
			(switch (gUser message:)
				(8
					(if (IsFlag 220)
						(= approachX 85)
						(= approachY 78)
					else
						(= approachX 83)
						(= approachY 85)
					)
				)
				(92
					(= approachX 80)
					(= approachY 86)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 220)
					(gCurRoom setScript: goIntoTomb)
				else
					(gCurRoom setScript: blowDustOffLock)
				)
			)
			(92 ; Firecracker
				((ScriptID 4001 6) client: 0 delete: dispose:) ; firecrackerTimer
				(gCurRoom setScript: blowOffLock)
			)
		)
	)
)

(instance stone1 of Feature
	(properties
		noun 4
		nsLeft 292
		nsTop 68
		nsRight 310
		nsBottom 84
		approachX 272
		approachY 104
		x 303
		y 99
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sStone1)
	)
)

(instance stone2 of Feature
	(properties
		noun 5
		nsLeft 221
		nsTop 43
		nsRight 236
		nsBottom 76
		approachX 252
		approachY 97
		x 223
		y 77
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sStone2)
	)
)

(instance stone3 of Feature
	(properties
		noun 6
		nsLeft 105
		nsTop 87
		nsRight 120
		nsBottom 106
		approachX 110
		approachY 118
		x 110
		y 114
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sStone3)
	)
)

(instance stone4 of Feature
	(properties
		noun 7
		nsLeft 38
		nsTop 91
		nsRight 59
		nsBottom 124
		approachX 78
		approachY 113
		x 48
		y 136
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sStone4)
	)
)

(instance stone5 of Feature
	(properties
		noun 8
		nsLeft 40
		nsTop 34
		nsRight 59
		nsBottom 63
		approachX 54
		approachY 80
		x 46
		y 80
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sStone5)
	)
)

(instance wrongSpot of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 109 221 127 282 127 282 109
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 238 120 238 138 320 138 320 120
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 262 79 268 89 274 93 288 95 273 110 220 110
					yourself:
				)
		)
	)
)

(instance myNWExit of ExitFeature
	(properties
		nsLeft 264
		nsRight 295
		nsBottom 105
		approachX 278
		approachY 99
		x 282
		y 10
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: exitNorth)
	)
)

(instance tombDoor of ExitFeature
	(properties
		y 60
		exitDir 6
	)

	(method (init)
		(super init:)
		(= approachX 85)
		(= approachY 78)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 82 23 101 21 128 25 125 30 97 31 89 75 76 69
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: goIntoTomb)
			)
		)
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 300
		nsTop 100
		nsRight 320
		nsBottom 137
		approachX 319
		approachY 130
		x 340
		y 130
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: exitToEast)
	)
)

(instance myLeftSouthExit of ExitFeature
	(properties
		nsLeft 113
		nsTop 125
		nsRight 300
		nsBottom 140
		approachX 262
		approachY 132
		x 262
		y 160
		exitDir 3
	)

	(method (handleEvent event)
		(= local7 (event x:))
		(= local8 (event y:))
		(cond
			((event claimed:)
				(return 1)
			)
			((and (gUser canControl:) (event type:) (self onMe: event))
				(gCurRoom setScript: exitToLeftSouth)
				(event claimed: 1)
				(return)
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
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance horseManTimer of Timer
	(properties)

	(method (setReal param1)
		(if (and param1 (param1 respondsTo: #timer) (param1 timer:))
			((param1 timer:) dispose:)
			(param1 timer: 0)
		)
		(super setReal: param1 &rest)
	)

	(method (cue)
		(cond
			((gCurRoom script:)
				(horseManTimer setReal: horseManTimer 60)
			)
			(((ScriptID 4001 0) script:) ; OogaBooga
				((ScriptID 4001 5) setReal: self (Random 30 50)) ; boogeyShowTimer
				(horseManTimer setReal: horseManTimer 60)
			)
			(
				(or
					(== gChapter 4)
					(== gValOrRoz -3) ; Roz
					(and
						(!= gValOrRoz -4) ; Val
						(not (wrongSpot onMe: gEgo))
						(-- local1)
					)
				)
				(horseman setScript: horsemanFlysOverhead)
				(self setReal: self 60)
			)
			(else
				(= local1 (Random 2 4))
				(horseman setScript: horsemanRidesThrough)
			)
		)
	)

	(method (doit)
		(if (and (not local4) local5 (wrongSpot onMe: gEgo))
			(if (not (< seconds 3))
				(self setReal: self 2)
			)
			(= local4 1)
		)
		(if (and local4 (not (wrongSpot onMe: gEgo)))
			(= local4 0)
		)
		(if (and (not (gCurRoom script:)) (not (gTalkers size:)))
			(super doit: &rest)
		)
	)
)

(instance countTalker of KQTalker
	(properties
		clientCel -1
	)

	(method (init)
		(= client horseman)
		(super init: &rest)
	)
)

(instance elspethTalker of KQTalker
	(properties
		clientCel 19
	)

	(method (init)
		(= client horseman)
		(super init: &rest)
	)
)

(instance horseSound of Sound
	(properties
		flags 5
		number 4101
		loop -1
	)
)

(instance WIBWeeps of Sound
	(properties
		number 4108
		loop -1
	)
)

(instance sExplosion of Sound
	(properties)
)

(instance sBlows of Sound
	(properties)
)

(instance sDoor of Sound
	(properties)
)

(instance sReunion of Sound
	(properties)
)

(instance sSFX of Sound
	(properties)
)

(instance roomFeatureInitCode of Code
	(properties)

	(method (doit param1)
		(if (not (param1 isKindOf: KQInventory))
			(if (param1 respondsTo: #signal)
				(param1 signal: (| (param1 signal:) $7001))
			)
			(param1 sightAngle: 10 modNum: 4100)
		)
	)
)

