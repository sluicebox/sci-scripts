;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
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
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm405 0
)

(local
	[local0 97] = [0 0 250 4 0 0 236 16 0 0 223 26 0 0 207 35 0 0 192 45 0 0 178 60 0 1 168 70 0 2 158 74 0 3 153 78 0 4 153 84 0 5 156 93 0 6 166 97 0 7 176 102 0 8 192 104 0 9 206 107 0 9 220 108 0 10 235 113 0 10 253 120 0 10 253 120 0 10 270 130 0 10 283 140 0 10 297 149 0 10 313 161 0 0 -100 -100 -32768]
	[local97 161] = [3 0 220 23 3 0 231 39 3 0 241 50 3 0 248 63 3 0 251 78 3 0 254 94 3 1 254 112 3 2 250 127 3 2 244 142 3 2 236 154 3 2 225 163 3 3 213 169 3 3 199 173 3 3 186 179 3 3 173 181 3 4 158 183 3 4 145 181 3 5 131 177 3 5 116 167 3 6 111 149 3 6 123 129 3 7 141 121 3 7 161 116 3 8 168 118 3 9 156 119 3 10 143 120 3 10 130 116 3 10 116 110 3 11 105 105 3 11 99 95 3 11 100 81 3 11 108 66 3 12 118 55 3 12 132 45 3 13 148 40 3 13 165 27 3 13 180 13 3 13 192 7 3 0 210 10 0 0 -100 -100 -32768]
	local258
	local259
	local260
	local261
	local262
	local263
	local264
	local265
	local266
	local267
	local268
	local269
)

