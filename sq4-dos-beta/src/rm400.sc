;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use BeltWay)
(use rmnScript)
(use SQRoom)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(local
	[local0 89] = [0 0 241 5 0 0 227 12 0 0 212 16 0 0 194 22 0 0 174 27 0 0 148 32 0 1 123 36 0 2 98 35 0 3 83 38 0 4 71 40 0 5 60 45 0 6 50 46 0 7 42 50 0 8 38 50 0 9 46 49 0 10 57 43 0 10 69 38 0 10 80 32 0 10 93 25 0 10 108 15 0 10 115 6 0 0 -100 -100 -32768]
	[local89 105] = [1 0 184 -6 1 0 179 4 1 0 172 16 1 0 160 24 1 1 149 29 1 1 141 36 1 2 133 43 1 2 129 50 1 3 125 59 1 4 128 66 1 4 139 70 1 4 152 72 1 5 161 73 1 6 176 74 1 6 191 73 1 7 203 71 1 7 216 65 1 7 228 58 1 7 239 53 1 7 250 47 1 7 262 40 1 7 275 32 1 7 288 23 1 7 302 13 1 7 314 7 0 0 -100 -100 -32768]
	[local194 77] = [4 0 26 7 4 0 30 17 4 0 31 26 4 0 33 34 4 1 39 38 4 1 47 39 4 2 55 40 4 3 64 41 4 4 71 41 4 5 78 40 4 6 85 38 4 0 92 36 4 1 97 32 4 2 104 29 4 2 113 25 4 2 121 18 4 2 129 10 4 2 136 4 0 0 -100 -100 -32768]
	local271
	local272
	local273
	local274
	local275
	local276
	local277
	local278
	local279
	local280
)

(instance rm400 of SQRoom
	(properties
		picture 400
		style 30
		east 395
		west 370
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 7 400 401)
		(Load rsFONT 68 69)
		(LoadMany rsSOUND 400 401 405)
		(switch gPrevRoomNum
			(west
				(gLongSong2 number: 0 stop:)
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= local277 -12)
					(= local278 93)
				else
					(= local277 -12)
					(= local278 151)
				)
				(gEgo
					x: local277
					y: local278
					setLoop: gStopGroop
					observeControl: 64
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue) ; enS
			)
			(east
				(gLongSong2 number: 0 stop:)
				(if (== ((ScriptID 700 0) whichBelt:) 1) ; mall
					(= local277 331)
					(= local278 93)
				else
					(= local277 331)
					(= local278 151)
				)
				(gEgo
					x: local277
					y: local278
					setLoop: gStopGroop
					observeControl: 64
				)
				(self setScript: (ScriptID 700 1) 0 egoBwCyan) ; enS
			)
			(else
				(gLongSong number: 405 loop: -1 vol: 20 play:)
				(self setScript: fromCarScript)
			)
		)
		(if (and (IsFlag 3) (not (gEgo has: 13))) ; cigar
			(cigar init:)
		)
		(if (and (TestMallFlag (ScriptID 700 0) #rFlag1 64) (not (gEgo has: 11))) ; mall, atmCard
			(card init: setCel: 6)
		)
		(super init:)
		(gEgo init: setPri: -1)
		(gFeatures
			add: escalator skateorama island1 island2
			eachElementDo: #init
			doit:
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 209 189 209 176 219 176 219 170 319 170 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 131 236 134 235 130 223 130 217 114 227 114 222 108 319 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 82 205 93 126 93 0 81 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 98 87 106 84 115 93 116 87 130 77 130 74 137 0 134
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 170 95 170 95 176 101 176 101 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 131 189 131 175 181 175 181 189
					yourself:
				)
		)
		((ScriptID 700 6) view: 7 loop: 3 cel: 0 x: 196 y: 248 init: stopUpd:) ; sp1
		(cond
			((or (IsFlag 24) (IsFlag 25))
				((ScriptID 700 6) setScript: plugEgo) ; sp1
			)
			((IsFlag 20)
				(SetFlag 25)
				(SetFlag 13)
				(if (== gPrevRoomNum 370)
					((ScriptID 700 6) setScript: twoSPright) ; sp1
				else
					((ScriptID 700 6) setScript: twoSPleft) ; sp1
				)
			)
		)
		(lator1 setScript: escScript init: setCycle: Fwd)
		(lator2 init: setCycle: Rev)
		(skater0 init: setScript: (Clone skaterScript))
		(skater1 init: setScript: (Clone skaterScript))
		(skater2 init: setScript: (Clone skaterScript))
		(skate1Snd init:)
		(skate2Snd init:)
		(skate3Snd init:)
		(escSnd init:)
		(self setRegions: 700) ; mall
	)

	(method (doit)
		(cond
			(script 0)
			((and (not ((ScriptID 700 7) script:)) (== (gEgo edgeHit:) 2)) ; sp2
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwRed) ; mall
				(self setScript: (ScriptID 700 2) 0 east) ; exS
			)
			((and (not ((ScriptID 700 7) script:)) (== (gEgo edgeHit:) 4)) ; sp2
				(HandsOff)
				((ScriptID 700 0) enterBelt: egoBwGreen) ; mall
				(self setScript: (ScriptID 700 2) 0 west) ; exS
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
			((StepOn gEgo 8)
				(egoBwCyan who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1) ; mall
				(proc700_5 0)
			)
			((StepOn gEgo 16)
				(egoBwRed who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2) ; mall
				(proc700_5 0)
			)
			(
				(or
					(egoBwGreen onCon:)
					(egoBwBlue onCon:)
					(egoBwCyan onCon:)
					(egoBwRed onCon:)
				)
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(egoBwCyan onCon: 0)
				(egoBwRed onCon: 0)
				(gEgo setStep: 3 2 setPri: -1)
				(proc700_5 1)
			)
			((StepOn gEgo 32)
				(HandsOff)
				(self setScript: downLatorScript)
			)
			((StepOn gEgo 64)
				(HandsOff)
				(self setScript: joyRiding)
			)
		)
		(if (not ((ScriptID 700 7) script:)) ; sp2
			(super doit:)
		)
	)

	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff -1
		xTweak 2
		key 90
		head 277
		xDir -1
		yDir 1
	)
)

