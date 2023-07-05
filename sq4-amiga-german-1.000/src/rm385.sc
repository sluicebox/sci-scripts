;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use eRS)
(use RandCycle)
(use MCyc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
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
				(gLongSong2 number: 4 loop: -1 vol: 10 flags: 1 playBed: 0)
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
				(gLongSong number: 405 loop: -1 vol: 95 flags: 1 play:)
				(gEgo x: -100 y: -100)
				(if (TestMallFlag (ScriptID 700 0) #rFlag4 1) ; mall
					(self setScript: egoTossedOut 0)
					(mall rFlag4: (& (mall rFlag4:) $fffe))
				else
					(self setScript: fromStoreScript)
				)
			)
		)
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
						init: 153 65 152 75 138 97 0 91 0 65
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 170 65 319 65 319 108 183 100
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
		(gEgo init: setPri: -1)
		(self setRegions: 700) ; mall
		(gFeatures addToFront: store bush1 bush2 eachElementDo: #init doit:)
	)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local141 0)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(gLongSong2 vol: (- 127 (/ temp0 3)) changeState:)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((== (gEgo edgeHit:) 4)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
			((StepOn gEgo 8)
				(if (== (gEgo view:) 402)
					(self setScript: egoTossedOut 0 1)
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
				(boss loop: 4)
				(pighead
					init:
					ignoreActors: 1
					illegalBits: 0
					setPri: 7
					x: (+ (boss x:) 2)
					y: (- (boss y:) 48)
					z: 0
					setCycle: RandCycle 30 self
				)
				(if (== register 1)
					(= local140
						(proc0_12
							385
							0
							67
							70
							20
							28
							(proc0_18 global135 global136 global135)
							29
							global129
							70
							245
						)
					)
				else
					(= local140
						(proc0_12
							385
							1
							70
							310
							67
							10
							10
							28
							(proc0_18 global135 global136 global135)
							29
							global129
							30
							1
						)
					)
					(SetFlag 70)
				)
			)
			(5
				(proc0_12 local140)
				(if
					(and
						(== register 0)
						(not ((gInventory at: 12) ownedBy: 400)) ; cigar
						(not (gEgo has: 12)) ; cigar
					)
					(boss loop: 2 cel: 0 setCycle: CT 3 1 self)
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
						init:
						z: 0
						illegalBits: 0
						ignoreActors: 1
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
					(cigar setLoop: 5 setMotion: MoveTo 321 148 self)
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
					(proc0_18 global133 global143 global143)
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
				(aSound number: 105 loop: 1 vol: 127 play:)
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
				(gEgo view: 26 cel: 0 cycleSpeed: 1 setCycle: End self)
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
				(EgoDead 8 24)
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

(instance door of PicView
	(properties
		x 168
		y 91
		description {door}
		sightAngle 90
		view 385
		loop 6
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 2) ; "This store seems to be closed. A security door blocks the entrance."
			)
			(3 ; Do
				(Print 385 3) ; "It's locked down tight. You can't open it."
			)
			(11 ; Smell
				(Print 385 4) ; "You smell that famous but unidentifiable Monolith Burger Secret Smell(tm)."
			)
			(10 ; Taste
				(Print 385 5) ; "It tastes like it smells."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boss of Actor
	(properties
		x 160
		y 42
		sightAngle 90
		view 385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 6) ; "It's your pachyderm of an ex-boss."
			)
			(11 ; Smell
				(Print 385 7) ; "He doesn't smell spring fresh, that's for sure."
			)
			(10 ; Taste
				(Print 385 8) ; "Not with your taste buds!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pighead of Actor
	(properties
		z 1000
		view 385
		loop 3
	)
)

(instance cigar of Actor
	(properties
		z 1000
		description {cigar}
		sightAngle 90
		yStep 1
		view 385
		loop 5
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 9) ; "It's a cigar butt."
			)
			(11 ; Smell
				(Print 385 10) ; "If you had it in your possession that might be possible."
			)
			(10 ; Taste
				(Print 385 10) ; "If you had it in your possession that might be possible."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

(instance store of Feature
	(properties
		description {Monolith Burger}
		sightAngle 90
	)

	(method (onMe param1)
		(return (>= 5 (/ (* 100 (- (param1 y:) 88)) (Max 1 (param1 x:)))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 11) ; "This is Monolith Burger - the only fast-food chain to survive the infamous "Food Wars"."
			)
			(11 ; Smell
				(Print 385 12) ; "Wow, it smells just like a giant, juicy, delicious Monolith Slugburger Combo!"
			)
			(10 ; Taste
				(Print 385 13) ; "Wow, it tastes just like a giant, delicious Monolith Slugburger Combo, coated with a heavy duoplasticizer and shellacked to look extra juicy!"
			)
			(3 ; Do
				(Print 385 14) ; "It feels like a real burger place!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Feature
	(properties
		x 55
		y 90
		nsTop 81
		nsLeft 44
		nsBottom 106
		nsRight 63
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 15) ; "This is a fine example of the wonders of fabricated flora."
			)
			(11 ; Smell
				(Print 385 16) ; "It smells a little like Julanar, the enchanted plant woman from QUEST FOR GLORY II."
			)
			(10 ; Taste
				(Print 385 17) ; "It tastes like another cheap plug for another Sierra product."
			)
			(3 ; Do
				(Print 385 18) ; "Hey! They had to be bolted to the super-structure because of people like you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Feature
	(properties
		x 262
		y 110
		nsTop 93
		nsLeft 256
		nsBottom 118
		nsRight 274
		description {fabricated flora}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 385 15) ; "This is a fine example of the wonders of fabricated flora."
			)
			(11 ; Smell
				(Print 385 16) ; "It smells a little like Julanar, the enchanted plant woman from QUEST FOR GLORY II."
			)
			(10 ; Taste
				(Print 385 17) ; "It tastes like another cheap plug for another Sierra product."
			)
			(3 ; Do
				(Print 385 18) ; "Hey! They had to be bolted to the super-structure because of people like you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

