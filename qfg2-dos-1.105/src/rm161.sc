;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 161)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm161 0
)

(local
	hiliter
	hilitPoster
)

(procedure (posterPrint theWidth theString)
	(Print theString #at -1 12 #mode 1 #width theWidth)
)

(procedure (changeHilite)
	(switch hilitPoster
		(1
			(hiliter cel: 0 posn: 94 94 stopUpd:)
		)
		(2
			(hiliter cel: 2 posn: 166 94 stopUpd:)
		)
		(3
			(hiliter cel: 3 posn: 223 126 stopUpd:)
		)
		(4
			(hiliter cel: 4 posn: 164 139 stopUpd:)
		)
		(5
			(hiliter cel: 1 posn: 111 142 stopUpd:)
		)
		(6
			(hiliter cel: 5 posn: 270 188 stopUpd:)
		)
	)
)

(procedure (readMessage &tmp [rectPoints 4] [str 400])
	(switch hilitPoster
		(1
			(Format @str 161 0) ; "There will be given to the one who restores the Emir Arus Al-Din to his rightful place in the palace at Raseir the sum of 1000 dinars. By order of the Sultan Harun Al-Rashid."
			(posterPrint 185 @str)
		)
		(2
			(Format @str 161 1) ; "He who is willing to brave the desert should seek Harik Attar in his shop at the sign of the mortar and pestle by the fountain. That one shall find rewards for his courage."
			(posterPrint 260 @str)
		)
		(3
			(Format @str 161 2) ; "There is needed for a Spell of Great Power the whirling part of a Dervish. Inquire at the Magic Shop. Keapon Laffin, Prop."
			(posterPrint 200 @str)
		)
		(4
			(Format @str 161 3) ; "Those who do service to the city and land of Shapeir shall know the rewards of goodness. By order of the Sultan Harun Al-Rashid."
			(posterPrint 300 @str)
		)
		(5
			(Format @str 161 4) ; "The Way of the Paladin: To seek. To learn. To do."
			(posterPrint 200 @str)
		)
		(6
			(gCurRoom newRoom: 160)
		)
	)
)

(instance rm161 of Rm
	(properties
		picture 161
		style 7
	)

	(method (init)
		(Load rsVIEW 161)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gDirectionHandler add: self)
		(SL enable:)
		(DontMove 1)
		(= gSpellChecker noSpells)
		(= hilitPoster 1)
		((= hiliter (View new:))
			view: 161
			loop: 2
			cel: 0
			posn: 94 94
			signal: 1
			init:
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(DontMove 0)
		(super dispose:)
	)

	(method (handleEvent event &tmp ctrlBits whichPoster)
		(switch (event type:)
			(evMOUSEBUTTON
				(= whichPoster 0)
				(switch (= ctrlBits (OnControl CONTROL (event x:) (event y:)))
					(512
						(= whichPoster 1)
					)
					(16384
						(= whichPoster 2)
					)
					(8192
						(= whichPoster 3)
					)
					(4096
						(= whichPoster 4)
					)
					(1024
						(= whichPoster 5)
					)
					(2048
						(= hilitPoster 6)
						(changeHilite)
						(RedrawCast)
						(event claimed: 1)
						(gCurRoom newRoom: 160)
					)
				)
				(event claimed: 1)
				(changeHilite)
				(if whichPoster
					(= hilitPoster whichPoster)
					(changeHilite)
					(RedrawCast)
					(readMessage)
				)
			)
			(evSAID
				(cond
					((Said 'stop,done,done,done')
						(event claimed: 1)
						(gCurRoom newRoom: 160)
					)
					((Said 'look,look')
						(event claimed: 1)
						(readMessage)
					)
				)
			)
			($0040 ; direction
				(switch (event message:)
					(JOY_UP
						(if (< (-= hilitPoster 3) 1)
							(+= hilitPoster 6)
						)
					)
					(JOY_RIGHT
						(if (> (++ hilitPoster) 6)
							(= hilitPoster 1)
						)
					)
					(JOY_DOWN
						(if (> (+= hilitPoster 3) 6)
							(-= hilitPoster 6)
						)
					)
					(JOY_LEFT
						(if (< (-- hilitPoster) 1)
							(= hilitPoster 6)
						)
					)
				)
				(event claimed: 1)
				(changeHilite)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(readMessage)
					(if (> (++ hilitPoster) 6)
						(= hilitPoster 1)
					)
					(changeHilite)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance noSpells of Code
	(properties)

	(method (doit spellNum)
		(cond
			((OneOf spellNum 1 2 3 4 5)
				(HighPrint 161 5) ; "Uhura would be angry if you threw that at her Quest Board."
			)
			((== spellNum 6)
				(HighPrint 161 6) ; "You will find better opportunities for social climbing by reading the quests."
			)
			(else
				(HighPrint 161 7) ; "There is no reason to cast a spell at the Quest Board."
			)
		)
		(return 0)
	)
)