(instance egoBwCyan of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff 1
		xTweak 2
		key 90
		head 262
		xDir -1
		yDir 1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff -1
		xTweak 2
		key 270
		head 96
		xDir 1
		yDir -1
	)
)

(instance egoBwRed of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff 1
		xTweak 2
		key 270
		head 86
		xDir 1
		yDir -1
	)
)

(instance skater0 of Prop
	(properties
		x -100
		y -100
		view 400
		priority 2
		signal 24592
	)
)

(instance skater1 of Prop
	(properties
		x -100
		y -100
		view 400
		loop 1
		priority 2
		signal 24592
	)
)

(instance skater2 of Prop
	(properties
		x -100
		y -100
		view 400
		loop 2
		priority 2
		signal 24592
	)
)

(instance lator1 of Prop
	(properties
		x 116
		y 189
		view 401
		priority 4
		signal 16400
	)
)

(instance escScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
		)
	)

	(method (doit)
		(if (not (lator1 cel:))
			(escSnd play:)
		)
		(super doit:)
	)
)

(instance escSnd of Sound
	(properties
		number 400
		priority 14
	)
)

(instance lator2 of Prop
	(properties
		x 196
		y 189
		view 401
		priority 4
		signal 16400
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

(instance cigar of View
	(properties
		x 220
		y 114
		description {cigar}
		lookStr {It's a cigar butt.}
		view 401
		loop 5
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(proc700_5 1)
				(gCurRoom setScript: getSomethingScript 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance card of Prop
	(properties
		x 167
		y 151
		description {ATM Card}
		sightAngle 90
		lookStr {It's an AutoBucks Teller Machine card.}
		view 401
		loop 4
		priority 1
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self doit:)
	)

	(method (doit)
		(super doit:)
		(if (!= (self cel:) 6)
			(self setPri: -1 x: (+ (self x:) 2))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(proc700_5 1)
				(gCurRoom setScript: getSomethingScript 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getSomethingScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(Face gEgo register)
				(= temp0
					(-
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(register x:)
							(register y:)
						)
						10
					)
				)
				(= temp1 (+ (gEgo x:) (SinMult (gEgo heading:) temp0)))
				(= temp2 (- (gEgo y:) (CosMult (gEgo heading:) temp0)))
				(gEgo setMotion: PolyPath temp1 temp2 self)
			)
			(1
				(switch register
					(card
						(Print 400 0) ; "You pick up the ATM Card."
						(gEgo get: 11) ; atmCard
					)
					(cigar
						(Print 400 1) ; "You retrieve the cigar butt."
						(gEgo get: 13) ; cigar
					)
				)
				(HandsOn)
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance joyRiding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local280 ((gEgo cycler:) vStopped:))
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 3) self)
			)
			(1
				(gEgo setHeading: 180 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(gEgo
					setHeading: 90
					setCycle: StopWalk local280
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(3
				(Print 400 2) ; "** wasn't much fun was it."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance babe1 of Actor
	(properties
		x 195
		y 248
		view 401
		loop 1
		signal 30720
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x:) 158)
	)
)

(instance babe2 of Actor
	(properties
		x 186
		y 255
		view 401
		loop 1
		cel 1
		signal 30720
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x:) 166)
	)
)

(instance babe3 of Actor
	(properties
		x 204
		y 255
		view 401
		loop 1
		cel 2
		signal 30720
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x:) 167)
	)
)

(instance fromCarScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gLongSong fade: 127 10 5 0)
				(NormalEgo 0 402)
				(AnimateEgoHead 14)
				(gEgo x: -100 y: -100)
				(= cycles 10)
			)
			(2
				(babe1 init:)
				(babe2 init:)
				(babe3 init:)
				(gEgo
					setCycle: 0
					posn: 196 262
					setMotion: MoveTo 196 172 self
				)
			)
			(3
				(NormalEgo 3 402)
				(gEgo observeControl: 64 setCycle: StopWalk 14)
				(proc700_5 1)
				(= cycles 3)
			)
			(4
				(self save1: (proc0_12 {"SALE!!"} 67 -1 103 30 1))
				(babe1 setLoop: 2 setCycle: End)
				(= seconds 4)
			)
			(5
				(self restore:)
				(= cycles 1)
			)
			(6
				(babe1
					setLoop: 3
					setCel: -1
					setStep: 5 3
					setCycle: Walk
					setMotion: PolyPath 80 109 self
				)
				(babe2 dispose:)
				(babe3 dispose:)
				(= cycles 3)
			)
			(7
				(card init: setCycle: End x: (- (babe1 x:) 23) y: (babe1 y:))
				(mall rFlag1: (| (mall rFlag1:) $0040))
			)
			(8
				(card setPri: 1)
				(babe1 setStep: 7 3 setMotion: MoveTo -40 111 self)
			)
			(9
				(babe1 dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance plugEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 6) posn: 160 (gEgo y:) loop: 2 cel: 2) ; sp1
				(= cycles 10)
			)
			(1
				(= register (< (gEgo x:) ((ScriptID 700 6) x:))) ; sp1
				((ScriptID 700 6) ; sp1
					view: 13
					loop: (if register 1 else 0)
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(2
				(HandsOff)
				(gEgo setMotion: 0)
				(= local278 (- ((ScriptID 700 6) y:) 28)) ; sp1
				(= local277 (if register 144 else 176))
				(= local276 (- (gEgo y:) 31))
				(if (< (= local275 (gEgo x:)) local277)
					(= local273 local275)
					(= local274 local277)
				else
					(= local273 local277)
					(= local274 local275)
				)
				(if (< local276 local278)
					(= local271 local276)
					(= local272 local278)
				else
					(= local271 local278)
					(= local272 local276)
				)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local278
					local277
					local276
					local275
					global133
					(- (gEgo priority:) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local279)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(blast
					init:
					posn: local275 local276
					cel: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
				((ScriptID 700 6) cel: 0) ; sp1
			)
			(4
				(EgoDead 400 3)
			)
		)
	)
)

