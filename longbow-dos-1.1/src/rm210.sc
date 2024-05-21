;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	[local19 4] = [1210 0 1 0]
	[local23 5] = [1210 16 1 2 0]
	[local28 4] = [1210 18 1 0]
	[local32 14] = [1210 19 1 2 1 1 2 1 2 1 2 1 2 0]
	[local46 4] = [1210 30 1 0]
	[local50 6] = [1210 31 1 2 2 0]
	[local56 4] = [1210 34 1 0]
	[local60 7] = [1210 35 1 2 1 2 0]
	[local67 8] = [1210 39 1 2 2 1 2 0]
	[local75 4] = [1210 44 1 0]
	[local79 4] = [1210 47 1 0]
	[local83 4] = [1210 48 2 0]
	[local87 4] = [1210 49 1 0]
	[local91 4] = [1210 50 1 0]
	[local95 12] = [1210 51 1 2 1 2 2 1 1 1 1 0]
	[local107 13] = [1210 60 2 1 1 1 2 2 1 1 2 1 0]
	[local120 4] = [1210 70 1 0]
	[local124 4] = [1210 71 1 0]
	[local128 15] = [1210 72 1 2 1 1 2 2 1 2 2 1 1 1 0]
	[local143 4] = [1210 84 1 0]
	[local147 7] = [1210 244 1 2 1 1 0]
	[local154 4] = [1210 101 1 0]
	[local158 5] = [1210 99 1 1 0]
	[local163 5] = [1210 90 2 1 0]
	[local168 7] = [1210 92 2 1 2 1 0]
	[local175 5] = [1210 97 1 1 0]
	[local180 26] = [1210 102 2 1 1 2 1 2 1 2 2 2 2 1 2 2 1 2 1 2 1 2 1 2 2 0]
	[local206 4] = [1210 125 2 0]
	[local210 4] = [1210 126 1 0]
	[local214 5] = [1210 127 2 2 0]
	[local219 5] = [1210 129 1 1 0]
	[local224 6] = [1210 131 2 1 1 0]
	[local230 12] = [1210 134 1 2 1 1 1 2 1 1 1 0]
	[local242 14] = [1210 143 2 1 1 2 2 1 1 2 1 2 1 0]
	[local256 5] = [1210 154 2 2 0]
	[local261 5] = [1210 157 1 1 0]
	[local266 9] = [1210 159 2 1 2 1 2 1 0]
	[local275 7] = [1210 165 2 1 1 2 0]
	[local282 5] = [1210 179 1 2 0]
	[local287 10] = [1210 181 2 1 2 2 1 1 2 0]
	[local297 4] = [1210 188 1 0]
	[local301 9] = [1210 172 2 1 2 2 1 2 0]
	[local310 9] = [1210 189 2 2 1 1 2 2 0]
	[local319 4] = [1210 195 1 0]
	[local323 7] = [1210 196 2 2 1 2 0]
	[local330 8] = [1210 200 2 1 2 1 2 0]
	[local338 4] = [1210 205 1 0]
	[local342 4] = [1210 206 1 0]
	[local346 5] = [1210 207 2 1 0]
	[local351 5] = [1210 209 1 2 0]
	[local356 5] = [1210 211 2 1 0]
	[local361 5] = [1210 213 2 1 0]
	[local366 6] = [1210 215 2 1 2 0]
	[local372 14] = [1210 219 2 1 2 1 2 1 2 1 2 1 2 0]
	[local386 6] = [1210 230 2 1 2 0]
	[local392 7] = [1210 233 2 1 1 2 0]
	[local399 4] = [1210 238 1 0]
	[local403 4] = [1210 239 1 0]
	[local407 4] = [1210 45 1 0]
	[local411 4] = [1210 46 1 0]
	[local415 4] = [1210 3 1 0]
	[local419 5] = [1210 242 1 1 0]
	local424
	[local425 4]
	local429
	local430
	local431
	local432
	[local433 4] = [1211 0 1 0]
	[local437 4] = [1211 1 1 0]
	[local441 4] = [1211 2 1 0]
	[local445 7] = [1211 3 1 2 1 2 0]
	[local452 5] = [1211 7 1 1 0]
	[local457 4] = [1211 9 1 0]
	[local461 6] = [1211 10 1 2 1 0]
	[local467 6] = [1211 13 1 2 1 0]
	[local473 5] = [1211 18 1 1 0]
	[local478 4] = [1211 20 1 0]
	[local482 4] = [1211 21 1 0]
	[local486 4] = [1211 22 1 0]
	[local490 6] = [1211 23 2 1 1 0]
	[local496 4] = [1317 12 1 0]
	[local500 4] = [1210 169 1 0]
	[local504 3] = [-1 0 0]
	[local507 3] = [-1 {Willows} 5]
)

(procedure (localproc_0)
	(HandsOn)
	(if local12
		(gTheIconBar disable: 0 disable: 5)
	)
	(cond
		((== (marian script:) waitToDie)
			(gTheIconBar disable: 4 disable: 5)
		)
		((and (== gDisguiseNum 0) local430) ; outlaw
			(gTheIconBar disable: 4)
		)
	)
)

(procedure (localproc_1 param1)
	(Display {} dsRESTOREPIXELS local424)
	(StrCat @local425 param1)
	(= local424 (Display @local425 dsCOORD 115 35 dsCOLOR global187 dsBACKGROUND global186 dsSAVEPIXELS))
)

