;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Path)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm510 0
)

(local
	local0
	local1
	[local2 5]
	[local7 10] = [120 137 126 137 132 138 139 137 146 138]
	[local17 5] = [214 81 360 100 -32768]
	[local22 5] = [214 86 360 100 -32768]
	[local27 5] = [216 86 214 180 -32768]
	[local32 5] = [216 81 214 180 -32768]
	[local37 45] = [3 0 201 62 3 1 201 62 3 2 201 62 3 3 201 62 3 4 197 64 3 5 180 66 3 6 167 79 3 7 165 93 3 8 162 117 3 9 169 148 3 10 169 148 -32768]
	[local82 25] = [4 0 220 58 4 1 219 65 4 2 220 89 4 4 224 112 4 3 227 140 4 3 227 180 -32768]
	[local107 29] = [0 0 188 134 0 1 188 134 0 2 188 134 0 3 207 121 0 4 228 130 0 5 237 147 0 5 237 180 -32768]
	local136
	local137
	local138
	local139
	local140
	local141
	local142
	local143
	local144
)

(instance rm510 of Rm
	(properties
		noun 7
		picture 510
		vanishingY -200
	)

	(method (init &tmp temp0)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 154 0 66 32 80 63 101 41 115 48 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 271 189 271 181 285 181 286 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 145 255 156 253 143 190 143 188 132 167 132 139 138 93 131 87 110 115 107 84 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 177 107 177 156 189 0 189
					yourself:
				)
		)
		(LoadMany rsVIEW 511 515 516 1 989 980 0 984 7 12)
		(rock init:)
		(marker init:)
		(mountains init:)
		(rack ignoreActors: 1 approachVerbs: 4 34 stopUpd: init:) ; Do, theVine
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			((= [local2 temp0] (spear new:))
				loop: 3
				cel: 0
				approachVerbs: 4 34 ; Do, theVine
				x: [local7 (* temp0 2)]
				y: [local7 (+ (* temp0 2) 1)]
				init:
			)
		)
		(gEgo changeGait: 1 setScale: 200 x: -30 y: 30 init:) ; running
		((ScriptID 39 1) ; Yesufu
			view: 983
			x: 0
			y: 60
			origStep: 2053
			setCycle: StopWalk -1
			setLoop: yesufuStopGroop
			setScale: 200
			ignoreActors: 1
			init:
		)
		((ScriptID 58 1) ; Elder
			setScale: 200
			view: 414
			loop: 0
			cel: 7
			x: 109
			y: 118
			setPri: 8
			ignoreActors: 1
			noun: 4
			illegalBits: 0
			init:
		)
		(hole init:)
		(string init:)
		(ring init:)
		(vine approachVerbs: 4 init:) ; Do
		(tree approachVerbs: 4 init:) ; Do
		(gCurRoom setScript: enterRoom)
		(super init:)
		(gGame save: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gEgo setScript: fallOff)
			)
			(65 ; Rest
				(gMessager say: 2 6 22) ; "This is no time to rest, where's your competitive spirit?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(UnLoad 128 511)
		(UnLoad 128 515)
		(UnLoad 128 516)
		(UnLoad 128 1)
		(UnLoad 128 989)
		(UnLoad 128 980)
		(UnLoad 128 0)
		(UnLoad 128 984)
		(UnLoad 128 7)
		(UnLoad 128 12)
		(LoadMany 0 39 983 942 58)
		(super dispose:)
	)
)

