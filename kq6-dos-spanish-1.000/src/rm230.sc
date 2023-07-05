;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use KQ6Print)
(use KQ6Room)
(use CartoonScript)
(use n913)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm230 0
)

(local
	local0
	local1
)

(instance rm230 of KQ6Room
	(properties
		noun 3
		picture 230
		horizon 0
		north 220
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 81 250 81 250 63 232 62 232 73 202 79 165 97 112 126 105 133 62 148 47 148 0 156
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 171 115 250 115 236 126 182 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 161 182 168 187 192 180 319 165 319 189 0 189 0 170 64 182
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 325 90 325 158 317 158 317 90
					yourself:
				)
		)
		(super init: &rest)
		(gEgo init: setScale: Scaler 100 58 140 58)
		(self setScript: enterRoomScr)
		(castleWall init:)
		(vine init:)
		(bush init:)
		(if (>= (gGame _detailLevel:) 2)
			(bush setScript: (ScriptID 13 0)) ; windScr
		)
		(if (IsFlag 23)
			(magicDoor init:)
			(if (IsFlag 24)
				(magicDoor view: 233 loop: 8 cel: 0)
			)
		)
		(if (== ((gInventory at: 18) owner:) gCurRoomNum) ; holeInTheWall
			(holeOnWall init:)
		)
		(genericFeatures init:)
		((ScriptID 10 4) onMeCheck: 136 init:) ; rocks
		(gGlobalSound2 number: 917 loop: -1 play:)
	)

	(method (notify)
		(gCurRoom setScript: enchantDoorScr)
	)

	(method (edgeToRoom param1)
		(if (== param1 2)
			(gEgo x: (- (gEgo x:) 1))
			(gMessager say: 3 3 15 1) ; "That way is blocked by heavy foliage."
			(return 0)
		else
			(super edgeToRoom: param1 &rest)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom setScript: exitRoomScr)
			)
			((and (& temp0 $0080) (not local0) (gEgo isStopped:))
				(= local0 1)
				(gMessager say: noun 3 12) ; "The narrow path ends abruptly at a pile of boulders."
			)
			((and local0 (& temp0 $0080) (not (gEgo isStopped:)))
				(= local0 0)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gGlobalSound2 fade:)
		(super dispose:)
		(DisposeScript 964)
		(DisposeScript 13)
		(DisposeScript 231)
	)
)

(instance holeInset of Inset
	(properties
		view 487
		x 133
		y 101
		disposeNotOnMe 1
		noun 12
	)

	(method (init)
		(gGlobalSound2 fade:)
		(super init: &rest)
		(wallView init:)
		(gGame handsOn:)
		(gTheIconBar disable: 0 1 3 4 5 6)
		(insetView signal: (| (insetView signal:) $1000))
		(if (not (guardWalkByScr register:))
			(self setScript: guardWalkByScr)
		)
		(gGlobalSound number: 704 loop: -1 play:)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(gTheIconBar enable: 6)
		(gGame handsOff:)
		(super dispose:)
		(gGlobalSound2 number: 917 loop: -1 play:)
	)
)

