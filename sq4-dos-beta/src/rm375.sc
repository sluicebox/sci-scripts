;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Polygon)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(public
	rm375 0
)

(local
	[local0 10] = [0 0 206 0 183 28 85 76 0 82]
	local10 = 65
)

(instance rm375 of SQRoom
	(properties
		picture 375
		style 30
		east 380
		south 370
		west 370
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(gLongSong2 number: 19 loop: -1 playBed:)
		(switch gPrevRoomNum
			(west
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 49)
					(= temp1 237)
				else
					(= temp0 -16)
					(= temp1 181)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen) ; enS
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= temp0 333)
					(= temp1 78)
				else
					(= temp0 327)
					(= temp1 -8)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 127 play:)
				(self setScript: fromStoreScript 0 (> (gEgo x:) 160))
			)
		)
		(light1 init: setCycle: Fwd)
		(light2 init: setCycle: Fwd)
		(if (IsFlag 9)
			(door init: priority: 1 signal: (| (door signal:) $4010))
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 297 0 224 39 213 39 191 32 139 59 148 76 129 86 111 71 39 108 47 117 47 126 0 149 0 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 149 0 68 47 117 47 125 44 128
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 298 0 224 39 216 39 208 38 106 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 123 28 150 74 118 91 84 49
						yourself:
					)
			)
		)
		(signPoly points: @local0 size: 5)
		(super init:)
		(gEgo init: setPri: -1)
		(self
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 319 121 319 189 185 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 29 319 66 219 115 185 95
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 185 136 119 169 141 72 189
					yourself:
				)
		)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local10 0)) 0)
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
			((or (== (gEgo edgeHit:) EDGE_LEFT) (== (gEgo edgeHit:) EDGE_BOTTOM))
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwBlue) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
			)
			((StepOn gEgo 8)
				(gCurRoom newRoom: 376)
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
				(gEgo
					x: (if register 149 else 70)
					y: (if register 43 else 82)
					setHeading: 135
					setMotion: MoveFwd 20 self
				)
			)
			(1
				(proc700_5 1)
				(HandsOn)
				(self dispose:)
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
		xOff 1
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
		x 21
		y 82
		view 375
		loop 2
	)
)

(instance light1 of Prop
	(properties
		x 30
		y 110
		description {sign}
		lookStr {"Buckazoid Bill's Arcade and Sushi Bar."}
		view 375
		signal 16384
	)

	(method (init)
		(super init:)
		(self onMeCheck: signPoly)
	)
)

(instance signPoly of Polygon
	(properties)
)

(instance light2 of Prop
	(properties
		x 214
		y 20
		view 375
		loop 1
		signal 16384
	)
)

