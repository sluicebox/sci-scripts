;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
)

(instance rm500 of Rm
	(properties
		picture 500
	)

	(method (init)
		(HandsOn)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 95 121 139 121 182 138 149 165 86 165 56 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 108 14 104 0 114
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 242 189 262 167 319 167
					yourself:
				)
		)
		(gFeatures
			add:
				pyre
				hedge
				ring1
				ring2
				ring3
				stand
				awning
				secretDoor
				walls
				floor
			eachElementDo: #init
		)
		(super init:)
		(ring1 approachVerbs: 3) ; Do
		(ring3 approachVerbs: 3) ; Do
		(gRgnMusic number: 500 loop: -1 play:)
		(gEgo setScript: enterRoom)
	)

	(method (doit)
		(if (and (not (gEgo script:)) (gEgo edgeHit:))
			(= gEgoEdgeHit (gEgo edgeHit:))
			(gEgo setScript: outAndInAgain)
		)
	)
)

(instance secretDoor of Prop
	(properties
		x 148
		y 101
		view 501
		loop 10
		priority 6
		signal 16400
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 187 36 185 101 148 100 150 36
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 1) ; "This secret door must be an escape route for the Abbot, should he ever need it."
			)
			(3 ; Do
				(gEgo setScript: openDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pyre of Feature
	(properties
		y 157
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 113 53 118 53 119 54 119 110 149 111 173 127 174 137 147 157 92 157 64 137 65 124 94 109 112 110
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 128))
					(Say 1500 18) ; "The Abbot had this thing built--a stake within a small pyre. Twice he has burned old women he accused of being witches, a vile foreign notion that causes great unease among the townsfolk. I'll wager he keeps this Court locked so the people do not sneak in here and destroy this thing."
					(SetFlag 128)
				else
					(Say 1500 0) ; "It's the Abbot's pyre for burning witches."
				)
			)
			(3 ; Do
				(Say 1500 8) ; "The stake is firmly set. There's nothing I can accomplish here."
			)
			(4 ; Inventory
				(Say 1500 12) ; "Not a safe place to hide it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hedge of Feature
	(properties
		y 15
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 1 16 14 7 24 8 38 4 46 7 57 5 63 8 72 7 76 6 89 7 99 5 106 5 145 5 169 6 173 4 193 5 205 7 214 5 223 6 318 7 319 14
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 3) ; "It is the top of the hedge upon the other side."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance awning of Feature
	(properties
		y 118
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 118 239 117 238 94 290 64 319 35
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 6) ; "The awning provides shade for the spectator stand."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stand of Feature
	(properties
		y 189
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 292 118 315 152 319 152 319 189 216 189 255 149 306 152 283 119
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 5) ; "The Abbot has built a spectator stand, curse his black heart."
			)
			(3 ; Do
				(Say 1500 10) ; "I see nothing of use here."
			)
			(4 ; Inventory
				(if (== invItem 13) ; robes
					(Say 1500 14) ; "I can think of no reason to leave them here. They could be too easily found before I came back for them later."
				else
					(Say 1500 13) ; "I can think of no reason to leave it here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ring1 of Feature
	(properties
		y 64
		approachX 89
		approachY 102
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 84 53 94 53 94 65 84 65
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 7) ; "Three iron rings are set into the walls, probably to disguise the fact that one of them provides a handle to open the hidden door."
			)
			(3 ; Do
				(Say 1500 11) ; "Nothing happens when I pull upon this ring."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ring2 of Feature
	(properties
		y 64
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 164 52 176 52 176 65 164 65
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 7) ; "Three iron rings are set into the walls, probably to disguise the fact that one of them provides a handle to open the hidden door."
			)
			(3 ; Do
				(gEgo setScript: openDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ring3 of Feature
	(properties
		y 64
		approachX 250
		approachY 107
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 245 53 257 53 257 67 245 67
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 7) ; "Three iron rings are set into the walls, probably to disguise the fact that one of them provides a handle to open the hidden door."
			)
			(3 ; Do
				(Say 1500 11) ; "Nothing happens when I pull upon this ring."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 19 7 16 319 14 319 33 319 105 10 97 0 101
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 2) ; "The walls are of solid stone."
			)
			(3 ; Do
				(Say 1500 9) ; "This part of the wall doesn't move."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 102 10 97 319 105 319 189 0 189
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1500 4) ; "The ground of the Witch's Court is paved with stone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 501 x: 169 y: 99 init: setLoop: 0 setCycle: End)
				(secretDoor setCycle: End self)
				(= gDisguiseNum 5) ; abbey monk
			)
			(1
				(NormalEgo)
				(gEgo setCycle: StopWalk 24 setMotion: PolyPath 170 116 self)
			)
			(2
				(secretDoor setCycle: Beg self)
			)
			(3
				(if (not (IsFlag 139))
					(Say 1500 15) ; "Ah, the maze has brought me out into the Witch's Court. It's entirely enclosed by the stone wall with two large wooden gates set in the northern wall. They're closed now, but when open, they would allow a large crowd of spectators to enter."
					(SetFlag 139)
					(SetScore 100)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance outAndInAgain of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (= local0 (gEgo x:)))
				(= temp1 (= local1 (gEgo y:)))
				(switch gEgoEdgeHit
					(3
						(= temp1 240)
						(= local1 180)
					)
					(2
						(+= temp0 20)
						(-= local0 20)
					)
					(4
						(-= temp0 20)
						(+= local0 20)
					)
				)
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(= seconds 4)
			)
			(2
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(3
				(if (== gEgoEdgeHit 2)
					(Say 1500 17) ; "The wall is too high to climb nor does this stand offer me any help."
				else
					(Say 1500 16) ; "The wall is too high to climb and the wooden gates of this enclosure are locked from the outside. It would seem I have no choice but to return the way I came."
				)
				(= cycles 2)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 162 110 self)
			)
			(1
				(gEgo view: 28 loop: 6 cel: 2)
				(= cycles 10)
			)
			(2
				(NormalEgo)
				(gEgo setMotion: PolyPath 197 108 self)
			)
			(3
				(secretDoor setCycle: End self)
			)
			(4
				(gEgo setMotion: MoveTo 165 108 self)
			)
			(5
				(gEgo setMotion: MoveTo 173 94 self)
			)
			(6
				(self dispose:)
				(gCurRoom newRoom: 70) ; hedge9
			)
		)
	)
)

