;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use mall)
(use MoveToY)
(use Inertia)
(use SQRoom)
(use n940)
(use MCyc)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	[local0 145] = [1 0 117 -4 1 0 107 9 1 0 99 20 1 0 91 29 1 0 86 39 1 1 79 47 1 2 71 54 1 2 66 63 1 3 62 72 1 4 63 78 1 4 70 84 1 5 75 87 1 5 84 91 1 5 93 95 1 6 105 97 1 7 117 98 1 7 129 98 1 7 143 95 1 8 157 91 1 8 166 82 1 8 168 73 1 9 167 67 1 10 161 62 1 10 151 59 1 11 143 56 1 11 132 55 1 12 120 53 1 12 108 51 1 12 96 48 1 12 87 44 1 12 76 39 1 12 65 34 1 12 43 23 1 12 32 15 1 12 23 0 0 0 -100 -100 -32768]
	[local145 129] = [2 0 169 -3 2 0 169 9 2 0 170 21 2 0 170 33 2 0 172 45 2 0 173 56 2 0 175 67 2 0 177 78 2 1 179 86 2 1 182 93 2 2 185 100 2 3 190 106 2 4 196 111 2 5 201 113 2 6 206 117 2 7 210 123 2 8 220 129 2 9 228 127 2 10 237 125 2 11 243 121 2 12 249 119 2 13 256 116 2 14 263 108 2 14 267 94 2 14 270 80 2 14 271 65 2 14 271 48 2 14 273 32 2 14 274 14 2 14 277 0 2 14 280 -14 0 0 -100 -100 -32768]
	local274
	local275
	local276
	local277
	local278
	local279
	local280
	local281
	local282
	local283
	local284
	local285
)

