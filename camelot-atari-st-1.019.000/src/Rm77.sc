;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Rm77 0
)

(instance Rm77 of Rm
	(properties
		picture 77
	)

	(method (init)
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
		(switch gPrevRoomNum
			(133 ; finalBattle
				(gEgo posn: (gEgo x:) (gEgo y:))
			)
			(76
				(gEgo posn: 310 (gEgo y:))
			)
			(78
				(gEgo posn: (gEgo x:) 180)
			)
			(else
				(gEgo posn: 300 100 loop: 1)
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
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 76)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 78)
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
								(Print 77 0) ; "Hurry! You must not let him out of your sight for an instant!"
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 77 1) ; "You will never see it again unless you catch that Thief!"
							)
							(else
								(Print 77 2) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
								(event claimed: 1)
							)
						)
					)
					(
						(Said
							'stop,get,kill,annihilate,attack,prevent,search/bandit'
						)
						(Print 77 3) ; "First, you must catch him!"
					)
					((Said 'capture/bandit')
						(Print 77 4) ; "Do not stand there then! Chase him!"
					)
					((Said 'talk[<to]/bandit')
						(Print 77 5) ; "First you must catch him and quickly!"
					)
					((Said 'get,get/grail')
						(Print 77 6) ; "Aye, you must, but only if you catch the Thief!"
					)
					((Said 'draw/blade')
						(Print 77 7) ; "First catch the Thief, then decide how to deal with him."
						(gEgo setScript: (ScriptID 198 1)) ; sheathSwordAndRun
					)
					((Said 'fuck')
						(Print 77 8) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(else
						(Print 77 2) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
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
							(OnButton event 8 65 37 110)
							(OnButton event 17 49 74 79)
							(OnButton event 74 23 128 84)
							(OnButton event 114 33 174 72)
							(OnButton event 172 36 252 56)
							(OnButton event 255 34 306 66)
						)
						(if (IsFlag 208)
							(Print 77 9) ; "Each broken pillar looks much the same as its neighbor. You must find the right one by your wits."
						else
							(Print 77 10) ; "The elegant marble pillars which once held a roof have all been broken and thrown down, the work of those who would destroy the worship of Aphrodite."
						)
					)
					(
						(or
							(OnButton event 44 92 67 98)
							(OnButton event 91 102 113 107)
							(OnButton event 118 96 128 101)
							(OnButton event 149 115 160 119)
							(OnButton event 33 165 49 173)
							(OnButton event 53 156 63 162)
							(OnButton event 64 148 72 155)
							(OnButton event 216 162 244 173)
						)
						(Print 77 11) ; "They are common weeds, of no interest."
					)
					((OnButton event 258 155 293 182)
						(Print 77 12) ; "The round pedestal in the center of the temple's ruins must have once held an altar or statue, but is empty now."
					)
					(
						(or
							(OnButton event 26 7 293 20)
							(OnButton event 9 20 310 56)
						)
						(Print 77 13) ; "The walls which encompass these ruins have deliberately been build without windows or doors, to enclose and hide this ruin."
					)
					((or (Said '/depression') (Said '//depression'))
						(Print 77 14) ; "The indentation once held a pillar."
					)
				)
			)
		)
	)
)