(instance rm210 of Rm
	(properties
		picture 210
		style 100
		east 220
		south 220
		west 220
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 220) ; forest
			(= gEgoEdgeHit 1)
		)
		(cond
			(
				(or
					(and (== gDay 4) (== gDisguiseNum 0) (gEgo has: 15)) ; outlaw, comb
					(and
						(== gDay 7)
						(== gDisguiseNum 0) ; outlaw
						(gEgo has: 17) ; handScroll
						(not (IsFlag 34))
					)
				)
				(marian init:)
				(gCurRoom
					addObstacle:
						(= local432
							((Polygon new:)
								type: PBarredAccess
								init: 116 146 153 145 153 152 116 152
								yourself:
							)
						)
				)
				(gCurRoom setScript: egoEnters 0 gEgoEdgeHit)
			)
			((== gPrevRoomNum 179) ; synop
				(gCurRoom setScript: carryIn)
			)
			(else
				(gCurRoom setScript: egoEnters 0 gEgoEdgeHit)
			)
		)
		(gEgo actions: egoActions)
		(gRgnMusic number: 905 play:)
		(gSFX number: (if (!= gDay 10) 210 else 217) loop: -1 play:)
		(willows init:)
		(ferns init:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((gEgo edgeHit:)
				(= gEgoEdgeHit (gEgo edgeHit:))
				(gCurRoom setScript: walkOut 0 (self edgeToRoom: gEgoEdgeHit))
			)
			(local431
				(local431 doit:)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 20 12 1)
		(gEgo actions: 0)
		(super dispose:)
		(DisposeScript 220)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo illegalBits: 0)
				(if (== gDisguiseNum 0) ; outlaw
					(= local431 weaponsCheck)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 228 161 201 147 171 143 136 143 96 147 76 152 63 160 0 160 0 0 319 0 319 161
								yourself:
							)
					)
				else
					(= local431 groveClosed)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 228 161 223 159 193 172 108 172 70 157 63 160 0 160 0 0 319 0 319 161
								yourself:
							)
					)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 178 303 186 248 186 224 178 251 170 300 170
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 60 177 41 184 4 184 0 176 16 170 43 170
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 224 159 223 162 194 173 107 173 74 162 67 156 2 58 313 58
							yourself:
						)
				)
				(switch register
					(1
						(gEgo
							posn: 142 240
							init:
							setMotion: PolyPath 142 183 self
						)
					)
					(2
						(gEgo
							posn: -10 170
							init:
							setMotion: PolyPath 40 170 self
						)
					)
					(else
						(gEgo
							posn: 325 170
							init:
							setMotion: PolyPath 250 170 self
						)
					)
				)
			)
			(1
				(if (IsFlag 179)
					(ClearFlag 179)
					(Converse @local419 @local504 0 self) ; "Thank the Blessed Virgin! The sprite's spell has worn off!"
				else
					(self cue:)
				)
			)
			(2
				(if (gCast contains: marian)
					(switch gDay
						(4
							(switch global149
								(0
									(Converse @local346 1 22 self) ; "Bring no weapons into this sacred place."
								)
								(1
									(= cycles 1)
								)
								(2
									(Converse @local361 1 22 self) ; "Come, stand here in the center."
								)
							)
						)
						(7
							(= cycles 1)
						)
					)
				else
					(localproc_0)
					(self dispose:)
				)
			)
			(3
				(SetFlag 155)
				(self setScript: disarm self)
				(= local430 1)
			)
			(4
				(if (== gDay 7)
					(++ state)
				)
				(marian loop: 0)
				(= cycles 2)
			)
			(5
				(switch global149
					(1
						(Converse @local356 1 22 self) ; "You seem confused and uncertain. I'll try to be patient with you."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(6
				(switch gDay
					(4
						(switch global149
							(0
								(Converse @local351 1 22 self) ; "I'm most pleased to see you again. I beg you to stay longer this time."
							)
							(2
								(Converse @local366 1 22 self) ; "Now stand fast in that place, until our business here is done."
								(= local12 1)
							)
							(else
								(= cycles 1)
							)
						)
					)
					(7
						(switch global149
							(0
								(Converse @local372 1 22 self) ; "'Tis good to see you safe, Robin."
							)
							(1
								(Converse @local386 1 22 self) ; "I wish you wouldn't leave like that when we've so much yet to discuss."
							)
							(else
								(Converse @local392 1 22 self) ; "By the Blessed Lady, Robin, if you leave here one more time--"
								(= local12 1)
							)
						)
					)
				)
			)
			(7
				(localproc_0)
				(++ global149)
				(self dispose:)
			)
		)
	)
)

