;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 219)
(include sci.sh)
(use Main)
(use eureka)
(use Print)
(use System)

(public
	sCommandWD40 0
)

(instance sCommandWD40 of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 202 14) setScript: 0) ; monitor2
				((ScriptID 1887 24) disposeWhenDone: 0) ; tkrWD40
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				(= register
					(Print
						mode: 1
						window: (ScriptID 205 0) ; commandWindow
						width: 125
						addColorButton: 0 1 0 0 24 0 0 205 13 29 31 0 0 0 ; "Scan Planet"
						addColorButton: 1 1 0 0 25 0 10 205 13 29 31 0 0 0 ; "Scan for Ships"
						addColorButton: 2 1 0 0 26 0 20 205 13 29 31 0 0 0 ; "Status Report"
						addColorButton: 3 1 0 0 27 0 30 205 13 29 31 0 0 0 ; "Recommendation"
						addColorButton: 4 1 0 0 28 0 40 205 13 29 31 0 0 0 ; "That is all"
						init:
					)
				)
				(= cycles 1)
			)
			(2
				(switch register
					(0
						(self setScript: sScanPlanet self)
					)
					(1
						(self setScript: sScanShips self)
					)
					(2
						(self setScript: sStatusReport self)
					)
					(3
						(self setScript: sRecommendation self)
					)
					(4
						(self setScript: sBelayThatOrder self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (!= register 4)
					(gMessager say: 43 0 0 2 self) ; "Do you require anything further, Captain Wilco?"
					(= state 0)
				else
					(= cycles 1)
				)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				((ScriptID 1887 24) disposeWhenDone: 1) ; tkrWD40
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 219)
		(DisposeScript 205)
	)
)

