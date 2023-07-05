;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7506)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoCisHDCU 0
)

(instance octoCisHDCU of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(if (== global258 3)
			(super init: 7516)
			(theLock init: setHotspot: 94)
		else
			(super init: 7510)
		)
		(hiddenDoor_135 init:)
		(proc201_1 11)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)

	(method (cue)
		(self newRoom: gPrevRoomNum)
	)

	(method (pitch param1)
		(if (global117 contains: hiddenDoor)
			(hiddenDoor setMotion: MoveTo 177 212 self)
			(hiddenDoorSnd play:)
		else
			(super pitch: param1)
		)
	)
)

(instance sOpenHiddenDoor of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hiddenDoor setMotion: MoveTo 176 13 self)
				(hiddenDoorSnd play:)
			)
			(1
				(hiddenDoor_135 dispose:)
				(keyNiche_135 init:)
				(self dispose:)
			)
		)
	)
)

(instance keyNiche_135 of Feature
	(properties
		noun 35
		nsBottom 278
		nsLeft 152
		nsRight 449
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hiddenDoor_135 of Feature
	(properties
		noun 34
		nsBottom 278
		nsLeft 152
		nsRight 449
	)

	(method (init)
		(super init: &rest)
		(if (== global258 3)
			(= case 2)
		else
			(= case 1)
		)
		(self setHotspot: 144)
	)
)

(instance hiddenDoor of Actor
	(properties
		x 177
		y 212
		view 7501
	)
)

(instance theLock of Feature
	(properties
		nsBottom 281
		nsLeft 255
		nsRight 331
		nsTop 228
	)

	(method (doVerb theVerb)
		(switch theVerb
			(94
				(proc70_1 100 1)
				(if (== (proc70_9 94) 7506)
					(keyBY init: global117)
				)
				(if (== (proc70_9 96) 7506)
					(keyGG init: global117)
				)
				(if (== (proc70_9 98) 7506)
					(keyGR init: global117)
				)
				(if (== (proc70_9 101) 7506)
					(keyOR init: global117)
				)
				(if (== (proc70_9 102) 7506)
					(keyVB init: global117)
				)
				(hiddenDoor priority: 10 init: global117)
				(gCurRoom drawPic: 7518)
				(hiddenDoor yStep: 10 setMotion: MoveTo 177 12)
				(hiddenDoorSnd play:)
				(hiddenDoor_135 dispose:)
				(keyNiche_135 init:)
				(self deleteHotspot: 94)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyBY of View
	(properties
		x 276
		y 53
		cel 1
		view 7502
	)

	(method (init)
		(super init: global117)
		(self setPri: 8 setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 94)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyGG of View
	(properties
		x 326
		y 77
		cel 2
		view 7502
	)

	(method (init)
		(super init: global117)
		(self setPri: 8 setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 96)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyGR of View
	(properties
		x 201
		y 127
		cel 3
		view 7502
	)

	(method (init)
		(super init: global117)
		(self setPri: 8 setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 98)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyOR of View
	(properties
		x 251
		y 177
		cel 6
		view 7502
	)

	(method (init)
		(super init: global117)
		(self setPri: 8 setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 101)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyVB of View
	(properties
		x 302
		y 152
		cel 8
		view 7502
	)

	(method (init)
		(super init: global117)
		(self setPri: 8 setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 102)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hiddenDoorSnd of Sound
	(properties
		number 7501
		flags 5
	)
)