(instance disarm of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (gEgo mover:))
				(if (and register (register isMemberOf: PolyPath))
					(gEgo mover: 0)
				else
					(gEgo setMotion: (= register 0))
				)
				(if (IsFlag 155)
					(= cycles 1)
				else
					(Say 1210 218 self) ; "Such is the power of this grove, I feel compelled to lay down my weapons before I enter."
				)
				(SetFlag 155)
			)
			(1
				(gEgo setMotion: PolyPath 149 175 self)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gEgo
					view: 15
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 5)
					setPri: 12
					setCycle: End self
				)
				(bow posn: (gEgo x:) (gEgo y:) init: setCycle: End)
				(Load rsVIEW 702)
				(Load rsVIEW 703)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					posn: (- (gEgo x:) 9) (- (gEgo y:) 3)
					setLoop: 3
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(6
				(quiver
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 2)
					signal: 16641
					init:
				)
				(NormalEgo 2 702 703)
				(= ticks 12)
			)
			(7
				(bow signal: (| (bow signal:) $0100) stopUpd:)
				(gEgo
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 149 172 self
				)
			)
			(8
				(if register
					(localproc_0)
					(gEgo
						mover: register
						setMotion:
							PolyPath
							(register finalX:)
							(register finalY:)
					)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 165 149 self)
					(if (not (gCast contains: marian))
						(++ state)
					)
				)
			)
			(9
				(Face gEgo marian self)
			)
			(10
				(= cycles 2)
			)
			(11
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance rearm of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 0)
				(Load rsVIEW 1)
				(= register (gEgo mover:))
				(if (and register (register isMemberOf: PolyPath))
					(gEgo mover: 0)
				else
					(gEgo setMotion: (= register 0))
				)
				(gEgo setMotion: PolyPath (bow x:) (bow y:) self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 15
					posn: (- (gEgo x:) 9) (- (gEgo y:) 3)
					setLoop: 3
					cel: 5
					cycleSpeed: 12
					setPri: 13
					setCycle: Beg self
				)
				(quiver dispose:)
			)
			(3
				(= ticks 12)
			)
			(4
				(gEgo
					posn: (bow x:) (bow y:)
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(bow signal: (& (bow signal:) $feff) startUpd:)
				(= ticks 12)
			)
			(6
				(gEgo setCycle: Beg self)
				(bow setCycle: Beg)
			)
			(7
				(= ticks 12)
			)
			(8
				(bow dispose:)
				(NormalEgo 4)
				(localproc_0)
				(gEgo setPri: -1 posn: (- (gEgo x:) 6) (- (gEgo y:) 6))
				(if register
					(gEgo
						mover: register
						setMotion:
							PolyPath
							(register finalX:)
							(register finalY:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance weaponsCheck of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((= temp0 (& (gEgo onControl: 1) $0004))
				(if (not local430)
					(gCurRoom setScript: disarm)
				)
			)
			(local430
				(gCurRoom setScript: rearm)
			)
		)
		(= local430 temp0)
	)
)

(instance groveClosed of Code
	(properties)

	(method (doit &tmp temp0)
		(if (& (gEgo onControl: 1) $0004)
			(= local431 0)
			(Say
				1210
				(if (and (== gDisguiseNum 4) (== gDay 8)) 248 else 249) ; yeoman
				1
			)
		)
	)
)

(instance bow of Prop
	(properties
		lookStr 7 ; "My bow and quiver lie where I left them."
		view 15
		loop 6
		priority 14
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(if (or (!= theVerb 3) local12) ; Do
			(super doVerb: theVerb invItem)
		else
			(gEgo setMotion: 0)
			(gCurRoom setScript: rearm)
			(= local430 0)
		)
	)
)

(instance quiver of View
	(properties
		lookStr 7 ; "My bow and quiver lie where I left them."
		view 15
		loop 4
		signal 16641
	)

	(method (doVerb)
		(bow doVerb: &rest)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch gEgoEdgeHit
					(3
						(= temp1 240)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(HandsOff)
				(if (!= gEgoEdgeHit 1)
					(gEgo
						ignoreActors: 1
						setMotion: PolyPath temp0 temp1 self
					)
				else
					(self cue:)
				)
			)
			(1
				(localproc_0)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance carryIn of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 228 161 201 147 171 143 136 143 96 147 76 152 63 160 14 160 14 170 43 170 60 177 36 186 248 186 224 178 251 170 302 170 302 161
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 129 149 185 147 190 151 182 156 127 159 119 154
							yourself:
						)
				)
				(marian
					actions: dying
					view: 510
					loop: 1
					posn: 154 154
					init:
					setCycle: End self
					ignoreActors: 1
				)
			)
			(1
				(= local429 1)
				(marian loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(Converse @local19 999 0 self) ; "Marian? Marian, can you hear me?"
			)
			(3
				(Say 1210 1 self) ; "She can scarcely breathe. The smoke has seared her lungs."
			)
			(4
				(Say 1210 2 self) ; "If I cannot save her, she'll die within minutes!"
			)
			(5
				(gEgo
					view: 510
					setLoop: 4
					setPri: -1
					posn: 167 152
					init:
					setScript: waitToStand
				)
				(marian loop: 3 setScript: waitToDie)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance waitToStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(= register (gEgo mover:))
				(gEgo mover: 0 setPri: -1 setCycle: End self)
			)
			(2
				(NormalEgo 2 702 703)
				(gEgo y: 150 setMotion: MoveTo (gEgo x:) 147 self)
			)
			(3
				(if (and register (register isMemberOf: PolyPath))
					(gEgo
						setMotion:
							register
							(register finalX:)
							(register finalY:)
					)
				else
					(gEgo setMotion: register (register x:) (register y:))
				)
				(gEgo cycleSpeed: (gEgo moveSpeed:))
				(= local429 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (gEgo mover:)
			(self cue:)
		)
	)
)

(instance waitToDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(HandsOff)
				(SetScore -500)
				(self setScript: sit self)
			)
			(2
				(gSFX number: 215 loop: -1 play:)
				(Converse @local415 2 0 self) ; "I was too slow! She's dead! Dead!"
			)
			(3
				(Load rsVIEW 501)
				(gEgo cycleSpeed: 9 setCycle: CT 2 1 self)
			)
			(4
				(gEgo
					view: 501
					cel: 0
					x: (- (gEgo x:) 2)
					setCycle: CT 3 1 self
				)
			)
			(5
				(for ((= register 98)) (>= register 0) ((-= register 2))
					(Palette palSET_INTENSITY 1 255 register)
					(Wait 4)
				)
				(gCurRoom drawPic: 803 100)
				(gCurRoom setScript: 0 script: self)
				(marian script: 0)
				(= client gCurRoom)
				(gCast eachElementDo: #dispose)
				(= cycles 3)
			)
			(6
				(Palette palSET_INTENSITY 1 255 100)
				(SetFlag 5)
				(gCurRoom newRoom: 160)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (= temp0 (& (gEgo onControl: 1) $0002)) (not local430))
			(Say 1210 4) ; "I dare not leave with Marian so near death!"
		)
		(= local430 temp0)
	)
)

