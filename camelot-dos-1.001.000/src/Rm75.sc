;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm75 0
	pillar 1
	thief 2
	thiefKeepsGoing 3
)

(instance thief of Act
	(properties
		y 88
		x 263
		yStep 4
		view 345
		loop 3
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
				(Print 75 0) ; "Catch him, Arthur! He must not escape!"
			)
		)
	)
)

(instance pillar of Act
	(properties
		y 118
		x 260
		view 175
		priority 6
		signal 20480
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(self setPri: 7)
	)
)

(instance Rm75 of Rm
	(properties
		picture 75
	)

	(method (init)
		(Load rsVIEW 51)
		(Load rsVIEW 50)
		(Load rsSOUND (proc0_20 111))
		(Load rsSOUND 118)
		(Load rsSOUND 119)
		(super init:)
		(if (not (IsFlag 208))
			(if (IsFlag 207)
				(if (not (IsFlag 208))
					(self setRegions: 177) ; stoneDove
				)
			else
				(self setRegions: 186) ; SaracenRgn
			)
		)
		(self setRegions: 135) ; Temple
		(self setRegions: 181) ; Thief
		(pillar init: stopUpd:)
		(if (IsFlag 196)
			(pillar posn: 278 118)
		else
			(pillar posn: 260 118)
		)
		(switch gPrevRoomNum
			(133 ; finalBattle
				(gEgo posn: (gEgo x:) (gEgo y:))
			)
			(76
				(gEgo posn: (gEgo x:) 60)
				(if (> (gEgo x:) 250)
					(gEgo x: 250)
				)
			)
			(78
				(gEgo posn: 10 (gEgo y:))
			)
			(else
				(gEgo posn: 100 100)
			)
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
			((< (gEgo x:) 10)
				(gCurRoom newRoom: 78)
			)
			(
				(and
					(< (gEgo y:) 50)
					(gEgo mover:)
					(< ((gEgo mover:) dy:) 0)
					(> (gEgo x:) 78)
				)
				(gCurRoom newRoom: 76)
			)
		)
		(if (IsFlag 219)
			(ClearFlag 219)
			(DisposeScript 191)
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
								(Print 75 1) ; "Hurry! You must not let him out of your sight for an instant!"
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 75 2) ; "You will never see it again unless you catch that Thief!"
							)
							(else
								(Print 75 3) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
								(event claimed: 1)
							)
						)
					)
					(
						(Said
							'stop,get,kill,annihilate,attack,prevent,search/bandit'
						)
						(Print 75 4) ; "First, you must catch him!"
					)
					((Said 'capture/bandit')
						(Print 75 5) ; "Do not stand there then! Chase him!"
					)
					((Said 'talk[<to]/bandit')
						(Print 75 6) ; "First you must catch him and quickly!"
					)
					((Said 'get,get/grail')
						(Print 75 7) ; "Aye, you must, but only if you catch the Thief!"
					)
					((Said 'draw/blade')
						(Print 75 8) ; "First catch the Thief, then decide how to deal with him."
						(gEgo setScript: (ScriptID 198 1)) ; sheathSwordAndRun
					)
					((Said 'fuck')
						(Print 75 9) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(else
						(Print 75 3) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
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
							(OnButton event 259 12 311 51)
							(OnButton event 277 51 310 105)
							(OnButton event 254 62 278 102)
							(OnButton event 224 75 298 123)
							(OnButton event 237 118 309 168)
							(OnButton event 249 166 293 182)
							(OnButton event 141 121 216 169)
							(OnButton event 39 151 100 182)
						)
						(if (IsFlag 208)
							(Print 75 10) ; "Each broken pillar looks much the same as its neighbor. You must find the right one by your wits."
						else
							(Print 75 11) ; "The elegant marble pillars which once held a roof have all been broken and thrown down, the work of those who would destroy the worship of Aphrodite."
						)
					)
					(
						(or
							(OnButton event 156 15 169 20)
							(OnButton event 107 46 113 51)
							(OnButton event 146 45 157 52)
							(OnButton event 237 31 242 39)
							(OnButton event 233 48 239 58)
							(OnButton event 38 57 46 60)
							(OnButton event 17 92 32 94)
							(OnButton event 43 84 65 91)
							(OnButton event 91 77 101 80)
							(OnButton event 152 64 162 70)
							(OnButton event 212 78 216 84)
							(OnButton event 77 102 89 110)
							(OnButton event 180 90 195 100)
							(OnButton event 21 139 33 145)
							(OnButton event 50 136 66 142)
							(OnButton event 123 107 150 125)
							(OnButton event 124 159 131 170)
						)
						(Print 75 12) ; "They are common weeds, of no interest."
					)
					(
						(or
							(OnButton event 26 7 68 39)
							(OnButton event 9 21 31 45)
						)
						(Print 75 13) ; "The round pedestal in the center of the temple's ruins must have once held an altar or statue, but is empty now."
					)
				)
			)
		)
	)
)

(instance thiefKeepsGoing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thief setMotion: MoveTo 0 83 self)
			)
			(1
				(client dispose:)
			)
		)
	)
)

