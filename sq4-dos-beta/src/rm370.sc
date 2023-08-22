;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use SQRoom)
(use Osc)
(use RandCycle)
(use Polygon)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 24] = [0 0 0 0 101 45 1 102 51 2 103 62 3 104 65 4 106 71 5 106 74 -1 -1 -1]
	local30 = 59
)

(instance rm370 of SQRoom
	(properties
		picture 370
		style 30
		east 375
		south 400
		west 400
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(Load rsVIEW 370)
		(gLongSong2 number: 371 loop: -1 playBed:)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 37)
					(= temp1 239)
				else
					(= temp0 -18)
					(= temp1 178)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 339)
					(= temp1 66)
				else
					(= temp0 329)
					(= temp1 3)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(405
				(gLongSong number: 405 loop: -1 vol: 127 play:)
				(if (and (IsFlag 21) (not (IsFlag 24)))
					(SetFlag 24)
					(SetFlag 8)
					(SetFlag 10)
					(SetFlag 11)
					(SetFlag 13)
					(SetFlag 12)
					(ClearFlag 9)
				)
				(self setScript: fromElsewhereScript 0 0)
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 127 play:)
				(gEgo posn: -10 -10)
				(if
					(and
						(TestMallFlag (ScriptID 700 0) #rFlag1 128) ; mall
						(not (TestMallFlag (ScriptID 700 0) #rFlag3 16)) ; mall
					)
					(self setScript: tossScript)
				else
					(mall rFlag3: (& (mall rFlag3:) $ffef))
					(self setScript: fromElsewhereScript 0 1)
				)
			)
		)
		(if (IsFlag 8)
			(door init: priority: 0 signal: (| (door signal:) $4010))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 296 0 177 60 143 60 119 45 68 69 74 75 78 83 79 87 79 104 74 114 0 150 0 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 150 0 19 75 76 78 83 79 89 79 97 79 103 74 114
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 296 0 176 60 161 60 143 60 50 0
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 133 119 166 141 72 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 27 319 65 213 117 180 96
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 180 189 207 176 224 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 304 189 291 183 291 180 279 173 279 166 252 152 319 119
					yourself:
				)
		)
		(gEgo init: setPri: -1)
		(super init:)
		(dummy1 init: setCycle: Osc)
		(dummy2 init: setCycle: Osc)
		(if global101
			(light2 init: setCycle: RandCycle)
			(light3 init: setCycle: RandCycle)
			(light4 init: setCycle: RandCycle)
			(light5 init: setCycle: RandCycle)
			(light6 init: setCycle: RandCycle)
			(light7 init: setCycle: RandCycle)
		)
		(if (IsFlag 25)
			(ClearFlag 25)
			((ScriptID 700 6) init: setScript: sp1Squeeze) ; sp1
		)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local30 0)) 0)
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
				(gCurRoom newRoom: 371)
			)
			((StepOn gEgo 16)
				(HandsOff)
				(self setScript: goToRamaScript)
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
				(gEgo setPri: -1)
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

(instance tossScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: (if (TestMallFlag (ScriptID 700 0) #rFlag3 8) 1 else 0) ; mall
				)
				(= local5 0)
				(= seconds 5)
			)
			(1
				(if (!= [local6 (+= local5 3)] -1)
					(-- state)
					(gEgo
						view: 392
						illegalBits: 0
						cel: [local6 local5]
						posn: [local6 (+ local5 1)] [local6 (+ local5 2)]
					)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(Print 370 0) ; "** HOOK, need view of getting up."
				(if (TestMallFlag (ScriptID 700 0) #rFlag3 8) ; mall
					(NormalEgo 2 402 14)
					(AnimateEgoHead 14)
				else
					(NormalEgo 2 0 4)
					(AnimateEgoHead 4)
				)
				(proc700_5 1)
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ff7f)) ; mall, mall
				(self dispose:)
			)
		)
	)
)

(instance fromElsewhereScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 373)
					(ClearFlag 8)
				)
				(if register
					(= temp0 75)
					(= temp1 40)
					(= temp2 110)
					(= temp3 74)
				else
					(= temp0 329)
					(= temp1 244)
					(= temp2 252)
					(= temp3 168)
				)
				(gEgo x: temp0 y: temp1 setMotion: MoveTo temp2 temp3 self)
			)
			(1
				(if (and (== (gEgo view:) 0) (IsFlag 31))
					(SetFlag 8)
				)
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToRamaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 135 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: 405)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 3
		yOff 1
		xTweak 1
		yTweak 1
		key 225
		head 63
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep 1
		xOff 10
		yOff 1
		xTweak 1
		yTweak 1
		key 45
		head 242
		xDir -1
		yDir 1
	)
)

(instance door of Prop
	(properties
		x 86
		y 69
		view 370
		loop 8
	)
)

(instance light2 of Prop
	(properties
		x 19
		y 108
		view 370
		loop 2
		cel 4
	)
)

(instance light3 of Prop
	(properties
		x 194
		y 16
		view 370
		loop 3
		cel 2
		priority 15
		signal 16
	)
)

