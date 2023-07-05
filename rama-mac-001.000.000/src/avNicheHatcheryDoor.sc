;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6820)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	avNicheHatcheryDoor 0
)

(local
	local0
)

(instance avNicheHatcheryDoor of CloseupLocation
	(properties)

	(method (init)
		(if local0
			(super init: 6827)
			(mirmicatID init:)
		else
			(super init: 6826)
			(ClearFlag 148)
			(ClearFlag 149)
			(scanner init:)
		)
	)

	(method (dispose)
		(= local0 0)
		(super dispose: &rest)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local0 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local0)
		)
	)
)

(instance scanner of Feature
	(properties
		nsLeft 249
		nsTop 170
		nsRight 346
		nsBottom 208
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 6820)
		(Load rsAUDIO 6821)
		(self setHotspot: 19 18)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(else
				(scanKeyScript register: theVerb)
				(gCurRoom setScript: scanKeyScript)
			)
		)
	)
)

(instance humanSymbol of View
	(properties
		x 391
		y 253
		view 6801
	)
)

(instance octoSymbol of View
	(properties
		x 116
		y 254
		view 6801
		cel 5
	)
)

(instance humanKey of View
	(properties
		x 250
		y 202
		view 6801
		cel 3
	)
)

(instance octoKey of View
	(properties
		x 249
		y 200
		view 6801
		cel 2
	)
)

(instance scannedKey of View
	(properties
		x 249
		y 198
		view 6801
		cel 4
	)

	(method (init)
		(super init: &rest)
		(super setPri: 255)
	)
)

(instance mirmicatID of View
	(properties
		x 246
		y 278
		view 6801
		cel 1
	)

	(method (init)
		(if (== (proc70_9 81) 6820)
			(super init: global117)
			(super setPri: 255)
			(self setHotspot: 2)
			(SoundManager playMusic: 0 -1 6010)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 81)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scanKeyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(19
						(humanKey init: global117)
					)
					(18
						(octoKey init: global117)
					)
				)
				(= seconds 2)
			)
			(1
				(scannedKey init: global117)
				(scanKeySound play:)
				(switch register
					(19
						(humanSymbol init: global117)
					)
					(18
						(octoSymbol init: global117)
					)
				)
				(= seconds 2)
			)
			(2
				(scannedKey dispose:)
				(= seconds 1)
			)
			(3
				(switch register
					(19
						(humanSymbol dispose:)
						(humanKey dispose:)
						(SetFlag 148)
					)
					(18
						(octoSymbol dispose:)
						(octoKey dispose:)
						(SetFlag 149)
					)
				)
				(gGame handsOn:)
				(if (and (IsFlag 148) (IsFlag 149))
					(doorOpeningSound play:)
					(gCurRoom drawPic: 6827)
					(= local0 1)
					(mirmicatID init:)
					(scanner dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance scanKeySound of Sound
	(properties
		flags 5
		number 6820
	)
)

(instance doorOpeningSound of Sound
	(properties
		flags 5
		number 6821
	)
)