(instance twoSPright of rmnScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not state) (> (gEgo x:) 90))
				(self cue:)
			)
			((> (gEgo x:) 118)
				(= cycles 0)
				(self changeState: 10)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7) posn: 229 163 loop: 2 cel: 2 init: stopUpd:) ; sp2
				((ScriptID 700 6) ; sp1
					posn: 213 106
					view: 13
					loop: 0
					cel: 0
					stopUpd:
				)
			)
			(1
				((ScriptID 700 7) loop: 1 forceUpd:) ; sp2
				((ScriptID 700 6) loop: 3 forceUpd:) ; sp1
				(= cycles 6)
			)
			(2
				(self
					save1:
						(proc0_12
							{HALT, WILCO!}
							67
							-1
							100
							28
							global130
							29
							global139
							30
							1
						)
				)
				((ScriptID 700 6) loop: 1 forceUpd:) ; sp1
				((ScriptID 700 7) setScript: uStayIGo) ; sp2
				(= seconds 2)
			)
			(3
				(self restore:)
				(= cycles 5)
			)
			(4
				((ScriptID 700 6) setCycle: CT 1 1 self) ; sp1
			)
			(5
				(= local271 74)
				(= local272 95)
				(= local273 4)
				(= local274 186)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(Graph grDRAW_LINE local271 local274 local272 local273 global133 3 -1)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(6
				((ScriptID 700 6) setCycle: End) ; sp1
				(blast init: posn: 4 95 setCycle: End)
				(Graph grRESTORE_BOX local279)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= local279 0)
				(= cycles 18)
			)
			(7
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self) ; sp1
			)
			(8
				(= local271 74)
				(= local272 78)
				(= local273 74)
				(= local274 186)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(Graph grDRAW_LINE local272 local274 local271 local273 global133 3 -1)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(9
				((ScriptID 700 6) setCycle: End) ; sp1
				(blast posn: 73 74 setPri: 6 setCycle: End)
				(Graph grRESTORE_BOX local279)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= local279 0)
				(= cycles 15)
			)
			(10
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self) ; sp1
			)
			(11
				(HandsOff)
				(gEgo setMotion: 0)
				(= local271 (Min (- (gEgo y:) 31) 75))
				(= local272 (Max (- (gEgo y:) 31) 75))
				(= local273 (gEgo x:))
				(= local274 186)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(if (== local271 75)
					(Graph
						grDRAW_LINE
						local271
						local274
						local272
						local273
						global133
						(- (gEgo priority:) 1)
						-1
					)
				else
					(Graph
						grDRAW_LINE
						local272
						local274
						local271
						local273
						global133
						(- (gEgo priority:) 1)
						-1
					)
				)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(12
				(EgoDead 400 3)
			)
		)
	)
)

