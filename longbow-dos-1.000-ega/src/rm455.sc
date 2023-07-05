;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm455 0
)

(instance rm455 of Rm
	(properties
		picture 455
		north 450
	)

	(method (init)
		(NormalEgo 2)
		(super init:)
		(gEgo posn: 130 109 init:)
		(HandsOn)
		(if (!= gDay 10)
			(if (== ((Inv at: 13) owner:) gCurRoomNum) ; robes
				(robes init:)
			)
			(if (== ((Inv at: 13) owner:) (+ gCurRoomNum 1)) ; robes
				(robes init: lookStr: 26)
			)
			(robes approachVerbs: 3) ; Do
		)
		(tub init:)
		(shelves init:)
		(table init:)
		(buckets init:)
		(jug init:)
		(water init:)
		(rShelves init:)
		(door init: approachVerbs: 3) ; Do
		(ldry init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 62 148 104 119 157 119 157 128 138 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 187 125 247 125 247 161 171 161
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 125 105 59 145 63 172 253 171 250 112 158 110
					yourself:
				)
		)
		(gEgo actions: (ScriptID 452 3)) ; noBlow
	)
)

(instance robes of View
	(properties
		x 202
		y 111
		sightAngle 45
		approachX 202
		approachY 121
		lookStr 10 ; "Three freshly washed robes and sash belts have been hung to dry."
		view 455
		loop 1
		signal 16641
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(rustleSound play:)
				(if (== ((Inv at: 13) owner:) gCurRoomNum) ; robes
					(SetScore 50)
					(Say 1455 2 1) ; "Good, they're mostly dry. Nothing worse to carry around than wet wool."
				else
					(Say 1455 3 1) ; "I should try to hold onto them this time."
				)
				(gEgo get: 13) ; robes
				(self dispose:)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tub of Feature
	(properties
		x 110
		y 134
		sightAngle 45
		onMeCheck 2
		lookStr 8 ; "The tub is filled with dirty water and half-done laundry."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 0) ; "I could hardly carry THAT around."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; robes
						(Say 1455 4 1) ; "They don't need to be washed again."
					)
					(18 ; waterRing
						(gCurRoom setScript: series 0 1455 20 21)
					)
					(else
						(Say 1455 19 1) ; "I don't think it needs washing."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance shelves of Feature
	(properties
		x 85
		y 114
		sightAngle 45
		onMeCheck 8
		lookStr 9 ; "The shelves hold dyed wool, ready to be made into more robes."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 1 1) ; "Raw wool doesn't seem useful."
			)
			(4 ; Inventory
				(table doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 214
		y 139
		sightAngle 45
		onMeCheck 4
		lookStr 11 ; "There's just a bucket and a some rags lying on the table."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 5 1) ; "Nothing here I want."
			)
			(4 ; Inventory
				(switch invItem
					(12 ; puzzleBox
						(Say 1455 25 1) ; "This isn't something I should leave lying around."
					)
					(11 ; cask
						(Say 1455 22 1) ; "Why would I want to leave it here?"
					)
					(else
						(if (and (gEgo has: 13) (!= invItem 13)) ; robes, robes
							(gCurRoom setScript: series 0 1455 15 16)
						else
							(Say 1455 17 1) ; "That would be foolish indeed."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance buckets of Feature
	(properties
		x 199
		y 107
		sightAngle 45
		onMeCheck 16
		lookStr 12 ; "Only an ordinary bucket."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 6 1) ; "Hmm...nay, can't think of a use for it."
			)
			(4 ; Inventory
				(table doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance jug of Feature
	(properties
		x 94
		y 116
		sightAngle 45
		onMeCheck 64
		lookStr 13 ; "It's a ceramic jug. Probably contains the brown dye they use on these robes."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 6 1) ; "Hmm...nay, can't think of a use for it."
			)
			(4 ; Inventory
				(table doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance water of Feature
	(properties
		sightAngle 45
		onMeCheck 32
		lookStr 14 ; "One expects puddles in a laundry room."
	)

	(method (onMe param1 param2 &tmp temp0)
		(if (IsObject param1)
			(= x (param1 x:))
			(= y (+ (param1 y:) 10))
		)
		(return (super onMe: param1 param2))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (== invItem 18) ; waterRing
					(gCurRoom setScript: series 0 1455 20 21)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rShelves of Feature
	(properties
		x 198
		y 105
		sightAngle 45
		onMeCheck 128
		lookStr 9 ; "The shelves hold dyed wool, ready to be made into more robes."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1455 1 1) ; "Raw wool doesn't seem useful."
			)
			(4 ; Inventory
				(switch invItem
					(12 ; puzzleBox
						(gCurRoom setScript: series 0 1455 23 24)
					)
					(11 ; cask
						(Say 1455 22 1) ; "Why would I want to leave it here?"
					)
					(13 ; robes
						(gCurRoom setScript: putBack)
					)
					(else
						(Say 1455 18 1) ; "Hmm...I could hide it inside these piles of fabric.... but it hardly seems safe enough."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance putBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 202 121 self)
			)
			(1
				(rustleSound play:)
				(gEgo put: 13 gCurRoomNum) ; robes
				(SetScore -50)
				(robes init:)
				(HandsOn)
			)
		)
	)
)

(instance door of Feature
	(properties
		onMeCheck 256
		approachX 134
		approachY 107
		lookStr 27 ; "It's the door through which I entered."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gCurRoom newRoom: 450)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ldry of Feature
	(properties
		onMeCheck 1
		lookStr 7 ; "It's a small laundry room, nothing more."
	)
)

(instance series of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(HandsOff)
		(= start param4)
		(super init: param1 param2 param3)
		(= start param5)
	)

	(method (changeState newState)
		(if (<= (= state newState) start)
			(Say register state self)
		else
			(HandsOn)
			(self dispose:)
		)
	)

	(method (cue param1)
		(if (not param1)
			(= start state)
		)
		(super cue:)
	)
)

(instance rustleSound of Sound
	(properties
		flags 1
		number 462
	)
)

