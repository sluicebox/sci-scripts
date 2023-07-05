;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	[local0 100]
	local100
	[local101 22]
	[local123 160] = [113 121 107 129 72 129 82 121 139 129 107 129 113 121 141 121 173 129 139 129 142 121 172 121 206 129 174 129 173 121 203 121 243 129 207 129 204 121 235 121 101 139 61 139 70 130 108 130 135 139 101 139 109 129 138 130 176 139 136 139 139 130 174 130 215 139 178 139 174 130 207 130 253 139 215 139 209 130 245 130 99 140 89 154 45 154 61 140 131 154 90 154 100 139 135 140 179 154 132 154 136 139 178 140 225 154 181 154 178 139 216 140 277 154 226 154 217 140 257 140 76 171 27 168 45 154 87 155 126 169 77 170 89 155 130 155 181 166 127 169 131 155 180 155 241 171 182 165 181 155 226 155 292 166 241 171 227 155 278 155]
	[local283 20] = [91 121 156 189 222 77 115 156 194 231 69 111 159 202 244 59 105 162 212 262]
	[local303 20] = [123 123 123 123 123 134 134 134 134 134 146 146 146 146 146 166 166 166 166 166]
	[local323 20] = [1 1 4 1 3 4 2 3 4 2 0 4 5 2 0 1 3 2 5 2]
	[local343 20] = [0 8 0 0 0 9 0 7 0 3 10 0 6 4 2 0 0 5 0 0]
	[local363 20] = [5 6 6 7 8 10 10 11 12 8 0 10 11 12 13 10 10 11 12 18]
	[local383 20] = [6 7 8 8 9 6 7 13 14 14 11 12 13 14 0 16 12 13 14 14]
	local403
	local404
	local405
	local406
	[local407 16] = [104 0 1 91 78 92 124 155 186 220 236 0 0 0 8 6]
	[local423 16] = [115 0 1 102 70 85 120 155 189 225 240 1 0 0 9 6]
	[local439 16] = [127 0 1 114 50 74 115 155 196 237 268 2 0 0 12 6]
	[local455 16] = [147 0 1 134 26 58 107 155 205 253 290 3 0 0 13 6]
	[local471 16] = [104 1 0 91 236 220 186 155 124 92 78 0 0 0 8 6]
	[local487 16] = [115 1 0 102 240 225 189 155 120 85 70 1 0 0 9 6]
	[local503 16] = [127 1 0 114 268 237 196 155 115 74 50 2 0 0 12 6]
	[local519 16] = [147 1 0 134 290 253 205 155 107 58 26 3 0 0 13 6]
	local535
	[local536 4]
	local540
)

(procedure (localproc_0 param1 param2 param3 param4)
	(if
		(and
			(== (- param1 32) param3)
			(== param2 (gEgo x:))
			(<= (- param4 10) param2 (+ param4 10))
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 20) ((++ temp0))
		((= [local101 temp0] (aTile new:))
			x: [local283 temp0]
			y: [local303 temp0]
			tileType: [local323 temp0]
			tileCheck: [local343 temp0]
			tilePointer: temp0
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init:
						[local123 (* temp0 8)]
						[local123 (+ (* temp0 8) 1)]
						[local123 (+ (* temp0 8) 2)]
						[local123 (+ (* temp0 8) 3)]
						[local123 (+ (* temp0 8) 4)]
						[local123 (+ (* temp0 8) 5)]
						[local123 (+ (* temp0 8) 6)]
						[local123 (+ (* temp0 8) 7)]
					yourself:
				)
			init:
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 20) ((++ temp0))
		([local101 temp0] dispose:)
	)
)

(procedure (localproc_3)
	(SetFlag 95)
	(gGame givePoints: 3)
)

