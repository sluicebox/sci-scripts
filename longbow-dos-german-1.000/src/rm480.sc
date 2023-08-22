;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use StdRoom)
(use rhEgo)
(use RTEyeCycle)
(use PPath)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	local0
	local1
	[local2 9] = [330 169 250 174 208 188 208 238 -32768]
	[local11 17] = [-10 175 12 169 79 165 122 152 202 152 257 168 312 168 330 175 -32768]
	[local28 11] = [134 238 134 188 109 188 12 169 -10 175 -32768]
	[local39 7] = [23 163 23 156 54 145 -32768]
	[local46 7] = [296 163 296 156 267 145 -32768]
	[local53 5] = [1480 17 1 0 0]
	[local58 5] = [1480 0 1 0 0]
	[local63 5] = [1480 1 1 0 0]
	[local68 5] = [1480 2 1 0 0]
)

(instance rm480 of StdRoom
	(properties
		picture 480
		east 450
		south 450
		west 450
	)

	(method (init)
		(self setRegions: 452) ; abbey
		(= local0 (ScriptID 452 1)) ; aMonk
		(NormalEgo 3)
		(if (== gPrevRoomNum 45) ; hedge4
			(self setScript: arrived)
		else
			(gEgo edgeHit: EDGE_TOP)
			(gEgo x: 105 y: 188)
		)
		(super init:)
		(if (!= (gRgnMusic number:) 455)
			(gRgnMusic number: 455 loop: -1 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 1 319 161 257 165 208 146 119 146 64 162 41 164 0 158 0 1
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 79 180 86 167 230 167 236 180
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 109 188 111 181 201 181 205 188
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 93 189 0 189 0 171 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 213 189 306 166 307 179 319 179 319 189
					yourself:
				)
		)
		(gEgo illegalBits: 0)
		(lDoor init:)
		(rDoor init:)
		(ceiling init:)
		(altar init:)
		(reliquary init:)
		(windows init:)
		(pews init:)
		(book init:)
		(chapel init:)
		(if (IsFlag 95)
			(lDoor lookStr: 10)
			(rDoor lookStr: 10)
		)
		(if (== gDay 10)
			(ClearFlag 99)
		else
			(lDoor setScript: monks)
		)
		(gEgo actions: (ScriptID 452 3)) ; noBlow
	)

	(method (dispose)
		(DisposeScript 852)
		(DisposeScript 927)
		(super dispose:)
	)
)

