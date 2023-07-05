;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use Game)
(use System)

(public
	tahiti 0
	tookTooLongScript 1
	braxMadScript 2
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
			((Said 'look[<at]/feet')
				(Print 300 1) ; "Those are your feet, alright."
			)
			((Said 'detach,(get<off)/shoe,sandal')
				(Print 300 2) ; "You can't do that."
			)
			((Said '(adjust<on),wear/shirt')
				(cond
					((OneOf gCurRoomNum 2 14) ; thatchedHut, inHerHut
						(event claimed: 0)
					)
					((== (gEgo view:) 206)
						(Print 300 3) ; "It is on."
					)
					(else
						(proc0_33) ; "Not now!"
					)
				)
			)
			((Said '(get<off),detach/shirt')
				(cond
					((OneOf gCurRoomNum 2 14) ; thatchedHut, inHerHut
						(event claimed: 0)
					)
					((== (gEgo view:) 206)
						(proc0_33) ; "Not now!"
					)
					(else
						(Print 300 4) ; "It is off."
					)
				)
			)
			((Said 'look[<in]/pocket')
				(cond
					((== gCurRoomNum 6) ; inEgosHut
						(event claimed: 0)
					)
					((== (gEgo view:) 206)
						(Print 300 5) ; "Nothing in there!"
					)
					(else
						(Print 300 6) ; "No pockets here!"
					)
				)
			)
			((Said 'look<down')
				(Print 300 7) ; "Your feet are below you."
			)
			((and (Said '/earring,film,top>') (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(if (OneOf gCurRoomNum 11 6) ; hotelBar, inEgosHut
					(Print 300 8) ; "You can't do that here."
					(event claimed: 1)
				else
					((ScriptID 317) handleEvent: event) ; earRingFeat
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
		(if (= state newState)
			(EgoDead 907 3 0 300 9) ; "You took too long and missed your plane. Now you'll spend your life picking sugar cane."
		)
	)
)

(instance braxMadScript of Script
	(properties
		cycles 2000
	)

	(method (changeState newState)
		(= state newState)
	)
)