(instance egoWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo solvePuzzle: 288 5 9)
				(gEgo setMotion: PolyPath 109 125 self)
			)
			(1
				(gEgo setMotion: PolyPath 65 160 self)
				((ScriptID 39 1) setMotion: PolyPath 65 180) ; Yesufu
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance yesufuWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 1) setMotion: PolyPath 109 125 self) ; Yesufu
			)
			(1
				(gMessager say: 1 6 18 0 self) ; "Yesufu wins, because it took him fewer moves to get the ring."
			)
			(2
				((ScriptID 39 1) setMotion: PolyPath 65 180 self) ; Yesufu
			)
			(3
				(gEgo setMotion: PolyPath 65 160 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance awardPrize of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((and (< local138 3) local143)
						(gMessager say: 1 6 19 0 self) ; "The Prince of Shapeir wins, he took the fewest of moves and showed the most brains."
						(= temp0 1)
					)
					((and (< local138 3) (< local137 3) local142 local141)
						(gMessager say: 1 6 21 0 self) ; "The Prince of Shapeir jumped, then climbed tree."
						(= temp0 1)
					)
					((and (< local138 3) (< local137 2) local141)
						(gMessager say: 1 6 16 0 self) ; "The Prince of Shapeir climbed the tree to get the ring. This took fewer moves than Yesufu. The Prince of Shapeir be the winner."
						(= temp0 1)
					)
					((and (<= local138 3) (== local137 3) local141)
						(gMessager say: 1 6 14 0 self) ; "Yesufu is the winner, for even a monkey can climb the tree, but only a man can throw the spear."
						(= temp0 0)
					)
					(
						(and
							(<= local138 3)
							(< 0 local137 3)
							(not local141)
							local143
						)
						(= temp0 1)
						(= local144 1)
						(gMessager say: 1 6 13 0 self) ; "You both took three moves."
					)
					((and (<= local138 3) local142 local143)
						(= temp0 1)
						(= local144 1)
						(gMessager say: 1 6 13 0 self) ; "You both took three moves."
					)
					((> local138 3)
						(gMessager say: 1 6 12 0 self) ; "Yesufu is the winner. You both took three moves to get the rings, but Yesufu figured out how to get the ring first."
						(= temp0 0)
					)
					(local139
						(= temp0 0)
						(= cycles 1)
					)
				)
			)
			(1
				(if local144
					(gMessager say: 1 6 15 0 self) ; "The Prince of Shapeir is the winner, for he used the most brains of all."
				else
					(= cycles 1)
				)
			)
			(2
				(if temp0 ; UNINIT
					(self setScript: egoWin self)
				else
					(self setScript: yesufuWin self)
				)
			)
			(3
				(gMessager say: 1 6 20) ; "You may begin the race!"
				(gEgo setMotion: PolyPath -20 160 self)
				((ScriptID 39 1) setMotion: PolyPath -20 180) ; Yesufu
			)
			(4
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance dropRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(string dispose:)
				(ring setMotion: MoveTo (ring x:) 180 self)
			)
			(2
				(ring setCycle: 0)
				(ring dispose:)
			)
		)
	)
)

