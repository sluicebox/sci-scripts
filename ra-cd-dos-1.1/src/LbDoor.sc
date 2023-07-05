;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Door)
(use Sound)
(use Motion)

(class LbDoor of Door
	(properties
		openSnd 46
		closeSnd 47
		openVerb 4
	)

	(method (init)
		(super init:)
		(self approachVerbs: openVerb listenVerb 18) ; skeletonKey
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(18 ; skeletonKey
					(if cel
						(gMessager say: 1 18 2 0 0 16) ; "This door is already open and there's really no need for you to lock it."
						1
					else
						(gMessager say: 1 18 1 0 0 16) ; "This door won't open this way."
						1
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (open)
		(return
			(if locked
				(if (!= gMsgType 2)
					(doorSound number: 48 play:)
				)
				(gMessager say: 1 0 3 0 0 16) ; "This door is locked."
				1
			else
				(if (gUser controls:)
					(gGame handsOff:)
				)
				(= doorState 1)
				(self setCycle: End self)
				(if openSnd
					(doorSound number: openSnd play:)
				)
				(if doubleDoor
					(doubleDoor setCycle: End)
				)
			)
		)
	)

	(method (listen)
		(gMessager say: 1 0 4 0 0 16) ; "You don't hear anything."
		(return 1)
	)
)

(instance doorSound of Sound
	(properties
		flags 1
	)
)

