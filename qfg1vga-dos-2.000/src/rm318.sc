;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm318 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2)
	(Print mode: 1 width: param1 addText: param2 x: -1 y: 12 init:)
)

(procedure (localproc_1)
	(local0 loop: local1 cel: 0 posn: local2 local3 setPri: 1)
)

(instance rm318 of Rm
	(properties
		picture 318
		style 7
	)

	(method (init)
		(Load rsVIEW 318)
		(Load rsPIC 318)
		(gTheIconBar disable: 5 7 8)
		(= picture 318)
		(super init: &rest)
		(gFeatures
			add: poster1 poster2 poster3 poster4 poster5 poster6
			eachElementDo: #init
		)
		(SL enable:)
		(User canControl: 0)
		((= local0 (View new:))
			view: 318
			loop: 0
			cel: 0
			posn: 74 38
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
		)
	)

	(method (dispose)
		(User canControl: 1)
		(gTheIconBar enable: 5 7 8)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 4 1 3) ; Do, Look, Walk
			(gCurRoom newRoom: 311)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance poster1 of Feature
	(properties
		x 65
		y 64
		nsTop 38
		nsLeft 42
		nsBottom 90
		nsRight 88
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster1Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster2 of Feature
	(properties
		x 63
		y 130
		nsTop 115
		nsLeft 35
		nsBottom 145
		nsRight 92
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 400])
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster2Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster3 of Feature
	(properties
		x 123
		y 94
		nsTop 67
		nsLeft 99
		nsBottom 121
		nsRight 147
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 400])
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster3Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster4 of Feature
	(properties
		x 189
		y 60
		nsTop 39
		nsLeft 168
		nsBottom 82
		nsRight 210
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 400])
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster4Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster5 of Feature
	(properties
		x 186
		y 125
		nsTop 101
		nsLeft 155
		nsBottom 150
		nsRight 218
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 400])
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster5Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster6 of Feature
	(properties
		x 254
		y 90
		nsTop 53
		nsLeft 228
		nsBottom 128
		nsRight 281
		sightAngle 40
	)

	(method (doVerb theVerb &tmp [temp0 400])
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: poster6Script)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "If you take the poster, no other adventurer will be able to read it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poster1Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 0)
				(= local2 73)
				(= local3 38)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 1 @temp0) ; "Reward for return of lost ring. Inquire at the Healer's."
				(localproc_0 240 @temp0)
			)
		)
	)
)

(instance poster2Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 4)
				(= local2 69)
				(= local3 112)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 2 @temp0) ; "This poster is rather dusty and faded. The picture is of a small child with braids. "Reward of 50 gold coins for the safe return of Elsa von Spielburg. Inquire at Spielburg Castle gates.""
				(localproc_0 265 @temp0)
			)
		)
	)
)

(instance poster3Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 2)
				(= local2 126)
				(= local3 66)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 3 @temp0) ; "Reward of 30 gold coins for the Capture or Death of the Brigand Warlock. Description: short, ugly, and wears brightly colored robes. Has habit of laughing continually. Inquire at Spielburg Castle gates."
				(localproc_0 265 @temp0)
			)
		)
	)
)

(instance poster4Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 1)
				(= local2 191)
				(= local3 37)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 4 @temp0) ; "Wanted: Brigand Leader. Description: Unknown appearance, wears a cloak. Must provide proof of leader's identity. Reward of 60 gold coins and title of Hero of the Realm. Inquire at Spielburg Castle gates."
				(localproc_0 265 @temp0)
			)
		)
	)
)

(instance poster5Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 5)
				(= local2 185)
				(= local3 99)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 5 @temp0) ; "Notice: Spell components needed. Cash or trade for potions. Inquire at the Healer's."
				(localproc_0 200 @temp0)
			)
		)
	)
)

(instance poster6Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 400])
		(switch (= state newState)
			(0
				(= local1 3)
				(= local2 253)
				(= local3 51)
				(localproc_1)
				(= cycles 2)
			)
			(1
				(Message msgGET 318 1 0 0 6 @temp0) ; "This poster seems to have been here a while. It has a picture of a handsome, but arrogant young man. "Reward of 50 gold coins for information leading to the return of Baronet Barnard von Spielburg. Inquire at Spielburg Castle gates.""
				(SetFlag 355)
				(localproc_0 265 @temp0)
			)
		)
	)
)