(instance marian of Actor
	(properties
		x 135
		y 150
		lookStr 5 ; "She is the most beautiful woman I have ever beheld."
		view 212
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1210 14) ; "I shall lay no hand upon this lady until I know she wishes it as much as I."
			)
			(5 ; Talk
				(switch gDay
					(4
						(cond
							((and (gEgo has: 15) local4) ; comb
								(Converse 1 @local28 22 3) ; "I'd prefer to say nothing else until I've made up my mind about you."
							)
							((gEgo has: 15) ; comb
								(= local4 1)
								(Converse @local23 999 22) ; "There are so many things I wish to know about you--"
							)
							(local5
								(Converse 1 @local46 22 3) ; "I prefer to judge a man by his actions, not his words."
							)
							(else
								(= local5 1)
								(Converse @local32 999 22) ; "Now that you've found me worthy of your trust, won't you tell me more of yourself?"
							)
						)
					)
					(7
						(cond
							((and (not (IsFlag 34)) local6)
								(Converse @local56 22 0) ; "Please, if you have the scroll I need, don't tease me like this. Time is precious."
							)
							((not (IsFlag 34))
								(++ local6)
								(Converse @local50 1 22) ; "Would you like to hear how I entered and then escaped the Monastery?"
							)
							((> local7 1)
								(Converse @local75 22) ; "I've told you all I can for now. When I see you next, it will be at the Fair."
							)
							((== local7 1)
								(++ local7)
								(Converse @local67 1 22) ; "This news of the Sheriff raising more men concerns me greatly."
							)
							(1
								(++ local7)
								(Converse @local60 1 22) ; "Is there more you can tell me of the Green Man?"
							)
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse @local407 22) ; "I've no need for such a man's toy."
					)
					(0 ; bucks
						(Converse @local411 22) ; "'Tis kind of you to offer, but I've quite enough money of my own."
					)
					(2 ; halfHeart
						(switch gDay
							(4
								(if local16
									(super doVerb: theVerb &rest)
								else
									(gCurRoom setScript: giveEmerald)
								)
							)
							(7
								(cond
									(local16
										(super doVerb: theVerb &rest)
									)
									((and (IsFlag 143) (IsFlag 34))
										(gCurRoom setScript: sex)
									)
									(else
										(gCurRoom setScript: giveEmerald)
									)
								)
							)
						)
					)
					(15 ; comb
						(gCurRoom setScript: giveComb)
					)
					(14 ; amethyst
						(Converse @local282 1 22) ; "If you'd care to have this piece of amethyst--"
					)
					(12 ; puzzleBox
						(if local8
							(Converse 1 @local297 22 3) ; "Please, I insist you keep it."
						else
							(= local8 1)
							(Converse @local287 1 22) ; "Is that the Abbot's?!"
						)
					)
					(10 ; fireRing
						(if (== gDay 7)
							(if local9
								(Say 1210 170) ; "I won't show it to her again after the distress it caused her."
							else
								(Converse @local301 1 22) ; "I care not for the feel of that ring."
							)
						)
					)
					(17 ; handScroll
						(if (IsFlag 34)
							(Converse 1 @local500 22 3) ; "You must give it to the Queen's spy."
						else
							(gCurRoom setScript: giveScroll)
						)
					)
					(16 ; fulkScroll
						(gCurRoom setScript: giveFScroll)
					)
					(18 ; waterRing
						(switch gDay
							(7
								(if local11
									(Converse 1 @local338 22 3) ; "I charge you to guard it for the King."
								else
									(Converse @local330 1 22) ; "This ring has a wondrous good feel to it."
								)
							)
							(10
								(Say 1210 178) ; "Alas, the ring has no power to heal."
							)
						)
					)
					(4 ; net
						(Converse 1 @local342 22 3) ; "'Tis good the Widow has given you this. You'll have need of it."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance giveEmerald of TScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0004))
					(self setScript: disarm self)
					(= local430 4)
					(-- state)
					(return)
				)
				(gEgo
					setMotion:
						PolyPath
						(+ (marian x:) 28)
						(+ (marian y:) -1)
						self
				)
			)
			(1
				(= notKilled 1)
				(gEgo setLoop: 1)
				(marian loop: 0)
				(Load rsVIEW 215)
				(= ticks 20)
			)
			(2
				(marian hide:)
				(gEgo
					view: 215
					cycleSpeed: 6
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 7) (gEgo y:)
				)
				(= ticks 40)
			)
			(3
				(gEgo posn: (+ (gEgo x:) 7) (gEgo y:))
				(NormalEgo 1 702 703)
				(marian
					view: 215
					x: (+ (marian x:) 1)
					loop: 4
					cel: 3
					show:
					setCycle: End self
				)
			)
			(4
				(marian
					view: 211
					x: (+ (marian x:) -1)
					loop: 0
					setCycle: StopWalk 212
				)
				(if
					(or
						(gEgo has: 15) ; comb
						(and (== gDay 7) (not (IsFlag 34)))
					)
					(cond
						((== gDay 4)
							(Converse @local79 22) ; "That is not the token I seek."
						)
						((IsFlag 143)
							(Converse @local158 22) ; "I'm glad to see you have the emerald still safely in your care, but matters of love must wait."
						)
						(else
							(Converse @local154 22) ; "I don't mind that you pilfer a gem from the Monks, but what of the Hand Scroll?"
						)
					)
					(localproc_0)
					(self dispose:)
				else
					(SetScore 50 143)
					(= local16 1)
					(if local18
						(Converse @local83 22 1 self 0) ; "Marian, you barely glanced at this before. Please look more closely."
					else
						(++ state)
						(= cycles 1)
					)
				)
				(= local18 1)
			)
			(5
				(switch gDay
					(4
						(Converse @local87 22 1 self 0) ; "I'm sorry, I was expecting silver. When I saw only the green--"
					)
					(7
						(Converse @local91 22 1 self 0) ; "I'm sorry, I expected the scroll. When I saw only the green--"
					)
				)
			)
			(6
				(Converse @local95 22 1 self) ; "Blessed Lady! How did you come by this?"
			)
			(7
				(self setScript: unite self)
			)
			(8
				(Converse @local107 22 1 self 0) ; "Did you create this?"
			)
			(9
				(switch gDay
					(4
						(Converse @local120 22 1 self) ; "I must go now. Be most careful in dealing with the monks. I'll pray for your success."
					)
					(7
						(Converse @local124 22 1 self) ; "I must go now. Be most careful when you come to the Fair. Beware of Prince John's spies!"
					)
				)
			)
			(10
				(if
					(or
						(and (== gDay 4) (not (gEgo has: 15))) ; comb
						(SetFlag 34)
					)
					(gCurRoom setScript: thereSheGoes)
				else
					(localproc_0)
				)
				(self dispose:)
			)
		)
	)
)