(instance twoSPleft of rmnScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (not state) (< (gEgo x:) 228))
				(self cue:)
			)
			((< (gEgo x:) 202)
				(= cycles 0)
				(self changeState: 10)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7) posn: 84 161 loop: 2 cel: 2 init: stopUpd:) ; sp2
				((ScriptID 700 6) ; sp1
					posn: 102 141
					view: 13
					loop: 1
					cel: 0
					stopUpd:
				)
			)
			(1
				((ScriptID 700 7) loop: 0 forceUpd:) ; sp2
				((ScriptID 700 6) loop: 3 forceUpd:) ; sp1
				(= cycles 4)
			)
			(2
				((ScriptID 700 7) stopUpd:) ; sp2
				((ScriptID 700 6) loop: 0 forceUpd:) ; sp1
				(self
					save1:
						(proc0_12
							{HALT, WILCO!}
							67
							-1
							100
							28
							global130
							29
							global139
							30
							1
						)
				)
				((ScriptID 700 7) setScript: uStayIGo) ; sp2
				(= seconds 2)
			)
			(3
				(self restore:)
				(= cycles 8)
			)
			(4
				((ScriptID 700 6) setCycle: CT 1 1 self) ; sp1
			)
			(5
				(= local271 109)
				(= local272 111)
				(= local273 124)
				(= local274 254)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(Graph grDRAW_LINE local272 local273 local271 local274 global133 3 -1)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(6
				((ScriptID 700 6) setCycle: End) ; sp1
				(blast init: posn: 254 109 setPri: 7 setCycle: End)
				(Graph grRESTORE_BOX local279)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= local279 0)
				(= cycles 24)
			)
			(7
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self) ; sp1
			)
			(8
				(= local271 107)
				(= local272 111)
				(= local273 124)
				(= local274 279)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(Graph grDRAW_LINE local272 local273 local271 local274 global133 3 -1)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(9
				((ScriptID 700 6) setCycle: End) ; sp1
				(blast posn: 279 107 setPri: 6 setCycle: End self)
				(Graph grRESTORE_BOX local279)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= local279 0)
				(= cycles 16)
			)
			(10
				((ScriptID 700 6) ; sp1
					loop: (if (> (gEgo x:) 161) 0 else 3)
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(11
				(HandsOff)
				(gEgo setMotion: 0)
				(= local271 (Min (- (gEgo y:) 31) 108))
				(= local272 (Max (- (gEgo y:) 31) 108))
				(= local274 (gEgo x:))
				(= local273 119)
				(= local279
					(Graph
						grSAVE_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
						1
					)
				)
				(if (== local271 108)
					(Graph
						grDRAW_LINE
						local271
						local273
						local272
						local274
						global133
						(- (gEgo priority:) 1)
						-1
					)
				else
					(Graph
						grDRAW_LINE
						local272
						local273
						local271
						local274
						global133
						(- (gEgo priority:) 1)
						-1
					)
				)
				(Graph
					grREDRAW_BOX
					(- local271 1)
					(- local273 1)
					(+ local272 1)
					(+ local274 1)
				)
				(= cycles 1)
			)
			(12
				(EgoDead 400 3)
			)
		)
	)
)

