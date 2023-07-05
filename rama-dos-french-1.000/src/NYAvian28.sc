;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5028)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use Feature)
(use Sound)
(use System)

(public
	NYAvian28 0
)

(local
	local0
)

(instance NYAvian28 of CloseupLocation
	(properties
		noun 2
		heading 315
	)

	(method (init)
		(super init: 5089)
		(tuningForkFeat init:)
		(self edgeW: 0 edgeE: 0 edgeN: 0)
		(tuningForkFeat init:)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance tuningForkFeat of Feature
	(properties
		nsBottom 196
		nsLeft 244
		nsRight 373
		nsTop 67
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 123 124 125 126 127)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(126
				(= local0 3)
				(gCurRoom setScript: tuningForkScript)
				(proc201_1 36)
			)
			(else
				(proc201_1 36)
				(= local0 (- (proc70_7 (gTheCursor invItem:)) 117))
				(gCurRoom setScript: tuningForkScript)
			)
		)
	)
)

(instance changeRampLocations of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 ((ScriptID 201 0) curAPRampPosition:)) ; newYorkRegion
				(if (OneOf temp0 1 5)
					((ScriptID 201 0) ; newYorkRegion
						curAPRampDir: (* ((ScriptID 201 0) curAPRampDir:) -1) ; newYorkRegion
					)
				)
				(+= temp0 ((ScriptID 201 0) curAPRampDir:)) ; newYorkRegion
				((ScriptID 201 0) curAPRampPosition: temp0) ; newYorkRegion
				(rampSound play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tuningForkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 (+ 5089 local0) 281 56 0 0 250 0 self)
				(forkSound number: (+ 20002 local0) play:)
				(statueSound play:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(if (== local0 3)
					(gCurRoom setScript: changeRampLocations)
				)
			)
		)
	)
)

(instance rampSound of Sound
	(properties
		number 5100
		flags 5
	)
)

(instance forkSound of Sound
	(properties
		flags 5
	)
)

(instance statueSound of Sound
	(properties
		number 5120
		flags 5
	)
)

(instance forkIndent_315 of Feature ; UNUSED
	(properties
		noun 26
		x 314
		y 137
		nsBottom 273
		nsLeft 170
		nsRight 458
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