(instance thereSheGoes of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(marian setCycle: Walk setMotion: PolyPath 114 177 self)
			)
			(1
				(marian setMotion: PolyPath 110 245 self)
			)
			(2
				(= local2 (= local1 0))
				(marian dispose:)
				((gCurRoom obstacles:) delete: local432)
				(local432 dispose:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sex of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0004))
					(self setScript: disarm self)
					(= local430 4)
					(-- state)
					(return)
				)
				(gEgo
					setMotion:
						PolyPath
						(+ (marian x:) 21)
						(+ (marian y:) -5)
						self
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(Converse @local128 1 22 self) ; "Now that we've spoken of spies and danger, perhaps the sight of this stone will bring to mind more pleasant thoughts."
			)
			(4
				(marian
					view: 217
					loop: 7
					cel: 0
					posn: (- (gEgo x:) 18) (+ (gEgo y:) 3)
					cycleSpeed: 15
					setCycle: End self
				)
				(gEgo dispose:)
			)
			(5
				(marian x: (+ (marian x:) 15) loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(= ticks 100)
			)
			(7
				(marian setCycle: Beg self)
			)
			(8
				(= ticks 45)
			)
			(9
				(Converse @local143 22 0 self) ; "Take more than one kiss, my beloved. Take all I have to offer."
			)
			(10
				(= seconds 2)
			)
			(11
				(marian loop: 3 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(12
				(marian loop: 5 cel: 0 setCycle: CT 7 1 self)
			)
			(13
				(marian cycleSpeed: 35 setCycle: End self)
				(if (not (IsFlag 0))
					(Graph grFILL_BOX 0 0 192 320 2 0 0)
				)
			)
			(14
				(marian dispose:)
				(mHead init:)
				(rHead init:)
				(gCurRoom overlay: 216)
				(if (IsFlag 0)
					(Graph grFILL_BOX 0 0 192 320 2 0 0)
				)
				(= seconds 4)
			)
			(15
				(mHead setCycle: End)
				(rHead setCycle: End self)
			)
			(16
				(= ticks 60)
			)
			(17
				(for ((= register 98)) (>= register 0) ((-= register 2))
					(Palette palSET_INTENSITY 1 255 register)
					(Wait 4)
				)
				(gCurRoom drawPic: 803 7)
				(= gOverlays -1)
				(marian dispose:)
				(rHead dispose:)
				(mHead dispose:)
				(bow z: 1000)
				(quiver z: 1000 forceUpd:)
				(= cycles 3)
			)
			(18
				(Palette palSET_INTENSITY 1 255 100)
				(SetScore 50 120)
				(Say 1210 85 self) ; "Well, what did you expect? A man and maid deserve SOME privacy."
			)
			(19
				(gCurRoom drawPic: 210 10)
				(NormalEgo 1 702 703)
				(gEgo init: actions: egoActions)
				(marian
					view: 211
					loop: 0
					posn: 135 150
					init:
					ignoreActors: 1
					cycleSpeed: 6
					setCycle: StopWalk 212
				)
				(bow z: 0)
				(quiver z: 0 forceUpd:)
				(= cycles 2)
			)
			(20
				(Converse @local147 22 1 self) ; "Farewell for now, sweet Robin. May the Blessed Lady protect you!"
			)
			(21
				(client setScript: thereSheGoes self)
			)
		)
	)
)

(instance rHead of Prop
	(properties
		x 120
		y 73
		view 219
		priority 14
		signal 16400
		cycleSpeed 17
	)
)

(instance mHead of Prop
	(properties
		x 161
		y 87
		view 219
		loop 1
		priority 13
		signal 16400
		cycleSpeed 17
	)
)

