;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	inCave1Rm 0
)

(instance inCave1Rm of Rm
	(properties
		picture 59
		south 56
	)

	(method (init)
		(super init:)
		(gEgo init:)
		(self setRegions: 304) ; cavesRg
		(if (== gPrevRoomNum south)
			(gEgo posn: 143 133 loop: 3)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(if ((ScriptID 304 0) notify: 0) ; cavesRg
					(Print 59 0) ; "Looking around the large chamber you see what appears to be the opening to other chambers or tubes."
					(Print 59 1) ; "Thinking to yourself you wonder..."Now just which way would be the right way?""
				else
					(Print 59 2) ; "You strain your eyes in an attempt to see, but it's just too dark."
				)
			)
		)
	)
)

