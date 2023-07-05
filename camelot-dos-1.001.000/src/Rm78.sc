;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm78 0
)

(local
	local0
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
				(Print 78 0) ; "Catch him, Arthur! He must not escape!"
			)
		)
	)
)

(instance Rm78 of Rm
	(properties
		picture 78
	)

	(method (init)
		(if (and (not (IsFlag 208)) (IsFlag 207))
			(Load rsSCRIPT 188)
			(Load rsSOUND 117)
			(Load rsSOUND 110)
			(Load rsVIEW 178)
			(Load rsVIEW 96)
		)
		(super init:)
		(if (not (IsFlag 208))
			(if (IsFlag 207)
				(if (and (not (IsFlag 208)) (not (IsFlag 211)))
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
			(75
				(gEgo posn: 310 (gEgo y:))
			)
			(77
				(gEgo posn: (gEgo x:) 50)
				(if (> (gEgo x:) 239)
					(gEgo x: 239)
				)
				(if (< (gEgo x:) 65)
					(gEgo x: 65)
				)
			)
			(79
				(gEgo posn: -5 106 setScript: goUpStairs)
			)
			(else
				(gEgo posn: 100 100)
			)
		)
		(if (and (IsFlag 197) (> global193 263))
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
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 75)
			)
			(
				(and
					(< (gEgo y:) 50)
					(gEgo mover:)
					(< ((gEgo mover:) dy:) 0)
					(< 62 (gEgo x:) 240)
				)
				(gCurRoom newRoom: 77)
			)
			((and (== (gEgo script:) 0) (& (gEgo onControl:) $0002))
				(HandsOff)
				(gEgo setScript: goDownStairs)
			)
		)
		(if
			(and
				(< (gEgo x:) 94)
				(not (gEgo script:))
				(User canControl:)
				(IsFlag 203)
			)
			(if (> global194 122)
				(= global194 122)
			)
			(HandsOff)
			(gEgo setMotion: MoveTo 116 (gEgo y:))
		)
		(if (IsFlag 205)
			((ScriptID 188 0) setScript: (ScriptID 188 1)) ; aphrodite, apparition
			(ClearFlag 205)
			(= global194 0)
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
								(Print 78 1) ; "Hurry! You must not let him out of your sight for an instant!"
							)
							((or (Said '/grail') (Said '//grail'))
								(Print 78 2) ; "You will never see it again unless you catch that Thief!"
							)
							(else
								(Print 78 3) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
								(event claimed: 1)
							)
						)
					)
					(
						(Said
							'stop,get,kill,annihilate,attack,prevent,search/bandit'
						)
						(Print 78 4) ; "First, you must catch him!"
					)
					((Said 'capture/bandit')
						(Print 78 5) ; "Do not stand there then! Chase him!"
					)
					((Said 'talk[<to]/bandit')
						(Print 78 6) ; "First you must catch him and quickly!"
					)
					((Said 'get,get/grail')
						(Print 78 7) ; "Aye, you must, but only if you catch the Thief!"
					)
					((Said 'draw/blade')
						(Print 78 8) ; "First catch the Thief, then decide how to deal with him."
						(gEgo setScript: (ScriptID 198 1)) ; sheathSwordAndRun
					)
					((Said 'fuck')
						(Print 78 9) ; "I can hardly blame you for being upset, but it will take more than foul language to catch the thief."
					)
					(else
						(Print 78 3) ; "Arthur, nothing else matters except that you catch that thief and retrieve the Grail at once!"
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
							(OnButton event 8 21 53 41)
							(OnButton event 25 6 42 20)
							(OnButton event 8 114 25 169)
							(OnButton event 28 113 52 182)
							(OnButton event 52 130 73 143)
							(OnButton event 73 143 103 182)
							(OnButton event 111 121 179 170)
							(OnButton event 141 156 217 183)
							(OnButton event 215 105 283 182)
						)
						(if (IsFlag 208)
							(Print 78 10) ; "Each broken pillar looks much the same as its neighbor. You must find the right one by your wits."
						else
							(Print 78 11) ; "The elegant marble pillars which once held a roof have all been broken and thrown down, the work of those who would destroy the worship of Aphrodite."
						)
					)
					(
						(or
							(OnButton event 124 19 140 29)
							(OnButton event 94 56 107 62)
							(OnButton event 121 98 133 106)
							(OnButton event 149 109 165 120)
							(OnButton event 190 94 202 102)
							(OnButton event 199 142 207 153)
							(OnButton event 209 20 223 29)
							(OnButton event 218 43 231 54)
							(OnButton event 227 84 242 91)
							(OnButton event 241 65 258 72)
						)
						(Print 78 12) ; "They are common weeds, of no interest."
					)
					(
						(or
							(OnButton event 245 7 293 21)
							(OnButton event 247 20 310 45)
						)
						(Print 78 13) ; "The round pedestal in the center of the temple's ruins must have once held an altar or statue, but is empty now."
					)
					(
						(or
							(Said '/threshold,spiral')
							(Said '//threshold,spiral')
							(OnButton event 55 57 114 91)
						)
						(SetScore 285 1 5)
						(Print 78 14) ; "The spiral carved into the threshold is lunar. That is, it turns to the left and denotes feminine power and influence."
					)
					((or (Said '/alley,stair') (OnButton event 7 64 67 101))
						(Print 78 15) ; "The steps lead down into a narrow alley."
					)
					((or (Said '/depression') (Said '//depression'))
						(Print 78 16) ; "The indentation once held a pillar."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance goDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gEgo)
					(gEgo cel: (if (IsFlag 202) 2 else 7))
				)
				(client illegalBits: 0 setPri: 4 setMotion: MoveTo -15 110 self)
			)
			(1
				(if (== client gEgo)
					(gCurRoom newRoom: 79)
				else
					(client dispose:)
				)
			)
		)
	)
)

(instance goUpStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client
					setPri: 4
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 10 (gEgo y:) self
				)
			)
			(1
				(if (== (gEgo view:) 92)
					(client setMotion: MoveTo 75 72 self)
				else
					(client setMotion: MoveTo 70 76 self)
				)
			)
			(2
				(client setPri: -1 illegalBits: -32768 ignoreActors: 0)
				(HandsOn)
				(self dispose:)
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
				(cond
					((> global193 375)
						(thief posn: (- 275 (- 425 global193)) 74)
						(self changeState: 1)
					)
					((> global193 337)
						(thief posn: (- 222 (- 375 global193)) 70)
						(self changeState: 2)
					)
					((> global193 298)
						(thief posn: (- 148 (- 337 global193)) 60)
						(self changeState: 3)
					)
					(else
						(self changeState: 4)
					)
				)
			)
			(1
				(thief setLoop: 3 setMotion: MoveTo 222 70 self)
			)
			(2
				(thief setLoop: 3 setMotion: MoveTo 148 68 self)
			)
			(3
				(thief setLoop: 3 setMotion: MoveTo 59 84 self)
			)
			(4
				(thief setLoop: 3 posn: 59 84 setScript: goDownStairs)
				(self dispose:)
			)
		)
	)
)

