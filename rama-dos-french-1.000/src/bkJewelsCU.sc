;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4132)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Feature)
(use Actor)
(use System)

(public
	bkJewelsCU 0
)

(instance bkJewelsCU of CloseupLocation
	(properties
		heading 180
	)

	(method (init)
		(super init: 4156)
		(leftJewelHole init:)
		(rightJewelHole init:)
		(topJewelHole init:)
		(= plane global116)
		(if
			(and
				(== (proc70_9 116) 4132)
				(IsFlag 42)
				(IsFlag 43)
				(IsFlag 44)
			)
			(gCurRoom setScript: sShowRosettaStone)
		else
			(jewelHolder_180 init:)
		)
		(self edgeW: 0 edgeE: 0)
	)

	(method (cue)
		(gCurRoom newRoom: gPrevRoomNum)
	)

	(method (pitch)
		(switch (global116 picture:)
			(4151
				(jewelsUp movieName: 4151 play: self)
			)
			(4163
				(jewelsUp movieName: 4152 play: self)
			)
			(else
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance leftJewelHole of Feature
	(properties
		nsBottom 181
		nsLeft 239
		nsRight 281
		nsTop 138
	)

	(method (init)
		(if (IsFlag 42)
			(jewel1 init: global117)
		else
			(= plane global116)
			(super init:)
			(self setHotspot: 142)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(142
				(proc70_3)
				(SetFlag 42)
				(jewel1 init: global117)
				(if (and (IsFlag 43) (IsFlag 44))
					(UpdateScreenItem jewel1)
					(FrameOut)
					(gCurRoom setScript: sShowRosettaStone)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightJewelHole of Feature
	(properties
		nsBottom 181
		nsLeft 307
		nsRight 346
		nsTop 139
	)

	(method (init)
		(if (IsFlag 43)
			(jewel2 init: global117)
		else
			(= plane global116)
			(super init:)
			(self setHotspot: 142)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(142
				(proc70_3)
				(SetFlag 43)
				(jewel2 init: global117)
				(if (and (IsFlag 42) (IsFlag 44))
					(UpdateScreenItem jewel2)
					(FrameOut)
					(gCurRoom setScript: sShowRosettaStone)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance topJewelHole of Feature
	(properties
		nsBottom 131
		nsLeft 267
		nsRight 311
		nsTop 89
	)

	(method (init)
		(if (IsFlag 44)
			(jewel3 init: global117)
		else
			(= plane global116)
			(super init:)
			(self setHotspot: 142)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(142
				(proc70_3)
				(SetFlag 44)
				(jewel3 init: global117)
				(if (and (IsFlag 43) (IsFlag 42))
					(UpdateScreenItem jewel3)
					(FrameOut)
					(gCurRoom setScript: sShowRosettaStone)
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rosettaStone of Feature
	(properties
		nsBottom 171
		nsLeft 265
		nsRight 321
		nsTop 115
	)

	(method (init)
		(if (== (proc70_9 116) 4132)
			(= plane global116)
			(super init:)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 116)
				(gCurRoom drawPic: 4163)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jewelHolder_180 of Feature
	(properties
		noun 61
		nsBottom 224
		nsLeft 202
		nsRight 384
		nsTop 60
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jewel1 of View
	(properties
		x 230
		y 189
		view 4155
	)
)

(instance jewel2 of View
	(properties
		x 298
		y 190
		cel 1
		view 4155
	)
)

(instance jewel3 of View
	(properties
		x 265
		y 135
		cel 2
		view 4155
	)
)

(instance sShowRosettaStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 4150)
				(jewel1 dispose:)
				(jewel2 dispose:)
				(jewel3 dispose:)
				(= seconds 1)
			)
			(1
				(jewelsDown play: self)
			)
			(2
				(gCurRoom drawPic: 4151)
				(rosettaStone init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jewelsDown of VMDMovie
	(properties
		movieName 4150
		frameRate 10
	)

	(method (play)
		(= priority (- (global124 priority:) 1))
		(super play: &rest)
	)
)

(instance jewelsUp of VMDMovie
	(properties
		frameRate 10
	)

	(method (play)
		(= priority (- (global124 priority:) 1))
		(super play: &rest)
	)
)

