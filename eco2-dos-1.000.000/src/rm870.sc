;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 870)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use ScaleTo)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm870 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7
	local8
)

(instance rm870 of Eco2Room
	(properties
		noun 10
		picture 870
		style 10
	)

	(method (init)
		(gGame handsOff:)
		(gGameSound2 stop:)
		(gGameSound1 number: 870 loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 113 111 65 111 47 122 34 142 41 165 70 180 178 184 234 184 243 171 235 166 186 166 135 161 105 149 77 147 79 128 134 128 150 124 181 124 192 122 192 118 176 121 140 117 140 107 180 94 230 100 268 109 278 101 180 88 181 84 194 74 169 74 175 84 146 88 135 89 120 103
					yourself:
				)
		)
		(island init:)
		(lake init: setOnMeCheck: 1 8)
		(sky init: setOnMeCheck: 1 4)
		(dirt init: setOnMeCheck: 1 16)
		(queen init:)
		(palms init: setOnMeCheck: 1 2)
		(branch init: setOnMeCheck: 1 32)
		(bowlFeat init:)
		(runoff init:)
		(channel init:)
		(seedBed init:)
		(princess init: setOnMeCheck: 1 64)
		(fountain init: setOnMeCheck: 1 128)
		(plants init: setOnMeCheck: 1 256)
		(seeds init: stopUpd:)
		(gEgo
			x: 189
			y: 110
			init:
			normalize: 0
			setScale: 0
			setLoop: 5
			actions: egoActions
			setPri: 1
		)
		(vine init:)
		(mop init: ignoreActors: 1 addToPic:)
		(valve init:)
		(bkGrnd init: addToPic:)
		(orchid1 init:)
		(orchid2 init:)
		(self setScript: enterScript)
		(super init:)
		(gTheDoits add: queen princess fountain)
	)

	(method (doit)
		(super doit:)
		(if (not (IsFlag 5))
			(Palette palANIMATE 73 80 10)
		)
		(if
			(and
				(not
					(OneOf
						script
						slatOutScript
						stayHereScr
						cureBatScript
						fromBeachScript
						toBeachScript
						enterScript
						fadeScript
					)
				)
				(& (gEgo onControl: 1) $0800)
			)
			(gGame handsOff:)
			(cond
				((== local3 1)
					(slatDigScript seconds: 0 dispose:)
					(gCurRoom setScript: slatOutScript 0 3)
				)
				((gCast contains: paq)
					(self setScript: stayHereScr)
				)
				(local7
					(self setScript: fromBeachScript 0 script)
				)
				(else
					(self setScript: toBeachScript)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event type:))
		(if
			(and
				(== (gEgo view:) 8705)
				(OneOf ((gTheIconBar curIcon:) message:) 4 3)
				(or
					(& temp0 evMOUSEBUTTON)
					(& temp0 $0040) ; direction
					(and (& temp0 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(gGame handsOff:)
			(self setScript: offStellaScript)
		else
			(event claimed: 0)
			(super handleEvent: event)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance stayHereScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 9 4 0 0 self) ; "Now is NOT the time to go swimming."
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(- (gEgo x:) 5)
						(+ (gEgo y:) 7)
						self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toBeachScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (!= (gEgo loop:) 6))
			(gEgo setLoop: 6)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo looper: 0)
				(gEgo setLoop: 6 setPri: 1 setMotion: MoveTo 182 127 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo
					setScale:
					scaleX: 40
					scaleY: 26
					posn: 181 89
					setMotion: PolyPath 179 76 self
				)
			)
			(3
				(= local7 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromBeachScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (!= (gEgo loop:) 5))
			(gEgo setLoop: 5)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 181 89 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo looper: 0)
				(gEgo
					posn: 182 127
					normalize: 0
					setLoop: 5
					setPri: 1
					setScale: 0
					scaleX: 128
					scaleY: 128
					setMotion: MoveTo 171 83 self
				)
			)
			(3
				(gEgo
					setLoop: -1
					setPri: -1
					normalize:
					setMotion: MoveTo 135 106 self
				)
			)
			(4
				(gEgo normalize: 0 5)
				(= cycles 2)
			)
			(5
				(= local7 0)
				(if register
					(gCurRoom setScript: register)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 45) ; whistle
				(return 0)
			)
			((!= local3 3)
				(gMessager say: 21 45 0 1) ; "The time is not right to call the bats."
				(return 1)
			)
			((gCast contains: paq)
				(gMessager say: 21 45 35 1) ; "The bats are already here."
				(return 1)
			)
			(local7
				(gMessager say: 19 2 37 1) ; "Slaughter can't here Adam from that far away."
				(return 0)
			)
			(else
				(gGame handsOff:)
				(gCurRoom setScript: whistleScript)
				(return 1)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< state 2) (!= (gEgo loop:) 5))
			(gEgo setLoop: 5)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo looper: 0)
				(gEgo setMotion: MoveTo 171 83 self)
			)
			(2
				(gEgo
					setLoop: -1
					setPri: -1
					normalize:
					setMotion: MoveTo 135 106 self
				)
			)
			(3
				(if local6
					(= local6 0)
					(gEgo
						view: 2
						loop: 12
						cel: 0
						cycleSpeed: 13
						setCycle: End self
					)
				else
					(self start: 8 init:)
				)
			)
			(4
				(= ticks 45)
			)
			(5
				(gEgo cycleSpeed: 9 setCycle: Beg self)
			)
			(6
				(= ticks 30)
			)
			(7
				(gEgo normalize: 0 2)
				(= cycles 2)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance whistleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 5)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 871 setLoop: 3 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 0 0)
				(= seconds 5)
			)
			(5
				(gMessager say: 10 0 50 0 self) ; "Faintly in the distance, Adam hears a whirring of wings. It is the high-pitched sound of many bats flying."
			)
			(6
				(= seconds 5)
			)
			(7
				(bats
					init:
					setLoop: 0
					setStep: 10 10
					setCycle: Fwd
					setMotion: MoveTo 76 161 self
				)
				(gGameSound1 number: 684 loop: -1 play:)
				(self setScript: fireBatScript)
			)
			(8
				(bats setLoop: 1 setMotion: MoveTo (+ (bats x:) 30) 161 self)
				(paq init:)
			)
			(9
				(bats setMotion: MoveTo 340 -10 self)
			)
			(10
				(paq setCycle: End self)
			)
			(11
				((View new:)
					view: 888
					loop: 4
					cel: 0
					x: 73
					y: 153
					z: -10
					ignoreActors: 1
					init:
					addToPic:
					yourself:
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 66 155 94 155 94 170 66 170
							yourself:
						)
				)
				(if local5
					(pondWater init: x: 252 y: 155 setLoop: 3)
					(pondWater
						cel: (pondWater lastCel:)
						ignoreActors: 1
						addToPic:
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fireBatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fireBat
					init:
					setPri: 10
					setStep: 10 10
					setCycle: Fwd
					setMotion: MoveTo 221 98 self
				)
			)
			(1
				(fireBat view: 888 setLoop: 2 cel: 0 setCycle: 0 posn: 223 106)
				(self dispose:)
			)
		)
	)
)