(instance enterRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setScale:
					scaleX: 83
					scaleY: 83
					setPri: 3
					setSpeed: 6
					posn: 223 88
					setMotion: MoveTo 238 88 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 250 84 self)
			)
			(2
				(gEgo setLoop: 2 setMotion: MoveTo 244 71 self)
			)
			(3
				(gEgo
					setScale: Scaler 100 58 140 58
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 228 77 self
				)
			)
			(4
				(gEgo reset: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: MoveTo 244 71 self)
			)
			(1
				(gEgo
					setScale:
					scaleX: 83
					scaleY: 83
					setPri: 3
					setLoop: 3
					setScale:
					setMotion: MoveTo 250 84 self
				)
			)
			(2
				(gEgo setLoop: -1 setMotion: DPath 238 88 223 88 self)
			)
			(3
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance climbVineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normal: 0
					setSpeed: 6
					view: 231
					posn: 204 82
					loop: 0
					cel: 0
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo reset: 1 posn: 200 81)
				(= ticks 10)
			)
			(3
				(gMessager say: 13 5 0 0 self) ; "The vines are too flimsy to support Alexander."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance paintWallScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gInventory at: 3) cue:) ; brush
				(gMessager say: 4 44 8 1 self) ; "Feeling artistically inspired, Alexander decides to make use of the large, blank castle wall."
			)
			(1
				(gEgo
					normal: 0
					posn: 136 113
					view: 233
					loop: 0
					cycleSpeed: 10
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(= register 3)
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(7
				(if (not (-- register))
					(gEgo cel: 2)
					(-= state 3)
				)
				(= cycles 2)
			)
			(8
				(= register 3)
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(9
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: CT 8 1 self)
			)
			(10
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(11
				(if (not (-- register))
					(gEgo cel: 4)
					(-= state 3)
				)
				(= cycles 2)
			)
			(12
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(13
				(= register 3)
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(14
				(= cycles 2)
			)
			(15
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(16
				(= cycles 2)
			)
			(17
				(gGlobalSound4 number: 230 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(18
				(if (not (-- register))
					(gEgo cel: 2)
					(-= state 3)
				)
				(= cycles 2)
			)
			(19
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(20
				(magicDoor init:)
				(gEgo reset: 7 posn: 148 107 setScale: Scaler 100 58 140 58)
				(= cycles 2)
			)
			(21
				(gGame givePoints: 1)
				(= ticks 20)
			)
			(22
				(gMessager say: 4 44 8 2 self) ; "Ah! A doorway! Just what Alexander was thinking this wall needed!"
			)
			(23
				(SetFlag 23)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enchantDoorScr of CartoonScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 147) (!= (gEgo y:) 115))
					(gEgo setMotion: PolyPath 147 115 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gMessager say: 1 0 13 1 self) ; "With trepidation, Alexander gathers his strength for the enchantment of the painted door...."
			)
			(2
				(= cycles 2)
			)
			(3
				(KQ6Print
					posn: -1 10
					font: gUserFont
					say: 0 1 0 13 2 ; "(DRAMATIC, AUTHORITATIVE)Magic paint, black as ink! Bring to life what I think! Make it real, what I draw! According to this spoken law!"
					modeless: 1
					ticks: 20
					init:
				)
				(= cycles 2)
			)
			(4
				(gEgo
					normal: 0
					setSpeed: 6
					view: 234
					loop: 0
					cel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(5
				(= register 60)
				(self cue:)
			)
			(6
				(= ticks register)
			)
			(7
				(gEgo cel: 0 loop: 1 setCycle: End self)
				(-= register 15)
				(if (!= (++ local1) 4)
					(-= state 2)
				)
			)
			(8
				(= ticks 45)
			)
			(9
				(gEgo cycleSpeed: 9 loop: 2 cel: 0 setCycle: End self)
			)
			(10
				(= ticks 35)
			)
			(11
				(magicDoor loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(magicDoor loop: 2 cel: 0 setCycle: End self)
			)
			(13
				(magicDoor loop: 3 setCycle: End self)
				(gEgo reset: 7 setScale: Scaler 100 58 140 58)
			)
			(14
				(gGlobalSound4 number: 231 loop: 1 play:)
				(magicDoor loop: 4 setCycle: End self)
			)
			(15
				(magicDoor view: 233 loop: 8 cel: 0)
				(= cycles 1)
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(17
				(= cycles 20)
			)
			(18
				(gMessager say: 1 0 13 3 self) ; "The spell worked! The door has magically solidified!"
			)
			(19
				(SetFlag 24)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 148 111 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 6 5 11 1 self) ; "Eager to be inside the castle at last, Alexander opens the enchanted door..."
			)
			(4
				(gEgo
					setSpeed: 6
					setPri: 14
					normal: 0
					view: 233
					loop: 9
					cel: 0
					posn: 136 113
					setScale: 0
				)
				(= cycles 2)
			)
			(5
				(gGlobalSound4 number: 901 loop: 1 play: self)
				(gEgo setCycle: CT 2 1 self)
				(magicDoor hide:)
			)
			(6
				(magicDoor setPri: -1 show: cel: 1)
				(gEgo cel: 3)
				(= cycles 2)
			)
			(7)
			(8
				(gMessager say: 6 5 11 2 self) ; "...and steps inside!"
			)
			(9
				(gGame givePoints: 2)
				(gEgo setCycle: End self)
			)
			(10
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance lookHoleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 1 0 0 self) ; "Alexander looks through the hole-in-the-wall."
			)
			(1
				(gEgo
					normal: 0
					setSpeed: 6
					view: 232
					loop: 4
					cel: 0
					posn: 89 140
					setCycle: End self
				)
			)
			(2
				(holeInset init: self gCurRoom)
			)
			(3
				(= cycles 3)
			)
			(4
				(gEgo loop: 4 setCycle: Beg self)
			)
			(5
				(gEgo posn: 97 140 reset: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance placeHoleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 18 gCurRoomNum) ; holeInTheWall
				(gGame handsOff:)
				(gEgo
					normal: 0
					posn: 84 140
					setSpeed: 6
					view: 232
					loop: 1
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(holeOnWall init:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo posn: 94 139 reset: 7)
				(= cycles 2)
			)
			(3
				(gMessager say: 4 25 0 0 self) ; "Alexander puts the hole-in-the-wall on the side wall of the castle."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance removeHoleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 18) ; holeInTheWall
				(gEgo
					normal: 0
					posn: 84 140
					setSpeed: 6
					view: 232
					loop: 1
					cel: 6
					setCycle: CT 5 -1 self
				)
			)
			(1
				(holeOnWall dispose:)
				(gEgo setCycle: Beg self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo posn: 94 139 reset: 7)
				(= cycles 2)
			)
			(4
				(gMessager say: 5 5 0 0 self) ; "Alexander removes the hole-in-the-wall from the wall."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance guardWalkByScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(= seconds (Random 5 15))
			)
			(1
				(guardDog init: setMotion: MoveTo 190 137 self)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(if (gCast contains: guardDog)
			(guardDog dispose:)
		)
	)
)

(instance bush of Prop
	(properties
		x 18
		y 134
		noun 9
		view 230
		priority 15
		signal 20496
	)
)

(instance magicDoor of Prop
	(properties
		x 136
		y 113
		noun 6
		sightAngle 15
		approachX 147
		approachY 115
		view 235
		priority 1
		signal 16401
	)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(or
					(and (== (param1 message:) 5) (IsFlag 24))
					(and (== (param1 message:) 28) (not (IsFlag 24)))
				)
			)
			(= _approachVerbs (gKq6ApproachCode doit: (param1 message:)))
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 5) ; Do
				(if (IsFlag 24)
					(gCurRoom setScript: openDoorScr)
				else
					(gMessager say: noun 5 10) ; "Alexander would love to go through the painted door, but that wall is still quite solid!"
				)
			)
			((OneOf theVerb 1 2) ; Look, Talk
				(gMessager say: noun theVerb (if (IsFlag 24) 11 else 10))
			)
			((== theVerb 28) ; spellBook
				(if (IsFlag 24)
					(gMessager say: noun theVerb 11) ; "The magic door is already as real as it's going to get."
				else
					(KQ6Print say: 0 6 28 10 1 init:) ; "Alexander opens the spell book."
					(gCurRoom setScript: (ScriptID 190)) ; openBook
				)
			)
			((== theVerb 29) ; brush
				(gMessager say: 4 theVerb 5) ; "Alexander has already painted the castle wall."
			)
			((== theVerb 44) ; teaCup
				(gMessager say: noun theVerb) ; "Alexander has already used the paint on the castle wall."
			)
			(else
				(gMessager say: noun 0 (if (IsFlag 24) 11 else 10))
			)
		)
	)

	(method (init)
		(self approachVerbs: 28) ; spellBook
		(super init: &rest)
	)
)

(instance guardDog of Actor
	(properties
		x 78
		y 137
		noun 15
		view 726
		priority 13
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self setScale: setCycle: Walk)
	)
)

(instance holeOnWall of View
	(properties
		x 75
		y 141
		z 47
		noun 5
		approachX 92
		approachY 140
		view 482
		loop 1
		signal 17
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(switch (param1 message:)
				(5
					(== approachX 97)
				)
				(1
					(== approachY 94)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: lookHoleScr)
			)
			(5 ; Do
				(gCurRoom setScript: removeHoleScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)
)

(instance wallView of View
	(properties
		x 141
		y 96
		noun 12
		view 230
		loop 1
		priority 12
		signal 17
	)
)

(instance castleWall of Feature
	(properties
		noun 4
		sightAngle 45
		onMeCheck 2
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(if
				(or
					(== (param1 message:) 25)
					(and
						(OneOf (param1 message:) 44 29)
						(IsFlag 22)
						(gEgo has: 3) ; brush
						(gEgo has: 46) ; teaCup
					)
				)
				(self _approachVerbs: (| $8000 (self _approachVerbs:)))
				(if (== (param1 message:) 25)
					(= approachX 94)
					(= approachY 140)
					(= x 70)
					(= y 118)
					(return temp0)
				)
			else
				(self _approachVerbs: (& $7fff (self _approachVerbs:)))
			)
		)
		(if (!= approachX 147)
			(= approachX 147)
			(= approachY 115)
			(= x 136)
			(= y 105)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(44 ; teaCup
				(cond
					((IsFlag 23)
						(gMessager say: noun theVerb 5) ; "Alexander has already painted the castle wall. Besides, the paint is all gone."
					)
					((not (IsFlag 22))
						(if (or (IsFlag 58) (IsFlag 68))
							(gMessager say: noun theVerb 6) ; "The paint isn't ready to be used on anything yet."
						else
							(gMessager say: noun theVerb 9) ; "Why would Alexander want to use that empty teacup on the wall?"
						)
					)
					((not (gEgo has: 3)) ; brush
						(gMessager say: noun 44 7) ; "Alexander will need something with which to apply the paint before he can paint that wall."
					)
					(else
						(gCurRoom setScript: paintWallScr)
					)
				)
			)
			(29 ; brush
				(cond
					((IsFlag 23)
						(gMessager say: noun theVerb 5) ; "Alexander has already painted the castle wall."
					)
					((IsFlag 22)
						(self doVerb: 44 &rest)
					)
					(else
						(gMessager say: noun theVerb 6) ; "Alexander might have a paintbrush, but he does not have any paint."
					)
				)
			)
			(25 ; holeInTheWall
				(gCurRoom setScript: placeHoleScr)
			)
			(1 ; Look
				(gMessager
					say:
						noun
						theVerb
						(cond
							((not (IsFlag 23)) 0)
							((IsFlag 24) 11)
							(else 10)
						)
				)
			)
			(28 ; spellBook
				(if (not (IsFlag 23))
					(gMessager say: noun theVerb 4) ; "There doesn't seem to be any spells for blank walls in the spell book!"
				else
					(magicDoor doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance genericFeatures of Feature
	(properties)

	(method (onMe param1)
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(4 9)
					(16 8)
					(32 11)
					(else 0)
				)
			)
		)
	)
)

(instance vine of Feature
	(properties
		noun 13
		onMeCheck 256
		approachX 200
		approachY 81
		_approachVerbs 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: climbVineScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

