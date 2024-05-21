;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use MoveToY)
(use Inertia)
(use eRS)
(use n940)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
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
	[local0 101] = [0 0 -100 -100 0 0 250 4 0 0 236 16 0 0 223 26 0 0 207 35 0 0 192 45 0 0 178 60 0 1 168 70 0 2 158 74 0 3 153 78 0 4 153 84 0 5 156 93 0 6 166 97 0 7 176 102 0 8 192 104 0 9 206 107 0 9 220 108 0 10 235 113 0 10 253 120 0 10 253 120 0 10 270 130 0 10 283 140 0 10 297 149 0 10 313 161 0 0 -100 -100 -32768]
	[local101 165] = [0 0 -100 -100 3 0 220 23 3 0 231 39 3 0 241 50 3 0 248 63 3 0 251 78 3 0 254 94 3 1 254 112 3 2 250 127 3 2 244 142 3 2 236 154 3 2 225 163 3 3 213 169 3 3 199 173 3 3 186 179 3 3 173 181 3 4 158 183 3 4 145 181 3 5 131 177 3 5 116 167 3 6 111 149 3 6 123 129 3 7 141 121 3 7 161 116 3 8 168 118 3 9 156 119 3 10 143 120 3 10 130 116 3 10 116 110 3 11 105 105 3 11 99 95 3 11 100 81 3 11 108 66 3 12 118 55 3 12 132 45 3 13 148 40 3 13 165 27 3 13 180 13 3 13 192 7 3 0 210 10 0 0 -100 -100 -32768]
	local266
	local267
	local268
	local269
	local270
	local271
	local272
	local273
	local274
	local275
	local276
	local277
	local278
)