(instance cureBatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 144 164 self)
			)
			(1
				(gEgo view: 889 setLoop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(2
				(gEgo
					setLoop: 3
					setCycle: Fwd
					setMotion: PolyPath 96 155 self
				)
			)
			(3
				(gEgo setLoop: 0 setCel: 9)
				(= cycles 5)
			)
			(4
				(gGame points: 15)
				(gEgo setLoop: 1 cel: 0 posn: 95 158 setCycle: CT 5 1 self)
				(paq hide:)
			)
			(5
				(gMessager say: 10 0 22 0 self) ; "Adam gently pours a drop of water from the fountain into Paquita's mouth."
				(gGameSound1 fade:)
			)
			(6
				(gEgo setCycle: End self)
				(gGameSound1 number: 902 loop: -1 play:)
			)
			(7
				(paq
					view: 50
					setLoop: -1
					show:
					posn: 94 155
					setSpeed: 0
					setCycle: Fwd
					setPri: 14
					scaleSignal: 1
					scaleX: 79
					scaleY: 79
					setStep: 10 10
					setMotion: MoveTo 200 50 self
				)
				(gEgo normalize: 0 2)
			)
			(8
				(paq view: 51 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				(paq
					view: 50
					setLoop: -1
					setCycle: Fwd
					setMotion: MoveTo 20 50 self
				)
			)
			(10
				(paq view: 51 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(11
				(paq
					view: 50
					setLoop: -1
					setStep: 20 20
					setCycle: Fwd
					setMotion: MoveTo 200 50 self
				)
			)
			(12
				(paq view: 51 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(13
				(paq
					view: 50
					setLoop: -1
					setStep: 30 30
					setCycle: Fwd
					setMotion: MoveTo 20 50 self
				)
			)
			(14
				(paq view: 51 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(15
				(paq
					view: 50
					setLoop: -1
					setCycle: Fwd
					setMotion: MoveTo 200 50 self
				)
			)
			(16
				(paq view: 51 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(17
				(paq
					view: 50
					setLoop: -1
					setStep: 40 40
					setCycle: Fwd
					setMotion: MoveTo 20 50 self
				)
			)
			(18
				(paq view: 51 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(19
				(paq
					view: 50
					setLoop: -1
					setCycle: Fwd
					setMotion: MoveTo 200 50 self
				)
			)
			(20
				(paq view: 51 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(21
				(paq
					view: 50
					setLoop: -1
					setCycle: Fwd
					setMotion: MoveTo 20 50 self
				)
			)
			(22
				(gMessager say: 10 0 23 0 self) ; "Oh, Adam, it is too beautiful!"
			)
			(23
				(paq
					view: 51
					setLoop: 1
					setStep: 20 20
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(24
				(paq
					setMotion:
						MoveTo
						(- (gEgo x:) 31)
						(- (gEgo y:) 42)
						self
				)
			)
			(25
				(paq hide:)
				(gEgo view: 889 setLoop: 2 cel: 0 setCycle: End self)
			)
			(26
				(paq
					show:
					view: 50
					setLoop: -1
					setCycle: Fwd
					posn: (+ (paq x:) 30) (paq y:)
					setMotion: MoveTo 200 100 self
				)
				(gEgo normalize: 0 2 setHeading: 90)
			)
			(27
				(gMessager say: 10 0 47 0 self) ; "NOT!"
			)
			(28
				(bats posn: 319 41 setMotion: MoveTo 218 130 self)
				(paq setLoop: 2)
			)
			(29
				(bats setCycle: 0)
				(self setScript: batSeedScript self)
			)
			(30
				(gMessager say: 10 0 24 0 self) ; "My friends will spread these seeds to heal the burned land."
			)
			(31
				(bats setCycle: Fwd setMotion: MoveTo -20 20 self)
			)
			(32
				(gEgo setMotion: PolyPath 112 115 self)
			)
			(33
				(gMessager say: 10 0 52 0 self) ; "I think I shall speak to him of all the plants in the forest. I shall name them all."
			)
			(34
				(gEgo setMotion: PolyPath 171 83 self)
			)
			(35
				(gMessager say: 10 0 45 0 self) ; "Don't leave me here with nature, kid!"
			)
			(36
				(gEgo setPri: 1 setLoop: 6 setMotion: MoveTo 189 110 self)
			)
			(37
				(gCurRoom newRoom: 860)
			)
		)
	)
)

(instance batSeedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bats cel: (+ (* (Random 0 2) 2) 1))
				(= cycles 6)
			)
			(1
				(if (< (++ register) 10)
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance intoBowlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 76 116 self)
			)
			(1
				(gEgo view: 4 setLoop: 6 cel: 0 setCycle: End self)
			)
			(2
				(gEgo normalize: 0 7 put: 4)
				(gCurrentRegionFlags set: 3)
				(gGame points: 5)
				(gMessager say: 15 27 0 1 self) ; "Adam carefully puts the dry blossom in the cup."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getBowlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 76 116 self)
			)
			(1
				(gEgo view: 4 setLoop: 6 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(statNoBowl init: ignoreActors: 1 addToPic:)
				(bowlFeat dispose:)
				(gEgo get: 21 setCycle: End self)
				(gGame points: 5)
				(= cycles 2)
			)
			(3
				(gMessager say: 15 4 0 1 self) ; "Adam removes the stone cup carefully."
			)
			(4
				(gEgo normalize: 0 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance intoHoleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 192 117 self)
			)
			(1
				(gEgo
					view: 8703
					setLoop: 0
					cel: 0
					setPri: 10
					posn: 205 108
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 0 0
					setPri: 10
					setMotion: MoveTo 226 106 self
				)
			)
			(3
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gEgo normalize: 0 0 setPri: 10)
				(gMessager say: 15 27 0 0 self) ; "Adam carefully puts the dry blossom in the cup."
				(gEgo put: 4)
				(gCurrentRegionFlags set: 3)
				(gGame points: 5)
				(if (gAddToPics contains: seedWater)
					(littleSparkle init: setCycle: Fwd)
					(bigSparkle init: setCycle: Fwd)
				)
			)
			(5
				(gEgo setMotion: MoveTo 205 108 self)
			)
			(6
				(gEgo
					view: 8703
					setLoop: 1
					cel: 0
					posn: 193 122
					setCycle: End self
				)
			)
			(7
				(gEgo
					normalize: 0 1
					posn: 198 119
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(8
				(gEgo setHeading: 90 self)
			)
			(9
				(if (gAddToPics contains: channelWater)
					(seeds dispose:)
					(gCurRoom setScript: insetScript)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance putBowlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 192 117 self)
			)
			(1
				(gEgo
					view: 8703
					setLoop: 0
					cel: 0
					setPri: 10
					posn: 205 108
					setCycle: End self
				)
			)
			(2
				(gEgo
					normalize: 0 0
					setPri: 10
					setMotion: MoveTo 226 106 self
				)
			)
			(3
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(bowlInHole init: addToPic:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo put: 21)
				(gGame points: 5)
				(if
					(or
						(gCast contains: channelWater)
						(gAddToPics contains: channelWater)
					)
					(self setScript: redirectScript self)
				)
				(gEgo
					normalize: 0 0
					setPri: 10
					setMotion: MoveTo 205 108 self
				)
			)
			(6
				(gEgo
					view: 8703
					setLoop: 1
					cel: 0
					posn: 193 122
					setCycle: End self
				)
			)
			(7
				(gEgo
					normalize: 0 1
					posn: 198 119
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(8
				(gEgo setHeading: 90 self)
			)
			(9
				(if (not script)
					(= cycles 1)
				)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance redirectScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(receptWater dispose:)
				(seedWater init: setCycle: End self)
				(= cycles 5)
			)
			(1
				(wfRight dispose:)
			)
			(2
				(seedWater setPri: 9 ignoreActors: 1 addToPic:)
				(if (gCurrentRegionFlags test: 3)
					(littleSparkle init: setCycle: Fwd)
				)
				(wfMiddle init: setCycle: Fwd)
				(wfLeft init: setCycle: Fwd)
				(= cycles 2)
			)
			(3 0)
			(4
				(if (gCurrentRegionFlags test: 3)
					(bigSparkle init: setCycle: Fwd)
				)
				(if (gCurrentRegionFlags test: 3)
					(seeds dispose:)
					(gCurRoom setScript: insetScript)
				else
					(self dispose:)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (>= (putBowlScript state:) 7))
			(self cue:)
		)
	)
)

(instance fountSound of Sound
	(properties
		number 873
		loop -1
	)
)

(instance openValveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 192 117 self)
			)
			(1
				(gEgo
					view: 8703
					setLoop: 0
					cel: 0
					setPri: 10
					posn: 205 108
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: 0 0 setPri: 10 setHeading: 0 self)
			)
			(3
				(if (== local0 0)
					(gCurRoom setScript: vineScript)
				else
					(valve setCycle: CT 3 1 self)
					(sfx number: 844 loop: 1 play:)
				)
			)
			(4
				(gEgo setHeading: 270 self)
			)
			(5
				(gGame points: 10)
				(gEgo
					view: 8703
					setLoop: 1
					cel: 0
					posn: 193 122
					setCycle: End self
				)
			)
			(6
				(gEgo
					normalize: 0 1
					posn: 198 119
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(7
				(gEgo setHeading: 90 self)
			)
			(8
				(sfx number: 848 loop: 1 play:)
				(valve setCycle: End self)
			)
			(9
				(channelWater init: setCycle: End self)
			)
			(10
				(valve ignoreActors: 1 addToPic:)
				(channelWater ignoreActors: 1 addToPic:)
				(fountSound number: 873 loop: -1 play:)
				(if (gAddToPics contains: bowlInHole)
					(self setScript: goodWaterScript)
				else
					(receptWater init: setCycle: End self)
				)
			)
			(11
				(wfRight init: setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(pondWater init: x: 252 y: 155 setLoop: 3 setCycle: End self)
			)
			(13
				(pondWater ignoreActors: 1 addToPic:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance littleSparkle of Prop
	(properties
		x 217
		y 137
		view 870
		loop 13
		cel 1
		priority 9
		signal 16400
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(seedWater doVerb: theVerb &rest)
	)
)

(instance bigSparkle of Prop
	(properties
		x 186
		y 162
		view 870
		loop 12
		cel 2
		priority 8
		signal 16400
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(pondWater doVerb: theVerb &rest)
	)
)

(instance goodWaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(seedWater init: setCycle: End self)
			)
			(1
				(if (gCurrentRegionFlags test: 3)
					(littleSparkle init: setCycle: Fwd)
				)
				(seedWater setPri: 9 ignoreActors: 1 addToPic:)
				(wfMiddle init: setCycle: Fwd)
				(wfLeft init: setCycle: Fwd)
				(= cycles 2)
			)
			(2
				(pondWater init: x: 198 y: 147 setLoop: 6 setCycle: End self)
			)
			(3
				(pondWater ignoreActors: 1 addToPic:)
				(if (gCurrentRegionFlags test: 3)
					(bigSparkle init: setCycle: Fwd)
				)
				(if (gCurrentRegionFlags test: 3)
					(seeds dispose:)
					(gCurRoom setScript: insetScript)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance insetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 number: 879 loop: -1 play:)
				(gMessager say: 6 4 26 0 self) ; "The water moves through the powder. A golden tinge spreads through the fountain."
			)
			(1
				(= local8
					((Prop new:)
						view: 873
						loop: 0
						cel: 0
						posn: 188 87
						setPri: 11
						setScale: 0
						maxScale: 1
						scaleX: 1
						scaleY: 1
						init:
						yourself:
					)
				)
				(local8 setScale: ScaleTo 128 10 self)
			)
			(2
				(gCurRoom setInset: seedInset)
				(= seconds 2)
			)
			(3
				(gGame points: 15)
				(local8 y: -100)
				(insetSeedling
					init:
					posn: (+ (seedInset x:) 1) (+ (seedInset y:) 12)
					setCycle: End self
				)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5 6 7)
			)
			(5
				(insetSeedling dispose:)
				(= seconds 3)
			)
			(6
				(gMessager say: 17 4 0 1 self) ; "The Seedling of Forest Heart! That's it! The true gold!"
			)
			(7
				(seedInset dispose:)
				(= cycles 1)
			)
			(8
				(local8 dispose:)
				(= local8 0)
				(gGame points: 20)
				(= cycles 2)
			)
			(9
				(gCurRoom setScript: slatArriveScript)
			)
		)
	)
)

(instance slatArriveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 fade:)
				(fountSound fade:)
				(= seconds 3)
			)
			(1
				(sfx number: 734 loop: -1 play:)
				(= seconds 3)
			)
			(2
				(chopper
					init:
					setPri: 0
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 150 30 self
				)
			)
			(3
				(gEgo setHeading: 0)
				(chopper setMotion: MoveTo 163 56 self)
			)
			(4
				(sfx fade:)
				(chopper
					setLoop: 6
					cel: 0
					cycleSpeed: 6
					posn: 152 53
					setCycle: End self
				)
			)
			(5
				(chopper ignoreActors: 1 addToPic:)
				(slaughter
					init:
					setScale:
					scaleX: 40
					scaleY: 26
					scaleSignal: 1
					posn: 182 73
					setPri: 1
					setCycle: Walk
				)
				(sfx number: 876 loop: 1 play: self)
			)
			(6
				(gGameSound1 number: 130 loop: -1 play:)
				(slaughter setMotion: MoveTo 177 94 self)
			)
			(7
				(slaughter
					scaleX: 128
					scaleY: 128
					scaleSignal: 0
					setStep: 4 2
					posn: 183 141
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					setLoop: 5
					setMotion: MoveTo 171 84 self
				)
			)
			(8
				(slaughter
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 131 112 self
				)
			)
			(9
				(slaughter setHeading: 90 self)
				(gEgo setHeading: 270 self)
			)
			(10 0)
			(11
				(gMessager say: 10 0 1 0 self) ; "Gotcha, you little worm!"
			)
			(12
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 113 111 65 111 36 124 26 141 38 169 70 180 178 184 234 184 243 171 235 166 186 166 135 161 105 149 80 148 44 153 33 145 44 133 56 124 68 122 88 123 104 128 134 128 150 124 181 124 192 122 192 118 176 121 140 117 140 107 174 96 245 100 271 108 279 97 179 90 181 84 201 71 170 71 175 84 146 88 135 89 120 103
							yourself:
						)
				)
				(gCurRoom setScript: fadeScript)
			)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fadeScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCast eachElementDo: #hide)
				(while
					(and
						(= temp0 (FirstNode (gAddToPics elements:)))
						(IsObject (= temp1 (NodeValue temp0)))
					)
					(aList add: temp1)
					(gAddToPics delete: temp1)
				)
				(gCurRoom drawPic: 888 0)
				(= cycles 2)
			)
			(2
				(bigSparkle dispose:)
				(littleSparkle dispose:)
				(= seconds 3)
			)
			(3
				(gGameSound1 number: 130 play:)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 870 0)
				(hole init: ignoreActors: 1 addToPic:)
				(slaughter
					setMotion: 0
					view: 8704
					loop: 0
					posn: 62 159 10
					setPri: 10
					ignoreActors: 1
					setCycle: Fwd
					setScript: slatDigScript 0 0
				)
				(gEgo view: 8705 setCycle: 0 setLoop: 5 cel: 0 posn: 45 67)
				(while
					(and
						(= temp0 (FirstNode (aList elements:)))
						(IsObject (= temp1 (NodeValue temp0)))
					)
					(gAddToPics add: temp1)
					(aList delete: temp1)
				)
				(gAddToPics doit:)
				(aList
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
					dispose:
				)
				(wfMiddle ignoreActors: 1 addToPic:)
				(wfLeft ignoreActors: 1 addToPic:)
				(= local3 1)
				(gDirectionHandler add: gCurRoom)
				(gMouseDownHandler add: gCurRoom)
				(gKeyDownHandler add: gCurRoom)
				(gWalkHandler add: gCurRoom)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance offStellaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 10 setCycle: End self)
			)
			(1
				(gEgo normalize: 531 4 posn: 61 120)
				(gGameSound1 number: 530 loop: -1 play:)
				(= cycles 1)
			)
			(2
				(gDirectionHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gWalkHandler delete: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slatDigScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(gNarrator back: 5)
				(if register
					(= register 0)
					(gMessager say: 10 0 6 1 self) ; "I bet I find the treasure any second now. Then I'll fry the little worm!"
				else
					(++ register)
					(gMessager say: 10 0 5 1 self) ; "Kids! I'll find the gold myself."
				)
			)
			(2
				(gNarrator back: 68)
				(self init:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (slaughter cel:) 10)
			(sfx number: 877 loop: 1 play:)
		)
		(if (== (slaughter cel:) 4)
			(sfx number: 878 loop: 1 play:)
		)
		(if (and (not (gCurRoom script:)) (< (gEgo distanceTo: slaughter) 35))
			(= seconds 0)
			(gGame handsOff:)
			(self dispose:)
			(gCurRoom setScript: slatOutScript 0 5)
		)
	)
)

(instance slatOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(gMessager say: 19 2 29 0 self) ; "Hey, come and get me!"
					)
					(2
						(gMessager say: 19 0 40 1) ; "Turn over the gold!"
						(gEgo setMotion: PolyPath 86 113)
						(= cycles 1)
					)
					(3
						(gMessager say: 10 0 42 0 self) ; "Where do you think YOU'RE going?"
					)
					(4
						(gMessager say: 19 2 21 0 self) ; "Hey, come over here and I'll show you the treasure!"
					)
					(5
						(gMessager say: 10 0 46 0 self) ; "Can't you stay put, kid? I'm gettin' too old for this!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (OneOf register 1 3 5)
					(gGameSound1 stop:)
					(sfx number: 876 loop: 1 play: self)
					(proc0_5 gEgo slaughter)
				)
				(slaughter view: 8704 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(slaughter
					view: 30
					setLoop: -1
					setCycle: StopWalk -1
					z: 0
					setPri: -1
					setMotion: MoveTo 50 162 self
				)
			)
			(3
				(switch register
					(2
						(gCurRoom setScript: giveDustScript)
					)
					(3
						(gCurRoom setScript: fadeScript)
					)
					(4
						(gCurRoom setScript: slatLureScript)
					)
					(5
						(gCurRoom setScript: fadeScript)
					)
					(6
						(self dispose:)
					)
					(else
						(proc0_5 slaughter gEgo self)
					)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 10 0 7 1 self) ; "So, do you have any gold for me?"
			)
			(6
				(slaughter setMotion: PChase gEgo 30 self)
			)
			(7
				(gCurRoom setScript: fadeScript)
			)
		)
	)
)

(instance slatLureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(slaughter setMotion: PolyPath 192 122 self)
			)
			(1
				(gEgo view: 0 setMotion: PolyPath 128 115)
				(slaughter
					setMotion:
						MoveTo
						(+ (slaughter x:) 20)
						(+ (slaughter y:) 5)
						self
				)
			)
			(2
				(gMessager say: 10 0 48 0 self) ; "You bet the gold is mine!"
			)
			(3
				(gCurRoom setScript: slatVineScript)
			)
		)
	)
)