(instance throwSpVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(+= local138 2)
				(= local143 1)
				(ring setScript: spinRing)
				(gMessager say: 2 6 10 0 self) ; "You tie the vine to the end of the spear."
			)
			(1
				(gEgo view: 511 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(= local136 2)
				(gEgo view: 10 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
				([local2 local136] dispose:)
			)
			(3
				((= [local2 local136] (spear new:))
					view: 46
					setLoop: 6
					cel: 4
					x: 152
					y: 90
					setStep: 18 8
					moveSpeed: 0
					setPri: 0
					init:
					setMotion: spear3Path self spinRing
				)
				(gEgo setCycle: End)
			)
			(4
				(gMessager say: 2 6 11 0 self) ; "You only missed by a little bit."
			)
			(5
				(= local0 (Graph grSAVE_BOX 112 143 131 192 1))
				(Graph grDRAW_LINE 113 144 130 191 87 -1 -1)
				(Graph grUPDATE_BOX 113 144 130 191 1)
				(gEgo view: 511 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 113 144 130 191 1)
				(++ local136)
				(gEgo view: 10 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
				([local2 local136] dispose:)
			)
			(7
				((= [local2 local136] (spear new:))
					view: 46
					setLoop: 6
					cel: 4
					x: 152
					y: 90
					moveSpeed: 0
					setStep: 18 8
					setPri: 0
					init:
					setMotion: spear4Path self spinRing
				)
				(gEgo setCycle: End)
			)
			(8
				(= local0 (Graph grSAVE_BOX 113 144 130 191 1))
				(Graph grDRAW_LINE 113 144 130 191 87 -1 -1)
				(Graph grUPDATE_BOX 113 144 130 191 1)
				(gEgo view: 511 setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(Graph grRESTORE_BOX local0)
				(Graph grUPDATE_BOX 113 144 130 191 1)
				(gEgo normalize:)
				(client setScript: awardPrize)
			)
		)
	)
)

(instance getVine of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo view: 31 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(vine dispose:)
				(gEgo get: 24 normalize:) ; theVine
				((gInventory at: 24) owner: gEgo) ; theVine
				(gTheIconBar
					curInvIcon: (gInventory at: 24) ; theVine
					curIcon: (gTheIconBar at: 7)
					enable: 7
				)
				((gTheIconBar at: 7) cursor: Cursor)
				(((gTheIconBar at: 7) cursor:) view: 905 loop: 10 cel: 8)
				(gGame setCursor: ((gTheIconBar at: 7) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance jumpForRing of Script
	(properties)

	(method (doit)
		(cond
			((and (== state 1) (== (gEgo cel:) 3))
				(ring setCycle: Fwd)
			)
			((== state 3)
				(ring setCycle: 0 cel: 0)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local142 1)
				(HandsOff)
				(++ local138)
				(gEgo changeGait: 1 setMotion: PolyPath 187 135 self) ; running
			)
			(1
				(gEgo
					view: 516
					setLoop: 0
					cel: 0
					setPri: 0
					setCycle: MCyc @local107 self
				)
			)
			(2
				(= ticks 240)
			)
			(3
				(gEgo setLoop: 1 x: 191 y: 132 setCycle: End self)
			)
			(4
				(gEgo
					x: 184
					y: 134
					setPri: -1
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(5
				(gEgo normalize:)
				(gMessager say: 2 6 8 0 self) ; "That doesn't seem to be the best way to get the ring. It certainly isn't the most graceful."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwSpears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local139 1)
				(+= local138 4)
				(gEgo view: 10)
				(= local136 2)
				(= cycles 1)
			)
			(1
				(gEgo setLoop: 0 cel: 0 setCycle: CT 4 1 self)
				([local2 local136] dispose:)
			)
			(2
				((= [local2 local136] (spear new:))
					view: 46
					setLoop: 6
					cel: 4
					x: 152
					y: 90
					setStep: 18 8
					moveSpeed: 0
					setPri: 9
					init:
					setMotion: spearPath self
				)
				(gEgo setCycle: End)
			)
			(3
				(if (== (++ local136) 4)
					(= cycles 1)
				else
					(switch local136
						(2
							(gMessager say: 2 6 6) ; "You missed by a mile."
						)
						(3
							(gMessager say: 2 6 7) ; "You missed by an inch."
						)
					)
					(self changeState: (-= state 2))
				)
			)
			(4
				(gEgo setLoop: 0 cel: 0 setCycle: CT 4 1 self)
				(ring setScript: dropRing)
				([local2 local136] dispose:)
			)
			(5
				((= [local2 local136] (spear new:))
					view: 46
					setLoop: 6
					cel: 4
					x: 152
					y: 90
					setStep: 18 8
					moveSpeed: 0
					setPri: 9
					init:
					setMotion: spear2Path self dropRing
				)
				(gEgo setCycle: End)
			)
			(6
				(gEgo view: 1 setCycle: Walk setMotion: MoveTo 187 135 self)
			)
			(7
				(gEgo
					view: 516
					setLoop: 0
					cel: 0
					setPri: 0
					setCycle: MCyc @local107 self
				)
			)
			(8
				(= ticks 240)
			)
			(9
				(gEgo setLoop: 1 x: 191 y: 132 setCycle: End self)
			)
			(10
				(gEgo
					x: 184
					y: 134
					setPri: -1
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(11
				(gEgo normalize:)
				(client setScript: awardPrize)
			)
		)
	)
)

(instance fallOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gWalkHandler delete: gCurRoom)
				(User canControl: 1)
				(HandsOff)
				(gEgo view: 6 setPri: 0 setCycle: MCyc @local82 self)
			)
			(1
				(gEgo view: 516 loop: 1 x: 191 y: 132 setCycle: End self)
			)
			(2
				(gEgo
					x: 184
					y: 134
					setPri: -1
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local141 1)
				(gWalkHandler delete: gCurRoom)
				(HandsOff)
				(gEgo view: 4 x: 191 y: 58 cel: 0 setCycle: End self)
			)
			(1
				(string setMotion: MoveTo 210 63 self)
				(ring setMotion: MoveTo 210 68)
			)
			(2
				(string dispose:)
				(ring dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 30 setCycle: MCyc @local37 self)
			)
			(4
				(gEgo normalize:)
				(client setScript: awardPrize)
			)
		)
	)
)

(instance egoClimbTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ local138)
				(gWalkHandler addToFront: gCurRoom)
				(User canControl: 0)
				(gEgo setMotion: MoveTo 130 125 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 3
					setScale:
					setCycle: Fwd
					setMotion: MoveTo 124 96 self
				)
			)
			(2
				(gEgo setLoop: 5 cel: 0 x: 120 y: 64 setCycle: End self)
			)
			(3
				(gEgo
					view: 12
					setLoop: 0
					x: 125
					y: 65
					setCycle: Walk
					setMotion: MoveTo 146 58 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 178 54 self)
			)
			(5
				(gEgo setMotion: MoveTo 199 60 self)
			)
			(6
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoTryClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 7
					setLoop: 3
					setScale:
					setCycle: Fwd
					setMotion: MoveTo 130 102 self
				)
			)
			(1
				(gEgo setCycle: 0 setMotion: MoveTo 130 120 self)
			)
			(2
				(++ local137)
				(++ local138)
				(gEgo normalize:)
				(gMessager say: 2 6 5 0 self) ; "You should practice climbing more often."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoCantClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local140 1)
				(HandsOff)
				(gEgo view: 7 setLoop: 3 cycleSpeed: 2 setCycle: Fwd)
				(= ticks 240)
			)
			(1
				(++ local138)
				(gEgo cycleSpeed: 6 normalize:)
				(gMessager say: 2 6 3 0 self) ; "You do not have the skill of climbing."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spinRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(ring setCycle: Fwd)
			)
			(2
				(string dispose:)
				(ring setMotion: MoveTo (ring x:) 180 self)
			)
			(3
				(ring setCycle: 0)
				(ring dispose:)
			)
		)
	)
)

