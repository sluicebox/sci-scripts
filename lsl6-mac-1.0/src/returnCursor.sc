;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n076)
(use n078)
(use n912)
(use Print)
(use System)

(public
	returnCursor 0
	unknown_93_2 1
	unknown_93_3 2
	unknown_93_4 3
	unknown_93_5 4
	unknown_93_6 5
	menuBar 6
	unknown_93_7 7
	unknown_93_8 8
	unknown_93_9 9
)

(local
	local0
	local1
)

(instance menuBar of Class_912_0
	(properties)

	(method (draw)
		(= state 1)
		(DrawStatus {                  Shape Up or Slip Out} 75 56)
	)
)

(instance returnCursor of Script
	(properties)

	(method (cue)
		(if (!= gCurRoomNum 740)
			(gGame setCursor: local0)
		else
			(gGame setCursor: gWaitCursor)
		)
	)
)

(instance unknown_93_2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gCurRoomNum 740)
					(= local0 gTheCursor)
					(gGame setCursor: gNormalCursor)
					(gGame setScript: unknown_93_10)
					(= ticks 60)
				else
					(gGlobalSound1 pause:)
					(gMessager say: 4 0 3 1 self 93) ; "Interface help is unavailable at this time."
				)
			)
			(1
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(2
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(if (== gCurRoomNum 740)
					(gGlobalSound1 pause:)
				)
				(= ticks 60)
			)
			(1
				(Message msgGET 93 3 0 2 1 global186) ; "Customer Service"
				(gMessager say: 3 0 0 0 self 93) ; "If you're having technical problems with this game, call Sierra's "Robo-Tech" at 209 683-8989 or fax your problems to 209 683-3633."
			)
			(2
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(3
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(if (== gCurRoomNum 740)
					(gGlobalSound1 pause:)
				)
				(= ticks 60)
			)
			(1
				(Message msgGET 93 5 0 2 1 global186) ; "Hint Book"
				(Print
					addTitle: global186
					addText: 5 0 0 1 0 0 93 ; "Completely erase everything on this hard disk?  Press Cancel to prevent catastrophe or  Press OK to lose everything..."
					addButton: 100 5 0 1 1 0 70 93 ; "OK"
					init: self
				)
			)
			(2
				(gMessager say: 5 0 0 2 self 93 oneOnly: 0) ; "Ha, ha, just kidding! Here's a blatantly commercial message about the fine line of Sierra Hint Books."
			)
			(3
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(4
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(= ticks 60)
				(if (== gCurRoomNum 740)
					(gGlobalSound1 pause:)
				)
			)
			(1
				(Message msgGET 93 6 0 2 1 global186) ; "Other Al Lowe Games"
				(gMessager say: 6 0 0 0 self 93) ; ""Shape Up or Slip Out!" is another in the long line of laughable Laffer software from Sierra and Al Lowe, World's Oldest Bald Bearded Computer Game Designer."
			)
			(2
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(3
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_6 of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(= local0 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(if (== gCurRoomNum 740)
					(gGlobalSound1 pause:)
				)
				(= ticks 60)
			)
			(1
				(Message msgGET 93 8 0 2 1 global186) ; "Shape Up or Slip Out!"
				(gMessager say: 8 0 0 1 12 self 93) ; ""Shape Up or Slip Out!" is an Up & Coming Production, Copyright 1993 by Sierra Publishing, a division of Sierra On-Line, Inc. Any resemblance to any characters, living or dead, means you need to find a better set of friends!"
			)
			(2
				(Message msgGET 93 8 0 0 13 @temp0) ; "December 24, 1993    Version %s"
				(Print addTitle: 8 0 2 1 93 addTextF: @temp0 gVersion init: self)
			)
			(3
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(4
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc76_0)
			)
		)
	)
)

(instance unknown_93_8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc78_1)
			)
		)
	)
)

(instance unknown_93_9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(if (== gCurRoomNum 740)
					(gGlobalSound1 pause:)
				)
				(= ticks 60)
			)
			(1
				(Message msgGET 93 2 0 2 1 global186) ; "Keyboard Fun"
				(gMessager say: 2 0 0 0 self 93) ; "Press 1, 2, 3, 4, 5, 6, 7, 8, 9, and 0 for a surprise."
			)
			(2
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 -1)
				)
				(= cycles 1)
			)
			(3
				(gGame setCursor: local0)
				(if (== gCurRoomNum 740)
					(Platform 0 4 2 6)
					(gGlobalSound1 pause: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance unknown_93_10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 4 0 2 1 global186) ; "Interface Help"
				(gMessager say: 4 0 0 1 self 93) ; "Click once to clear this message. When you do, your cursor will change into a Question Mark. Pass the Question Mark over the other areas of the screen to learn what they do. When you are done, click again anywhere to turn off these messages."
			)
			(1
				((ScriptID 75 0) init: doit: dispose:) ; nClickHelp
				(gGame setCursor: local0)
				(Platform 0 4 2 -1)
				(Platform 0 4 2 6)
				(self dispose:)
			)
		)
	)
)