(instance giveDustScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(1
				(gMessager say: 19 0 40 2 self) ; "Come get it!"
			)
			(2
				(gEgo setMotion: PolyPath 86 113 self)
				(slaughter ignoreActors: 0 setMotion: PolyPath 130 126 self)
			)
			(3 0)
			(4
				(gEgo setHeading: 90 self)
				(slaughter setHeading: 270 self)
			)
			(5 0)
			(6
				(gMessager say: 19 22 0 2 self) ; "Hand that over!"
			)
			(7
				(gEgo view: 879 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
				(sfx number: 901 loop: 1 play:)
			)
			(8
				(= local4
					((Prop new:)
						view: 879
						loop: 2
						cel: 0
						x: 89
						y: 81
						priority: 10
						signal: 16
						init:
						setCycle: CT 2 1 self
						yourself:
					)
				)
				(gEgo setCycle: End)
			)
			(9
				(slaughter view: 872 setLoop: 0 cel: 0 setCycle: End self)
				(local4 setCycle: End)
			)
			(10
				(gMessager say: 10 0 53 0 self) ; "My eyes, my eyes!"
			)
			(11
				(gEgo put: 20 normalize: 0 0)
				(slaughter setLoop: 10 cel: 0 setCycle: End self)
			)
			(12
				(slaughter
					setLoop: 6
					setCycle: Walk
					setMotion: PolyPath 192 122 self
				)
				(local4 dispose:)
				(= local4 0)
			)
			(13
				(slaughter
					setMotion:
						MoveTo
						(+ (slaughter x:) 20)
						(+ (slaughter y:) 5)
						self
				)
			)
			(14
				(gCurRoom setScript: slatVineScript)
			)
		)
	)
)

