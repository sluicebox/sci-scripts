;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use SQRoom)
(use RandCycle)
(use MCyc)
(use Polygon)
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
		style 30
		east 390
		west 380
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(gLongSong2 number: 4 loop: -1 playBed:)
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
				(gEgo x: -100 y: -100)
				(self setScript: egoTossedOut 0 0)
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 127 play:)
				(gEgo x: -100 y: -100)
				(self setScript: fromStoreScript)
			)
		)
		(if (IsFlag 11)
			(door
				init:
				priority: 1
				signal: (| (door signal:) $0010)
				setCel: (door lastCel:)
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 108 0 91 0 0 319 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 153 65 152 75 131 97 0 91 0 55
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 174 65 319 66 319 108 190 101
						yourself:
					)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 165 319 189 0 189 0 149
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 108 131 115 120 134 0 128
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 122 319 144 193 136 184 117
					yourself:
				)
		)
		(if (and (IsFlag 25) (not (IsFlag 24)))
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
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
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
			)
			((StepOn gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
			)
			((or (egoBwGreen onCon:) (egoBwBlue onCon:))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo setStep: 3 2)
				(proc700_5 1)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 385 0) ; "*** outside monoburger."
			)
		)
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

(instance egoTossedOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 392)
				(HandsOff)
				(if (== register 1)
					(gEgo illegalBits: 0 setMotion: MoveTo 160 42 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 392 setLoop: register)
				(if (== register 1)
					(gEgo setCycle: MCyc @local53 self)
				else
					(gEgo setCycle: MCyc @local0 self)
				)
			)
			(2
				(boss
					init:
					setLoop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 155 95 self
				)
			)
			(3
				(boss loop: 4)
				(pighead
					init:
					ignoreActors: 1
					illegalBits: 0
					setPri: 7
					x: (+ (boss x:) 2)
					y: (- (boss y:) 48)
					z: 0
					setCycle: RandCycle 20 self
				)
				(if (== register 1)
					(= local140
						(proc0_12
							{*** No shirt, no shoes, no service!!}
							67
							70
							20
							28
							global135
							29
							global129
						)
					)
				else
					(= local140
						(proc0_12
							{*** You're fired!!}
							67
							80
							20
							28
							global135
							29
							global129
						)
					)
				)
			)
			(4
				(proc0_12 local140)
				(if (and (== register 0) (not (IsFlag 3)))
					(boss loop: 2 cel: 0 setCycle: CT 3 1 self)
					(SetFlag 3)
					(= register 2)
				else
					(= cycles 1)
				)
				(pighead dispose:)
			)
			(5
				(if (== register 2)
					(boss cel: 4)
					(cigar
						init:
						z: 0
						illegalBits: 0
						ignoreActors: 1
						setCycle: MCyc @local106 self
					)
				else
					(= cycles 1)
				)
			)
			(6
				(if (== register 2)
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
			(7 0)
			(8
				(boss dispose:)
				(if (== register 2)
					(cigar dispose:)
				)
				(Print 385 1) ; "*** HEY!!!!! Need a view of ego standing up."
				(NormalEgo
					2
					(if (== (gEgo loop:) 1) 402 else 0)
					(if (== (gEgo loop:) 1) 14 else 4)
				)
				(= cycles 1)
			)
			(9
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
					global133
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
				(= cycles 1)
			)
			(3
				(blast
					init:
					cel: 0
					posn: local138 local135
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
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
				(= cycles 8)
			)
			(5
				(EgoDead 385 2)
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

(instance door of Prop
	(properties
		x 133
		y 49
		view 385
		loop 8
	)
)

(instance boss of Actor
	(properties
		x 160
		y 42
		view 385
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
		yStep 1
		view 385
		loop 5
		xStep 2
	)
)

(instance blast of Prop
	(properties
		view 499
		loop 1
	)
)