(instance rm410 of SQRoom
	(properties
		picture 410
		north 411
		east 390
		west 405
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 400)
		(switch gPrevRoomNum
			(north
				(self setScript: enterScript 0 north style: 30)
			)
			(west
				(self setScript: enterScript 0 west style: 41)
			)
			(else
				(gLongSong number: 406 loop: -1 playBed:)
				(gLongSong2 number: 0 stop:)
				(self setScript: enterScript 0 east style: 30)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 167 319 189 259 189 302 165
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 111 304 111 304 116 289 116 289 121 274 121 274 125 250 125 250 0 319 0
					yourself:
				)
		)
		(gEgo init:)
		(super init:)
		(skater1 init: setScript: (Clone skaterScript))
		(skater2 init: setScript: (Clone skaterScript))
		(cond
			((IsFlag 21)
				((ScriptID 700 6) init: hide: setScript: swimAfterEgo) ; sp1
			)
			((not (IsFlag 20)))
			((== gPrevRoomNum 390)
				((ScriptID 700 7) init: hide: setScript: enterAndShootEgo) ; sp2
			)
			(else
				((ScriptID 700 7) init: setScript: shootEgo) ; sp2
			)
		)
		(self setRegions: 700) ; mall
	)

	(method (doit)
		(cond
			(script 0)
			((StepOn gEgo 2)
				(HandsOff)
				(if (OneOf (gEgo view:) 406 398)
					(self setScript: endSwimScript)
				else
					(self setScript: startSwimScript)
				)
			)
			((StepOn gEgo 4)
				(HandsOff)
				(self setScript: landScript)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitScript 0 north)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(HandsOff)
				(self setScript: exitScript 0 west)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber west) (!= newRoomNumber north))
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					((gCurRoom east:)
						(gEgo x: 331 y: 124 setMotion: MoveTo 297 142 self)
					)
					((gCurRoom north:)
						(= temp0
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						((ScriptID 700 4) init: gEgo) ; eSwimCode
						(gEgo
							setCycle: Swim
							setHeading: 180
							x:
								(if (> (gEgo x:) 240)
									240
								else
									(gEgo x:)
								)
							y: (- (gCurRoom horizon:) temp0)
						)
						(Animate (gCast elements:) 0)
						(gEgo setMotion: MoveTo (gEgo x:) 10 self)
					)
					((gCurRoom west:)
						(= temp0
							(CelWide
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						((ScriptID 700 4) ; eSwimCode
							init: gEgo
							inertizing: 1
							inertia: 5
							oldDir: 90
							xOff: 1
						)
						(gEgo
							normal: 0
							setHeading: 90
							setCycle: Swim
							x: (+ 0 (/ temp0 2) 1)
							y: (gEgo y:)
						)
						(= cycles 1)
					)
				)
			)
			(1
				(switch register
					((gCurRoom east:)
						(if (== (gEgo view:) 402)
							(NormalEgo 1 402 14)
						else
							(NormalEgo 1 0 4)
						)
						(proc700_5 1)
					)
					(else
						(proc700_5 0)
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 700 4) dispose:) ; eSwimCode
				(if (== register (gCurRoom north:))
					(= temp0 0)
				else
					(= temp0 270)
				)
				(gEgo setHeading: temp0 self)
			)
			(1
				(switch register
					((gCurRoom north:)
						(gEgo setMotion: MoveToY -30 self)
					)
					((gCurRoom west:)
						(gEgo setMotion: MoveToX -30 self)
					)
				)
			)
			(2
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance startSwimScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 402)
					(= temp1 3)
				else
					(= temp1 1)
				)
				(gEgo
					normal: 0
					view: 403
					setLoop: temp1
					cycleSpeed: 3
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if (== (gEgo loop:) 1)
					(= temp0 406)
				else
					(= temp0 398)
				)
				((ScriptID 700 4) init: gEgo) ; eSwimCode
				(gEgo
					normal: 0
					loop: 1
					setLoop: -1
					view: temp0
					posn: (- (gEgo x:) 40) (- (gEgo y:) 6) 0
					setStep: 3 2
					setCycle: Swim
					cycleSpeed: 0
					setHeading: 270
					setMotion: MoveFwd 20 self
				)
			)
			(2
				(proc700_5 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance endSwimScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 406)
					(= temp1 0)
				else
					(= temp1 2)
				)
				(gEgo
					view: 403
					setLoop: temp1
					cel: 1
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 6)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 3)
			)
			(1
				(gEgo cel: 0 posn: (+ (gEgo x:) 20) (gEgo y:))
				(= cycles 3)
			)
			(2
				(if (== (gEgo loop:) 0)
					(= temp0 0)
					(= temp2 4)
				else
					(= temp0 402)
					(= temp2 14)
				)
				(NormalEgo 0 temp0 temp2)
				(proc700_5 1)
				(gEgo
					posn: (+ (gEgo x:) 13) (+ (gEgo y:) 3)
					setMotion: PolyPath 298 135 self
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance landScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 406)
					(= temp1 0)
				else
					(= temp1 2)
				)
				(gEgo
					view: 403
					setLoop: temp1
					cel: 1
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 6)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 2)
			)
			(1
				(gEgo cel: 0 posn: (+ (gEgo x:) 20) (gEgo y:))
				(= cycles 2)
			)
			(2
				(if (== (gEgo loop:) 0)
					(= temp0 0)
				else
					(= temp0 402)
				)
				(NormalEgo 0 temp0)
				(gEgo
					setLoop: 0
					setStep: 6 4
					setCycle: 0
					setMotion: MoveTo 298 135 self
				)
			)
			(3
				(if (== (gEgo view:) 0)
					(= temp2 4)
				else
					(= temp2 14)
				)
				(NormalEgo 0 (gEgo view:) temp2)
				(HandsOn)
				(self dispose:)
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
					(skater1
						(client setCycle: MCyc @local0 self)
					)
					(skater2
						(client setCycle: MCyc @local145 self)
					)
				)
			)
			(2
				(self init:)
			)
		)
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

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(OneOf (gEgo view:) 323 398)
				(self onMe: gEgo)
			)
			(gCurRoom setScript: spinEgo self)
		)
		(super doit: &rest)
	)
)

(instance skater2 of Actor
	(properties
		x -100
		y -100
		view 400
		loop 2
		priority 2
		signal 24592
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(OneOf (gEgo view:) 323 398)
				(self onMe: gEgo)
			)
			(gCurRoom setScript: spinEgo self)
		)
		(if (> x 204)
			(self setPri: 9)
		else
			(self setPri: 2)
		)
		(super doit: &rest)
	)
)

