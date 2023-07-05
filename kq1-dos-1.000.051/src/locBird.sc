;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	locBird 0
)

(instance locBird of Locale
	(properties)

	(method (init)
		(if (OneOf gCurRoomNum 56 57 58 59 60 61 62 72 82)
			(Load rsVIEW 305)
		else
			(Load rsVIEW 301)
		)
		(super init: &rest)
		(birdie
			view:
				(if (OneOf gCurRoomNum 56 57 58 59 60 61 62 72 82)
					305
				else
					301
				)
			init:
			hide:
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			setPri: 9
			setScript: flyBy
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look,listen/bird')
				(Print 611 0) ; "You can hear the chirping of many birds hidden in the trees."
			)
			((Said 'throw,throw/boulder,pebble,pebble/bird')
				(Print 611 1) ; "Sir Graham! Your conduct is unbecoming of a knight. Fortunately, the birds are flying too fast for you to hit."
			)
			((Said '/bird')
				(Print 611 2) ; "They're not here right now...but the birds are coming."
			)
		)
	)
)

(instance birdie of Actor
	(properties
		x -18
		illegalBits 0
		xStep 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 611 3) ; "The birds of Daventry are beautiful, are they not?"
			)
			(7
				(Print 611 4) ; "You are neither tall enough nor fast enough to do that."
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((& signal $0080)
				(return)
			)
			((Said 'look,look/bird')
				(self doVerb: 1)
			)
			((Said 'get,get,capture/bird')
				(self doVerb: 7)
			)
			((Said 'kill/bird')
				(Print 611 5) ; "There's no reason to kill the birds in Daventry.  They would never harm you!"
			)
			((Said 'feed/bird')
				(Print 611 6) ; "The birds of Daventry get up early and catch all the worms they need."
			)
			((Said '/bird')
				(Print 611 7) ; "Please try something else, Sir Graham."
			)
		)
	)
)

(instance flyBy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 4 9))
			)
			(1
				(= temp0 (Random 0 1))
				(birdie
					view:
						(if (OneOf gCurRoomNum 56 57 58 59 60 61 62 72 82)
							305
						else
							301
						)
					show:
					setLoop: (+ (if (Random 0 1) 2 else 0) temp0)
					setCycle: Fwd
					posn: (if temp0 338 else -18) (Random 20 48)
					setMotion:
						MoveTo
						(if temp0 -18 else 338)
						(Random 20 48)
						self
				)
			)
			(2
				(birdie hide:)
				(= seconds (Random 6 14))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

