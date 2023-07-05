;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	Town 0
)

(instance Town of Rgn
	(properties)

	(method (init)
		(if (not (OneOf gCurRoomNum 300 310 311 320 330 333 334))
			(gLongSong stop:)
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(and (== (event type:) evMOUSEBUTTON) (not (event modifiers:)))
			)
			(if (== (gTheIconBar curIcon:) (gTheIconBar at: 7))
				(= temp0 ((gTheIconBar curInvIcon:) message:))
			else
				(= temp0 ((gTheIconBar curIcon:) message:))
			)
			(event claimed: (self doVerb: temp0))
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; dagger
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
			(12 ; sword
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
			(20 ; rock
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

