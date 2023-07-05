;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1011)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	hubCampLocker2 0
)

(local
	local0
	local1
)

(instance hubCampLocker2 of CloseupLocation
	(properties)

	(method (init)
		(self heading: 0)
		(cond
			((IsFlag 80)
				(if local1
					(super init: 1128)
				else
					(super init: 1126)
				)
			)
			(local1
				(super init: 1028)
			)
			(else
				(super init: 1026)
			)
		)
		(lockerHandle init:)
	)

	(method (newRoom)
		(if (not (OneOf curPic 1126 1026))
			(gGame handsOff:)
			(self setScript: doorClose self)
		else
			(super newRoom: &rest)
		)
	)

	(method (pitch)
		(self newRoom: 1002) ; hubCamp2
	)

	(method (dispose)
		(= local1 0)
		(super dispose: &rest)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local1 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local1)
		)
	)
)

(instance lockerHandle of Feature
	(properties
		nsBottom 246
		nsLeft 295
		nsRight 398
		nsTop 168
	)

	(method (init)
		(if (not local1)
			(super init:)
			(if (IsFlag 87)
				(self setHotspot: 2)
			else
				(self setHotspot: 65)
			)
		else
			(memo_Data_Cube init:)
			(lighter init:)
			(unmarked_Key init:)
			(map_Pieces init:)
			(mp_PL11x_Good init:)
			(mp_PL21y_Bad init:)
			(mp_PB32z_Bad init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65
				(self setHotspot: 2)
				(lockerClick play:)
				(SetFlag 87)
			)
			(2
				(if (IsFlag 80)
					(gCurRoom drawPic: 1128)
				else
					(gCurRoom drawPic: 1028)
				)
				(= local1 1)
				(memo_Data_Cube init:)
				(lighter init:)
				(unmarked_Key init:)
				(map_Pieces init:)
				(mp_PL11x_Good init:)
				(mp_PL21y_Bad init:)
				(mp_PB32z_Bad init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lighter of View
	(properties
		x 337
		y 223
		loop 2
		view 1026
	)

	(method (init)
		(if (== (proc70_9 9) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 9)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_PL11x_Good of View
	(properties
		x 304
		y 202
		loop 4
		cel 2
		view 1026
	)

	(method (init)
		(if (== (proc70_9 64) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 64)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_PB32z_Bad of View
	(properties
		x 293
		y 261
		loop 4
		view 1026
	)

	(method (init)
		(if (== (proc70_9 63) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 63)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_PL21y_Bad of View
	(properties
		x 293
		y 260
		loop 4
		cel 1
		view 1026
	)

	(method (init)
		(if (== (proc70_9 68) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 68)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance map_Pieces of View
	(properties
		x 227
		y 250
		loop 3
		view 1026
	)

	(method (init)
		(= local0 0)
		(if (== (proc70_9 10) 1011)
			(++ local0)
		)
		(if (== (proc70_9 83) 1011)
			(++ local0)
		)
		(switch local0
			(1
				(= cel 1)
			)
			(2
				(= cel 0)
			)
		)
		(if local0
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switch local0
					(1
						(self deleteHotspot:)
						(self hide:)
					)
					(2
						(= cel 1)
						(UpdateScreenItem self)
						(FrameOut)
					)
				)
				(cond
					((== (proc70_9 83) 1011)
						(proc70_1 83)
					)
					((== (proc70_9 10) 1011)
						(proc70_1 10)
					)
				)
				(-- local0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance unmarked_Key of View
	(properties
		x 261
		y 204
		loop 1
		view 1026
	)

	(method (init)
		(if (== (proc70_9 110) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 110)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance memo_Data_Cube of View
	(properties
		x 317
		y 210
		view 1026
	)

	(method (init)
		(if (== (proc70_9 18) 1011)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 18)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockerClick of Sound
	(properties
		number 6900
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(memo_Data_Cube dispose:)
				(lighter dispose:)
				(unmarked_Key dispose:)
				(map_Pieces dispose:)
				(mp_PL11x_Good dispose:)
				(mp_PB32z_Bad dispose:)
				(mp_PL21y_Bad dispose:)
				(if (IsFlag 80)
					(gCurRoom drawPic: 1126)
				else
					(gCurRoom drawPic: 1026)
				)
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1002) ; hubCamp2
				(self dispose:)
			)
		)
	)
)