(instance rm405 of SQRoom
	(properties
		picture 405
		horizon 8
		north 406
		east 410
		west 370
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 400 403)
		(switch (gEgo view:)
			(0
				(LoadMany rsVIEW 406 407)
			)
			(402
				(LoadMany rsVIEW 398 411)
			)
		)
		(LoadMany rsSOUND 0 105 401 406)
		(switch gPrevRoomNum
			(north
				(self setScript: enterScript 0 north style: 10)
			)
			(east
				(self setScript: enterScript 0 east style: 11)
			)
			(else
				(gLongSong number: 406 loop: -1 vol: 127 flags: 1 playBed:)
				(gLongSong2 number: 0 stop:)
				(self setScript: enterScript 0 west style: 10)
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
					init: 69 125 41 125 0 111 0 0 44 0 44 112
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
			((or (IsFlag 20) (and (== gPrevRoomNum 370) (IsFlag 22)))
				(LoadMany rsVIEW 408 409 28)
				((ScriptID 700 6) init: hide: setScript: swimAfterEgo) ; sp1
			)
			((not (IsFlag 19)) 0)
			((== gPrevRoomNum 370)
				(LoadMany rsVIEW 7 13 28 409)
				((ScriptID 700 6) init: hide: setScript: enterAndShootEgo) ; sp1
			)
			(else
				(LoadMany rsVIEW 13 28 409)
				((ScriptID 700 6) init: setScript: shootEgo) ; sp1
			)
		)
		(self setRegions: 700) ; mall
		(gFeatures
			add: skateorama light steps wall restOfMall
			eachElementDo: #init
			doit:
		)
	)

	(method (dispose)
		(if (gSounds contains: skate0Snd)
			(skate0Snd dispose:)
		)
		(if (gSounds contains: skate3Snd)
			(skate3Snd dispose:)
		)
		(super dispose: &rest)
	)

	(method (doit)
		(cond
			(script 0)
			(
				(or
					(== (gEgo view:) 409)
					(>= local277 8)
					(and
						(== ((ScriptID 700 6) script:) swimAfterEgo) ; sp1
						(swimAfterEgo state:)
					)
				)
				(gEgo edgeHit: EDGE_NONE)
			)
			((StepOn gEgo 2)
				(HandsOff)
				(cond
					((OneOf (gEgo view:) 373 374)
						(gEgo x: (- (gEgo x:) 4) setMotion: 0)
						(Print 405 0) ; "A real lady doesn't go Zero-G swimming in a dress!"
						(HandsOn)
					)
					((OneOf (gEgo view:) 406 398)
						(self setScript: endSwimScript)
					)
					(else
						(self setScript: startSwimScript)
					)
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
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(HandsOff)
				(self setScript: exitScript 0 east)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: stayInScript)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber east) (!= newRoomNumber north))
			(gLongSong fade:)
		)
		(if (and (IsFlag 20) (not (IsFlag 22)))
			(SetFlag 22)
			(SetFlag 8)
			(SetFlag 10)
			(SetFlag 11)
			(SetFlag 13)
			(SetFlag 12)
			(ClearFlag 9)
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
				(cond
					((OneOf (gEgo view:) 373 374)
						(= local278 0)
					)
					((OneOf (gEgo view:) 402 14 398)
						(= local278 1)
					)
					((OneOf (gEgo view:) 0 4 406)
						(= local278 2)
					)
				)
				(switch register
					((gCurRoom west:)
						(switch local278
							(0
								(NormalEgo 0 373 374)
							)
							(1
								(NormalEgo 0 402 14)
							)
							(2
								(NormalEgo 0 0 4)
							)
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
		description {Zero-G skater}
		lookStr {The Zero-G skaters look to be having fun.__But I wouldn't get in their way if I were you.__They enjoy playing "Spin the Dweeb" with any non-skaters who happen to wander into their air space.}
		view 400
		priority 2
		signal 24592
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(OneOf (gEgo view:) 406 398)
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
		description {Zero-G skater}
		lookStr {The Zero-G skaters look to be having fun.__But I wouldn't get in their way if I were you.__They enjoy playing "Spin the Dweeb" with any non-skaters who happen to wander into their air space.}
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
							(skater0 @local0)
							(skater3 @local101)
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
				(= local267 1)
				(= local268 121)
				(= local269 54)
				(= local270 107)
				(= local266
					(Graph grSAVE_BOX (- 107 1) local267 (+ local268 1) (+ local269 1) 1)
				)
				(Graph
					grDRAW_LINE
					local268
					local267
					local270
					local269
					(proc0_18 global133 global143 global143)
					2
					-1
				)
				(Graph grREDRAW_BOX (- local270 1) local267 (+ local268 1) (+ local269 1))
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(2
				(blast init: posn: local269 local270 setCycle: End)
				(Graph grRESTORE_BOX local266)
				(Graph grREDRAW_BOX (- local270 1) local267 (+ local268 1) (+ local269 1))
				(= cycles 1)
			)
			(3
				(= cycles 16)
			)
			(4
				(= local267 1)
				(= local268 181)
				(= local269 58)
				(= local270 108)
				(= local266
					(Graph grSAVE_BOX (- 108 1) local267 (+ local268 1) (+ local269 1) 1)
				)
				(Graph
					grDRAW_LINE
					local270
					local267
					local268
					local269
					(proc0_18 global133 global143 global143)
					2
					-1
				)
				(Graph grREDRAW_BOX (- local270 1) local267 (+ local268 1) (+ local269 1))
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(5
				(blast cel: 0 posn: local269 local268 setCycle: End)
				(Graph grRESTORE_BOX local266)
				(Graph grREDRAW_BOX (- local270 1) local267 (+ local268 1) (+ local269 1))
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
					(= local267 1)
					(= local270 (- (gEgo y:) 36))
					(= local269 (- (gEgo x:) 3))
					(= local268 (- (gEgo y:) 32))
					(Graph
						grDRAW_LINE
						local268
						local267
						local270
						local269
						(proc0_18 global133 global143 global143)
						(- (gEgo priority:) 1)
						-1
					)
					(Graph
						grREDRAW_BOX
						(- local270 1)
						local267
						(+ local268 1)
						(+ local269 1)
					)
					(aSound number: 105 loop: 1 vol: 127 play:)
					(= cycles 4)
				)
			)
			(8
				(EgoDead 8 12)
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
				(< local277 8)
			)
			(= local277 8)
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
				(++ local277)
				((ScriptID 700 6) ; sp1
					loop: (if register 0 else 4)
					cel: 0
					cycleSpeed: 1
					setCycle: CT 1 1 self
				)
			)
			(2
				(if register
					(= local271 54)
					(= local272 (if (<= 105 (gEgo y:) 120) 110 else 104))
					(= local273 (Min (+ (gEgo x:) 6) 318))
					(= local274 (Max (- (gEgo y:) 10) 5))
				else
					(= local271 42)
					(= local272 113)
					(= local273 (Min (+ (gEgo x:) 6) 318))
					(= local274 (Min (- (gEgo y:) 8) 188))
				)
				(cond
					((>= local277 8)
						(= local275 local273)
						(= local276 local274)
					)
					(
						(= temp0
							(/
								(* (- local272 local274) 100)
								(- local273 local271)
							)
						)
						(if (< temp0 0)
							(= local276 188)
						else
							(= local276 2)
						)
						(= local275
							(Min
								318
								(+
									(/ (* (- local272 local276) 100) temp0)
									local271
								)
							)
						)
					)
					(else
						(= local275 318)
						(= local276 local272)
					)
				)
				(if (and (> local275 318) temp0)
					(= local275 318)
					(= local276
						(Max
							(-
								188
								(+ (/ (* temp0 (- 318 local271)) 100) local272)
							)
						)
					)
				)
				(if (< local272 local276)
					(= local270 local272)
					(= local268 local276)
				else
					(= local270 local276)
					(= local268 local272)
				)
				(= local266
					(Graph
						grSAVE_BOX
						(- local270 1)
						(- local271 1)
						(+ local268 1)
						(+ local275 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local272
					local271
					local276
					local275
					(proc0_18 global133 global143 global143)
					0
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local270 1)
					(- local271 1)
					(+ local268 1)
					(+ local275 1)
				)
				((ScriptID 700 6) setCycle: End) ; sp1
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(if (>= local277 8)
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
				(Graph grRESTORE_BOX local266)
				(Graph
					grREDRAW_BOX
					(- local270 1)
					(- local271 1)
					(+ local268 1)
					(+ local275 1)
				)
				(if (>= local277 8)
					(blast init: cel: 0 posn: local273 local274 setCycle: End)
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
					{SQ QUIZ QUESTION #1052\nWhen being shot at by crazed Sequel Police Cyborgs, a space hero should:}
					106
					106
					81
					{A>}
					0
					{Wait patiently until they get lucky?}
					106
					81
					{B>}
					1
					{Make a list of favorite bodily functions?}
					106
					81
					{C>}
					2
					{Stroke your bunny?}
					106
					81
					{D>}
					3
					{Remove your hindquarters from here!!!}
				)
				(EgoDead 8 18)
			)
		)
	)
)

(instance swimAfterEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (if (and (== gPrevRoomNum 370) (IsFlag 22)) 16 else 120))
			)
			(1
				(if
					(or
						(and
							(not (gCurRoom script:))
							(< (gEgo x:) 236)
							(> (gEgo y:) 30)
						)
						(and (== gPrevRoomNum 370) (IsFlag 22))
					)
					(gEgo setMotion: 0)
					((ScriptID 700 4) inertia: 0) ; eSwimCode
					((ScriptID 700 6) ; sp1
						show:
						view: 408
						setLoop: 1
						cel: 0
						setCycle: End
						setStep: 2 2
						posn:
							(if (and (== gPrevRoomNum 370) (IsFlag 22))
								318
							else
								358
							)
							(- (gEgo y:) 18)
						setMotion: MoveTo 310 (- (gEgo y:) 10) self
					)
				else
					(self init:)
				)
			)
			(2
				(HandsOff)
				((ScriptID 700 6) ; sp1
					view: 409
					setLoop: 1
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(3
				(= local272 (- ((ScriptID 700 6) y:) 4)) ; sp1
				(= local271 (- ((ScriptID 700 6) x:) 57)) ; sp1
				(= local274 (Max 2 (Min 188 (- (gEgo y:) 10))))
				(= local273 (Min 318 (gEgo x:)))
				(if (< local274 local272)
					(= local270 local274)
					(= local268 local272)
				else
					(= local270 local272)
					(= local268 local274)
				)
				(= local266
					(Graph
						grSAVE_BOX
						(- local270 1)
						(- local273 1)
						(+ local268 1)
						(+ local271 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local272
					local271
					local274
					local273
					(proc0_18 global133 global143 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local270 1)
					(- local273 1)
					(+ local268 1)
					(+ local271 1)
					1
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(4
				(Graph grRESTORE_BOX local266)
				(Graph
					grREDRAW_BOX
					(- local270 1)
					(- local273 1)
					(+ local268 1)
					(+ local271 1)
					1
				)
				(blast init: cel: 0 posn: local273 local268 setCycle: End)
				((ScriptID 700 6) cel: 0) ; sp1
				(if
					(or
						(gEgo script:)
						(OneOf (gCurRoom script:) landScript endSwimScript)
					)
					(gEgo view: 409 setLoop: 4)
				else
					(gEgo view: 26)
				)
				(gEgo cel: 0 setCycle: End self setMotion: 0)
			)
			(5
				(PrintD
					{SQ QUIZ QUESTION #1052\nWhen being shot at by crazed Sequel Police Cyborgs, a space hero should:}
					106
					106
					81
					{A>}
					0
					{Wait patiently until they get lucky?}
					106
					81
					{B>}
					1
					{Make a list of favorite bodily functions?}
					106
					81
					{C>}
					2
					{Stroke your bunny?}
					106
					81
					{D>}
					3
					{Remove your hindquarters from here!!!}
				)
				(EgoDead 8 18)
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
				(gEgo setHeading: temp0 self cel: 0)
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
				(if (== local278 1)
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
				(if (== local278 2)
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local278 2)
					(= register 1)
				else
					(= register 3)
				)
				(gEgo
					view: 403
					setMotion: 0
					setCycle: 0
					setLoop: register
					cel: 1
					posn: (+ (gEgo x:) 12) (+ (gEgo y:) 5)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 3)
			)
			(1
				(gEgo
					setLoop: register
					cel: 0
					posn: (- (gEgo x:) 20) (+ (gEgo y:) 4)
				)
				(= cycles 3)
			)
			(2
				(if (== local278 2)
					(= temp0 0)
					(= temp1 4)
				else
					(= temp0 402)
					(= temp1 14)
				)
				(NormalEgo 1 temp0 temp1)
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local278 2)
					(= register 1)
				else
					(= register 3)
				)
				(gEgo
					view: 403
					setMotion: 0
					setCycle: 0
					setLoop: register
					cel: 1
					posn: (+ (gEgo x:) 12) (+ (gEgo y:) 5)
				)
				((ScriptID 700 4) dispose:) ; eSwimCode
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: register
					cel: 0
					posn: (- (gEgo x:) 20) (+ (gEgo y:) 4)
				)
				(= cycles 2)
			)
			(2
				(if (== local278 2)
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
				(if (== local278 2)
					(= temp1 4)
				else
					(= temp1 14)
				)
				(proc700_5 1)
				(NormalEgo 1 (gEgo view:) temp1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stayInScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				((gEgo code:) xOff: 0 yOff: 0 inertia: 0)
				(= temp0 (gEgo x:))
				(= temp1 220)
				(gEgo illegalBits: 0 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				((gEgo code:) xOff: 0 yOff: 0 inertia: 0)
				(if (> (gEgo x:) 300)
					(gEgo x: 300)
				)
				(if (< (gEgo x:) 78)
					(gEgo x: 78)
				)
				(Animate (gCast elements:) 0)
				(= temp0 (gEgo x:))
				(= temp1 185)
				(gEgo setMotion: MoveTo temp0 temp1 self)
			)
			(2
				(gEgo illegalBits: -32768)
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

(instance skateorama of Feature
	(properties
		x 75
		y 100
		description {Skate-O-Rama}
		sightAngle 180
		lookStr {It's a Zero-G Skate-O-Rama.__In here, the mall's gravity generators have no effect, providing an ideal and unique entertainment opportunity for the entire family.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 2048))
	)
)

(instance light of Feature
	(properties
		x 1
		y 189
		description {center light}
		lookStr {The Skate-O-Rama is illuminated by a nearby sun whose glow is reflected through a mirror set into the floor.__With this latest innovation, you can now enjoy zero-G while tuning up your tan.}
	)

	(method (onMe param1)
		(return (== (OnControl CONTROL (param1 x:) (param1 y:)) 1024))
	)
)

(instance steps of Feature
	(properties
		x 280
		y 90
		description {steps}
		sightAngle 180
		lookStr {These steps lead up to the rest of the Galaxy Galleria Mall.}
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $1002))
	)
)

(instance wall of Feature
	(properties
		x 190
		y 80
		description {wall}
		sightAngle 180
		lookStr {These walls protect shoppers from errant sky-skaters.}
	)

	(method (onMe param1)
		(return
			(or
				(& (OnControl CONTROL (param1 x:) (param1 y:)) $e000)
				(and
					(& (OnControl CONTROL (param1 x:) (param1 y:)) $0004)
					(> (param1 y:) 71)
				)
			)
		)
	)
)

(instance restOfMall of Feature
	(properties
		x 110
		y 80
		description {rest of the mall}
		sightAngle 180
		lookStr {The rest of the Galaxy Galleria awaits the unwary and uninformed shopper.}
	)

	(method (onMe)
		(return 1)
	)
)

(instance aSound of Sound
	(properties)
)