(instance spinEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (StepOn gEgo 4) (StepOn gEgo 2))
			(gEgo setMotion: 0)
			((ScriptID 700 4) inertia: 0) ; eSwimCode
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (if (> (caller x:) (gEgo x:)) 1 else -1))
				(= caller 0)
				(gEgo
					view:
						(switch (gEgo view:)
							(406 407)
							(398 411)
							(else 407)
						)
					loop: 0
					cel:
						(switch (gEgo loop:)
							(0 0)
							(1 2)
							(2 1)
							(3 4)
							(4 0)
							(5 2)
							(6 5)
							(7 3)
						)
					cycleSpeed: 0
					setCycle: CT (gEgo cel:) register self
				)
			)
			(1
				(gEgo
					setCycle: CT (gEgo cel:) register self
					cycleSpeed: 1
				)
			)
			(2
				(gEgo
					setCycle: CT (gEgo cel:) register self
					cycleSpeed: 2
				)
			)
			(3
				(gEgo
					view:
						(switch (gEgo view:)
							(407 406)
							(411 398)
						)
					loop:
						(switch (gEgo cel:)
							(0 0)
							(2 1)
							(1 2)
							(4 3)
							(0 4)
							(2 5)
							(5 6)
							(3 7)
						)
					cycleSpeed: 0
					setCycle: Swim
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterAndShootEgo of Script
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:))
			((and (>= (gEgo x:) 298) (OneOf state 0 3 6))
				(self changeState: 7)
			)
			((and (OneOf (gEgo view:) 406 407) (OneOf state 0 3 6))
				(self changeState: 9)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(= local276 259)
				(= local278 319)
				(= local277 125)
				(= local279 110)
				(= local275
					(Graph
						grSAVE_BOX
						(- 110 1)
						(- local276 1)
						(+ local277 1)
						(+ local278 1)
						1
					)
				)
				(Graph grDRAW_LINE local277 local278 local279 local276 global133 1 -1)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local276 1)
					(+ local277 1)
					(+ local278 1)
				)
				(= cycles 1)
			)
			(2
				(blast init: posn: local276 local279 setCycle: End)
				(Graph grRESTORE_BOX local275)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local276 1)
					(+ local277 1)
					(+ local278 1)
				)
				(= cycles 1)
			)
			(3
				(= cycles 16)
			)
			(4
				(= local276 273)
				(= local277 137)
				(= local278 319)
				(= local279 110)
				(= local275
					(Graph
						grSAVE_BOX
						(- 110 1)
						(- local276 1)
						(+ local277 1)
						(+ local278 1)
						1
					)
				)
				(Graph grDRAW_LINE local277 local278 local279 local276 global133 1 -1)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local276 1)
					(+ local277 1)
					(+ local278 1)
				)
				(= cycles 1)
			)
			(5
				(blast cel: 0 posn: local276 local279 setCycle: End)
				(Graph grRESTORE_BOX local275)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local276 1)
					(+ local277 1)
					(+ local278 1)
				)
				(= cycles 1)
			)
			(6
				(= cycles 14)
			)
			(7
				(if (OneOf (gEgo view:) 406 407 403)
					(self changeState: (+ state 2))
				else
					(HandsOff)
					(gEgo setMotion: 0)
					(= local278 319)
					(= local279 100)
					(= local276 (+ (gEgo x:) 3))
					(= local277 (- (gEgo y:) 30))
					(Graph grDRAW_LINE local277 local276 local279 local278 global133 1 -1)
					(Graph
						grREDRAW_BOX
						(- local279 1)
						(- local276 1)
						(+ local277 1)
						(+ local278 1)
					)
					(= cycles 4)
				)
			)
			(8
				(EgoDead 410 0) ; "** Gee, Zero IQ, zero G might be for you."
			)
			(9
				(= cycles 20)
			)
			(10
				((ScriptID 700 7) ; sp2
					show:
					setLoop: -1
					setCel: -1
					view: 7
					setCycle: Walk
					posn: 326 118
					setMotion: MoveTo 299 127 self
				)
			)
			(11
				(client setScript: shootEgo)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not state)
				(> (gEgo x:) 154)
				(> (gEgo y:) 6)
				(< local274 8)
			)
			(= local274 8)
			(gEgo setMotion: 0)
			((ScriptID 700 4) inertia: 0) ; eSwimCode
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register (<= (gEgo y:) 111))
				((ScriptID 700 7) ; sp2
					view: 13
					setMotion: 0
					loop: (if register 1 else 5)
					cel: 0
					posn: 299 127
					init:
				)
				(= seconds 3)
			)
			(1
				(= register (<= (gEgo y:) 111))
				((ScriptID 700 7) ; sp2
					loop: (if register 1 else 5)
					cel: 0
					cycleSpeed: 1
					setCycle: CT 1 1 self
				)
			)
			(2
				(++ local274)
				(if register
					(= local280 283)
					(= local281 (if (<= 95 (gEgo y:) 111) 102 else 98))
					(= local282 (Max (+ (gEgo x:) 6) 1))
					(= local283 (Max (- (gEgo y:) 12) 1))
				else
					(= local280 292)
					(= local281 105)
					(= local282 (Max (+ (gEgo x:) 6) 1))
					(= local283 (Min (- (gEgo y:) 10) 189))
				)
				(cond
					((>= local274 8)
						(= local284 local282)
						(= local285 local283)
					)
					(
						(= temp0
							(/
								(* (- local283 local281) 100)
								(- local282 local280)
							)
						)
						(if (< temp0 0)
							(= local285 189)
						else
							(= local285 1)
						)
						(= local284
							(+ (/ (* (- local285 local281) 100) temp0) local280)
						)
					)
					(else
						(= local284 0)
						(= local285 local281)
					)
				)
				(if (and (< local284 0) temp0)
					(= local284 0)
					(= local285
						(Max
							(+ (/ (* temp0 (- 0 local280)) 100) local281)
						)
					)
				)
				(if (< local285 local281)
					(= local279 local285)
					(= local277 local281)
				else
					(= local279 local281)
					(= local277 local285)
				)
				(= local275
					(Graph
						grSAVE_BOX
						(- local279 1)
						(- local284 1)
						(+ local277 1)
						(+ local280 1)
						1
					)
				)
				(Graph grDRAW_LINE local281 local280 local285 local284 global133 0 -1)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local284 1)
					(+ local277 1)
					(+ local280 1)
				)
				((ScriptID 700 7) setCycle: End self) ; sp2
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) cel: 0 stopUpd:) ; sp2
				(Graph grRESTORE_BOX local275)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local284 1)
					(+ local277 1)
					(+ local280 1)
				)
				(if (>= local274 8)
					(blast init: cel: 0 posn: local282 local283 setCycle: End)
					(gEgo
						view: 409
						setLoop: 4
						cel: 0
						setCycle: End self
						setMotion: 0
					)
				else
					(= state 0)
					(= cycles (Random 16 24))
				)
			)
			(4
				(PrintD
					{SQ QUIZ QUESTION #1052\nWhen being shot at by crazed Sequal Police Cyborgs, a space hero should:}
					101
					101
					81
					{A>}
					0
					{Wait patiently until they get lucky?}
					101
					81
					{B>}
					1
					{Make a list of favorite campfire songs?}
					101
					81
					{C>}
					2
					{Play with a pink bunny rabbit?}
					101
					81
					{D>}
					3
					{RUN LIKE HECK!!!}
				)
				(EgoDead 410 1) ; "Well... maybe. It's worth a try."
			)
		)
	)
)