(instance rm410 of KQ6Room
	(properties
		noun 2
		picture 410
		style 10
		east 400
		west 400
		walkOffEdge 1
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 232 123 83 123 69 134 81 136 73 144 0 144 0 0 319 0 319 146 242 146 236 138 245 134
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 66 151 46 163 27 165 5 184 298 185 307 185 283 166 263 162 249 152 319 152 319 189 0 189 0 151
					yourself:
				)
		)
		(gGame handsOn:)
		(super init: &rest)
		(if (== ((ScriptID 30 0) prevEdgeHit:) 2) ; rLab
			(= local404 10)
			(= local403 10)
		else
			(= local404 14)
			(= local403 2)
		)
		((ScriptID 30 0) cue:) ; rLab
		(if (not (IsFlag 1))
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
		)
		(localproc_1)
		((ScriptID 30 3) init:) ; theTorch
		(door init:)
		(backOfDoors init:)
		(hall init:)
		(gCurRoom setScript: egoEnters)
	)

	(method (dispose)
		(if (not (IsFlag 1))
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(& (event type:) $0044) ; direction | evKEYBOARD
					(or
						(== (event message:) JOY_UP)
						(== (event message:) JOY_UPRIGHT)
						(== (event message:) JOY_RIGHT)
						(== (event message:) JOY_DOWNRIGHT)
						(== (event message:) JOY_DOWN)
						(== (event message:) JOY_DOWNLEFT)
						(== (event message:) JOY_LEFT)
						(== (event message:) JOY_UPLEFT)
					)
				)
				(and
					(User canInput:)
					(!= (event type:) evVERB)
					(not (event modifiers:))
					(or (== (event message:) KEY_RETURN) (== (event type:) evMOUSEBUTTON))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				)
			)
			(event claimed: 1)
		else
			(event claimed: 0)
		)
		(event claimed:)
	)

	(method (doit &tmp temp0)
		(if (IsFlag 1)
			(cond
				((gCurRoom script:))
				((== (gEgo onControl: 1) 8192)
					((ScriptID 30 0) prevEdgeHit: EDGE_RIGHT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
				((== (gEgo onControl: 1) 16384)
					((ScriptID 30 0) prevEdgeHit: EDGE_LEFT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
			)
		)
		(super doit:)
	)

	(method (scriptCheck)
		(gMessager say: 0 0 154 1 0 899) ; "Alexander decides he should concentrate on the room's tiles and try that later!"
		(return 0)
	)
)

(instance aSpike of View
	(properties
		view 412
		loop 4
		signal 18432
	)
)

(instance aSandBlast of Prop
	(properties
		view 412
		signal 16384
	)

	(method (cue)
		(self dispose:)
	)
)

(class FloorTile of Feature
	(properties
		tileType 0
		tilePointer 0
		tileCheck 0
		script 0
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 1))
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
		)
	)

	(method (dispose)
		(if (not (IsFlag 1))
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch tileType
					(0
						(gMessager say: 10 1 0 1) ; "The tiles directly in front of the exit doors do not bear any symbols."
					)
					(1
						(gMessager say: 4 1 0 1) ; "That tile bears the image of a dove."
					)
					(2
						(gMessager say: 3 1 0 1) ; "An image of a rose has been carved into that tile."
					)
					(3
						(gMessager say: 5 1 0 1) ; "That tile bears an engraving of a crown."
					)
					(4
						(gMessager say: 6 1 0 1) ; "That tile is engraved with a skull and crossbones."
					)
					(5
						(gMessager say: 7 1 0 1) ; "A carving of a scythe adorns that tile."
					)
				)
			)
			(5 ; Do
				(gMessager say: 3 5 0 1) ; "Alexander can see nothing to do with the tiles except to walk on them and hope for the best!"
			)
			(2 ; Talk
				(gMessager say: 3 2 0 1) ; "The tiles will not give up their secrets so easily."
			)
			(else
				(gMessager say: 3 0 0 1) ; "Using that on the tiles would accomplish nothing."
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(or
					(and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
					(== (event type:) evMOUSEBUTTON)
				)
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(self onMe: event)
			)
			(event claimed: 1)
			(= local405 local404)
			(= local404 (self tilePointer:))
			(gCurRoom setScript: goToTile 0 [local101 (self tilePointer:)])
		else
			(super handleEvent: event)
		)
	)
)

(instance goToTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((and (== local405 10) (== local404 14))
						(= register [local101 11])
					)
					((and (== local405 14) (== local404 10))
						(= register [local101 13])
					)
				)
				(if (!= local404 local405)
					(gEgo
						setMotion: PolyPath (register x:) (register y:) self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (not (== local404 local405))
					(if (== (register tileCheck:) (- local403 1))
						(-- local403)
					else
						(++ local403)
					)
				)
				(if
					(or
						(== (register tileCheck:) local403)
						(== local404 local405)
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound4 number: 300 setLoop: 1 play: self)
			)
			(3
				(gMessager say: 2 3 5 1 self) ; "Alexander feels the tile he's standing on shift beneath his feet."
			)
			(4
				(gMessager say: 2 3 5 2 self) ; "Uh, oh!"
			)
			(5
				(client setScript: fireAllSpikes 0 register)
			)
		)
	)
)

(instance aTile of FloorTile
	(properties)
)

