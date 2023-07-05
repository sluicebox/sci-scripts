;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)

(public
	MineReg 0
)

(synonyms
	(dwarf fuck dwarf man person)
)

(instance MineReg of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(= keep 1)
		(super init:)
		(= global189 1)
		(dwarfMusic play:)
	)

	(method (dispose)
		(if (== keep 0)
			(= global189 0)
			(dwarfMusic keep: 0)
			(gSounds eachElementDo: #dispose)
		)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 28)
			(dwarfMusic keep: 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '/dwarf')
								(Print 600 0) ; "You see the Seven Dwarfs toiling away with their picks and shovels, extracting the plentiful diamonds from their underground mine."
							)
							((Said '/mine[<diamond]')
								(Print 600 1) ; "This underground diamond mine belongs to the Seven Dwarfs."
							)
							((Said '/boulder[<gray]')
								(Print 600 2) ; "Chunks of rock litter the floor of the diamond mine."
							)
							((Said '[<down]/dirt[<mine]')
								(Print 600 3) ; "Numerous rock and diamond chunks lie scattered on the mine floor."
							)
							((Said '/passageway[<mine]')
								(Print 600 4) ; "The passageway of the diamond mine is but a short distance underground."
							)
							((Said '/path')
								(Print 600 5) ; "Be careful on these narrow paths."
							)
							((Said '/wall')
								(Print 600 6) ; "Sparkling diamonds flash and gleam from the mine walls."
							)
							((Said '/bucket')
								(Print 600 7) ; "The bucket is brimming with sparkling diamonds."
							)
							((Said '/diamond')
								(Print 600 8) ; "Sparkling diamonds gleam from the walls and litter the mine floor."
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/boulder')
								(Print 600 9) ; "You are not interested in the rocks."
							)
							((Said '/diamond')
								(Print 600 10) ; "These diamonds do not belong to you."
							)
							((Said '/dwarf')
								(Print 600 11) ; "You couldn't get the Seven Dwarfs."
							)
						)
					)
					((Said 'rob/diamond')
						(Print 600 12) ; "You were raised better than that!"
					)
					((Said 'climb/boulder')
						(Print 600 13) ; "There are no rocks to climb here."
					)
					((or (Said 'talk/dwarf') (Said 'talk[/!*]'))
						(Print 600 14) ; "You endeavor to engage in conversation with the small men, but they are too busy to reply."
					)
					((Said 'kill/dwarf')
						(Print 600 15) ; "You are NOT a murderous girl, Rosella!"
					)
					((or (Said 'kiss/dwarf') (Said 'kiss[/!*]'))
						(Print 600 16) ; "They are working awfully hard. That might distract them."
					)
					((Said 'hit/dwarf')
						(Print 600 17) ; "You don't want to do that!"
					)
					((Said 'help/dwarf')
						(Print 600 18) ; "They don't need help."
					)
					((and (Said 'give,return>') (= temp0 (gInventory saidMe:)))
						(if (gEgo has: (gInventory indexOf: temp0))
							(Print 600 19) ; "The dwarfs have everything they need."
						else
							(DontHave) ; "You don't have it."
						)
					)
				)
			)
		)
	)
)

(instance dwarfMusic of Sound
	(properties
		number 30
		loop -1
		keep 1
	)
)

