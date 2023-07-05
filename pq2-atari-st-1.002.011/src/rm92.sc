;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm92 0
)

(instance rm92 of Rm
	(properties
		picture 92
		style 6
	)

	(method (init)
		(User canInput: 0 canControl: 0)
		(Load rsVIEW 290)
		(Load rsVIEW 291)
		((View new:)
			view: 291
			loop: 0
			cel: 0
			posn: 62 46
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 291
			loop: 0
			cel: 1
			posn: 186 46
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 0
			cel: 0
			posn: 59 135
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 0
			cel: 3
			posn: 212 189
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 0
			cel: 1
			posn: 280 61
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 3
			cel: 0
			posn: 263 132
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 3
			cel: 1
			posn: 281 148
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 3
			cel: 2
			posn: 279 160
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 4
			cel: 0
			posn: 279 189
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 4
			cel: 1
			posn: 159 189
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 0
			cel: 2
			posn: 158 139
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 1
			cel: 0
			posn: 59 168
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 1
			cel: 1
			posn: 59 189
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 2
			cel: 0
			posn: 160 83
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 290
			loop: 2
			cel: (Random 1 4)
			posn: 160 163
			init:
			stopUpd:
			addToPic:
		)
		(super init:)
		(self setScript: rm92Script)
	)
)

(instance rm92Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SL enable:)
				(Timer setReal: self 5)
			)
			(1
				(EgoDead
					{I'll write to you at\nHappy Meadows!\nThanks for playing\nPolice Quest II.\nNext time, CALM DOWN!}
				)
			)
		)
	)
)