(instance arrived of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo edgeHit: EDGE_NONE)
				(NormalEgo 2)
				(if (> (gEgo x:) 227)
					(= register @local46)
					(rDoor setCel: (rDoor lastCel:))
				else
					(= register @local39)
					(lDoor setCel: (lDoor lastCel:))
				)
				(gEgo
					x: (WordAt register 4)
					y: (WordAt register 5)
					setMotion: PPath register 1 0 self
				)
			)
			(1
				(NormalEgo 2)
				(if (== register @local46)
					(rDoor
						signal: (& (rDoor signal:) $feff)
						startUpd:
						setCycle: Beg self
					)
				else
					(lDoor startUpd: setCycle: Beg self)
				)
			)
			(2
				(doorSound number: 938 play:)
				(if (== register @local46)
					(rDoor signal: (| (rDoor signal:) $0100) stopUpd:)
				else
					(lDoor stopUpd:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance monks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds
					(if (or (== gDay 5) (== gDay 6))
						(Random 15 30)
					else
						(Random 4 8)
					)
				)
			)
			(1
				(if (gCurRoom script:)
					(= state -1)
					(= cycles 1)
				else
					(= register
						(switch (Random 1 3)
							(1
								@local2
							)
							(2
								@local11
							)
							(3
								@local28
							)
						)
					)
					(local0
						init:
						posn: (WordAt register 0) (WordAt register 1)
						setCycle: SyncWalk
						setAvoider: PAvoider
						setMotion: PPath (+ register 4) self
						actions: wanderVerbs
					)
				)
			)
			(2
				(local0 dispose: actions: 0)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance wanderVerbs of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Talk
			(Converse @local53 10) ; "Shhhh."
			(return 1)
		)
		(return 0)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: PAvoider
					setMotion: PolyPath (register x:) 163 self
				)
				(local0 setAvoider: 0)
			)
			(1
				(if (or (gCast contains: local0) (IsFlag 99))
					(cond
						((IsFlag 99)
							(= state 9)
						)
						((IsFlag 98)
							(SetFlag 99)
							(= state 7)
						)
						((IsFlag 97)
							(SetFlag 98)
							(= state 3)
						)
						(else
							(SetFlag 97)
							(= state 3)
						)
					)
					(= cycles 1)
				else
					(register signal: 24582 setCycle: End self)
				)
			)
			(2
				(doorSound number: 937 play:)
				(if (== register lDoor)
					(gEgo setMotion: PPath @local39 1 2 self)
				else
					(gEgo setMotion: PPath @local46 1 2 self)
				)
			)
			(3
				(SetScore 10 95)
				(gCurRoom newRoom: 45) ; hedge4
			)
			(4
				(= local1 (local0 mover:))
				(local0 ignoreActors: 1 mover: 0)
				(Face local0 gEgo)
				(= cycles 1)
			)
			(5
				(Converse @local58 10 0 self) ; "Brother, you're not allowed to go there! Return to your devotions."
			)
			(6
				(gEgo setMotion: PolyPath 159 189 self)
			)
			(7
				(Face local0 gEgo)
				(gEgo setMotion: MoveTo 159 188 self)
			)
			(8
				(= seconds 2)
			)
			(9
				(local0 ignoreActors: 0 mover: local1)
				(Face local0 local1)
				(HandsOn)
				(self dispose:)
			)
			(10
				(local0 ignoreActors: 1 setMotion: 0)
				(Face local0 gEgo)
				(Converse @local63 10 0 self) ; "Haven't you been warned before about this trespass, Brother? Go to your cell and pray for the Blessed Virgin to give you an ounce of common sense."
			)
			(11
				(gEgo setMotion: PolyPath 108 190)
				(self dispose:)
			)
			(12
				(Converse @local68 999 0 self) ; "Curse that Monk! He's locked the door."
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lDoor of Prop
	(properties
		x 41
		y 159
		lookStr 9 ; "This door should lead to someplace outside the Abbey."
		view 480
		priority 10
		signal 26641
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(gCurRoom setScript: openDoor 0 self)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance rDoor of Prop
	(properties
		x 282
		y 160
		lookStr 9 ; "This door should lead to someplace outside the Abbey."
		view 480
		loop 1
		priority 11
		signal 26897
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(gCurRoom setScript: openDoor 0 self)
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance ceiling of Feature
	(properties
		onMeCheck 8
		lookStr 4 ; "The devotional scenes painted upon the ceiling remind me that this has always been a sacred place, long before a church was even built here."
	)
)

(instance altar of Feature
	(properties
		x 156
		y 184
		onMeCheck 16
		lookStr 5 ; "'Tis the altar, with the Holy Book upon it."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(Say 1480 14) ; "I dare not lay my profane hands upon such a sacred object."
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance reliquary of Feature
	(properties
		x 156
		y 174
		onMeCheck 128
		lookStr 6 ; "This magnificent, gilded and bejewelled reliquary holds a sliver of the True Cross which legend says was brought back from Jerusalem by King Arthur."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(super doVerb: theVerb)
		else
			(altar doVerb: theVerb invItem)
		)
	)
)

(instance windows of Feature
	(properties
		y 146
		onMeCheck 2
		lookStr 7 ; "The windows are most beautiful. Their coloured light uplifts my soul."
	)

	(method (onMe param1 param2)
		(if (IsObject param1)
			(= x (if (< (param1 x:) 160) 94 else 288))
		)
		(return (super onMe: param1 param2))
	)
)

(instance pews of Feature
	(properties
		onMeCheck 256
		lookStr 8 ; "They've put in wooden pews, I see. I guess the Monks grew tired of kneeling upon a stone floor."
	)

	(method (onMe param1 param2 &tmp temp0)
		(if (IsObject param1)
			(= x (param1 x:))
			(= y (+ (param1 y:) 10))
		)
		(return (super onMe: param1 param2))
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(Say 1480 15) ; "Perhaps one day I will sit here in peace."
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance book of Feature
	(properties
		x 156
		y 184
		onMeCheck 32
		lookStr 13 ; "The scriptures are laid open upon the altar."
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(Say 1480 14) ; "I dare not lay my profane hands upon such a sacred object."
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance chapel of Feature
	(properties
		onMeCheck 1
		lookStr 11 ; "The Abbot may be corrupt, but he has helped to rebuild a magnificent chapel."
	)
)

(instance doorSound of Sound
	(properties
		flags 1
	)
)

