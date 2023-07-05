;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 452)
(include sci.sh)
(use Main)
(use n013)
(use rhEgo)
(use RTEyeCycle)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	abbey 0
	aMonk 1
	regTimer 2
	noBlow 3
)

(local
	[local0 5] = [1452 1 1 2 0]
	[local5 4] = [1452 3 1 0]
	[local9 4] = [1452 4 1 0]
	[local13 4] = [1452 6 1 0]
	[local17 4] = [1452 7 1 0]
	[local21 4] = [1452 8 1 0]
	[local25 4] = [1452 11 1 0]
	[local29 8] = [1452 9 1 0 1452 30 1 0]
	[local37 6] = [1452 13 2 1 2 0]
	[local43 6] = [1452 13 2 1 2 0]
	[local49 6] = [1452 13 2 1 2 0]
	[local55 6] = [1452 13 2 1 2 0]
	[local61 4] = [1452 22 1 0]
	[local65 5] = [1452 26 1 1 0]
	local70
)

(instance abbey of Rgn
	(properties)

	(method (init)
		(gTheIconBar disable: 5)
		(= local70 gCast)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(if (and (!= local70 gCast) (!= script dangerBox) (IsFlag 126))
			(dangerBox next: script)
			(= script 0)
			(self setScript: dangerBox)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(Converse @local9 9) ; "I've no need to use my bow here and precious little time to waste!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aMonk of Actor
	(properties
		view 434
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1452 0) ; "They all look fat and ugly to me."
			)
			(5 ; Talk
				(Converse @local0 9 10) ; "Dominus Vobiscum."
			)
			(3 ; Do
				(Converse @local5 10) ; "Why, dear brother, I didn't know the flesh enticed you so. Meet me in my cell after midnight and we shall...uh...pray together."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Converse @local13 10) ; "Bless you, Brother."
						(gEgo put: 0) ; bucks
					)
					(11 ; cask
						(if ((Inv at: 11) value:) ; cask
							(Converse @local17 10) ; "It's empty, Brother. Fill it and then seek me out."
						else
							(Converse @local21 10) ; "Best take that to the Abbot at once, Brother. He's never so angry as when he's thirsty."
						)
					)
					(12 ; puzzleBox
						(Converse @local25 10) ; "What are you doing with that?! Brothers! SOUND THE ALARM! I've caught a thief!"
					)
					(14 ; amethyst
						(Converse @local29 10) ; "By our Blessed Lady! Thank you most heartily for this gift, Brother."
						(gEgo put: 14) ; amethyst
					)
					(13 ; robes
						(switch (Random 1 4)
							(1
								(Converse @local37 9 10) ; "What are you doing with those robes and belts, Brother?"
							)
							(2
								(Converse @local43 9 10) ; "What are you doing with those robes and belts, Brother?"
							)
							(3
								(Converse @local49 9 10) ; "What are you doing with those robes and belts, Brother?"
							)
							(4
								(Converse @local55 9 10) ; "What are you doing with those robes and belts, Brother?"
							)
						)
					)
					(16 ; fulkScroll
						(Converse @local61 10) ; "What secular nonsense is this? Better not let the Abbot see it or he'll have you copying scripture 14 hours a day."
					)
					(18 ; waterRing
						(Converse @local65 10) ; "You'd give ME this ring? Why? What's wrong with it? Is it cursed?"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance regTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (== gCurRoomNum 470)
					(if (or (gCurRoom script:) (gGame script:))
						(= seconds 2)
						(-- state)
					else
						(gCurRoom setScript: register)
						(self dispose:)
					)
				else
					(= seconds 60)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance dangerBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 201)
					(+= state 2)
				)
				(SetFlag 201)
				(= seconds 3)
			)
			(1
				(Say 1452 10 self) ; "I'd best keep this hidden until I'm in a safer place."
			)
			(2
				(gGame setScript: 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				((ScriptID 853) dispose:) ; thePuzzleBox
				(if next
					(client script: next)
					(= client 0)
				else
					(self dispose:)
				)
			)
			(3
				(= seconds 9)
			)
			(4
				(HandsOff)
				(gGame setScript: 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				((ScriptID 853) dispose:) ; thePuzzleBox
				(HandsOff)
				(switch gCurRoomNum
					(455
						(gEgo posn: 162 122)
						(aMonk posn: 141 109)
					)
					(460
						(if (> (gEgo y:) 153)
							(aMonk posn: 289 109)
						else
							(aMonk posn: 176 185)
						)
					)
					(470
						(if (> (gEgo x:) 46)
							(aMonk posn: 16 184)
						else
							(aMonk posn: 72 183)
						)
					)
					(480
						(if (> (gEgo x:) 160)
							(aMonk posn: 105 188)
						else
							(aMonk posn: 205 188)
						)
					)
				)
				(aMonk init:)
				(Face aMonk gEgo)
				(= cycles 2)
			)
			(5
				(Converse @local25 10 0 self) ; "What are you doing with that?! Brothers! SOUND THE ALARM! I've caught a thief!"
			)
			(6
				(= gDeathNum 10)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)

	(method (doit)
		(if (and (IsFlag 127) (< state 4))
			(if next
				(client script: next)
				(= client 0)
			else
				(self dispose:)
			)
			(ClearFlag 127)
		else
			(super doit:)
		)
	)
)

(instance noBlow of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
				(Say 1005 3 1) ; "I dare not wind my horn here."
				1
			)
		)
	)
)