(instance sScanPlanet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gEurekaLocation
					(1 ; garbage1
						(gMessager say: 33 0 48 1 self) ; "This planet has a planetary shield which prevents scanning, Captain."
					)
					(2 ; garbage2
						(gMessager say: 33 0 48 1 self) ; "This planet has a planetary shield which prevents scanning, Captain."
					)
					(5 ; clorox2
						(if (IsFlag 30)
							(gMessager say: 33 0 27 1 self) ; "Atmosphere: Nitrogen, oxygen, carbon dioxide.  Gravity: .097 normal.  Average temperature: 27 degrees Celsius.  Life Forms: Indeterminate readings.  The planet can support oxygen breathing life-forms, sir."
						else
							(gMessager say: 33 0 27 2 self) ; "The colony shield is up sir. No scan is possible at this time."
						)
					)
					(3 ; ku
						(gMessager say: 33 0 56 1 self) ; "Kiz Urazgubi is a class M planet capable of sustaining humanoid life forms."
					)
					(6 ; thrakus
						(gMessager say: 33 0 30 1 self) ; "The atmosphere of this planet is highly toxic to humanoid life forms, Captain."
					)
					(7 ; genetix Space Lab
						(gMessager say: 33 0 28 1 self) ; "The station is shielded, Captain. Scans negative."
					)
					(8 ; genetix environdome
						(gMessager say: 33 0 28 2 self) ; "I am detecting power fluctuations inside the envirodome, sir. Sensors register debris in the area as well."
					)
					(9 ; generic planet 1
						(gMessager say: 33 0 31 1 self) ; "This planet cannot sustain humanoid life, Captain."
					)
					(10 ; genceric planet 2
						(gMessager say: 33 0 31 2 self) ; "Humans cannot survive on this planet without a complete vac suit, Captain."
					)
					(11 ; generic planet 3
						(gMessager say: 33 0 31 3 self) ; "The surface temperature of this planet is minus 200 degrees."
					)
					(12 ; generic planet 4
						(gMessager say: 33 0 31 4 self) ; "This planet is geologically active and highly unstable."
					)
					(13 ; generic planet 5
						(gMessager say: 33 0 31 5 self) ; "Surface winds on this planet exceed 500 kilometers per hour."
					)
					(14 ; goliath
						(gMessager say: 33 0 5 2 self) ; "We aren't close enough to a planet, sir."
					)
					(else
						(gMessager say: 33 0 5 (Random 1 3) self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sScanShips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gEurekaLocation
					(6 ; thrakus
						(if (IsFlag 42)
							(if (eureka damaged:)
								(gMessager say: 34 0 20 1 self) ; "The Goliath is coming around for another pass, Captain. Her weapons are fully charged."
							else
								(gMessager say: 34 0 22 1 self) ; "The Goliath is closing rapidly. Her weapons systems are fully armed."
							)
						else
							(gMessager say: 34 0 30 1 self) ; "Indeterminate readings, sir. If there are any ships within scanning range, they're jamming us."
						)
					)
					(14 ; goliath
						(if (IsFlag 39)
							(gMessager say: 34 0 49 4 self) ; "The Goliath has not scanned us, Captain. There is a good chance they are unaware of our presence."
						else
							(gMessager say: 34 0 49 3 self) ; "The Goliath has scanned us sir, her weapons are beginning to power up."
						)
					)
					(else
						(cond
							((IsFlag 37)
								(if (IsFlag 39)
									(gMessager say: 34 0 49 4 self) ; "The Goliath has not scanned us, Captain. There is a good chance they are unaware of our presence."
								else
									(gMessager say: 34 0 49 3 self) ; "The Goliath has scanned us sir, her weapons are beginning to power up."
								)
							)
							((IsFlag 75)
								(gMessager say: 34 0 49 1 self) ; "The Goliath is currently in the vicinity of Gingivitis, sir."
							)
							(else
								(gMessager say: 34 0 5 (Random 1 3) self)
							)
						)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sStatusReport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (eureka puke:) 4)
					(gMessager say: 41 0 16 1 self) ; "The superstructure of the ship is enduring stresses well beyond design specifications."
				else
					(gMessager say: 41 0 5 (Random 1 3) self)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sRecommendation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== gEurekaLocation 5) (IsFlag 30) (== gAct 0)) ; clorox2
						(gMessager say: 30 0 27 1 self) ; "I recommend we send down an away team to investigate the fate of the colonists, Captain."
					)
					((and (== gEurekaLocation 6) (IsFlag 94) (not (IsFlag 63))) ; thrakus
						(gMessager say: 30 0 30 0 self) ; "The most logical course of action is to beam down to investigate the source of the beacon, Captain."
					)
					((IsFlag 42)
						(if (eureka hits:)
							(switch (Random 1 2)
								(1
									(gMessager say: 30 0 11 1 self) ; "I recommend we retreat, sir. The Eureka cannot sustain much more damage and retain structural integrity."
								)
								(2
									(gMessager say: 30 0 20 1 self) ; "I recommend we leave the area as rapidly as possible, Captain Wilco."
								)
							)
						else
							(gMessager say: 30 0 49 1 self) ; "I recommend caution, sir. She outguns us a hundred to one."
						)
					)
					((and (== gEurekaLocation 15) (not (IsFlag 87))) ; empty space
						(gMessager say: 30 0 40 0 self) ; "It would be logical to utilize the Eureka's EVA pod to recover our chief engineer, Captain Wilco."
					)
					((and (== gEurekaLocation 8) (not (IsFlag 75))) ; genetix environdome
						(gMessager say: 30 0 28 0 self) ; "This facility is not listed in the StarCon registry or any of our other library databases, sir."
					)
					((eureka damaged:)
						(gMessager say: 30 0 11 1 self) ; "I recommend we retreat, sir. The Eureka cannot sustain much more damage and retain structural integrity."
					)
					((== gEurekaLocation 14) ; goliath
						(gMessager say: 30 0 50 0 self) ; "I recommend we attempt to capture the Goliath, Captain."
					)
					(else
						(gMessager say: 30 0 5 (Random 1 3) self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sBelayThatOrder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 0 5 (Random 1 3) self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

