;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Actor)

(class Word of Prop
	(properties
		view 0
		signal 1
		anAudio 0
		aSound 0
	)

	(method (init)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(self setCycle: Beg)
		(if aSound
			(aSound dispose:)
			(= aSound 0)
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= aSound ((Sound new:) number: anAudio play: yourself:))
			(event claimed: 1)
			(self aniDoit:)
		)
	)

	(method (aniDoit)
		(self setCycle: End self)
	)
)

