;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Inventory)

(public
	cemReg 0
)

(synonyms
	(fence wall)
)

(instance cemReg of Rgn
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/flora')
							(Print 510 0) ; "Mostly, you see pine trees."
						)
						((Said '/boulder')
							(Print 510 1) ; "The only rocks of importance are gravestones."
						)
						((Said '/dirt,down')
							(Print 510 2) ; "You see numerous graves on the ground."
						)
						((Said '/grass')
							(Print 510 3) ; "Overgrown grass and weeds blanket this cemetery."
						)
						((Said '/bush')
							(Print 510 4) ; "The bushes are small and scrubby."
						)
						((Said '/blossom')
							(Print 510 5) ; "There are few flowers here."
						)
						((Said '/fence')
							(Print 510 6) ; "An old, crumbling stone wall surrounds the neglected cemetery."
						)
						((Said '/forest')
							(Print 510 7) ; "A pine forest surrounds the decrepit cemetery."
						)
						((Said '/cemetery,cemetery')
							(Print 510 8) ; "This old cemetery has fallen into a bad state of disrepair."
						)
						((Said '/grave,crypt')
							(Print 510 9) ; "Many graves with crumbling tombstones litter the old cemetery."
						)
						((Said '/gravestone')
							(Print 510 10) ; "Each tombstone has an epitaph written on it."
						)
						((Said '/monument')
							(Print 510 11) ; "Large stone monuments cover some graves."
						)
						((Said '/ghoul')
							(if (and gNight global186)
								(Print 510 12) ; "Watch out! Frightful zombies are everywhere!"
							else
								(Print 510 13) ; "You don't see one now."
							)
						)
					)
				)
				((Said 'get/blossom')
					(Print 510 14) ; "It would waste your time to stop and pick flowers."
				)
				((Said 'dig[/grave,hole]')
					(if (not ((Inv at: 15) owner: gEgo)) ; Shovel
						(Print 510 15) ; "You have nothing to dig with."
					)
					(if (== 5 gShovelCount)
						(Print 510 16) ; "There is no more reason to dig."
					)
				)
				((Said 'hide<behind/grave,gravestone')
					(Print 510 17) ; "Go ahead, try it."
				)
				((Said 'get/gravestone')
					(Print 510 18) ; "The tombstones are much too heavy for you to carry around."
				)
				((Said 'pull/gravestone')
					(Print 510 19) ; "The tombstones are firmly planted in the ground."
				)
				((Said 'talk[/ghoul]')
					(if (and gNight global186)
						(Print 510 20) ; "Trying to reason with a zombie is NOT a good idea!"
					else
						(Print 510 21) ; "To whom?"
					)
				)
				((Said 'kill[/ghoul]')
					(if (and gNight global186)
						(Print 510 22) ; "How could you possibly kill something that is ALREADY DEAD!!"
					else
						(Print 510 13) ; "You don't see one now."
					)
				)
				((Said 'climb/boulder')
					(Print 510 23) ; "There are no rocks suitable for climbing here."
				)
				((Said 'get,capture/ghoul')
					(if (and gNight global186)
						(Print 510 24) ; "Come now. Would you really want a zombie?"
					else
						(Print 510 13) ; "You don't see one now."
					)
				)
				((Said 'kiss[/ghoul]')
					(if (and gNight global186)
						(Print 510 25) ; "PLEASE!! Wise up, will you?!!"
					else
						(event claimed: 0)
					)
				)
				((and (Said 'give>') (= temp0 (gInventory saidMe:)))
					(if (gEgo has: (gInventory indexOf: temp0))
						(if (== global186 0)
							(Print 510 21) ; "To whom?"
						else
							(Print 510 26) ; "You don't want to give anything to a zombie!"
						)
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