(instance runIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 36 72 self)
			)
			(1
				(gEgo setMotion: PolyPath 66 161 self)
			)
			(2
				(gEgo view: 0 normalize: setSpeed: global126 setHeading: 90)
				(= cycles 18)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 1) ; Yesufu
					xStep: 5
					yStep: 3
					setMotion: PolyPath 36 72 self
				)
			)
			(1
				(gEgo setScript: runIn self)
				(HandsOff)
				((ScriptID 39 1) setMotion: PolyPath 76 135 self) ; Yesufu
			)
			(2
				((ScriptID 39 1) setMotion: PolyPath 109 125 self) ; Yesufu
			)
			(3
				((ScriptID 39 1) setHeading: 0) ; Yesufu
				(= cycles 18)
			)
			(4)
			(5
				(gMessager say: 1 6 1 0 self) ; "Yesufu be the winner of the first race!"
			)
			(6
				(gMessager say: 1 6 2 0 self) ; "The way to be winning this contest is to get the ring from the rope."
			)
			(7
				((ScriptID 39 1) setMotion: PolyPath 109 142 self) ; Yesufu
			)
			(8
				((ScriptID 39 1) view: 984 loop: 0 cel: 0 setCycle: CT 4 1 self) ; Yesufu
			)
			(9
				((ScriptID 39 1) setCycle: End self) ; Yesufu
				([local2 local136] dispose:)
			)
			(10
				((ScriptID 39 1) ; Yesufu
					x: 120
					y: 140
					loop: 1
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(11
				((= [local2 local136] (spear new:))
					view: 46
					setLoop: 6
					cel: 4
					x: 152
					y: 90
					setStep: 18 8
					moveSpeed: 0
					setPri: 9
					init:
					setMotion: spearPath self spinRing
				)
				((ScriptID 39 1) setCycle: End) ; Yesufu
			)
			(12
				([local2 local136] dispose:)
				(if (!= local136 1)
					(++ local136)
					(-= state 5)
					(= ticks 120)
				else
					(= ticks 1)
				)
			)
			(13
				((ScriptID 39 1) ; Yesufu
					x: 109
					y: 138
					view: 983
					setCycle: StopWalk -1
					setLoop: yesufuStopGroop
					setMotion: MoveTo 165 140 self
				)
			)
			(14
				((ScriptID 39 1) ; Yesufu
					view: 515
					setLoop: 0
					cel: 0
					x: 191
					y: 140
					setCycle: End self
				)
			)
			(15
				((ScriptID 39 1) ; Yesufu
					setPri: 0
					moveSpeed: 0
					setScale:
					origStep: 1290
					setMotion: MoveTo 240 220 self
				)
			)
			(16
				(= ticks 240)
			)
			(17
				((ScriptID 39 1) ; Yesufu
					setLoop: 1
					setPri: -1
					x: 222
					y: 140
					origStep: 2053
					cel: 0
					moveSpeed: 6
					setCycle: End self
				)
			)
			(18
				(= ticks 120)
			)
			(19
				((ScriptID 39 1) ; Yesufu
					view: 983
					setPri: -1
					setCycle: StopWalk -1
					setLoop: yesufuStopGroop
					setMotion: PolyPath 96 185 self
				)
			)
			(20
				((ScriptID 39 1) setHeading: 90) ; Yesufu
				((ScriptID 58 1) setCycle: End self) ; Elder
				(string y: 65 setMotion: MoveTo 210 73 init:)
				(ring y: 70 cel: 0 setMotion: MoveTo 210 78 init:)
			)
			(21
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance hole of Feature
	(properties
		x 210
		y 65
		noun 3
		sightAngle 40
		onMeCheck 8
	)
)

(instance tree of Feature
	(properties
		x 115
		y 90
		noun 10
		sightAngle 40
		onMeCheck 4
		approachX 119
		approachY 130
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(cond
					((gCurRoom script:) 0)
					((< (gEgo y:) 60) 0)
					((and (== (= temp0 (gEgo trySkill: 11 150)) 0) local140) ; climb
						(gMessager say: 2 6 4) ; "You can't improve upon a skill you know nothing about. Try another approach."
					)
					((== temp0 0)
						(gCurRoom setScript: egoCantClimb)
					)
					((and (== temp0 -1) (< local137 3))
						(gCurRoom setScript: egoTryClimb)
					)
					(else
						(gCurRoom setScript: egoClimbTree)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock of Feature
	(properties
		x 74
		y 169
		noun 11
		nsTop 149
		nsBottom 189
		nsRight 149
		sightAngle 180
	)
)

(instance marker of Feature
	(properties
		x 282
		y 161
		noun 12
		nsTop 133
		nsLeft 278
		nsBottom 189
		nsRight 287
		sightAngle 180
	)
)

(instance mountains of Feature
	(properties
		x 159
		y 31
		noun 13
		nsTop 22
		nsBottom 41
		nsRight 319
		sightAngle 180
	)
)

(instance vine of View
	(properties
		x 77
		y 43
		noun 6
		approachX 80
		approachY 111
		view 510
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: getVine)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spear of Actor
	(properties
		noun 8
		view 510
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: 1 &rest)
		else
			(rack doVerb: theVerb)
		)
	)
)

(instance ring of Actor
	(properties
		x 210
		y 78
		noun 5
		yStep 10
		view 510
		loop 1
		signal 18448
		illegalBits 0
	)

	(method (init)
		(self setScript: spinRing)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo script:) 0)
					((== (gEgo view:) 12)
						(gEgo setScript: getRing)
					)
					((and (!= (gEgo view:) 12) (not local142))
						(gEgo setScript: jumpForRing)
					)
					((and (!= (gEgo view:) 12) local142)
						(gMessager say: 2 6 9) ; "You better think of another approach if you want to win this contest."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance string of Actor
	(properties
		x 210
		y 73
		noun 9
		view 510
		loop 1
		cel 1
		signal 18432
	)
)

(instance rack of Actor
	(properties
		x 144
		y 135
		approachX 132
		approachY 150
		view 510
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: throwSpears)
				)
			)
			(34 ; theVine
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: throwSpVine)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance yesufuStopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject ((ScriptID 39 1) cycler:)) ; Yesufu
				(((ScriptID 39 1) cycler:) isKindOf: StopWalk) ; Yesufu
			)
			((ScriptID 39 1) view: (((ScriptID 39 1) cycler:) vWalking:)) ; Yesufu, Yesufu
		)
		(super doit: &rest)
	)
)

(instance spearPath of Path
	(properties)

	(method (at param1)
		(return [local17 param1])
	)
)

(instance spear2Path of Path
	(properties)

	(method (at param1)
		(return [local22 param1])
	)
)

(instance spear3Path of Path
	(properties)

	(method (at param1)
		(return [local27 param1])
	)
)

(instance spear4Path of Path
	(properties)

	(method (at param1)
		(return [local32 param1])
	)
)