(instance backOfDoors of Feature
	(properties
		noun 2
	)

	(method (init)
		(self setOnMeCheck: 1 2 4)
		(super init: &rest)
		(if (not (IsFlag 1))
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
		)
	)

	(method (dispose)
		(if (not (IsFlag 1))
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(or (== (event message:) KEY_RETURN) (== (event type:) evMOUSEBUTTON))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(self onMe: event)
			)
			(cond
				((and (gEgo inRect: 59 140 86 153) (< gMouseX 165))
					(event claimed: 1)
					(if
						(and
							(not (IsFlag 95))
							(== ((ScriptID 30 0) prevEdgeHit:) 4) ; rLab
						)
						(localproc_3)
					)
					((ScriptID 30 0) prevEdgeHit: EDGE_LEFT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
				((and (gEgo inRect: 229 142 261 151) (> gMouseX 165))
					(event claimed: 1)
					(if
						(and
							(not (IsFlag 95))
							(== ((ScriptID 30 0) prevEdgeHit:) 2) ; rLab
						)
						(localproc_3)
					)
					((ScriptID 30 0) prevEdgeHit: EDGE_RIGHT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
				((and (not (gEgo inRect: 229 142 261 151)) (> gMouseX 165))
					(event claimed: 1)
					(= local406 1)
					(gCurRoom setScript: doorDeathMsgPause 0 2)
				)
				((and (not (gEgo inRect: 59 140 86 153)) (< gMouseX 165))
					(event claimed: 1)
					(= local406 1)
					(gCurRoom setScript: doorDeathMsgPause 0 4)
				)
				(else
					(event claimed: 0)
					(gCurRoom handleEvent: event)
				)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance door of Feature
	(properties
		noun 8
	)

	(method (init)
		(self setOnMeCheck: 1 8 16384 128 8192)
		(super init: &rest)
		(if (not (IsFlag 1))
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
		)
	)

	(method (dispose)
		(if (not (IsFlag 1))
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(or (== (event message:) KEY_RETURN) (== (event type:) evMOUSEBUTTON))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(self onMe: event)
			)
			(cond
				((and (gEgo inRect: 59 140 86 153) (< gMouseX 165))
					(event claimed: 1)
					(if
						(and
							(not (IsFlag 95))
							(== ((ScriptID 30 0) prevEdgeHit:) 4) ; rLab
						)
						(localproc_3)
					)
					((ScriptID 30 0) prevEdgeHit: EDGE_LEFT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
				((and (gEgo inRect: 229 142 261 151) (> gMouseX 165))
					(event claimed: 1)
					(if
						(and
							(not (IsFlag 95))
							(== ((ScriptID 30 0) prevEdgeHit:) 2) ; rLab
						)
						(localproc_3)
					)
					((ScriptID 30 0) prevEdgeHit: EDGE_RIGHT) ; rLab
					(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
				)
				((and (not (gEgo inRect: 229 142 261 151)) (> gMouseX 165))
					(event claimed: 1)
					(= local406 1)
					(gCurRoom setScript: doorDeathMsgPause 0 2)
				)
				((and (not (gEgo inRect: 59 140 86 153)) (< gMouseX 165))
					(event claimed: 1)
					(= local406 1)
					(gCurRoom setScript: doorDeathMsgPause 0 4)
				)
				(else
					(event claimed: 0)
					(gCurRoom handleEvent: event)
				)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance hall of Feature
	(properties
		noun 2
		nsBottom 189
		nsRight 319
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== ((ScriptID 30 0) prevEdgeHit:) 2) ; rLab
					(gEgo
						posn: 10 146
						init:
						actions: egoDoVerb
						illegalBits: 0
						ignoreActors:
						setScale: Scaler 100 99 190 0
						setMotion: PolyPath 69 146 self
					)
				else
					(gEgo
						posn: 310 146
						init:
						actions: egoDoVerb
						illegalBits: 0
						ignoreActors:
						setScale: Scaler 100 99 190 0
						setMotion: PolyPath 244 146 self
					)
				)
			)
			(1
				(if (== ((ScriptID 30 0) prevEdgeHit:) 2) ; rLab
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gGame handsOn:)
				(gTheIconBar enable: 6)
				(self dispose:)
			)
		)
	)
)

(instance doorDeathMsgPause of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 3 7 1 self) ; "Alexander decides to make a beeline for the exit from his current location."
			)
			(1
				(for ((= temp0 0)) (< temp0 20) ((++ temp0))
					(if (== local404 temp0)
						(if (== register 2)
							(= local100 [local383 temp0])
						else
							(= local100 [local363 temp0])
						)
					)
				)
				(cond
					((and (== register 2) (== local404 9))
						(= local100 9)
					)
					((and (== register 4) (== local404 5))
						(= local100 5)
					)
				)
				(gEgo
					setMotion:
						MoveTo
						([local101 local100] x:)
						([local101 local100] y:)
						self
				)
			)
			(2
				(= cycles 8)
			)
			(3
				(gGlobalSound4 number: 300 setLoop: 1 play:)
				(gMessager say: 2 3 5 1 self) ; "Alexander feels the tile he's standing on shift beneath his feet."
			)
			(4
				(if (== register 2)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(= cycles 10)
			)
			(5
				(gCurRoom setScript: fireAllSpikes 0 [local101 local100])
			)
		)
	)
)

(instance fireAllSpikes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 135)
					(switch local540
						(0
							(= local535 @local407)
						)
						(1
							(= local535 @local455)
						)
						(2
							(= local535 @local423)
						)
						(else
							(= local535 @local439)
						)
					)
				else
					(switch local540
						(0
							(= local535 @local471)
						)
						(1
							(= local535 @local519)
						)
						(2
							(= local535 @local487)
						)
						(else
							(= local535 @local503)
						)
					)
				)
				(Memory memPOKE (+ local535 24) (register y:))
				(Memory memPOKE (+ local535 26) (register x:))
				((aSandBlast new:)
					x: (WordAt local535 4)
					y: (WordAt local535 0)
					setLoop: (WordAt local535 1)
					cel: 1
					init:
					setScript: (aSpikeScript new:) 0 local535
				)
				(= ticks (Random 2 6))
			)
			(1
				(if (< (++ local540) 4)
					(-= state 2)
				)
				(self cue:)
			)
			(2
				(gGlobalSound3 number: 410 setLoop: 1 play:)
				(localproc_2)
				(self dispose:)
			)
		)
	)
)