(instance rm405 of SQRoom
	(properties
		picture 405
		north 406
		east 410
		west 370
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 400)
		(LoadMany rsSOUND 401 406)
		(switch gPrevRoomNum
			(north
				(self setScript: enterScript 0 north style: 30)
			)
			(east
				(self setScript: enterScript 0 east style: 40)
			)
			(else
				(gLongSong number: 406 loop: -1 playBed:)
				(gLongSong2 number: 0 stop:)
				(self setScript: enterScript 0 west style: 30)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 168 16 168 50 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 81 125 41 125 41 121 26 121 26 117 11 117 11 111 0 111 0 0 81 0
					yourself:
				)
		)
		(gEgo init:)
		(super init:)
		(skate0Snd init:)
		(skate3Snd init:)
		(skater0 init: setScript: (Clone skaterScript))
		(skater3 init: setScript: (Clone skaterScript))
		(cond
			((IsFlag 21)
				((ScriptID 700 6) init: hide: setScript: swimAfterEgo) ; sp1
			)
			((not (IsFlag 20)) 0)
			((== gPrevRoomNum 370)
				((ScriptID 700 6) init: hide: setScript: enterAndShootEgo) ; sp1
			)
			(else
				((ScriptID 700 6) init: setScript: shootEgo) ; sp1
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
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitScript 0 north)
			)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				(self setScript: exitScript 0 east)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber east) (!= newRoomNumber north))
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
					((gCurRoom west:)
						(gEgo x: -20 y: 106 setMotion: MoveTo 22 142 self)
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
								(if (< (gEgo x:) 90)
									90
								else
									(gEgo x:)
								)
							y: (- (gCurRoom horizon:) temp0)
						)
						(Animate (gCast elements:) 0)
						(gEgo setMotion: MoveTo (gEgo x:) 10 self)
					)
					((gCurRoom east:)
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
							oldDir: 270
							xOff: -1
						)
						(gEgo
							normal: 0
							setHeading: 270
							setCycle: Swim
							x: (- 319 (+ (/ temp0 2) 1))
							y: (gEgo y:)
						)
						(= cycles 1)
					)
				)
			)
			(1
				(switch register
					((gCurRoom west:)
						(if (== (gEgo view:) 402)
							(NormalEgo 0 402 14)
						else
							(NormalEgo 0 0 4)
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

(instance skater0 of Prop
	(properties
		x -100
		y -100
		view 400
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

(instance skater3 of Prop
	(properties
		x -100
		y -100
		view 400
		loop 3
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

(instance skaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 10))
			)
			(1
				(client
					setCycle:
						MCyc
						(switch client
							(skater0
								@local0
							)
							(skater3
								@local97
							)
						)
						self
				)
				(switch client
					(skater0
						(skate0Snd play:)
					)
					(skater3
						(skate3Snd play:)
					)
				)
			)
			(2
				(switch client
					(skater0
						(skate0Snd stop:)
					)
					(skater3
						(skate3Snd stop:)
					)
				)
				(self init:)
			)
		)
	)
)

(instance enterAndShootEgo of Script
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:))
			((and (<= (gEgo x:) 18) (OneOf state 0 3 6))
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
				(= local259 0)
				(= local260 121)
				(= local261 54)
				(= local262 107)
				(= local258
					(Graph
						grSAVE_BOX
						(- 107 1)
						(- local259 1)
						(+ local260 1)
						(+ local261 1)
						1
					)
				)
				(Graph grDRAW_LINE local260 local259 local262 local261 global133 2 -1)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local259 1)
					(+ local260 1)
					(+ local261 1)
				)
				(= cycles 1)
			)
			(2
				(blast init: posn: local261 local262 setCycle: End)
				(Graph grRESTORE_BOX local258)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local259 1)
					(+ local260 1)
					(+ local261 1)
				)
				(= cycles 1)
			)
			(3
				(= cycles 16)
			)
			(4
				(= local259 0)
				(= local260 181)
				(= local261 58)
				(= local262 108)
				(= local258
					(Graph
						grSAVE_BOX
						(- 108 1)
						(- local259 1)
						(+ local260 1)
						(+ local261 1)
						1
					)
				)
				(Graph grDRAW_LINE local262 local259 local260 local261 global133 2 -1)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local259 1)
					(+ local260 1)
					(+ local261 1)
				)
				(= cycles 1)
			)
			(5
				(blast cel: 0 posn: local261 local260 setCycle: End)
				(Graph grRESTORE_BOX local258)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local259 1)
					(+ local260 1)
					(+ local261 1)
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
					(= local259 0)
					(= local262 (- (gEgo y:) 36))
					(= local261 (- (gEgo x:) 3))
					(= local260 (- (gEgo y:) 32))
					(Graph
						grDRAW_LINE
						local260
						local259
						local262
						local261
						global133
						(- (gEgo priority:) 1)
						-1
					)
					(Graph
						grREDRAW_BOX
						(- local262 1)
						(- local259 1)
						(+ local260 1)
						(+ local261 1)
					)
					(= cycles 4)
				)
			)
			(8
				(EgoDead 405 0)
			)
			(9
				(= cycles 20)
			)
			(10
				((ScriptID 700 6) ; sp1
					show:
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					posn: -7 122
					setMotion: MoveTo 34 135 self
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
				(< (gEgo x:) 155)
				(> (gEgo y:) 6)
				(< local269 8)
			)
			(= local269 8)
			(gEgo setMotion: 0)
			((ScriptID 700 4) inertia: 0) ; eSwimCode
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 700 6) ; sp1
					view: 13
					setMotion: 0
					loop: (if register 0 else 4)
					cel: 0
					posn: 34 135
					init:
				)
				(= seconds 3)
			)
			(1
				(= register (<= (gEgo y:) 120))
				((ScriptID 700 6) ; sp1
					loop: (if register 0 else 4)
					cel: 0
					cycleSpeed: 1
					setCycle: CT 1 1 self
				)
			)
			(2
				(++ local269)
				(if register
					(= local263 54)
					(= local264 (if (<= 105 (gEgo y:) 120) 110 else 104))
					(= local265 (Min (+ (gEgo x:) 6) 319))
					(= local266 (Max (- (gEgo y:) 10) 5))
				else
					(= local263 42)
					(= local264 113)
					(= local265 (Min (+ (gEgo x:) 6) 319))
					(= local266 (Min (- (gEgo y:) 8) 189))
				)
				(cond
					((>= local269 8)
						(= local267 local265)
						(= local268 local266)
					)
					(
						(= temp0
							(/
								(* (- local264 local266) 100)
								(- local265 local263)
							)
						)
						(if (< temp0 0)
							(= local268 190)
						else
							(= local268 1)
						)
						(= local267
							(+ (/ (* (- local264 local268) 100) temp0) local263)
						)
					)
					(else
						(= local267 320)
						(= local268 local264)
					)
				)
				(if (and (> local267 320) temp0)
					(= local267 320)
					(= local268
						(Max
							(-
								189
								(+ (/ (* temp0 (- 320 local263)) 100) local264)
							)
						)
					)
				)
				(if (< local264 local268)
					(= local262 local264)
					(= local260 local268)
				else
					(= local262 local268)
					(= local260 local264)
				)
				(= local258
					(Graph
						grSAVE_BOX
						(- local262 1)
						(- local263 1)
						(+ local260 1)
						(+ local267 1)
						1
					)
				)
				(Graph grDRAW_LINE local264 local263 local268 local267 global133 0 -1)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local263 1)
					(+ local260 1)
					(+ local267 1)
				)
				((ScriptID 700 6) setCycle: End self) ; sp1
				(= cycles 1)
			)
			(3
				(if (>= local269 8)
					(HandsOff)
					(gEgo
						view: 409
						setLoop: 5
						cel: 0
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
				((ScriptID 700 6) cel: 0 stopUpd:) ; sp1
				(Graph grRESTORE_BOX local258)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local263 1)
					(+ local260 1)
					(+ local267 1)
				)
				(if (>= local269 8)
					(blast init: cel: 0 posn: local265 local266 setCycle: End)
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
					{** SQ QUIZ QUESTION #1052\nWhen being shot at by crazed Sequel Police Cyborgs, a space hero should:}
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
				(EgoDead 405 1)
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
						(< 25 (gEgo x:) 260)
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
					setLoop: 1
					cel: 0
					setCycle: End
					setStep: 2 2
					posn: 358 (- (gEgo y:) 24)
					setMotion: MoveTo 310 (- (gEgo y:) 10) self
				)
			)
			(3
				((ScriptID 700 6) ; sp1
					view: 409
					setLoop: 1
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(4
				(= local264 (- ((ScriptID 700 6) y:) 4)) ; sp1
				(= local263 (- ((ScriptID 700 6) x:) 57)) ; sp1
				(= local266 (- (gEgo y:) 10))
				(= local265 (gEgo x:))
				(if (< local266 local264)
					(= local262 local266)
					(= local260 local264)
				else
					(= local262 local264)
					(= local260 local266)
				)
				(= local258
					(Graph
						grSAVE_BOX
						(- local262 1)
						(- local263 1)
						(+ local260 1)
						(+ local265 1)
						1
					)
				)
				(Graph grDRAW_LINE local264 local263 local266 local265 global133 1 -1)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local263 1)
					(+ local260 1)
					(+ local265 1)
					1
				)
				(= cycles 1)
			)
			(5
				(Graph grRESTORE_BOX local258)
				(Graph
					grREDRAW_BOX
					(- local262 1)
					(- local263 1)
					(+ local260 1)
					(+ local265 1)
					1
				)
				(blast init: cel: 0 posn: local265 local260 setCycle: End)
				((ScriptID 700 6) cel: 0) ; sp1
				(gEgo
					view: 409
					setLoop: 4
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
				(EgoDead 405 1)
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
					(= temp0 90)
				)
				(gEgo setHeading: temp0 self)
			)
			(1
				(switch register
					((gCurRoom north:)
						(gEgo setMotion: MoveToY -30 self)
					)
					((gCurRoom east:)
						(gEgo setMotion: MoveToX 350 self)
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
					(= temp1 2)
				else
					(= temp1 0)
				)
				(gEgo
					normal: 0
					view: 403
					setLoop: temp1
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if (== (gEgo loop:) 0)
					(= temp0 406)
				else
					(= temp0 398)
				)
				((ScriptID 700 4) init: gEgo) ; eSwimCode
				(gEgo
					normal: 0
					loop: 0
					setLoop: -1
					view: temp0
					posn: (+ (gEgo x:) 37) (- (gEgo y:) 3) 0
					setStep: 3 2
					setCycle: Swim
					cycleSpeed: 0
					setHeading: 90
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
					(= temp1 1)
				else
					(= temp1 3)
				)
				(gEgo
					view: 403
					setLoop: temp1
					cel: 1
					posn: (+ (gEgo x:) 12) (+ (gEgo y:) 5)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 3)
			)
			(1
				(gEgo cel: 0 posn: (- (gEgo x:) 20) (+ (gEgo y:) 4))
				(= cycles 3)
			)
			(2
				(if (== (gEgo loop:) 1)
					(= temp0 0)
					(= temp2 4)
				else
					(= temp0 402)
					(= temp2 14)
				)
				(NormalEgo 1 temp0 temp2)
				(proc700_5 1)
				(gEgo
					posn: (- (gEgo x:) 17) (+ (gEgo y:) 4)
					setMotion: PolyPath 24 136 self
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
					(= temp1 1)
				else
					(= temp1 3)
				)
				(gEgo
					view: 403
					setLoop: temp1
					cel: 1
					posn: (+ (gEgo x:) 12) (+ (gEgo y:) 5)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 2)
			)
			(1
				(gEgo cel: 0 posn: (- (gEgo x:) 20) (+ (gEgo y:) 4))
				(= cycles 2)
			)
			(2
				(if (== (gEgo loop:) 1)
					(= temp0 0)
				else
					(= temp0 402)
				)
				(NormalEgo 1 temp0)
				(gEgo
					setLoop: 1
					setStep: 6 4
					setCycle: 0
					setMotion: MoveTo 21 132 self
				)
			)
			(3
				(if (== (gEgo view:) 0)
					(= temp2 4)
				else
					(= temp2 14)
				)
				(NormalEgo 1 (gEgo view:) temp2)
				(HandsOn)
				(self dispose:)
			)
		)
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

(instance blast of Prop
	(properties
		view 28
	)
)

(instance skate0Snd of Sound
	(properties
		number 401
		priority 15
		loop -1
	)
)

(instance skate3Snd of Sound
	(properties
		number 401
		priority 15
		loop -1
	)
)

