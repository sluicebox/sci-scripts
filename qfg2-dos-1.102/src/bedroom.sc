;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	bedroom 0
)

(local
	sleepTime
)

(instance sleeper of PicView
	(properties
		x 85
		y 113
		view 101
		priority 7
	)
)

(instance bedroom of Rm
	(properties
		picture 101
		style 8
	)

	(method (init)
		(super init:)
		(sleeper init:)
		(gAddToPics doit:)
		(self setScript: bedSleep)
	)
)

(instance bedSleep of Script
	(properties)

	(method (changeState newState &tmp wakenTime sleepDial [str 50])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(FindTime @str)
				(StrCat @str {__How long do you wish to sleep? })
				(sleepText text: @str)
				(gCustomWindow color: 14 back: 5)
				(HandsOn)
				((= sleepDial (Dialog new:))
					window: gCustomWindow
					text: {Asleep at the Katta's Tail Inn}
					add: sleepText dawnButton eveButton napButton cancelButton
					eachElementDo: #setSize
					setSize:
					moveTo: 104 14
					open: 4 15
				)
				(if (= sleepTime (sleepDial doit: cancelButton))
					(= sleepTime (sleepTime value:))
				else
					(= sleepTime 3)
				)
				(HandsOff)
				(sleepDial dispose:)
				(switch sleepTime
					(3)
					(0
						(EgoRests 0)
					)
					(else
						(ClearFlag 4) ; fHungry
						(ClearFlag 5) ; fStarving
						(= wakenTime (if (== sleepTime 1) 20 else 5))
						(EgoSleeps wakenTime 0)
					)
				)
				(= seconds 2)
			)
			(2
				(if (and (!= sleepTime 3) (!= gDay 17))
					(HighPrint 101 0) ; "You awaken much refreshed."
				)
				(HandsOn)
				(if (== gDay 17)
					(ClearFlag 3) ; fThirsty
					(ClearFlag 137) ; fDyingOfThirst
					(ClearFlag 4) ; fHungry
					(ClearFlag 5) ; fStarving
					(gEgo get: 49 get: 3 12) ; SpareClothes, Food
					(if (not (gEgo has: 37)) ; Waterskin
						(gEgo get: 37) ; Waterskin
					)
					(++ gFreeMeals)
					(= gDrinksLeft (* [gInvNum 37] 10)) ; Waterskin
					(client newRoom: 860)
				else
					(client newRoom: 100)
				)
			)
		)
	)
)

(instance sleepText of DText
	(properties
		nsTop 10
		nsLeft 10
		font 300
		mode 1
	)
)

(instance dawnButton of DButton
	(properties
		nsTop 45
		nsLeft 10
		value 2
		text {Until Dawn}
		font 300
	)
)

(instance eveButton of DButton
	(properties
		nsTop 45
		nsLeft 110
		value 1
		text {Until Evening}
		font 300
	)
)

(instance napButton of DButton
	(properties
		nsTop 65
		nsLeft 18
		text {One Hour}
		font 300
	)
)

(instance cancelButton of DButton
	(properties
		nsTop 65
		nsLeft 118
		value 3
		text {Stay Awake}
		font 300
	)
)

