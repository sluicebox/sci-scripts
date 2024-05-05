;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use rmnScript)
(use SQRoom)
(use Polygon)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	[local0 18] = [181 5 187 8 197 14 211 16 225 20 235 31 250 36 263 41 274 45]
	local18
	local19
	local20
	local21
	local22
)

(instance rm390 of SQRoom
	(properties
		picture 390
		style 30
		north 385
		east 395
		south 395
		west 385
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -9)
					(= temp1 -6)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 256)
					(= temp1 249)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(410
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
				(self setScript: fromElsewhereScript 0 1)
			)
		)
		(if (IsFlag 12)
			(door
				init:
				priority: 1
				signal: (| (door signal:) $0010)
				setCel: (door lastCel:)
			)
			(self
				addObstacle:
					((Polygon new:) type: PBarredAccess init: 21 0 319 0 319 150 yourself:)
			)
		else
			(self
				addObstacle:
					((Polygon new:) type: PBarredAccess init: 307 0 159 71 21 0 yourself:)
					((Polygon new:)
						type: PBarredAccess
						init: 319 150 229 105 319 51
						yourself:
					)
			)
		)
		(super init:)
		(zap init: setScript: zapScript)
		(gEgo init: setPri: -1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 116 64 149 64 157 44 170 40 179 13 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 28 142 99 111 118 0 62
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 254 189 159 142 191 121 319 187 319 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 142 189 95 189 111 173 yourself:)
		)
		(if (and (IsFlag 25) (not (IsFlag 24)))
			((ScriptID 700 7) init: hide: posn: -12 79 setScript: sp2Squeeze) ; sp2
		)
		(self setRegions: 700) ; mall
	)

	(method (doit)
		(cond
			(script 0)
			((OneOf (gEgo edgeHit:) 3 2)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((OneOf (gEgo edgeHit:) 1 4)
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
			((StepOn gEgo 16)
				(HandsOff)
				(self setScript: goToRamaScript)
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 391)
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
				(gEgo setStep: 3 2 setPri: -1)
				(proc700_5 1)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 391)
			(gLongSong fade: 40 10 10 0)
		)
		(cond
			((OneOf newRoomNumber 391 410)
				(super newRoom: newRoomNumber)
			)
			((!= script (ScriptID 700 2)) ; exS
				(HandsOff)
				(self setScript: (ScriptID 700 2) 0 1) ; exS
			)
			((and script (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromElsewhereScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if register
					(= temp0 224)
					(= temp1 54)
					(= temp2 196)
					(= temp3 82)
				else
					(= temp0 -3)
					(= temp1 244)
					(= temp2 71)
					(= temp3 170)
				)
				(gEgo x: temp0 y: temp1 setMotion: MoveTo temp2 temp3 self)
			)
			(1
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
				(gEgo setHeading: 225 setMotion: MoveFwd 80 self)
			)
			(1
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance zapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					x: [local0 register]
					y: [local0 (+ register 1)]
					cel: (/ register 2)
				)
				(= cycles 1)
				(if (< register 3)
					(signSound play:)
				)
			)
			(1
				(if (> (+= register 2) 16)
					(= register 0)
				)
				(self init:)
			)
		)
	)
)

(instance zap of Prop
	(properties
		x 181
		y 5
		view 390
		priority 15
		signal 16
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 315
		head 119
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 135
		head 301
		xDir -1
		yDir 1
	)
)

(instance door of Prop
	(properties
		x 196
		y 40
		view 390
		loop 1
	)
)

(instance sp2Squeeze of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not state) (or (< (gEgo x:) 219) (StepOn gEgo 8192)))
				(self cue:)
			)
			((gCurRoom script:))
			(
				(and
					(< (gEgo y:) (- ((ScriptID 700 7) y:) 12)) ; sp2
					(not (StepOn gEgo 8192))
				)
				(client setScript: sp2ShootEgo)
			)
			((StepOn gEgo 1)
				(client setScript: sp2ShootDown)
			)
			((StepOn gEgo 8192)
				(gCurRoom setScript: hideEgoInStore)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 700 7) ; sp2
					view: 7
					setLoop: 2
					setCel: 5
					show:
					setStep: 2 2
					setMotion: MoveTo 89 133 self
				)
			)
			(2
				((ScriptID 700 6) init: setScript: sp1Squeeze) ; sp1
				((ScriptID 700 7) ; sp2
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 134 122 self
				)
			)
			(3
				((ScriptID 700 7) view: 13 loop: 3 cel: 0 stopUpd:) ; sp2
				(self dispose:)
			)
		)
	)
)