(instance light4 of Prop
	(properties
		x 50
		y 75
		view 370
		loop 4
		cel 1
		priority 15
		signal 16
	)
)

(instance light5 of Prop
	(properties
		x 140
		y 25
		view 370
		loop 5
		cel 3
	)
)

(instance light6 of Prop
	(properties
		x 164
		y 28
		view 370
		loop 6
		cel 3
	)
)

(instance light7 of Prop
	(properties
		x 48
		y 91
		view 370
		loop 7
		cel 1
	)
)

(instance dummy1 of Prop
	(properties
		x 26
		y 101
		description {dummy}
		sightAngle 90
		lookStr {In the window a robotic garment rack struts its stuff.}
		view 370
		cycleSpeed 2
	)
)

(instance dummy2 of Prop
	(properties
		x 160
		y 20
		description {dummy}
		sightAngle 90
		lookStr {In the window a robotic garment rack struts its stuff.}
		view 370
		loop 1
		cycleSpeed 2
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

(instance sp1Squeeze of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not state) (> (gEgo x:) 90))
				(self cue:)
			)
			((and (not register) (StepOn client 1024))
				(if (> (gEgo x:) 259)
					(self changeState: 9)
				)
			)
			((and (not register) (< (gEgo y:) 138))
				(self changeState: 9)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 1 setCel: 0 posn: 320 2)
			)
			(1
				(client
					setLoop: 1
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 244 46 self
				)
			)
			(2
				(client setLoop: 2 setMotion: MoveTo 231 49 self)
			)
			(3
				(client setMotion: MoveTo 163 86 view: 13 setCycle: CT 1 1 self)
			)
			(4
				(= local0 21)
				(= local1 172)
				(= local3 210)
				(= local2 226)
				(= local4
					(Graph
						grSAVE_BOX
						(- local0 1)
						(- local3 1)
						(+ local1 1)
						(+ local2 1)
						1
					)
				)
				(Graph grDRAW_LINE local0 local2 local1 local3 global133 4 -1)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(= cycles 1)
			)
			(5
				(client setCycle: End)
				(Graph grRESTORE_BOX local4)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(client cel: 0)
				(blast init: posn: 210 170 setCycle: End self)
				((ScriptID 700 7) init: setScript: sp2Squeeze) ; sp2
			)
			(6
				(client setCycle: CT 1 1 self)
			)
			(7
				(= local3 (- (client x:) 4))
				(= local0 (- (client y:) 27))
				(= local2 275)
				(= local1 132)
				(= local4
					(Graph
						grSAVE_BOX
						(- local0 1)
						(- local3 1)
						(+ local1 1)
						(+ local2 1)
						1
					)
				)
				(Graph grDRAW_LINE local0 local3 local1 local2 global133 4 -1)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(= cycles 1)
			)
			(8
				(client setCycle: End)
				(blast init: posn: 275 132 setCycle: End)
				(Graph grRESTORE_BOX local4)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(client cel: 0)
			)
			(9
				(= register 1)
				(client setCycle: CT 1 1 self)
			)
			(10
				(= local3 (- (client x:) 4))
				(= local0 (- (client y:) 27))
				(= local2 (gEgo x:))
				(= local1 (- (gEgo y:) 30))
				(= local4
					(Graph
						grSAVE_BOX
						(- local0 1)
						(- local3 1)
						(+ local1 1)
						(+ local2 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local0
					local3
					local1
					local2
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(= cycles 1)
			)
			(11
				(client setCycle: End)
				(blast init: posn: local2 local1 setCycle: End self)
				(Graph grRESTORE_BOX local4)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(client cel: 0)
			)
			(12
				(EgoDead 370 1)
			)
		)
	)
)

(instance sp2Squeeze of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not state)
				(not (gCurRoom script:))
				(or (< (gEgo x:) 130) (> (+ (gEgo y:) 4) (client y:)))
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client posn: 33 229 view: 13 setLoop: 0 setCel: 0)
				(= cycles 8)
			)
			(1
				(client setMotion: MoveTo 86 184 self)
			)
			(2
				(Print 370 2) ; "fire one"
				(client setCycle: CT 1 1 self)
			)
			(3
				(Print 370 3) ; "drawing laser line"
				(= register (not (gCurRoom script:)))
				(= local3 (+ (client x:) 6))
				(= local1 (- (client y:) 29))
				(if register
					(= local2 (gEgo x:))
					(= local0 (- (gEgo y:) 32))
					(gEgo setMotion: 0)
				else
					(= local2 295)
					(= local0 151)
				)
				(= local4
					(Graph
						grSAVE_BOX
						(- local0 1)
						(- local3 1)
						(+ local1 1)
						(+ local2 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local1
					local3
					local0
					local2
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(= cycles 1)
			)
			(4
				(client setCycle: End)
				(blast cel: 0 posn: local2 local0 setPri: 10 setCycle: End self)
				(Graph grRESTORE_BOX local4)
				(Graph grREDRAW_BOX (- local0 1) (- local3 1) (+ local1 1) (+ local2 1))
				(client cel: 0)
			)
			(5
				(if register
					(EgoDead 370 4)
				)
			)
		)
	)
)