(instance sit of Script
	(properties)

	(method (changeState newState &tmp [temp0 152])
		(switch (= state newState)
			(0
				(if local429
					(++ state)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 167 150 self)
				)
			)
			(1
				(= local429 0)
				(gEgo
					view: 510
					loop: 4
					cel: 3
					posn: 167 152
					setCycle: Beg self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance heal of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp [temp0 2] [temp2 150])
		(switch (= state newState)
			(0
				(HandsOff)
				(marian setScript: 0)
				(self setScript: sit self)
			)
			(1
				(if (IsFlag 143)
					(Say 1210 88 self) ; "The diamond! Somehow she's fooled her captors and kept it clutched within her hand!"
				else
					(Say 1210 86 self) ; "What's this she has clutched in her hand? 'Tis a diamond, shaped as half a heart the same as my emerald."
				)
			)
			(2
				(self setScript: unite self (if (IsFlag 143) 0 else 87))
			)
			(3
				(gSFX number: 210 loop: -1 play:)
				(Say 1210 89 self) ; "Blessed Lady, if love be stronger than death, let my love flow through these gems and heal her."
			)
			(4
				(= ticks 60)
			)
			(5
				(Converse @local163 1 22 self) ; "Oh, not the fire! Robin! Robin!"
			)
			(6
				(SetScore 300 62)
				(= seconds 2)
			)
			(7
				(Converse @local168 1 22 self 0) ; "I-I thought I was dead."
			)
			(8
				(GetFarText 1210 96 @temp2) ; "I cannot rest until I tell you. The Queen's Knight will know you when you spell out the word"
				(GetFarText 1317 (+ -10 global140) (+ @temp2 (StrLen @temp2)))
				(if ((= register (ScriptID 851 3)) underBits:) ; talker2
					(register say: @temp2 0 0 0 self)
				else
					(= cycles 1)
				)
			)
			(9
				(Converse @local175 1 22 self) ; "Your duty is fulfilled. Don't tax your strength further."
			)
			(10
				(marian loop: 2 cel: 8 setCycle: Beg self)
				(gEgo dispose:)
			)
			(11
				(gCurRoom drawPic: 803 6)
				(gCast eachElementDo: #dispose)
				(= ticks 60)
			)
			(12
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance dying of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1210 6 1) ; "Her breathing is painful, ragged. She could die at any moment!"
			)
			(3 ; Do
				(Say 1210 15 1) ; "I'm not a physician. I cannot heal her with my hands alone."
			)
			(4 ; Inventory
				(switch invItem
					(2 ; halfHeart
						(gCurRoom setScript: heal)
					)
					(10 ; fireRing
						(Say 1210 171 1) ; "The ring protected us from the flames, but it can do nothing to heal her."
					)
					(18 ; waterRing
						(Say 1210 178 1) ; "Alas, the ring has no power to heal."
					)
					(else
						(gDoVerbCode doit: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(Say 1210 250 1) ; "She cannot speak. She is dying!"
			)
			(else
				(gDoVerbCode doit: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance unite of TScript
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gGame setCursor: 5 1 310 185)
				(= local17 -1)
				(gEgo hide:)
				(marian hide:)
				(bow hide:)
				(quiver hide:)
				(gCurRoom drawPic: 215)
				((= local13 (Actor new:))
					view: 216
					loop: (== client heal)
					posn: 80 140
					signal: 18432
					init:
					setMotion: MoveTo 121 120 self
				)
				((= local14 (Actor new:))
					view: 216
					loop: 2
					posn: 250 142
					signal: 18432
					init:
					setMotion: MoveTo 210 122
				)
				(gSFX pause: 1)
				(gRgnMusic pause: 1)
				(joinSound play:)
			)
			(1
				(= local17 -2)
				(local13 addToPic:)
				(local14 addToPic:)
				((= local15 (Prop new:))
					view: 216
					loop: 3
					posn: 156 89
					priority: 9
					signal: 16400
					init:
					setCycle: End self
				)
			)
			(2
				(local15 setCycle: Beg self)
			)
			(3
				(= local17 -4)
				(local15 dispose:)
				(if register
					(Say 1210 register self)
				else
					(= ticks 180)
				)
			)
			(4
				(if (== (joinSound prevSignal:) -1)
					(= cycles 2)
				else
					(-- state)
					(= cycles 2)
				)
			)
			(5
				(gEgo show:)
				(marian show:)
				(bow show:)
				(quiver show:)
				(local13 dispose:)
				(local14 dispose:)
				(gCurRoom drawPic: 210 10)
				(gSFX pause: 0)
				(gRgnMusic pause: 0)
				(= cycles 1)
				(= local17 0)
			)
			(6
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if local17
			(Palette palANIMATE 224 254 local17)
		)
	)
)

(instance giveComb of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0004))
					(self setScript: disarm self)
					(= local430 4)
					(-- state)
					(return)
				)
				(marian signal: 16384)
				(gEgo
					setMotion:
						PolyPath
						(+ (marian x:) 28)
						(- (marian y:) 2)
						self
				)
			)
			(1
				(gEgo setLoop: 1)
				(marian loop: 0)
				(= ticks 30)
			)
			(2
				(marian hide:)
				(gEgo
					view: 215
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					posn: (- (gEgo x:) 7) (gEgo y:)
				)
				(= ticks 20)
			)
			(3
				(gEgo setCel: 1)
				(= ticks 20)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 7) (gEgo y:))
				(marian view: 215 loop: 4 cel: 3 show: setCycle: End self)
				(NormalEgo 1 702 703)
			)
			(5
				(marian view: 212 loop: 0)
				(= ticks 30)
			)
			(6
				(Converse @local180 1 22 self) ; "So you have spoken to Lobb! He wouldn't have given you this token unless you'd agreed to join us."
			)
			(7
				(SetScore 50 48)
				(if (IsFlag 47)
					(gCurRoom east: 160)
					(gCurRoom south: 160)
					(gCurRoom west: 160)
				)
				(gEgo put: 15) ; comb
				(marian signal: 0)
				(= local12 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance giveScroll of TScript
	(properties)

	(method (changeState newState &tmp [temp0 2] [temp2 150])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0004))
					(self setScript: disarm self)
					(= local430 4)
					(-- state)
					(return)
				)
				(= notKilled 1)
				(marian signal: 16384)
				(gEgo
					setMotion: PolyPath (+ (marian x:) 28) (marian y:) self
				)
			)
			(1
				(gEgo setLoop: 1)
				(marian loop: 0)
				(= ticks 20)
			)
			(2
				(marian hide:)
				(gEgo
					view: 215
					cycleSpeed: 6
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 8) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(3
				(SetScore 200)
				(marian
					view: 215
					posn: (- (gEgo x:) 15) (gEgo y:)
					loop: 2
					cel: 0
					show:
				)
				(gEgo posn: (+ (gEgo x:) 8) (- (gEgo y:) 1))
				(NormalEgo 1 702 703)
				(= cycles 20)
			)
			(4
				(Converse @local206 1 22 self 0) ; "You are so clever! Now, I have a gift of great importance to bestow upon you."
			)
			(5
				(Converse @local210 3 22 self 0) ; "A kiss?"
			)
			(6
				(Converse @local214 1 22 self) ; "Robin! Cease being a rogue for but a moment and watch closely."
			)
			(7
				(marian setCycle: End self)
			)
			(8
				(rustleSound play:)
				(self setScript: scrollCloseUp self)
			)
			(9
				(= notKilled 1)
				(Converse @local219 22 0 self) ; "Long ago the Druids devised this Hand Code. By touching the tip or a part of each finger, the thumb or the palm, you signify a certain letter."
			)
			(10
				(marian setCycle: Beg self)
				(rustleSound play:)
			)
			(11
				(marian hide:)
				(gEgo
					view: 215
					setLoop: 0
					setCel: 255
					posn: (- (gEgo x:) 8) (gEgo y:)
					setCycle: Beg self
				)
			)
			(12
				(gEgo posn: (+ (gEgo x:) 8) (gEgo y:))
				(marian
					view: 211
					posn: (- (gEgo x:) 28) (gEgo y:)
					loop: 0
					show:
					setCycle: StopWalk 212
				)
				(NormalEgo 1 702 703)
				(= ticks 30)
			)
			(13
				(Converse @local224 22 1 self) ; "The letters are branded in my mind. I close my eyes and see them still."
			)
			(14
				(if notKilled
					(cursMan init: setMotion: MoveTo 161 121 self)
					(= register 1)
				else
					(+= state 15)
					(= cycles 1)
				)
			)
			(15
				(= ticks 15)
			)
			(16
				(gEgo z: 1000)
				(gEgoHead z: 1000)
				(marian z: 1000)
				(bow z: 1000)
				(quiver z: 1000)
				(gCurRoom drawPic: 213 10 1 1)
				(= cycles 2)
			)
			(17
				(= register 0)
				(gGame setCursor: gTheCursor 1 305 190)
				(cursMan show: setMotion: MoveTo 202 93 self)
			)
			(18
				(= ticks 20)
			)
			(19
				(localproc_1 {R})
				(cursMan setMotion: MoveTo 160 98 self)
			)
			(20
				(= ticks 20)
			)
			(21
				(localproc_1 {O})
				(cursMan setMotion: MoveTo 127 94 self)
			)
			(22
				(= ticks 20)
			)
			(23
				(localproc_1 {B})
				(cursMan setMotion: MoveTo 199 102 self)
			)
			(24
				(= ticks 20)
			)
			(25
				(localproc_1 {I})
				(cursMan setMotion: MoveTo 209 74 self)
			)
			(26
				(= ticks 20)
			)
			(27
				(localproc_1 {N})
				(cursMan setMotion: MoveTo 174 122 self)
			)
			(28
				(= ticks 20)
			)
			(29
				(Display {} dsRESTOREPIXELS local424)
				(gCurRoom drawPic: 210 10)
				(gEgo z: 0)
				(gEgoHead z: 40)
				(marian z: 0)
				(bow z: 0)
				(quiver z: 0)
				(cursMan dispose:)
				(= cycles 2)
			)
			(30
				(Converse @local230 22 1 self 0) ; "Keep the scroll safe."
			)
			(31
				(Converse @local242 22 3 self 0) ; "Mayhap he will mingle freely enough, but you've said naught of how I shall perform this miracle."
			)
			(32
				(Converse @local256 22 1 self 0) ; "I'll take care not to endanger you."
			)
			(33
				(GetFarText 1210 156 @temp2) ; "Aye, and he'll be testing you as well. When you speak with him, you must ask him to show you the coat-of-arms of The"
				(GetFarText 1317 global123 (+ @temp2 (StrLen @temp2)))
				(SetMessageColor 9)
				((= register (ScriptID 851 2)) show: say: @temp2 0 0 0 self) ; talker1
				(SetMessageColor 0)
			)
			(34
				(if (not notKilled)
					(register dispose:)
				)
				(Converse @local261 22 1 self 0) ; "He'll open his book and show you coats-of-arms. You must be sure he shows you the right one."
			)
			(35
				(Converse @local266 22 3 self 0) ; "And after the fair, shall I meet you here again? Or will you come to my camp and meet my men?"
			)
			(36
				(Converse @local275 22 1 self) ; "I know the grove and the oak well. You seem most anxious about this."
			)
			(37
				(marian signal: 0)
				(= local12 0)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance scrollCloseUp of Script
	(properties)

	(method (doit)
		(if (and local0 (== (letterSound prevSignal:) -1))
			(gRgnMusic pause: 0)
			(gSFX pause: 0)
			(= local0 0)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(letterSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo z: 1000)
				(gEgoHead z: 1000)
				(marian z: 1000)
				(bow z: 1000)
				(quiver z: 1000)
				(gCurRoom drawPic: 211 6)
				(= cycles 2)
			)
			(1
				(= ticks 75)
			)
			(2
				((= register (Actor new:))
					view: 208
					loop: 0
					cel: 2
					x: 158
					y: 118
					cycleSpeed: 35
					init:
					setCycle: Beg self
				)
			)
			(3
				(gSFX pause: 1)
				(gRgnMusic pause: 1)
				(= local0 1)
				(letterSound play:)
				(= seconds 5)
			)
			(4
				(register setCycle: End self)
			)
			(5
				(register dispose:)
				(= ticks 30)
			)
			(6
				(gCurRoom drawPic: 210 6)
				(gEgo z: 0)
				(gEgoHead z: 40)
				(marian z: 0)
				(bow z: 0)
				(quiver z: 0)
				(= cycles 2)
			)
			(7
				(SetFlag 34)
				(self dispose:)
			)
		)
	)
)