(instance uStayIGo of rmnScript
	(properties)

	(method (doit)
		(if (and (not state) (gEgo edgeHit:))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local279
					(Graph grRESTORE_BOX local279)
					(Graph
						grREDRAW_BOX
						(- local271 1)
						(- local273 1)
						(+ local272 1)
						(+ local274 1)
					)
				)
				((ScriptID 700 6) cel: 0) ; sp1
			)
			(1
				(HandsOff)
				(gEgo hide:)
				((ScriptID 700 6) view: 7 loop: 2 cel: 2 setScript: 0) ; sp1
				((ScriptID 700 7) forceUpd: loop: 3) ; sp2
				(= seconds 3)
			)
			(2
				(self
					save1:
						(proc0_12
							{I shall pursue the Wilco unit.\n   Stay and guard the area.}
							67
							-1
							40
							28
							global130
							29
							global139
							30
							1
						)
				)
				(= seconds 6)
			)
			(3
				(self restore:)
				(= cycles 2)
			)
			(4
				(self save1: (proc0_12 {Affirmative.} 67 -1 123 30 1))
				(= seconds 4)
			)
			(5
				(self restore:)
				((ScriptID 700 6) ; sp1
					setCycle: Walk
					setMotion: MoveTo 160 ((ScriptID 700 6) y:) self ; sp1
				)
			)
			(6
				(gCurRoom setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance downLatorScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(gEgo
					setCycle: 0
					setMotion: MoveTo (gEgo x:) (+ 189 temp0) self
				)
			)
			(1
				(Print 400 4 #dispose) ; "** roger will be coming up escalator with his hands up followed by sequel police."
				(= cycles 30)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo
					setLoop: 2
					posn: 196 248
					ignoreControl: 64
					setMotion: MoveTo 196 177 self
				)
			)
			(3
				((ScriptID 700 6) ; sp1
					illegalBits: 0
					setCycle: 0
					setLoop: 3
					setMotion: MoveTo 196 172 self
				)
				(gEgo setCycle: Rev setMotion: MoveTo 196 155 self)
			)
			(4
				(gEgo setCycle: 0)
				0
			)
			(5
				(EgoDead 400 5)
			)
		)
	)
)

(instance skaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(switch client
					(skater0
						(skate1Snd play:)
						(client setCycle: MCyc @local0 self)
					)
					(skater1
						(skate2Snd play:)
						(client setCycle: MCyc @local89 self)
					)
					(skater2
						(skate3Snd play:)
						(client setCycle: MCyc @local194 self)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance skate1Snd of Sound
	(properties
		number 401
		vol 40
	)
)

(instance skate2Snd of Sound
	(properties
		number 401
		vol 40
	)
)

(instance skate3Snd of Sound
	(properties
		number 401
		vol 40
	)
)

(instance escalator of Feature
	(properties
		x 156
		y 189
		z 12
		nsTop 166
		nsLeft 86
		nsBottom 189
		nsRight 226
		description {escalator1}
		sightAngle 90
		lookStr {** escalator}
	)
)

(instance skateorama of Feature
	(properties
		x 159
		y 64
		z 24
		nsTop -1
		nsBottom 82
		nsRight 319
		description {skate-o-rama}
		sightAngle 90
		lookStr {** skate-o-rama.}
	)
)

(instance island1 of Feature
	(properties
		x 41
		y 123
		z 10
		nsTop 96
		nsBottom 130
		nsRight 82
		description {island1}
		sightAngle 90
		lookStr {** escalator island.}
	)
)

(instance island2 of Feature
	(properties
		x 278
		y 112
		nsTop 95
		nsLeft 238
		nsBottom 130
		nsRight 319
		description {island2}
		sightAngle 90
		lookStr {** escalator island.}
	)
)

