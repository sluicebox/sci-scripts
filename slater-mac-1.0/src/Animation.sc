;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use User)
(use Actor)

(class Animation of Prop
	(properties
		view 0
		signal 16385
		anAudio 0
		whichCyc 0
		noLoops 0
		lastView 0
		aSound 0
	)

	(method (init)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(if whichCyc
			(whichCyc dispose:)
		)
		(if aSound
			(aSound dispose:)
			(= aSound 0)
		)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (User canInput:) 1))
			(gGame handsOff:)
			(event claimed: 1)
			(if whichCyc
				(self setCycle: whichCyc lastView noLoops self)
			else
				(self setCycle: End self)
			)
			(if anAudio
				(if aSound
					(aSound play:)
				else
					(= aSound ((Sound new:) number: anAudio play: yourself:))
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

