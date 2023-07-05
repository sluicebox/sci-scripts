;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	rm385 0
)

(local
	[local0 53] = [0 0 164 69 0 0 165 75 0 1 167 82 0 1 168 90 0 2 169 99 0 2 170 108 0 3 171 115 0 3 173 125 0 4 174 129 0 4 176 128 0 5 177 122 0 5 178 127 0 6 178 129 -32768]
	[local53 53] = [1 0 164 69 1 0 165 75 1 0 167 82 1 1 168 90 1 1 169 99 1 2 170 108 1 2 171 115 1 3 173 125 1 3 174 129 1 4 176 128 1 4 177 122 1 5 178 127 1 5 178 129 -32768]
	[local106 29] = [5 3 180 93 5 4 177 103 5 5 171 99 5 6 165 94 5 0 161 105 5 1 156 123 5 2 156 140 -32768]
	local135
	local136
	local137
	local138
	local139
	local140
	local141 = 175
	local142 = 1
	[local143 30] = [262 -1 272 27 231 91 193 97 188 87 198 50 168 50 137 46 138 84 131 94 123 94 92 81 84 60 74 33 71 0]
)

(instance rm385 of SQRoom
	(properties
		picture 385
		style 10
		east 390
		west 380
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(cond
			((and (!= gPrevRoomNum 386) (not (IsFlag 11)))
				(groundCigarSFX init:)
				(tossedSFX init:)
				(egoLandsSFX init:)
				(gLongSong2 number: 4 loop: -1 flags: 1 play: 65)
			)
			((IsFlag 11)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
		)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -12)
					(= temp1 139)
				else
					(= temp0 -12)
					(= temp1 99)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 334)
					(= temp1 149)
				else
					(= temp0 334)
					(= temp1 119)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(387
				(gLongSong number: 405 loop: -1 flags: 1 play:)
				(gEgo x: -100 y: -100)
				(self setScript: egoTossedOut 0 0)
			)
			(else
				(gLongSong number: 405 loop: -1 flags: 1 play: 95)
				(gEgo x: -100 y: -100)
				(if (TestMallFlag (ScriptID 700 0) #rFlag4 1) ; mall
					(self setScript: egoTossedOut 0)
					(mall rFlag4: (& (mall rFlag4:) $fffe))
				else
					(self setScript: fromStoreScript)
				)
			)
		)
		(burgerPoly points: @local143 size: 15)
		(super init:)
		(if (IsFlag 11)
			(gAddToPics add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 108 191 101 185 93 136 92 134 98 0 91 0 0 319 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 153 65 152 75 138 97 0 91 0 55
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 170 65 319 66 319 108 183 100
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 165 319 189 0 189 0 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 105 124 110 139 114 130 133 0 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 122 319 144 189 136 181 116 190 114
					yourself:
				)
		)
		(if (and (IsFlag 23) (not (IsFlag 22)))
			(Load rsSOUND 105)
			((ScriptID 700 7) ; sp2
				posn: 168 118
				view: 13
				setLoop: 0
				setCel: 0
				init:
				setScript: shootEgo
			)
		)
		(gEgo setPri: -1 code: beltwayCode init: setCycle: SyncWalk)
		(self setRegions: 700) ; mall
		(store init:)
		(bush1 init:)
		(bush2 init:)
	)

	(method (doit &tmp temp0)
		(if (not (-- local142))
			(cond
				(
					(<
						(= temp0
							(GetDistance (gEgo x:) (gEgo y:) local141 0)
						)
						0
					)
					(= temp0 0)
				)
				((> temp0 300)
					(= temp0 300)
				)
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local142 60)
		)
		(cond
			((gCurRoom script:) 0)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(gCurRoom setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((== (gEgo edgeHit:) 4)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(gCurRoom setScript: (ScriptID 700 2) 0 west) ; exS
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromStoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 167 y: 74 setMotion: MoveTo 167 96 self)
			)
			(1
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance beltwayCode of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((StepOn gEgo 8)
				(if (== (gEgo view:) 402)
					(gCurRoom setScript: egoTossedOut 0 1)
				else
					(gCurRoom newRoom: 386)
				)
			)
			((StepOn gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((StepOn gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2)
				(proc700_5 1)
			)
		)
	)
)

(instance sDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(if (< 130 ((ScriptID 700 9) x:) 220) ; shopper3
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance egoTossedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 392 385)
				(LoadMany rsSOUND 836 873 874 134)
				(HandsOff)
				(if (== register 1)
					(gEgo illegalBits: 0 setMotion: MoveTo 160 42 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (< 130 ((ScriptID 700 9) x:) 220) ; shopper3
					(self setScript: sDS self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 392 setLoop: register)
				(if (== register 1)
					(tossedSFX play:)
					(gEgo setCycle: MCyc @local53)
					(= cycles 10)
				else
					(tossedSFX play:)
					(gEgo setCycle: MCyc @local0)
					(= cycles 10)
				)
			)
			(3
				(egoLandsSFX play:)
				(boss
					init:
					setLoop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 155 95 self
				)
			)
			(4
				(boss view: 385 loop: 4)
				(pighead
					ignoreActors: 1
					setPri: 7
					x: (+ (boss x:) 2)
					y: (- (boss y:) 48)
					z: 0
					init:
				)
				(if (== register 1)
					(tPighead init: 0 0 pighead say: 1 self 2) ; "No shirt, no shoes, no service!!"
				else
					(tPighead ; "You're FIRED! My JANITOR could do a better job than you could!"
						init: 0 0 pighead
						say: 2 self 2 64 5 5 67 310 27 1
					)
					(SetFlag 70)
				)
			)
			(5
				(pighead dispose:)
				(if
					(and
						(== register 0)
						(not ((gInventory at: 12) ownedBy: 400)) ; cigar
						(not (gEgo has: 12)) ; cigar
					)
					(boss view: 385 loop: 2 cel: 0 setCycle: CT 3 1 self)
					((gInventory at: 12) owner: 400) ; cigar
					(= register 2)
				else
					(= cycles 1)
				)
				(pighead dispose:)
			)
			(6
				(if (== register 2)
					(boss cel: 4)
					(cigar
						z: 0
						illegalBits: 0
						ignoreActors: 1
						init:
						setCycle: MCyc @local106 self
					)
					(headCigarSFX init: play:)
				else
					(= cycles 1)
				)
			)
			(7
				(if (== register 2)
					(groundCigarSFX play:)
					(cigar
						setLoop: 5
						setSpeed: gGameSpeed
						setMotion: MoveTo 321 148 self
					)
				else
					(= cycles 1)
				)
				(boss
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 160 42 self
				)
			)
			(8 0)
			(9
				(boss dispose:)
				(if (== register 2)
					(cigar dispose:)
				)
				(= cycles 1)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(NormalEgo
					2
					(if (== (gEgo loop:) 1) 402 else 0)
					(if (== (gEgo loop:) 1) 14 else 4)
				)
				(= cycles 1)
			)
			(12
				(HandsOn)
				(proc700_5 1)
				(self dispose:)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)

	(method (doit)
		(if (and (not state) (not (gCurRoom script:)))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(HandsOff)
				((ScriptID 700 7) setCycle: CT 1 1 self) ; sp2
			)
			(2
				(= local135 (= local136 89))
				(= local138 (- (gEgo x:) 3))
				(= local137 194)
				(= local139
					(Graph
						grSAVE_BOX
						(- local135 1)
						(- local137 1)
						(+ local136 1)
						(+ local138 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local136
					local137
					local135
					local138
					(proc0_18 global133 global143)
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local135 1)
					(- local137 1)
					(+ local136 1)
					(+ local138 1)
				)
				(aSound number: 105 loop: 1 play:)
				(= cycles 1)
			)
			(3
				(blast
					init:
					cel: 0
					posn: local138 local135
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
				(gEgo view: 26 cel: 0 cycleSpeed: 12 setCycle: End self)
				(Graph grRESTORE_BOX local139)
				(Graph
					grREDRAW_BOX
					(- local135 1)
					(- local137 1)
					(+ local136 1)
					(+ local138 1)
				)
			)
			(4
				(EgoDead 8 24) ; "It's not over 'till the fat lady Orat spits... Well, it's over. All over. All over everything!"
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff 1
		xTweak 2
		key 270
		head 90
		xDir 1
		yDir 1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff -1
		xTweak 2
		key 90
		head 270
		xDir -1
		yDir 1
	)
)

(instance tossedSFX of Sound
	(properties
		number 836
	)
)

(instance headCigarSFX of Sound
	(properties
		number 873
	)
)

(instance groundCigarSFX of Sound
	(properties
		number 874
	)
)

(instance egoLandsSFX of Sound
	(properties
		number 134
	)
)

(instance door of Sq4View
	(properties
		x 168
		y 91
		sightAngle 90
		view 385
		loop 6
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 375 say: 1) ; "This store seems to be closed. A security door blocks the entrance."
			)
			(4 ; Do
				(gNarrator say: 2) ; "It's your pachyderm of an ex-boss."
			)
			(6 ; Smell
				(gNarrator say: 1) ; "You smell that famous but unidentifiable Monolith Burger Secret Sauce."
			)
			(7 ; Taste
				(gNarrator say: 11) ; "It tastes like another cheap plug for a Sierra product."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boss of Sq4Actor
	(properties
		x 160
		y 42
		sightAngle 90
		view 385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 2) ; "It's your pachyderm of an ex-boss."
			)
			(6 ; Smell
				(gNarrator say: 3) ; "He doesn't smell spring fresh, that's for sure."
			)
			(7 ; Taste
				(gNarrator say: 4) ; "Not with your taste buds!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pighead of Sq4Prop
	(properties
		z 1000
		view 1385
		loop 3
	)
)

(instance cigar of Sq4Actor
	(properties
		z 1000
		sightAngle 90
		yStep 1
		view 385
		loop 5
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 5) ; "Why, it's a cigar butt."
			)
			(6 ; Smell
				(gNarrator say: 6) ; "If you had it in your possession that might be possible."
			)
			(7 ; Taste
				(gNarrator say: 6) ; "If you had it in your possession that might be possible."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance store of Sq4Feature
	(properties
		x 131
		y 94
		sightAngle 90
	)

	(method (init)
		(super init:)
		(self onMeCheck: burgerPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 7) ; "Monolith Burger - the only fast-food chain to survive the infamous "Food Wars"."
			)
			(6 ; Smell
				(gNarrator say: 8) ; "Wow, it smells just like a giant, juicy, delicious Monolith Slugburger Combo!"
			)
			(7 ; Taste
				(gNarrator say: 4) ; "Not with your taste buds!"
			)
			(4 ; Do
				(gNarrator say: 9) ; "It feels like a real burger place!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 55
		y 90
		nsTop 81
		nsLeft 44
		nsBottom 106
		nsRight 63
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 370 say: 12) ; "This is a fine example of the wonders of fabricated flora."
			)
			(6 ; Smell
				(gNarrator say: 10) ; "It smells a little like Julanar, the enchanted plant woman from QUEST FOR GLORY II."
			)
			(7 ; Taste
				(gNarrator say: 11) ; "It tastes like another cheap plug for a Sierra product."
			)
			(4 ; Do
				(gNarrator modNum: 380 say: 1) ; "Don't bother. The fake plants are bolted down because of people like you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 262
		y 110
		nsTop 93
		nsLeft 256
		nsBottom 118
		nsRight 274
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 370 say: 12) ; "This is a fine example of the wonders of fabricated flora."
			)
			(6 ; Smell
				(gNarrator say: 10) ; "It smells a little like Julanar, the enchanted plant woman from QUEST FOR GLORY II."
			)
			(7 ; Taste
				(gNarrator say: 11) ; "It tastes like another cheap plug for a Sierra product."
			)
			(4 ; Do
				(gNarrator modNum: 380 say: 1) ; "Don't bother. The fake plants are bolted down because of people like you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance burgerPoly of Polygon
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance tPighead of FaceTalker
	(properties
		noun 24
		talkerNum 24
	)
)

(instance tROG of Sq4Talker ; UNUSED
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 22
		mouthOffsetY 31
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