(instance pot of View
	(properties
		x 192
		y 126
		noun 32
		view 870
		loop 9
		priority 11
		signal 16400
	)
)

(instance putDustScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 192 117 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo
					view: 5
					setLoop: 2
					cel: 0
					put: 20
					setCycle: CT 3 1 self
				)
			)
			(3
				(pot init: addToPic:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 0 2 setHeading: 225 self)
				(slatDigScript seconds: 0 dispose:)
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 19 22 0 0 self) ; "Here's some gold dust. Is that the kind of thing you're looking for?"
			)
			(7
				(gEgo setMotion: PolyPath 128 107 self)
			)
			(8
				(gEgo setHeading: 135 self)
			)
			(9
				(= cycles 2)
			)
			(10
				(gMessager say: 19 0 40 2 self) ; "Come get it!"
			)
			(11
				(self setScript: slatOutScript self 6)
			)
			(12
				(slaughter setMotion: PolyPath 192 122 self)
			)
			(13
				(slaughter setHeading: 180 self)
			)
			(14
				(gMessager say: 10 0 48 0 self) ; "You bet the gold is mine!"
			)
			(15
				(gCurRoom setScript: slatVineScript)
			)
		)
	)
)

(instance slatVineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 10)
				(vine
					view: 875
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
				(sfx number: 871 loop: 1 play:)
			)
			(1
				(gGameSound1 fade:)
				(slaughter setPri: 10)
				(vine
					view: 8708
					setLoop: 0
					cel: 0
					setPri: (- (slaughter priority:) 1)
					setCycle: End self
				)
				(vineFront
					init:
					setPri: (+ (slaughter priority:) 1)
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2 0)
			(3
				(vineFront dispose:)
				(vine view: 8707 setLoop: 0 cel: 0 setCycle: End self)
				(slaughter dispose:)
				(sfx number: 872 loop: 1 play:)
			)
			(4
				(gGameSound1 number: 902 loop: -1 play:)
				(gEgo setMotion: 0)
				(proc0_5 gEgo vine self)
			)
			(5
				(= local3 3)
				(vine ignoreActors: 1 addToPic:)
				(slatInVine init: posn: (vine x:) (vine y:))
				(= cycles 2)
			)
			(6
				(gMessager say: 10 0 2 0 self) ; "C'mon, kid, I was just, um, pulling your leg. Tell this thing to let me go."
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slatInVine of View
	(properties
		noun 8
		view 8709
		priority 11
		signal 24592
	)

	(method (doVerb theVerb)
		(vine doVerb: theVerb &rest)
	)
)

(instance vineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 stop:)
				((ScriptID 1009) setupTalker: 4) ; EgoTalker
				((ScriptID 1877) setupTalker: 6) ; Orchid1
				((ScriptID 1878) setupTalker: 6) ; Orchid2
				(vine
					view: 875
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
				(sfx number: 871 loop: 1 play:)
			)
			(1
				(vine
					view: 8708
					setLoop: 0
					cel: 0
					setPri: (- (gEgo priority:) 1)
					setCycle: End self
				)
				(vineFront
					init:
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2 0)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(gEgo view: 2 setLoop: 6 cel: 0 setCycle: End self)
			)
			(5
				(vineFront dispose:)
				(gEgo hide:)
				(vine view: 8706 setLoop: 0 cel: 0 setCycle: End self)
				(sfx number: 872 loop: 1 play:)
			)
			(6
				(gGameSound1 number: 730 loop: -1 play:)
				(orchid1 setCycle: End self)
				(orchid2 setCycle: End self)
			)
			(7 0)
			(8
				(= seconds 2)
			)
			(9
				(gMessager say: 10 0 3 0 self) ; "He-e-y, what! Let go!"
			)
			(10
				(= local0 1)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance spitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 0 4 0 self) ; "It is the ancient call for help!"
			)
			(1
				(gGame points: 1)
				(vine view: 876 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(vine setCycle: End)
				(gEgo
					show:
					view: 11
					setLoop: 1
					cel: 9
					posn: 173 146
					setStep: 10 10
					setCycle: End self
					setMotion: MoveTo 122 171 self
				)
			)
			(3 0)
			(4
				(vine view: 8701 loop: 0 cel: 0)
				(gEgo
					setLoop: 2
					cel: 0
					posn: (+ (gEgo x:) 35) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(5
				(gGameSound1 number: 870 loop: -1 play:)
				(gEgo normalize: 0 0)
				(orchid1 setCycle: Beg self)
				(orchid2 setCycle: Beg self)
			)
			(6 0)
			(7
				((ScriptID 1009) setupTalker: 8) ; EgoTalker
				((ScriptID 1877) setupTalker: 8) ; Orchid1
				((ScriptID 1878) setupTalker: 8) ; Orchid2
				(orchid1 ignoreActors: 1 addToPic:)
				(orchid2 ignoreActors: 1 addToPic:)
				(= local0 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chopper of Actor
	(properties
		x 120
		y -20
		noun 31
		view 870
		loop 5
		signal 26624
	)
)

(instance paq of Actor
	(properties
		x 95
		y 158
		noun 22
		view 888
		loop 3
		signal 16384
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 12 0) ; "Paquita is barely breathing."
			)
			(2 ; Talk
				(gMessager say: noun theVerb 12 0) ; "Paquita cannot answer."
			)
			(4 ; Do
				(gMessager say: noun theVerb 12 0) ; "Paquita is too fragile to be touched."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bats of Actor
	(properties
		view 888
		priority 10
		signal 24592
	)
)

(instance fireBat of Actor
	(properties
		x 132
		y -10
		noun 20
		view 618
		loop 2
		signal 24576
	)

	(method (doVerb theVerb)
		(cond
			((self perform: gWriteEcorderData theVerb 39) 0)
			((OneOf theVerb 1 2) ; Look, Talk
				(gMessager say: noun theVerb 12 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 39))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance slaughter of Actor
	(properties
		noun 19
		view 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch local3
					(1
						(gMessager say: noun theVerb 29 1) ; "Slaughter is digging up the garden. He must be thinking of buried treasure."
					)
					(3
						(gMessager say: noun theVerb 2 1) ; "Slaughter is all tied up."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(2 ; Talk
				(cond
					((== (gEgo view:) 8705)
						(gMessager say: noun theVerb 10 0) ; "Hey, get me off here!"
					)
					((== local3 3)
						(gMessager say: noun theVerb 2 0) ; "Kid, please let me out of here!"
					)
					(local7
						(gMessager say: noun theVerb 37 0) ; "Slaughter can't here Adam from that far away."
					)
					((> (gEgo x:) 210)
						(slatDigScript seconds: 0 dispose:)
						(gGame handsOff:)
						(gCurRoom setScript: slatOutScript 0 4)
					)
					(else
						(slatDigScript seconds: 0 dispose:)
						(gGame handsOff:)
						(gCurRoom setScript: slatOutScript 0 1)
					)
				)
			)
			(22 ; goldDust
				(cond
					((== local0 1)
						(gMessager say: 6 4 34 1) ; "Adam will have to get out of the trap to do that."
					)
					((== (gEgo view:) 8705)
						(gMessager say: 15 4 10 1) ; "Not from where Adam is sitting!"
					)
					((== local3 1)
						(slatDigScript seconds: 0 dispose:)
						(gGame handsOff:)
						(gCurRoom setScript: slatOutScript 0 2)
					)
					(else
						(gMessager say: noun 1 2 0) ; "Slaughter is all tied up."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hole of View
	(properties
		x 59
		y 153
		noun 11
		view 870
		loop 2
		priority 9
		signal 16
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 1 4) (== local3 3)) ; Look, Do
			(gMessager say: noun theVerb 2 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance seedInset of Inset
	(properties
		view 873
		x 188
		y 87
		priority 13
	)

	(method (init &tmp temp0)
		(= temp0 (gAddToPics contains: seedWater))
		(super init: &rest)
		(gEgo stopUpd:)
		(wfMiddle stopUpd:)
		(wfLeft stopUpd:)
		(if temp0
			(insetWF init: posn: (- x 65) (+ y 28) setCycle: Fwd)
		)
	)

	(method (dispose param1)
		(insetWF dispose:)
		(wfMiddle startUpd:)
		(wfLeft startUpd:)
		(super dispose: &rest)
	)
)

(instance insetSeedling of Prop
	(properties
		noun 17
		view 873
		loop 1
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gEgo get: 19)
			(insetScript cue:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance insetWF of Prop
	(properties
		view 873
		loop 2
		priority 13
		signal 16
	)
)

(instance channelWater of Prop
	(properties
		x 220
		y 87
		view 877
		priority 8
		signal 16
	)
)

(instance seeds of View
	(properties
		x 213
		y 120
		z -10
		view 870
		loop 3
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(seedBed doVerb: theVerb &rest)
	)
)

(instance receptWater of Prop
	(properties
		x 257
		y 107
		view 877
		loop 1
		priority 8
		signal 16
	)

	(method (doVerb theVerb)
		(runoff doVerb: theVerb)
	)
)

(instance wfRight of Prop
	(properties
		x 272
		y 121
		view 877
		loop 2
		priority 9
		signal 16
	)
)

(instance pondWater of Prop
	(properties
		x 252
		y 155
		view 877
		loop 3
		priority 8
		signal 4112
	)

	(method (doVerb theVerb)
		(fountain doVerb: theVerb &rest)
	)
)

(instance seedWater of Prop
	(properties
		x 248
		y 105
		view 877
		loop 4
		priority 8
		signal 4112
	)

	(method (doVerb theVerb)
		(seedBed doVerb: theVerb &rest)
	)
)

(instance wfMiddle of Prop
	(properties
		x 246
		y 111
		view 877
		loop 5
		priority 8
		signal 16
	)
)

(instance wfLeft of Prop
	(properties
		x 199
		y 139
		view 877
		loop 7
		priority 9
		signal 16
		cycleSpeed 10
	)
)

(instance valve of Prop
	(properties
		x 213
		y 91
		noun 6
		view 8702
		priority 8
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				(cel
					(gMessager say: noun theVerb 33 1) ; "The water is already flowing."
				)
				((== local0 1)
					(gMessager say: noun theVerb 34 1) ; "Adam will have to get out of the trap to do that."
				)
				((== (gEgo view:) 8705)
					(gMessager say: 15 theVerb 10 1) ; "Not from where Adam is sitting!"
				)
				(else
					(gGame handsOff:)
					(gCurRoom setScript: openValveScript)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bowlInHole of View
	(properties
		x 266
		y 114
		view 870
		loop 10
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(runoff doVerb: theVerb)
	)
)

(instance statNoBowl of View
	(properties
		x 64
		y 93
		view 870
		loop 10
		cel 1
	)

	(method (doVerb theVerb)
		(princess doVerb: theVerb)
	)
)

(instance orchid1 of Prop
	(properties
		x 105
		y 45
		noun 3
		view 874
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(switch theVerb
				(2 ; Talk
					(switch local0
						(0
							(gMessager say: noun theVerb 28 1) ; "The orchids' leaves move lazily but nothing happens."
						)
						(1
							(gMessager say: noun theVerb 17 1) ; "If you can show us why you're here, we'll let you go."
						)
						(2
							(cond
								((== (gEgo view:) 8705)
									(gMessager say: noun theVerb 10 1) ; "I don't think he's paying any attention to you!"
								)
								((gCast contains: paq)
									(gMessager say: noun theVerb 12 1) ; "Surely you can help her now, Adam."
								)
								((== local3 1)
									(gMessager say: noun theVerb 38 1) ; "Ssssh, Adam, you must defeat this human!"
								)
								((== local3 3)
									(gMessager say: noun theVerb 2 1) ; "We will watch him closely. Do not worry."
								)
								((== local1 0)
									(++ local1)
									(gMessager say: noun theVerb 16 1) ; "Many have forgotten the people who lived here. But we remember them, my sister and I."
								)
								((== local1 1)
									(++ local1)
									(gMessager say: noun theVerb 15 0) ; "Who were they?"
								)
								(else
									(gMessager say: noun theVerb 0 1) ; "The treasure lies before you. To awaken it is your task."
								)
							)
						)
					)
				)
				(4 ; Do
					(if local0
						(gMessager say: noun theVerb 0 1) ; "Hands off! I bruise easily."
					else
						(gMessager say: noun theVerb 28 1) ; "The orchids' petals bruise when touched."
					)
				)
				(1 ; Look
					(switch local0
						(0
							(gMessager say: noun theVerb 51 1) ; "The stelas are covered with delicate orchids."
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
				(53 ; Recycle
					(super doVerb: theVerb &rest)
				)
				(13 ; amulet
					(if (== local0 1)
						(gGame handsOff:)
						(gCurRoom setScript: spitScript)
					else
						(super doVerb: theVerb &rest)
					)
				)
				(else
					(if (== local0 1)
						(gMessager say: 10 0 19 0) ; "Oh, not that!"
					else
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance orchid2 of Prop
	(properties
		x 24
		y 52
		noun 4
		view 874
		loop 1
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(switch theVerb
				(2 ; Talk
					(switch local0
						(0
							(gMessager say: noun theVerb 28 1) ; "The orchids' leaves move lazily but nothing happens."
						)
						(1
							(gMessager say: noun theVerb 17 1) ; "Are you the one we're waiting for? If so, you must prove it!"
						)
						(2
							(cond
								((== (gEgo view:) 8705)
									(gMessager say: noun theVerb 10 1) ; "Oh, be quick, he's not watching!"
								)
								((gCast contains: paq)
									(gMessager say: noun theVerb 12 1) ; "In a way she, too, is a child of Forest Heart. Help her with our blessing."
								)
								((== local3 1)
									(gMessager say: noun theVerb 38 1) ; "I cannot help you! Please make him leave!"
								)
								((== local3 3)
									(gMessager say: noun theVerb 2 1) ; "I think I shall speak to him of all the plants in the forest. I shall name them all."
								)
								((== local2 0)
									(++ local2)
									(gMessager say: noun theVerb 16 1) ; "A King came here every year to remember his wife and daughter."
								)
								((== local2 1)
									(++ local2)
									(gMessager say: noun theVerb 15 0) ; "What is the treasure?"
								)
								(else
									(gMessager say: noun theVerb 0 1) ; "If you are the right one, I have told you enough."
								)
							)
						)
					)
				)
				(4 ; Do
					(if local0
						(gMessager say: noun theVerb 0 1) ; "That might bruise my petals!"
					else
						(gMessager say: noun theVerb 28 1) ; "The orchid's petals bruise when touched."
					)
				)
				(1 ; Look
					(switch local0
						(0
							(gMessager say: noun theVerb 51 1) ; "The stelas are covered with delicate orchids."
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
				(53 ; Recycle
					(super doVerb: theVerb &rest)
				)
				(13 ; amulet
					(if (== local0 1)
						(gGame handsOff:)
						(gCurRoom setScript: spitScript)
					else
						(super doVerb: theVerb &rest)
					)
				)
				(else
					(if (== local0 1)
						(gMessager say: 10 0 19 0) ; "Oh, not that!"
					else
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance bkGrnd of View
	(properties
		x 21
		y 47
		view 874
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(orchid2 doVerb: theVerb &rest)
	)
)

(instance vine of Prop
	(properties
		x 270
		y 19
		noun 8
		view 8701
		priority 12
		signal 16
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (== local3 3)
					(gMessager say: 19 2 2 0) ; "Kid, please let me out of here!"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(if (== local3 3)
					(gMessager say: 19 1 2 1) ; "Slaughter is all tied up."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(super doVerb: theVerb &rest)
			)
			(53 ; Recycle
				(super doVerb: theVerb &rest)
			)
			(13 ; amulet
				(if (== local0 1)
					(gGame handsOff:)
					(gCurRoom setScript: spitScript)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(if (== local0 1)
					(gMessager say: 10 0 19 0) ; "Oh, not that!"
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance vineFront of Prop
	(properties
		x 270
		y 19
		noun 8
		view 8708
		loop 1
		priority 12
		signal 16400
	)
)

(instance mop of View
	(properties
		x 259
		y 25
		noun 8
		view 876
		loop 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(vine doVerb: theVerb &rest)
	)
)

(instance channel of Feature
	(properties
		x 231
		y 93
		noun 2
		nsTop 86
		nsLeft 219
		nsBottom 100
		nsRight 243
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (valve cel:)
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 13) ; "The channel is dry."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bowlFeat of Feature
	(properties
		x 55
		y 81
		noun 15
		nsTop 76
		nsLeft 44
		nsBottom 87
		nsRight 66
		sightAngle 40
		approachX 73
		approachY 111
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== local0 1)
						(gMessager say: 6 theVerb 34 1) ; "Adam will have to get out of the trap to do that."
					)
					((== (gEgo view:) 8705)
						(gMessager say: noun theVerb 10 1) ; "Not from where Adam is sitting!"
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: getBowlScript)
					)
				)
			)
			(27 ; goldenBlossom
				(if (== local0 1)
					(gMessager say: 6 4 34 1) ; "Adam will have to get out of the trap to do that."
				else
					(gGame handsOff:)
					(gCurRoom setScript: intoBowlScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance runoff of Feature
	(properties
		x 258
		y 103
		noun 14
		nsTop 94
		nsLeft 247
		nsBottom 112
		nsRight 269
		sightAngle 40
		approachX 258
		approachY 103
		approachDist 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; chalice
				(if (== local0 1)
					(gMessager say: 6 4 34 1) ; "Adam will have to get out of the trap to do that."
				else
					(gGame handsOff:)
					(gCurRoom setScript: putBowlScript)
				)
			)
			(1 ; Look
				(if (gAddToPics contains: bowlInHole)
					(gMessager say: noun theVerb 31) ; "The stone cup fits perfectly into the fountain. The inside of the cup has a golden stain."
				else
					(gMessager say: noun theVerb 30) ; "A hole has been carved in the rock. It appears that something is missing."
				)
			)
			(27 ; goldenBlossom
				(cond
					((not (gAddToPics contains: bowlInHole))
						(gMessager say: noun theVerb) ; "The blossom would be washed away if Adam put it there."
					)
					((== local0 1)
						(gMessager say: 6 4 34 1) ; "Adam will have to get out of the trap to do that."
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: intoHoleScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seedBed of Feature
	(properties
		x 215
		y 121
		noun 1
		nsTop 116
		nsLeft 182
		nsBottom 136
		nsRight 249
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; goldenBlossom
				(gMessager say: 7 4 0 1) ; "Be more specific."
			)
			(22 ; goldDust
				(fountain doVerb: theVerb &rest)
			)
			(1 ; Look
				(if (gEgo has: 19)
					(gMessager say: noun theVerb 44 0) ; "The remaining seeds are slowly sprouting."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (gEgo has: 19)
					(gMessager say: noun theVerb 44 0) ; "Adam has the seedling of Forest Heart."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance island of Feature
	(properties
		x 225
		y 10
		noun 23
		nsTop 39
		nsLeft 210
		nsBottom 52
		nsRight 241
		sightAngle 40
		approachX 229
		approachY 45
		approachDist 1
	)
)

(instance lake of Feature
	(properties
		x 174
		y 10
		noun 9
		sightAngle 40
		onMeCheck 8
	)
)

(instance sky of Feature
	(properties
		x 195
		y 24
		noun 5
		sightAngle 40
		onMeCheck 4
	)
)

(instance dirt of Feature
	(properties
		x 62
		y 129
		noun 12
		sightAngle 40
		onMeCheck 16
	)
)

(instance queen of Feature
	(properties
		x 91
		y 27
		noun 25
		nsTop 19
		nsLeft 74
		nsBottom 109
		nsRight 110
		sightAngle 40
		approachX 91
		approachY 61
		approachDist 11
	)

	(method (doit)
		(if (not (IsEcorderFlag 81))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 81))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance princess of Feature
	(properties
		x 41
		y 40
		noun 24
		sightAngle 40
		onMeCheck 64
	)

	(method (doit)
		(if (not (IsEcorderFlag 81))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 81))
			(super doVerb: theVerb)
		)
	)
)

(instance palms of Feature
	(properties
		x 174
		y 1
		noun 16
		sightAngle 40
		onMeCheck 2
	)
)

(instance branch of Feature
	(properties
		x 237
		y 18
		noun 28
		sightAngle 40
		onMeCheck 32
	)
)

(instance fountain of Feature
	(properties
		x 207
		y 90
		noun 7
		sightAngle 40
		onMeCheck 128
	)

	(method (doit)
		(if (not (IsEcorderFlag 82))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 82))
			(switch theVerb
				(4 ; Do
					(cond
						((not (gAddToPics contains: pondWater))
							(super doVerb: theVerb &rest)
						)
						((not (gCast contains: paq))
							(gMessager say: noun theVerb 36 1) ; "Adam has no use for the water right now."
						)
						(else
							(gGame handsOff:)
							(gCurRoom setScript: cureBatScript)
						)
					)
				)
				(1 ; Look
					(cond
						((gEgo has: 19)
							(gMessager say: noun theVerb 44 0) ; "The water sparkles and seems to move with a life of its own."
						)
						((gAddToPics contains: pondWater)
							(gMessager say: noun theVerb 14 0) ; "The seedbed is moist but nothing happens."
						)
						(else
							(gMessager say: noun theVerb 13 0) ; "An immense stone fountain rests in the shade of this lonely place. Zigzag channels lead from the top of the fountain."
						)
					)
				)
				(22 ; goldDust
					(cond
						((== local0 1)
							(gMessager say: 6 4 34 1) ; "Adam will have to get out of the trap to do that."
						)
						((== (gEgo view:) 8705)
							(gMessager say: 15 4 10 1) ; "Not from where Adam is sitting!"
						)
						((not (gCast contains: slaughter))
							(gMessager say: noun theVerb 43) ; "Adam has no reason to do that now."
						)
						(else
							(gGame handsOff:)
							(gCurRoom setScript: putDustScript)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance plants of Feature
	(properties
		x 12
		y 35
		noun 27
		sightAngle 180
		onMeCheck 256
	)
)

