;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use Actor)

(public
	rm318 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (localproc_0 param1 param2)
	(Print param2 #at -1 12 #mode 1 #width param1)
)

(procedure (localproc_1)
	(switch local10
		(1
			(local9 cel: 0 posn: 60 108 stopUpd:)
		)
		(2
			(local9 cel: 1 posn: 120 105 stopUpd:)
		)
		(3
			(local9 cel: 0 posn: 197 106 stopUpd:)
		)
		(4
			(local9 cel: 2 posn: 100 154 stopUpd:)
		)
		(5
			(local9 cel: 0 posn: 176 155 stopUpd:)
		)
		(6
			(local9 cel: 3 posn: 263 146 stopUpd:)
		)
		(7
			(local9 cel: 4 posn: 247 187 stopUpd:)
		)
	)
)

(procedure (localproc_2 &tmp [temp0 4] [temp4 400])
	(switch local10
		(1
			(Format @temp4 318 0) ; "Reward for return of lost ring. Inquire at the Healer's."
			(localproc_0 185 @temp4)
		)
		(2
			(Format @temp4 318 1) ; "This poster is rather dusty and faded. The picture is of a small child with braids. "Reward of 50 gold coins for the safe return of Elsa von Spielburg. Inquire at Spielburg Castle gates.""
			(localproc_0 260 @temp4)
		)
		(3
			(Format @temp4 318 2) ; "Reward of 30 gold coins for the Capture or Death of the Brigand Warlock. Description: short, ugly, and wears brightly colored robes. Has habit of laughing continually. Inquire at Spielburg Castle gates."
			(localproc_0 200 @temp4)
		)
		(4
			(Format @temp4 318 3) ; "Wanted: Brigand Leader. Description: Unknown appearance, wears a cloak. Must provide proof of leader's identity. Reward of 60 gold coins and title of Hero of the Realm. Inquire at Spielburg Castle gates."
			(localproc_0 300 @temp4)
		)
		(5
			(Format @temp4 318 4) ; "Notice: Spell components needed. Cash or trade for potions. Inquire at the Healer's."
			(localproc_0 200 @temp4)
		)
		(6
			(SetFlag 355)
			(Format @temp4 318 5) ; "This poster seems to have been here a while. It has a picture of a handsome, but arrogant young man. "Reward of 50 gold coins for information leading to the return of Baronet Barnard von Spielburg. Inquire at Spielburg Castle gates.""
			(localproc_0 280 @temp4)
		)
		(7
			(gCurRoom newRoom: 311)
		)
	)
)

(instance rm318 of Rm
	(properties
		picture 318
		style 7
	)

	(method (init)
		(Load rsVIEW 318)
		(super init:)
		(gMouseHandler add: self)
		(gKeyHandler add: self)
		(gDirHandler add: self)
		(SL enable:)
		(User canControl: 0)
		((= local0 (View new:))
			view: 318
			loop: 0
			cel: 1
			posn: 60 76
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local1 (View new:))
			view: 318
			loop: 0
			cel: 1
			posn: 120 70
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local2 (View new:))
			view: 318
			loop: 0
			cel: 1
			posn: 197 74
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local3 (View new:))
			view: 318
			loop: 0
			cel: 0
			posn: 100 124
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local4 (View new:))
			view: 318
			loop: 0
			cel: 2
			posn: 175 123
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local5 (View new:))
			view: 318
			loop: 0
			cel: 1
			posn: 263 104
			setPri: 0
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local6 (View new:))
			view: 318
			loop: 1
			cel: 0
			posn: 119 84
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local7 (View new:))
			view: 318
			loop: 1
			cel: 1
			posn: 262 120
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((= local8 (View new:))
			view: 318
			loop: 0
			cel: 0
			posn: 100 124
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		(= local10 1)
		((= local9 (View new:))
			view: 318
			loop: 2
			cel: 0
			posn: 60 108
			setPri: 1
			init:
			ignoreActors:
			stopUpd:
		)
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(gKeyHandler delete: self)
		(gDirHandler delete: self)
		(User canControl: 1)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evMOUSEBUTTON
				(= temp1 0)
				(switch (= temp0 (OnControl CONTROL (event x:) (event y:)))
					(2
						(= temp1 1)
					)
					(4
						(= temp1 2)
					)
					(8
						(= temp1 3)
					)
					(16
						(= temp1 4)
					)
					(32
						(= temp1 5)
					)
					(64
						(= temp1 6)
					)
					(16384
						(= local10 7)
						(localproc_1)
						(RedrawCast)
						(event claimed: 1)
						(gCurRoom newRoom: 311)
					)
				)
				(event claimed: 1)
				(localproc_1)
				(if temp1
					(= local10 temp1)
					(localproc_1)
					(RedrawCast)
					(localproc_2)
				)
			)
			(evSAID
				(cond
					((Said 'stop,done,done,done')
						(event claimed: 1)
						(gCurRoom newRoom: 311)
					)
					((Said 'look')
						(event claimed: 1)
						(localproc_2)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if (< (-= local10 3) 1)
							(+= local10 7)
						)
					)
					(JOY_RIGHT
						(if (> (++ local10) 7)
							(= local10 1)
						)
					)
					(JOY_DOWN
						(if (> (+= local10 3) 7)
							(-= local10 7)
						)
					)
					(JOY_LEFT
						(if (< (-- local10) 1)
							(= local10 7)
						)
					)
				)
				(event claimed: 1)
				(localproc_1)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(localproc_2)
					(if (> (++ local10) 7)
						(= local10 1)
					)
					(localproc_1)
				)
			)
		)
		(super handleEvent: event)
	)
)

