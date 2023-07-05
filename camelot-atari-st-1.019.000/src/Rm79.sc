;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm79 0
)

(instance thief of Act
	(properties
		yStep 4
		view 345
		signal 16384
		illegalBits 0
		xStep 6
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(and
					(or
						(== (event type:) evMOUSEBUTTON)
						(Said 'look,(are<where)>')
						(Said 'ask[/merlin]/*>')
					)
					(or (Said '/bandit') (Said '//bandit'))
				)
				(Print 79 0) ; "Catch him, Arthur! He must not escape!"
			)
		)
	)
)

(instance leftBlock of Blk
	(properties
		left -10
		bottom 200
		right -5
	)
)

(instance bottomBlock of Blk
	(properties
		top 200
		left -10
		bottom 210
		right 330
	)
)

(instance Rm79 of Rm
	(properties
		picture 79
	)

	(method (init)
		(super init:)
		(self setRegions: 184) ; Alley
		(self setRegions: 181) ; Thief
		(= global112 3)
		(gEgo observeBlocks: leftBlock bottomBlock)
		(switch gPrevRoomNum
			(78
				(gEgo posn: 60 112 loop: 2)
			)
			(80
				(gEgo posn: 310 170 loop: 1)
			)
			(else
				(gEgo posn: 100 150)
			)
		)
		(if (and (IsFlag 197) (> global193 113))
			(thief init: setScript: thiefRunsAway)
		)
		(if (IsFlag 202)
			(gEgo view: 92 setStep: 6 4)
		)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo y:) 112)
				(gCurRoom newRoom: 78)
			)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 80)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(global193
				(cond
					(
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,(are<where)>')
							(Said 'ask[/merlin]/*>')
						)
						(cond
							((or (Said '/bandit') (Said '//bandit'))
								(Print 79 1) ; "The Thief ran this way. Catch him!"
							)
							((or (Said '/door') (Said '//door'))
								(Print 79 2) ; "Stop babbling and catch the Thief!"
							)
							((or (Said '/saracen') (Said '//saracen'))
								(Print 79 3) ; "He is dead, you fool! Catch the Thief!"
							)
							(
								(or
									(Said '/aphrodite,goddess')
									(Said '//aphrodite,goddess')
								)
								(Print 79 4) ; "She is gone, you fool! Catch the thief!"
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 79 5) ; "You will never see it again unless you catch that Thief!"
							)
							(else
								(Print 79 6) ; "Forget that! Catch the Thief!"
								(event claimed: 1)
							)
						)
					)
					((Said 'talk[<to]/saracen')
						(Print 79 3) ; "He is dead, you fool! Catch the Thief!"
					)
					((Said 'talk[<to]/aphrodite/goddess')
						(Print 79 4) ; "She is gone, you fool! Catch the thief!"
					)
					(
						(Said
							'stop,get,kill,annihilate,attack,prevent,search/bandit'
						)
						(Print 79 7) ; "First, you must catch him!"
					)
					((Said 'capture/bandit')
						(Print 79 8) ; "Do not stand there then! Chase him!"
					)
					((Said 'talk[<to]/bandit')
						(Print 79 9) ; "First you must catch him and quickly!"
					)
					((Said 'get,get/grail')
						(Print 79 10) ; "Aye, you must, but only if you catch the Thief!"
					)
					((Said 'draw/blade')
						(Print 79 11) ; "First catch the Thief, then decide how to deal with him."
						(gEgo setScript: (ScriptID 198 1)) ; sheathSwordAndRun
					)
					((Said 'fuck')
						(Print 79 12) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(else
						(Print 79 6) ; "Forget that! Catch the Thief!"
						(event claimed: 1)
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<!*][/room,alley]')
							(Said '//room,alley')
							(Said 'look<around')
						)
						(if (< (gEgo y:) 167)
							(Print 79 13) ; "The alley is bounded by tall buildings without windows or doors. It takes a sharp turn not far from the Temple stairs."
						else
							(Print 79 14) ; "Just around the bend in the alley, there is a tiny grate in the bottom of the wall. Otherwise, there seem to be no windows or doors in these walls."
						)
					)
					((Said '<below/column')
						(Print 79 15) ; "The fallen pillars are too heavy to look under."
					)
					(
						(or
							(Said '/temple')
							(Said '//temple')
							(OnButton event 17 52 114 84)
						)
						(if (IsFlag 207)
							(Print 79 16) ; "Why do you waste time here? The Temple awaits you but a few steps away."
						else
							(Print 79 17) ; "This appears to be the only way in or out of the Temple."
						)
					)
					(
						(or
							(Said '/column')
							(Said '//column')
							(OnButton event 17 94 34 124)
							(OnButton event 92 85 114 129)
						)
						(Print 79 18) ; "They are the fallen marble pillars that once formed the Temple of Aphrodite."
					)
					(
						(or
							(Said '/grate,bar,drain,window')
							(Said '//grate,bar,drain,window')
							(OnButton event 228 151 268 166)
						)
						(if (< (gEgo y:) 167)
							(if (not (OnButton event 228 151 268 166))
								(Print 79 19) ; "There is none here."
							)
						else
							(Print 79 20) ; "There is a tiny grate or barred opening of some sort at the base of this wall."
						)
					)
					(
						(or
							(Said '/tree')
							(Said '//tree')
							(OnButton event 49 10 70 21)
							(OnButton event 87 9 109 25)
						)
						(Print 79 21) ; "There are a few trees rising above the high walls that encircle the Temple."
					)
					(
						(or
							(Said '/ceiling')
							(Said '//ceiling')
							(OnButton event 26 13 49 21)
							(OnButton event 72 15 87 20)
						)
						(Print 79 22) ; "A few roofs can be glimpsed in the distance, for all the good it does you."
					)
					(
						(or
							(Said '/stair,entrance,exit,threshold')
							(Said '//stair,entrance,exit,threshold')
							(OnButton event 37 82 90 114)
						)
						(Print 79 23) ; "The stairs and only entrance to the Temple face the alley where once they must have faced a major street."
					)
					((OnButton event 19 21 113 51)
						(Print 79 24) ; "It is one of the walls which enclose the temple."
					)
				)
			)
			((Said 'get/grail')
				(Print 79 25) ; "Aye, that IS your mission. Do get on with it."
			)
		)
	)
)

(instance thiefRunsAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thief setCycle: Fwd)
				(if (< global193 210)
					(+= global193 33)
				)
				(cond
					((> global193 222)
						(self changeState: 1)
					)
					((> global193 162)
						(self changeState: 2)
					)
					((> global193 131)
						(self changeState: 3)
					)
					(else
						(self changeState: 6)
					)
				)
			)
			(1
				(thief setLoop: 4 posn: 80 130 setMotion: MoveTo 83 140 self)
			)
			(2
				(thief setLoop: 4 posn: 83 140 setMotion: MoveTo 100 166 self)
			)
			(3
				(thief
					setLoop: 5
					posn: 100 166
					setMotion: MoveTo 500 500
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(4
				(thief setMotion: MoveTo 500 300 setCycle: CT 3 1 self)
			)
			(5
				(thief setMotion: MoveTo 500 180 setCycle: CT 5 1 self)
			)
			(6
				(thief
					setLoop: 2
					posn: 122 176
					setCycle: Fwd
					setMotion: MoveTo 322 179 self
				)
			)
			(7
				(thief dispose:)
				(self dispose:)
			)
		)
	)
)