(instance cursMan of Actor
	(properties
		yStep 4
		view 182
		loop 1
		priority 15
		signal 18584
		illegalBits 0
		xStep 4
		moveSpeed 3
	)

	(method (init)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super init:)
		(= signal 18584)
	)

	(method (doit)
		(super doit: &rest)
		(if (giveScroll register:)
			(SetCursor 2 1 x y)
		)
	)
)

(instance giveFScroll of TScript
	(properties)

	(method (changeState newState &tmp [temp0 152])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0004))
					(self setScript: disarm self)
					(= local430 4)
					(-- state)
					(return)
				)
				(= notKilled 1)
				(gEgo
					setMotion: PolyPath (+ (marian x:) 28) (marian y:) self
				)
			)
			(1
				(Face gEgo marian)
				(marian loop: 0)
				(= ticks 20)
			)
			(2
				(marian
					view: 215
					loop: 4
					setCel: 255
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(3
				(cond
					((gEgo has: 10) ; fireRing
						(Converse @local323 1 22 self) ; "These are most interesting verses. I know this hand."
						(gEgo put: 16) ; fulkScroll
					)
					(local10
						(Converse 1 @local319 22 3 self) ; "I can make no sense of his doggerel. I wish you luck in deciphering it."
					)
					(1
						(= local10 1)
						(Converse @local310 1 22 self) ; "These are most interesting verses. I know this hand."
					)
				)
			)
			(4
				(if (gEgo has: 10) ; fireRing
					(gEgo put: 16) ; fulkScroll
					(marian setCycle: CT 2 1 self)
				else
					(marian setCycle: End self)
				)
			)
			(5
				(marian
					view: 211
					posn: (- (gEgo x:) 28) (gEgo y:)
					loop: 0
					show:
					setCycle: StopWalk 212
				)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance tryBlowinIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gDay 10)
					(Say 1210 241 self) ; "My men are scattered and some may still be fighting. It would be futile to wind my horn, perhaps even dangerous."
					(= local2 0)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(1
				(localproc_0)
				(self dispose:)
			)
			(2
				(if (= register (gCast contains: marian))
					(Converse 1 @local399 22 3 self) ; "Surely you don't mean to wind that horn here?"
				else
					(Say 1210 240 self) ; "I cannot bring myself to shatter the silence of this sacred grove."
				)
			)
			(3
				(= cycles 1)
				(if (not register)
					(++ state)
				)
			)
			(4
				(Converse @local403 1 0 self) ; "Your pardon, Marian. Since it disturbs you, I will not."
			)
			(5
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(4 ; Inventory
					(if (== invItem 1) ; horn
						(gCurRoom setScript: tryBlowinIt)
						1
					)
				)
				(3 ; Do
					(if (IsFlag 34)
						(gCurRoom setScript: waitForIt)
					)
				)
			)
		)
	)
)