(instance swimAfterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 12)
			)
			(1
				(if
					(and
						(not (gCurRoom script:))
						(> 295 (gEgo x:) 60)
						(> (gEgo y:) 70)
					)
					(= cycles 1)
				else
					(-- state)
					(= cycles 10)
				)
			)
			(2
				(HandsOff)
				(gEgo setMotion: 0)
				((ScriptID 700 4) inertia: 0) ; eSwimCode
				((ScriptID 700 6) ; sp1
					show:
					view: 408
					setLoop: 0
					cel: 0
					setCycle: End
					setStep: 2 2
					posn: -38 (- (gEgo y:) 24)
					setMotion: MoveTo 10 (- (gEgo y:) 10) self
				)
			)
			(3
				((ScriptID 700 6) ; sp1
					view: 409
					setLoop: 0
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(4
				(= local281 (- ((ScriptID 700 6) y:) 4)) ; sp1
				(= local280 (+ ((ScriptID 700 6) x:) 57)) ; sp1
				(= local283 (- (gEgo y:) 10))
				(= local282 (gEgo x:))
				(if (< local283 local281)
					(= local279 local283)
					(= local277 local281)
				else
					(= local279 local281)
					(= local277 local283)
				)
				(= local275
					(Graph
						grSAVE_BOX
						(- local279 1)
						(- local280 1)
						(+ local277 1)
						(+ local282 1)
						1
					)
				)
				(Graph grDRAW_LINE local281 local280 local283 local282 global133 1 -1)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local280 1)
					(+ local277 1)
					(+ local282 1)
					1
				)
				(= cycles 1)
			)
			(5
				(Graph grRESTORE_BOX local275)
				(Graph
					grREDRAW_BOX
					(- local279 1)
					(- local280 1)
					(+ local277 1)
					(+ local282 1)
					1
				)
				(blast init: cel: 0 posn: local282 local277 setCycle: End)
				((ScriptID 700 6) cel: 0) ; sp1
				(gEgo
					view: 409
					setLoop: 5
					cel: 0
					setCycle: End self
					setMotion: 0
				)
			)
			(6
				(PrintD
					{SQ QUIZ QUESTION #1052\nWhen being shot at by crazed Sequal Police Androids, a space hero should:}
					101
					101
					81
					{A>}
					0
					{Wait patiently until they get lucky?}
					101
					81
					{B>}
					1
					{Make a list of favorite campfire songs?}
					101
					81
					{C>}
					2
					{Play with a pink bunny rabbit?}
					101
					81
					{D>}
					3
					{RUN LIKE HECK!!!}
				)
				(EgoDead 410 1) ; "Well... maybe. It's worth a try."
			)
		)
	)
)

(instance blast of Prop
	(properties
		view 28
	)
)

