;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use n828)
(use Game)
(use System)

(public
	tahiti 0
	tookTooLongScript 1
	braxMadScript 2
)

(local
	local0
	local1
)

(class tahiti of Rgn
	(properties
		flags 0
		volley 0
		pointFlag 0
		whichSong 0
	)

	(method (newRoom newRoomNumber)
		(= keep
			(OneOf
				newRoomNumber
				1 ; openingScene
				2 ; thatchedHut
				3 ; volleyRm
				4 ; beachHuts1
				5 ; beachHuts2
				6 ; inEgosHut
				7 ; endBeach
				8 ; HutSwimRm
				9 ; hotelEntrance
				10 ; inLobby
				11 ; hotelBar
				12 ; beachHuts3
				13 ; beachHuts4
				14 ; inHerHut
				16 ; beachSwimRm
				15 ; tahitiOcean2
				199 ; danceRm
				24 ; eastBeachRm
				8 ; HutSwimRm
				16 ; beachSwimRm
			)
		)
		(= initialized 0)
		(gEgo illegalBits: -32768)
		(super newRoom: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'climb[/palm]')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'look[<at]/shoe,sandal')
				(Print 300 0) ; "They are just ordinary sandals."
			)
			((Said 'remove,(get<off)/shoe,sandal')
				(Print 300 1) ; "You can't do that."
			)
			((Said '(get<off),remove/shirt')
				(cond
					((== gCurRoomNum 2) ; thatchedHut
						(event claimed: 0)
					)
					((== (gEgo view:) 206)
						(proc0_33) ; "Not now!"
					)
					(else
						(Print 300 2) ; "It is off."
					)
				)
			)
			((Said 'look[<in]/pocket')
				(cond
					((== gCurRoomNum 6) ; inEgosHut
						(event claimed: 0)
					)
					((== (gEgo view:) 206)
						(Print 300 3) ; "Nothing in there!"
					)
					(else
						(Print 300 4) ; "No pockets here!"
					)
				)
			)
			((Said 'look<down')
				(Print 300 5) ; "Your feet are below you."
			)
			((not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(event claimed: 0)
			)
			((Said 'look<in,in/earring')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 300 6) ; "The interior is hollow."
					)
					((== local0 1)
						(Print 300 7) ; "Inside you see a piece of microfilm."
						(Print 300 8) ; "MERCY MERCY!" you think to yourself, "That beautiful woman is an 'undercover' AGENT!"
						(Print 300 9) ; ""But for whom?" you add as an afterthought."
						(gGame changeScore: 1)
						(= local0 2)
					)
					((== local0 2)
						(Print 300 7) ; "Inside you see a piece of microfilm."
					)
					(else
						(Print 300 10) ; "It's not open."
					)
				)
			)
			((Said 'look[<at]/earring')
				(if local1
					(Print 300 11) ; "It appears the top of the earring can be opened."
				else
					(Print 300 12) ; "You take a close look after brushing the sand off.  It appears the top of the earring can be opened."
					(= local1 1)
				)
			)
			((or (Said 'open,remove,(get<off)/top') (Said 'open/earring'))
				(if (> local0 0)
					(proc0_31) ; "It is."
				else
					(Print 300 13) ; "After carefully removing the top, you discover the earring to be hollow."
					(= local0 1)
				)
			)
			((Said 'get/film')
				(if (== local0 2)
					(Print 300 14) ; "You remove the microfilm."
					(gEgo get: 1) ; Microfilm
				else
					(event claimed: 0)
				)
			)
			((Said 'look/film')
				(cond
					((gEgo has: 1) ; Microfilm
						(SetScore tahiti 413 16 4)
						(event claimed: 0)
					)
					((== local0 2)
						(Print 300 15) ; "It's hard to see. It's crammed down in the earring."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance tookTooLongScript of Script
	(properties
		cycles 1200
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(EgoDead 907 3 0 300 16) ; "You took too long and missed your plane. Now you'll spend your life picking sugar cane"
			)
		)
	)
)

(instance braxMadScript of Script
	(properties
		cycles 2000
	)

	(method (changeState newState)
		(switch (= state newState)
			(1 0)
		)
	)
)