(instance sp1Squeeze of rmnScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((gCurRoom script:))
			(
				(and
					(< ((ScriptID 700 6) x:) 310) ; sp1
					(not (& (gEgo onControl: 1) $2000))
				)
				(client setScript: sp1ShootEgo)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 6) ; sp1
					setStep: 2 2
					posn: 330 182
					view: 13
					setLoop: 1
					setCel: 0
					init:
					setMotion: MoveTo 199 112 self
				)
			)
			(1
				((ScriptID 700 6) ; sp1
					setStep: 3 2
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 159 116 self
				)
			)
			(2
				((ScriptID 700 6) view: 13 loop: 1 cel: 0 stopUpd:) ; sp1
				(= seconds 3)
			)
			(3
				(self save1: (proc0_12 {I am in pursuit of Wilco.} 67 175 80))
				(= seconds 5)
			)
			(4
				(self restore:)
				(self
					save1:
						(proc0_12
							{How did he get past me?}
							67
							25
							127
							28
							global132
						)
				)
				(= seconds 4)
			)
			(5
				(self restore:)
				(self
					save1:
						(proc0_12
							{** He is undoubtedly \nhiding in a store.}
							67
							175
							70
						)
				)
				(= seconds 4)
			)
			(6
				(self restore:)
				(self
					save1:
						(proc0_12
							{** We must search each one carefully.}
							67
							20
							127
							28
							global132
						)
				)
				(= seconds 5)
			)
			(7
				(self restore:)
				(self
					save1:
						(proc0_12
							{** I will begin by searching \nMonilith Burger.}
							67
							145
							38
						)
				)
				(= seconds 6)
			)
			(8
				(self restore:)
				(self
					save1:
						(proc0_12
							{** Good.__I will search in \nthe opposite direction.}
							67
							30
							130
							28
							global132
						)
				)
				(= seconds 6)
			)
			(9
				(self restore:)
				(self
					save1:
						(proc0_12
							{** Long May Vohaul \nRule Supreme!}
							67
							145
							38
						)
				)
				(= seconds 5)
			)
			(10
				(self restore:)
				(self
					save1: (proc0_12 {** Yeah... right.} 67 60 130 28 global132)
				)
				(= seconds 3)
			)
			(11
				(self restore:)
				((ScriptID 700 6) view: 7 setMotion: MoveTo 148 85 self) ; sp1
			)
			(12
				((ScriptID 700 6) ; sp1
					view: 13
					setLoop: 1
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 1 1
				)
				(= cycles 10)
			)
			(13
				((ScriptID 700 7) view: 7 setMotion: MoveTo 143 156 self) ; sp2
			)
			(14
				((ScriptID 700 7) ; sp2
					view: 13
					setLoop: 0
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 267 236 self
				)
			)
			(15
				(hideEgoInStore cue:)
				(self dispose:)
			)
		)
	)
)

(instance sp1ShootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 6) setLoop: 3 cel: 0 setCycle: End self) ; sp1
			)
			(1
				(= local18 (- (gEgo y:) 33))
				(= local19 (- ((ScriptID 700 6) y:) 34)) ; sp1
				(= local21 (gEgo x:))
				(= local20 (- ((ScriptID 700 6) x:) 8)) ; sp1
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local19
					local20
					local18
					local21
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(= cycles 1)
			)
			(2
				(blast
					init:
					cel: 0
					posn: local21 local18
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
			)
			(3
				(EgoDead 390 0)
			)
		)
	)
)

(instance sp2ShootDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 7) ; sp2
					view: 13
					setLoop: 4
					setCel: 0
					setPri: (gEgo priority:)
				)
				(= cycles 4)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self) ; sp2
			)
			(2
				(= local19 (- (gEgo y:) 33))
				(= local18 (- ((ScriptID 700 7) y:) 20)) ; sp2
				(= local20 (gEgo x:))
				(= local21 (+ ((ScriptID 700 7) x:) 11)) ; sp2
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local18
					local21
					local19
					local20
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) setCel: 0) ; sp2
				(blast
					init:
					cel: 0
					posn: local20 local19
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
			)
			(4
				(EgoDead 390 0)
			)
		)
	)
)

(instance sp2ShootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 700 7) view: 13 setLoop: 0 setCel: 0) ; sp2
				(= cycles 2)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self) ; sp2
			)
			(2
				(= local18 (- (gEgo y:) 33))
				(= local19 (- ((ScriptID 700 7) y:) 28)) ; sp2
				(= local20 (gEgo x:))
				(= local21 (+ ((ScriptID 700 7) x:) 16)) ; sp2
				(= local22
					(Graph
						grSAVE_BOX
						(- local18 1)
						(- local21 1)
						(+ local19 1)
						(+ local20 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local19
					local21
					local18
					local20
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
				((ScriptID 700 7) setCycle: End) ; sp2
				(= cycles 1)
			)
			(3
				(blast
					init:
					cel: 0
					posn: local20 local18
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
				(Graph grRESTORE_BOX local22)
				(Graph
					grREDRAW_BOX
					(- local18 1)
					(- local21 1)
					(+ local19 1)
					(+ local20 1)
				)
			)
			(4
				(EgoDead 390 0)
			)
		)
	)
)

(instance hideEgoInStore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 192 49 self)
			)
			(1
				(gEgo setPri: 1 setMotion: MoveTo 171 47)
			)
			(2
				(gEgo setMotion: MoveTo 192 49 self)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 199 86 self)
			)
			(4
				(= cycles 4)
			)
			(5
				(Print 390 1) ; "These guys mean bussiness, alright. But they sure aren't Harvard graduates."
				(HandsOn)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

(instance signSound of Sound
	(properties
		number 391
	)
)