(instance waitForIt of Script
	(properties)

	(method (doit)
		(if (IsFlag 110)
			(ClearFlag 110)
			(client setScript: willowTalk)
		)
	)
)

(instance willowTalk of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((gCast contains: marian)
						(if (== gDay 7)
							(++ local1)
							(= state 4)
							(= register
								(cond
									((>= local1 5) @local441)
									((== global124 55) @local433)
									(1 @local437)
								)
							)
						else
							(= state 2)
							(if (== global124 19)
								(++ state)
								(= register @local482)
							)
						)
					)
					((or (!= global124 19) (not (IsFlag 35)) (!= gDisguiseNum 0)) ; outlaw
						(self dispose:)
						(localproc_0)
						(return)
					)
					(local1
						(= register @local457)
						(= state 3)
					)
					(1
						(= local1 1)
						(switch gDay
							(7
								(= register
									(cond
										((IsFlag 120) @local467)
										((IsFlag 143) @local461)
										(1 @local452)
									)
								)
							)
							(8
								(= register @local473)
							)
							(9
								(= register @local473)
							)
							(10
								(= register @local478)
								(= state 3)
							)
							(else
								(if (IsFlag 5)
									(client setScript: spillBeans)
								else
									(= register @local486)
									(= state 3)
								)
							)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(Converse @local445 @local507 999 self 0) ; "What would you ask of us?"
			)
			(2
				(Converse register @local507 999 self)
			)
			(3
				(self dispose:)
				(localproc_0)
			)
			(4
				(-= state 2)
				(Converse 1 register @local507 0 self)
			)
			(5
				(-= state 3)
				(Converse register 22 0 self)
			)
		)
	)
)

(instance spillBeans of TScript
	(properties)

	(method (changeState newState &tmp [temp0 30])
		(switch (= state newState)
			(0
				(Converse @local490 @local507 999 self 0) ; "Did Marian whisper a password to you?"
			)
			(1
				(= [local496 1] (+ -10 global140))
				(Converse @local496 @local507 999 self) ; "LIONS."
				(SetFlag 51)
			)
			(2
				(self dispose:)
				(localproc_0)
			)
		)
	)
)

(instance rustleSound of Sound
	(properties
		flags 1
		number 633
	)
)

(instance joinSound of Sound
	(properties
		flags 1
		number 212
	)
)

(instance letterSound of Sound
	(properties
		flags 1
		number 214
	)
)

(instance willows of Feature
	(properties
		onMeCheck 8
		lookStr 8 ; "The willows form a living, green temple."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(if (== (marian script:) waitToDie)
				(Say 1210 11) ; "The willow's medicine can cure many ills, but Marian's injury is beyond their power."
			else
				(Say 1210 10) ; "There is nothing I would take from the willows."
			)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance ferns of Feature
	(properties
		onMeCheck 16
		lookStr 9 ; "The ferns are fresh and lush."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(if (== (marian script:) waitToDie)
				(Say 1210 13) ; "There's nothing in them that can save Marian."
			else
				(Say 1210 12) ; "I've no need to pick ferns."
			)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

