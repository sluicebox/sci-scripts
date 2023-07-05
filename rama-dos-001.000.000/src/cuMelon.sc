;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1202)
(include sci.sh)
(use Main)
(use InvInitialize)
(use InvInset)
(use SpinProp)

(public
	cuMelon 0
)

(instance cuMelon of SpinProp
	(properties)

	(method (init)
		(switch (myInvObj cel:)
			(0
				(self view: 20947)
			)
			(4
				(self view: 20949)
			)
			(2
				(self view: 20948)
			)
		)
		(super init: &rest)
		(switch (myInvObj cel:)
			(0
				(self setHotspot: 16)
			)
			(4
				(self setHotspot: 66)
			)
			(2
				(self setHotspot: 66)
			)
		)
		(self setPri: 200)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(= view 20948)
				(self deleteHotspot: setHotspot: 66)
				(myInvObj cel: 2)
				(myInvObj setHotspot: 66)
				(switch gCurRoomNum
					(6201 ; avianGreatHall2
						(gCurRoom doVerb: 16)
					)
				)
			)
			(66
				(switch view
					(20948
						(= view 20949)
						(myInvObj cel: 4)
						(switch gCurRoomNum
							(6201 ; avianGreatHall2
								(gCurRoom doVerb: theVerb)
							)
						)
						(InvInset dispose:)
						(FrameOut)
						(gGame setScript: (ScriptID 100 0)) ; eatMelonScr
					)
					(20949
						(InvInset dispose:)
						(proc70_3 124 myInvObj)
						(switch gCurRoomNum
							(6201 ; avianGreatHall2
								(gCurRoom doVerb: theVerb)
							)
						)
						(FrameOut)
						(gGame setScript: (ScriptID 100 0)) ; eatMelonScr
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