(instance aSpikeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 4)
			)
			(1
				(client cel: 2)
				(if
					(localproc_0
						(WordAt register 12)
						(WordAt register 13)
						(WordAt register 3)
						(WordAt register 5)
					)
					(gCurRoom setScript: killEgo)
					(client setCycle: End client)
				else
					((= [local536 (WordAt register 11)] (aSpike new:))
						x: (WordAt register 5)
						y: (WordAt register 3)
						cel: (WordAt register 2)
						setPri: (WordAt register 14)
						setLoop: 4
						init:
					)
					(= ticks 4)
				)
			)
			(2
				(client cel: (+ (client cel:) 1))
				(if
					(localproc_0
						(WordAt register 12)
						(WordAt register 13)
						(WordAt register 3)
						(WordAt register (WordAt register 15))
					)
					(gCurRoom setScript: killEgo)
					([local536 (WordAt register 11)] dispose:)
					(client setCycle: End client)
				else
					([local536 (WordAt register 11)]
						x: (WordAt register (WordAt register 15))
					)
					(= ticks 4)
				)
			)
			(3
				(Memory memPOKE (+ register 30) (+ (WordAt register 15) 1))
				(if (< (WordAt register 15) 9)
					(-= state 2)
				)
				(self cue:)
			)
			(4
				([local536 (WordAt register 11)] x: (WordAt register 10))
				(= ticks 4)
			)
			(5
				(client dispose:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if local406
					(gMessager say: 2 3 7 2 self) ; "Apparently, not a good idea."
				else
					(self cue:)
				)
			)
			(1
				(gGlobalSound stop:)
				(gGlobalSound4 number: 411 setLoop: 1 play:)
				(cond
					((and (< (gEgo x:) 135) (< (gEgo heading:) 180))
						(= temp0 1)
						(= temp1 30)
						(= temp2 5)
					)
					((and (< (gEgo x:) 135) (>= (gEgo heading:) 180))
						(= temp0 2)
						(= temp1 21)
						(= temp2 6)
					)
					((and (>= (gEgo x:) 135) (< (gEgo heading:) 180))
						(= temp0 3)
						(= temp1 -20)
						(= temp2 7)
					)
					(else
						(= temp0 0)
						(= temp1 -28)
						(= temp2 3)
					)
				)
				(gEgo
					view: 411
					normal: 0
					cel: 0
					cycleSpeed: 2
					setLoop: temp0
					posn: (+ (gEgo x:) temp1) (+ (gEgo y:) temp2)
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(EgoDead 37) ; "Three spikes and you're out!"
				(self dispose:)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(return 0)
			)
			(5 ; Do
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(else
				(gMessager say: 0 0 154 1 0 899) ; "Alexander decides he should concentrate on the room's tiles and try that later!"
				(return 1)
			)
		)
	)
)

